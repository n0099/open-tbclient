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
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean wS = true;
    private static j wV;
    private long wT;
    private NetworkInfo wK = null;
    private boolean isWifi = true;
    private boolean wL = false;
    private boolean wM = true;
    private int wN = 0;
    private int wO = 0;
    private int wP = -1;
    private String wQ = null;
    private int wR = -1;
    private boolean wU = true;

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
        wV = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gC() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.wK = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.wL = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.wL = true;
            } else {
                this.isWifi = false;
                this.wL = false;
            }
            this.wM = true;
            this.wN = activeNetworkInfo.getSubtype();
            if (this.wL) {
                this.wO = ap(this.wN);
            } else {
                this.wO = 0;
            }
        } else {
            this.isWifi = false;
            this.wL = false;
            this.wM = false;
            this.wN = 0;
            this.wN = 0;
        }
        this.wP = gL();
        this.wQ = Proxy.getDefaultHost();
        this.wR = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean gD() {
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

    public boolean gE() {
        if (this.wK == null) {
            gC();
        }
        return this.wM;
    }

    public boolean gF() {
        if (this.wK == null) {
            gC();
        }
        return this.isWifi;
    }

    public boolean gG() {
        if (this.wK == null) {
            gC();
        }
        return this.wL;
    }

    public int gH() {
        if (this.wK == null) {
            gC();
        }
        return this.wO;
    }

    public int gI() {
        if (this.wP == -1) {
            try {
                this.wP = gL();
            } catch (Exception e) {
                this.wP = 0;
            }
        }
        return this.wP;
    }

    public String gJ() {
        if (this.wQ == null) {
            this.wQ = Proxy.getDefaultHost();
        }
        return this.wQ;
    }

    private long gK() {
        return this.wT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(long j) {
        this.wT = j;
    }

    private static int gL() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || k.aR(networkOperator)) {
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

    public static int ap(int i) {
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

    public int gM() {
        if (-1 == this.wR) {
            this.wR = Proxy.getDefaultPort();
        }
        return this.wR;
    }

    public boolean gN() {
        return this.wU;
    }

    public void N(boolean z) {
        this.wU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j gO() {
        j jVar;
        synchronized (j.class) {
            if (wV == null) {
                wV = new j();
            }
            jVar = wV;
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
                int gV = j.gV();
                long hc = j.hc();
                j.gO().gC();
                if (j.gO().gN()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = gV;
                    networkState.mCurNetState = j.gV();
                    networkState.mlastChangedTime = hc;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    j.gO().l(currentTimeMillis);
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
        gO().N(z);
        gO().gC();
    }

    public static boolean gP() {
        return gO().gE();
    }

    public static boolean gQ() {
        return gO().gF();
    }

    public static boolean gR() {
        return gO().gG();
    }

    public static boolean gS() {
        return 3 == gO().gH();
    }

    public static boolean gT() {
        return 2 == gO().gH();
    }

    public static boolean gU() {
        return 1 == gO().gH();
    }

    public static int gV() {
        if (gQ()) {
            return 1;
        }
        if (gU()) {
            return 2;
        }
        if (gT()) {
            return 3;
        }
        return (gS() || gP()) ? 4 : 0;
    }

    public static String gW() {
        switch (gV()) {
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

    public static String gX() {
        String gW = gW();
        if (gW != null) {
            return gW.toUpperCase();
        }
        return gW;
    }

    public static int gY() {
        return gO().gI();
    }

    public static String gZ() {
        return gO().gJ();
    }

    public static int ha() {
        return gO().gM();
    }

    public static boolean hb() {
        return wS;
    }

    public static boolean aP(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = gO().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long hc() {
        return gO().gK();
    }
}
