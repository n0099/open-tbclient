package com.baidu.tbadk.core.d;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s extends n implements k {
    private static final int[] acr = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] acs = {201, 202, 203};
    private static final int[] act = {501, 502, 503};
    private final HashMap<String, o> abL;
    private final g acm;
    private final com.baidu.tbadk.core.d.c acn;
    private final c aco;
    private final HashMap<String, j> acp;
    private int acq;
    private String logId;
    private int status;

    private s(WebView webView, com.baidu.tbadk.core.d.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.d.c(), bVar);
    }

    private s(WebView webView, g gVar, com.baidu.tbadk.core.d.c cVar, com.baidu.tbadk.core.d.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.acq = -1;
        this.acm = gVar;
        this.acn = cVar;
        this.acn.a(this);
        this.acm.a(this);
        this.aco = new c(this);
        this.acp = new HashMap<>(16);
        this.abL = new HashMap<>(8);
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
        sVar.acm.a(webViewClient);
        sVar.acn.a(webChromeClient);
        return sVar;
    }

    public static n a(boolean z, f fVar, com.baidu.tbadk.core.d.b bVar) {
        if (!z) {
            return new a(fVar, null);
        }
        WebViewClient webViewClient = fVar.webViewClient;
        WebChromeClient webChromeClient = fVar.chromeClient;
        s sVar = new s(fVar, bVar);
        sVar.acm.a(webViewClient);
        sVar.acn.a(webChromeClient);
        return sVar;
    }

    @Override // com.baidu.tbadk.core.d.n
    public void a(String str, d dVar) {
        if (this.acp.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.d.n
    public void a(o oVar) {
        a(oVar, oVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.d.k
    public void tX() {
        this.acq++;
        int i = this.acq;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", uc());
        a(o.a(hashMap, acr[this.acq % acr.length], new t(this, i)), true);
        Q("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < acs.length) {
            Q(String.valueOf(acs[i]), String.valueOf(currentTimeMillis - oVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.d.k
    public void cB(String str) {
        if (TextUtils.isEmpty(str)) {
            e.cA("invalid callbackId.");
            return;
        }
        o remove = this.abL.remove(str);
        if (remove != null) {
            e.cA("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.a(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cE(String str) {
        this.acq = -1;
        if (this.status != 2 && this.status != 1) {
            e.cA("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (r.cC(str) && r.cD(str)) {
            e.cA("current status " + this.status + ", constructing bridge for " + str);
            if (this.acf != null) {
                this.acf.tP();
            }
            d(this.ace);
            if (this.acf != null) {
                this.acf.tQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String N(String str, String str2) {
        e.cA("got js prompt in url:" + str + " with content:" + str2);
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
                e.p(uc(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.p(uc(), "109", e.getMessage());
            return null;
        }
    }

    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.ace.getSettings().setJavaScriptEnabled(true);
        this.ace.setWebViewClient(this.acm);
        this.ace.setWebChromeClient(this.acn);
        this.ace.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(o oVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.p(uc(), "101", "(" + oVar.cmd + ", " + oVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(oVar.cmd) || TextUtils.isEmpty(oVar.method)) {
                e.p(uc(), "102", "the alias class or method is empty");
                oVar.a(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(oVar.acj)) {
            if (oVar.type != 3) {
                this.abL.put(oVar.acj, oVar);
                if (oVar.ack > 0) {
                    this.aco.sendMessageDelayed(Message.obtain(this.aco, 2, oVar.acj), oVar.ack);
                } else if (oVar.cmd != null || oVar.method != null) {
                    e.cA("ignore timeout check for method call (" + oVar.cmd + ", " + oVar.method + ").");
                }
            } else {
                e.cA("ignore timeout check for response method, callbackId " + oVar.acj);
            }
        }
        try {
            String tZ = oVar.tZ();
            this.ace.loadUrl(tZ);
            e.cA(tZ);
        } catch (NullPointerException e) {
            Q("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                Q("102", e2.getMessage());
            } else {
                e.cA(e2.getMessage());
            }
            oVar.a(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.p(uc(), "106", "bridge is not ready");
        }
        j jVar = this.acp.get(str);
        if (jVar == null) {
            jVar = new b(this, str);
            e.p(uc(), "107", "cmd " + str + " not found");
        }
        jVar.a(str2, jSONObject, jSONObject2);
    }

    private void d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.cA("invalid callbackId.");
            return;
        }
        this.aco.removeMessages(2, str);
        o remove = this.abL.remove(str);
        if (remove != null) {
            remove.j(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String uc() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(String str, String str2) {
        e.o(uc(), str, str2);
    }

    private void d(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder ue = ue();
            ue.append(new String(bArr));
            webView.loadUrl("javascript:" + ue.toString());
            this.aco.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            Q("102", th.getMessage());
            e.cA(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud() {
        e.cA("reInject for pingIndex " + this.acq);
        d(this.ace);
    }

    private StringBuilder ue() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", uc());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<k> acw;

        public c(k kVar) {
            this.acw = new WeakReference<>(kVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            k kVar = this.acw.get();
            if (kVar == null) {
                e.cA("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    kVar.tX();
                    return;
                case 2:
                    kVar.cB((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements j {
        private final n abK;
        private final String cmd;

        protected b(n nVar, String str) {
            this.abK = nVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.d.j
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.cA("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.abK.a(o.c(optString, hashMap));
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
            oVar.a(4, null);
        }
    }
}
