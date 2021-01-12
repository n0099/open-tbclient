package com.baidu.adp.framework.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class e<K, V> implements g<K, V> {
    protected Map<K, List<V>> Jx = new LinkedHashMap();

    public void add(K k, V v) {
        if (k != null) {
            if (!this.Jx.containsKey(k)) {
                this.Jx.put(k, new ArrayList(2));
            }
            this.Jx.get(k).add(v);
        }
    }

    @Override // com.baidu.adp.framework.a.g
    public void d(Map<K, V> map) {
        for (K k : map.keySet()) {
            add(k, map.get(k));
        }
    }

    @Override // com.baidu.adp.framework.a.g
    public List<V> p(K k) {
        return this.Jx.remove(k);
    }

    @Override // com.baidu.adp.framework.a.g
    public List<V> q(K k) {
        return this.Jx.get(k);
    }

    @Override // com.baidu.adp.framework.a.g
    public boolean containsKey(K k) {
        return this.Jx.containsKey(k);
    }
}
