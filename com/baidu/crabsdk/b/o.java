package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static TelephonyManager f4728a;

    /* renamed from: b  reason: collision with root package name */
    public static ConnectivityManager f4729b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f4730c;

    public static String a() {
        NetworkInfo activeNetworkInfo;
        String str = "\n";
        StringBuilder sb = new StringBuilder();
        try {
            if (f4729b == null) {
                f4729b = (ConnectivityManager) f4730c.getSystemService("connectivity");
            }
            activeNetworkInfo = f4729b.getActiveNetworkInfo();
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
                if (f4728a == null) {
                    f4728a = (TelephonyManager) f4730c.getSystemService("phone");
                }
                sb.append("isRoaming: ");
                sb.append(f4728a.isNetworkRoaming() ? "yes" : "no");
            }
            return sb.toString();
        }
        str = "type: none\n";
        sb.append(str);
        return sb.toString();
    }

    public static String b() {
        try {
            if (f4729b == null) {
                f4729b = (ConnectivityManager) f4730c.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = f4729b.getActiveNetworkInfo();
            return activeNetworkInfo == null ? RomUtils.UNKNOWN : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
        } catch (RuntimeException unused) {
            return RomUtils.UNKNOWN;
        }
    }

    public static void c(Context context) {
        f4730c = context;
    }
}
