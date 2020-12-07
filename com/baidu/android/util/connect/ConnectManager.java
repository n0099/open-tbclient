package com.baidu.android.util.connect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
@Deprecated
/* loaded from: classes19.dex */
public class ConnectManager {
    private static final boolean DEBUG = false;
    private static final String TAG = "ConnectManager";
    private String mApn;
    private String mNetType;
    private int mPort;
    private String mProxy;
    private int mSubType;
    private String mSubTypeName;
    private boolean mUseWap;

    public ConnectManager(Context context) {
        checkNetworkType(context);
    }

    @Deprecated
    public static boolean isNetworkConnected(Context context) {
        return NetWorkUtils.isConnected(context);
    }

    @Deprecated
    public static boolean isWifi(Context context) {
        return NetWorkUtils.isWifiConnected(context);
    }

    private void checkApn(NetworkInfo networkInfo) {
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
        NetworkInfo activeNetworkInfo = NetWorkUtils.getActiveNetworkInfo(context);
        if (activeNetworkInfo != null) {
            if ("wifi".equals(activeNetworkInfo.getTypeName().toLowerCase())) {
                this.mNetType = "wifi";
                this.mUseWap = false;
            } else {
                checkApn(activeNetworkInfo);
                this.mNetType = this.mApn;
            }
            this.mSubType = activeNetworkInfo.getSubtype();
            this.mSubTypeName = activeNetworkInfo.getSubtypeName();
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

    public String getNetType() {
        return this.mNetType;
    }

    @Deprecated
    public static String getNetworkInfo(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = NetWorkUtils.getActiveNetworkInfo(context)) == null || !activeNetworkInfo.isConnected()) {
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

    @SuppressLint({"MissingPermission"})
    @Deprecated
    public static NetworkInfo getInfo(Context context) {
        return NetWorkUtils.getActiveNetworkInfo(context);
    }
}
