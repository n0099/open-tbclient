package com.baidu.tbadk.core.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.message.NetWorkChangeMessage;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class a extends BroadcastReceiver {
    public int a = -1;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
            NoNetworkView.setIsHasNetwork(z);
            if (z) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    if (this.a != 1) {
                        if (this.a != -1) {
                            bf.a().b(true);
                            MessageManager.getInstance().dispatchResponsedMessage(new NetWorkChangeMessage(1));
                        }
                        this.a = 1;
                    }
                } else if (this.a != 2) {
                    if (this.a != -1) {
                        bf.a().b(false);
                        MessageManager.getInstance().dispatchResponsedMessage(new NetWorkChangeMessage(2));
                    }
                    this.a = 2;
                }
            } else if (this.a != 0) {
                this.a = 0;
                MessageManager.getInstance().dispatchResponsedMessage(new NetWorkChangeMessage(0));
            }
            CompatibleUtile.dealWebView();
        } catch (Throwable th) {
            BdLog.e("NetworkChangeReceiver", "onReceiver", th.getMessage());
        }
    }
}
