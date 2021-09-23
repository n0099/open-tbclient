package c.a.r0.w1.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.browser.IBrowserView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.medialive.browser.HkWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a implements IBrowserView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HkWebView f28079a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f28080b;

    /* renamed from: c  reason: collision with root package name */
    public View f28081c;

    /* renamed from: d  reason: collision with root package name */
    public View f28082d;

    /* renamed from: e  reason: collision with root package name */
    public View f28083e;

    /* renamed from: f  reason: collision with root package name */
    public IBrowserView.OnBrowserStatusChangeCallBack f28084f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28085g;

    /* renamed from: c.a.r0.w1.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1318a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28086a;

        public C1318a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28086a = aVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.f28086a.i();
                if (this.f28086a.f28084f != null) {
                    this.f28086a.f28084f.onHideLoading();
                }
                if (this.f28086a.f28085g) {
                    this.f28086a.j();
                    if (this.f28086a.f28084f != null) {
                        this.f28086a.f28084f.onLoadFailure();
                    }
                } else if (this.f28086a.f28084f != null) {
                    this.f28086a.f28084f.onLoadSuccess();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.f28086a.f28085g = false;
                this.f28086a.k();
                this.f28086a.h();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest, webResourceError) == null) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                this.f28086a.f28085g = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                this.f28086a.f28085g = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Activity b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str) || (b2 = c.a.e.a.b.f().b()) == null) {
                    return false;
                }
                UrlManager.getInstance().dealOneLink((TbPageContext) j.a(b2), new String[]{str}, true);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28085g = false;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HkWebView hkWebView = this.f28079a;
            return hkWebView != null && hkWebView.canGoBack();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public boolean canScrollVertically(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            HkWebView hkWebView = this.f28079a;
            if (hkWebView != null) {
                return hkWebView.canScrollVertically(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public View getView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.f28080b == null) {
                this.f28080b = new FrameLayout(context);
            }
            if (this.f28083e == null) {
                View view = new View(context);
                this.f28083e = view;
                view.setBackgroundColor(context.getResources().getColor(17170443));
            }
            if (this.f28079a == null) {
                HkWebView hkWebView = new HkWebView(context);
                this.f28079a = hkWebView;
                hkWebView.setWebViewClient(new C1318a(this));
            }
            this.f28080b.addView(this.f28079a);
            return this.f28080b;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void goBack() {
        HkWebView hkWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hkWebView = this.f28079a) == null) {
            return;
        }
        hkWebView.goBack();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f28082d != null && this.f28083e.getParent() != null) {
                ((ViewGroup) this.f28083e.getParent()).removeView(this.f28083e);
            }
            View view = this.f28081c;
            if (view == null || view.getParent() == null) {
                return;
            }
            ((ViewGroup) this.f28081c.getParent()).removeView(this.f28081c);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f28082d != null && this.f28083e.getParent() != null) {
                ((ViewGroup) this.f28083e.getParent()).removeView(this.f28083e);
            }
            View view = this.f28082d;
            if (view == null || view.getParent() == null) {
                return;
            }
            ((ViewGroup) this.f28082d.getParent()).removeView(this.f28082d);
        }
    }

    public final void j() {
        View view;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f28080b != null && (view2 = this.f28083e) != null && view2.getParent() == null) {
                this.f28080b.addView(this.f28083e, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.f28080b == null || (view = this.f28081c) == null || view.getParent() != null) {
                return;
            }
            this.f28080b.addView(this.f28081c, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void k() {
        View view;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f28080b != null && (view2 = this.f28083e) != null && view2.getParent() == null) {
                this.f28080b.addView(this.f28083e, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.f28080b == null || (view = this.f28082d) == null || view.getParent() != null) {
                return;
            }
            this.f28080b.addView(this.f28082d, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void loadUrl(String str) {
        HkWebView hkWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (hkWebView = this.f28079a) == null) {
            return;
        }
        hkWebView.loadUrl(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f28079a = null;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void refresh() {
        HkWebView hkWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (hkWebView = this.f28079a) == null) {
            return;
        }
        hkWebView.reload();
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setDynamicDispatcherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setErrorView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view) == null) {
            this.f28081c = view;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            this.f28082d = view;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setOnBrowserStatusChangeCallBack(IBrowserView.OnBrowserStatusChangeCallBack onBrowserStatusChangeCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onBrowserStatusChangeCallBack) == null) {
            this.f28084f = onBrowserStatusChangeCallBack;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setOnLongPressListener(IBrowserView.OnLongPressListener onLongPressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onLongPressListener) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setStateViewVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setUpSelect(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
        }
    }
}
