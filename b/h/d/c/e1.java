package b.h.d.c;

import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public interface e1<K, V> extends q0<K, V> {
    @Override // b.h.d.c.q0
    Set<Map.Entry<K, V>> entries();

    @Override // b.h.d.c.q0
    Set<V> get(K k);

    @Override // b.h.d.c.q0
    Set<V> removeAll(Object obj);

    @Override // b.h.d.c.q0
    Set<V> replaceValues(K k, Iterable<? extends V> iterable);
}
