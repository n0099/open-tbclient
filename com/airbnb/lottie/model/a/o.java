package com.airbnb.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class o<V, O> implements m<V, O> {
    final List<com.airbnb.lottie.a.a<V>> mi;
    final V my;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(V v) {
        this(Collections.emptyList(), v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(List<com.airbnb.lottie.a.a<V>> list, V v) {
        this.mi = list;
        this.my = v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    O g(V v) {
        return v;
    }

    public boolean hasAnimation() {
        return !this.mi.isEmpty();
    }

    public O ck() {
        return g(this.my);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("parseInitialValue=").append(this.my);
        if (!this.mi.isEmpty()) {
            sb.append(", values=").append(Arrays.toString(this.mi.toArray()));
        }
        return sb.toString();
    }
}
