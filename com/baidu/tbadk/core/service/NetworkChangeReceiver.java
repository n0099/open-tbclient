package com.baidu.tbadk.core.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.message.NetWorkChangeMessage;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class NetworkChangeReceiver extends BroadcastReceiver {
    public static final int MOBILE = 2;
    public static final int NOTSET = -1;
    public static final int UNAVAIL = 0;
    public static final int WIFI = 1;
    public static final String WIFI_STRING = "WIFI";
    public int NETWORK_STATUS = -1;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
            NoNetworkView.setIsHasNetwork(z);
            if (z) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase(WIFI_STRING)) {
                    if (this.NETWORK_STATUS != 1) {
                        if (this.NETWORK_STATUS != -1) {
                            bg.pB().ao(true);
                            MessageManager.getInstance().dispatchResponsedMessage(new NetWorkChangeMessage(1));
                        }
                        this.NETWORK_STATUS = 1;
                    }
                } else if (this.NETWORK_STATUS != 2) {
                    if (this.NETWORK_STATUS != -1) {
                        bg.pB().ao(false);
                        MessageManager.getInstance().dispatchResponsedMessage(new NetWorkChangeMessage(2));
                    }
                    this.NETWORK_STATUS = 2;
                }
            } else if (this.NETWORK_STATUS != 0) {
                this.NETWORK_STATUS = 0;
                MessageManager.getInstance().dispatchResponsedMessage(new NetWorkChangeMessage(0));
            }
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
