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
    private static boolean yS = true;
    private static i yV;
    private long yT;
    private NetworkInfo yK = null;
    private boolean isWifi = true;
    private boolean yL = false;
    private boolean yM = true;
    private int yN = 0;
    private int yO = 0;
    private int yP = -1;
    private String yQ = null;
    private int yR = -1;
    private boolean yU = true;

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
        yV = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.yK = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.yL = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.yL = true;
            } else {
                this.isWifi = false;
                this.yL = false;
            }
            this.yM = true;
            this.yN = activeNetworkInfo.getSubtype();
            if (this.yL) {
                this.yO = ap(this.yN);
            } else {
                this.yO = 0;
            }
        } else {
            this.isWifi = false;
            this.yL = false;
            this.yM = false;
            this.yN = 0;
            this.yN = 0;
        }
        this.yP = jb();
        this.yQ = Proxy.getDefaultHost();
        this.yR = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean iT() {
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

    public boolean iU() {
        if (this.yK == null) {
            iS();
        }
        return this.yM;
    }

    public boolean iV() {
        if (this.yK == null) {
            iS();
        }
        return this.isWifi;
    }

    public boolean iW() {
        if (this.yK == null) {
            iS();
        }
        return this.yL;
    }

    public int iX() {
        if (this.yK == null) {
            iS();
        }
        return this.yO;
    }

    public int iY() {
        if (this.yP == -1) {
            try {
                this.yP = jb();
            } catch (Exception e) {
                this.yP = 0;
            }
        }
        return this.yP;
    }

    public String iZ() {
        if (this.yQ == null) {
            this.yQ = Proxy.getDefaultHost();
        }
        return this.yQ;
    }

    private long ja() {
        return this.yT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j) {
        this.yT = j;
    }

    private static int jb() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || j.aT(networkOperator)) {
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

    public static int ap(int i) {
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

    public int jc() {
        if (-1 == this.yR) {
            this.yR = Proxy.getDefaultPort();
        }
        return this.yR;
    }

    public boolean jd() {
        return this.yU;
    }

    public void E(boolean z) {
        this.yU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i je() {
        i iVar;
        synchronized (i.class) {
            if (yV == null) {
                yV = new i();
            }
            iVar = yV;
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
                int jl = i.jl();
                long js = i.js();
                i.je().iS();
                if (i.je().jd()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = jl;
                    networkState.mCurNetState = i.jl();
                    networkState.mlastChangedTime = js;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.je().j(currentTimeMillis);
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
        je().E(z);
        je().iS();
    }

    public static boolean jf() {
        return je().iU();
    }

    public static boolean jg() {
        return je().iV();
    }

    public static boolean jh() {
        return je().iW();
    }

    public static boolean ji() {
        return 3 == je().iX();
    }

    public static boolean jj() {
        return 2 == je().iX();
    }

    public static boolean jk() {
        return 1 == je().iX();
    }

    public static int jl() {
        if (jg()) {
            return 1;
        }
        if (jk()) {
            return 2;
        }
        if (jj()) {
            return 3;
        }
        return (ji() || jf()) ? 4 : 0;
    }

    public static String jm() {
        switch (jl()) {
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

    public static String jn() {
        String jm = jm();
        if (jm != null) {
            return jm.toUpperCase();
        }
        return jm;
    }

    public static int jo() {
        return je().iY();
    }

    public static String jp() {
        return je().iZ();
    }

    public static int jq() {
        return je().jc();
    }

    public static boolean jr() {
        return yS;
    }

    public static boolean aR(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = je().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long js() {
        return je().ja();
    }
}
