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
import com.repackage.d21;
import com.repackage.e21;
import com.repackage.eh0;
import com.repackage.g21;
import com.repackage.g31;
import com.repackage.h21;
import com.repackage.hh0;
import com.repackage.j21;
import com.repackage.j31;
import com.repackage.l21;
import com.repackage.m21;
import com.repackage.og0;
import com.repackage.q01;
import com.repackage.qg0;
import com.repackage.r01;
import com.repackage.t21;
import com.repackage.u01;
import com.repackage.uh0;
import com.repackage.yx0;
import com.repackage.z21;
import com.repackage.zg0;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaseNativeBrowserContainer extends AbsContainer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e21 d;
    public FrameLayout e;
    public LinearLayout f;
    public WebView g;
    public String h;
    public String i;
    public z21 j;
    public String k;
    public RelativeLayout l;
    public BrowserStateView m;
    public boolean n;
    public boolean o;
    public boolean p;
    public View.OnClickListener q;

    /* loaded from: classes2.dex */
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
                this.a.P(str, str2, str3, str4, j);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements zg0 {
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

        @Override // com.repackage.zg0
        public void a(boolean z, @Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) {
                String p = eh0.p(map);
                if (TextUtils.isEmpty(p)) {
                    return;
                }
                this.a.l(p);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends j31 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zg0 c;
        public final /* synthetic */ BaseNativeBrowserContainer d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BaseNativeBrowserContainer baseNativeBrowserContainer, WebView webView, WebViewClient webViewClient, zg0 zg0Var, zg0 zg0Var2) {
            super(webView, webViewClient, zg0Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer, webView, webViewClient, zg0Var, zg0Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WebView) objArr2[0], (WebViewClient) objArr2[1], (zg0) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = baseNativeBrowserContainer;
            this.c = zg0Var2;
        }

        @Override // com.repackage.j31, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.d.q0(webView.getTitle());
                Object tag = webView.getTag(R.id.obfuscated_res_0x7f09155d);
                int intValue = tag == null ? 0 : ((Integer) tag).intValue();
                if (TextUtils.equals(str, this.d.h) || TextUtils.equals(webView.getOriginalUrl(), this.d.h) || (str != null && str.contains(this.d.h))) {
                    if (intValue != 0 && intValue != -1) {
                        this.d.o0(intValue);
                    } else {
                        this.d.g0();
                    }
                }
                this.d.S();
                this.d.j.x(str);
            }
        }

        @Override // com.repackage.j31, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.d.o) {
                    webView.setTag(R.id.obfuscated_res_0x7f09155d, 0);
                }
                this.d.o = false;
                WebView webView2 = this.d.g;
                if (webView2 != null && !webView2.canGoBack() && !this.d.g.canGoForward()) {
                    this.d.p0();
                }
                this.d.j.y(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                webView.setTag(R.id.obfuscated_res_0x7f09155d, Integer.valueOf(i));
                this.d.j.A(webView, i, str, str2);
            }
        }

        @Override // com.repackage.j31, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                String d = g31.d(str);
                if (TextUtils.isEmpty(d) || !(d.startsWith("http://") || d.startsWith("https://") || d.startsWith("ftp://") || d.startsWith("sftp://") || d.startsWith("ftps://"))) {
                    this.d.o = true;
                    if (this.d.j.G(webView, this.d.M(), str) || og0.b(this.d.getActivity(), str, false) || m21.b.a().a(this.d.getActivity(), str, webView.getUrl(), this.c) || qg0.c(str, this.d.getActivity())) {
                        return true;
                    }
                    this.d.p0();
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onReceivedTitle(webView, str);
                this.a.j.B(str);
                this.a.q0(webView.getTitle());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;
        public final /* synthetic */ BaseNativeBrowserContainer b;

        public e(BaseNativeBrowserContainer baseNativeBrowserContainer, WebView webView) {
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
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ BaseNativeBrowserContainer b;

        public f(BaseNativeBrowserContainer baseNativeBrowserContainer, String str) {
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
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseNativeBrowserContainer a;

        public g(BaseNativeBrowserContainer baseNativeBrowserContainer) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && NetUtil.a(hh0.b())) {
                this.a.h0();
                this.a.p0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNativeBrowserContainer(d21 d21Var, e21 e21Var) {
        super(d21Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d21Var, e21Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d21) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = true;
        this.o = false;
        this.p = true;
        this.q = new g(this);
        this.d = e21Var;
        a0();
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (h().getExtras() == null || !k()) {
                return false;
            }
            h().removeExtra("other_app_back_url");
            return true;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"JavascriptInterface"})
    public void F(Object obj, String str) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, str) == null) || (webView = this.g) == null) {
            return;
        }
        webView.addJavascriptInterface(obj, str);
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (getActivity() instanceof BaseActivity)) {
            ((BaseActivity) getActivity()).setCurrentActivityNoTransparent();
        }
    }

    public final void H(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, context) == null) && Build.VERSION.SDK_INT == 17 && context != null) {
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

    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j.l() : (String) invokeV.objValue;
    }

    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public final int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getActivity().getRequestedOrientation() : invokeV.intValue;
    }

    public FrameLayout L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e : (FrameLayout) invokeV.objValue;
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            WebView webView = this.g;
            if (webView == null) {
                return "";
            }
            String url = webView.getUrl();
            return !TextUtils.isEmpty(url) ? url : !TextUtils.isEmpty(this.h) ? this.h : "";
        }
        return (String) invokeV.objValue;
    }

    public LinearLayout N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f : (LinearLayout) invokeV.objValue;
    }

    public final String O(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, intent)) == null) {
            String stringExtra = intent.getStringExtra("url");
            if (TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(I())) {
                stringExtra = I();
            }
            String d2 = g31.d(stringExtra);
            return (TextUtils.isEmpty(d2) || !g31.g(g31.b(d2))) ? "" : d2;
        }
        return (String) invokeL.objValue;
    }

    public final void P(String str, String str2, String str3, String str4, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) && r01.b(r01.c(r01.e(str, str3, str4)), str4) == 3) {
            JSONObject c2 = yx0.c(this.k);
            yx0.f(c2, "url", str);
            yx0.e(c2, BreakpointSQLiteKey.CONTENT_LENGTH, j);
            h21.b().b(getActivity(), this.l, c2.toString());
        }
    }

    public boolean Q(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.m.a(BrowserStateView.ViewState.ERROR);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.a(BrowserStateView.ViewState.LOADING);
        }
    }

    public FrameLayout T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(getActivity());
            BrowserStateView browserStateView = new BrowserStateView(getActivity());
            this.m = browserStateView;
            browserStateView.setErrorViewClickListener(this.q);
            WebView a2 = g21.a().a(getActivity());
            this.g = a2;
            frameLayout.addView(a2, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(this.m, new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f.addView(T(), new LinearLayout.LayoutParams(-1, -1));
            d0(this.g);
            X(this.g);
            if (this.b) {
                Y();
            } else {
                this.e.findViewById(R.id.obfuscated_res_0x7f0920f2).setVisibility(8);
            }
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.h = O(h());
        }
    }

    public final void W(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, intent) == null) && TextUtils.equals(intent.getStringExtra("layoutfullscreen"), "1") && Build.VERSION.SDK_INT >= 23) {
            j().getDecorView().setSystemUiVisibility(j().getDecorView().getSystemUiVisibility() | 1024 | 8192);
            j().addFlags(Integer.MIN_VALUE);
            j().setStatusBarColor(getResources().getColor(R.color.obfuscated_res_0x7f060847, null));
        }
    }

    public void X(@NonNull WebView webView) {
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
            this.j.q(getActivity(), webView);
        }
    }

    public final void Y() {
        int[] a2;
        int[] c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.e.findViewById(R.id.obfuscated_res_0x7f0920f2).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f0920f6);
            for (int i : h21.i().a()) {
                ImageView imageView = new ImageView(new ContextThemeWrapper(getActivity(), (int) R.style.obfuscated_res_0x7f100134), null, R.style.obfuscated_res_0x7f100134);
                imageView.setImageResource(i);
                imageView.setTag(Integer.valueOf(i));
                h21.i().b(imageView, this);
                linearLayout.addView(imageView);
            }
            LinearLayout linearLayout2 = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f0920fe);
            for (int i2 : h21.i().c()) {
                ImageView imageView2 = new ImageView(new ContextThemeWrapper(getActivity(), (int) R.style.obfuscated_res_0x7f100134), null, R.style.obfuscated_res_0x7f100134);
                imageView2.setImageResource(i2);
                imageView2.setTag(Integer.valueOf(i2));
                h21.i().b(imageView2, this);
                linearLayout2.addView(imageView2);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void Z(@NonNull Intent intent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, intent) == null) {
            String stringExtra = intent.getStringExtra("forbidautorotate");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (Build.VERSION.SDK_INT == 26) {
                G();
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
                if (K() != -1) {
                    l0(-1);
                }
            } else if (c2 != 1) {
                if (c2 == 2 && K() != 0) {
                    l0(0);
                }
            } else if (K() != 1) {
                l0(1);
            }
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) ? this.g != null && this.p : invokeL.booleanValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.j = new z21(this);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            Intent h = h();
            Z(h);
            W(h);
            m0(!"true".equals(h().getStringExtra("hide_state_view")));
            e0();
            this.j.u(getActivity(), this.e, this.g);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.c();
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            U();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void d0(@NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, webView) == null) {
            H(getActivity());
            webView.setScrollbarFadingEnabled(true);
            webView.setVerticalScrollBarEnabled(true);
            webView.setHorizontalScrollBarEnabled(false);
            webView.getSettings().setLightTouchEnabled(false);
            webView.getSettings().setUserAgentString(hh0.e());
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
            j0(true);
            webView.setDownloadListener(new a(this));
            b bVar = new b(this);
            webView.setWebViewClient(new c(this, webView, null, bVar, bVar));
            webView.setWebChromeClient(new d(this));
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public t21 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.j.i() : (t21) invokeV.objValue;
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            e21 e21Var = this.d;
            if (e21Var == null || !e21Var.h0()) {
                z21 z21Var = this.j;
                if (z21Var == null || !z21Var.m()) {
                    this.o = true;
                    WebView webView = this.g;
                    if (webView != null) {
                        webView.loadUrl(this.h);
                    }
                }
            }
        }
    }

    public void f0(Map<String, String> map) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, map) == null) || (webView = this.g) == null) {
            return;
        }
        webView.loadUrl(this.h, map);
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            S();
            R();
        }
    }

    public void h0() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (webView = this.g) == null) {
            return;
        }
        webView.reload();
        this.o = true;
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public int i() {
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

    public final void i0() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (webView = this.g) == null) {
            return;
        }
        if (webView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.g.getParent()).removeView(this.g);
        }
        WebView webView2 = this.g;
        if (!q01.b.c()) {
            new Handler().postDelayed(new e(this, webView2), 1500L);
        } else {
            try {
                webView2.destroy();
            } catch (Exception unused) {
            }
        }
        this.g = null;
    }

    public final void j0(boolean z) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
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
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? (h().getExtras() == null || TextUtils.isEmpty(h().getExtras().getString("other_app_back_url"))) ? false : true : invokeV.booleanValue;
    }

    public void k0(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, relativeLayout) == null) {
            this.l = relativeLayout;
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            uh0.b(new f(this, str));
        }
    }

    public final void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            getActivity().setRequestedOrientation(i);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.j.v();
            super.m();
            u(View.inflate(getActivity(), R.layout.obfuscated_res_0x7f0d05b7, null));
            V();
            c0();
            b0();
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.n = z;
            BrowserStateView browserStateView = this.m;
            if (browserStateView != null) {
                browserStateView.setVisibility(z ? 0 : 8);
            }
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.j.w();
            i0();
            super.n();
        }
    }

    public void n0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.k = str;
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.j.z();
            this.g.onPause();
            u01.a(f(), j().getDecorView().getWindowToken());
            super.o();
        }
    }

    public final void o0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            if (i == 0) {
                R();
                return;
            }
            if (this.n) {
                this.m.setVisibility(0);
            }
            this.m.e(BrowserStateView.ViewState.ERROR);
            this.m.a(BrowserStateView.ViewState.LOADING);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048625, this, i, keyEvent)) == null) {
            if (j21.b.a().a(i) || Q(i, keyEvent)) {
                return true;
            }
            if (i == 4) {
                x();
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
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.g.freeMemory();
            super.onLowMemory();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048627, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            if (this.n) {
                this.m.setVisibility(0);
            }
            this.m.e(BrowserStateView.ViewState.LOADING);
            this.m.a(BrowserStateView.ViewState.ERROR);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.j.C();
            super.q();
            this.g.onResume();
            this.g.resumeTimers();
        }
    }

    public void q0(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, str) == null) || (textView = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0922a1)) == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.j.D();
            super.r();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.j.E();
            super.s();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void u(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, view2) == null) {
            super.u(view2);
            this.e = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b73);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0924cc);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.i = str;
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            u01.a(f(), j().getDecorView().getWindowToken());
            if (this.g.canGoBack()) {
                this.g.goBack();
            } else if (E()) {
            } else {
                l21.b.a().a(getActivity());
            }
        }
    }
}
