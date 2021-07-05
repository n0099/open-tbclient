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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.g0.f;
import d.a.g0.g;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class PayWebActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f9435i;
    public boolean j;
    public String k;
    public Bundle l;
    public WebView webView;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayWebActivity f9436e;

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
            this.f9436e = payWebActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f9436e.setResult(0);
                this.f9436e.finish();
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

    private void V() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        this.k = intent.getStringExtra("load_url");
        this.l = intent.getBundleExtra("launch_payment_data");
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            ImageView imageView = (ImageView) findViewById(f.iv_pay_back);
            this.f9435i = imageView;
            imageView.setOnClickListener(new a(this));
            WebView webView = (WebView) findViewById(f.webView);
            this.webView = webView;
            webView.setVerticalScrollBarEnabled(false);
            this.webView.setHorizontalScrollBarEnabled(false);
            this.webView.getSettings().setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 19) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            this.webView.setWebViewClient(new b(this));
            if (TextUtils.isEmpty(this.k)) {
                return;
            }
            this.webView.loadUrl(this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            if (str.startsWith("cashier://closewindow")) {
                setResult(0);
                finish();
                return true;
            } else if (URLUtil.isNetworkUrl(str)) {
                return false;
            } else {
                this.j = str.contains("weixin://");
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                startActivity(intent);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
            setContentView(g.activity_pay_web);
            this.j = false;
            V();
            W();
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
            if (this.j) {
                Intent intent = new Intent();
                intent.putExtras(this.l);
                setResult(-1, intent);
                finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PayWebActivity f9437a;

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
            this.f9437a = payWebActivity;
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
                sslErrorHandler.proceed();
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
                return this.f9437a.m(str);
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
                    return this.f9437a.m(uri);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }
}
