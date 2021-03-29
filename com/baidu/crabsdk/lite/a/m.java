package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static TelephonyManager f4737a;

    /* renamed from: b  reason: collision with root package name */
    public static ConnectivityManager f4738b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f4739c;

    public static void a(Context context) {
        f4739c = context;
    }

    public static String b() {
        try {
            if (f4738b == null) {
                f4738b = (ConnectivityManager) f4739c.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = f4738b.getActiveNetworkInfo();
            return activeNetworkInfo == null ? RomUtils.UNKNOWN : !activeNetworkInfo.isConnected() ? "NONE" : activeNetworkInfo.getTypeName().toUpperCase();
        } catch (RuntimeException unused) {
            return RomUtils.UNKNOWN;
        }
    }

    public static String c(String str) {
        NetworkInfo activeNetworkInfo;
        String str2 = "\n";
        StringBuilder sb = new StringBuilder();
        try {
            if (f4738b == null) {
                f4738b = (ConnectivityManager) f4739c.getSystemService("connectivity");
            }
            activeNetworkInfo = f4738b.getActiveNetworkInfo();
        } catch (RuntimeException e2) {
            com.baidu.crabsdk.lite.b.a.e(str, "getNetworkInfo", e2);
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
                if (f4737a == null) {
                    f4737a = (TelephonyManager) f4739c.getSystemService("phone");
                }
                sb.append("isRoaming: ");
                sb.append(f4737a.isNetworkRoaming() ? "yes" : "no");
            }
            return sb.toString();
        }
        str2 = "type: none\n";
        sb.append(str2);
        return sb.toString();
    }
}
