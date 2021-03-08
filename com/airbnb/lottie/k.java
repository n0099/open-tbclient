package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class k<V> {
    @Nullable
    private final Throwable exception;
    @Nullable
    private final V value;

    public k(V v) {
        this.value = v;
        this.exception = null;
    }

    public k(Throwable th) {
        this.exception = th;
        this.value = null;
    }

    @Nullable
    public V getValue() {
        return this.value;
    }

    @Nullable
    public Throwable il() {
        return this.exception;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (getValue() == null || !getValue().equals(kVar.getValue())) {
                if (il() == null || kVar.il() == null) {
                    return false;
                }
                return il().toString().equals(il().toString());
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), il()});
    }
}
