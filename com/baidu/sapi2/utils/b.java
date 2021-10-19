package com.baidu.sapi2.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.a.d;
import c.a.c0.a.e;
import c.a.c0.a.f;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.SweepLightLoadingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebView f44890a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f44891b;

        /* renamed from: com.baidu.sapi2.utils.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1704a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f44892a;

            public RunnableC1704a(a aVar) {
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
                this.f44892a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44892a.f44891b.setVisibility(4);
                    this.f44892a.f44890a.reload();
                }
            }
        }

        public a(WebView webView, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webView, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44890a = webView;
            this.f44891b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f44890a.post(new RunnableC1704a(this));
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(Context context, SapiWebView sapiWebView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65539, null, context, sapiWebView, z) == null) || sapiWebView == null) {
            return;
        }
        a(context, sapiWebView);
        d(context, sapiWebView);
        if (z) {
            c(context, sapiWebView);
        } else {
            b(context, sapiWebView);
        }
    }

    public static void b(Context context, SapiWebView sapiWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, sapiWebView) == null) {
            try {
                ProgressBar progressBar = new ProgressBar(context, null, 16842872);
                progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, SapiUtils.dip2px(context, 2.0f), 0, 0));
                progressBar.setBackgroundColor(context.getResources().getColor(c.a.c0.a.b.sapi_sdk_dark_mode_color));
                sapiWebView.setProgressBar(progressBar);
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    public static void c(Context context, SapiWebView sapiWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, sapiWebView) == null) {
            sapiWebView.setWebviewLoadingView(new SweepLightLoadingView(context));
        }
    }

    public static void d(Context context, SapiWebView sapiWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, sapiWebView) == null) {
            sapiWebView.setTimeoutView(a(context, (WebView) sapiWebView));
        }
    }

    public static void a(Context context, SapiWebView sapiWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, sapiWebView) == null) {
            sapiWebView.setNoNetworkView(a(context, (WebView) sapiWebView));
        }
    }

    public static View a(Context context, WebView webView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, webView)) == null) {
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(f.layout_sapi_sdk_loading_timeout, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(e.btn_retry);
            if (SapiAccountManager.getInstance().getConfignation().isDarkMode && inflate != null) {
                ((LinearLayout) inflate.findViewById(e.sapi_sdk_loading_timeout_bg_layout)).setBackgroundColor(context.getResources().getColor(c.a.c0.a.b.sapi_sdk_dark_mode_color));
                ((TextView) inflate.findViewById(e.sapi_sdk_loading_timeout_tv)).setTextColor(context.getResources().getColor(c.a.c0.a.b.sapi_sdk_dark_mode_no_network_tv_color));
                ((ImageView) inflate.findViewById(e.sapi_sdk_loading_timeout_iv)).setImageResource(d.sapi_sdk_icon_connection_failed_dark);
                button.setBackgroundResource(d.sapi_sdk_btn_gray);
                Resources resources = context.getResources();
                if (resources != null) {
                    button.setTextColor(resources.getColorStateList(c.a.c0.a.b.sapi_sdk_text_white));
                }
            }
            button.setOnClickListener(new a(webView, inflate));
            return inflate;
        }
        return (View) invokeLL.objValue;
    }
}
