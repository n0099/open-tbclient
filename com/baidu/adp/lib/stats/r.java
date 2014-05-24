package com.baidu.adp.lib.stats;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import java.security.MessageDigest;
import java.util.Random;
/* loaded from: classes.dex */
public class r {
    private static Random a = new Random();

    public static String a() {
        try {
            return Long.toHexString(Math.abs(a.nextLong()));
        } catch (Exception e) {
            return Long.toHexString(System.currentTimeMillis());
        }
    }

    public static String a(Context context) {
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
                    int d = com.baidu.adp.lib.network.willdelete.h.d();
                    StringBuilder sb = new StringBuilder();
                    switch (d) {
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
            return "unknown";
        } catch (Exception e) {
            return null;
        }
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkChangeReceiver.WIFI_STRING)) {
                    return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                }
                String defaultHost = Proxy.getDefaultHost();
                if (defaultHost != null) {
                    if (defaultHost.length() > 0) {
                        return TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT;
                    }
                }
                return TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = digest[i2];
                int i3 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i3 + 1;
                cArr2[i3] = cArr[b & 15];
            }
            return new String(cArr2);
        } catch (Exception e) {
            BdLog.e("BdStatsHelper", "getMD5", e);
            return null;
        }
    }
}
