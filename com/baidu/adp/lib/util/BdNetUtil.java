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
    public enum NetTpyeEnum {
        UNAVAIL,
        WIFI,
        NET,
        WAP;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetTpyeEnum[] valuesCustom() {
            NetTpyeEnum[] valuesCustom = values();
            int length = valuesCustom.length;
            NetTpyeEnum[] netTpyeEnumArr = new NetTpyeEnum[length];
            System.arraycopy(valuesCustom, 0, netTpyeEnumArr, 0, length);
            return netTpyeEnumArr;
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

    public static NetworkStateInfo getStatusInfo() {
        NetworkStateInfo networkStateInfo;
        NetworkStateInfo networkStateInfo2 = NetworkStateInfo.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) BdBaseApplication.getInst().getApp().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!activeNetworkInfo.isAvailable()) {
                networkStateInfo = NetworkStateInfo.UNAVAIL;
            } else if (activeNetworkInfo.getType() == 1) {
                networkStateInfo = NetworkStateInfo.WIFI;
            } else {
                switch (((TelephonyManager) BdBaseApplication.getInst().getApp().getSystemService("phone")).getNetworkType()) {
                    case 0:
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
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
                        networkStateInfo = NetworkStateInfo.ThreeG;
                        break;
                    default:
                        networkStateInfo = NetworkStateInfo.TwoG;
                        break;
                }
            }
            return networkStateInfo;
        } catch (Exception e) {
            return networkStateInfo2;
        }
    }

    public static NetTpyeEnum getNetType() {
        NetTpyeEnum netTpyeEnum = NetTpyeEnum.UNAVAIL;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) BdBaseApplication.getInst().getApp().getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = false;
            if (activeNetworkInfo != null) {
                z = activeNetworkInfo.isAvailable();
            }
            if (!z) {
                return NetTpyeEnum.UNAVAIL;
            }
            if (activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkChangeReceiver.WIFI_STRING)) {
                return NetTpyeEnum.WIFI;
            }
            String defaultHost = Proxy.getDefaultHost();
            if (defaultHost != null && defaultHost.length() > 0) {
                return NetTpyeEnum.WAP;
            }
            return NetTpyeEnum.NET;
        } catch (Exception e) {
            e.printStackTrace();
            return netTpyeEnum;
        }
    }
}
