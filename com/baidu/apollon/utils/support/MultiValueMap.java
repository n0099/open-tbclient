package com.baidu.apollon.utils.support;

import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public interface MultiValueMap<K, V> extends Map<K, List<V>> {
    void add(K k, V v);

    V getFirst(K k);

    void set(K k, V v);

    void setAll(Map<K, V> map);

    Map<K, V> toSingleValueMap();
}
