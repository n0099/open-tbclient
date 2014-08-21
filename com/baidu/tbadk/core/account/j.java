package com.baidu.tbadk.core.account;

import android.content.Context;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class j {
    public static void a(Context context, SapiWebView sapiWebView) {
        d(context, sapiWebView);
        b(context, sapiWebView);
        c(context, sapiWebView);
    }

    public static void b(Context context, SapiWebView sapiWebView) {
        View a = com.baidu.adp.lib.e.b.a().a(context, v.layout_sapi_network_unavailable, null);
        a.findViewById(u.btn_network_settings).setOnClickListener(new k(context));
        sapiWebView.setNoNetworkView(a);
    }

    public static void c(Context context, SapiWebView sapiWebView) {
        View a = com.baidu.adp.lib.e.b.a().a(context, v.layout_sapi_loading_timeout, null);
        a.findViewById(u.btn_retry).setOnClickListener(new l(sapiWebView, a));
        sapiWebView.setTimeoutView(a);
    }

    public static void d(Context context, SapiWebView sapiWebView) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(s.ds8);
        ProgressBar progressBar = new ProgressBar(context, null, 16842872);
        progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, dimensionPixelSize, 0, 0));
        sapiWebView.setProgressBar(progressBar);
    }
}
