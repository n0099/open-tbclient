package com.baidu.location;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.zeus.Headers;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private static final int E = 5;
    private static final int K = 5;

    /* renamed from: else  reason: not valid java name */
    private static final double f65else = 1.0E-5d;

    /* renamed from: goto  reason: not valid java name */
    private static final int f66goto = 3000;
    private static final int h = 1024;
    private static final int i = 1000;

    /* renamed from: if  reason: not valid java name */
    private static final String f67if = "baidu_location_service";
    private static final int l = 12;
    private static final int n = 1;
    private static final int q = 3;
    private static final int t = 100;

    /* renamed from: void  reason: not valid java name */
    private static final int f68void = 3600;
    private static final int x = 5;
    private static final int z = 750;
    private Location D;
    private Handler F;
    private GpsStatus a;
    private Context f;

    /* renamed from: for  reason: not valid java name */
    private d f70for;
    private static int k = 0;
    private static String p = null;
    private static String L = "Temp_in.dat";
    private static File y = new File(f.aa, L);
    private static StringBuffer w = null;

    /* renamed from: char  reason: not valid java name */
    private static boolean f64char = true;

    /* renamed from: case  reason: not valid java name */
    private static int f63case = 0;
    private static int c = 0;

    /* renamed from: byte  reason: not valid java name */
    private static long f62byte = 0;
    private static long H = 0;
    private static long J = 0;
    private static int j = 0;
    private static int G = 0;
    private static int b = 0;
    private final long o = 1000;

    /* renamed from: do  reason: not valid java name */
    private LocationManager f69do = null;
    private C0001b v = null;

    /* renamed from: new  reason: not valid java name */
    private a f73new = null;
    private long d = 0;

    /* renamed from: long  reason: not valid java name */
    private long f72long = 0;

    /* renamed from: int  reason: not valid java name */
    private boolean f71int = false;
    private boolean r = false;
    private String B = null;
    private boolean A = false;
    private long C = 0;
    private final int I = BdWebErrorView.ERROR_CODE_400;
    private boolean u = true;
    private boolean e = false;
    private List s = new ArrayList();
    private String g = null;

    /* renamed from: try  reason: not valid java name */
    private String f74try = null;
    private String m = null;

    /* loaded from: classes.dex */
    class a implements GpsStatus.Listener, GpsStatus.NmeaListener {
        private a() {
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            if (b.this.f69do == null) {
                return;
            }
            switch (i) {
                case 2:
                    b.this.a((Location) null);
                    b.this.a(false);
                    int unused = b.k = 0;
                    return;
                case 3:
                default:
                    return;
                case 4:
                    j.a("baidu_location_service", "gps status change");
                    if (b.this.a == null) {
                        b.this.a = b.this.f69do.getGpsStatus(null);
                    } else {
                        b.this.f69do.getGpsStatus(b.this.a);
                    }
                    int i2 = 0;
                    for (GpsSatellite gpsSatellite : b.this.a.getSatellites()) {
                        i2 = gpsSatellite.usedInFix() ? i2 + 1 : i2;
                    }
                    j.a("baidu_location_service", "gps nunmber in count:" + i2);
                    if (b.k >= 3 && i2 < 3) {
                        b.this.d = System.currentTimeMillis();
                    }
                    if (i2 < 3) {
                        b.this.a(false);
                    }
                    if (b.k <= 3 && i2 > 3) {
                        b.this.a(true);
                    }
                    int unused2 = b.k = i2;
                    return;
            }
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j, String str) {
            if (str == null || str.equals("")) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.C > 400 && b.this.e && b.this.s.size() > 0) {
                try {
                    c cVar = new c(b.this.s, b.this.g, b.this.f74try, b.this.m);
                    if (cVar.m91if()) {
                        j.f206void = cVar.c();
                        if (j.f206void > 0) {
                            String unused = b.p = String.format("&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&nmea=%.1f|%.1f&ll_t=%d&g_tp=%d", Double.valueOf(cVar.d()), Double.valueOf(cVar.l()), Double.valueOf(cVar.m85case()), Double.valueOf(cVar.j()), 0, Integer.valueOf(cVar.m90goto()), Double.valueOf(cVar.m95try()), Double.valueOf(cVar.a()), Double.valueOf(cVar.b()), Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(j.f206void));
                        }
                    } else {
                        j.f206void = 0;
                        j.a("baidu_location_service", "nmea invalid");
                    }
                } catch (Exception e) {
                    j.f206void = 0;
                }
                b.this.s.clear();
                b.this.g = b.this.f74try = b.this.m = null;
                b.this.e = false;
            }
            if (str.startsWith(c.f76if)) {
                b.this.e = true;
                b.this.g = str.trim();
            } else if (str.startsWith(c.g)) {
                b.this.s.add(str.trim());
            } else if (str.startsWith(c.f77int)) {
                b.this.f74try = str.trim();
            } else if (str.startsWith(c.f75for)) {
                b.this.m = str.trim();
            }
            b.this.C = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.location.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0001b implements LocationListener {
        private C0001b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            b.this.a(location);
            b.this.f71int = false;
            if (b.this.A) {
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
                    b.this.f72long = System.currentTimeMillis();
                    b.this.f71int = true;
                    b.this.a(false);
                    return;
                case 2:
                    b.this.f71int = false;
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: for  reason: not valid java name */
        public static final String f75for = "$GPGSA";
        public static final String g = "$GPGSV";

        /* renamed from: if  reason: not valid java name */
        public static final String f76if = "$GPGGA";

        /* renamed from: int  reason: not valid java name */
        public static final String f77int = "$GPRMC";
        private String d;
        private List e;

        /* renamed from: new  reason: not valid java name */
        private List f85new;
        private String p;
        private String q;
        private boolean f = true;
        private boolean r = false;

        /* renamed from: goto  reason: not valid java name */
        private String f83goto = "";

        /* renamed from: else  reason: not valid java name */
        private double f82else = 500.0d;

        /* renamed from: byte  reason: not valid java name */
        private double f78byte = 500.0d;
        private double o = 0.0d;
        private int h = 0;
        private int m = 0;

        /* renamed from: long  reason: not valid java name */
        private boolean f84long = false;
        private String k = "";
        private char c = 'N';
        private double j = 0.0d;
        private double a = 500.0d;
        private boolean i = false;

        /* renamed from: try  reason: not valid java name */
        private int f86try = 1;
        private double b = 0.0d;

        /* renamed from: case  reason: not valid java name */
        private double f79case = 0.0d;

        /* renamed from: char  reason: not valid java name */
        private double f80char = 0.0d;

        /* renamed from: void  reason: not valid java name */
        private boolean f87void = false;
        private int n = 0;

        /* renamed from: do  reason: not valid java name */
        public int f81do = 0;

        /* loaded from: classes.dex */
        public class a {
            private int a;

            /* renamed from: do  reason: not valid java name */
            private int f88do;

            /* renamed from: if  reason: not valid java name */
            private int f90if;

            /* renamed from: int  reason: not valid java name */
            private int f91int;

            public a(int i, int i2, int i3, int i4) {
                this.f91int = 0;
                this.a = 0;
                this.f90if = 0;
                this.f88do = 0;
                this.f91int = i;
                this.a = i2;
                this.f90if = i3;
                this.f88do = i4;
            }

            public int a() {
                return this.a;
            }

            /* renamed from: do  reason: not valid java name */
            public int m97do() {
                return this.f88do;
            }

            /* renamed from: for  reason: not valid java name */
            public int m98for() {
                return this.f91int;
            }

            /* renamed from: if  reason: not valid java name */
            public int m99if() {
                return this.f90if;
            }
        }

        public c(List list, String str, String str2, String str3) {
            this.d = "";
            this.q = "";
            this.p = "";
            this.f85new = null;
            this.e = null;
            this.f85new = list;
            this.d = str;
            this.q = str2;
            this.p = str3;
            this.e = new ArrayList();
            m96void();
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
            double[] m83if = m83if(90 - ((a) list.get(0)).m99if(), ((a) list.get(0)).a());
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    double[] m83if2 = m83if(90 - ((a) list.get(i)).m99if(), ((a) list.get(i)).a());
                    m83if[0] = (m83if[0] + m83if2[0]) / 2.0d;
                    m83if[1] = (m83if[1] + m83if2[1]) / 2.0d;
                }
            }
            return m83if;
        }

        /* renamed from: if  reason: not valid java name */
        private double[] m83if(double d, double d2) {
            return new double[]{Math.sin(Math.toRadians(d2)) * d, Math.cos(Math.toRadians(d2)) * d};
        }

        public double a() {
            return this.f79case;
        }

        public int a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            int i;
            double[] a2;
            int i2;
            if (this.f) {
                if (z && this.r) {
                    this.f81do = 1;
                    if (this.m >= j.a) {
                        return 1;
                    }
                    if (this.m <= j.t) {
                        return 4;
                    }
                }
                if (z2 && this.i) {
                    this.f81do = 2;
                    if (this.f79case <= j.f195case) {
                        return 1;
                    }
                    if (this.f79case >= j.A) {
                        return 4;
                    }
                }
                if (z3 && this.i) {
                    this.f81do = 3;
                    if (this.b <= j.f196char) {
                        return 1;
                    }
                    if (this.b >= j.C) {
                        return 4;
                    }
                }
                if (z4 && this.f87void) {
                    this.f81do = 4;
                    int i3 = 0;
                    Iterator it = this.e.iterator();
                    while (true) {
                        i2 = i3;
                        if (!it.hasNext()) {
                            break;
                        }
                        i3 = ((a) it.next()).m97do() >= j.f202int ? i2 + 1 : i2;
                    }
                    if (i2 >= j.f201if) {
                        return 1;
                    }
                    if (i2 <= j.u) {
                        return 4;
                    }
                }
                if (z5 && this.f87void) {
                    this.f81do = 5;
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (int i4 = 0; i4 < 10; i4++) {
                        arrayList.add(new ArrayList());
                    }
                    int i5 = 0;
                    Iterator it2 = this.e.iterator();
                    while (true) {
                        i = i5;
                        if (!it2.hasNext()) {
                            break;
                        }
                        a aVar = (a) it2.next();
                        if (aVar.m97do() >= 10 && aVar.m99if() >= 1) {
                            ((List) arrayList.get((aVar.m97do() - 10) / 5)).add(aVar);
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
                    if (a3[0] <= j.k) {
                        return 1;
                    }
                    if (a3[0] >= j.K) {
                        return 4;
                    }
                }
                this.f81do = 0;
                return 3;
            }
            return 0;
        }

        public double b() {
            return this.b;
        }

        /* renamed from: byte  reason: not valid java name */
        public String m84byte() {
            return this.k;
        }

        public int c() {
            return a(true, true, true, true, true);
        }

        /* renamed from: case  reason: not valid java name */
        public double m85case() {
            return this.j;
        }

        /* renamed from: char  reason: not valid java name */
        public boolean m86char() {
            return this.r;
        }

        public double d() {
            return this.f78byte;
        }

        /* renamed from: do  reason: not valid java name */
        public List m87do() {
            return this.e;
        }

        public String e() {
            return this.p;
        }

        /* renamed from: else  reason: not valid java name */
        public List m88else() {
            return this.f85new;
        }

        public int f() {
            return this.f86try;
        }

        /* renamed from: for  reason: not valid java name */
        public double m89for() {
            return this.f80char;
        }

        public int g() {
            return this.h;
        }

        /* renamed from: goto  reason: not valid java name */
        public int m90goto() {
            return this.m;
        }

        public boolean h() {
            return this.i;
        }

        public boolean i() {
            return this.f84long;
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m91if() {
            return this.f;
        }

        /* renamed from: int  reason: not valid java name */
        public String m92int() {
            return this.f83goto;
        }

        public double j() {
            return this.a;
        }

        public String k() {
            return this.q;
        }

        public double l() {
            return this.f82else;
        }

        /* renamed from: long  reason: not valid java name */
        public boolean m93long() {
            return this.f87void;
        }

        public int m() {
            return this.n;
        }

        public String n() {
            return this.d;
        }

        /* renamed from: new  reason: not valid java name */
        public char m94new() {
            return this.c;
        }

        /* renamed from: try  reason: not valid java name */
        public double m95try() {
            return this.o;
        }

        /* renamed from: void  reason: not valid java name */
        public void m96void() {
            String str;
            if (a(this.d)) {
                String substring = this.d.substring(0, this.d.length() - 3);
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
                    this.f82else = i3 * (Integer.valueOf(split[2].substring(0, 2)).intValue() + (Double.valueOf(split[2].substring(2, split[2].length())).doubleValue() / 60.0d));
                    this.f78byte = i4 * (Integer.valueOf(split[4].substring(0, 3)).intValue() + (Double.valueOf(split[4].substring(3, split[4].length())).doubleValue() / 60.0d));
                    this.o = Double.valueOf(split[9]).doubleValue();
                    this.h = Integer.valueOf(split[6]).intValue();
                    this.m = Integer.valueOf(split[7]).intValue();
                    this.r = true;
                }
            }
            if (a(this.q)) {
                String substring2 = this.q.substring(0, this.q.length() - 3);
                int i5 = 0;
                for (int i6 = 0; i6 < substring2.length(); i6++) {
                    if (substring2.charAt(i6) == ',') {
                        i5++;
                    }
                }
                String[] split2 = substring2.split(",", i5 + 1);
                if (!split2[9].equals("") && !split2[2].equals("")) {
                    this.c = Character.valueOf(split2[2].charAt(0)).charValue();
                    this.j = split2[7].equals("") ? 0.0d : 1.852d * Double.valueOf(split2[7]).doubleValue();
                    this.a = (split2[8].equals("") || split2[8].equalsIgnoreCase("nan")) ? 500.0d : Double.valueOf(split2[8]).doubleValue();
                    this.f84long = true;
                }
            }
            if (a(this.p)) {
                String substring3 = this.p.substring(0, this.p.length() - 3);
                int i7 = 0;
                for (int i8 = 0; i8 < substring3.length(); i8++) {
                    if (substring3.charAt(i8) == ',') {
                        i7++;
                    }
                }
                String[] split3 = substring3.split(",", i7 + 1);
                if (!split3[2].equals("") && !split3[split3.length - 3].equals("") && !split3[split3.length - 2].equals("") && !split3[split3.length - 1].equals("")) {
                    this.f86try = Integer.valueOf(split3[2]).intValue();
                    this.b = Double.valueOf(split3[split3.length - 3]).doubleValue();
                    this.f79case = Double.valueOf(split3[split3.length - 2]).doubleValue();
                    this.f80char = Double.valueOf(split3[split3.length - 1]).doubleValue();
                    this.i = true;
                }
            }
            if (this.f85new == null || this.f85new.size() <= 0) {
                this.f87void = false;
            } else {
                this.f87void = Integer.valueOf(((String) this.f85new.get(0)).split(",")[1]).intValue() == this.f85new.size();
                if (this.f87void) {
                    Iterator it = this.f85new.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String str2 = (String) it.next();
                        if (!a(str2)) {
                            this.f87void = false;
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
                                    this.n++;
                                    this.e.add(new a(Integer.valueOf(split4[i12]).intValue(), Integer.valueOf(split4[i12 + 2]).intValue(), Integer.valueOf(split4[i12 + 1]).intValue(), split4[i12 + 3].equals("") ? 0 : Integer.valueOf(split4[i12 + 3]).intValue()));
                                }
                                i11 = i12 + 4;
                            }
                        }
                    }
                }
            }
            this.f = this.r && this.i;
        }
    }

    /* loaded from: classes.dex */
    public class d {
        private String a;

        public d(String str) {
            this.a = null;
            if (str == null) {
                str = "";
            } else if (str.length() > 100) {
                str = str.substring(0, 100);
            }
            this.a = str;
        }

        private boolean a(String str) {
            String m2if;
            int length;
            if (str == null || !str.startsWith("&nr")) {
                return false;
            }
            if (b.y.exists() || b.d()) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(b.y, "rw");
                    randomAccessFile.seek(0L);
                    int readInt = randomAccessFile.readInt();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    if (!b.m69if(readInt, readInt2, readInt3)) {
                        randomAccessFile.close();
                        b.d();
                        return false;
                    }
                    if (j.G) {
                        if (readInt == j.l) {
                            if (str.equals(a(readInt3 == 1 ? j.l : readInt3 - 1))) {
                                randomAccessFile.close();
                                return false;
                            }
                        } else if (readInt3 > 1 && str.equals(a(readInt3 - 1))) {
                            randomAccessFile.close();
                            return false;
                        }
                    }
                    randomAccessFile.seek(((readInt3 - 1) * 1024) + 12 + 0);
                    if (str.length() > b.z || (length = (m2if = Jni.m2if(str)).length()) > 1020) {
                        return false;
                    }
                    randomAccessFile.writeInt(length);
                    randomAccessFile.writeBytes(m2if);
                    if (readInt == 0) {
                        randomAccessFile.seek(0L);
                        randomAccessFile.writeInt(1);
                        randomAccessFile.writeInt(1);
                        randomAccessFile.writeInt(2);
                    } else if (readInt < j.l - 1) {
                        randomAccessFile.seek(0L);
                        randomAccessFile.writeInt(readInt + 1);
                        randomAccessFile.seek(8L);
                        randomAccessFile.writeInt(readInt + 2);
                    } else if (readInt == j.l - 1) {
                        randomAccessFile.seek(0L);
                        randomAccessFile.writeInt(j.l);
                        if (readInt2 == 0 || readInt2 == 1) {
                            randomAccessFile.writeInt(2);
                        }
                        randomAccessFile.seek(8L);
                        randomAccessFile.writeInt(1);
                    } else if (readInt3 == readInt2) {
                        int i = readInt3 == j.l ? 1 : readInt3 + 1;
                        int i2 = i == j.l ? 1 : i + 1;
                        randomAccessFile.seek(4L);
                        randomAccessFile.writeInt(i2);
                        randomAccessFile.writeInt(i);
                    } else {
                        int i3 = readInt3 == j.l ? 1 : readInt3 + 1;
                        if (i3 == readInt2) {
                            int i4 = i3 == j.l ? 1 : i3 + 1;
                            randomAccessFile.seek(4L);
                            randomAccessFile.writeInt(i4);
                        }
                        randomAccessFile.seek(8L);
                        randomAccessFile.writeInt(i3);
                    }
                    randomAccessFile.close();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }

        public int a() {
            if (b.y.exists()) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(b.y, "rw");
                    randomAccessFile.seek(0L);
                    int readInt = randomAccessFile.readInt();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    if (b.m69if(readInt3, readInt2, readInt3)) {
                        return readInt;
                    }
                    randomAccessFile.close();
                    return 0;
                } catch (IOException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
            return 0;
        }

        public String a(int i) {
            if (b.y.exists()) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(b.y, "rw");
                    randomAccessFile.seek(0L);
                    int readInt = randomAccessFile.readInt();
                    if (!b.m69if(readInt, randomAccessFile.readInt(), randomAccessFile.readInt())) {
                        randomAccessFile.close();
                        b.d();
                        return null;
                    } else if (i == 0 || i == readInt + 1) {
                        return null;
                    } else {
                        long j = 12 + 0 + ((i - 1) * 1024);
                        randomAccessFile.seek(j);
                        int readInt2 = randomAccessFile.readInt();
                        byte[] bArr = new byte[readInt2];
                        randomAccessFile.seek(j + 4);
                        for (int i2 = 0; i2 < readInt2; i2++) {
                            bArr[i2] = randomAccessFile.readByte();
                        }
                        randomAccessFile.close();
                        return new String(bArr);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }

        public void a(boolean z) {
            j.m = z;
        }

        public boolean a(Location location) {
            return a(location, j.i, j.g);
        }

        public boolean a(Location location, int i, int i2) {
            if (location == null || !j.m) {
                return false;
            }
            if (j.i < 5) {
                j.i = 5;
            } else if (j.i > 1000) {
                j.i = 1000;
            }
            if (j.g < 5) {
                j.g = 5;
            } else if (j.g > b.f68void) {
                j.g = b.f68void;
            }
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            long time = location.getTime() / 1000;
            if (b.f64char) {
                int unused = b.f63case = 1;
                StringBuffer unused2 = b.w = new StringBuffer("");
                b.w.append(String.format("&nr=%s&traj=%d,%.5f,%.5f|", this.a, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)));
                int unused3 = b.c = b.w.length();
                long unused4 = b.f62byte = time;
                long unused5 = b.H = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                long unused6 = b.J = (long) Math.floor((latitude * 100000.0d) + 0.5d);
                boolean unused7 = b.f64char = false;
                return true;
            }
            float[] fArr = new float[1];
            Location.distanceBetween(latitude, longitude, b.f65else * b.J, b.f65else * b.H, fArr);
            long j = time - b.f62byte;
            if (fArr[0] >= j.i || j >= j.g) {
                if (b.w == null) {
                    b.m46byte();
                    int unused8 = b.c = 0;
                    StringBuffer unused9 = b.w = new StringBuffer("");
                    b.w.append(String.format("&nr=%s&traj=%d,%.5f,%.5f|", this.a, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)));
                    int unused10 = b.c = b.w.length();
                    long unused11 = b.f62byte = time;
                    long unused12 = b.H = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                    long unused13 = b.J = (long) Math.floor((latitude * 100000.0d) + 0.5d);
                } else {
                    long floor = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                    long floor2 = (long) Math.floor((latitude * 100000.0d) + 0.5d);
                    int unused14 = b.j = (int) (time - b.f62byte);
                    int unused15 = b.G = (int) (floor - b.H);
                    int unused16 = b.b = (int) (floor2 - b.J);
                    b.w.append(String.format("%d,%d,%d|", Integer.valueOf(b.j), Integer.valueOf(b.G), Integer.valueOf(b.b)));
                    int unused17 = b.c = b.w.length();
                    long unused18 = b.f62byte = time;
                    long unused19 = b.H = floor;
                    long unused20 = b.J = floor2;
                }
                if (b.c + 15 > b.z) {
                    a(b.w.toString());
                    StringBuffer unused21 = b.w = null;
                }
                if (b.f63case >= j.l) {
                    j.m = false;
                }
                return true;
            }
            return false;
        }

        /* renamed from: do  reason: not valid java name */
        public void m100do() {
            if (b.w != null && b.w.length() >= 100) {
                a(b.w.toString());
            }
            b.m77void();
        }

        /* renamed from: for  reason: not valid java name */
        public boolean m101for() {
            if (b.y.exists()) {
                b.y.delete();
            }
            b.m77void();
            return !b.y.exists();
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m102if() {
            return j.m;
        }
    }

    public b(Context context, Handler handler) {
        this.F = null;
        this.f70for = null;
        this.f = context;
        this.F = handler;
        try {
            if (j.f != null) {
                this.f70for = new d(j.f);
            } else {
                this.f70for = new d("NULL");
            }
        } catch (Exception e) {
            this.f70for = null;
        }
    }

    private void a(double d2, double d3, float f) {
        int i2 = 0;
        j.a("baidu_location_service", "check...gps ...");
        if (d2 >= 73.146973d && d2 <= 135.252686d && d3 <= 54.258807d && d3 >= 14.604847d && f <= 18.0f) {
            j.a("baidu_location_service", "check...gps2 ...");
            int i3 = (int) ((d2 - j.s) * 1000.0d);
            int i4 = (int) ((j.f194byte - d3) * 1000.0d);
            j.a("baidu_location_service", "check...gps ..." + i3 + i4);
            if (i3 <= 0 || i3 >= 50 || i4 <= 0 || i4 >= 50) {
                j.O = d2;
                j.c = d3;
                g.a(String.format("&ll=%.5f|%.5f", Double.valueOf(d2), Double.valueOf(d3)) + "&im=" + j.f, true);
            } else {
                j.a("baidu_location_service", "check...gps ..." + i3 + i4);
                int i5 = i3 + (i4 * 50);
                int i6 = i5 >> 2;
                int i7 = i5 & 3;
                if (j.e) {
                    i2 = (j.o[i6] >> (i7 * 2)) & 3;
                    j.a("baidu_location_service", "check gps scacity..." + i2);
                }
            }
        }
        if (j.f203long != i2) {
            j.f203long = i2;
            try {
                if (j.f203long == 3) {
                    this.f69do.removeUpdates(this.v);
                    this.f69do.requestLocationUpdates("gps", 1000L, 1.0f, this.v);
                } else {
                    this.f69do.removeUpdates(this.v);
                    this.f69do.requestLocationUpdates("gps", 1000L, 5.0f, this.v);
                }
            } catch (Exception e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        j.a("baidu_location_service", "set new gpsLocation ...");
        this.D = location;
        if (this.D == null) {
            this.B = null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            this.D.setTime(currentTimeMillis);
            float speed = (float) (this.D.getSpeed() * 3.6d);
            this.B = String.format("&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.D.getLongitude()), Double.valueOf(this.D.getLatitude()), Float.valueOf(speed), Float.valueOf(this.D.getBearing()), Integer.valueOf(k), Long.valueOf(currentTimeMillis));
            a(this.D.getLongitude(), this.D.getLatitude(), speed);
        }
        if (this.f70for != null) {
            try {
                this.f70for.a(this.D);
            } catch (Exception e) {
            }
        }
        this.F.obtainMessage(51).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        this.A = z2;
        if ((!z2 || m79for()) && j.b != z2) {
            j.b = z2;
            if (j.I) {
                this.F.obtainMessage(53).sendToTarget();
            }
        }
    }

    public static boolean a(Location location, Location location2, boolean z2) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (z2 && j.f203long == 3 && speed < 5.0f) {
            return true;
        }
        float distanceTo = location2.distanceTo(location);
        return speed > j.Q ? distanceTo > j.H : speed > j.T ? distanceTo > j.d : distanceTo > 5.0f;
    }

    /* renamed from: byte  reason: not valid java name */
    static /* synthetic */ int m46byte() {
        int i2 = f63case + 1;
        f63case = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d() {
        if (y.exists()) {
            y.delete();
        }
        if (!y.getParentFile().exists()) {
            y.getParentFile().mkdirs();
        }
        try {
            y.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(y, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            m77void();
            return y.exists();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String e() {
        j.a("baidu_location_service", "GPS readline...");
        if (y != null && y.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(y, "rw");
                randomAccessFile.seek(0L);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                if (!m69if(readInt, readInt2, readInt3)) {
                    randomAccessFile.close();
                    d();
                    return null;
                }
                j.a("baidu_location_service", "GPS readline1...");
                if (readInt2 == 0 || readInt2 == readInt3) {
                    return null;
                }
                j.a("baidu_location_service", "GPS readline2...");
                long j2 = 0 + ((readInt2 - 1) * 1024) + 12;
                randomAccessFile.seek(j2);
                int readInt4 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt4];
                randomAccessFile.seek(j2 + 4);
                for (int i2 = 0; i2 < readInt4; i2++) {
                    bArr[i2] = randomAccessFile.readByte();
                }
                String str = new String(bArr);
                int i3 = readInt < j.l ? readInt2 + 1 : readInt2 == j.l ? 1 : readInt2 + 1;
                randomAccessFile.seek(4L);
                randomAccessFile.writeInt(i3);
                randomAccessFile.close();
                return str;
            } catch (IOException e) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: if  reason: not valid java name */
    public static String m65if(Location location) {
        if (location == null) {
            return null;
        }
        return String.format("&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&g_tp=0", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf((float) (location.getSpeed() * 3.6d)), Float.valueOf(location.getBearing()), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)), Integer.valueOf(k), Double.valueOf(location.hasAltitude() ? location.getAltitude() : 555.0d), Long.valueOf(location.getTime() / 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public static boolean m69if(int i2, int i3, int i4) {
        if (i2 < 0 || i2 > j.l) {
            return false;
        }
        if (i3 < 0 || i3 > i2 + 1) {
            return false;
        }
        return i4 >= 1 && i4 <= i2 + 1 && i4 <= j.l;
    }

    public static String k() {
        return p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: void  reason: not valid java name */
    public static void m77void() {
        f64char = true;
        w = null;
        f63case = 0;
        c = 0;
        f62byte = 0L;
        H = 0L;
        J = 0L;
        j = 0;
        G = 0;
        b = 0;
    }

    /* renamed from: do  reason: not valid java name */
    public String m78do() {
        if (this.D == null) {
            j.a("baidu_location_service", "gps man getGpsJson but gpslocation is null");
            return null;
        }
        String str = "{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"}}";
        int accuracy = (int) (this.D.hasAccuracy() ? this.D.getAccuracy() : 10.0f);
        float speed = (float) (this.D.getSpeed() * 3.6d);
        double[] m3if = Jni.m3if(this.D.getLongitude(), this.D.getLatitude(), "gps2gcj");
        if (m3if[0] <= 0.0d && m3if[1] <= 0.0d) {
            m3if[0] = this.D.getLongitude();
            m3if[1] = this.D.getLatitude();
        }
        String format = String.format(str, Double.valueOf(m3if[0]), Double.valueOf(m3if[1]), Integer.valueOf(accuracy), Float.valueOf(this.D.getBearing()), Float.valueOf(speed), Integer.valueOf(k));
        j.a("baidu_location_service", "wgs84: " + this.D.getLongitude() + " " + this.D.getLatitude() + " gcj02: " + m3if[0] + " " + m3if[1]);
        return format;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m79for() {
        if (m81new()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.f71int || currentTimeMillis - this.f72long <= 3000) {
                return k >= 3 || currentTimeMillis - this.d < 3000;
            }
            return false;
        }
        return false;
    }

    public void i() {
        if (this.r) {
            return;
        }
        try {
            this.f69do = (LocationManager) this.f.getSystemService(Headers.LOCATION);
            this.v = new C0001b();
            this.f73new = new a();
            this.f69do.requestLocationUpdates("gps", 1000L, 5.0f, this.v);
            this.f69do.addGpsStatusListener(this.f73new);
            this.f69do.addNmeaListener(this.f73new);
            this.r = true;
        } catch (Exception e) {
        }
    }

    /* renamed from: int  reason: not valid java name */
    public Location m80int() {
        return this.D;
    }

    public void j() {
        if (this.r) {
            if (this.f69do != null) {
                try {
                    if (this.v != null) {
                        this.f69do.removeUpdates(this.v);
                    }
                    if (this.f73new != null) {
                        this.f69do.removeGpsStatusListener(this.f73new);
                        this.f69do.removeNmeaListener(this.f73new);
                    }
                    if (this.f70for != null) {
                        this.f70for.m100do();
                    }
                } catch (Exception e) {
                }
            }
            this.v = null;
            this.f73new = null;
            this.f69do = null;
            this.r = false;
            a(false);
        }
    }

    /* renamed from: new  reason: not valid java name */
    public boolean m81new() {
        return (this.D == null || this.D.getLatitude() == 0.0d || this.D.getLongitude() == 0.0d) ? false : true;
    }

    /* renamed from: try  reason: not valid java name */
    public String m82try() {
        return this.B;
    }
}
