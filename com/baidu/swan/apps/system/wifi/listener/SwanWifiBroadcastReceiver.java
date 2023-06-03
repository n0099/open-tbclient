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
import com.baidu.tieba.pm3;
import com.baidu.tieba.qm3;
import com.baidu.tieba.rm3;
/* loaded from: classes4.dex */
public class SwanWifiBroadcastReceiver extends BroadcastReceiver {
    public pm3 mConnectListener;
    public qm3 mConnectSuccessListener;
    public rm3 mScanListener;
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

    public void setConnectListener(pm3 pm3Var) {
        this.mConnectListener = pm3Var;
    }

    public void setConnectSuccessListener(qm3 qm3Var) {
        this.mConnectSuccessListener = qm3Var;
    }

    public void setScanListener(rm3 rm3Var) {
        this.mScanListener = rm3Var;
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
        pm3 pm3Var;
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
                        pm3 pm3Var2 = this.mConnectListener;
                        if (pm3Var2 != null) {
                            pm3Var2.a(wifiInfo);
                        }
                        qm3 qm3Var = this.mConnectSuccessListener;
                        if (qm3Var != null && this.mIsWifiDisconnected) {
                            qm3Var.a(wifiInfo);
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
            } else if (intent.getIntExtra("supplicantError", -1) == 1 && (pm3Var = this.mConnectListener) != null) {
                pm3Var.onError(1);
                return;
            } else {
                return;
            }
        }
        rm3 rm3Var = this.mScanListener;
        if (rm3Var != null) {
            rm3Var.a(this.mWifiManager.getScanResults());
        }
    }
}
