package com.baidu.tbadk.core.hybrid;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r extends m implements j {
    private final HashMap<String, n> aSQ;
    private final g aTt;
    private final com.baidu.tbadk.core.hybrid.c aTu;
    private final c aTv;
    private final HashMap<String, i> aTw;
    private int aTx;
    private String logId;
    private int status;
    private static final int[] aTy = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] aTz = {201, 202, HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION};
    private static final int[] aTA = {HttpStatus.SC_NOT_IMPLEMENTED, HttpStatus.SC_BAD_GATEWAY, HttpStatus.SC_SERVICE_UNAVAILABLE};

    private r(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private r(WebView webView, g gVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.aTx = -1;
        this.aTt = gVar;
        this.aTu = cVar;
        this.aTu.a(this);
        this.aTt.a(this);
        this.aTv = new c(this);
        this.aTw = new HashMap<>(16);
        this.aSQ = new HashMap<>(8);
        init();
    }

    public static m a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        r rVar = new r(webView, bVar);
        rVar.aTt.a(webViewClient);
        rVar.aTu.a(webChromeClient);
        return rVar;
    }

    public static m a(boolean z, f fVar, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(fVar);
        }
        WebViewClient webViewClient = fVar.webViewClient;
        WebChromeClient webChromeClient = fVar.chromeClient;
        r rVar = new r(fVar, bVar);
        rVar.aTt.a(webViewClient);
        rVar.aTu.a(webChromeClient);
        return rVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.m
    public void a(String str, d dVar) {
        if (this.aTw.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.m
    public void a(n nVar) {
        a(nVar, nVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.j
    public void Bz() {
        this.aTx++;
        final int i = this.aTx;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", Constants.OS_TYPE_VALUE);
        hashMap.put("version", "1.0");
        hashMap.put("logid", BE());
        a(n.a(hashMap, aTy[this.aTx % aTy.length], new l() { // from class: com.baidu.tbadk.core.hybrid.r.1
            @Override // com.baidu.tbadk.core.hybrid.l
            public void a(n nVar, JSONObject jSONObject) {
                r.this.a(nVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.l
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < r.aTA.length) {
                        r.this.BF();
                    }
                    if (i >= 0 && i < r.aTA.length) {
                        r.this.S(String.valueOf(r.aTA[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.l(r.this.BE(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        S("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < aTz.length) {
            S(String.valueOf(aTz[i]), String.valueOf(currentTimeMillis - nVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.j
    /* renamed from: do */
    public void mo12do(String str) {
        if (TextUtils.isEmpty(str)) {
            e.dn("invalid callbackId.");
            return;
        }
        n remove = this.aSQ.remove(str);
        if (remove != null) {
            e.dn("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dr(String str) {
        this.aTx = -1;
        if (this.status != 2 && this.status != 1) {
            e.dn("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (q.dp(str) && q.dq(str)) {
            e.dn("current status " + this.status + ", constructing bridge for " + str);
            if (this.aTk != null) {
                this.aTk.Br();
            }
            b(this.aTj);
            if (this.aTk != null) {
                this.aTk.Bs();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String P(String str, String str2) {
        e.dn("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("messageType");
            if ("ping".equals(optString)) {
                c(jSONObject.optString("callbackId"), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString(IntentConfig.CMD), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if ("response".equals(optString)) {
                c(jSONObject.optString("callbackId"), jSONObject.optJSONObject("outputData"));
            } else {
                e.l(BE(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.l(BE(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.aTj.getSettings().setJavaScriptEnabled(true);
        this.aTj.setWebViewClient(this.aTt);
        this.aTj.setWebChromeClient(this.aTu);
        this.aTj.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(n nVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.l(BE(), "101", "(" + nVar.cmd + ", " + nVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(nVar.cmd) || TextUtils.isEmpty(nVar.method)) {
                e.l(BE(), "102", "the alias class or method is empty");
                nVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(nVar.aTo)) {
            if (nVar.type != 3) {
                this.aSQ.put(nVar.aTo, nVar);
                if (nVar.aTp > 0) {
                    this.aTv.sendMessageDelayed(Message.obtain(this.aTv, 2, nVar.aTo), nVar.aTp);
                } else if (nVar.cmd != null || nVar.method != null) {
                    e.dn("ignore timeout check for method call (" + nVar.cmd + ", " + nVar.method + ").");
                }
            } else {
                e.dn("ignore timeout check for response method, callbackId " + nVar.aTo);
            }
        }
        try {
            String BB = nVar.BB();
            if (Build.VERSION.SDK_INT >= 19) {
                this.aTj.evaluateJavascript(BB, null);
            } else {
                this.aTj.loadUrl(BB);
            }
            e.dn(BB);
        } catch (NullPointerException e) {
            S("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                S("102", e2.getMessage());
            } else {
                e.dn(e2.getMessage());
            }
            nVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.l(BE(), "106", "bridge is not ready");
        }
        i iVar = this.aTw.get(str);
        if (iVar == null) {
            iVar = new b(this, str);
            e.l(BE(), "107", "cmd " + str + " not found");
        }
        iVar.a(str2, jSONObject, jSONObject2);
    }

    private void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.dn("invalid callbackId.");
            return;
        }
        this.aTv.removeMessages(2, str);
        n remove = this.aSQ.remove(str);
        if (remove != null) {
            remove.j(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String BE() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str, String str2) {
        e.k(BE(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder BG = BG();
            BG.append(new String(bArr));
            webView.loadUrl("javascript:" + BG.toString());
            this.aTv.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            S("102", th.getMessage());
            e.dn(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BF() {
        e.dn("reInject for pingIndex " + this.aTx);
        b(this.aTj);
    }

    private StringBuilder BG() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", Constants.OS_TYPE_VALUE);
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", BE());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<j> aTD;

        public c(j jVar) {
            this.aTD = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j jVar = this.aTD.get();
            if (jVar == null) {
                e.dn("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    jVar.Bz();
                    return;
                case 2:
                    jVar.mo12do((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements i {
        private final m aSP;
        private final String cmd;

        protected b(m mVar, String str) {
            this.aSP = mVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.i
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.dn("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.aSP.a(n.c(optString, hashMap));
        }
    }

    /* loaded from: classes.dex */
    private static final class a extends m {
        private a(WebView webView) {
            super(webView, null);
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        public void a(String str, d dVar) {
        }

        @Override // com.baidu.tbadk.core.hybrid.m
        public void a(n nVar) {
            nVar.b(4, (Throwable) null);
        }
    }
}
