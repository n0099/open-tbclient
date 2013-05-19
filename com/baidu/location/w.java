package com.baidu.location;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class w {
    private static String a = "baidu_location_service";
    private Context e;
    private Handler f;
    private final long b = 3000;
    private final long c = 3000;
    private final long d = 5000;
    private WifiManager g = null;
    private z h = null;
    private y i = null;
    private aa j = null;
    private long k = 0;
    private long l = 0;
    private boolean m = false;
    private Object n = null;
    private Method o = null;
    private boolean p = true;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;

    public w(Context context, Handler handler) {
        this.f = null;
        this.e = context;
        this.f = handler;
    }

    public void k() {
        if (this.g == null) {
            return;
        }
        try {
            aa aaVar = new aa(this, this.g.getScanResults(), this.k);
            this.k = 0L;
            if (this.j == null || !aaVar.a(this.j)) {
                this.j = aaVar;
            }
        } catch (Exception e) {
        }
    }

    public void l() {
        NetworkInfo.State state;
        NetworkInfo.State state2 = NetworkInfo.State.UNKNOWN;
        try {
            state = ((ConnectivityManager) this.e.getSystemService("connectivity")).getNetworkInfo(1).getState();
        } catch (Exception e) {
            state = state2;
        }
        if (NetworkInfo.State.CONNECTED != state) {
            this.q = false;
        } else if (this.q) {
        } else {
            this.q = true;
            this.f.postDelayed(new ab(this), ap.L);
            this.s = true;
        }
    }

    public void a() {
        if (this.m) {
            return;
        }
        this.g = (WifiManager) this.e.getSystemService("wifi");
        this.h = new z(this);
        try {
            this.e.registerReceiver(this.h, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            this.i = new y(this);
            if (ap.a) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.e.registerReceiver(this.i, intentFilter);
                this.r = true;
                l();
            }
        } catch (Exception e) {
        }
        this.m = true;
        ap.a(a, "wifimanager start ...");
        try {
            Field declaredField = Class.forName("android.net.wifi.WifiManager").getDeclaredField("mService");
            if (declaredField == null) {
                ap.a(a, "android.net.wifi.WifiManager.mService  NOT  found ...");
            } else {
                declaredField.setAccessible(true);
                this.n = declaredField.get(this.g);
                Class<?> cls = this.n.getClass();
                ap.a(a, "mserviceClass : " + cls.getName());
                this.o = cls.getDeclaredMethod("startScan", Boolean.TYPE);
                if (this.o == null) {
                    ap.a(a, "mService.startScan NOT  found ...");
                } else {
                    this.o.setAccessible(true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b() {
        if (this.i == null) {
            this.i = new y(this);
        }
        try {
            if (!ap.a || this.r) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.e.registerReceiver(this.i, intentFilter);
            l();
            this.r = true;
        } catch (Exception e) {
        }
    }

    public void c() {
        if (this.m) {
            try {
                this.e.unregisterReceiver(this.h);
                if (ap.a) {
                    this.e.unregisterReceiver(this.i);
                }
            } catch (Exception e) {
            }
            this.h = null;
            this.g = null;
            this.i = null;
            this.m = false;
            ap.a(a, "wifimanager stop ...");
        }
    }

    public boolean d() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.l <= 10000) {
            return false;
        }
        this.l = currentTimeMillis;
        return e();
    }

    public boolean e() {
        if (this.g == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.k > 3000) {
            try {
                if (!this.g.isWifiEnabled()) {
                    this.k = 0L;
                    return false;
                }
                if (this.o == null || this.n == null) {
                    this.g.startScan();
                } else {
                    try {
                        this.o.invoke(this.n, Boolean.valueOf(this.p));
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.g.startScan();
                    }
                }
                this.k = currentTimeMillis;
                ap.a(a, "wifimanager start scan ...");
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
        return false;
    }

    public String f() {
        WifiInfo connectionInfo = this.g.getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                return bssid.replace(":", "");
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public aa g() {
        if ((this.j == null || !this.j.f()) && this.g != null) {
            try {
                return new aa(this, this.g.getScanResults(), 0L);
            } catch (Exception e) {
                return new aa(this, null, 0L);
            }
        }
        return this.j;
    }

    public aa h() {
        if ((this.j == null || !this.j.g()) && this.g != null) {
            try {
                return new aa(this, this.g.getScanResults(), 0L);
            } catch (Exception e) {
                return new aa(this, null, 0L);
            }
        }
        return this.j;
    }

    public void i() {
        if (!this.s && ap.a && ap.k) {
            this.f.postDelayed(new ab(this), ap.L);
            this.s = true;
        }
    }
}
