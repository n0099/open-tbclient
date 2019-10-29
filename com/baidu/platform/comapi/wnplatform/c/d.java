package com.baidu.platform.comapi.wnplatform.c;

import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.http.Headers;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class d extends com.baidu.platform.comapi.walknavi.a {
    private List<com.baidu.platform.comapi.wnplatform.c.a> f;
    private c i;
    private Handler j;
    private Context k;
    private long l;
    private static GeoPoint g = new GeoPoint(0.0d, 0.0d);
    public static int a = 0;
    private WLocData b = null;
    private WLocData c = new WLocData();
    private LocationManager d = null;
    private ArrayList<b> e = new ArrayList<>();
    private boolean h = false;
    private long m = 0;
    private int n = 2;
    private int o = 0;
    private int p = 0;
    private long q = 0;
    private GpsStatus.Listener r = new e(this);
    private int s = 0;
    private boolean t = false;
    private Location u = null;
    private LocationListener v = new f(this);
    private LocationListener w = new g(this);

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a();
        if (this.j != null) {
            this.j = null;
        }
        this.k = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public synchronized void a(Context context) {
        this.k = context;
        if (this.d == null) {
            this.d = (LocationManager) context.getSystemService(Headers.LOCATION);
        }
        this.j = new a(this, null);
        MessageCenter.registMessage(4103, this.j);
        this.l = System.currentTimeMillis();
    }

    public synchronized void a() {
        MessageCenter.unregistMessage(4103, this.j);
        d();
        if (this.e != null) {
            this.e.clear();
        }
        if (this.f != null) {
            this.f.clear();
        }
        this.b = null;
        this.c = null;
    }

    public void a(b bVar) {
        this.e.add(bVar);
    }

    public void a(c cVar) {
        this.i = cVar;
        a = 0;
    }

    public void a(com.baidu.platform.comapi.wnplatform.c.a aVar) {
        if (this.f == null) {
            this.f = new LinkedList();
        }
        this.f.add(aVar);
    }

    public void b(com.baidu.platform.comapi.wnplatform.c.a aVar) {
        if (this.f != null && aVar != null) {
            this.f.remove(aVar);
        }
    }

    public GeoPoint b() {
        return new GeoPoint(g.getLatitudeE6(), g.getLongitudeE6());
    }

    public boolean c() {
        if (this.d == null) {
            return false;
        }
        try {
            return this.d.isProviderEnabled("gps");
        } catch (Exception e) {
            com.baidu.platform.comapi.wnplatform.d.a.b(e.getMessage());
            return false;
        }
    }

    public synchronized void b(Context context) {
        c(context);
    }

    public synchronized void d() {
        try {
            if (this.d != null) {
                this.d.removeUpdates(this.v);
            }
        } catch (Exception e) {
        }
        try {
            if (this.d != null) {
                this.d.removeGpsStatusListener(this.r);
            }
        } catch (Exception e2) {
            com.baidu.platform.comapi.wnplatform.d.a.b(e2.getMessage());
        }
        this.h = false;
        this.v = null;
        this.r = null;
        this.d = null;
    }

    private void c(Context context) {
        if (context != null) {
            try {
                this.h = false;
                if (this.d == null) {
                    this.d = (LocationManager) context.getSystemService(Headers.LOCATION);
                }
                this.d.requestLocationUpdates("gps", 0L, 0.0f, this.v);
                this.d.addGpsStatusListener(this.r);
                e();
            } catch (Exception e) {
            }
        }
    }

    private void e() {
        this.q = 0L;
        this.p = 0;
        this.o = 0;
        this.m = 0L;
        this.n = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        this.c.latitude = location.getLatitude();
        this.c.longitude = location.getLongitude();
        this.c.speed = location.getSpeed();
        this.c.accuracy = Math.min(2000.0f, location.getAccuracy());
        this.c.direction = location.getBearing();
        this.c.altitude = location.getAltitude();
        this.c.coordType = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a extends Handler {
        private a() {
        }

        /* synthetic */ a(d dVar, e eVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 4103) {
                if (d.this.f != null) {
                    for (com.baidu.platform.comapi.wnplatform.c.a aVar : d.this.f) {
                        if (aVar != null) {
                            aVar.a(message);
                        }
                    }
                }
                if (message.arg1 == 0) {
                    d.this.h = false;
                }
            }
        }
    }

    public void a(WLocData wLocData) {
        if (com.baidu.platform.comapi.wnplatform.a.a().d() || this.h) {
        }
        if (wLocData.accuracy < 80.0f) {
            this.c = wLocData.m15clone();
            a(this.c, "sdk");
            if (wLocData.isIndoorMode) {
                a++;
                if (a > 3 && this.i != null) {
                    this.i.a();
                    return;
                }
                return;
            }
            a = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WLocData wLocData, String str) {
        ArrayList arrayList;
        this.b = wLocData.m15clone();
        GeoPoint a2 = com.baidu.platform.comapi.wnplatform.o.b.a(wLocData.longitude, wLocData.latitude);
        g.setLongitudeE6(a2.getLongitudeE6());
        g.setLatitudeE6(a2.getLatitudeE6());
        synchronized (this.e) {
            arrayList = new ArrayList(this.e);
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null) {
                    bVar.a(this.b);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
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
