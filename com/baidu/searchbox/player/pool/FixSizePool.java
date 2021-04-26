package com.baidu.searchbox.player.pool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.pool.IPoolItem;
/* loaded from: classes2.dex */
public abstract class FixSizePool<T extends IPoolItem> implements IPool<T> {
    public static final String TAG = "FixSizePool";
    public final Object[] mPool;
    public int mPoolSize;

    public FixSizePool(int i2) {
        if (i2 > 0) {
            this.mPool = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean isInPool(T t) {
        for (int i2 = 0; i2 < this.mPoolSize; i2++) {
            if (this.mPool[i2] == t) {
                return true;
            }
        }
        return false;
    }

    public abstract T createItem();

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.player.pool.FixSizePool<T extends com.baidu.searchbox.player.pool.IPoolItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.player.pool.IPool
    public /* bridge */ /* synthetic */ void release(@NonNull Object obj) {
        release((FixSizePool<T>) ((IPoolItem) obj));
    }

    public void release(@NonNull T t) {
        if (isInPool(t)) {
            return;
        }
        int i2 = this.mPoolSize;
        Object[] objArr = this.mPool;
        if (i2 < objArr.length) {
            objArr[i2] = t;
            this.mPoolSize = i2 + 1;
        }
        t.onRelease();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    @Nullable
    public T acquire() {
        int i2 = this.mPoolSize;
        if (i2 <= 0) {
            T createItem = createItem();
            createItem.onInit();
            return createItem;
        }
        int i3 = i2 - 1;
        Object[] objArr = this.mPool;
        T t = (T) objArr[i3];
        objArr[i3] = null;
        this.mPoolSize = i2 - 1;
        t.onInit();
        return t;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    @Nullable
    public T acquire(String str) {
        return acquire();
    }
}
