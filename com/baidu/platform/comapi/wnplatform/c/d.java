package com.baidu.platform.comapi.wnplatform.c;

import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapsdkplatform.comapi.map.MessageCenter;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class d extends com.baidu.platform.comapi.walknavi.a {
    private List<com.baidu.platform.comapi.wnplatform.c.a> f;
    private c j;
    private Handler k;
    private Context l;
    private long m;
    private static GeoPoint g = new GeoPoint(0.0d, 0.0d);

    /* renamed from: a  reason: collision with root package name */
    public static int f3099a = 0;
    private WLocData b = null;
    private WLocData c = new WLocData();
    private LocationManager d = null;
    private ArrayList<b> e = new ArrayList<>();
    private boolean h = false;
    private boolean i = false;
    private long n = 0;
    private int o = 2;
    private int p = 0;
    private int q = 0;
    private long r = 0;
    private GpsStatus.Listener s = new e(this);
    private int t = 0;
    private boolean u = false;
    private Location v = null;
    private LocationListener w = new f(this);
    private LocationListener x = new g(this);

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a();
        if (this.k != null) {
            this.k = null;
        }
        this.l = null;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    public synchronized void a(Context context) {
        this.l = context;
        if (this.d == null) {
            this.d = (LocationManager) context.getSystemService("location");
        }
        this.k = new a(this, null);
        MessageCenter.registMessage(4103, this.k);
        this.m = System.currentTimeMillis();
    }

    public synchronized void a() {
        MessageCenter.unregistMessage(4103, this.k);
        d();
        if (this.e != null) {
            this.e.clear();
        }
        if (this.f != null) {
            this.f.clear();
        }
    }

    public void a(b bVar) {
        this.e.add(bVar);
    }

    public void a(c cVar) {
        this.j = cVar;
        f3099a = 0;
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

    public void b(b bVar) {
        this.e.remove(bVar);
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
                this.d.removeUpdates(this.w);
            }
        } catch (Exception e) {
        }
        try {
            if (this.d != null) {
                this.d.removeGpsStatusListener(this.s);
            }
        } catch (Exception e2) {
            com.baidu.platform.comapi.wnplatform.d.a.b(e2.getMessage());
        }
        this.h = false;
        this.w = null;
        this.s = null;
        this.d = null;
    }

    private void c(Context context) {
        if (context != null) {
            try {
                this.h = false;
                if (this.d == null) {
                    this.d = (LocationManager) context.getSystemService("location");
                } else {
                    this.d.removeUpdates(this.w);
                }
                this.d.requestLocationUpdates("gps", 0L, 0.0f, this.w);
                this.d.addGpsStatusListener(this.s);
                e();
            } catch (Exception e) {
            }
        }
    }

    private void e() {
        this.r = 0L;
        this.q = 0;
        this.p = 0;
        this.n = 0L;
        this.o = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        if (location != null && this.c != null) {
            this.c.latitude = location.getLatitude();
            this.c.longitude = location.getLongitude();
            this.c.speed = location.getSpeed();
            this.c.accuracy = Math.min(2000.0f, location.getAccuracy());
            this.c.direction = location.getBearing();
            this.c.altitude = location.getAltitude();
            this.c.coordType = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
        this.i = true;
        if (com.baidu.platform.comapi.wnplatform.a.a().d() || this.h) {
        }
        if (wLocData.accuracy < 80.0f) {
            try {
                this.c = wLocData.m30clone();
                a(this.c, CashierData.SDK);
                if (wLocData.isIndoorMode) {
                    f3099a++;
                    if (f3099a > 3 && this.j != null) {
                        this.j.a();
                        return;
                    }
                    return;
                }
                f3099a = 0;
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WLocData wLocData, String str) {
        ArrayList arrayList;
        if (wLocData != null) {
            try {
                this.b = wLocData.m30clone();
                GeoPoint geoPoint = null;
                if (wLocData.coordType == 0) {
                    geoPoint = com.baidu.platform.comapi.wnplatform.p.b.a(wLocData.longitude, wLocData.latitude);
                } else if (wLocData.coordType == 3) {
                    geoPoint = new GeoPoint((int) (wLocData.latitude * 100000.0d), (int) (wLocData.longitude * 100000.0d));
                } else if (wLocData.coordType == 2) {
                    geoPoint = new GeoPoint(wLocData.latitude, wLocData.longitude);
                }
                if (geoPoint != null) {
                    g.setLongitudeE6(geoPoint.getLongitudeE6());
                    g.setLatitudeE6(geoPoint.getLatitudeE6());
                }
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
            } catch (Exception e) {
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
