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
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes8.dex */
public class e {
    private int C;
    private int D;
    private Context b;
    private Location d;
    private GpsStatus g;
    private a h;
    private boolean i;
    private static e a = null;
    private static int n = 0;
    private static int o = 0;
    private static int p = 0;
    private static long q = 0;
    private static String A = null;
    private static double E = 100.0d;
    private static String F = "";
    private LocationManager c = null;
    private c e = null;
    private C0191e f = null;
    private b j = null;
    private boolean k = false;
    private d l = null;
    private OnNmeaMessageListener m = null;
    private long r = 0;
    private boolean s = false;
    private boolean t = false;
    private String u = null;
    private boolean v = false;
    private long w = 0;
    private double x = -1.0d;
    private double y = 0.0d;
    private double z = 0.0d;
    private Handler B = null;
    private long G = 0;
    private ArrayList<ArrayList<Float>> H = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes8.dex */
    public class a extends GnssStatus.Callback {
        private a() {
        }

        /* synthetic */ a(e eVar, f fVar) {
            this();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            int i = 0;
            if (e.this.c == null) {
                return;
            }
            int satelliteCount = gnssStatus.getSatelliteCount();
            e.this.H.clear();
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < satelliteCount; i4++) {
                ArrayList arrayList = new ArrayList();
                i2++;
                if (gnssStatus.usedInFix(i4)) {
                    i3++;
                    if (gnssStatus.getConstellationType(i4) == 1) {
                        i++;
                        arrayList.add(Float.valueOf(gnssStatus.getCn0DbHz(i4)));
                        arrayList.add(Float.valueOf(0.0f));
                        arrayList.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i4)));
                        arrayList.add(Float.valueOf(gnssStatus.getElevationDegrees(i4)));
                        arrayList.add(Float.valueOf(1.0f));
                    }
                    e.this.H.add(arrayList);
                }
            }
            int unused = e.n = i3;
            int unused2 = e.o = i;
            int unused3 = e.p = i2;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b implements GpsStatus.Listener {
        private long b;

        private b() {
            this.b = 0L;
        }

        /* synthetic */ b(e eVar, f fVar) {
            this();
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            if (e.this.c == null) {
                return;
            }
            switch (i) {
                case 2:
                    e.this.d((Location) null);
                    e.this.b(false);
                    int unused = e.n = 0;
                    int unused2 = e.o = 0;
                    return;
                case 3:
                default:
                    return;
                case 4:
                    if (e.this.t) {
                        try {
                            if (e.this.g == null) {
                                e.this.g = e.this.c.getGpsStatus(null);
                            } else {
                                e.this.c.getGpsStatus(e.this.g);
                            }
                            e.this.C = 0;
                            e.this.D = 0;
                            double d = 0.0d;
                            e.this.H.clear();
                            int i2 = 0;
                            int i3 = 0;
                            int i4 = 0;
                            for (GpsSatellite gpsSatellite : e.this.g.getSatellites()) {
                                ArrayList arrayList = new ArrayList();
                                new ArrayList();
                                i2++;
                                if (gpsSatellite.usedInFix()) {
                                    i4++;
                                    if (gpsSatellite.getPrn() <= 65) {
                                        i3++;
                                        d += gpsSatellite.getSnr();
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
                            if (i3 > 0) {
                                int unused3 = e.o = i3;
                                double unused4 = e.E = d / i3;
                            }
                            if (i4 > 0) {
                                this.b = System.currentTimeMillis();
                                int unused5 = e.n = i4;
                            } else if (System.currentTimeMillis() - this.b > 100) {
                                this.b = System.currentTimeMillis();
                                int unused6 = e.n = i4;
                            }
                            long unused7 = e.q = System.currentTimeMillis();
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class c implements LocationListener {
        private c() {
        }

        /* synthetic */ c(e eVar, f fVar) {
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
            switch (i) {
                case 0:
                    e.this.d((Location) null);
                    e.this.b(false);
                    return;
                case 1:
                    e.this.r = System.currentTimeMillis();
                    e.this.s = true;
                    e.this.b(false);
                    return;
                case 2:
                    e.this.s = false;
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class d implements GpsStatus.NmeaListener {
        private d() {
        }

        /* synthetic */ d(e eVar, f fVar) {
            this();
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            if (e.this.b(str)) {
                e.this.a(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.b.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0191e implements LocationListener {
        private long b;

        private C0191e() {
            this.b = 0L;
        }

        /* synthetic */ C0191e(e eVar, f fVar) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!e.this.t && location != null && location.getProvider() == "gps" && System.currentTimeMillis() - this.b >= 10000 && w.a(location, false)) {
                this.b = System.currentTimeMillis();
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

    private e() {
        this.i = false;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.i = true;
            } catch (ClassNotFoundException e) {
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
            if (a == null) {
                a = new e();
            }
            eVar = a;
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
        boolean e = i.a().e();
        u.a(new com.baidu.location.b.a(com.baidu.location.b.b.a().f()));
        u.a(System.currentTimeMillis());
        u.a(new Location(location));
        u.a(str2);
        if (e) {
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
        return a2 != null ? a2 + "&g_tp=0" : a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.v = z;
        if (!z || !i()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        if (str.indexOf("*") != -1 && str.indexOf("$") != -1 && str.indexOf("$") <= str.indexOf("*") && str.length() >= str.indexOf("*")) {
            byte[] bytes = str.substring(0, str.indexOf("*")).getBytes();
            int i = bytes[1];
            for (int i2 = 2; i2 < bytes.length; i2++) {
                i ^= bytes[i2];
            }
            String format = String.format("%02x", Integer.valueOf(i));
            int indexOf = str.indexOf("*");
            if (indexOf != -1 && str.length() >= indexOf + 3 && format.equalsIgnoreCase(str.substring(indexOf + 1, indexOf + 3))) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static String c(Location location) {
        String a2 = a(location);
        return a2 != null ? a2 + A : a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Location location) {
        this.B.sendMessage(this.B.obtainMessage(1, location));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        Location location2;
        if (location == null) {
            this.d = null;
            return;
        }
        int i = n;
        if (i == 0) {
            try {
                i = location.getExtras().getInt("satellites");
            } catch (Exception e) {
            }
        }
        if (i != 0 || com.baidu.location.d.j.m) {
            if (this.k && location.getSpeed() == 0.0d && this.y != 0.0d && System.currentTimeMillis() - this.z < 2000.0d) {
                location.setSpeed((float) this.y);
            }
            this.d = location;
            int i2 = n;
            if (this.d == null) {
                this.u = null;
                location2 = null;
            } else {
                Location location3 = new Location(this.d);
                long currentTimeMillis = System.currentTimeMillis();
                this.d.setTime(currentTimeMillis);
                float speed = (float) (this.d.getSpeed() * 3.6d);
                if (!this.d.hasSpeed()) {
                    speed = -1.0f;
                }
                if (i2 == 0) {
                    try {
                        i2 = this.d.getExtras().getInt("satellites");
                    } catch (Exception e2) {
                    }
                }
                this.u = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.d.getLongitude()), Double.valueOf(this.d.getLatitude()), Float.valueOf(speed), Float.valueOf(this.d.getBearing()), Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
                location2 = location3;
            }
            if (i() && this.d != null) {
                F = k();
                com.baidu.location.a.a.a().a(f());
                if (n > 2 && w.a(this.d, true)) {
                    boolean e3 = i.a().e();
                    u.a(new com.baidu.location.b.a(com.baidu.location.b.b.a().f()));
                    u.a(System.currentTimeMillis());
                    u.a(new Location(this.d));
                    u.a(com.baidu.location.a.a.a().c());
                    if (!e3) {
                        x.a().b();
                    }
                }
            }
            x.a().a(location2, n);
        }
    }

    static /* synthetic */ int f(e eVar) {
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
                    sb.append("|");
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
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                a(str, Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split == null || split.length <= 0) {
                    return;
                }
                if ((split[0].equalsIgnoreCase("$GPRMC") || split[0].equalsIgnoreCase("$GNRMC") || split[0].equalsIgnoreCase("$GLRMC") || split[0].equalsIgnoreCase("$BDRMC")) && split.length > 7 && split[7].trim().length() > 0) {
                    this.y = ((Double.valueOf(split[7]).doubleValue() * 1.852d) / 3600.0d) * 1000.0d;
                    this.z = System.currentTimeMillis();
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
            this.b = com.baidu.location.f.getServiceContext();
            try {
                this.c = (LocationManager) this.b.getSystemService("location");
                if (this.i) {
                    this.h = new a(this, null);
                    this.c.registerGnssStatusCallback(this.h);
                } else {
                    this.j = new b(this, null);
                    this.c.addGpsStatusListener(this.j);
                }
                if (this.k) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        this.m = new f(this);
                        this.c.addNmeaListener(this.m);
                    } else {
                        this.l = new d(this, null);
                        this.c.addNmeaListener(this.l);
                    }
                }
                this.f = new C0191e(this, null);
                this.c.requestLocationUpdates("passive", 9000L, 0.0f, this.f);
            } catch (Exception e) {
            }
            this.B = new g(this);
        }
    }

    public void c() {
        Log.d(com.baidu.location.d.a.a, "start gps...");
        if (this.t) {
            return;
        }
        try {
            this.e = new c(this, null);
            try {
                this.c.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
            } catch (Exception e) {
            }
            this.c.requestLocationUpdates("gps", 1000L, 0.0f, this.e);
            this.G = System.currentTimeMillis();
            this.t = true;
        } catch (Exception e2) {
        }
    }

    public void d() {
        if (this.t) {
            if (this.c != null) {
                try {
                    if (this.e != null) {
                        this.c.removeUpdates(this.e);
                    }
                } catch (Exception e) {
                }
            }
            com.baidu.location.d.j.d = 0;
            com.baidu.location.d.j.v = 0;
            this.e = null;
            this.t = false;
            b(false);
        }
    }

    public synchronized void e() {
        d();
        if (this.c != null) {
            try {
                if (this.j != null) {
                    this.c.removeGpsStatusListener(this.j);
                }
                if (this.i && this.h != null) {
                    this.c.unregisterGnssStatusCallback(this.h);
                }
                if (this.k && this.l != null) {
                    this.c.removeNmeaListener(this.l);
                }
                this.c.removeUpdates(this.f);
            } catch (Exception e) {
            }
            this.j = null;
            this.c = null;
        }
    }

    public String f() {
        double[] dArr;
        boolean z;
        if (this.d != null) {
            String str = "{\"result\":{\"time\":\"" + com.baidu.location.d.j.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
            int accuracy = (int) (this.d.hasAccuracy() ? this.d.getAccuracy() : 10.0f);
            float speed = (float) (this.d.getSpeed() * 3.6d);
            if (!this.d.hasSpeed()) {
                speed = -1.0f;
            }
            double[] dArr2 = new double[2];
            if (com.baidu.location.d.d.a().a(this.d.getLongitude(), this.d.getLatitude())) {
                double[] coorEncrypt = Jni.coorEncrypt(this.d.getLongitude(), this.d.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                if (coorEncrypt[0] > 0.0d || coorEncrypt[1] > 0.0d) {
                    dArr = coorEncrypt;
                    z = true;
                } else {
                    coorEncrypt[0] = this.d.getLongitude();
                    coorEncrypt[1] = this.d.getLatitude();
                    dArr = coorEncrypt;
                    z = true;
                }
            } else {
                dArr2[0] = this.d.getLongitude();
                dArr2[1] = this.d.getLatitude();
                dArr = dArr2;
                z = false;
            }
            String format = String.format(Locale.CHINA, str, Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.d.getBearing()), Float.valueOf(speed), Integer.valueOf(n));
            if (!z) {
                format = format + ",\"in_cn\":\"0\"";
            }
            return this.d.hasAltitude() ? format + String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.d.getAltitude())) : format + "}}";
        }
        return null;
    }

    public Location g() {
        if (this.d != null && Math.abs(System.currentTimeMillis() - this.d.getTime()) <= 60000) {
            return this.d;
        }
        return null;
    }

    public boolean h() {
        try {
            if (this.d != null && this.d.getLatitude() != 0.0d && this.d.getLongitude() != 0.0d) {
                if (n > 2) {
                    return true;
                }
                if (this.d.getExtras().getInt("satellites", 3) > 2) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return (this.d == null || this.d.getLatitude() == 0.0d || this.d.getLongitude() == 0.0d) ? false : true;
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
