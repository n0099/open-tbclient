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
    private static j amz;
    private long amx;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean amw = true;
    private NetworkInfo amo = null;
    private boolean isWifi = true;
    private boolean amp = false;
    private boolean amq = true;
    private int amr = 0;
    private int ams = 0;
    private int amt = -1;
    private String amu = null;
    private int amv = -1;
    private boolean amy = true;

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
        amz = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ow() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.amo = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.amp = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.amp = true;
            } else {
                this.isWifi = false;
                this.amp = false;
            }
            this.amq = true;
            this.amr = activeNetworkInfo.getSubtype();
            if (this.amp) {
                this.ams = dp(this.amr);
            } else {
                this.ams = 0;
            }
        } else {
            this.isWifi = false;
            this.amp = false;
            this.amq = false;
            this.amr = 0;
            this.amr = 0;
        }
        this.amt = oF();
        this.amu = Proxy.getDefaultHost();
        this.amv = Proxy.getDefaultPort();
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
        if (this.amo == null) {
            ow();
        }
        return this.amq;
    }

    public boolean oz() {
        if (this.amo == null) {
            ow();
        }
        return this.isWifi;
    }

    public boolean oA() {
        if (this.amo == null) {
            ow();
        }
        return this.amp;
    }

    public int oB() {
        if (this.amo == null) {
            ow();
        }
        return this.ams;
    }

    public int oC() {
        if (this.amt == -1) {
            try {
                this.amt = oF();
            } catch (Exception e) {
                this.amt = 0;
            }
        }
        return this.amt;
    }

    public String oD() {
        if (this.amu == null) {
            this.amu = Proxy.getDefaultHost();
        }
        return this.amu;
    }

    private long oE() {
        return this.amx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(long j) {
        this.amx = j;
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
        if (-1 == this.amv) {
            this.amv = Proxy.getDefaultPort();
        }
        return this.amv;
    }

    public boolean oH() {
        return this.amy;
    }

    public void ar(boolean z) {
        this.amy = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j oI() {
        j jVar;
        synchronized (j.class) {
            if (amz == null) {
                amz = new j();
            }
            jVar = amz;
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
        oI().ar(z);
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
        return amw;
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
