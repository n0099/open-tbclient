package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static TelephonyManager f4772a;

    /* renamed from: b  reason: collision with root package name */
    public static ConnectivityManager f4773b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f4774c;

    public static void a(Context context) {
        f4774c = context;
    }

    public static String b() {
        try {
            if (f4773b == null) {
                f4773b = (ConnectivityManager) f4774c.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = f4773b.getActiveNetworkInfo();
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
            if (f4773b == null) {
                f4773b = (ConnectivityManager) f4774c.getSystemService("connectivity");
            }
            activeNetworkInfo = f4773b.getActiveNetworkInfo();
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
                if (f4772a == null) {
                    f4772a = (TelephonyManager) f4774c.getSystemService("phone");
                }
                sb.append("isRoaming: ");
                sb.append(f4772a.isNetworkRoaming() ? "yes" : "no");
            }
            return sb.toString();
        }
        str2 = "type: none\n";
        sb.append(str2);
        return sb.toString();
    }
}
