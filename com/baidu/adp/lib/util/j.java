package com.baidu.adp.lib.util;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class j {
    private static Pattern ke = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static j mZ;
    private NetworkInfo mQ = null;
    private boolean mR = true;
    private boolean mS = false;
    private boolean mT = true;
    private int mU = 0;
    private int mV = 0;
    private int mW = -1;
    private String mX = null;
    private int mY = -1;

    static {
        try {
            k kVar = new k(null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            BdBaseApplication.getInst().getApp().registerReceiver(kVar, intentFilter);
            fg().eX();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        mZ = null;
    }

    public void eX() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.mQ = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.mR = true;
                this.mS = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.mR = false;
                this.mS = true;
            } else {
                this.mR = false;
                this.mS = false;
            }
            this.mT = true;
            this.mU = activeNetworkInfo.getSubtype();
            if (this.mS) {
                this.mV = F(this.mU);
            } else {
                this.mV = 0;
            }
        } else {
            this.mR = false;
            this.mS = false;
            this.mT = false;
            this.mU = 0;
            this.mU = 0;
        }
        this.mW = ff();
        this.mX = Proxy.getDefaultHost();
        this.mY = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) com.baidu.adp.lib.network.willdelete.e.dY().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean eY() {
        if (this.mQ == null) {
            eX();
        }
        return this.mT;
    }

    public boolean eZ() {
        if (this.mQ == null) {
            eX();
        }
        return this.mR;
    }

    public boolean dZ() {
        if (this.mQ == null) {
            eX();
        }
        return this.mS;
    }

    public int fa() {
        if (this.mQ == null) {
            eX();
        }
        return this.mV;
    }

    public int fb() {
        if (this.mW == -1) {
            try {
                this.mW = ff();
            } catch (Exception e) {
                this.mW = 0;
            }
        }
        return this.mW;
    }

    public static boolean ay(String str) {
        if (ke.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public String fc() {
        if (this.mX == null) {
            this.mX = Proxy.getDefaultHost();
        }
        return this.mX;
    }

    public int fd() {
        if (-1 == this.mY) {
            this.mY = Proxy.getDefaultPort();
        }
        return this.mY;
    }

    public static boolean fe() {
        return (fg().mR || ff() == 1 || l.aB(Proxy.getDefaultHost())) ? false : true;
    }

    private static int ff() {
        int i;
        String networkOperator = ((TelephonyManager) com.baidu.adp.lib.network.willdelete.e.dY().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || l.aB(networkOperator)) {
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

    public static int F(int i) {
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
            case DealIntentService.CLASS_TYPE_GROUP_EVENT /* 14 */:
            case 15:
                return 2;
            case 13:
                return 3;
            default:
                return 4;
        }
    }

    public static synchronized j fg() {
        j jVar;
        synchronized (j.class) {
            if (mZ == null) {
                mZ = new j();
            }
            jVar = mZ;
        }
        return jVar;
    }

    public static boolean fh() {
        return fg().eY();
    }

    public static boolean fi() {
        return fg().eZ();
    }

    public static boolean fj() {
        return fg().dZ();
    }

    public static boolean fk() {
        return 3 == fg().fa();
    }

    public static boolean fl() {
        return 2 == fg().fa();
    }

    public static boolean eb() {
        return 1 == fg().fa();
    }

    public static int fm() {
        if (fi()) {
            return 1;
        }
        if (eb()) {
            return 2;
        }
        if (fl()) {
            return 3;
        }
        return (fk() || fh()) ? 4 : 0;
    }

    public static String fn() {
        switch (fm()) {
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

    public static String fo() {
        String fn = fn();
        if (fn != null) {
            return fn.toUpperCase();
        }
        return fn;
    }

    public static int fp() {
        return fg().fb();
    }

    public static String fq() {
        return fg().fc();
    }

    public static int fr() {
        return fg().fd();
    }
}
