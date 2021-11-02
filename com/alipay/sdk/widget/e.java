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
import com.alipay.sdk.util.i;
import com.alipay.sdk.util.l;
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
/* loaded from: classes6.dex */
public class e extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static Handler m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f34281a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34282b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34283c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f34284d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f34285e;

    /* renamed from: f  reason: collision with root package name */
    public final C1527e f34286f;

    /* renamed from: g  reason: collision with root package name */
    public f f34287g;

    /* renamed from: h  reason: collision with root package name */
    public g f34288h;

    /* renamed from: i  reason: collision with root package name */
    public h f34289i;
    public final com.alipay.sdk.sys.a j;
    public View.OnClickListener k;
    public final float l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f34290a;

        /* renamed from: com.alipay.sdk.widget.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1526a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ View f34291a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f34292b;

            public RunnableC1526a(a aVar, View view) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34292b = aVar;
                this.f34291a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f34291a.setEnabled(true);
                }
            }
        }

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34290a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (hVar = this.f34290a.f34289i) == null) {
                return;
            }
            view.setEnabled(false);
            e.m.postDelayed(new RunnableC1526a(this, view), 256L);
            if (view != this.f34290a.f34281a) {
                if (view == this.f34290a.f34283c) {
                    hVar.a(this.f34290a);
                    return;
                }
                return;
            }
            hVar.b(this.f34290a);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34293a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f34294b;

        public b(e eVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34294b = eVar;
            this.f34293a = context;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(268435456);
                    this.f34293a.startActivity(intent);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f34295a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34295a = eVar;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, webView, str, str2, str3, jsPromptResult)) == null) ? this.f34295a.f34287g.a(this.f34295a, str, str2, str3, jsPromptResult) : invokeLLLLL.booleanValue;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, i2) == null) {
                if (!this.f34295a.f34286f.f34298b) {
                    this.f34295a.f34284d.setVisibility(8);
                } else if (i2 > 90) {
                    this.f34295a.f34284d.setVisibility(4);
                } else {
                    if (this.f34295a.f34284d.getVisibility() == 4) {
                        this.f34295a.f34284d.setVisibility(0);
                    }
                    this.f34295a.f34284d.setProgress(i2);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
                this.f34295a.f34287g.c(this.f34295a, str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f34296a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34296a = eVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) || this.f34296a.f34288h.b(this.f34296a, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) || this.f34296a.f34288h.d(this.f34296a, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) || this.f34296a.f34288h.a(this.f34296a, i2, str, str2)) {
                return;
            }
            super.onReceivedError(webView, i2, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) || this.f34296a.f34288h.a(this.f34296a, sslErrorHandler, sslError)) {
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (this.f34296a.f34288h.a(this.f34296a, str)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            return invokeLL.booleanValue;
        }
    }

    /* renamed from: com.alipay.sdk.widget.e$e  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1527e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f34297a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f34298b;

        public C1527e(boolean z, boolean z2) {
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
            this.f34297a = z;
            this.f34298b = z2;
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        boolean a(e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult);

        void c(e eVar, String str);
    }

    /* loaded from: classes6.dex */
    public interface g {
        boolean a(e eVar, int i2, String str, String str2);

        boolean a(e eVar, SslErrorHandler sslErrorHandler, SslError sslError);

        boolean a(e eVar, String str);

        boolean b(e eVar, String str);

        boolean d(e eVar, String str);
    }

    /* loaded from: classes6.dex */
    public interface h {
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
        m = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(Context context, com.alipay.sdk.sys.a aVar, C1527e c1527e) {
        this(context, null, aVar, c1527e);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar, c1527e};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], (com.alipay.sdk.sys.a) objArr2[2], (C1527e) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public ImageView getBackButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34281a : (ImageView) invokeV.objValue;
    }

    public ProgressBar getProgressbar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f34284d : (ProgressBar) invokeV.objValue;
    }

    public ImageView getRefreshButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34283c : (ImageView) invokeV.objValue;
    }

    public TextView getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f34282b : (TextView) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f34285e.getUrl() : (String) invokeV.objValue;
    }

    public WebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f34285e : (WebView) invokeV.objValue;
    }

    public void setChromeProxy(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.f34287g = fVar;
            if (fVar == null) {
                this.f34285e.setWebChromeClient(null);
            } else {
                this.f34285e.setWebChromeClient(new c(this));
            }
        }
    }

    public void setWebClientProxy(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.f34288h = gVar;
            if (gVar == null) {
                this.f34285e.setWebViewClient(null);
            } else {
                this.f34285e.setWebViewClient(new d(this));
            }
        }
    }

    public void setWebEventProxy(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hVar) == null) {
            this.f34289i = hVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, AttributeSet attributeSet, com.alipay.sdk.sys.a aVar, C1527e c1527e) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, aVar, c1527e};
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
        this.k = new a(this);
        this.f34286f = c1527e == null ? new C1527e(false, false) : c1527e;
        this.j = aVar;
        this.l = context.getResources().getDisplayMetrics().density;
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
            linearLayout.setVisibility(this.f34286f.f34297a ? 0 : 8);
            ImageView imageView = new ImageView(context);
            this.f34281a = imageView;
            imageView.setOnClickListener(this.k);
            this.f34281a.setScaleType(ImageView.ScaleType.CENTER);
            this.f34281a.setImageDrawable(i.a(i.f34225a, context));
            this.f34281a.setPadding(a(12), 0, a(12), 0);
            linearLayout.addView(this.f34281a, new LinearLayout.LayoutParams(-2, -2));
            View view = new View(context);
            view.setBackgroundColor(-2500135);
            linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
            TextView textView = new TextView(context);
            this.f34282b = textView;
            textView.setTextColor(-15658735);
            this.f34282b.setTextSize(17.0f);
            this.f34282b.setMaxLines(1);
            this.f34282b.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(a(17), 0, 0, 0);
            layoutParams.weight = 1.0f;
            linearLayout.addView(this.f34282b, layoutParams);
            ImageView imageView2 = new ImageView(context);
            this.f34283c = imageView2;
            imageView2.setOnClickListener(this.k);
            this.f34283c.setScaleType(ImageView.ScaleType.CENTER);
            this.f34283c.setImageDrawable(i.a(i.f34226b, context));
            this.f34283c.setPadding(a(12), 0, a(12), 0);
            linearLayout.addView(this.f34283c, new LinearLayout.LayoutParams(-2, -2));
            addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
        }
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, context) == null) {
            WebView webView = new WebView(context);
            this.f34285e = webView;
            webView.setVerticalScrollbarOverlay(true);
            a(this.f34285e, context);
            WebSettings settings = this.f34285e.getSettings();
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
            this.f34285e.setVerticalScrollbarOverlay(true);
            this.f34285e.setDownloadListener(new b(this, context));
            try {
                try {
                    this.f34285e.removeJavascriptInterface("searchBoxJavaBridge_");
                    this.f34285e.removeJavascriptInterface("accessibility");
                    this.f34285e.removeJavascriptInterface("accessibilityTraversal");
                } catch (Throwable unused) {
                }
            } catch (Exception unused2) {
                Method method = this.f34285e.getClass().getMethod("removeJavascriptInterface", new Class[0]);
                if (method != null) {
                    method.invoke(this.f34285e, "searchBoxJavaBridge_");
                    method.invoke(this.f34285e, "accessibility");
                    method.invoke(this.f34285e, "accessibilityTraversal");
                }
            }
            com.alipay.sdk.widget.c.a(this.f34285e);
            addView(this.f34285e, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            ProgressBar progressBar = new ProgressBar(context, null, 16973855);
            this.f34284d = progressBar;
            progressBar.setProgressDrawable(context.getResources().getDrawable(17301612));
            this.f34284d.setMax(100);
            this.f34284d.setBackgroundColor(-218103809);
            addView(this.f34284d, new LinearLayout.LayoutParams(-1, a(2)));
        }
    }

    public void a(WebView webView, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, context) == null) {
            String userAgentString = webView.getSettings().getUserAgentString();
            WebSettings settings = webView.getSettings();
            settings.setUserAgentString(userAgentString + l.g(context));
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f34285e.loadUrl(str);
            com.alipay.sdk.widget.c.a(this.f34285e);
        }
    }

    public void a(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bArr) == null) {
            this.f34285e.postUrl(str, bArr);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            removeAllViews();
            this.f34285e.removeAllViews();
            this.f34285e.setWebViewClient(null);
            this.f34285e.setWebChromeClient(null);
            this.f34285e.destroy();
        }
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) ? (int) (i2 * this.l) : invokeI.intValue;
    }
}
