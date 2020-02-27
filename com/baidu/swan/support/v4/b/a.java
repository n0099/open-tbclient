package com.baidu.swan.support.v4.b;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes11.dex */
public class a<K, V> extends f<K, V> implements Map<K, V> {
    e<K, V> cDG;

    private e<K, V> auN() {
        if (this.cDG == null) {
            this.cDG = new e<K, V>() { // from class: com.baidu.swan.support.v4.b.a.1
                @Override // com.baidu.swan.support.v4.b.e
                protected int colGetSize() {
                    return a.this.mSize;
                }

                @Override // com.baidu.swan.support.v4.b.e
                protected Object colGetEntry(int i, int i2) {
                    return a.this.mArray[(i << 1) + i2];
                }

                @Override // com.baidu.swan.support.v4.b.e
                protected int colIndexOfKey(Object obj) {
                    return a.this.indexOfKey(obj);
                }

                @Override // com.baidu.swan.support.v4.b.e
                protected int colIndexOfValue(Object obj) {
                    return a.this.indexOfValue(obj);
                }

                @Override // com.baidu.swan.support.v4.b.e
                protected Map<K, V> colGetMap() {
                    return a.this;
                }

                @Override // com.baidu.swan.support.v4.b.e
                protected void colPut(K k, V v) {
                    a.this.put(k, v);
                }

                @Override // com.baidu.swan.support.v4.b.e
                protected V colSetValue(int i, V v) {
                    return a.this.setValueAt(i, v);
                }

                @Override // com.baidu.swan.support.v4.b.e
                protected void colRemoveAt(int i) {
                    a.this.removeAt(i);
                }

                @Override // com.baidu.swan.support.v4.b.e
                protected void colClear() {
                    a.this.clear();
                }
            };
        }
        return this.cDG;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean retainAll(Collection<?> collection) {
        return e.retainAllHelper(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return auN().getEntrySet();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return auN().getKeySet();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return auN().getValues();
    }
}
