package c.a.o0.o.a.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class a<K, V> extends f<K, V> implements Map<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e<K, V> l;

    /* renamed from: c.a.o0.o.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0625a extends e<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f12135d;

        public C0625a(a aVar) {
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
            this.f12135d = aVar;
        }

        @Override // c.a.o0.o.a.c.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12135d.clear();
            }
        }

        @Override // c.a.o0.o.a.c.e
        public Object b(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) ? this.f12135d.f12159f[(i2 << 1) + i3] : invokeII.objValue;
        }

        @Override // c.a.o0.o.a.c.e
        public Map<K, V> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f12135d : (Map) invokeV.objValue;
        }

        @Override // c.a.o0.o.a.c.e
        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12135d.f12160g : invokeV.intValue;
        }

        @Override // c.a.o0.o.a.c.e
        public int e(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? this.f12135d.e(obj) : invokeL.intValue;
        }

        @Override // c.a.o0.o.a.c.e
        public int f(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? this.f12135d.g(obj) : invokeL.intValue;
        }

        @Override // c.a.o0.o.a.c.e
        public void g(K k, V v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, k, v) == null) {
                this.f12135d.put(k, v);
            }
        }

        @Override // c.a.o0.o.a.c.e
        public void h(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                this.f12135d.i(i2);
            }
        }

        @Override // c.a.o0.o.a.c.e
        public V i(int i2, V v) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, v)) == null) ? this.f12135d.j(i2, v) : (V) invokeIL.objValue;
        }
    }

    public a() {
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

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? l().l() : (Set) invokeV.objValue;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l().m() : (Set) invokeV.objValue;
    }

    public final e<K, V> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.l == null) {
                this.l = new C0625a(this);
            }
            return this.l;
        }
        return (e) invokeV.objValue;
    }

    public boolean m(Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, collection)) == null) ? e.p(this, collection) : invokeL.booleanValue;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, map) == null) {
            b(this.f12160g + map.size());
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? l().n() : (Collection) invokeV.objValue;
    }
}
