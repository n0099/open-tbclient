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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.view.TitleBar;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.WalletBaseEmptyView;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
/* loaded from: classes.dex */
public class WapPayActivity extends LBSBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static boolean mIsSuccessFlag;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean finishedError;
    public WalletBaseEmptyView mEmptyView;
    public String mLoadingTitle;
    public SafeWebView mWebView;
    public String title;

    /* loaded from: classes.dex */
    public class OnPageCancelListener implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WapPayActivity this$0;

        public OnPageCancelListener(WapPayActivity wapPayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wapPayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = wapPayActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class a extends SafeWebView.SafeChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WapPayActivity f2664a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2665b;

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, webView, str, str2, jsResult)) == null) {
                new AlertDialog.Builder(this.f2664a).setTitle(ResUtils.string(this.f2664a, "lbspay_title")).setMessage(str2).setPositiveButton(ResUtils.string(this.f2664a, "lbspay_confirm"), new DialogInterface.OnClickListener(this, jsResult) { // from class: com.baidu.android.lbspay.activity.WapPayActivity.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ JsResult f2668a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f2669b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, jsResult};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f2669b = this;
                        this.f2668a = jsResult;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                            this.f2668a.confirm();
                        }
                    }
                }).setNegativeButton(ResUtils.string(this.f2664a, "lbspay_cancel"), new DialogInterface.OnClickListener(this, jsResult) { // from class: com.baidu.android.lbspay.activity.WapPayActivity.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ JsResult f2666a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f2667b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, jsResult};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f2667b = this;
                        this.f2666a = jsResult;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                            this.f2666a.cancel();
                        }
                    }
                }).show();
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, jsResult)) == null) {
                new AlertDialog.Builder(this.f2664a).setTitle(ResUtils.string(this.f2664a, "lbspay_title")).setMessage(str2).setPositiveButton(ResUtils.string(this.f2664a, "lbspay_confirm"), new DialogInterface.OnClickListener(this, jsResult) { // from class: com.baidu.android.lbspay.activity.WapPayActivity.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ JsResult f2672a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f2673b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, jsResult};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f2673b = this;
                        this.f2672a = jsResult;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                            this.f2672a.confirm();
                        }
                    }
                }).setNegativeButton(ResUtils.string(this.f2664a, "lbspay_cancel"), new DialogInterface.OnClickListener(this, jsResult) { // from class: com.baidu.android.lbspay.activity.WapPayActivity.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ JsResult f2670a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f2671b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, jsResult};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f2671b = this;
                        this.f2670a = jsResult;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                            this.f2670a.cancel();
                        }
                    }
                }).show();
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, str3, jsPromptResult)) == null) {
                new AlertDialog.Builder(this.f2664a).setTitle(ResUtils.string(this.f2664a, "lbspay_title")).setMessage(str2).setPositiveButton(ResUtils.string(this.f2664a, "lbspay_confirm"), new DialogInterface.OnClickListener(this, jsPromptResult) { // from class: com.baidu.android.lbspay.activity.WapPayActivity.a.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ JsPromptResult f2676a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f2677b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, jsPromptResult};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f2677b = this;
                        this.f2676a = jsPromptResult;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                            this.f2676a.confirm();
                        }
                    }
                }).setNegativeButton(ResUtils.string(this.f2664a, "lbspay_cancel"), new DialogInterface.OnClickListener(this, jsPromptResult) { // from class: com.baidu.android.lbspay.activity.WapPayActivity.a.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ JsPromptResult f2674a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f2675b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, jsPromptResult};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f2675b = this;
                        this.f2674a = jsPromptResult;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, dialogInterface, i2) == null) {
                            this.f2674a.cancel();
                        }
                    }
                }).show();
                return true;
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, webView, i2) == null) {
                if (i2 <= 25) {
                    this.f2665b = false;
                } else if (!this.f2665b) {
                    this.f2664a.mWebView.loadUrl(WapPayActivity.JSPARAMS);
                    this.f2665b = true;
                }
                if (i2 == 100) {
                    WapPayActivity wapPayActivity = this.f2664a;
                    if (!wapPayActivity.finishedError) {
                        wapPayActivity.hideErrorPage();
                    }
                }
                super.onProgressChanged(webView, i2);
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeChromeClient, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) {
                if (!this.f2665b) {
                    this.f2664a.mWebView.loadUrl(WapPayActivity.JSPARAMS);
                }
                super.onReceivedTitle(webView, str);
                this.f2665b = true;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f2664a.title = str;
            }
        }

        public a(WapPayActivity wapPayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wapPayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2664a = wapPayActivity;
        }
    }

    /* loaded from: classes.dex */
    public class b extends SafeWebView.SafeWebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WapPayActivity f2678a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2679b;

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, webView, str, z) == null) {
                if (!this.f2679b) {
                    this.f2678a.mWebView.loadUrl(WapPayActivity.JSPARAMS);
                }
                super.doUpdateVisitedHistory(webView, str, z);
                this.f2679b = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, message, message2) == null) {
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, webView, str) == null) {
                LogUtil.logd("url=" + str);
                if (!this.f2679b) {
                    this.f2678a.mWebView.loadUrl(WapPayActivity.JSPARAMS);
                }
                WalletGlobalUtils.safeDismissDialog(this.f2678a, -2);
                super.onPageFinished(webView, str);
                this.f2679b = false;
                WapPayActivity wapPayActivity = this.f2678a;
                if (!wapPayActivity.finishedError && !TextUtils.isEmpty(wapPayActivity.title) && !this.f2678a.title.startsWith("http") && !this.f2678a.title.contains("错误") && !this.f2678a.title.contains("error")) {
                    WapPayActivity wapPayActivity2 = this.f2678a;
                    wapPayActivity2.titleBar.setTitle(wapPayActivity2.title);
                } else {
                    WapPayActivity wapPayActivity3 = this.f2678a;
                    wapPayActivity3.titleBar.setTitle(ResUtils.getString(wapPayActivity3, "lbspay_title_new"));
                }
                if (webView.getProgress() != 100) {
                    this.f2678a.finishedError = true;
                }
            }
        }

        @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, webView, str, bitmap) == null) {
                this.f2678a.mEmptyView.setVisibility(8);
                LogUtil.logd("url=" + str);
                WapPayActivity wapPayActivity = this.f2678a;
                wapPayActivity.titleBar.setTitle(wapPayActivity.mLoadingTitle);
                if (!this.f2679b) {
                    this.f2678a.mWebView.loadUrl(WapPayActivity.JSPARAMS);
                }
                if (str.contains(WapPayActivity.PAGE_URL)) {
                    if (str.contains(WapPayActivity.PAY_SUCCESS)) {
                        Intent intent = new Intent();
                        intent.putExtra(WalletPayResultActivityConfig.PAY_RESULT, "success");
                        this.f2678a.setResult(99, intent);
                        this.f2678a.finish();
                    } else if (str.contains(WapPayActivity.PAY_PAY_FAILED)) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(WalletPayResultActivityConfig.PAY_RESULT, e.f2000a);
                        this.f2678a.setResult(99, intent2);
                        this.f2678a.finish();
                    } else {
                        this.f2678a.setResult(99, new Intent());
                        this.f2678a.finish();
                    }
                } else if (str.contains(WapPayActivity.SMS_PAY_PAGE_URL)) {
                    if (str.contains(WapPayActivity.SMS_PAY_SUCCESS)) {
                        Bundle bundle = new Bundle();
                        bundle.putString(WalletPayResultActivityConfig.PAY_RESULT, "success");
                        Intent intent3 = new Intent();
                        intent3.putExtras(bundle);
                        this.f2678a.setResult(99, intent3);
                        this.f2678a.finish();
                    } else if (str.contains(WapPayActivity.SMS_PAY_CLOSE_WINDOW)) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(WalletPayResultActivityConfig.PAY_RESULT, QueryResponse.Options.CANCEL);
                        Intent intent4 = new Intent();
                        intent4.putExtras(bundle2);
                        this.f2678a.setResult(99, intent4);
                        this.f2678a.finish();
                    } else {
                        this.f2678a.setResult(99, new Intent());
                        this.f2678a.finish();
                    }
                } else {
                    WalletGlobalUtils.safeShowDialog(this.f2678a, -2, "");
                    super.onPageStarted(webView, str, bitmap);
                    this.f2679b = true;
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048581, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                WapPayActivity wapPayActivity = this.f2678a;
                wapPayActivity.finishedError = true;
                wapPayActivity.mWebView.stopLoading();
                this.f2678a.showErrorPage(str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048582, this, webView, sslErrorHandler, sslError) == null) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            String host;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, str)) == null) {
                Uri parse = Uri.parse(str);
                if (parse == null || !WapPayActivity.BAIDUSCHEME.equals(parse.getScheme()) || (host = parse.getHost()) == null) {
                    return false;
                }
                if (host.startsWith(WapPayActivity.SUCCESS_NOTIFY_METHOD)) {
                    boolean unused = WapPayActivity.mIsSuccessFlag = true;
                } else if (host.startsWith(WapPayActivity.CLOSE_VIEW_METHOD)) {
                    this.f2678a.notifyMessage();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public b(WapPayActivity wapPayActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wapPayActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2678a = wapPayActivity;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1433701248, "Lcom/baidu/android/lbspay/activity/WapPayActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1433701248, "Lcom/baidu/android/lbspay/activity/WapPayActivity;");
        }
    }

    public WapPayActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.finishedError = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideErrorPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            this.mEmptyView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (mIsSuccessFlag) {
                LBSPayResult.payResult(getActivity(), 0, "");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WalletPayResultActivityConfig.PAY_RESULT, QueryResponse.Options.CANCEL);
            setResult(99, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, str) == null) {
            this.mEmptyView.setVisibility(0);
            this.titleBar.setTitle(ResUtils.getString(this, "lbspay_title_new"));
            this.mEmptyView.showTip1_Tip2_NextBtn(ResUtils.drawable(this, "wallet_base_no_net"), ResUtils.getString(this, "wallet_base_no_network"), ResUtils.getString(this, "wallet_base_no_network_reason"), ResUtils.getString(getActivity(), "bd_wallet_reload"), new WalletBaseEmptyView.EmptyBtnClickListener(this) { // from class: com.baidu.android.lbspay.activity.WapPayActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ WapPayActivity f2663a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f2663a = this;
                }

                @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
                public void onBtnClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f2663a.mWebView.reload();
                        this.f2663a.finishedError = false;
                    }
                }
            });
        }
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
        }
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        SafeWebView safeWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.mEmptyView.setVisibility(8);
            this.mWebView.reload();
            this.finishedError = false;
        }
    }

    @Override // com.baidu.android.lbspay.activity.LBSBaseActivity, com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled", "NewApi"})
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
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
    }

    @Override // com.baidu.wallet.paysdk.ui.base.DxmPayBaseActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onResume();
            SafeWebView safeWebView = this.mWebView;
            if (safeWebView != null) {
                safeWebView.resumeTimers();
            }
        }
    }
}
