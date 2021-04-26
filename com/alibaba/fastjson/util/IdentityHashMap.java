package com.alibaba.fastjson.util;

import java.util.Arrays;
/* loaded from: classes.dex */
public class IdentityHashMap<K, V> {
    public static final int DEFAULT_SIZE = 8192;
    public final Entry<K, V>[] buckets;
    public final int indexMask;

    /* loaded from: classes.dex */
    public static final class Entry<K, V> {
        public final int hashCode;
        public final K key;
        public final Entry<K, V> next;
        public V value;

        public Entry(K k, V v, int i2, Entry<K, V> entry) {
            this.key = k;
            this.value = v;
            this.next = entry;
            this.hashCode = i2;
        }
    }

    public IdentityHashMap() {
        this(8192);
    }

    public void clear() {
        Arrays.fill(this.buckets, (Object) null);
    }

    public Class findClass(String str) {
        int i2 = 0;
        while (true) {
            Entry<K, V>[] entryArr = this.buckets;
            if (i2 >= entryArr.length) {
                return null;
            }
            Entry<K, V> entry = entryArr[i2];
            if (entry != null) {
                for (Entry<K, V> entry2 = entry; entry2 != null; entry2 = entry2.next) {
                    K k = entry.key;
                    if (k instanceof Class) {
                        Class cls = (Class) k;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
                continue;
            }
            i2++;
        }
    }

    public final V get(K k) {
        for (Entry<K, V> entry = this.buckets[System.identityHashCode(k) & this.indexMask]; entry != null; entry = entry.next) {
            if (k == entry.key) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean put(K k, V v) {
        int identityHashCode = System.identityHashCode(k);
        int i2 = this.indexMask & identityHashCode;
        for (Entry<K, V> entry = this.buckets[i2]; entry != null; entry = entry.next) {
            if (k == entry.key) {
                entry.value = v;
                return true;
            }
        }
        this.buckets[i2] = new Entry<>(k, v, identityHashCode, this.buckets[i2]);
        return false;
    }

    public int size() {
        Entry<K, V>[] entryArr;
        int i2 = 0;
        for (Entry<K, V> entry : this.buckets) {
            for (; entry != null; entry = entry.next) {
                i2++;
            }
        }
        return i2;
    }

    public IdentityHashMap(int i2) {
        this.indexMask = i2 - 1;
        this.buckets = new Entry[i2];
    }
}
