package com.baidu.mapapi.map;

import android.graphics.Point;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final double f7359a;

    /* renamed from: b  reason: collision with root package name */
    public final double f7360b;

    /* renamed from: c  reason: collision with root package name */
    public final double f7361c;

    /* renamed from: d  reason: collision with root package name */
    public final double f7362d;

    /* renamed from: e  reason: collision with root package name */
    public final double f7363e;

    /* renamed from: f  reason: collision with root package name */
    public final double f7364f;

    public g(double d2, double d3, double d4, double d5) {
        this.f7359a = d2;
        this.f7360b = d4;
        this.f7361c = d3;
        this.f7362d = d5;
        this.f7363e = (d2 + d3) / 2.0d;
        this.f7364f = (d4 + d5) / 2.0d;
    }

    public boolean a(double d2, double d3) {
        return this.f7359a <= d2 && d2 <= this.f7361c && this.f7360b <= d3 && d3 <= this.f7362d;
    }

    public boolean a(double d2, double d3, double d4, double d5) {
        return d2 < this.f7361c && this.f7359a < d3 && d4 < this.f7362d && this.f7360b < d5;
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean a(g gVar) {
        return a(gVar.f7359a, gVar.f7361c, gVar.f7360b, gVar.f7362d);
    }

    public boolean b(g gVar) {
        return gVar.f7359a >= this.f7359a && gVar.f7361c <= this.f7361c && gVar.f7360b >= this.f7360b && gVar.f7362d <= this.f7362d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("minX: " + this.f7359a);
        sb.append(" minY: " + this.f7360b);
        sb.append(" maxX: " + this.f7361c);
        sb.append(" maxY: " + this.f7362d);
        sb.append(" midX: " + this.f7363e);
        sb.append(" midY: " + this.f7364f);
        return sb.toString();
    }
}
