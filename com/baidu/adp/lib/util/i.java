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
    private static boolean yh = true;
    private static i yk;
    private long yi;
    private NetworkInfo xZ = null;
    private boolean isWifi = true;
    private boolean ya = false;
    private boolean yb = true;
    private int yc = 0;
    private int yd = 0;
    private int ye = -1;
    private String yf = null;
    private int yg = -1;
    private boolean yj = true;

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
        yk = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gV() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.xZ = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.ya = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.ya = true;
            } else {
                this.isWifi = false;
                this.ya = false;
            }
            this.yb = true;
            this.yc = activeNetworkInfo.getSubtype();
            if (this.ya) {
                this.yd = at(this.yc);
            } else {
                this.yd = 0;
            }
        } else {
            this.isWifi = false;
            this.ya = false;
            this.yb = false;
            this.yc = 0;
            this.yc = 0;
        }
        this.ye = he();
        this.yf = Proxy.getDefaultHost();
        this.yg = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean gW() {
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

    public boolean gX() {
        if (this.xZ == null) {
            gV();
        }
        return this.yb;
    }

    public boolean gY() {
        if (this.xZ == null) {
            gV();
        }
        return this.isWifi;
    }

    public boolean gZ() {
        if (this.xZ == null) {
            gV();
        }
        return this.ya;
    }

    public int ha() {
        if (this.xZ == null) {
            gV();
        }
        return this.yd;
    }

    public int hb() {
        if (this.ye == -1) {
            try {
                this.ye = he();
            } catch (Exception e) {
                this.ye = 0;
            }
        }
        return this.ye;
    }

    public String hc() {
        if (this.yf == null) {
            this.yf = Proxy.getDefaultHost();
        }
        return this.yf;
    }

    private long hd() {
        return this.yi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j) {
        this.yi = j;
    }

    private static int he() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || j.aM(networkOperator)) {
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

    public static int at(int i) {
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

    public int hf() {
        if (-1 == this.yg) {
            this.yg = Proxy.getDefaultPort();
        }
        return this.yg;
    }

    public boolean hg() {
        return this.yj;
    }

    public void K(boolean z) {
        this.yj = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i hh() {
        i iVar;
        synchronized (i.class) {
            if (yk == null) {
                yk = new i();
            }
            iVar = yk;
        }
        return iVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                int ho = i.ho();
                long hv = i.hv();
                i.hh().gV();
                if (i.hh().hg()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = ho;
                    networkState.mCurNetState = i.ho();
                    networkState.mlastChangedTime = hv;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.hh().j(currentTimeMillis);
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
        hh().K(z);
        hh().gV();
    }

    public static boolean hi() {
        return hh().gX();
    }

    public static boolean hj() {
        return hh().gY();
    }

    public static boolean hk() {
        return hh().gZ();
    }

    public static boolean hl() {
        return 3 == hh().ha();
    }

    public static boolean hm() {
        return 2 == hh().ha();
    }

    public static boolean hn() {
        return 1 == hh().ha();
    }

    public static int ho() {
        if (hj()) {
            return 1;
        }
        if (hn()) {
            return 2;
        }
        if (hm()) {
            return 3;
        }
        return (hl() || hi()) ? 4 : 0;
    }

    public static String hp() {
        switch (ho()) {
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

    public static String hq() {
        String hp = hp();
        if (hp != null) {
            return hp.toUpperCase();
        }
        return hp;
    }

    public static int hr() {
        return hh().hb();
    }

    public static String hs() {
        return hh().hc();
    }

    public static int ht() {
        return hh().hf();
    }

    public static boolean hu() {
        return yh;
    }

    public static boolean aK(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = hh().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long hv() {
        return hh().hd();
    }
}
