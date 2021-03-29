package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.b;
/* loaded from: classes2.dex */
public class q<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f9408a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f9409b;

    /* renamed from: c  reason: collision with root package name */
    public final v f9410c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9411d;

    /* loaded from: classes2.dex */
    public interface a {
        void a(v vVar);
    }

    /* loaded from: classes2.dex */
    public interface b<T> {
        void a(T t);
    }

    public q(T t, b.a aVar) {
        this.f9411d = false;
        this.f9408a = t;
        this.f9409b = aVar;
        this.f9410c = null;
    }

    public static <T> q<T> a(T t, b.a aVar) {
        return new q<>(t, aVar);
    }

    public static <T> q<T> a(v vVar) {
        return new q<>(vVar);
    }

    public boolean a() {
        return this.f9410c == null;
    }

    public q(v vVar) {
        this.f9411d = false;
        this.f9408a = null;
        this.f9409b = null;
        this.f9410c = vVar;
    }
}
