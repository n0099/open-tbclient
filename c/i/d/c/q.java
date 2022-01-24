package c.i.d.c;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class q<K, V> extends c.i.d.c.c<K, V> implements u<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final q0<K, V> f30099e;

    /* renamed from: f  reason: collision with root package name */
    public final c.i.d.a.o<? super Map.Entry<K, V>> f30100f;

    /* loaded from: classes9.dex */
    public class a extends Maps.y<K, Collection<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ q f30101h;

        /* renamed from: c.i.d.c.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1680a extends Maps.k<K, Collection<V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f30102e;

            /* renamed from: c.i.d.c.q$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C1681a extends AbstractIterator<Map.Entry<K, Collection<V>>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: g  reason: collision with root package name */
                public final Iterator<Map.Entry<K, Collection<V>>> f30103g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ C1680a f30104h;

                public C1681a(C1680a c1680a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1680a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30104h = c1680a;
                    this.f30103g = this.f30104h.f30102e.f30101h.f30099e.asMap().entrySet().iterator();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.common.collect.AbstractIterator
                /* renamed from: d */
                public Map.Entry<K, Collection<V>> a() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        while (this.f30103g.hasNext()) {
                            Map.Entry<K, Collection<V>> next = this.f30103g.next();
                            K key = next.getKey();
                            Collection d2 = q.d(next.getValue(), new c(this.f30104h.f30102e.f30101h, key));
                            if (!d2.isEmpty()) {
                                return Maps.l(key, d2);
                            }
                        }
                        return b();
                    }
                    return (Map.Entry) invokeV.objValue;
                }
            }

            public C1680a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f30102e = aVar;
            }

            @Override // com.google.common.collect.Maps.k
            public Map<K, Collection<V>> b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30102e : (Map) invokeV.objValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new C1681a(this) : (Iterator) invokeV.objValue;
            }

            @Override // com.google.common.collect.Maps.k, com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) ? this.f30102e.f30101h.e(Predicates.g(collection)) : invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Maps.k, com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, collection)) == null) ? this.f30102e.f30101h.e(Predicates.j(Predicates.g(collection))) : invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Maps.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Iterators.y(iterator()) : invokeV.intValue;
            }
        }

        /* loaded from: classes9.dex */
        public class b extends Maps.q<K, Collection<V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f30105f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(a aVar) {
                super(aVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Map) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f30105f = aVar;
            }

            @Override // com.google.common.collect.Maps.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this.f30105f.remove(obj) != null : invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) ? this.f30105f.f30101h.e(Maps.q(Predicates.g(collection))) : invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) ? this.f30105f.f30101h.e(Maps.q(Predicates.j(Predicates.g(collection)))) : invokeL.booleanValue;
            }
        }

        /* loaded from: classes9.dex */
        public class c extends Maps.x<K, Collection<V>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f30106f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(a aVar) {
                super(aVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Map) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f30106f = aVar;
            }

            @Override // com.google.common.collect.Maps.x, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                    if (obj instanceof Collection) {
                        Collection collection = (Collection) obj;
                        Iterator<Map.Entry<K, Collection<V>>> it = this.f30106f.f30101h.f30099e.asMap().entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<K, Collection<V>> next = it.next();
                            Collection d2 = q.d(next.getValue(), new c(this.f30106f.f30101h, next.getKey()));
                            if (!d2.isEmpty() && collection.equals(d2)) {
                                if (d2.size() == next.getValue().size()) {
                                    it.remove();
                                    return true;
                                }
                                d2.clear();
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Maps.x, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) ? this.f30106f.f30101h.e(Maps.Q(Predicates.g(collection))) : invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Maps.x, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) ? this.f30106f.f30101h.e(Maps.Q(Predicates.j(Predicates.g(collection)))) : invokeL.booleanValue;
            }
        }

        public a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30101h = qVar;
        }

        @Override // com.google.common.collect.Maps.y
        public Set<Map.Entry<K, Collection<V>>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C1680a(this) : (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.Maps.y
        public Set<K> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new b(this) : (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.Maps.y
        public Collection<Collection<V>> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new c(this) : (Collection) invokeV.objValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f30101h.clear();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? get(obj) != null : invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Collection<V> get(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                Collection<V> collection = this.f30101h.f30099e.asMap().get(obj);
                if (collection == null) {
                    return null;
                }
                Collection<V> d2 = q.d(collection, new c(this.f30101h, obj));
                if (d2.isEmpty()) {
                    return null;
                }
                return d2;
            }
            return (Collection) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Collection<V> remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                Collection<V> collection = this.f30101h.f30099e.asMap().get(obj);
                if (collection == null) {
                    return null;
                }
                ArrayList i2 = Lists.i();
                Iterator<V> it = collection.iterator();
                while (it.hasNext()) {
                    V next = it.next();
                    if (this.f30101h.f(obj, next)) {
                        it.remove();
                        i2.add(next);
                    }
                }
                if (i2.isEmpty()) {
                    return null;
                }
                if (this.f30101h.f30099e instanceof e1) {
                    return Collections.unmodifiableSet(Sets.j(i2));
                }
                return Collections.unmodifiableList(i2);
            }
            return (Collection) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends Multimaps.c<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ q f30107f;

        /* loaded from: classes9.dex */
        public class a extends Multisets.d<K> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f30108e;

            /* renamed from: c.i.d.c.q$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public class C1682a implements c.i.d.a.o<Map.Entry<K, Collection<V>>> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ c.i.d.a.o f30109e;

                public C1682a(a aVar, c.i.d.a.o oVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, oVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30109e = oVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // c.i.d.a.o
                /* renamed from: a */
                public boolean apply(Map.Entry<K, Collection<V>> entry) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, entry)) == null) ? this.f30109e.apply(Multisets.h(entry.getKey(), entry.getValue().size())) : invokeL.booleanValue;
                }
            }

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f30108e = bVar;
            }

            @Override // com.google.common.collect.Multisets.d
            public s0<K> b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30108e : (s0) invokeV.objValue;
            }

            public final boolean c(c.i.d.a.o<? super s0.a<K>> oVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar)) == null) ? this.f30108e.f30107f.e(new C1682a(this, oVar)) : invokeL.booleanValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<s0.a<K>> iterator() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30108e.entryIterator() : (Iterator) invokeV.objValue;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, collection)) == null) ? c(Predicates.g(collection)) : invokeL.booleanValue;
            }

            @Override // com.google.common.collect.Sets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) ? c(Predicates.j(Predicates.g(collection))) : invokeL.booleanValue;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30108e.f30107f.keySet().size() : invokeV.intValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(q qVar) {
            super(qVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((q0) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30107f = qVar;
        }

        @Override // c.i.d.c.d, c.i.d.c.s0
        public Set<s0.a<K>> entrySet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (Set) invokeV.objValue;
        }

        @Override // com.google.common.collect.Multimaps.c, c.i.d.c.d, c.i.d.c.s0
        public int remove(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2)) == null) {
                m.b(i2, "occurrences");
                if (i2 == 0) {
                    return count(obj);
                }
                Collection<V> collection = this.f30107f.f30099e.asMap().get(obj);
                int i3 = 0;
                if (collection == null) {
                    return 0;
                }
                Iterator<V> it = collection.iterator();
                while (it.hasNext()) {
                    if (this.f30107f.f(obj, it.next()) && (i3 = i3 + 1) <= i2) {
                        it.remove();
                    }
                }
                return i3;
            }
            return invokeLI.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class c implements c.i.d.a.o<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f30110e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ q f30111f;

        public c(q qVar, K k) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, k};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30111f = qVar;
            this.f30110e = k;
        }

        @Override // c.i.d.a.o
        public boolean apply(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v)) == null) ? this.f30111f.f(this.f30110e, v) : invokeL.booleanValue;
        }
    }

    public q(q0<K, V> q0Var, c.i.d.a.o<? super Map.Entry<K, V>> oVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q0Var, oVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.i.d.a.n.p(q0Var);
        this.f30099e = q0Var;
        c.i.d.a.n.p(oVar);
        this.f30100f = oVar;
    }

    public static <E> Collection<E> d(Collection<E> collection, c.i.d.a.o<? super E> oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, collection, oVar)) == null) {
            if (collection instanceof Set) {
                return Sets.b((Set) collection, oVar);
            }
            return n.c(collection, oVar);
        }
        return (Collection) invokeLL.objValue;
    }

    @Override // c.i.d.c.u
    public c.i.d.a.o<? super Map.Entry<K, V>> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30100f : (c.i.d.a.o) invokeV.objValue;
    }

    @Override // c.i.d.c.q0
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            entries().clear();
        }
    }

    @Override // c.i.d.c.q0
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? asMap().get(obj) != null : invokeL.booleanValue;
    }

    @Override // c.i.d.c.c
    public Map<K, Collection<V>> createAsMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(this) : (Map) invokeV.objValue;
    }

    @Override // c.i.d.c.c
    public Set<K> createKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? asMap().keySet() : (Set) invokeV.objValue;
    }

    @Override // c.i.d.c.c
    public s0<K> createKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new b(this) : (s0) invokeV.objValue;
    }

    @Override // c.i.d.c.c
    public Collection<V> createValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new v(this) : (Collection) invokeV.objValue;
    }

    public boolean e(c.i.d.a.o<? super Map.Entry<K, Collection<V>>> oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, oVar)) == null) {
            Iterator<Map.Entry<K, Collection<V>>> it = this.f30099e.asMap().entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<K, Collection<V>> next = it.next();
                K key = next.getKey();
                Collection d2 = d(next.getValue(), new c(this, key));
                if (!d2.isEmpty() && oVar.apply(Maps.l(key, d2))) {
                    if (d2.size() == next.getValue().size()) {
                        it.remove();
                    } else {
                        d2.clear();
                    }
                    z = true;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // c.i.d.c.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new AssertionError("should never be called");
        }
        return (Iterator) invokeV.objValue;
    }

    public final boolean f(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, k, v)) == null) ? this.f30100f.apply(Maps.l(k, v)) : invokeLL.booleanValue;
    }

    public Collection<V> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.f30099e instanceof e1) {
                return Collections.emptySet();
            }
            return Collections.emptyList();
        }
        return (Collection) invokeV.objValue;
    }

    @Override // c.i.d.c.q0
    public Collection<V> get(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, k)) == null) ? d(this.f30099e.get(k), new c(this, k)) : (Collection) invokeL.objValue;
    }

    @Override // c.i.d.c.q0
    public Collection<V> removeAll(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) ? (Collection) c.i.d.a.j.a(asMap().remove(obj), g()) : (Collection) invokeL.objValue;
    }

    @Override // c.i.d.c.q0
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? entries().size() : invokeV.intValue;
    }
}
