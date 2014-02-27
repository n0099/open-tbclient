package com.baidu.adp.lib.stats;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class f {
    private static f a;
    private static int b = 20;
    private Context c;
    private ArrayList<BdStatsOpItem> d = new ArrayList<>();
    private ArrayList<BdStatsOpItem> e = new ArrayList<>();

    public static f a() {
        if (a == null) {
            a = new f();
        }
        return a;
    }

    public final String b() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.c.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return "WIFI";
            }
            if (type == 0) {
                int b2 = com.baidu.adp.lib.network.i.b();
                StringBuilder sb = new StringBuilder();
                switch (b2) {
                    case 1:
                        sb.append('M');
                        break;
                    case 2:
                        sb.append('U');
                        break;
                    case 3:
                        sb.append('T');
                        break;
                    default:
                        sb.append('N');
                        break;
                }
                if (activeNetworkInfo.getExtraInfo() != null && activeNetworkInfo.getExtraInfo().contains(com.baidu.loginshare.e.d)) {
                    sb.append("_WAP_");
                } else {
                    sb.append("_NET_");
                }
                TelephonyManager telephonyManager = (TelephonyManager) this.c.getSystemService("phone");
                if (telephonyManager != null) {
                    switch (telephonyManager.getNetworkType()) {
                        case 1:
                        case 2:
                        case 4:
                        case 5:
                            sb.append("2G");
                            break;
                        case 3:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            sb.append("3G");
                            break;
                        default:
                            sb.append('N');
                            break;
                    }
                }
                return sb.toString();
            }
        }
        return "unknown";
    }
}
