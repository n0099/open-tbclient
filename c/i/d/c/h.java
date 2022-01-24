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
/* loaded from: classes9.dex */
public abstract class h<E> extends d<E> implements h1<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Comparator<? super E> comparator;
    public transient h1<E> descendingMultiset;

    /* loaded from: classes9.dex */
    public class a extends p<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h f30072h;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30072h = hVar;
        }

        @Override // c.i.d.c.p
        public Iterator<s0.a<E>> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30072h.descendingEntryIterator() : (Iterator) invokeV.objValue;
        }

        @Override // c.i.d.c.p
        public h1<E> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30072h : (h1) invokeV.objValue;
        }

        @Override // c.i.d.c.y, java.util.Collection, java.lang.Iterable, c.i.d.c.s0
        public Iterator<E> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30072h.descendingIterator() : (Iterator) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h() {
        this(Ordering.natural());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Comparator) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.i.d.c.h1, c.i.d.c.f1
    public Comparator<? super E> comparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.comparator : (Comparator) invokeV.objValue;
    }

    public h1<E> createDescendingMultiset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (h1) invokeV.objValue;
    }

    public abstract Iterator<s0.a<E>> descendingEntryIterator();

    public Iterator<E> descendingIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Multisets.j(descendingMultiset()) : (Iterator) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public h1<E> descendingMultiset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            h1<E> h1Var = this.descendingMultiset;
            if (h1Var == null) {
                h1<E> createDescendingMultiset = createDescendingMultiset();
                this.descendingMultiset = createDescendingMultiset;
                return createDescendingMultiset;
            }
            return h1Var;
        }
        return (h1) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public s0.a<E> firstEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Iterator<s0.a<E>> entryIterator = entryIterator();
            if (entryIterator.hasNext()) {
                return entryIterator.next();
            }
            return null;
        }
        return (s0.a) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public s0.a<E> lastEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Iterator<s0.a<E>> descendingEntryIterator = descendingEntryIterator();
            if (descendingEntryIterator.hasNext()) {
                return descendingEntryIterator.next();
            }
            return null;
        }
        return (s0.a) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public s0.a<E> pollFirstEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Iterator<s0.a<E>> entryIterator = entryIterator();
            if (entryIterator.hasNext()) {
                s0.a<E> next = entryIterator.next();
                s0.a<E> h2 = Multisets.h(next.getElement(), next.getCount());
                entryIterator.remove();
                return h2;
            }
            return null;
        }
        return (s0.a) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public s0.a<E> pollLastEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Iterator<s0.a<E>> descendingEntryIterator = descendingEntryIterator();
            if (descendingEntryIterator.hasNext()) {
                s0.a<E> next = descendingEntryIterator.next();
                s0.a<E> h2 = Multisets.h(next.getElement(), next.getCount());
                descendingEntryIterator.remove();
                return h2;
            }
            return null;
        }
        return (s0.a) invokeV.objValue;
    }

    @Override // c.i.d.c.h1
    public h1<E> subMultiset(E e2, BoundType boundType, E e3, BoundType boundType2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, e2, boundType, e3, boundType2)) == null) {
            c.i.d.a.n.p(boundType);
            c.i.d.a.n.p(boundType2);
            return tailMultiset(e2, boundType).headMultiset(e3, boundType2);
        }
        return (h1) invokeLLLL.objValue;
    }

    public h(Comparator<? super E> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {comparator};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c.i.d.a.n.p(comparator);
        this.comparator = comparator;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.d
    public NavigableSet<E> createElementSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new i1.b(this) : (NavigableSet) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.d, c.i.d.c.s0
    public NavigableSet<E> elementSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (NavigableSet) super.elementSet() : (NavigableSet) invokeV.objValue;
    }
}
