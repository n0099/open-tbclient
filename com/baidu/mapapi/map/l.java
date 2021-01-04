package com.baidu.mapapi.map;

import android.graphics.Point;
/* loaded from: classes15.dex */
class l {

    /* renamed from: a  reason: collision with root package name */
    public final double f2920a;

    /* renamed from: b  reason: collision with root package name */
    public final double f2921b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public l(double d, double d2, double d3, double d4) {
        this.f2920a = d;
        this.f2921b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    public boolean a(double d, double d2) {
        return this.f2920a <= d && d <= this.c && this.f2921b <= d2 && d2 <= this.d;
    }

    public boolean a(double d, double d2, double d3, double d4) {
        return d < this.c && this.f2920a < d2 && d3 < this.d && this.f2921b < d4;
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean a(l lVar) {
        return a(lVar.f2920a, lVar.c, lVar.f2921b, lVar.d);
    }

    public boolean b(l lVar) {
        return lVar.f2920a >= this.f2920a && lVar.c <= this.c && lVar.f2921b >= this.f2921b && lVar.d <= this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f2920a);
        sb.append(" minY: " + this.f2921b);
        sb.append(" maxX: " + this.c);
        sb.append(" maxY: " + this.d);
        sb.append(" midX: " + this.e);
        sb.append(" midY: " + this.f);
        return sb.toString();
    }
}
