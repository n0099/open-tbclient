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
    private static j Gf;
    private long Gd;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean Gc = true;
    private NetworkInfo FU = null;
    private boolean isWifi = true;
    private boolean FV = false;
    private boolean FW = true;
    private int FX = 0;
    private int FY = 0;
    private int FZ = -1;
    private String Ga = null;
    private int Gb = -1;
    private boolean Ge = true;

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
        Gf = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kL() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.FU = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.FV = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.FV = true;
            } else {
                this.isWifi = false;
                this.FV = false;
            }
            this.FW = true;
            this.FX = activeNetworkInfo.getSubtype();
            if (this.FV) {
                this.FY = aA(this.FX);
            } else {
                this.FY = 0;
            }
        } else {
            this.isWifi = false;
            this.FV = false;
            this.FW = false;
            this.FX = 0;
            this.FX = 0;
        }
        this.FZ = kV();
        this.Ga = Proxy.getDefaultHost();
        this.Gb = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean kM() {
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

    public boolean kN() {
        if (this.FU == null) {
            kL();
        }
        return this.FW;
    }

    public boolean isWifi() {
        if (this.FU == null) {
            kL();
        }
        return this.isWifi;
    }

    public boolean kO() {
        if (this.FU == null) {
            kL();
        }
        return this.FV;
    }

    public int kP() {
        if (this.FU == null) {
            kL();
        }
        return this.FY;
    }

    public int kQ() {
        if (this.FU == null) {
            kL();
        }
        return this.FX;
    }

    public static int kR() {
        return kX().kQ();
    }

    public int kS() {
        if (this.FZ == -1) {
            try {
                this.FZ = kV();
            } catch (Exception e) {
                this.FZ = 0;
            }
        }
        return this.FZ;
    }

    public String kT() {
        if (this.Ga == null) {
            this.Ga = Proxy.getDefaultHost();
        }
        return this.Ga;
    }

    private long kU() {
        return this.Gd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(long j) {
        this.Gd = j;
    }

    private static int kV() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || k.bw(networkOperator)) {
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

    public static int aA(int i) {
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
        if (-1 == this.Gb) {
            this.Gb = Proxy.getDefaultPort();
        }
        return this.Gb;
    }

    public boolean kW() {
        return this.Ge;
    }

    public void am(boolean z) {
        this.Ge = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j kX() {
        j jVar;
        synchronized (j.class) {
            if (Gf == null) {
                Gf = new j();
            }
            jVar = Gf;
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
                int netType = j.netType();
                long lk = j.lk();
                j.kX().kL();
                if (j.kX().kW()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = netType;
                    networkState.mCurNetState = j.netType();
                    networkState.mlastChangedTime = lk;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    j.kX().q(currentTimeMillis);
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
        kX().am(z);
        kX().kL();
    }

    public static boolean kY() {
        return kX().kN();
    }

    public static boolean kZ() {
        return kX().isWifi();
    }

    public static boolean la() {
        return kX().kO();
    }

    public static boolean lb() {
        return 3 == kX().kP();
    }

    public static boolean lc() {
        return 2 == kX().kP();
    }

    public static boolean ld() {
        return 1 == kX().kP();
    }

    public static int netType() {
        if (kZ()) {
            return 1;
        }
        if (ld()) {
            return 2;
        }
        if (lc()) {
            return 3;
        }
        return (lb() || kY()) ? 4 : 0;
    }

    public static String le() {
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

    public static String lf() {
        String le = le();
        if (le != null) {
            return le.toUpperCase();
        }
        return le;
    }

    public static int lg() {
        return kX().kS();
    }

    public static String lh() {
        return kX().kT();
    }

    public static int li() {
        return kX().getProxyPort();
    }

    public static boolean lj() {
        return Gc;
    }

    public static boolean bu(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = kX().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long lk() {
        return kX().kU();
    }
}
