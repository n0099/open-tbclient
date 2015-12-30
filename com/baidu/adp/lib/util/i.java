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
    private static boolean yt = true;
    private static i yw;
    private long yu;
    private NetworkInfo yl = null;
    private boolean isWifi = true;
    private boolean ym = false;
    private boolean yn = true;
    private int yo = 0;
    private int yp = 0;
    private int yq = -1;
    private String yr = null;
    private int ys = -1;
    private boolean yv = true;

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
        yw = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iD() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.yl = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.ym = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.ym = true;
            } else {
                this.isWifi = false;
                this.ym = false;
            }
            this.yn = true;
            this.yo = activeNetworkInfo.getSubtype();
            if (this.ym) {
                this.yp = af(this.yo);
            } else {
                this.yp = 0;
            }
        } else {
            this.isWifi = false;
            this.ym = false;
            this.yn = false;
            this.yo = 0;
            this.yo = 0;
        }
        this.yq = iM();
        this.yr = Proxy.getDefaultHost();
        this.ys = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean iE() {
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

    public boolean iF() {
        if (this.yl == null) {
            iD();
        }
        return this.yn;
    }

    public boolean iG() {
        if (this.yl == null) {
            iD();
        }
        return this.isWifi;
    }

    public boolean iH() {
        if (this.yl == null) {
            iD();
        }
        return this.ym;
    }

    public int iI() {
        if (this.yl == null) {
            iD();
        }
        return this.yp;
    }

    public int iJ() {
        if (this.yq == -1) {
            try {
                this.yq = iM();
            } catch (Exception e) {
                this.yq = 0;
            }
        }
        return this.yq;
    }

    public String iK() {
        if (this.yr == null) {
            this.yr = Proxy.getDefaultHost();
        }
        return this.yr;
    }

    private long iL() {
        return this.yu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(long j) {
        this.yu = j;
    }

    private static int iM() {
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

    public int iN() {
        if (-1 == this.ys) {
            this.ys = Proxy.getDefaultPort();
        }
        return this.ys;
    }

    public boolean iO() {
        return this.yv;
    }

    public void F(boolean z) {
        this.yv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i iP() {
        i iVar;
        synchronized (i.class) {
            if (yw == null) {
                yw = new i();
            }
            iVar = yw;
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
                int iW = i.iW();
                long jd = i.jd();
                i.iP().iD();
                if (i.iP().iO()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = iW;
                    networkState.mCurNetState = i.iW();
                    networkState.mlastChangedTime = jd;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.iP().i(currentTimeMillis);
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
        iP().F(z);
        iP().iD();
    }

    public static boolean iQ() {
        return iP().iF();
    }

    public static boolean iR() {
        return iP().iG();
    }

    public static boolean iS() {
        return iP().iH();
    }

    public static boolean iT() {
        return 3 == iP().iI();
    }

    public static boolean iU() {
        return 2 == iP().iI();
    }

    public static boolean iV() {
        return 1 == iP().iI();
    }

    public static int iW() {
        if (iR()) {
            return 1;
        }
        if (iV()) {
            return 2;
        }
        if (iU()) {
            return 3;
        }
        return (iT() || iQ()) ? 4 : 0;
    }

    public static String iX() {
        switch (iW()) {
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

    public static String iY() {
        String iX = iX();
        if (iX != null) {
            return iX.toUpperCase();
        }
        return iX;
    }

    public static int iZ() {
        return iP().iJ();
    }

    public static String ja() {
        return iP().iK();
    }

    public static int jb() {
        return iP().iN();
    }

    public static boolean jc() {
        return yt;
    }

    public static boolean aQ(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = iP().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long jd() {
        return iP().iL();
    }
}
