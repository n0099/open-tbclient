package com.baidu.searchbox.ui.animview.praise;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
public class NetworkMonitor {
    private static String NET_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private boolean mIsInit = false;
    private INetworkMonitorCb mNetworkMonitorCb;
    private ConncetStatusReceiver mReceiver;

    /* loaded from: classes13.dex */
    public interface INetworkMonitorCb {
        void onNetworkStateChanged();
    }

    public NetworkMonitor(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void init() {
        if (!this.mIsInit) {
            this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NET_CHANGE_ACTION);
            this.mReceiver = new ConncetStatusReceiver(this.mNetworkMonitorCb);
            this.mContext.registerReceiver(this.mReceiver, intentFilter);
            this.mIsInit = true;
        }
    }

    public void release() {
        if (this.mIsInit) {
            this.mContext.unregisterReceiver(this.mReceiver);
            this.mReceiver = null;
            this.mConnectivityManager = null;
            this.mIsInit = false;
        }
    }

    public void setNetworkMonitorCb(INetworkMonitorCb iNetworkMonitorCb) {
        this.mNetworkMonitorCb = iNetworkMonitorCb;
    }

    @SuppressLint({"MissingPermission"})
    public boolean isNetworkEnable() {
        NetworkInfo activeNetworkInfo;
        return this.mIsInit && (activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected();
    }

    /* loaded from: classes13.dex */
    private static class ConncetStatusReceiver extends BroadcastReceiver {
        private WeakReference<INetworkMonitorCb> mINetworkMonitorCb;

        public ConncetStatusReceiver(INetworkMonitorCb iNetworkMonitorCb) {
            this.mINetworkMonitorCb = new WeakReference<>(iNetworkMonitorCb);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (this.mINetworkMonitorCb != null && this.mINetworkMonitorCb.get() != null) {
                this.mINetworkMonitorCb.get().onNetworkStateChanged();
            }
        }
    }
}
