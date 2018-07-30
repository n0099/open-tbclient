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
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class j {
    private static j CZ;
    private long CX;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean CW = true;
    private NetworkInfo CM = null;
    private boolean isWifi = true;
    private boolean CN = false;
    private boolean CO = true;
    private int CP = 0;
    private int CQ = 0;
    private int CT = -1;
    private String CU = null;
    private int CV = -1;
    private boolean CY = true;

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
        CZ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.CM = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.CN = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.CN = true;
            } else {
                this.isWifi = false;
                this.CN = false;
            }
            this.CO = true;
            this.CP = activeNetworkInfo.getSubtype();
            if (this.CN) {
                this.CQ = ar(this.CP);
            } else {
                this.CQ = 0;
            }
        } else {
            this.isWifi = false;
            this.CN = false;
            this.CO = false;
            this.CP = 0;
            this.CP = 0;
        }
        this.CT = jA();
        this.CU = Proxy.getDefaultHost();
        this.CV = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean js() {
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

    public boolean jt() {
        if (this.CM == null) {
            jr();
        }
        return this.CO;
    }

    public boolean ju() {
        if (this.CM == null) {
            jr();
        }
        return this.isWifi;
    }

    public boolean jv() {
        if (this.CM == null) {
            jr();
        }
        return this.CN;
    }

    public int jw() {
        if (this.CM == null) {
            jr();
        }
        return this.CQ;
    }

    public int jx() {
        if (this.CT == -1) {
            try {
                this.CT = jA();
            } catch (Exception e) {
                this.CT = 0;
            }
        }
        return this.CT;
    }

    public String jy() {
        if (this.CU == null) {
            this.CU = Proxy.getDefaultHost();
        }
        return this.CU;
    }

    private long jz() {
        return this.CX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j) {
        this.CX = j;
    }

    private static int jA() {
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

    public static int ar(int i) {
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

    public int jB() {
        if (-1 == this.CV) {
            this.CV = Proxy.getDefaultPort();
        }
        return this.CV;
    }

    public boolean jC() {
        return this.CY;
    }

    public void O(boolean z) {
        this.CY = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j jD() {
        j jVar;
        synchronized (j.class) {
            if (CZ == null) {
                CZ = new j();
            }
            jVar = CZ;
        }
        return jVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                int jK = j.jK();
                long jR = j.jR();
                j.jD().jr();
                if (j.jD().jC()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = jK;
                    networkState.mCurNetState = j.jK();
                    networkState.mlastChangedTime = jR;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    j.jD().n(currentTimeMillis);
                    MessageManager.getInstance().dispatchResponsedMessage(new NetWorkChangedMessage(networkState));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void init() {
        init(true);
    }

    public static void init(boolean z) {
        jD().O(z);
        jD().jr();
    }

    public static boolean jE() {
        return jD().jt();
    }

    public static boolean jF() {
        return jD().ju();
    }

    public static boolean jG() {
        return jD().jv();
    }

    public static boolean jH() {
        return 3 == jD().jw();
    }

    public static boolean jI() {
        return 2 == jD().jw();
    }

    public static boolean jJ() {
        return 1 == jD().jw();
    }

    public static int jK() {
        if (jF()) {
            return 1;
        }
        if (jJ()) {
            return 2;
        }
        if (jI()) {
            return 3;
        }
        return (jH() || jE()) ? 4 : 0;
    }

    public static String jL() {
        switch (jK()) {
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

    public static String jM() {
        String jL = jL();
        if (jL != null) {
            return jL.toUpperCase();
        }
        return jL;
    }

    public static int jN() {
        return jD().jx();
    }

    public static String jO() {
        return jD().jy();
    }

    public static int jP() {
        return jD().jB();
    }

    public static boolean jQ() {
        return CW;
    }

    public static boolean be(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = jD().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long jR() {
        return jD().jz();
    }
}
