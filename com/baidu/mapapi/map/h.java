package com.baidu.mapapi.map;

import android.graphics.Point;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final double f7121a;

    /* renamed from: b  reason: collision with root package name */
    public final double f7122b;

    /* renamed from: c  reason: collision with root package name */
    public final double f7123c;

    /* renamed from: d  reason: collision with root package name */
    public final double f7124d;

    /* renamed from: e  reason: collision with root package name */
    public final double f7125e;

    /* renamed from: f  reason: collision with root package name */
    public final double f7126f;

    public h(double d2, double d3, double d4, double d5) {
        this.f7121a = d2;
        this.f7122b = d4;
        this.f7123c = d3;
        this.f7124d = d5;
        this.f7125e = (d2 + d3) / 2.0d;
        this.f7126f = (d4 + d5) / 2.0d;
    }

    public boolean a(double d2, double d3) {
        return this.f7121a <= d2 && d2 <= this.f7123c && this.f7122b <= d3 && d3 <= this.f7124d;
    }

    public boolean a(double d2, double d3, double d4, double d5) {
        return d2 < this.f7123c && this.f7121a < d3 && d4 < this.f7124d && this.f7122b < d5;
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean a(h hVar) {
        return a(hVar.f7121a, hVar.f7123c, hVar.f7122b, hVar.f7124d);
    }

    public boolean b(h hVar) {
        return hVar.f7121a >= this.f7121a && hVar.f7123c <= this.f7123c && hVar.f7122b >= this.f7122b && hVar.f7124d <= this.f7124d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f7121a);
        sb.append(" minY: " + this.f7122b);
        sb.append(" maxX: " + this.f7123c);
        sb.append(" maxY: " + this.f7124d);
        sb.append(" midX: " + this.f7125e);
        sb.append(" midY: " + this.f7126f);
        return sb.toString();
    }
}
