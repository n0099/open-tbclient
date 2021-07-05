package androidx.constraintlayout.solver;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class Pools {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);

        void releaseAll(T[] tArr, int i2);
    }

    /* loaded from: classes.dex */
    public static class SimplePool<T> implements Pool<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object[] mPool;
        public int mPoolSize;

        public SimplePool(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (i2 > 0) {
                this.mPool = new Object[i2];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, t)) == null) {
                for (int i2 = 0; i2 < this.mPoolSize; i2++) {
                    if (this.mPool[i2] == t) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public T acquire() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
            return (T) invokeV.objValue;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public boolean release(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
                int i2 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i2 < objArr.length) {
                    objArr[i2] = t;
                    this.mPoolSize = i2 + 1;
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public void releaseAll(T[] tArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tArr, i2) == null) {
                if (i2 > tArr.length) {
                    i2 = tArr.length;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    T t = tArr[i3];
                    int i4 = this.mPoolSize;
                    Object[] objArr = this.mPool;
                    if (i4 < objArr.length) {
                        objArr[i4] = t;
                        this.mPoolSize = i4 + 1;
                    }
                }
            }
        }
    }

    public Pools() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
