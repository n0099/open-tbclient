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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.SweepLightLoadingView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;
        public final /* synthetic */ View b;

        /* renamed from: com.baidu.sapi2.utils.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0154a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0154a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.b.setVisibility(4);
                    this.a.a.reload();
                }
            }
        }

        public a(WebView webView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webView;
            this.b = view2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.post(new RunnableC0154a(this));
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static View a(Context context, WebView webView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, webView)) == null) {
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_sapi_sdk_loading_timeout, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(R.id.btn_retry);
            if (SapiAccountManager.getInstance().getConfignation().isDarkMode && inflate != null) {
                ((LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091e8e)).setBackgroundColor(context.getResources().getColor(R.color.sapi_sdk_dark_mode_color));
                ((TextView) inflate.findViewById(R.id.sapi_sdk_loading_timeout_tv)).setTextColor(context.getResources().getColor(R.color.sapi_sdk_dark_mode_no_network_tv_color));
                ((ImageView) inflate.findViewById(R.id.sapi_sdk_loading_timeout_iv)).setImageResource(R.drawable.sapi_sdk_icon_connection_failed_dark);
                button.setBackgroundResource(R.drawable.sapi_sdk_btn_gray);
                Resources resources = context.getResources();
                if (resources != null) {
                    button.setTextColor(resources.getColorStateList(R.color.sapi_sdk_text_white));
                }
            }
            button.setOnClickListener(new a(webView, inflate));
            return inflate;
        }
        return (View) invokeLL.objValue;
    }

    public static void a(Context context, SapiWebView sapiWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, sapiWebView) == null) {
            sapiWebView.setNoNetworkView(a(context, (WebView) sapiWebView));
        }
    }

    public static void c(Context context, SapiWebView sapiWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, sapiWebView) == null) {
            sapiWebView.setWebviewLoadingView(new SweepLightLoadingView(context));
        }
    }

    public static void d(Context context, SapiWebView sapiWebView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, sapiWebView) == null) {
            sapiWebView.setTimeoutView(a(context, (WebView) sapiWebView));
        }
    }

    public static void a(Context context, SapiWebView sapiWebView, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65539, null, context, sapiWebView, view2) != null) || sapiWebView == null) {
            return;
        }
        a(context, sapiWebView);
        d(context, sapiWebView);
        if (view2 != null) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view2);
            }
            b(context, sapiWebView, view2);
        }
    }

    public static void b(Context context, SapiWebView sapiWebView, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, context, sapiWebView, view2) == null) {
            sapiWebView.setWebviewLoadingView(view2);
        }
    }

    public static void a(Context context, SapiWebView sapiWebView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, sapiWebView, z) != null) || sapiWebView == null) {
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
        if (interceptable == null || interceptable.invokeLL(65541, null, context, sapiWebView) == null) {
            try {
                ProgressBar progressBar = new ProgressBar(context, null, 16842872);
                progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, SapiUtils.dip2px(context, 2.0f), 0, 0));
                progressBar.setBackgroundColor(context.getResources().getColor(R.color.sapi_sdk_dark_mode_color));
                sapiWebView.setProgressBar(progressBar);
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }
}
