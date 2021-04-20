package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.b;
/* loaded from: classes2.dex */
public class q<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f8966a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f8967b;

    /* renamed from: c  reason: collision with root package name */
    public final v f8968c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f8969d;

    /* loaded from: classes2.dex */
    public interface a {
        void a(v vVar);
    }

    /* loaded from: classes2.dex */
    public interface b<T> {
        void a(T t);
    }

    public q(T t, b.a aVar) {
        this.f8969d = false;
        this.f8966a = t;
        this.f8967b = aVar;
        this.f8968c = null;
    }

    public static <T> q<T> a(T t, b.a aVar) {
        return new q<>(t, aVar);
    }

    public static <T> q<T> a(v vVar) {
        return new q<>(vVar);
    }

    public boolean a() {
        return this.f8968c == null;
    }

    public q(v vVar) {
        this.f8969d = false;
        this.f8966a = null;
        this.f8967b = null;
        this.f8968c = vVar;
    }
}
