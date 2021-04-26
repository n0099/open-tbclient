package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class Pools {

    /* loaded from: classes.dex */
    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NonNull T t);
    }

    /* loaded from: classes.dex */
    public static class SimplePool<T> implements Pool<T> {
        public final Object[] mPool;
        public int mPoolSize;

        public SimplePool(int i2) {
            if (i2 > 0) {
                this.mPool = new Object[i2];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(@NonNull T t) {
            for (int i2 = 0; i2 < this.mPoolSize; i2++) {
                if (this.mPool[i2] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int i2 = this.mPoolSize;
            if (i2 > 0) {
                int i3 = i2 - 1;
                Object[] objArr = this.mPool;
                T t = (T) objArr[i3];
                objArr[i3] = null;
                this.mPoolSize = i2 - 1;
                return t;
            }
            return null;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (!isInPool(t)) {
                int i2 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i2 < objArr.length) {
                    objArr[i2] = t;
                    this.mPoolSize = i2 + 1;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    /* loaded from: classes.dex */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        public final Object mLock;

        public SynchronizedPool(int i2) {
            super(i2);
            this.mLock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            T t;
            synchronized (this.mLock) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t);
            }
            return release;
        }
    }
}
