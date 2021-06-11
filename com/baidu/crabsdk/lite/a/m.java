package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes2.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static TelephonyManager f4681a;

    /* renamed from: b  reason: collision with root package name */
    public static ConnectivityManager f4682b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f4683c;

    public static void a(Context context) {
        f4683c = context;
    }

    public static String b() {
        try {
            if (f4682b == null) {
                f4682b = (ConnectivityManager) f4683c.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = f4682b.getActiveNetworkInfo();
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
            if (f4682b == null) {
                f4682b = (ConnectivityManager) f4683c.getSystemService("connectivity");
            }
            activeNetworkInfo = f4682b.getActiveNetworkInfo();
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
                if (f4681a == null) {
                    f4681a = (TelephonyManager) f4683c.getSystemService("phone");
                }
                sb.append("isRoaming: ");
                sb.append(f4681a.isNetworkRoaming() ? "yes" : "no");
            }
            return sb.toString();
        }
        str2 = "type: none\n";
        sb.append(str2);
        return sb.toString();
    }
}
