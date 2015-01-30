package com.baidu.adp.lib.stats;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import java.util.Random;
/* loaded from: classes.dex */
public class p {
    private static Random mz = new Random();

    public static String eJ() {
        try {
            return Long.toHexString(Math.abs(mz.nextLong()));
        } catch (Exception e) {
            return Long.toHexString(System.currentTimeMillis());
        }
    }

    public static String getNetType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return NetworkChangeReceiver.WIFI_STRING;
                }
                if (type == 0) {
                    int fn = com.baidu.adp.lib.util.i.fn();
                    StringBuilder sb = new StringBuilder();
                    switch (fn) {
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
                    if (activeNetworkInfo.getExtraInfo() != null && activeNetworkInfo.getExtraInfo().contains("wap")) {
                        sb.append("_WAP_");
                    } else {
                        sb.append("_NET_");
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
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
                    } else {
                        sb.append('N');
                    }
                    return sb.toString();
                }
            }
            return EnvironmentCompat.MEDIA_UNKNOWN;
        } catch (Exception e) {
            return null;
        }
    }

    public static String H(Context context) {
        if (context == null) {
            return null;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkChangeReceiver.WIFI_STRING)) {
                    return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                }
                String fo = com.baidu.adp.lib.util.i.fo();
                if (fo != null) {
                    if (fo.length() > 0) {
                        return "2";
                    }
                }
                return "1";
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
