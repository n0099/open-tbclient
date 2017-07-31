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
    private static HybridManager adN;
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

    public static HybridManager tW() {
        if (adN == null) {
            synchronized (HybridManager.class) {
                if (adN == null) {
                    adN = new HybridManager();
                }
            }
        }
        return adN;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        InterceptType da = da(str);
        if (da == null) {
            return null;
        }
        return a(webView, str, da);
    }

    private WebResourceResponse a(WebView webView, String str, InterceptType interceptType) {
        if (interceptType == InterceptType.NORMAL) {
            if (j.cZ(str) || j.cY(str)) {
                return h(str, false);
            }
            if (j.cX(str)) {
                return h(str, true);
            }
            return null;
        }
        if (interceptType == InterceptType.IMAGE) {
        }
        return null;
    }

    private WebResourceResponse h(String str, boolean z) {
        String dc = s.dc(MimeTypeMap.getFileExtensionFromUrl(str));
        if (TextUtils.isEmpty(dc)) {
            dc = "text/html";
        }
        try {
            com.baidu.tbadk.core.hybrid.b.b bVar = new com.baidu.tbadk.core.hybrid.b.b();
            WebResourceResponse webResourceResponse = new WebResourceResponse(dc, "UTF-8", new com.baidu.tbadk.core.hybrid.b.a(bVar));
            new a(str, bVar, z, dc).execute(new Void[0]);
            return webResourceResponse;
        } catch (IOException e) {
            e.printStackTrace();
            h.cz(1);
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0053 -> B:24:0x0007). Please submit an issue!!! */
    private InterceptType da(String str) {
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
        private com.baidu.tbadk.core.hybrid.b.b adQ;
        private boolean adR;
        private String adS;
        private String adT;
        private boolean adU;
        private String adV;
        private byte[] data;
        private String url;

        public a(String str, com.baidu.tbadk.core.hybrid.b.b bVar, boolean z, String str2) {
            this.url = str;
            this.adQ = bVar;
            this.adR = z;
            this.adV = str2;
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
                CacheEntry di = com.baidu.tbadk.core.hybrid.cache.b.uq().di(this.url);
                if (di != null) {
                    byte[] o = o.o(di.getInputStream());
                    this.adT = di.geteTag();
                    if (di.isValidate(this.adT, o)) {
                        this.adQ.write(o, 0, o.length);
                        this.adQ.flush();
                        this.adU = true;
                        if (!this.adR) {
                            return null;
                        }
                        o.g(this.adQ);
                    }
                }
                vVar = new v();
                vVar.setUrl(this.url);
                vVar.addHeader("Cookie", j.tV());
                if (this.adU) {
                    vVar.addHeader("If-None-Match", this.adT);
                }
                this.data = vVar.uf();
                responseCode = vVar.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                o.g(this.adQ);
            }
            if (304 == responseCode) {
                return null;
            }
            if (200 == responseCode) {
                if (!this.adU) {
                    this.adQ.write(this.data, 0, this.data.length);
                    this.adQ.flush();
                }
                Map<String, List<String>> ue = vVar.ue();
                if (ue != null) {
                    List<String> list = ue.get("Cache-Offline");
                    if (list != null && list.size() > 0 && list.get(0).equals("false")) {
                        return OperateCacheType.REMOVE;
                    }
                    List<String> list2 = ue.get("ETag");
                    if (list2 != null && list2.size() > 0) {
                        this.adS = list2.get(0);
                        if (StringUtils.isNull(this.adS)) {
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
                new b(this.url, this.adS, this.data, operateCacheType).execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        private OperateCacheType adX;
        private byte[] data;
        private String eTag;
        private String url;

        public b(String str, String str2, byte[] bArr, OperateCacheType operateCacheType) {
            this.url = str;
            this.eTag = str2;
            this.data = bArr;
            this.adX = operateCacheType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            switch (this.adX) {
                case REMOVE:
                    com.baidu.tbadk.core.hybrid.cache.b.uq().dj(this.url);
                    return null;
                case SAVE:
                    com.baidu.tbadk.core.hybrid.cache.b.uq().saveCache(this.url, this.eTag, false, this.data);
                    return null;
                default:
                    return null;
            }
        }
    }
}
