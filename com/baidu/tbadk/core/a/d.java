package com.baidu.tbadk.core.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class d {
    public static void a(Context context, SapiWebView sapiWebView) {
        d(context, sapiWebView);
        b(context, sapiWebView);
        c(context, sapiWebView);
    }

    public static void b(Context context, SapiWebView sapiWebView) {
        View inflate = LayoutInflater.from(context).inflate(i.g.layout_sapi_network_unavailable, (ViewGroup) null);
        inflate.findViewById(i.f.btn_network_settings).setOnClickListener(new e(context));
        sapiWebView.setNoNetworkView(inflate);
    }

    public static void c(Context context, SapiWebView sapiWebView) {
        View inflate = LayoutInflater.from(context).inflate(i.g.layout_sapi_loading_timeout, (ViewGroup) null);
        inflate.findViewById(i.f.btn_retry).setOnClickListener(new f(sapiWebView, inflate));
        sapiWebView.setTimeoutView(inflate);
    }

    public static void d(Context context, SapiWebView sapiWebView) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i.d.ds8);
        ProgressBar progressBar = new ProgressBar(context, null, 16842872);
        progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, dimensionPixelSize, 0, 0));
        sapiWebView.setProgressBar(progressBar);
    }
}
