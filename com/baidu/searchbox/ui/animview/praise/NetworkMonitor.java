package com.baidu.searchbox.ui.animview.praise;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class NetworkMonitor {
    public static final String NET_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public ConnectivityManager mConnectivityManager;
    public Context mContext;
    public boolean mIsInit = false;
    public INetworkMonitorCb mNetworkMonitorCb;
    public ConnectStatusReceiver mReceiver;

    /* loaded from: classes4.dex */
    public interface INetworkMonitorCb {
        void onNetworkStateChanged();
    }

    /* loaded from: classes4.dex */
    public static class ConnectStatusReceiver extends BroadcastReceiver {
        public WeakReference<INetworkMonitorCb> mINetworkMonitorCb;

        public ConnectStatusReceiver(INetworkMonitorCb iNetworkMonitorCb) {
            this.mINetworkMonitorCb = new WeakReference<>(iNetworkMonitorCb);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WeakReference<INetworkMonitorCb> weakReference = this.mINetworkMonitorCb;
            if (weakReference != null && weakReference.get() != null) {
                this.mINetworkMonitorCb.get().onNetworkStateChanged();
            }
        }
    }

    public NetworkMonitor(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void setNetworkMonitorCb(INetworkMonitorCb iNetworkMonitorCb) {
        this.mNetworkMonitorCb = iNetworkMonitorCb;
    }

    public void init() {
        if (!this.mIsInit) {
            this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NET_CHANGE_ACTION);
            ConnectStatusReceiver connectStatusReceiver = new ConnectStatusReceiver(this.mNetworkMonitorCb);
            this.mReceiver = connectStatusReceiver;
            this.mContext.registerReceiver(connectStatusReceiver, intentFilter);
            this.mIsInit = true;
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean isNetworkEnable() {
        NetworkInfo activeNetworkInfo;
        if (!this.mIsInit || (activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public void release() {
        if (this.mIsInit) {
            this.mContext.unregisterReceiver(this.mReceiver);
            this.mReceiver = null;
            this.mConnectivityManager = null;
            this.mIsInit = false;
        }
    }
}
