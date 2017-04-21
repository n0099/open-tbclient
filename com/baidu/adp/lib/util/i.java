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
    private static boolean yK = true;
    private static i yN;
    private long yL;
    private NetworkInfo yC = null;
    private boolean isWifi = true;
    private boolean yD = false;
    private boolean yE = true;
    private int yF = 0;
    private int yG = 0;
    private int yH = -1;
    private String yI = null;
    private int yJ = -1;
    private boolean yM = true;

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
        yN = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.yC = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.yD = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.yD = true;
            } else {
                this.isWifi = false;
                this.yD = false;
            }
            this.yE = true;
            this.yF = activeNetworkInfo.getSubtype();
            if (this.yD) {
                this.yG = at(this.yF);
            } else {
                this.yG = 0;
            }
        } else {
            this.isWifi = false;
            this.yD = false;
            this.yE = false;
            this.yF = 0;
            this.yF = 0;
        }
        this.yH = hg();
        this.yI = Proxy.getDefaultHost();
        this.yJ = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean gY() {
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

    public boolean gZ() {
        if (this.yC == null) {
            gX();
        }
        return this.yE;
    }

    public boolean ha() {
        if (this.yC == null) {
            gX();
        }
        return this.isWifi;
    }

    public boolean hb() {
        if (this.yC == null) {
            gX();
        }
        return this.yD;
    }

    public int hc() {
        if (this.yC == null) {
            gX();
        }
        return this.yG;
    }

    public int hd() {
        if (this.yH == -1) {
            try {
                this.yH = hg();
            } catch (Exception e) {
                this.yH = 0;
            }
        }
        return this.yH;
    }

    public String he() {
        if (this.yI == null) {
            this.yI = Proxy.getDefaultHost();
        }
        return this.yI;
    }

    private long hf() {
        return this.yL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j) {
        this.yL = j;
    }

    private static int hg() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || j.aC(networkOperator)) {
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

    public int hh() {
        if (-1 == this.yJ) {
            this.yJ = Proxy.getDefaultPort();
        }
        return this.yJ;
    }

    public boolean hi() {
        return this.yM;
    }

    public void J(boolean z) {
        this.yM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i hj() {
        i iVar;
        synchronized (i.class) {
            if (yN == null) {
                yN = new i();
            }
            iVar = yN;
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
                int hq = i.hq();
                long hx = i.hx();
                i.hj().gX();
                if (i.hj().hi()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = hq;
                    networkState.mCurNetState = i.hq();
                    networkState.mlastChangedTime = hx;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.hj().j(currentTimeMillis);
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
        hj().J(z);
        hj().gX();
    }

    public static boolean hk() {
        return hj().gZ();
    }

    public static boolean hl() {
        return hj().ha();
    }

    public static boolean hm() {
        return hj().hb();
    }

    public static boolean hn() {
        return 3 == hj().hc();
    }

    public static boolean ho() {
        return 2 == hj().hc();
    }

    public static boolean hp() {
        return 1 == hj().hc();
    }

    public static int hq() {
        if (hl()) {
            return 1;
        }
        if (hp()) {
            return 2;
        }
        if (ho()) {
            return 3;
        }
        return (hn() || hk()) ? 4 : 0;
    }

    public static String hr() {
        switch (hq()) {
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

    public static String hs() {
        String hr = hr();
        if (hr != null) {
            return hr.toUpperCase();
        }
        return hr;
    }

    public static int ht() {
        return hj().hd();
    }

    public static String hu() {
        return hj().he();
    }

    public static int hv() {
        return hj().hh();
    }

    public static boolean hw() {
        return yK;
    }

    public static boolean aA(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = hj().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long hx() {
        return hj().hf();
    }
}
