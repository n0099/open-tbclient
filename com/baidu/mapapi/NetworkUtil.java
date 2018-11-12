package com.baidu.mapapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
/* loaded from: classes4.dex */
public class NetworkUtil {
    public static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getCurrentNetMode(Context context) {
        int i = 1;
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() != 1) {
                switch (((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getNetworkType()) {
                    case 1:
                    case 2:
                        i = 6;
                        break;
                    case 3:
                    case 9:
                    case 10:
                    case 15:
                        i = 9;
                        break;
                    case 4:
                        i = 5;
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 12:
                        i = 7;
                        break;
                    case 8:
                        i = 8;
                        break;
                    case 11:
                        i = 2;
                        break;
                    case 13:
                        i = 4;
                        break;
                    case 14:
                        i = 10;
                        break;
                }
            }
            return Integer.toString(i);
        }
        i = 0;
        return Integer.toString(i);
    }

    public static boolean initConnectState() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (r3.isConnected() != false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isWifiConnected(NetworkInfo networkInfo) {
        boolean z = true;
        if (networkInfo != null) {
            try {
                if (1 == networkInfo.getType()) {
                }
                z = false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            z = false;
        }
        return z;
    }

    public static void updateNetworkProxy(Context context) {
        SysUpdateObservable.getInstance().updateNetworkProxy(context);
    }
}
