package com.baidu.apollon.webmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.base.ApollonBaseActivity;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.apollon.webmanager.SafeWebView;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f37238a = "AbstractWebViewPage";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f37239b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f37240c = "appcache";

    /* renamed from: d  reason: collision with root package name */
    public static final String f37241d = "databases";

    /* renamed from: e  reason: collision with root package name */
    public static final String f37242e = "geolocation";

    /* renamed from: f  reason: collision with root package name */
    public static final String f37243f = "page load success";

    /* renamed from: g  reason: collision with root package name */
    public static final String f37244g = "page load failure";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final View f37245h;

    /* renamed from: i  reason: collision with root package name */
    public final View f37246i;
    public ViewGroup j;
    public SafeWebView k;
    public boolean l;
    public int m;
    public String n;
    public ApollonBaseActivity o;
    public boolean p;
    public EventBus q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(570021138, "Lcom/baidu/apollon/webmanager/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(570021138, "Lcom/baidu/apollon/webmanager/a;");
                return;
            }
        }
        f37239b = ApollonConstants.DEBUG & false;
    }

    public a(ApollonBaseActivity apollonBaseActivity, ViewGroup viewGroup, View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {apollonBaseActivity, viewGroup, view, view2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = null;
        this.l = false;
        this.m = 0;
        this.n = "";
        this.o = null;
        this.p = false;
        this.o = apollonBaseActivity;
        this.j = viewGroup;
        this.f37245h = view;
        this.f37246i = view2;
        this.l = false;
        this.m = i2;
        String[] strArr = {f37243f, f37244g};
        EventBus eventBus = EventBus.getInstance();
        this.q = eventBus;
        eventBus.register(this, strArr, 0, EventBus.ThreadMode.MainThread);
        n();
    }

    private void j() {
        View view;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (view = this.f37245h) == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
            return;
        }
        viewGroup.removeView(this.f37245h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (view = this.f37246i) == null) {
            return;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            j();
            View view = this.f37246i;
            if (view != null) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f37246i);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(13);
                this.j.addView(this.f37246i, layoutParams);
                this.f37246i.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            EventBus eventBus = this.q;
            eventBus.getClass();
            eventBus.post(new EventBus.Event(eventBus, f37243f, null));
        }
    }

    private void n() {
        Context applicationContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (applicationContext = DxmApplicationContextImpl.getApplicationContext(this.o)) == null) {
            return;
        }
        this.k = new SafeWebView(applicationContext);
        if (this.l) {
            File file = new File(applicationContext.getCacheDir(), "webviewCacheChromium");
            if (!file.exists()) {
                file = new File(applicationContext.getCacheDir(), "webviewCache");
            }
            if (file.exists()) {
                if (NetworkUtils.isNetworkConnected(applicationContext)) {
                    this.k.getSettings().setCacheMode(-1);
                } else {
                    this.k.getSettings().setCacheMode(1);
                }
            } else {
                this.k.getSettings().setCacheMode(1);
            }
        }
        this.k.setScrollBarStyle(0);
        this.k.getSettings().setBlockNetworkImage(true);
        this.k.setLongClickable(true);
        a(this.k);
        this.k.setWebViewClient(new SafeWebView.SafeWebViewClient(this) { // from class: com.baidu.apollon.webmanager.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f37247a;

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
                this.f37247a = this;
            }

            @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
            public void onLoadResource(WebView webView, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, webView, str) == null) {
                    super.onLoadResource(webView, str);
                    if (a.f37239b) {
                        String str2 = "onLoadResource is called, url is " + str;
                    }
                }
            }

            @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) {
                    if (a.f37239b) {
                        String str2 = "onPageFinished, url is " + str + " original url is " + webView.getOriginalUrl();
                    }
                    super.onPageFinished(webView, str);
                    Object tag = webView.getTag(this.f37247a.m);
                    int intValue = tag == null ? 0 : ((Integer) tag).intValue();
                    if (a.f37239b) {
                        String str3 = "onPageFinished errorTagCode is " + intValue;
                    }
                    if (TextUtils.equals(str, this.f37247a.n) || TextUtils.equals(webView.getOriginalUrl(), this.f37247a.n) || (str != null && str.contains(this.f37247a.n))) {
                        if (intValue == 0) {
                            this.f37247a.m();
                        } else {
                            this.f37247a.b(intValue);
                        }
                    }
                    this.f37247a.k();
                    this.f37247a.k.getSettings().setBlockNetworkImage(false);
                }
            }

            @Override // com.baidu.apollon.webmanager.SafeWebView.SafeWebViewClient, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, bitmap) == null) {
                    super.onPageStarted(webView, str, bitmap);
                    if (a.f37239b) {
                        String str2 = "onPageStarted is called, url is " + str;
                    }
                    if (this.f37247a.p) {
                        this.f37247a.k.getSettings().setBlockNetworkImage(true);
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f37247a.k.clearView();
                        }
                    }
                    this.f37247a.p = false;
                    this.f37247a.n = str;
                    WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
                    if (this.f37247a.f37245h == null || this.f37247a.f37245h.getVisibility() != 0) {
                        if (copyBackForwardList == null || copyBackForwardList.getCurrentIndex() == copyBackForwardList.getSize() - 1) {
                            this.f37247a.l();
                        }
                    }
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLILL(1048579, this, webView, i2, str, str2) == null) {
                    if (a.f37239b) {
                        String str3 = "onReceivedError is called, errorCode is  " + i2 + " failingUrl is " + str2;
                    }
                    webView.setTag(this.f37247a.m, Integer.valueOf(i2));
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, webView, str)) == null) {
                    if (a.f37239b) {
                        String str2 = "shouldOverrideUrlLoading, url is " + str;
                    }
                    this.f37247a.p = true;
                    this.f37247a.n = str;
                    this.f37247a.l();
                    return false;
                }
                return invokeLL.booleanValue;
            }
        });
        this.k.setWebChromeClient(new SafeWebView.SafeChromeClient(this) { // from class: com.baidu.apollon.webmanager.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f37248a;

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
                this.f37248a = this;
            }

            @Override // android.webkit.WebChromeClient
            public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), quotaUpdater}) == null) {
                    quotaUpdater.updateQuota(j * 2);
                }
            }
        });
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k.goBack();
            this.p = true;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k.goForward();
            this.p = true;
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k.canGoBack() : invokeV.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public void e() {
        SafeWebView safeWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || Build.VERSION.SDK_INT < 11 || (safeWebView = this.k) == null) {
            return;
        }
        safeWebView.onPause();
    }

    @SuppressLint({"NewApi"})
    public void f() {
        SafeWebView safeWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || Build.VERSION.SDK_INT < 11 || (safeWebView = this.k) == null) {
            return;
        }
        safeWebView.onResume();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ViewGroup viewGroup = (ViewGroup) this.k.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.k);
            }
            this.k.destroy();
            this.k = null;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String str = Uri.parse(this.n).getScheme() + "://" + Uri.parse(this.n).getHost();
            if (f37239b) {
                String str2 = "delOrigin is " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            WebStorage.getInstance().deleteOrigin(str);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (f37239b) {
            String str2 = "delOrigin is " + str;
        }
        WebStorage.getInstance().deleteOrigin(str);
    }

    public SafeWebView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (SafeWebView) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.n = str;
            this.p = true;
            this.k.loadUrl(str);
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
            EventBus eventBus = this.q;
            eventBus.getClass();
            eventBus.post(new EventBus.Event(eventBus, f37244g, Integer.valueOf(i2)));
        }
    }

    public void a(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            if (event.mEventKey.equals(f37243f)) {
                j();
                k();
                this.k.setVisibility(0);
            } else if (event.mEventKey.equals(f37244g)) {
                a(((Integer) event.mEventObj).intValue());
                this.k.setVisibility(8);
            }
        }
    }

    public a(ApollonBaseActivity apollonBaseActivity, ViewGroup viewGroup, View view, View view2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {apollonBaseActivity, viewGroup, view, view2, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.j = null;
        this.l = false;
        this.m = 0;
        this.n = "";
        this.o = null;
        this.p = false;
        this.o = apollonBaseActivity;
        this.j = viewGroup;
        this.f37245h = view;
        this.f37246i = view2;
        this.l = z;
        this.m = i2;
        n();
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            if (i2 == 0) {
                j();
                return;
            }
            k();
            View view = this.f37245h;
            if (view != null) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.f37245h);
                }
                this.j.addView(this.f37245h, this.j.getLayoutParams());
                this.f37245h.setVisibility(0);
            }
        }
    }

    private void a(SafeWebView safeWebView) {
        Context applicationContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, safeWebView) == null) || (applicationContext = DxmApplicationContextImpl.getApplicationContext(this.o)) == null) {
            return;
        }
        WebSettings settings = safeWebView.getSettings();
        if (this.l) {
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setGeolocationEnabled(true);
            settings.setDatabasePath(applicationContext.getDir("databases", 0).getPath());
            if (this.l) {
                settings.setAppCacheEnabled(true);
                settings.setAppCachePath(applicationContext.getDir("appcache", 0).getPath());
            }
        }
        settings.setGeolocationDatabasePath(applicationContext.getDir("geolocation", 0).getPath());
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
    }
}
