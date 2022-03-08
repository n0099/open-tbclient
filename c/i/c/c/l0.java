package c.i.c.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
/* loaded from: classes3.dex */
public abstract class l0<E> extends j0<E> implements SortedSet<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l0() {
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

    private int unsafeCompare(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, obj, obj2)) == null) {
            Comparator<? super E> comparator = comparator();
            if (comparator == null) {
                return ((Comparable) obj).compareTo(obj2);
            }
            return comparator.compare(obj, obj2);
        }
        return invokeLL.intValue;
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? delegate().comparator() : (Comparator) invokeV.objValue;
    }

    @Override // c.i.c.c.j0, c.i.c.c.y, c.i.c.c.h0
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // c.i.c.c.j0, c.i.c.c.y, c.i.c.c.h0
    public abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // c.i.c.c.j0, c.i.c.c.y, c.i.c.c.h0
    public abstract /* bridge */ /* synthetic */ Set delegate();

    @Override // c.i.c.c.j0, c.i.c.c.y, c.i.c.c.h0
    public abstract SortedSet<E> delegate();

    @Override // java.util.SortedSet
    public E first() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? delegate().first() : (E) invokeV.objValue;
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, e2)) == null) ? delegate().headSet(e2) : (SortedSet) invokeL.objValue;
    }

    @Override // java.util.SortedSet
    public E last() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? delegate().last() : (E) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.i.c.c.y
    public boolean standardContains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            try {
                return unsafeCompare(tailSet(obj).first(), obj) == 0;
            } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.i.c.c.y
    public boolean standardRemove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            try {
                Iterator<E> it = tailSet(obj).iterator();
                if (it.hasNext() && unsafeCompare(it.next(), obj) == 0) {
                    it.remove();
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public SortedSet<E> standardSubSet(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, e2, e3)) == null) ? tailSet(e2).headSet(e3) : (SortedSet) invokeLL.objValue;
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e2, E e3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, e2, e3)) == null) ? delegate().subSet(e2, e3) : (SortedSet) invokeLL.objValue;
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, e2)) == null) ? delegate().tailSet(e2) : (SortedSet) invokeL.objValue;
    }
}
