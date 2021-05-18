package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static TelephonyManager f4739a;

    /* renamed from: b  reason: collision with root package name */
    public static ConnectivityManager f4740b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f4741c;

    public static void a(Context context) {
        f4741c = context;
    }

    public static String b() {
        try {
            if (f4740b == null) {
                f4740b = (ConnectivityManager) f4741c.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = f4740b.getActiveNetworkInfo();
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
            if (f4740b == null) {
                f4740b = (ConnectivityManager) f4741c.getSystemService("connectivity");
            }
            activeNetworkInfo = f4740b.getActiveNetworkInfo();
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
                if (f4739a == null) {
                    f4739a = (TelephonyManager) f4741c.getSystemService("phone");
                }
                sb.append("isRoaming: ");
                sb.append(f4739a.isNetworkRoaming() ? "yes" : "no");
            }
            return sb.toString();
        }
        str2 = "type: none\n";
        sb.append(str2);
        return sb.toString();
    }
}
