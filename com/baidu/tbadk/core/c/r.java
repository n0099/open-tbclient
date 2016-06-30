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
public class r extends m implements j {
    private static final int[] Un = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] Uo = {201, 202, 203};
    private static final int[] Up = {501, 502, 503};
    private final HashMap<String, n> TE;
    private final f Uh;
    private final com.baidu.tbadk.core.c.b Ui;
    private final c Uj;
    private final HashMap<String, i> Uk;
    private String Ul;
    private int Um;
    private int status;

    private r(WebView webView, com.baidu.tbadk.core.c.a aVar) {
        this(webView, new f(), new com.baidu.tbadk.core.c.b(), aVar);
    }

    private r(WebView webView, f fVar, com.baidu.tbadk.core.c.b bVar, com.baidu.tbadk.core.c.a aVar) {
        super(webView, aVar);
        this.Ul = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.Um = -1;
        this.Uh = fVar;
        this.Ui = bVar;
        this.Ui.a(this);
        this.Uh.a(this);
        this.Uj = new c(this);
        this.Uk = new HashMap<>(16);
        this.TE = new HashMap<>(8);
        init();
    }

    public static m a(boolean z, WebView webView, com.baidu.tbadk.core.c.a aVar) {
        return z ? new r(webView, aVar) : new a(webView, null);
    }

    public static m a(boolean z, e eVar, com.baidu.tbadk.core.c.a aVar) {
        if (!z) {
            return new a(eVar, null);
        }
        WebViewClient webViewClient = eVar.webViewClient;
        WebChromeClient webChromeClient = eVar.chromeClient;
        r rVar = new r(eVar, aVar);
        rVar.Uh.a(webViewClient);
        rVar.Ui.a(webChromeClient);
        return rVar;
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(String str, com.baidu.tbadk.core.c.c cVar) {
        if (this.Uk.put(str, cVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(n nVar) {
        a(nVar, nVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.c.j
    public void sy() {
        this.Um++;
        int i = this.Um;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", sD());
        a(n.a(hashMap, Un[this.Um % Un.length], new s(this, i)), true);
        S("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < Uo.length) {
            S(String.valueOf(Uo[i]), String.valueOf(currentTimeMillis - nVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.c.j
    public void cD(String str) {
        if (TextUtils.isEmpty(str)) {
            d.cC("invalid callbackId.");
            return;
        }
        n remove = this.TE.remove(str);
        if (remove != null) {
            d.cC("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.a(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cG(String str) {
        this.Um = -1;
        if (this.status != 2 && this.status != 1) {
            d.cC("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (q.cE(str) && q.cF(str)) {
            d.cC("current status " + this.status + ", constructing bridge for " + str);
            if (this.Ua != null) {
                this.Ua.sq();
            }
            b(this.TZ);
            if (this.Ua != null) {
                this.Ua.sr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String P(String str, String str2) {
        d.cC("got js prompt in url:" + str + " with content:" + str2);
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
                d.r(sD(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            d.r(sD(), "109", e.getMessage());
            return null;
        }
    }

    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.TZ.getSettings().setJavaScriptEnabled(true);
        this.TZ.setWebViewClient(this.Uh);
        this.TZ.setWebChromeClient(this.Ui);
        this.status = 1;
    }

    private void a(n nVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                d.r(sD(), "101", "(" + nVar.cmd + ", " + nVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(nVar.cmd) || TextUtils.isEmpty(nVar.method)) {
                d.r(sD(), "102", "the alias class or method is empty");
                nVar.a(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(nVar.Ue)) {
            if (nVar.type != 3) {
                this.TE.put(nVar.Ue, nVar);
                if (nVar.Uf > 0) {
                    this.Uj.sendMessageDelayed(Message.obtain(this.Uj, 2, nVar.Ue), nVar.Uf);
                } else if (nVar.cmd != null || nVar.method != null) {
                    d.cC("ignore timeout check for method call (" + nVar.cmd + ", " + nVar.method + ").");
                }
            } else {
                d.cC("ignore timeout check for response method, callbackId " + nVar.Ue);
            }
        }
        try {
            String sA = nVar.sA();
            this.TZ.loadUrl(sA);
            d.cC(sA);
        } catch (NullPointerException e) {
            S("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                S("102", e2.getMessage());
            } else {
                d.cC(e2.getMessage());
            }
            nVar.a(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            d.r(sD(), "106", "bridge is not ready");
        }
        i iVar = this.Uk.get(str);
        if (iVar == null) {
            iVar = new b(this, str);
            d.r(sD(), "107", "cmd " + str + " not found");
        }
        iVar.a(str2, jSONObject, jSONObject2);
    }

    private void d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            d.cC("invalid callbackId.");
            return;
        }
        this.Uj.removeMessages(2, str);
        n remove = this.TE.remove(str);
        if (remove != null) {
            remove.j(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String sD() {
        return this.Ul;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str, String str2) {
        d.q(sD(), str, str2);
    }

    private void b(WebView webView) {
        this.Ul = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder sF = sF();
            sF.append(new String(bArr));
            webView.loadUrl("javascript:" + sF.toString());
            this.Uj.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            S("102", th.getMessage());
            d.cC(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sE() {
        d.cC("reInject for pingIndex " + this.Um);
        b(this.TZ);
    }

    private StringBuilder sF() {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", sD());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<j> Us;

        public c(j jVar) {
            this.Us = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j jVar = this.Us.get();
            if (jVar == null) {
                d.cC("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    jVar.sy();
                    return;
                case 2:
                    jVar.cD((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements i {
        private final m TD;
        private final String cmd;

        protected b(m mVar, String str) {
            this.TD = mVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.c.i
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                d.cC("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.TD.a(n.b(optString, hashMap));
        }
    }

    /* loaded from: classes.dex */
    private static final class a extends m {
        /* synthetic */ a(WebView webView, a aVar) {
            this(webView);
        }

        private a(WebView webView) {
            super(webView, null);
        }

        @Override // com.baidu.tbadk.core.c.m
        public void a(String str, com.baidu.tbadk.core.c.c cVar) {
        }

        @Override // com.baidu.tbadk.core.c.m
        public void a(n nVar) {
            nVar.a(4, null);
        }
    }
}
