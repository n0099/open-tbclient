package com.baidu.searchbox.player.pool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.pool.IPoolItem;
/* loaded from: classes4.dex */
public abstract class FixSizePool<T extends IPoolItem> implements IPool<T> {
    public static final int DEFAULT_SIZE = 2;
    public static final String TAG = "FixSizePool";
    public final Object[] mPool;
    public int mPoolSize;

    public abstract T createItem();

    public FixSizePool(int i) {
        this.mPool = new Object[i <= 0 ? 2 : i];
    }

    private boolean isInPool(T t) {
        for (int i = 0; i < this.mPoolSize; i++) {
            if (this.mPool[i] == t) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    @Nullable
    public T acquire(String str) {
        return acquire();
    }

    public void release(@NonNull T t) {
        if (isInPool(t)) {
            return;
        }
        int i = this.mPoolSize;
        Object[] objArr = this.mPool;
        if (i < objArr.length) {
            objArr[i] = t;
            this.mPoolSize = i + 1;
        }
        t.onRelease();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    @NonNull
    public T acquire() {
        int i = this.mPoolSize;
        if (i <= 0) {
            T createItem = createItem();
            createItem.onInit();
            return createItem;
        }
        int i2 = i - 1;
        Object[] objArr = this.mPool;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.mPoolSize = i - 1;
        t.onInit();
        return t;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.player.pool.FixSizePool<T extends com.baidu.searchbox.player.pool.IPoolItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.player.pool.IPool
    public /* bridge */ /* synthetic */ void release(@NonNull Object obj) {
        release((FixSizePool<T>) ((IPoolItem) obj));
    }
}
