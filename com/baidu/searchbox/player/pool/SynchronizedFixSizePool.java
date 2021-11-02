package com.baidu.searchbox.player.pool;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.pool.IPoolItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class SynchronizedFixSizePool<T extends IPoolItem> extends FixSizePool<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object mLock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SynchronizedFixSizePool(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.player.pool.SynchronizedFixSizePool<T extends com.baidu.searchbox.player.pool.IPoolItem> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.player.pool.FixSizePool, com.baidu.searchbox.player.pool.IPool
    public /* bridge */ /* synthetic */ void release(@NonNull Object obj) {
        release((SynchronizedFixSizePool<T>) ((IPoolItem) obj));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.player.pool.FixSizePool, com.baidu.searchbox.player.pool.IPool
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

    @Override // com.baidu.searchbox.player.pool.FixSizePool
    public void release(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            synchronized (this.mLock) {
                super.release((SynchronizedFixSizePool<T>) t);
            }
        }
    }
}
