package com.baidu.sapi2.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.d.a.a;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes2.dex */
public class k {
    public static void a(Context context, SapiWebView sapiWebView, boolean z) {
        a(context, sapiWebView);
        d(context, sapiWebView);
        if (z) {
            c(context, sapiWebView);
        } else {
            b(context, sapiWebView);
        }
    }

    private static void b(Context context, SapiWebView sapiWebView) {
        try {
            ProgressBar progressBar = new ProgressBar(context, null, 16842872);
            progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, SapiUtils.dip2px(context, 2.0f), 0, 0));
            progressBar.setBackgroundColor(context.getResources().getColor(a.b.sapi_sdk_dark_mode_color));
            sapiWebView.setProgressBar(progressBar);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    private static void c(Context context, SapiWebView sapiWebView) {
        sapiWebView.setWebviewLoadingView(new com.baidu.sapi2.views.p(context));
    }

    private static void d(Context context, SapiWebView sapiWebView) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(a.f.layout_sapi_sdk_loading_timeout, (ViewGroup) null);
        Button button = (Button) inflate.findViewById(a.e.btn_retry);
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode && inflate != null) {
            ((LinearLayout) inflate.findViewById(a.e.sapi_sdk_loading_timeout_bg_layout)).setBackgroundColor(context.getResources().getColor(a.b.sapi_sdk_dark_mode_color));
            ((TextView) inflate.findViewById(a.e.sapi_sdk_loading_timeout_tv)).setTextColor(context.getResources().getColor(a.b.sapi_sdk_dark_mode_no_network_tv_color));
            button.setBackgroundResource(a.d.sapi_sdk_btn_gray);
            button.setTextColor(context.getResources().getColor(a.b.sapi_sdk_dark_mode_btn_tv_color));
        }
        button.setOnClickListener(new j(sapiWebView, inflate));
        sapiWebView.setTimeoutView(inflate);
    }

    private static void a(Context context, SapiWebView sapiWebView) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(a.f.layout_sapi_sdk_network_unavailable, (ViewGroup) null);
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode && inflate != null) {
            ((LinearLayout) inflate.findViewById(a.e.sapi_sdk_network_unavailable_bg_layout)).setBackgroundColor(context.getResources().getColor(a.b.sapi_sdk_dark_mode_color));
            ((TextView) inflate.findViewById(a.e.sapi_sdk_network_unavailable_tv)).setTextColor(context.getResources().getColor(a.b.sapi_sdk_dark_mode_no_network_tv_color));
        }
        sapiWebView.setNoNetworkView(inflate);
    }
}
