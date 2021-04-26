package com.baidu.adp.framework.cmdRouter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class LinkedMultiValueMap<K, V> implements MultiValueMap<K, V> {
    public Map<K, List<V>> mSource = new LinkedHashMap();

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void add(K k, V v) {
        if (k != null) {
            if (!this.mSource.containsKey(k)) {
                this.mSource.put(k, new ArrayList(2));
            }
            this.mSource.get(k).add(v);
        }
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void addAll(Map<K, V> map) {
        for (K k : map.keySet()) {
            add((LinkedMultiValueMap<K, V>) k, (K) map.get(k));
        }
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void clear() {
        this.mSource.clear();
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public boolean containsKey(K k) {
        return this.mSource.containsKey(k);
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public V getValue(K k, int i2) {
        List<V> list = this.mSource.get(k);
        if (list == null || i2 >= list.size()) {
            return null;
        }
        return list.get(i2);
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public List<V> getValues(K k) {
        return this.mSource.get(k);
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public boolean isEmpty() {
        return this.mSource.isEmpty();
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public Set<K> keySet() {
        return this.mSource.keySet();
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public List<V> remove(K k) {
        return this.mSource.remove(k);
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void set(K k, V v) {
        this.mSource.remove(k);
        add((LinkedMultiValueMap<K, V>) k, (K) v);
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public int size() {
        return this.mSource.size();
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public List<V> values() {
        ArrayList arrayList = new ArrayList();
        for (K k : this.mSource.keySet()) {
            arrayList.addAll(this.mSource.get(k));
        }
        return arrayList;
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void set(K k, List<V> list) {
        this.mSource.remove(k);
        add((LinkedMultiValueMap<K, V>) k, (List) list);
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void add(K k, List<V> list) {
        for (V v : list) {
            add((LinkedMultiValueMap<K, V>) k, (K) v);
        }
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void set(Map<K, List<V>> map) {
        this.mSource.clear();
        this.mSource.putAll(map);
    }
}
