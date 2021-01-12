package com.baidu.mapapi.map;

import android.graphics.Point;
/* loaded from: classes6.dex */
class g {

    /* renamed from: a  reason: collision with root package name */
    public final double f2794a;

    /* renamed from: b  reason: collision with root package name */
    public final double f2795b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public g(double d, double d2, double d3, double d4) {
        this.f2794a = d;
        this.f2795b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    public boolean a(double d, double d2) {
        return this.f2794a <= d && d <= this.c && this.f2795b <= d2 && d2 <= this.d;
    }

    public boolean a(double d, double d2, double d3, double d4) {
        return d < this.c && this.f2794a < d2 && d3 < this.d && this.f2795b < d4;
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean a(g gVar) {
        return a(gVar.f2794a, gVar.c, gVar.f2795b, gVar.d);
    }

    public boolean b(g gVar) {
        return gVar.f2794a >= this.f2794a && gVar.c <= this.c && gVar.f2795b >= this.f2795b && gVar.d <= this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f2794a);
        sb.append(" minY: " + this.f2795b);
        sb.append(" maxX: " + this.c);
        sb.append(" maxY: " + this.d);
        sb.append(" midX: " + this.e);
        sb.append(" midY: " + this.f);
        return sb.toString();
    }
}
