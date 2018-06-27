package com.airbnb.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class o<V, O> implements m<V, O> {
    final V mJ;
    final List<com.airbnb.lottie.a.a<V>> mr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(V v) {
        this(Collections.emptyList(), v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(List<com.airbnb.lottie.a.a<V>> list, V v) {
        this.mr = list;
        this.mJ = v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    O g(V v) {
        return v;
    }

    public boolean hasAnimation() {
        return !this.mr.isEmpty();
    }

    public O cm() {
        return g(this.mJ);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("parseInitialValue=").append(this.mJ);
        if (!this.mr.isEmpty()) {
            sb.append(", values=").append(Arrays.toString(this.mr.toArray()));
        }
        return sb.toString();
    }
}
