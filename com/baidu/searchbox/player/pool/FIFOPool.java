package com.baidu.searchbox.player.pool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.pool.IPoolItem;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FIFOPool<T extends IPoolItem> implements IPool<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_INDEX = -1;
    public static final String TAG = "FIFOPool";
    public transient /* synthetic */ FieldHolder $fh;
    public int mActive;
    public int mMaxSize;
    public final Object[] mPool;
    public int mPoolSize;

    public FIFOPool(int i2) {
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
        this.mActive = 0;
        if (i2 > 0) {
            this.mMaxSize = i2;
            this.mPool = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private void addElement(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, t) == null) || isInPool(t)) {
            return;
        }
        int i2 = this.mPoolSize;
        Object[] objArr = this.mPool;
        if (i2 < objArr.length) {
            objArr[i2] = t;
            this.mPoolSize = i2 + 1;
            return;
        }
        int i3 = 0;
        while (true) {
            Object[] objArr2 = this.mPool;
            if (i3 < objArr2.length - 1) {
                int i4 = i3 + 1;
                objArr2[i3] = objArr2[i4];
                i3 = i4;
            } else {
                objArr2[this.mPoolSize - 1] = t;
                return;
            }
        }
    }

    private boolean isInPool(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, t)) == null) {
            for (int i2 = 0; i2 < this.mPoolSize; i2++) {
                if (this.mPool[i2] == t) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void add(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, t) == null) || isInPool(t)) {
            return;
        }
        addElement(t);
        t.onInit();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.player.pool.FIFOPool<T extends com.baidu.searchbox.player.pool.IPoolItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.player.pool.IPool
    public /* bridge */ /* synthetic */ void release(@NonNull Object obj) {
        release((FIFOPool<T>) ((IPoolItem) obj));
    }

    public void release(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, t) == null) || isInPool(t)) {
            return;
        }
        addElement(t);
        this.mActive--;
        t.onRelease();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    @Nullable
    public T acquire() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mPoolSize > 0) {
                if (this.mActive >= this.mMaxSize) {
                    BdVideoLog.e("active player is overSize : " + this.mMaxSize);
                }
                int i2 = this.mPoolSize;
                int i3 = i2 - 1;
                Object[] objArr = this.mPool;
                T t = (T) objArr[i3];
                objArr[i3] = null;
                this.mPoolSize = i2 - 1;
                this.mActive++;
                t.onInit();
                return t;
            }
            return null;
        }
        return (T) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    @Nullable
    public T acquire(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.mPoolSize > 0) {
                if (this.mActive >= this.mMaxSize) {
                    BdVideoLog.e("active player is overSize : " + this.mMaxSize);
                }
                int i2 = -1;
                for (int i3 = 0; i3 < this.mPoolSize; i3++) {
                    if (((IPoolItem) this.mPool[i3]).verify(str)) {
                        i2 = i3;
                    }
                }
                if (i2 != -1) {
                    this.mActive++;
                    Object[] objArr = this.mPool;
                    T t = (T) objArr[i2];
                    objArr[i2] = null;
                    while (true) {
                        int i4 = this.mPoolSize;
                        if (i2 < i4 - 1) {
                            Object[] objArr2 = this.mPool;
                            int i5 = i2 + 1;
                            objArr2[i2] = objArr2[i5];
                            i2 = i5;
                        } else {
                            this.mPool[i4 - 1] = null;
                            this.mPoolSize = i4 - 1;
                            t.onInit();
                            return t;
                        }
                    }
                }
            }
            return null;
        }
        return (T) invokeL.objValue;
    }
}
