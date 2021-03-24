package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import d.a.a.f;
import d.a.a.s.i.m;
import d.a.a.s.j.b;
import d.a.a.s.k.a;
/* loaded from: classes.dex */
public class PolystarShape implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1593a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f1594b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.s.i.b f1595c;

    /* renamed from: d  reason: collision with root package name */
    public final m<PointF, PointF> f1596d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.s.i.b f1597e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.a.s.i.b f1598f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.a.s.i.b f1599g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.a.s.i.b f1600h;
    public final d.a.a.s.i.b i;

    /* loaded from: classes.dex */
    public enum Type {
        Star(1),
        Polygon(2);
        
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

    public PolystarShape(String str, Type type, d.a.a.s.i.b bVar, m<PointF, PointF> mVar, d.a.a.s.i.b bVar2, d.a.a.s.i.b bVar3, d.a.a.s.i.b bVar4, d.a.a.s.i.b bVar5, d.a.a.s.i.b bVar6) {
        this.f1593a = str;
        this.f1594b = type;
        this.f1595c = bVar;
        this.f1596d = mVar;
        this.f1597e = bVar2;
        this.f1598f = bVar3;
        this.f1599g = bVar4;
        this.f1600h = bVar5;
        this.i = bVar6;
    }

    @Override // d.a.a.s.j.b
    public d.a.a.q.a.b a(f fVar, a aVar) {
        return new d.a.a.q.a.m(fVar, aVar, this);
    }

    public d.a.a.s.i.b b() {
        return this.f1598f;
    }

    public d.a.a.s.i.b c() {
        return this.f1600h;
    }

    public String d() {
        return this.f1593a;
    }

    public d.a.a.s.i.b e() {
        return this.f1599g;
    }

    public d.a.a.s.i.b f() {
        return this.i;
    }

    public d.a.a.s.i.b g() {
        return this.f1595c;
    }

    public m<PointF, PointF> h() {
        return this.f1596d;
    }

    public d.a.a.s.i.b i() {
        return this.f1597e;
    }

    public Type j() {
        return this.f1594b;
    }
}
