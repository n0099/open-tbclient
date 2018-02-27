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
    private static j ams;
    private long amq;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean amp = true;
    private NetworkInfo amh = null;
    private boolean isWifi = true;
    private boolean ami = false;
    private boolean amj = true;
    private int amk = 0;
    private int aml = 0;
    private int amm = -1;
    private String amn = null;
    private int amo = -1;
    private boolean amr = true;

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
        ams = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ow() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.amh = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.ami = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.ami = true;
            } else {
                this.isWifi = false;
                this.ami = false;
            }
            this.amj = true;
            this.amk = activeNetworkInfo.getSubtype();
            if (this.ami) {
                this.aml = dp(this.amk);
            } else {
                this.aml = 0;
            }
        } else {
            this.isWifi = false;
            this.ami = false;
            this.amj = false;
            this.amk = 0;
            this.amk = 0;
        }
        this.amm = oF();
        this.amn = Proxy.getDefaultHost();
        this.amo = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean ox() {
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

    public boolean oy() {
        if (this.amh == null) {
            ow();
        }
        return this.amj;
    }

    public boolean oz() {
        if (this.amh == null) {
            ow();
        }
        return this.isWifi;
    }

    public boolean oA() {
        if (this.amh == null) {
            ow();
        }
        return this.ami;
    }

    public int oB() {
        if (this.amh == null) {
            ow();
        }
        return this.aml;
    }

    public int oC() {
        if (this.amm == -1) {
            try {
                this.amm = oF();
            } catch (Exception e) {
                this.amm = 0;
            }
        }
        return this.amm;
    }

    public String oD() {
        if (this.amn == null) {
            this.amn = Proxy.getDefaultHost();
        }
        return this.amn;
    }

    private long oE() {
        return this.amq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(long j) {
        this.amq = j;
    }

    private static int oF() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || k.aU(networkOperator)) {
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
                return 3;
            case 4:
            default:
                return 0;
        }
    }

    public static int dp(int i) {
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

    public int oG() {
        if (-1 == this.amo) {
            this.amo = Proxy.getDefaultPort();
        }
        return this.amo;
    }

    public boolean oH() {
        return this.amr;
    }

    public void au(boolean z) {
        this.amr = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j oI() {
        j jVar;
        synchronized (j.class) {
            if (ams == null) {
                ams = new j();
            }
            jVar = ams;
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
                int oP = j.oP();
                long oW = j.oW();
                j.oI().ow();
                if (j.oI().oH()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = oP;
                    networkState.mCurNetState = j.oP();
                    networkState.mlastChangedTime = oW;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    j.oI().t(currentTimeMillis);
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
        oI().au(z);
        oI().ow();
    }

    public static boolean oJ() {
        return oI().oy();
    }

    public static boolean oK() {
        return oI().oz();
    }

    public static boolean oL() {
        return oI().oA();
    }

    public static boolean oM() {
        return 3 == oI().oB();
    }

    public static boolean oN() {
        return 2 == oI().oB();
    }

    public static boolean oO() {
        return 1 == oI().oB();
    }

    public static int oP() {
        if (oK()) {
            return 1;
        }
        if (oO()) {
            return 2;
        }
        if (oN()) {
            return 3;
        }
        return (oM() || oJ()) ? 4 : 0;
    }

    public static String oQ() {
        switch (oP()) {
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

    public static String oR() {
        String oQ = oQ();
        if (oQ != null) {
            return oQ.toUpperCase();
        }
        return oQ;
    }

    public static int oS() {
        return oI().oC();
    }

    public static String oT() {
        return oI().oD();
    }

    public static int oU() {
        return oI().oG();
    }

    public static boolean oV() {
        return amp;
    }

    public static boolean aS(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = oI().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long oW() {
        return oI().oE();
    }
}
