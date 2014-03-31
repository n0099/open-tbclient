package com.baidu.tbadk.core.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public final class a extends BroadcastReceiver {
    public int a = -1;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
            NoNetworkView.setIsHasNetwork(z);
            if (z) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    if (this.a != 1) {
                        if (this.a != -1) {
                            bd.a().a(true);
                            Integer.valueOf(1);
                            com.baidu.adp.framework.c.a().a(new com.baidu.tbadk.core.message.a());
                        }
                        this.a = 1;
                    }
                } else if (this.a != 2) {
                    if (this.a != -1) {
                        bd.a().a(false);
                        Integer.valueOf(2);
                        com.baidu.adp.framework.c.a().a(new com.baidu.tbadk.core.message.a());
                    }
                    this.a = 2;
                }
            } else if (this.a != 0) {
                this.a = 0;
                Integer.valueOf(0);
                com.baidu.adp.framework.c.a().a(new com.baidu.tbadk.core.message.a());
            }
            CompatibleUtile.dealWebView();
        } catch (Throwable th) {
            f.b("NetworkChangeReceiver", "onReceiver", th.getMessage());
        }
    }
}
