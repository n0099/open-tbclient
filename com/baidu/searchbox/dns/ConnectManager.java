package com.baidu.searchbox.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.util.DnsUtil;
/* loaded from: classes3.dex */
public class ConnectManager {
    public static long DELAY = 5000;
    public static String NET_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    public static volatile ConnectManager mInstance;
    public boolean isConnected;
    public boolean isWifi;
    public long lastConnectedTime;
    public long lastWifiTime;
    public ConnectivityManager mConnectivityManager;
    public Context mContext;
    public boolean mIsInit = false;
    public ConncetStatusReceiver mReceiver;

    /* loaded from: classes3.dex */
    public class ConncetStatusReceiver extends BroadcastReceiver {
        public ConncetStatusReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectManager connectManager = ConnectManager.this;
            connectManager.isConnected = connectManager.isNetWorkEnable();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " action: " + intent.getAction() + " isConnected: " + ConnectManager.this.isConnected + " isSticky: " + isInitialStickyBroadcast());
            }
            DnsUtil.initNetworkStackType();
            if (ConnectManager.this.isConnected && !isInitialStickyBroadcast()) {
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, "clear dns cache and force update domain");
                }
                DnsCacheHelper.getCacheHelper().clear();
                DnsEngine.forceUpdateDomain();
            }
        }
    }

    public ConnectManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static ConnectManager initInstance(Context context) {
        if (mInstance == null) {
            synchronized (ConnectManager.class) {
                if (mInstance == null) {
                    mInstance = new ConnectManager(context);
                }
            }
        }
        return mInstance;
    }

    public static ConnectManager getInstance() {
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNetWorkEnable() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public synchronized void exit() {
        if (this.mIsInit) {
            this.mContext.unregisterReceiver(this.mReceiver);
            this.mIsInit = false;
        }
    }

    public boolean isWifiEnabled() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    public synchronized void init() {
        if (!this.mIsInit) {
            if (this.mContext == null) {
                this.mContext = AppRuntime.getAppContext();
            }
            if (this.mContext == null) {
                this.mIsInit = false;
                return;
            }
            this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NET_CHANGE_ACTION);
            ConncetStatusReceiver conncetStatusReceiver = new ConncetStatusReceiver();
            this.mReceiver = conncetStatusReceiver;
            this.mContext.registerReceiver(conncetStatusReceiver, intentFilter);
            this.mIsInit = true;
        }
    }

    public boolean isConnected() {
        if (System.currentTimeMillis() - this.lastConnectedTime > DELAY) {
            this.isConnected = isNetWorkEnable();
            this.lastConnectedTime = System.currentTimeMillis();
        }
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " is network connect: " + this.isConnected);
        }
        return this.isConnected;
    }

    public boolean isWifi() {
        if (System.currentTimeMillis() - this.lastWifiTime > DELAY) {
            this.isWifi = isWifiEnabled();
            this.lastWifiTime = System.currentTimeMillis();
        }
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " is wifi network: " + this.isWifi);
        }
        return this.isWifi;
    }
}
