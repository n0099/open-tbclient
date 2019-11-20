package com.airbnb.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class o<V, O> implements m<V, O> {
    final List<com.airbnb.lottie.a.a<V>> eR;
    final V fg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(V v) {
        this(Collections.emptyList(), v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(List<com.airbnb.lottie.a.a<V>> list, V v) {
        this.eR = list;
        this.fg = v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    O k(V v) {
        return v;
    }

    public boolean hasAnimation() {
        return !this.eR.isEmpty();
    }

    public O ca() {
        return k(this.fg);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("parseInitialValue=").append(this.fg);
        if (!this.eR.isEmpty()) {
            sb.append(", values=").append(Arrays.toString(this.eR.toArray()));
        }
        return sb.toString();
    }
}
