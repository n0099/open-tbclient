package com.baidu.nadcore.webview.container;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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
import c.a.b0.d0.f;
import c.a.b0.g0.h;
import c.a.b0.g0.j;
import c.a.b0.g0.p.d;
import c.a.b0.g0.p.f;
import c.a.b0.g0.p.g;
import c.a.b0.g0.p.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.webview.container.base.AbsContainer;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class BaseNativeBrowserContainer extends AbsContainer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JS_CALLBACK = "callback";
    public static final String JS_DATA = "data";
    public static final String JS_MESSAGE = "message";
    public static final String JS_STATUS = "status";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public String f37773f;

    /* renamed from: g  reason: collision with root package name */
    public String f37774g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.b0.g0.t.a f37775h;

    /* renamed from: i  reason: collision with root package name */
    public String f37776i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f37777j;
    public c.a.b0.g0.n.a.b mFrameExtHandler;
    public FrameLayout mRootView;
    public LinearLayout mWebRootView;
    public WebView mWebView;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BaseNativeBrowserContainer f37778e;

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
            this.f37778e = baseNativeBrowserContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f37778e.webViewGoBack();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DownloadListener {
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

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) {
                this.a.h(str, str2, str3, str4, j2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements c.a.b0.d.g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseNativeBrowserContainer a;

        public c(BaseNativeBrowserContainer baseNativeBrowserContainer) {
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

        @Override // c.a.b0.d.g.d
        public void a(boolean z, @Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) || map == null || map.get("callback") == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            c.a.b0.u.b.d(jSONObject, "status", map.get("status"));
            c.a.b0.u.b.d(jSONObject, "message", map.get("message"));
            c.a.b0.u.b.d(jSONObject, "data", map.get("data"));
            this.a.loadJavaScript(c.a.b0.g0.v.a.a(map.get("callback"), c.a.b0.u.b.a(jSONObject.toString())));
        }
    }

    /* loaded from: classes8.dex */
    public class d extends c.a.b0.g0.x.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.b0.d.g.d f37779c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BaseNativeBrowserContainer f37780d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(BaseNativeBrowserContainer baseNativeBrowserContainer, WebView webView, WebViewClient webViewClient, c.a.b0.d.g.d dVar, c.a.b0.d.g.d dVar2) {
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
                    super((WebView) objArr2[0], (WebViewClient) objArr2[1], (c.a.b0.d.g.d) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37780d = baseNativeBrowserContainer;
            this.f37779c = dVar2;
        }

        @Override // c.a.b0.g0.x.a, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f37780d.updateTitle(webView.getTitle());
                this.f37780d.f37775h.x(str);
            }
        }

        @Override // c.a.b0.g0.x.a, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str)) == null) {
                String d2 = c.a.b0.g0.v.c.d(str);
                if (TextUtils.isEmpty(d2) || !(d2.startsWith("http://") || d2.startsWith("https://") || d2.startsWith("ftp://") || d2.startsWith("sftp://") || d2.startsWith("ftps://"))) {
                    if (this.f37780d.f37775h.D(webView, this.f37780d.getUrl(), str) || c.a.b0.d.a.b(this.f37780d.getActivity(), str, false) || g.b.a().a(this.f37780d.getActivity(), str, webView.getUrl(), this.f37779c) || c.a.b0.d.c.c(str, this.f37780d.getActivity())) {
                        return true;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e extends WebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseNativeBrowserContainer a;

        public e(BaseNativeBrowserContainer baseNativeBrowserContainer) {
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
                this.a.f37775h.z(str);
                this.a.updateTitle(webView.getTitle());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WebView f37781e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseNativeBrowserContainer f37782f;

        public f(BaseNativeBrowserContainer baseNativeBrowserContainer, WebView webView) {
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
            this.f37782f = baseNativeBrowserContainer;
            this.f37781e = webView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f37781e.destroy();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f37783e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseNativeBrowserContainer f37784f;

        public g(BaseNativeBrowserContainer baseNativeBrowserContainer, String str) {
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
            this.f37784f = baseNativeBrowserContainer;
            this.f37783e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.f37783e;
                if (!str.startsWith("javascript:")) {
                    str = "javascript:" + str;
                }
                this.f37784f.mWebView.loadUrl(str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNativeBrowserContainer(c.a.b0.g0.n.a.a aVar, c.a.b0.g0.n.a.b bVar) {
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
                super((c.a.b0.g0.n.a.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFrameExtHandler = bVar;
        m();
    }

    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, obj, str) == null) {
            this.mWebView.addJavascriptInterface(obj, str);
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getIntent().getExtras() == null || !isAdFromOtherApp()) {
                return false;
            }
            getIntent().removeExtra("other_app_back_url");
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean canSlide(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean checkInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (getActivity() instanceof BaseActivity)) {
            ((BaseActivity) getActivity()).setCurrentActivityNoTransparent();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void doFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.doFinish();
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, context) == null) && Build.VERSION.SDK_INT == 17 && context != null) {
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

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getActivity().getRequestedOrientation() : invokeV.intValue;
    }

    public final String g(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent)) == null) {
            String stringExtra = intent.getStringExtra("url");
            if (TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(getDesUrl())) {
                stringExtra = getDesUrl();
            }
            String d2 = c.a.b0.g0.v.c.d(stringExtra);
            return (TextUtils.isEmpty(d2) || !c.a.b0.g0.v.c.g(c.a.b0.g0.v.c.b(d2))) ? "" : d2;
        }
        return (String) invokeL.objValue;
    }

    public View getContainerLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mRootView : (View) invokeV.objValue;
    }

    public String getDesUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f37775h.k() : (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f37774g : (String) invokeV.objValue;
    }

    public FrameLayout getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mRootView : (FrameLayout) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String url = this.mWebView.getUrl();
            return !TextUtils.isEmpty(url) ? url : !TextUtils.isEmpty(this.f37773f) ? this.f37773f : "";
        }
        return (String) invokeV.objValue;
    }

    public LinearLayout getWebRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mWebRootView : (LinearLayout) invokeV.objValue;
    }

    public final void h(String str, String str2, String str3, String str4, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{str, str2, str3, str4, Long.valueOf(j2)}) == null) && c.a.b0.d0.g.b(c.a.b0.d0.g.c(c.a.b0.d0.g.e(str, str3, str4)), str4) == 3) {
            JSONObject b2 = c.a.b0.u.b.b(this.f37776i);
            c.a.b0.u.b.d(b2, "url", str);
            c.a.b0.u.b.c(b2, BreakpointSQLiteKey.CONTENT_LENGTH, j2);
            c.a.b0.g0.p.b.b().a(getActivity(), this.f37777j, b2.toString());
        }
    }

    public boolean handleKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048592, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mWebRootView.addView(initBrowserLayout(), new LinearLayout.LayoutParams(-1, -1));
            p(this.mWebView);
            initJsAbility(this.mWebView);
            k();
        }
    }

    public WebView initBrowserLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            WebView a2 = c.a.b0.g0.p.a.a().a(getActivity());
            this.mWebView = a2;
            return a2;
        }
        return (WebView) invokeV.objValue;
    }

    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f37773f = g(getIntent());
        }
    }

    public void initJsAbility(@NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, webView) == null) {
            try {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            webView.loadUrl("javascript:(function(){try{if(performance&&performance.timing){var performanceResult={};for(var key in performance.timing){if(typeof performance.timing[key]!==\"function\"){performanceResult[key]=performance.timing[key];}}var strJson=JSON.stringify(performanceResult);NadJsControl.getPerformanceTiming(strJson);}}catch(e){}})();");
            this.f37775h.p(webView);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean isAdFromOtherApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (getIntent().getExtras() == null || TextUtils.isEmpty(getIntent().getExtras().getString("other_app_back_url"))) ? false : true : invokeV.booleanValue;
    }

    public final void j(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, intent) == null) && TextUtils.equals(intent.getStringExtra("layoutfullscreen"), "1") && Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 1024 | 8192);
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(getResources().getColor(c.a.b0.g0.e.nad_transparent, null));
        }
    }

    public final void k() {
        int[] a2;
        int[] c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(c.a.b0.g0.g.titlebar_left_layout);
            if (c.a.b0.g0.p.b.i() == i.f1564b) {
                ImageView imageView = new ImageView(new ContextThemeWrapper(getActivity(), j.NadTitleBarBackBtnStyle), null, j.NadTitleBarBackBtnStyle);
                imageView.setImageResource(c.a.b0.g0.f.nad_web_back);
                linearLayout.addView(imageView);
                imageView.setOnClickListener(new a(this));
                return;
            }
            for (int i2 : c.a.b0.g0.p.b.i().a()) {
                ImageView imageView2 = new ImageView(new ContextThemeWrapper(getActivity(), j.NadTitleBarBackBtnStyle), null, j.NadTitleBarBackBtnStyle);
                imageView2.setImageResource(i2);
                imageView2.setTag(Integer.valueOf(i2));
                c.a.b0.g0.p.b.i().b(imageView2, this);
                linearLayout.addView(imageView2);
            }
            LinearLayout linearLayout2 = (LinearLayout) this.mRootView.findViewById(c.a.b0.g0.g.titlebar_right_layout);
            for (int i3 : c.a.b0.g0.p.b.i().c()) {
                ImageView imageView3 = new ImageView(new ContextThemeWrapper(getActivity(), j.NadTitleBarBackBtnStyle), null, j.NadTitleBarBackBtnStyle);
                imageView3.setImageResource(i3);
                imageView3.setTag(Integer.valueOf(i3));
                c.a.b0.g0.p.b.i().b(imageView3, this);
                linearLayout2.addView(imageView3);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void l(@NonNull Intent intent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, intent) == null) {
            String stringExtra = intent.getStringExtra("forbidautorotate");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (Build.VERSION.SDK_INT == 26) {
                d();
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
                if (f() != -1) {
                    s(-1);
                }
            } else if (c2 != 1) {
                if (c2 == 2 && f() != 0) {
                    s(0);
                }
            } else if (f() != 1) {
                s(1);
            }
        }
    }

    public void loadJavaScript(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            c.a.b0.e.g.b(new g(this, str));
        }
    }

    public void loadUrl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            c.a.b0.g0.n.a.b bVar = this.mFrameExtHandler;
            if (bVar == null || !bVar.handleLoadUrl()) {
                c.a.b0.g0.t.a aVar = this.f37775h;
                if (aVar == null || !aVar.l()) {
                    this.mWebView.loadUrl(this.f37773f);
                }
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.f37775h = new c.a.b0.g0.t.a(this);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            Intent intent = getIntent();
            l(intent);
            j(intent);
            loadUrl();
            this.f37775h.t(getActivity(), this.mRootView, this.mWebView);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            i();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048608, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.f37775h.u();
            super.onCreate();
            setContentView(View.inflate(getActivity(), h.nad_light_browser_activity, null));
            initData();
            o();
            n();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.f37775h.v();
            q();
            super.onDestroy();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048612, this, i2, keyEvent)) == null) {
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
            this.f37775h.w(intent);
            super.onNewIntent(intent);
            getActivity().setIntent(intent);
            this.mWebView.clearHistory();
            String g2 = g(intent);
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            this.f37773f = g2;
            loadUrl();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.f37775h.y();
            this.mWebView.onPause();
            c.a.b0.d0.j.a(getApplicationContext(), getWindow().getDecorView().getWindowToken());
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
            this.f37775h.A();
            super.onResume();
            this.mWebView.onResume();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.f37775h.B();
            super.onStart();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.f37775h.C();
            super.onStop();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void p(@NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, webView) == null) {
            e(getActivity());
            webView.setScrollbarFadingEnabled(true);
            webView.setVerticalScrollBarEnabled(true);
            webView.setHorizontalScrollBarEnabled(false);
            webView.getSettings().setLightTouchEnabled(false);
            webView.getSettings().setUserAgentString(c.a.b0.e.a.d());
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
            r(true);
            webView.setDownloadListener(new b(this));
            c cVar = new c(this);
            webView.setWebViewClient(new d(this, webView, null, cVar, cVar));
            webView.setWebChromeClient(new e(this));
        }
    }

    public final void q() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (webView = this.mWebView) == null) {
            return;
        }
        if (webView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mWebView.getParent()).removeView(this.mWebView);
        }
        WebView webView2 = this.mWebView;
        if (!f.b.c()) {
            new Handler().postDelayed(new f(this, webView2), 1500L);
        } else {
            try {
                webView2.destroy();
            } catch (Exception unused) {
            }
        }
        this.mWebView = null;
    }

    public final void r(boolean z) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
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

    public void resetContainer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
        }
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            getActivity().setRequestedOrientation(i2);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void setContentView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, view) == null) {
            super.setContentView(view);
            this.mRootView = (FrameLayout) view.findViewById(c.a.b0.g0.g.rootview);
            this.mWebRootView = (LinearLayout) view.findViewById(c.a.b0.g0.g.webview_container);
        }
    }

    public void setDownLoadView(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, relativeLayout) == null) {
            this.f37777j = relativeLayout;
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.f37774g = str;
        }
    }

    public void setmAdParams(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.f37776i = str;
        }
    }

    public void updateTitle(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, str) == null) || (textView = (TextView) this.mWebRootView.findViewById(c.a.b0.g0.g.tv_title)) == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void webViewGoBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            c.a.b0.d0.j.a(getApplicationContext(), getWindow().getDecorView().getWindowToken());
            if (this.mWebView.canGoBack()) {
                this.mWebView.goBack();
            } else if (c()) {
            } else {
                f.b.a().a(getActivity());
            }
        }
    }

    public void loadJavaScript(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, str, valueCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("javascript:")) {
            str = "javascript:" + str;
        }
        this.mWebView.evaluateJavascript(str, valueCallback);
    }

    public void loadUrl(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, map) == null) {
            this.mWebView.loadUrl(this.f37773f, map);
        }
    }
}
