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
    private static boolean pF = true;
    private static i pI;
    private long pG;
    private NetworkInfo px = null;
    private boolean isWifi = true;
    private boolean py = false;
    private boolean pz = true;
    private int pA = 0;
    private int pB = 0;
    private int pC = -1;
    private String pD = null;
    private int pE = -1;
    private boolean pH = true;

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
        pI = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.px = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.py = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.py = true;
            } else {
                this.isWifi = false;
                this.py = false;
            }
            this.pz = true;
            this.pA = activeNetworkInfo.getSubtype();
            if (this.py) {
                this.pB = ag(this.pA);
            } else {
                this.pB = 0;
            }
        } else {
            this.isWifi = false;
            this.py = false;
            this.pz = false;
            this.pA = 0;
            this.pA = 0;
        }
        this.pC = fm();
        this.pD = Proxy.getDefaultHost();
        this.pE = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean fe() {
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

    public boolean ff() {
        if (this.px == null) {
            fd();
        }
        return this.pz;
    }

    public boolean fg() {
        if (this.px == null) {
            fd();
        }
        return this.isWifi;
    }

    public boolean fh() {
        if (this.px == null) {
            fd();
        }
        return this.py;
    }

    public int fi() {
        if (this.px == null) {
            fd();
        }
        return this.pB;
    }

    public int fj() {
        if (this.pC == -1) {
            try {
                this.pC = fm();
            } catch (Exception e) {
                this.pC = 0;
            }
        }
        return this.pC;
    }

    public String fk() {
        if (this.pD == null) {
            this.pD = Proxy.getDefaultHost();
        }
        return this.pD;
    }

    private long fl() {
        return this.pG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j) {
        this.pG = j;
    }

    private static int fm() {
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

    public static int ag(int i) {
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

    public int fn() {
        if (-1 == this.pE) {
            this.pE = Proxy.getDefaultPort();
        }
        return this.pE;
    }

    public boolean fo() {
        return this.pH;
    }

    public void G(boolean z) {
        this.pH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i fp() {
        i iVar;
        synchronized (i.class) {
            if (pI == null) {
                pI = new i();
            }
            iVar = pI;
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
                int fw = i.fw();
                long fD = i.fD();
                i.fp().fd();
                if (i.fp().fo()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = fw;
                    networkState.mCurNetState = i.fw();
                    networkState.mlastChangedTime = fD;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.fp().j(currentTimeMillis);
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
        fp().G(z);
        fp().fd();
    }

    public static boolean fq() {
        return fp().ff();
    }

    public static boolean fr() {
        return fp().fg();
    }

    public static boolean fs() {
        return fp().fh();
    }

    public static boolean ft() {
        return 3 == fp().fi();
    }

    public static boolean fu() {
        return 2 == fp().fi();
    }

    public static boolean fv() {
        return 1 == fp().fi();
    }

    public static int fw() {
        if (fr()) {
            return 1;
        }
        if (fv()) {
            return 2;
        }
        if (fu()) {
            return 3;
        }
        return (ft() || fq()) ? 4 : 0;
    }

    public static String fx() {
        switch (fw()) {
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

    public static String fy() {
        String fx = fx();
        if (fx != null) {
            return fx.toUpperCase();
        }
        return fx;
    }

    public static int fz() {
        return fp().fj();
    }

    public static String fA() {
        return fp().fk();
    }

    public static int fB() {
        return fp().fn();
    }

    public static boolean fC() {
        return pF;
    }

    public static boolean aL(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = fp().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long fD() {
        return fp().fl();
    }
}
