package com.baidu.location.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.a.u;
import com.baidu.location.a.w;
import com.baidu.location.a.x;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes2.dex */
public class e {
    public static String A = null;
    public static double E = 100.0d;
    public static String F = "";

    /* renamed from: a  reason: collision with root package name */
    public static e f6662a;
    public static int n;
    public static int o;
    public static int p;
    public static long q;
    public int C;
    public int D;

    /* renamed from: b  reason: collision with root package name */
    public Context f6663b;

    /* renamed from: d  reason: collision with root package name */
    public Location f6665d;

    /* renamed from: g  reason: collision with root package name */
    public GpsStatus f6668g;

    /* renamed from: h  reason: collision with root package name */
    public a f6669h;
    public boolean i;

    /* renamed from: c  reason: collision with root package name */
    public LocationManager f6664c = null;

    /* renamed from: e  reason: collision with root package name */
    public c f6666e = null;

    /* renamed from: f  reason: collision with root package name */
    public C0092e f6667f = null;
    public b j = null;
    public boolean k = false;
    public d l = null;
    public OnNmeaMessageListener m = null;
    public long r = 0;
    public boolean s = false;
    public boolean t = false;
    public String u = null;
    public boolean v = false;
    public long w = 0;
    public double x = -1.0d;
    public double y = 0.0d;
    public double z = 0.0d;
    public Handler B = null;
    public long G = 0;
    public ArrayList<ArrayList<Float>> H = new ArrayList<>();

    @TargetApi(24)
    /* loaded from: classes2.dex */
    public class a extends GnssStatus.Callback {
        public a() {
        }

        public /* synthetic */ a(e eVar, f fVar) {
            this();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            if (e.this.f6664c == null) {
                return;
            }
            int satelliteCount = gnssStatus.getSatelliteCount();
            e.this.H.clear();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < satelliteCount; i4++) {
                ArrayList arrayList = new ArrayList();
                i3++;
                if (gnssStatus.usedInFix(i4)) {
                    i++;
                    if (gnssStatus.getConstellationType(i4) == 1) {
                        i2++;
                        arrayList.add(Float.valueOf(gnssStatus.getCn0DbHz(i4)));
                        arrayList.add(Float.valueOf(0.0f));
                        arrayList.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i4)));
                        arrayList.add(Float.valueOf(gnssStatus.getElevationDegrees(i4)));
                        arrayList.add(Float.valueOf(1.0f));
                    }
                    e.this.H.add(arrayList);
                }
            }
            int unused = e.n = i;
            int unused2 = e.o = i2;
            int unused3 = e.p = i3;
            long unused4 = e.q = System.currentTimeMillis();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            e.this.d((Location) null);
            e.this.b(false);
            int unused = e.n = 0;
            int unused2 = e.o = 0;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements GpsStatus.Listener {

        /* renamed from: b  reason: collision with root package name */
        public long f6672b;

        public b() {
            this.f6672b = 0L;
        }

        public /* synthetic */ b(e eVar, f fVar) {
            this();
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            long currentTimeMillis;
            if (e.this.f6664c == null) {
                return;
            }
            int i2 = 0;
            if (i == 2) {
                e.this.d((Location) null);
                e.this.b(false);
                int unused = e.n = 0;
                int unused2 = e.o = 0;
            } else if (i == 4 && e.this.t) {
                try {
                    if (e.this.f6668g == null) {
                        e.this.f6668g = e.this.f6664c.getGpsStatus(null);
                    } else {
                        e.this.f6664c.getGpsStatus(e.this.f6668g);
                    }
                    e.this.C = 0;
                    e.this.D = 0;
                    double d2 = 0.0d;
                    e.this.H.clear();
                    int i3 = 0;
                    for (GpsSatellite gpsSatellite : e.this.f6668g.getSatellites()) {
                        ArrayList arrayList = new ArrayList();
                        new ArrayList();
                        if (gpsSatellite.usedInFix()) {
                            i3++;
                            if (gpsSatellite.getPrn() <= 65) {
                                i2++;
                                d2 += gpsSatellite.getSnr();
                                arrayList.add(Float.valueOf(0.0f));
                                arrayList.add(Float.valueOf(gpsSatellite.getSnr()));
                                arrayList.add(Float.valueOf(gpsSatellite.getAzimuth()));
                                arrayList.add(Float.valueOf(gpsSatellite.getElevation()));
                                arrayList.add(Float.valueOf(1.0f));
                            }
                            e.this.H.add(arrayList);
                            if (gpsSatellite.getSnr() >= com.baidu.location.d.j.H) {
                                e.f(e.this);
                            }
                        }
                    }
                    if (i2 > 0) {
                        int unused3 = e.o = i2;
                        double unused4 = e.E = d2 / i2;
                    }
                    if (i3 <= 0) {
                        if (System.currentTimeMillis() - this.f6672b > 100) {
                            currentTimeMillis = System.currentTimeMillis();
                        }
                        long unused5 = e.q = System.currentTimeMillis();
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    this.f6672b = currentTimeMillis;
                    int unused6 = e.n = i3;
                    long unused52 = e.q = System.currentTimeMillis();
                } catch (Exception unused7) {
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements LocationListener {
        public c() {
        }

        public /* synthetic */ c(e eVar, f fVar) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            e.this.w = System.currentTimeMillis();
            e.this.b(true);
            e.this.d(location);
            e.this.s = false;
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            e.this.d((Location) null);
            e.this.b(false);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0) {
                e.this.d((Location) null);
            } else if (i != 1) {
                if (i != 2) {
                    return;
                }
                e.this.s = false;
                return;
            } else {
                e.this.r = System.currentTimeMillis();
                e.this.s = true;
            }
            e.this.b(false);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements GpsStatus.NmeaListener {
        public d() {
        }

        public /* synthetic */ d(e eVar, f fVar) {
            this();
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            if (e.this.b(str)) {
                e.this.a(str);
            }
        }
    }

    /* renamed from: com.baidu.location.b.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0092e implements LocationListener {

        /* renamed from: b  reason: collision with root package name */
        public long f6676b;

        public C0092e() {
            this.f6676b = 0L;
        }

        public /* synthetic */ C0092e(e eVar, f fVar) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!e.this.t && location != null && location.getProvider() == "gps" && System.currentTimeMillis() - this.f6676b >= 10000 && w.a(location, false)) {
                this.f6676b = System.currentTimeMillis();
                e.this.B.sendMessage(e.this.B.obtainMessage(4, location));
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public e() {
        this.i = false;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.i = true;
            } catch (ClassNotFoundException unused) {
                this.i = false;
            }
        }
    }

    public static int a(String str, String str2) {
        char charAt = str2.charAt(0);
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (Character.valueOf(charAt).equals(Character.valueOf(str.charAt(i2)))) {
                i++;
            }
        }
        return i;
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f6662a == null) {
                f6662a = new e();
            }
            eVar = f6662a;
        }
        return eVar;
    }

    public static String a(Location location) {
        if (location == null) {
            return null;
        }
        float speed = (float) (location.getSpeed() * 3.6d);
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d&ll_snr=%.1f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(location.hasBearing() ? location.getBearing() : -1.0f), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)), Integer.valueOf(n), Double.valueOf(location.hasAltitude() ? location.getAltitude() : 555.0d), Long.valueOf(location.getTime() / 1000), Integer.valueOf(n), Integer.valueOf(o), Double.valueOf(E));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Location location) {
        if (location == null) {
            return;
        }
        String str2 = str + com.baidu.location.a.a.a().c();
        boolean e2 = i.a().e();
        u.a(new com.baidu.location.b.a(com.baidu.location.b.b.a().f()));
        u.a(System.currentTimeMillis());
        u.a(new Location(location));
        u.a(str2);
        if (e2) {
            return;
        }
        w.a(u.c(), null, u.d(), str2);
    }

    public static boolean a(Location location, Location location2, boolean z) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (!z || ((com.baidu.location.d.j.v != 3 && com.baidu.location.d.d.a().a(location2.getLongitude(), location2.getLatitude())) || speed >= 5.0f)) {
            float distanceTo = location2.distanceTo(location);
            return speed > com.baidu.location.d.j.L ? distanceTo > com.baidu.location.d.j.N : speed > com.baidu.location.d.j.K ? distanceTo > com.baidu.location.d.j.M : distanceTo > 5.0f;
        }
        return true;
    }

    public static String b(Location location) {
        String a2 = a(location);
        if (a2 != null) {
            return a2 + "&g_tp=0";
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.v = z;
        if (!z || !i()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        int i;
        if (str.indexOf("*") != -1 && str.indexOf("$") != -1 && str.indexOf("$") <= str.indexOf("*") && str.length() >= str.indexOf("*")) {
            byte[] bytes = str.substring(0, str.indexOf("*")).getBytes();
            int i2 = bytes[1];
            for (int i3 = 2; i3 < bytes.length; i3++) {
                i2 ^= bytes[i3];
            }
            String format = String.format("%02x", Integer.valueOf(i2));
            int indexOf = str.indexOf("*");
            if (indexOf != -1 && str.length() >= (i = indexOf + 3) && format.equalsIgnoreCase(str.substring(indexOf + 1, i))) {
                return true;
            }
        }
        return false;
    }

    public static String c(Location location) {
        String a2 = a(location);
        if (a2 != null) {
            return a2 + A;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Location location) {
        this.B.sendMessage(this.B.obtainMessage(1, location));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        Location location2 = null;
        if (location == null) {
            this.f6665d = null;
            return;
        }
        int i = n;
        if (i == 0) {
            try {
                i = location.getExtras().getInt("satellites");
            } catch (Exception unused) {
            }
        }
        if (i != 0 || com.baidu.location.d.j.m) {
            if (this.k && location.getSpeed() == 0.0d && this.y != 0.0d && System.currentTimeMillis() - this.z < 2000.0d) {
                location.setSpeed((float) this.y);
            }
            this.f6665d = location;
            int i2 = n;
            if (location == null) {
                this.u = null;
            } else {
                location2 = new Location(this.f6665d);
                long currentTimeMillis = System.currentTimeMillis();
                this.f6665d.setTime(currentTimeMillis);
                float speed = (float) (this.f6665d.getSpeed() * 3.6d);
                if (!this.f6665d.hasSpeed()) {
                    speed = -1.0f;
                }
                if (i2 == 0) {
                    try {
                        i2 = this.f6665d.getExtras().getInt("satellites");
                    } catch (Exception unused2) {
                    }
                }
                this.u = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.f6665d.getLongitude()), Double.valueOf(this.f6665d.getLatitude()), Float.valueOf(speed), Float.valueOf(this.f6665d.getBearing()), Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
            }
            if (i() && this.f6665d != null) {
                F = k();
                com.baidu.location.a.a.a().a(f());
                if (n > 2 && w.a(this.f6665d, true)) {
                    boolean e2 = i.a().e();
                    u.a(new com.baidu.location.b.a(com.baidu.location.b.b.a().f()));
                    u.a(System.currentTimeMillis());
                    u.a(new Location(this.f6665d));
                    u.a(com.baidu.location.a.a.a().c());
                    if (!e2) {
                        x.a().b();
                    }
                }
            }
            x.a().a(location2, n);
        }
    }

    public static /* synthetic */ int f(e eVar) {
        int i = eVar.D;
        eVar.D = i + 1;
        return i;
    }

    public static String j() {
        long currentTimeMillis = System.currentTimeMillis() - q;
        if (currentTimeMillis < 0 || currentTimeMillis >= 3000) {
            return null;
        }
        return String.format(Locale.US, "&gsvn=%d&gsfn=%d", Integer.valueOf(p), Integer.valueOf(n));
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        if (this.H.size() > 32 || this.H.size() == 0) {
            return sb.toString();
        }
        Iterator<ArrayList<Float>> it = this.H.iterator();
        boolean z = true;
        while (it.hasNext()) {
            ArrayList<Float> next = it.next();
            if (next.size() == 5) {
                if (z) {
                    z = false;
                } else {
                    sb.append(FieldBuilder.SE);
                }
                sb.append(String.format("%.1f;", next.get(0)));
                sb.append(String.format("%.1f;", next.get(2)));
                sb.append(String.format("%.0f;", next.get(2)));
                sb.append(String.format("%.0f;", next.get(3)));
                sb.append(String.format("%.0f", next.get(4)));
            }
        }
        return sb.toString();
    }

    public void a(String str) {
        if (str.length() != 0 && b(str)) {
            if (str.startsWith("$GPPWR,") || str.startsWith("$GNGST,") || str.startsWith("$GPGST,") || str.startsWith("$GLGSV,") || str.startsWith("$GNGSV,") || str.startsWith("$BDGSV,") || str.startsWith("$GPZDA,") || str.startsWith("$GPGSA,") || str.startsWith("$GNVTG,") || str.startsWith("$GPVTG,") || str.startsWith("$GNGSA,") || str.startsWith("$GPNTR,") || str.startsWith("$GNGGA,") || str.startsWith("$GPGGA,") || str.startsWith("$GPRMC,") || str.startsWith("$GPGSV,") || str.startsWith("$BDGSA,")) {
                String[] split = str.split(",");
                a(str, ",");
                if (split != null && split.length > 0) {
                    if ((split[0].equalsIgnoreCase("$GPRMC") || split[0].equalsIgnoreCase("$GNRMC") || split[0].equalsIgnoreCase("$GLRMC") || split[0].equalsIgnoreCase("$BDRMC")) && split.length > 7 && split[7].trim().length() > 0) {
                        this.y = ((Double.valueOf(split[7]).doubleValue() * 1.852d) / 3600.0d) * 1000.0d;
                        this.z = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            c();
        } else {
            d();
        }
    }

    public synchronized void b() {
        if (com.baidu.location.f.isServing) {
            Context serviceContext = com.baidu.location.f.getServiceContext();
            this.f6663b = serviceContext;
            try {
                this.f6664c = (LocationManager) serviceContext.getSystemService("location");
                if (this.i) {
                    a aVar = new a(this, null);
                    this.f6669h = aVar;
                    this.f6664c.registerGnssStatusCallback(aVar);
                } else {
                    b bVar = new b(this, null);
                    this.j = bVar;
                    this.f6664c.addGpsStatusListener(bVar);
                }
                if (this.k) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        f fVar = new f(this);
                        this.m = fVar;
                        this.f6664c.addNmeaListener(fVar);
                    } else {
                        d dVar = new d(this, null);
                        this.l = dVar;
                        this.f6664c.addNmeaListener(dVar);
                    }
                }
                C0092e c0092e = new C0092e(this, null);
                this.f6667f = c0092e;
                this.f6664c.requestLocationUpdates("passive", 9000L, 0.0f, c0092e);
            } catch (Exception unused) {
            }
            this.B = new g(this);
        }
    }

    public void c() {
        Log.d(com.baidu.location.d.a.f6704a, "start gps...");
        if (this.t) {
            return;
        }
        try {
            this.f6666e = new c(this, null);
            try {
                this.f6664c.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
            } catch (Exception unused) {
            }
            this.f6664c.requestLocationUpdates("gps", 1000L, 0.0f, this.f6666e);
            this.G = System.currentTimeMillis();
            this.t = true;
        } catch (Exception unused2) {
        }
    }

    public void d() {
        if (this.t) {
            LocationManager locationManager = this.f6664c;
            if (locationManager != null) {
                try {
                    if (this.f6666e != null) {
                        locationManager.removeUpdates(this.f6666e);
                    }
                } catch (Exception unused) {
                }
            }
            com.baidu.location.d.j.f6753d = 0;
            com.baidu.location.d.j.v = 0;
            this.f6666e = null;
            this.t = false;
            b(false);
        }
    }

    public synchronized void e() {
        d();
        if (this.f6664c == null) {
            return;
        }
        try {
            if (this.j != null) {
                this.f6664c.removeGpsStatusListener(this.j);
            }
            if (this.i && this.f6669h != null) {
                this.f6664c.unregisterGnssStatusCallback(this.f6669h);
            }
            if (this.k && this.l != null) {
                this.f6664c.removeNmeaListener(this.l);
            }
            this.f6664c.removeUpdates(this.f6667f);
        } catch (Exception unused) {
        }
        this.j = null;
        this.f6664c = null;
    }

    public String f() {
        boolean z;
        StringBuilder sb;
        String str;
        if (this.f6665d != null) {
            String str2 = "{\"result\":{\"time\":\"" + com.baidu.location.d.j.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
            int accuracy = (int) (this.f6665d.hasAccuracy() ? this.f6665d.getAccuracy() : 10.0f);
            float speed = (float) (this.f6665d.getSpeed() * 3.6d);
            if (!this.f6665d.hasSpeed()) {
                speed = -1.0f;
            }
            double[] dArr = new double[2];
            if (com.baidu.location.d.d.a().a(this.f6665d.getLongitude(), this.f6665d.getLatitude())) {
                dArr = Jni.coorEncrypt(this.f6665d.getLongitude(), this.f6665d.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                if (dArr[0] <= 0.0d && dArr[1] <= 0.0d) {
                    dArr[0] = this.f6665d.getLongitude();
                    dArr[1] = this.f6665d.getLatitude();
                }
                z = true;
            } else {
                dArr[0] = this.f6665d.getLongitude();
                dArr[1] = this.f6665d.getLatitude();
                z = false;
            }
            String format = String.format(Locale.CHINA, str2, Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.f6665d.getBearing()), Float.valueOf(speed), Integer.valueOf(n));
            if (!z) {
                format = format + ",\"in_cn\":\"0\"";
            }
            if (this.f6665d.hasAltitude()) {
                sb = new StringBuilder();
                sb.append(format);
                str = String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.f6665d.getAltitude()));
            } else {
                sb = new StringBuilder();
                sb.append(format);
                str = "}}";
            }
            sb.append(str);
            return sb.toString();
        }
        return null;
    }

    public Location g() {
        if (this.f6665d != null && Math.abs(System.currentTimeMillis() - this.f6665d.getTime()) <= 60000) {
            return this.f6665d;
        }
        return null;
    }

    public boolean h() {
        try {
            if (this.f6665d != null && this.f6665d.getLatitude() != 0.0d && this.f6665d.getLongitude() != 0.0d) {
                if (n <= 2) {
                    if (this.f6665d.getExtras().getInt("satellites", 3) > 2) {
                    }
                }
                return true;
            }
            return false;
        } catch (Exception unused) {
            Location location = this.f6665d;
            return (location == null || location.getLatitude() == 0.0d || this.f6665d.getLongitude() == 0.0d) ? false : true;
        }
    }

    public boolean i() {
        if (h() && System.currentTimeMillis() - this.w <= 10000) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.s || currentTimeMillis - this.r >= 3000) {
                return this.v;
            }
            return true;
        }
        return false;
    }
}
