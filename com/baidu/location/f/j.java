package com.baidu.location.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import com.baidu.tbadk.TbConfig;
import java.lang.reflect.Field;
import java.util.List;
/* loaded from: classes.dex */
public class j extends l {
    private static j QC = null;
    public static long a = 0;
    private WifiManager QD = null;
    private a QE = null;
    private i QF = null;
    private long f = 0;
    private long g = 0;
    private boolean h = false;
    private Object i = null;
    private boolean j = true;
    private Handler k = new Handler();

    /* loaded from: classes.dex */
    private class a extends BroadcastReceiver {
        private long b;
        private boolean c;

        private a() {
            this.b = 0L;
            this.c = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                j.a = System.currentTimeMillis() / 1000;
                j.this.m();
                com.baidu.location.a.e.mv().h();
                if (System.currentTimeMillis() - com.baidu.location.a.h.b() <= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    com.baidu.location.a.j.a(com.baidu.location.a.h.mB(), j.this.no(), com.baidu.location.a.h.mC(), com.baidu.location.a.h.a());
                }
            } else if (action.equals("android.net.wifi.STATE_CHANGE") && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) && System.currentTimeMillis() - this.b >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                this.b = System.currentTimeMillis();
                if (this.c) {
                    return;
                }
                this.c = true;
            }
        }
    }

    private j() {
    }

    public static boolean a(i iVar, i iVar2, float f) {
        int i;
        if (iVar == null || iVar2 == null) {
            return false;
        }
        List<ScanResult> list = iVar.a;
        List<ScanResult> list2 = iVar2.a;
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        int size = list.size();
        int size2 = list2.size();
        float f2 = size + size2;
        if (size == 0 && size2 == 0) {
            return true;
        }
        if (size == 0 || size2 == 0) {
            return false;
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            String str = list.get(i2).BSSID;
            if (str != null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        i = i3;
                        break;
                    } else if (str.equals(list2.get(i4).BSSID)) {
                        i = i3 + 1;
                        break;
                    } else {
                        i4++;
                    }
                }
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        return ((float) (i3 * 2)) > f2 * f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.QD == null) {
            return;
        }
        try {
            i iVar = new i(this.QD.getScanResults(), System.currentTimeMillis());
            if (this.QF == null || !iVar.a(this.QF)) {
                this.QF = iVar;
            }
        } catch (Exception e) {
        }
    }

    public static synchronized j nm() {
        j jVar;
        synchronized (j.class) {
            if (QC == null) {
                QC = new j();
            }
            jVar = QC;
        }
        return jVar;
    }

    @Override // com.baidu.location.f.l
    public synchronized void b() {
        if (!this.h && com.baidu.location.f.isServing) {
            this.QD = (WifiManager) com.baidu.location.f.getServiceContext().getSystemService("wifi");
            this.QE = new a();
            try {
                com.baidu.location.f.getServiceContext().registerReceiver(this.QE, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            } catch (Exception e) {
            }
            this.h = true;
            try {
                Field declaredField = Class.forName("android.net.wifi.WifiManager").getDeclaredField("mService");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    this.i = declaredField.get(this.QD);
                    this.i.getClass();
                }
            } catch (Exception e2) {
            }
        }
    }

    @Override // com.baidu.location.f.l
    public synchronized void c() {
        if (this.h) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.QE);
                a = 0L;
            } catch (Exception e) {
            }
            this.QE = null;
            this.QD = null;
            this.h = false;
        }
    }

    @Override // com.baidu.location.f.l
    public boolean d() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.g <= TbConfig.NOTIFY_SOUND_INTERVAL) {
            return false;
        }
        this.g = currentTimeMillis;
        return e();
    }

    @Override // com.baidu.location.f.l
    public boolean e() {
        if (this.QD == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f <= TbConfig.NOTIFY_SOUND_INTERVAL || currentTimeMillis - (a * 1000) <= TbConfig.NOTIFY_SOUND_INTERVAL) {
            return false;
        }
        if (!g() || currentTimeMillis - this.f > 10000) {
            return f();
        }
        return false;
    }

    @Override // com.baidu.location.f.l
    public boolean f() {
        try {
            if (this.QD.isWifiEnabled() || (Build.VERSION.SDK_INT > 17 && this.QD.isScanAlwaysAvailable())) {
                this.QD.startScan();
                this.f = System.currentTimeMillis();
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        } catch (NoSuchMethodError e2) {
            return false;
        }
    }

    @Override // com.baidu.location.f.l
    public boolean g() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.baidu.location.f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.location.f.l
    public String l() {
        try {
            WifiInfo connectionInfo = this.QD.getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.location.f.l
    public WifiInfo nn() {
        if (this.QD == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = this.QD.getConnectionInfo();
            if (connectionInfo == null || connectionInfo.getBSSID() == null) {
                return null;
            }
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                String replace = bssid.replace(":", "");
                if ("000000000000".equals(replace)) {
                    return null;
                }
                if ("".equals(replace)) {
                    return null;
                }
            }
            return connectionInfo;
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.location.f.l
    public i no() {
        return (this.QF == null || !this.QF.f()) ? nq() : this.QF;
    }

    @Override // com.baidu.location.f.l
    public i np() {
        return (this.QF == null || !this.QF.g()) ? nq() : this.QF;
    }

    @Override // com.baidu.location.f.l
    public i nq() {
        if (this.QD != null) {
            try {
                return new i(this.QD.getScanResults(), this.f);
            } catch (Exception e) {
            }
        }
        return new i(null, 0L);
    }
}
