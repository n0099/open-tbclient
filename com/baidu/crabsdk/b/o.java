package com.baidu.crabsdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static TelephonyManager f4840a;

    /* renamed from: b  reason: collision with root package name */
    public static ConnectivityManager f4841b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f4842c;

    public static String a() {
        NetworkInfo activeNetworkInfo;
        String str = "\n";
        StringBuilder sb = new StringBuilder();
        try {
            if (f4841b == null) {
                f4841b = (ConnectivityManager) f4842c.getSystemService("connectivity");
            }
            activeNetworkInfo = f4841b.getActiveNetworkInfo();
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
                if (f4840a == null) {
                    f4840a = (TelephonyManager) f4842c.getSystemService("phone");
                }
                sb.append("isRoaming: ");
                sb.append(f4840a.isNetworkRoaming() ? "yes" : "no");
            }
            return sb.toString();
        }
        str = "type: none\n";
        sb.append(str);
        return sb.toString();
    }

    public static String b() {
        try {
            if (f4841b == null) {
                f4841b = (ConnectivityManager) f4842c.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = f4841b.getActiveNetworkInfo();
            return activeNetworkInfo == null ? RomUtils.UNKNOWN : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
        } catch (RuntimeException unused) {
            return RomUtils.UNKNOWN;
        }
    }

    public static void c(Context context) {
        f4842c = context;
    }
}
