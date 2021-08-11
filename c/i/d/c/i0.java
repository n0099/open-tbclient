package c.i.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Queue;
/* loaded from: classes4.dex */
public abstract class i0<E> extends y<E> implements Queue<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i0() {
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

    @Override // c.i.d.c.y, c.i.d.c.h0
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // c.i.d.c.y, c.i.d.c.h0
    public abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // c.i.d.c.y, c.i.d.c.h0
    public abstract Queue<E> delegate();

    @Override // java.util.Queue
    public E element() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? delegate().element() : (E) invokeV.objValue;
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, e2)) == null) ? delegate().offer(e2) : invokeL.booleanValue;
    }

    @Override // java.util.Queue
    public E peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? delegate().peek() : (E) invokeV.objValue;
    }

    @Override // java.util.Queue
    public E poll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? delegate().poll() : (E) invokeV.objValue;
    }

    @Override // java.util.Queue
    public E remove() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? delegate().remove() : (E) invokeV.objValue;
    }

    public boolean standardOffer(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e2)) == null) {
            try {
                return add(e2);
            } catch (IllegalStateException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public E standardPeek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                return element();
            } catch (NoSuchElementException unused) {
                return null;
            }
        }
        return (E) invokeV.objValue;
    }

    public E standardPoll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                return remove();
            } catch (NoSuchElementException unused) {
                return null;
            }
        }
        return (E) invokeV.objValue;
    }
}
