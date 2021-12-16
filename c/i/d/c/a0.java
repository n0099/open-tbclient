package c.i.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
/* loaded from: classes9.dex */
public abstract class a0<E> extends i0<E> implements Deque<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a0() {
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

    @Override // java.util.Deque
    public void addFirst(E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e2) == null) {
            delegate().addFirst(e2);
        }
    }

    @Override // java.util.Deque
    public void addLast(E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2) == null) {
            delegate().addLast(e2);
        }
    }

    @Override // c.i.d.c.i0, c.i.d.c.y, c.i.d.c.h0
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // c.i.d.c.i0, c.i.d.c.y, c.i.d.c.h0
    public abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // c.i.d.c.i0, c.i.d.c.y, c.i.d.c.h0
    public abstract Deque<E> delegate();

    @Override // c.i.d.c.i0, c.i.d.c.y, c.i.d.c.h0
    public abstract /* bridge */ /* synthetic */ Queue delegate();

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? delegate().descendingIterator() : (Iterator) invokeV.objValue;
    }

    @Override // java.util.Deque
    public E getFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? delegate().getFirst() : (E) invokeV.objValue;
    }

    @Override // java.util.Deque
    public E getLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? delegate().getLast() : (E) invokeV.objValue;
    }

    @Override // java.util.Deque
    public boolean offerFirst(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, e2)) == null) ? delegate().offerFirst(e2) : invokeL.booleanValue;
    }

    @Override // java.util.Deque
    public boolean offerLast(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, e2)) == null) ? delegate().offerLast(e2) : invokeL.booleanValue;
    }

    @Override // java.util.Deque
    public E peekFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? delegate().peekFirst() : (E) invokeV.objValue;
    }

    @Override // java.util.Deque
    public E peekLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? delegate().peekLast() : (E) invokeV.objValue;
    }

    @Override // java.util.Deque
    public E pollFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? delegate().pollFirst() : (E) invokeV.objValue;
    }

    @Override // java.util.Deque
    public E pollLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? delegate().pollLast() : (E) invokeV.objValue;
    }

    @Override // java.util.Deque
    public E pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? delegate().pop() : (E) invokeV.objValue;
    }

    @Override // java.util.Deque
    public void push(E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, e2) == null) {
            delegate().push(e2);
        }
    }

    @Override // java.util.Deque
    public E removeFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? delegate().removeFirst() : (E) invokeV.objValue;
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) ? delegate().removeFirstOccurrence(obj) : invokeL.booleanValue;
    }

    @Override // java.util.Deque
    public E removeLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? delegate().removeLast() : (E) invokeV.objValue;
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) ? delegate().removeLastOccurrence(obj) : invokeL.booleanValue;
    }
}
