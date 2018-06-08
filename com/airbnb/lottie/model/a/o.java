package com.airbnb.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class o<V, O> implements m<V, O> {
    final V mK;
    final List<com.airbnb.lottie.a.a<V>> mt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(V v) {
        this(Collections.emptyList(), v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(List<com.airbnb.lottie.a.a<V>> list, V v) {
        this.mt = list;
        this.mK = v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    O g(V v) {
        return v;
    }

    public boolean hasAnimation() {
        return !this.mt.isEmpty();
    }

    public O cm() {
        return g(this.mK);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("parseInitialValue=").append(this.mK);
        if (!this.mt.isEmpty()) {
            sb.append(", values=").append(Arrays.toString(this.mt.toArray()));
        }
        return sb.toString();
    }
}
