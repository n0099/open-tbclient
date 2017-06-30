package com.baidu.tbadk.core.hybrid;

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
public class aa extends s implements o {
    private final HashMap<String, t> abx;
    private final g acu;
    private final com.baidu.tbadk.core.hybrid.c acv;
    private final c acw;
    private final HashMap<String, n> acx;
    private int acy;
    private String logId;
    private int status;
    private static final int[] acz = {1500, 2000, 3500, 4600, 6000, 8000};
    private static final int[] acA = {201, 202, 203};
    private static final int[] acB = {501, 502, 503};

    private aa(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new g(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private aa(WebView webView, g gVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.acy = -1;
        this.acu = gVar;
        this.acv = cVar;
        this.acv.a(this);
        this.acu.a(this);
        this.acw = new c(this);
        this.acx = new HashMap<>(16);
        this.abx = new HashMap<>(8);
        init();
    }

    public static s a(boolean z, WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        return z ? new aa(webView, bVar) : new a(webView, null);
    }

    public static s a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView, null);
        }
        aa aaVar = new aa(webView, bVar);
        aaVar.acu.a(webViewClient);
        aaVar.acv.a(webChromeClient);
        return aaVar;
    }

    public static s a(boolean z, f fVar, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(fVar, null);
        }
        WebViewClient webViewClient = fVar.webViewClient;
        WebChromeClient webChromeClient = fVar.chromeClient;
        aa aaVar = new aa(fVar, bVar);
        aaVar.acu.a(webViewClient);
        aaVar.acv.a(webChromeClient);
        return aaVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.s
    public void a(String str, d dVar) {
        if (this.acx.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.s
    public void a(t tVar) {
        a(tVar, tVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.o
    public void tH() {
        this.acy++;
        int i = this.acy;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", "1.0");
        hashMap.put("logid", tR());
        a(t.a(hashMap, acz[this.acy % acz.length], new ab(this, i)), true);
        R("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < acA.length) {
            R(String.valueOf(acA[i]), String.valueOf(currentTimeMillis - tVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.o
    public void cS(String str) {
        if (TextUtils.isEmpty(str)) {
            e.cL("invalid callbackId.");
            return;
        }
        t remove = this.abx.remove(str);
        if (remove != null) {
            e.cL("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cW(String str) {
        this.acy = -1;
        if (this.status != 2 && this.status != 1) {
            e.cL("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (z.cU(str) && z.cV(str)) {
            e.cL("current status " + this.status + ", constructing bridge for " + str);
            if (this.acj != null) {
                this.acj.tw();
            }
            d(this.aci);
            if (this.acj != null) {
                this.acj.tx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String O(String str, String str2) {
        e.cL("got js prompt in url:" + str + " with content:" + str2);
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
                e.k(tR(), "105", "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.k(tR(), "109", e.getMessage());
            return null;
        }
    }

    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.aci.getSettings().setJavaScriptEnabled(true);
        this.aci.setWebViewClient(this.acu);
        this.aci.setWebChromeClient(this.acv);
        this.aci.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(t tVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.k(tR(), "101", "(" + tVar.cmd + ", " + tVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(tVar.cmd) || TextUtils.isEmpty(tVar.method)) {
                e.k(tR(), "102", "the alias class or method is empty");
                tVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(tVar.acn)) {
            if (tVar.type != 3) {
                this.abx.put(tVar.acn, tVar);
                if (tVar.aco > 0) {
                    this.acw.sendMessageDelayed(Message.obtain(this.acw, 2, tVar.acn), tVar.aco);
                } else if (tVar.cmd != null || tVar.method != null) {
                    e.cL("ignore timeout check for method call (" + tVar.cmd + ", " + tVar.method + ").");
                }
            } else {
                e.cL("ignore timeout check for response method, callbackId " + tVar.acn);
            }
        }
        try {
            String tJ = tVar.tJ();
            this.aci.loadUrl(tJ);
            e.cL(tJ);
        } catch (NullPointerException e) {
            R("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                R("102", e2.getMessage());
            } else {
                e.cL(e2.getMessage());
            }
            tVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.k(tR(), "106", "bridge is not ready");
        }
        n nVar = this.acx.get(str);
        if (nVar == null) {
            nVar = new b(this, str);
            e.k(tR(), "107", "cmd " + str + " not found");
        }
        nVar.a(str2, jSONObject, jSONObject2);
    }

    private void d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.cL("invalid callbackId.");
            return;
        }
        this.acw.removeMessages(2, str);
        t remove = this.abx.remove(str);
        if (remove != null) {
            remove.j(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tR() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(String str, String str2) {
        e.j(tR(), str, str2);
    }

    private void d(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder tT = tT();
            tT.append(new String(bArr));
            webView.loadUrl("javascript:" + tT.toString());
            this.acw.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            R("102", th.getMessage());
            e.cL(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tS() {
        e.cL("reInject for pingIndex " + this.acy);
        d(this.aci);
    }

    private StringBuilder tT() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", tR());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<o> acE;

        public c(o oVar) {
            this.acE = new WeakReference<>(oVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            o oVar = this.acE.get();
            if (oVar == null) {
                e.cL("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    oVar.tH();
                    return;
                case 2:
                    oVar.cS((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements n {
        private final s abw;
        private final String cmd;

        protected b(s sVar, String str) {
            this.abw = sVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.n
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString("callbackId");
            if (TextUtils.isEmpty(optString)) {
                e.cL("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "107");
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.abw.a(t.c(optString, hashMap));
        }
    }

    /* loaded from: classes.dex */
    private static final class a extends s {
        /* synthetic */ a(WebView webView, a aVar) {
            this(webView);
        }

        private a(WebView webView) {
            super(webView, null);
        }

        @Override // com.baidu.tbadk.core.hybrid.s
        public void a(String str, d dVar) {
        }

        @Override // com.baidu.tbadk.core.hybrid.s
        public void a(t tVar) {
            tVar.b(4, null);
        }
    }
}
