package c.i.d.c;

import java.util.List;
/* loaded from: classes7.dex */
public interface p0<K, V> extends q0<K, V> {
    @Override // c.i.d.c.q0
    List<V> get(K k2);

    @Override // c.i.d.c.q0
    List<V> removeAll(Object obj);

    @Override // c.i.d.c.q0
    List<V> replaceValues(K k2, Iterable<? extends V> iterable);
}
