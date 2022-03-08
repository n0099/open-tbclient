package c.i.c.c;

import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public interface e1<K, V> extends q0<K, V> {
    @Override // c.i.c.c.q0
    Set<Map.Entry<K, V>> entries();

    @Override // c.i.c.c.q0
    Set<V> get(K k);

    @Override // c.i.c.c.q0
    Set<V> removeAll(Object obj);

    @Override // c.i.c.c.q0
    Set<V> replaceValues(K k, Iterable<? extends V> iterable);
}
