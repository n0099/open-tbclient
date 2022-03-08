package c.i.c.c;

import java.util.Comparator;
import java.util.SortedSet;
/* loaded from: classes3.dex */
public interface j1<K, V> extends e1<K, V> {
    @Override // c.i.c.c.e1, c.i.c.c.q0
    SortedSet<V> get(K k);

    @Override // c.i.c.c.e1, c.i.c.c.q0
    SortedSet<V> removeAll(Object obj);

    @Override // c.i.c.c.e1, c.i.c.c.q0
    SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable);

    Comparator<? super V> valueComparator();
}
