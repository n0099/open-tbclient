package com.baidu.mapapi.map;

import android.graphics.Point;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final double f7104a;

    /* renamed from: b  reason: collision with root package name */
    public final double f7105b;

    /* renamed from: c  reason: collision with root package name */
    public final double f7106c;

    /* renamed from: d  reason: collision with root package name */
    public final double f7107d;

    /* renamed from: e  reason: collision with root package name */
    public final double f7108e;

    /* renamed from: f  reason: collision with root package name */
    public final double f7109f;

    public g(double d2, double d3, double d4, double d5) {
        this.f7104a = d2;
        this.f7105b = d4;
        this.f7106c = d3;
        this.f7107d = d5;
        this.f7108e = (d2 + d3) / 2.0d;
        this.f7109f = (d4 + d5) / 2.0d;
    }

    public boolean a(double d2, double d3) {
        return this.f7104a <= d2 && d2 <= this.f7106c && this.f7105b <= d3 && d3 <= this.f7107d;
    }

    public boolean a(double d2, double d3, double d4, double d5) {
        return d2 < this.f7106c && this.f7104a < d3 && d4 < this.f7107d && this.f7105b < d5;
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean a(g gVar) {
        return a(gVar.f7104a, gVar.f7106c, gVar.f7105b, gVar.f7107d);
    }

    public boolean b(g gVar) {
        return gVar.f7104a >= this.f7104a && gVar.f7106c <= this.f7106c && gVar.f7105b >= this.f7105b && gVar.f7107d <= this.f7107d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f7104a);
        sb.append(" minY: " + this.f7105b);
        sb.append(" maxX: " + this.f7106c);
        sb.append(" maxY: " + this.f7107d);
        sb.append(" midX: " + this.f7108e);
        sb.append(" midY: " + this.f7109f);
        return sb.toString();
    }
}
