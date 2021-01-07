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
import com.baidu.l.a.a;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
/* loaded from: classes3.dex */
public class g {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WebView f5415a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f5416b;

        /* renamed from: com.baidu.sapi2.utils.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class RunnableC0352a implements Runnable {
            RunnableC0352a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f5416b.setVisibility(4);
                a.this.f5415a.reload();
            }
        }

        a(WebView webView, View view) {
            this.f5415a = webView;
            this.f5416b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f5415a.post(new RunnableC0352a());
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
        sapiWebView.setWebviewLoadingView(new com.baidu.sapi2.views.b(context));
    }

    private static void d(Context context, SapiWebView sapiWebView) {
        sapiWebView.setTimeoutView(a(context, (WebView) sapiWebView));
    }

    private static void a(Context context, SapiWebView sapiWebView) {
        sapiWebView.setNoNetworkView(a(context, (WebView) sapiWebView));
    }

    public static View a(Context context, WebView webView) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(a.f.layout_sapi_sdk_loading_timeout, (ViewGroup) null);
        Button button = (Button) inflate.findViewById(a.e.btn_retry);
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode && inflate != null) {
            ((LinearLayout) inflate.findViewById(a.e.sapi_sdk_loading_timeout_bg_layout)).setBackgroundColor(context.getResources().getColor(a.b.sapi_sdk_dark_mode_color));
            ((TextView) inflate.findViewById(a.e.sapi_sdk_loading_timeout_tv)).setTextColor(context.getResources().getColor(a.b.sapi_sdk_dark_mode_no_network_tv_color));
            ((ImageView) inflate.findViewById(a.e.sapi_sdk_loading_timeout_iv)).setImageResource(a.d.sapi_sdk_icon_connection_failed_dark);
            button.setBackgroundResource(a.d.sapi_sdk_btn_gray);
            Resources resources = context.getResources();
            if (resources != null) {
                button.setTextColor(resources.getColorStateList(a.b.sapi_sdk_text_white));
            }
        }
        button.setOnClickListener(new a(webView, inflate));
        return inflate;
    }
}
