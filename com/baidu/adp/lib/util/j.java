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
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class j {
    private static j Ft;
    private long Fr;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    private static boolean Fq = true;
    private NetworkInfo Fi = null;
    private boolean isWifi = true;
    private boolean Fj = false;
    private boolean Fk = true;
    private int Fl = 0;
    private int Fm = 0;
    private int Fn = -1;
    private String Fo = null;
    private int Fp = -1;
    private boolean Fs = true;

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
        Ft = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kx() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        this.Fi = activeNetworkInfo;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                this.isWifi = true;
                this.Fj = false;
            } else if (activeNetworkInfo.getType() == 0) {
                this.isWifi = false;
                this.Fj = true;
            } else {
                this.isWifi = false;
                this.Fj = false;
            }
            this.Fk = true;
            this.Fl = activeNetworkInfo.getSubtype();
            if (this.Fj) {
                this.Fm = az(this.Fl);
            } else {
                this.Fm = 0;
            }
        } else {
            this.isWifi = false;
            this.Fj = false;
            this.Fk = false;
            this.Fl = 0;
            this.Fl = 0;
        }
        this.Fn = kG();
        this.Fo = Proxy.getDefaultHost();
        this.Fp = Proxy.getDefaultPort();
    }

    private NetworkInfo getActiveNetworkInfo() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean ky() {
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

    public boolean kz() {
        if (this.Fi == null) {
            kx();
        }
        return this.Fk;
    }

    public boolean kA() {
        if (this.Fi == null) {
            kx();
        }
        return this.isWifi;
    }

    public boolean kB() {
        if (this.Fi == null) {
            kx();
        }
        return this.Fj;
    }

    public int kC() {
        if (this.Fi == null) {
            kx();
        }
        return this.Fm;
    }

    public int kD() {
        if (this.Fn == -1) {
            try {
                this.Fn = kG();
            } catch (Exception e) {
                this.Fn = 0;
            }
        }
        return this.Fn;
    }

    public String kE() {
        if (this.Fo == null) {
            this.Fo = Proxy.getDefaultHost();
        }
        return this.Fo;
    }

    private long kF() {
        return this.Fr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(long j) {
        this.Fr = j;
    }

    private static int kG() {
        int i;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || k.bx(networkOperator)) {
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
            case 11:
                return 3;
            case 4:
            case 8:
            case 9:
            case 10:
            default:
                return 0;
        }
    }

    public static int az(int i) {
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

    public int kH() {
        if (-1 == this.Fp) {
            this.Fp = Proxy.getDefaultPort();
        }
        return this.Fp;
    }

    public boolean kI() {
        return this.Fs;
    }

    public void Y(boolean z) {
        this.Fs = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized j kJ() {
        j jVar;
        synchronized (j.class) {
            if (Ft == null) {
                Ft = new j();
            }
            jVar = Ft;
        }
        return jVar;
    }

    /* loaded from: classes.dex */
    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                int kQ = j.kQ();
                long kX = j.kX();
                j.kJ().kx();
                if (j.kJ().kI()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = kQ;
                    networkState.mCurNetState = j.kQ();
                    networkState.mlastChangedTime = kX;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    j.kJ().q(currentTimeMillis);
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
        kJ().Y(z);
        kJ().kx();
    }

    public static boolean kK() {
        return kJ().kz();
    }

    public static boolean kL() {
        return kJ().kA();
    }

    public static boolean kM() {
        return kJ().kB();
    }

    public static boolean kN() {
        return 3 == kJ().kC();
    }

    public static boolean kO() {
        return 2 == kJ().kC();
    }

    public static boolean kP() {
        return 1 == kJ().kC();
    }

    public static int kQ() {
        if (kL()) {
            return 1;
        }
        if (kP()) {
            return 2;
        }
        if (kO()) {
            return 3;
        }
        return (kN() || kK()) ? 4 : 0;
    }

    public static String kR() {
        switch (kQ()) {
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

    public static String kS() {
        String kR = kR();
        if (kR != null) {
            return kR.toUpperCase();
        }
        return kR;
    }

    public static int kT() {
        return kJ().kD();
    }

    public static String kU() {
        return kJ().kE();
    }

    public static int kV() {
        return kJ().kH();
    }

    public static boolean kW() {
        return Fq;
    }

    public static boolean bv(String str) {
        if (mPattern.matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static boolean isWap() {
        NetworkInfo activeNetworkInfo = kJ().getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) ? false : true;
    }

    public static long kX() {
        return kJ().kF();
    }
}
