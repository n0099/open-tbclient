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
    private static boolean yL = true;
    private static i yO;
    private long yM;
    private NetworkInfo yD = null;
    private boolean isWifi = true;
    private boolean yE = false;
    private boolean yF = true;
    private int yG = 0;
    private int yH = 0;
    private int yI = -1;
    private String yJ = null;
    private int yK = -1;
    private boolean yN = true;

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
        yO = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gW() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.yD = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.yE = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.yE = true;
            } else {
                this.isWifi = false;
                this.yE = false;
            }
            this.yF = true;
            this.yG = activeNetworkInfo.getSubtype();
            if (this.yE) {
                this.yH = at(this.yG);
            } else {
                this.yH = 0;
            }
        } else {
            this.isWifi = false;
            this.yE = false;
            this.yF = false;
            this.yG = 0;
            this.yG = 0;
        }
        this.yI = hf();
        this.yJ = Proxy.getDefaultHost();
        this.yK = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean gX() {
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

    public boolean gY() {
        if (this.yD == null) {
            gW();
        }
        return this.yF;
    }

    public boolean gZ() {
        if (this.yD == null) {
            gW();
        }
        return this.isWifi;
    }

    public boolean ha() {
        if (this.yD == null) {
            gW();
        }
        return this.yE;
    }

    public int hb() {
        if (this.yD == null) {
            gW();
        }
        return this.yH;
    }

    public int hc() {
        if (this.yI == -1) {
            try {
                this.yI = hf();
            } catch (Exception e) {
                this.yI = 0;
            }
        }
        return this.yI;
    }

    public String hd() {
        if (this.yJ == null) {
            this.yJ = Proxy.getDefaultHost();
        }
        return this.yJ;
    }

    private long he() {
        return this.yM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j) {
        this.yM = j;
    }

    private static int hf() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || j.aH(networkOperator)) {
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

    public int hg() {
        if (-1 == this.yK) {
            this.yK = Proxy.getDefaultPort();
        }
        return this.yK;
    }

    public boolean hh() {
        return this.yN;
    }

    public void J(boolean z) {
        this.yN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i hi() {
        i iVar;
        synchronized (i.class) {
            if (yO == null) {
                yO = new i();
            }
            iVar = yO;
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
                int hp = i.hp();
                long hw = i.hw();
                i.hi().gW();
                if (i.hi().hh()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = hp;
                    networkState.mCurNetState = i.hp();
                    networkState.mlastChangedTime = hw;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.hi().j(currentTimeMillis);
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
        hi().J(z);
        hi().gW();
    }

    public static boolean hj() {
        return hi().gY();
    }

    public static boolean hk() {
        return hi().gZ();
    }

    public static boolean hl() {
        return hi().ha();
    }

    public static boolean hm() {
        return 3 == hi().hb();
    }

    public static boolean hn() {
        return 2 == hi().hb();
    }

    public static boolean ho() {
        return 1 == hi().hb();
    }

    public static int hp() {
        if (hk()) {
            return 1;
        }
        if (ho()) {
            return 2;
        }
        if (hn()) {
            return 3;
        }
        return (hm() || hj()) ? 4 : 0;
    }

    public static String hq() {
        switch (hp()) {
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

    public static String hr() {
        String hq = hq();
        if (hq != null) {
            return hq.toUpperCase();
        }
        return hq;
    }

    public static int hs() {
        return hi().hc();
    }

    public static String ht() {
        return hi().hd();
    }

    public static int hu() {
        return hi().hg();
    }

    public static boolean hv() {
        return yL;
    }

    public static boolean aF(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = hi().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long hw() {
        return hi().he();
    }
}
