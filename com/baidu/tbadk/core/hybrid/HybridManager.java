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
    private static HybridManager adP;
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

    public static HybridManager tX() {
        if (adP == null) {
            synchronized (HybridManager.class) {
                if (adP == null) {
                    adP = new HybridManager();
                }
            }
        }
        return adP;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        InterceptType dd = dd(str);
        if (dd == null) {
            return null;
        }
        return a(webView, str, dd);
    }

    private WebResourceResponse a(WebView webView, String str, InterceptType interceptType) {
        if (interceptType == InterceptType.NORMAL) {
            if (j.dc(str) || j.db(str)) {
                return h(str, false);
            }
            if (j.da(str)) {
                return h(str, true);
            }
            return null;
        }
        if (interceptType == InterceptType.IMAGE) {
        }
        return null;
    }

    private WebResourceResponse h(String str, boolean z) {
        String df = s.df(MimeTypeMap.getFileExtensionFromUrl(str));
        if (TextUtils.isEmpty(df)) {
            df = "text/html";
        }
        try {
            com.baidu.tbadk.core.hybrid.b.b bVar = new com.baidu.tbadk.core.hybrid.b.b();
            WebResourceResponse webResourceResponse = new WebResourceResponse(df, "UTF-8", new com.baidu.tbadk.core.hybrid.b.a(bVar));
            new a(str, bVar, z, df).execute(new Void[0]);
            return webResourceResponse;
        } catch (IOException e) {
            e.printStackTrace();
            h.cz(1);
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0053 -> B:24:0x0007). Please submit an issue!!! */
    private InterceptType dd(String str) {
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
        private com.baidu.tbadk.core.hybrid.b.b adS;
        private boolean adT;
        private String adU;
        private String adV;
        private boolean adW;
        private String adX;
        private byte[] data;
        private String url;

        public a(String str, com.baidu.tbadk.core.hybrid.b.b bVar, boolean z, String str2) {
            this.url = str;
            this.adS = bVar;
            this.adT = z;
            this.adX = str2;
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
                CacheEntry dl = com.baidu.tbadk.core.hybrid.cache.b.ur().dl(this.url);
                if (dl != null) {
                    byte[] o = o.o(dl.getInputStream());
                    this.adV = dl.geteTag();
                    if (dl.isValidate(this.adV, o)) {
                        this.adS.write(o, 0, o.length);
                        this.adS.flush();
                        this.adW = true;
                        if (!this.adT) {
                            return null;
                        }
                        o.g(this.adS);
                    }
                }
                vVar = new v();
                vVar.setUrl(this.url);
                vVar.addHeader("Cookie", j.tW());
                if (this.adW) {
                    vVar.addHeader("If-None-Match", this.adV);
                }
                this.data = vVar.ug();
                responseCode = vVar.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                o.g(this.adS);
            }
            if (304 == responseCode) {
                return null;
            }
            if (200 == responseCode) {
                if (!this.adW) {
                    this.adS.write(this.data, 0, this.data.length);
                    this.adS.flush();
                }
                Map<String, List<String>> uf = vVar.uf();
                if (uf != null) {
                    List<String> list = uf.get("Cache-Offline");
                    if (list != null && list.size() > 0 && list.get(0).equals("false")) {
                        return OperateCacheType.REMOVE;
                    }
                    List<String> list2 = uf.get("ETag");
                    if (list2 != null && list2.size() > 0) {
                        this.adU = list2.get(0);
                        if (StringUtils.isNull(this.adU)) {
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
                new b(this.url, this.adU, this.data, operateCacheType).execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        private OperateCacheType adZ;
        private byte[] data;
        private String eTag;
        private String url;

        public b(String str, String str2, byte[] bArr, OperateCacheType operateCacheType) {
            this.url = str;
            this.eTag = str2;
            this.data = bArr;
            this.adZ = operateCacheType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            switch (this.adZ) {
                case REMOVE:
                    com.baidu.tbadk.core.hybrid.cache.b.ur().dm(this.url);
                    return null;
                case SAVE:
                    com.baidu.tbadk.core.hybrid.cache.b.ur().saveCache(this.url, this.eTag, false, this.data);
                    return null;
                default:
                    return null;
            }
        }
    }
}
