package com.baidu.searchbox.live.util;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class LruLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    public final int capacity;

    public LruLinkedHashMap(int i) {
        super(i, 0.75f, true);
        this.capacity = i;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        if (size() > this.capacity) {
            return true;
        }
        return false;
    }
}
