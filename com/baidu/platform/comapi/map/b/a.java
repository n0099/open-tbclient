package com.baidu.platform.comapi.map.b;

import android.view.MotionEvent;
/* loaded from: classes3.dex */
public class a {
    public static final C0240a a = new C0240a(new b(0.0d, 0.0d), new b(1.0d, 0.0d));
    public static final C0240a b = new C0240a(new b(0.0d, 0.0d), new b(0.0d, 1.0d));
    public static final C0240a c = new C0240a(new b(0.0d, 1.0d), new b(0.0d, 0.0d));

    /* renamed from: com.baidu.platform.comapi.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0240a {
        public b a;
        public b b;

        public C0240a(b bVar, b bVar2) {
            this.a = bVar;
            this.b = bVar2;
        }

        public static C0240a a(MotionEvent motionEvent) {
            return new C0240a(new b(motionEvent.getX(0), motionEvent.getY(0)), new b(motionEvent.getX(1), motionEvent.getY(1)));
        }

        public b a() {
            return new b((this.a.a + this.b.a) / 2.0d, (this.a.b + this.b.b) / 2.0d);
        }

        public double b() {
            return Math.sqrt(((this.a.a - this.b.a) * (this.a.a - this.b.a)) + ((this.a.b - this.b.b) * (this.a.b - this.b.b)));
        }

        public d c() {
            return new d(this.b.a - this.a.a, this.b.b - this.a.b);
        }

        public String toString() {
            return getClass().getSimpleName() + "  a : " + this.a.toString() + " b : " + this.b.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public double a;
        public double b;

        public b(double d, double d2) {
            this.a = d;
            this.b = d2;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.a + " y : " + this.b;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public final double a;
        public final double b;
        public final d c;

        public c(C0240a c0240a, C0240a c0240a2) {
            this.c = new d(c0240a.a(), c0240a2.a());
            this.b = c0240a2.b() / c0240a.b();
            this.a = d.a(c0240a.c(), c0240a2.c());
        }

        public String toString() {
            return getClass().getSimpleName() + " rotate : " + this.a + " scale : " + (this.b * 100.0d) + " move : " + this.c.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public double a;
        public double b;

        public d(double d, double d2) {
            this.a = d;
            this.b = d2;
        }

        public d(b bVar, b bVar2) {
            this.a = bVar2.a - bVar.a;
            this.b = bVar2.b - bVar.b;
        }

        public static double a(d dVar, d dVar2) {
            double atan2 = Math.atan2(dVar.b, dVar.a) - Math.atan2(dVar2.b, dVar2.a);
            if (atan2 > 3.141592653589793d) {
                atan2 -= 6.283185307179586d;
            } else if (atan2 < -3.141592653589793d) {
                atan2 += 6.283185307179586d;
            }
            return (atan2 * 180.0d) / 3.141592653589793d;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.a + " y : " + this.b;
        }
    }
}
