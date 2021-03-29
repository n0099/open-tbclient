package com.baidu.android.lbspay.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.alipay.sdk.util.e;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.view.TitleBar;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.wallet.base.widget.WalletBaseEmptyView;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
/* loaded from: classes.dex */
public class WapPayActivity extends LBSBaseActivity implements View.OnClickListener {
    public static final String BAIDUSCHEME = "baiduwalletjuhe";
    public static final String CLOSE_VIEW_METHOD = "close_view";
    public static final String EXTRA_PARAM = "extra_param";
    public static final String FROM_SDK_FLAG = "fromsdkjuhe=1";
    public static final String HOST = "https://zhifu.baidu.com";
    public static final String JSPARAMS = "javascript:window._SIGN_FROM_BAIDUWALLETJUHESDK = 1";
    public static final String NOTIFY_URL_PARAMS = "notify_url";
    public static final String PAGE_URL = "/proxy/return/pay?";
    public static final String PAY_PAY_FAILED = "status=PAY_FAILED";
    public static final String PAY_SUCCESS = "status=PAY_SUCCESS";
    public static final int REQUEST_CODE = 99;
    public static final String SMS_PAY_CLOSE_WINDOW = "status=CLOSE_WINDOW";
    public static final String SMS_PAY_PAGE_URL = "/proxy/return/smspay";
    public static final String SMS_PAY_SUCCESS = "status=SMSPAY_SUCCESS";
    public static final String SUCCESS_NOTIFY_METHOD = "success_notify";
    public static final String URL = "WapPayActivityUrl";
    public static boolean mIsSuccessFlag = false;
    public boolean finishedError = false;
    public WalletBaseEmptyView mEmptyView;
    public String mLoadingTitle;
    public SafeWebView mWebView;
    public String title;

    /* loaded from: classes.dex */
    public class OnPageCancelListener implements DialogInterface.OnCancelListener {
        public OnPageCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* loaded from: classes.dex */
    public class a extends SafeWebView.SafeChromeClient {

        /* renamed from: b  reason: collision with root package name */
        public boolean f2583b;

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            new AlertDialog.Builder(WapPayActivity.this).setTitle(ResUtils.string(WapPayActivity.this, "lbspay_title")).setMessage(str2).setPositiveButton(ResUtils.string(WapPayActivity.this, "lbspay_confirm"), new DialogInterface.OnClickListener() { // from class: com.baidu.android.lbspay.activity.WapPayActivity.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }).setNegativeButton(ResUtils.string(WapPayActivity.this, "lbspay_cancel"), new DialogInterface.OnClickListener() { // from class: com.baidu.android.lbspay.activity.WapPayActivity.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                }
            }).show();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
            new AlertDialog.Builder(WapPayActivity.this).setTitle(ResUtils.string(WapPayActivity.this, "lbspay_title")).setMessage(str2).setPositiveButton(ResUtils.string(WapPayActivity.this, "lbspay_confirm"), new DialogInterface.OnClickListener() { // from class: com.baidu.android.lbspay.activity.WapPayActivity.a.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }).setNegativeButton(ResUtils.string(WapPayActivity.this, "lbspay_cancel"), new DialogInterface.OnClickListener() { // from class: com.baidu.android.lbspay.activity.WapPayActivity.a.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                }
            }).show();
            return true;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
            new AlertDialog.Builder(WapPayActivity.this).setTitle(ResUtils.string(WapPayActivity.this, "lbspay_title")).setMessage(str2).setPositiveButton(ResUtils.string(WapPayActivity.this, "lbspay_confirm"), new DialogInterface.OnClickListener() { // from class: com.baidu.android.lbspay.activity.WapPayActivity.a.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsPromptResult.confirm();
                }
            }).setNegativeButton(ResUtils.string(WapPayActivity.this, "lbspay_cancel"), new DialogInterface.OnClickListener() { // from class: com.baidu.android.lbspay.activity.WapPayActivity.a.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsPromptResult.cancel();
                }
            }).show();
            return true;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i <= 25) {
                this.f2583b = false;
            } else if (!this.f2583b) {
                WapPayActivity.this.mWebView.loadUrl(WapPayActivity.JSPARAMS);
                this.f2583b = true;
            }
            if (i == 100) {
                WapPayActivity wapPayActivity = WapPayActivity.this;
                if (!wapPayActivity.finishedError) {
                    wapPayActivity.hideErrorPage();
                }
            }
            super.onProgressChanged(webView, i);
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (!this.f2583b) {
                WapPayActivity.this.mWebView.loadUrl(WapPayActivity.JSPARAMS);
            }
            super.onReceivedTitle(webView, str);
            this.f2583b = true;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            WapPayActivity.this.title = str;
        }

        public a() {
        }
    }

    /* loaded from: classes.dex */
    public class b extends SafeWebView.SafeWebViewClient {

        /* renamed from: b  reason: collision with root package name */
        public boolean f2597b;

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            if (!this.f2597b) {
                WapPayActivity.this.mWebView.loadUrl(WapPayActivity.JSPARAMS);
            }
            super.doUpdateVisitedHistory(webView, str, z);
            this.f2597b = true;
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            LogUtil.logd("url=" + str);
            if (!this.f2597b) {
                WapPayActivity.this.mWebView.loadUrl(WapPayActivity.JSPARAMS);
            }
            WalletGlobalUtils.safeDismissDialog(WapPayActivity.this, -2);
            super.onPageFinished(webView, str);
            this.f2597b = false;
            WapPayActivity wapPayActivity = WapPayActivity.this;
            if (!wapPayActivity.finishedError && !TextUtils.isEmpty(wapPayActivity.title) && !WapPayActivity.this.title.startsWith("http") && !WapPayActivity.this.title.contains("错误") && !WapPayActivity.this.title.contains("error")) {
                WapPayActivity wapPayActivity2 = WapPayActivity.this;
                wapPayActivity2.titleBar.setTitle(wapPayActivity2.title);
            } else {
                WapPayActivity wapPayActivity3 = WapPayActivity.this;
                wapPayActivity3.titleBar.setTitle(ResUtils.getString(wapPayActivity3, "lbspay_title_new"));
            }
            if (webView.getProgress() != 100) {
                WapPayActivity.this.finishedError = true;
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WapPayActivity.this.mEmptyView.setVisibility(8);
            LogUtil.logd("url=" + str);
            WapPayActivity wapPayActivity = WapPayActivity.this;
            wapPayActivity.titleBar.setTitle(wapPayActivity.mLoadingTitle);
            if (!this.f2597b) {
                WapPayActivity.this.mWebView.loadUrl(WapPayActivity.JSPARAMS);
            }
            if (str.contains(WapPayActivity.PAGE_URL)) {
                if (str.contains(WapPayActivity.PAY_SUCCESS)) {
                    Intent intent = new Intent();
                    intent.putExtra(WalletPayResultActivityConfig.PAY_RESULT, "success");
                    WapPayActivity.this.setResult(99, intent);
                    WapPayActivity.this.finish();
                } else if (str.contains(WapPayActivity.PAY_PAY_FAILED)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra(WalletPayResultActivityConfig.PAY_RESULT, e.f1969a);
                    WapPayActivity.this.setResult(99, intent2);
                    WapPayActivity.this.finish();
                } else {
                    WapPayActivity.this.setResult(99, new Intent());
                    WapPayActivity.this.finish();
                }
            } else if (str.contains(WapPayActivity.SMS_PAY_PAGE_URL)) {
                if (str.contains(WapPayActivity.SMS_PAY_SUCCESS)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(WalletPayResultActivityConfig.PAY_RESULT, "success");
                    Intent intent3 = new Intent();
                    intent3.putExtras(bundle);
                    WapPayActivity.this.setResult(99, intent3);
                    WapPayActivity.this.finish();
                } else if (str.contains(WapPayActivity.SMS_PAY_CLOSE_WINDOW)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(WalletPayResultActivityConfig.PAY_RESULT, QueryResponse.Options.CANCEL);
                    Intent intent4 = new Intent();
                    intent4.putExtras(bundle2);
                    WapPayActivity.this.setResult(99, intent4);
                    WapPayActivity.this.finish();
                } else {
                    WapPayActivity.this.setResult(99, new Intent());
                    WapPayActivity.this.finish();
                }
            } else {
                WalletGlobalUtils.safeShowDialog(WapPayActivity.this, -2, "");
                super.onPageStarted(webView, str, bitmap);
                this.f2597b = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            WapPayActivity wapPayActivity = WapPayActivity.this;
            wapPayActivity.finishedError = true;
            wapPayActivity.mWebView.stopLoading();
            WapPayActivity.this.showErrorPage(str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String host;
            Uri parse = Uri.parse(str);
            if (parse == null || !WapPayActivity.BAIDUSCHEME.equals(parse.getScheme()) || (host = parse.getHost()) == null) {
                return false;
            }
            if (host.startsWith(WapPayActivity.SUCCESS_NOTIFY_METHOD)) {
                boolean unused = WapPayActivity.mIsSuccessFlag = true;
            } else if (host.startsWith(WapPayActivity.CLOSE_VIEW_METHOD)) {
                WapPayActivity.this.notifyMessage();
            }
            return false;
        }

        public b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideErrorPage() {
        this.mEmptyView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMessage() {
        if (mIsSuccessFlag) {
            LBSPayResult.payResult(getActivity(), 0, "");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(WalletPayResultActivityConfig.PAY_RESULT, QueryResponse.Options.CANCEL);
        setResult(99, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorPage(String str) {
        this.mEmptyView.setVisibility(0);
        this.titleBar.setTitle(ResUtils.getString(this, "lbspay_title_new"));
        this.mEmptyView.showTip1_Tip2_NextBtn(ResUtils.drawable(this, "wallet_base_no_net"), ResUtils.getString(this, "wallet_base_no_network"), ResUtils.getString(this, "wallet_base_no_network_reason"), ResUtils.getString(getActivity(), "bd_wallet_reload"), new WalletBaseEmptyView.EmptyBtnClickListener() { // from class: com.baidu.android.lbspay.activity.WapPayActivity.1
            @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
            public void onBtnClick() {
                WapPayActivity.this.mWebView.reload();
                WapPayActivity.this.finishedError = false;
            }
        });
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleFailure(int i, int i2, String str) {
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleResponse(int i, Object obj, String str) {
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        SafeWebView safeWebView;
        if (this.mEmptyView.getVisibility() == 0) {
            this.mEmptyView.setVisibility(8);
            notifyMessage();
        } else if (!mIsSuccessFlag && (safeWebView = this.mWebView) != null && safeWebView.canGoBack()) {
            this.mWebView.goBack();
            this.finishedError = false;
        } else {
            notifyMessage();
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.mEmptyView.setVisibility(8);
        this.mWebView.reload();
        this.finishedError = false;
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(this, "wallet_juhe_layout_wappay"));
        TitleBar titleBar = (TitleBar) findViewById(ResUtils.id(this, "wallet_lbs_titlebar"));
        this.titleBar = titleBar;
        titleBar.setTitle(ResUtils.getString(this, "lbspay_title_new"));
        this.titleBar.setRightButton(this);
        String string = getIntent().getExtras().getString(URL);
        this.mEmptyView = (WalletBaseEmptyView) findViewById(ResUtils.id(this, "lspay_empty_view"));
        this.mWebView = (SafeWebView) findViewById(ResUtils.id(this, "webView"));
        this.mLoadingTitle = ResUtils.getString(this, "ebpay_loading");
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.mWebView.setWebViewClient(new b());
        this.mWebView.setWebChromeClient(new a());
        settings.setMinimumFontSize(settings.getMinimumFontSize() + 8);
        if (Build.VERSION.SDK_INT >= 11) {
            this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.mWebView.removeJavascriptInterface("accessibility");
            this.mWebView.removeJavascriptInterface("accessibilityTraversal");
        }
        if (Build.VERSION.SDK_INT <= 18) {
            settings.setSavePassword(false);
        }
        mIsSuccessFlag = false;
        if (string.contains("?")) {
            if (!string.endsWith("&")) {
                string = string + "&";
            }
        } else {
            string = string + "?";
        }
        this.mWebView.loadUrl(string + FROM_SDK_FLAG);
        setBackButton();
        PayStatisticsUtil.onEvent("wap_pay_activity");
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SafeWebView safeWebView = this.mWebView;
        if (safeWebView != null) {
            safeWebView.resumeTimers();
        }
    }
}
