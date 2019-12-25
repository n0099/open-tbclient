package com.baidu.down.common.intercepter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes4.dex */
public class WifiOnlyIntercepter implements IIntercepter<Void> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.down.common.intercepter.IIntercepter
    public InterceptResult process(Context context, String str, long j, Void r7) {
        if (isWifiNetWork(context)) {
            return null;
        }
        return new InterceptResult(1);
    }

    private static boolean isWifiNetWork(Context context) {
        NetworkInfo activeNetworkInfoSafely = getActiveNetworkInfoSafely(context);
        return activeNetworkInfoSafely != null && activeNetworkInfoSafely.isAvailable() && activeNetworkInfoSafely.getTypeName().toLowerCase().equalsIgnoreCase("wifi");
    }

    public static NetworkInfo getActiveNetworkInfoSafely(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            return null;
        }
    }
}
