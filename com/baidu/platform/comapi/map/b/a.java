package com.baidu.platform.comapi.map.b;

import android.view.MotionEvent;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0290a f4306a = new C0290a(new b(0.0d, 0.0d), new b(1.0d, 0.0d));

    /* renamed from: b  reason: collision with root package name */
    public static final C0290a f4307b = new C0290a(new b(0.0d, 0.0d), new b(0.0d, 1.0d));
    public static final C0290a c = new C0290a(new b(0.0d, 1.0d), new b(0.0d, 0.0d));

    /* renamed from: com.baidu.platform.comapi.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0290a {

        /* renamed from: a  reason: collision with root package name */
        public b f4310a;

        /* renamed from: b  reason: collision with root package name */
        public b f4311b;

        public C0290a(b bVar, b bVar2) {
            this.f4310a = bVar;
            this.f4311b = bVar2;
        }

        public static C0290a a(MotionEvent motionEvent) {
            return new C0290a(new b(motionEvent.getX(0), motionEvent.getY(0)), new b(motionEvent.getX(1), motionEvent.getY(1)));
        }

        public b a() {
            return new b((this.f4310a.f4314a + this.f4311b.f4314a) / 2.0d, (this.f4310a.f4315b + this.f4311b.f4315b) / 2.0d);
        }

        public double b() {
            return Math.sqrt(((this.f4310a.f4314a - this.f4311b.f4314a) * (this.f4310a.f4314a - this.f4311b.f4314a)) + ((this.f4310a.f4315b - this.f4311b.f4315b) * (this.f4310a.f4315b - this.f4311b.f4315b)));
        }

        public d c() {
            return new d(this.f4311b.f4314a - this.f4310a.f4314a, this.f4311b.f4315b - this.f4310a.f4315b);
        }

        public String toString() {
            return getClass().getSimpleName() + "  a : " + this.f4310a.toString() + " b : " + this.f4311b.toString();
        }
    }

    /* loaded from: classes15.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public double f4314a;

        /* renamed from: b  reason: collision with root package name */
        public double f4315b;

        public b(double d, double d2) {
            this.f4314a = d;
            this.f4315b = d2;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.f4314a + " y : " + this.f4315b;
        }
    }

    /* loaded from: classes15.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final double f4316a;

        /* renamed from: b  reason: collision with root package name */
        public final double f4317b;
        public final d c;

        public c(C0290a c0290a, C0290a c0290a2) {
            this.c = new d(c0290a.a(), c0290a2.a());
            this.f4317b = c0290a2.b() / c0290a.b();
            this.f4316a = d.a(c0290a.c(), c0290a2.c());
        }

        public String toString() {
            return getClass().getSimpleName() + " rotate : " + this.f4316a + " scale : " + (this.f4317b * 100.0d) + " move : " + this.c.toString();
        }
    }

    /* loaded from: classes15.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public double f4318a;

        /* renamed from: b  reason: collision with root package name */
        public double f4319b;

        public d(double d, double d2) {
            this.f4318a = d;
            this.f4319b = d2;
        }

        public d(b bVar, b bVar2) {
            this.f4318a = bVar2.f4314a - bVar.f4314a;
            this.f4319b = bVar2.f4315b - bVar.f4315b;
        }

        public static double a(d dVar, d dVar2) {
            double atan2 = Math.atan2(dVar.f4319b, dVar.f4318a) - Math.atan2(dVar2.f4319b, dVar2.f4318a);
            if (atan2 > 3.141592653589793d) {
                atan2 -= 6.283185307179586d;
            } else if (atan2 < -3.141592653589793d) {
                atan2 += 6.283185307179586d;
            }
            return (atan2 * 180.0d) / 3.141592653589793d;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.f4318a + " y : " + this.f4319b;
        }
    }
}
