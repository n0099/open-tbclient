package com.airbnb.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class o<V, O> implements m<V, O> {
    final List<com.airbnb.lottie.a.a<V>> oL;
    final V oZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(V v) {
        this(Collections.emptyList(), v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(List<com.airbnb.lottie.a.a<V>> list, V v) {
        this.oL = list;
        this.oZ = v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    O h(V v) {
        return v;
    }

    public boolean hasAnimation() {
        return !this.oL.isEmpty();
    }

    public O dr() {
        return h(this.oZ);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("parseInitialValue=").append(this.oZ);
        if (!this.oL.isEmpty()) {
            sb.append(", values=").append(Arrays.toString(this.oL.toArray()));
        }
        return sb.toString();
    }
}
