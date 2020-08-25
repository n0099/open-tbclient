package com.baidu.mapapi.map;

import android.graphics.Point;
/* loaded from: classes20.dex */
class l {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public l(double d, double d2, double d3, double d4) {
        this.a = d;
        this.b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    public boolean a(double d, double d2) {
        return this.a <= d && d <= this.c && this.b <= d2 && d2 <= this.d;
    }

    public boolean a(double d, double d2, double d3, double d4) {
        return d < this.c && this.a < d2 && d3 < this.d && this.b < d4;
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean a(l lVar) {
        return a(lVar.a, lVar.c, lVar.b, lVar.d);
    }

    public boolean b(l lVar) {
        return lVar.a >= this.a && lVar.c <= this.c && lVar.b >= this.b && lVar.d <= this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.a);
        sb.append(" minY: " + this.b);
        sb.append(" maxX: " + this.c);
        sb.append(" maxY: " + this.d);
        sb.append(" midX: " + this.e);
        sb.append(" midY: " + this.f);
        return sb.toString();
    }
}
