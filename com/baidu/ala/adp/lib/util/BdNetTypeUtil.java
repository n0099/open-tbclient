package com.baidu.ala.adp.lib.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.baidu.ala.tbadk.core.TbadkCoreApplicationProxy;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class BdNetTypeUtil {
    public static final String NATION_CODE = "460";
    public static final int NETWORK_CLASS_2_G = 1;
    public static final int NETWORK_CLASS_3_G = 2;
    public static final int NETWORK_CLASS_4_G = 3;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_OPERATOR_MOBILE = 1;
    public static final int NETWORK_OPERATOR_TELECOM = 3;
    public static final int NETWORK_OPERATOR_UNICOM = 2;
    public static final int NETWORK_OPERATOR_UNKOWN = 0;
    public static final int NETWORK_TYPE_1xRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NET_TPYE_UNAVAILABLE = 0;
    public static final String NET_TYPENAME_2G = "2g";
    public static final String NET_TYPENAME_3G = "3g";
    public static final String NET_TYPENAME_4G = "4g";
    public static final String NET_TYPENAME_UNAVAILABLE = "unreachable";
    public static final String NET_TYPENAME_WIFI = "wifi";
    public static final int NET_TYPE_2G = 2;
    public static final int NET_TYPE_3G = 3;
    public static final int NET_TYPE_4G = 4;
    public static final int NET_TYPE_WIFI = 1;
    private static BdNetTypeUtil mInstance;
    private long mNetChangedTime;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean mSupportWap = true;
    private static Set<NetWorkChangedListener> mNetWorkChangedListenerSet = null;
    private NetworkInfo curNetworkInfo = null;
    private boolean isWifi = true;
    private boolean isMobile = false;
    private boolean isNetAvailable = true;
    private int curMobileNetDetailType = 0;
    private int curMobileNetClassify = 0;
    private int operatorType = -1;
    private String mProxyHost = null;
    private int mProxyPort = -1;
    private boolean isOpenNetChangedMessage = true;

    static {
        try {
            NetChangeReceiver netChangeReceiver = new NetChangeReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            TbadkCoreApplicationProxy.getInst().getAppContext().registerReceiver(netChangeReceiver, intentFilter);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        mInstance = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCurNetState() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.curNetworkInfo = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.isMobile = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.isMobile = true;
            } else {
                this.isWifi = false;
                this.isMobile = false;
            }
            this.isNetAvailable = true;
            this.curMobileNetDetailType = activeNetworkInfo.getSubtype();
            if (this.isMobile) {
                this.curMobileNetClassify = getNetworkClass(this.curMobileNetDetailType);
            } else {
                this.curMobileNetClassify = 0;
            }
        } else {
            this.isWifi = false;
            this.isMobile = false;
            this.isNetAvailable = false;
            this.curMobileNetDetailType = 0;
            this.curMobileNetDetailType = 0;
        }
        this.operatorType = readNetworkOperatorType();
        this.mProxyHost = Proxy.getDefaultHost();
        this.mProxyPort = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) TbadkCoreApplicationProxy.getInst().getAppContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNetworkAvailableForImmediately() {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) TbadkCoreApplicationProxy.getInst().getAppContext().getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null && allNetworkInfo.length > 0) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNetAvailable() {
        if (this.curNetworkInfo == null) {
            getCurNetState();
        }
        return this.isNetAvailable;
    }

    public NetworkInfo getCurNetworkInfo() {
        if (this.curNetworkInfo == null) {
            getCurNetState();
        }
        return this.curNetworkInfo;
    }

    public boolean isWifi() {
        if (this.curNetworkInfo == null) {
            getCurNetState();
        }
        return this.isWifi;
    }

    public boolean isMobile() {
        if (this.curNetworkInfo == null) {
            getCurNetState();
        }
        return this.isMobile;
    }

    public int getCurMobileNetClassify() {
        if (this.curNetworkInfo == null) {
            getCurNetState();
        }
        return this.curMobileNetClassify;
    }

    public int getCurMobileNetDetailType() {
        if (this.curNetworkInfo == null) {
            getCurNetState();
        }
        return this.curMobileNetDetailType;
    }

    public int getOperatorType() {
        if (this.operatorType == -1) {
            try {
                this.operatorType = readNetworkOperatorType();
            } catch (Exception e) {
                this.operatorType = 0;
            }
        }
        return this.operatorType;
    }

    public String getProxyHost() {
        if (this.mProxyHost == null) {
            this.mProxyHost = Proxy.getDefaultHost();
        }
        return this.mProxyHost;
    }

    private long geNetworkChangedTime() {
        return this.mNetChangedTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNetworkChangedTime(long j) {
        this.mNetChangedTime = j;
    }

    public static boolean isPorxyUsed() {
        return (getInstance().isWifi || readNetworkOperatorType() == 1 || BdStringHelper.isEmptyStringAfterTrim(Proxy.getDefaultHost())) ? false : true;
    }

    private static int readNetworkOperatorType() {
        int i;
        String networkOperator = ((TelephonyManager) TbadkCoreApplicationProxy.getInst().getAppContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || BdStringHelper.isEmptyStringAfterTrim(networkOperator)) {
            return 0;
        }
        String substring = networkOperator.substring(0, 3);
        if (substring == null || !substring.equals("460")) {
            return 0;
        }
        try {
            i = Integer.parseInt(networkOperator.substring(3));
        } catch (NumberFormatException e) {
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
            case 11:
                return 3;
            case 4:
            case 8:
            case 9:
            case 10:
            default:
                return 0;
        }
    }

    public static int getNetworkClass(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 2;
            case 13:
                return 3;
            default:
                return 4;
        }
    }

    public int getProxyPort() {
        if (-1 == this.mProxyPort) {
            this.mProxyPort = Proxy.getDefaultPort();
        }
        return this.mProxyPort;
    }

    public boolean isOpenNetChangedMessage() {
        return this.isOpenNetChangedMessage;
    }

    public void setOpenNetChangedMessage(boolean z) {
        this.isOpenNetChangedMessage = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized BdNetTypeUtil getInstance() {
        BdNetTypeUtil bdNetTypeUtil;
        synchronized (BdNetTypeUtil.class) {
            if (mInstance == null) {
                mInstance = new BdNetTypeUtil();
            }
            bdNetTypeUtil = mInstance;
        }
        return bdNetTypeUtil;
    }

    /* loaded from: classes5.dex */
    private static class NetChangeReceiver extends BroadcastReceiver {
        private NetChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.ala.adp.lib.util.BdNetTypeUtil.NetChangeReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        int netType = BdNetTypeUtil.netType();
                        long netChangedTime = BdNetTypeUtil.getNetChangedTime();
                        BdNetTypeUtil.getInstance().getCurNetState();
                        if (BdNetTypeUtil.getInstance().isOpenNetChangedMessage()) {
                            NetworkState networkState = new NetworkState();
                            networkState.mLastNetState = netType;
                            networkState.mCurNetState = BdNetTypeUtil.netType();
                            networkState.mlastChangedTime = netChangedTime;
                            long currentTimeMillis = System.currentTimeMillis();
                            networkState.mCurChangedTime = currentTimeMillis;
                            BdNetTypeUtil.getInstance().setNetworkChangedTime(currentTimeMillis);
                            NetWorkChangedMessage netWorkChangedMessage = new NetWorkChangedMessage(networkState);
                            if (BdNetTypeUtil.mNetWorkChangedListenerSet != null && BdNetTypeUtil.mNetWorkChangedListenerSet.size() > 0) {
                                for (NetWorkChangedListener netWorkChangedListener : BdNetTypeUtil.mNetWorkChangedListenerSet) {
                                    netWorkChangedListener.onNetWorkChanged(netWorkChangedMessage);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 1000L);
        }
    }

    public static void addNetWorkChangedListener(NetWorkChangedListener netWorkChangedListener) {
        if (mNetWorkChangedListenerSet == null) {
            mNetWorkChangedListenerSet = new HashSet();
        }
        mNetWorkChangedListenerSet.add(netWorkChangedListener);
    }

    public static void removeNetWorkChangedListener(NetWorkChangedListener netWorkChangedListener) {
        if (mNetWorkChangedListenerSet != null) {
            mNetWorkChangedListenerSet.remove(netWorkChangedListener);
        }
    }

    public static void init() {
        init(true);
    }

    public static void init(boolean z) {
        getInstance().setOpenNetChangedMessage(z);
        getInstance().getCurNetState();
    }

    public static boolean isNetWorkAvailable() {
        return getInstance().isNetAvailable();
    }

    public static boolean isWifiNet() {
        return getInstance().isWifi();
    }

    public static boolean isMobileNet() {
        return getInstance().isMobile();
    }

    public static boolean is4GNet() {
        return 3 == getInstance().getCurMobileNetClassify();
    }

    public static boolean is3GNet() {
        return 2 == getInstance().getCurMobileNetClassify();
    }

    public static boolean is2GNet() {
        return 1 == getInstance().getCurMobileNetClassify();
    }

    public static int netType() {
        if (isWifiNet()) {
            return 1;
        }
        if (is2GNet()) {
            return 2;
        }
        if (is3GNet()) {
            return 3;
        }
        return (is4GNet() || isNetWorkAvailable()) ? 4 : 0;
    }

    public static String netTypeNameInLowerCase() {
        switch (netType()) {
            case 1:
                return "wifi";
            case 2:
                return "2g";
            case 3:
                return "3g";
            case 4:
                return "4g";
            default:
                return "unreachable";
        }
    }

    public static String netTypeNameInUpperCase() {
        String netTypeNameInLowerCase = netTypeNameInLowerCase();
        if (netTypeNameInLowerCase != null) {
            return netTypeNameInLowerCase.toUpperCase();
        }
        return netTypeNameInLowerCase;
    }

    public static int curOperatorType() {
        return getInstance().getOperatorType();
    }

    public static String curMobileProxyHost() {
        return getInstance().getProxyHost();
    }

    public static int curMobileProxyPort() {
        return getInstance().getProxyPort();
    }

    public static boolean isSupportWap() {
        return mSupportWap;
    }

    public static void setSupportWap(boolean z) {
        mSupportWap = z;
    }

    public static boolean isWap(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = getInstance().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long getNetChangedTime() {
        return getInstance().geNetworkChangedTime();
    }
}
