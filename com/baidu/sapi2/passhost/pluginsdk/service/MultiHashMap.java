package com.baidu.sapi2.passhost.pluginsdk.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiHashMap<K, V> {
    private HashMap<K, ArrayList<V>> model;

    public MultiHashMap() {
        this(16);
    }

    public MultiHashMap(int i) {
        this.model = new HashMap<>(i < 8 ? 8 : i);
    }

    public ArrayList<V> get(K k) {
        return this.model.get(k);
    }

    public boolean isEmpty() {
        return this.model.isEmpty();
    }

    public boolean containsKey(K k) {
        return this.model.containsKey(k);
    }

    public void put(K k, V v) {
        ArrayList<V> arrayList = this.model.get(k);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.model.put(k, arrayList);
        }
        if (!arrayList.contains(v)) {
            arrayList.add(v);
        }
    }

    public ArrayList<V> remove(K k) {
        return this.model.remove(k);
    }

    public void removeValue(V v) {
        for (Map.Entry<K, ArrayList<V>> entry : this.model.entrySet()) {
            ArrayList<V> value = entry.getValue();
            int i = 0;
            while (i < value.size()) {
                V v2 = value.get(i);
                if (v2 == v || (v2 != null && v2.equals(v))) {
                    entry.getValue().remove(v);
                } else {
                    i++;
                }
            }
        }
    }
}
