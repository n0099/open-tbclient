package com.baidu.mapapi.map;

import android.graphics.Point;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final double f7069a;

    /* renamed from: b  reason: collision with root package name */
    public final double f7070b;

    /* renamed from: c  reason: collision with root package name */
    public final double f7071c;

    /* renamed from: d  reason: collision with root package name */
    public final double f7072d;

    /* renamed from: e  reason: collision with root package name */
    public final double f7073e;

    /* renamed from: f  reason: collision with root package name */
    public final double f7074f;

    public g(double d2, double d3, double d4, double d5) {
        this.f7069a = d2;
        this.f7070b = d4;
        this.f7071c = d3;
        this.f7072d = d5;
        this.f7073e = (d2 + d3) / 2.0d;
        this.f7074f = (d4 + d5) / 2.0d;
    }

    public boolean a(double d2, double d3) {
        return this.f7069a <= d2 && d2 <= this.f7071c && this.f7070b <= d3 && d3 <= this.f7072d;
    }

    public boolean a(double d2, double d3, double d4, double d5) {
        return d2 < this.f7071c && this.f7069a < d3 && d4 < this.f7072d && this.f7070b < d5;
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean a(g gVar) {
        return a(gVar.f7069a, gVar.f7071c, gVar.f7070b, gVar.f7072d);
    }

    public boolean b(g gVar) {
        return gVar.f7069a >= this.f7069a && gVar.f7071c <= this.f7071c && gVar.f7070b >= this.f7070b && gVar.f7072d <= this.f7072d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f7069a);
        sb.append(" minY: " + this.f7070b);
        sb.append(" maxX: " + this.f7071c);
        sb.append(" maxY: " + this.f7072d);
        sb.append(" midX: " + this.f7073e);
        sb.append(" midY: " + this.f7074f);
        return sb.toString();
    }
}
