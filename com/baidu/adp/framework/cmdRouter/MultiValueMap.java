package com.baidu.adp.framework.cmdRouter;

import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public interface MultiValueMap<K, V> {
    void add(K k2, V v);

    void add(K k2, List<V> list);

    void addAll(Map<K, V> map);

    void clear();

    boolean containsKey(K k2);

    V getValue(K k2, int i2);

    List<V> getValues(K k2);

    boolean isEmpty();

    Set<K> keySet();

    List<V> remove(K k2);

    void set(K k2, V v);

    void set(K k2, List<V> list);

    void set(Map<K, List<V>> map);

    int size();

    List<V> values();
}
