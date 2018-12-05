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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class j {
    private static j Gg;
    private long Ge;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean Gd = true;
    private NetworkInfo FV = null;
    private boolean isWifi = true;
    private boolean FW = false;
    private boolean FX = true;
    private int FY = 0;
    private int FZ = 0;
    private int Ga = -1;
    private String Gb = null;
    private int Gc = -1;
    private boolean Gf = true;

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
        Gg = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kJ() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.FV = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.FW = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.FW = true;
            } else {
                this.isWifi = false;
                this.FW = false;
            }
            this.FX = true;
            this.FY = activeNetworkInfo.getSubtype();
            if (this.FW) {
                this.FZ = aQ(this.FY);
            } else {
                this.FZ = 0;
            }
        } else {
            this.isWifi = false;
            this.FW = false;
            this.FX = false;
            this.FY = 0;
            this.FY = 0;
        }
        this.Ga = kS();
        this.Gb = Proxy.getDefaultHost();
        this.Gc = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean kK() {
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

    public boolean kL() {
        if (this.FV == null) {
            kJ();
        }
        return this.FX;
    }

    public boolean isWifi() {
        if (this.FV == null) {
            kJ();
        }
        return this.isWifi;
    }

    public boolean kM() {
        if (this.FV == null) {
            kJ();
        }
        return this.FW;
    }

    public int kN() {
        if (this.FV == null) {
            kJ();
        }
        return this.FZ;
    }

    public int kO() {
        if (this.FV == null) {
            kJ();
        }
        return this.FY;
    }

    public static int kP() {
        return kU().kO();
    }

    public int getOperatorType() {
        if (this.Ga == -1) {
            try {
                this.Ga = kS();
            } catch (Exception e) {
                this.Ga = 0;
            }
        }
        return this.Ga;
    }

    public String kQ() {
        if (this.Gb == null) {
            this.Gb = Proxy.getDefaultHost();
        }
        return this.Gb;
    }

    private long kR() {
        return this.Ge;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j) {
        this.Ge = j;
    }

    private static int kS() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || k.bw(networkOperator)) {
            return 0;
        }
        String substring = networkOperator.substring(0, 3);
        if (substring == null || !substring.equals(SystemScreenshotManager.UBC_SHARE_FAIL)) {
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

    public static int aQ(int i) {
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
        if (-1 == this.Gc) {
            this.Gc = Proxy.getDefaultPort();
        }
        return this.Gc;
    }

    public boolean kT() {
        return this.Gf;
    }

    public void am(boolean z) {
        this.Gf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j kU() {
        j jVar;
        synchronized (j.class) {
            if (Gg == null) {
                Gg = new j();
            }
            jVar = Gg;
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
                long lh = j.lh();
                j.kU().kJ();
                if (j.kU().kT()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = netType;
                    networkState.mCurNetState = j.netType();
                    networkState.mlastChangedTime = lh;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    j.kU().s(currentTimeMillis);
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
        kU().am(z);
        kU().kJ();
    }

    public static boolean kV() {
        return kU().kL();
    }

    public static boolean kW() {
        return kU().isWifi();
    }

    public static boolean kX() {
        return kU().kM();
    }

    public static boolean kY() {
        return 3 == kU().kN();
    }

    public static boolean kZ() {
        return 2 == kU().kN();
    }

    public static boolean la() {
        return 1 == kU().kN();
    }

    public static int netType() {
        if (kW()) {
            return 1;
        }
        if (la()) {
            return 2;
        }
        if (kZ()) {
            return 3;
        }
        return (kY() || kV()) ? 4 : 0;
    }

    public static String lb() {
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

    public static String lc() {
        String lb = lb();
        if (lb != null) {
            return lb.toUpperCase();
        }
        return lb;
    }

    public static int ld() {
        return kU().getOperatorType();
    }

    public static String le() {
        return kU().kQ();
    }

    public static int lf() {
        return kU().getProxyPort();
    }

    public static boolean lg() {
        return Gd;
    }

    public static boolean bu(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = kU().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long lh() {
        return kU().kR();
    }
}
