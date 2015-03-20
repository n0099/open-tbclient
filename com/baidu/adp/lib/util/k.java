package com.baidu.adp.lib.util;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.adp.base.BdBaseApplication;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class k {
    private static Pattern vz = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean yA = true;
    private static k yB;
    private NetworkInfo yt = null;
    private boolean yu = true;
    private boolean yv = false;
    private boolean yw = true;
    private int yx = 0;
    private int yy = 0;
    private int yz = -1;
    private String mProxyHost = null;
    private int mProxyPort = -1;

    static {
        try {
            l lVar = new l(null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            BdBaseApplication.getInst().getApp().registerReceiver(lVar, intentFilter);
            iG().iy();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        yB = null;
    }

    public void iy() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.yt = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.yu = true;
                this.yv = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.yu = false;
                this.yv = true;
            } else {
                this.yu = false;
                this.yv = false;
            }
            this.yw = true;
            this.yx = activeNetworkInfo.getSubtype();
            if (this.yv) {
                this.yy = T(this.yx);
            } else {
                this.yy = 0;
            }
        } else {
            this.yu = false;
            this.yv = false;
            this.yw = false;
            this.yx = 0;
            this.yx = 0;
        }
        this.yz = iF();
        this.mProxyHost = Proxy.getDefaultHost();
        this.mProxyPort = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) com.baidu.adp.lib.network.willdelete.e.hu().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean iz() {
        if (this.yt == null) {
            iy();
        }
        return this.yw;
    }

    public boolean isWifi() {
        if (this.yt == null) {
            iy();
        }
        return this.yu;
    }

    public boolean hv() {
        if (this.yt == null) {
            iy();
        }
        return this.yv;
    }

    public int iA() {
        if (this.yt == null) {
            iy();
        }
        return this.yy;
    }

    public int iB() {
        if (this.yz == -1) {
            try {
                this.yz = iF();
            } catch (Exception e) {
                this.yz = 0;
            }
        }
        return this.yz;
    }

    public static boolean aJ(String str) {
        if (vz.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public String iC() {
        if (this.mProxyHost == null) {
            this.mProxyHost = Proxy.getDefaultHost();
        }
        return this.mProxyHost;
    }

    public int iD() {
        if (-1 == this.mProxyPort) {
            this.mProxyPort = Proxy.getDefaultPort();
        }
        return this.mProxyPort;
    }

    public static boolean iE() {
        return (iG().yu || iF() == 1 || m.aL(Proxy.getDefaultHost())) ? false : true;
    }

    private static int iF() {
        int i;
        String networkOperator = ((TelephonyManager) com.baidu.adp.lib.network.willdelete.e.hu().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || m.aL(networkOperator)) {
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

    public static int T(int i) {
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

    public static synchronized k iG() {
        k kVar;
        synchronized (k.class) {
            if (yB == null) {
                yB = new k();
            }
            kVar = yB;
        }
        return kVar;
    }

    public static boolean iH() {
        return iG().iz();
    }

    public static boolean iI() {
        return iG().isWifi();
    }

    public static boolean iJ() {
        return iG().hv();
    }

    public static boolean iK() {
        return 3 == iG().iA();
    }

    public static boolean iL() {
        return 2 == iG().iA();
    }

    public static boolean hx() {
        return 1 == iG().iA();
    }

    public static int iM() {
        if (iI()) {
            return 1;
        }
        if (hx()) {
            return 2;
        }
        if (iL()) {
            return 3;
        }
        return (iK() || iH()) ? 4 : 0;
    }

    public static String iN() {
        switch (iM()) {
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

    public static String iO() {
        String iN = iN();
        if (iN != null) {
            return iN.toUpperCase();
        }
        return iN;
    }

    public static int iP() {
        return iG().iB();
    }

    public static String iQ() {
        return iG().iC();
    }

    public static int iR() {
        return iG().iD();
    }

    public static boolean iS() {
        return yA;
    }
}
