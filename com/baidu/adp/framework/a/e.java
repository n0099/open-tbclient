package com.baidu.adp.framework.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class e<K, V> implements g<K, V> {
    protected Map<K, List<V>> KP = new LinkedHashMap();

    public void add(K k, V v) {
        if (k != null) {
            if (!this.KP.containsKey(k)) {
                this.KP.put(k, new ArrayList(2));
            }
            this.KP.get(k).add(v);
        }
    }

    @Override // com.baidu.adp.framework.a.g
    public void d(Map<K, V> map) {
        for (K k : map.keySet()) {
            add(k, map.get(k));
        }
    }

    @Override // com.baidu.adp.framework.a.g
    public List<V> r(K k) {
        return this.KP.remove(k);
    }

    @Override // com.baidu.adp.framework.a.g
    public List<V> s(K k) {
        return this.KP.get(k);
    }

    @Override // com.baidu.adp.framework.a.g
    public boolean containsKey(K k) {
        return this.KP.containsKey(k);
    }
}
