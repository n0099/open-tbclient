package c.i.d.c;

import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public interface k<K, V> extends Map<K, V> {
    V forcePut(K k2, V v);

    k<V, K> inverse();

    @Override // java.util.Map
    Set<V> values();
}
