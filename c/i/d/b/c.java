package c.i.d.b;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
/* loaded from: classes9.dex */
public interface c<K, V> {
    ConcurrentMap<K, V> asMap();

    void cleanUp();

    V get(K k2, Callable<? extends V> callable) throws ExecutionException;

    ImmutableMap<K, V> getAllPresent(Iterable<?> iterable);

    V getIfPresent(Object obj);

    void invalidate(Object obj);

    void invalidateAll();

    void invalidateAll(Iterable<?> iterable);

    void put(K k2, V v);

    void putAll(Map<? extends K, ? extends V> map);

    long size();

    d stats();
}
