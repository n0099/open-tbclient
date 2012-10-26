package com.baidu.location;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {

    /* renamed from: char  reason: not valid java name */
    private static final int f60char = 3000;

    /* renamed from: else  reason: not valid java name */
    private static final int f61else = 3;
    private static final double f = 1.0E-5d;

    /* renamed from: goto  reason: not valid java name */
    private static final String f62goto = "baidu_location_service";

    /* renamed from: long  reason: not valid java name */
    private static final int f63long = 5;

    /* renamed from: for  reason: not valid java name */
    private Handler f67for;
    private Context g;
    private Location l;

    /* renamed from: void  reason: not valid java name */
    private GpsStatus f72void;
    private static int i = 0;
    private static String d = null;
    private final long m = 1000;
    private LocationManager o = null;
    private C0001b k = null;
    private a b = null;
    private long c = 0;

    /* renamed from: new  reason: not valid java name */
    private long f70new = 0;
    private boolean a = false;

    /* renamed from: case  reason: not valid java name */
    private boolean f65case = false;

    /* renamed from: try  reason: not valid java name */
    private String f71try = null;
    private boolean h = false;
    private long j = 0;

    /* renamed from: int  reason: not valid java name */
    private final int f69int = 400;

    /* renamed from: byte  reason: not valid java name */
    private boolean f64byte = true;
    private boolean e = false;
    private List n = new ArrayList();
    private String p = null;

    /* renamed from: do  reason: not valid java name */
    private String f66do = null;

    /* renamed from: if  reason: not valid java name */
    private String f68if = null;

    /* loaded from: classes.dex */
    private class a implements GpsStatus.NmeaListener, GpsStatus.Listener {
        private a() {
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            if (b.this.o == null) {
                return;
            }
            switch (i) {
                case 2:
                    b.this.a((Location) null);
                    b.this.a(false);
                    int unused = b.i = 0;
                    return;
                case 3:
                default:
                    return;
                case 4:
                    j.a("baidu_location_service", "gps status change");
                    if (b.this.f72void == null) {
                        b.this.f72void = b.this.o.getGpsStatus(null);
                    } else {
                        b.this.o.getGpsStatus(b.this.f72void);
                    }
                    int i2 = 0;
                    for (GpsSatellite gpsSatellite : b.this.f72void.getSatellites()) {
                        i2 = gpsSatellite.usedInFix() ? i2 + 1 : i2;
                    }
                    j.a("baidu_location_service", "gps nunmber in count:" + i2);
                    if (b.i >= 3 && i2 < 3) {
                        b.this.c = System.currentTimeMillis();
                    }
                    if (i2 < 3) {
                        b.this.a(false);
                    }
                    if (b.i <= 3 && i2 > 3) {
                        b.this.a(true);
                    }
                    int unused2 = b.i = i2;
                    return;
            }
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            if (str == null || str.equals("")) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.j > 400 && b.this.e && b.this.n.size() > 0) {
                try {
                    c cVar = new c(b.this.n, b.this.p, b.this.f66do, b.this.f68if);
                    if (cVar.m72if()) {
                        j.f187long = cVar.c();
                        if (j.f187long > 0) {
                            String unused = b.d = String.format("&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&nmea=%.1f|%.1f&ll_t=%d&g_tp=%d", Double.valueOf(cVar.d()), Double.valueOf(cVar.l()), Double.valueOf(cVar.m66case()), Double.valueOf(cVar.j()), 0, Integer.valueOf(cVar.m71goto()), Double.valueOf(cVar.m76try()), Double.valueOf(cVar.a()), Double.valueOf(cVar.b()), Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(j.f187long));
                        }
                    } else {
                        j.f187long = 0;
                        j.a("baidu_location_service", "nmea invalid");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    j.f187long = 0;
                }
                b.this.n.clear();
                b.this.p = b.this.f66do = b.this.f68if = null;
                b.this.e = false;
            }
            if (str.startsWith(c.x)) {
                b.this.e = true;
                b.this.p = str.trim();
            } else if (str.startsWith(c.l)) {
                b.this.n.add(str.trim());
            } else if (str.startsWith(c.g)) {
                b.this.f66do = str.trim();
            } else if (str.startsWith(c.f73if)) {
                b.this.f68if = str.trim();
            }
            b.this.j = System.currentTimeMillis();
        }
    }

    /* renamed from: com.baidu.location.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0001b implements LocationListener {
        private C0001b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            b.this.a(location);
            b.this.a = false;
            if (b.this.h) {
                b.this.a(true);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            b.this.a((Location) null);
            b.this.a(false);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            switch (i) {
                case 0:
                    b.this.a((Location) null);
                    b.this.a(false);
                    return;
                case 1:
                    b.this.f70new = System.currentTimeMillis();
                    b.this.a = true;
                    b.this.a(false);
                    return;
                case 2:
                    b.this.a = false;
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static final String g = "$GPRMC";

        /* renamed from: if  reason: not valid java name */
        public static final String f73if = "$GPGSA";
        public static final String l = "$GPGSV";
        public static final String x = "$GPGGA";
        private String A;
        private List m;
        private String r;

        /* renamed from: try  reason: not valid java name */
        private String f84try;
        private List u;
        private boolean h = true;
        private boolean q = false;
        private String p = "";
        private double d = 500.0d;

        /* renamed from: new  reason: not valid java name */
        private double f83new = 500.0d;

        /* renamed from: else  reason: not valid java name */
        private double f78else = 0.0d;
        private int c = 0;

        /* renamed from: for  reason: not valid java name */
        private int f79for = 0;
        private boolean k = false;
        private String v = "";

        /* renamed from: char  reason: not valid java name */
        private char f76char = 'N';
        private double n = 0.0d;
        private double z = 500.0d;
        private boolean s = false;
        private int C = 1;
        private double B = 0.0d;
        private double j = 0.0d;

        /* renamed from: long  reason: not valid java name */
        private double f82long = 0.0d;
        private boolean i = false;
        private int o = 0;

        /* renamed from: void  reason: not valid java name */
        private int f85void = 3;
        private int a = 10;

        /* renamed from: byte  reason: not valid java name */
        private double f74byte = 1.1d;
        private double e = 2.2d;

        /* renamed from: case  reason: not valid java name */
        private double f75case = 2.3d;
        private double f = 3.8d;

        /* renamed from: int  reason: not valid java name */
        private int f81int = 20;
        private int b = 2;

        /* renamed from: do  reason: not valid java name */
        private int f77do = 7;

        /* renamed from: goto  reason: not valid java name */
        private int f80goto = 70;
        private int w = 120;
        public int t = 0;

        /* loaded from: classes.dex */
        public class a {
            private int a;

            /* renamed from: do  reason: not valid java name */
            private int f86do;

            /* renamed from: if  reason: not valid java name */
            private int f88if;

            /* renamed from: int  reason: not valid java name */
            private int f89int;

            public a(int i, int i2, int i3, int i4) {
                this.f89int = 0;
                this.a = 0;
                this.f88if = 0;
                this.f86do = 0;
                this.f89int = i;
                this.a = i2;
                this.f88if = i3;
                this.f86do = i4;
            }

            public int a() {
                return this.a;
            }

            /* renamed from: do  reason: not valid java name */
            public int m78do() {
                return this.f86do;
            }

            /* renamed from: for  reason: not valid java name */
            public int m79for() {
                return this.f89int;
            }

            /* renamed from: if  reason: not valid java name */
            public int m80if() {
                return this.f88if;
            }
        }

        public c(List list, String str, String str2, String str3) {
            this.f84try = "";
            this.A = "";
            this.r = "";
            this.m = null;
            this.u = null;
            this.m = list;
            this.f84try = str;
            this.A = str2;
            this.r = str3;
            this.u = new ArrayList();
            m77void();
        }

        private boolean a(String str) {
            if (str == null || str.length() < 4) {
                return false;
            }
            int i = 0;
            for (int i2 = 1; i2 < str.length() - 3; i2++) {
                i ^= str.charAt(i2);
            }
            return Integer.toHexString(i).equalsIgnoreCase(str.substring(str.length() + (-2), str.length()));
        }

        private double[] a(double d, double d2) {
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

        private double[] a(List list) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            double[] m64if = m64if(90 - ((a) list.get(0)).m80if(), ((a) list.get(0)).a());
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    double[] m64if2 = m64if(90 - ((a) list.get(i)).m80if(), ((a) list.get(i)).a());
                    m64if[0] = (m64if[0] + m64if2[0]) / 2.0d;
                    m64if[1] = (m64if[1] + m64if2[1]) / 2.0d;
                }
            }
            return m64if;
        }

        /* renamed from: if  reason: not valid java name */
        private double[] m64if(double d, double d2) {
            return new double[]{Math.sin(Math.toRadians(d2)) * d, Math.cos(Math.toRadians(d2)) * d};
        }

        public double a() {
            return this.j;
        }

        public int a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            int i;
            double[] a2;
            int i2;
            if (this.h) {
                if (z && this.q) {
                    this.t = 1;
                    if (this.f79for >= this.a) {
                        return 1;
                    }
                    if (this.f79for <= this.f85void) {
                        return 4;
                    }
                }
                if (z2 && this.s) {
                    this.t = 2;
                    if (this.j <= this.f74byte) {
                        return 1;
                    }
                    if (this.j >= this.e) {
                        return 4;
                    }
                }
                if (z3 && this.s) {
                    this.t = 3;
                    if (this.B <= this.f75case) {
                        return 1;
                    }
                    if (this.B >= this.f) {
                        return 4;
                    }
                }
                if (z4 && this.i) {
                    this.t = 4;
                    int i3 = 0;
                    Iterator it = this.u.iterator();
                    while (true) {
                        i2 = i3;
                        if (!it.hasNext()) {
                            break;
                        }
                        i3 = ((a) it.next()).m78do() >= this.f81int ? i2 + 1 : i2;
                    }
                    if (i2 >= this.f77do) {
                        return 1;
                    }
                    if (i2 <= this.b) {
                        return 4;
                    }
                }
                if (z5 && this.i) {
                    this.t = 5;
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (int i4 = 0; i4 < 10; i4++) {
                        arrayList.add(new ArrayList());
                    }
                    int i5 = 0;
                    Iterator it2 = this.u.iterator();
                    while (true) {
                        i = i5;
                        if (!it2.hasNext()) {
                            break;
                        }
                        a aVar = (a) it2.next();
                        if (aVar.m78do() >= 10 && aVar.m80if() >= 1) {
                            ((List) arrayList.get((aVar.m78do() - 10) / 5)).add(aVar);
                            i++;
                        }
                        i5 = i;
                    }
                    if (i < 4) {
                        return 4;
                    }
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        if (i7 >= arrayList.size()) {
                            break;
                        }
                        if (((List) arrayList.get(i7)).size() != 0 && (a2 = a((List) arrayList.get(i7))) != null) {
                            arrayList2.add(a2);
                            arrayList3.add(Integer.valueOf(i7));
                        }
                        i6 = i7 + 1;
                    }
                    if (arrayList2 == null || arrayList2.size() <= 0) {
                        return 4;
                    }
                    double[] dArr = (double[]) arrayList2.get(0);
                    dArr[0] = dArr[0] * ((Integer) arrayList3.get(0)).intValue();
                    dArr[1] = dArr[1] * ((Integer) arrayList3.get(0)).intValue();
                    if (arrayList2.size() > 1) {
                        int i8 = 1;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= arrayList2.size()) {
                                break;
                            }
                            double[] dArr2 = (double[]) arrayList2.get(i9);
                            dArr2[0] = dArr2[0] * ((Integer) arrayList3.get(i9)).intValue();
                            dArr2[1] = dArr2[1] * ((Integer) arrayList3.get(i9)).intValue();
                            dArr[0] = (dArr[0] + dArr2[0]) / 2.0d;
                            dArr[1] = (dArr[1] + dArr2[1]) / 2.0d;
                            i8 = i9 + 1;
                        }
                    }
                    double[] a3 = a(dArr[0], dArr[1]);
                    if (a3[0] <= this.f80goto) {
                        return 1;
                    }
                    if (a3[0] >= this.w) {
                        return 4;
                    }
                }
                this.t = 0;
                return 3;
            }
            return 0;
        }

        public double b() {
            return this.B;
        }

        /* renamed from: byte  reason: not valid java name */
        public String m65byte() {
            return this.v;
        }

        public int c() {
            return a(true, true, true, true, true);
        }

        /* renamed from: case  reason: not valid java name */
        public double m66case() {
            return this.n;
        }

        /* renamed from: char  reason: not valid java name */
        public boolean m67char() {
            return this.q;
        }

        public double d() {
            return this.f83new;
        }

        /* renamed from: do  reason: not valid java name */
        public List m68do() {
            return this.u;
        }

        public String e() {
            return this.r;
        }

        /* renamed from: else  reason: not valid java name */
        public List m69else() {
            return this.m;
        }

        public int f() {
            return this.C;
        }

        /* renamed from: for  reason: not valid java name */
        public double m70for() {
            return this.f82long;
        }

        public int g() {
            return this.c;
        }

        /* renamed from: goto  reason: not valid java name */
        public int m71goto() {
            return this.f79for;
        }

        public boolean h() {
            return this.s;
        }

        public boolean i() {
            return this.k;
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m72if() {
            return this.h;
        }

        /* renamed from: int  reason: not valid java name */
        public String m73int() {
            return this.p;
        }

        public double j() {
            return this.z;
        }

        public String k() {
            return this.A;
        }

        public double l() {
            return this.d;
        }

        /* renamed from: long  reason: not valid java name */
        public boolean m74long() {
            return this.i;
        }

        public int m() {
            return this.o;
        }

        public String n() {
            return this.f84try;
        }

        /* renamed from: new  reason: not valid java name */
        public char m75new() {
            return this.f76char;
        }

        /* renamed from: try  reason: not valid java name */
        public double m76try() {
            return this.f78else;
        }

        /* renamed from: void  reason: not valid java name */
        public void m77void() {
            String str;
            if (a(this.f84try)) {
                String substring = this.f84try.substring(0, this.f84try.length() - 3);
                int i = 0;
                for (int i2 = 0; i2 < substring.length(); i2++) {
                    if (substring.charAt(i2) == ',') {
                        i++;
                    }
                }
                String[] split = substring.split(",", i + 1);
                if (!split[1].equals("") && !split[2].equals("") && !split[4].equals("") && !split[6].equals("") && !split[7].equals("") && !split[9].equals("")) {
                    int i3 = split[3].equals("S") ? -1 : 1;
                    int i4 = split[5].equals("W") ? -1 : 1;
                    this.d = i3 * (Integer.valueOf(split[2].substring(0, 2)).intValue() + (Double.valueOf(split[2].substring(2, split[2].length())).doubleValue() / 60.0d));
                    this.f83new = i4 * (Integer.valueOf(split[4].substring(0, 3)).intValue() + (Double.valueOf(split[4].substring(3, split[4].length())).doubleValue() / 60.0d));
                    this.f78else = Double.valueOf(split[9]).doubleValue();
                    this.c = Integer.valueOf(split[6]).intValue();
                    this.f79for = Integer.valueOf(split[7]).intValue();
                    this.q = true;
                }
            }
            if (a(this.A)) {
                String substring2 = this.A.substring(0, this.A.length() - 3);
                int i5 = 0;
                for (int i6 = 0; i6 < substring2.length(); i6++) {
                    if (substring2.charAt(i6) == ',') {
                        i5++;
                    }
                }
                String[] split2 = substring2.split(",", i5 + 1);
                if (!split2[9].equals("") && !split2[2].equals("")) {
                    this.f76char = Character.valueOf(split2[2].charAt(0)).charValue();
                    this.n = split2[7].equals("") ? 0.0d : 1.852d * Double.valueOf(split2[7]).doubleValue();
                    this.z = (split2[8].equals("") || split2[8].equalsIgnoreCase("nan")) ? 500.0d : Double.valueOf(split2[8]).doubleValue();
                    this.k = true;
                }
            }
            if (a(this.r)) {
                String substring3 = this.r.substring(0, this.r.length() - 3);
                int i7 = 0;
                for (int i8 = 0; i8 < substring3.length(); i8++) {
                    if (substring3.charAt(i8) == ',') {
                        i7++;
                    }
                }
                String[] split3 = substring3.split(",", i7 + 1);
                if (!split3[2].equals("") && !split3[split3.length - 3].equals("") && !split3[split3.length - 2].equals("") && !split3[split3.length - 1].equals("")) {
                    this.C = Integer.valueOf(split3[2]).intValue();
                    this.B = Double.valueOf(split3[split3.length - 3]).doubleValue();
                    this.j = Double.valueOf(split3[split3.length - 2]).doubleValue();
                    this.f82long = Double.valueOf(split3[split3.length - 1]).doubleValue();
                    this.s = true;
                }
            }
            if (this.m == null || this.m.size() <= 0) {
                this.i = false;
            } else {
                this.i = Integer.valueOf(((String) this.m.get(0)).split(",")[1]).intValue() == this.m.size();
                if (this.i) {
                    Iterator it = this.m.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String str2 = (String) it.next();
                        if (!a(str2)) {
                            this.i = false;
                            break;
                        }
                        String substring4 = str2.split(",", 5)[4].substring(0, str.length() - 3);
                        int i9 = 0;
                        for (int i10 = 0; i10 < substring4.length(); i10++) {
                            if (substring4.charAt(i10) == ',') {
                                i9++;
                            }
                        }
                        String[] split4 = substring4.split(",", i9 + 1);
                        int i11 = 0;
                        while (true) {
                            int i12 = i11;
                            if (i12 < split4.length) {
                                if (!split4[i12].equals("") && !split4[i12 + 1].equals("") && !split4[i12 + 2].equals("")) {
                                    this.o++;
                                    this.u.add(new a(Integer.valueOf(split4[i12]).intValue(), Integer.valueOf(split4[i12 + 2]).intValue(), Integer.valueOf(split4[i12 + 1]).intValue(), split4[i12 + 3].equals("") ? 0 : Integer.valueOf(split4[i12 + 3]).intValue()));
                                }
                                i11 = i12 + 4;
                            }
                        }
                    }
                }
            }
            this.h = this.q && this.s;
        }
    }

    public b(Context context, Handler handler) {
        this.f67for = null;
        this.g = context;
        this.f67for = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        j.a("baidu_location_service", "set new gpsLocation ...");
        this.l = location;
        if (this.l == null) {
            this.f71try = null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            this.l.setTime(currentTimeMillis);
            this.f71try = String.format("&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.l.getLongitude()), Double.valueOf(this.l.getLatitude()), Float.valueOf((float) (this.l.getSpeed() * 3.6d)), Float.valueOf(this.l.getBearing()), Integer.valueOf(i), Long.valueOf(currentTimeMillis));
        }
        this.f67for.obtainMessage(51).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.h = z;
        if ((!z || m58case()) && j.f189try != z) {
            j.f189try = z;
            if (j.f190void) {
                this.f67for.obtainMessage(53).sendToTarget();
            }
        }
    }

    public static boolean a(Location location, Location location2) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        float distanceTo = location2.distanceTo(location);
        return ((double) speed) > 10.0d ? distanceTo > j.f179case : ((double) speed) > 2.0d ? distanceTo > j.f185if : Math.abs(location.getLatitude() - location2.getLatitude()) > f || Math.abs(location.getLongitude() - location2.getLongitude()) > f;
    }

    /* renamed from: byte  reason: not valid java name */
    public static String m42byte() {
        return d;
    }

    /* renamed from: if  reason: not valid java name */
    public static String m51if(Location location) {
        if (location == null) {
            return null;
        }
        return String.format("&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&g_tp=0", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf((float) (location.getSpeed() * 3.6d)), Float.valueOf(location.getBearing()), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)), Integer.valueOf(i), Double.valueOf(location.hasAltitude() ? location.getAltitude() : 555.0d), Long.valueOf(location.getTime() / 1000));
    }

    public void a() {
        if (this.f65case) {
            if (this.o != null) {
                try {
                    if (this.k != null) {
                        this.o.removeUpdates(this.k);
                    }
                    if (this.b != null) {
                        this.o.removeGpsStatusListener(this.b);
                    }
                } catch (Exception e) {
                }
            }
            this.k = null;
            this.b = null;
            this.o = null;
            this.f65case = false;
            a(false);
        }
    }

    /* renamed from: case  reason: not valid java name */
    public boolean m58case() {
        if (m63try()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.a || currentTimeMillis - this.f70new <= 3000) {
                return i >= 3 || currentTimeMillis - this.c < 3000;
            }
            return false;
        }
        return false;
    }

    /* renamed from: do  reason: not valid java name */
    public Location m59do() {
        return this.l;
    }

    /* renamed from: if  reason: not valid java name */
    public String m60if() {
        if (this.l == null) {
            j.a("baidu_location_service", "gps man getGpsJson but gpslocation is null");
            return null;
        }
        String str = "{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"}}";
        int accuracy = (int) (this.l.hasAccuracy() ? this.l.getAccuracy() : 10.0f);
        float speed = (float) (this.l.getSpeed() * 3.6d);
        double[] m1if = Jni.m1if(this.l.getLongitude(), this.l.getLatitude(), "gps2gcj");
        if (m1if[0] <= 0.0d && m1if[1] <= 0.0d) {
            m1if[0] = this.l.getLongitude();
            m1if[1] = this.l.getLatitude();
        }
        String format = String.format(str, Double.valueOf(m1if[0]), Double.valueOf(m1if[1]), Integer.valueOf(accuracy), Float.valueOf(this.l.getBearing()), Float.valueOf(speed), Integer.valueOf(i));
        j.a("baidu_location_service", "wgs84: " + this.l.getLongitude() + " " + this.l.getLatitude() + " gcj02: " + m1if[0] + " " + m1if[1]);
        return format;
    }

    /* renamed from: int  reason: not valid java name */
    public void m61int() {
        if (this.f65case) {
            return;
        }
        try {
            this.o = (LocationManager) this.g.getSystemService("location");
            this.k = new C0001b();
            this.b = new a();
            this.o.requestLocationUpdates("gps", 1000L, 5.0f, this.k);
            this.o.addGpsStatusListener(this.b);
            this.o.addNmeaListener(this.b);
            this.f65case = true;
        } catch (Exception e) {
            j.a("baidu_location_service", e.getMessage());
        }
    }

    /* renamed from: new  reason: not valid java name */
    public String m62new() {
        return this.f71try;
    }

    /* renamed from: try  reason: not valid java name */
    public boolean m63try() {
        return (this.l == null || this.l.getLatitude() == 0.0d || this.l.getLongitude() == 0.0d) ? false : true;
    }
}
