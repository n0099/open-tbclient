package com.baidu.location.f;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class e extends g {
    private static e PR = null;
    private static int k = 0;
    private static String r = null;
    private Location PS;
    private GpsStatus PV;
    private HashMap<Integer, List<GpsSatellite>> PY;
    private Context d;
    private int x;
    private int y;
    private final long a = 1000;
    private final long b = 9000;
    private LocationManager e = null;
    private b PT = null;
    private c PU = null;
    private a PW = null;
    private long l = 0;
    private boolean m = false;
    private boolean n = false;
    private String o = null;
    private boolean p = false;
    private long Pl = 0;
    private Handler PX = null;
    private final int t = 1;
    private final int u = 2;
    private final int v = 3;
    private final int w = 4;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements GpsStatus.Listener, GpsStatus.NmeaListener {
        long a;
        private long c;
        private final int d;
        private boolean e;
        private List<String> f;
        private String g;
        private String h;
        private String i;

        private a() {
            this.a = 0L;
            this.c = 0L;
            this.d = 400;
            this.e = false;
            this.f = new ArrayList();
            this.g = null;
            this.h = null;
            this.i = null;
        }

        /* synthetic */ a(e eVar, h hVar) {
            this();
        }

        public void a(String str) {
            if (System.currentTimeMillis() - this.c > 400 && this.e && this.f.size() > 0) {
                try {
                    m mVar = new m(this.f, this.g, this.h, this.i);
                    if (mVar.a()) {
                        com.baidu.location.h.i.d = e.this.a(mVar, e.this.y);
                        if (com.baidu.location.h.i.d > 0) {
                            String unused = e.r = String.format(Locale.CHINA, "&nmea=%.1f|%.1f&g_tp=%d", Double.valueOf(mVar.c()), Double.valueOf(mVar.b()), Integer.valueOf(com.baidu.location.h.i.d));
                        }
                    } else {
                        com.baidu.location.h.i.d = 0;
                    }
                } catch (Exception e) {
                    com.baidu.location.h.i.d = 0;
                }
                this.f.clear();
                this.i = null;
                this.h = null;
                this.g = null;
                this.e = false;
            }
            if (str.startsWith("$GPGGA")) {
                this.e = true;
                this.g = str.trim();
            } else if (str.startsWith("$GPGSV")) {
                this.f.add(str.trim());
            } else if (str.startsWith("$GPGSA")) {
                this.i = str.trim();
            }
            this.c = System.currentTimeMillis();
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            if (e.this.e == null) {
                return;
            }
            switch (i) {
                case 2:
                    e.this.e((Location) null);
                    e.this.b(false);
                    int unused = e.k = 0;
                    return;
                case 3:
                default:
                    return;
                case 4:
                    if (e.this.n) {
                        try {
                            if (e.this.PV == null) {
                                e.this.PV = e.this.e.getGpsStatus(null);
                            } else {
                                e.this.e.getGpsStatus(e.this.PV);
                            }
                            e.this.x = 0;
                            e.this.y = 0;
                            e.this.PY = new HashMap();
                            int i2 = 0;
                            for (GpsSatellite gpsSatellite : e.this.PV.getSatellites()) {
                                if (gpsSatellite.usedInFix()) {
                                    i2++;
                                    if (gpsSatellite.getSnr() >= com.baidu.location.h.i.E) {
                                        e.f(e.this);
                                    }
                                    e.this.a(gpsSatellite, e.this.PY);
                                }
                            }
                            int unused2 = e.k = i2;
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
            }
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            if (e.this.n) {
                if (!com.baidu.location.c.c.nf().g) {
                    com.baidu.location.h.i.d = 0;
                } else if (str == null || str.equals("") || str.length() < 9 || str.length() > 150 || !e.this.i()) {
                } else {
                    e.this.PX.sendMessage(e.this.PX.obtainMessage(2, str));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements LocationListener {
        private b() {
        }

        /* synthetic */ b(e eVar, h hVar) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            e.this.Pl = System.currentTimeMillis();
            e.this.b(true);
            e.this.e(location);
            e.this.m = false;
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            e.this.e((Location) null);
            e.this.b(false);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            switch (i) {
                case 0:
                    e.this.e((Location) null);
                    e.this.b(false);
                    return;
                case 1:
                    e.this.l = System.currentTimeMillis();
                    e.this.m = true;
                    e.this.b(false);
                    return;
                case 2:
                    e.this.m = false;
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements LocationListener {
        private long b;

        private c() {
            this.b = 0L;
        }

        /* synthetic */ c(e eVar, h hVar) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!e.this.n && location != null && location.getProvider() == "gps" && System.currentTimeMillis() - this.b >= 10000 && com.baidu.location.a.j.a(location, false)) {
                this.b = System.currentTimeMillis();
                e.this.PX.sendMessage(e.this.PX.obtainMessage(4, location));
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(m mVar, int i) {
        if (k >= com.baidu.location.h.i.B) {
            return 1;
        }
        if (k <= com.baidu.location.h.i.A) {
            return 4;
        }
        double c2 = mVar.c();
        if (c2 > com.baidu.location.h.i.w) {
            if (c2 >= com.baidu.location.h.i.x) {
                return 4;
            }
            double b2 = mVar.b();
            if (b2 > com.baidu.location.h.i.y) {
                if (b2 >= com.baidu.location.h.i.z) {
                    return 4;
                }
                if (i < com.baidu.location.h.i.D) {
                    if (i <= com.baidu.location.h.i.C) {
                        return 4;
                    }
                    if (this.PY != null) {
                        return e(this.PY);
                    }
                    return 3;
                }
                return 1;
            }
            return 1;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(GpsSatellite gpsSatellite, HashMap<Integer, List<GpsSatellite>> hashMap) {
        int floor = (int) Math.floor(gpsSatellite.getAzimuth() / 6.0f);
        float elevation = gpsSatellite.getElevation();
        int floor2 = (int) Math.floor(elevation / 1.5d);
        float snr = gpsSatellite.getSnr();
        int round = Math.round(snr / 5.0f);
        int prn = gpsSatellite.getPrn();
        int i = prn >= 65 ? prn - 32 : prn;
        if (snr >= 10.0f && elevation >= 1.0f) {
            List<GpsSatellite> list = hashMap.get(Integer.valueOf(round));
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(gpsSatellite);
            hashMap.put(Integer.valueOf(round), list);
            this.x++;
        }
        if (floor >= 64) {
        }
        if (floor2 >= 64) {
        }
        if (i >= 65) {
        }
        return null;
    }

    private void a(double d, double d2, float f) {
        int i = 0;
        if (com.baidu.location.c.c.nf().f) {
            if (d >= 73.146973d && d <= 135.252686d && d2 <= 54.258807d && d2 >= 14.604847d && f <= 18.0f) {
                int i2 = (int) ((d - com.baidu.location.h.i.Nz) * 1000.0d);
                int i3 = (int) ((com.baidu.location.h.i.NA - d2) * 1000.0d);
                if (i2 <= 0 || i2 >= 50 || i3 <= 0 || i3 >= 50) {
                    com.baidu.location.h.i.Nx = d;
                    com.baidu.location.h.i.Ny = d2;
                    com.baidu.location.c.c.nf().a(String.format(Locale.CHINA, "&ll=%.5f|%.5f", Double.valueOf(d), Double.valueOf(d2)) + "&im=" + com.baidu.location.h.c.nP().b());
                } else {
                    int i4 = i2 + (i3 * 50);
                    int i5 = i4 >> 2;
                    int i6 = i4 & 3;
                    if (com.baidu.location.h.i.u) {
                        i = (com.baidu.location.h.i.t[i5] >> (i6 * 2)) & 3;
                    }
                }
            }
            if (com.baidu.location.h.i.s != i) {
                com.baidu.location.h.i.s = i;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Location location) {
        if (location == null) {
            return;
        }
        String str2 = str + com.baidu.location.a.a.mP().c();
        boolean d = j.nJ().d();
        com.baidu.location.a.h.c(new com.baidu.location.f.a(com.baidu.location.f.b.nA().nB()));
        com.baidu.location.a.h.a(System.currentTimeMillis());
        com.baidu.location.a.h.b(new Location(location));
        com.baidu.location.a.h.a(str2);
        if (d) {
            return;
        }
        com.baidu.location.a.j.a(com.baidu.location.a.h.mW(), null, com.baidu.location.a.h.mX(), str2);
    }

    public static boolean a(Location location, Location location2, boolean z) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (!z || ((com.baidu.location.h.i.s != 3 && com.baidu.location.h.e.nR().e(location2.getLongitude(), location2.getLatitude())) || speed >= 5.0f)) {
            float distanceTo = location2.distanceTo(location);
            return speed > com.baidu.location.h.i.I ? distanceTo > com.baidu.location.h.i.K : speed > com.baidu.location.h.i.H ? distanceTo > com.baidu.location.h.i.J : distanceTo > 5.0f;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.p = z;
        if (!z || !i()) {
        }
    }

    private double[] c(double d, double d2) {
        return new double[]{Math.sin(Math.toRadians(d2)) * d, Math.cos(Math.toRadians(d2)) * d};
    }

    private double[] d(double d, double d2) {
        double d3 = 0.0d;
        if (d2 != 0.0d) {
            d3 = Math.toDegrees(Math.atan(d / d2));
        } else if (d > 0.0d) {
            d3 = 90.0d;
        } else if (d < 0.0d) {
            d3 = 270.0d;
        }
        return new double[]{Math.sqrt((d * d) + (d2 * d2)), d3};
    }

    private int e(HashMap<Integer, List<GpsSatellite>> hashMap) {
        int i;
        double[] i2;
        if (this.x > 4) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            for (Map.Entry<Integer, List<GpsSatellite>> entry : hashMap.entrySet()) {
                List<GpsSatellite> value = entry.getValue();
                if (value == null || (i2 = i(value)) == null) {
                    i = i3;
                } else {
                    arrayList.add(i2);
                    i = i3 + 1;
                    arrayList2.add(Integer.valueOf(i3));
                }
                i3 = i;
            }
            if (!arrayList.isEmpty()) {
                double[] dArr = new double[2];
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    double[] dArr2 = (double[]) arrayList.get(i4);
                    int intValue = ((Integer) arrayList2.get(i4)).intValue();
                    dArr2[0] = dArr2[0] * intValue;
                    dArr2[1] = dArr2[1] * intValue;
                    dArr[0] = dArr[0] + dArr2[0];
                    dArr[1] = dArr2[1] + dArr[1];
                }
                dArr[0] = dArr[0] / size;
                dArr[1] = dArr[1] / size;
                double[] d = d(dArr[0], dArr[1]);
                if (d[0] <= com.baidu.location.h.i.F) {
                    return 1;
                }
                if (d[0] >= com.baidu.location.h.i.G) {
                    return 4;
                }
            }
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        this.PX.sendMessage(this.PX.obtainMessage(1, location));
    }

    static /* synthetic */ int f(e eVar) {
        int i = eVar.y;
        eVar.y = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Location location) {
        if (location == null) {
            this.PS = null;
            return;
        }
        int i = k;
        if (i == 0) {
            try {
                i = location.getExtras().getInt("satellites");
            } catch (Exception e) {
            }
        }
        if (i != 0 || com.baidu.location.h.i.k) {
            this.PS = location;
            if (this.PS == null) {
                this.o = null;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                this.PS.setTime(currentTimeMillis);
                float speed = (float) (this.PS.getSpeed() * 3.6d);
                if (!this.PS.hasSpeed()) {
                    speed = -1.0f;
                }
                int i2 = k;
                if (i2 == 0) {
                    try {
                        i2 = this.PS.getExtras().getInt("satellites");
                    } catch (Exception e2) {
                    }
                }
                this.o = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.PS.getLongitude()), Double.valueOf(this.PS.getLatitude()), Float.valueOf(speed), Float.valueOf(this.PS.getBearing()), Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
                a(this.PS.getLongitude(), this.PS.getLatitude(), speed);
            }
            try {
                com.baidu.location.a.c.mQ().a(this.PS);
            } catch (Exception e3) {
            }
            if (this.PS != null) {
                com.baidu.location.c.e.nh().b(this.PS);
            }
            if (!i() || this.PS == null) {
                return;
            }
            com.baidu.location.a.a.mP().a(f());
            if (k <= 2 || !com.baidu.location.a.j.a(this.PS, true)) {
                return;
            }
            boolean d = j.nJ().d();
            com.baidu.location.a.h.c(new com.baidu.location.f.a(com.baidu.location.f.b.nA().nB()));
            com.baidu.location.a.h.a(System.currentTimeMillis());
            com.baidu.location.a.h.b(new Location(this.PS));
            com.baidu.location.a.h.a(com.baidu.location.a.a.mP().c());
            if (d) {
                return;
            }
            com.baidu.location.a.j.a(com.baidu.location.a.h.mW(), null, com.baidu.location.a.h.mX(), com.baidu.location.a.a.mP().c());
        }
    }

    public static String g(Location location) {
        if (location == null) {
            return null;
        }
        float speed = (float) (location.getSpeed() * 3.6d);
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(location.hasBearing() ? location.getBearing() : -1.0f), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)), Integer.valueOf(k), Double.valueOf(location.hasAltitude() ? location.getAltitude() : 555.0d), Long.valueOf(location.getTime() / 1000));
    }

    public static String h(Location location) {
        String g = g(location);
        return g != null ? g + "&g_tp=0" : g;
    }

    public static String i(Location location) {
        String g = g(location);
        return g != null ? g + r : g;
    }

    private double[] i(List<GpsSatellite> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        double[] dArr = new double[2];
        for (GpsSatellite gpsSatellite : list) {
            if (gpsSatellite != null) {
                double[] c2 = c(90.0f - gpsSatellite.getElevation(), gpsSatellite.getAzimuth());
                dArr[0] = dArr[0] + c2[0];
                dArr[1] = dArr[1] + c2[1];
            }
        }
        int size = list.size();
        dArr[0] = dArr[0] / size;
        dArr[1] = dArr[1] / size;
        return dArr;
    }

    public static synchronized e nG() {
        e eVar;
        synchronized (e.class) {
            if (PR == null) {
                PR = new e();
            }
            eVar = PR;
        }
        return eVar;
    }

    @Override // com.baidu.location.f.g
    public void a(boolean z) {
        if (z) {
            c();
        } else {
            d();
        }
    }

    @Override // com.baidu.location.f.g
    public synchronized void b() {
        if (com.baidu.location.f.isServing) {
            this.d = com.baidu.location.f.getServiceContext();
            try {
                this.e = (LocationManager) this.d.getSystemService("location");
                this.PW = new a(this, null);
                this.e.addGpsStatusListener(this.PW);
                this.PU = new c(this, null);
                this.e.requestLocationUpdates("passive", 9000L, 0.0f, this.PU);
            } catch (Exception e) {
            }
            this.PX = new h(this);
        }
    }

    @Override // com.baidu.location.f.g
    public void c() {
        b();
        if (this.n) {
            return;
        }
        try {
            this.PT = new b(this, null);
            this.e.requestLocationUpdates("gps", 1000L, 0.0f, this.PT);
            this.e.addNmeaListener(this.PW);
            this.n = true;
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.location.f.g
    public void d() {
        if (this.n) {
            if (this.e != null) {
                try {
                    if (this.PT != null) {
                        this.e.removeUpdates(this.PT);
                    }
                    if (this.PW != null) {
                        this.e.removeNmeaListener(this.PW);
                    }
                } catch (Exception e) {
                }
            }
            com.baidu.location.h.i.d = 0;
            com.baidu.location.h.i.s = 0;
            this.PT = null;
            this.n = false;
            b(false);
        }
    }

    @Override // com.baidu.location.f.g
    public synchronized void e() {
        d();
        if (this.e != null) {
            try {
                if (this.PW != null) {
                    this.e.removeGpsStatusListener(this.PW);
                }
                this.e.removeUpdates(this.PU);
            } catch (Exception e) {
            }
            this.PW = null;
            this.e = null;
        }
    }

    @Override // com.baidu.location.f.g
    public String f() {
        double[] dArr;
        boolean z;
        if (this.PS != null) {
            String str = "{\"result\":{\"time\":\"" + com.baidu.location.h.i.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
            int accuracy = (int) (this.PS.hasAccuracy() ? this.PS.getAccuracy() : 10.0f);
            float speed = (float) (this.PS.getSpeed() * 3.6d);
            if (!this.PS.hasSpeed()) {
                speed = -1.0f;
            }
            double[] dArr2 = new double[2];
            if (com.baidu.location.h.e.nR().e(this.PS.getLongitude(), this.PS.getLatitude())) {
                double[] coorEncrypt = Jni.coorEncrypt(this.PS.getLongitude(), this.PS.getLatitude(), "gps2gcj");
                if (coorEncrypt[0] > 0.0d || coorEncrypt[1] > 0.0d) {
                    dArr = coorEncrypt;
                    z = true;
                } else {
                    coorEncrypt[0] = this.PS.getLongitude();
                    coorEncrypt[1] = this.PS.getLatitude();
                    dArr = coorEncrypt;
                    z = true;
                }
            } else {
                dArr2[0] = this.PS.getLongitude();
                dArr2[1] = this.PS.getLatitude();
                dArr = dArr2;
                z = false;
            }
            String format = String.format(Locale.CHINA, str, Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.PS.getBearing()), Float.valueOf(speed), Integer.valueOf(k));
            if (!z) {
                format = format + ",\"in_cn\":\"0\"";
            }
            return this.PS.hasAltitude() ? format + String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.PS.getAltitude())) : format + "}}";
        }
        return null;
    }

    @Override // com.baidu.location.f.g
    public boolean h() {
        return (this.PS == null || this.PS.getLatitude() == 0.0d || this.PS.getLongitude() == 0.0d) ? false : true;
    }

    @Override // com.baidu.location.f.g
    public boolean i() {
        if (h() && System.currentTimeMillis() - this.Pl <= 10000) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.m || currentTimeMillis - this.l >= 3000) {
                return this.p;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.location.f.g
    public Location nH() {
        if (this.PS != null && Math.abs(System.currentTimeMillis() - this.PS.getTime()) <= TbConfig.USE_TIME_INTERVAL) {
            return this.PS;
        }
        return null;
    }
}
