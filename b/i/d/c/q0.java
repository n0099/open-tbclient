package b.i.d.c;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public interface q0<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(Object obj, Object obj2);

    boolean containsKey(Object obj);

    boolean containsValue(Object obj);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(Object obj);

    Collection<V> get(K k);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    s0<K> keys();

    boolean put(K k, V v);

    boolean putAll(q0<? extends K, ? extends V> q0Var);

    boolean putAll(K k, Iterable<? extends V> iterable);

    boolean remove(Object obj, Object obj2);

    Collection<V> removeAll(Object obj);

    Collection<V> replaceValues(K k, Iterable<? extends V> iterable);

    int size();

    Collection<V> values();
}
