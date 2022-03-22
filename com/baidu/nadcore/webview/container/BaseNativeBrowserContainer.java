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
import c.a.a0.h.k;
import c.a.a0.h0.f;
import c.a.a0.h0.j;
import c.a.a0.k0.i.d;
import c.a.a0.k0.i.f;
import c.a.a0.k0.i.g;
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

    /* renamed from: c  reason: collision with root package name */
    public c.a.a0.k0.g.a.b f27725c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f27726d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f27727e;

    /* renamed from: f  reason: collision with root package name */
    public WebView f27728f;

    /* renamed from: g  reason: collision with root package name */
    public String f27729g;

    /* renamed from: h  reason: collision with root package name */
    public String f27730h;
    public c.a.a0.k0.n.a i;
    public String j;
    public RelativeLayout k;
    public BrowserStateView l;
    public boolean m;
    public boolean n;
    public boolean o;
    public View.OnClickListener p;

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
                this.a.I(str, str2, str3, str4, j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.a0.g.g.d {
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

        @Override // c.a.a0.g.g.d
        public void a(boolean z, @Nullable Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, map) == null) {
                String o = c.a.a0.g.h.d.o(map);
                if (TextUtils.isEmpty(o)) {
                    return;
                }
                this.a.X(o);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends c.a.a0.k0.r.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.a0.g.g.d f27731c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BaseNativeBrowserContainer f27732d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BaseNativeBrowserContainer baseNativeBrowserContainer, WebView webView, WebViewClient webViewClient, c.a.a0.g.g.d dVar, c.a.a0.g.g.d dVar2) {
            super(webView, webViewClient, dVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseNativeBrowserContainer, webView, webViewClient, dVar, dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((WebView) objArr2[0], (WebViewClient) objArr2[1], (c.a.a0.g.g.d) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27732d = baseNativeBrowserContainer;
            this.f27731c = dVar2;
        }

        @Override // c.a.a0.k0.r.a, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f27732d.k0(webView.getTitle());
                Object tag = webView.getTag(R.id.obfuscated_res_0x7f0914e8);
                int intValue = tag == null ? 0 : ((Integer) tag).intValue();
                if (TextUtils.equals(str, this.f27732d.f27729g) || TextUtils.equals(webView.getOriginalUrl(), this.f27732d.f27729g) || (str != null && str.contains(this.f27732d.f27729g))) {
                    if (intValue != 0 && intValue != -1) {
                        this.f27732d.i0(intValue);
                    } else {
                        this.f27732d.a0();
                    }
                }
                this.f27732d.L();
                this.f27732d.i.w(str);
            }
        }

        @Override // c.a.a0.k0.r.a, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                if (this.f27732d.n) {
                    webView.setTag(R.id.obfuscated_res_0x7f0914e8, 0);
                }
                this.f27732d.n = false;
                WebView webView2 = this.f27732d.f27728f;
                if (webView2 != null && !webView2.canGoBack() && !this.f27732d.f27728f.canGoForward()) {
                    this.f27732d.j0();
                }
                this.f27732d.i.x(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, webView, i, str, str2) == null) {
                super.onReceivedError(webView, i, str, str2);
                webView.setTag(R.id.obfuscated_res_0x7f0914e8, Integer.valueOf(i));
                this.f27732d.i.z(webView, i, str, str2);
            }
        }

        @Override // c.a.a0.k0.r.a, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
                String d2 = c.a.a0.k0.p.b.d(str);
                if (TextUtils.isEmpty(d2) || !(d2.startsWith("http://") || d2.startsWith("https://") || d2.startsWith("ftp://") || d2.startsWith("sftp://") || d2.startsWith("ftps://"))) {
                    this.f27732d.n = true;
                    if (this.f27732d.i.F(webView, this.f27732d.F(), str) || c.a.a0.g.a.b(this.f27732d.getActivity(), str, false) || g.b.a().a(this.f27732d.getActivity(), str, webView.getUrl(), this.f27731c) || c.a.a0.g.c.c(str, this.f27732d.getActivity())) {
                        return true;
                    }
                    this.f27732d.j0();
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
                this.a.i.A(str);
                this.a.k0(webView.getTitle());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseNativeBrowserContainer f27733b;

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
            this.f27733b = baseNativeBrowserContainer;
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

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseNativeBrowserContainer f27734b;

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
            this.f27734b = baseNativeBrowserContainer;
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
                WebView webView = this.f27734b.f27728f;
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && NetUtil.a(c.a.a0.h.a.b())) {
                this.a.b0();
                this.a.j0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNativeBrowserContainer(c.a.a0.k0.g.a.a aVar, c.a.a0.k0.g.a.b bVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.a0.k0.g.a.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = true;
        this.n = false;
        this.o = true;
        this.p = new g(this);
        this.f27725c = bVar;
        T();
    }

    public final void A(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && Build.VERSION.SDK_INT == 17 && context != null) {
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

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.i.k() : (String) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27730h : (String) invokeV.objValue;
    }

    public final int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getActivity().getRequestedOrientation() : invokeV.intValue;
    }

    public FrameLayout E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f27726d : (FrameLayout) invokeV.objValue;
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String url = this.f27728f.getUrl();
            return !TextUtils.isEmpty(url) ? url : !TextUtils.isEmpty(this.f27729g) ? this.f27729g : "";
        }
        return (String) invokeV.objValue;
    }

    public LinearLayout G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f27727e : (LinearLayout) invokeV.objValue;
    }

    public final String H(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, intent)) == null) {
            String stringExtra = intent.getStringExtra("url");
            if (TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(B())) {
                stringExtra = B();
            }
            String d2 = c.a.a0.k0.p.b.d(stringExtra);
            return (TextUtils.isEmpty(d2) || !c.a.a0.k0.p.b.g(c.a.a0.k0.p.b.b(d2))) ? "" : d2;
        }
        return (String) invokeL.objValue;
    }

    public final void I(String str, String str2, String str3, String str4, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, str3, str4, Long.valueOf(j)}) == null) && c.a.a0.h0.g.b(c.a.a0.h0.g.c(c.a.a0.h0.g.e(str, str3, str4)), str4) == 3) {
            JSONObject b2 = c.a.a0.x.b.b(this.j);
            c.a.a0.x.b.e(b2, "url", str);
            c.a.a0.x.b.d(b2, BreakpointSQLiteKey.CONTENT_LENGTH, j);
            c.a.a0.k0.i.b.b().b(getActivity(), this.k, b2.toString());
        }
    }

    public boolean J(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.l.a(BrowserStateView.ViewState.ERROR);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.a(BrowserStateView.ViewState.LOADING);
        }
    }

    public FrameLayout M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            FrameLayout frameLayout = new FrameLayout(getActivity());
            BrowserStateView browserStateView = new BrowserStateView(getActivity());
            this.l = browserStateView;
            browserStateView.setErrorViewClickListener(this.p);
            WebView a2 = c.a.a0.k0.i.a.a().a(getActivity());
            this.f27728f = a2;
            frameLayout.addView(a2, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(this.l, new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f27727e.addView(M(), new LinearLayout.LayoutParams(-1, -1));
            W(this.f27728f);
            Q(this.f27728f);
            if (this.f27735b) {
                R();
            } else {
                this.f27726d.findViewById(R.id.obfuscated_res_0x7f092063).setVisibility(8);
            }
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f27729g = H(e());
        }
    }

    public final void P(@NonNull Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, intent) == null) && TextUtils.equals(intent.getStringExtra("layoutfullscreen"), "1") && Build.VERSION.SDK_INT >= 23) {
            f().getDecorView().setSystemUiVisibility(f().getDecorView().getSystemUiVisibility() | 1024 | 8192);
            f().addFlags(Integer.MIN_VALUE);
            f().setStatusBarColor(getResources().getColor(R.color.obfuscated_res_0x7f060838, null));
        }
    }

    public void Q(@NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, webView) == null) {
            try {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            webView.loadUrl("javascript:(function(){try{if(performance&&performance.timing){var performanceResult={};for(var key in performance.timing){if(typeof performance.timing[key]!==\"function\"){performanceResult[key]=performance.timing[key];}}var strJson=JSON.stringify(performanceResult);NadJsControl.getPerformanceTiming(strJson);}}catch(e){}})();");
            this.i.p(getActivity(), webView);
        }
    }

    public final void R() {
        int[] a2;
        int[] c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f27726d.findViewById(R.id.obfuscated_res_0x7f092063).setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) this.f27726d.findViewById(R.id.obfuscated_res_0x7f092067);
            for (int i : c.a.a0.k0.i.b.i().a()) {
                ImageView imageView = new ImageView(new ContextThemeWrapper(getActivity(), (int) R.style.obfuscated_res_0x7f100133), null, R.style.obfuscated_res_0x7f100133);
                imageView.setImageResource(i);
                imageView.setTag(Integer.valueOf(i));
                c.a.a0.k0.i.b.i().b(imageView, this);
                linearLayout.addView(imageView);
            }
            LinearLayout linearLayout2 = (LinearLayout) this.f27726d.findViewById(R.id.obfuscated_res_0x7f09206f);
            for (int i2 : c.a.a0.k0.i.b.i().c()) {
                ImageView imageView2 = new ImageView(new ContextThemeWrapper(getActivity(), (int) R.style.obfuscated_res_0x7f100133), null, R.style.obfuscated_res_0x7f100133);
                imageView2.setImageResource(i2);
                imageView2.setTag(Integer.valueOf(i2));
                c.a.a0.k0.i.b.i().b(imageView2, this);
                linearLayout2.addView(imageView2);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @SuppressLint({"SourceLockedOrientationActivity"})
    public final void S(@NonNull Intent intent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            String stringExtra = intent.getStringExtra("forbidautorotate");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (Build.VERSION.SDK_INT == 26) {
                z();
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
                if (D() != -1) {
                    f0(-1);
                }
            } else if (c2 != 1) {
                if (c2 == 2 && D() != 0) {
                    f0(0);
                }
            } else if (D() != 1) {
                f0(1);
            }
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.i = new c.a.a0.k0.n.a(this);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Intent e2 = e();
            S(e2);
            P(e2);
            g0(!"true".equals(e().getStringExtra("hide_state_view")));
            Y();
            this.i.t(getActivity(), this.f27726d, this.f27728f);
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            N();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void W(@NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, webView) == null) {
            A(getActivity());
            webView.setScrollbarFadingEnabled(true);
            webView.setVerticalScrollBarEnabled(true);
            webView.setHorizontalScrollBarEnabled(false);
            webView.getSettings().setLightTouchEnabled(false);
            webView.getSettings().setUserAgentString(c.a.a0.h.a.e());
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
            d0(true);
            webView.setDownloadListener(new a(this));
            b bVar = new b(this);
            webView.setWebViewClient(new c(this, webView, null, bVar, bVar));
            webView.setWebChromeClient(new d(this));
        }
    }

    public void X(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            k.b(new f(this, str));
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            c.a.a0.k0.g.a.b bVar = this.f27725c;
            if (bVar == null || !bVar.handleLoadUrl()) {
                c.a.a0.k0.n.a aVar = this.i;
                if (aVar == null || !aVar.l()) {
                    this.n = true;
                    this.f27728f.loadUrl(this.f27729g);
                }
            }
        }
    }

    public void Z(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, map) == null) {
            this.f27728f.loadUrl(this.f27729g, map);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) ? this.f27728f != null && this.o : invokeL.booleanValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            L();
            K();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void b0() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (webView = this.f27728f) == null) {
            return;
        }
        webView.reload();
        this.n = true;
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.c();
        }
    }

    public final void c0() {
        WebView webView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (webView = this.f27728f) == null) {
            return;
        }
        if (webView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.f27728f.getParent()).removeView(this.f27728f);
        }
        WebView webView2 = this.f27728f;
        if (!f.b.c()) {
            new Handler().postDelayed(new e(this, webView2), 1500L);
        } else {
            try {
                webView2.destroy();
            } catch (Exception unused) {
            }
        }
        this.f27728f = null;
    }

    public final void d0(boolean z) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
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
            cookieManager.setAcceptThirdPartyCookies(this.f27728f, z);
        }
    }

    public void e0(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, relativeLayout) == null) {
            this.k = relativeLayout;
        }
    }

    public final void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            getActivity().setRequestedOrientation(i);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? (e().getExtras() == null || TextUtils.isEmpty(e().getExtras().getString("other_app_back_url"))) ? false : true : invokeV.booleanValue;
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.m = z;
            BrowserStateView browserStateView = this.l;
            if (browserStateView != null) {
                browserStateView.setVisibility(z ? 0 : 8);
            }
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.i.u();
            super.h();
            o(View.inflate(getActivity(), R.layout.obfuscated_res_0x7f0d05ba, null));
            O();
            V();
            U();
        }
    }

    public void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.j = str;
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.i.v();
            c0();
            super.i();
        }
    }

    public final void i0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            if (i == 0) {
                K();
                return;
            }
            if (this.m) {
                this.l.setVisibility(0);
            }
            this.l.e(BrowserStateView.ViewState.ERROR);
            this.l.a(BrowserStateView.ViewState.LOADING);
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.i.y();
            this.f27728f.onPause();
            j.a(d(), f().getDecorView().getWindowToken());
            super.j();
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (this.m) {
                this.l.setVisibility(0);
            }
            this.l.e(BrowserStateView.ViewState.LOADING);
            this.l.a(BrowserStateView.ViewState.ERROR);
        }
    }

    public void k0(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, str) == null) || (textView = (TextView) this.f27727e.findViewById(R.id.obfuscated_res_0x7f09221e)) == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.i.B();
            super.l();
            this.f27728f.onResume();
            this.f27728f.resumeTimers();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.i.C();
            super.m();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.i.D();
            super.n();
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void o(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, view) == null) {
            super.o(view);
            this.f27726d = (FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f091aef);
            this.f27727e = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f09244c);
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
            if (d.b.a().a(i) || J(i, keyEvent)) {
                return true;
            }
            if (i == 4) {
                q();
                return true;
            } else if (this.f27728f.onKeyDown(i, keyEvent)) {
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
            this.f27728f.freeMemory();
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

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.f27730h = str;
        }
    }

    @Override // com.baidu.nadcore.webview.container.base.AbsContainer
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            j.a(d(), f().getDecorView().getWindowToken());
            if (this.f27728f.canGoBack()) {
                this.f27728f.goBack();
            } else if (x()) {
            } else {
                f.b.a().a(getActivity());
            }
        }
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            if (e().getExtras() == null || !g()) {
                return false;
            }
            e().removeExtra("other_app_back_url");
            return true;
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"JavascriptInterface"})
    public void y(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048631, this, obj, str) == null) {
            this.f27728f.addJavascriptInterface(obj, str);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048632, this) == null) && (getActivity() instanceof BaseActivity)) {
            ((BaseActivity) getActivity()).setCurrentActivityNoTransparent();
        }
    }
}
