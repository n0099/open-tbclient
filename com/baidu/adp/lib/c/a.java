package com.baidu.adp.lib.c;

import android.content.Context;
import android.location.Address;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import java.lang.ref.SoftReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a {
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

    public final void a(Context context, String str) {
        if (context == null) {
            throw new InvalidParameterException("context is null");
        }
        this.n = new ArrayList<>();
        this.o = context;
        this.h = str;
        this.i = true;
        this.p = new Handler(new c(this));
        b();
    }

    public final void a(boolean z) {
        this.e = z;
    }

    private void b() {
        try {
            this.k = (LocationManager) this.o.getSystemService("location");
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
        }
        try {
            if (this.e) {
                this.g = new e(this, (byte) 0);
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
            com.baidu.adp.lib.util.f.b(e2.getMessage());
        }
    }

    public final Address b(boolean z) {
        if (System.currentTimeMillis() - this.a > d) {
            this.l = null;
        }
        if (this.l != null) {
            return this.l;
        }
        this.l = null;
        d();
        return null;
    }

    public final Address a(boolean z, d dVar) {
        boolean z2;
        if (System.currentTimeMillis() - this.a > d) {
            this.l = null;
        }
        Address address = this.l;
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
            d();
        }
        return null;
    }

    public void c() {
        if (this.p.hasMessages(0)) {
            this.p.removeMessages(0);
        }
        if (this.k != null) {
            try {
                this.k.removeUpdates(this.q);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("error : " + e.getMessage());
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

    private void d() {
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
            c();
            this.j = 5;
            if (this.p.hasMessages(0)) {
                this.p.removeMessages(0);
            }
            this.p.sendMessageDelayed(this.p.obtainMessage(0), 100L);
        }
    }

    public static /* synthetic */ void a(a aVar, int i, String str, Address address) {
        int i2 = 0;
        if (aVar.p.hasMessages(0)) {
            aVar.p.removeMessages(0);
        }
        if (aVar.n == null) {
            return;
        }
        while (true) {
            int i3 = i2;
            if (i3 >= aVar.n.size()) {
                aVar.n.clear();
                return;
            }
            d dVar = aVar.n.get(i3).get();
            if (dVar != null) {
                dVar.a(i, address);
            }
            i2 = i3 + 1;
        }
    }
}
