package com.baidu.searchbox.player.pool;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.player.pool.IPoolItem;
/* loaded from: classes19.dex */
public abstract class FixSizePool<T extends IPoolItem> implements IPool<T> {
    private static final String TAG = "FixSizePool";
    private final Object[] mPool;
    private int mPoolSize;

    public abstract T createItem();

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.player.pool.FixSizePool<T extends com.baidu.searchbox.player.pool.IPoolItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.player.pool.IPool
    public /* bridge */ /* synthetic */ void release(@NonNull Object obj) {
        release((FixSizePool<T>) ((IPoolItem) obj));
    }

    public FixSizePool(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.mPool = new Object[i];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    @Nullable
    public T acquire() {
        if (this.mPoolSize <= 0) {
            T createItem = createItem();
            createItem.onInit();
            return createItem;
        }
        int i = this.mPoolSize - 1;
        T t = (T) this.mPool[i];
        this.mPool[i] = null;
        this.mPoolSize--;
        t.onInit();
        return t;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    @Nullable
    public T acquire(String str) {
        return acquire();
    }

    public void release(@NonNull T t) {
        if (!isInPool(t)) {
            if (this.mPoolSize < this.mPool.length) {
                this.mPool[this.mPoolSize] = t;
                this.mPoolSize++;
            }
            t.onRelease();
        }
    }

    private boolean isInPool(T t) {
        for (int i = 0; i < this.mPoolSize; i++) {
            if (this.mPool[i] == t) {
                return true;
            }
        }
        return false;
    }
}
