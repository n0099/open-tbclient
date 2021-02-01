package com.baidu.adp.lib.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.service.AsyncService;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class j {
    private static j Qm;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean mSupportWap = true;
    private long mNetChangedTime;
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
    private Runnable Qn = new Runnable() { // from class: com.baidu.adp.lib.util.j.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                int netType = j.netType();
                long netChangedTime = j.getNetChangedTime();
                j.nK();
                if (j.nL()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = netType;
                    networkState.mCurNetState = j.netType();
                    networkState.mlastChangedTime = netChangedTime;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    j.L(currentTimeMillis);
                    MessageManager.getInstance().dispatchResponsedMessage(new NetWorkChangedMessage(networkState));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    static {
        try {
            a aVar = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            BdBaseApplication.getInst().getApp().registerReceiver(aVar, intentFilter);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        Qm = null;
    }

    private void getCurNetState() {
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
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNetworkAvailableForImmediately() {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity");
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

    private void setNetworkChangedTime(long j) {
        this.mNetChangedTime = j;
    }

    private static int readNetworkOperatorType() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || k.isEmptyStringAfterTrim(networkOperator)) {
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
    public static synchronized j nJ() {
        j jVar;
        synchronized (j.class) {
            if (Qm == null) {
                Qm = new j();
            }
            jVar = Qm;
        }
        return jVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AsyncService.INSTANCE.sendRunnable(j.nJ().Qn);
        }
    }

    public static void init() {
        init(true);
    }

    public static void init(boolean z) {
        nJ().setOpenNetChangedMessage(z);
        nJ().getCurNetState();
    }

    public static void nK() {
        nJ().getCurNetState();
    }

    public static boolean nL() {
        return nJ().isOpenNetChangedMessage();
    }

    public static void L(long j) {
        nJ().setNetworkChangedTime(j);
    }

    public static boolean isNetWorkAvailable() {
        return nJ().isNetAvailable();
    }

    public static boolean isWifiNet() {
        return nJ().isWifi();
    }

    public static boolean isMobileNet() {
        return nJ().isMobile();
    }

    public static boolean is4GNet() {
        return 3 == nJ().getCurMobileNetClassify();
    }

    public static boolean is3GNet() {
        return 2 == nJ().getCurMobileNetClassify();
    }

    public static boolean is2GNet() {
        return 1 == nJ().getCurMobileNetClassify();
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

    public static String getNetType() {
        if (!isNetWorkAvailable()) {
            return "N";
        }
        if (isWifiNet()) {
            return "WIFI";
        }
        if (is4GNet()) {
            return "4G";
        }
        if (is3GNet()) {
            return "3G";
        }
        if (!is2GNet()) {
            return "N";
        }
        return "2G";
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
        return nJ().getOperatorType();
    }

    public static String curMobileProxyHost() {
        return nJ().getProxyHost();
    }

    public static int curMobileProxyPort() {
        return nJ().getProxyPort();
    }

    public static boolean isSupportWap() {
        return mSupportWap;
    }

    public static boolean isWap(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = nJ().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long getNetChangedTime() {
        return nJ().geNetworkChangedTime();
    }
}
