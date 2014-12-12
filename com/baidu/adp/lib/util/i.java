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
    private static Pattern kg = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static i mW;
    private NetworkInfo mO = null;
    private boolean mP = true;
    private boolean mQ = false;
    private boolean mS = true;
    private int mT = 0;
    private int mU = 0;
    private int mV = -1;
    private String mProxyHost = null;
    private int mProxyPort = -1;

    static {
        try {
            j jVar = new j(null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            BdBaseApplication.getInst().getApp().registerReceiver(jVar, intentFilter);
            ff().eX();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        mW = null;
    }

    public void eX() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.mO = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.mP = true;
                this.mQ = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.mP = false;
                this.mQ = true;
            } else {
                this.mP = false;
                this.mQ = false;
            }
            this.mS = true;
            this.mT = activeNetworkInfo.getSubtype();
            if (this.mQ) {
                this.mU = N(this.mT);
            } else {
                this.mU = 0;
            }
        } else {
            this.mP = false;
            this.mQ = false;
            this.mS = false;
            this.mT = 0;
            this.mT = 0;
        }
        this.mV = fe();
        this.mProxyHost = Proxy.getDefaultHost();
        this.mProxyPort = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) com.baidu.adp.lib.network.willdelete.e.dX().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean eY() {
        if (this.mO == null) {
            eX();
        }
        return this.mS;
    }

    public boolean isWifi() {
        if (this.mO == null) {
            eX();
        }
        return this.mP;
    }

    public boolean dY() {
        if (this.mO == null) {
            eX();
        }
        return this.mQ;
    }

    public int eZ() {
        if (this.mO == null) {
            eX();
        }
        return this.mU;
    }

    public int fa() {
        if (this.mV == -1) {
            try {
                this.mV = fe();
            } catch (Exception e) {
                this.mV = 0;
            }
        }
        return this.mV;
    }

    public static boolean aB(String str) {
        if (kg.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public String fb() {
        if (this.mProxyHost == null) {
            this.mProxyHost = Proxy.getDefaultHost();
        }
        return this.mProxyHost;
    }

    public int fc() {
        if (-1 == this.mProxyPort) {
            this.mProxyPort = Proxy.getDefaultPort();
        }
        return this.mProxyPort;
    }

    public static boolean fd() {
        return (ff().mP || fe() == 1 || k.aD(Proxy.getDefaultHost())) ? false : true;
    }

    private static int fe() {
        int i;
        String networkOperator = ((TelephonyManager) com.baidu.adp.lib.network.willdelete.e.dX().getContext().getSystemService("phone")).getNetworkOperator();
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

    public static int N(int i) {
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

    public static synchronized i ff() {
        i iVar;
        synchronized (i.class) {
            if (mW == null) {
                mW = new i();
            }
            iVar = mW;
        }
        return iVar;
    }

    public static boolean fg() {
        return ff().eY();
    }

    public static boolean fh() {
        return ff().isWifi();
    }

    public static boolean fi() {
        return ff().dY();
    }

    public static boolean fj() {
        return 3 == ff().eZ();
    }

    public static boolean fk() {
        return 2 == ff().eZ();
    }

    public static boolean ea() {
        return 1 == ff().eZ();
    }

    public static int fl() {
        if (fh()) {
            return 1;
        }
        if (ea()) {
            return 2;
        }
        if (fk()) {
            return 3;
        }
        return (fj() || fg()) ? 4 : 0;
    }

    public static String fm() {
        switch (fl()) {
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

    public static String fn() {
        String fm = fm();
        if (fm != null) {
            return fm.toUpperCase();
        }
        return fm;
    }

    public static int fo() {
        return ff().fa();
    }

    public static String fp() {
        return ff().fb();
    }

    public static int fq() {
        return ff().fc();
    }
}
