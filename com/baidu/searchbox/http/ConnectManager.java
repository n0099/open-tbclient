package com.baidu.searchbox.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes15.dex */
public class ConnectManager {
    private static final boolean DEBUG = false;
    private static final String TAG = "ConnectManager";
    private String mApn;
    private String mNetType;
    private int mPort;
    private String mProxy;
    private String mSimOperatorCode;
    private String mSimOperatorName;
    private int mSubType;
    private String mSubTypeName;
    private boolean mUseWap;
    private String mWifiBSSID;
    private String mWifiSSID;

    public ConnectManager(Context context) {
        checkNetworkType(context);
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return activeNetworkInfo.getType() == 1;
    }

    private void checkApn(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                this.mUseWap = true;
                this.mApn = lowerCase;
                this.mProxy = "10.0.0.172";
                this.mPort = 80;
                return;
            } else if (lowerCase.startsWith("ctwap")) {
                this.mUseWap = true;
                this.mApn = lowerCase;
                this.mProxy = "10.0.0.200";
                this.mPort = 80;
                return;
            } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                this.mUseWap = false;
                this.mApn = lowerCase;
                return;
            }
        }
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost != null && defaultHost.length() > 0) {
            this.mProxy = defaultHost;
            if ("10.0.0.172".equals(this.mProxy.trim())) {
                this.mUseWap = true;
                this.mPort = 80;
                return;
            } else if ("10.0.0.200".equals(this.mProxy.trim())) {
                this.mUseWap = true;
                this.mPort = 80;
                return;
            } else {
                this.mUseWap = false;
                this.mPort = defaultPort;
                return;
            }
        }
        this.mUseWap = false;
    }

    private void checkNetworkType(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (NullPointerException e) {
            networkInfo = null;
        }
        if (networkInfo != null) {
            if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                this.mNetType = "wifi";
                this.mUseWap = false;
                checkWifi(context);
            } else {
                checkApn(context, networkInfo);
                this.mNetType = this.mApn;
            }
            checkSIMCard(context);
            this.mSubType = networkInfo.getSubtype();
            this.mSubTypeName = networkInfo.getSubtypeName();
        }
    }

    private void checkWifi(Context context) {
        NetworkInfo activeNetworkInfo;
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && 1 == activeNetworkInfo.getType() && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                this.mWifiBSSID = connectionInfo.getBSSID();
                this.mWifiSSID = connectionInfo.getSSID();
            }
        } catch (Exception e) {
        }
    }

    private void checkSIMCard(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            this.mSimOperatorName = telephonyManager.getSimOperatorName();
            String simOperator = telephonyManager.getSimOperator();
            if (simOperator != null && simOperator.length() >= 5) {
                StringBuilder sb = new StringBuilder();
                try {
                    int length = simOperator.length();
                    if (length > 6) {
                        length = 6;
                    }
                    for (int i = 0; i < length; i++) {
                        if (!Character.isDigit(simOperator.charAt(i))) {
                            if (sb.length() > 0) {
                                break;
                            }
                        } else {
                            sb.append(simOperator.charAt(i));
                        }
                    }
                    this.mSimOperatorCode = Integer.valueOf(sb.toString()).toString();
                } catch (Exception e) {
                }
            }
        }
    }

    public boolean isWapNetwork() {
        return this.mUseWap;
    }

    public String getApn() {
        return this.mApn;
    }

    public String getProxy() {
        return this.mProxy;
    }

    public String getSubTypeName() {
        return this.mSubTypeName;
    }

    public int getSubType() {
        return this.mSubType;
    }

    public int getProxyPort() {
        return this.mPort;
    }

    public String getWifiBSSID() {
        return this.mWifiBSSID;
    }

    public String getWifiSSID() {
        return this.mWifiSSID;
    }

    public String getSimOperatorName() {
        return this.mSimOperatorName;
    }

    public String getSimOperatorCode() {
        return this.mSimOperatorCode;
    }

    public String getNetType() {
        return this.mNetType;
    }

    public static String getNetworkInfo(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            String lowerCase = activeNetworkInfo.getExtraInfo() == null ? "none" : activeNetworkInfo.getExtraInfo().toLowerCase();
            StringBuilder sb = new StringBuilder();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    sb.append("2g");
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
                    sb.append("3g");
                    break;
                case 13:
                    sb.append("4g");
                    break;
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    sb.append(activeNetworkInfo.getTypeName());
                    break;
                case 20:
                    sb.append("5g");
                    break;
            }
            return sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(lowerCase).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(subtypeName).toString();
        }
        return activeNetworkInfo.getTypeName() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + activeNetworkInfo.getSubtypeName();
    }
}
