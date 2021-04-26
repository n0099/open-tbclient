package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.b;
/* loaded from: classes2.dex */
public class q<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f9296a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f9297b;

    /* renamed from: c  reason: collision with root package name */
    public final v f9298c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9299d;

    /* loaded from: classes2.dex */
    public interface a {
        void a(v vVar);
    }

    /* loaded from: classes2.dex */
    public interface b<T> {
        void a(T t);
    }

    public q(T t, b.a aVar) {
        this.f9299d = false;
        this.f9296a = t;
        this.f9297b = aVar;
        this.f9298c = null;
    }

    public static <T> q<T> a(T t, b.a aVar) {
        return new q<>(t, aVar);
    }

    public static <T> q<T> a(v vVar) {
        return new q<>(vVar);
    }

    public boolean a() {
        return this.f9298c == null;
    }

    public q(v vVar) {
        this.f9299d = false;
        this.f9296a = null;
        this.f9297b = null;
        this.f9298c = vVar;
    }
}
