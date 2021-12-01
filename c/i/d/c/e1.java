package c.i.d.c;

import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public interface e1<K, V> extends q0<K, V> {
    @Override // c.i.d.c.q0
    Set<Map.Entry<K, V>> entries();

    @Override // c.i.d.c.q0
    Set<V> get(K k2);

    @Override // c.i.d.c.q0
    Set<V> removeAll(Object obj);

    @Override // c.i.d.c.q0
    Set<V> replaceValues(K k2, Iterable<? extends V> iterable);
}
