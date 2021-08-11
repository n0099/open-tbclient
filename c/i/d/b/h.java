package c.i.d.b;

import com.google.common.cache.LocalCache;
/* loaded from: classes4.dex */
public interface h<K, V> {
    long getAccessTime();

    int getHash();

    K getKey();

    h<K, V> getNext();

    h<K, V> getNextInAccessQueue();

    h<K, V> getNextInWriteQueue();

    h<K, V> getPreviousInAccessQueue();

    h<K, V> getPreviousInWriteQueue();

    LocalCache.s<K, V> getValueReference();

    long getWriteTime();

    void setAccessTime(long j2);

    void setNextInAccessQueue(h<K, V> hVar);

    void setNextInWriteQueue(h<K, V> hVar);

    void setPreviousInAccessQueue(h<K, V> hVar);

    void setPreviousInWriteQueue(h<K, V> hVar);

    void setValueReference(LocalCache.s<K, V> sVar);

    void setWriteTime(long j2);
}
