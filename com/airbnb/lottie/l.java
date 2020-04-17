package com.airbnb.lottie;

import android.support.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes6.dex */
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
    public Throwable gV() {
        return this.exception;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (getValue() == null || !getValue().equals(lVar.getValue())) {
                if (gV() == null || lVar.gV() == null) {
                    return false;
                }
                return gV().toString().equals(gV().toString());
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), gV()});
    }
}
