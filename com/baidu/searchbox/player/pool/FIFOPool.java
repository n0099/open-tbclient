package com.baidu.searchbox.player.pool;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class FIFOPool implements IPool {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SIZE = 2;
    public static final int INVALID_INDEX = -1;
    public static final String TAG = "FIFOPool";
    public transient /* synthetic */ FieldHolder $fh;
    public int mActive;
    public final int mMaxSize;
    public final Object[] mPool;
    public int mPoolSize;

    public FIFOPool(int i) {
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
        this.mActive = 0;
        i = i <= 0 ? 2 : i;
        this.mMaxSize = i;
        this.mPool = new Object[i];
    }

    private void addElement(IPoolItem iPoolItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, this, iPoolItem) != null) || isInPool(iPoolItem)) {
            return;
        }
        int i = this.mPoolSize;
        Object[] objArr = this.mPool;
        if (i < objArr.length) {
            objArr[i] = iPoolItem;
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
                objArr2[this.mPoolSize - 1] = iPoolItem;
                return;
            }
        }
    }

    private boolean isInPool(IPoolItem iPoolItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, iPoolItem)) == null) {
            for (int i = 0; i < this.mPoolSize; i++) {
                if (this.mPool[i] == iPoolItem) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void add(IPoolItem iPoolItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, iPoolItem) != null) || isInPool(iPoolItem)) {
            return;
        }
        addElement(iPoolItem);
        iPoolItem.onInit();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    public void release(IPoolItem iPoolItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, iPoolItem) != null) || isInPool(iPoolItem)) {
            return;
        }
        addElement(iPoolItem);
        this.mActive--;
        iPoolItem.onRelease();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    public IPoolItem acquire() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mPoolSize <= 0) {
                return null;
            }
            if (this.mActive >= this.mMaxSize) {
                BdVideoLog.w("acquire(), active player is overSize : " + this.mMaxSize);
            }
            int i = this.mPoolSize;
            int i2 = i - 1;
            Object[] objArr = this.mPool;
            IPoolItem iPoolItem = (IPoolItem) objArr[i2];
            objArr[i2] = null;
            this.mPoolSize = i - 1;
            this.mActive++;
            iPoolItem.onInit();
            return iPoolItem;
        }
        return (IPoolItem) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.IPool
    public IPoolItem acquire(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
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
                    IPoolItem iPoolItem = (IPoolItem) objArr[i];
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
                            iPoolItem.onInit();
                            return iPoolItem;
                        }
                    }
                }
            }
            return null;
        }
        return (IPoolItem) invokeL.objValue;
    }
}
