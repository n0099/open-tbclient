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
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class j {
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean yi = true;
    private static j yl;
    private long yj;
    private NetworkInfo ya = null;
    private boolean isWifi = true;
    private boolean yb = false;
    private boolean yc = true;
    private int yd = 0;
    private int ye = 0;
    private int yf = -1;
    private String yg = null;
    private int yh = -1;
    private boolean yk = true;

    static {
        try {
            a aVar = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            BdBaseApplication.getInst().getApp().registerReceiver(aVar, intentFilter);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        yl = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gU() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.ya = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.yb = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.yb = true;
            } else {
                this.isWifi = false;
                this.yb = false;
            }
            this.yc = true;
            this.yd = activeNetworkInfo.getSubtype();
            if (this.yb) {
                this.ye = av(this.yd);
            } else {
                this.ye = 0;
            }
        } else {
            this.isWifi = false;
            this.yb = false;
            this.yc = false;
            this.yd = 0;
            this.yd = 0;
        }
        this.yf = hd();
        this.yg = Proxy.getDefaultHost();
        this.yh = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean gV() {
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

    public boolean gW() {
        if (this.ya == null) {
            gU();
        }
        return this.yc;
    }

    public boolean gX() {
        if (this.ya == null) {
            gU();
        }
        return this.isWifi;
    }

    public boolean gY() {
        if (this.ya == null) {
            gU();
        }
        return this.yb;
    }

    public int gZ() {
        if (this.ya == null) {
            gU();
        }
        return this.ye;
    }

    public int ha() {
        if (this.yf == -1) {
            try {
                this.yf = hd();
            } catch (Exception e) {
                this.yf = 0;
            }
        }
        return this.yf;
    }

    public String hb() {
        if (this.yg == null) {
            this.yg = Proxy.getDefaultHost();
        }
        return this.yg;
    }

    private long hc() {
        return this.yj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(long j) {
        this.yj = j;
    }

    private static int hd() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || k.aM(networkOperator)) {
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

    public static int av(int i) {
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

    public int he() {
        if (-1 == this.yh) {
            this.yh = Proxy.getDefaultPort();
        }
        return this.yh;
    }

    public boolean hf() {
        return this.yk;
    }

    public void K(boolean z) {
        this.yk = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j hg() {
        j jVar;
        synchronized (j.class) {
            if (yl == null) {
                yl = new j();
            }
            jVar = yl;
        }
        return jVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                int hn = j.hn();
                long hu = j.hu();
                j.hg().gU();
                if (j.hg().hf()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = hn;
                    networkState.mCurNetState = j.hn();
                    networkState.mlastChangedTime = hu;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    j.hg().k(currentTimeMillis);
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
        hg().K(z);
        hg().gU();
    }

    public static boolean hh() {
        return hg().gW();
    }

    public static boolean hi() {
        return hg().gX();
    }

    public static boolean hj() {
        return hg().gY();
    }

    public static boolean hk() {
        return 3 == hg().gZ();
    }

    public static boolean hl() {
        return 2 == hg().gZ();
    }

    public static boolean hm() {
        return 1 == hg().gZ();
    }

    public static int hn() {
        if (hi()) {
            return 1;
        }
        if (hm()) {
            return 2;
        }
        if (hl()) {
            return 3;
        }
        return (hk() || hh()) ? 4 : 0;
    }

    public static String ho() {
        switch (hn()) {
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

    public static String hp() {
        String ho = ho();
        if (ho != null) {
            return ho.toUpperCase();
        }
        return ho;
    }

    public static int hq() {
        return hg().ha();
    }

    public static String hr() {
        return hg().hb();
    }

    public static int hs() {
        return hg().he();
    }

    public static boolean ht() {
        return yi;
    }

    public static boolean aK(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = hg().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long hu() {
        return hg().hc();
    }
}
