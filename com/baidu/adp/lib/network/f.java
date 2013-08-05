package com.baidu.adp.lib.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.browser.core.util.BdUtil;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class f {
    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) d.a().b().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean b(String str) {
        if (Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8).matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean c(String str) {
        return str != null && str.contains("vnd.wap.wml");
    }

    public static String d(String str) {
        String[] split;
        if (str == null) {
            return BdUtil.UTF8;
        }
        for (String str2 : str.split(";")) {
            if (str2.contains("charset")) {
                String[] split2 = str2.split("=");
                if (split2.length <= 1) {
                    return BdUtil.UTF8;
                }
                return split2[1].trim();
            }
        }
        return BdUtil.UTF8;
    }

    public static boolean b() {
        return (a() || c() == 1 || a(Proxy.getDefaultHost())) ? false : true;
    }

    public static int c() {
        int i;
        String networkOperator = ((TelephonyManager) d.a().b().getSystemService("phone")).getNetworkOperator();
        if (a(networkOperator)) {
            return 0;
        }
        String substring = networkOperator.substring(0, 3);
        if (substring == null || !substring.equals("460")) {
            return 0;
        }
        try {
            i = Integer.parseInt(networkOperator.substring(3));
        } catch (NumberFormatException e) {
            i = 0;
        }
        switch (i) {
            case 0:
            case 2:
            case 7:
                return 1;
            case 1:
            case 6:
                return 2;
            case 3:
            case 5:
                return 3;
            case 4:
            default:
                return 0;
        }
    }
}
