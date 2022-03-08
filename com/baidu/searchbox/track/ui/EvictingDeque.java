package com.baidu.searchbox.track.ui;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public final class EvictingDeque<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCapacity;
    public final LinkedList<E> mDelegate;

    public EvictingDeque(int i2) {
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
        this.mDelegate = new LinkedList<>();
        this.mCapacity = i2;
    }

    public static <E> EvictingDeque<E> create(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 >= 0) {
                return new EvictingDeque<>(i2);
            }
            throw new IllegalArgumentException("capacity should not < 0");
        }
        return (EvictingDeque) invokeI.objValue;
    }

    public int getCapacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCapacity : invokeV.intValue;
    }

    public LinkedList<E> getElements() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDelegate : (LinkedList) invokeV.objValue;
    }

    public boolean offerLast(@NonNull E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2)) == null) {
            if (e2 != null) {
                while (this.mDelegate.size() > 0 && this.mDelegate.size() >= this.mCapacity) {
                    this.mDelegate.pollFirst();
                }
                if (this.mCapacity == 0) {
                    return true;
                }
                this.mDelegate.offerLast(e2);
                return true;
            }
            throw new NullPointerException("element should not be null");
        }
        return invokeL.booleanValue;
    }

    public E peekLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDelegate.peekLast() : (E) invokeV.objValue;
    }

    public void setCapacity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 >= 0) {
                this.mCapacity = i2;
                return;
            }
            throw new IllegalArgumentException("capacity should not < 0");
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDelegate.size() : invokeV.intValue;
    }
}
