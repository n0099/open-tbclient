package b.i.d.c;

import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public interface k<K, V> extends Map<K, V> {
    V forcePut(K k, V v);

    k<V, K> inverse();

    @Override // java.util.Map
    Set<V> values();
}
