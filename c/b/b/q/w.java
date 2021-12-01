package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes7.dex */
public class w<K, V> implements Iterable<b<K, V>> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f27931e;

    /* renamed from: f  reason: collision with root package name */
    public K[] f27932f;

    /* renamed from: g  reason: collision with root package name */
    public V[] f27933g;

    /* renamed from: h  reason: collision with root package name */
    public float f27934h;

    /* renamed from: i  reason: collision with root package name */
    public int f27935i;

    /* renamed from: j  reason: collision with root package name */
    public int f27936j;

    /* renamed from: k  reason: collision with root package name */
    public int f27937k;
    public transient a l;
    public transient a m;
    public transient e n;
    public transient e o;
    public transient c p;
    public transient c q;

    /* loaded from: classes7.dex */
    public static class a<K, V> extends d<K, V, b<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public b<K, V> f27938j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w<K, V> wVar) {
            super(wVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((w) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27938j = new b<>();
        }

        public a<K, V> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: e */
        public b<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f27940e) {
                    if (this.f27944i) {
                        w<K, V> wVar = this.f27941f;
                        K[] kArr = wVar.f27932f;
                        b<K, V> bVar = this.f27938j;
                        int i2 = this.f27942g;
                        bVar.a = kArr[i2];
                        bVar.f27939b = wVar.f27933g[i2];
                        this.f27943h = i2;
                        b();
                        return this.f27938j;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (b) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f27944i) {
                    return this.f27940e;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            d();
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public static class b<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public K a;

        /* renamed from: b  reason: collision with root package name */
        public V f27939b;

        public b() {
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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a + "=" + this.f27939b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c<K> extends d<K, Object, K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(w<K, ?> wVar) {
            super(wVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((w) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public c<K> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (c) invokeV.objValue;
        }

        public c.b.b.q.a<K> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f(new c.b.b.q.a<>(true, this.f27941f.f27931e)) : (c.b.b.q.a) invokeV.objValue;
        }

        public c.b.b.q.a<K> f(c.b.b.q.a<K> aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                while (this.f27940e) {
                    aVar.a(next());
                }
                return aVar;
            }
            return (c.b.b.q.a) invokeL.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f27944i) {
                    return this.f27940e;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            d();
            return this;
        }

        @Override // java.util.Iterator
        public K next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f27940e) {
                    if (this.f27944i) {
                        K[] kArr = this.f27941f.f27932f;
                        int i2 = this.f27942g;
                        K k2 = kArr[i2];
                        this.f27943h = i2;
                        b();
                        return k2;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (K) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class d<K, V, I> implements Iterable<I>, Iterator<I> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27940e;

        /* renamed from: f  reason: collision with root package name */
        public final w<K, V> f27941f;

        /* renamed from: g  reason: collision with root package name */
        public int f27942g;

        /* renamed from: h  reason: collision with root package name */
        public int f27943h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f27944i;

        public d(w<K, V> wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27944i = true;
            this.f27941f = wVar;
            c();
        }

        public void b() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                K[] kArr = this.f27941f.f27932f;
                int length = kArr.length;
                do {
                    i2 = this.f27942g + 1;
                    this.f27942g = i2;
                    if (i2 >= length) {
                        this.f27940e = false;
                        return;
                    }
                } while (kArr[i2] == null);
                this.f27940e = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f27943h = -1;
                this.f27942g = -1;
                b();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = this.f27943h;
                if (i2 >= 0) {
                    w<K, V> wVar = this.f27941f;
                    K[] kArr = wVar.f27932f;
                    V[] vArr = wVar.f27933g;
                    int i3 = wVar.f27937k;
                    int i4 = i2 + 1;
                    while (true) {
                        int i5 = i4 & i3;
                        K k2 = kArr[i5];
                        if (k2 == null) {
                            break;
                        }
                        int h2 = this.f27941f.h(k2);
                        if (((i5 - h2) & i3) > ((i2 - h2) & i3)) {
                            kArr[i2] = k2;
                            vArr[i2] = vArr[i5];
                            i2 = i5;
                        }
                        i4 = i5 + 1;
                    }
                    kArr[i2] = null;
                    vArr[i2] = null;
                    w<K, V> wVar2 = this.f27941f;
                    wVar2.f27931e--;
                    if (i2 != this.f27943h) {
                        this.f27942g--;
                    }
                    this.f27943h = -1;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e<V> extends d<Object, V, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(w<?, V> wVar) {
            super(wVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((w) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public e<V> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (e) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f27944i) {
                    return this.f27940e;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            d();
            return this;
        }

        @Override // java.util.Iterator
        public V next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f27940e) {
                    if (this.f27944i) {
                        V[] vArr = this.f27941f.f27933g;
                        int i2 = this.f27942g;
                        V v = vArr[i2];
                        this.f27943h = i2;
                        b();
                        return v;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (V) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(156867156, "Lc/b/b/q/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(156867156, "Lc/b/b/q/w;");
                return;
            }
        }
        r = new Object();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w() {
        this(51, 0.8f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public boolean a(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k2)) == null) ? g(k2) >= 0 : invokeL.booleanValue;
    }

    public a<K, V> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (f.a) {
                return new a<>(this);
            }
            if (this.l == null) {
                this.l = new a(this);
                this.m = new a(this);
            }
            a aVar = this.l;
            if (!aVar.f27944i) {
                aVar.c();
                a<K, V> aVar2 = this.l;
                aVar2.f27944i = true;
                this.m.f27944i = false;
                return aVar2;
            }
            this.m.c();
            a<K, V> aVar3 = this.m;
            aVar3.f27944i = true;
            this.l.f27944i = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T extends K */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends K> V c(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            int g2 = g(t);
            if (g2 < 0) {
                return null;
            }
            return this.f27933g[g2];
        }
        return (V) invokeL.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f27931e == 0) {
            return;
        }
        this.f27931e = 0;
        Arrays.fill(this.f27932f, (Object) null);
        Arrays.fill(this.f27933g, (Object) null);
    }

    public V d(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k2, v)) == null) {
            int g2 = g(k2);
            return g2 < 0 ? v : this.f27933g[g2];
        }
        return (V) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: e */
    public a<K, V> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? b() : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v1, resolved type: c.b.b.q.w */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof w) {
                w wVar = (w) obj;
                if (wVar.f27931e != this.f27931e) {
                    return false;
                }
                K[] kArr = this.f27932f;
                V[] vArr = this.f27933g;
                int length = kArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    K k2 = kArr[i2];
                    if (k2 != null) {
                        V v = vArr[i2];
                        if (v == null) {
                            if (wVar.d(k2, r) != null) {
                                return false;
                            }
                        } else if (!v.equals(wVar.c(k2))) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public c<K> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (f.a) {
                return new c<>(this);
            }
            if (this.p == null) {
                this.p = new c(this);
                this.q = new c(this);
            }
            c cVar = this.p;
            if (!cVar.f27944i) {
                cVar.c();
                c<K> cVar2 = this.p;
                cVar2.f27944i = true;
                this.q.f27944i = false;
                return cVar2;
            }
            this.q.c();
            c<K> cVar3 = this.q;
            cVar3.f27944i = true;
            this.p.f27944i = false;
            return cVar3;
        }
        return (c) invokeV.objValue;
    }

    public int g(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k2)) != null) {
            return invokeL.intValue;
        }
        if (k2 != null) {
            K[] kArr = this.f27932f;
            int h2 = h(k2);
            while (true) {
                K k3 = kArr[h2];
                if (k3 == null) {
                    return -(h2 + 1);
                }
                if (k3.equals(k2)) {
                    return h2;
                }
                h2 = (h2 + 1) & this.f27937k;
            }
        } else {
            throw new IllegalArgumentException("key cannot be null.");
        }
    }

    public int h(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k2)) == null) ? (int) ((k2.hashCode() * (-7046029254386353131L)) >>> this.f27936j) : invokeL.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.f27931e;
            K[] kArr = this.f27932f;
            V[] vArr = this.f27933g;
            int length = kArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                K k2 = kArr[i3];
                if (k2 != null) {
                    i2 += k2.hashCode();
                    V v = vArr[i3];
                    if (v != null) {
                        i2 += v.hashCode();
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public V i(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, k2, v)) == null) {
            int g2 = g(k2);
            if (g2 >= 0) {
                V[] vArr = this.f27933g;
                V v2 = vArr[g2];
                vArr[g2] = v;
                return v2;
            }
            int i2 = -(g2 + 1);
            K[] kArr = this.f27932f;
            kArr[i2] = k2;
            this.f27933g[i2] = v;
            int i3 = this.f27931e + 1;
            this.f27931e = i3;
            if (i3 >= this.f27935i) {
                l(kArr.length << 1);
                return null;
            }
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public final void j(K k2, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, k2, v) == null) {
            K[] kArr = this.f27932f;
            int h2 = h(k2);
            while (kArr[h2] != null) {
                h2 = (h2 + 1) & this.f27937k;
            }
            kArr[h2] = k2;
            this.f27933g[h2] = v;
        }
    }

    public V k(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048590, this, k2)) != null) {
            return (V) invokeL.objValue;
        }
        int g2 = g(k2);
        if (g2 < 0) {
            return null;
        }
        K[] kArr = this.f27932f;
        V[] vArr = this.f27933g;
        V v = vArr[g2];
        int i2 = this.f27937k;
        int i3 = g2 + 1;
        while (true) {
            int i4 = i3 & i2;
            K k3 = kArr[i4];
            if (k3 != null) {
                int h2 = h(k3);
                if (((i4 - h2) & i2) > ((g2 - h2) & i2)) {
                    kArr[g2] = k3;
                    vArr[g2] = vArr[i4];
                    g2 = i4;
                }
                i3 = i4 + 1;
            } else {
                kArr[g2] = null;
                vArr[g2] = null;
                this.f27931e--;
                return v;
            }
        }
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            int length = this.f27932f.length;
            this.f27935i = (int) (i2 * this.f27934h);
            int i3 = i2 - 1;
            this.f27937k = i3;
            this.f27936j = Long.numberOfLeadingZeros(i3);
            K[] kArr = this.f27932f;
            V[] vArr = this.f27933g;
            this.f27932f = (K[]) new Object[i2];
            this.f27933g = (V[]) new Object[i2];
            if (this.f27931e > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    K k2 = kArr[i4];
                    if (k2 != null) {
                        j(k2, vArr[i4]);
                    }
                }
            }
        }
    }

    public String m(String str, boolean z) {
        InterceptResult invokeLZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) {
            if (this.f27931e == 0) {
                return z ? StringUtil.EMPTY_ARRAY : "";
            }
            StringBuilder sb = new StringBuilder(32);
            if (z) {
                sb.append(ExtendedMessageFormat.START_FE);
            }
            K[] kArr = this.f27932f;
            Object[] objArr = this.f27933g;
            int length = kArr.length;
            while (true) {
                i2 = length - 1;
                if (length <= 0) {
                    break;
                }
                K k2 = kArr[i2];
                if (k2 == null) {
                    length = i2;
                } else {
                    if (k2 == this) {
                        k2 = "(this)";
                    }
                    sb.append(k2);
                    sb.append(com.alipay.sdk.encrypt.a.f31351h);
                    Object obj = objArr[i2];
                    if (obj == this) {
                        obj = "(this)";
                    }
                    sb.append(obj);
                }
            }
            while (true) {
                int i3 = i2 - 1;
                if (i2 <= 0) {
                    break;
                }
                K k3 = kArr[i3];
                if (k3 != null) {
                    sb.append(str);
                    if (k3 == this) {
                        k3 = "(this)";
                    }
                    sb.append(k3);
                    sb.append(com.alipay.sdk.encrypt.a.f31351h);
                    Object obj2 = objArr[i3];
                    if (obj2 == this) {
                        obj2 = "(this)";
                    }
                    sb.append(obj2);
                }
                i2 = i3;
            }
            if (z) {
                sb.append(ExtendedMessageFormat.END_FE);
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public e<V> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (f.a) {
                return new e<>(this);
            }
            if (this.n == null) {
                this.n = new e(this);
                this.o = new e(this);
            }
            e eVar = this.n;
            if (!eVar.f27944i) {
                eVar.c();
                e<V> eVar2 = this.n;
                eVar2.f27944i = true;
                this.o.f27944i = false;
                return eVar2;
            }
            this.o.c();
            e<V> eVar3 = this.o;
            eVar3.f27944i = true;
            this.n.f27944i = false;
            return eVar3;
        }
        return (e) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? m(StringUtil.ARRAY_ELEMENT_SEPARATOR, true) : (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w(int i2) {
        this(i2, 0.8f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public w(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f27934h = f2;
            int h2 = x.h(i2, f2);
            this.f27935i = (int) (h2 * f2);
            int i5 = h2 - 1;
            this.f27937k = i5;
            this.f27936j = Long.numberOfLeadingZeros(i5);
            this.f27932f = (K[]) new Object[h2];
            this.f27933g = (V[]) new Object[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
