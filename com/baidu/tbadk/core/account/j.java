package com.baidu.tbadk.core.account;

import android.content.Context;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class j {
    public static void a(Context context, SapiWebView sapiWebView) {
        d(context, sapiWebView);
        b(context, sapiWebView);
        c(context, sapiWebView);
    }

    public static void b(Context context, SapiWebView sapiWebView) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(context, x.layout_sapi_network_unavailable, null);
        inflate.findViewById(w.btn_network_settings).setOnClickListener(new k(context));
        sapiWebView.setNoNetworkView(inflate);
    }

    public static void c(Context context, SapiWebView sapiWebView) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(context, x.layout_sapi_loading_timeout, null);
        inflate.findViewById(w.btn_retry).setOnClickListener(new l(sapiWebView, inflate));
        sapiWebView.setTimeoutView(inflate);
    }

    public static void d(Context context, SapiWebView sapiWebView) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(u.ds8);
        ProgressBar progressBar = new ProgressBar(context, null, 16842872);
        progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, dimensionPixelSize, 0, 0));
        sapiWebView.setProgressBar(progressBar);
    }
}
