package com.baidu.live.lottie.model.a;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
abstract class n<V, O> implements m<V, O> {
    final List<com.baidu.live.lottie.e.a<V>> Es;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(V v) {
        this(Collections.singletonList(new com.baidu.live.lottie.e.a(v)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(List<com.baidu.live.lottie.e.a<V>> list) {
        this.Es = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.Es.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.Es.toArray()));
        }
        return sb.toString();
    }
}
