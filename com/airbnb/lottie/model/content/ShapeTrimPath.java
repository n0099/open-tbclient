package com.airbnb.lottie.model.content;

import d.a.a.f;
import d.a.a.q.a.r;
import d.a.a.s.j.b;
import d.a.a.s.k.a;
/* loaded from: classes.dex */
public class ShapeTrimPath implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1611a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f1612b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.a.s.i.b f1613c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a.a.s.i.b f1614d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.a.s.i.b f1615e;

    /* loaded from: classes.dex */
    public enum Type {
        Simultaneously,
        Individually;

        public static Type forId(int i) {
            if (i != 1) {
                if (i == 2) {
                    return Individually;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i);
            }
            return Simultaneously;
        }
    }

    public ShapeTrimPath(String str, Type type, d.a.a.s.i.b bVar, d.a.a.s.i.b bVar2, d.a.a.s.i.b bVar3) {
        this.f1611a = str;
        this.f1612b = type;
        this.f1613c = bVar;
        this.f1614d = bVar2;
        this.f1615e = bVar3;
    }

    @Override // d.a.a.s.j.b
    public d.a.a.q.a.b a(f fVar, a aVar) {
        return new r(aVar, this);
    }

    public d.a.a.s.i.b b() {
        return this.f1614d;
    }

    public String c() {
        return this.f1611a;
    }

    public d.a.a.s.i.b d() {
        return this.f1615e;
    }

    public d.a.a.s.i.b e() {
        return this.f1613c;
    }

    public Type f() {
        return this.f1612b;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f1613c + ", end: " + this.f1614d + ", offset: " + this.f1615e + "}";
    }
}
