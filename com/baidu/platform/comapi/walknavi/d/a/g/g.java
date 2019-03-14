package com.baidu.platform.comapi.walknavi.d.a.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* loaded from: classes5.dex */
public final class g {
    public static NetworkInfo a(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }
}
