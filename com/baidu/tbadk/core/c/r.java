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
    private static final int[] TW = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] TX = {201, 202, 203};
    private static final int[] TY = {501, 502, 503};
    private final f TQ;
    private final com.baidu.tbadk.core.c.b TR;
    private final c TS;
    private final HashMap<String, i> TT;
    private String TU;
    private int TV;
    private final HashMap<String, n> Tn;
    private int status;

    private r(WebView webView, com.baidu.tbadk.core.c.a aVar) {
        this(webView, new f(), new com.baidu.tbadk.core.c.b(), aVar);
    }

    private r(WebView webView, f fVar, com.baidu.tbadk.core.c.b bVar, com.baidu.tbadk.core.c.a aVar) {
        super(webView, aVar);
        this.TU = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.TV = -1;
        this.TQ = fVar;
        this.TR = bVar;
        this.TR.a(this);
        this.TQ.a(this);
        this.TS = new c(this);
        this.TT = new HashMap<>(16);
        this.Tn = new HashMap<>(8);
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
        rVar.TQ.a(webViewClient);
        rVar.TR.a(webChromeClient);
        return rVar;
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(String str, com.baidu.tbadk.core.c.c cVar) {
        if (this.TT.put(str, cVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.c.m
    public void a(n nVar) {
        a(nVar, nVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.c.j
    public void sz() {
        this.TV++;
        int i = this.TV;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", sF());
        a(n.a(hashMap, TW[this.TV % TW.length], new s(this, i)), true);
        T("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < TX.length) {
            T(String.valueOf(TX[i]), String.valueOf(currentTimeMillis - nVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.c.j
    public void cE(String str) {
        if (TextUtils.isEmpty(str)) {
            d.cD("invalid callbackId.");
            return;
        }
        n remove = this.Tn.remove(str);
        if (remove != null) {
            d.cD("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.a(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cH(String str) {
        this.TV = -1;
        if (this.status != 2 && this.status != 1) {
            d.cD("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (q.cF(str) && q.cG(str)) {
            d.cD("current status " + this.status + ", constructing bridge for " + str);
            if (this.TI != null) {
                this.TI.sr();
            }
            b(this.TH);
            if (this.TI != null) {
                this.TI.ss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String Q(String str, String str2) {
        d.cD("got js prompt in url:" + str + " with content:" + str2);
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
                d.n(sF(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            d.n(sF(), "109", e.getMessage());
            return null;
        }
    }

    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.TH.getSettings().setJavaScriptEnabled(true);
        this.TH.setWebViewClient(this.TQ);
        this.TH.setWebChromeClient(this.TR);
        this.status = 1;
    }

    private void a(n nVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                d.n(sF(), "101", "(" + nVar.cmd + ", " + nVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(nVar.cmd) || TextUtils.isEmpty(nVar.method)) {
                d.n(sF(), "102", "the alias class or method is empty");
                nVar.a(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(nVar.TM)) {
            if (nVar.type != 3) {
                this.Tn.put(nVar.TM, nVar);
                if (nVar.TO > 0) {
                    this.TS.sendMessageDelayed(Message.obtain(this.TS, 2, nVar.TM), nVar.TO);
                } else if (nVar.cmd != null || nVar.method != null) {
                    d.cD("ignore timeout check for method call (" + nVar.cmd + ", " + nVar.method + ").");
                }
            } else {
                d.cD("ignore timeout check for response method, callbackId " + nVar.TM);
            }
        }
        try {
            String sB = nVar.sB();
            this.TH.loadUrl(sB);
            d.cD(sB);
        } catch (JSONException e) {
            if (z) {
                T("102", e.getMessage());
            } else {
                d.cD(e.getMessage());
            }
            nVar.a(2, e);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            d.n(sF(), "106", "bridge is not ready");
        }
        i iVar = this.TT.get(str);
        if (iVar == null) {
            iVar = new b(this, str);
            d.n(sF(), "107", "cmd " + str + " not found");
        }
        iVar.a(str2, jSONObject, jSONObject2);
    }

    private void d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            d.cD("invalid callbackId.");
            return;
        }
        this.TS.removeMessages(2, str);
        n remove = this.Tn.remove(str);
        if (remove != null) {
            remove.i(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String sF() {
        return this.TU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(String str, String str2) {
        d.m(sF(), str, str2);
    }

    private void b(WebView webView) {
        this.TU = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder sH = sH();
            sH.append(new String(bArr));
            webView.loadUrl("javascript:" + sH.toString());
            this.TS.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            T("102", th.getMessage());
            d.cD(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG() {
        d.cD("reInject for pingIndex " + this.TV);
        b(this.TH);
    }

    private StringBuilder sH() {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", SocialConstants.ANDROID_CLIENT_TYPE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", sF());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<j> Ub;

        public c(j jVar) {
            this.Ub = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j jVar = this.Ub.get();
            if (jVar == null) {
                d.cD("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    jVar.sz();
                    return;
                case 2:
                    jVar.cE((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements i {
        private final m Tm;
        private final String cmd;

        protected b(m mVar, String str) {
            this.Tm = mVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.c.i
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                d.cD("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.Tm.a(n.b(optString, hashMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends m {
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
            nVar.a(4, (Throwable) null);
        }
    }
}
