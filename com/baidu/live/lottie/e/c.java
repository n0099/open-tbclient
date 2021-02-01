package com.baidu.live.lottie.e;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* loaded from: classes10.dex */
public class c<T> {
    private final b<T> bti;
    @Nullable
    private com.baidu.live.lottie.a.b.a<?, ?> buG;
    @Nullable
    protected T value;

    public c() {
        this.bti = new b<>();
        this.value = null;
    }

    public c(@Nullable T t) {
        this.bti = new b<>();
        this.value = null;
        this.value = t;
    }

    @Nullable
    public T a(b<T> bVar) {
        return this.value;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T c(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return a(this.bti.d(f, f2, t, t2, f3, f4, f5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void b(@Nullable com.baidu.live.lottie.a.b.a<?, ?> aVar) {
        this.buG = aVar;
    }
}
