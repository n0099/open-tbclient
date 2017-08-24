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
    private static i Ar;
    private long Ap;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean Ao = true;
    private NetworkInfo Ag = null;
    private boolean isWifi = true;
    private boolean Ah = false;
    private boolean Ai = true;
    private int Aj = 0;
    private int Ak = 0;
    private int Al = -1;
    private String Am = null;
    private int An = -1;
    private boolean Aq = true;

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
        Ar = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.Ag = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.Ah = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.Ah = true;
            } else {
                this.isWifi = false;
                this.Ah = false;
            }
            this.Ai = true;
            this.Aj = activeNetworkInfo.getSubtype();
            if (this.Ah) {
                this.Ak = aw(this.Aj);
            } else {
                this.Ak = 0;
            }
        } else {
            this.isWifi = false;
            this.Ah = false;
            this.Ai = false;
            this.Aj = 0;
            this.Aj = 0;
        }
        this.Al = hn();
        this.Am = Proxy.getDefaultHost();
        this.An = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean hf() {
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

    public boolean hg() {
        if (this.Ag == null) {
            he();
        }
        return this.Ai;
    }

    public boolean hh() {
        if (this.Ag == null) {
            he();
        }
        return this.isWifi;
    }

    public boolean hi() {
        if (this.Ag == null) {
            he();
        }
        return this.Ah;
    }

    public int hj() {
        if (this.Ag == null) {
            he();
        }
        return this.Ak;
    }

    public int hk() {
        if (this.Al == -1) {
            try {
                this.Al = hn();
            } catch (Exception e) {
                this.Al = 0;
            }
        }
        return this.Al;
    }

    public String hl() {
        if (this.Am == null) {
            this.Am = Proxy.getDefaultHost();
        }
        return this.Am;
    }

    private long hm() {
        return this.Ap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j) {
        this.Ap = j;
    }

    private static int hn() {
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

    public static int aw(int i) {
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

    public int ho() {
        if (-1 == this.An) {
            this.An = Proxy.getDefaultPort();
        }
        return this.An;
    }

    public boolean hp() {
        return this.Aq;
    }

    public void J(boolean z) {
        this.Aq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i hq() {
        i iVar;
        synchronized (i.class) {
            if (Ar == null) {
                Ar = new i();
            }
            iVar = Ar;
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
                int hx = i.hx();
                long hE = i.hE();
                i.hq().he();
                if (i.hq().hp()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = hx;
                    networkState.mCurNetState = i.hx();
                    networkState.mlastChangedTime = hE;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.hq().j(currentTimeMillis);
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
        hq().J(z);
        hq().he();
    }

    public static boolean hr() {
        return hq().hg();
    }

    public static boolean hs() {
        return hq().hh();
    }

    public static boolean ht() {
        return hq().hi();
    }

    public static boolean hu() {
        return 3 == hq().hj();
    }

    public static boolean hv() {
        return 2 == hq().hj();
    }

    public static boolean hw() {
        return 1 == hq().hj();
    }

    public static int hx() {
        if (hs()) {
            return 1;
        }
        if (hw()) {
            return 2;
        }
        if (hv()) {
            return 3;
        }
        return (hu() || hr()) ? 4 : 0;
    }

    public static String hy() {
        switch (hx()) {
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

    public static String hz() {
        String hy = hy();
        if (hy != null) {
            return hy.toUpperCase();
        }
        return hy;
    }

    public static int hA() {
        return hq().hk();
    }

    public static String hB() {
        return hq().hl();
    }

    public static int hC() {
        return hq().ho();
    }

    public static boolean hD() {
        return Ao;
    }

    public static boolean aO(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = hq().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long hE() {
        return hq().hm();
    }
}
