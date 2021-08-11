package c.i.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
/* loaded from: classes4.dex */
public final class o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends x<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Iterable f33997f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.i.d.a.o f33998g;

        public a(Iterable iterable, c.i.d.a.o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iterable, oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33997f = iterable;
            this.f33998g = oVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Iterators.l(this.f33997f.iterator(), this.f33998g) : (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends x<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Iterable f33999f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.i.d.a.g f34000g;

        public b(Iterable iterable, c.i.d.a.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iterable, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33999f = iterable;
            this.f34000g = gVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Iterators.A(this.f33999f.iterator(), this.f34000g) : (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends x<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Iterable f34001f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f34002g;

        /* loaded from: classes4.dex */
        public class a implements Iterator<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public boolean f34003e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Iterator f34004f;

            public a(c cVar, Iterator it) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, it};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34004f = it;
                this.f34003e = true;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34004f.hasNext() : invokeV.booleanValue;
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
            @Override // java.util.Iterator
            public T next() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    ?? next = this.f34004f.next();
                    this.f34003e = false;
                    return next;
                }
                return invokeV.objValue;
            }

            @Override // java.util.Iterator
            public void remove() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    m.e(!this.f34003e);
                    this.f34004f.remove();
                }
            }
        }

        public c(Iterable iterable, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iterable, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34001f = iterable;
            this.f34002g = i2;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Iterable iterable = this.f34001f;
                if (iterable instanceof List) {
                    List list = (List) iterable;
                    return list.subList(Math.min(list.size(), this.f34002g), list.size()).iterator();
                }
                Iterator it = iterable.iterator();
                Iterators.b(it, this.f34002g);
                return new a(this, it);
            }
            return (Iterator) invokeV.objValue;
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, collection, iterable)) == null) {
            if (iterable instanceof Collection) {
                return collection.addAll(n.a(iterable));
            }
            c.i.d.a.n.p(iterable);
            return Iterators.a(collection, iterable.iterator());
        }
        return invokeLL.booleanValue;
    }

    public static <T> boolean b(Iterable<T> iterable, c.i.d.a.o<? super T> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, iterable, oVar)) == null) ? Iterators.c(iterable.iterator(), oVar) : invokeLL.booleanValue;
    }

    public static <E> Collection<E> c(Iterable<E> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iterable)) == null) ? iterable instanceof Collection ? (Collection) iterable : Lists.k(iterable.iterator()) : (Collection) invokeL.objValue;
    }

    public static <T> Iterable<T> d(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, iterable, iterable2)) == null) ? x.a(iterable, iterable2) : (Iterable) invokeLL.objValue;
    }

    public static <T> Iterable<T> e(Iterable<T> iterable, c.i.d.a.o<? super T> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, iterable, oVar)) == null) {
            c.i.d.a.n.p(iterable);
            c.i.d.a.n.p(oVar);
            return new a(iterable, oVar);
        }
        return (Iterable) invokeLL.objValue;
    }

    public static <T> T f(Iterable<? extends T> iterable, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, iterable, t)) == null) ? (T) Iterators.o(iterable.iterator(), t) : (T) invokeLL.objValue;
    }

    public static <T> T g(Iterable<T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, iterable)) == null) {
            if (iterable instanceof List) {
                List list = (List) iterable;
                if (!list.isEmpty()) {
                    return (T) h(list);
                }
                throw new NoSuchElementException();
            }
            return (T) Iterators.n(iterable.iterator());
        }
        return (T) invokeL.objValue;
    }

    public static <T> T h(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, list)) == null) ? list.get(list.size() - 1) : (T) invokeL.objValue;
    }

    public static <T> T i(Iterable<T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) ? (T) Iterators.p(iterable.iterator()) : (T) invokeL.objValue;
    }

    public static boolean j(Iterable<?> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, iterable)) == null) {
            if (iterable instanceof Collection) {
                return ((Collection) iterable).isEmpty();
            }
            return !iterable.iterator().hasNext();
        }
        return invokeL.booleanValue;
    }

    public static <T> boolean k(Iterable<T> iterable, c.i.d.a.o<? super T> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, iterable, oVar)) == null) {
            if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
                c.i.d.a.n.p(oVar);
                return l((List) iterable, oVar);
            }
            return Iterators.v(iterable.iterator(), oVar);
        }
        return invokeLL.booleanValue;
    }

    public static <T> boolean l(List<T> list, c.i.d.a.o<? super T> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, list, oVar)) == null) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < list.size()) {
                T t = list.get(i2);
                if (!oVar.apply(t)) {
                    if (i2 > i3) {
                        try {
                            list.set(i3, t);
                        } catch (IllegalArgumentException unused) {
                            n(list, oVar, i3, i2);
                            return true;
                        } catch (UnsupportedOperationException unused2) {
                            n(list, oVar, i3, i2);
                            return true;
                        }
                    }
                    i3++;
                }
                i2++;
            }
            list.subList(i3, list.size()).clear();
            return i2 != i3;
        }
        return invokeLL.booleanValue;
    }

    public static <T> Iterable<T> m(Iterable<T> iterable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, iterable, i2)) == null) {
            c.i.d.a.n.p(iterable);
            c.i.d.a.n.e(i2 >= 0, "number to skip cannot be negative");
            return new c(iterable, i2);
        }
        return (Iterable) invokeLI.objValue;
    }

    public static <T> void n(List<T> list, c.i.d.a.o<? super T> oVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(65549, null, list, oVar, i2, i3) == null) {
            for (int size = list.size() - 1; size > i3; size--) {
                if (oVar.apply(list.get(size))) {
                    list.remove(size);
                }
            }
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                list.remove(i4);
            }
        }
    }

    public static Object[] o(Iterable<?> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, iterable)) == null) ? c(iterable).toArray() : (Object[]) invokeL.objValue;
    }

    public static <T> T[] p(Iterable<? extends T> iterable, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, iterable, cls)) == null) ? (T[]) q(iterable, u0.f(cls, 0)) : (T[]) ((Object[]) invokeLL.objValue);
    }

    public static <T> T[] q(Iterable<? extends T> iterable, T[] tArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, iterable, tArr)) == null) ? (T[]) c(iterable).toArray(tArr) : (T[]) ((Object[]) invokeLL.objValue);
    }

    public static String r(Iterable<?> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, iterable)) == null) ? Iterators.z(iterable.iterator()) : (String) invokeL.objValue;
    }

    public static <F, T> Iterable<T> s(Iterable<F> iterable, c.i.d.a.g<? super F, ? extends T> gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, iterable, gVar)) == null) {
            c.i.d.a.n.p(iterable);
            c.i.d.a.n.p(gVar);
            return new b(iterable, gVar);
        }
        return (Iterable) invokeLL.objValue;
    }
}
