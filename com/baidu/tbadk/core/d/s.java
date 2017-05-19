package com.baidu.tbadk.core.d;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s extends n implements k {
    private static final int[] acd = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] ace = {201, 202, 203};
    private static final int[] acf = {501, 502, 503};
    private final g abY;
    private final com.baidu.tbadk.core.d.c abZ;
    private final HashMap<String, o> abx;
    private final c aca;
    private final HashMap<String, j> acb;
    private int acc;
    private String logId;
    private int status;

    private s(WebView webView, com.baidu.tbadk.core.d.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.d.c(), bVar);
    }

    private s(WebView webView, g gVar, com.baidu.tbadk.core.d.c cVar, com.baidu.tbadk.core.d.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.acc = -1;
        this.abY = gVar;
        this.abZ = cVar;
        this.abZ.a(this);
        this.abY.a(this);
        this.aca = new c(this);
        this.acb = new HashMap<>(16);
        this.abx = new HashMap<>(8);
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
        sVar.abY.a(webViewClient);
        sVar.abZ.a(webChromeClient);
        return sVar;
    }

    public static n a(boolean z, f fVar, com.baidu.tbadk.core.d.b bVar) {
        if (!z) {
            return new a(fVar, null);
        }
        WebViewClient webViewClient = fVar.webViewClient;
        WebChromeClient webChromeClient = fVar.chromeClient;
        s sVar = new s(fVar, bVar);
        sVar.abY.a(webViewClient);
        sVar.abZ.a(webChromeClient);
        return sVar;
    }

    @Override // com.baidu.tbadk.core.d.n
    public void a(String str, d dVar) {
        if (this.acb.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.d.n
    public void a(o oVar) {
        a(oVar, oVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.d.k
    public void tH() {
        this.acc++;
        int i = this.acc;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", "1.0");
        hashMap.put("logid", tM());
        a(o.a(hashMap, acd[this.acc % acd.length], new t(this, i)), true);
        R("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < ace.length) {
            R(String.valueOf(ace[i]), String.valueOf(currentTimeMillis - oVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.d.k
    public void cG(String str) {
        if (TextUtils.isEmpty(str)) {
            e.cF("invalid callbackId.");
            return;
        }
        o remove = this.abx.remove(str);
        if (remove != null) {
            e.cF("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.a(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cJ(String str) {
        this.acc = -1;
        if (this.status != 2 && this.status != 1) {
            e.cF("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (r.cH(str) && r.cI(str)) {
            e.cF("current status " + this.status + ", constructing bridge for " + str);
            if (this.abR != null) {
                this.abR.tz();
            }
            d(this.abQ);
            if (this.abR != null) {
                this.abR.tA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String O(String str, String str2) {
        e.cF("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("messageType");
            if ("ping".equals(optString)) {
                d(jSONObject.optString("callbackId"), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString(IntentConfig.CMD), jSONObject.optString(PushConstants.EXTRA_METHOD), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if ("response".equals(optString)) {
                d(jSONObject.optString("callbackId"), jSONObject.optJSONObject("outputData"));
            } else {
                e.k(tM(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.k(tM(), "109", e.getMessage());
            return null;
        }
    }

    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.abQ.getSettings().setJavaScriptEnabled(true);
        this.abQ.setWebViewClient(this.abY);
        this.abQ.setWebChromeClient(this.abZ);
        this.abQ.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(o oVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.k(tM(), "101", "(" + oVar.cmd + ", " + oVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(oVar.cmd) || TextUtils.isEmpty(oVar.method)) {
                e.k(tM(), "102", "the alias class or method is empty");
                oVar.a(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(oVar.abV)) {
            if (oVar.type != 3) {
                this.abx.put(oVar.abV, oVar);
                if (oVar.abW > 0) {
                    this.aca.sendMessageDelayed(Message.obtain(this.aca, 2, oVar.abV), oVar.abW);
                } else if (oVar.cmd != null || oVar.method != null) {
                    e.cF("ignore timeout check for method call (" + oVar.cmd + ", " + oVar.method + ").");
                }
            } else {
                e.cF("ignore timeout check for response method, callbackId " + oVar.abV);
            }
        }
        try {
            String tJ = oVar.tJ();
            this.abQ.loadUrl(tJ);
            e.cF(tJ);
        } catch (NullPointerException e) {
            R("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                R("102", e2.getMessage());
            } else {
                e.cF(e2.getMessage());
            }
            oVar.a(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.k(tM(), "106", "bridge is not ready");
        }
        j jVar = this.acb.get(str);
        if (jVar == null) {
            jVar = new b(this, str);
            e.k(tM(), "107", "cmd " + str + " not found");
        }
        jVar.a(str2, jSONObject, jSONObject2);
    }

    private void d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.cF("invalid callbackId.");
            return;
        }
        this.aca.removeMessages(2, str);
        o remove = this.abx.remove(str);
        if (remove != null) {
            remove.j(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tM() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(String str, String str2) {
        e.j(tM(), str, str2);
    }

    private void d(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder tO = tO();
            tO.append(new String(bArr));
            webView.loadUrl("javascript:" + tO.toString());
            this.aca.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            R("102", th.getMessage());
            e.cF(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tN() {
        e.cF("reInject for pingIndex " + this.acc);
        d(this.abQ);
    }

    private StringBuilder tO() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", tM());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<k> aci;

        public c(k kVar) {
            this.aci = new WeakReference<>(kVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            k kVar = this.aci.get();
            if (kVar == null) {
                e.cF("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    kVar.tH();
                    return;
                case 2:
                    kVar.cG((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements j {
        private final n abw;
        private final String cmd;

        protected b(n nVar, String str) {
            this.abw = nVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.d.j
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.cF("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.abw.a(o.c(optString, hashMap));
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
