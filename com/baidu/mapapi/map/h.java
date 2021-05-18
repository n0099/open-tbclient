package com.baidu.mapapi.map;

import android.graphics.Point;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final double f7178a;

    /* renamed from: b  reason: collision with root package name */
    public final double f7179b;

    /* renamed from: c  reason: collision with root package name */
    public final double f7180c;

    /* renamed from: d  reason: collision with root package name */
    public final double f7181d;

    /* renamed from: e  reason: collision with root package name */
    public final double f7182e;

    /* renamed from: f  reason: collision with root package name */
    public final double f7183f;

    public h(double d2, double d3, double d4, double d5) {
        this.f7178a = d2;
        this.f7179b = d4;
        this.f7180c = d3;
        this.f7181d = d5;
        this.f7182e = (d2 + d3) / 2.0d;
        this.f7183f = (d4 + d5) / 2.0d;
    }

    public boolean a(double d2, double d3) {
        return this.f7178a <= d2 && d2 <= this.f7180c && this.f7179b <= d3 && d3 <= this.f7181d;
    }

    public boolean a(double d2, double d3, double d4, double d5) {
        return d2 < this.f7180c && this.f7178a < d3 && d4 < this.f7181d && this.f7179b < d5;
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean a(h hVar) {
        return a(hVar.f7178a, hVar.f7180c, hVar.f7179b, hVar.f7181d);
    }

    public boolean b(h hVar) {
        return hVar.f7178a >= this.f7178a && hVar.f7180c <= this.f7180c && hVar.f7179b >= this.f7179b && hVar.f7181d <= this.f7181d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f7178a);
        sb.append(" minY: " + this.f7179b);
        sb.append(" maxX: " + this.f7180c);
        sb.append(" maxY: " + this.f7181d);
        sb.append(" midX: " + this.f7182e);
        sb.append(" midY: " + this.f7183f);
        return sb.toString();
    }
}
