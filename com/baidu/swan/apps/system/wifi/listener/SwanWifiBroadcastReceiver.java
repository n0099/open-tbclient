package com.baidu.swan.apps.system.wifi.listener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Parcelable;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.tieba.bh3;
import com.baidu.tieba.ch3;
import com.baidu.tieba.dh3;
/* loaded from: classes4.dex */
public class SwanWifiBroadcastReceiver extends BroadcastReceiver {
    public bh3 mConnectListener;
    public ch3 mConnectSuccessListener;
    public dh3 mScanListener;
    public WifiManager mWifiManager;
    public boolean mIsWifiDisconnected = true;
    public boolean mIsRegistered = false;

    public SwanWifiBroadcastReceiver(WifiManager wifiManager) {
        this.mWifiManager = wifiManager;
    }

    public synchronized void registerSelf(Context context) {
        if (context != null) {
            if (!this.mIsRegistered) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
                intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
                intentFilter.addAction(McastConfig.ACTION_NETWORK_STATE_CHANGED);
                context.registerReceiver(this, intentFilter);
                this.mIsRegistered = true;
            }
        }
    }

    public void setConnectListener(bh3 bh3Var) {
        this.mConnectListener = bh3Var;
    }

    public void setConnectSuccessListener(ch3 ch3Var) {
        this.mConnectSuccessListener = ch3Var;
    }

    public void setScanListener(dh3 dh3Var) {
        this.mScanListener = dh3Var;
    }

    public synchronized void unregisterSelf(Context context) {
        if (context != null) {
            if (this.mIsRegistered) {
                context.unregisterReceiver(this);
                this.mIsRegistered = false;
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        char c;
        bh3 bh3Var;
        if (intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        int hashCode = action.hashCode();
        if (hashCode != -343630553) {
            if (hashCode != 233521600) {
                if (hashCode == 1878357501 && action.equals("android.net.wifi.SCAN_RESULTS")) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (action.equals("android.net.wifi.supplicant.STATE_CHANGE")) {
                    c = 1;
                }
                c = 65535;
            }
        } else {
            if (action.equals(McastConfig.ACTION_NETWORK_STATE_CHANGED)) {
                c = 2;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c == 2) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                    WifiInfo wifiInfo = (WifiInfo) intent.getParcelableExtra("wifiInfo");
                    if (parcelableExtra != null && ((NetworkInfo) parcelableExtra).getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
                        if (!this.mIsWifiDisconnected) {
                            return;
                        }
                        bh3 bh3Var2 = this.mConnectListener;
                        if (bh3Var2 != null) {
                            bh3Var2.a(wifiInfo);
                        }
                        ch3 ch3Var = this.mConnectSuccessListener;
                        if (ch3Var != null && this.mIsWifiDisconnected) {
                            ch3Var.a(wifiInfo);
                        }
                        this.mIsWifiDisconnected = false;
                    }
                    if (parcelableExtra != null && ((NetworkInfo) parcelableExtra).getDetailedState() == NetworkInfo.DetailedState.DISCONNECTED) {
                        this.mIsWifiDisconnected = true;
                        return;
                    }
                    return;
                }
                return;
            } else if (intent.getIntExtra("supplicantError", -1) == 1 && (bh3Var = this.mConnectListener) != null) {
                bh3Var.onError(1);
                return;
            } else {
                return;
            }
        }
        dh3 dh3Var = this.mScanListener;
        if (dh3Var != null) {
            dh3Var.a(this.mWifiManager.getScanResults());
        }
    }
}
