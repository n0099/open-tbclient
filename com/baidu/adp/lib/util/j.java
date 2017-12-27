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
    private static j amw;
    private long amu;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean amt = true;
    private NetworkInfo aml = null;
    private boolean isWifi = true;
    private boolean amm = false;
    private boolean amn = true;
    private int amo = 0;
    private int amp = 0;
    private int amq = -1;
    private String amr = null;
    private int ams = -1;
    private boolean amv = true;

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
        amw = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ov() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.aml = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.amm = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.amm = true;
            } else {
                this.isWifi = false;
                this.amm = false;
            }
            this.amn = true;
            this.amo = activeNetworkInfo.getSubtype();
            if (this.amm) {
                this.amp = dp(this.amo);
            } else {
                this.amp = 0;
            }
        } else {
            this.isWifi = false;
            this.amm = false;
            this.amn = false;
            this.amo = 0;
            this.amo = 0;
        }
        this.amq = oE();
        this.amr = Proxy.getDefaultHost();
        this.ams = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean ow() {
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

    public boolean ox() {
        if (this.aml == null) {
            ov();
        }
        return this.amn;
    }

    public boolean oy() {
        if (this.aml == null) {
            ov();
        }
        return this.isWifi;
    }

    public boolean oz() {
        if (this.aml == null) {
            ov();
        }
        return this.amm;
    }

    public int oA() {
        if (this.aml == null) {
            ov();
        }
        return this.amp;
    }

    public int oB() {
        if (this.amq == -1) {
            try {
                this.amq = oE();
            } catch (Exception e) {
                this.amq = 0;
            }
        }
        return this.amq;
    }

    public String oC() {
        if (this.amr == null) {
            this.amr = Proxy.getDefaultHost();
        }
        return this.amr;
    }

    private long oD() {
        return this.amu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(long j) {
        this.amu = j;
    }

    private static int oE() {
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

    public int oF() {
        if (-1 == this.ams) {
            this.ams = Proxy.getDefaultPort();
        }
        return this.ams;
    }

    public boolean oG() {
        return this.amv;
    }

    public void aq(boolean z) {
        this.amv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j oH() {
        j jVar;
        synchronized (j.class) {
            if (amw == null) {
                amw = new j();
            }
            jVar = amw;
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
                int oO = j.oO();
                long oV = j.oV();
                j.oH().ov();
                if (j.oH().oG()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = oO;
                    networkState.mCurNetState = j.oO();
                    networkState.mlastChangedTime = oV;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    j.oH().t(currentTimeMillis);
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
        oH().aq(z);
        oH().ov();
    }

    public static boolean oI() {
        return oH().ox();
    }

    public static boolean oJ() {
        return oH().oy();
    }

    public static boolean oK() {
        return oH().oz();
    }

    public static boolean oL() {
        return 3 == oH().oA();
    }

    public static boolean oM() {
        return 2 == oH().oA();
    }

    public static boolean oN() {
        return 1 == oH().oA();
    }

    public static int oO() {
        if (oJ()) {
            return 1;
        }
        if (oN()) {
            return 2;
        }
        if (oM()) {
            return 3;
        }
        return (oL() || oI()) ? 4 : 0;
    }

    public static String oP() {
        switch (oO()) {
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

    public static String oQ() {
        String oP = oP();
        if (oP != null) {
            return oP.toUpperCase();
        }
        return oP;
    }

    public static int oR() {
        return oH().oB();
    }

    public static String oS() {
        return oH().oC();
    }

    public static int oT() {
        return oH().oF();
    }

    public static boolean oU() {
        return amt;
    }

    public static boolean aS(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = oH().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long oV() {
        return oH().oD();
    }
}
