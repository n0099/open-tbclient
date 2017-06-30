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
import com.baidu.tbadk.n.as;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class HybridManager {
    private static HybridManager abS;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    public enum InterceptType {
        NORMAL,
        IMAGE;

        /* JADX DEBUG: Replace access to removed values field (abX) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static InterceptType[] valuesCustom() {
            InterceptType[] valuesCustom = values();
            int length = valuesCustom.length;
            InterceptType[] interceptTypeArr = new InterceptType[length];
            System.arraycopy(valuesCustom, 0, interceptTypeArr, 0, length);
            return interceptTypeArr;
        }
    }

    /* loaded from: classes.dex */
    public enum OperateCacheType {
        SAVE,
        REMOVE;

        /* JADX DEBUG: Replace access to removed values field (acg) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static OperateCacheType[] valuesCustom() {
            OperateCacheType[] valuesCustom = values();
            int length = valuesCustom.length;
            OperateCacheType[] operateCacheTypeArr = new OperateCacheType[length];
            System.arraycopy(valuesCustom, 0, operateCacheTypeArr, 0, length);
            return operateCacheTypeArr;
        }
    }

    private HybridManager() {
    }

    public static HybridManager tF() {
        if (abS == null) {
            synchronized (HybridManager.class) {
                if (abS == null) {
                    abS = new HybridManager();
                }
            }
        }
        return abS;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        InterceptType cR;
        if (as.fU() && (cR = cR(str)) != null) {
            return a(webView, str, cR);
        }
        return null;
    }

    private WebResourceResponse a(WebView webView, String str, InterceptType interceptType) {
        if (interceptType == InterceptType.NORMAL) {
            if (k.cO(str) || k.cN(str)) {
                return h(str, false);
            }
            if (k.cM(str)) {
                return h(str, true);
            }
            return null;
        } else if (interceptType == InterceptType.IMAGE && k.cP(str)) {
            return cQ(str);
        } else {
            return null;
        }
    }

    private WebResourceResponse h(String str, boolean z) {
        String cT = v.cT(MimeTypeMap.getFileExtensionFromUrl(str));
        if (TextUtils.isEmpty(cT)) {
            cT = "text/html";
        }
        try {
            com.baidu.tbadk.core.hybrid.b.b bVar = new com.baidu.tbadk.core.hybrid.b.b();
            WebResourceResponse webResourceResponse = new WebResourceResponse(cT, "UTF-8", new com.baidu.tbadk.core.hybrid.b.a(bVar));
            new a(str, bVar, z, cT).execute(new Void[0]);
            return webResourceResponse;
        } catch (IOException e) {
            e.printStackTrace();
            h.cv(1);
            return null;
        }
    }

    private WebResourceResponse cQ(String str) {
        String cT = v.cT(MimeTypeMap.getFileExtensionFromUrl(str));
        try {
            com.baidu.tbadk.core.hybrid.b.b bVar = new com.baidu.tbadk.core.hybrid.b.b();
            WebResourceResponse webResourceResponse = new WebResourceResponse(cT, "UTF-8", new com.baidu.tbadk.core.hybrid.b.a(bVar));
            this.mHandler.post(new l(this, str, bVar));
            return webResourceResponse;
        } catch (IOException e) {
            e.printStackTrace();
            h.cv(1);
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x004f -> B:24:0x0007). Please submit an issue!!! */
    private InterceptType cR(String str) {
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
        private com.baidu.tbadk.core.hybrid.b.b abY;
        private boolean abZ;
        private String aca;
        private String acb;
        private boolean acc;
        private String acd;
        private byte[] data;
        private String url;

        public a(String str, com.baidu.tbadk.core.hybrid.b.b bVar, boolean z, String str2) {
            this.url = str;
            this.abY = bVar;
            this.abZ = z;
            this.acd = str2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [275=8] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public OperateCacheType doInBackground(Void... voidArr) {
            y yVar;
            int responseCode;
            try {
                CacheEntry cZ = com.baidu.tbadk.core.hybrid.cache.b.tZ().cZ(this.url);
                if (cZ != null) {
                    byte[] i = r.i(cZ.getInputStream());
                    this.acb = cZ.geteTag();
                    if (cZ.isValidate(this.acb, i)) {
                        this.abY.write(i, 0, i.length);
                        this.abY.flush();
                        this.acc = true;
                        if (!this.abZ) {
                            return null;
                        }
                        r.f(this.abY);
                    }
                }
                yVar = new y();
                yVar.setUrl(this.url);
                yVar.addHeader("Cookie", k.tE());
                if (this.acc) {
                    yVar.addHeader("If-None-Match", this.acb);
                }
                this.data = yVar.tP();
                responseCode = yVar.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                r.f(this.abY);
            }
            if (304 == responseCode) {
                return null;
            }
            if (200 == responseCode) {
                if (!this.acc) {
                    this.abY.write(this.data, 0, this.data.length);
                    this.abY.flush();
                }
                Map<String, List<String>> tO = yVar.tO();
                if (tO != null) {
                    List<String> list = tO.get("Cache-Offline");
                    if (list != null && list.size() > 0 && list.get(0).equals("false")) {
                        return OperateCacheType.REMOVE;
                    }
                    List<String> list2 = tO.get("ETag");
                    if (list2 != null && list2.size() > 0) {
                        this.aca = list2.get(0);
                        if (StringUtils.isNull(this.aca)) {
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
                new b(this.url, this.aca, this.data, operateCacheType).execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {
        private com.baidu.tbadk.core.hybrid.b.b abY;
        private com.baidu.adp.widget.a.a ach;

        public c(com.baidu.adp.widget.a.a aVar, com.baidu.tbadk.core.hybrid.b.b bVar) {
            this.ach = aVar;
            this.abY = bVar;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, IGET] complete} */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            byte[] kS;
            try {
                try {
                    if (this.ach != null && (kS = this.ach.kS()) != null && kS.length > 0) {
                        this.abY.write(kS, 0, kS.length);
                        this.abY.flush();
                    }
                    try {
                        if (this.abY != null) {
                            this.abY.close();
                            return null;
                        }
                        return null;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    try {
                        if (this.abY != null) {
                            this.abY.close();
                            return null;
                        }
                        return null;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                }
            } catch (Throwable th) {
                try {
                    if (this.abY != null) {
                        this.abY.close();
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        private static /* synthetic */ int[] acf;
        private OperateCacheType ace;
        private byte[] data;
        private String eTag;
        private String url;

        static /* synthetic */ int[] tG() {
            int[] iArr = acf;
            if (iArr == null) {
                iArr = new int[OperateCacheType.valuesCustom().length];
                try {
                    iArr[OperateCacheType.REMOVE.ordinal()] = 2;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[OperateCacheType.SAVE.ordinal()] = 1;
                } catch (NoSuchFieldError e2) {
                }
                acf = iArr;
            }
            return iArr;
        }

        public b(String str, String str2, byte[] bArr, OperateCacheType operateCacheType) {
            this.url = str;
            this.eTag = str2;
            this.data = bArr;
            this.ace = operateCacheType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            switch (tG()[this.ace.ordinal()]) {
                case 1:
                    com.baidu.tbadk.core.hybrid.cache.b.tZ().saveCache(this.url, this.eTag, false, this.data);
                    return null;
                case 2:
                    com.baidu.tbadk.core.hybrid.cache.b.tZ().da(this.url);
                    return null;
                default:
                    return null;
            }
        }
    }
}
