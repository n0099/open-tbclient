package com.baidu.location.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
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
import android.os.Message;
import android.support.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.ab;
import com.baidu.location.b.ac;
import com.baidu.location.b.x;
import com.baidu.location.e.l;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
/* loaded from: classes20.dex */
public class f {
    private BDLocation ac;
    private String ag;
    private Context e;
    private Location g;
    private GpsStatus j;
    private c k;
    private boolean l;
    private boolean n;
    private static f d = null;
    public static int a = 0;
    private static int q = 0;
    private static int r = 0;
    private static int s = 0;
    private static int t = 0;
    private static int u = 0;
    private static long v = 0;
    private static String I = null;
    private static double K = 100.0d;
    public static String b = "";
    private static float N = -1.0f;
    private LocationManager f = null;
    private C0208f h = null;
    private h i = null;
    private d m = null;
    private GpsStatus.NmeaListener o = null;
    private OnNmeaMessageListener p = null;
    private long w = 0;
    private boolean x = false;
    private boolean y = false;
    private String z = null;
    private boolean A = false;
    private long B = 0;
    private double C = -1.0d;
    private double D = 0.0d;
    private double E = 0.0d;
    private long F = 0;
    private long G = 0;
    private long H = 0;
    private e J = null;
    private long L = 0;
    private long M = 0;
    private a O = null;
    private b P = null;
    private ArrayList<ArrayList<Float>> Q = new ArrayList<>();
    private ArrayList<ArrayList<Float>> R = new ArrayList<>();
    private ArrayList<ArrayList<Float>> S = new ArrayList<>();
    private ArrayList<ArrayList<Float>> T = new ArrayList<>();
    private ArrayList<ArrayList<Float>> U = new ArrayList<>();
    private String V = null;
    private long W = 0;
    private ArrayList<Integer> X = new ArrayList<>();
    private String Y = null;
    private long Z = 0;
    private long aa = -1;
    private long ab = -1;
    private boolean ad = false;
    private boolean ae = false;
    private long af = 0;
    public long c = 0;

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes20.dex */
    public class a extends GnssMeasurementsEvent.Callback {
        public int a;
        public String b;

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            if (this.a != 1 || gnssMeasurementsEvent == null) {
                return;
            }
            this.b = gnssMeasurementsEvent.toString();
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(int i) {
            this.a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes20.dex */
    public class b extends GnssNavigationMessage.Callback {
        public int a;

        private b() {
            this.a = 0;
        }

        /* synthetic */ b(f fVar, com.baidu.location.c.g gVar) {
            this();
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onGnssNavigationMessageReceived(GnssNavigationMessage gnssNavigationMessage) {
            if (f.this.H != 0) {
                ac.a().a(gnssNavigationMessage, f.this.H);
            } else {
                ac.a().a(gnssNavigationMessage, System.currentTimeMillis() / 1000);
            }
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onStatusChanged(int i) {
            this.a = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes20.dex */
    public class c extends GnssStatus.Callback {
        private c() {
        }

        /* synthetic */ c(f fVar, com.baidu.location.c.g gVar) {
            this();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            int i;
            int i2;
            if (f.this.f == null) {
                return;
            }
            f.this.M = System.currentTimeMillis();
            int satelliteCount = gnssStatus.getSatelliteCount();
            f.this.R.clear();
            f.this.S.clear();
            f.this.T.clear();
            f.this.U.clear();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i3 < satelliteCount) {
                int i7 = i4 + 1;
                ArrayList arrayList = new ArrayList();
                int constellationType = gnssStatus.getConstellationType(i3);
                arrayList.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i3)));
                arrayList.add(Float.valueOf(gnssStatus.getElevationDegrees(i3)));
                arrayList.add(Float.valueOf(gnssStatus.getCn0DbHz(i3)));
                if (gnssStatus.usedInFix(i3)) {
                    i2 = i6 + 1;
                    arrayList.add(Float.valueOf(1.0f));
                    i = constellationType == 1 ? i5 + 1 : i5;
                } else {
                    arrayList.add(Float.valueOf(0.0f));
                    i = i5;
                    i2 = i6;
                }
                arrayList.add(Float.valueOf(gnssStatus.getSvid(i3)));
                if (constellationType == 1) {
                    arrayList.add(Float.valueOf(1.0f));
                    f.this.R.add(arrayList);
                } else if (constellationType == 5) {
                    arrayList.add(Float.valueOf(2.0f));
                    f.this.S.add(arrayList);
                } else if (constellationType == 3) {
                    arrayList.add(Float.valueOf(3.0f));
                    f.this.T.add(arrayList);
                } else if (constellationType == 6) {
                    arrayList.add(Float.valueOf(4.0f));
                    f.this.U.add(arrayList);
                }
                i3++;
                i4 = i7;
                i5 = i;
                i6 = i2;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(f.this.R);
            arrayList2.addAll(f.this.S);
            arrayList2.addAll(f.this.T);
            arrayList2.addAll(f.this.U);
            f.this.b(arrayList2);
            f.this.Q = f.this.a(true, false, false, false, true, -1.0f);
            f.b = f.this.a(f.this.Q);
            f.a = i6;
            int unused = f.q = i5;
            int unused2 = f.u = i4;
            long unused3 = f.v = System.currentTimeMillis();
            int unused4 = f.r = f.this.a((ArrayList<ArrayList<Float>>) f.this.T, true, -1.0f).size();
            int unused5 = f.s = f.this.a((ArrayList<ArrayList<Float>>) f.this.U, true, -1.0f).size();
            int unused6 = f.t = f.this.a((ArrayList<ArrayList<Float>>) f.this.S, true, -1.0f).size();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            f.this.d((Location) null);
            f.this.b(false);
            f.a = 0;
            int unused = f.q = 0;
            int unused2 = f.r = 0;
            int unused3 = f.s = 0;
            int unused4 = f.t = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class d implements GpsStatus.Listener {
        private long b;

        private d() {
            this.b = 0L;
        }

        /* synthetic */ d(f fVar, com.baidu.location.c.g gVar) {
            this();
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            int i2;
            int i3;
            int i4 = 0;
            if (f.this.f == null) {
                return;
            }
            switch (i) {
                case 2:
                    f.this.d((Location) null);
                    f.this.b(false);
                    f.a = 0;
                    int unused = f.q = 0;
                    int unused2 = f.r = 0;
                    int unused3 = f.s = 0;
                    int unused4 = f.t = 0;
                    return;
                case 3:
                default:
                    return;
                case 4:
                    if (f.this.y) {
                        try {
                            if (f.this.j == null) {
                                f.this.j = f.this.f.getGpsStatus(null);
                            } else {
                                f.this.f.getGpsStatus(f.this.j);
                            }
                            f.this.M = System.currentTimeMillis();
                            f.this.R.clear();
                            f.this.S.clear();
                            f.this.T.clear();
                            f.this.U.clear();
                            int i5 = 0;
                            int i6 = 0;
                            for (GpsSatellite gpsSatellite : f.this.j.getSatellites()) {
                                int i7 = i4 + 1;
                                ArrayList arrayList = new ArrayList();
                                int prn = gpsSatellite.getPrn();
                                arrayList.add(Float.valueOf(gpsSatellite.getAzimuth()));
                                arrayList.add(Float.valueOf(gpsSatellite.getElevation()));
                                arrayList.add(Float.valueOf(gpsSatellite.getSnr()));
                                if (gpsSatellite.usedInFix()) {
                                    i3 = i6 + 1;
                                    arrayList.add(Float.valueOf(1.0f));
                                    i2 = (prn < 1 || prn > 32) ? i5 : i5 + 1;
                                } else {
                                    arrayList.add(Float.valueOf(0.0f));
                                    i2 = i5;
                                    i3 = i6;
                                }
                                arrayList.add(Float.valueOf(prn));
                                if (prn >= 1 && prn <= 32) {
                                    arrayList.add(Float.valueOf(1.0f));
                                    f.this.R.add(arrayList);
                                } else if (prn >= 201 && prn <= 235) {
                                    arrayList.add(Float.valueOf(2.0f));
                                    f.this.S.add(arrayList);
                                } else if (prn >= 65 && prn <= 96) {
                                    arrayList.add(Float.valueOf(3.0f));
                                    f.this.T.add(arrayList);
                                } else if (prn >= 301 && prn <= 336) {
                                    arrayList.add(Float.valueOf(4.0f));
                                    f.this.U.add(arrayList);
                                }
                                i5 = i2;
                                i6 = i3;
                                i4 = i7;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.addAll(f.this.R);
                            arrayList2.addAll(f.this.S);
                            arrayList2.addAll(f.this.T);
                            arrayList2.addAll(f.this.U);
                            f.this.b(arrayList2);
                            f.this.Q = f.this.a(true, false, false, false, true, -1.0f);
                            f.b = f.this.a(f.this.Q);
                            if (i5 > 0) {
                                int unused5 = f.q = i5;
                            }
                            if (i6 > 0) {
                                this.b = System.currentTimeMillis();
                                f.a = i6;
                            } else if (System.currentTimeMillis() - this.b > 100) {
                                this.b = System.currentTimeMillis();
                                f.a = i6;
                            }
                            long unused6 = f.v = System.currentTimeMillis();
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
    /* loaded from: classes20.dex */
    public static class e extends Handler {
        WeakReference<f> a;
        f b;

        e(f fVar) {
            this.a = new WeakReference<>(fVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                this.b = this.a.get();
                if (this.b != null) {
                    switch (message.what) {
                        case 1:
                            this.b.f((Location) message.obj);
                            return;
                        case 2:
                        default:
                            return;
                        case 3:
                            this.b.a("&og=1", (Location) message.obj);
                            return;
                        case 4:
                            this.b.a("&og=2", (Location) message.obj);
                            return;
                        case 5:
                            this.b.a((String) message.obj);
                            return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.location.c.f$f  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C0208f implements LocationListener {
        private C0208f() {
        }

        /* synthetic */ C0208f(f fVar, com.baidu.location.c.g gVar) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d) {
                f.this.H = location.getTime() / 1000;
                f.this.aa = System.currentTimeMillis();
                if (f.this.G != 0) {
                    f.this.F = System.currentTimeMillis() - f.this.G;
                }
                f.this.G = System.currentTimeMillis();
                int i = f.a;
                if (i == 0) {
                    try {
                        i = location.getExtras().getInt("satellites");
                    } catch (Exception e) {
                    }
                }
                if (i == 0) {
                    long currentTimeMillis = System.currentTimeMillis() - f.this.M;
                }
                f.this.b(true);
                f.this.d(location);
                f.this.x = false;
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            f.this.d((Location) null);
            f.this.b(false);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            switch (i) {
                case 0:
                    f.this.d((Location) null);
                    f.this.b(false);
                    return;
                case 1:
                    f.this.w = System.currentTimeMillis();
                    f.this.x = true;
                    f.this.b(false);
                    return;
                case 2:
                    f.this.x = false;
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class g implements GpsStatus.NmeaListener {
        private g() {
        }

        /* synthetic */ g(f fVar, com.baidu.location.c.g gVar) {
            this();
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            if (f.this.J != null) {
                f.this.J.sendMessage(f.this.J.obtainMessage(5, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class h implements LocationListener {
        private long b;

        private h() {
            this.b = 0L;
        }

        /* synthetic */ h(f fVar, com.baidu.location.c.g gVar) {
            this();
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!f.this.y && location != null && TextUtils.equals(location.getProvider(), "gps") && System.currentTimeMillis() - this.b >= 10000 && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d && ab.a(location, false)) {
                this.b = System.currentTimeMillis();
                if (f.this.J != null) {
                    f.this.c = System.currentTimeMillis();
                    f.this.J.sendMessage(f.this.J.obtainMessage(4, location));
                }
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

    private f() {
        this.l = false;
        this.n = false;
        this.ag = null;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Class.forName("android.location.GnssStatus");
                this.l = true;
            } catch (ClassNotFoundException e2) {
                this.l = false;
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                this.ag = Build.MANUFACTURER;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.n = false;
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (d == null) {
                d = new f();
            }
            fVar = d;
        }
        return fVar;
    }

    public static String a(Location location) {
        if (location == null) {
            return null;
        }
        float speed = (float) (location.getSpeed() * 3.6d);
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        int accuracy = (int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f);
        double altitude = location.hasAltitude() ? location.getAltitude() : 555.0d;
        float bearing = location.hasBearing() ? location.getBearing() : -1.0f;
        return N < -0.01f ? String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_snr=%.1f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(a), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(a), Integer.valueOf(q), Integer.valueOf(r), Integer.valueOf(s), Integer.valueOf(t), Double.valueOf(K)) : String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_snr=%.1f&ll_bp=%.2f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(a), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(a), Integer.valueOf(q), Integer.valueOf(r), Integer.valueOf(s), Integer.valueOf(t), Double.valueOf(K), Float.valueOf(N));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(ArrayList<ArrayList<Float>> arrayList) {
        StringBuilder sb = new StringBuilder();
        if (arrayList.size() == 0) {
            return sb.toString();
        }
        Iterator<ArrayList<Float>> it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            ArrayList<Float> next = it.next();
            if (next.size() == 6) {
                if (z) {
                    z = false;
                } else {
                    sb.append("|");
                }
                sb.append(String.format("%.1f;", next.get(0)));
                sb.append(String.format("%.1f;", next.get(1)));
                sb.append(String.format("%.1f;", next.get(2)));
                sb.append(String.format("%.0f;", next.get(3)));
                sb.append(String.format("%.0f", next.get(4)));
                sb.append(String.format("%.0f", next.get(5)));
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ArrayList<Float>> a(ArrayList<ArrayList<Float>> arrayList, boolean z, float f) {
        ArrayList<ArrayList<Float>> arrayList2 = new ArrayList<>();
        if (arrayList.size() > 40 || arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<ArrayList<Float>> it = arrayList.iterator();
        while (it.hasNext()) {
            ArrayList<Float> next = it.next();
            if (next.size() == 6) {
                float floatValue = next.get(3).floatValue();
                float floatValue2 = next.get(2).floatValue();
                if (!z || floatValue >= 1.0f) {
                    if (f <= 0.0f || floatValue2 >= f) {
                        arrayList2.add(next);
                    }
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ArrayList<Float>> a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, float f) {
        ArrayList<ArrayList<Float>> arrayList = new ArrayList<>();
        if (z) {
            arrayList.addAll(a(this.R, z5, f));
        }
        if (z2) {
            arrayList.addAll(a(this.S, z5, f));
        }
        if (z3) {
            arrayList.addAll(a(this.T, z5, f));
        }
        if (z4) {
            arrayList.addAll(a(this.U, z5, f));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (TextUtils.isEmpty(str) || !b(str)) {
            return;
        }
        if (str.startsWith("$GPGGA,")) {
            a(str, 2, 4, 6);
        } else if (str.startsWith("$GPRMC,")) {
            a(str, 3, 5, 2);
        }
    }

    private void a(String str, int i, int i2, int i3) {
        if (TextUtils.isEmpty(str) || !b(str)) {
            return;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (str.startsWith("$GPGGA,")) {
            if (split.length < 7) {
                return;
            }
        } else if (str.startsWith("$GPRMC,") && split.length < 6) {
            return;
        }
        if (TextUtils.isEmpty(split[i].trim()) || split[i].trim().length() <= 2) {
            this.ac = null;
        } else {
            try {
                double doubleValue = Double.valueOf(split[i].substring(0, 2)).doubleValue() + (Double.valueOf(split[i].substring(2)).doubleValue() / 60.0d);
                if (this.ac == null) {
                    this.ac = new BDLocation();
                }
                this.ac.setLatitude(doubleValue);
            } catch (NumberFormatException e2) {
                this.ae = true;
            }
        }
        if (this.ac == null || TextUtils.isEmpty(split[i2].trim()) || split[i2].trim().length() <= 3) {
            this.ac = null;
        } else {
            try {
                this.ac.setLongitude(Double.valueOf(split[i2].substring(0, 3)).doubleValue() + (Double.valueOf(split[i2].substring(3)).doubleValue() / 60.0d));
            } catch (NumberFormatException e3) {
                this.ae = true;
            }
        }
        if (!TextUtils.isEmpty(split[i3].trim())) {
            if (i3 == 2) {
                if (TextUtils.equals(split[i3], ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                    this.ad = false;
                } else if (TextUtils.equals(split[i3], ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)) {
                    this.ad = true;
                }
            } else if (i3 == 6) {
                if (TextUtils.equals(split[i3], "0")) {
                    this.ad = false;
                } else {
                    this.ad = true;
                }
            }
        }
        if (this.ac != null) {
            this.ae = false;
        }
        this.ab = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Location location) {
        if (location == null) {
            return;
        }
        String str2 = str + com.baidu.location.b.b.a().c();
        boolean e2 = i.a().e();
        x.a(new com.baidu.location.c.a(com.baidu.location.c.b.a().f()));
        x.a(System.currentTimeMillis());
        x.a(new Location(location));
        x.a(str2);
        if (e2) {
            return;
        }
        ab.a(x.c(), null, x.d(), str2);
    }

    public static boolean a(Location location, Location location2, boolean z) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (!z || ((l.v != 3 && com.baidu.location.e.e.a().a(location2.getLongitude(), location2.getLatitude())) || speed >= 5.0f)) {
            float distanceTo = location2.distanceTo(location);
            return speed > l.L ? distanceTo > l.N : speed > l.K ? distanceTo > l.M : distanceTo > 5.0f;
        }
        return true;
    }

    public static String b(Location location) {
        String a2 = a(location);
        return a2 != null ? a2 + "&g_tp=0" : a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<ArrayList<Float>> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            this.V = null;
        } else {
            StringBuilder sb = new StringBuilder(100);
            sb.append(com.baidu.location.e.c.g(this.R)).append("|").append(com.baidu.location.e.c.f(this.R)).append("|").append(com.baidu.location.e.c.a(this.R)).append("|").append(com.baidu.location.e.c.h(this.R)).append("|").append(com.baidu.location.e.c.b(this.R)).append("|").append(com.baidu.location.e.c.c(this.R)).append("|").append(com.baidu.location.e.c.e(this.R)).append("|").append(com.baidu.location.e.c.d(this.R));
            this.V = sb.toString();
        }
        this.W = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.A = z;
        N = -1.0f;
    }

    private boolean b(String str) {
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
        return a2 != null ? a2 + I : a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Location location) {
        if (this.J != null) {
            this.J.sendMessage(this.J.obtainMessage(1, location));
        }
    }

    private int e(Location location) {
        if (location == null) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT <= 17 || !location.isFromMockProvider()) {
                if (Math.abs(this.aa - this.ab) >= IMConnection.RETRY_DELAY_TIMES) {
                    this.ab = -1L;
                    this.ae = false;
                    this.ad = false;
                    this.ac = null;
                } else if (this.ac == null) {
                    if (!this.ad) {
                        return 200;
                    }
                    if (this.ae) {
                        return 300;
                    }
                } else if (!this.ae && this.ad) {
                    return 400;
                }
                if (this.aa > 0) {
                    return this.ab == -1 ? 500 : 0;
                }
                return 0;
            }
            return 100;
        } catch (Error e2) {
            return 0;
        } catch (Exception e3) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Location location) {
        if (location == null) {
            this.g = null;
            return;
        }
        if (a == 0) {
            try {
                location.getExtras().getInt("satellites");
            } catch (Exception e2) {
            }
        }
        if (this.n && location.getSpeed() == 0.0d && this.D != 0.0d && System.currentTimeMillis() - this.E < 2000.0d) {
            location.setSpeed((float) this.D);
        }
        Location location2 = new Location(location);
        this.B = System.currentTimeMillis();
        this.g = location;
        int i = a;
        if (this.g == null) {
            this.z = null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            this.g.setTime(currentTimeMillis);
            float speed = (float) (this.g.getSpeed() * 3.6d);
            if (!this.g.hasSpeed()) {
                speed = -1.0f;
            }
            if (i == 0) {
                try {
                    i = this.g.getExtras().getInt("satellites");
                } catch (Exception e3) {
                }
            }
            this.z = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.g.getLongitude()), Double.valueOf(this.g.getLatitude()), Float.valueOf(speed), Float.valueOf(this.g.getBearing()), Integer.valueOf(i), Long.valueOf(currentTimeMillis));
        }
        if (this.g != null) {
            n();
            if (a > 2 && ab.a(this.g, true)) {
                boolean e4 = i.a().e();
                x.a(new com.baidu.location.c.a(com.baidu.location.c.b.a().f()));
                x.a(System.currentTimeMillis());
                x.a(new Location(this.g));
                x.a(com.baidu.location.b.b.a().c());
                if (!e4) {
                    ac.a().b();
                }
            }
        }
        ac.a().a(location2, a);
    }

    public static String l() {
        long currentTimeMillis = System.currentTimeMillis() - v;
        if (currentTimeMillis < 0 || currentTimeMillis >= IMConnection.RETRY_DELAY_TIMES) {
            return null;
        }
        return String.format(Locale.US, "&gsvn=%d&gsfn=%d", Integer.valueOf(u), Integer.valueOf(a));
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
            this.e = com.baidu.location.f.getServiceContext();
            try {
                this.f = (LocationManager) this.e.getSystemService("location");
                if (this.l) {
                    this.k = new c(this, null);
                    this.f.registerGnssStatusCallback(this.k);
                } else {
                    this.m = new d(this, null);
                    this.f.addGpsStatusListener(this.m);
                }
                this.i = new h(this, null);
                this.f.requestLocationUpdates("passive", 9000L, 0.0f, this.i);
            } catch (Exception e2) {
            }
            this.J = new e(this);
        }
    }

    public void c() {
        Log.d(com.baidu.location.e.a.a, "start gps...");
        if (this.y) {
            return;
        }
        try {
            this.h = new C0208f(this, null);
            try {
                this.f.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
            } catch (Exception e2) {
            }
            this.f.requestLocationUpdates("gps", 1000L, 0.0f, this.h);
            if (this.l && this.P == null && l.aC == 1 && new Random().nextDouble() < l.aB) {
                this.P = new b(this, null);
            }
            if (this.P != null) {
                this.f.registerGnssNavigationMessageCallback(this.P);
            }
            this.L = System.currentTimeMillis();
            if (!l.m && l.aL == 1) {
                if (Build.VERSION.SDK_INT >= 24) {
                    this.p = new com.baidu.location.c.g(this);
                    this.f.addNmeaListener(this.p);
                } else {
                    this.o = new g(this, null);
                    Class.forName("android.location.LocationManager").getMethod("addNmeaListener", GpsStatus.NmeaListener.class).invoke(this.f, this.o);
                }
            }
            this.y = true;
        } catch (Exception e3) {
        }
    }

    public void d() {
        if (this.y) {
            if (this.f != null) {
                try {
                    if (this.h != null) {
                        this.f.removeUpdates(this.h);
                    }
                    if (this.p != null) {
                        this.f.removeNmeaListener(this.p);
                    }
                    if (this.o != null) {
                        Class.forName("android.location.LocationManager").getMethod("removeNmeaListener", GpsStatus.NmeaListener.class).invoke(this.f, this.o);
                    }
                    if (this.P != null) {
                        this.f.unregisterGnssNavigationMessageCallback(this.P);
                    }
                    k();
                } catch (Exception e2) {
                }
            }
            l.d = 0;
            l.v = 0;
            this.h = null;
            this.y = false;
            b(false);
        }
    }

    public synchronized void e() {
        d();
        if (this.f != null) {
            try {
                if (this.m != null) {
                    this.f.removeGpsStatusListener(this.m);
                }
                if (this.l && this.k != null) {
                    this.f.unregisterGnssStatusCallback(this.k);
                }
                if (this.i != null) {
                    this.f.removeUpdates(this.i);
                    this.i = null;
                }
            } catch (Exception e2) {
            }
            try {
                if (this.J != null) {
                    this.J.removeCallbacksAndMessages(null);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.m = null;
            this.f = null;
        }
    }

    public String f() {
        double[] dArr;
        boolean z;
        if (this.g != null) {
            String str = "{\"result\":{\"time\":\"" + l.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
            int accuracy = (int) (this.g.hasAccuracy() ? this.g.getAccuracy() : 10.0f);
            float speed = (float) (this.g.getSpeed() * 3.6d);
            if (!this.g.hasSpeed()) {
                speed = -1.0f;
            }
            double[] dArr2 = new double[2];
            if (com.baidu.location.e.e.a().a(this.g.getLongitude(), this.g.getLatitude())) {
                double[] coorEncrypt = Jni.coorEncrypt(this.g.getLongitude(), this.g.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
                if (coorEncrypt[0] > 0.0d || coorEncrypt[1] > 0.0d) {
                    dArr = coorEncrypt;
                    z = true;
                } else {
                    coorEncrypt[0] = this.g.getLongitude();
                    coorEncrypt[1] = this.g.getLatitude();
                    dArr = coorEncrypt;
                    z = true;
                }
            } else {
                dArr2[0] = this.g.getLongitude();
                dArr2[1] = this.g.getLatitude();
                if (dArr2[0] <= 0.0d && dArr2[1] <= 0.0d) {
                    dArr2[0] = this.g.getLongitude();
                    dArr2[1] = this.g.getLatitude();
                }
                dArr = dArr2;
                z = false;
            }
            String format = String.format(Locale.CHINA, str, Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.g.getBearing()), Float.valueOf(speed), Integer.valueOf(a));
            if (!z) {
                format = format + ",\"in_cn\":\"0\"";
            }
            if (!l.m) {
                format = format + String.format(Locale.CHINA, ",\"is_mock\":%d", Integer.valueOf(e(this.g)));
            }
            return this.g.hasAltitude() ? format + String.format(Locale.CHINA, ",\"h\":%.2f}}", Double.valueOf(this.g.getAltitude())) : format + "}}";
        }
        return null;
    }

    public Location g() {
        if (this.g != null && Math.abs(System.currentTimeMillis() - this.g.getTime()) <= 60000) {
            return this.g;
        }
        return null;
    }

    public BDLocation h() {
        if (this.ac != null && Math.abs(System.currentTimeMillis() - this.ab) <= IMConnection.RETRY_DELAY_TIMES) {
            return this.ac;
        }
        return null;
    }

    public boolean i() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - this.M;
            if (a == 0) {
                try {
                    this.g.getExtras().getInt("satellites");
                } catch (Exception e2) {
                }
            }
            if (this.g != null && this.g.getLatitude() != 0.0d) {
                if (this.g.getLongitude() != 0.0d) {
                    return true;
                }
            }
            return false;
        } catch (Exception e3) {
            return (this.g == null || this.g.getLatitude() == 0.0d || this.g.getLongitude() == 0.0d) ? false : true;
        }
    }

    public boolean j() {
        if (i() && System.currentTimeMillis() - this.B <= 10000) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.x || currentTimeMillis - this.w >= IMConnection.RETRY_DELAY_TIMES) {
                return this.A;
            }
            return true;
        }
        return false;
    }

    public void k() {
        if (!this.l || this.O == null || this.f == null) {
            return;
        }
        this.f.unregisterGnssMeasurementsCallback(this.O);
        this.O = null;
    }

    public synchronized String m() {
        return "&gnsf=" + (Math.abs(System.currentTimeMillis() - this.W) < IMConnection.RETRY_DELAY_TIMES ? this.V == null ? "0" : this.V : "-1");
    }

    public void n() {
        if (l.m || e(this.g) <= 0) {
            com.baidu.location.b.b.a().a(f());
        } else {
            com.baidu.location.b.b.a().c(new BDLocation(f()));
        }
    }
}
