package com.baidu.poly.a.a;

import java.util.Map;
/* loaded from: classes11.dex */
public abstract class d<K, V> {
    private Map<K, V> map = com.baidu.poly.util.e.Ni();

    public Map<K, V> MK() {
        return this.map;
    }

    public void b(Map<K, V> map) {
        this.map = map;
    }

    public void g(K k, V v) {
        this.map.put(k, v);
    }

    public V get(K k) {
        return this.map.get(k);
    }

    public Map<K, V> getMap() {
        return this.map;
    }
}
