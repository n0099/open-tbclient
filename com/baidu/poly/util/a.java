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
    private static InetAddress WU() {
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

    private static String WV() {
        byte[] hardwareAddress;
        try {
            InetAddress WU = WU();
            if (WU == null || (hardwareAddress = NetworkInterface.getByInetAddress(WU).getHardwareAddress()) == null) {
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

    private static String WW() {
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
        return ((WifiManager) g.WY().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }

    public static String getMacAddress() {
        String WW;
        if (Build.VERSION.SDK_INT < 23) {
            WW = getMac();
        } else {
            WW = WW();
        }
        if (!iV(WW)) {
            WW = WV();
        }
        return !TextUtils.isEmpty(WW) ? WW.toUpperCase() : WW;
    }

    private static boolean iV(String str) {
        return (TextUtils.isEmpty(str) || str.equals(Config.DEF_MAC_ID)) ? false : true;
    }
}
