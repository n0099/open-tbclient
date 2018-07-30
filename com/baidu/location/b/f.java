package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.location.a.j;
import com.baidu.location.a.n;
import com.baidu.location.a.p;
import com.baidu.tbadk.TbConfig;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.List;
/* loaded from: classes2.dex */
public class f {
    private static f XG = null;
    public static long a = 0;
    private WifiManager XH = null;
    private a XI = null;
    private e XJ = null;
    private long f = 0;
    private long g = 0;
    private boolean h = false;
    private Handler i = new Handler();
    private long j = 0;
    private long k = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
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
                f.a = System.currentTimeMillis() / 1000;
                f.this.i.post(new Runnable() { // from class: com.baidu.location.b.f.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f.this.r();
                        j.qv().h();
                        if (System.currentTimeMillis() - n.b() <= TbConfig.NOTIFY_SOUND_INTERVAL) {
                            p.a(n.qA(), f.this.qN(), n.qB(), n.a());
                        }
                    }
                });
            } else if (action.equals("android.net.wifi.STATE_CHANGE") && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) && System.currentTimeMillis() - this.b >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                this.b = System.currentTimeMillis();
                if (this.c) {
                    return;
                }
                this.c = true;
            }
        }
    }

    private f() {
    }

    private String a(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }

    public static boolean a(e eVar, e eVar2) {
        boolean a2 = a(eVar, eVar2, 0.7f);
        long currentTimeMillis = System.currentTimeMillis() - com.baidu.location.a.a.c;
        if (currentTimeMillis <= 0 || currentTimeMillis >= StatisticConfig.MIN_UPLOAD_INTERVAL || !a2 || eVar2.f() - eVar.f() <= 30) {
            return a2;
        }
        return false;
    }

    public static boolean a(e eVar, e eVar2, float f) {
        int i;
        if (eVar == null || eVar2 == null) {
            return false;
        }
        List<ScanResult> list = eVar.a;
        List<ScanResult> list2 = eVar2.a;
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        int size = list.size();
        int size2 = list2.size();
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
        return ((float) i3) >= ((float) size) * f;
    }

    public static boolean i() {
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

    public static synchronized f qL() {
        f fVar;
        synchronized (f.class) {
            if (XG == null) {
                XG = new f();
            }
            fVar = XG;
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.XH == null) {
            return;
        }
        try {
            List<ScanResult> scanResults = this.XH.getScanResults();
            if (scanResults != null) {
                e eVar = new e(scanResults, System.currentTimeMillis());
                if (this.XJ == null || !eVar.a(this.XJ)) {
                    this.XJ = eVar;
                }
            }
        } catch (Exception e) {
        }
    }

    public void b() {
        this.j = 0L;
    }

    public synchronized void c() {
        if (!this.h && com.baidu.location.f.isServing) {
            this.XH = (WifiManager) com.baidu.location.f.getServiceContext().getApplicationContext().getSystemService("wifi");
            this.XI = new a();
            try {
                com.baidu.location.f.getServiceContext().registerReceiver(this.XI, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            } catch (Exception e) {
            }
            this.h = true;
        }
    }

    public synchronized void d() {
        if (this.h) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.XI);
                a = 0L;
            } catch (Exception e) {
            }
            this.XI = null;
            this.XH = null;
            this.h = false;
        }
    }

    public boolean e() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.g <= 0 || currentTimeMillis - this.g > TbConfig.NOTIFY_SOUND_INTERVAL) {
            this.g = currentTimeMillis;
            b();
            return f();
        }
        return false;
    }

    public boolean f() {
        if (this.XH == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f > 0) {
            if (currentTimeMillis - this.f <= this.j + TbConfig.NOTIFY_SOUND_INTERVAL || currentTimeMillis - (a * 1000) <= this.j + TbConfig.NOTIFY_SOUND_INTERVAL) {
                return false;
            }
            if (i() && currentTimeMillis - this.f <= 10000 + this.j) {
                return false;
            }
        }
        return h();
    }

    @SuppressLint({"NewApi"})
    public String g() {
        if (this.XH != null) {
            try {
                if (!this.XH.isWifiEnabled()) {
                    if (Build.VERSION.SDK_INT <= 17) {
                        return "";
                    }
                    if (!this.XH.isScanAlwaysAvailable()) {
                        return "";
                    }
                }
                return "&wifio=1";
            } catch (Exception e) {
                return "";
            } catch (NoSuchMethodError e2) {
                return "";
            }
        }
        return "";
    }

    @SuppressLint({"NewApi"})
    public boolean h() {
        long currentTimeMillis = System.currentTimeMillis() - this.k;
        if (currentTimeMillis < 0 || currentTimeMillis > 2000) {
            this.k = System.currentTimeMillis();
            try {
                if (this.XH.isWifiEnabled() || (Build.VERSION.SDK_INT > 17 && this.XH.isScanAlwaysAvailable())) {
                    this.XH.startScan();
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
        return false;
    }

    @SuppressLint({"NewApi"})
    public boolean j() {
        e eVar;
        try {
            if ((!this.XH.isWifiEnabled() && (Build.VERSION.SDK_INT <= 17 || !this.XH.isScanAlwaysAvailable())) || i() || (eVar = new e(this.XH.getScanResults(), 0L)) == null) {
                return false;
            }
            return eVar.e();
        } catch (Exception e) {
            return false;
        } catch (NoSuchMethodError e2) {
            return false;
        }
    }

    public String l() {
        StringBuffer stringBuffer = new StringBuffer();
        WifiInfo qM = qL().qM();
        if (qM == null || qM.getBSSID() == null) {
            return null;
        }
        String replace = qM.getBSSID().replace(SystemInfoUtil.COLON, "");
        int rssi = qM.getRssi();
        String m = qL().m();
        if (rssi < 0) {
            rssi = -rssi;
        }
        if (replace == null || rssi >= 100) {
            return null;
        }
        stringBuffer.append("&wf=");
        stringBuffer.append(replace);
        stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        stringBuffer.append("" + rssi + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        String ssid = qM.getSSID();
        if (ssid != null && (ssid.contains("&") || ssid.contains(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR))) {
            ssid = ssid.replace("&", "_");
        }
        stringBuffer.append(ssid);
        stringBuffer.append("&wf_n=1");
        if (m != null) {
            stringBuffer.append("&wf_gw=");
            stringBuffer.append(m);
        }
        return stringBuffer.toString();
    }

    public String m() {
        DhcpInfo dhcpInfo;
        if (this.XH == null || (dhcpInfo = this.XH.getDhcpInfo()) == null) {
            return null;
        }
        return a(dhcpInfo.gateway);
    }

    public String q() {
        try {
            WifiInfo connectionInfo = this.XH.getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
            return null;
        } catch (Error e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public WifiInfo qM() {
        if (this.XH == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = this.XH.getConnectionInfo();
            if (connectionInfo == null || connectionInfo.getBSSID() == null || connectionInfo.getRssi() <= -100) {
                return null;
            }
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                String replace = bssid.replace(SystemInfoUtil.COLON, "");
                if ("000000000000".equals(replace)) {
                    return null;
                }
                if ("".equals(replace)) {
                    return null;
                }
            }
            return connectionInfo;
        } catch (Error e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public e qN() {
        return (this.XJ == null || !this.XJ.i()) ? qP() : this.XJ;
    }

    public e qO() {
        return (this.XJ == null || !this.XJ.j()) ? qP() : this.XJ;
    }

    public e qP() {
        if (this.XH != null) {
            try {
                return new e(this.XH.getScanResults(), this.f);
            } catch (Exception e) {
            }
        }
        return new e(null, 0L);
    }
}
