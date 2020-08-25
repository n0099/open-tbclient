package com.alibaba.fastjson.util;
/* loaded from: classes11.dex */
public class IdentityHashMap<K, V> {
    public static final int DEFAULT_SIZE = 8192;
    private final Entry<K, V>[] buckets;
    private final int indexMask;

    public IdentityHashMap() {
        this(8192);
    }

    public IdentityHashMap(int i) {
        this.indexMask = i - 1;
        this.buckets = new Entry[i];
    }

    public final V get(K k) {
        for (Entry<K, V> entry = this.buckets[System.identityHashCode(k) & this.indexMask]; entry != null; entry = entry.next) {
            if (k == entry.key) {
                return entry.value;
            }
        }
        return null;
    }

    public Class findClass(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.buckets.length) {
                Entry<K, V> entry = this.buckets[i2];
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
                i = i2 + 1;
            } else {
                return null;
            }
        }
    }

    public boolean put(K k, V v) {
        int identityHashCode = System.identityHashCode(k);
        int i = identityHashCode & this.indexMask;
        for (Entry<K, V> entry = this.buckets[i]; entry != null; entry = entry.next) {
            if (k == entry.key) {
                entry.value = v;
                return true;
            }
        }
        this.buckets[i] = new Entry<>(k, v, identityHashCode, this.buckets[i]);
        return false;
    }

    /* loaded from: classes11.dex */
    protected static final class Entry<K, V> {
        public final int hashCode;
        public final K key;
        public final Entry<K, V> next;
        public V value;

        public Entry(K k, V v, int i, Entry<K, V> entry) {
            this.key = k;
            this.value = v;
            this.next = entry;
            this.hashCode = i;
        }
    }
}
