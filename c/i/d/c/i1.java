package c.i.d.c;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.BoundType;
import com.google.common.collect.Multisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
/* loaded from: classes9.dex */
public final class i1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a<E> extends Multisets.c<E> implements SortedSet<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h1<E> f30075e;

        public a(h1<E> h1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30075e = h1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Multisets.c
        /* renamed from: c */
        public final h1<E> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30075e : (h1) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b().comparator() : (Comparator) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public E first() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (E) i1.d(b().firstEntry()) : (E) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, e2)) == null) ? b().headMultiset(e2, BoundType.OPEN).elementSet() : (SortedSet) invokeL.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Multisets.e(b().entrySet().iterator()) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public E last() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (E) i1.d(b().lastEntry()) : (E) invokeV.objValue;
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e2, E e3) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, e2, e3)) == null) ? b().subMultiset(e2, BoundType.CLOSED, e3, BoundType.OPEN).elementSet() : (SortedSet) invokeLL.objValue;
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, e2)) == null) ? b().tailMultiset(e2, BoundType.CLOSED).elementSet() : (SortedSet) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b<E> extends a<E> implements NavigableSet<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h1<E> h1Var) {
            super(h1Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((h1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) ? (E) i1.c(b().tailMultiset(e2, BoundType.CLOSED).firstEntry()) : (E) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? descendingSet().iterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new b(b().descendingMultiset()) : (NavigableSet) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, e2)) == null) ? (E) i1.c(b().headMultiset(e2, BoundType.CLOSED).lastEntry()) : (E) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, e2, z)) == null) ? new b(b().headMultiset(e2, BoundType.forBoolean(z))) : (NavigableSet) invokeLZ.objValue;
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, e2)) == null) ? (E) i1.c(b().tailMultiset(e2, BoundType.OPEN).firstEntry()) : (E) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, e2)) == null) ? (E) i1.c(b().headMultiset(e2, BoundType.OPEN).lastEntry()) : (E) invokeL.objValue;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (E) i1.c(b().pollFirstEntry()) : (E) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (E) i1.c(b().pollLastEntry()) : (E) invokeV.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e2, boolean z, E e3, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{e2, Boolean.valueOf(z), e3, Boolean.valueOf(z2)})) == null) ? new b(b().subMultiset(e2, BoundType.forBoolean(z), e3, BoundType.forBoolean(z2))) : (NavigableSet) invokeCommon.objValue;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e2, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, e2, z)) == null) ? new b(b().tailMultiset(e2, BoundType.forBoolean(z))) : (NavigableSet) invokeLZ.objValue;
        }
    }

    public static <E> E c(s0.a<E> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            if (aVar == null) {
                return null;
            }
            return aVar.getElement();
        }
        return (E) invokeL.objValue;
    }

    public static <E> E d(s0.a<E> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            if (aVar != null) {
                return aVar.getElement();
            }
            throw new NoSuchElementException();
        }
        return (E) invokeL.objValue;
    }
}
