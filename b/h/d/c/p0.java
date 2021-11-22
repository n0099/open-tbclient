package b.h.d.c;

import java.util.List;
/* loaded from: classes6.dex */
public interface p0<K, V> extends q0<K, V> {
    @Override // b.h.d.c.q0
    List<V> get(K k);

    @Override // b.h.d.c.q0
    List<V> removeAll(Object obj);

    @Override // b.h.d.c.q0
    List<V> replaceValues(K k, Iterable<? extends V> iterable);
}
