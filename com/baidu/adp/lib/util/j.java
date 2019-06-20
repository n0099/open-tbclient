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
    private static j DN;
    private long DL;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean DK = true;
    private NetworkInfo DC = null;
    private boolean isWifi = true;
    private boolean DD = false;
    private boolean DE = true;
    private int DF = 0;
    private int DG = 0;
    private int DH = -1;
    private String DI = null;
    private int DJ = -1;
    private boolean DM = true;
    private Runnable DO = new Runnable() { // from class: com.baidu.adp.lib.util.j.1
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
        DN = null;
    }

    private void jF() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.DC = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.DD = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.DD = true;
            } else {
                this.isWifi = false;
                this.DD = false;
            }
            this.DE = true;
            this.DF = activeNetworkInfo.getSubtype();
            if (this.DD) {
                this.DG = as(this.DF);
            } else {
                this.DG = 0;
            }
        } else {
            this.isWifi = false;
            this.DD = false;
            this.DE = false;
            this.DF = 0;
            this.DF = 0;
        }
        this.DH = jN();
        this.DI = Proxy.getDefaultHost();
        this.DJ = Proxy.getDefaultPort();
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
        if (this.DC == null) {
            jF();
        }
        return this.DE;
    }

    public boolean isWifi() {
        if (this.DC == null) {
            jF();
        }
        return this.isWifi;
    }

    public boolean jI() {
        if (this.DC == null) {
            jF();
        }
        return this.DD;
    }

    public int jJ() {
        if (this.DC == null) {
            jF();
        }
        return this.DG;
    }

    public int jK() {
        if (this.DH == -1) {
            try {
                this.DH = jN();
            } catch (Exception e) {
                this.DH = 0;
            }
        }
        return this.DH;
    }

    public String jL() {
        if (this.DI == null) {
            this.DI = Proxy.getDefaultHost();
        }
        return this.DI;
    }

    private long jM() {
        return this.DL;
    }

    private void n(long j) {
        this.DL = j;
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
        if (-1 == this.DJ) {
            this.DJ = Proxy.getDefaultPort();
        }
        return this.DJ;
    }

    public boolean jO() {
        return this.DM;
    }

    public void ae(boolean z) {
        this.DM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j jP() {
        j jVar;
        synchronized (j.class) {
            if (DN == null) {
                DN = new j();
            }
            jVar = DN;
        }
        return jVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AsyncService.INSTANCE.sendRunnable(j.jP().DO);
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
        return DK;
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
