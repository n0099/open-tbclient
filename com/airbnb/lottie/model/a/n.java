package com.airbnb.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
abstract class n<V, O> implements m<V, O> {
    final List<com.airbnb.lottie.e.a<V>> Du;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(V v) {
        this(Collections.singletonList(new com.airbnb.lottie.e.a(v)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(List<com.airbnb.lottie.e.a<V>> list) {
        this.Du = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.Du.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.Du.toArray()));
        }
        return sb.toString();
    }
}
