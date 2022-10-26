package com.baidu.searchbox.player.pool;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class FixSizePool implements IPool {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SIZE = 2;
    public static final String TAG = "FixSizePool";
    public transient /* synthetic */ FieldHolder $fh;
    public final Object[] mPool;
    public int mPoolSize;

    public abstract IPoolItem createItem();

    public FixSizePool(int i) {
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
        this.mPool = new Object[i <= 0 ? 2 : i];
    }

    private boolean isInPool(IPoolItem iPoolItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, iPoolItem)) == null) {
            for (int i = 0; i < this.mPoolSize; i++) {
                if (this.mPool[i] == iPoolItem) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    public IPoolItem acquire(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return acquire();
        }
        return (IPoolItem) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    public void release(IPoolItem iPoolItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, iPoolItem) != null) || isInPool(iPoolItem)) {
            return;
        }
        int i = this.mPoolSize;
        Object[] objArr = this.mPool;
        if (i < objArr.length) {
            objArr[i] = iPoolItem;
            this.mPoolSize = i + 1;
        }
        iPoolItem.onRelease();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    public IPoolItem acquire() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.mPoolSize;
            if (i <= 0) {
                IPoolItem createItem = createItem();
                createItem.onInit();
                return createItem;
            }
            int i2 = i - 1;
            Object[] objArr = this.mPool;
            IPoolItem iPoolItem = (IPoolItem) objArr[i2];
            objArr[i2] = null;
            this.mPoolSize = i - 1;
            iPoolItem.onInit();
            return iPoolItem;
        }
        return (IPoolItem) invokeV.objValue;
    }
}
