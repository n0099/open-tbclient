package com.airbnb.lottie.e;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
/* loaded from: classes16.dex */
public class c<T> {
    private final b<T> El;
    @Nullable
    private com.airbnb.lottie.a.b.a<?, ?> Hy;
    @Nullable
    protected T value;

    public c() {
        this.El = new b<>();
        this.value = null;
    }

    public c(@Nullable T t) {
        this.El = new b<>();
        this.value = null;
        this.value = t;
    }

    @Nullable
    public T getValue(b<T> bVar) {
        return this.value;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T b(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return getValue(this.El.a(f, f2, t, t2, f3, f4, f5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void b(@Nullable com.airbnb.lottie.a.b.a<?, ?> aVar) {
        this.Hy = aVar;
    }
}
