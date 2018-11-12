package com.baidu.location.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
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
import com.baidu.location.a.q;
import com.baidu.location.g.g;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes6.dex */
public class d {
    private int C;
    private int D;
    private GpsStatus afB;
    private a afC;
    private Location afy;
    private Context b;
    private boolean i;
    private static d afx = null;
    private static int n = 0;
    private static int o = 0;
    private static int p = 0;
    private static long q = 0;
    private static String A = null;
    private static double E = 100.0d;
    private static String F = "";
    private LocationManager c = null;
    private c afz = null;
    private e afA = null;
    private b afD = null;
    private boolean k = false;
    private C0087d afE = null;
    private OnNmeaMessageListener afF = null;
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
    /* loaded from: classes6.dex */
    public class a extends GnssStatus.Callback {
        private a() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            int i = 0;
            if (d.this.c == null) {
                return;
            }
            int satelliteCount = gnssStatus.getSatelliteCount();
            d.this.H.clear();
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
                    d.this.H.add(arrayList);
                }
            }
            int unused = d.n = i3;
            int unused2 = d.o = i;
            int unused3 = d.p = i2;
            long unused4 = d.q = System.currentTimeMillis();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            d.this.d((Location) null);
            d.this.b(false);
            int unused = d.n = 0;
            int unused2 = d.o = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b implements GpsStatus.Listener {
        private long b;

        private b() {
            this.b = 0L;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            if (d.this.c == null) {
                return;
            }
            switch (i) {
                case 2:
                    d.this.d((Location) null);
                    d.this.b(false);
                    int unused = d.n = 0;
                    int unused2 = d.o = 0;
                    return;
                case 3:
                default:
                    return;
                case 4:
                    if (d.this.t) {
                        try {
                            if (d.this.afB == null) {
                                d.this.afB = d.this.c.getGpsStatus(null);
                            } else {
                                d.this.c.getGpsStatus(d.this.afB);
                            }
                            d.this.C = 0;
                            d.this.D = 0;
                            double d = 0.0d;
                            d.this.H.clear();
                            int i2 = 0;
                            int i3 = 0;
                            int i4 = 0;
                            for (GpsSatellite gpsSatellite : d.this.afB.getSatellites()) {
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
                                    d.this.H.add(arrayList);
                                    if (gpsSatellite.getSnr() >= g.H) {
                                        d.f(d.this);
                                    }
                                }
                            }
                            if (i3 > 0) {
                                int unused3 = d.o = i3;
                                double unused4 = d.E = d / i3;
                            }
                            if (i4 > 0) {
                                this.b = System.currentTimeMillis();
                                int unused5 = d.n = i4;
                            } else if (System.currentTimeMillis() - this.b > 100) {
                                this.b = System.currentTimeMillis();
                                int unused6 = d.n = i4;
                            }
                            long unused7 = d.q = System.currentTimeMillis();
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
    /* loaded from: classes6.dex */
    public class c implements LocationListener {
        private c() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            d.this.w = System.currentTimeMillis();
            d.this.b(true);
            d.this.d(location);
            d.this.s = false;
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
                    d.this.r = System.currentTimeMillis();
                    d.this.s = true;
                    d.this.b(false);
                    return;
                case 2:
                    d.this.s = false;
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.e.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0087d implements GpsStatus.NmeaListener {
        private C0087d() {
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            if (d.this.b(str)) {
                d.this.a(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class e implements LocationListener {
        private long b;

        private e() {
            this.b = 0L;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!d.this.t && location != null && location.getProvider() == "gps" && System.currentTimeMillis() - this.b >= ErrDef.Feature.WEIGHT && p.a(location, false)) {
                this.b = System.currentTimeMillis();
                d.this.B.sendMessage(d.this.B.obtainMessage(4, location));
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
        this.i = false;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.i = true;
            } catch (ClassNotFoundException e2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Location location) {
        if (location == null) {
            return;
        }
        String str2 = str + com.baidu.location.a.a.tc().c();
        boolean f = f.tR().f();
        n.c(new com.baidu.location.e.a(com.baidu.location.e.b.tM().tN()));
        n.a(System.currentTimeMillis());
        n.a(new Location(location));
        n.a(str2);
        if (f) {
            return;
        }
        p.a(n.tp(), null, n.tq(), str2);
    }

    public static boolean a(Location location, Location location2, boolean z) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (!z || ((g.v != 3 && com.baidu.location.g.d.tY().a(location2.getLongitude(), location2.getLatitude())) || speed >= 5.0f)) {
            float distanceTo = location2.distanceTo(location);
            return speed > g.agh ? distanceTo > g.agj : speed > g.K ? distanceTo > g.agi : distanceTo > 5.0f;
        }
        return true;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Location location) {
        this.B.sendMessage(this.B.obtainMessage(1, location));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        Location location2;
        if (location == null) {
            this.afy = null;
            return;
        }
        int i = n;
        if (i == 0) {
            try {
                i = location.getExtras().getInt("satellites");
            } catch (Exception e2) {
            }
        }
        if (i != 0 || g.m) {
            if (this.k && location.getSpeed() == 0.0d && this.y != 0.0d && System.currentTimeMillis() - this.z < 2000.0d) {
                location.setSpeed((float) this.y);
            }
            this.afy = location;
            int i2 = n;
            if (this.afy == null) {
                this.u = null;
                location2 = null;
            } else {
                Location location3 = new Location(this.afy);
                long currentTimeMillis = System.currentTimeMillis();
                this.afy.setTime(currentTimeMillis);
                float speed = (float) (this.afy.getSpeed() * 3.6d);
                if (!this.afy.hasSpeed()) {
                    speed = -1.0f;
                }
                if (i2 == 0) {
                    try {
                        i2 = this.afy.getExtras().getInt("satellites");
                    } catch (Exception e3) {
                    }
                }
                this.u = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.afy.getLongitude()), Double.valueOf(this.afy.getLatitude()), Float.valueOf(speed), Float.valueOf(this.afy.getBearing()), Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
                location2 = location3;
            }
            if (i() && this.afy != null) {
                F = k();
                com.baidu.location.a.a.tc().a(f());
                if (n > 2 && p.a(this.afy, true)) {
                    boolean f = f.tR().f();
                    n.c(new com.baidu.location.e.a(com.baidu.location.e.b.tM().tN()));
                    n.a(System.currentTimeMillis());
                    n.a(new Location(this.afy));
                    n.a(com.baidu.location.a.a.tc().c());
                    if (!f) {
                        q.tt().b();
                    }
                }
            }
            q.tt().a(location2, n);
        }
    }

    static /* synthetic */ int f(d dVar) {
        int i = dVar.D;
        dVar.D = i + 1;
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
        return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d&ll_snr=%.1f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(location.hasBearing() ? location.getBearing() : -1.0f), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)), Integer.valueOf(n), Double.valueOf(location.hasAltitude() ? location.getAltitude() : 555.0d), Long.valueOf(location.getTime() / 1000), Integer.valueOf(n), Integer.valueOf(o), Double.valueOf(E));
    }

    public static String h(Location location) {
        String g = g(location);
        return g != null ? g + "&g_tp=0" : g;
    }

    public static String i(Location location) {
        String g = g(location);
        return g != null ? g + A : g;
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

    public static synchronized d tP() {
        d dVar;
        synchronized (d.class) {
            if (afx == null) {
                afx = new d();
            }
            dVar = afx;
        }
        return dVar;
    }

    public void a(String str) {
        if (str.length() != 0 && b(str)) {
            if (str.startsWith("$GPPWR,") || str.startsWith("$GNGST,") || str.startsWith("$GPGST,") || str.startsWith("$GLGSV,") || str.startsWith("$GNGSV,") || str.startsWith("$BDGSV,") || str.startsWith("$GPZDA,") || str.startsWith("$GPGSA,") || str.startsWith("$GNVTG,") || str.startsWith("$GPVTG,") || str.startsWith("$GNGSA,") || str.startsWith("$GPNTR,") || str.startsWith("$GNGGA,") || str.startsWith("$GPGGA,") || str.startsWith("$GPRMC,") || str.startsWith("$GPGSV,") || str.startsWith("$BDGSA,")) {
                String[] split = str.split(",");
                a(str, ",");
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
                this.c = (LocationManager) this.b.getSystemService(Headers.LOCATION);
                if (this.i) {
                    this.afC = new a();
                    this.c.registerGnssStatusCallback(this.afC);
                } else {
                    this.afD = new b();
                    this.c.addGpsStatusListener(this.afD);
                }
                if (this.k) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        this.afF = new OnNmeaMessageListener() { // from class: com.baidu.location.e.d.1
                            @Override // android.location.OnNmeaMessageListener
                            public void onNmeaMessage(String str, long j) {
                                if (d.this.b(str)) {
                                    d.this.a(str);
                                }
                            }
                        };
                        this.c.addNmeaListener(this.afF);
                    } else {
                        this.afE = new C0087d();
                        this.c.addNmeaListener(this.afE);
                    }
                }
                this.afA = new e();
                this.c.requestLocationUpdates("passive", 9000L, 0.0f, this.afA);
            } catch (Exception e2) {
            }
            this.B = new Handler() { // from class: com.baidu.location.e.d.2
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
        Log.d(com.baidu.location.g.a.a, "start gps...");
        if (this.t) {
            return;
        }
        try {
            this.afz = new c();
            try {
                this.c.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
            } catch (Exception e2) {
            }
            this.c.requestLocationUpdates("gps", 1000L, 0.0f, this.afz);
            this.G = System.currentTimeMillis();
            this.t = true;
        } catch (Exception e3) {
        }
    }

    public void d() {
        if (this.t) {
            if (this.c != null) {
                try {
                    if (this.afz != null) {
                        this.c.removeUpdates(this.afz);
                    }
                } catch (Exception e2) {
                }
            }
            g.d = 0;
            g.v = 0;
            this.afz = null;
            this.t = false;
            b(false);
        }
    }

    public synchronized void e() {
        d();
        if (this.c != null) {
            try {
                if (this.afD != null) {
                    this.c.removeGpsStatusListener(this.afD);
                }
                if (this.i && this.afC != null) {
                    this.c.unregisterGnssStatusCallback(this.afC);
                }
                if (this.k && this.afE != null) {
                    this.c.removeNmeaListener(this.afE);
                }
                this.c.removeUpdates(this.afA);
            } catch (Exception e2) {
            }
            this.afD = null;
            this.c = null;
        }
    }

    public String f() {
        double[] dArr;
        boolean z;
        if (this.afy != null) {
            String str = "{\"result\":{\"time\":\"" + g.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
            int accuracy = (int) (this.afy.hasAccuracy() ? this.afy.getAccuracy() : 10.0f);
            float speed = (float) (this.afy.getSpeed() * 3.6d);
            if (!this.afy.hasSpeed()) {
                speed = -1.0f;
            }
            double[] dArr2 = new double[2];
            if (com.baidu.location.g.d.tY().a(this.afy.getLongitude(), this.afy.getLatitude())) {
                double[] coorEncrypt = Jni.coorEncrypt(this.afy.getLongitude(), this.afy.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                if (coorEncrypt[0] > 0.0d || coorEncrypt[1] > 0.0d) {
                    dArr = coorEncrypt;
                    z = true;
                } else {
                    coorEncrypt[0] = this.afy.getLongitude();
                    coorEncrypt[1] = this.afy.getLatitude();
                    dArr = coorEncrypt;
                    z = true;
                }
            } else {
                dArr2[0] = this.afy.getLongitude();
                dArr2[1] = this.afy.getLatitude();
                dArr = dArr2;
                z = false;
            }
            String format = String.format(Locale.CHINA, str, Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.afy.getBearing()), Float.valueOf(speed), Integer.valueOf(n));
            if (!z) {
                format = format + ",\"in_cn\":\"0\"";
            }
            return this.afy.hasAltitude() ? format + String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.afy.getAltitude())) : format + "}}";
        }
        return null;
    }

    public boolean h() {
        try {
            if (this.afy != null && this.afy.getLatitude() != 0.0d && this.afy.getLongitude() != 0.0d) {
                if (n > 2) {
                    return true;
                }
                if (this.afy.getExtras().getInt("satellites", 3) > 2) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            return (this.afy == null || this.afy.getLatitude() == 0.0d || this.afy.getLongitude() == 0.0d) ? false : true;
        }
    }

    public boolean i() {
        if (h() && System.currentTimeMillis() - this.w <= ErrDef.Feature.WEIGHT) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.s || currentTimeMillis - this.r >= 3000) {
                return this.v;
            }
            return true;
        }
        return false;
    }

    public Location tQ() {
        if (this.afy != null && Math.abs(System.currentTimeMillis() - this.afy.getTime()) <= 60000) {
            return this.afy;
        }
        return null;
    }
}
