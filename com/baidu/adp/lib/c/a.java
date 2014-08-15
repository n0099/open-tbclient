package com.baidu.adp.lib.c;

import android.content.Context;
import android.location.Address;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import java.lang.ref.SoftReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private static long b = 10000;
    private static a c = null;
    private static long d = 300000;
    private LocationManager k;
    private boolean e = true;
    private LocationClient f = null;
    private BDLocationListener g = null;
    private String h = "baidu";
    private boolean i = true;
    private int j = 0;
    private Address l = null;
    private f m = null;
    public long a = 0;
    private ArrayList<SoftReference<d>> n = null;
    private Context o = null;
    private Handler p = null;
    private final LocationListener q = new b(this);

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    public void a(Context context, String str) {
        a(context, str, true);
    }

    public void a(Context context, String str, boolean z) {
        if (context == null) {
            throw new InvalidParameterException("context is null");
        }
        this.n = new ArrayList<>();
        this.o = context;
        this.h = str;
        this.i = z;
        b();
        c();
    }

    public void a(boolean z) {
        this.e = z;
    }

    private void b() {
        this.p = new Handler(new c(this));
    }

    private void c() {
        try {
            this.k = (LocationManager) this.o.getSystemService("location");
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        try {
            if (this.e) {
                this.g = new e(this, null);
                LocationClientOption locationClientOption = new LocationClientOption();
                locationClientOption.setOpenGps(true);
                locationClientOption.setProdName(this.h);
                locationClientOption.setAddrType("all");
                locationClientOption.setCoorType("bd09ll");
                locationClientOption.setScanSpan(500);
                locationClientOption.disableCache(this.i);
                this.f = new LocationClient(this.o);
                this.f.registerLocationListener(this.g);
                this.f.setLocOption(locationClientOption);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public Address b(boolean z) {
        if (System.currentTimeMillis() - this.a > d) {
            this.l = null;
        }
        if (this.l != null && !z) {
            return this.l;
        }
        this.l = null;
        e();
        return null;
    }

    public Address a(boolean z, d dVar) {
        boolean z2;
        if (System.currentTimeMillis() - this.a > d) {
            this.l = null;
        }
        if (this.l != null && !z) {
            return this.l;
        }
        if (dVar != null) {
            int i = 0;
            while (true) {
                if (i < this.n.size()) {
                    d dVar2 = this.n.get(i).get();
                    if (dVar2 == null || !dVar2.equals(dVar)) {
                        i++;
                    } else {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (!z2) {
                if (this.n.size() >= 100) {
                    this.n.remove(0);
                }
                this.n.add(new SoftReference<>(dVar));
            }
            e();
        }
        return null;
    }

    public void a(d dVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.n.size()) {
                SoftReference<d> softReference = this.n.get(i2);
                d dVar2 = softReference.get();
                if (dVar2 == null || !dVar2.equals(dVar)) {
                    i = i2 + 1;
                } else {
                    this.n.remove(softReference);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void d() {
        if (this.p.hasMessages(0)) {
            this.p.removeMessages(0);
        }
        if (this.k != null) {
            try {
                this.k.removeUpdates(this.q);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        if (this.f != null && this.f.isStarted()) {
            this.f.stop();
        }
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
    }

    private void e() {
        try {
            this.l = null;
            if (this.p.hasMessages(0)) {
                this.p.removeMessages(0);
            }
            if (this.k != null) {
                this.k.removeUpdates(this.q);
            }
            if (this.e) {
                if (!this.f.isStarted()) {
                    this.f.start();
                }
                this.f.requestLocation();
            }
            this.j = 4;
            if (this.k != null && !this.k.isProviderEnabled("gps") && !this.k.isProviderEnabled("network")) {
                this.j = 3;
                if (!this.e) {
                    this.p.sendMessageDelayed(this.p.obtainMessage(0), 100L);
                    return;
                }
            }
            if (this.k != null && this.k.isProviderEnabled("gps")) {
                this.k.requestLocationUpdates("gps", 10000L, 100.0f, this.q);
            } else {
                this.j = 1;
            }
            if (this.k != null && this.k.isProviderEnabled("network")) {
                this.k.requestLocationUpdates("network", 10000L, 100.0f, this.q);
            } else {
                this.j = 2;
            }
            this.p.sendMessageDelayed(this.p.obtainMessage(0), b);
        } catch (Exception e) {
            d();
            this.j = 5;
            if (this.p.hasMessages(0)) {
                this.p.removeMessages(0);
            }
            this.p.sendMessageDelayed(this.p.obtainMessage(0), 100L);
        }
    }

    public void a(int i, String str, Address address) {
        int i2 = 0;
        if (this.p.hasMessages(0)) {
            this.p.removeMessages(0);
        }
        if (this.n == null) {
            return;
        }
        while (true) {
            int i3 = i2;
            if (i3 < this.n.size()) {
                d dVar = this.n.get(i3).get();
                if (dVar != null) {
                    try {
                        dVar.a(i, str, address);
                    } catch (Throwable th) {
                        BdLog.detailException(th);
                    }
                }
                i2 = i3 + 1;
            } else {
                this.n.clear();
                return;
            }
        }
    }
}
