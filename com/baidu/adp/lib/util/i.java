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
    private static boolean oY = true;
    private static i pd;
    private long oZ;
    private NetworkInfo oQ = null;
    private boolean isWifi = true;
    private boolean oR = false;
    private boolean oS = true;
    private int oT = 0;
    private int oU = 0;
    private int oV = -1;
    private String oW = null;
    private int oX = -1;
    private boolean pa = true;

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
        pd = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.oQ = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.oR = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.oR = true;
            } else {
                this.isWifi = false;
                this.oR = false;
            }
            this.oS = true;
            this.oT = activeNetworkInfo.getSubtype();
            if (this.oR) {
                this.oU = ad(this.oT);
            } else {
                this.oU = 0;
            }
        } else {
            this.isWifi = false;
            this.oR = false;
            this.oS = false;
            this.oT = 0;
            this.oT = 0;
        }
        this.oV = fm();
        this.oW = Proxy.getDefaultHost();
        this.oX = Proxy.getDefaultPort();
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
        if (this.oQ == null) {
            fd();
        }
        return this.oS;
    }

    public boolean fg() {
        if (this.oQ == null) {
            fd();
        }
        return this.isWifi;
    }

    public boolean fh() {
        if (this.oQ == null) {
            fd();
        }
        return this.oR;
    }

    public int fi() {
        if (this.oQ == null) {
            fd();
        }
        return this.oU;
    }

    public int fj() {
        if (this.oV == -1) {
            try {
                this.oV = fm();
            } catch (Exception e) {
                this.oV = 0;
            }
        }
        return this.oV;
    }

    public String fk() {
        if (this.oW == null) {
            this.oW = Proxy.getDefaultHost();
        }
        return this.oW;
    }

    private long fl() {
        return this.oZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(long j) {
        this.oZ = j;
    }

    private static int fm() {
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

    public static int ad(int i) {
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
        if (-1 == this.oX) {
            this.oX = Proxy.getDefaultPort();
        }
        return this.oX;
    }

    public boolean fo() {
        return this.pa;
    }

    public void E(boolean z) {
        this.pa = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i fp() {
        i iVar;
        synchronized (i.class) {
            if (pd == null) {
                pd = new i();
            }
            iVar = pd;
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
                    i.fp().i(currentTimeMillis);
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
        fp().E(z);
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
        return oY;
    }

    public static boolean aK(String str) {
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
