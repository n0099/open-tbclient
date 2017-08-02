package com.baidu.tbadk.core.hybrid;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.hybrid.cache.CacheEntry;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class HybridManager {
    private static HybridManager acq;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    public enum InterceptType {
        NORMAL,
        IMAGE
    }

    /* loaded from: classes.dex */
    public enum OperateCacheType {
        SAVE,
        REMOVE
    }

    private HybridManager() {
    }

    public static HybridManager tM() {
        if (acq == null) {
            synchronized (HybridManager.class) {
                if (acq == null) {
                    acq = new HybridManager();
                }
            }
        }
        return acq;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        InterceptType cU = cU(str);
        if (cU == null) {
            return null;
        }
        return a(webView, str, cU);
    }

    private WebResourceResponse a(WebView webView, String str, InterceptType interceptType) {
        if (interceptType == InterceptType.NORMAL) {
            if (j.cT(str) || j.cS(str)) {
                return h(str, false);
            }
            if (j.cR(str)) {
                return h(str, true);
            }
            return null;
        }
        if (interceptType == InterceptType.IMAGE) {
        }
        return null;
    }

    private WebResourceResponse h(String str, boolean z) {
        String cW = s.cW(MimeTypeMap.getFileExtensionFromUrl(str));
        if (TextUtils.isEmpty(cW)) {
            cW = "text/html";
        }
        try {
            com.baidu.tbadk.core.hybrid.b.b bVar = new com.baidu.tbadk.core.hybrid.b.b();
            WebResourceResponse webResourceResponse = new WebResourceResponse(cW, "UTF-8", new com.baidu.tbadk.core.hybrid.b.a(bVar));
            new a(str, bVar, z, cW).execute(new Void[0]);
            return webResourceResponse;
        } catch (IOException e) {
            e.printStackTrace();
            h.cx(1);
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0053 -> B:24:0x0007). Please submit an issue!!! */
    private InterceptType cU(String str) {
        InterceptType interceptType = null;
        if (!TextUtils.isEmpty(str) && (str.startsWith("http") || str.startsWith("https"))) {
            try {
                String host = Uri.parse(str).getHost();
                if (!TextUtils.isEmpty(host)) {
                    if (str.contains("tieba.baidu.com/n") || str.contains("tiebac.baidu.com/n")) {
                        interceptType = InterceptType.NORMAL;
                    } else if (host.contains("bdstatic") || host.contains("imgsrc")) {
                        interceptType = InterceptType.IMAGE;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return interceptType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Void, OperateCacheType> {
        private com.baidu.tbadk.core.hybrid.b.b act;
        private boolean acu;
        private String acv;
        private String acw;
        private boolean acx;
        private String acy;
        private byte[] data;
        private String url;

        public a(String str, com.baidu.tbadk.core.hybrid.b.b bVar, boolean z, String str2) {
            this.url = str;
            this.act = bVar;
            this.acu = z;
            this.acy = str2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [269=6] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public OperateCacheType doInBackground(Void... voidArr) {
            v vVar;
            int responseCode;
            try {
                CacheEntry dc = com.baidu.tbadk.core.hybrid.cache.b.uf().dc(this.url);
                if (dc != null) {
                    byte[] i = o.i(dc.getInputStream());
                    this.acw = dc.geteTag();
                    if (dc.isValidate(this.acw, i)) {
                        this.act.write(i, 0, i.length);
                        this.act.flush();
                        this.acx = true;
                        if (!this.acu) {
                            return null;
                        }
                        o.f(this.act);
                    }
                }
                vVar = new v();
                vVar.setUrl(this.url);
                vVar.addHeader("Cookie", j.tL());
                if (this.acx) {
                    vVar.addHeader("If-None-Match", this.acw);
                }
                this.data = vVar.tV();
                responseCode = vVar.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                o.f(this.act);
            }
            if (304 == responseCode) {
                return null;
            }
            if (200 == responseCode) {
                if (!this.acx) {
                    this.act.write(this.data, 0, this.data.length);
                    this.act.flush();
                }
                Map<String, List<String>> tU = vVar.tU();
                if (tU != null) {
                    List<String> list = tU.get("Cache-Offline");
                    if (list != null && list.size() > 0 && list.get(0).equals("false")) {
                        return OperateCacheType.REMOVE;
                    }
                    List<String> list2 = tU.get("ETag");
                    if (list2 != null && list2.size() > 0) {
                        this.acv = list2.get(0);
                        if (StringUtils.isNull(this.acv)) {
                            return null;
                        }
                    }
                }
                return OperateCacheType.SAVE;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(OperateCacheType operateCacheType) {
            super.onPostExecute(operateCacheType);
            if (operateCacheType != null) {
                new b(this.url, this.acv, this.data, operateCacheType).execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        private OperateCacheType acA;
        private byte[] data;
        private String eTag;
        private String url;

        public b(String str, String str2, byte[] bArr, OperateCacheType operateCacheType) {
            this.url = str;
            this.eTag = str2;
            this.data = bArr;
            this.acA = operateCacheType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            switch (this.acA) {
                case REMOVE:
                    com.baidu.tbadk.core.hybrid.cache.b.uf().dd(this.url);
                    return null;
                case SAVE:
                    com.baidu.tbadk.core.hybrid.cache.b.uf().saveCache(this.url, this.eTag, false, this.data);
                    return null;
                default:
                    return null;
            }
        }
    }
}
