package com.baidu.nadcore.webview.container;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.h.k;
import c.a.b0.h0.f;
import c.a.b0.h0.j;
import c.a.b0.k0.i.d;
import c.a.b0.k0.i.f;
import c.a.b0.k0.i.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.webview.BrowserStateView;
import com.baidu.nadcore.webview.container.base.AbsContainer;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BaseNativeBrowserContainer extends AbsContainer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f35864f;

    /* renamed from: g  reason: collision with root package name */
    public String f35865g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.b0.k0.n.a f35866h;

    /* renamed from: i  reason: collision with root package name */
    public String f35867i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f35868j;
    public BrowserStateView k;
    public boolean l;
    public boolean m;
    public View.OnClickListener mDefaultRetryClickListener;
    public c.a.b0.k0.g.a.b mFrameExtHandler;
    public FrameLayout mRootView;
    public LinearLayout mWebRootView;
    public WebView mWebView;
    public boolean n;

    /* loaded from: classes4.dex */
    public class a implements DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseNativeBrowserContainer a;

        public a(BaseNativeBrowserContainer baseNativeBrowserContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseNativeBrowserContainer;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                this.a.l(str, str2, str3, str4, j2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.b0.f.g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseNativeBrowserContainer a;

        public b(BaseNativeBrowserContainer baseNativeBrowserContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseNativeBrowserContainer;
        }

        @Override // c.a.b0.f.g.d
        public void a(boolean z, @Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) {
                String o = c.a.b0.f.h.d.o(map);
                if (TextUtils.isEmpty(o)) {
                    return;
                }
                this.a.loadJavaScript(o);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends c.a.b0.k0.r.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.b0.f.g.d f35869c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BaseNativeBrowserContainer f35870d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BaseNativeBrowserContainer baseNativeBrowserContainer, WebView webView, WebViewClient webViewClient, c.a.b0.f.g.d dVar, c.a.b0.f.g.d dVar2) {
            super(webView, webViewClient, dVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer, webView, webViewClient, dVar, dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WebView) objArr2[0], (WebViewClient) objArr2[1], (c.a.b0.f.g.d) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35870d = baseNativeBrowserContainer;
            this.f35869c = dVar2;
        }

        @Override // c.a.b0.k0.r.a, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f35870d.updateTitle(webView.getTitle());
                Object tag = webView.getTag(R.id.nad_webcontent_error_code);
                int intValue = tag == null ? 0 : ((Integer) tag).intValue();
                if (TextUtils.equals(str, this.f35870d.f35864f) || TextUtils.equals(webView.getOriginalUrl(), this.f35870d.f35864f) || (str != null && str.contains(this.f35870d.f35864f))) {
                    if (intValue != 0 && intValue != -1) {
                        this.f35870d.y(intValue);
                    } else {
                        this.f35870d.onLoadSuccess();
                    }
                }
                this.f35870d.hideLoadingView();
                this.f35870d.f35866h.y(str);
            }
        }

        @Override // c.a.b0.k0.r.a, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.f35870d.m) {
                    webView.setTag(R.id.nad_webcontent_error_code, 0);
                }
                this.f35870d.m = false;
                WebView webView2 = this.f35870d.mWebView;
                if (webView2 != null && !webView2.canGoBack() && !this.f35870d.mWebView.canGoForward()) {
                    this.f35870d.showLoadingView();
                }
                this.f35870d.f35866h.z(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i2, str, str2) == null) {
                super.onReceivedError(webView, i2, str, str2);
                webView.setTag(R.id.nad_webcontent_error_code, Integer.valueOf(i2));
                this.f35870d.f35866h.B(webView, i2, str, str2);
            }
        }

        @Override // c.a.b0.k0.r.a, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                String d2 = c.a.b0.k0.p.b.d(str);
                if (TextUtils.isEmpty(d2) || !(d2.startsWith("http://") || d2.startsWith("https://") || d2.startsWith("ftp://") || d2.startsWith("sftp://") || d2.startsWith("ftps://"))) {
                    this.f35870d.m = true;
                    if (this.f35870d.f35866h.H(webView, this.f35870d.getUrl(), str) || c.a.b0.f.a.b(this.f35870d.getActivity(), str, false) || g.b.a().a(this.f35870d.getActivity(), str, webView.getUrl(), this.f35869c) || c.a.b0.f.c.c(str, this.f35870d.getActivity())) {
                        return true;
                    }
                    this.f35870d.showLoadingView();
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseNativeBrowserContainer a;

        public d(BaseNativeBrowserContainer baseNativeBrowserContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseNativeBrowserContainer;
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                this.a.f35866h.C(str);
                this.a.updateTitle(webView.getTitle());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WebView f35871e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseNativeBrowserContainer f35872f;

        public e(BaseNativeBrowserContainer baseNativeBrowserContainer, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35872f = baseNativeBrowserContainer;
            this.f35871e = webView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f35871e.destroy();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f35873e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseNativeBrowserContainer f35874f;

        public f(BaseNativeBrowserContainer baseNativeBrowserContainer, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35874f = baseNativeBrowserContainer;
            this.f35873e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.f35873e;
                if (!str.startsWith("javascript:")) {
                    str = "javascript:" + str;
                }
                WebView webView = this.f35874f.mWebView;
                if (webView != null) {
                    webView.loadUrl(str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseNativeBrowserContainer f35875e;

        public g(BaseNativeBrowserContainer baseNativeBrowserContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35875e = baseNativeBrowserContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && NetUtil.a(c.a.b0.h.a.b())) {
                this.f35875e.refreshWebview();
                this.f35875e.showLoadingView();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNativeBrowserContainer(c.a.b0.k0.g.a.a aVar, c.a.b0.k0.g.a.b bVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.b0.k0.g.a.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = true;
        this.m = false;
        this.n = true;
        this.mDefaultRetryClickListener = new g(this);
        this.mFrameExtHandler = bVar;
        r();
    }

    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, obj, str) == null) {
            this.mWebView.addJavascriptInterface(obj, str);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean canSlide(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) ? this.mWebView != null && this.n : invokeL.booleanValue;
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean checkInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void doFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.doFinish();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (getIntent().getExtras() == null || !isAdFromOtherApp()) {
                return false;
            }
            getIntent().removeExtra("other_app_back_url");
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public c.a.b0.k0.j.c getAdWebViewAlsProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f35866h.i() : (c.a.b0.k0.j.c) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public View getContainerLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mRootView : (View) invokeV.objValue;
    }

    public String getDesUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f35866h.l() : (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f35865g : (String) invokeV.objValue;
    }

    public FrameLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mRootView : (FrameLayout) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String url = this.mWebView.getUrl();
            return !TextUtils.isEmpty(url) ? url : !TextUtils.isEmpty(this.f35864f) ? this.f35864f : "";
        }
        return (String) invokeV.objValue;
    }

    public LinearLayout getWebRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mWebRootView : (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public int getWebViewScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? getWebRootView().getScrollY() : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (getActivity() instanceof BaseActivity)) {
            ((BaseActivity) getActivity()).setCurrentActivityNoTransparent();
        }
    }

    public boolean handleKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.k.hideState(BrowserStateView.ViewState.LOADING);
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, context) == null) && Build.VERSION.SDK_INT == 17 && context != null) {
            try {
                AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
                if (accessibilityManager.isEnabled()) {
                    Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(accessibilityManager, 0);
                }
            } catch (Error e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public FrameLayout initBrowserLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(getActivity());
            BrowserStateView browserStateView = new BrowserStateView(getActivity());
            this.k = browserStateView;
            browserStateView.setErrorViewClickListener(this.mDefaultRetryClickListener);
            WebView a2 = c.a.b0.k0.i.a.a().a(getActivity());
            this.mWebView = a2;
            frameLayout.addView(a2, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(this.k, new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f35864f = k(getIntent());
        }
    }

    public void initJsAbility(@NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, webView) == null) {
            try {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            webView.loadUrl("javascript:(function(){try{if(performance&&performance.timing){var performanceResult={};for(var key in performance.timing){if(typeof performance.timing[key]!==\"function\"){performanceResult[key]=performance.timing[key];}}var strJson=JSON.stringify(performanceResult);NadJsControl.getPerformanceTiming(strJson);}}catch(e){}})();");
            this.f35866h.q(getActivity(), webView);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean isAdFromOtherApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? (getIntent().getExtras() == null || TextUtils.isEmpty(getIntent().getExtras().getString("other_app_back_url"))) ? false : true : invokeV.booleanValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? getActivity().getRequestedOrientation() : invokeV.intValue;
    }

    public final String k(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, intent)) == null) {
            String stringExtra = intent.getStringExtra("url");
            if (TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(getDesUrl())) {
                stringExtra = getDesUrl();
            }
            String d2 = c.a.b0.k0.p.b.d(stringExtra);
            return (TextUtils.isEmpty(d2) || !c.a.b0.k0.p.b.g(c.a.b0.k0.p.b.b(d2))) ? "" : d2;
        }
        return (String) invokeL.objValue;
    }

    public final void l(String str, String str2, String str3, String str4, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) && c.a.b0.h0.g.b(c.a.b0.h0.g.c(c.a.b0.h0.g.e(str, str3, str4)), str4) == 3) {
            JSONObject b2 = c.a.b0.x.b.b(this.f35867i);
            c.a.b0.x.b.e(b2, "url", str);
            c.a.b0.x.b.d(b2, BreakpointSQLiteKey.CONTENT_LENGTH, j2);
            c.a.b0.k0.i.b.b().b(getActivity(), this.f35868j, b2.toString());
        }
    }

    public void loadJavaScript(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            k.b(new f(this, str));
        }
    }

    public void loadUrl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c.a.b0.k0.g.a.b bVar = this.mFrameExtHandler;
            if (bVar == null || !bVar.handleLoadUrl()) {
                c.a.b0.k0.n.a aVar = this.f35866h;
                if (aVar == null || !aVar.m()) {
                    this.m = true;
                    this.mWebView.loadUrl(this.f35864f);
                }
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.k.hideState(BrowserStateView.ViewState.ERROR);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.mWebRootView.addView(initBrowserLayout(), new LinearLayout.LayoutParams(-1, -1));
            u(this.mWebView);
            initJsAbility(this.mWebView);
            if (this.mShowNavigationBar) {
                p();
            } else {
                this.mRootView.findViewById(R.id.titlebar).setVisibility(8);
            }
        }
    }

    public final void o(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, intent) == null) && TextUtils.equals(intent.getStringExtra("layoutfullscreen"), "1") && Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 1024 | 8192);
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(getResources().getColor(R.color.nad_transparent, null));
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048607, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f35866h.v();
            super.onCreate();
            setContentView(View.inflate(getActivity(), R.layout.nad_light_browser_activity, null));
            initData();
            t();
            s();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.f35866h.w();
            v();
            super.onDestroy();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048611, this, i2, keyEvent)) == null) {
            if (d.b.a().a(i2) || handleKeyDown(i2, keyEvent)) {
                return true;
            }
            if (i2 == 4) {
                webViewGoBack();
                return true;
            } else if (this.mWebView.onKeyDown(i2, keyEvent)) {
                return true;
            } else {
                return super.onKeyDown(i2, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }

    public void onLoadSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            hideLoadingView();
            m();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.mWebView.freeMemory();
            super.onLowMemory();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, intent) == null) {
            this.f35866h.x(intent);
            super.onNewIntent(intent);
            getActivity().setIntent(intent);
            this.mWebView.clearHistory();
            String k = k(intent);
            if (TextUtils.isEmpty(k)) {
                return;
            }
            this.f35864f = k;
            loadUrl();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.f35866h.A();
            this.mWebView.onPause();
            j.a(getApplicationContext(), getWindow().getDecorView().getWindowToken());
            super.onPause();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048616, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.f35866h.D();
            super.onResume();
            this.mWebView.onResume();
            this.mWebView.resumeTimers();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.f35866h.E();
            super.onStart();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.f35866h.F();
            super.onStop();
        }
    }

    public final void p() {
        int[] a2;
        int[] c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.mRootView.findViewById(R.id.titlebar).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(R.id.titlebar_left_layout);
            for (int i2 : c.a.b0.k0.i.b.i().a()) {
                ImageView imageView = new ImageView(new ContextThemeWrapper(getActivity(), (int) R.style.NadTitleBarBackBtnStyle), null, R.style.NadTitleBarBackBtnStyle);
                imageView.setImageResource(i2);
                imageView.setTag(Integer.valueOf(i2));
                c.a.b0.k0.i.b.i().b(imageView, this);
                linearLayout.addView(imageView);
            }
            LinearLayout linearLayout2 = (LinearLayout) this.mRootView.findViewById(R.id.titlebar_right_layout);
            for (int i3 : c.a.b0.k0.i.b.i().c()) {
                ImageView imageView2 = new ImageView(new ContextThemeWrapper(getActivity(), (int) R.style.NadTitleBarBackBtnStyle), null, R.style.NadTitleBarBackBtnStyle);
                imageView2.setImageResource(i3);
                imageView2.setTag(Integer.valueOf(i3));
                c.a.b0.k0.i.b.i().b(imageView2, this);
                linearLayout2.addView(imageView2);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void q(@NonNull Intent intent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, intent) == null) {
            String stringExtra = intent.getStringExtra("forbidautorotate");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (Build.VERSION.SDK_INT == 26) {
                h();
            }
            switch (stringExtra.hashCode()) {
                case 48:
                    if (stringExtra.equals("0")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49:
                    if (stringExtra.equals("1")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 50:
                    if (stringExtra.equals("2")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                if (j() != -1) {
                    x(-1);
                }
            } else if (c2 != 1) {
                if (c2 == 2 && j() != 0) {
                    x(0);
                }
            } else if (j() != 1) {
                x(1);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.f35866h = new c.a.b0.k0.n.a(this);
        }
    }

    public void refreshWebview() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (webView = this.mWebView) == null) {
            return;
        }
        webView.reload();
        this.m = true;
    }

    public void resetContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            Intent intent = getIntent();
            q(intent);
            o(intent);
            setStateViewVisible(!"true".equals(getIntent().getStringExtra("hide_state_view")));
            loadUrl();
            this.f35866h.u(getActivity(), this.mRootView, this.mWebView);
        }
    }

    public void setCanSlide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.n = z;
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void setContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, view) == null) {
            super.setContentView(view);
            this.mRootView = (FrameLayout) view.findViewById(R.id.rootview);
            this.mWebRootView = (LinearLayout) view.findViewById(R.id.webview_container);
        }
    }

    public void setDownLoadView(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, relativeLayout) == null) {
            this.f35868j = relativeLayout;
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.f35865g = str;
        }
    }

    public void setStateViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.l = z;
            BrowserStateView browserStateView = this.k;
            if (browserStateView != null) {
                browserStateView.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void setmAdParams(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.f35867i = str;
        }
    }

    public void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (this.l) {
                this.k.setVisibility(0);
            }
            this.k.showState(BrowserStateView.ViewState.LOADING);
            this.k.hideState(BrowserStateView.ViewState.ERROR);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            n();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void u(@NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, webView) == null) {
            i(getActivity());
            webView.setScrollbarFadingEnabled(true);
            webView.setVerticalScrollBarEnabled(true);
            webView.setHorizontalScrollBarEnabled(false);
            webView.getSettings().setLightTouchEnabled(false);
            webView.getSettings().setUserAgentString(c.a.b0.h.a.e());
            webView.getSettings().setDefaultTextEncodingName("UTF-8");
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setAllowFileAccess(false);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setPluginState(WebSettings.PluginState.ON);
            webView.getSettings().setCacheMode(-1);
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            webView.getSettings().setAllowContentAccess(true);
            getActivity().getWindow().setFlags(16777216, 16777216);
            webView.getSettings().setDomStorageEnabled(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.clearFocus();
            webView.clearHistory();
            webView.clearView();
            webView.setScrollBarStyle(0);
            w(true);
            webView.setDownloadListener(new a(this));
            b bVar = new b(this);
            webView.setWebViewClient(new c(this, webView, null, bVar, bVar));
            webView.setWebChromeClient(new d(this));
        }
    }

    public void updateTitle(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, str) == null) || (textView = (TextView) this.mWebRootView.findViewById(R.id.tv_title)) == null) {
            return;
        }
        textView.setText(str);
    }

    public final void v() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (webView = this.mWebView) == null) {
            return;
        }
        if (webView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mWebView.getParent()).removeView(this.mWebView);
        }
        WebView webView2 = this.mWebView;
        if (!f.b.c()) {
            new Handler().postDelayed(new e(this, webView2), 1500L);
        } else {
            try {
                webView2.destroy();
            } catch (Exception unused) {
            }
        }
        this.mWebView = null;
    }

    public final void w(boolean z) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            try {
                CookieSyncManager.createInstance(getActivity());
                cookieManager = CookieManager.getInstance();
            } catch (Throwable th) {
                th.printStackTrace();
                cookieManager = null;
            }
            if (cookieManager == null || Build.VERSION.SDK_INT < 21) {
                return;
            }
            cookieManager.setAcceptThirdPartyCookies(this.mWebView, z);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void webViewGoBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            j.a(getApplicationContext(), getWindow().getDecorView().getWindowToken());
            if (this.mWebView.canGoBack()) {
                this.mWebView.goBack();
            } else if (g()) {
            } else {
                f.b.a().a(getActivity());
            }
        }
    }

    public final void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            getActivity().setRequestedOrientation(i2);
        }
    }

    public final void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            if (i2 == 0) {
                m();
                return;
            }
            if (this.l) {
                this.k.setVisibility(0);
            }
            this.k.showState(BrowserStateView.ViewState.ERROR);
            this.k.hideState(BrowserStateView.ViewState.LOADING);
        }
    }

    public void loadJavaScript(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048601, this, str, valueCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("javascript:")) {
            str = "javascript:" + str;
        }
        this.mWebView.evaluateJavascript(str, valueCallback);
    }

    public void loadUrl(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, map) == null) {
            this.mWebView.loadUrl(this.f35864f, map);
        }
    }
}
