package c.i.d.b;

import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;
/* loaded from: classes9.dex */
public interface f<K, V> extends c<K, V>, c.i.d.a.g<K, V> {
    @Override // c.i.d.a.g
    @Deprecated
    V apply(K k2);

    V get(K k2) throws ExecutionException;

    ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException;

    V getUnchecked(K k2);

    void refresh(K k2);
}
