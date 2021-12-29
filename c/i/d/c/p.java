package c.i.d.c;

import c.i.d.c.i1;
import c.i.d.c.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.BoundType;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
/* loaded from: classes9.dex */
public abstract class p<E> extends g0<E> implements h1<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public transient Comparator<? super E> f31038e;

    /* renamed from: f  reason: collision with root package name */
    public transient NavigableSet<E> f31039f;

    /* renamed from: g  reason: collision with root package name */
    public transient Set<s0.a<E>> f31040g;

    /* loaded from: classes9.dex */
    public class a extends Multisets.d<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f31041e;

        public a(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31041e = pVar;
        }

        @Override // com.google.common.collect.Multisets.d
        public s0<E> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31041e : (s0) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<s0.a<E>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31041e.e() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31041e.f().entrySet().size() : invokeV.intValue;
        }
    }

    public p() {
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

    @Override // c.i.d.c.h1, c.i.d.c.f1
    public Comparator<? super E> comparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Comparator<? super E> comparator = this.f31038e;
            if (comparator == null) {
                Ordering reverse = Ordering.from(f().comparator()).reverse();
                this.f31038e = reverse;
                return reverse;
            }
            return comparator;
        }
        return (Comparator) invokeV.objValue;
    }

    public Set<s0.a<E>> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (Set) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public h1<E> descendingMultiset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? f() : (h1) invokeV.objValue;
    }

    public abstract Iterator<s0.a<E>> e();

    @Override // c.i.d.c.g0, c.i.d.c.s0
    public Set<s0.a<E>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Set<s0.a<E>> set = this.f31040g;
            if (set == null) {
                Set<s0.a<E>> d2 = d();
                this.f31040g = d2;
                return d2;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    public abstract h1<E> f();

    @Override // c.i.d.c.h1
    public s0.a<E> firstEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? f().lastEntry() : (s0.a) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public h1<E> headMultiset(E e2, BoundType boundType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, e2, boundType)) == null) ? f().tailMultiset(e2, boundType).descendingMultiset() : (h1) invokeLL.objValue;
    }

    @Override // c.i.d.c.h1
    public s0.a<E> lastEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? f().firstEntry() : (s0.a) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public s0.a<E> pollFirstEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? f().pollLastEntry() : (s0.a) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public s0.a<E> pollLastEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? f().pollFirstEntry() : (s0.a) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public h1<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, e2, boundType, e3, boundType2)) == null) ? f().subMultiset(e3, boundType2, e2, boundType).descendingMultiset() : (h1) invokeLLLL.objValue;
    }

    @Override // c.i.d.c.h1
    public h1<E> tailMultiset(E e2, BoundType boundType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, e2, boundType)) == null) ? f().headMultiset(e2, boundType).descendingMultiset() : (h1) invokeLL.objValue;
    }

    @Override // c.i.d.c.y, java.util.Collection
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? standardToArray() : (Object[]) invokeV.objValue;
    }

    @Override // c.i.d.c.h0, java.lang.Object
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? entrySet().toString() : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.g0, c.i.d.c.s0
    public NavigableSet<E> elementSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            NavigableSet<E> navigableSet = this.f31039f;
            if (navigableSet == null) {
                i1.b bVar = new i1.b(this);
                this.f31039f = bVar;
                return bVar;
            }
            return navigableSet;
        }
        return (NavigableSet) invokeV.objValue;
    }

    @Override // c.i.d.c.y, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, tArr)) == null) ? (T[]) standardToArray(tArr) : (T[]) ((Object[]) invokeL.objValue);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.g0, c.i.d.c.y, c.i.d.c.h0
    public s0<E> delegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f() : (s0) invokeV.objValue;
    }
}
