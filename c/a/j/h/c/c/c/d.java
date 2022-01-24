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
    public c<K, V> f4113e;

    /* renamed from: f  reason: collision with root package name */
    public c<K, V> f4114f;

    /* renamed from: g  reason: collision with root package name */
    public WeakHashMap<Object<K, V>, Boolean> f4115g;

    /* renamed from: h  reason: collision with root package name */
    public int f4116h;

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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? cVar.f4119g : (c) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f4117e;

        /* renamed from: f  reason: collision with root package name */
        public final V f4118f;

        /* renamed from: g  reason: collision with root package name */
        public c<K, V> f4119g;

        public c(K k, V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4117e = k;
            this.f4118f = v;
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
                    return this.f4117e.equals(cVar.f4117e) && this.f4118f.equals(cVar.f4118f);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f4117e : (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f4118f : (V) invokeV.objValue;
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
                return this.f4117e + "=" + this.f4118f;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e<K, V> implements Object<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c<K, V> f4123e;

        /* renamed from: f  reason: collision with root package name */
        public c<K, V> f4124f;

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
            this.f4123e = cVar2;
            this.f4124f = cVar;
        }

        public abstract c<K, V> a(c<K, V> cVar);

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: b */
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c<K, V> cVar = this.f4124f;
                this.f4124f = c();
                return cVar;
            }
            return (Map.Entry) invokeV.objValue;
        }

        public final c<K, V> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                c<K, V> cVar = this.f4124f;
                c<K, V> cVar2 = this.f4123e;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f4124f != null : invokeV.booleanValue;
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
        this.f4115g = new WeakHashMap<>();
        this.f4116h = 0;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4116h : invokeV.intValue;
    }

    public c<K, V> d(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) {
            c<K, V> cVar = this.f4113e;
            while (cVar != null && !cVar.f4117e.equals(k)) {
                cVar = cVar.f4119g;
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public V e(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k, v)) == null) {
            c<K, V> d2 = d(k);
            if (d2 != null) {
                return d2.f4118f;
            }
            f(k, v);
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

    public c<K, V> f(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k, v)) == null) {
            c<K, V> cVar = new c<>(k, v);
            this.f4116h++;
            c<K, V> cVar2 = this.f4114f;
            if (cVar2 == null) {
                this.f4113e = cVar;
                this.f4114f = cVar;
                return cVar;
            }
            cVar2.f4119g = cVar;
            this.f4114f = cVar;
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    public d<K, V>.C0187d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d<K, V>.C0187d c0187d = new C0187d(this, null);
            this.f4115g.put(c0187d, Boolean.FALSE);
            return c0187d;
        }
        return (C0187d) invokeV.objValue;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b bVar = new b(this.f4113e, this.f4114f);
            this.f4115g.put(bVar, Boolean.FALSE);
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
    public class C0187d implements Object<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c<K, V> f4120e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f4121f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f4122g;

        public C0187d(d dVar) {
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
            this.f4122g = dVar;
            this.f4121f = true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f4121f) {
                    this.f4121f = false;
                    this.f4120e = this.f4122g.f4113e;
                } else {
                    c<K, V> cVar = this.f4120e;
                    this.f4120e = cVar != null ? cVar.f4119g : null;
                }
                return this.f4120e;
            }
            return (Map.Entry) invokeV.objValue;
        }

        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f4121f) {
                    return this.f4122g.f4113e != null;
                }
                c<K, V> cVar = this.f4120e;
                return (cVar == null || cVar.f4119g == null) ? false : true;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ C0187d(d dVar, a aVar) {
            this(dVar);
        }
    }
}
