package com.baidu.adp.lib.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class BdNetUtil {

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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x008a */
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
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) BdBaseApplication.getInst().getApp().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkStateInfo = NetworkStateInfo.UNAVAIL;
                try {
                    e = "NetWorkCore";
                    BdLog.i("NetWorkCore", "NetworkStateInfo", "UNAVAIL");
                } catch (Exception e2) {
                    e = e2;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                BdLog.i("NetWorkCore", "NetworkStateInfo", NetworkChangeReceiver.WIFI_STRING);
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) BdBaseApplication.getInst().getApp().getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        BdLog.i("NetWorkCore", "NetworkStateInfo", "TwoG");
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
                    case DealIntentService.CLASS_TYPE_GROUP_EVENT /* 14 */:
                    case 15:
                        BdLog.i("NetWorkCore", "NetworkStateInfo", "ThreeG");
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        BdLog.i("NetWorkCore", "NetworkStateInfo-default", "TwoG");
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
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) BdBaseApplication.getInst().getApp().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                netTpyeEnmu = NetTpyeEnmu.UNAVAIL;
            } else if (activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkChangeReceiver.WIFI_STRING)) {
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
