package com.airbnb.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class o<V, O> implements m<V, O> {
    final List<com.airbnb.lottie.a.a<V>> mV;
    final V nl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(V v) {
        this(Collections.emptyList(), v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(List<com.airbnb.lottie.a.a<V>> list, V v) {
        this.mV = list;
        this.nl = v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: V */
    /* JADX WARN: Multi-variable type inference failed */
    O k(V v) {
        return v;
    }

    public boolean hasAnimation() {
        return !this.mV.isEmpty();
    }

    public O cH() {
        return k(this.nl);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("parseInitialValue=").append(this.nl);
        if (!this.mV.isEmpty()) {
            sb.append(", values=").append(Arrays.toString(this.mV.toArray()));
        }
        return sb.toString();
    }
}
