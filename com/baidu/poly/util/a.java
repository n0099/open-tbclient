package com.baidu.poly.util;

import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes6.dex */
public class a {
    private static InetAddress YO() {
        InetAddress inetAddress;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return null;
            }
            InetAddress inetAddress2 = null;
            while (networkInterfaces.hasMoreElements()) {
                try {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (!inetAddresses.hasMoreElements()) {
                            inetAddress = inetAddress2;
                            break;
                        }
                        inetAddress = inetAddresses.nextElement();
                        try {
                            if (!inetAddress.isLoopbackAddress() && !inetAddress.getHostAddress().contains(":")) {
                                break;
                            }
                            inetAddress2 = null;
                        } catch (Exception e) {
                            return inetAddress;
                        }
                    }
                    if (inetAddress != null) {
                        return inetAddress;
                    }
                    inetAddress2 = inetAddress;
                } catch (Exception e2) {
                    return inetAddress2;
                }
            }
            return inetAddress2;
        } catch (Exception e3) {
            return null;
        }
    }

    private static String YP() {
        byte[] hardwareAddress;
        try {
            InetAddress YO = YO();
            if (YO == null || (hardwareAddress = NetworkInterface.getByInetAddress(YO).getHardwareAddress()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hardwareAddress.length; i++) {
                if (i != 0) {
                    sb.append(':');
                }
                String hexString = Integer.toHexString(hardwareAddress[i] & 255);
                if (hexString.length() == 1) {
                    hexString = 0 + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    private static String YQ() {
        byte[] hardwareAddress;
        try {
            NetworkInterface byName = NetworkInterface.getByName("wlan0");
            if (byName == null || (hardwareAddress = byName.getHardwareAddress()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = hardwareAddress.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getMac() {
        return ((WifiManager) g.YS().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }

    public static String getMacAddress() {
        String YQ;
        if (Build.VERSION.SDK_INT < 23) {
            YQ = getMac();
        } else {
            YQ = YQ();
        }
        if (!jo(YQ)) {
            YQ = YP();
        }
        return !TextUtils.isEmpty(YQ) ? YQ.toUpperCase() : YQ;
    }

    private static boolean jo(String str) {
        return (TextUtils.isEmpty(str) || str.equals(Config.DEF_MAC_ID)) ? false : true;
    }
}
