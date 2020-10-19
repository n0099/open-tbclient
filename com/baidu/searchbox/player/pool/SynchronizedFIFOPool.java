package com.baidu.searchbox.player.pool;

import android.support.annotation.NonNull;
import com.baidu.searchbox.player.pool.IPoolItem;
/* loaded from: classes15.dex */
public class SynchronizedFIFOPool<T extends IPoolItem> extends FIFOPool<T> {
    private final Object mLock;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.player.pool.SynchronizedFIFOPool<T extends com.baidu.searchbox.player.pool.IPoolItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.player.pool.FIFOPool, com.baidu.searchbox.player.pool.IPool
    public /* bridge */ /* synthetic */ void release(@NonNull Object obj) {
        release((SynchronizedFIFOPool<T>) ((IPoolItem) obj));
    }

    public SynchronizedFIFOPool(int i) {
        super(i);
        this.mLock = new Object();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.FIFOPool, com.baidu.searchbox.player.pool.IPool
    public T acquire() {
        T t;
        synchronized (this.mLock) {
            t = (T) super.acquire();
        }
        return t;
    }

    @Override // com.baidu.searchbox.player.pool.FIFOPool
    public void release(@NonNull T t) {
        synchronized (this.mLock) {
            super.release((SynchronizedFIFOPool<T>) t);
        }
    }

    @Override // com.baidu.searchbox.player.pool.FIFOPool
    public void add(T t) {
        synchronized (this.mLock) {
            super.add(t);
        }
    }
}
