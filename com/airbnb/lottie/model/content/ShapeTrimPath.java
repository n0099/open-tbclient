package com.airbnb.lottie.model.content;

import d.a.a.f;
import d.a.a.s.b.c;
import d.a.a.s.b.s;
import d.a.a.u.j.b;
import d.a.a.u.k.a;
/* loaded from: classes.dex */
public class ShapeTrimPath implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1612a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f1613b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.u.i.b f1614c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.u.i.b f1615d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.u.i.b f1616e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1617f;

    /* loaded from: classes.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i) {
            if (i != 1) {
                if (i == 2) {
                    return INDIVIDUALLY;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i);
            }
            return SIMULTANEOUSLY;
        }
    }

    public ShapeTrimPath(String str, Type type, d.a.a.u.i.b bVar, d.a.a.u.i.b bVar2, d.a.a.u.i.b bVar3, boolean z) {
        this.f1612a = str;
        this.f1613b = type;
        this.f1614c = bVar;
        this.f1615d = bVar2;
        this.f1616e = bVar3;
        this.f1617f = z;
    }

    @Override // d.a.a.u.j.b
    public c a(f fVar, a aVar) {
        return new s(aVar, this);
    }

    public d.a.a.u.i.b b() {
        return this.f1615d;
    }

    public String c() {
        return this.f1612a;
    }

    public d.a.a.u.i.b d() {
        return this.f1616e;
    }

    public d.a.a.u.i.b e() {
        return this.f1614c;
    }

    public Type f() {
        return this.f1613b;
    }

    public boolean g() {
        return this.f1617f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f1614c + ", end: " + this.f1615d + ", offset: " + this.f1616e + "}";
    }
}
