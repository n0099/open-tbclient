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
import com.repackage.c11;
import com.repackage.d11;
import com.repackage.e31;
import com.repackage.ei0;
import com.repackage.g11;
import com.repackage.hi0;
import com.repackage.j31;
import com.repackage.o21;
import com.repackage.oh0;
import com.repackage.p21;
import com.repackage.q31;
import com.repackage.qh0;
import com.repackage.r21;
import com.repackage.s21;
import com.repackage.si0;
import com.repackage.t31;
import com.repackage.u21;
import com.repackage.uy0;
import com.repackage.w21;
import com.repackage.x21;
import com.repackage.zh0;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BaseNativeBrowserContainer extends AbsContainer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p21 c;
    public FrameLayout d;
    public LinearLayout e;
    public WebView f;
    public String g;
    public String h;
    public j31 i;
    public String j;
    public RelativeLayout k;
    public BrowserStateView l;
    public boolean m;
    public boolean n;
    public boolean o;
    public View.OnClickListener p;

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
                this.a.N(str, str2, str3, str4, j);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements zh0 {
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

        @Override // com.repackage.zh0
        public void a(boolean z, @Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) {
                String o = ei0.o(map);
                if (TextUtils.isEmpty(o)) {
                    return;
                }
                this.a.c0(o);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends t31 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zh0 c;
        public final /* synthetic */ BaseNativeBrowserContainer d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BaseNativeBrowserContainer baseNativeBrowserContainer, WebView webView, WebViewClient webViewClient, zh0 zh0Var, zh0 zh0Var2) {
            super(webView, webViewClient, zh0Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer, webView, webViewClient, zh0Var, zh0Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WebView) objArr2[0], (WebViewClient) objArr2[1], (zh0) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = baseNativeBrowserContainer;
            this.c = zh0Var2;
        }

        @Override // com.repackage.t31, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.d.p0(webView.getTitle());
                Object tag = webView.getTag(R.id.obfuscated_res_0x7f0914e4);
                int intValue = tag == null ? 0 : ((Integer) tag).intValue();
                if (TextUtils.equals(str, this.d.g) || TextUtils.equals(webView.getOriginalUrl(), this.d.g) || (str != null && str.contains(this.d.g))) {
                    if (intValue != 0 && intValue != -1) {
                        this.d.n0(intValue);
                    } else {
                        this.d.f0();
                    }
                }
                this.d.Q();
                this.d.i.x(str);
            }
        }

        @Override // com.repackage.t31, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.d.n) {
                    webView.setTag(R.id.obfuscated_res_0x7f0914e4, 0);
                }
                this.d.n = false;
                WebView webView2 = this.d.f;
                if (webView2 != null && !webView2.canGoBack() && !this.d.f.canGoForward()) {
                    this.d.o0();
                }
                this.d.i.y(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                webView.setTag(R.id.obfuscated_res_0x7f0914e4, Integer.valueOf(i));
                this.d.i.A(webView, i, str, str2);
            }
        }

        @Override // com.repackage.t31, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                String d = q31.d(str);
                if (TextUtils.isEmpty(d) || !(d.startsWith("http://") || d.startsWith("https://") || d.startsWith("ftp://") || d.startsWith("sftp://") || d.startsWith("ftps://"))) {
                    this.d.n = true;
                    if (this.d.i.G(webView, this.d.K(), str) || oh0.b(this.d.getActivity(), str, false) || x21.b.a().a(this.d.getActivity(), str, webView.getUrl(), this.c) || qh0.c(str, this.d.getActivity())) {
                        return true;
                    }
                    this.d.o0();
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
                this.a.i.B(str);
                this.a.p0(webView.getTitle());
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
                WebView webView = this.b.f;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && NetUtil.a(hi0.b())) {
                this.a.g0();
                this.a.o0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNativeBrowserContainer(o21 o21Var, p21 p21Var) {
        super(o21Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o21Var, p21Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((o21) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = true;
        this.n = false;
        this.o = true;
        this.p = new g(this);
        this.c = p21Var;
        Y();
    }

    public final boolean C() {
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
    public void D(Object obj, String str) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, str) == null) || (webView = this.f) == null) {
            return;
        }
        webView.addJavascriptInterface(obj, str);
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (getActivity() instanceof BaseActivity)) {
            ((BaseActivity) getActivity()).setCurrentActivityNoTransparent();
        }
    }

    public final void F(Context context) {
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

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i.l() : (String) invokeV.objValue;
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public final int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getActivity().getRequestedOrientation() : invokeV.intValue;
    }

    public FrameLayout J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (FrameLayout) invokeV.objValue;
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            WebView webView = this.f;
            if (webView == null) {
                return "";
            }
            String url = webView.getUrl();
            return !TextUtils.isEmpty(url) ? url : !TextUtils.isEmpty(this.g) ? this.g : "";
        }
        return (String) invokeV.objValue;
    }

    public LinearLayout L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.e : (LinearLayout) invokeV.objValue;
    }

    public final String M(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, intent)) == null) {
            String stringExtra = intent.getStringExtra("url");
            if (TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(G())) {
                stringExtra = G();
            }
            String d2 = q31.d(stringExtra);
            return (TextUtils.isEmpty(d2) || !q31.g(q31.b(d2))) ? "" : d2;
        }
        return (String) invokeL.objValue;
    }

    public final void N(String str, String str2, String str3, String str4, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) && d11.b(d11.c(d11.e(str, str3, str4)), str4) == 3) {
            JSONObject c2 = uy0.c(this.j);
            uy0.f(c2, "url", str);
            uy0.e(c2, BreakpointSQLiteKey.CONTENT_LENGTH, j);
            s21.b().b(getActivity(), this.k, c2.toString());
        }
    }

    public boolean O(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.l.a(BrowserStateView.ViewState.ERROR);
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.l.a(BrowserStateView.ViewState.LOADING);
        }
    }

    public FrameLayout R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(getActivity());
            BrowserStateView browserStateView = new BrowserStateView(getActivity());
            this.l = browserStateView;
            browserStateView.setErrorViewClickListener(this.p);
            WebView a2 = r21.a().a(getActivity());
            this.f = a2;
            frameLayout.addView(a2, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(this.l, new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.e.addView(R(), new LinearLayout.LayoutParams(-1, -1));
            b0(this.f);
            V(this.f);
            if (this.b) {
                W();
            } else {
                this.d.findViewById(R.id.obfuscated_res_0x7f092049).setVisibility(8);
            }
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.g = M(h());
        }
    }

    public final void U(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, intent) == null) && TextUtils.equals(intent.getStringExtra("layoutfullscreen"), "1") && Build.VERSION.SDK_INT >= 23) {
            j().getDecorView().setSystemUiVisibility(j().getDecorView().getSystemUiVisibility() | 1024 | 8192);
            j().addFlags(Integer.MIN_VALUE);
            j().setStatusBarColor(getResources().getColor(R.color.obfuscated_res_0x7f060847, null));
        }
    }

    public void V(@NonNull WebView webView) {
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
            this.i.q(getActivity(), webView);
        }
    }

    public final void W() {
        int[] a2;
        int[] c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.d.findViewById(R.id.obfuscated_res_0x7f092049).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09204d);
            for (int i : s21.i().a()) {
                ImageView imageView = new ImageView(new ContextThemeWrapper(getActivity(), (int) R.style.obfuscated_res_0x7f100133), null, R.style.obfuscated_res_0x7f100133);
                imageView.setImageResource(i);
                imageView.setTag(Integer.valueOf(i));
                s21.i().b(imageView, this);
                linearLayout.addView(imageView);
            }
            LinearLayout linearLayout2 = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092055);
            for (int i2 : s21.i().c()) {
                ImageView imageView2 = new ImageView(new ContextThemeWrapper(getActivity(), (int) R.style.obfuscated_res_0x7f100133), null, R.style.obfuscated_res_0x7f100133);
                imageView2.setImageResource(i2);
                imageView2.setTag(Integer.valueOf(i2));
                s21.i().b(imageView2, this);
                linearLayout2.addView(imageView2);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void X(@NonNull Intent intent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, intent) == null) {
            String stringExtra = intent.getStringExtra("forbidautorotate");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (Build.VERSION.SDK_INT == 26) {
                E();
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
                if (I() != -1) {
                    k0(-1);
                }
            } else if (c2 != 1) {
                if (c2 == 2 && I() != 0) {
                    k0(0);
                }
            } else if (I() != 1) {
                k0(1);
            }
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.i = new j31(this);
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Intent h = h();
            X(h);
            U(h);
            l0(!"true".equals(h().getStringExtra("hide_state_view")));
            d0();
            this.i.u(getActivity(), this.d, this.f);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) ? this.f != null && this.o : invokeL.booleanValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            S();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void b0(@NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, webView) == null) {
            F(getActivity());
            webView.setScrollbarFadingEnabled(true);
            webView.setVerticalScrollBarEnabled(true);
            webView.setHorizontalScrollBarEnabled(false);
            webView.getSettings().setLightTouchEnabled(false);
            webView.getSettings().setUserAgentString(hi0.e());
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
            i0(true);
            webView.setDownloadListener(new a(this));
            b bVar = new b(this);
            webView.setWebViewClient(new c(this, webView, null, bVar, bVar));
            webView.setWebChromeClient(new d(this));
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.c();
        }
    }

    public void c0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            si0.b(new f(this, str));
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            p21 p21Var = this.c;
            if (p21Var == null || !p21Var.handleLoadUrl()) {
                j31 j31Var = this.i;
                if (j31Var == null || !j31Var.m()) {
                    this.n = true;
                    WebView webView = this.f;
                    if (webView != null) {
                        webView.loadUrl(this.g);
                    }
                }
            }
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public e31 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.i.i() : (e31) invokeV.objValue;
    }

    public void e0(Map<String, String> map) {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, map) == null) || (webView = this.f) == null) {
            return;
        }
        webView.loadUrl(this.g, map);
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            Q();
            P();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public void g0() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (webView = this.f) == null) {
            return;
        }
        webView.reload();
        this.n = true;
    }

    public final void h0() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || (webView = this.f) == null) {
            return;
        }
        if (webView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f.getParent()).removeView(this.f);
        }
        WebView webView2 = this.f;
        if (!c11.b.c()) {
            new Handler().postDelayed(new e(this, webView2), 1500L);
        } else {
            try {
                webView2.destroy();
            } catch (Exception unused) {
            }
        }
        this.f = null;
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            WebView webView = this.f;
            if (webView != null) {
                return webView.getScrollY();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void i0(boolean z) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
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
            cookieManager.setAcceptThirdPartyCookies(this.f, z);
        }
    }

    public void j0(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, relativeLayout) == null) {
            this.k = relativeLayout;
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? (h().getExtras() == null || TextUtils.isEmpty(h().getExtras().getString("other_app_back_url"))) ? false : true : invokeV.booleanValue;
    }

    public final void k0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            getActivity().setRequestedOrientation(i);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.i.v();
            super.l();
            s(View.inflate(getActivity(), R.layout.obfuscated_res_0x7f0d05b6, null));
            T();
            a0();
            Z();
        }
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.m = z;
            BrowserStateView browserStateView = this.l;
            if (browserStateView != null) {
                browserStateView.setVisibility(z ? 0 : 8);
            }
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.i.w();
            h0();
            super.m();
        }
    }

    public void m0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.j = str;
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.i.z();
            this.f.onPause();
            g11.a(f(), j().getDecorView().getWindowToken());
            super.n();
        }
    }

    public final void n0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            if (i == 0) {
                P();
                return;
            }
            if (this.m) {
                this.l.setVisibility(0);
            }
            this.l.e(BrowserStateView.ViewState.ERROR);
            this.l.a(BrowserStateView.ViewState.LOADING);
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (this.m) {
                this.l.setVisibility(0);
            }
            this.l.e(BrowserStateView.ViewState.LOADING);
            this.l.a(BrowserStateView.ViewState.ERROR);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048626, this, i, keyEvent)) == null) {
            if (u21.b.a().a(i) || O(i, keyEvent)) {
                return true;
            }
            if (i == 4) {
                v();
                return true;
            } else if (this.f.onKeyDown(i, keyEvent)) {
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
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.f.freeMemory();
            super.onLowMemory();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048628, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.i.C();
            super.p();
            this.f.onResume();
            this.f.resumeTimers();
        }
    }

    public void p0(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, str) == null) || (textView = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f092202)) == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.i.D();
            super.q();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.i.E();
            super.r();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, view2) == null) {
            super.s(view2);
            this.d = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091adf);
            this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092429);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, str) == null) {
            this.h = str;
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            g11.a(f(), j().getDecorView().getWindowToken());
            if (this.f.canGoBack()) {
                this.f.goBack();
            } else if (C()) {
            } else {
                w21.b.a().a(getActivity());
            }
        }
    }
}
