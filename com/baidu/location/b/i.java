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
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.webkit.internal.ETAG;
import java.util.List;
/* loaded from: classes6.dex */
public class i {
    private WifiManager c = null;
    private a d = null;
    private h e = null;
    private long f = 0;
    private long g = 0;
    private boolean h = false;
    private Handler i = new Handler();
    private long j = 0;
    private long k = 0;

    /* renamed from: b  reason: collision with root package name */
    private static i f2615b = null;

    /* renamed from: a  reason: collision with root package name */
    public static long f2614a = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private long f2617b;
        private boolean c;

        private a() {
            this.f2617b = 0L;
            this.c = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                i.f2614a = System.currentTimeMillis() / 1000;
                i.this.i.post(new j(this));
            } else if (action.equals(McastConfig.ACTION_NETWORK_STATE_CHANGED) && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) && System.currentTimeMillis() - this.f2617b >= 5000) {
                this.f2617b = System.currentTimeMillis();
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
            if (f2615b == null) {
                f2615b = new i();
            }
            iVar = f2615b;
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
        boolean a2 = a(hVar, hVar2, 0.7f);
        long currentTimeMillis = System.currentTimeMillis() - com.baidu.location.a.a.c;
        if (currentTimeMillis <= 0 || currentTimeMillis >= 30000 || !a2 || hVar2.f() - hVar.f() <= 30) {
            return a2;
        }
        return false;
    }

    public static boolean a(h hVar, h hVar2, float f) {
        int i;
        if (hVar == null || hVar2 == null) {
            return false;
        }
        List<ScanResult> list = hVar.f2612a;
        List<ScanResult> list2 = hVar2.f2612a;
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
        this.j = 0L;
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
                f2614a = 0L;
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
            if (currentTimeMillis - this.f <= this.j + 5000 || currentTimeMillis - (f2614a * 1000) <= this.j + 5000) {
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
        long currentTimeMillis = System.currentTimeMillis() - this.k;
        if (currentTimeMillis < 0 || currentTimeMillis > 2000) {
            this.k = System.currentTimeMillis();
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
        if (replace == null || rssi >= 100) {
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
        return (this.e == null || !this.e.i()) ? p() : this.e;
    }

    public h o() {
        return (this.e == null || !this.e.j()) ? p() : this.e;
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

    public String q() {
        try {
            WifiInfo connectionInfo = this.c.getConnectionInfo();
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
}
