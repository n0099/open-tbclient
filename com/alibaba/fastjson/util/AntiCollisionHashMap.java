package com.alibaba.fastjson.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
/* loaded from: classes.dex */
public class AntiCollisionHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    public static final int DEFAULT_INITIAL_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    public static final int KEY = 16777619;
    public static final int MAXIMUM_CAPACITY = 1073741824;
    public static final int M_MASK = -2023358765;
    public static final int SEED = -2128831035;
    public static final long serialVersionUID = 362498820763181265L;
    public transient Set<Map.Entry<K, V>> entrySet;
    public volatile transient Set<K> keySet;
    public final float loadFactor;
    public volatile transient int modCount;
    public final int random;
    public transient int size;
    public transient Entry<K, V>[] table;
    public int threshold;
    public volatile transient Collection<V> values;

    /* loaded from: classes.dex */
    public static class Entry<K, V> implements Map.Entry<K, V> {
        public final int hash;
        public final K key;
        public Entry<K, V> next;
        public V value;

        public Entry(int i, K k, V v, Entry<K, V> entry) {
            this.value = v;
            this.next = entry;
            this.key = k;
            this.hash = i;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K key = getKey();
                Object key2 = entry.getKey();
                if (key == key2 || (key != null && key.equals(key2))) {
                    V value = getValue();
                    Object value2 = entry.getValue();
                    if (value == value2) {
                        return true;
                    }
                    if (value != null && value.equals(value2)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k = this.key;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.value;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        public void recordAccess(AntiCollisionHashMap<K, V> antiCollisionHashMap) {
        }

        public void recordRemoval(AntiCollisionHashMap<K, V> antiCollisionHashMap) {
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* loaded from: classes.dex */
    public final class EntryIterator extends AntiCollisionHashMap<K, V>.HashIterator<Map.Entry<K, V>> {
        public EntryIterator() {
            super();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return nextEntry();
        }
    }

    /* loaded from: classes.dex */
    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Entry<K, V> entry2 = AntiCollisionHashMap.this.getEntry(entry.getKey());
                return entry2 != null && entry2.equals(entry);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return AntiCollisionHashMap.this.newEntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeMapping(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    /* loaded from: classes.dex */
    public abstract class HashIterator<E> implements Iterator<E> {
        public Entry<K, V> current;
        public int expectedModCount;
        public int index;
        public Entry<K, V> next;

        public HashIterator() {
            Entry<K, V> entry;
            this.expectedModCount = AntiCollisionHashMap.this.modCount;
            if (AntiCollisionHashMap.this.size > 0) {
                Entry<K, V>[] entryArr = AntiCollisionHashMap.this.table;
                do {
                    int i = this.index;
                    if (i >= entryArr.length) {
                        return;
                    }
                    this.index = i + 1;
                    entry = entryArr[i];
                    this.next = entry;
                } while (entry == null);
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != null;
        }

        public final Entry<K, V> nextEntry() {
            Entry<K, V> entry;
            if (AntiCollisionHashMap.this.modCount == this.expectedModCount) {
                Entry<K, V> entry2 = this.next;
                if (entry2 != null) {
                    Entry<K, V> entry3 = entry2.next;
                    this.next = entry3;
                    if (entry3 == null) {
                        Entry<K, V>[] entryArr = AntiCollisionHashMap.this.table;
                        do {
                            int i = this.index;
                            if (i >= entryArr.length) {
                                break;
                            }
                            this.index = i + 1;
                            entry = entryArr[i];
                            this.next = entry;
                        } while (entry == null);
                    }
                    this.current = entry2;
                    return entry2;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.current != null) {
                if (AntiCollisionHashMap.this.modCount == this.expectedModCount) {
                    K k = this.current.key;
                    this.current = null;
                    AntiCollisionHashMap.this.removeEntryForKey(k);
                    this.expectedModCount = AntiCollisionHashMap.this.modCount;
                    return;
                }
                throw new ConcurrentModificationException();
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes.dex */
    public final class KeyIterator extends AntiCollisionHashMap<K, V>.HashIterator<K> {
        public KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return nextEntry().getKey();
        }
    }

    /* loaded from: classes.dex */
    public final class KeySet extends AbstractSet<K> {
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return AntiCollisionHashMap.this.newKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeEntryForKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    /* loaded from: classes.dex */
    public final class ValueIterator extends AntiCollisionHashMap<K, V>.HashIterator<V> {
        public ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return nextEntry().value;
        }
    }

    /* loaded from: classes.dex */
    public final class Values extends AbstractCollection<V> {
        public Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return AntiCollisionHashMap.this.newValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    public AntiCollisionHashMap(int i, float f2) {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        if (i >= 0) {
            i = i > 1073741824 ? 1073741824 : i;
            if (f2 > 0.0f && !Float.isNaN(f2)) {
                int i2 = 1;
                while (i2 < i) {
                    i2 <<= 1;
                }
                this.loadFactor = f2;
                this.threshold = (int) (i2 * f2);
                this.table = new Entry[i2];
                init();
                return;
            }
            throw new IllegalArgumentException("Illegal load factor: " + f2);
        }
        throw new IllegalArgumentException("Illegal initial capacity: " + i);
    }

    private boolean containsNullValue() {
        Entry<K, V>[] entryArr;
        for (Entry<K, V> entry : this.table) {
            for (; entry != null; entry = entry.next) {
                if (entry.value == null) {
                    return true;
                }
            }
        }
        return false;
    }

    private Set<Map.Entry<K, V>> entrySet0() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    private V getForNullKey() {
        for (Entry<K, V> entry = this.table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                return entry.value;
            }
        }
        return null;
    }

    public static int hash(int i) {
        int i2 = i * i;
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    private int hashString(String str) {
        int i = this.random * SEED;
        for (int i2 = 0; i2 < str.length(); i2++) {
            i = (i * KEY) ^ str.charAt(i2);
        }
        return ((i >> 1) ^ i) & M_MASK;
    }

    public static int indexFor(int i, int i2) {
        return i & (i2 - 1);
    }

    private void putAllForCreate(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            putForCreate(entry.getKey(), entry.getValue());
        }
    }

    private void putForCreate(K k, V v) {
        int hash;
        K k2;
        if (k == null) {
            hash = 0;
        } else if (k instanceof String) {
            hash = hash(hashString((String) k));
        } else {
            hash = hash(k.hashCode());
        }
        int indexFor = indexFor(hash, this.table.length);
        for (Entry<K, V> entry = this.table[indexFor]; entry != null; entry = entry.next) {
            if (entry.hash == hash && ((k2 = entry.key) == k || (k != null && k.equals(k2)))) {
                entry.value = v;
                return;
            }
        }
        createEntry(hash, k, v, indexFor);
    }

    private V putForNullKey(V v) {
        for (Entry<K, V> entry = this.table[0]; entry != null; entry = entry.next) {
            if (entry.key == null) {
                V v2 = entry.value;
                entry.value = v;
                entry.recordAccess(this);
                return v2;
            }
        }
        this.modCount++;
        addEntry(0, null, v, 0);
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.alibaba.fastjson.util.AntiCollisionHashMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.table = new Entry[objectInputStream.readInt()];
        init();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            putForCreate(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Iterator<Map.Entry<K, V>> it = this.size > 0 ? entrySet0().iterator() : null;
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.table.length);
        objectOutputStream.writeInt(this.size);
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objectOutputStream.writeObject(next.getKey());
                objectOutputStream.writeObject(next.getValue());
            }
        }
    }

    public void addEntry(int i, K k, V v, int i2) {
        Entry<K, V>[] entryArr = this.table;
        entryArr[i2] = new Entry<>(i, k, v, entryArr[i2]);
        int i3 = this.size;
        this.size = i3 + 1;
        if (i3 >= this.threshold) {
            resize(this.table.length * 2);
        }
    }

    public int capacity() {
        return this.table.length;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        Entry<K, V>[] entryArr = this.table;
        for (int i = 0; i < entryArr.length; i++) {
            entryArr[i] = null;
        }
        this.size = 0;
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        AntiCollisionHashMap antiCollisionHashMap;
        try {
            antiCollisionHashMap = (AntiCollisionHashMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            antiCollisionHashMap = null;
        }
        antiCollisionHashMap.table = new Entry[this.table.length];
        antiCollisionHashMap.entrySet = null;
        antiCollisionHashMap.modCount = 0;
        antiCollisionHashMap.size = 0;
        antiCollisionHashMap.init();
        antiCollisionHashMap.putAllForCreate(this);
        return antiCollisionHashMap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return getEntry(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Entry<K, V>[] entryArr;
        if (obj == null) {
            return containsNullValue();
        }
        for (Entry<K, V> entry : this.table) {
            for (; entry != null; entry = entry.next) {
                if (obj.equals(entry.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void createEntry(int i, K k, V v, int i2) {
        Entry<K, V>[] entryArr = this.table;
        entryArr[i2] = new Entry<>(i, k, v, entryArr[i2]);
        this.size++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet0();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int hash;
        K k;
        if (obj == null) {
            return getForNullKey();
        }
        if (obj instanceof String) {
            hash = hash(hashString((String) obj));
        } else {
            hash = hash(obj.hashCode());
        }
        Entry<K, V>[] entryArr = this.table;
        for (Entry<K, V> entry = entryArr[indexFor(hash, entryArr.length)]; entry != null; entry = entry.next) {
            if (entry.hash == hash && ((k = entry.key) == obj || obj.equals(k))) {
                return entry.value;
            }
        }
        return null;
    }

    public final Entry<K, V> getEntry(Object obj) {
        int hash;
        K k;
        if (obj == null) {
            hash = 0;
        } else if (obj instanceof String) {
            hash = hash(hashString((String) obj));
        } else {
            hash = hash(obj.hashCode());
        }
        Entry<K, V>[] entryArr = this.table;
        for (Entry<K, V> entry = entryArr[indexFor(hash, entryArr.length)]; entry != null; entry = entry.next) {
            if (entry.hash == hash && ((k = entry.key) == obj || (obj != null && obj.equals(k)))) {
                return entry;
            }
        }
        return null;
    }

    public void init() {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    public float loadFactor() {
        return this.loadFactor;
    }

    public Iterator<Map.Entry<K, V>> newEntryIterator() {
        return new EntryIterator();
    }

    public Iterator<K> newKeyIterator() {
        return new KeyIterator();
    }

    public Iterator<V> newValueIterator() {
        return new ValueIterator();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        int hash;
        K k2;
        if (k == null) {
            return putForNullKey(v);
        }
        if (k instanceof String) {
            hash = hash(hashString((String) k));
        } else {
            hash = hash(k.hashCode());
        }
        int indexFor = indexFor(hash, this.table.length);
        for (Entry<K, V> entry = this.table[indexFor]; entry != null; entry = entry.next) {
            if (entry.hash == hash && ((k2 = entry.key) == k || k.equals(k2))) {
                V v2 = entry.value;
                entry.value = v;
                entry.recordAccess(this);
                return v2;
            }
        }
        this.modCount++;
        addEntry(hash, k, v, indexFor);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size == 0) {
            return;
        }
        if (size > this.threshold) {
            int i = (int) ((size / this.loadFactor) + 1.0f);
            if (i > 1073741824) {
                i = 1073741824;
            }
            int length = this.table.length;
            while (length < i) {
                length <<= 1;
            }
            if (length > this.table.length) {
                resize(length);
            }
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Entry<K, V> removeEntryForKey = removeEntryForKey(obj);
        if (removeEntryForKey == null) {
            return null;
        }
        return removeEntryForKey.value;
    }

    public final Entry<K, V> removeEntryForKey(Object obj) {
        int hash;
        K k;
        if (obj == null) {
            hash = 0;
        } else if (obj instanceof String) {
            hash = hash(hashString((String) obj));
        } else {
            hash = hash(obj.hashCode());
        }
        int indexFor = indexFor(hash, this.table.length);
        Entry<K, V> entry = this.table[indexFor];
        Entry<K, V> entry2 = entry;
        while (entry != null) {
            Entry<K, V> entry3 = entry.next;
            if (entry.hash == hash && ((k = entry.key) == obj || (obj != null && obj.equals(k)))) {
                this.modCount++;
                this.size--;
                if (entry2 == entry) {
                    this.table[indexFor] = entry3;
                } else {
                    entry2.next = entry3;
                }
                entry.recordRemoval(this);
                return entry;
            }
            entry2 = entry;
            entry = entry3;
        }
        return entry;
    }

    public final Entry<K, V> removeMapping(Object obj) {
        int hash;
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            if (key == null) {
                hash = 0;
            } else if (key instanceof String) {
                hash = hash(hashString((String) key));
            } else {
                hash = hash(key.hashCode());
            }
            int indexFor = indexFor(hash, this.table.length);
            Entry<K, V> entry2 = this.table[indexFor];
            Entry<K, V> entry3 = entry2;
            while (entry2 != null) {
                Entry<K, V> entry4 = entry2.next;
                if (entry2.hash == hash && entry2.equals(entry)) {
                    this.modCount++;
                    this.size--;
                    if (entry3 == entry2) {
                        this.table[indexFor] = entry4;
                    } else {
                        entry3.next = entry4;
                    }
                    entry2.recordRemoval(this);
                    return entry2;
                }
                entry3 = entry2;
                entry2 = entry4;
            }
            return entry2;
        }
        return null;
    }

    public void resize(int i) {
        if (this.table.length == 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        Entry<K, V>[] entryArr = new Entry[i];
        transfer(entryArr);
        this.table = entryArr;
        this.threshold = (int) (i * this.loadFactor);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public void transfer(Entry[] entryArr) {
        Entry<K, V>[] entryArr2 = this.table;
        int length = entryArr.length;
        for (int i = 0; i < entryArr2.length; i++) {
            Entry<K, V> entry = entryArr2[i];
            if (entry != null) {
                entryArr2[i] = null;
                while (true) {
                    Entry<K, V> entry2 = entry.next;
                    int indexFor = indexFor(entry.hash, length);
                    entry.next = entryArr[indexFor];
                    entryArr[indexFor] = entry;
                    if (entry2 == null) {
                        break;
                    }
                    entry = entry2;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }

    public AntiCollisionHashMap(int i) {
        this(i, 0.75f);
    }

    public AntiCollisionHashMap() {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        this.loadFactor = 0.75f;
        this.threshold = 12;
        this.table = new Entry[16];
        init();
    }

    public AntiCollisionHashMap(Map<? extends K, ? extends V> map) {
        this(Math.max(((int) (map.size() / 0.75f)) + 1, 16), 0.75f);
        putAllForCreate(map);
    }
}
