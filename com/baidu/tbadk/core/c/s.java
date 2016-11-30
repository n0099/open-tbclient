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
    private static final int[] Yv = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] Yw = {201, 202, 203};
    private static final int[] Yx = {501, 502, 503};
    private final HashMap<String, o> XN;
    private final g Yp;
    private final com.baidu.tbadk.core.c.c Yq;
    private final c Yr;
    private final HashMap<String, j> Ys;
    private String Yt;
    private int Yu;
    private int status;

    private s(WebView webView, com.baidu.tbadk.core.c.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.c.c(), bVar);
    }

    private s(WebView webView, g gVar, com.baidu.tbadk.core.c.c cVar, com.baidu.tbadk.core.c.b bVar) {
        super(webView, bVar);
        this.Yt = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.Yu = -1;
        this.Yp = gVar;
        this.Yq = cVar;
        this.Yq.a(this);
        this.Yp.a(this);
        this.Yr = new c(this);
        this.Ys = new HashMap<>(16);
        this.XN = new HashMap<>(8);
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
        sVar.Yp.a(webViewClient);
        sVar.Yq.a(webChromeClient);
        return sVar;
    }

    @Override // com.baidu.tbadk.core.c.n
    public void a(String str, d dVar) {
        if (this.Ys.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.c.n
    public void a(o oVar) {
        a(oVar, oVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.c.k
    public void tV() {
        this.Yu++;
        int i = this.Yu;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", ua());
        a(o.a(hashMap, Yv[this.Yu % Yv.length], new t(this, i)), true);
        S("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < Yw.length) {
            S(String.valueOf(Yw[i]), String.valueOf(currentTimeMillis - oVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.c.k
    public void cJ(String str) {
        if (TextUtils.isEmpty(str)) {
            e.cI("invalid callbackId.");
            return;
        }
        o remove = this.XN.remove(str);
        if (remove != null) {
            e.cI("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.a(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cM(String str) {
        this.Yu = -1;
        if (this.status != 2 && this.status != 1) {
            e.cI("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (r.cK(str) && r.cL(str)) {
            e.cI("current status " + this.status + ", constructing bridge for " + str);
            if (this.Yi != null) {
                this.Yi.tN();
            }
            d(this.Yh);
            if (this.Yi != null) {
                this.Yi.tO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String P(String str, String str2) {
        e.cI("got js prompt in url:" + str + " with content:" + str2);
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
                e.q(ua(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.q(ua(), "109", e.getMessage());
            return null;
        }
    }

    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.Yh.getSettings().setJavaScriptEnabled(true);
        this.Yh.setWebViewClient(this.Yp);
        this.Yh.setWebChromeClient(this.Yq);
        this.Yh.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(o oVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.q(ua(), "101", "(" + oVar.cmd + ", " + oVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(oVar.cmd) || TextUtils.isEmpty(oVar.method)) {
                e.q(ua(), "102", "the alias class or method is empty");
                oVar.a(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(oVar.Ym)) {
            if (oVar.type != 3) {
                this.XN.put(oVar.Ym, oVar);
                if (oVar.Yn > 0) {
                    this.Yr.sendMessageDelayed(Message.obtain(this.Yr, 2, oVar.Ym), oVar.Yn);
                } else if (oVar.cmd != null || oVar.method != null) {
                    e.cI("ignore timeout check for method call (" + oVar.cmd + ", " + oVar.method + ").");
                }
            } else {
                e.cI("ignore timeout check for response method, callbackId " + oVar.Ym);
            }
        }
        try {
            String tX = oVar.tX();
            this.Yh.loadUrl(tX);
            e.cI(tX);
        } catch (NullPointerException e) {
            S("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                S("102", e2.getMessage());
            } else {
                e.cI(e2.getMessage());
            }
            oVar.a(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.q(ua(), "106", "bridge is not ready");
        }
        j jVar = this.Ys.get(str);
        if (jVar == null) {
            jVar = new b(this, str);
            e.q(ua(), "107", "cmd " + str + " not found");
        }
        jVar.a(str2, jSONObject, jSONObject2);
    }

    private void d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.cI("invalid callbackId.");
            return;
        }
        this.Yr.removeMessages(2, str);
        o remove = this.XN.remove(str);
        if (remove != null) {
            remove.l(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ua() {
        return this.Yt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str, String str2) {
        e.p(ua(), str, str2);
    }

    private void d(WebView webView) {
        this.Yt = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder uc = uc();
            uc.append(new String(bArr));
            webView.loadUrl("javascript:" + uc.toString());
            this.Yr.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            S("102", th.getMessage());
            e.cI(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub() {
        e.cI("reInject for pingIndex " + this.Yu);
        d(this.Yh);
    }

    private StringBuilder uc() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", ua());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<k> YA;

        public c(k kVar) {
            this.YA = new WeakReference<>(kVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            k kVar = this.YA.get();
            if (kVar == null) {
                e.cI("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    kVar.tV();
                    return;
                case 2:
                    kVar.cJ((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements j {
        private final n XM;
        private final String cmd;

        protected b(n nVar, String str) {
            this.XM = nVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.c.j
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.cI("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.XM.a(o.c(optString, hashMap));
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
