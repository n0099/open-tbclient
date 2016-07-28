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
    private static final int[] UX = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] UY = {201, 202, 203};
    private static final int[] UZ = {501, 502, 503};
    private final g UR;
    private final com.baidu.tbadk.core.c.c US;
    private final c UT;
    private final HashMap<String, j> UU;
    private String UV;
    private int UW;
    private final HashMap<String, o> Un;
    private int status;

    private s(WebView webView, com.baidu.tbadk.core.c.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.c.c(), bVar);
    }

    private s(WebView webView, g gVar, com.baidu.tbadk.core.c.c cVar, com.baidu.tbadk.core.c.b bVar) {
        super(webView, bVar);
        this.UV = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.UW = -1;
        this.UR = gVar;
        this.US = cVar;
        this.US.a(this);
        this.UR.a(this);
        this.UT = new c(this);
        this.UU = new HashMap<>(16);
        this.Un = new HashMap<>(8);
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
        sVar.UR.a(webViewClient);
        sVar.US.a(webChromeClient);
        return sVar;
    }

    @Override // com.baidu.tbadk.core.c.n
    public void a(String str, d dVar) {
        if (this.UU.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.c.n
    public void a(o oVar) {
        a(oVar, oVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.c.k
    public void sx() {
        this.UW++;
        int i = this.UW;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", sC());
        a(o.a(hashMap, UX[this.UW % UX.length], new t(this, i)), true);
        S("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < UY.length) {
            S(String.valueOf(UY[i]), String.valueOf(currentTimeMillis - oVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.c.k
    public void cD(String str) {
        if (TextUtils.isEmpty(str)) {
            e.cC("invalid callbackId.");
            return;
        }
        o remove = this.Un.remove(str);
        if (remove != null) {
            e.cC("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.a(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cG(String str) {
        this.UW = -1;
        if (this.status != 2 && this.status != 1) {
            e.cC("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (r.cE(str) && r.cF(str)) {
            e.cC("current status " + this.status + ", constructing bridge for " + str);
            if (this.UJ != null) {
                this.UJ.sp();
            }
            d(this.UI);
            if (this.UJ != null) {
                this.UJ.sq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String P(String str, String str2) {
        e.cC("got js prompt in url:" + str + " with content:" + str2);
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
                e.r(sC(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.r(sC(), "109", e.getMessage());
            return null;
        }
    }

    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.UI.getSettings().setJavaScriptEnabled(true);
        this.UI.setWebViewClient(this.UR);
        this.UI.setWebChromeClient(this.US);
        this.status = 1;
    }

    private void a(o oVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.r(sC(), "101", "(" + oVar.cmd + ", " + oVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(oVar.cmd) || TextUtils.isEmpty(oVar.method)) {
                e.r(sC(), "102", "the alias class or method is empty");
                oVar.a(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(oVar.UN)) {
            if (oVar.type != 3) {
                this.Un.put(oVar.UN, oVar);
                if (oVar.UO > 0) {
                    this.UT.sendMessageDelayed(Message.obtain(this.UT, 2, oVar.UN), oVar.UO);
                } else if (oVar.cmd != null || oVar.method != null) {
                    e.cC("ignore timeout check for method call (" + oVar.cmd + ", " + oVar.method + ").");
                }
            } else {
                e.cC("ignore timeout check for response method, callbackId " + oVar.UN);
            }
        }
        try {
            String sz = oVar.sz();
            this.UI.loadUrl(sz);
            e.cC(sz);
        } catch (NullPointerException e) {
            S("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                S("102", e2.getMessage());
            } else {
                e.cC(e2.getMessage());
            }
            oVar.a(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.r(sC(), "106", "bridge is not ready");
        }
        j jVar = this.UU.get(str);
        if (jVar == null) {
            jVar = new b(this, str);
            e.r(sC(), "107", "cmd " + str + " not found");
        }
        jVar.a(str2, jSONObject, jSONObject2);
    }

    private void d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.cC("invalid callbackId.");
            return;
        }
        this.UT.removeMessages(2, str);
        o remove = this.Un.remove(str);
        if (remove != null) {
            remove.l(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String sC() {
        return this.UV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str, String str2) {
        e.q(sC(), str, str2);
    }

    private void d(WebView webView) {
        this.UV = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder sE = sE();
            sE.append(new String(bArr));
            webView.loadUrl("javascript:" + sE.toString());
            this.UT.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            S("102", th.getMessage());
            e.cC(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sD() {
        e.cC("reInject for pingIndex " + this.UW);
        d(this.UI);
    }

    private StringBuilder sE() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", sC());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<k> Vc;

        public c(k kVar) {
            this.Vc = new WeakReference<>(kVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            k kVar = this.Vc.get();
            if (kVar == null) {
                e.cC("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    kVar.sx();
                    return;
                case 2:
                    kVar.cD((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements j {
        private final n Um;
        private final String cmd;

        protected b(n nVar, String str) {
            this.Um = nVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.c.j
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.cC("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.Um.a(o.c(optString, hashMap));
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
