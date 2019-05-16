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
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class j {
    private static j DO;
    private long DM;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean DL = true;
    private NetworkInfo DD = null;
    private boolean isWifi = true;
    private boolean DE = false;
    private boolean DF = true;
    private int DG = 0;
    private int DH = 0;
    private int DI = -1;
    private String DJ = null;
    private int DK = -1;
    private boolean DN = true;
    private Runnable DQ = new Runnable() { // from class: com.baidu.adp.lib.util.j.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                int netType = j.netType();
                long ke = j.ke();
                j.jQ();
                if (j.jR()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = netType;
                    networkState.mCurNetState = j.netType();
                    networkState.mlastChangedTime = ke;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    j.o(currentTimeMillis);
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
        DO = null;
    }

    private void jF() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.DD = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.DE = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.DE = true;
            } else {
                this.isWifi = false;
                this.DE = false;
            }
            this.DF = true;
            this.DG = activeNetworkInfo.getSubtype();
            if (this.DE) {
                this.DH = as(this.DG);
            } else {
                this.DH = 0;
            }
        } else {
            this.isWifi = false;
            this.DE = false;
            this.DF = false;
            this.DG = 0;
            this.DG = 0;
        }
        this.DI = jN();
        this.DJ = Proxy.getDefaultHost();
        this.DK = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean jG() {
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

    public boolean jH() {
        if (this.DD == null) {
            jF();
        }
        return this.DF;
    }

    public boolean isWifi() {
        if (this.DD == null) {
            jF();
        }
        return this.isWifi;
    }

    public boolean jI() {
        if (this.DD == null) {
            jF();
        }
        return this.DE;
    }

    public int jJ() {
        if (this.DD == null) {
            jF();
        }
        return this.DH;
    }

    public int jK() {
        if (this.DI == -1) {
            try {
                this.DI = jN();
            } catch (Exception e) {
                this.DI = 0;
            }
        }
        return this.DI;
    }

    public String jL() {
        if (this.DJ == null) {
            this.DJ = Proxy.getDefaultHost();
        }
        return this.DJ;
    }

    private long jM() {
        return this.DM;
    }

    private void n(long j) {
        this.DM = j;
    }

    private static int jN() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || k.bg(networkOperator)) {
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

    public static int as(int i) {
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
        if (-1 == this.DK) {
            this.DK = Proxy.getDefaultPort();
        }
        return this.DK;
    }

    public boolean jO() {
        return this.DN;
    }

    public void ae(boolean z) {
        this.DN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j jP() {
        j jVar;
        synchronized (j.class) {
            if (DO == null) {
                DO = new j();
            }
            jVar = DO;
        }
        return jVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AsyncService.INSTANCE.sendRunnable(j.jP().DQ);
        }
    }

    public static void init() {
        init(true);
    }

    public static void init(boolean z) {
        jP().ae(z);
        jP().jF();
    }

    public static void jQ() {
        jP().jF();
    }

    public static boolean jR() {
        return jP().jO();
    }

    public static void o(long j) {
        jP().n(j);
    }

    public static boolean jS() {
        return jP().jH();
    }

    public static boolean jT() {
        return jP().isWifi();
    }

    public static boolean jU() {
        return jP().jI();
    }

    public static boolean jV() {
        return 3 == jP().jJ();
    }

    public static boolean jW() {
        return 2 == jP().jJ();
    }

    public static boolean jX() {
        return 1 == jP().jJ();
    }

    public static int netType() {
        if (jT()) {
            return 1;
        }
        if (jX()) {
            return 2;
        }
        if (jW()) {
            return 3;
        }
        return (jV() || jS()) ? 4 : 0;
    }

    public static String jY() {
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

    public static String jZ() {
        String jY = jY();
        if (jY != null) {
            return jY.toUpperCase();
        }
        return jY;
    }

    public static int ka() {
        return jP().jK();
    }

    public static String kb() {
        return jP().jL();
    }

    public static int kc() {
        return jP().getProxyPort();
    }

    public static boolean kd() {
        return DL;
    }

    public static boolean be(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = jP().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long ke() {
        return jP().jM();
    }
}
