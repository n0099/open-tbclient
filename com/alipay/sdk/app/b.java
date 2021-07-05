package com.alipay.sdk.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.util.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class b extends WebViewClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Activity f1786a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1787b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f1788c;

    /* renamed from: d  reason: collision with root package name */
    public com.alipay.sdk.widget.a f1789d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1790e;

    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<b> f1791a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1791a = new WeakReference<>(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f1791a.get()) == null) {
                return;
            }
            bVar.d();
        }
    }

    public b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1786a = activity;
        this.f1788c = new Handler(this.f1786a.getMainLooper());
    }

    private void c() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (activity = this.f1786a) == null) {
            return;
        }
        if (this.f1789d == null) {
            com.alipay.sdk.widget.a aVar = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f2013a);
            this.f1789d = aVar;
            aVar.a(true);
        }
        this.f1789d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            com.alipay.sdk.widget.a aVar = this.f1789d;
            if (aVar != null) {
                aVar.c();
            }
            this.f1789d = null;
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1790e : invokeV.booleanValue;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
            Activity activity = this.f1786a;
            if (this.f1788c == null || activity == null || activity.isFinishing()) {
                return;
            }
            d();
            this.f1788c.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, webView, str, bitmap) == null) {
            Activity activity = this.f1786a;
            if (this.f1788c != null && activity != null && !activity.isFinishing()) {
                c();
                this.f1788c.postDelayed(new a(this), 30000L);
            }
            super.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, webView, i2, str, str2) == null) {
            this.f1790e = true;
            super.onReceivedError(webView, i2, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, webView, sslErrorHandler, sslError) == null) || (activity = this.f1786a) == null) {
            return;
        }
        com.alipay.sdk.app.statistic.a.a("net", com.alipay.sdk.app.statistic.c.r, "1" + sslError);
        if (this.f1787b) {
            sslErrorHandler.proceed();
            this.f1787b = false;
            return;
        }
        activity.runOnUiThread(new c(this, activity, sslErrorHandler));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, str)) == null) ? n.a(webView, str, this.f1786a) : invokeLL.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1788c = null;
            this.f1786a = null;
        }
    }
}
