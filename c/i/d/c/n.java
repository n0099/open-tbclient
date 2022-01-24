package c.i.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes9.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a<E> extends AbstractCollection<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Collection<E> f30082e;

        /* renamed from: f  reason: collision with root package name */
        public final c.i.d.a.o<? super E> f30083f;

        public a(Collection<E> collection, c.i.d.a.o<? super E> oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {collection, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30082e = collection;
            this.f30083f = oVar;
        }

        public a<E> a(c.i.d.a.o<? super E> oVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, oVar)) == null) ? new a<>(this.f30082e, Predicates.c(this.f30083f, oVar)) : (a) invokeL.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E e2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2)) == null) {
                c.i.d.a.n.d(this.f30083f.apply(e2));
                return this.f30082e.add(e2);
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
                for (E e2 : collection) {
                    c.i.d.a.n.d(this.f30083f.apply(e2));
                }
                return this.f30082e.addAll(collection);
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                o0.k(this.f30082e, this.f30083f);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (n.e(this.f30082e, obj)) {
                    return this.f30083f.apply(obj);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, collection)) == null) ? n.b(this, collection) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !o0.b(this.f30082e, this.f30083f) : invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Iterators.l(this.f30082e.iterator(), this.f30083f) : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? contains(obj) && this.f30082e.remove(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, collection)) == null) {
                Iterator<E> it = this.f30082e.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    E next = it.next();
                    if (this.f30083f.apply(next) && collection.contains(next)) {
                        it.remove();
                        z = true;
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, collection)) == null) {
                Iterator<E> it = this.f30082e.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    E next = it.next();
                    if (this.f30083f.apply(next) && !collection.contains(next)) {
                        it.remove();
                        z = true;
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                int i2 = 0;
                for (E e2 : this.f30082e) {
                    if (this.f30083f.apply(e2)) {
                        i2++;
                    }
                }
                return i2;
            }
            return invokeV.intValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Lists.k(iterator()).toArray() : (Object[]) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, tArr)) == null) ? (T[]) Lists.k(iterator()).toArray(tArr) : (T[]) ((Object[]) invokeL.objValue);
        }
    }

    public static <T> Collection<T> a(Iterable<T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iterable)) == null) ? (Collection) iterable : (Collection) invokeL.objValue;
    }

    public static boolean b(Collection<?> collection, Collection<?> collection2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, collection, collection2)) == null) {
            Iterator<?> it = collection2.iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static <E> Collection<E> c(Collection<E> collection, c.i.d.a.o<? super E> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, collection, oVar)) == null) {
            if (collection instanceof a) {
                return ((a) collection).a(oVar);
            }
            c.i.d.a.n.p(collection);
            c.i.d.a.n.p(oVar);
            return new a(collection, oVar);
        }
        return (Collection) invokeLL.objValue;
    }

    public static StringBuilder d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            m.b(i2, "size");
            return new StringBuilder((int) Math.min(i2 * 8, 1073741824L));
        }
        return (StringBuilder) invokeI.objValue;
    }

    public static boolean e(Collection<?> collection, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, collection, obj)) == null) {
            c.i.d.a.n.p(collection);
            try {
                return collection.contains(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(Collection<?> collection, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, collection, obj)) == null) {
            c.i.d.a.n.p(collection);
            try {
                return collection.remove(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static String g(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, collection)) == null) {
            StringBuilder d2 = d(collection.size());
            d2.append('[');
            boolean z = true;
            for (Object obj : collection) {
                if (!z) {
                    d2.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                z = false;
                if (obj == collection) {
                    d2.append("(this Collection)");
                } else {
                    d2.append(obj);
                }
            }
            d2.append(']');
            return d2.toString();
        }
        return (String) invokeL.objValue;
    }
}
