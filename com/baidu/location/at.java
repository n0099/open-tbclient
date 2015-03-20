package com.baidu.location;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class at implements BDGeofence {

    /* renamed from: byte  reason: not valid java name */
    private static final String f60byte = "Administrative";

    /* renamed from: case  reason: not valid java name */
    private static final int f61case = 2;
    private static final int d = 100;
    private static final int e = 2;

    /* renamed from: else  reason: not valid java name */
    private static final int f62else = 1;

    /* renamed from: for  reason: not valid java name */
    private static final String f63for = "Circle";
    private static final int i = 3;

    /* renamed from: int  reason: not valid java name */
    public static final int f64int = 1;

    /* renamed from: void  reason: not valid java name */
    private static final long f65void = 2592000;
    private final int a;
    private float b;
    private final int c;

    /* renamed from: char  reason: not valid java name */
    private boolean f66char;

    /* renamed from: do  reason: not valid java name */
    private final String f67do;
    private boolean f;
    protected int g;

    /* renamed from: goto  reason: not valid java name */
    private final double f68goto;
    private long h;

    /* renamed from: if  reason: not valid java name */
    private boolean f69if;

    /* renamed from: long  reason: not valid java name */
    private final long f70long;

    /* renamed from: new  reason: not valid java name */
    private final String f71new;

    /* renamed from: try  reason: not valid java name */
    private final double f72try;

    public at(int i2, String str, double d2, double d3, int i3, long j, String str2) {
        m191do(i3);
        m194if(str);
        a(d2, d3);
        a(str2);
        m193if(j);
        this.c = i2;
        this.f67do = str;
        this.f68goto = d2;
        this.f72try = d3;
        this.a = i3;
        this.f70long = j;
        this.f71new = str2;
    }

    public at(String str, double d2, double d3, int i2, long j, String str2) {
        this(1, str, d3, d2, i2, j, str2);
    }

    private static void a(double d2, double d3) {
    }

    private static void a(String str) {
        if (!str.equals(BDGeofence.COORD_TYPE_BD09) && !str.equals(BDGeofence.COORD_TYPE_BD09LL) && !str.equals(BDGeofence.COORD_TYPE_GCJ)) {
            throw new IllegalArgumentException("invalid coord type: " + str);
        }
    }

    /* renamed from: do  reason: not valid java name */
    private static void m191do(int i2) {
        if (i2 != 1) {
            throw new IllegalArgumentException("invalid radius type: " + i2);
        }
    }

    /* renamed from: if  reason: not valid java name */
    private static String m192if(int i2) {
        switch (i2) {
            case 1:
                return f63for;
            case 2:
                return f60byte;
            default:
                return null;
        }
    }

    /* renamed from: if  reason: not valid java name */
    private static void m193if(long j) {
        if (j / 1000.0d > 2592000.0d) {
            throw new IllegalArgumentException("invalid druationMillis :" + j);
        }
    }

    /* renamed from: if  reason: not valid java name */
    private static void m194if(String str) {
        if (TextUtils.isEmpty(str) || str.length() > 100) {
            throw new IllegalArgumentException("Geofence name is null or too long: " + str);
        }
    }

    public double a() {
        return this.f72try;
    }

    public void a(float f) {
        this.b = f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2) {
        this.g = i2;
    }

    public void a(long j) {
        this.h = j;
    }

    public void a(boolean z) {
        this.f69if = z;
    }

    /* renamed from: byte  reason: not valid java name */
    public boolean m195byte() {
        return this.f;
    }

    /* renamed from: case  reason: not valid java name */
    public double m196case() {
        return this.f68goto;
    }

    /* renamed from: char  reason: not valid java name */
    public int m197char() {
        if (this.f66char) {
            return 1;
        }
        return this.f69if ? 2 : 3;
    }

    /* renamed from: do  reason: not valid java name */
    public float m198do() {
        return this.b;
    }

    /* renamed from: do  reason: not valid java name */
    public void m199do(boolean z) {
        this.f = z;
    }

    /* renamed from: else  reason: not valid java name */
    public long m200else() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof at)) {
            at atVar = (at) obj;
            return this.a == atVar.a && this.f68goto == atVar.f68goto && this.f72try == atVar.f72try && this.c == atVar.c && this.f71new == atVar.f71new;
        }
        return false;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m201for() {
        return this.f66char;
    }

    @Override // com.baidu.location.BDGeofence
    public String getGeofenceId() {
        return this.f67do;
    }

    /* renamed from: goto  reason: not valid java name */
    public long m202goto() {
        return this.f70long;
    }

    /* renamed from: if  reason: not valid java name */
    public void m203if(boolean z) {
        this.f66char = z;
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m204if() {
        return this.f69if;
    }

    /* renamed from: int  reason: not valid java name */
    public String m205int() {
        return this.f71new;
    }

    /* renamed from: new  reason: not valid java name */
    public int m206new() {
        return this.a;
    }

    public String toString() {
        return String.format("Geofence[Type:%s, Name:%s, latitude:%.6f, longitude:%.6f, radius:%.0f, expriation:%d, coordType:%s, fenceType:%d]", m192if(this.c), this.f67do, Double.valueOf(this.f68goto), Double.valueOf(this.f72try), Float.valueOf(this.b), Long.valueOf(this.f70long), this.f71new, Integer.valueOf(m197char()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: try  reason: not valid java name */
    public int m207try() {
        return this.g;
    }
}
