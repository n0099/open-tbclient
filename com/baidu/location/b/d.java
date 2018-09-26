package com.baidu.location.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.http.Headers;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.a.n;
import com.baidu.location.a.p;
import com.baidu.location.d.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class d {
    private int A;
    private int B;
    private Location ZW;
    private GpsStatus ZZ;
    private a aaa;
    private Context d;
    private boolean k;
    private static d ZU = null;
    private static int m = 0;
    private static int n = 0;
    private static String u = null;
    private static double aad = 100.0d;
    private static String D = "";
    private final long a = 1000;
    private final long b = 9000;
    private LocationManager ZV = null;
    private c ZX = null;
    private C0072d ZY = null;
    private b aab = null;
    private long o = 0;
    private boolean p = false;
    private boolean q = false;
    private String r = null;
    private boolean s = false;
    private long t = 0;
    private Handler aac = null;
    private final int w = 1;
    private final int x = 2;
    private final int y = 3;
    private final int z = 4;
    private long aae = 0;
    private ArrayList<ArrayList<Float>> aaf = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes2.dex */
    public class a extends GnssStatus.Callback {
        private a() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            int i = 0;
            if (d.this.ZV == null) {
                return;
            }
            int satelliteCount = gnssStatus.getSatelliteCount();
            d.this.aaf.clear();
            int i2 = 0;
            for (int i3 = 0; i3 < satelliteCount; i3++) {
                ArrayList arrayList = new ArrayList();
                if (gnssStatus.usedInFix(i3)) {
                    i2++;
                    if (gnssStatus.getConstellationType(i3) == 1) {
                        i++;
                        arrayList.add(Float.valueOf(gnssStatus.getCn0DbHz(i3)));
                        arrayList.add(Float.valueOf(0.0f));
                        arrayList.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i3)));
                        arrayList.add(Float.valueOf(gnssStatus.getElevationDegrees(i3)));
                        arrayList.add(Float.valueOf(1.0f));
                    }
                    d.this.aaf.add(arrayList);
                }
            }
            int unused = d.m = i2;
            int unused2 = d.n = i;
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            d.this.d((Location) null);
            d.this.b(false);
            int unused = d.m = 0;
            int unused2 = d.n = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements GpsStatus.Listener {
        long a;
        private long c;
        private final int d;
        private boolean e;
        private List<String> f;
        private String g;
        private String h;
        private String i;
        private long j;

        private b() {
            this.a = 0L;
            this.c = 0L;
            this.d = HttpStatus.SC_BAD_REQUEST;
            this.e = false;
            this.f = new ArrayList();
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = 0L;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            int i2 = 0;
            if (d.this.ZV == null) {
                return;
            }
            switch (i) {
                case 2:
                    d.this.d((Location) null);
                    d.this.b(false);
                    int unused = d.m = 0;
                    int unused2 = d.n = 0;
                    return;
                case 3:
                default:
                    return;
                case 4:
                    if (d.this.q) {
                        try {
                            if (d.this.ZZ == null) {
                                d.this.ZZ = d.this.ZV.getGpsStatus(null);
                            } else {
                                d.this.ZV.getGpsStatus(d.this.ZZ);
                            }
                            d.this.A = 0;
                            d.this.B = 0;
                            double d = 0.0d;
                            d.this.aaf.clear();
                            int i3 = 0;
                            for (GpsSatellite gpsSatellite : d.this.ZZ.getSatellites()) {
                                ArrayList arrayList = new ArrayList();
                                new ArrayList();
                                if (gpsSatellite.usedInFix()) {
                                    i3++;
                                    if (gpsSatellite.getPrn() <= 65) {
                                        i2++;
                                        d += gpsSatellite.getSnr();
                                        arrayList.add(Float.valueOf(0.0f));
                                        arrayList.add(Float.valueOf(gpsSatellite.getSnr()));
                                        arrayList.add(Float.valueOf(gpsSatellite.getAzimuth()));
                                        arrayList.add(Float.valueOf(gpsSatellite.getElevation()));
                                        arrayList.add(Float.valueOf(1.0f));
                                    }
                                    d.this.aaf.add(arrayList);
                                    if (gpsSatellite.getSnr() >= g.H) {
                                        d.f(d.this);
                                    }
                                }
                            }
                            if (i2 > 0) {
                                int unused3 = d.n = i2;
                                double unused4 = d.aad = d / i2;
                            }
                            if (i3 > 0) {
                                this.j = System.currentTimeMillis();
                                int unused5 = d.m = i3;
                                return;
                            } else if (System.currentTimeMillis() - this.j > 100) {
                                this.j = System.currentTimeMillis();
                                int unused6 = d.m = i3;
                                return;
                            } else {
                                return;
                            }
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements LocationListener {
        private c() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            d.this.t = System.currentTimeMillis();
            d.this.b(true);
            d.this.d(location);
            d.this.p = false;
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            d.this.d((Location) null);
            d.this.b(false);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            switch (i) {
                case 0:
                    d.this.d((Location) null);
                    d.this.b(false);
                    return;
                case 1:
                    d.this.o = System.currentTimeMillis();
                    d.this.p = true;
                    d.this.b(false);
                    return;
                case 2:
                    d.this.p = false;
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0072d implements LocationListener {
        private long b;

        private C0072d() {
            this.b = 0L;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!d.this.q && location != null && location.getProvider() == "gps" && System.currentTimeMillis() - this.b >= 10000 && p.a(location, false)) {
                this.b = System.currentTimeMillis();
                d.this.aac.sendMessage(d.this.aac.obtainMessage(4, location));
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

    private d() {
        this.k = false;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.k = true;
            } catch (ClassNotFoundException e) {
                this.k = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Location location) {
        if (location == null) {
            return;
        }
        String str2 = str + com.baidu.location.a.a.rp().c();
        boolean e = f.rN().e();
        n.b(new com.baidu.location.b.a(com.baidu.location.b.b.rG().rH()));
        n.a(System.currentTimeMillis());
        n.a(new Location(location));
        n.a(str2);
        if (e) {
            return;
        }
        p.a(n.rC(), null, n.rD(), str2);
    }

    public static boolean a(Location location, Location location2, boolean z) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (!z || ((g.v != 3 && com.baidu.location.d.d.rU().b(location2.getLongitude(), location2.getLatitude())) || speed >= 5.0f)) {
            float distanceTo = location2.distanceTo(location);
            return speed > g.aaJ ? distanceTo > g.aaL : speed > g.K ? distanceTo > g.aaK : distanceTo > 5.0f;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.s = z;
        if (!z || !i()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Location location) {
        this.aac.sendMessage(this.aac.obtainMessage(1, location));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        Location location2;
        if (location == null) {
            this.ZW = null;
            return;
        }
        int i = m;
        if (i == 0) {
            try {
                i = location.getExtras().getInt("satellites");
            } catch (Exception e) {
            }
        }
        if (i != 0 || g.l) {
            this.ZW = location;
            int i2 = m;
            if (this.ZW == null) {
                this.r = null;
                location2 = null;
            } else {
                Location location3 = new Location(this.ZW);
                long currentTimeMillis = System.currentTimeMillis();
                this.ZW.setTime(currentTimeMillis);
                float speed = (float) (this.ZW.getSpeed() * 3.6d);
                if (!this.ZW.hasSpeed()) {
                    speed = -1.0f;
                }
                if (i2 == 0) {
                    try {
                        i2 = this.ZW.getExtras().getInt("satellites");
                    } catch (Exception e2) {
                    }
                }
                this.r = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.ZW.getLongitude()), Double.valueOf(this.ZW.getLatitude()), Float.valueOf(speed), Float.valueOf(this.ZW.getBearing()), Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
                location2 = location3;
            }
            if (i() && this.ZW != null) {
                D = j();
                com.baidu.location.a.a.rp().a(f());
                if (m > 2 && p.a(this.ZW, true)) {
                    boolean e3 = f.rN().e();
                    n.b(new com.baidu.location.b.a(com.baidu.location.b.b.rG().rH()));
                    n.a(System.currentTimeMillis());
                    n.a(new Location(this.ZW));
                    n.a(com.baidu.location.a.a.rp().c());
                    if (!e3) {
                        p.a(n.rC(), null, n.rD(), com.baidu.location.a.a.rp().c());
                    }
                }
            }
            try {
                com.baidu.location.a.e.rt().f(this.ZW);
            } catch (Exception e4) {
            }
            if (location2 != null) {
                com.baidu.location.a.d.rs().a(location2);
            }
        }
    }

    static /* synthetic */ int f(d dVar) {
        int i = dVar.B;
        dVar.B = i + 1;
        return i;
    }

    public static String g(Location location) {
        if (location == null) {
            return null;
        }
        float speed = (float) (location.getSpeed() * 3.6d);
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d&ll_snr=%.1f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(location.hasBearing() ? location.getBearing() : -1.0f), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)), Integer.valueOf(m), Double.valueOf(location.hasAltitude() ? location.getAltitude() : 555.0d), Long.valueOf(location.getTime() / 1000), Integer.valueOf(m), Integer.valueOf(n), Double.valueOf(aad));
    }

    public static String h(Location location) {
        String g = g(location);
        return g != null ? g + "&g_tp=0" : g;
    }

    public static String i(Location location) {
        String g = g(location);
        return g != null ? g + u : g;
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        if (this.aaf.size() > 32 || this.aaf.size() == 0) {
            return sb.toString();
        }
        Iterator<ArrayList<Float>> it = this.aaf.iterator();
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

    public static synchronized d rL() {
        d dVar;
        synchronized (d.class) {
            if (ZU == null) {
                ZU = new d();
            }
            dVar = ZU;
        }
        return dVar;
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
            this.d = com.baidu.location.f.getServiceContext();
            try {
                this.ZV = (LocationManager) this.d.getSystemService(Headers.LOCATION);
                if (this.k) {
                    this.aaa = new a();
                    this.ZV.registerGnssStatusCallback(this.aaa);
                } else {
                    this.aab = new b();
                    this.ZV.addGpsStatusListener(this.aab);
                }
                this.ZY = new C0072d();
                this.ZV.requestLocationUpdates("passive", 9000L, 0.0f, this.ZY);
            } catch (Exception e) {
            }
            this.aac = new Handler() { // from class: com.baidu.location.b.d.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (com.baidu.location.f.isServing) {
                        switch (message.what) {
                            case 1:
                                d.this.e((Location) message.obj);
                                return;
                            case 2:
                            default:
                                return;
                            case 3:
                                d.this.a("&og=1", (Location) message.obj);
                                return;
                            case 4:
                                d.this.a("&og=2", (Location) message.obj);
                                return;
                        }
                    }
                }
            };
        }
    }

    public void c() {
        Log.d(com.baidu.location.d.a.a, "start gps...");
        if (this.q) {
            return;
        }
        try {
            this.ZX = new c();
            try {
                this.ZV.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
            } catch (Exception e) {
            }
            this.ZV.requestLocationUpdates("gps", 1000L, 0.0f, this.ZX);
            this.aae = System.currentTimeMillis();
            this.q = true;
        } catch (Exception e2) {
        }
    }

    public void d() {
        if (this.q) {
            if (this.ZV != null) {
                try {
                    if (this.ZX != null) {
                        this.ZV.removeUpdates(this.ZX);
                    }
                } catch (Exception e) {
                }
            }
            g.d = 0;
            g.v = 0;
            this.ZX = null;
            this.q = false;
            b(false);
        }
    }

    public synchronized void e() {
        d();
        if (this.ZV != null) {
            try {
                if (this.aab != null) {
                    this.ZV.removeGpsStatusListener(this.aab);
                }
                if (this.k && this.aaa != null) {
                    this.ZV.unregisterGnssStatusCallback(this.aaa);
                }
                this.ZV.removeUpdates(this.ZY);
            } catch (Exception e) {
            }
            this.aab = null;
            this.ZV = null;
        }
    }

    public String f() {
        double[] dArr;
        boolean z;
        if (this.ZW != null) {
            String str = "{\"result\":{\"time\":\"" + g.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
            int accuracy = (int) (this.ZW.hasAccuracy() ? this.ZW.getAccuracy() : 10.0f);
            float speed = (float) (this.ZW.getSpeed() * 3.6d);
            if (!this.ZW.hasSpeed()) {
                speed = -1.0f;
            }
            double[] dArr2 = new double[2];
            if (com.baidu.location.d.d.rU().b(this.ZW.getLongitude(), this.ZW.getLatitude())) {
                double[] coorEncrypt = Jni.coorEncrypt(this.ZW.getLongitude(), this.ZW.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                if (coorEncrypt[0] > 0.0d || coorEncrypt[1] > 0.0d) {
                    dArr = coorEncrypt;
                    z = true;
                } else {
                    coorEncrypt[0] = this.ZW.getLongitude();
                    coorEncrypt[1] = this.ZW.getLatitude();
                    dArr = coorEncrypt;
                    z = true;
                }
            } else {
                dArr2[0] = this.ZW.getLongitude();
                dArr2[1] = this.ZW.getLatitude();
                dArr = dArr2;
                z = false;
            }
            String format = String.format(Locale.CHINA, str, Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.ZW.getBearing()), Float.valueOf(speed), Integer.valueOf(m));
            if (!z) {
                format = format + ",\"in_cn\":\"0\"";
            }
            return this.ZW.hasAltitude() ? format + String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.ZW.getAltitude())) : format + "}}";
        }
        return null;
    }

    public boolean h() {
        try {
            if (this.ZW != null && this.ZW.getLatitude() != 0.0d && this.ZW.getLongitude() != 0.0d) {
                if (m > 2) {
                    return true;
                }
                if (this.ZW.getExtras().getInt("satellites", 3) > 2) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return (this.ZW == null || this.ZW.getLatitude() == 0.0d || this.ZW.getLongitude() == 0.0d) ? false : true;
        }
    }

    public boolean i() {
        if (h() && System.currentTimeMillis() - this.t <= 10000) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.p || currentTimeMillis - this.o >= 3000) {
                return this.s;
            }
            return true;
        }
        return false;
    }

    public Location rM() {
        if (this.ZW != null && Math.abs(System.currentTimeMillis() - this.ZW.getTime()) <= 60000) {
            return this.ZW;
        }
        return null;
    }
}
