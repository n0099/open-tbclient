package com.baidu.sapi2.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class SapiUtils {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;

    public static boolean isValidAccount(SapiAccount sapiAccount) {
        return (sapiAccount == null || TextUtils.isEmpty(sapiAccount.bduss) || TextUtils.isEmpty(sapiAccount.app) || TextUtils.isEmpty(sapiAccount.uid) || TextUtils.isEmpty(sapiAccount.displayname)) ? false : true;
    }

    public static String getLocalIpAddress() {
        String hostAddress;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (hostAddress = nextElement.getHostAddress()) != null && hostAddress.length() > 0) {
                        return hostAddress;
                    }
                }
            }
        } catch (SocketException e) {
            L.e(e);
        }
        return null;
    }

    public static String createRequestParams(List<NameValuePair> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (NameValuePair nameValuePair : list) {
                if (!TextUtils.isEmpty(nameValuePair.getName()) && !TextUtils.isEmpty(nameValuePair.getValue())) {
                    if (TextUtils.isEmpty(sb.toString())) {
                        sb.append(nameValuePair.getName()).append("=").append(nameValuePair.getValue());
                    } else {
                        sb.append("&").append(nameValuePair.getName()).append("=").append(nameValuePair.getValue());
                    }
                }
            }
        }
        return sb.toString();
    }

    public static boolean hasActiveNetwork(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    public static int readNetworkOperatorType(Context context) {
        int i;
        String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        if (TextUtils.isEmpty(networkOperator)) {
            return 0;
        }
        if (networkOperator.length() < 3 || networkOperator.substring(0, 3).equals("460")) {
            if (networkOperator.length() > 3) {
                try {
                    i = Integer.parseInt(networkOperator.substring(3));
                } catch (NumberFormatException e) {
                    L.e(e);
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
                }
            }
            return 0;
        }
        return 0;
    }
}
