package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class Pools {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NonNull T t);
    }

    /* loaded from: classes.dex */
    public static class SimplePool<T> implements Pool<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object[] mPool;
        public int mPoolSize;

        public SimplePool(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (i > 0) {
                this.mPool = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(@NonNull T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, t)) == null) {
                for (int i = 0; i < this.mPoolSize; i++) {
                    if (this.mPool[i] == t) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
                if (!isInPool(t)) {
                    int i = this.mPoolSize;
                    Object[] objArr = this.mPool;
                    if (i < objArr.length) {
                        objArr[i] = t;
                        this.mPoolSize = i + 1;
                        return true;
                    }
                    return false;
                }
                throw new IllegalStateException("Already in the pool!");
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = this.mPoolSize;
                if (i <= 0) {
                    return null;
                }
                int i2 = i - 1;
                Object[] objArr = this.mPool;
                T t = (T) objArr[i2];
                objArr[i2] = null;
                this.mPoolSize = i - 1;
                return t;
            }
            return (T) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object mLock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SynchronizedPool(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            InterceptResult invokeV;
            T t;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.mLock) {
                    t = (T) super.acquire();
                }
                return t;
            }
            return (T) invokeV.objValue;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            InterceptResult invokeL;
            boolean release;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
                synchronized (this.mLock) {
                    release = super.release(t);
                }
                return release;
            }
            return invokeL.booleanValue;
        }
    }

    public Pools() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
