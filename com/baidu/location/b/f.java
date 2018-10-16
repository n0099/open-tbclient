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
import com.baidu.location.a.j;
import com.baidu.location.a.n;
import com.baidu.location.a.p;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.webkit.internal.ETAG;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.List;
/* loaded from: classes6.dex */
public class f {
    private static f aeP = null;
    public static long a = 0;
    private WifiManager kr = null;
    private a aeQ = null;
    private e aeR = null;
    private long f = 0;
    private long g = 0;
    private boolean h = false;
    private Handler i = new Handler();
    private long j = 0;
    private long k = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
                        j.tr().h();
                        if (System.currentTimeMillis() - n.b() <= 5000) {
                            p.a(n.tw(), f.this.tJ(), n.tx(), n.a());
                        }
                    }
                });
            } else if (action.equals("android.net.wifi.STATE_CHANGE") && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) && System.currentTimeMillis() - this.b >= 5000) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.kr == null) {
            return;
        }
        try {
            List<ScanResult> scanResults = this.kr.getScanResults();
            if (scanResults != null) {
                e eVar = new e(scanResults, System.currentTimeMillis());
                if (this.aeR == null || !eVar.a(this.aeR)) {
                    this.aeR = eVar;
                }
            }
        } catch (Exception e) {
        }
    }

    public static synchronized f tH() {
        f fVar;
        synchronized (f.class) {
            if (aeP == null) {
                aeP = new f();
            }
            fVar = aeP;
        }
        return fVar;
    }

    public void b() {
        this.j = 0L;
    }

    public synchronized void c() {
        if (!this.h && com.baidu.location.f.isServing) {
            this.kr = (WifiManager) com.baidu.location.f.getServiceContext().getApplicationContext().getSystemService("wifi");
            this.aeQ = new a();
            try {
                com.baidu.location.f.getServiceContext().registerReceiver(this.aeQ, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            } catch (Exception e) {
            }
            this.h = true;
        }
    }

    public synchronized void d() {
        if (this.h) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.aeQ);
                a = 0L;
            } catch (Exception e) {
            }
            this.aeQ = null;
            this.kr = null;
            this.h = false;
        }
    }

    public boolean e() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.g <= 0 || currentTimeMillis - this.g > 5000) {
            this.g = currentTimeMillis;
            b();
            return f();
        }
        return false;
    }

    public boolean f() {
        if (this.kr == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f > 0) {
            if (currentTimeMillis - this.f <= this.j + 5000 || currentTimeMillis - (a * 1000) <= this.j + 5000) {
                return false;
            }
            if (i() && currentTimeMillis - this.f <= ErrDef.Feature.WEIGHT + this.j) {
                return false;
            }
        }
        return h();
    }

    @SuppressLint({"NewApi"})
    public String g() {
        if (this.kr != null) {
            try {
                if (!this.kr.isWifiEnabled()) {
                    if (Build.VERSION.SDK_INT <= 17) {
                        return "";
                    }
                    if (!this.kr.isScanAlwaysAvailable()) {
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
        if (currentTimeMillis < 0 || currentTimeMillis > SystemScreenshotManager.DELAY_TIME) {
            this.k = System.currentTimeMillis();
            try {
                if (this.kr.isWifiEnabled() || (Build.VERSION.SDK_INT > 17 && this.kr.isScanAlwaysAvailable())) {
                    this.kr.startScan();
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
            if ((!this.kr.isWifiEnabled() && (Build.VERSION.SDK_INT <= 17 || !this.kr.isScanAlwaysAvailable())) || i() || (eVar = new e(this.kr.getScanResults(), 0L)) == null) {
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
        WifiInfo tI = tH().tI();
        if (tI == null || tI.getBSSID() == null) {
            return null;
        }
        String replace = tI.getBSSID().replace(":", "");
        int rssi = tI.getRssi();
        String m = tH().m();
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
        String ssid = tI.getSSID();
        if (ssid != null && (ssid.contains(ETAG.ITEM_SEPARATOR) || ssid.contains(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR))) {
            ssid = ssid.replace(ETAG.ITEM_SEPARATOR, BaseRequestAction.SPLITE);
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
        if (this.kr == null || (dhcpInfo = this.kr.getDhcpInfo()) == null) {
            return null;
        }
        return a(dhcpInfo.gateway);
    }

    public String q() {
        try {
            WifiInfo connectionInfo = this.kr.getConnectionInfo();
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

    public WifiInfo tI() {
        if (this.kr == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = this.kr.getConnectionInfo();
            if (connectionInfo == null || connectionInfo.getBSSID() == null || connectionInfo.getRssi() <= -100) {
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
        } catch (Error e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public e tJ() {
        return (this.aeR == null || !this.aeR.i()) ? tL() : this.aeR;
    }

    public e tK() {
        return (this.aeR == null || !this.aeR.j()) ? tL() : this.aeR;
    }

    public e tL() {
        if (this.kr != null) {
            try {
                return new e(this.kr.getScanResults(), this.f);
            } catch (Exception e) {
            }
        }
        return new e(null, 0L);
    }
}
