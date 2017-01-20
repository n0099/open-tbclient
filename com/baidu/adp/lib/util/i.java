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
    private static boolean rL = true;
    private static i rO;
    private long rM;
    private NetworkInfo rD = null;
    private boolean isWifi = true;
    private boolean rE = false;
    private boolean rF = true;
    private int rG = 0;
    private int rH = 0;
    private int rI = -1;
    private String rJ = null;
    private int rK = -1;
    private boolean rN = true;

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
        rO = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.rD = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.rE = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.rE = true;
            } else {
                this.isWifi = false;
                this.rE = false;
            }
            this.rF = true;
            this.rG = activeNetworkInfo.getSubtype();
            if (this.rE) {
                this.rH = au(this.rG);
            } else {
                this.rH = 0;
            }
        } else {
            this.isWifi = false;
            this.rE = false;
            this.rF = false;
            this.rG = 0;
            this.rG = 0;
        }
        this.rI = gg();
        this.rJ = Proxy.getDefaultHost();
        this.rK = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean fX() {
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

    public boolean fY() {
        if (this.rD == null) {
            fW();
        }
        return this.rF;
    }

    public boolean fZ() {
        if (this.rD == null) {
            fW();
        }
        return this.isWifi;
    }

    public boolean ga() {
        if (this.rD == null) {
            fW();
        }
        return this.rE;
    }

    public int gb() {
        if (this.rD == null) {
            fW();
        }
        return this.rH;
    }

    public int gd() {
        if (this.rI == -1) {
            try {
                this.rI = gg();
            } catch (Exception e) {
                this.rI = 0;
            }
        }
        return this.rI;
    }

    public String ge() {
        if (this.rJ == null) {
            this.rJ = Proxy.getDefaultHost();
        }
        return this.rJ;
    }

    private long gf() {
        return this.rM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j) {
        this.rM = j;
    }

    private static int gg() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || j.aN(networkOperator)) {
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

    public int gh() {
        if (-1 == this.rK) {
            this.rK = Proxy.getDefaultPort();
        }
        return this.rK;
    }

    public boolean gi() {
        return this.rN;
    }

    public void I(boolean z) {
        this.rN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i gj() {
        i iVar;
        synchronized (i.class) {
            if (rO == null) {
                rO = new i();
            }
            iVar = rO;
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
                int gq = i.gq();
                long gx = i.gx();
                i.gj().fW();
                if (i.gj().gi()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = gq;
                    networkState.mCurNetState = i.gq();
                    networkState.mlastChangedTime = gx;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.gj().j(currentTimeMillis);
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
        gj().I(z);
        gj().fW();
    }

    public static boolean gk() {
        return gj().fY();
    }

    public static boolean gl() {
        return gj().fZ();
    }

    public static boolean gm() {
        return gj().ga();
    }

    public static boolean gn() {
        return 3 == gj().gb();
    }

    public static boolean go() {
        return 2 == gj().gb();
    }

    public static boolean gp() {
        return 1 == gj().gb();
    }

    public static int gq() {
        if (gl()) {
            return 1;
        }
        if (gp()) {
            return 2;
        }
        if (go()) {
            return 3;
        }
        return (gn() || gk()) ? 4 : 0;
    }

    public static String gr() {
        switch (gq()) {
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

    public static String gs() {
        String gr = gr();
        if (gr != null) {
            return gr.toUpperCase();
        }
        return gr;
    }

    public static int gt() {
        return gj().gd();
    }

    public static String gu() {
        return gj().ge();
    }

    public static int gv() {
        return gj().gh();
    }

    public static boolean gw() {
        return rL;
    }

    public static boolean aL(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = gj().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long gx() {
        return gj().gf();
    }
}
