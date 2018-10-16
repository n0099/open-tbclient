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
    private static j Gc;
    private long Ga;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean FZ = true;
    private NetworkInfo FQ = null;
    private boolean isWifi = true;
    private boolean FR = false;
    private boolean FT = true;
    private int FU = 0;
    private int FV = 0;
    private int FW = -1;
    private String FX = null;
    private int FY = -1;
    private boolean Gb = true;

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
        Gc = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kL() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.FQ = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.FR = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.FR = true;
            } else {
                this.isWifi = false;
                this.FR = false;
            }
            this.FT = true;
            this.FU = activeNetworkInfo.getSubtype();
            if (this.FR) {
                this.FV = az(this.FU);
            } else {
                this.FV = 0;
            }
        } else {
            this.isWifi = false;
            this.FR = false;
            this.FT = false;
            this.FU = 0;
            this.FU = 0;
        }
        this.FW = kU();
        this.FX = Proxy.getDefaultHost();
        this.FY = Proxy.getDefaultPort();
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
        if (this.FQ == null) {
            kL();
        }
        return this.FT;
    }

    public boolean isWifi() {
        if (this.FQ == null) {
            kL();
        }
        return this.isWifi;
    }

    public boolean kO() {
        if (this.FQ == null) {
            kL();
        }
        return this.FR;
    }

    public int kP() {
        if (this.FQ == null) {
            kL();
        }
        return this.FV;
    }

    public int kQ() {
        if (this.FQ == null) {
            kL();
        }
        return this.FU;
    }

    public static int kR() {
        return kW().kQ();
    }

    public int getOperatorType() {
        if (this.FW == -1) {
            try {
                this.FW = kU();
            } catch (Exception e) {
                this.FW = 0;
            }
        }
        return this.FW;
    }

    public String kS() {
        if (this.FX == null) {
            this.FX = Proxy.getDefaultHost();
        }
        return this.FX;
    }

    private long kT() {
        return this.Ga;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(long j) {
        this.Ga = j;
    }

    private static int kU() {
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

    public static int az(int i) {
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
        if (-1 == this.FY) {
            this.FY = Proxy.getDefaultPort();
        }
        return this.FY;
    }

    public boolean kV() {
        return this.Gb;
    }

    public void Y(boolean z) {
        this.Gb = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j kW() {
        j jVar;
        synchronized (j.class) {
            if (Gc == null) {
                Gc = new j();
            }
            jVar = Gc;
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
                int ld = j.ld();
                long lk = j.lk();
                j.kW().kL();
                if (j.kW().kV()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = ld;
                    networkState.mCurNetState = j.ld();
                    networkState.mlastChangedTime = lk;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    j.kW().q(currentTimeMillis);
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
        kW().Y(z);
        kW().kL();
    }

    public static boolean kX() {
        return kW().kN();
    }

    public static boolean kY() {
        return kW().isWifi();
    }

    public static boolean kZ() {
        return kW().kO();
    }

    public static boolean la() {
        return 3 == kW().kP();
    }

    public static boolean lb() {
        return 2 == kW().kP();
    }

    public static boolean lc() {
        return 1 == kW().kP();
    }

    public static int ld() {
        if (kY()) {
            return 1;
        }
        if (lc()) {
            return 2;
        }
        if (lb()) {
            return 3;
        }
        return (la() || kX()) ? 4 : 0;
    }

    public static String le() {
        switch (ld()) {
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
        return kW().getOperatorType();
    }

    public static String lh() {
        return kW().kS();
    }

    public static int li() {
        return kW().getProxyPort();
    }

    public static boolean lj() {
        return FZ;
    }

    public static boolean bu(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = kW().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long lk() {
        return kW().kT();
    }
}
