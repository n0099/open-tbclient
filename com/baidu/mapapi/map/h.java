package com.baidu.mapapi.map;

import android.graphics.Point;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final double f7078a;

    /* renamed from: b  reason: collision with root package name */
    public final double f7079b;

    /* renamed from: c  reason: collision with root package name */
    public final double f7080c;

    /* renamed from: d  reason: collision with root package name */
    public final double f7081d;

    /* renamed from: e  reason: collision with root package name */
    public final double f7082e;

    /* renamed from: f  reason: collision with root package name */
    public final double f7083f;

    public h(double d2, double d3, double d4, double d5) {
        this.f7078a = d2;
        this.f7079b = d4;
        this.f7080c = d3;
        this.f7081d = d5;
        this.f7082e = (d2 + d3) / 2.0d;
        this.f7083f = (d4 + d5) / 2.0d;
    }

    public boolean a(double d2, double d3) {
        return this.f7078a <= d2 && d2 <= this.f7080c && this.f7079b <= d3 && d3 <= this.f7081d;
    }

    public boolean a(double d2, double d3, double d4, double d5) {
        return d2 < this.f7080c && this.f7078a < d3 && d4 < this.f7081d && this.f7079b < d5;
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean a(h hVar) {
        return a(hVar.f7078a, hVar.f7080c, hVar.f7079b, hVar.f7081d);
    }

    public boolean b(h hVar) {
        return hVar.f7078a >= this.f7078a && hVar.f7080c <= this.f7080c && hVar.f7079b >= this.f7079b && hVar.f7081d <= this.f7081d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f7078a);
        sb.append(" minY: " + this.f7079b);
        sb.append(" maxX: " + this.f7080c);
        sb.append(" maxY: " + this.f7081d);
        sb.append(" midX: " + this.f7082e);
        sb.append(" midY: " + this.f7083f);
        return sb.toString();
    }
}
