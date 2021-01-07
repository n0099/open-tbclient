package b.a.a.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.android.imsdk.mcast.McastConfig;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes4.dex */
public final class j extends ag implements Runnable, Comparator {
    public static boolean d = false;
    private static long i = 0;
    private static boolean j = false;
    public long c;
    private Handler e;
    private int f;
    private long g;
    private BroadcastReceiver h;

    public j(w wVar, y yVar) {
        super(wVar, yVar);
        this.e = null;
        this.f = 4;
        this.c = 30000L;
        this.g = 0L;
        this.h = new k(this);
    }

    public static String a(Context context) {
        String bssid;
        if (context == null) {
            return "{}";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (wifiManager == null || connectivityManager == null) {
                return "{}";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (connectionInfo == null || networkInfo == null || !networkInfo.isConnected() || (bssid = connectionInfo.getBSSID()) == null || bssid.equals("000000000000") || bssid.equals("00-00-00-00-00-00") || bssid.equals("00:00:00:00:00:00")) {
                return "{}";
            }
            int rssi = connectionInfo.getRssi();
            if (rssi < -100 || rssi > -20) {
                return "{}";
            }
            String replace = connectionInfo.getSSID().replace("\"", "").replace("|", "");
            return "{\"mac\":\"" + bssid + "\",\"rssi\":" + rssi + ",\"ssid\":\"" + replace + "\"}";
        } catch (Throwable th) {
            return "{}";
        }
    }

    private void a(long j2) {
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacks(this);
            handler.postDelayed(this, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(j jVar, List list) {
        jVar.g = System.currentTimeMillis();
        if (list.size() == 0) {
            jVar.f();
        } else if (d) {
            d = false;
            jVar.f();
        }
        jVar.a(new af(list, jVar.g, jVar.f));
    }

    private static boolean a(w wVar) {
        WifiManager wifiManager = wVar.AY;
        if (wifiManager != null) {
            try {
                if (Build.VERSION.SDK_INT < 23 || Settings.Secure.getInt(wVar.f1082a.getContentResolver(), "location_mode") != 0) {
                    boolean isWifiEnabled = wifiManager.isWifiEnabled();
                    return (isWifiEnabled || Build.VERSION.SDK_INT < 18) ? isWifiEnabled : wifiManager.isScanAlwaysAvailable();
                }
                return false;
            } catch (Throwable th) {
                if (th instanceof SecurityException) {
                    d = true;
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    public static List b(WifiManager wifiManager) {
        List<ScanResult> list = null;
        if (wifiManager != null) {
            try {
                list = wifiManager.getScanResults();
                d = false;
            } catch (Throwable th) {
                d = true;
            }
        }
        return list == null ? Collections.emptyList() : list;
    }

    private static boolean c(WifiManager wifiManager) {
        boolean z = false;
        synchronized (j.class) {
            if (wifiManager != null) {
                try {
                    if (System.currentTimeMillis() - i > IMConnection.RETRY_DELAY_TIMES) {
                        z = wifiManager.startScan();
                        j = z;
                        i = System.currentTimeMillis();
                    } else {
                        z = j;
                    }
                } catch (Throwable th) {
                    try {
                        if (th instanceof SecurityException) {
                            d = true;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int i2;
        try {
            this.f = this.Bm.b() ? this.Bm.AY.getWifiState() : 4;
        } catch (Throwable th) {
            this.f = 4;
        }
        if (this.f == 3) {
            a(0L);
            i2 = 1;
        } else if (this.f == 1) {
            i2 = 0;
            if (!a(this.Bm)) {
                this.e.sendEmptyMessage(2005);
            }
        } else {
            i2 = -1;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                if (Settings.Secure.getInt(this.Bm.f1082a.getContentResolver(), "location_mode") == 0) {
                    i2 = 5;
                }
            }
        } catch (Throwable th2) {
        }
        a(1, i2);
    }

    @Override // b.a.a.a.a.ah
    public final void b(Handler handler) {
        this.e = handler;
        Handler handler2 = this.e;
        if (handler2 != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(McastConfig.ACTION_WIFI_STATE_CHANGED);
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            try {
                this.Bm.f1082a.registerReceiver(this.h, intentFilter, null, handler2);
            } catch (Throwable th) {
            }
        }
        a(0L);
    }

    @Override // b.a.a.a.a.ah
    public final void c() {
        if (this.e != null) {
            this.e.removeCallbacksAndMessages(null);
            this.e = null;
        }
        try {
            this.Bm.f1082a.unregisterReceiver(this.h);
        } catch (Throwable th) {
        }
        this.g = 0L;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((ScanResult) obj2).level - ((ScanResult) obj).level;
    }

    @Override // b.a.a.a.a.ah
    public final String d() {
        return "WifiPro";
    }

    public final boolean e() {
        if (a(this.Bm)) {
            return c(this.Bm.AY);
        }
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e();
        a(this.c);
    }
}
