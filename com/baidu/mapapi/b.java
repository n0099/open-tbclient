package com.baidu.mapapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        Mj.s = activeNetworkInfo != null ? (wifiManager.getWifiState() == 3 && "WIFI".matches(activeNetworkInfo.getTypeName())) ? 1 : 0 : networkInfo == null ? -1 : (wifiManager.getWifiState() == 3 && "WIFI".matches(networkInfo.getTypeName())) ? 1 : 0;
        Bundle bundle = new Bundle();
        bundle.putInt("opt", 15010902);
        bundle.putInt("act", 15010900);
        bundle.putInt("state", Mj.s);
        Mj.sendBundle(bundle);
        if (-1 != Mj.s) {
            Mj.changeGprsConnect();
        }
    }
}
