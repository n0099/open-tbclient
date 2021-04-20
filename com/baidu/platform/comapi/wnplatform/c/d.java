package com.baidu.platform.comapi.wnplatform.c;

import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: f  reason: collision with root package name */
    public List<com.baidu.platform.comapi.wnplatform.c.a> f9810f;
    public c i;
    public Handler j;
    public Context k;
    public long l;

    /* renamed from: g  reason: collision with root package name */
    public static GeoPoint f9805g = new GeoPoint(0.0d, 0.0d);

    /* renamed from: a  reason: collision with root package name */
    public static int f9804a = 0;

    /* renamed from: b  reason: collision with root package name */
    public WLocData f9806b = null;

    /* renamed from: c  reason: collision with root package name */
    public WLocData f9807c = new WLocData();

    /* renamed from: d  reason: collision with root package name */
    public LocationManager f9808d = null;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<b> f9809e = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public boolean f9811h = false;
    public long m = 0;
    public int n = 2;
    public int o = 0;
    public int p = 0;
    public long q = 0;
    public GpsStatus.Listener r = new e(this);
    public int s = 0;
    public boolean t = false;
    public Location u = null;
    public LocationListener v = new f(this);
    public LocationListener w = new g(this);

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 4103) {
                if (d.this.f9810f != null) {
                    for (com.baidu.platform.comapi.wnplatform.c.a aVar : d.this.f9810f) {
                        if (aVar != null) {
                            aVar.a(message);
                        }
                    }
                }
                if (message.arg1 == 0) {
                    d.this.f9811h = false;
                }
            }
        }

        public /* synthetic */ a(d dVar, e eVar) {
            this();
        }
    }

    private void e() {
        this.q = 0L;
        this.p = 0;
        this.o = 0;
        this.m = 0L;
        this.n = 2;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a();
        if (this.j != null) {
            this.j = null;
        }
        this.k = null;
    }

    public boolean c() {
        LocationManager locationManager = this.f9808d;
        if (locationManager == null) {
            return false;
        }
        try {
            return locationManager.isProviderEnabled("gps");
        } catch (Exception e2) {
            com.baidu.platform.comapi.wnplatform.d.a.b(e2.getMessage());
            return false;
        }
    }

    public synchronized void d() {
        try {
            if (this.f9808d != null) {
                this.f9808d.removeUpdates(this.v);
            }
        } catch (Exception unused) {
        }
        try {
            if (this.f9808d != null) {
                this.f9808d.removeGpsStatusListener(this.r);
            }
        } catch (Exception e2) {
            com.baidu.platform.comapi.wnplatform.d.a.b(e2.getMessage());
        }
        this.f9811h = false;
        this.v = null;
        this.r = null;
        this.f9808d = null;
    }

    public void b(com.baidu.platform.comapi.wnplatform.c.a aVar) {
        List<com.baidu.platform.comapi.wnplatform.c.a> list = this.f9810f;
        if (list == null || aVar == null) {
            return;
        }
        list.remove(aVar);
    }

    private void c(Context context) {
        if (context == null) {
            return;
        }
        try {
            this.f9811h = false;
            if (this.f9808d == null) {
                this.f9808d = (LocationManager) context.getSystemService("location");
            }
            this.f9808d.requestLocationUpdates("gps", 0L, 0.0f, this.v);
            this.f9808d.addGpsStatusListener(this.r);
            e();
        } catch (Exception unused) {
        }
    }

    public GeoPoint b() {
        return new GeoPoint(f9805g.getLatitudeE6(), f9805g.getLongitudeE6());
    }

    public synchronized void b(Context context) {
        c(context);
    }

    public synchronized void a(Context context) {
        this.k = context;
        if (this.f9808d == null) {
            this.f9808d = (LocationManager) context.getSystemService("location");
        }
        a aVar = new a(this, null);
        this.j = aVar;
        MessageCenter.registMessage(4103, aVar);
        this.l = System.currentTimeMillis();
    }

    public synchronized void a() {
        MessageCenter.unregistMessage(4103, this.j);
        d();
        if (this.f9809e != null) {
            this.f9809e.clear();
        }
        if (this.f9810f != null) {
            this.f9810f.clear();
        }
        this.f9806b = null;
        this.f9807c = null;
    }

    public void a(b bVar) {
        this.f9809e.add(bVar);
    }

    public void a(c cVar) {
        this.i = cVar;
        f9804a = 0;
    }

    public void a(com.baidu.platform.comapi.wnplatform.c.a aVar) {
        if (this.f9810f == null) {
            this.f9810f = new LinkedList();
        }
        this.f9810f.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        this.f9807c.latitude = location.getLatitude();
        this.f9807c.longitude = location.getLongitude();
        this.f9807c.speed = location.getSpeed();
        this.f9807c.accuracy = Math.min(2000.0f, location.getAccuracy());
        this.f9807c.direction = location.getBearing();
        this.f9807c.altitude = location.getAltitude();
        this.f9807c.coordType = 0;
    }

    public void a(WLocData wLocData) {
        c cVar;
        com.baidu.platform.comapi.wnplatform.a.a().d();
        if (wLocData.accuracy < 80.0f) {
            WLocData m13clone = wLocData.m13clone();
            this.f9807c = m13clone;
            a(m13clone, "sdk");
            if (wLocData.isIndoorMode) {
                int i = f9804a + 1;
                f9804a = i;
                if (i <= 3 || (cVar = this.i) == null) {
                    return;
                }
                cVar.a();
                return;
            }
            f9804a = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WLocData wLocData, String str) {
        ArrayList arrayList;
        this.f9806b = wLocData.m13clone();
        GeoPoint a2 = com.baidu.platform.comapi.wnplatform.o.b.a(wLocData.longitude, wLocData.latitude);
        f9805g.setLongitudeE6(a2.getLongitudeE6());
        f9805g.setLatitudeE6(a2.getLatitudeE6());
        synchronized (this.f9809e) {
            arrayList = new ArrayList(this.f9809e);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null) {
                bVar.a(this.f9806b);
            }
        }
    }

    public boolean a(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > AppConfig.TIMESTAMP_AVAILABLE_DURATION;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean a2 = a(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && a2;
        }
        return true;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }
}
