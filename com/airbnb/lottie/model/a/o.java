package com.airbnb.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class o<V, O> implements m<V, O> {
    final List<com.airbnb.lottie.a.a<V>> pD;
    final V pR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(V v) {
        this(Collections.emptyList(), v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(List<com.airbnb.lottie.a.a<V>> list, V v) {
        this.pD = list;
        this.pR = v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    O k(V v) {
        return v;
    }

    public boolean hasAnimation() {
        return !this.pD.isEmpty();
    }

    public O dJ() {
        return k(this.pR);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("parseInitialValue=").append(this.pR);
        if (!this.pD.isEmpty()) {
            sb.append(", values=").append(Arrays.toString(this.pD.toArray()));
        }
        return sb.toString();
    }
}
