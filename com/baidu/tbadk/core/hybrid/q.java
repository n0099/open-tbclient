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
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q extends l implements i {
    private static final int[] eQF = {1500, 2000, 3500, 4600, 6000, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static final int[] eQG = {201, 202, 203};
    private static final int[] eQH = {501, 502, 503};
    private final HashMap<String, m> ePY;
    private final f eQA;
    private final com.baidu.tbadk.core.hybrid.c eQB;
    private final c eQC;
    private final HashMap<String, h> eQD;
    private int eQE;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.eQE = -1;
        this.eQA = fVar;
        this.eQB = cVar;
        this.eQB.a(this);
        this.eQA.a(this);
        this.eQC = new c(this);
        this.eQD = new HashMap<>(16);
        this.ePY = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.eQA.a(webViewClient);
        qVar.eQB.a(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.eQA.a(webViewClient);
        qVar.eQB.a(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.eQD.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void bsv() {
        this.eQE++;
        final int i = this.eQE;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", "1.0");
        hashMap.put("logid", bsA());
        a(m.a(hashMap, eQF[this.eQE % eQF.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void onError(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.eQH.length) {
                        q.this.bsB();
                    }
                    if (i >= 0 && i < q.eQH.length) {
                        q.this.dS(String.valueOf(q.eQH[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.ak(q.this.bsA(), TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, "ping timeout for index " + i);
                }
            }
        }), true);
        dS("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < eQG.length) {
            dS(String.valueOf(eQG[i]), String.valueOf(currentTimeMillis - mVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void Bz(String str) {
        if (TextUtils.isEmpty(str)) {
            e.debug("invalid callbackId.");
            return;
        }
        m remove = this.ePY.remove(str);
        if (remove != null) {
            e.debug("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.onError(1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BC(String str) {
        this.eQE = -1;
        if (this.status != 2 && this.status != 1) {
            e.debug("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.BA(str) && p.BB(str)) {
            e.debug("current status " + this.status + ", constructing bridge for " + str);
            if (this.eQs != null) {
                this.eQs.bso();
            }
            b(this.eQr);
            if (this.eQs != null) {
                this.eQs.bsp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String dP(String str, String str2) {
        e.debug("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("messageType");
            if ("ping".equals(optString)) {
                o(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString("cmd"), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if (IIntercepter.TYPE_RESPONSE.equals(optString)) {
                o(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else {
                e.ak(bsA(), TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.ak(bsA(), TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.eQr.getSettings().setJavaScriptEnabled(true);
        this.eQr.setWebViewClient(this.eQA);
        this.eQr.setWebChromeClient(this.eQB);
        this.eQr.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.ak(bsA(), TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY, "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.ak(bsA(), TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, "the alias class or method is empty");
                mVar.onError(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.eQw)) {
            if (mVar.type != 3) {
                this.ePY.put(mVar.eQw, mVar);
                if (mVar.timeout > 0) {
                    this.eQC.sendMessageDelayed(Message.obtain(this.eQC, 2, mVar.eQw), mVar.timeout);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.debug("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.debug("ignore timeout check for response method, callbackId " + mVar.eQw);
            }
        }
        try {
            String bsx = mVar.bsx();
            if (Build.VERSION.SDK_INT >= 19) {
                this.eQr.evaluateJavascript(bsx, null);
            } else {
                this.eQr.loadUrl(bsx);
            }
            e.debug(bsx);
        } catch (NullPointerException e) {
            dS("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                dS(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, e2.getMessage());
            } else {
                e.debug(e2.getMessage());
            }
            mVar.onError(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.ak(bsA(), TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, "bridge is not ready");
        }
        h hVar = this.eQD.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.ak(bsA(), TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void o(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.debug("invalid callbackId.");
            return;
        }
        this.eQC.removeMessages(2, str);
        m remove = this.ePY.remove(str);
        if (remove != null) {
            remove.dk(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bsA() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dS(String str, String str2) {
        e.aj(bsA(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder bsC = bsC();
            bsC.append(new String(bArr));
            webView.loadUrl("javascript:" + bsC.toString());
            this.eQC.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            dS(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, th.getMessage());
            e.debug(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsB() {
        e.debug("reInject for pingIndex " + this.eQE);
        b(this.eQr);
    }

    private StringBuilder bsC() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", bsA());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> eQJ;

        public c(i iVar) {
            this.eQJ = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.eQJ.get();
            if (iVar == null) {
                e.debug("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.bsv();
                    return;
                case 2:
                    iVar.Bz((String) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException("Invalid message.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements h {
        private final String cmd;
        private final l ePX;

        protected b(l lVar, String str) {
            this.ePX = lVar;
            this.cmd = str;
        }

        @Override // com.baidu.tbadk.core.hybrid.h
        public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                e.debug("scope " + this.cmd + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP);
            hashMap.put("errMsg", "cmd " + this.cmd + " not found");
            this.ePX.a(m.l(optString, hashMap));
        }
    }

    /* loaded from: classes.dex */
    private static final class a extends l {
        private a(WebView webView) {
            super(webView, null);
        }

        @Override // com.baidu.tbadk.core.hybrid.l
        public void a(String str, d dVar) {
        }

        @Override // com.baidu.tbadk.core.hybrid.l
        public void a(m mVar) {
            mVar.onError(4, null);
        }
    }
}
