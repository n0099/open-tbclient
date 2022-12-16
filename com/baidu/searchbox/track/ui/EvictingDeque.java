package com.baidu.searchbox.track.ui;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public final class EvictingDeque<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCapacity;
    public final LinkedList<E> mDelegate;

    public EvictingDeque(int i) {
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
        this.mDelegate = new LinkedList<>();
        this.mCapacity = i;
    }

    public boolean offerLast(@NonNull E e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e)) == null) {
            if (e != null) {
                while (this.mDelegate.size() > 0 && this.mDelegate.size() >= this.mCapacity) {
                    this.mDelegate.pollFirst();
                }
                if (this.mCapacity == 0) {
                    return true;
                }
                this.mDelegate.offerLast(e);
                return true;
            }
            throw new NullPointerException("element should not be null");
        }
        return invokeL.booleanValue;
    }

    public static <E> EvictingDeque<E> create(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (i >= 0) {
                return new EvictingDeque<>(i);
            }
            throw new IllegalArgumentException("capacity should not < 0");
        }
        return (EvictingDeque) invokeI.objValue;
    }

    public void setCapacity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i >= 0) {
                this.mCapacity = i;
                return;
            }
            throw new IllegalArgumentException("capacity should not < 0");
        }
    }

    public int getCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mCapacity;
        }
        return invokeV.intValue;
    }

    public LinkedList<E> getElements() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mDelegate;
        }
        return (LinkedList) invokeV.objValue;
    }

    public E peekLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mDelegate.peekLast();
        }
        return (E) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mDelegate.size();
        }
        return invokeV.intValue;
    }
}
