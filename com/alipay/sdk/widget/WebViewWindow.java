package com.alipay.sdk.widget;

import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class WebViewWindow extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f2004f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f2005a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f2006b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f2007c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f2008d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f2009e;

    /* renamed from: g  reason: collision with root package name */
    public a f2010g;

    /* renamed from: h  reason: collision with root package name */
    public b f2011h;

    /* renamed from: i  reason: collision with root package name */
    public c f2012i;
    public View.OnClickListener j;
    public final float k;

    /* loaded from: classes.dex */
    public interface a {
        void a(WebViewWindow webViewWindow, String str);

        boolean a(WebViewWindow webViewWindow, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(WebViewWindow webViewWindow, int i2, String str, String str2);

        boolean a(WebViewWindow webViewWindow, SslErrorHandler sslErrorHandler, SslError sslError);

        boolean b(WebViewWindow webViewWindow, String str);

        boolean c(WebViewWindow webViewWindow, String str);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(WebViewWindow webViewWindow);

        void b(WebViewWindow webViewWindow);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-769520451, "Lcom/alipay/sdk/widget/WebViewWindow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-769520451, "Lcom/alipay/sdk/widget/WebViewWindow;");
                return;
            }
        }
        f2004f = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebViewWindow(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public ImageView getBackButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2005a : (ImageView) invokeV.objValue;
    }

    public ProgressBar getProgressbar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2008d : (ProgressBar) invokeV.objValue;
    }

    public ImageView getRefreshButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2007c : (ImageView) invokeV.objValue;
    }

    public TextView getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2006b : (TextView) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2009e.getUrl() : (String) invokeV.objValue;
    }

    public WebView getWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f2009e : (WebView) invokeV.objValue;
    }

    public void setChromeProxy(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f2010g = aVar;
            if (aVar == null) {
                this.f2009e.setWebChromeClient(null);
            } else {
                this.f2009e.setWebChromeClient(new s(this));
            }
        }
    }

    public void setWebClientProxy(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f2011h = bVar;
            if (bVar == null) {
                this.f2009e.setWebViewClient(null);
            } else {
                this.f2009e.setWebViewClient(new t(this));
            }
        }
    }

    public void setWebEventProxy(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.f2012i = cVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.j = new q(this);
        this.k = context.getResources().getDisplayMetrics().density;
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
            ImageView imageView = new ImageView(context);
            this.f2005a = imageView;
            imageView.setOnClickListener(this.j);
            this.f2005a.setScaleType(ImageView.ScaleType.CENTER);
            this.f2005a.setImageDrawable(com.alipay.sdk.util.k.a(com.alipay.sdk.util.k.f1987a, context));
            this.f2005a.setPadding(a(12), 0, a(12), 0);
            linearLayout.addView(this.f2005a, new LinearLayout.LayoutParams(-2, -2));
            View view = new View(context);
            view.setBackgroundColor(-2500135);
            linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
            TextView textView = new TextView(context);
            this.f2006b = textView;
            textView.setTextColor(-15658735);
            this.f2006b.setTextSize(17.0f);
            this.f2006b.setMaxLines(1);
            this.f2006b.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(a(17), 0, 0, 0);
            layoutParams.weight = 1.0f;
            linearLayout.addView(this.f2006b, layoutParams);
            ImageView imageView2 = new ImageView(context);
            this.f2007c = imageView2;
            imageView2.setOnClickListener(this.j);
            this.f2007c.setScaleType(ImageView.ScaleType.CENTER);
            this.f2007c.setImageDrawable(com.alipay.sdk.util.k.a(com.alipay.sdk.util.k.f1988b, context));
            this.f2007c.setPadding(a(12), 0, a(12), 0);
            linearLayout.addView(this.f2007c, new LinearLayout.LayoutParams(-2, -2));
            addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
        }
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, context) == null) {
            WebView webView = new WebView(context);
            this.f2009e = webView;
            webView.setVerticalScrollbarOverlay(true);
            a(this.f2009e, context);
            WebSettings settings = this.f2009e.getSettings();
            settings.setUseWideViewPort(true);
            settings.setAppCacheMaxSize(5242880L);
            settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
            settings.setAllowFileAccess(true);
            settings.setAppCacheEnabled(true);
            settings.setJavaScriptEnabled(true);
            settings.setCacheMode(-1);
            settings.setSupportMultipleWindows(true);
            settings.setJavaScriptEnabled(true);
            settings.setSavePassword(false);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            try {
                this.f2009e.removeJavascriptInterface("searchBoxJavaBridge_");
                this.f2009e.removeJavascriptInterface("accessibility");
                this.f2009e.removeJavascriptInterface("accessibilityTraversal");
            } catch (Exception unused) {
            }
            addView(this.f2009e, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            ProgressBar progressBar = new ProgressBar(context, null, 16973855);
            this.f2008d = progressBar;
            progressBar.setProgressDrawable(context.getResources().getDrawable(17301612));
            this.f2008d.setMax(100);
            this.f2008d.setBackgroundColor(-218103809);
            addView(this.f2008d, new LinearLayout.LayoutParams(-1, a(2)));
        }
    }

    public void a(WebView webView, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, context) == null) {
            String userAgentString = webView.getSettings().getUserAgentString();
            String packageName = context.getPackageName();
            String h2 = com.alipay.sdk.util.n.h(context);
            webView.getSettings().setUserAgentString(userAgentString + " AlipaySDK(" + packageName + "/" + h2 + "/15.6.5" + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f2009e.loadUrl(str);
        }
    }

    public void a(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bArr) == null) {
            this.f2009e.postUrl(str, bArr);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            removeAllViews();
            this.f2009e.removeAllViews();
            this.f2009e.setWebViewClient(null);
            this.f2009e.setWebChromeClient(null);
            this.f2009e.destroy();
        }
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) ? (int) (i2 * this.k) : invokeI.intValue;
    }
}
