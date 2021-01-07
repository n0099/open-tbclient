package com.baidu.mapapi.map;

import android.graphics.Point;
/* loaded from: classes3.dex */
class l {

    /* renamed from: a  reason: collision with root package name */
    public final double f2921a;

    /* renamed from: b  reason: collision with root package name */
    public final double f2922b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public l(double d, double d2, double d3, double d4) {
        this.f2921a = d;
        this.f2922b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    public boolean a(double d, double d2) {
        return this.f2921a <= d && d <= this.c && this.f2922b <= d2 && d2 <= this.d;
    }

    public boolean a(double d, double d2, double d3, double d4) {
        return d < this.c && this.f2921a < d2 && d3 < this.d && this.f2922b < d4;
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean a(l lVar) {
        return a(lVar.f2921a, lVar.c, lVar.f2922b, lVar.d);
    }

    public boolean b(l lVar) {
        return lVar.f2921a >= this.f2921a && lVar.c <= this.c && lVar.f2922b >= this.f2922b && lVar.d <= this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f2921a);
        sb.append(" minY: " + this.f2922b);
        sb.append(" maxX: " + this.c);
        sb.append(" maxY: " + this.d);
        sb.append(" midX: " + this.e);
        sb.append(" midY: " + this.f);
        return sb.toString();
    }
}
