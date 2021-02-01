package com.baidu.adp.framework.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class e<K, V> implements g<K, V> {
    protected Map<K, List<V>> Jw = new LinkedHashMap();

    public void add(K k, V v) {
        if (k != null) {
            if (!this.Jw.containsKey(k)) {
                this.Jw.put(k, new ArrayList(2));
            }
            this.Jw.get(k).add(v);
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
        return this.Jw.remove(k);
    }

    @Override // com.baidu.adp.framework.a.g
    public List<V> q(K k) {
        return this.Jw.get(k);
    }

    @Override // com.baidu.adp.framework.a.g
    public boolean containsKey(K k) {
        return this.Jw.containsKey(k);
    }
}
