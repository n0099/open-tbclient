package c.a.j.h.c.c.c;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class d<K, V> implements Iterable<Map.Entry<K, V>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c<K, V> f3606e;

    /* renamed from: f  reason: collision with root package name */
    public c<K, V> f3607f;

    /* renamed from: g  reason: collision with root package name */
    public WeakHashMap<Object<K, V>, Boolean> f3608g;

    /* renamed from: h  reason: collision with root package name */
    public int f3609h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b<K, V> extends e<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((c) objArr2[0], (c) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.j.h.c.c.c.d.e
        public c<K, V> a(c<K, V> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.f3612g : (c) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f3610e;

        /* renamed from: f  reason: collision with root package name */
        public final V f3611f;

        /* renamed from: g  reason: collision with root package name */
        public c<K, V> f3612g;

        public c(K k2, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k2, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3610e = k2;
            this.f3611f = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof c) {
                    c cVar = (c) obj;
                    return this.f3610e.equals(cVar.f3610e) && this.f3611f.equals(cVar.f3611f);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3610e : (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3611f : (V) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, v)) == null) {
                throw new UnsupportedOperationException("An entry modification is not supported");
            }
            return (V) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.f3610e + "=" + this.f3611f;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e<K, V> implements Object<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c<K, V> f3616e;

        /* renamed from: f  reason: collision with root package name */
        public c<K, V> f3617f;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3616e = cVar2;
            this.f3617f = cVar;
        }

        public abstract c<K, V> a(c<K, V> cVar);

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c<K, V> cVar = this.f3617f;
                this.f3617f = c();
                return cVar;
            }
            return (Map.Entry) invokeV.objValue;
        }

        public final c<K, V> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                c<K, V> cVar = this.f3617f;
                c<K, V> cVar2 = this.f3616e;
                if (cVar == cVar2 || cVar2 == null) {
                    return null;
                }
                return a(cVar);
            }
            return (c) invokeV.objValue;
        }

        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3617f != null : invokeV.booleanValue;
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3608g = new WeakHashMap<>();
        this.f3609h = 0;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3609h : invokeV.intValue;
    }

    public c<K, V> d(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k2)) == null) {
            c<K, V> cVar = this.f3606e;
            while (cVar != null && !cVar.f3610e.equals(k2)) {
                cVar = cVar.f3612g;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public V e(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k2, v)) == null) {
            c<K, V> d2 = d(k2);
            if (d2 != null) {
                return d2.f3611f;
            }
            f(k2, v);
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (b() != dVar.b()) {
                    return false;
                }
                Iterator<Map.Entry<K, V>> it = iterator();
                Iterator<Map.Entry<K, V>> it2 = dVar.iterator();
                while (it.hasNext() && it2.hasNext()) {
                    Map.Entry<K, V> next = it.next();
                    Map.Entry<K, V> next2 = it2.next();
                    if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                        return false;
                    }
                }
                return (it.hasNext() || it2.hasNext()) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public c<K, V> f(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k2, v)) == null) {
            c<K, V> cVar = new c<>(k2, v);
            this.f3609h++;
            c<K, V> cVar2 = this.f3607f;
            if (cVar2 == null) {
                this.f3606e = cVar;
                this.f3607f = cVar;
                return cVar;
            }
            cVar2.f3612g = cVar;
            this.f3607f = cVar;
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    public d<K, V>.C0148d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d<K, V>.C0148d c0148d = new C0148d(this, null);
            this.f3608g.put(c0148d, Boolean.FALSE);
            return c0148d;
        }
        return (C0148d) invokeV.objValue;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b bVar = new b(this.f3606e, this.f3607f);
            this.f3608g.put(bVar, Boolean.FALSE);
            return bVar;
        }
        return (Iterator) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            Iterator<Map.Entry<K, V>> it = iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString());
                if (it.hasNext()) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    /* renamed from: c.a.j.h.c.c.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0148d implements Object<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c<K, V> f3613e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f3614f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f3615g;

        public C0148d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3615g = dVar;
            this.f3614f = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f3614f) {
                    this.f3614f = false;
                    this.f3613e = this.f3615g.f3606e;
                } else {
                    c<K, V> cVar = this.f3613e;
                    this.f3613e = cVar != null ? cVar.f3612g : null;
                }
                return this.f3613e;
            }
            return (Map.Entry) invokeV.objValue;
        }

        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f3614f) {
                    return this.f3615g.f3606e != null;
                }
                c<K, V> cVar = this.f3613e;
                return (cVar == null || cVar.f3612g == null) ? false : true;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ C0148d(d dVar, a aVar) {
            this(dVar);
        }
    }
}
