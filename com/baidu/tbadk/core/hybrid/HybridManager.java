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
    private static HybridManager acV;
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

    public static HybridManager tT() {
        if (acV == null) {
            synchronized (HybridManager.class) {
                if (acV == null) {
                    acV = new HybridManager();
                }
            }
        }
        return acV;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        InterceptType cT = cT(str);
        if (cT == null) {
            return null;
        }
        return a(webView, str, cT);
    }

    private WebResourceResponse a(WebView webView, String str, InterceptType interceptType) {
        if (interceptType == InterceptType.NORMAL) {
            if (j.cS(str) || j.cR(str)) {
                return h(str, false);
            }
            if (j.cQ(str)) {
                return h(str, true);
            }
            return null;
        }
        if (interceptType == InterceptType.IMAGE) {
        }
        return null;
    }

    private WebResourceResponse h(String str, boolean z) {
        String cV = s.cV(MimeTypeMap.getFileExtensionFromUrl(str));
        if (TextUtils.isEmpty(cV)) {
            cV = "text/html";
        }
        try {
            com.baidu.tbadk.core.hybrid.b.b bVar = new com.baidu.tbadk.core.hybrid.b.b();
            WebResourceResponse webResourceResponse = new WebResourceResponse(cV, "UTF-8", new com.baidu.tbadk.core.hybrid.b.a(bVar));
            new a(str, bVar, z, cV).execute(new Void[0]);
            return webResourceResponse;
        } catch (IOException e) {
            e.printStackTrace();
            h.cz(1);
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0053 -> B:24:0x0007). Please submit an issue!!! */
    private InterceptType cT(String str) {
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
        private com.baidu.tbadk.core.hybrid.b.b acY;
        private boolean acZ;
        private String ada;
        private String adb;
        private boolean adc;
        private String ade;
        private byte[] data;
        private String url;

        public a(String str, com.baidu.tbadk.core.hybrid.b.b bVar, boolean z, String str2) {
            this.url = str;
            this.acY = bVar;
            this.acZ = z;
            this.ade = str2;
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
                CacheEntry db = com.baidu.tbadk.core.hybrid.cache.b.um().db(this.url);
                if (db != null) {
                    byte[] c = o.c(db.getInputStream());
                    this.adb = db.geteTag();
                    if (db.isValidate(this.adb, c)) {
                        this.acY.write(c, 0, c.length);
                        this.acY.flush();
                        this.adc = true;
                        if (!this.acZ) {
                            return null;
                        }
                        o.d(this.acY);
                    }
                }
                vVar = new v();
                vVar.setUrl(this.url);
                vVar.addHeader("Cookie", j.tS());
                if (this.adc) {
                    vVar.addHeader("If-None-Match", this.adb);
                }
                this.data = vVar.uc();
                responseCode = vVar.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                o.d(this.acY);
            }
            if (304 == responseCode) {
                return null;
            }
            if (200 == responseCode) {
                if (!this.adc) {
                    this.acY.write(this.data, 0, this.data.length);
                    this.acY.flush();
                }
                Map<String, List<String>> ub = vVar.ub();
                if (ub != null) {
                    List<String> list = ub.get("Cache-Offline");
                    if (list != null && list.size() > 0 && list.get(0).equals("false")) {
                        return OperateCacheType.REMOVE;
                    }
                    List<String> list2 = ub.get("ETag");
                    if (list2 != null && list2.size() > 0) {
                        this.ada = list2.get(0);
                        if (StringUtils.isNull(this.ada)) {
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
                new b(this.url, this.ada, this.data, operateCacheType).execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        private OperateCacheType adg;
        private byte[] data;
        private String eTag;
        private String url;

        public b(String str, String str2, byte[] bArr, OperateCacheType operateCacheType) {
            this.url = str;
            this.eTag = str2;
            this.data = bArr;
            this.adg = operateCacheType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            switch (this.adg) {
                case REMOVE:
                    com.baidu.tbadk.core.hybrid.cache.b.um().dc(this.url);
                    return null;
                case SAVE:
                    com.baidu.tbadk.core.hybrid.cache.b.um().saveCache(this.url, this.eTag, false, this.data);
                    return null;
                default:
                    return null;
            }
        }
    }
}
