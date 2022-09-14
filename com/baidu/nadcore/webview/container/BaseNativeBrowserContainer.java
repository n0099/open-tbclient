package com.baidu.nadcore.webview.container;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.webarch.NadLongPressView;
import com.baidu.nadcore.webview.BrowserStateView;
import com.baidu.nadcore.webview.container.base.AbsContainer;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.tieba.R;
import com.baidu.tieba.a31;
import com.baidu.tieba.a41;
import com.baidu.tieba.aj0;
import com.baidu.tieba.d41;
import com.baidu.tieba.e51;
import com.baidu.tieba.ei0;
import com.baidu.tieba.g21;
import com.baidu.tieba.i21;
import com.baidu.tieba.ji0;
import com.baidu.tieba.kz0;
import com.baidu.tieba.l21;
import com.baidu.tieba.l41;
import com.baidu.tieba.m41;
import com.baidu.tieba.mi0;
import com.baidu.tieba.n11;
import com.baidu.tieba.n51;
import com.baidu.tieba.o41;
import com.baidu.tieba.p41;
import com.baidu.tieba.q51;
import com.baidu.tieba.r41;
import com.baidu.tieba.r51;
import com.baidu.tieba.t41;
import com.baidu.tieba.th0;
import com.baidu.tieba.vh0;
import com.baidu.tieba.x31;
import com.baidu.tieba.z41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaseNativeBrowserContainer extends AbsContainer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m41 d;
    public FrameLayout e;
    public LinearLayout f;
    public WebView g;
    public String h;
    public String i;
    public e51 j;
    public String k;
    public RelativeLayout l;
    public BrowserStateView m;
    public boolean n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;

    /* loaded from: classes2.dex */
    public class a implements NadLongPressView.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseNativeBrowserContainer;
        }

        @Override // com.baidu.nadcore.webarch.NadLongPressView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a31 a = a31.a(this.a.getActivity());
                a.b("老架构，url = " + this.a.h);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseNativeBrowserContainer;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) {
                this.a.S(str, str2, str3, str4, j);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ei0 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseNativeBrowserContainer;
        }

        @Override // com.baidu.tieba.ei0
        public void a(boolean z, @Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) {
                String p = ji0.p(map);
                if (TextUtils.isEmpty(p)) {
                    return;
                }
                this.a.n(p);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends r51 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ei0 c;
        public final /* synthetic */ BaseNativeBrowserContainer d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(BaseNativeBrowserContainer baseNativeBrowserContainer, WebView webView, WebViewClient webViewClient, ei0 ei0Var, ei0 ei0Var2) {
            super(webView, webViewClient, ei0Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer, webView, webViewClient, ei0Var, ei0Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WebView) objArr2[0], (WebViewClient) objArr2[1], (ei0) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = baseNativeBrowserContainer;
            this.c = ei0Var2;
        }

        @Override // com.baidu.tieba.r51, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.d.u0(webView.getTitle());
                Object tag = webView.getTag(R.id.obfuscated_res_0x7f09161f);
                int intValue = tag == null ? 0 : ((Integer) tag).intValue();
                if (TextUtils.equals(str, this.d.h) || TextUtils.equals(webView.getOriginalUrl(), this.d.h) || (str != null && str.contains(this.d.h))) {
                    if (intValue != 0 && intValue != -1) {
                        this.d.r0(intValue);
                    } else {
                        this.d.j0();
                    }
                }
                this.d.V();
                this.d.j.x(str);
            }
        }

        @Override // com.baidu.tieba.r51, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.d.o) {
                    webView.setTag(R.id.obfuscated_res_0x7f09161f, 0);
                }
                this.d.o = false;
                WebView webView2 = this.d.g;
                if (webView2 != null && !webView2.canGoBack() && !this.d.g.canGoForward()) {
                    this.d.s0();
                }
                this.d.j.y(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                webView.setTag(R.id.obfuscated_res_0x7f09161f, Integer.valueOf(i));
                this.d.j.A(webView, i, str, str2);
            }
        }

        @Override // com.baidu.tieba.r51, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                String d = n51.d(str);
                if (TextUtils.isEmpty(d) || !(d.startsWith("http://") || d.startsWith("https://") || d.startsWith("ftp://") || d.startsWith("sftp://") || d.startsWith("ftps://"))) {
                    this.d.o = true;
                    if (this.d.j.G(webView, this.d.P(), str) || th0.b(this.d.getActivity(), str, false) || x31.b.a().a(this.d.getActivity(), str, webView.getUrl(), this.c) || vh0.c(str, this.d.getActivity())) {
                        return true;
                    }
                    this.d.s0();
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e extends q51 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseNativeBrowserContainer c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(BaseNativeBrowserContainer baseNativeBrowserContainer, Context context, BaseNativeBrowserContainer baseNativeBrowserContainer2) {
            super(context, baseNativeBrowserContainer2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer, context, baseNativeBrowserContainer2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (BaseNativeBrowserContainer) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = baseNativeBrowserContainer;
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                this.c.j.B(str);
                this.c.u0(webView.getTitle());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;
        public final /* synthetic */ BaseNativeBrowserContainer b;

        public f(BaseNativeBrowserContainer baseNativeBrowserContainer, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = baseNativeBrowserContainer;
            this.a = webView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.destroy();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ BaseNativeBrowserContainer b;

        public g(BaseNativeBrowserContainer baseNativeBrowserContainer, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = baseNativeBrowserContainer;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.a;
                if (!str.startsWith("javascript:")) {
                    str = "javascript:" + str;
                }
                WebView webView = this.b.g;
                if (webView != null) {
                    webView.loadUrl(str);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseNativeBrowserContainer a;

        public h(BaseNativeBrowserContainer baseNativeBrowserContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseNativeBrowserContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && NetUtil.a(mi0.b())) {
                this.a.k0();
                this.a.s0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNativeBrowserContainer(l41 l41Var, m41 m41Var) {
        super(l41Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l41Var, m41Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l41) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = true;
        this.o = false;
        this.p = true;
        this.q = new h(this);
        this.d = m41Var;
        d0();
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            l21.a(h(), l().getDecorView().getWindowToken());
            if (this.g.canGoBack()) {
                this.g.goBack();
            } else if (H()) {
            } else {
                t41.b.a().a(getActivity());
            }
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (j().getExtras() == null || !m()) {
                return false;
            }
            j().removeExtra("other_app_back_url");
            return true;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"JavascriptInterface"})
    public void I(Object obj, String str) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, str) == null) || (webView = this.g) == null) {
            return;
        }
        webView.addJavascriptInterface(obj, str);
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (getActivity() instanceof BaseActivity)) {
            ((BaseActivity) getActivity()).setCurrentActivityNoTransparent();
        }
    }

    public final void K(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, context) == null) && Build.VERSION.SDK_INT == 17 && context != null) {
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

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j.l() : (String) invokeV.objValue;
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public final int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getActivity().getRequestedOrientation() : invokeV.intValue;
    }

    public FrameLayout O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e : (FrameLayout) invokeV.objValue;
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            WebView webView = this.g;
            if (webView == null) {
                return "";
            }
            String url = webView.getUrl();
            return !TextUtils.isEmpty(url) ? url : !TextUtils.isEmpty(this.h) ? this.h : "";
        }
        return (String) invokeV.objValue;
    }

    public LinearLayout Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f : (LinearLayout) invokeV.objValue;
    }

    public final String R(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, intent)) == null) {
            String stringExtra = intent.getStringExtra("url");
            if (TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(L())) {
                stringExtra = L();
            }
            String d2 = n51.d(stringExtra);
            return (TextUtils.isEmpty(d2) || !n51.g(n51.b(d2))) ? "" : d2;
        }
        return (String) invokeL.objValue;
    }

    public final void S(String str, String str2, String str3, String str4, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) && i21.b(i21.c(i21.e(str, str3, str4)), str4) == 3) {
            JSONObject c2 = kz0.c(this.k);
            kz0.f(c2, "url", str);
            kz0.e(c2, BreakpointSQLiteKey.CONTENT_LENGTH, j);
            a41.a().b(getActivity(), this.l, c2.toString());
        }
    }

    public boolean T(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.a(BrowserStateView.ViewState.ERROR);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.m.a(BrowserStateView.ViewState.LOADING);
        }
    }

    public FrameLayout W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(getActivity());
            BrowserStateView browserStateView = new BrowserStateView(getActivity());
            this.m = browserStateView;
            browserStateView.setErrorViewClickListener(this.q);
            WebView a2 = o41.a().a(getActivity());
            this.g = a2;
            frameLayout.addView(a2, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(this.m, new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f.addView(W(), new LinearLayout.LayoutParams(-1, -1));
            g0(this.g);
            a0(this.g);
            if (this.b) {
                b0();
            } else {
                this.e.findViewById(R.id.obfuscated_res_0x7f09224c).setVisibility(8);
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.h = R(j());
        }
    }

    public final void Z(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, intent) == null) && TextUtils.equals(intent.getStringExtra("layoutfullscreen"), "1") && Build.VERSION.SDK_INT >= 23) {
            l().getDecorView().setSystemUiVisibility(l().getDecorView().getSystemUiVisibility() | 1024 | 8192);
            l().addFlags(Integer.MIN_VALUE);
            l().setStatusBarColor(getResources().getColor(R.color.obfuscated_res_0x7f060876, null));
        }
    }

    public void a0(@NonNull WebView webView) {
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
            this.j.q(getActivity(), webView);
        }
    }

    public final void b0() {
        int[] b2;
        int[] c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.e.findViewById(R.id.obfuscated_res_0x7f09224c).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f092251);
            for (int i : p41.h().b()) {
                ImageView imageView = new ImageView(new ContextThemeWrapper(getActivity(), (int) R.style.obfuscated_res_0x7f100137), null, R.style.obfuscated_res_0x7f100137);
                imageView.setImageResource(i);
                imageView.setTag(Integer.valueOf(i));
                p41.h().a(imageView, this);
                linearLayout.addView(imageView);
            }
            LinearLayout linearLayout2 = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f092259);
            for (int i2 : p41.h().c()) {
                NadLongPressView nadLongPressView = new NadLongPressView(new ContextThemeWrapper(getActivity(), (int) R.style.obfuscated_res_0x7f100137), null, R.style.obfuscated_res_0x7f100137);
                nadLongPressView.setImageResource(i2);
                nadLongPressView.setTag(Integer.valueOf(i2));
                p41.h().a(nadLongPressView, this);
                nadLongPressView.setHandler(new a(this));
                linearLayout2.addView(nadLongPressView);
            }
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) ? this.g != null && this.p : invokeL.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void c0(@NonNull Intent intent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, intent) == null) {
            String stringExtra = intent.getStringExtra("forbidautorotate");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (Build.VERSION.SDK_INT == 26) {
                J();
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
                if (N() != -1) {
                    o0(-1);
                }
            } else if (c2 != 1) {
                if (c2 == 2 && N() != 0) {
                    o0(0);
                }
            } else if (N() != 1) {
                o0(1);
            }
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.j = new e51(this);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.e();
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            Intent j = j();
            c0(j);
            Z(j);
            p0(!"true".equals(j().getStringExtra("hide_state_view")));
            h0();
            this.j.u(getActivity(), this.e, this.g);
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            X();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public z41 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.j.i() : (z41) invokeV.objValue;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void g0(@NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, webView) == null) {
            K(getActivity());
            webView.setScrollbarFadingEnabled(true);
            webView.setVerticalScrollBarEnabled(true);
            webView.setHorizontalScrollBarEnabled(false);
            webView.getSettings().setLightTouchEnabled(false);
            webView.getSettings().setUserAgentString(mi0.e());
            webView.getSettings().setDefaultTextEncodingName("UTF-8");
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setAllowFileAccess(false);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setPluginState(WebSettings.PluginState.ON);
            webView.getSettings().setCacheMode(-1);
            webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            webView.getSettings().setAllowContentAccess(true);
            if (Build.VERSION.SDK_INT >= 21) {
                webView.getSettings().setMixedContentMode(0);
            }
            webView.getSettings().setLoadsImagesAutomatically(true);
            getActivity().getWindow().setFlags(16777216, 16777216);
            webView.getSettings().setDomStorageEnabled(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.clearFocus();
            webView.clearHistory();
            webView.clearView();
            webView.setScrollBarStyle(0);
            m0(true);
            webView.setDownloadListener(new b(this));
            c cVar = new c(this);
            webView.setWebViewClient(new d(this, webView, null, cVar, cVar));
            webView.setWebChromeClient(new e(this, getActivity(), this));
        }
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            m41 m41Var = this.d;
            if (m41Var == null || !m41Var.D0()) {
                e51 e51Var = this.j;
                if (e51Var == null || !e51Var.m()) {
                    this.o = true;
                    WebView webView = this.g;
                    if (webView != null) {
                        webView.loadUrl(this.h);
                    }
                }
            }
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public void i0(Map<String, String> map) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, map) == null) || (webView = this.g) == null) {
            return;
        }
        webView.loadUrl(this.h, map);
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            V();
            U();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            WebView webView = this.g;
            if (webView != null) {
                return webView.getScrollY();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void k0() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (webView = this.g) == null) {
            return;
        }
        webView.reload();
        this.o = true;
    }

    public final void l0() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (webView = this.g) == null) {
            return;
        }
        if (webView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.g.getParent()).removeView(this.g);
        }
        WebView webView2 = this.g;
        if (!g21.b.c()) {
            new Handler().postDelayed(new f(this, webView2), 1500L);
        } else {
            try {
                webView2.destroy();
            } catch (Exception unused) {
            }
        }
        this.g = null;
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? (j().getExtras() == null || TextUtils.isEmpty(j().getExtras().getString("other_app_back_url"))) ? false : true : invokeV.booleanValue;
    }

    public final void m0(boolean z) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
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
            cookieManager.setAcceptThirdPartyCookies(this.g, z);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            aj0.b(new g(this, str));
        }
    }

    public void n0(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, relativeLayout) == null) {
            this.l = relativeLayout;
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void o(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048618, this, i, i2, intent) == null) {
            d41.c().g(getActivity(), i, i2, intent);
            super.o(i, i2, intent);
        }
    }

    public final void o0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            getActivity().setRequestedOrientation(i);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048621, this, i, keyEvent)) == null) {
            if (r41.b.a().a(i) || T(i, keyEvent)) {
                return true;
            }
            if (i == 4) {
                A();
                return true;
            } else if (this.g.onKeyDown(i, keyEvent)) {
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.g.freeMemory();
            super.onLowMemory();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048623, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.j.v();
            d41.c().d(getActivity());
            super.p();
            x(View.inflate(getActivity(), R.layout.obfuscated_res_0x7f0d05f8, null));
            Y();
            f0();
            e0();
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.n = z;
            BrowserStateView browserStateView = this.m;
            if (browserStateView != null) {
                browserStateView.setVisibility(z ? 0 : 8);
            }
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.j.w();
            d41.c().f(getActivity());
            l0();
            super.q();
        }
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.k = str;
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.j.z();
            this.g.onPause();
            l21.a(h(), l().getDecorView().getWindowToken());
            super.r();
        }
    }

    public final void r0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            if (i == 0) {
                U();
                return;
            }
            if (this.n) {
                this.m.setVisibility(0);
            }
            this.m.e(BrowserStateView.ViewState.ERROR);
            this.m.a(BrowserStateView.ViewState.LOADING);
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (this.n) {
                this.m.setVisibility(0);
            }
            this.m.e(BrowserStateView.ViewState.LOADING);
            this.m.a(BrowserStateView.ViewState.ERROR);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.j.C();
            super.t();
            this.g.onResume();
            this.g.resumeTimers();
        }
    }

    @TargetApi(23)
    public void t0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048632, this) == null) && g21.b.d()) {
            if (getActivity().checkSelfPermission(PermissionRequest.RESOURCE_AUDIO_CAPTURE) == 0 && getActivity().checkSelfPermission(PermissionRequest.RESOURCE_VIDEO_CAPTURE) == 0) {
                return;
            }
            n11.a().a(getActivity(), R.string.obfuscated_res_0x7f0f090b);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            this.j.D();
            super.u();
        }
    }

    public void u0(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048634, this, str) == null) || (textView = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f092417)) == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.j.E();
            super.v();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, view2) == null) {
            super.x(view2);
            this.e = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c82);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092659);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, str) == null) {
            this.i = str;
        }
    }
}
