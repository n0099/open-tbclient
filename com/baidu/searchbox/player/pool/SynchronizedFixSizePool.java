package com.baidu.searchbox.player.pool;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.pool.IPoolItem;
/* loaded from: classes4.dex */
public abstract class SynchronizedFixSizePool<T extends IPoolItem> extends FixSizePool<T> {
    public final Object mLock;

    public SynchronizedFixSizePool(int i) {
        super(i);
        this.mLock = new Object();
    }

    @Override // com.baidu.searchbox.player.pool.FixSizePool
    public void release(@NonNull T t) {
        synchronized (this.mLock) {
            super.release((SynchronizedFixSizePool<T>) t);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.FixSizePool, com.baidu.searchbox.player.pool.IPool
    @NonNull
    public T acquire() {
        T t;
        synchronized (this.mLock) {
            t = (T) super.acquire();
        }
        return t;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.player.pool.SynchronizedFixSizePool<T extends com.baidu.searchbox.player.pool.IPoolItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.player.pool.FixSizePool, com.baidu.searchbox.player.pool.IPool
    public /* bridge */ /* synthetic */ void release(@NonNull Object obj) {
        release((SynchronizedFixSizePool<T>) ((IPoolItem) obj));
    }
}
