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
    private static final double f101else = 1.0E-5d;

    /* renamed from: goto  reason: not valid java name */
    private static final int f102goto = 3000;
    private static final int h = 1024;
    private static final int i = 1000;

    /* renamed from: if  reason: not valid java name */
    private static final String f103if = "baidu_location_service";
    private static final int l = 12;
    private static final int n = 1;
    private static final int q = 3;
    private static final int t = 100;

    /* renamed from: void  reason: not valid java name */
    private static final int f104void = 3600;
    private static final int x = 5;
    private static final int z = 750;
    private Location D;
    private Handler F;
    private GpsStatus a;
    private Context f;

    /* renamed from: for  reason: not valid java name */
    private d f106for;
    private static int k = 0;
    private static String p = null;
    private static String L = "Temp_in.dat";
    private static File y = new File(f.aa, L);
    private static StringBuffer w = null;

    /* renamed from: char  reason: not valid java name */
    private static boolean f100char = true;

    /* renamed from: case  reason: not valid java name */
    private static int f99case = 0;
    private static int c = 0;

    /* renamed from: byte  reason: not valid java name */
    private static long f98byte = 0;
    private static long H = 0;
    private static long J = 0;
    private static int j = 0;
    private static int G = 0;
    private static int b = 0;
    private final long o = 1000;

    /* renamed from: do  reason: not valid java name */
    private LocationManager f105do = null;
    private C0001b v = null;

    /* renamed from: new  reason: not valid java name */
    private a f109new = null;
    private long d = 0;

    /* renamed from: long  reason: not valid java name */
    private long f108long = 0;

    /* renamed from: int  reason: not valid java name */
    private boolean f107int = false;
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
    private String f110try = null;
    private String m = null;

    /* loaded from: classes.dex */
    class a implements GpsStatus.Listener, GpsStatus.NmeaListener {
        private a() {
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            if (b.this.f105do == null) {
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
                        b.this.a = b.this.f105do.getGpsStatus(null);
                    } else {
                        b.this.f105do.getGpsStatus(b.this.a);
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
                    c cVar = new c(b.this.s, b.this.g, b.this.f110try, b.this.m);
                    if (cVar.m106if()) {
                        j.f242void = cVar.c();
                        if (j.f242void > 0) {
                            String unused = b.p = String.format("&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&nmea=%.1f|%.1f&ll_t=%d&g_tp=%d", Double.valueOf(cVar.d()), Double.valueOf(cVar.l()), Double.valueOf(cVar.m100case()), Double.valueOf(cVar.j()), 0, Integer.valueOf(cVar.m105goto()), Double.valueOf(cVar.m110try()), Double.valueOf(cVar.a()), Double.valueOf(cVar.b()), Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(j.f242void));
                        }
                    } else {
                        j.f242void = 0;
                        j.a("baidu_location_service", "nmea invalid");
                    }
                } catch (Exception e) {
                    j.f242void = 0;
                }
                b.this.s.clear();
                b.this.g = b.this.f110try = b.this.m = null;
                b.this.e = false;
            }
            if (str.startsWith(c.f112if)) {
                b.this.e = true;
                b.this.g = str.trim();
            } else if (str.startsWith(c.g)) {
                b.this.s.add(str.trim());
            } else if (str.startsWith(c.f113int)) {
                b.this.f110try = str.trim();
            } else if (str.startsWith(c.f111for)) {
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
            b.this.f107int = false;
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
                    b.this.f108long = System.currentTimeMillis();
                    b.this.f107int = true;
                    b.this.a(false);
                    return;
                case 2:
                    b.this.f107int = false;
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c {

        /* renamed from: for  reason: not valid java name */
        public static final String f111for = "$GPGSA";
        public static final String g = "$GPGSV";

        /* renamed from: if  reason: not valid java name */
        public static final String f112if = "$GPGGA";

        /* renamed from: int  reason: not valid java name */
        public static final String f113int = "$GPRMC";
        private String d;
        private List e;

        /* renamed from: new  reason: not valid java name */
        private List f121new;
        private String p;
        private String q;
        private boolean f = true;
        private boolean r = false;

        /* renamed from: goto  reason: not valid java name */
        private String f119goto = "";

        /* renamed from: else  reason: not valid java name */
        private double f118else = 500.0d;

        /* renamed from: byte  reason: not valid java name */
        private double f114byte = 500.0d;
        private double o = 0.0d;
        private int h = 0;
        private int m = 0;

        /* renamed from: long  reason: not valid java name */
        private boolean f120long = false;
        private String k = "";
        private char c = 'N';
        private double j = 0.0d;
        private double a = 500.0d;
        private boolean i = false;

        /* renamed from: try  reason: not valid java name */
        private int f122try = 1;
        private double b = 0.0d;

        /* renamed from: case  reason: not valid java name */
        private double f115case = 0.0d;

        /* renamed from: char  reason: not valid java name */
        private double f116char = 0.0d;

        /* renamed from: void  reason: not valid java name */
        private boolean f123void = false;
        private int n = 0;

        /* renamed from: do  reason: not valid java name */
        public int f117do = 0;

        /* loaded from: classes.dex */
        public class a {
            private int a;

            /* renamed from: do  reason: not valid java name */
            private int f124do;

            /* renamed from: if  reason: not valid java name */
            private int f126if;

            /* renamed from: int  reason: not valid java name */
            private int f127int;

            public a(int i, int i2, int i3, int i4) {
                this.f127int = 0;
                this.a = 0;
                this.f126if = 0;
                this.f124do = 0;
                this.f127int = i;
                this.a = i2;
                this.f126if = i3;
                this.f124do = i4;
            }

            public int a() {
                return this.a;
            }

            /* renamed from: do  reason: not valid java name */
            public int m112do() {
                return this.f124do;
            }

            /* renamed from: for  reason: not valid java name */
            public int m113for() {
                return this.f127int;
            }

            /* renamed from: if  reason: not valid java name */
            public int m114if() {
                return this.f126if;
            }
        }

        public c(List list, String str, String str2, String str3) {
            this.d = "";
            this.q = "";
            this.p = "";
            this.f121new = null;
            this.e = null;
            this.f121new = list;
            this.d = str;
            this.q = str2;
            this.p = str3;
            this.e = new ArrayList();
            m111void();
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
            double[] m98if = m98if(90 - ((a) list.get(0)).m114if(), ((a) list.get(0)).a());
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    double[] m98if2 = m98if(90 - ((a) list.get(i)).m114if(), ((a) list.get(i)).a());
                    m98if[0] = (m98if[0] + m98if2[0]) / 2.0d;
                    m98if[1] = (m98if[1] + m98if2[1]) / 2.0d;
                }
            }
            return m98if;
        }

        /* renamed from: if  reason: not valid java name */
        private double[] m98if(double d, double d2) {
            return new double[]{Math.sin(Math.toRadians(d2)) * d, Math.cos(Math.toRadians(d2)) * d};
        }

        public double a() {
            return this.f115case;
        }

        public int a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            int i;
            double[] a2;
            int i2;
            if (this.f) {
                if (z && this.r) {
                    this.f117do = 1;
                    if (this.m >= j.a) {
                        return 1;
                    }
                    if (this.m <= j.t) {
                        return 4;
                    }
                }
                if (z2 && this.i) {
                    this.f117do = 2;
                    if (this.f115case <= j.f231case) {
                        return 1;
                    }
                    if (this.f115case >= j.A) {
                        return 4;
                    }
                }
                if (z3 && this.i) {
                    this.f117do = 3;
                    if (this.b <= j.f232char) {
                        return 1;
                    }
                    if (this.b >= j.C) {
                        return 4;
                    }
                }
                if (z4 && this.f123void) {
                    this.f117do = 4;
                    int i3 = 0;
                    Iterator it = this.e.iterator();
                    while (true) {
                        i2 = i3;
                        if (!it.hasNext()) {
                            break;
                        }
                        i3 = ((a) it.next()).m112do() >= j.f238int ? i2 + 1 : i2;
                    }
                    if (i2 >= j.f237if) {
                        return 1;
                    }
                    if (i2 <= j.u) {
                        return 4;
                    }
                }
                if (z5 && this.f123void) {
                    this.f117do = 5;
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
                        if (aVar.m112do() >= 10 && aVar.m114if() >= 1) {
                            ((List) arrayList.get((aVar.m112do() - 10) / 5)).add(aVar);
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
                this.f117do = 0;
                return 3;
            }
            return 0;
        }

        public double b() {
            return this.b;
        }

        /* renamed from: byte  reason: not valid java name */
        public String m99byte() {
            return this.k;
        }

        public int c() {
            return a(true, true, true, true, true);
        }

        /* renamed from: case  reason: not valid java name */
        public double m100case() {
            return this.j;
        }

        /* renamed from: char  reason: not valid java name */
        public boolean m101char() {
            return this.r;
        }

        public double d() {
            return this.f114byte;
        }

        /* renamed from: do  reason: not valid java name */
        public List m102do() {
            return this.e;
        }

        public String e() {
            return this.p;
        }

        /* renamed from: else  reason: not valid java name */
        public List m103else() {
            return this.f121new;
        }

        public int f() {
            return this.f122try;
        }

        /* renamed from: for  reason: not valid java name */
        public double m104for() {
            return this.f116char;
        }

        public int g() {
            return this.h;
        }

        /* renamed from: goto  reason: not valid java name */
        public int m105goto() {
            return this.m;
        }

        public boolean h() {
            return this.i;
        }

        public boolean i() {
            return this.f120long;
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m106if() {
            return this.f;
        }

        /* renamed from: int  reason: not valid java name */
        public String m107int() {
            return this.f119goto;
        }

        public double j() {
            return this.a;
        }

        public String k() {
            return this.q;
        }

        public double l() {
            return this.f118else;
        }

        /* renamed from: long  reason: not valid java name */
        public boolean m108long() {
            return this.f123void;
        }

        public int m() {
            return this.n;
        }

        public String n() {
            return this.d;
        }

        /* renamed from: new  reason: not valid java name */
        public char m109new() {
            return this.c;
        }

        /* renamed from: try  reason: not valid java name */
        public double m110try() {
            return this.o;
        }

        /* renamed from: void  reason: not valid java name */
        public void m111void() {
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
                    this.f118else = i3 * (Integer.valueOf(split[2].substring(0, 2)).intValue() + (Double.valueOf(split[2].substring(2, split[2].length())).doubleValue() / 60.0d));
                    this.f114byte = i4 * (Integer.valueOf(split[4].substring(0, 3)).intValue() + (Double.valueOf(split[4].substring(3, split[4].length())).doubleValue() / 60.0d));
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
                    this.f120long = true;
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
                    this.f122try = Integer.valueOf(split3[2]).intValue();
                    this.b = Double.valueOf(split3[split3.length - 3]).doubleValue();
                    this.f115case = Double.valueOf(split3[split3.length - 2]).doubleValue();
                    this.f116char = Double.valueOf(split3[split3.length - 1]).doubleValue();
                    this.i = true;
                }
            }
            if (this.f121new == null || this.f121new.size() <= 0) {
                this.f123void = false;
            } else {
                this.f123void = Integer.valueOf(((String) this.f121new.get(0)).split(",")[1]).intValue() == this.f121new.size();
                if (this.f123void) {
                    Iterator it = this.f121new.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String str2 = (String) it.next();
                        if (!a(str2)) {
                            this.f123void = false;
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
            String m17if;
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
                    if (!b.m84if(readInt, readInt2, readInt3)) {
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
                    if (str.length() > b.z || (length = (m17if = Jni.m17if(str)).length()) > 1020) {
                        return false;
                    }
                    randomAccessFile.writeInt(length);
                    randomAccessFile.writeBytes(m17if);
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
                    if (b.m84if(readInt3, readInt2, readInt3)) {
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
                    if (!b.m84if(readInt, randomAccessFile.readInt(), randomAccessFile.readInt())) {
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
            } else if (j.g > b.f104void) {
                j.g = b.f104void;
            }
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            long time = location.getTime() / 1000;
            if (b.f100char) {
                int unused = b.f99case = 1;
                StringBuffer unused2 = b.w = new StringBuffer("");
                b.w.append(String.format("&nr=%s&traj=%d,%.5f,%.5f|", this.a, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)));
                int unused3 = b.c = b.w.length();
                long unused4 = b.f98byte = time;
                long unused5 = b.H = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                long unused6 = b.J = (long) Math.floor((latitude * 100000.0d) + 0.5d);
                boolean unused7 = b.f100char = false;
                return true;
            }
            float[] fArr = new float[1];
            Location.distanceBetween(latitude, longitude, b.f101else * b.J, b.f101else * b.H, fArr);
            long j = time - b.f98byte;
            if (fArr[0] >= j.i || j >= j.g) {
                if (b.w == null) {
                    b.m61byte();
                    int unused8 = b.c = 0;
                    StringBuffer unused9 = b.w = new StringBuffer("");
                    b.w.append(String.format("&nr=%s&traj=%d,%.5f,%.5f|", this.a, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)));
                    int unused10 = b.c = b.w.length();
                    long unused11 = b.f98byte = time;
                    long unused12 = b.H = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                    long unused13 = b.J = (long) Math.floor((latitude * 100000.0d) + 0.5d);
                } else {
                    long floor = (long) Math.floor((longitude * 100000.0d) + 0.5d);
                    long floor2 = (long) Math.floor((latitude * 100000.0d) + 0.5d);
                    int unused14 = b.j = (int) (time - b.f98byte);
                    int unused15 = b.G = (int) (floor - b.H);
                    int unused16 = b.b = (int) (floor2 - b.J);
                    b.w.append(String.format("%d,%d,%d|", Integer.valueOf(b.j), Integer.valueOf(b.G), Integer.valueOf(b.b)));
                    int unused17 = b.c = b.w.length();
                    long unused18 = b.f98byte = time;
                    long unused19 = b.H = floor;
                    long unused20 = b.J = floor2;
                }
                if (b.c + 15 > b.z) {
                    a(b.w.toString());
                    StringBuffer unused21 = b.w = null;
                }
                if (b.f99case >= j.l) {
                    j.m = false;
                }
                return true;
            }
            return false;
        }

        /* renamed from: do  reason: not valid java name */
        public void m115do() {
            if (b.w != null && b.w.length() >= 100) {
                a(b.w.toString());
            }
            b.m92void();
        }

        /* renamed from: for  reason: not valid java name */
        public boolean m116for() {
            if (b.y.exists()) {
                b.y.delete();
            }
            b.m92void();
            return !b.y.exists();
        }

        /* renamed from: if  reason: not valid java name */
        public boolean m117if() {
            return j.m;
        }
    }

    public b(Context context, Handler handler) {
        this.F = null;
        this.f106for = null;
        this.f = context;
        this.F = handler;
        try {
            if (j.f != null) {
                this.f106for = new d(j.f);
            } else {
                this.f106for = new d("NULL");
            }
        } catch (Exception e) {
            this.f106for = null;
        }
    }

    private void a(double d2, double d3, float f) {
        int i2 = 0;
        j.a("baidu_location_service", "check...gps ...");
        if (d2 >= 73.146973d && d2 <= 135.252686d && d3 <= 54.258807d && d3 >= 14.604847d && f <= 18.0f) {
            j.a("baidu_location_service", "check...gps2 ...");
            int i3 = (int) ((d2 - j.s) * 1000.0d);
            int i4 = (int) ((j.f230byte - d3) * 1000.0d);
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
        if (j.f239long != i2) {
            j.f239long = i2;
            try {
                if (j.f239long == 3) {
                    this.f105do.removeUpdates(this.v);
                    this.f105do.requestLocationUpdates("gps", 1000L, 1.0f, this.v);
                } else {
                    this.f105do.removeUpdates(this.v);
                    this.f105do.requestLocationUpdates("gps", 1000L, 5.0f, this.v);
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
        if (this.f106for != null) {
            try {
                this.f106for.a(this.D);
            } catch (Exception e) {
            }
        }
        this.F.obtainMessage(51).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        this.A = z2;
        if ((!z2 || m94for()) && j.b != z2) {
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
        if (z2 && j.f239long == 3 && speed < 5.0f) {
            return true;
        }
        float distanceTo = location2.distanceTo(location);
        return speed > j.Q ? distanceTo > j.H : speed > j.T ? distanceTo > j.d : distanceTo > 5.0f;
    }

    /* renamed from: byte  reason: not valid java name */
    static /* synthetic */ int m61byte() {
        int i2 = f99case + 1;
        f99case = i2;
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
            m92void();
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
                if (!m84if(readInt, readInt2, readInt3)) {
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
    public static String m80if(Location location) {
        if (location == null) {
            return null;
        }
        return String.format("&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&g_tp=0", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf((float) (location.getSpeed() * 3.6d)), Float.valueOf(location.getBearing()), Integer.valueOf((int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f)), Integer.valueOf(k), Double.valueOf(location.hasAltitude() ? location.getAltitude() : 555.0d), Long.valueOf(location.getTime() / 1000));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public static boolean m84if(int i2, int i3, int i4) {
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
    public static void m92void() {
        f100char = true;
        w = null;
        f99case = 0;
        c = 0;
        f98byte = 0L;
        H = 0L;
        J = 0L;
        j = 0;
        G = 0;
        b = 0;
    }

    /* renamed from: do  reason: not valid java name */
    public String m93do() {
        if (this.D == null) {
            j.a("baidu_location_service", "gps man getGpsJson but gpslocation is null");
            return null;
        }
        String str = "{\"result\":{\"time\":\"" + j.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"}}";
        int accuracy = (int) (this.D.hasAccuracy() ? this.D.getAccuracy() : 10.0f);
        float speed = (float) (this.D.getSpeed() * 3.6d);
        double[] m18if = Jni.m18if(this.D.getLongitude(), this.D.getLatitude(), "gps2gcj");
        if (m18if[0] <= 0.0d && m18if[1] <= 0.0d) {
            m18if[0] = this.D.getLongitude();
            m18if[1] = this.D.getLatitude();
        }
        String format = String.format(str, Double.valueOf(m18if[0]), Double.valueOf(m18if[1]), Integer.valueOf(accuracy), Float.valueOf(this.D.getBearing()), Float.valueOf(speed), Integer.valueOf(k));
        j.a("baidu_location_service", "wgs84: " + this.D.getLongitude() + " " + this.D.getLatitude() + " gcj02: " + m18if[0] + " " + m18if[1]);
        return format;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m94for() {
        if (m96new()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.f107int || currentTimeMillis - this.f108long <= 3000) {
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
            this.f105do = (LocationManager) this.f.getSystemService(Headers.LOCATION);
            this.v = new C0001b();
            this.f109new = new a();
            this.f105do.requestLocationUpdates("gps", 1000L, 5.0f, this.v);
            this.f105do.addGpsStatusListener(this.f109new);
            this.f105do.addNmeaListener(this.f109new);
            this.r = true;
        } catch (Exception e) {
        }
    }

    /* renamed from: int  reason: not valid java name */
    public Location m95int() {
        return this.D;
    }

    public void j() {
        if (this.r) {
            if (this.f105do != null) {
                try {
                    if (this.v != null) {
                        this.f105do.removeUpdates(this.v);
                    }
                    if (this.f109new != null) {
                        this.f105do.removeGpsStatusListener(this.f109new);
                        this.f105do.removeNmeaListener(this.f109new);
                    }
                    if (this.f106for != null) {
                        this.f106for.m115do();
                    }
                } catch (Exception e) {
                }
            }
            this.v = null;
            this.f109new = null;
            this.f105do = null;
            this.r = false;
            a(false);
        }
    }

    /* renamed from: new  reason: not valid java name */
    public boolean m96new() {
        return (this.D == null || this.D.getLatitude() == 0.0d || this.D.getLongitude() == 0.0d) ? false : true;
    }

    /* renamed from: try  reason: not valid java name */
    public String m97try() {
        return this.B;
    }
}
