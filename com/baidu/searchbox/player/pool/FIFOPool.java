package com.baidu.searchbox.player.pool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.pool.IPoolItem;
import com.baidu.searchbox.player.utils.BdVideoLog;
/* loaded from: classes3.dex */
public class FIFOPool<T extends IPoolItem> implements IPool<T> {
    private static final int INVALID_INDEX = -1;
    private static final String TAG = "FIFOPool";
    private int mActive = 0;
    private int mMaxSize;
    private final Object[] mPool;
    private int mPoolSize;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.player.pool.FIFOPool<T extends com.baidu.searchbox.player.pool.IPoolItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.player.pool.IPool
    public /* bridge */ /* synthetic */ void release(@NonNull Object obj) {
        release((FIFOPool<T>) ((IPoolItem) obj));
    }

    public FIFOPool(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.mMaxSize = i;
        this.mPool = new Object[i];
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    @Nullable
    public T acquire() {
        if (this.mPoolSize > 0) {
            if (this.mActive >= this.mMaxSize) {
                BdVideoLog.e("active player is overSize : " + this.mMaxSize);
            }
            int i = this.mPoolSize - 1;
            T t = (T) this.mPool[i];
            this.mPool[i] = null;
            this.mPoolSize--;
            this.mActive++;
            t.onInit();
            return t;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    @Nullable
    public T acquire(String str) {
        if (this.mPoolSize > 0) {
            if (this.mActive >= this.mMaxSize) {
                BdVideoLog.e("active player is overSize : " + this.mMaxSize);
            }
            int i = -1;
            for (int i2 = 0; i2 < this.mPoolSize; i2++) {
                if (((IPoolItem) this.mPool[i2]).verify(str)) {
                    i = i2;
                }
            }
            if (i != -1) {
                this.mActive++;
                T t = (T) this.mPool[i];
                this.mPool[i] = null;
                while (i < this.mPoolSize - 1) {
                    this.mPool[i] = this.mPool[i + 1];
                    i++;
                }
                this.mPool[this.mPoolSize - 1] = null;
                this.mPoolSize--;
                t.onInit();
                return t;
            }
            return null;
        }
        return null;
    }

    public void release(@NonNull T t) {
        if (!isInPool(t)) {
            addElement(t);
            this.mActive--;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(T t) {
        if (!isInPool(t)) {
            addElement(t);
            t.onInit();
        }
    }

    private void addElement(T t) {
        if (!isInPool(t)) {
            if (this.mPoolSize < this.mPool.length) {
                this.mPool[this.mPoolSize] = t;
                this.mPoolSize++;
                return;
            }
            for (int i = 0; i < this.mPool.length - 1; i++) {
                this.mPool[i] = this.mPool[i + 1];
            }
            this.mPool[this.mPoolSize - 1] = t;
        }
    }
}
