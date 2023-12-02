package com.baidu.searchbox.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.baidu.webkit.internal.ConectivityUtils;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
/* loaded from: classes4.dex */
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

    private void checkSIMCard(Context context) {
        this.mSimOperatorCode = "";
        this.mSimOperatorName = "";
    }

    @RequiresApi(api = 21)
    public static boolean checkVPN(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (networkInfo = connectivityManager.getNetworkInfo(17)) == null) {
            return false;
        }
        return networkInfo.isConnectedOrConnecting();
    }

    private void checkWifi(Context context) {
        this.mWifiBSSID = "";
        this.mWifiSSID = "";
    }

    public static boolean isAirModeOn(Context context) {
        if (Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean isMobile(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    /* loaded from: classes3.dex */
    public enum NetworkStateEnum {
        NO("no"),
        WIFI("wifi"),
        _2G("2g"),
        _3G("3g"),
        _4G("4g"),
        _5G("5g"),
        UNKNOWN("unknown");
        
        public final String name;

        NetworkStateEnum(String str) {
            this.name = str;
        }
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
        if (context == null) {
            return;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (NullPointerException unused) {
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

    public static boolean isVPNConnected(Context context) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            z = checkVPN(context);
        } else {
            z = false;
        }
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
                    return z;
                }
                if (!arrayList.contains("tun0")) {
                    if (!arrayList.contains("ppp0") && !z) {
                        return false;
                    }
                }
                return true;
            }
            return z;
        } catch (NullPointerException | SocketException e) {
            e.printStackTrace();
            return z;
        }
    }

    public static String getNetworkInfo(Context context) {
        NetworkInfo activeNetworkInfo;
        String lowerCase;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "no";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            if (activeNetworkInfo.getExtraInfo() == null) {
                lowerCase = "none";
            } else {
                lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
            }
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

    public static NetworkStateEnum getNetworkType(Context context) {
        String networkInfo = getNetworkInfo(context);
        if (networkInfo.startsWith("no")) {
            return NetworkStateEnum.NO;
        }
        if (networkInfo.startsWith("wifi")) {
            return NetworkStateEnum.WIFI;
        }
        if (networkInfo.startsWith("2g")) {
            return NetworkStateEnum._2G;
        }
        if (networkInfo.startsWith("3g")) {
            return NetworkStateEnum._3G;
        }
        if (networkInfo.startsWith("4g")) {
            return NetworkStateEnum._4G;
        }
        if (networkInfo.startsWith("5g")) {
            return NetworkStateEnum._5G;
        }
        return NetworkStateEnum.UNKNOWN;
    }

    public static boolean isProxyConnected() {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        if (!TextUtils.isEmpty(property) && !TextUtils.isEmpty(property2)) {
            return true;
        }
        return false;
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
