package com.baidu.tbadk.core.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ProgressBar;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    public static void addCustomView(Context context, SapiWebView sapiWebView) {
        setProgressBar(context, sapiWebView);
        setNoNetworkView(context, sapiWebView);
        setTimeoutView(context, sapiWebView);
    }

    public static void setNoNetworkView(final Context context, SapiWebView sapiWebView) {
        View inflate = LayoutInflater.from(context).inflate(d.i.layout_sapi_network_unavailable, (ViewGroup) null);
        inflate.findViewById(d.g.btn_network_settings).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent("android.settings.SETTINGS");
                intent.setFlags(270532608);
                context.startActivity(intent);
            }
        });
        sapiWebView.setNoNetworkView(inflate);
    }

    public static void setTimeoutView(Context context, final SapiWebView sapiWebView) {
        final View inflate = LayoutInflater.from(context).inflate(d.i.layout_sapi_loading_timeout, (ViewGroup) null);
        inflate.findViewById(d.g.btn_retry).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.core.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                SapiWebView.this.post(new Runnable() { // from class: com.baidu.tbadk.core.a.d.2.1
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

    public static void setProgressBar(Context context, SapiWebView sapiWebView) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.ds8);
        ProgressBar progressBar = new ProgressBar(context, null, 16842872);
        progressBar.setLayoutParams(new AbsoluteLayout.LayoutParams(-1, dimensionPixelSize, 0, 0));
        sapiWebView.setProgressBar(progressBar);
    }
}
