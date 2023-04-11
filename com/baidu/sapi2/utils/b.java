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
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ WebView a;
        public final /* synthetic */ View b;

        /* renamed from: com.baidu.sapi2.utils.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0139a implements Runnable {
            public RunnableC0139a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.setVisibility(4);
                a.this.a.reload();
            }
        }

        public a(WebView webView, View view2) {
            this.a = webView;
            this.b = view2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            this.a.post(new RunnableC0139a());
        }
    }

    public static View a(Context context, WebView webView) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.layout_sapi_sdk_loading_timeout, (ViewGroup) null);
        Button button = (Button) inflate.findViewById(R.id.btn_retry);
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode && inflate != null) {
            ((LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091f0a)).setBackgroundColor(context.getResources().getColor(R.color.sapi_sdk_dark_mode_color));
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

    public static void a(Context context, SapiWebView sapiWebView) {
        sapiWebView.setNoNetworkView(a(context, (WebView) sapiWebView));
    }

    public static void b(Context context, SapiWebView sapiWebView) {
        try {
            ProgressBar progressBar = new ProgressBar(context, null, 16842872);
            progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, SapiUtils.dip2px(context, 2.0f), 0, 0));
            progressBar.setBackgroundColor(context.getResources().getColor(R.color.sapi_sdk_dark_mode_color));
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

    public static void a(Context context, SapiWebView sapiWebView, View view2) {
        if (sapiWebView == null) {
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
        sapiWebView.setWebviewLoadingView(view2);
    }

    public static void a(Context context, SapiWebView sapiWebView, boolean z) {
        if (sapiWebView == null) {
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
}
