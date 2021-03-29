package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static TelephonyManager f4693a;

    /* renamed from: b  reason: collision with root package name */
    public static ConnectivityManager f4694b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f4695c;

    public static String a() {
        NetworkInfo activeNetworkInfo;
        String str = "\n";
        StringBuilder sb = new StringBuilder();
        try {
            if (f4694b == null) {
                f4694b = (ConnectivityManager) f4695c.getSystemService("connectivity");
            }
            activeNetworkInfo = f4694b.getActiveNetworkInfo();
        } catch (RuntimeException e2) {
            com.baidu.crabsdk.c.a.a("getNetworkInfo", e2);
        }
        if (activeNetworkInfo == null) {
            return "N/A";
        }
        if (activeNetworkInfo.isConnected()) {
            sb.append("type: ");
            sb.append(activeNetworkInfo.getTypeName());
            sb.append("\n");
            if (activeNetworkInfo.getType() == 0) {
                sb.append("subType: ");
                sb.append(activeNetworkInfo.getSubtypeName());
                sb.append("\n");
                if (f4693a == null) {
                    f4693a = (TelephonyManager) f4695c.getSystemService("phone");
                }
                sb.append("isRoaming: ");
                sb.append(f4693a.isNetworkRoaming() ? "yes" : "no");
            }
            return sb.toString();
        }
        str = "type: none\n";
        sb.append(str);
        return sb.toString();
    }

    public static String b() {
        try {
            if (f4694b == null) {
                f4694b = (ConnectivityManager) f4695c.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = f4694b.getActiveNetworkInfo();
            return activeNetworkInfo == null ? RomUtils.UNKNOWN : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
        } catch (RuntimeException unused) {
            return RomUtils.UNKNOWN;
        }
    }

    public static void c(Context context) {
        f4695c = context;
    }
}
