package com.baidu.adp.lib.util;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.adp.base.BdBaseApplication;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class i {
    private static Pattern kj = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static i nb;
    private NetworkInfo mS = null;
    private boolean mT = true;
    private boolean mU = false;
    private boolean mV = true;
    private int mW = 0;
    private int mZ = 0;
    private int na = -1;
    private String mProxyHost = null;
    private int mProxyPort = -1;

    static {
        try {
            j jVar = new j(null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            BdBaseApplication.getInst().getApp().registerReceiver(jVar, intentFilter);
            fe().eW();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        nb = null;
    }

    public void eW() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.mS = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.mT = true;
                this.mU = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.mT = false;
                this.mU = true;
            } else {
                this.mT = false;
                this.mU = false;
            }
            this.mV = true;
            this.mW = activeNetworkInfo.getSubtype();
            if (this.mU) {
                this.mZ = S(this.mW);
            } else {
                this.mZ = 0;
            }
        } else {
            this.mT = false;
            this.mU = false;
            this.mV = false;
            this.mW = 0;
            this.mW = 0;
        }
        this.na = fd();
        this.mProxyHost = Proxy.getDefaultHost();
        this.mProxyPort = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) com.baidu.adp.lib.network.willdelete.e.dV().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean eX() {
        if (this.mS == null) {
            eW();
        }
        return this.mV;
    }

    public boolean isWifi() {
        if (this.mS == null) {
            eW();
        }
        return this.mT;
    }

    public boolean dW() {
        if (this.mS == null) {
            eW();
        }
        return this.mU;
    }

    public int eY() {
        if (this.mS == null) {
            eW();
        }
        return this.mZ;
    }

    public int eZ() {
        if (this.na == -1) {
            try {
                this.na = fd();
            } catch (Exception e) {
                this.na = 0;
            }
        }
        return this.na;
    }

    public static boolean aB(String str) {
        if (kj.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public String fa() {
        if (this.mProxyHost == null) {
            this.mProxyHost = Proxy.getDefaultHost();
        }
        return this.mProxyHost;
    }

    public int fb() {
        if (-1 == this.mProxyPort) {
            this.mProxyPort = Proxy.getDefaultPort();
        }
        return this.mProxyPort;
    }

    public static boolean fc() {
        return (fe().mT || fd() == 1 || k.aD(Proxy.getDefaultHost())) ? false : true;
    }

    private static int fd() {
        int i;
        String networkOperator = ((TelephonyManager) com.baidu.adp.lib.network.willdelete.e.dV().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || k.aD(networkOperator)) {
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

    public static int S(int i) {
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

    public static synchronized i fe() {
        i iVar;
        synchronized (i.class) {
            if (nb == null) {
                nb = new i();
            }
            iVar = nb;
        }
        return iVar;
    }

    public static boolean ff() {
        return fe().eX();
    }

    public static boolean fg() {
        return fe().isWifi();
    }

    public static boolean fh() {
        return fe().dW();
    }

    public static boolean fi() {
        return 3 == fe().eY();
    }

    public static boolean fj() {
        return 2 == fe().eY();
    }

    public static boolean dY() {
        return 1 == fe().eY();
    }

    public static int fk() {
        if (fg()) {
            return 1;
        }
        if (dY()) {
            return 2;
        }
        if (fj()) {
            return 3;
        }
        return (fi() || ff()) ? 4 : 0;
    }

    public static String fl() {
        switch (fk()) {
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

    public static String fm() {
        String fl = fl();
        if (fl != null) {
            return fl.toUpperCase();
        }
        return fl;
    }

    public static int fn() {
        return fe().eZ();
    }

    public static String fo() {
        return fe().fa();
    }

    public static int fp() {
        return fe().fb();
    }
}
