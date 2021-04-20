package com.baidu.mobads.container.components.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
public class OAdBasicNetworkBroadcastReceiver extends BroadcastReceiver {
    public OAdBasicNetworkController mController;

    public OAdBasicNetworkBroadcastReceiver(OAdBasicNetworkController oAdBasicNetworkController) {
        this.mController = oAdBasicNetworkController;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            this.mController.onConnectionChanged();
        }
    }
}
