package com.baidu.searchbox.widget;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class RecyclePool<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<T> mPool;
    public final int mPoolLimit;

    public RecyclePool(int i2) {
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
        this.mPool = new ArrayList<>();
        this.mPoolLimit = i2;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mPool.clear();
        }
    }

    public synchronized T get() {
        InterceptResult invokeV;
        T remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                do {
                    if (this.mPool.size() <= 0) {
                        return null;
                    }
                    remove = this.mPool.remove(this.mPool.size() - 1);
                } while (remove == null);
                return remove;
            }
        }
        return (T) invokeV.objValue;
    }

    public synchronized void recycle(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            synchronized (this) {
                if (t != null) {
                    if (this.mPool.size() >= this.mPoolLimit) {
                        this.mPool.remove(this.mPool.size() - 1);
                    }
                    this.mPool.add(t);
                }
            }
        }
    }
}
