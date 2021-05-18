package com.baidu.mobads.container.util.network;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.apollon.statistics.g;
import com.baidu.down.utils.Utils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class NetworkInfoUtils {
    public static final Map<String, Integer> CARRIER_MCCMNC = new HashMap<String, Integer>() { // from class: com.baidu.mobads.container.util.network.NetworkInfoUtils.1
        {
            put("46000", 1);
            put("46002", 1);
            put("46007", 1);
            put("46008", 1);
            put("46003", 2);
            put("46005", 2);
            put("46011", 2);
            put("46001", 3);
            put("46006", 3);
            put("46009", 3);
        }
    };
    public static final int NETWORKTYPE_CELL_2G = 2;
    public static final int NETWORKTYPE_CELL_3G = 3;
    public static final int NETWORKTYPE_CELL_4G = 4;
    public static final int NETWORKTYPE_CELL_5G = 5;
    public static final int NETWORKTYPE_CELL_UNKNOWN = 1;
    public static final int NETWORKTYPE_CONNECTION_UNKNOWN = 0;
    public static final int NETWORKTYPE_ETHERNET = 101;
    public static final int NETWORKTYPE_NEW_TYPE = 999;
    public static final int NETWORKTYPE_WIFI = 100;
    public static final String NETWORK_NAME = "wlan0";
    public static final String NT_NONE = "none";
    public static final String NT_UNKNOWN = "unknown";
    public static final String NT_WIFI = "wifi";

    public static NetworkInfo getActiveNetwork(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) == 0) {
                return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Integer getCarrier(Context context) {
        String networkOperator;
        try {
            networkOperator = getNetworkOperator(context);
        } catch (Throwable th) {
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            remoteXAdLogger.d("Get carrier encounter exception: " + th.getMessage());
        }
        if (TextUtils.isEmpty(networkOperator)) {
            return 0;
        }
        for (Map.Entry<String, Integer> entry : CARRIER_MCCMNC.entrySet()) {
            if (networkOperator.startsWith(entry.getKey())) {
                return entry.getValue();
            }
        }
        return 99;
    }

    public static Pair<Integer, Integer> getDimensions(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                if (Build.VERSION.SDK_INT >= 17) {
                    windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
                } else {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                }
            }
            return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        } catch (Exception e2) {
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            remoteXAdLogger.d("Get screen size error: " + e2.getMessage());
            return null;
        }
    }

    public static String getNetType(Context context) {
        return "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
        if (r3.equalsIgnoreCase("CDMA2000") == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getNetwork(Context context) {
        NetworkInfo activeNetwork = getActiveNetwork(context);
        if (activeNetwork == null || !activeNetwork.isAvailable()) {
            return 0;
        }
        int i2 = 1;
        if (activeNetwork.getType() == 1) {
            return 100;
        }
        if (activeNetwork.getType() != 0) {
            return activeNetwork.getType() == 9 ? 101 : 999;
        }
        switch (activeNetwork.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                i2 = 2;
                break;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                i2 = 3;
                break;
            case 13:
            case 18:
                i2 = 4;
                break;
            default:
                String subtypeName = activeNetwork.getSubtypeName();
                if (!subtypeName.equalsIgnoreCase("TD-SCDMA")) {
                    if (!subtypeName.equalsIgnoreCase("WCDMA")) {
                        break;
                    }
                }
                i2 = 3;
                break;
        }
        return i2;
    }

    public static String getNetwork(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 100 ? i2 != 101 ? RomUtils.UNKNOWN : "ETHERNET" : CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : "5G" : "4G" : g.f3963b : "2G" : RomUtils.UNKNOWN : "NO";
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (r3.equalsIgnoreCase("CDMA2000") != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getNetworkCatagory(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 100;
            }
            if (activeNetworkInfo.getType() == 0) {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                switch (activeNetworkInfo.getSubtype()) {
                    case 0:
                        return 1;
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                        return 3;
                    default:
                        if (subtypeName != null) {
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                                break;
                            }
                            return 3;
                        }
                        return 1;
                }
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String getNetworkOperator(Context context) {
        try {
            String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
            return networkOperator == null ? "" : networkOperator;
        } catch (Throwable unused) {
            return "";
        }
    }

    @SuppressLint({"DefaultLocale"})
    @TargetApi(3)
    public static String getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) ? "none" : activeNetworkInfo.getType() == 1 ? "wifi" : activeNetworkInfo.getSubtypeName() != null ? activeNetworkInfo.getSubtypeName().toLowerCase() : "unknown";
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().i(e2);
            return "none";
        }
    }

    public static String getWifiConnected(Context context) {
        return "";
    }

    public static boolean isCurrentNetworkAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d("isCurrentNetworkAvailable", e2);
            return false;
        }
    }

    public static Boolean isWifiConnected(Context context) {
        return isXTypeConnected(context, 1);
    }

    public static Boolean isXTypeConnected(Context context, int i2) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            boolean z = true;
            if (context.checkCallingOrSelfPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) != 0) {
                RemoteXAdLogger.getInstance().e(Utils.TAG, "no permission android.permission.ACCESS_NETWORK_STATE");
                return Boolean.FALSE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != i2 || !activeNetworkInfo.isConnected()) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }
}
