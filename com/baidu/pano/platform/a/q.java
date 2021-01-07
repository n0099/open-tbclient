package com.baidu.pano.platform.a;

import com.baidu.pano.platform.a.b;
/* loaded from: classes3.dex */
public class q<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f3928a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f3929b;
    public final v c;
    public boolean d;

    /* loaded from: classes3.dex */
    public interface a {
        void a(v vVar);
    }

    /* loaded from: classes3.dex */
    public interface b<T> {
        void a(T t);
    }

    public static <T> q<T> a(T t, b.a aVar) {
        return new q<>(t, aVar);
    }

    public static <T> q<T> a(v vVar) {
        return new q<>(vVar);
    }

    public boolean a() {
        return this.c == null;
    }

    private q(T t, b.a aVar) {
        this.d = false;
        this.f3928a = t;
        this.f3929b = aVar;
        this.c = null;
    }

    private q(v vVar) {
        this.d = false;
        this.f3928a = null;
        this.f3929b = null;
        this.c = vVar;
    }
}
