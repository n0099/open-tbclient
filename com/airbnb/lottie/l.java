package com.airbnb.lottie;

import android.support.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class l<V> {
    @Nullable
    private final Throwable exception;
    @Nullable
    private final V value;

    public l(V v) {
        this.value = v;
        this.exception = null;
    }

    public l(Throwable th) {
        this.exception = th;
        this.value = null;
    }

    @Nullable
    public V getValue() {
        return this.value;
    }

    @Nullable
    public Throwable bx() {
        return this.exception;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (getValue() == null || !getValue().equals(lVar.getValue())) {
                if (bx() == null || lVar.bx() == null) {
                    return false;
                }
                return bx().toString().equals(bx().toString());
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), bx()});
    }
}
