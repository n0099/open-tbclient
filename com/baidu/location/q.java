package com.baidu.location;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    final /* synthetic */ m b;
    private String d;
    private String l;
    private String r;
    private List x;
    private List z;
    private boolean c = true;
    private boolean e = false;
    private String f = "";
    private double g = 500.0d;
    private double h = 500.0d;
    private double i = 0.0d;
    private int j = 0;
    private int k = 0;
    private boolean m = false;
    private String n = "";
    private char o = 'N';
    private double p = 0.0d;
    private double q = 500.0d;
    private boolean s = false;
    private int t = 1;
    private double u = 0.0d;
    private double v = 0.0d;
    private double w = 0.0d;
    private boolean y = false;
    private int A = 0;
    public int a = 0;

    public q(m mVar, List list, String str, String str2, String str3) {
        this.b = mVar;
        this.d = "";
        this.l = "";
        this.r = "";
        this.x = null;
        this.z = null;
        this.x = list;
        this.d = str;
        this.l = str2;
        this.r = str3;
        this.z = new ArrayList();
        a();
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
        return new double[]{Math.sin(Math.toRadians(d2)) * d, Math.cos(Math.toRadians(d2)) * d};
    }

    private double[] a(List list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        double[] a = a(90 - ((r) list.get(0)).b(), ((r) list.get(0)).a());
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                double[] a2 = a(90 - ((r) list.get(i)).b(), ((r) list.get(i)).a());
                a[0] = (a[0] + a2[0]) / 2.0d;
                a[1] = (a[1] + a2[1]) / 2.0d;
            }
        }
        return a;
    }

    private double[] b(double d, double d2) {
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

    public int a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        int i;
        double[] a;
        int i2;
        if (this.c) {
            if (z && this.e) {
                this.a = 1;
                if (this.k >= ap.z) {
                    return 1;
                }
                if (this.k <= ap.y) {
                    return 4;
                }
            }
            if (z2 && this.s) {
                this.a = 2;
                if (this.v <= ap.u) {
                    return 1;
                }
                if (this.v >= ap.v) {
                    return 4;
                }
            }
            if (z3 && this.s) {
                this.a = 3;
                if (this.u <= ap.w) {
                    return 1;
                }
                if (this.u >= ap.x) {
                    return 4;
                }
            }
            if (z4 && this.y) {
                this.a = 4;
                int i3 = 0;
                Iterator it = this.z.iterator();
                while (true) {
                    i2 = i3;
                    if (!it.hasNext()) {
                        break;
                    }
                    i3 = ((r) it.next()).c() >= ap.C ? i2 + 1 : i2;
                }
                if (i2 >= ap.B) {
                    return 1;
                }
                if (i2 <= ap.A) {
                    return 4;
                }
            }
            if (z5 && this.y) {
                this.a = 5;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (int i4 = 0; i4 < 10; i4++) {
                    arrayList.add(new ArrayList());
                }
                int i5 = 0;
                Iterator it2 = this.z.iterator();
                while (true) {
                    i = i5;
                    if (!it2.hasNext()) {
                        break;
                    }
                    r rVar = (r) it2.next();
                    if (rVar.c() >= 10 && rVar.b() >= 1) {
                        ((List) arrayList.get((rVar.c() - 10) / 5)).add(rVar);
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
                    if (((List) arrayList.get(i7)).size() != 0 && (a = a((List) arrayList.get(i7))) != null) {
                        arrayList2.add(a);
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
                double[] b = b(dArr[0], dArr[1]);
                if (b[0] <= ap.D) {
                    return 1;
                }
                if (b[0] >= ap.E) {
                    return 4;
                }
            }
            this.a = 0;
            return 3;
        }
        return 0;
    }

    public void a() {
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
                this.g = i3 * (Integer.valueOf(split[2].substring(0, 2)).intValue() + (Double.valueOf(split[2].substring(2, split[2].length())).doubleValue() / 60.0d));
                this.h = i4 * (Integer.valueOf(split[4].substring(0, 3)).intValue() + (Double.valueOf(split[4].substring(3, split[4].length())).doubleValue() / 60.0d));
                this.i = Double.valueOf(split[9]).doubleValue();
                this.j = Integer.valueOf(split[6]).intValue();
                this.k = Integer.valueOf(split[7]).intValue();
                this.e = true;
            }
        }
        if (a(this.l)) {
            String substring2 = this.l.substring(0, this.l.length() - 3);
            int i5 = 0;
            for (int i6 = 0; i6 < substring2.length(); i6++) {
                if (substring2.charAt(i6) == ',') {
                    i5++;
                }
            }
            String[] split2 = substring2.split(",", i5 + 1);
            if (!split2[9].equals("") && !split2[2].equals("")) {
                this.o = Character.valueOf(split2[2].charAt(0)).charValue();
                this.p = split2[7].equals("") ? 0.0d : 1.852d * Double.valueOf(split2[7]).doubleValue();
                this.q = (split2[8].equals("") || split2[8].equalsIgnoreCase("nan")) ? 500.0d : Double.valueOf(split2[8]).doubleValue();
                this.m = true;
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
                this.t = Integer.valueOf(split3[2]).intValue();
                this.u = Double.valueOf(split3[split3.length - 3]).doubleValue();
                this.v = Double.valueOf(split3[split3.length - 2]).doubleValue();
                this.w = Double.valueOf(split3[split3.length - 1]).doubleValue();
                this.s = true;
            }
        }
        if (this.x == null || this.x.size() <= 0) {
            this.y = false;
        } else {
            this.y = Integer.valueOf(((String) this.x.get(0)).split(",")[1]).intValue() == this.x.size();
            if (this.y) {
                Iterator it = this.x.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    if (!a(str2)) {
                        this.y = false;
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
                                this.A++;
                                this.z.add(new r(this, Integer.valueOf(split4[i12]).intValue(), Integer.valueOf(split4[i12 + 2]).intValue(), Integer.valueOf(split4[i12 + 1]).intValue(), split4[i12 + 3].equals("") ? 0 : Integer.valueOf(split4[i12 + 3]).intValue()));
                            }
                            i11 = i12 + 4;
                        }
                    }
                }
            }
        }
        this.c = this.e && this.s;
    }

    public int b() {
        return a(true, true, true, true, true);
    }

    public boolean c() {
        return this.c;
    }

    public double d() {
        return this.g;
    }

    public double e() {
        return this.h;
    }

    public double f() {
        return this.i;
    }

    public double g() {
        return this.p;
    }

    public double h() {
        return this.q;
    }

    public double i() {
        return this.u;
    }

    public double j() {
        return this.v;
    }

    public int k() {
        return this.k;
    }
}
