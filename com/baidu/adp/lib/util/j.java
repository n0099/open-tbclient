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
    private static j DU;
    private long DS;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean DR = true;
    private NetworkInfo DI = null;
    private boolean isWifi = true;
    private boolean DJ = false;
    private boolean DK = true;
    private int DL = 0;
    private int DM = 0;
    private int DN = -1;
    private String DO = null;
    private int DQ = -1;
    private boolean DT = true;
    private Runnable DV = new Runnable() { // from class: com.baidu.adp.lib.util.j.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                int netType = j.netType();
                long kp = j.kp();
                j.ka();
                if (j.kb()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = netType;
                    networkState.mCurNetState = j.netType();
                    networkState.mlastChangedTime = kp;
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
        DU = null;
    }

    private void jO() {
        NetworkInfo jP = jP();
        this.DI = jP;
        if (jP != null) {
            if (jP.getType() == 1) {
                this.isWifi = true;
                this.DJ = false;
            } else if (jP.getType() == 0) {
                this.isWifi = false;
                this.DJ = true;
            } else {
                this.isWifi = false;
                this.DJ = false;
            }
            this.DK = true;
            this.DL = jP.getSubtype();
            if (this.DJ) {
                this.DM = as(this.DL);
            } else {
                this.DM = 0;
            }
        } else {
            this.isWifi = false;
            this.DJ = false;
            this.DK = false;
            this.DL = 0;
            this.DL = 0;
        }
        this.DN = jX();
        this.DO = Proxy.getDefaultHost();
        this.DQ = Proxy.getDefaultPort();
    }

    private NetworkInfo jP() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean jQ() {
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

    public boolean jR() {
        if (this.DI == null) {
            jO();
        }
        return this.DK;
    }

    public boolean isWifi() {
        if (this.DI == null) {
            jO();
        }
        return this.isWifi;
    }

    public boolean jS() {
        if (this.DI == null) {
            jO();
        }
        return this.DJ;
    }

    public int jT() {
        if (this.DI == null) {
            jO();
        }
        return this.DM;
    }

    public int jU() {
        if (this.DN == -1) {
            try {
                this.DN = jX();
            } catch (Exception e) {
                this.DN = 0;
            }
        }
        return this.DN;
    }

    public String jV() {
        if (this.DO == null) {
            this.DO = Proxy.getDefaultHost();
        }
        return this.DO;
    }

    private long jW() {
        return this.DS;
    }

    private void n(long j) {
        this.DS = j;
    }

    private static int jX() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || k.bh(networkOperator)) {
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
        if (-1 == this.DQ) {
            this.DQ = Proxy.getDefaultPort();
        }
        return this.DQ;
    }

    public boolean jY() {
        return this.DT;
    }

    public void af(boolean z) {
        this.DT = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j jZ() {
        j jVar;
        synchronized (j.class) {
            if (DU == null) {
                DU = new j();
            }
            jVar = DU;
        }
        return jVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AsyncService.INSTANCE.sendRunnable(j.jZ().DV);
        }
    }

    public static void init() {
        ag(true);
    }

    public static void ag(boolean z) {
        jZ().af(z);
        jZ().jO();
    }

    public static void ka() {
        jZ().jO();
    }

    public static boolean kb() {
        return jZ().jY();
    }

    public static void o(long j) {
        jZ().n(j);
    }

    public static boolean kc() {
        return jZ().jR();
    }

    public static boolean kd() {
        return jZ().isWifi();
    }

    public static boolean ke() {
        return jZ().jS();
    }

    public static boolean kf() {
        return 3 == jZ().jT();
    }

    public static boolean kg() {
        return 2 == jZ().jT();
    }

    public static boolean kh() {
        return 1 == jZ().jT();
    }

    public static int netType() {
        if (kd()) {
            return 1;
        }
        if (kh()) {
            return 2;
        }
        if (kg()) {
            return 3;
        }
        return (kf() || kc()) ? 4 : 0;
    }

    public static String ki() {
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

    public static String kj() {
        String ki = ki();
        if (ki != null) {
            return ki.toUpperCase();
        }
        return ki;
    }

    public static int kk() {
        return jZ().jU();
    }

    public static String kl() {
        return jZ().jV();
    }

    public static int km() {
        return jZ().getProxyPort();
    }

    public static boolean kn() {
        return DR;
    }

    public static boolean bf(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean ko() {
        NetworkInfo jP = jZ().jP();
        return (jP == null || jP.getExtraInfo() == null || !jP.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long kp() {
        return jZ().jW();
    }
}
