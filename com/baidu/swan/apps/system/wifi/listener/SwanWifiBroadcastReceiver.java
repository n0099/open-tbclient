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
import com.baidu.tieba.oi3;
import com.baidu.tieba.pi3;
import com.baidu.tieba.qi3;
/* loaded from: classes3.dex */
public class SwanWifiBroadcastReceiver extends BroadcastReceiver {
    public oi3 mConnectListener;
    public pi3 mConnectSuccessListener;
    public qi3 mScanListener;
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

    public void setConnectListener(oi3 oi3Var) {
        this.mConnectListener = oi3Var;
    }

    public void setConnectSuccessListener(pi3 pi3Var) {
        this.mConnectSuccessListener = pi3Var;
    }

    public void setScanListener(qi3 qi3Var) {
        this.mScanListener = qi3Var;
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
        oi3 oi3Var;
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
                        oi3 oi3Var2 = this.mConnectListener;
                        if (oi3Var2 != null) {
                            oi3Var2.a(wifiInfo);
                        }
                        pi3 pi3Var = this.mConnectSuccessListener;
                        if (pi3Var != null && this.mIsWifiDisconnected) {
                            pi3Var.a(wifiInfo);
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
            } else if (intent.getIntExtra("supplicantError", -1) == 1 && (oi3Var = this.mConnectListener) != null) {
                oi3Var.onError(1);
                return;
            } else {
                return;
            }
        }
        qi3 qi3Var = this.mScanListener;
        if (qi3Var != null) {
            qi3Var.a(this.mWifiManager.getScanResults());
        }
    }
}
