package com.baidu.mapapi.map;

import android.graphics.Point;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final double f7068a;

    /* renamed from: b  reason: collision with root package name */
    public final double f7069b;

    /* renamed from: c  reason: collision with root package name */
    public final double f7070c;

    /* renamed from: d  reason: collision with root package name */
    public final double f7071d;

    /* renamed from: e  reason: collision with root package name */
    public final double f7072e;

    /* renamed from: f  reason: collision with root package name */
    public final double f7073f;

    public g(double d2, double d3, double d4, double d5) {
        this.f7068a = d2;
        this.f7069b = d4;
        this.f7070c = d3;
        this.f7071d = d5;
        this.f7072e = (d2 + d3) / 2.0d;
        this.f7073f = (d4 + d5) / 2.0d;
    }

    public boolean a(double d2, double d3) {
        return this.f7068a <= d2 && d2 <= this.f7070c && this.f7069b <= d3 && d3 <= this.f7071d;
    }

    public boolean a(double d2, double d3, double d4, double d5) {
        return d2 < this.f7070c && this.f7068a < d3 && d4 < this.f7071d && this.f7069b < d5;
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean a(g gVar) {
        return a(gVar.f7068a, gVar.f7070c, gVar.f7069b, gVar.f7071d);
    }

    public boolean b(g gVar) {
        return gVar.f7068a >= this.f7068a && gVar.f7070c <= this.f7070c && gVar.f7069b >= this.f7069b && gVar.f7071d <= this.f7071d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f7068a);
        sb.append(" minY: " + this.f7069b);
        sb.append(" maxX: " + this.f7070c);
        sb.append(" maxY: " + this.f7071d);
        sb.append(" midX: " + this.f7072e);
        sb.append(" midY: " + this.f7073f);
        return sb.toString();
    }
}
