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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.SweepLightLoadingView;
/* loaded from: classes2.dex */
public class i {

    /* loaded from: classes2.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WebView f11101a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f11102b;

        /* renamed from: com.baidu.sapi2.utils.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0148a implements Runnable {
            public RunnableC0148a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f11102b.setVisibility(4);
                a.this.f11101a.reload();
            }
        }

        public a(WebView webView, View view) {
            this.f11101a = webView;
            this.f11102b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f11101a.post(new RunnableC0148a());
        }
    }

    public static void a(Context context, SapiWebView sapiWebView, boolean z) {
        a(context, sapiWebView);
        d(context, sapiWebView);
        if (z) {
            c(context, sapiWebView);
        } else {
            b(context, sapiWebView);
        }
    }

    public static void b(Context context, SapiWebView sapiWebView) {
        try {
            ProgressBar progressBar = new ProgressBar(context, null, 16842872);
            progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, SapiUtils.dip2px(context, 2.0f), 0, 0));
            progressBar.setBackgroundColor(context.getResources().getColor(d.b.x.a.b.sapi_sdk_dark_mode_color));
            sapiWebView.setProgressBar(progressBar);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public static void c(Context context, SapiWebView sapiWebView) {
        sapiWebView.setWebviewLoadingView(new SweepLightLoadingView(context));
    }

    public static void d(Context context, SapiWebView sapiWebView) {
        sapiWebView.setTimeoutView(a(context, (WebView) sapiWebView));
    }

    public static void a(Context context, SapiWebView sapiWebView) {
        sapiWebView.setNoNetworkView(a(context, (WebView) sapiWebView));
    }

    public static View a(Context context, WebView webView) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.b.x.a.f.layout_sapi_sdk_loading_timeout, (ViewGroup) null);
        Button button = (Button) inflate.findViewById(d.b.x.a.e.btn_retry);
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode && inflate != null) {
            ((LinearLayout) inflate.findViewById(d.b.x.a.e.sapi_sdk_loading_timeout_bg_layout)).setBackgroundColor(context.getResources().getColor(d.b.x.a.b.sapi_sdk_dark_mode_color));
            ((TextView) inflate.findViewById(d.b.x.a.e.sapi_sdk_loading_timeout_tv)).setTextColor(context.getResources().getColor(d.b.x.a.b.sapi_sdk_dark_mode_no_network_tv_color));
            ((ImageView) inflate.findViewById(d.b.x.a.e.sapi_sdk_loading_timeout_iv)).setImageResource(d.b.x.a.d.sapi_sdk_icon_connection_failed_dark);
            button.setBackgroundResource(d.b.x.a.d.sapi_sdk_btn_gray);
            Resources resources = context.getResources();
            if (resources != null) {
                button.setTextColor(resources.getColorStateList(d.b.x.a.b.sapi_sdk_text_white));
            }
        }
        button.setOnClickListener(new a(webView, inflate));
        return inflate;
    }
}
