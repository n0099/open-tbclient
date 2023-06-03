package com.baidu.searchbox.player.pool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.pool.IPoolItem;
import com.baidu.searchbox.player.utils.BdVideoLog;
/* loaded from: classes4.dex */
public class FIFOPool<T extends IPoolItem> implements IPool<T> {
    public static final int DEFAULT_SIZE = 2;
    public static final int INVALID_INDEX = -1;
    public static final String TAG = "FIFOPool";
    public int mActive = 0;
    public final int mMaxSize;
    public final Object[] mPool;
    public int mPoolSize;

    public FIFOPool(int i) {
        i = i <= 0 ? 2 : i;
        this.mMaxSize = i;
        this.mPool = new Object[i];
    }

    private void addElement(T t) {
        if (isInPool(t)) {
            return;
        }
        int i = this.mPoolSize;
        Object[] objArr = this.mPool;
        if (i < objArr.length) {
            objArr[i] = t;
            this.mPoolSize = i + 1;
            return;
        }
        int i2 = 0;
        while (true) {
            Object[] objArr2 = this.mPool;
            if (i2 < objArr2.length - 1) {
                int i3 = i2 + 1;
                objArr2[i2] = objArr2[i3];
                i2 = i3;
            } else {
                objArr2[this.mPoolSize - 1] = t;
                return;
            }
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

    public void add(T t) {
        if (isInPool(t)) {
            return;
        }
        addElement(t);
        t.onInit();
    }

    public void release(@NonNull T t) {
        if (isInPool(t)) {
            return;
        }
        addElement(t);
        this.mActive--;
        t.onRelease();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    public T acquire() {
        if (this.mPoolSize <= 0) {
            return null;
        }
        if (this.mActive >= this.mMaxSize) {
            BdVideoLog.w("acquire(), active player is overSize : " + this.mMaxSize);
        }
        int i = this.mPoolSize;
        int i2 = i - 1;
        Object[] objArr = this.mPool;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.mPoolSize = i - 1;
        this.mActive++;
        t.onInit();
        return t;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    @Nullable
    public T acquire(String str) {
        if (this.mPoolSize > 0) {
            if (this.mActive >= this.mMaxSize) {
                BdVideoLog.w("acquire(" + str + "), active player is overSize : " + this.mMaxSize);
            }
            int i = -1;
            for (int i2 = 0; i2 < this.mPoolSize; i2++) {
                if (((IPoolItem) this.mPool[i2]).verify(str)) {
                    i = i2;
                }
            }
            if (i != -1) {
                this.mActive++;
                Object[] objArr = this.mPool;
                T t = (T) objArr[i];
                objArr[i] = null;
                while (true) {
                    int i3 = this.mPoolSize;
                    if (i < i3 - 1) {
                        Object[] objArr2 = this.mPool;
                        int i4 = i + 1;
                        objArr2[i] = objArr2[i4];
                        i = i4;
                    } else {
                        this.mPool[i3 - 1] = null;
                        this.mPoolSize = i3 - 1;
                        t.onInit();
                        return t;
                    }
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.player.pool.FIFOPool<T extends com.baidu.searchbox.player.pool.IPoolItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.player.pool.IPool
    public /* bridge */ /* synthetic */ void release(@NonNull Object obj) {
        release((FIFOPool<T>) ((IPoolItem) obj));
    }
}
