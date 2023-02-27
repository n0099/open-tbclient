package com.baidu.mapapi.map;

import android.graphics.Point;
/* loaded from: classes2.dex */
public class m {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public m(double d, double d2, double d3, double d4) {
        this.a = d;
        this.b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    public boolean a(double d, double d2, double d3, double d4) {
        if (d < this.c && this.a < d2 && d3 < this.d && this.b < d4) {
            return true;
        }
        return false;
    }

    public boolean a(double d, double d2) {
        if (this.a <= d && d <= this.c && this.b <= d2 && d2 <= this.d) {
            return true;
        }
        return false;
    }

    public boolean a(Point point) {
        return a(point.x, point.y);
    }

    public boolean b(m mVar) {
        if (mVar.a >= this.a && mVar.c <= this.c && mVar.b >= this.b && mVar.d <= this.d) {
            return true;
        }
        return false;
    }

    public boolean a(m mVar) {
        return a(mVar.a, mVar.c, mVar.b, mVar.d);
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
