package com.baidu.tbadk.core.hybrid;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.BuildConfig;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x extends p implements l {
    private static final int[] acV = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] acW = {201, 202, 203};
    private static final int[] acX = {501, 502, 503};
    private final HashMap<String, q> abV;
    private final g acQ;
    private final com.baidu.tbadk.core.hybrid.c acR;
    private final c acS;
    private final HashMap<String, k> acT;
    private int acU;
    private String logId;
    private int status;

    private x(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private x(WebView webView, g gVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.acU = -1;
        this.acQ = gVar;
        this.acR = cVar;
        this.acR.a(this);
        this.acQ.a(this);
        this.acS = new c(this);
        this.acT = new HashMap<>(16);
        this.abV = new HashMap<>(8);
        init();
    }

    public static p a(boolean z, WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        return z ? new x(webView, bVar) : new a(webView);
    }

    public static p a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        x xVar = new x(webView, bVar);
        xVar.acQ.a(webViewClient);
        xVar.acR.a(webChromeClient);
        return xVar;
    }

    public static p a(boolean z, f fVar, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(fVar);
        }
        WebViewClient webViewClient = fVar.webViewClient;
        WebChromeClient webChromeClient = fVar.chromeClient;
        x xVar = new x(fVar, bVar);
        xVar.acQ.a(webViewClient);
        xVar.acR.a(webChromeClient);
        return xVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.p
    public void a(String str, d dVar) {
        if (this.acT.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.p
    public void a(q qVar) {
        a(qVar, qVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void tN() {
        this.acU++;
        final int i = this.acU;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", BuildConfig.VERSION_NAME);
        hashMap.put("logid", tX());
        a(q.a(hashMap, acV[this.acU % acV.length], new n() { // from class: com.baidu.tbadk.core.hybrid.x.1
            @Override // com.baidu.tbadk.core.hybrid.n
            public void a(q qVar, JSONObject jSONObject) {
                x.this.a(qVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.n
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < x.acX.length) {
                        x.this.tY();
                    }
                    if (i >= 0 && i < x.acX.length) {
                        x.this.R(String.valueOf(x.acX[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.k(x.this.tX(), "103", "ping timeout for index " + i);
                }
            }
        }), true);
        R("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < acW.length) {
            R(String.valueOf(acW[i]), String.valueOf(currentTimeMillis - qVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void cV(String str) {
        if (TextUtils.isEmpty(str)) {
            e.cQ("invalid callbackId.");
            return;
        }
        q remove = this.abV.remove(str);
        if (remove != null) {
            e.cQ("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cZ(String str) {
        this.acU = -1;
        if (this.status != 2 && this.status != 1) {
            e.cQ("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (w.cX(str) && w.cY(str)) {
            e.cQ("current status " + this.status + ", constructing bridge for " + str);
            if (this.acD != null) {
                this.acD.tD();
            }
            d(this.acC);
            if (this.acD != null) {
                this.acD.tE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String O(String str, String str2) {
        e.cQ("got js prompt in url:" + str + " with content:" + str2);
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
                e.k(tX(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.k(tX(), "109", e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.acC.getSettings().setJavaScriptEnabled(true);
        this.acC.setWebViewClient(this.acQ);
        this.acC.setWebChromeClient(this.acR);
        this.acC.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(q qVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.k(tX(), "101", "(" + qVar.cmd + ", " + qVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(qVar.cmd) || TextUtils.isEmpty(qVar.method)) {
                e.k(tX(), "102", "the alias class or method is empty");
                qVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(qVar.acH)) {
            if (qVar.type != 3) {
                this.abV.put(qVar.acH, qVar);
                if (qVar.acI > 0) {
                    this.acS.sendMessageDelayed(Message.obtain(this.acS, 2, qVar.acH), qVar.acI);
                } else if (qVar.cmd != null || qVar.method != null) {
                    e.cQ("ignore timeout check for method call (" + qVar.cmd + ", " + qVar.method + ").");
                }
            } else {
                e.cQ("ignore timeout check for response method, callbackId " + qVar.acH);
            }
        }
        try {
            String tP = qVar.tP();
            this.acC.loadUrl(tP);
            e.cQ(tP);
        } catch (NullPointerException e) {
            R("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                R("102", e2.getMessage());
            } else {
                e.cQ(e2.getMessage());
            }
            qVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.k(tX(), "106", "bridge is not ready");
        }
        k kVar = this.acT.get(str);
        if (kVar == null) {
            kVar = new b(this, str);
            e.k(tX(), "107", "cmd " + str + " not found");
        }
        kVar.a(str2, jSONObject, jSONObject2);
    }

    private void d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.cQ("invalid callbackId.");
            return;
        }
        this.acS.removeMessages(2, str);
        q remove = this.abV.remove(str);
        if (remove != null) {
            remove.j(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tX() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(String str, String str2) {
        e.j(tX(), str, str2);
    }

    private void d(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder tZ = tZ();
            tZ.append(new String(bArr));
            webView.loadUrl("javascript:" + tZ.toString());
            this.acS.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            R("102", th.getMessage());
            e.cQ(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tY() {
        e.cQ("reInject for pingIndex " + this.acU);
        d(this.acC);
    }

    private StringBuilder tZ() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", BuildConfig.VERSION_NAME);
        jSONObject.put("logid", tX());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<l> ada;

        public c(l lVar) {
            this.ada = new WeakReference<>(lVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            l lVar = this.ada.get();
            if (lVar == null) {
                e.cQ("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    lVar.tN();
                    return;
                case 2:
                    lVar.cV((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements k {
        private final p abU;
        private final String cmd;

        protected b(p pVar, String str) {
            this.abU = pVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.k
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.cQ("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.abU.a(q.c(optString, hashMap));
        }
    }

    /* loaded from: classes.dex */
    private static final class a extends p {
        private a(WebView webView) {
            super(webView, null);
        }

        @Override // com.baidu.tbadk.core.hybrid.p
        public void a(String str, d dVar) {
        }

        @Override // com.baidu.tbadk.core.hybrid.p
        public void a(q qVar) {
            qVar.b(4, null);
        }
    }
}
