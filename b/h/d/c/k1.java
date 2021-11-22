package b.h.d.c;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public interface k1<R, C, V> {

    /* loaded from: classes6.dex */
    public interface a<R, C, V> {
        C getColumnKey();

        R getRowKey();

        V getValue();
    }

    Set<a<R, C, V>> cellSet();

    void clear();

    Map<R, V> column(C c2);

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean contains(Object obj, Object obj2);

    boolean containsColumn(Object obj);

    boolean containsRow(Object obj);

    boolean containsValue(Object obj);

    boolean equals(Object obj);

    V get(Object obj, Object obj2);

    int hashCode();

    boolean isEmpty();

    V put(R r, C c2, V v);

    void putAll(k1<? extends R, ? extends C, ? extends V> k1Var);

    V remove(Object obj, Object obj2);

    Map<C, V> row(R r);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();

    Collection<V> values();
}
