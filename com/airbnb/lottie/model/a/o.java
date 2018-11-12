package com.airbnb.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class o<V, O> implements m<V, O> {
    final List<com.airbnb.lottie.a.a<V>> pE;
    final V pS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(V v) {
        this(Collections.emptyList(), v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(List<com.airbnb.lottie.a.a<V>> list, V v) {
        this.pE = list;
        this.pS = v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    O k(V v) {
        return v;
    }

    public boolean hasAnimation() {
        return !this.pE.isEmpty();
    }

    public O dI() {
        return k(this.pS);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("parseInitialValue=").append(this.pS);
        if (!this.pE.isEmpty()) {
            sb.append(", values=").append(Arrays.toString(this.pE.toArray()));
        }
        return sb.toString();
    }
}
