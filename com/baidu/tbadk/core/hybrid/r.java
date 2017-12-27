package com.baidu.tbadk.core.hybrid;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.BuildConfig;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r extends m implements j {
    private static final int[] aSa = {TbConfig.POST_IMAGE_SMALL, 2000, 3500, 4600, 6000, 8000};
    private static final int[] aSb = {HttpStatus.SC_CREATED, HttpStatus.SC_ACCEPTED, HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION};
    private static final int[] aSc = {HttpStatus.SC_NOT_IMPLEMENTED, HttpStatus.SC_BAD_GATEWAY, HttpStatus.SC_SERVICE_UNAVAILABLE};
    private final g aRV;
    private final com.baidu.tbadk.core.hybrid.c aRW;
    private final c aRX;
    private final HashMap<String, i> aRY;
    private int aRZ;
    private final HashMap<String, n> aRs;
    private String logId;
    private int status;

    private r(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private r(WebView webView, g gVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.aRZ = -1;
        this.aRV = gVar;
        this.aRW = cVar;
        this.aRW.a(this);
        this.aRV.a(this);
        this.aRX = new c(this);
        this.aRY = new HashMap<>(16);
        this.aRs = new HashMap<>(8);
        init();
    }

    public static m a(boolean z, WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        return z ? new r(webView, bVar) : new a(webView);
    }

    public static m a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        r rVar = new r(webView, bVar);
        rVar.aRV.a(webViewClient);
        rVar.aRW.a(webChromeClient);
        return rVar;
    }

    public static m a(boolean z, f fVar, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(fVar);
        }
        WebViewClient webViewClient = fVar.webViewClient;
        WebChromeClient webChromeClient = fVar.chromeClient;
        r rVar = new r(fVar, bVar);
        rVar.aRV.a(webViewClient);
        rVar.aRW.a(webChromeClient);
        return rVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.m
    public void a(String str, d dVar) {
        if (this.aRY.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.m
    public void a(n nVar) {
        a(nVar, nVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.j
    public void Bm() {
        this.aRZ++;
        final int i = this.aRZ;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put(ClientCookie.VERSION_ATTR, BuildConfig.VERSION_NAME);
        hashMap.put("logid", Br());
        a(n.a(hashMap, aSa[this.aRZ % aSa.length], new l() { // from class: com.baidu.tbadk.core.hybrid.r.1
            @Override // com.baidu.tbadk.core.hybrid.l
            public void a(n nVar, JSONObject jSONObject) {
                r.this.a(nVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.l
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < r.aSc.length) {
                        r.this.Bs();
                    }
                    if (i >= 0 && i < r.aSc.length) {
                        r.this.R(String.valueOf(r.aSc[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.m(r.this.Br(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        R("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < aSb.length) {
            R(String.valueOf(aSb[i]), String.valueOf(currentTimeMillis - nVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.j
    public void dd(String str) {
        if (TextUtils.isEmpty(str)) {
            e.dc("invalid callbackId.");
            return;
        }
        n remove = this.aRs.remove(str);
        if (remove != null) {
            e.dc("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dg(String str) {
        this.aRZ = -1;
        if (this.status != 2 && this.status != 1) {
            e.dc("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (q.de(str) && q.df(str)) {
            e.dc("current status " + this.status + ", constructing bridge for " + str);
            if (this.aRM != null) {
                this.aRM.Be();
            }
            b(this.aRL);
            if (this.aRM != null) {
                this.aRM.Bf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String O(String str, String str2) {
        e.dc("got js prompt in url:" + str + " with content:" + str2);
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
                e.m(Br(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.m(Br(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.aRL.getSettings().setJavaScriptEnabled(true);
        this.aRL.setWebViewClient(this.aRV);
        this.aRL.setWebChromeClient(this.aRW);
        this.aRL.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(n nVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.m(Br(), "101", "(" + nVar.cmd + ", " + nVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(nVar.cmd) || TextUtils.isEmpty(nVar.method)) {
                e.m(Br(), "102", "the alias class or method is empty");
                nVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(nVar.aRQ)) {
            if (nVar.type != 3) {
                this.aRs.put(nVar.aRQ, nVar);
                if (nVar.aRR > 0) {
                    this.aRX.sendMessageDelayed(Message.obtain(this.aRX, 2, nVar.aRQ), nVar.aRR);
                } else if (nVar.cmd != null || nVar.method != null) {
                    e.dc("ignore timeout check for method call (" + nVar.cmd + ", " + nVar.method + ").");
                }
            } else {
                e.dc("ignore timeout check for response method, callbackId " + nVar.aRQ);
            }
        }
        try {
            String Bo = nVar.Bo();
            if (Build.VERSION.SDK_INT >= 19) {
                this.aRL.evaluateJavascript(Bo, null);
            } else {
                this.aRL.loadUrl(Bo);
            }
            e.dc(Bo);
        } catch (NullPointerException e) {
            R("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                R("102", e2.getMessage());
            } else {
                e.dc(e2.getMessage());
            }
            nVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.m(Br(), "106", "bridge is not ready");
        }
        i iVar = this.aRY.get(str);
        if (iVar == null) {
            iVar = new b(this, str);
            e.m(Br(), "107", "cmd " + str + " not found");
        }
        iVar.a(str2, jSONObject, jSONObject2);
    }

    private void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.dc("invalid callbackId.");
            return;
        }
        this.aRX.removeMessages(2, str);
        n remove = this.aRs.remove(str);
        if (remove != null) {
            remove.f(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Br() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(String str, String str2) {
        e.l(Br(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder Bt = Bt();
            Bt.append(new String(bArr));
            webView.loadUrl("javascript:" + Bt.toString());
            this.aRX.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            R("102", th.getMessage());
            e.dc(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bs() {
        e.dc("reInject for pingIndex " + this.aRZ);
        b(this.aRL);
    }

    private StringBuilder Bt() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put(ClientCookie.VERSION_ATTR, BuildConfig.VERSION_NAME);
        jSONObject.put("logid", Br());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<j> aSf;

        public c(j jVar) {
            this.aSf = new WeakReference<>(jVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j jVar = this.aSf.get();
            if (jVar == null) {
                e.dc("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    jVar.Bm();
                    return;
                case 2:
                    jVar.dd((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements i {
        private final m aRr;
        private final String cmd;

        protected b(m mVar, String str) {
            this.aRr = mVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.i
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.dc("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.aRr.a(n.b(optString, hashMap));
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
