package com.baidu.tbadk.core.d;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s extends n implements k {
    private static final int[] acG = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] acH = {201, 202, 203};
    private static final int[] acI = {501, 502, 503};
    private final g acB;
    private final com.baidu.tbadk.core.d.c acC;
    private final c acD;
    private final HashMap<String, j> acE;
    private int acF;
    private final HashMap<String, o> aca;
    private String logId;
    private int status;

    private s(WebView webView, com.baidu.tbadk.core.d.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.d.c(), bVar);
    }

    private s(WebView webView, g gVar, com.baidu.tbadk.core.d.c cVar, com.baidu.tbadk.core.d.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.acF = -1;
        this.acB = gVar;
        this.acC = cVar;
        this.acC.a(this);
        this.acB.a(this);
        this.acD = new c(this);
        this.acE = new HashMap<>(16);
        this.aca = new HashMap<>(8);
        init();
    }

    public static n a(boolean z, WebView webView, com.baidu.tbadk.core.d.b bVar) {
        return z ? new s(webView, bVar) : new a(webView, null);
    }

    public static n a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.d.b bVar) {
        if (!z) {
            return new a(webView, null);
        }
        s sVar = new s(webView, bVar);
        sVar.acB.a(webViewClient);
        sVar.acC.a(webChromeClient);
        return sVar;
    }

    public static n a(boolean z, f fVar, com.baidu.tbadk.core.d.b bVar) {
        if (!z) {
            return new a(fVar, null);
        }
        WebViewClient webViewClient = fVar.webViewClient;
        WebChromeClient webChromeClient = fVar.chromeClient;
        s sVar = new s(fVar, bVar);
        sVar.acB.a(webViewClient);
        sVar.acC.a(webChromeClient);
        return sVar;
    }

    @Override // com.baidu.tbadk.core.d.n
    public void a(String str, d dVar) {
        if (this.acE.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.d.n
    public void a(o oVar) {
        a(oVar, oVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.d.k
    public void uv() {
        this.acF++;
        int i = this.acF;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", "1.0");
        hashMap.put("logid", uA());
        a(o.a(hashMap, acG[this.acF % acG.length], new t(this, i)), true);
        R("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < acH.length) {
            R(String.valueOf(acH[i]), String.valueOf(currentTimeMillis - oVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.d.k
    public void cI(String str) {
        if (TextUtils.isEmpty(str)) {
            e.cH("invalid callbackId.");
            return;
        }
        o remove = this.aca.remove(str);
        if (remove != null) {
            e.cH("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.a(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cL(String str) {
        this.acF = -1;
        if (this.status != 2 && this.status != 1) {
            e.cH("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (r.cJ(str) && r.cK(str)) {
            e.cH("current status " + this.status + ", constructing bridge for " + str);
            if (this.acu != null) {
                this.acu.un();
            }
            d(this.act);
            if (this.acu != null) {
                this.acu.uo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String O(String str, String str2) {
        e.cH("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("messageType");
            if ("ping".equals(optString)) {
                d(jSONObject.optString("callbackId"), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString(IntentConfig.CMD), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if ("response".equals(optString)) {
                d(jSONObject.optString("callbackId"), jSONObject.optJSONObject("outputData"));
            } else {
                e.k(uA(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.k(uA(), "109", e.getMessage());
            return null;
        }
    }

    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.act.getSettings().setJavaScriptEnabled(true);
        this.act.setWebViewClient(this.acB);
        this.act.setWebChromeClient(this.acC);
        this.act.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(o oVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.k(uA(), "101", "(" + oVar.cmd + ", " + oVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(oVar.cmd) || TextUtils.isEmpty(oVar.method)) {
                e.k(uA(), "102", "the alias class or method is empty");
                oVar.a(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(oVar.acy)) {
            if (oVar.type != 3) {
                this.aca.put(oVar.acy, oVar);
                if (oVar.acz > 0) {
                    this.acD.sendMessageDelayed(Message.obtain(this.acD, 2, oVar.acy), oVar.acz);
                } else if (oVar.cmd != null || oVar.method != null) {
                    e.cH("ignore timeout check for method call (" + oVar.cmd + ", " + oVar.method + ").");
                }
            } else {
                e.cH("ignore timeout check for response method, callbackId " + oVar.acy);
            }
        }
        try {
            String ux = oVar.ux();
            this.act.loadUrl(ux);
            e.cH(ux);
        } catch (NullPointerException e) {
            R("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                R("102", e2.getMessage());
            } else {
                e.cH(e2.getMessage());
            }
            oVar.a(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.k(uA(), "106", "bridge is not ready");
        }
        j jVar = this.acE.get(str);
        if (jVar == null) {
            jVar = new b(this, str);
            e.k(uA(), "107", "cmd " + str + " not found");
        }
        jVar.a(str2, jSONObject, jSONObject2);
    }

    private void d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.cH("invalid callbackId.");
            return;
        }
        this.acD.removeMessages(2, str);
        o remove = this.aca.remove(str);
        if (remove != null) {
            remove.j(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String uA() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(String str, String str2) {
        e.j(uA(), str, str2);
    }

    private void d(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder uC = uC();
            uC.append(new String(bArr));
            webView.loadUrl("javascript:" + uC.toString());
            this.acD.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            R("102", th.getMessage());
            e.cH(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uB() {
        e.cH("reInject for pingIndex " + this.acF);
        d(this.act);
    }

    private StringBuilder uC() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", uA());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<k> acL;

        public c(k kVar) {
            this.acL = new WeakReference<>(kVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            k kVar = this.acL.get();
            if (kVar == null) {
                e.cH("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    kVar.uv();
                    return;
                case 2:
                    kVar.cI((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements j {
        private final n abZ;
        private final String cmd;

        protected b(n nVar, String str) {
            this.abZ = nVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.d.j
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.cH("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.abZ.a(o.c(optString, hashMap));
        }
    }

    /* loaded from: classes.dex */
    private static final class a extends n {
        /* synthetic */ a(WebView webView, a aVar) {
            this(webView);
        }

        private a(WebView webView) {
            super(webView, null);
        }

        @Override // com.baidu.tbadk.core.d.n
        public void a(String str, d dVar) {
        }

        @Override // com.baidu.tbadk.core.d.n
        public void a(o oVar) {
            oVar.a(4, (Throwable) null);
        }
    }
}
