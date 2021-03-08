package com.baidu.mapapi.map;

import android.graphics.Point;
/* loaded from: classes4.dex */
class g {

    /* renamed from: a  reason: collision with root package name */
    public final double f2066a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public g(double d, double d2, double d3, double d4) {
        this.f2066a = d;
        this.b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    public boolean a(double d, double d2) {
        return this.f2066a <= d && d <= this.c && this.b <= d2 && d2 <= this.d;
    }

    public boolean a(double d, double d2, double d3, double d4) {
        return d < this.c && this.f2066a < d2 && d3 < this.d && this.b < d4;
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean a(g gVar) {
        return a(gVar.f2066a, gVar.c, gVar.b, gVar.d);
    }

    public boolean b(g gVar) {
        return gVar.f2066a >= this.f2066a && gVar.c <= this.c && gVar.b >= this.b && gVar.d <= this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f2066a);
        sb.append(" minY: " + this.b);
        sb.append(" maxX: " + this.c);
        sb.append(" maxY: " + this.d);
        sb.append(" midX: " + this.e);
        sb.append(" midY: " + this.f);
        return sb.toString();
    }
}
