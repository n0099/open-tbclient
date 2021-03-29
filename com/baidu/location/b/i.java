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
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.util.List;
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static long f6649a;

    /* renamed from: b  reason: collision with root package name */
    public static i f6650b;

    /* renamed from: c  reason: collision with root package name */
    public WifiManager f6651c = null;

    /* renamed from: d  reason: collision with root package name */
    public a f6652d = null;

    /* renamed from: e  reason: collision with root package name */
    public h f6653e = null;

    /* renamed from: f  reason: collision with root package name */
    public long f6654f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f6655g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6656h = false;
    public Handler i = new Handler();
    public long j = 0;
    public long k = 0;

    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        public long f6658b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6659c;

        public a() {
            this.f6658b = 0L;
            this.f6659c = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                i.f6649a = System.currentTimeMillis() / 1000;
                i.this.i.post(new j(this));
            } else if (action.equals(McastConfig.ACTION_NETWORK_STATE_CHANGED) && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) && System.currentTimeMillis() - this.f6658b >= 5000) {
                this.f6658b = System.currentTimeMillis();
                if (this.f6659c) {
                    return;
                }
                this.f6659c = true;
            }
        }
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (f6650b == null) {
                f6650b = new i();
            }
            iVar = f6650b;
        }
        return iVar;
    }

    private String a(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append(IStringUtil.EXTENSION_SEPARATOR);
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append(IStringUtil.EXTENSION_SEPARATOR);
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append(IStringUtil.EXTENSION_SEPARATOR);
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }

    public static boolean a(h hVar, h hVar2) {
        boolean a2 = a(hVar, hVar2, 0.7f);
        long currentTimeMillis = System.currentTimeMillis() - com.baidu.location.a.a.f6449c;
        if (currentTimeMillis <= 0 || currentTimeMillis >= StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD || !a2 || hVar2.f() - hVar.f() <= 30) {
            return a2;
        }
        return false;
    }

    public static boolean a(h hVar, h hVar2, float f2) {
        if (hVar != null && hVar2 != null) {
            List<ScanResult> list = hVar.f6644a;
            List<ScanResult> list2 = hVar2.f6644a;
            if (list == list2) {
                return true;
            }
            if (list != null && list2 != null) {
                int size = list.size();
                int size2 = list2.size();
                if (size == 0 && size2 == 0) {
                    return true;
                }
                if (size != 0 && size2 != 0) {
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = list.get(i2).BSSID;
                        if (str != null) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= size2) {
                                    break;
                                } else if (str.equals(list2.get(i3).BSSID)) {
                                    i++;
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                    if (i >= size * f2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean i() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.baidu.location.f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        WifiManager wifiManager = this.f6651c;
        if (wifiManager == null) {
            return;
        }
        try {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                h hVar = new h(scanResults, System.currentTimeMillis());
                h hVar2 = this.f6653e;
                if (hVar2 == null || !hVar.a(hVar2)) {
                    this.f6653e = hVar;
                }
            }
        } catch (Exception unused) {
        }
    }

    public void b() {
        this.j = 0L;
    }

    public synchronized void c() {
        if (this.f6656h) {
            return;
        }
        if (com.baidu.location.f.isServing) {
            this.f6651c = (WifiManager) com.baidu.location.f.getServiceContext().getApplicationContext().getSystemService("wifi");
            this.f6652d = new a();
            try {
                com.baidu.location.f.getServiceContext().registerReceiver(this.f6652d, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            } catch (Exception unused) {
            }
            this.f6656h = true;
        }
    }

    public synchronized void d() {
        if (this.f6656h) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.f6652d);
                f6649a = 0L;
            } catch (Exception unused) {
            }
            this.f6652d = null;
            this.f6651c = null;
            this.f6656h = false;
        }
    }

    public boolean e() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f6655g;
        if (currentTimeMillis - j <= 0 || currentTimeMillis - j > 5000) {
            this.f6655g = currentTimeMillis;
            b();
            return f();
        }
        return false;
    }

    public boolean f() {
        if (this.f6651c == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f6654f;
        if (currentTimeMillis - j > 0) {
            long j2 = this.j;
            if (currentTimeMillis - j <= j2 + 5000 || currentTimeMillis - (f6649a * 1000) <= j2 + 5000) {
                return false;
            }
            if (i() && currentTimeMillis - this.f6654f <= this.j + 10000) {
                return false;
            }
        }
        return h();
    }

    @SuppressLint({"NewApi"})
    public String g() {
        WifiManager wifiManager = this.f6651c;
        if (wifiManager != null) {
            try {
                if (!wifiManager.isWifiEnabled()) {
                    if (Build.VERSION.SDK_INT <= 17) {
                        return "";
                    }
                    if (!this.f6651c.isScanAlwaysAvailable()) {
                        return "";
                    }
                }
                return "&wifio=1";
            } catch (Exception | NoSuchMethodError unused) {
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
                if (!this.f6651c.isWifiEnabled() && (Build.VERSION.SDK_INT <= 17 || !this.f6651c.isScanAlwaysAvailable())) {
                    return false;
                }
                this.f6651c.startScan();
                this.f6654f = System.currentTimeMillis();
                return true;
            } catch (Exception | NoSuchMethodError unused) {
                return false;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public boolean j() {
        try {
            if ((this.f6651c.isWifiEnabled() || (Build.VERSION.SDK_INT > 17 && this.f6651c.isScanAlwaysAvailable())) && !i()) {
                return new h(this.f6651c.getScanResults(), 0L).e();
            }
            return false;
        } catch (Exception | NoSuchMethodError unused) {
            return false;
        }
    }

    public WifiInfo k() {
        WifiManager wifiManager = this.f6651c;
        if (wifiManager == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null && connectionInfo.getBSSID() != null && connectionInfo.getRssi() > -100) {
                String bssid = connectionInfo.getBSSID();
                if (bssid != null) {
                    String replace = bssid.replace(":", "");
                    if (!"000000000000".equals(replace)) {
                        if ("".equals(replace)) {
                        }
                    }
                    return null;
                }
                return connectionInfo;
            }
        } catch (Error | Exception unused) {
        }
        return null;
    }

    public String l() {
        StringBuffer stringBuffer = new StringBuffer();
        WifiInfo k = a().k();
        if (k != null && k.getBSSID() != null) {
            String replace = k.getBSSID().replace(":", "");
            int rssi = k.getRssi();
            String m = a().m();
            if (rssi < 0) {
                rssi = -rssi;
            }
            if (replace != null && rssi < 100) {
                stringBuffer.append("&wf=");
                stringBuffer.append(replace);
                stringBuffer.append(";");
                stringBuffer.append("" + rssi + ";");
                String ssid = k.getSSID();
                if (ssid != null && (ssid.contains("&") || ssid.contains(";"))) {
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
        }
        return null;
    }

    public String m() {
        DhcpInfo dhcpInfo;
        WifiManager wifiManager = this.f6651c;
        if (wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null) {
            return null;
        }
        return a(dhcpInfo.gateway);
    }

    public h n() {
        h hVar = this.f6653e;
        return (hVar == null || !hVar.i()) ? p() : this.f6653e;
    }

    public h o() {
        h hVar = this.f6653e;
        return (hVar == null || !hVar.j()) ? p() : this.f6653e;
    }

    public h p() {
        WifiManager wifiManager = this.f6651c;
        if (wifiManager != null) {
            try {
                return new h(wifiManager.getScanResults(), this.f6654f);
            } catch (Exception unused) {
            }
        }
        return new h(null, 0L);
    }

    public String q() {
        try {
            WifiInfo connectionInfo = this.f6651c.getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
            return null;
        } catch (Error | Exception unused) {
            return null;
        }
    }
}
