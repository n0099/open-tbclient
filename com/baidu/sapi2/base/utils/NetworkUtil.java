package com.baidu.sapi2.base.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.sapi2.base.debug.Log;
/* loaded from: classes.dex */
public class NetworkUtil {
    public static boolean isNetworkAvaliable(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        } catch (Throwable th) {
            Log.e(th);
            return false;
        }
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            Log.w("getActiveNetworkInfo", " getActiveNetworkInfo NullPointerException--- \n" + e.getMessage());
            return null;
        }
    }
}
