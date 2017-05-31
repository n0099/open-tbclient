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
    public void gX() {
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
        this.yI = hg();
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
        if (this.yD == null) {
            gX();
        }
        return this.yF;
    }

    public boolean ha() {
        if (this.yD == null) {
            gX();
        }
        return this.isWifi;
    }

    public boolean hb() {
        if (this.yD == null) {
            gX();
        }
        return this.yE;
    }

    public int hc() {
        if (this.yD == null) {
            gX();
        }
        return this.yH;
    }

    public int hd() {
        if (this.yI == -1) {
            try {
                this.yI = hg();
            } catch (Exception e) {
                this.yI = 0;
            }
        }
        return this.yI;
    }

    public String he() {
        if (this.yJ == null) {
            this.yJ = Proxy.getDefaultHost();
        }
        return this.yJ;
    }

    private long hf() {
        return this.yM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j) {
        this.yM = j;
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
        if (-1 == this.yK) {
            this.yK = Proxy.getDefaultPort();
        }
        return this.yK;
    }

    public boolean hi() {
        return this.yN;
    }

    public void J(boolean z) {
        this.yN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i hj() {
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
        return yL;
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
