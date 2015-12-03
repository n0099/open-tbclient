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
    private static boolean yr = true;
    private static i yu;
    private long ys;
    private NetworkInfo yj = null;
    private boolean isWifi = true;
    private boolean yk = false;
    private boolean yl = true;
    private int ym = 0;
    private int yn = 0;
    private int yo = -1;
    private String yp = null;
    private int yq = -1;
    private boolean yt = true;

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
        yu = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iD() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.yj = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.yk = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.yk = true;
            } else {
                this.isWifi = false;
                this.yk = false;
            }
            this.yl = true;
            this.ym = activeNetworkInfo.getSubtype();
            if (this.yk) {
                this.yn = af(this.ym);
            } else {
                this.yn = 0;
            }
        } else {
            this.isWifi = false;
            this.yk = false;
            this.yl = false;
            this.ym = 0;
            this.ym = 0;
        }
        this.yo = iL();
        this.yp = Proxy.getDefaultHost();
        this.yq = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean iE() {
        if (this.yj == null) {
            iD();
        }
        return this.yl;
    }

    public boolean iF() {
        if (this.yj == null) {
            iD();
        }
        return this.isWifi;
    }

    public boolean iG() {
        if (this.yj == null) {
            iD();
        }
        return this.yk;
    }

    public int iH() {
        if (this.yj == null) {
            iD();
        }
        return this.yn;
    }

    public int iI() {
        if (this.yo == -1) {
            try {
                this.yo = iL();
            } catch (Exception e) {
                this.yo = 0;
            }
        }
        return this.yo;
    }

    public String iJ() {
        if (this.yp == null) {
            this.yp = Proxy.getDefaultHost();
        }
        return this.yp;
    }

    private long iK() {
        return this.ys;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(long j) {
        this.ys = j;
    }

    private static int iL() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || j.aS(networkOperator)) {
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

    public static int af(int i) {
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

    public int iM() {
        if (-1 == this.yq) {
            this.yq = Proxy.getDefaultPort();
        }
        return this.yq;
    }

    public boolean iN() {
        return this.yt;
    }

    public void F(boolean z) {
        this.yt = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i iO() {
        i iVar;
        synchronized (i.class) {
            if (yu == null) {
                yu = new i();
            }
            iVar = yu;
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
                int iV = i.iV();
                long jc = i.jc();
                i.iO().iD();
                if (i.iO().iN()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = iV;
                    networkState.mCurNetState = i.iV();
                    networkState.mlastChangedTime = jc;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.iO().i(currentTimeMillis);
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
        iO().F(z);
        iO().iD();
    }

    public static boolean iP() {
        return iO().iE();
    }

    public static boolean iQ() {
        return iO().iF();
    }

    public static boolean iR() {
        return iO().iG();
    }

    public static boolean iS() {
        return 3 == iO().iH();
    }

    public static boolean iT() {
        return 2 == iO().iH();
    }

    public static boolean iU() {
        return 1 == iO().iH();
    }

    public static int iV() {
        if (iQ()) {
            return 1;
        }
        if (iU()) {
            return 2;
        }
        if (iT()) {
            return 3;
        }
        return (iS() || iP()) ? 4 : 0;
    }

    public static String iW() {
        switch (iV()) {
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

    public static String iX() {
        String iW = iW();
        if (iW != null) {
            return iW.toUpperCase();
        }
        return iW;
    }

    public static int iY() {
        return iO().iI();
    }

    public static String iZ() {
        return iO().iJ();
    }

    public static int ja() {
        return iO().iM();
    }

    public static boolean jb() {
        return yr;
    }

    public static boolean aQ(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = iO().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long jc() {
        return iO().iK();
    }
}
