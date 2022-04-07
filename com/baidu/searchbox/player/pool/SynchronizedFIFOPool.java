package com.baidu.searchbox.player.pool;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.pool.IPoolItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SynchronizedFIFOPool<T extends IPoolItem> extends FIFOPool<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object mLock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SynchronizedFIFOPool(int i) {
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

    @Override // com.baidu.searchbox.player.pool.FIFOPool
    public void add(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            synchronized (this.mLock) {
                super.add(t);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.player.pool.SynchronizedFIFOPool<T extends com.baidu.searchbox.player.pool.IPoolItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.player.pool.FIFOPool, com.baidu.searchbox.player.pool.IPool
    public /* bridge */ /* synthetic */ void release(@NonNull Object obj) {
        release((SynchronizedFIFOPool<T>) ((IPoolItem) obj));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.FIFOPool, com.baidu.searchbox.player.pool.IPool
    @NonNull
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

    @Override // com.baidu.searchbox.player.pool.FIFOPool
    public void release(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            synchronized (this.mLock) {
                super.release((SynchronizedFIFOPool<T>) t);
            }
        }
    }
}
