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
    private static boolean yl = true;
    private static i yo;
    private long ym;
    private NetworkInfo yd = null;
    private boolean isWifi = true;
    private boolean ye = false;
    private boolean yf = true;
    private int yg = 0;
    private int yh = 0;
    private int yi = -1;
    private String yj = null;
    private int yk = -1;
    private boolean yn = true;

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
        yo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iA() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.yd = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.ye = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.ye = true;
            } else {
                this.isWifi = false;
                this.ye = false;
            }
            this.yf = true;
            this.yg = activeNetworkInfo.getSubtype();
            if (this.ye) {
                this.yh = ae(this.yg);
            } else {
                this.yh = 0;
            }
        } else {
            this.isWifi = false;
            this.ye = false;
            this.yf = false;
            this.yg = 0;
            this.yg = 0;
        }
        this.yi = iI();
        this.yj = Proxy.getDefaultHost();
        this.yk = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean iB() {
        if (this.yd == null) {
            iA();
        }
        return this.yf;
    }

    public boolean iC() {
        if (this.yd == null) {
            iA();
        }
        return this.isWifi;
    }

    public boolean iD() {
        if (this.yd == null) {
            iA();
        }
        return this.ye;
    }

    public int iE() {
        if (this.yd == null) {
            iA();
        }
        return this.yh;
    }

    public int iF() {
        if (this.yi == -1) {
            try {
                this.yi = iI();
            } catch (Exception e) {
                this.yi = 0;
            }
        }
        return this.yi;
    }

    public String iG() {
        if (this.yj == null) {
            this.yj = Proxy.getDefaultHost();
        }
        return this.yj;
    }

    private long iH() {
        return this.ym;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j) {
        this.ym = j;
    }

    private static int iI() {
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

    public int iJ() {
        if (-1 == this.yk) {
            this.yk = Proxy.getDefaultPort();
        }
        return this.yk;
    }

    public boolean iK() {
        return this.yn;
    }

    public void F(boolean z) {
        this.yn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i iL() {
        i iVar;
        synchronized (i.class) {
            if (yo == null) {
                yo = new i();
            }
            iVar = yo;
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
                int iS = i.iS();
                long iZ = i.iZ();
                i.iL().iA();
                if (i.iL().iK()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = iS;
                    networkState.mCurNetState = i.iS();
                    networkState.mlastChangedTime = iZ;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.iL().k(currentTimeMillis);
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
        iL().F(z);
        iL().iA();
    }

    public static boolean iM() {
        return iL().iB();
    }

    public static boolean iN() {
        return iL().iC();
    }

    public static boolean iO() {
        return iL().iD();
    }

    public static boolean iP() {
        return 3 == iL().iE();
    }

    public static boolean iQ() {
        return 2 == iL().iE();
    }

    public static boolean iR() {
        return 1 == iL().iE();
    }

    public static int iS() {
        if (iN()) {
            return 1;
        }
        if (iR()) {
            return 2;
        }
        if (iQ()) {
            return 3;
        }
        return (iP() || iM()) ? 4 : 0;
    }

    public static String iT() {
        switch (iS()) {
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

    public static String iU() {
        String iT = iT();
        if (iT != null) {
            return iT.toUpperCase();
        }
        return iT;
    }

    public static int iV() {
        return iL().iF();
    }

    public static String iW() {
        return iL().iG();
    }

    public static int iX() {
        return iL().iJ();
    }

    public static boolean iY() {
        return yl;
    }

    public static boolean aO(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = iL().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long iZ() {
        return iL().iH();
    }
}
