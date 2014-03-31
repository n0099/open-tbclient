package com.baidu.adp.lib.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
/* loaded from: classes.dex */
public final class BdNetUtil {

    /* loaded from: classes.dex */
    public enum NetTpyeEnmu {
        UNAVAIL,
        WIFI,
        NET,
        WAP;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetTpyeEnmu[] valuesCustom() {
            NetTpyeEnmu[] valuesCustom = values();
            int length = valuesCustom.length;
            NetTpyeEnmu[] netTpyeEnmuArr = new NetTpyeEnmu[length];
            System.arraycopy(valuesCustom, 0, netTpyeEnmuArr, 0, length);
            return netTpyeEnmuArr;
        }
    }

    /* loaded from: classes.dex */
    public enum NetworkStateInfo {
        UNAVAIL,
        WIFI,
        TwoG,
        ThreeG;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetworkStateInfo[] valuesCustom() {
            NetworkStateInfo[] valuesCustom = values();
            int length = valuesCustom.length;
            NetworkStateInfo[] networkStateInfoArr = new NetworkStateInfo[length];
            System.arraycopy(valuesCustom, 0, networkStateInfoArr, 0, length);
            return networkStateInfoArr;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0079 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0002 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.adp.lib.util.BdNetUtil$NetworkStateInfo] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    public static NetworkStateInfo a() {
        NetworkStateInfo networkStateInfo;
        ?? e = NetworkStateInfo.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.baidu.adp.a.b.a().b().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkStateInfo = NetworkStateInfo.UNAVAIL;
                try {
                    e = "NetWorkCore";
                    f.a("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e2) {
                    e = e2;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                f.a("NetWorkCore", "NetworkStateInfo", "WIFI");
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) com.baidu.adp.a.b.a().b().getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        f.a("NetWorkCore", "NetworkStateInfo", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        f.a("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        f.a("NetWorkCore", "NetworkStateInfo-default", "TwoG");
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                }
            }
            return networkStateInfo;
        } catch (Exception e3) {
            return e;
        }
    }

    public static NetTpyeEnmu b() {
        NetTpyeEnmu netTpyeEnmu;
        NetTpyeEnmu netTpyeEnmu2 = NetTpyeEnmu.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.baidu.adp.a.b.a().b().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                netTpyeEnmu = NetTpyeEnmu.UNAVAIL;
            } else if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                netTpyeEnmu = NetTpyeEnmu.WIFI;
            } else {
                String defaultHost = Proxy.getDefaultHost();
                if (defaultHost != null && defaultHost.length() > 0) {
                    netTpyeEnmu = NetTpyeEnmu.WAP;
                } else {
                    netTpyeEnmu = NetTpyeEnmu.NET;
                }
            }
            return netTpyeEnmu;
        } catch (Exception e) {
            e.printStackTrace();
            return netTpyeEnmu2;
        }
    }
}
