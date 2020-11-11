package com.baidu.platform.comapi.map.b;

import android.view.MotionEvent;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0281a f2899a = new C0281a(new b(0.0d, 0.0d), new b(1.0d, 0.0d));
    public static final C0281a b = new C0281a(new b(0.0d, 0.0d), new b(0.0d, 1.0d));
    public static final C0281a c = new C0281a(new b(0.0d, 1.0d), new b(0.0d, 0.0d));

    /* renamed from: com.baidu.platform.comapi.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0281a {

        /* renamed from: a  reason: collision with root package name */
        public b f2901a;
        public b b;

        public C0281a(b bVar, b bVar2) {
            this.f2901a = bVar;
            this.b = bVar2;
        }

        public static C0281a a(MotionEvent motionEvent) {
            return new C0281a(new b(motionEvent.getX(0), motionEvent.getY(0)), new b(motionEvent.getX(1), motionEvent.getY(1)));
        }

        public b a() {
            return new b((this.f2901a.f2903a + this.b.f2903a) / 2.0d, (this.f2901a.b + this.b.b) / 2.0d);
        }

        public double b() {
            return Math.sqrt(((this.f2901a.f2903a - this.b.f2903a) * (this.f2901a.f2903a - this.b.f2903a)) + ((this.f2901a.b - this.b.b) * (this.f2901a.b - this.b.b)));
        }

        public d c() {
            return new d(this.b.f2903a - this.f2901a.f2903a, this.b.b - this.f2901a.b);
        }

        public String toString() {
            return getClass().getSimpleName() + "  a : " + this.f2901a.toString() + " b : " + this.b.toString();
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public double f2903a;
        public double b;

        public b(double d, double d2) {
            this.f2903a = d;
            this.b = d2;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.f2903a + " y : " + this.b;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final double f2904a;
        public final double b;
        public final d c;

        public c(C0281a c0281a, C0281a c0281a2) {
            this.c = new d(c0281a.a(), c0281a2.a());
            this.b = c0281a2.b() / c0281a.b();
            this.f2904a = d.a(c0281a.c(), c0281a2.c());
        }

        public String toString() {
            return getClass().getSimpleName() + " rotate : " + this.f2904a + " scale : " + (this.b * 100.0d) + " move : " + this.c.toString();
        }
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public double f2905a;
        public double b;

        public d(double d, double d2) {
            this.f2905a = d;
            this.b = d2;
        }

        public d(b bVar, b bVar2) {
            this.f2905a = bVar2.f2903a - bVar.f2903a;
            this.b = bVar2.b - bVar.b;
        }

        public static double a(d dVar, d dVar2) {
            double atan2 = Math.atan2(dVar.b, dVar.f2905a) - Math.atan2(dVar2.b, dVar2.f2905a);
            if (atan2 > 3.141592653589793d) {
                atan2 -= 6.283185307179586d;
            } else if (atan2 < -3.141592653589793d) {
                atan2 += 6.283185307179586d;
            }
            return (atan2 * 180.0d) / 3.141592653589793d;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.f2905a + " y : " + this.b;
        }
    }
}
