package com.baidu.mobads.container.components.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.baidu.mobads.container.util.XAdRemoteEvent;
/* loaded from: classes2.dex */
public class OAdBasicNetworkController extends OAdBasicReceivableController {
    public static final String NETWORK_CHANGED = "network_changed";
    public static final String TAG = "BasicNetworkController";
    public IntentFilter mFilter;
    public int mNetworkListenerCount;
    public OAdBasicNetworkBroadcastReceiver mReceiver;

    public OAdBasicNetworkController(Context context) {
        super(context);
    }

    public void onConnectionChanged() {
        dispatchEvent(new XAdRemoteEvent(NETWORK_CHANGED));
    }

    @Override // com.baidu.mobads.container.components.controller.OAdBasicReceivableController
    public void setBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        this.mReceiver = (OAdBasicNetworkBroadcastReceiver) broadcastReceiver;
    }

    @Override // com.baidu.mobads.container.components.controller.OAdBasicController
    public void startListener() {
        if (this.mNetworkListenerCount == 0) {
            if (this.mReceiver == null) {
                setBroadcastReceiver(new OAdBasicNetworkBroadcastReceiver(this));
            }
            IntentFilter intentFilter = new IntentFilter();
            this.mFilter = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        this.mNetworkListenerCount++;
        this.mContext.registerReceiver(this.mReceiver, this.mFilter);
    }

    @Override // com.baidu.mobads.container.components.controller.OAdBasicController
    public void stopListeners() {
        this.mNetworkListenerCount = 0;
        try {
            this.mContext.unregisterReceiver(this.mReceiver);
        } catch (Exception unused) {
        }
    }
}
