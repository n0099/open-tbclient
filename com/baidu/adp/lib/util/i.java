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
    private static boolean yB = true;
    private static i yE;
    private long yC;
    private NetworkInfo yt = null;
    private boolean isWifi = true;
    private boolean yu = false;
    private boolean yv = true;
    private int yw = 0;
    private int yx = 0;
    private int yy = -1;
    private String yz = null;
    private int yA = -1;
    private boolean yD = true;

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
        yE = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iM() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.yt = activeNetworkInfo;
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.yu = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.yu = true;
            } else {
                this.isWifi = false;
                this.yu = false;
            }
            this.yv = true;
            this.yw = activeNetworkInfo.getSubtype();
            if (this.yu) {
                this.yx = aq(this.yw);
            } else {
                this.yx = 0;
            }
        } else {
            this.isWifi = false;
            this.yu = false;
            this.yv = false;
            this.yw = 0;
            this.yw = 0;
        }
        this.yy = iV();
        this.yz = Proxy.getDefaultHost();
        this.yA = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean iN() {
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

    public boolean iO() {
        if (this.yt == null) {
            iM();
        }
        return this.yv;
    }

    public boolean iP() {
        if (this.yt == null) {
            iM();
        }
        return this.isWifi;
    }

    public boolean iQ() {
        if (this.yt == null) {
            iM();
        }
        return this.yu;
    }

    public int iR() {
        if (this.yt == null) {
            iM();
        }
        return this.yx;
    }

    public int iS() {
        if (this.yy == -1) {
            try {
                this.yy = iV();
            } catch (Exception e) {
                this.yy = 0;
            }
        }
        return this.yy;
    }

    public String iT() {
        if (this.yz == null) {
            this.yz = Proxy.getDefaultHost();
        }
        return this.yz;
    }

    private long iU() {
        return this.yC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j) {
        this.yC = j;
    }

    private static int iV() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || j.aR(networkOperator)) {
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

    public static int aq(int i) {
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

    public int iW() {
        if (-1 == this.yA) {
            this.yA = Proxy.getDefaultPort();
        }
        return this.yA;
    }

    public boolean iX() {
        return this.yD;
    }

    public void F(boolean z) {
        this.yD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized i iY() {
        i iVar;
        synchronized (i.class) {
            if (yE == null) {
                yE = new i();
            }
            iVar = yE;
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
                int jf = i.jf();
                long jm = i.jm();
                i.iY().iM();
                if (i.iY().iX()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = jf;
                    networkState.mCurNetState = i.jf();
                    networkState.mlastChangedTime = jm;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    i.iY().j(currentTimeMillis);
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
        iY().F(z);
        iY().iM();
    }

    public static boolean iZ() {
        return iY().iO();
    }

    public static boolean ja() {
        return iY().iP();
    }

    public static boolean jb() {
        return iY().iQ();
    }

    public static boolean jc() {
        return 3 == iY().iR();
    }

    public static boolean jd() {
        return 2 == iY().iR();
    }

    public static boolean je() {
        return 1 == iY().iR();
    }

    public static int jf() {
        if (ja()) {
            return 1;
        }
        if (je()) {
            return 2;
        }
        if (jd()) {
            return 3;
        }
        return (jc() || iZ()) ? 4 : 0;
    }

    public static String jg() {
        switch (jf()) {
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

    public static String jh() {
        String jg = jg();
        if (jg != null) {
            return jg.toUpperCase();
        }
        return jg;
    }

    public static int ji() {
        return iY().iS();
    }

    public static String jj() {
        return iY().iT();
    }

    public static int jk() {
        return iY().iW();
    }

    public static boolean jl() {
        return yB;
    }

    public static boolean aP(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = iY().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long jm() {
        return iY().iU();
    }
}
