package com.baidu.searchbox.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.baidu.webkit.internal.ConectivityUtils;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class ConnectManager {
    public static final boolean DEBUG = false;
    public static final String TAG = "ConnectManager";
    public boolean mAirModeOn;
    public String mApn;
    public String mHttpProxyIp;
    public int mHttpProxyPort = -1;
    public String mNetType;
    public int mPort;
    public String mProxy;
    public String mSimOperatorCode;
    public String mSimOperatorName;
    public int mSubType;
    public String mSubTypeName;
    public boolean mUseWap;
    public boolean mVpnOn;
    public String mWifiBSSID;
    public String mWifiSSID;

    public ConnectManager(Context context) {
        checkNetworkType(context);
    }

    private void checkApn(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
            if (!lowerCase.startsWith(ConectivityUtils.APN_CMWAP) && !lowerCase.startsWith(ConectivityUtils.APN_UNIWAP) && !lowerCase.startsWith(ConectivityUtils.APN_3GWAP)) {
                if (lowerCase.startsWith(ConectivityUtils.APN_CTWAP)) {
                    this.mUseWap = true;
                    this.mApn = lowerCase;
                    this.mProxy = "10.0.0.200";
                    this.mPort = 80;
                    return;
                } else if (lowerCase.startsWith(ConectivityUtils.APN_CMNET) || lowerCase.startsWith(ConectivityUtils.APN_UNINET) || lowerCase.startsWith(ConectivityUtils.APN_CTNET) || lowerCase.startsWith(ConectivityUtils.APN_3GNET)) {
                    this.mUseWap = false;
                    this.mApn = lowerCase;
                    return;
                }
            } else {
                this.mUseWap = true;
                this.mApn = lowerCase;
                this.mProxy = "10.0.0.172";
                this.mPort = 80;
                return;
            }
        }
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost != null && defaultHost.length() > 0) {
            this.mProxy = defaultHost;
            if ("10.0.0.172".equals(defaultHost.trim())) {
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
        } catch (NullPointerException unused) {
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
        this.mHttpProxyIp = System.getProperty("http.proxyHost");
        String property = System.getProperty("http.proxyPort");
        if (!TextUtils.isEmpty(property)) {
            this.mHttpProxyPort = Integer.parseInt(property);
        }
        this.mAirModeOn = isAirModeOn(context);
        this.mVpnOn = isVPNConnected(context);
    }

    private void checkSIMCard(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            this.mSimOperatorName = telephonyManager.getSimOperatorName();
            String simOperator = telephonyManager.getSimOperator();
            if (simOperator == null || simOperator.length() < 5) {
                return;
            }
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
            } catch (Exception unused) {
            }
        }
    }

    @RequiresApi(api = 21)
    public static boolean checkVPN(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || connectivityManager.getNetworkInfo(17) == null) {
            return false;
        }
        return connectivityManager.getNetworkInfo(17).isConnectedOrConnecting();
    }

    private void checkWifi(Context context) {
        NetworkInfo activeNetworkInfo;
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || 1 != activeNetworkInfo.getType() || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return;
            }
            this.mWifiBSSID = connectionInfo.getBSSID();
            this.mWifiSSID = connectionInfo.getSSID();
        } catch (Exception unused) {
        }
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
            if (subtype != 20) {
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
                    default:
                        sb.append(activeNetworkInfo.getTypeName());
                        break;
                }
            } else {
                sb.append("5g");
            }
            sb.append("_");
            sb.append(lowerCase);
            sb.append("_");
            sb.append(subtypeName);
            return sb.toString();
        }
        return activeNetworkInfo.getTypeName() + "_" + activeNetworkInfo.getSubtypeName();
    }

    public static boolean isAirModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    public static boolean isProxyConnected() {
        return (TextUtils.isEmpty(System.getProperty("http.proxyHost")) || TextUtils.isEmpty(System.getProperty("http.proxyPort"))) ? false : true;
    }

    public static boolean isVPNConnected(Context context) {
        ArrayList arrayList = new ArrayList();
        boolean checkVPN = Build.VERSION.SDK_INT >= 21 ? checkVPN(context) : false;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Iterator it = Collections.list(networkInterfaces).iterator();
                while (it.hasNext()) {
                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                    if (networkInterface.isUp()) {
                        arrayList.add(networkInterface.getName());
                    }
                }
                if (arrayList.isEmpty()) {
                    return checkVPN;
                }
                if (!arrayList.contains("tun0")) {
                    if (!arrayList.contains("ppp0") && !checkVPN) {
                        return false;
                    }
                }
                return true;
            }
            return checkVPN;
        } catch (SocketException e2) {
            e2.printStackTrace();
            return checkVPN;
        }
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    public boolean airModeOn() {
        return this.mAirModeOn;
    }

    public String getApn() {
        return this.mApn;
    }

    public String getHttpProxyIp() {
        return this.mHttpProxyIp;
    }

    public int getHttpProxyPort() {
        return this.mHttpProxyPort;
    }

    public String getNetType() {
        return this.mNetType;
    }

    public String getProxy() {
        return this.mProxy;
    }

    public int getProxyPort() {
        return this.mPort;
    }

    public String getSimOperatorCode() {
        return this.mSimOperatorCode;
    }

    public String getSimOperatorName() {
        return this.mSimOperatorName;
    }

    public int getSubType() {
        return this.mSubType;
    }

    public String getSubTypeName() {
        return this.mSubTypeName;
    }

    public String getWifiBSSID() {
        return this.mWifiBSSID;
    }

    public String getWifiSSID() {
        return this.mWifiSSID;
    }

    public boolean isVpnOn() {
        return this.mVpnOn;
    }

    public boolean isWapNetwork() {
        return this.mUseWap;
    }
}
