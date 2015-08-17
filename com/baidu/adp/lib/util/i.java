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
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class i {
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean ym = true;
    private static i yp;
    private long yn;
    private NetworkInfo ye = null;
    private boolean isWifi = true;
    private boolean yf = false;
    private boolean yg = true;
    private int yh = 0;
    private int yi = 0;
    private int yj = -1;
    private String yk = null;
    private int yl = -1;
    private boolean yo = true;

    static {
        try {
            a aVar = new a(null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            BdBaseApplication.getInst().getApp().registerReceiver(aVar, intentFilter);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        yp = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iC() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.ye = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.yf = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.yf = true;
            } else {
                this.isWifi = false;
                this.yf = false;
            }
            this.yg = true;
            this.yh = activeNetworkInfo.getSubtype();
            if (this.yf) {
                this.yi = ae(this.yh);
            } else {
                this.yi = 0;
            }
        } else {
            this.isWifi = false;
            this.yf = false;
            this.yg = false;
            this.yh = 0;
            this.yh = 0;
        }
        this.yj = iK();
        this.yk = Proxy.getDefaultHost();
        this.yl = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean iD() {
        if (this.ye == null) {
            iC();
        }
        return this.yg;
    }

    public boolean iE() {
        if (this.ye == null) {
            iC();
        }
        return this.isWifi;
    }

    public boolean iF() {
        if (this.ye == null) {
            iC();
        }
        return this.yf;
    }

    public int iG() {
        if (this.ye == null) {
            iC();
        }
        return this.yi;
    }

    public int iH() {
        if (this.yj == -1) {
            try {
                this.yj = iK();
            } catch (Exception e) {
                this.yj = 0;
            }
        }
        return this.yj;
    }

    public String iI() {
        if (this.yk == null) {
            this.yk = Proxy.getDefaultHost();
        }
        return this.yk;
    }

    private long iJ() {
        return this.yn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(long j) {
        this.yn = j;
    }

    private static int iK() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || j.aQ(networkOperator)) {
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

    public static int ae(int i) {
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

    public int iL() {
        if (-1 == this.yl) {
            this.yl = Proxy.getDefaultPort();
        }
        return this.yl;
    }

    public boolean iM() {
        return this.yo;
    }

    public void F(boolean z) {
        this.yo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i iN() {
        i iVar;
        synchronized (i.class) {
            if (yp == null) {
                yp = new i();
            }
            iVar = yp;
        }
        return iVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                int iU = i.iU();
                long jb = i.jb();
                i.iN().iC();
                if (i.iN().iM()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = iU;
                    networkState.mCurNetState = i.iU();
                    networkState.mlastChangedTime = jb;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.iN().i(currentTimeMillis);
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
        iN().F(z);
        iN().iC();
    }

    public static boolean iO() {
        return iN().iD();
    }

    public static boolean iP() {
        return iN().iE();
    }

    public static boolean iQ() {
        return iN().iF();
    }

    public static boolean iR() {
        return 3 == iN().iG();
    }

    public static boolean iS() {
        return 2 == iN().iG();
    }

    public static boolean iT() {
        return 1 == iN().iG();
    }

    public static int iU() {
        if (iP()) {
            return 1;
        }
        if (iT()) {
            return 2;
        }
        if (iS()) {
            return 3;
        }
        return (iR() || iO()) ? 4 : 0;
    }

    public static String iV() {
        switch (iU()) {
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

    public static String iW() {
        String iV = iV();
        if (iV != null) {
            return iV.toUpperCase();
        }
        return iV;
    }

    public static int iX() {
        return iN().iH();
    }

    public static String iY() {
        return iN().iI();
    }

    public static int iZ() {
        return iN().iL();
    }

    public static boolean ja() {
        return ym;
    }

    public static boolean aO(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = iN().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long jb() {
        return iN().iJ();
    }
}
