package com.baidu.poly.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.h0.g;
import c.a.h0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes10.dex */
public class PayWebActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LAUNCH_PAYMENT_DATA = "launch_payment_data";
    public static final String LOAD_URL = "load_url";
    public static final String URL_CLOSE_WINDOW = "cashier://closewindow";
    public static final String URL_WEIXIN = "weixin://";
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView ivBack;
    public boolean jumpedWX;
    public String loadUrl;
    public Bundle mBundle;
    public WebView webView;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayWebActivity f37816e;

        public a(PayWebActivity payWebActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payWebActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37816e = payWebActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f37816e.setResult(0);
                this.f37816e.finish();
            }
        }
    }

    public PayWebActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleRedirectUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith(URL_CLOSE_WINDOW)) {
                c.a.h0.p.b.g(119102, "3", PayChannelController.WXPAY_PAYCHANNEL, "-105", "调起微信H5支付失败");
                setResult(0);
                finish();
                return true;
            } else if (URLUtil.isNetworkUrl(str)) {
                return false;
            } else {
                this.jumpedWX = str.contains(URL_WEIXIN);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                startActivity(intent);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    private void initLoadUrl() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        this.loadUrl = intent.getStringExtra(LOAD_URL);
        this.mBundle = intent.getBundleExtra(LAUNCH_PAYMENT_DATA);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            ImageView imageView = (ImageView) findViewById(g.iv_pay_back);
            this.ivBack = imageView;
            imageView.setOnClickListener(new a(this));
            WebView webView = (WebView) findViewById(g.webView);
            this.webView = webView;
            webView.setVerticalScrollBarEnabled(false);
            this.webView.setHorizontalScrollBarEnabled(false);
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.setWebViewClient(new b(this));
            if (TextUtils.isEmpty(this.loadUrl)) {
                return;
            }
            this.webView.loadUrl(this.loadUrl);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.h0.p.b.g(119103, "4", PayChannelController.WXPAY_PAYCHANNEL, "-106", "取消微信H5支付");
            setResult(0);
            finish();
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(h.activity_pay_web);
            this.jumpedWX = false;
            initLoadUrl();
            initView();
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WebView webView = this.webView;
            if (webView != null) {
                webView.loadDataWithBaseURL(null, "", SapiWebView.DATA_MIME_TYPE, "utf-8", null);
                this.webView.clearHistory();
                ((ViewGroup) this.webView.getParent()).removeView(this.webView);
                this.webView.destroy();
                this.webView = null;
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            if (this.jumpedWX) {
                Intent intent = new Intent();
                intent.putExtras(this.mBundle);
                setResult(-1, intent);
                finish();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayWebActivity a;

        public b(PayWebActivity payWebActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payWebActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payWebActivity;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, webResourceRequest, webResourceError) == null) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, sslErrorHandler, sslError) == null) {
                if (webView != null) {
                    sslErrorHandler.proceed();
                } else {
                    sslErrorHandler.cancel();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                try {
                    str = URLDecoder.decode(str, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                return this.a.handleRedirectUrl(str);
            }
            return invokeLL.booleanValue;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, webResourceRequest)) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    String uri = webResourceRequest.getUrl().toString();
                    try {
                        uri = URLDecoder.decode(uri, "UTF-8");
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                    return this.a.handleRedirectUrl(uri);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }
}
