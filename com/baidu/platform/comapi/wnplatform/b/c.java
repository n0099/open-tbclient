package com.baidu.platform.comapi.wnplatform.b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.http.Headers;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends com.baidu.platform.comapi.walknavi.a {
    private static GeoPoint f = new GeoPoint(0.0d, 0.0d);
    private List<com.baidu.platform.comapi.wnplatform.b.a> e;
    private Handler h;
    private Context i;
    private long j;
    private com.baidu.platform.comapi.wnplatform.d.a.a a = null;
    private com.baidu.platform.comapi.wnplatform.d.a.a b = new com.baidu.platform.comapi.wnplatform.d.a.a();
    private LocationManager c = null;
    private ArrayList<b> d = new ArrayList<>();
    private boolean g = false;
    private int k = 0;
    private boolean l = false;
    private Location m = null;
    private LocationListener n = new d(this);
    private LocationListener o = new e(this);

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a();
        if (this.h != null) {
            this.h = null;
        }
        this.i = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public synchronized void a(Context context) {
        this.i = context;
        if (this.c == null) {
            this.c = (LocationManager) context.getSystemService(Headers.LOCATION);
        }
        this.h = new a(this, null);
        MessageCenter.registMessage(4103, this.h);
        this.j = System.currentTimeMillis();
    }

    public synchronized void a() {
        MessageCenter.unregistMessage(4103, this.h);
        e();
    }

    public void a(b bVar) {
        this.d.add(bVar);
    }

    public void a(com.baidu.platform.comapi.wnplatform.b.a aVar) {
        if (this.e == null) {
            this.e = new LinkedList();
        }
        this.e.add(aVar);
    }

    public void b(com.baidu.platform.comapi.wnplatform.b.a aVar) {
        if (this.e != null && aVar != null) {
            this.e.remove(aVar);
        }
    }

    public com.baidu.platform.comapi.wnplatform.d.a.a b() {
        com.baidu.platform.comapi.wnplatform.d.a.a aVar;
        synchronized (this.b) {
            this.a = this.b.clone();
            aVar = this.a;
        }
        return aVar;
    }

    public GeoPoint c() {
        return new GeoPoint(f.getLatitudeE6(), f.getLongitudeE6());
    }

    public boolean d() {
        if (this.c == null) {
            return false;
        }
        try {
            return this.c.isProviderEnabled("gps");
        } catch (Exception e) {
            com.baidu.platform.comapi.wnplatform.c.a.b(e.getMessage());
            return false;
        }
    }

    public synchronized void b(Context context) {
        c(context);
    }

    public synchronized void e() {
        try {
            if (this.c != null) {
                this.c.removeUpdates(this.n);
                if (this.o != null) {
                    this.c.removeUpdates(this.o);
                }
            }
        } catch (Exception e) {
        }
        this.g = false;
        this.c = null;
    }

    private void c(Context context) {
        if (context != null) {
            try {
                this.g = false;
                if (this.c == null) {
                    this.c = (LocationManager) context.getSystemService(Headers.LOCATION);
                }
                this.c.requestLocationUpdates("gps", 0L, 0.0f, this.n);
                this.c.requestLocationUpdates("network", 0L, 0.0f, this.o);
                this.m = this.c.getLastKnownLocation("network");
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        this.b.a = location.getLatitude();
        this.b.b = location.getLongitude();
        this.b.c = location.getSpeed();
        this.b.e = Math.min(2000.0f, location.getAccuracy());
        this.b.d = location.getBearing();
        this.b.g = location.getAltitude();
        this.b.h = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends Handler {
        private a() {
        }

        /* synthetic */ a(c cVar, d dVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 4103) {
                if (c.this.e != null) {
                    for (com.baidu.platform.comapi.wnplatform.b.a aVar : c.this.e) {
                        if (aVar != null) {
                            aVar.a(message);
                        }
                    }
                }
                if (message.arg1 == 0) {
                    c.this.g = false;
                }
            }
        }
    }

    public void a(com.baidu.platform.comapi.wnplatform.d.a.a aVar) {
        if (!this.g && aVar.e < 80.0f) {
            b(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.platform.comapi.wnplatform.d.a.a aVar) {
        ArrayList arrayList;
        this.a = aVar.clone();
        GeoPoint a2 = com.baidu.platform.comapi.wnplatform.o.b.a(aVar.b, aVar.a);
        f.setLongitudeE6(a2.getLongitudeE6());
        f.setLatitudeE6(a2.getLatitudeE6());
        synchronized (this.d) {
            arrayList = new ArrayList(this.d);
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null) {
                    bVar.a(this.a);
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
