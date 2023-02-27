package com.baidu.mapapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
/* loaded from: classes2.dex */
public class NetworkUtil {
    public static boolean initConnectState() {
        return true;
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            if (isWifiConnected(context)) {
                return true;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            if (!activeNetworkInfo.isConnectedOrConnecting()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                return false;
            }
            if (!activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void updateNetworkProxy(Context context) {
        SysUpdateObservable.getInstance().updateNetworkProxy(context);
    }

    public static String getCurrentNetMode(Context context) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        int i = 4;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                i = 1;
            } else if (Build.VERSION.SDK_INT > 29) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null) {
                    return "mobile";
                }
                boolean hasTransport = networkCapabilities.hasTransport(1);
                boolean hasTransport2 = networkCapabilities.hasTransport(0);
                boolean hasTransport3 = networkCapabilities.hasTransport(3);
                boolean hasTransport4 = networkCapabilities.hasTransport(6);
                boolean hasTransport5 = networkCapabilities.hasTransport(4);
                boolean hasTransport6 = networkCapabilities.hasTransport(5);
                if (hasTransport) {
                    return "WIFI";
                }
                if (hasTransport2) {
                    return "CELLULAR";
                }
                if (hasTransport3) {
                    return "ETHERNET";
                }
                if (hasTransport4) {
                    return "LoWPAN";
                }
                if (hasTransport5) {
                    return "VPN";
                }
                if (!hasTransport6) {
                    return "mobile";
                }
                return "WifiAware";
            } else {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return Integer.toString(0);
                }
                switch (telephonyManager.getNetworkType()) {
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
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        z = false;
        return z;
    }
}
