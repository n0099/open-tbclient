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
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
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
    private static final int[] dKS = {1500, 2000, 3500, 4600, SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME, CoolPraiseGuideLottieView.ANIM_DURATION};
    private static final int[] dKT = {201, 202, 203};
    private static final int[] dKU = {501, 502, 503};
    private final f dKN;
    private final com.baidu.tbadk.core.hybrid.c dKO;
    private final c dKP;
    private final HashMap<String, h> dKQ;
    private int dKR;
    private final HashMap<String, m> dKl;
    private String logId;
    private int status;

    private q(WebView webView, com.baidu.tbadk.core.hybrid.b bVar) {
        this(webView, new f(), new com.baidu.tbadk.core.hybrid.c(), bVar);
    }

    private q(WebView webView, f fVar, com.baidu.tbadk.core.hybrid.c cVar, com.baidu.tbadk.core.hybrid.b bVar) {
        super(webView, bVar);
        this.logId = String.valueOf(System.currentTimeMillis());
        this.status = -1;
        this.dKR = -1;
        this.dKN = fVar;
        this.dKO = cVar;
        this.dKO.a(this);
        this.dKN.a(this);
        this.dKP = new c(this);
        this.dKQ = new HashMap<>(16);
        this.dKl = new HashMap<>(8);
        init();
    }

    public static l a(boolean z, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(webView);
        }
        q qVar = new q(webView, bVar);
        qVar.dKN.a(webViewClient);
        qVar.dKO.a(webChromeClient);
        return qVar;
    }

    public static l a(boolean z, BridgeWebView bridgeWebView, com.baidu.tbadk.core.hybrid.b bVar) {
        if (!z) {
            return new a(bridgeWebView);
        }
        WebViewClient webViewClient = bridgeWebView.webViewClient;
        WebChromeClient webChromeClient = bridgeWebView.chromeClient;
        q qVar = new q(bridgeWebView, bVar);
        qVar.dKN.a(webViewClient);
        qVar.dKO.a(webChromeClient);
        return qVar;
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(String str, d dVar) {
        if (this.dKQ.put(str, dVar) != null) {
            throw new IllegalArgumentException("handler " + str + " exists.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.l
    public void a(m mVar) {
        a(mVar, mVar.type == 3);
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void aTF() {
        this.dKR++;
        final int i = this.dKR;
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("version", "1.0");
        hashMap.put("logid", aTK());
        a(m.a(hashMap, dKS[this.dKR % dKS.length], new k() { // from class: com.baidu.tbadk.core.hybrid.q.1
            @Override // com.baidu.tbadk.core.hybrid.k
            public void a(m mVar, JSONObject jSONObject) {
                q.this.a(mVar, i);
            }

            @Override // com.baidu.tbadk.core.hybrid.k
            public void b(int i2, Throwable th) {
                if (i2 == 1) {
                    if (i < q.dKU.length) {
                        q.this.aTL();
                    }
                    if (i >= 0 && i < q.dKU.length) {
                        q.this.de(String.valueOf(q.dKU[i]), "");
                        return;
                    }
                    BdLog.e("pingIndex " + i + " out of bounds.");
                    e.Z(q.this.aTK(), TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, "ping timeout for index " + i);
                }
            }
        }), true);
        de("100", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar, int i) {
        this.status = 0;
        long currentTimeMillis = System.currentTimeMillis();
        if (i >= 0 && i < dKT.length) {
            de(String.valueOf(dKT[i]), String.valueOf(currentTimeMillis - mVar.start));
        } else {
            BdLog.e("pingIndex " + i + " out of bounds.");
        }
    }

    @Override // com.baidu.tbadk.core.hybrid.i
    public void vT(String str) {
        if (TextUtils.isEmpty(str)) {
            e.debug("invalid callbackId.");
            return;
        }
        m remove = this.dKl.remove(str);
        if (remove != null) {
            e.debug("(" + remove.cmd + ", " + remove.method + ", " + str + ") timeout.");
            remove.b(1, (Throwable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void vW(String str) {
        this.dKR = -1;
        if (this.status != 2 && this.status != 1) {
            e.debug("current status " + this.status + ", broken because url changed to " + str);
            this.status = 2;
        }
        if (p.vU(str) && p.vV(str)) {
            e.debug("current status " + this.status + ", constructing bridge for " + str);
            if (this.dKF != null) {
                this.dKF.aTy();
            }
            b(this.dKE);
            if (this.dKF != null) {
                this.dKF.aTz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String db(String str, String str2) {
        e.debug("got js prompt in url:" + str + " with content:" + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("messageType");
            if ("ping".equals(optString)) {
                p(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else if ("request".equals(optString)) {
                a(jSONObject.optString("cmd"), jSONObject.optString("method"), jSONObject.optJSONObject("inputData"), jSONObject);
            } else if (IIntercepter.TYPE_RESPONSE.equals(optString)) {
                p(jSONObject.optString(WBConstants.SHARE_CALLBACK_ID), jSONObject.optJSONObject("outputData"));
            } else {
                e.Z(aTK(), TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, "invalid message type " + optString);
            }
            return null;
        } catch (JSONException e) {
            e.Z(aTK(), TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, e.getMessage());
            return null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        if (this.status != -1) {
            throw new IllegalStateException("Can't init bridge more than once.");
        }
        this.dKE.getSettings().setJavaScriptEnabled(true);
        this.dKE.setWebViewClient(this.dKN);
        this.dKE.setWebChromeClient(this.dKO);
        this.dKE.removeJavascriptInterface("searchBoxJavaBridge_");
        this.status = 1;
    }

    private void a(m mVar, boolean z) {
        if (!z) {
            if (this.status != 0) {
                e.Z(aTK(), TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY, "(" + mVar.cmd + ", " + mVar.method + ") is called before bridge ready");
            }
            if (TextUtils.isEmpty(mVar.cmd) || TextUtils.isEmpty(mVar.method)) {
                e.Z(aTK(), TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, "the alias class or method is empty");
                mVar.b(3, new IllegalArgumentException("cmd or method is illegal."));
                return;
            }
        }
        if (!TextUtils.isEmpty(mVar.dKJ)) {
            if (mVar.type != 3) {
                this.dKl.put(mVar.dKJ, mVar);
                if (mVar.timeout > 0) {
                    this.dKP.sendMessageDelayed(Message.obtain(this.dKP, 2, mVar.dKJ), mVar.timeout);
                } else if (mVar.cmd != null || mVar.method != null) {
                    e.debug("ignore timeout check for method call (" + mVar.cmd + ", " + mVar.method + ").");
                }
            } else {
                e.debug("ignore timeout check for response method, callbackId " + mVar.dKJ);
            }
        }
        try {
            String aTH = mVar.aTH();
            if (Build.VERSION.SDK_INT >= 19) {
                this.dKE.evaluateJavascript(aTH, null);
            } else {
                this.dKE.loadUrl(aTH);
            }
            e.debug(aTH);
        } catch (NullPointerException e) {
            de("500", e.getMessage());
        } catch (JSONException e2) {
            if (z) {
                de(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, e2.getMessage());
            } else {
                e.debug(e2.getMessage());
            }
            mVar.b(2, e2);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.status != 0) {
            e.Z(aTK(), TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, "bridge is not ready");
        }
        h hVar = this.dKQ.get(str);
        if (hVar == null) {
            hVar = new b(this, str);
            e.Z(aTK(), TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, "cmd " + str + " not found");
        }
        hVar.a(str2, jSONObject, jSONObject2);
    }

    private void p(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            e.debug("invalid callbackId.");
            return;
        }
        this.dKP.removeMessages(2, str);
        m remove = this.dKl.remove(str);
        if (remove != null) {
            remove.cC(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aTK() {
        return this.logId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(String str, String str2) {
        e.Y(aTK(), str, str2);
    }

    private void b(WebView webView) {
        this.logId = String.valueOf(System.currentTimeMillis());
        try {
            InputStream open = webView.getContext().getAssets().open("bridge.dist.min.js");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            StringBuilder aTM = aTM();
            aTM.append(new String(bArr));
            webView.loadUrl("javascript:" + aTM.toString());
            this.dKP.sendEmptyMessageDelayed(1, 0L);
        } catch (Throwable th) {
            de(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, th.getMessage());
            e.debug(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTL() {
        e.debug("reInject for pingIndex " + this.dKR);
        b(this.dKE);
    }

    private StringBuilder aTM() throws JSONException {
        StringBuilder sb = new StringBuilder("window.HYBRID_INITIAL_DATA=");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "android");
        jSONObject.put("version", "1.0");
        jSONObject.put("logid", aTK());
        sb.append(jSONObject.toString());
        sb.append(';');
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends Handler {
        private final WeakReference<i> dKW;

        public c(i iVar) {
            this.dKW = new WeakReference<>(iVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i iVar = this.dKW.get();
            if (iVar == null) {
                e.debug("TimeHandler got null bridge reference.");
                return;
            }
            switch (message.what) {
                case 1:
                    iVar.aTF();
                    return;
                case 2:
                    iVar.vT((String) message.obj);
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
        private final l dKk;

        protected b(l lVar, String str) {
            this.dKk = lVar;
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
            this.dKk.a(m.m(optString, hashMap));
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
            mVar.b(4, (Throwable) null);
        }
    }
}
