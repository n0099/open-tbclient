package com.baidu.fsg.base.restnet.http;

import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public interface b<K, V> extends Map<K, List<V>> {
    void a(K k, V v);

    void a(Map<K, V> map);

    void b(K k, V v);

    V c(K k);

    Map<K, V> t();
}
