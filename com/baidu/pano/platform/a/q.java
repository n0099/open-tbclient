package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.b;
/* loaded from: classes2.dex */
public class q<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f9407a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f9408b;

    /* renamed from: c  reason: collision with root package name */
    public final v f9409c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9410d;

    /* loaded from: classes2.dex */
    public interface a {
        void a(v vVar);
    }

    /* loaded from: classes2.dex */
    public interface b<T> {
        void a(T t);
    }

    public q(T t, b.a aVar) {
        this.f9410d = false;
        this.f9407a = t;
        this.f9408b = aVar;
        this.f9409c = null;
    }

    public static <T> q<T> a(T t, b.a aVar) {
        return new q<>(t, aVar);
    }

    public static <T> q<T> a(v vVar) {
        return new q<>(vVar);
    }

    public boolean a() {
        return this.f9409c == null;
    }

    public q(v vVar) {
        this.f9410d = false;
        this.f9407a = null;
        this.f9408b = null;
        this.f9409c = vVar;
    }
}
