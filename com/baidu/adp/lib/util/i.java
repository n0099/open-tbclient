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
    private static boolean yk = true;
    private static i yn;
    private long yl;
    private NetworkInfo yc = null;
    private boolean isWifi = true;
    private boolean yd = false;
    private boolean ye = true;
    private int yf = 0;
    private int yg = 0;
    private int yh = -1;
    private String yi = null;
    private int yj = -1;
    private boolean ym = true;

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
        yn = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iz() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.yc = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.yd = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.yd = true;
            } else {
                this.isWifi = false;
                this.yd = false;
            }
            this.ye = true;
            this.yf = activeNetworkInfo.getSubtype();
            if (this.yd) {
                this.yg = ae(this.yf);
            } else {
                this.yg = 0;
            }
        } else {
            this.isWifi = false;
            this.yd = false;
            this.ye = false;
            this.yf = 0;
            this.yf = 0;
        }
        this.yh = iH();
        this.yi = Proxy.getDefaultHost();
        this.yj = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean iA() {
        if (this.yc == null) {
            iz();
        }
        return this.ye;
    }

    public boolean iB() {
        if (this.yc == null) {
            iz();
        }
        return this.isWifi;
    }

    public boolean iC() {
        if (this.yc == null) {
            iz();
        }
        return this.yd;
    }

    public int iD() {
        if (this.yc == null) {
            iz();
        }
        return this.yg;
    }

    public int iE() {
        if (this.yh == -1) {
            try {
                this.yh = iH();
            } catch (Exception e) {
                this.yh = 0;
            }
        }
        return this.yh;
    }

    public String iF() {
        if (this.yi == null) {
            this.yi = Proxy.getDefaultHost();
        }
        return this.yi;
    }

    private long iG() {
        return this.yl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(long j) {
        this.yl = j;
    }

    private static int iH() {
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

    public int iI() {
        if (-1 == this.yj) {
            this.yj = Proxy.getDefaultPort();
        }
        return this.yj;
    }

    public boolean iJ() {
        return this.ym;
    }

    public void F(boolean z) {
        this.ym = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i iK() {
        i iVar;
        synchronized (i.class) {
            if (yn == null) {
                yn = new i();
            }
            iVar = yn;
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
                int iR = i.iR();
                long iY = i.iY();
                i.iK().iz();
                if (i.iK().iJ()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = iR;
                    networkState.mCurNetState = i.iR();
                    networkState.mlastChangedTime = iY;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.iK().i(currentTimeMillis);
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
        iK().F(z);
        iK().iz();
    }

    public static boolean iL() {
        return iK().iA();
    }

    public static boolean iM() {
        return iK().iB();
    }

    public static boolean iN() {
        return iK().iC();
    }

    public static boolean iO() {
        return 3 == iK().iD();
    }

    public static boolean iP() {
        return 2 == iK().iD();
    }

    public static boolean iQ() {
        return 1 == iK().iD();
    }

    public static int iR() {
        if (iM()) {
            return 1;
        }
        if (iQ()) {
            return 2;
        }
        if (iP()) {
            return 3;
        }
        return (iO() || iL()) ? 4 : 0;
    }

    public static String iS() {
        switch (iR()) {
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

    public static String iT() {
        String iS = iS();
        if (iS != null) {
            return iS.toUpperCase();
        }
        return iS;
    }

    public static int iU() {
        return iK().iE();
    }

    public static String iV() {
        return iK().iF();
    }

    public static int iW() {
        return iK().iI();
    }

    public static boolean iX() {
        return yk;
    }

    public static boolean aO(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = iK().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long iY() {
        return iK().iG();
    }
}
