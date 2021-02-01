package com.baidu.live.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: classes10.dex */
public final class m<V> {
    @Nullable
    private final Throwable exception;
    @Nullable
    private final V value;

    public m(V v) {
        this.value = v;
        this.exception = null;
    }

    public m(Throwable th) {
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
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (getValue() == null || !getValue().equals(mVar.getValue())) {
                if (il() == null || mVar.il() == null) {
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
