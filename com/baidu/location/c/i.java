package com.baidu.location.c;

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
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.location.e.l;
import com.baidu.webkit.internal.ETAG;
import java.util.List;
/* loaded from: classes3.dex */
public class i {
    private WifiManager c = null;
    private a d = null;
    private h e = null;
    private long f = 0;
    private long g = 0;
    private boolean h = false;
    private ConnectivityManager i = null;
    private Handler j = new Handler();
    private boolean k = false;
    private long l = 0;
    private long m = 0;
    private static i b = null;
    public static long a = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
                i.a = System.currentTimeMillis() / 1000;
                i.this.j.post(new j(this, intent.getBooleanExtra("resultsUpdated", true)));
            } else if (action.equals(McastConfig.ACTION_NETWORK_STATE_CHANGED) && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) && System.currentTimeMillis() - this.b >= 5000) {
                this.b = System.currentTimeMillis();
                if (this.c) {
                    return;
                }
                this.c = true;
            }
        }
    }

    private i() {
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (b == null) {
                b = new i();
            }
            iVar = b;
        }
        return iVar;
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

    public static boolean a(h hVar, h hVar2) {
        boolean a2 = a(hVar, hVar2, l.aA);
        long currentTimeMillis = System.currentTimeMillis() - com.baidu.location.b.b.c;
        if (currentTimeMillis <= 0 || currentTimeMillis >= 30000 || !a2 || hVar2.g() - hVar.g() <= 30) {
            return a2;
        }
        return false;
    }

    public static boolean a(h hVar, h hVar2, float f) {
        int i;
        if (hVar == null || hVar2 == null) {
            return false;
        }
        List<ScanResult> list = hVar.a;
        List<ScanResult> list2 = hVar2.a;
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
            String str = list.get(i2) != null ? list.get(i2).BSSID : null;
            if (str != null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        i = i3;
                        break;
                    }
                    String str2 = list2.get(i4) != null ? list2.get(i4).BSSID : null;
                    if (str2 != null && str.equals(str2)) {
                        i = i3 + 1;
                        break;
                    }
                    i4++;
                }
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        return ((float) i3) >= ((float) size) * f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.c == null) {
            return;
        }
        try {
            List<ScanResult> scanResults = this.c.getScanResults();
            if (scanResults != null) {
                h hVar = new h(scanResults, System.currentTimeMillis());
                if (this.e == null || !hVar.a(this.e)) {
                    this.e = hVar;
                }
            }
        } catch (Exception e) {
        }
    }

    public void b() {
        this.l = 0L;
    }

    public synchronized void c() {
        if (!this.h && com.baidu.location.f.isServing) {
            this.c = (WifiManager) com.baidu.location.f.getServiceContext().getApplicationContext().getSystemService("wifi");
            this.d = new a();
            try {
                com.baidu.location.f.getServiceContext().registerReceiver(this.d, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            } catch (Exception e) {
            }
            this.h = true;
        }
    }

    public synchronized void d() {
        if (this.h) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.d);
                a = 0L;
            } catch (Exception e) {
            }
            this.d = null;
            this.c = null;
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
        if (this.c == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f > 0) {
            if (currentTimeMillis - this.f <= this.l + 5000 || currentTimeMillis - (a * 1000) <= this.l + 5000) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 28 && currentTimeMillis - this.f < 25000) {
                return false;
            }
            if (i() && currentTimeMillis - this.f <= 10000 + this.l) {
                return false;
            }
        }
        return h();
    }

    @SuppressLint({"NewApi"})
    public String g() {
        if (this.c != null) {
            try {
                if (!this.c.isWifiEnabled()) {
                    if (Build.VERSION.SDK_INT <= 17) {
                        return "";
                    }
                    if (!this.c.isScanAlwaysAvailable()) {
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
        long currentTimeMillis = System.currentTimeMillis() - this.m;
        if (currentTimeMillis < 0 || currentTimeMillis > 2000) {
            this.m = System.currentTimeMillis();
            try {
                if (this.c.isWifiEnabled() || (Build.VERSION.SDK_INT > 17 && this.c.isScanAlwaysAvailable())) {
                    this.c.startScan();
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

    public boolean i() {
        try {
            if (this.i == null) {
                this.i = (ConnectivityManager) com.baidu.location.f.getServiceContext().getSystemService("connectivity");
            }
            if (this.i != null) {
                return this.i.getNetworkInfo(1).isConnected();
            }
            return false;
        } catch (Error e) {
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public boolean j() {
        h hVar;
        try {
            if ((!this.c.isWifiEnabled() && (Build.VERSION.SDK_INT <= 17 || !this.c.isScanAlwaysAvailable())) || i() || (hVar = new h(this.c.getScanResults(), 0L)) == null) {
                return false;
            }
            return hVar.e();
        } catch (Exception e) {
            return false;
        } catch (NoSuchMethodError e2) {
            return false;
        }
    }

    public WifiInfo k() {
        if (this.c == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = this.c.getConnectionInfo();
            if (connectionInfo == null || connectionInfo.getBSSID() == null || connectionInfo.getRssi() <= -100) {
                return null;
            }
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                String replace = bssid.replace(":", "");
                if ("000000000000".equals(replace) || "".equals(replace)) {
                    return null;
                }
                if (replace.equals("020000000000")) {
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

    public String l() {
        StringBuffer stringBuffer = new StringBuffer();
        WifiInfo k = a().k();
        if (k == null || k.getBSSID() == null) {
            return null;
        }
        String replace = k.getBSSID().replace(":", "");
        int rssi = k.getRssi();
        String m = a().m();
        if (rssi < 0) {
            rssi = -rssi;
        }
        if (replace == null || rssi >= 100 || replace.equals("020000000000")) {
            return null;
        }
        stringBuffer.append("&wf=");
        stringBuffer.append(replace);
        stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        stringBuffer.append("" + rssi + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        String ssid = k.getSSID();
        if (ssid != null && (ssid.contains(ETAG.ITEM_SEPARATOR) || ssid.contains(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR))) {
            ssid = ssid.replace(ETAG.ITEM_SEPARATOR, PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
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
        if (this.c == null || (dhcpInfo = this.c.getDhcpInfo()) == null) {
            return null;
        }
        return a(dhcpInfo.gateway);
    }

    public h n() {
        return (this.e == null || !this.e.j()) ? p() : this.e;
    }

    public h o() {
        return (this.e == null || !this.e.k()) ? p() : this.e;
    }

    public h p() {
        if (this.c != null) {
            try {
                return new h(this.c.getScanResults(), this.f);
            } catch (Exception e) {
            }
        }
        return new h(null, 0L);
    }
}
