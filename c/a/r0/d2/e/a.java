package c.a.r0.d2.e;

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
import c.a.d.a.j;
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
/* loaded from: classes5.dex */
public class a implements IBrowserView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HkWebView a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f16562b;

    /* renamed from: c  reason: collision with root package name */
    public View f16563c;

    /* renamed from: d  reason: collision with root package name */
    public View f16564d;

    /* renamed from: e  reason: collision with root package name */
    public View f16565e;

    /* renamed from: f  reason: collision with root package name */
    public IBrowserView.OnBrowserStatusChangeCallBack f16566f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16567g;

    /* renamed from: c.a.r0.d2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0997a extends WebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0997a(a aVar) {
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
            this.a = aVar;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, webView, str) == null) {
                super.onPageFinished(webView, str);
                this.a.i();
                if (this.a.f16566f != null) {
                    this.a.f16566f.onHideLoading();
                }
                if (this.a.f16567g) {
                    this.a.j();
                    if (this.a.f16566f != null) {
                        this.a.f16566f.onLoadFailure();
                    }
                } else if (this.a.f16566f != null) {
                    this.a.f16566f.onLoadSuccess();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
                super.onPageStarted(webView, str, bitmap);
                this.a.f16567g = false;
                this.a.k();
                this.a.h();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, webResourceRequest, webResourceError) == null) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                this.a.f16567g = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, sslErrorHandler, sslError) == null) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                this.a.f16567g = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Activity b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
                if (TextUtils.isEmpty(str) || (b2 = c.a.d.a.b.g().b()) == null) {
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
        this.f16567g = false;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public boolean canGoBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HkWebView hkWebView = this.a;
            return hkWebView != null && hkWebView.canGoBack();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public boolean canScrollVertically(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            HkWebView hkWebView = this.a;
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
            if (this.f16562b == null) {
                this.f16562b = new FrameLayout(context);
            }
            if (this.f16565e == null) {
                View view = new View(context);
                this.f16565e = view;
                view.setBackgroundColor(context.getResources().getColor(17170443));
            }
            if (this.a == null) {
                HkWebView hkWebView = new HkWebView(context);
                this.a = hkWebView;
                hkWebView.setWebViewClient(new C0997a(this));
            }
            this.f16562b.addView(this.a);
            return this.f16562b;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void goBack() {
        HkWebView hkWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (hkWebView = this.a) == null) {
            return;
        }
        hkWebView.goBack();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f16564d != null && this.f16565e.getParent() != null) {
                ((ViewGroup) this.f16565e.getParent()).removeView(this.f16565e);
            }
            View view = this.f16563c;
            if (view == null || view.getParent() == null) {
                return;
            }
            ((ViewGroup) this.f16563c.getParent()).removeView(this.f16563c);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f16564d != null && this.f16565e.getParent() != null) {
                ((ViewGroup) this.f16565e.getParent()).removeView(this.f16565e);
            }
            View view = this.f16564d;
            if (view == null || view.getParent() == null) {
                return;
            }
            ((ViewGroup) this.f16564d.getParent()).removeView(this.f16564d);
        }
    }

    public final void j() {
        View view;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f16562b != null && (view2 = this.f16565e) != null && view2.getParent() == null) {
                this.f16562b.addView(this.f16565e, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.f16562b == null || (view = this.f16563c) == null || view.getParent() != null) {
                return;
            }
            this.f16562b.addView(this.f16563c, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void k() {
        View view;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f16562b != null && (view2 = this.f16565e) != null && view2.getParent() == null) {
                this.f16562b.addView(this.f16565e, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.f16562b == null || (view = this.f16564d) == null || view.getParent() != null) {
                return;
            }
            this.f16562b.addView(this.f16564d, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void loadUrl(String str) {
        HkWebView hkWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (hkWebView = this.a) == null) {
            return;
        }
        hkWebView.loadUrl(str);
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a = null;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void refresh() {
        HkWebView hkWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (hkWebView = this.a) == null) {
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
            this.f16563c = view;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
            this.f16564d = view;
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.browser.IBrowserView
    public void setOnBrowserStatusChangeCallBack(IBrowserView.OnBrowserStatusChangeCallBack onBrowserStatusChangeCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onBrowserStatusChangeCallBack) == null) {
            this.f16566f = onBrowserStatusChangeCallBack;
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
