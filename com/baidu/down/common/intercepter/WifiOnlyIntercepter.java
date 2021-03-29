package com.baidu.down.common.intercepter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes.dex */
public class WifiOnlyIntercepter implements IIntercepter<Void> {
    public static NetworkInfo getActiveNetworkInfoSafely(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isWifiNetWork(Context context) {
        NetworkInfo activeNetworkInfoSafely = getActiveNetworkInfoSafely(context);
        return activeNetworkInfoSafely != null && activeNetworkInfoSafely.isAvailable() && activeNetworkInfoSafely.getTypeName().toLowerCase().equalsIgnoreCase("wifi");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.down.common.intercepter.IIntercepter
    public InterceptResult process(Context context, String str, long j, Void r5) {
        if (isWifiNetWork(context)) {
            return null;
        }
        return new InterceptResult(1);
    }
}
