package com.baidu.tbadk.core.c;

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
    private static final int[] XX = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] XY = {201, 202, 203};
    private static final int[] XZ = {501, 502, 503};
    private final g XR;
    private final com.baidu.tbadk.core.c.c XS;
    private final c XT;
    private final HashMap<String, j> XU;
    private String XV;
    private int XW;
    private final HashMap<String, o> Xp;
    private int status;

    private s(WebView webView, com.baidu.tbadk.core.c.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.c.c(), bVar);
    }

    private s(WebView webView, g gVar, com.baidu.tbadk.core.c.c cVar, com.baidu.tbadk.core.c.b bVar) {
        super(webView, bVar);
        this.XV = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.XW = -1;
        this.XR = gVar;
        this.XS = cVar;
        this.XS.a(this);
        this.XR.a(this);
        this.XT = new c(this);
        this.XU = new HashMap<>(16);
        this.Xp = new HashMap<>(8);
        init();
    }

    public static n a(boolean z, WebView webView, com.baidu.tbadk.core.c.b bVar) {
        return z ? new s(webView, bVar) : new a(webView, null);
    }

    public static n a(boolean z, f fVar, com.baidu.tbadk.core.c.b bVar) {
        if (!z) {
            return new a(fVar, null);
        }
        WebViewClient webViewClient = fVar.webViewClient;
        WebChromeClient webChromeClient = fVar.chromeClient;
        s sVar = new s(fVar, bVar);
        sVar.XR.a(webViewClient);
        sVar.XS.a(webChromeClient);
        return sVar;
    }

    @Override // com.baidu.tbadk.core.c.n
    public void a(String str, d dVar) {
        if (this.XU.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.c.n
    public void a(o oVar) {
        a(oVar, oVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.c.k
    public void tR() {
        this.XW++;
        int i = this.XW;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", tW());
        a(o.a(hashMap, XX[this.XW % XX.length], new t(this, i)), true);
        S("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < XY.length) {
            S(String.valueOf(XY[i]), String.valueOf(currentTimeMillis - oVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.c.k
    public void cH(String str) {
        if (TextUtils.isEmpty(str)) {
            e.cG("invalid callbackId.");
            return;
        }
        o remove = this.Xp.remove(str);
        if (remove != null) {
            e.cG("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.a(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cK(String str) {
        this.XW = -1;
        if (this.status != 2 && this.status != 1) {
            e.cG("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (r.cI(str) && r.cJ(str)) {
            e.cG("current status " + this.status + ", constructing bridge for " + str);
            if (this.XK != null) {
                this.XK.tJ();
            }
            d(this.XJ);
            if (this.XK != null) {
                this.XK.tK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String P(String str, String str2) {
        e.cG("got js prompt in url:" + str + " with content:" + str2);
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
                e.q(tW(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.q(tW(), "109", e.getMessage());
            return null;
        }
    }

    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.XJ.getSettings().setJavaScriptEnabled(true);
        this.XJ.setWebViewClient(this.XR);
        this.XJ.setWebChromeClient(this.XS);
        this.status = 1;
    }

    private void a(o oVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.q(tW(), "101", "(" + oVar.cmd + ", " + oVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(oVar.cmd) || TextUtils.isEmpty(oVar.method)) {
                e.q(tW(), "102", "the alias class or method is empty");
                oVar.a(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(oVar.XO)) {
            if (oVar.type != 3) {
                this.Xp.put(oVar.XO, oVar);
                if (oVar.XP > 0) {
                    this.XT.sendMessageDelayed(Message.obtain(this.XT, 2, oVar.XO), oVar.XP);
                } else if (oVar.cmd != null || oVar.method != null) {
                    e.cG("ignore timeout check for method call (" + oVar.cmd + ", " + oVar.method + ").");
                }
            } else {
                e.cG("ignore timeout check for response method, callbackId " + oVar.XO);
            }
        }
        try {
            String tT = oVar.tT();
            this.XJ.loadUrl(tT);
            e.cG(tT);
        } catch (NullPointerException e) {
            S("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                S("102", e2.getMessage());
            } else {
                e.cG(e2.getMessage());
            }
            oVar.a(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.q(tW(), "106", "bridge is not ready");
        }
        j jVar = this.XU.get(str);
        if (jVar == null) {
            jVar = new b(this, str);
            e.q(tW(), "107", "cmd " + str + " not found");
        }
        jVar.a(str2, jSONObject, jSONObject2);
    }

    private void d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.cG("invalid callbackId.");
            return;
        }
        this.XT.removeMessages(2, str);
        o remove = this.Xp.remove(str);
        if (remove != null) {
            remove.l(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tW() {
        return this.XV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str, String str2) {
        e.p(tW(), str, str2);
    }

    private void d(WebView webView) {
        this.XV = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder tY = tY();
            tY.append(new String(bArr));
            webView.loadUrl("javascript:" + tY.toString());
            this.XT.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            S("102", th.getMessage());
            e.cG(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tX() {
        e.cG("reInject for pingIndex " + this.XW);
        d(this.XJ);
    }

    private StringBuilder tY() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", tW());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<k> Yc;

        public c(k kVar) {
            this.Yc = new WeakReference<>(kVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            k kVar = this.Yc.get();
            if (kVar == null) {
                e.cG("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    kVar.tR();
                    return;
                case 2:
                    kVar.cH((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements j {
        private final n Xo;
        private final String cmd;

        protected b(n nVar, String str) {
            this.Xo = nVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.c.j
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.cG("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.Xo.a(o.c(optString, hashMap));
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

        @Override // com.baidu.tbadk.core.c.n
        public void a(String str, d dVar) {
        }

        @Override // com.baidu.tbadk.core.c.n
        public void a(o oVar) {
            oVar.a(4, null);
        }
    }
}
