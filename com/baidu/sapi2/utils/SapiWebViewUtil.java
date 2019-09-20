package com.baidu.sapi2.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.baidu.d.a.a;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.views.SweepLightLoadingView;
/* loaded from: classes2.dex */
public class SapiWebViewUtil {
    public static void addCustomView(Context context, SapiWebView sapiWebView, boolean z) {
        setNoNetworkView(context, sapiWebView);
        setTimeoutView(context, sapiWebView);
        if (z) {
            setSweepLightLoadingView(context, sapiWebView);
        } else {
            setProgressBar(context, sapiWebView);
        }
    }

    private static void setNoNetworkView(Context context, SapiWebView sapiWebView) {
        sapiWebView.setNoNetworkView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(a.f.layout_sapi_sdk_network_unavailable, (ViewGroup) null));
    }

    private static void setTimeoutView(Context context, final SapiWebView sapiWebView) {
        final View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(a.f.layout_sapi_sdk_loading_timeout, (ViewGroup) null);
        inflate.findViewById(a.e.btn_retry).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.sapi2.utils.SapiWebViewUtil.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.sapi2.utils.SapiWebViewUtil.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        inflate.setVisibility(4);
                        SapiWebView.this.reload();
                    }
                });
            }
        });
        sapiWebView.setTimeoutView(inflate);
    }

    private static void setSweepLightLoadingView(Context context, SapiWebView sapiWebView) {
        sapiWebView.setWebviewLoadingView(new SweepLightLoadingView(context));
    }

    private static void setProgressBar(Context context, SapiWebView sapiWebView) {
        try {
            ProgressBar progressBar = new ProgressBar(context, null, 16842872);
            progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, SapiUtils.dip2px(context, 2.0f), 0, 0));
            sapiWebView.setProgressBar(progressBar);
        } catch (Throwable th) {
            Log.e(th);
        }
    }
}
