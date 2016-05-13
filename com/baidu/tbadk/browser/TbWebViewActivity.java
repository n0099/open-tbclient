package com.baidu.tbadk.browser;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TbWebViewActivity extends BaseWebViewActivity {
    public static final int FILECHOOSER_RESULTCODE = 1;
    private com.baidu.tieba.tbadkCore.e.a jsBridge;
    private String mBid;
    private com.baidu.tbadk.core.c.m mHybridBridge;
    private ValueCallback<Uri> mUploadMessage;
    private static boolean sFrameLostTracked = false;
    private static HashMap<String, String> mShareToTypes = new HashMap<>();
    protected com.baidu.tbadk.core.c.e mWebView = null;
    private com.baidu.tieba.tbadkCore.e.c jsCallback = new q(this);
    private boolean mShareResultToFe = false;
    private boolean mShowShareItem = true;

    static {
        mShareToTypes.put("weixin_timeline", "weixin_timeline");
        mShareToTypes.put("weixin_friend", "weixin_friend");
        mShareToTypes.put("qqdenglu", "qq_zone");
        mShareToTypes.put("sinaweibo", "sina_weibo");
        mShareToTypes.put("qqweibo", "qq_weibo");
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.m11getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_WEBVIEW_PROXY, (Class) null);
        this.jsBridge = new com.baidu.tieba.tbadkCore.e.a();
        this.jsBridge.a(new XiubaTbJsBridge(getPageContext()));
        this.jsBridge.a(new g(getPageContext()));
        this.jsBridge.a(buildGameDownloadJSPrompt());
        if (this.mNeedCookie) {
            initCookie();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (getWebView() != null) {
            callHiddenWebViewMethod("onResume");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        callHiddenWebViewMethod("onPause");
    }

    public void addJsPromptInterface(com.baidu.tieba.tbadkCore.e.b bVar) {
        if (bVar != null) {
            this.jsBridge.a(bVar);
        }
    }

    public void removePromptInterface(com.baidu.tieba.tbadkCore.e.b bVar) {
        if (bVar != null) {
            this.jsBridge.b(bVar);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View createWebView() {
        if (this.mWebView == null) {
            this.mWebView = new com.baidu.tbadk.core.c.e(getPageContext().getPageActivity());
            this.mWebView.getSettings().setJavaScriptEnabled(true);
            this.mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            this.mWebView.getSettings().setAllowFileAccess(true);
            this.mWebView.getSettings().setDatabaseEnabled(true);
            this.mWebView.getSettings().setDomStorageEnabled(true);
            this.mWebView.getSettings().setSupportZoom(true);
            this.mWebView.getSettings().setBuiltInZoomControls(true);
            this.mWebView.getSettings().setUseWideViewPort(true);
            this.mWebView.getSettings().setDatabasePath(getApplicationContext().getDir("databases", 0).getAbsolutePath());
            this.mWebView.setHorizontalScrollBarEnabled(false);
            this.mWebView.setHorizontalScrollbarOverlay(false);
            this.mWebView.setInitialScale(100);
            this.mWebView.setScrollBarStyle(33554432);
            this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mWebView.setWebViewClient(new a());
            this.mWebView.setDownloadListener(new b(this, null));
            TbWebChromeClient tbWebChromeClient = new TbWebChromeClient(this);
            tbWebChromeClient.setOnJsPromptCallback(this.jsCallback);
            this.mWebView.setWebChromeClient(tbWebChromeClient);
            if (this.mEnableJs) {
                addJavascriptInterface();
            }
            CompatibleUtile.getInstance().removeJavascriptInterface(this.mWebView);
            boolean isHybridBridgeEnabled = TbadkCoreApplication.m11getInst().isHybridBridgeEnabled();
            com.baidu.tbadk.core.c.m a2 = com.baidu.tbadk.core.c.r.a(isHybridBridgeEnabled, this.mWebView, (com.baidu.tbadk.core.c.a) null);
            this.mHybridBridge = a2;
            if (isHybridBridgeEnabled) {
                a2.a(new r(this, a2));
                a2.a(new com.baidu.tbadk.core.c.a.a(a2));
                a2.a(new s(this, a2));
                a2.a(new u(this, a2));
                a2.a(new h(a2));
            }
        }
        return this.mWebView;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (getUploadMessage() != null) {
                getUploadMessage().onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
                setUploadMessage(null);
                return;
            }
            return;
        }
        switch (i) {
            case 24007:
                handleShareResult(intent, i2);
                return;
            default:
                return;
        }
    }

    private void handleShareResult(Intent intent, int i) {
        if (this.mShareResultToFe) {
            this.mShareResultToFe = false;
            if (intent != null) {
                String str = mShareToTypes.get(intent.getStringExtra("share_to"));
                HashMap hashMap = new HashMap();
                boolean z = i == -1;
                hashMap.put("bid", this.mBid);
                hashMap.put("result", Boolean.valueOf(z));
                hashMap.put("channel", str);
                com.baidu.tbadk.core.c.n a2 = com.baidu.tbadk.core.c.n.a("TBJS_COMMON_Share", "onShareResult", (Map<String, Object>) hashMap, 0L, false);
                if (this.mHybridBridge != null) {
                    this.mHybridBridge.a(a2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void addJavascriptInterface(Object obj, String str) {
        if (this.mWebView != null) {
            this.mWebView.addJavascriptInterface(obj, str);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public View getWebView() {
        return this.mWebView;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void loadUrl(String str) {
        if (this.mWebView != null) {
            com.baidu.tieba.adkiller.b.gR(str);
            CompatibleUtile.getInstance().loadUrl(this.mWebView, str);
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void webViewDestory() {
        if (this.jsBridge != null) {
            this.jsBridge.aUE();
        }
        if (this.mWebView != null) {
            this.mWebView.getSettings().setBuiltInZoomControls(true);
            this.mWebView.setVisibility(8);
            com.baidu.adp.lib.h.h.dL().postDelayed(new v(this), ViewConfiguration.getZoomControlsTimeout() + 1000);
        }
    }

    /* loaded from: classes.dex */
    protected class a extends WebViewClient {
        protected a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (TbWebViewActivity.this.mWebView != null) {
                TbWebViewActivity.this.mUrl = str;
                if (StringUtils.isNull(TbWebViewActivity.this.mUrlTitle)) {
                    TbWebViewActivity.this.mUrlTitle = TbWebViewActivity.this.mWebView.getTitle();
                }
                TbWebViewActivity.this.mView.bX(TbWebViewActivity.this.mUrlTitle);
                TbWebViewActivity.this.mView.setNavBarVisibility(TbWebViewActivity.this.mIsShowNavBar);
                TbWebViewActivity.this.mView.ac(TbWebViewActivity.this.isNeedShowShareItem());
                TbWebViewActivity.this.hideProgressBar();
                TbWebViewActivity.this.stopLoadTimer();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            if (TbWebViewActivity.this.mWebView != null) {
                TbWebViewActivity.this.mWebView.stopLoading();
                TbWebViewActivity.this.stopLoadTimer();
                TbWebViewActivity.this.onReceivedError(i);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (TbWebViewActivity.this.mWebView != null) {
                TbWebViewActivity.this.mUrl = str;
                TbWebViewActivity.this.showProgressBar();
                TbWebViewActivity.this.startLoadTimer();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tbadk.browser.TbWebViewActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            com.baidu.tieba.adkiller.b.gR(str);
            int b = bg.ut().b(TbWebViewActivity.this.getPageContext(), new String[]{str});
            if (b == 1) {
                TbWebViewActivity.this.finish();
                return true;
            } else if (b == 0) {
                return true;
            } else {
                TbWebViewActivity.this.mUrl = str;
                TbWebViewActivity.this.refresh();
                return true;
            }
        }
    }

    /* loaded from: classes.dex */
    private class b implements DownloadListener {
        private b() {
        }

        /* synthetic */ b(TbWebViewActivity tbWebViewActivity, b bVar) {
            this();
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (!StringUtils.isNull(str)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                    TbWebViewActivity.this.startActivity(intent);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public boolean webViewGoBack() {
        if (this.mWebView != null && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initCookie() {
        f.I(getApplicationContext());
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void onReceivedError(int i) {
        if (this.mWebView != null) {
            this.mUrl = this.mWebView.getUrl();
            this.mWebView.stopLoading();
        }
        hideProgressBar();
        showNoDataView();
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity
    public void initWebView() {
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
        }
    }

    public ValueCallback<Uri> getUploadMessage() {
        return this.mUploadMessage;
    }

    public void setUploadMessage(ValueCallback<Uri> valueCallback) {
        this.mUploadMessage = valueCallback;
    }

    private com.baidu.tieba.tbadkCore.e.b buildGameDownloadJSPrompt() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GAME_JS_HANDLER_REGISTER, com.baidu.tieba.tbadkCore.e.b.class, getPageContext());
        if (runTask == null || runTask.getData() == null) {
            return null;
        }
        return (com.baidu.tieba.tbadkCore.e.b) runTask.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackFPS() {
        if (!sFrameLostTracked) {
            sFrameLostTracked = true;
            com.baidu.tbadk.core.c.g.su().a(16, new w(this));
        }
    }
}
