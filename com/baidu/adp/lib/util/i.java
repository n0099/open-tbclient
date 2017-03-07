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
    private static boolean zg = true;
    private static i zj;
    private long zh;
    private NetworkInfo yY = null;
    private boolean isWifi = true;
    private boolean yZ = false;
    private boolean za = true;
    private int zb = 0;
    private int zc = 0;
    private int zd = -1;
    private String ze = null;
    private int zf = -1;
    private boolean zi = true;

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
        zj = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.yY = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.yZ = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.yZ = true;
            } else {
                this.isWifi = false;
                this.yZ = false;
            }
            this.za = true;
            this.zb = activeNetworkInfo.getSubtype();
            if (this.yZ) {
                this.zc = au(this.zb);
            } else {
                this.zc = 0;
            }
        } else {
            this.isWifi = false;
            this.yZ = false;
            this.za = false;
            this.zb = 0;
            this.zb = 0;
        }
        this.zd = ha();
        this.ze = Proxy.getDefaultHost();
        this.zf = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean gS() {
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

    public boolean gT() {
        if (this.yY == null) {
            gR();
        }
        return this.za;
    }

    public boolean gU() {
        if (this.yY == null) {
            gR();
        }
        return this.isWifi;
    }

    public boolean gV() {
        if (this.yY == null) {
            gR();
        }
        return this.yZ;
    }

    public int gW() {
        if (this.yY == null) {
            gR();
        }
        return this.zc;
    }

    public int gX() {
        if (this.zd == -1) {
            try {
                this.zd = ha();
            } catch (Exception e) {
                this.zd = 0;
            }
        }
        return this.zd;
    }

    public String gY() {
        if (this.ze == null) {
            this.ze = Proxy.getDefaultHost();
        }
        return this.ze;
    }

    private long gZ() {
        return this.zh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j) {
        this.zh = j;
    }

    private static int ha() {
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

    public static int au(int i) {
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

    public int hb() {
        if (-1 == this.zf) {
            this.zf = Proxy.getDefaultPort();
        }
        return this.zf;
    }

    public boolean hc() {
        return this.zi;
    }

    public void J(boolean z) {
        this.zi = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i hd() {
        i iVar;
        synchronized (i.class) {
            if (zj == null) {
                zj = new i();
            }
            iVar = zj;
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
                int hk = i.hk();
                long hr = i.hr();
                i.hd().gR();
                if (i.hd().hc()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = hk;
                    networkState.mCurNetState = i.hk();
                    networkState.mlastChangedTime = hr;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.hd().j(currentTimeMillis);
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
        hd().J(z);
        hd().gR();
    }

    public static boolean he() {
        return hd().gT();
    }

    public static boolean hf() {
        return hd().gU();
    }

    public static boolean hg() {
        return hd().gV();
    }

    public static boolean hh() {
        return 3 == hd().gW();
    }

    public static boolean hi() {
        return 2 == hd().gW();
    }

    public static boolean hj() {
        return 1 == hd().gW();
    }

    public static int hk() {
        if (hf()) {
            return 1;
        }
        if (hj()) {
            return 2;
        }
        if (hi()) {
            return 3;
        }
        return (hh() || he()) ? 4 : 0;
    }

    public static String hl() {
        switch (hk()) {
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

    public static String hm() {
        String hl = hl();
        if (hl != null) {
            return hl.toUpperCase();
        }
        return hl;
    }

    public static int hn() {
        return hd().gX();
    }

    public static String ho() {
        return hd().gY();
    }

    public static int hp() {
        return hd().hb();
    }

    public static boolean hq() {
        return zg;
    }

    public static boolean aF(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = hd().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long hr() {
        return hd().gZ();
    }
}
