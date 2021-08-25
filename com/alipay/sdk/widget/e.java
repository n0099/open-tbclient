package com.alipay.sdk.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.util.h;
import com.alipay.sdk.util.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class e extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static Handler f36035g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f36036a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f36037b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f36038c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f36039d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f36040e;

    /* renamed from: f  reason: collision with root package name */
    public final a f36041f;

    /* renamed from: h  reason: collision with root package name */
    public b f36042h;

    /* renamed from: i  reason: collision with root package name */
    public c f36043i;

    /* renamed from: j  reason: collision with root package name */
    public d f36044j;
    public final com.alipay.sdk.sys.a k;
    public View.OnClickListener l;
    public final float m;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f36052a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f36053b;

        public a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36052a = z;
            this.f36053b = z2;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(e eVar, String str);

        boolean a(e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    /* loaded from: classes4.dex */
    public interface c {
        boolean a(e eVar, int i2, String str, String str2);

        boolean a(e eVar, SslErrorHandler sslErrorHandler, SslError sslError);

        boolean b(e eVar, String str);

        boolean c(e eVar, String str);

        boolean d(e eVar, String str);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(e eVar);

        void b(e eVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1920584097, "Lcom/alipay/sdk/widget/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1920584097, "Lcom/alipay/sdk/widget/e;");
                return;
            }
        }
        f36035g = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(Context context, com.alipay.sdk.sys.a aVar, a aVar2) {
        this(context, null, aVar, aVar2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, aVar2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (com.alipay.sdk.sys.a) objArr2[2], (a) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public ImageView getBackButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36036a : (ImageView) invokeV.objValue;
    }

    public ProgressBar getProgressbar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36039d : (ProgressBar) invokeV.objValue;
    }

    public ImageView getRefreshButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f36038c : (ImageView) invokeV.objValue;
    }

    public TextView getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f36037b : (TextView) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f36040e.getUrl() : (String) invokeV.objValue;
    }

    public WebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f36040e : (WebView) invokeV.objValue;
    }

    public void setChromeProxy(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f36042h = bVar;
            if (bVar == null) {
                this.f36040e.setWebChromeClient(null);
            } else {
                this.f36040e.setWebChromeClient(new WebChromeClient(this) { // from class: com.alipay.sdk.widget.e.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ e f36050a;

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
                        this.f36050a = this;
                    }

                    @Override // android.webkit.WebChromeClient
                    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                        InterceptResult invokeLLLLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLLLLL = interceptable2.invokeLLLLL(1048576, this, webView, str, str2, str3, jsPromptResult)) == null) ? this.f36050a.f36042h.a(this.f36050a, str, str2, str3, jsPromptResult) : invokeLLLLL.booleanValue;
                    }

                    @Override // android.webkit.WebChromeClient
                    public void onProgressChanged(WebView webView, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2) == null) {
                            if (!this.f36050a.f36041f.f36053b) {
                                this.f36050a.f36039d.setVisibility(8);
                            } else if (i2 > 90) {
                                this.f36050a.f36039d.setVisibility(4);
                            } else {
                                if (this.f36050a.f36039d.getVisibility() == 4) {
                                    this.f36050a.f36039d.setVisibility(0);
                                }
                                this.f36050a.f36039d.setProgress(i2);
                            }
                        }
                    }

                    @Override // android.webkit.WebChromeClient
                    public void onReceivedTitle(WebView webView, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
                            this.f36050a.f36042h.a(this.f36050a, str);
                        }
                    }
                });
            }
        }
    }

    public void setWebClientProxy(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f36043i = cVar;
            if (cVar == null) {
                this.f36040e.setWebViewClient(null);
            } else {
                this.f36040e.setWebViewClient(new WebViewClient(this) { // from class: com.alipay.sdk.widget.e.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ e f36051a;

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
                        this.f36051a = this;
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView, String str) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) || this.f36051a.f36043i.d(this.f36051a, str)) {
                            return;
                        }
                        super.onPageFinished(webView, str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) || this.f36051a.f36043i.c(this.f36051a, str)) {
                            return;
                        }
                        super.onPageFinished(webView, str);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView webView, int i2, String str, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) || this.f36051a.f36043i.a(this.f36051a, i2, str, str2)) {
                            return;
                        }
                        super.onReceivedError(webView, i2, str, str2);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) || this.f36051a.f36043i.a(this.f36051a, sslErrorHandler, sslError)) {
                            return;
                        }
                        super.onReceivedSslError(webView, sslErrorHandler, sslError);
                    }

                    @Override // android.webkit.WebViewClient
                    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, webView, str)) == null) {
                            if (this.f36051a.f36043i.b(this.f36051a, str)) {
                                return true;
                            }
                            return super.shouldOverrideUrlLoading(webView, str);
                        }
                        return invokeLL.booleanValue;
                    }
                });
            }
        }
    }

    public void setWebEventProxy(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            this.f36044j = dVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, AttributeSet attributeSet, com.alipay.sdk.sys.a aVar, a aVar2) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, aVar, aVar2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = new View.OnClickListener(this) { // from class: com.alipay.sdk.widget.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f36045a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f36045a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (dVar = this.f36045a.f36044j) == null) {
                    return;
                }
                view.setEnabled(false);
                e.f36035g.postDelayed(new Runnable(this, view) { // from class: com.alipay.sdk.widget.e.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ View f36046a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ AnonymousClass1 f36047b;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext2 = TitanRuntime.newInitContext();
                            newInitContext2.initArgs = r2;
                            Object[] objArr3 = {this, view};
                            interceptable3.invokeUnInit(65536, newInitContext2);
                            int i4 = newInitContext2.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext2.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext2);
                                return;
                            }
                        }
                        this.f36047b = this;
                        this.f36046a = view;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                            this.f36046a.setEnabled(true);
                        }
                    }
                }, 256L);
                if (view != this.f36045a.f36036a) {
                    if (view == this.f36045a.f36038c) {
                        dVar.b(this.f36045a);
                        return;
                    }
                    return;
                }
                dVar.a(this.f36045a);
            }
        };
        this.f36041f = aVar2 == null ? new a(false, false) : aVar2;
        this.k = aVar;
        this.m = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        a(context);
        b(context);
        c(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setBackgroundColor(-218103809);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            linearLayout.setVisibility(this.f36041f.f36052a ? 0 : 8);
            ImageView imageView = new ImageView(context);
            this.f36036a = imageView;
            imageView.setOnClickListener(this.l);
            this.f36036a.setScaleType(ImageView.ScaleType.CENTER);
            this.f36036a.setImageDrawable(h.a(h.f35982a, context));
            this.f36036a.setPadding(a(12), 0, a(12), 0);
            linearLayout.addView(this.f36036a, new LinearLayout.LayoutParams(-2, -2));
            View view = new View(context);
            view.setBackgroundColor(-2500135);
            linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
            TextView textView = new TextView(context);
            this.f36037b = textView;
            textView.setTextColor(-15658735);
            this.f36037b.setTextSize(17.0f);
            this.f36037b.setMaxLines(1);
            this.f36037b.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(a(17), 0, 0, 0);
            layoutParams.weight = 1.0f;
            linearLayout.addView(this.f36037b, layoutParams);
            ImageView imageView2 = new ImageView(context);
            this.f36038c = imageView2;
            imageView2.setOnClickListener(this.l);
            this.f36038c.setScaleType(ImageView.ScaleType.CENTER);
            this.f36038c.setImageDrawable(h.a(h.f35983b, context));
            this.f36038c.setPadding(a(12), 0, a(12), 0);
            linearLayout.addView(this.f36038c, new LinearLayout.LayoutParams(-2, -2));
            addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
        }
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, context) == null) {
            WebView webView = new WebView(context);
            this.f36040e = webView;
            webView.setVerticalScrollbarOverlay(true);
            a(this.f36040e, context);
            WebSettings settings = this.f36040e.getSettings();
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setSupportMultipleWindows(true);
            settings.setUseWideViewPort(true);
            settings.setAppCacheMaxSize(5242880L);
            settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
            settings.setAllowFileAccess(false);
            settings.setTextSize(WebSettings.TextSize.NORMAL);
            if (Build.VERSION.SDK_INT >= 16) {
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
            }
            settings.setAppCacheEnabled(true);
            settings.setJavaScriptEnabled(true);
            settings.setSavePassword(false);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setCacheMode(1);
            settings.setDomStorageEnabled(true);
            settings.setAllowContentAccess(false);
            this.f36040e.setVerticalScrollbarOverlay(true);
            this.f36040e.setDownloadListener(new DownloadListener(this, context) { // from class: com.alipay.sdk.widget.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f36048a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f36049b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36049b = this;
                    this.f36048a = context;
                }

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            intent.setFlags(268435456);
                            this.f36048a.startActivity(intent);
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
            try {
                try {
                    this.f36040e.removeJavascriptInterface("searchBoxJavaBridge_");
                    this.f36040e.removeJavascriptInterface("accessibility");
                    this.f36040e.removeJavascriptInterface("accessibilityTraversal");
                } catch (Throwable unused) {
                }
            } catch (Exception unused2) {
                Method method = this.f36040e.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                if (method != null) {
                    method.invoke(this.f36040e, "searchBoxJavaBridge_");
                    method.invoke(this.f36040e, "accessibility");
                    method.invoke(this.f36040e, "accessibilityTraversal");
                }
            }
            com.alipay.sdk.widget.c.a(this.f36040e);
            addView(this.f36040e, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            ProgressBar progressBar = new ProgressBar(context, null, 16973855);
            this.f36039d = progressBar;
            progressBar.setProgressDrawable(context.getResources().getDrawable(17301612));
            this.f36039d.setMax(100);
            this.f36039d.setBackgroundColor(-218103809);
            addView(this.f36039d, new LinearLayout.LayoutParams(-1, a(2)));
        }
    }

    public void a(WebView webView, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, context) == null) {
            String userAgentString = webView.getSettings().getUserAgentString();
            WebSettings settings = webView.getSettings();
            settings.setUserAgentString(userAgentString + k.c(context));
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f36040e.loadUrl(str);
            com.alipay.sdk.widget.c.a(this.f36040e);
        }
    }

    public void a(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bArr) == null) {
            this.f36040e.postUrl(str, bArr);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            removeAllViews();
            this.f36040e.removeAllViews();
            this.f36040e.setWebViewClient(null);
            this.f36040e.setWebChromeClient(null);
            this.f36040e.destroy();
        }
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) ? (int) (i2 * this.m) : invokeI.intValue;
    }
}
