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
    private static j Db;
    private long CZ;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean CY = true;
    private NetworkInfo CO = null;
    private boolean isWifi = true;
    private boolean CP = false;
    private boolean CQ = true;
    private int CT = 0;
    private int CU = 0;
    private int CV = -1;
    private String CW = null;
    private int CX = -1;
    private boolean Da = true;

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
        Db = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.CO = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.CP = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.CP = true;
            } else {
                this.isWifi = false;
                this.CP = false;
            }
            this.CQ = true;
            this.CT = activeNetworkInfo.getSubtype();
            if (this.CP) {
                this.CU = aq(this.CT);
            } else {
                this.CU = 0;
            }
        } else {
            this.isWifi = false;
            this.CP = false;
            this.CQ = false;
            this.CT = 0;
            this.CT = 0;
        }
        this.CV = jz();
        this.CW = Proxy.getDefaultHost();
        this.CX = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean jr() {
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

    public boolean js() {
        if (this.CO == null) {
            jq();
        }
        return this.CQ;
    }

    public boolean jt() {
        if (this.CO == null) {
            jq();
        }
        return this.isWifi;
    }

    public boolean ju() {
        if (this.CO == null) {
            jq();
        }
        return this.CP;
    }

    public int jv() {
        if (this.CO == null) {
            jq();
        }
        return this.CU;
    }

    public int jw() {
        if (this.CV == -1) {
            try {
                this.CV = jz();
            } catch (Exception e) {
                this.CV = 0;
            }
        }
        return this.CV;
    }

    public String jx() {
        if (this.CW == null) {
            this.CW = Proxy.getDefaultHost();
        }
        return this.CW;
    }

    private long jy() {
        return this.CZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(long j) {
        this.CZ = j;
    }

    private static int jz() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || k.bd(networkOperator)) {
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

    public static int aq(int i) {
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

    public int jA() {
        if (-1 == this.CX) {
            this.CX = Proxy.getDefaultPort();
        }
        return this.CX;
    }

    public boolean jB() {
        return this.Da;
    }

    public void P(boolean z) {
        this.Da = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j jC() {
        j jVar;
        synchronized (j.class) {
            if (Db == null) {
                Db = new j();
            }
            jVar = Db;
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
                int jJ = j.jJ();
                long jQ = j.jQ();
                j.jC().jq();
                if (j.jC().jB()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = jJ;
                    networkState.mCurNetState = j.jJ();
                    networkState.mlastChangedTime = jQ;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    j.jC().n(currentTimeMillis);
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
        jC().P(z);
        jC().jq();
    }

    public static boolean jD() {
        return jC().js();
    }

    public static boolean jE() {
        return jC().jt();
    }

    public static boolean jF() {
        return jC().ju();
    }

    public static boolean jG() {
        return 3 == jC().jv();
    }

    public static boolean jH() {
        return 2 == jC().jv();
    }

    public static boolean jI() {
        return 1 == jC().jv();
    }

    public static int jJ() {
        if (jE()) {
            return 1;
        }
        if (jI()) {
            return 2;
        }
        if (jH()) {
            return 3;
        }
        return (jG() || jD()) ? 4 : 0;
    }

    public static String jK() {
        switch (jJ()) {
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

    public static String jL() {
        String jK = jK();
        if (jK != null) {
            return jK.toUpperCase();
        }
        return jK;
    }

    public static int jM() {
        return jC().jw();
    }

    public static String jN() {
        return jC().jx();
    }

    public static int jO() {
        return jC().jA();
    }

    public static boolean jP() {
        return CY;
    }

    public static boolean bb(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = jC().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long jQ() {
        return jC().jy();
    }
}
