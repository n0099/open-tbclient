package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import d.a.a.f;
import d.a.a.s.b.c;
import d.a.a.s.b.n;
import d.a.a.u.i.m;
import d.a.a.u.j.b;
import d.a.a.u.k.a;
/* loaded from: classes.dex */
public class PolystarShape implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1594a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f1595b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.u.i.b f1596c;

    /* renamed from: d  reason: collision with root package name */
    public final m<PointF, PointF> f1597d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.u.i.b f1598e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.u.i.b f1599f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.u.i.b f1600g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.a.u.i.b f1601h;
    public final d.a.a.u.i.b i;
    public final boolean j;

    /* loaded from: classes.dex */
    public enum Type {
        STAR(1),
        POLYGON(2);
        
        public final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, d.a.a.u.i.b bVar, m<PointF, PointF> mVar, d.a.a.u.i.b bVar2, d.a.a.u.i.b bVar3, d.a.a.u.i.b bVar4, d.a.a.u.i.b bVar5, d.a.a.u.i.b bVar6, boolean z) {
        this.f1594a = str;
        this.f1595b = type;
        this.f1596c = bVar;
        this.f1597d = mVar;
        this.f1598e = bVar2;
        this.f1599f = bVar3;
        this.f1600g = bVar4;
        this.f1601h = bVar5;
        this.i = bVar6;
        this.j = z;
    }

    @Override // d.a.a.u.j.b
    public c a(f fVar, a aVar) {
        return new n(fVar, aVar, this);
    }

    public d.a.a.u.i.b b() {
        return this.f1599f;
    }

    public d.a.a.u.i.b c() {
        return this.f1601h;
    }

    public String d() {
        return this.f1594a;
    }

    public d.a.a.u.i.b e() {
        return this.f1600g;
    }

    public d.a.a.u.i.b f() {
        return this.i;
    }

    public d.a.a.u.i.b g() {
        return this.f1596c;
    }

    public m<PointF, PointF> h() {
        return this.f1597d;
    }

    public d.a.a.u.i.b i() {
        return this.f1598e;
    }

    public Type j() {
        return this.f1595b;
    }

    public boolean k() {
        return this.j;
    }
}
