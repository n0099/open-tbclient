package b.i.d.c;

import java.util.Comparator;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public interface j1<K, V> extends e1<K, V> {
    @Override // b.i.d.c.e1, b.i.d.c.q0
    SortedSet<V> get(K k);

    @Override // b.i.d.c.e1, b.i.d.c.q0
    SortedSet<V> removeAll(Object obj);

    @Override // b.i.d.c.e1, b.i.d.c.q0
    SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable);

    Comparator<? super V> valueComparator();
}
