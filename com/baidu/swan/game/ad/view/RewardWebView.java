package com.baidu.swan.game.ad.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class RewardWebView extends WebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45383e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f45384f;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45385e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ RewardWebView f45386f;

        public a(RewardWebView rewardWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rewardWebView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45386f = rewardWebView;
            this.f45385e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RewardWebView.super.loadUrl(this.f45385e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45387e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45388f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45389g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45390h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f45391i;
        public final /* synthetic */ RewardWebView j;

        public b(RewardWebView rewardWebView, String str, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rewardWebView, str, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = rewardWebView;
            this.f45387e = str;
            this.f45388f = str2;
            this.f45389g = str3;
            this.f45390h = str4;
            this.f45391i = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RewardWebView.super.loadDataWithBaseURL(this.f45387e, this.f45388f, this.f45389g, this.f45390h, this.f45391i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45392e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ValueCallback f45393f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ RewardWebView f45394g;

        public c(RewardWebView rewardWebView, String str, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rewardWebView, str, valueCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45394g = rewardWebView;
            this.f45392e = str;
            this.f45393f = valueCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RewardWebView.super.evaluateJavascript(this.f45392e, this.f45393f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"SetJavaScriptEnabled"})
    public RewardWebView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45383e = false;
        this.f45384f = new Handler(Looper.getMainLooper());
        setClickable(true);
        setBackgroundColor(0);
        setFocusable(true);
        setScrollBarStyle(0);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setNeedInitialFocus(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        String path = context.getApplicationContext().getDir("database", 0).getPath();
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(path);
        e();
        try {
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
        } catch (Exception unused) {
        }
    }

    public final void d(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.f45384f.post(runnable);
            }
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                if (this.f45383e) {
                    return;
                }
                if (getParent() != null) {
                    ((ViewGroup) getParent()).removeView(this);
                }
                super.destroy();
                this.f45383e = true;
            } catch (Exception unused) {
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WebSettings settings = getSettings();
            settings.setUserAgentString(b.a.p0.h.i.n.a.b().o(settings.getUserAgentString()));
        }
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, valueCallback) == null) || this.f45383e) {
            return;
        }
        d(new c(this, str, valueCallback));
    }

    public boolean isDestroy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45383e : invokeV.booleanValue;
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048581, this, str, str2, str3, str4, str5) == null) || this.f45383e) {
            return;
        }
        d(new b(this, str, str2, str3, str4, str5));
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            try {
                if (this.f45383e) {
                    return;
                }
                d(new a(this, str));
            } catch (Exception unused) {
            }
        }
    }
}
