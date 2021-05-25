package com.baidu.location.c;

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
import com.baidu.location.b.t;
import com.baidu.location.b.w;
import com.baidu.location.b.x;
import com.baidu.location.e.k;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes2.dex */
public class e {
    public static String C = null;
    public static double G = 100.0d;

    /* renamed from: a  reason: collision with root package name */
    public static String f6619a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f6620b = "";

    /* renamed from: c  reason: collision with root package name */
    public static e f6621c;
    public static int p;
    public static int q;
    public static int r;
    public static long s;
    public int E;
    public int F;

    /* renamed from: d  reason: collision with root package name */
    public Context f6622d;

    /* renamed from: f  reason: collision with root package name */
    public Location f6624f;

    /* renamed from: i  reason: collision with root package name */
    public GpsStatus f6627i;
    public a j;
    public boolean k;
    public boolean m;

    /* renamed from: e  reason: collision with root package name */
    public LocationManager f6623e = null;

    /* renamed from: g  reason: collision with root package name */
    public c f6625g = null;

    /* renamed from: h  reason: collision with root package name */
    public C0092e f6626h = null;
    public b l = null;
    public d n = null;
    public OnNmeaMessageListener o = null;
    public long t = 0;
    public boolean u = false;
    public boolean v = false;
    public String w = null;
    public boolean x = false;
    public long y = 0;
    public double z = -1.0d;
    public double A = 0.0d;
    public double B = 0.0d;
    public Handler D = null;
    public long H = 0;
    public long I = 0;
    public ArrayList<ArrayList<Float>> J = new ArrayList<>();
    public ArrayList<ArrayList<Float>> K = new ArrayList<>();

    @TargetApi(24)
    /* loaded from: classes2.dex */
    public class a extends GnssStatus.Callback {
        public a() {
        }

        public /* synthetic */ a(e eVar, f fVar) {
            this();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i2) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            if (e.this.f6623e == null) {
                return;
            }
            e.this.I = System.currentTimeMillis();
            int satelliteCount = gnssStatus.getSatelliteCount();
            e.this.J.clear();
            e.this.K.clear();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < satelliteCount; i5++) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                i4++;
                if (gnssStatus.usedInFix(i5)) {
                    i2++;
                    gnssStatus.getConstellationType(i5);
                    i3++;
                    arrayList.add(Float.valueOf(gnssStatus.getCn0DbHz(i5)));
                    arrayList.add(Float.valueOf(0.0f));
                    arrayList.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i5)));
                    arrayList.add(Float.valueOf(gnssStatus.getElevationDegrees(i5)));
                    arrayList.add(Float.valueOf(1.0f));
                    arrayList.add(Float.valueOf(gnssStatus.getSvid(i5)));
                    e.this.J.add(arrayList);
                    e.this.K.add(arrayList);
                } else {
                    gnssStatus.getConstellationType(i5);
                    arrayList2.add(Float.valueOf(gnssStatus.getCn0DbHz(i5)));
                    arrayList2.add(Float.valueOf(0.0f));
                    arrayList2.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i5)));
                    arrayList2.add(Float.valueOf(gnssStatus.getElevationDegrees(i5)));
                    arrayList2.add(Float.valueOf(0.0f));
                    arrayList2.add(Float.valueOf(gnssStatus.getSvid(i5)));
                    e.this.K.add(arrayList2);
                }
            }
            e.f6619a = e.this.l();
            e.f6620b = e.this.m();
            int unused = e.p = i2;
            int unused2 = e.q = i3;
            int unused3 = e.r = i4;
            long unused4 = e.s = System.currentTimeMillis();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            e.this.d((Location) null);
            e.this.b(false);
            int unused = e.p = 0;
            int unused2 = e.q = 0;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements GpsStatus.Listener {

        /* renamed from: b  reason: collision with root package name */
        public long f6630b;

        public b() {
            this.f6630b = 0L;
        }

        public /* synthetic */ b(e eVar, f fVar) {
            this();
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i2) {
            long currentTimeMillis;
            if (e.this.f6623e == null) {
                return;
            }
            int i3 = 0;
            if (i2 == 2) {
                e.this.d((Location) null);
                e.this.b(false);
                int unused = e.p = 0;
                int unused2 = e.q = 0;
            } else if (i2 == 4 && e.this.v) {
                try {
                    if (e.this.f6627i == null) {
                        e.this.f6627i = e.this.f6623e.getGpsStatus(null);
                    } else {
                        e.this.f6623e.getGpsStatus(e.this.f6627i);
                    }
                    e.this.E = 0;
                    e.this.F = 0;
                    double d2 = 0.0d;
                    e.this.J.clear();
                    e.this.K.clear();
                    e.this.I = System.currentTimeMillis();
                    int i4 = 0;
                    for (GpsSatellite gpsSatellite : e.this.f6627i.getSatellites()) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        if (gpsSatellite.usedInFix()) {
                            i4++;
                            gpsSatellite.getPrn();
                            i3++;
                            d2 += gpsSatellite.getSnr();
                            arrayList.add(Float.valueOf(0.0f));
                            arrayList.add(Float.valueOf(gpsSatellite.getSnr()));
                            arrayList.add(Float.valueOf(gpsSatellite.getAzimuth()));
                            arrayList.add(Float.valueOf(gpsSatellite.getElevation()));
                            arrayList.add(Float.valueOf(1.0f));
                            arrayList.add(Float.valueOf(gpsSatellite.getPrn()));
                            e.this.J.add(arrayList);
                            e.this.K.add(arrayList);
                        } else {
                            gpsSatellite.getPrn();
                            arrayList2.add(Float.valueOf(0.0f));
                            arrayList2.add(Float.valueOf(gpsSatellite.getSnr()));
                            arrayList2.add(Float.valueOf(gpsSatellite.getAzimuth()));
                            arrayList2.add(Float.valueOf(gpsSatellite.getElevation()));
                            arrayList2.add(Float.valueOf(0.0f));
                            arrayList2.add(Float.valueOf(gpsSatellite.getPrn()));
                            e.this.K.add(arrayList2);
                        }
                        if (gpsSatellite.getSnr() >= k.H) {
                            e.j(e.this);
                        }
                    }
                    e.f6619a = e.this.l();
                    e.f6620b = e.this.m();
                    if (i3 > 0) {
                        int unused3 = e.q = i3;
                        double unused4 = e.G = d2 / i3;
                    }
                    if (i4 <= 0) {
                        if (System.currentTimeMillis() - this.f6630b > 100) {
                            currentTimeMillis = System.currentTimeMillis();
                        }
                        long unused5 = e.s = System.currentTimeMillis();
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    this.f6630b = currentTimeMillis;
                    int unused6 = e.p = i4;
                    long unused52 = e.s = System.currentTimeMillis();
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
            if (location != null && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d) {
                int i2 = e.p;
                if (i2 == 0) {
                    try {
                        i2 = location.getExtras().getInt("satellites");
                    } catch (Exception unused) {
                    }
                }
                if (i2 == 0) {
                    System.currentTimeMillis();
                    long unused2 = e.this.I;
                    if (location.getAccuracy() > 50.0f && !k.m) {
                        return;
                    }
                }
                e.this.b(true);
                e.this.d(location);
                e.this.u = false;
            }
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
        public void onStatusChanged(String str, int i2, Bundle bundle) {
            if (i2 == 0) {
                e.this.d((Location) null);
            } else if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                e.this.u = false;
                return;
            } else {
                e.this.t = System.currentTimeMillis();
                e.this.u = true;
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

    /* renamed from: com.baidu.location.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0092e implements LocationListener {

        /* renamed from: b  reason: collision with root package name */
        public long f6634b;

        public C0092e() {
            this.f6634b = 0L;
        }

        public /* synthetic */ C0092e(e eVar, f fVar) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!e.this.v && location != null && location.getProvider() == "gps" && System.currentTimeMillis() - this.f6634b >= 10000 && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d && w.a(location, false)) {
                this.f6634b = System.currentTimeMillis();
                e.this.D.sendMessage(e.this.D.obtainMessage(4, location));
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    public e() {
        this.k = false;
        this.m = false;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.k = true;
            } catch (ClassNotFoundException unused) {
                this.k = false;
            }
        }
        this.m = false;
    }

    public static int a(String str, String str2) {
        char charAt = str2.charAt(0);
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (Character.valueOf(charAt).equals(Character.valueOf(str.charAt(i3)))) {
                i2++;
            }
        }
        return i2;
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f6621c == null) {
                f6621c = new e();
            }
            eVar = f6621c;
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
        return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d&ll_snr=%.1f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(location.hasBearing() ? location.getBearing() : -1.0f), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)), Integer.valueOf(p), Double.valueOf(location.hasAltitude() ? location.getAltitude() : 555.0d), Long.valueOf(location.getTime() / 1000), Integer.valueOf(p), Integer.valueOf(q), Double.valueOf(G));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Location location) {
        if (location == null) {
            return;
        }
        String str2 = str + com.baidu.location.b.a.a().c();
        boolean e2 = i.a().e();
        t.a(new com.baidu.location.c.a(com.baidu.location.c.b.a().f()));
        t.a(System.currentTimeMillis());
        t.a(new Location(location));
        t.a(str2);
        if (e2) {
            return;
        }
        w.a(t.c(), null, t.d(), str2);
    }

    public static boolean a(Location location, Location location2, boolean z) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (!z || ((k.v != 3 && com.baidu.location.e.d.a().a(location2.getLongitude(), location2.getLatitude())) || speed >= 5.0f)) {
            float distanceTo = location2.distanceTo(location);
            return speed > k.L ? distanceTo > k.N : speed > k.K ? distanceTo > k.M : distanceTo > 5.0f;
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
        this.x = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        int i2;
        if (str.indexOf("*") != -1 && str.indexOf("$") != -1 && str.indexOf("$") <= str.indexOf("*") && str.length() >= str.indexOf("*")) {
            byte[] bytes = str.substring(0, str.indexOf("*")).getBytes();
            int i3 = bytes[1];
            for (int i4 = 2; i4 < bytes.length; i4++) {
                i3 ^= bytes[i4];
            }
            String format = String.format("%02x", Integer.valueOf(i3));
            int indexOf = str.indexOf("*");
            if (indexOf != -1 && str.length() >= (i2 = indexOf + 3) && format.equalsIgnoreCase(str.substring(indexOf + 1, i2))) {
                return true;
            }
        }
        return false;
    }

    public static String c(Location location) {
        String a2 = a(location);
        if (a2 != null) {
            return a2 + C;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Location location) {
        this.D.sendMessage(this.D.obtainMessage(1, location));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        String str = null;
        if (location == null) {
            this.f6624f = null;
            return;
        }
        int i2 = p;
        if (i2 == 0) {
            try {
                i2 = location.getExtras().getInt("satellites");
            } catch (Exception unused) {
            }
        }
        if (i2 != 0 || Math.abs(System.currentTimeMillis() - this.I) <= 5000 || k.m) {
            if (this.m && location.getSpeed() == 0.0d && this.A != 0.0d && System.currentTimeMillis() - this.B < 2000.0d) {
                location.setSpeed((float) this.A);
            }
            this.y = System.currentTimeMillis();
            System.currentTimeMillis();
            this.f6624f = location;
            Location location2 = new Location(this.f6624f);
            int i3 = p;
            if (this.f6624f != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f6624f.setTime(currentTimeMillis);
                float speed = (float) (this.f6624f.getSpeed() * 3.6d);
                if (!this.f6624f.hasSpeed()) {
                    speed = -1.0f;
                }
                if (i3 == 0) {
                    try {
                        i3 = this.f6624f.getExtras().getInt("satellites");
                    } catch (Exception unused2) {
                    }
                }
                str = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.f6624f.getLongitude()), Double.valueOf(this.f6624f.getLatitude()), Float.valueOf(speed), Float.valueOf(this.f6624f.getBearing()), Integer.valueOf(i3), Long.valueOf(currentTimeMillis));
            }
            this.w = str;
            if (this.f6624f != null) {
                com.baidu.location.b.a.a().a(f());
                if (p > 2 && w.a(this.f6624f, true)) {
                    boolean e2 = i.a().e();
                    t.a(new com.baidu.location.c.a(com.baidu.location.c.b.a().f()));
                    t.a(System.currentTimeMillis());
                    t.a(new Location(this.f6624f));
                    t.a(com.baidu.location.b.a.a().c());
                    if (!e2) {
                        x.a().b();
                    }
                }
            }
            x.a().a(location2, p);
        }
    }

    public static /* synthetic */ int j(e eVar) {
        int i2 = eVar.F;
        eVar.F = i2 + 1;
        return i2;
    }

    public static String j() {
        long currentTimeMillis = System.currentTimeMillis() - s;
        if (currentTimeMillis < 0 || currentTimeMillis >= 3000) {
            return null;
        }
        return String.format(Locale.US, "&gsvn=%d&gsfn=%d", Integer.valueOf(r), Integer.valueOf(p));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l() {
        StringBuilder sb = new StringBuilder();
        if (this.J.size() > 32 || this.J.size() == 0) {
            return sb.toString();
        }
        Iterator<ArrayList<Float>> it = this.J.iterator();
        boolean z = true;
        while (it.hasNext()) {
            ArrayList<Float> next = it.next();
            if (next.size() == 6) {
                if (z) {
                    z = false;
                } else {
                    sb.append(FieldBuilder.SE);
                }
                sb.append(String.format("%.1f;", next.get(0)));
                sb.append(String.format("%.1f;", next.get(1)));
                sb.append(String.format("%.0f;", next.get(2)));
                sb.append(String.format("%.0f;", next.get(3)));
                sb.append(String.format("%.0f", next.get(4)));
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m() {
        StringBuilder sb = new StringBuilder();
        if (this.K.size() == 0) {
            return sb.toString();
        }
        Iterator<ArrayList<Float>> it = this.K.iterator();
        boolean z = true;
        while (it.hasNext()) {
            ArrayList<Float> next = it.next();
            if (next.size() == 6) {
                if (z) {
                    z = false;
                } else {
                    sb.append(FieldBuilder.SE);
                }
                sb.append(String.format("%.1f;", next.get(0)));
                sb.append(String.format("%.1f;", next.get(1)));
                sb.append(String.format("%.0f;", next.get(2)));
                sb.append(String.format("%.0f;", next.get(3)));
                sb.append(String.format("%.0f", next.get(4)));
                sb.append(String.format("%.0f", next.get(5)));
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
                        this.A = ((Double.valueOf(split[7]).doubleValue() * 1.852d) / 3600.0d) * 1000.0d;
                        this.B = System.currentTimeMillis();
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
            this.f6622d = serviceContext;
            try {
                this.f6623e = (LocationManager) serviceContext.getSystemService("location");
                if (this.k) {
                    a aVar = new a(this, null);
                    this.j = aVar;
                    this.f6623e.registerGnssStatusCallback(aVar);
                } else {
                    b bVar = new b(this, null);
                    this.l = bVar;
                    this.f6623e.addGpsStatusListener(bVar);
                }
                if (this.m) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        f fVar = new f(this);
                        this.o = fVar;
                        this.f6623e.addNmeaListener(fVar);
                    } else {
                        d dVar = new d(this, null);
                        this.n = dVar;
                        this.f6623e.addNmeaListener(dVar);
                    }
                }
                C0092e c0092e = new C0092e(this, null);
                this.f6626h = c0092e;
                this.f6623e.requestLocationUpdates("passive", 9000L, 0.0f, c0092e);
            } catch (Exception unused) {
            }
            this.D = new g(this);
        }
    }

    public void c() {
        Log.d(com.baidu.location.e.a.f6667a, "start gps...");
        if (this.v) {
            return;
        }
        try {
            this.f6625g = new c(this, null);
            try {
                this.f6623e.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
            } catch (Exception unused) {
            }
            this.f6623e.requestLocationUpdates("gps", 1000L, 0.0f, this.f6625g);
            this.H = System.currentTimeMillis();
            this.v = true;
        } catch (Exception unused2) {
        }
    }

    public void d() {
        if (this.v) {
            LocationManager locationManager = this.f6623e;
            if (locationManager != null) {
                try {
                    if (this.f6625g != null) {
                        locationManager.removeUpdates(this.f6625g);
                    }
                } catch (Exception unused) {
                }
            }
            k.f6722d = 0;
            k.v = 0;
            this.f6625g = null;
            this.v = false;
            b(false);
        }
    }

    public synchronized void e() {
        d();
        if (this.f6623e == null) {
            return;
        }
        try {
            if (this.l != null) {
                this.f6623e.removeGpsStatusListener(this.l);
            }
            if (this.k && this.j != null) {
                this.f6623e.unregisterGnssStatusCallback(this.j);
            }
            if (this.m && this.n != null) {
                this.f6623e.removeNmeaListener(this.n);
            }
            this.f6623e.removeUpdates(this.f6626h);
        } catch (Exception unused) {
        }
        this.l = null;
        this.f6623e = null;
    }

    public String f() {
        double[] coorEncrypt;
        boolean z;
        StringBuilder sb;
        String str;
        if (this.f6624f != null) {
            String str2 = "{\"result\":{\"time\":\"" + k.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
            int accuracy = (int) (this.f6624f.hasAccuracy() ? this.f6624f.getAccuracy() : 10.0f);
            float speed = (float) (this.f6624f.getSpeed() * 3.6d);
            if (!this.f6624f.hasSpeed()) {
                speed = -1.0f;
            }
            if (com.baidu.location.e.d.a().a(this.f6624f.getLongitude(), this.f6624f.getLatitude())) {
                coorEncrypt = Jni.coorEncrypt(this.f6624f.getLongitude(), this.f6624f.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                if (coorEncrypt[0] <= 0.0d && coorEncrypt[1] <= 0.0d) {
                    coorEncrypt[0] = this.f6624f.getLongitude();
                    coorEncrypt[1] = this.f6624f.getLatitude();
                }
                z = true;
            } else {
                this.f6624f.getLongitude();
                this.f6624f.getLatitude();
                coorEncrypt = Jni.coorEncrypt(this.f6624f.getLongitude(), this.f6624f.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                if (coorEncrypt[0] <= 0.0d && coorEncrypt[1] <= 0.0d) {
                    coorEncrypt[0] = this.f6624f.getLongitude();
                    coorEncrypt[1] = this.f6624f.getLatitude();
                }
                z = false;
            }
            String format = String.format(Locale.CHINA, str2, Double.valueOf(coorEncrypt[0]), Double.valueOf(coorEncrypt[1]), Integer.valueOf(accuracy), Float.valueOf(this.f6624f.getBearing()), Float.valueOf(speed), Integer.valueOf(p));
            if (!z) {
                format = format + ",\"in_cn\":\"0\"";
            }
            if (this.f6624f.hasAltitude()) {
                sb = new StringBuilder();
                sb.append(format);
                str = String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.f6624f.getAltitude()));
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
        if (this.f6624f != null && Math.abs(System.currentTimeMillis() - this.f6624f.getTime()) <= 60000) {
            return this.f6624f;
        }
        return null;
    }

    public boolean h() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - this.I;
            int i2 = p;
            if (i2 == 0) {
                try {
                    i2 = this.f6624f.getExtras().getInt("satellites");
                } catch (Exception unused) {
                }
            }
            if (this.f6624f != null && this.f6624f.getLatitude() != 0.0d && this.f6624f.getLongitude() != 0.0d) {
                if (i2 <= 2 && Math.abs(currentTimeMillis) >= 5000) {
                    if (k.m) {
                    }
                }
                return true;
            }
            return false;
        } catch (Exception unused2) {
            Location location = this.f6624f;
            return (location == null || location.getLatitude() == 0.0d || this.f6624f.getLongitude() == 0.0d) ? false : true;
        }
    }

    public boolean i() {
        if (h() && System.currentTimeMillis() - this.y <= 10000) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.u || currentTimeMillis - this.t >= 3000) {
                return this.x;
            }
            return true;
        }
        return false;
    }
}
