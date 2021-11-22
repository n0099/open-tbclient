package b.h.d.c;

import androidx.core.view.InputDeviceCompat;
import b.h.d.c.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class g0<E> extends y<E> implements s0<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g0() {
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

    @Override // b.h.d.c.s0
    public int add(E e2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, e2, i2)) == null) ? delegate().add(e2, i2) : invokeLI.intValue;
    }

    @Override // b.h.d.c.s0
    public int count(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? delegate().count(obj) : invokeL.intValue;
    }

    @Override // b.h.d.c.y, b.h.d.c.h0
    public abstract s0<E> delegate();

    @Override // b.h.d.c.y, b.h.d.c.h0
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // b.h.d.c.y, b.h.d.c.h0
    public abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // b.h.d.c.s0
    public abstract Set<E> elementSet();

    @Override // b.h.d.c.s0
    public abstract Set<s0.a<E>> entrySet();

    @Override // java.util.Collection, b.h.d.c.s0
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) ? obj == this || delegate().equals(obj) : invokeL.booleanValue;
    }

    @Override // java.util.Collection, b.h.d.c.s0
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? delegate().hashCode() : invokeV.intValue;
    }

    @Override // b.h.d.c.s0
    public int remove(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, obj, i2)) == null) ? delegate().remove(obj, i2) : invokeLI.intValue;
    }

    @Override // b.h.d.c.s0
    public int setCount(E e2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, e2, i2)) == null) ? delegate().setCount(e2, i2) : invokeLI.intValue;
    }

    public boolean standardAdd(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, e2)) == null) {
            add(e2, 1);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // b.h.d.c.y
    public boolean standardAddAll(Collection<? extends E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, collection)) == null) ? Multisets.c(this, collection) : invokeL.booleanValue;
    }

    @Override // b.h.d.c.y
    public void standardClear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Iterators.e(entrySet().iterator());
        }
    }

    @Override // b.h.d.c.y
    public boolean standardContains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, obj)) == null) ? count(obj) > 0 : invokeL.booleanValue;
    }

    public int standardCount(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            for (s0.a<E> aVar : entrySet()) {
                if (b.h.d.a.k.a(aVar.getElement(), obj)) {
                    return aVar.getCount();
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public boolean standardEquals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) ? Multisets.f(this, obj) : invokeL.booleanValue;
    }

    public int standardHashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? entrySet().hashCode() : invokeV.intValue;
    }

    public Iterator<E> standardIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? Multisets.j(this) : (Iterator) invokeV.objValue;
    }

    @Override // b.h.d.c.y
    public boolean standardRemove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) ? remove(obj, 1) > 0 : invokeL.booleanValue;
    }

    @Override // b.h.d.c.y
    public boolean standardRemoveAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, collection)) == null) ? Multisets.l(this, collection) : invokeL.booleanValue;
    }

    @Override // b.h.d.c.y
    public boolean standardRetainAll(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, collection)) == null) ? Multisets.m(this, collection) : invokeL.booleanValue;
    }

    public int standardSetCount(E e2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, e2, i2)) == null) ? Multisets.n(this, e2, i2) : invokeLI.intValue;
    }

    public int standardSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? Multisets.k(this) : invokeV.intValue;
    }

    @Override // b.h.d.c.y
    public String standardToString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? entrySet().toString() : (String) invokeV.objValue;
    }

    @Override // b.h.d.c.s0
    public boolean setCount(E e2, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048587, this, e2, i2, i3)) == null) ? delegate().setCount(e2, i2, i3) : invokeLII.booleanValue;
    }

    public boolean standardSetCount(E e2, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048600, this, e2, i2, i3)) == null) ? Multisets.o(this, e2, i2, i3) : invokeLII.booleanValue;
    }
}
