package com.baidu.down.loopj.android.http;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.down.utils.Utils;
/* loaded from: classes15.dex */
public class ConnectManager {
    private static final boolean DEBUG = false;
    private static final String TAG = ConnectManager.class.getSimpleName();
    private String mApn;
    private NetWorkType mNetWorkType = NetWorkType.TYPE_UNKNOWN;
    private String mPort;
    private String mProxy;
    private boolean mUseWap;

    /* loaded from: classes15.dex */
    public enum NetWorkType {
        TYPE_UNKNOWN,
        TYPE_WF,
        TYPE_2G,
        TYPE_3G,
        TYPE_4G
    }

    public ConnectManager(Context context) {
        checkNetworkType(context);
    }

    private void checkApn(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                this.mUseWap = true;
                this.mApn = lowerCase;
                this.mProxy = "10.0.0.172";
                this.mPort = "80";
                return;
            } else if (lowerCase.startsWith("ctwap")) {
                this.mUseWap = true;
                this.mApn = lowerCase;
                this.mProxy = "10.0.0.200";
                this.mPort = "80";
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
                this.mPort = "80";
                return;
            } else if ("10.0.0.200".equals(this.mProxy.trim())) {
                this.mUseWap = true;
                this.mPort = "80";
                return;
            } else {
                this.mUseWap = false;
                this.mPort = Integer.toString(defaultPort);
                return;
            }
        }
        this.mUseWap = false;
    }

    private void checkNetworkType(Context context) {
        NetworkInfo activeNetworkInfoSafely = Utils.getActiveNetworkInfoSafely(context);
        if (activeNetworkInfoSafely != null) {
            if ("wifi".equals(activeNetworkInfoSafely.getTypeName().toLowerCase())) {
                this.mNetWorkType = NetWorkType.TYPE_WF;
                this.mUseWap = false;
                return;
            }
            checkApn(context, activeNetworkInfoSafely);
            this.mNetWorkType = checkApnType(activeNetworkInfoSafely);
        }
    }

    private NetWorkType checkApnType(NetworkInfo networkInfo) {
        String lowerCase = networkInfo.getTypeName().toLowerCase();
        NetWorkType netWorkType = NetWorkType.TYPE_UNKNOWN;
        if ("wifi".equals(lowerCase)) {
            return NetWorkType.TYPE_WF;
        }
        NetWorkType netWorkType2 = NetWorkType.TYPE_2G;
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 11:
                return netWorkType2;
            case 3:
                return NetWorkType.TYPE_3G;
            case 5:
                return NetWorkType.TYPE_3G;
            case 6:
                return NetWorkType.TYPE_3G;
            case 7:
                return NetWorkType.TYPE_3G;
            case 8:
                return NetWorkType.TYPE_3G;
            case 9:
                return NetWorkType.TYPE_3G;
            case 10:
                return NetWorkType.TYPE_3G;
            case 12:
                return NetWorkType.TYPE_3G;
            case 13:
                return NetWorkType.TYPE_4G;
            case 14:
                return NetWorkType.TYPE_3G;
            case 15:
                return NetWorkType.TYPE_3G;
            default:
                return NetWorkType.TYPE_4G;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfoSafely = Utils.getActiveNetworkInfoSafely(context);
        if (activeNetworkInfoSafely != null) {
            return activeNetworkInfoSafely.isConnectedOrConnecting();
        }
        return false;
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

    public String getProxyPort() {
        return this.mPort;
    }

    public NetWorkType getNetType() {
        return this.mNetWorkType;
    }
}
