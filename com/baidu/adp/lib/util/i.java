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
    private static boolean rT = true;
    private static i rW;
    private long rU;
    private NetworkInfo rL = null;
    private boolean isWifi = true;
    private boolean rM = false;
    private boolean rN = true;
    private int rO = 0;
    private int rP = 0;
    private int rQ = -1;
    private String rR = null;
    private int rS = -1;
    private boolean rV = true;

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
        rW = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fY() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.rL = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.rM = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.rM = true;
            } else {
                this.isWifi = false;
                this.rM = false;
            }
            this.rN = true;
            this.rO = activeNetworkInfo.getSubtype();
            if (this.rM) {
                this.rP = at(this.rO);
            } else {
                this.rP = 0;
            }
        } else {
            this.isWifi = false;
            this.rM = false;
            this.rN = false;
            this.rO = 0;
            this.rO = 0;
        }
        this.rQ = gi();
        this.rR = Proxy.getDefaultHost();
        this.rS = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean fZ() {
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

    public boolean ga() {
        if (this.rL == null) {
            fY();
        }
        return this.rN;
    }

    public boolean gb() {
        if (this.rL == null) {
            fY();
        }
        return this.isWifi;
    }

    public boolean gd() {
        if (this.rL == null) {
            fY();
        }
        return this.rM;
    }

    public int ge() {
        if (this.rL == null) {
            fY();
        }
        return this.rP;
    }

    public int gf() {
        if (this.rQ == -1) {
            try {
                this.rQ = gi();
            } catch (Exception e) {
                this.rQ = 0;
            }
        }
        return this.rQ;
    }

    public String gg() {
        if (this.rR == null) {
            this.rR = Proxy.getDefaultHost();
        }
        return this.rR;
    }

    private long gh() {
        return this.rU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j) {
        this.rU = j;
    }

    private static int gi() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || j.aO(networkOperator)) {
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

    public int gj() {
        if (-1 == this.rS) {
            this.rS = Proxy.getDefaultPort();
        }
        return this.rS;
    }

    public boolean gk() {
        return this.rV;
    }

    public void I(boolean z) {
        this.rV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i gl() {
        i iVar;
        synchronized (i.class) {
            if (rW == null) {
                rW = new i();
            }
            iVar = rW;
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
                int gs = i.gs();
                long gz = i.gz();
                i.gl().fY();
                if (i.gl().gk()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = gs;
                    networkState.mCurNetState = i.gs();
                    networkState.mlastChangedTime = gz;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.gl().j(currentTimeMillis);
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
        gl().I(z);
        gl().fY();
    }

    public static boolean gm() {
        return gl().ga();
    }

    public static boolean gn() {
        return gl().gb();
    }

    public static boolean go() {
        return gl().gd();
    }

    public static boolean gp() {
        return 3 == gl().ge();
    }

    public static boolean gq() {
        return 2 == gl().ge();
    }

    public static boolean gr() {
        return 1 == gl().ge();
    }

    public static int gs() {
        if (gn()) {
            return 1;
        }
        if (gr()) {
            return 2;
        }
        if (gq()) {
            return 3;
        }
        return (gp() || gm()) ? 4 : 0;
    }

    public static String gt() {
        switch (gs()) {
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

    public static String gu() {
        String gt = gt();
        if (gt != null) {
            return gt.toUpperCase();
        }
        return gt;
    }

    public static int gv() {
        return gl().gf();
    }

    public static String gw() {
        return gl().gg();
    }

    public static int gx() {
        return gl().gj();
    }

    public static boolean gy() {
        return rT;
    }

    public static boolean aM(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = gl().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long gz() {
        return gl().gh();
    }
}
