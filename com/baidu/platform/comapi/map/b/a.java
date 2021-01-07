package com.baidu.platform.comapi.map.b;

import android.view.MotionEvent;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0290a f4307a = new C0290a(new b(0.0d, 0.0d), new b(1.0d, 0.0d));

    /* renamed from: b  reason: collision with root package name */
    public static final C0290a f4308b = new C0290a(new b(0.0d, 0.0d), new b(0.0d, 1.0d));
    public static final C0290a c = new C0290a(new b(0.0d, 1.0d), new b(0.0d, 0.0d));

    /* renamed from: com.baidu.platform.comapi.map.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0290a {

        /* renamed from: a  reason: collision with root package name */
        public b f4311a;

        /* renamed from: b  reason: collision with root package name */
        public b f4312b;

        public C0290a(b bVar, b bVar2) {
            this.f4311a = bVar;
            this.f4312b = bVar2;
        }

        public static C0290a a(MotionEvent motionEvent) {
            return new C0290a(new b(motionEvent.getX(0), motionEvent.getY(0)), new b(motionEvent.getX(1), motionEvent.getY(1)));
        }

        public b a() {
            return new b((this.f4311a.f4315a + this.f4312b.f4315a) / 2.0d, (this.f4311a.f4316b + this.f4312b.f4316b) / 2.0d);
        }

        public double b() {
            return Math.sqrt(((this.f4311a.f4315a - this.f4312b.f4315a) * (this.f4311a.f4315a - this.f4312b.f4315a)) + ((this.f4311a.f4316b - this.f4312b.f4316b) * (this.f4311a.f4316b - this.f4312b.f4316b)));
        }

        public d c() {
            return new d(this.f4312b.f4315a - this.f4311a.f4315a, this.f4312b.f4316b - this.f4311a.f4316b);
        }

        public String toString() {
            return getClass().getSimpleName() + "  a : " + this.f4311a.toString() + " b : " + this.f4312b.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public double f4315a;

        /* renamed from: b  reason: collision with root package name */
        public double f4316b;

        public b(double d, double d2) {
            this.f4315a = d;
            this.f4316b = d2;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.f4315a + " y : " + this.f4316b;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final double f4317a;

        /* renamed from: b  reason: collision with root package name */
        public final double f4318b;
        public final d c;

        public c(C0290a c0290a, C0290a c0290a2) {
            this.c = new d(c0290a.a(), c0290a2.a());
            this.f4318b = c0290a2.b() / c0290a.b();
            this.f4317a = d.a(c0290a.c(), c0290a2.c());
        }

        public String toString() {
            return getClass().getSimpleName() + " rotate : " + this.f4317a + " scale : " + (this.f4318b * 100.0d) + " move : " + this.c.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public double f4319a;

        /* renamed from: b  reason: collision with root package name */
        public double f4320b;

        public d(double d, double d2) {
            this.f4319a = d;
            this.f4320b = d2;
        }

        public d(b bVar, b bVar2) {
            this.f4319a = bVar2.f4315a - bVar.f4315a;
            this.f4320b = bVar2.f4316b - bVar.f4316b;
        }

        public static double a(d dVar, d dVar2) {
            double atan2 = Math.atan2(dVar.f4320b, dVar.f4319a) - Math.atan2(dVar2.f4320b, dVar2.f4319a);
            if (atan2 > 3.141592653589793d) {
                atan2 -= 6.283185307179586d;
            } else if (atan2 < -3.141592653589793d) {
                atan2 += 6.283185307179586d;
            }
            return (atan2 * 180.0d) / 3.141592653589793d;
        }

        public String toString() {
            return getClass().getSimpleName() + " x : " + this.f4319a + " y : " + this.f4320b;
        }
    }
}
