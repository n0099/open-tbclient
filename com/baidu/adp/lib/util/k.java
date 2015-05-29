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
    private static Pattern uL = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean yo = true;
    private static k yp;
    private NetworkInfo yi = null;
    private boolean isWifi = true;
    private boolean yj = false;
    private boolean yk = true;
    private int yl = 0;
    private int ym = 0;
    private int yn = -1;
    private String mProxyHost = null;
    private int mProxyPort = -1;

    static {
        try {
            l lVar = new l(null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            BdBaseApplication.getInst().getApp().registerReceiver(lVar, intentFilter);
            iW().iP();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        yp = null;
    }

    public void iP() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.yi = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.yj = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.yj = true;
            } else {
                this.isWifi = false;
                this.yj = false;
            }
            this.yk = true;
            this.yl = activeNetworkInfo.getSubtype();
            if (this.yj) {
                this.ym = R(this.yl);
            } else {
                this.ym = 0;
            }
        } else {
            this.isWifi = false;
            this.yj = false;
            this.yk = false;
            this.yl = 0;
            this.yl = 0;
        }
        this.yn = iV();
        this.mProxyHost = Proxy.getDefaultHost();
        this.mProxyPort = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean iQ() {
        if (this.yi == null) {
            iP();
        }
        return this.yk;
    }

    public boolean isWifi() {
        if (this.yi == null) {
            iP();
        }
        return this.isWifi;
    }

    public boolean hg() {
        if (this.yi == null) {
            iP();
        }
        return this.yj;
    }

    public int iR() {
        if (this.yi == null) {
            iP();
        }
        return this.ym;
    }

    public int iS() {
        if (this.yn == -1) {
            try {
                this.yn = iV();
            } catch (Exception e) {
                this.yn = 0;
            }
        }
        return this.yn;
    }

    public static boolean aS(String str) {
        if (uL.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = iW().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public String iT() {
        if (this.mProxyHost == null) {
            this.mProxyHost = Proxy.getDefaultHost();
        }
        return this.mProxyHost;
    }

    public int iU() {
        if (-1 == this.mProxyPort) {
            this.mProxyPort = Proxy.getDefaultPort();
        }
        return this.mProxyPort;
    }

    private static int iV() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || m.aU(networkOperator)) {
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

    public static int R(int i) {
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

    public static synchronized k iW() {
        k kVar;
        synchronized (k.class) {
            if (yp == null) {
                yp = new k();
            }
            kVar = yp;
        }
        return kVar;
    }

    public static boolean iX() {
        return iW().iQ();
    }

    public static boolean iY() {
        return iW().isWifi();
    }

    public static boolean iZ() {
        return iW().hg();
    }

    public static boolean ja() {
        return 3 == iW().iR();
    }

    public static boolean jb() {
        return 2 == iW().iR();
    }

    public static boolean hi() {
        return 1 == iW().iR();
    }

    public static int jc() {
        if (iY()) {
            return 1;
        }
        if (hi()) {
            return 2;
        }
        if (jb()) {
            return 3;
        }
        return (ja() || iX()) ? 4 : 0;
    }

    public static String jd() {
        switch (jc()) {
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

    public static String je() {
        String jd = jd();
        if (jd != null) {
            return jd.toUpperCase();
        }
        return jd;
    }

    public static int jf() {
        return iW().iS();
    }

    public static String jg() {
        return iW().iT();
    }

    public static int jh() {
        return iW().iU();
    }

    public static boolean ji() {
        return yo;
    }
}
