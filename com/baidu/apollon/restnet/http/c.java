package com.baidu.apollon.restnet.http;

import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public interface c<K, V> extends Map<K, List<V>> {
    void a(K k2, V v);

    void a(Map<K, V> map);

    void b(K k2, V v);

    V c(K k2);

    Map<K, V> t();
}
