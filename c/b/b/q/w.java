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
/* loaded from: classes3.dex */
public class w<K, V> implements Iterable<b<K, V>> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f27655e;

    /* renamed from: f  reason: collision with root package name */
    public K[] f27656f;

    /* renamed from: g  reason: collision with root package name */
    public V[] f27657g;

    /* renamed from: h  reason: collision with root package name */
    public float f27658h;

    /* renamed from: i  reason: collision with root package name */
    public int f27659i;

    /* renamed from: j  reason: collision with root package name */
    public int f27660j;
    public int k;
    public transient a l;
    public transient a m;
    public transient e n;
    public transient e o;
    public transient c p;
    public transient c q;

    /* loaded from: classes3.dex */
    public static class a<K, V> extends d<K, V, b<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public b<K, V> f27661j;

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
            this.f27661j = new b<>();
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
                if (this.f27663e) {
                    if (this.f27667i) {
                        w<K, V> wVar = this.f27664f;
                        K[] kArr = wVar.f27656f;
                        b<K, V> bVar = this.f27661j;
                        int i2 = this.f27665g;
                        bVar.a = kArr[i2];
                        bVar.f27662b = wVar.f27657g[i2];
                        this.f27666h = i2;
                        b();
                        return this.f27661j;
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
                if (this.f27667i) {
                    return this.f27663e;
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

    /* loaded from: classes3.dex */
    public static class b<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public K a;

        /* renamed from: b  reason: collision with root package name */
        public V f27662b;

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
                return this.a + "=" + this.f27662b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f(new c.b.b.q.a<>(true, this.f27664f.f27655e)) : (c.b.b.q.a) invokeV.objValue;
        }

        public c.b.b.q.a<K> f(c.b.b.q.a<K> aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                while (this.f27663e) {
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
                if (this.f27667i) {
                    return this.f27663e;
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
                if (this.f27663e) {
                    if (this.f27667i) {
                        K[] kArr = this.f27664f.f27656f;
                        int i2 = this.f27665g;
                        K k = kArr[i2];
                        this.f27666h = i2;
                        b();
                        return k;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (K) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d<K, V, I> implements Iterable<I>, Iterator<I> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27663e;

        /* renamed from: f  reason: collision with root package name */
        public final w<K, V> f27664f;

        /* renamed from: g  reason: collision with root package name */
        public int f27665g;

        /* renamed from: h  reason: collision with root package name */
        public int f27666h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f27667i;

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
            this.f27667i = true;
            this.f27664f = wVar;
            c();
        }

        public void b() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                K[] kArr = this.f27664f.f27656f;
                int length = kArr.length;
                do {
                    i2 = this.f27665g + 1;
                    this.f27665g = i2;
                    if (i2 >= length) {
                        this.f27663e = false;
                        return;
                    }
                } while (kArr[i2] == null);
                this.f27663e = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f27666h = -1;
                this.f27665g = -1;
                b();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = this.f27666h;
                if (i2 >= 0) {
                    w<K, V> wVar = this.f27664f;
                    K[] kArr = wVar.f27656f;
                    V[] vArr = wVar.f27657g;
                    int i3 = wVar.k;
                    int i4 = i2 + 1;
                    while (true) {
                        int i5 = i4 & i3;
                        K k = kArr[i5];
                        if (k == null) {
                            break;
                        }
                        int h2 = this.f27664f.h(k);
                        if (((i5 - h2) & i3) > ((i2 - h2) & i3)) {
                            kArr[i2] = k;
                            vArr[i2] = vArr[i5];
                            i2 = i5;
                        }
                        i4 = i5 + 1;
                    }
                    kArr[i2] = null;
                    vArr[i2] = null;
                    w<K, V> wVar2 = this.f27664f;
                    wVar2.f27655e--;
                    if (i2 != this.f27666h) {
                        this.f27665g--;
                    }
                    this.f27666h = -1;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (this.f27667i) {
                    return this.f27663e;
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
                if (this.f27663e) {
                    if (this.f27667i) {
                        V[] vArr = this.f27664f.f27657g;
                        int i2 = this.f27665g;
                        V v = vArr[i2];
                        this.f27666h = i2;
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

    public boolean a(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) ? g(k) >= 0 : invokeL.booleanValue;
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
            if (!aVar.f27667i) {
                aVar.c();
                a<K, V> aVar2 = this.l;
                aVar2.f27667i = true;
                this.m.f27667i = false;
                return aVar2;
            }
            this.m.c();
            a<K, V> aVar3 = this.m;
            aVar3.f27667i = true;
            this.l.f27667i = false;
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
            return this.f27657g[g2];
        }
        return (V) invokeL.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f27655e == 0) {
            return;
        }
        this.f27655e = 0;
        Arrays.fill(this.f27656f, (Object) null);
        Arrays.fill(this.f27657g, (Object) null);
    }

    public V d(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k, v)) == null) {
            int g2 = g(k);
            return g2 < 0 ? v : this.f27657g[g2];
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
                if (wVar.f27655e != this.f27655e) {
                    return false;
                }
                K[] kArr = this.f27656f;
                V[] vArr = this.f27657g;
                int length = kArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    K k = kArr[i2];
                    if (k != null) {
                        V v = vArr[i2];
                        if (v == null) {
                            if (wVar.d(k, r) != null) {
                                return false;
                            }
                        } else if (!v.equals(wVar.c(k))) {
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
            if (!cVar.f27667i) {
                cVar.c();
                c<K> cVar2 = this.p;
                cVar2.f27667i = true;
                this.q.f27667i = false;
                return cVar2;
            }
            this.q.c();
            c<K> cVar3 = this.q;
            cVar3.f27667i = true;
            this.p.f27667i = false;
            return cVar3;
        }
        return (c) invokeV.objValue;
    }

    public int g(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k)) != null) {
            return invokeL.intValue;
        }
        if (k != null) {
            K[] kArr = this.f27656f;
            int h2 = h(k);
            while (true) {
                K k2 = kArr[h2];
                if (k2 == null) {
                    return -(h2 + 1);
                }
                if (k2.equals(k)) {
                    return h2;
                }
                h2 = (h2 + 1) & this.k;
            }
        } else {
            throw new IllegalArgumentException("key cannot be null.");
        }
    }

    public int h(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k)) == null) ? (int) ((k.hashCode() * (-7046029254386353131L)) >>> this.f27660j) : invokeL.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.f27655e;
            K[] kArr = this.f27656f;
            V[] vArr = this.f27657g;
            int length = kArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                K k = kArr[i3];
                if (k != null) {
                    i2 += k.hashCode();
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

    public V i(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, k, v)) == null) {
            int g2 = g(k);
            if (g2 >= 0) {
                V[] vArr = this.f27657g;
                V v2 = vArr[g2];
                vArr[g2] = v;
                return v2;
            }
            int i2 = -(g2 + 1);
            K[] kArr = this.f27656f;
            kArr[i2] = k;
            this.f27657g[i2] = v;
            int i3 = this.f27655e + 1;
            this.f27655e = i3;
            if (i3 >= this.f27659i) {
                l(kArr.length << 1);
                return null;
            }
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public final void j(K k, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, k, v) == null) {
            K[] kArr = this.f27656f;
            int h2 = h(k);
            while (kArr[h2] != null) {
                h2 = (h2 + 1) & this.k;
            }
            kArr[h2] = k;
            this.f27657g[h2] = v;
        }
    }

    public V k(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048590, this, k)) != null) {
            return (V) invokeL.objValue;
        }
        int g2 = g(k);
        if (g2 < 0) {
            return null;
        }
        K[] kArr = this.f27656f;
        V[] vArr = this.f27657g;
        V v = vArr[g2];
        int i2 = this.k;
        int i3 = g2 + 1;
        while (true) {
            int i4 = i3 & i2;
            K k2 = kArr[i4];
            if (k2 != null) {
                int h2 = h(k2);
                if (((i4 - h2) & i2) > ((g2 - h2) & i2)) {
                    kArr[g2] = k2;
                    vArr[g2] = vArr[i4];
                    g2 = i4;
                }
                i3 = i4 + 1;
            } else {
                kArr[g2] = null;
                vArr[g2] = null;
                this.f27655e--;
                return v;
            }
        }
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            int length = this.f27656f.length;
            this.f27659i = (int) (i2 * this.f27658h);
            int i3 = i2 - 1;
            this.k = i3;
            this.f27660j = Long.numberOfLeadingZeros(i3);
            K[] kArr = this.f27656f;
            V[] vArr = this.f27657g;
            this.f27656f = (K[]) new Object[i2];
            this.f27657g = (V[]) new Object[i2];
            if (this.f27655e > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    K k = kArr[i4];
                    if (k != null) {
                        j(k, vArr[i4]);
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
            if (this.f27655e == 0) {
                return z ? StringUtil.EMPTY_ARRAY : "";
            }
            StringBuilder sb = new StringBuilder(32);
            if (z) {
                sb.append(ExtendedMessageFormat.START_FE);
            }
            K[] kArr = this.f27656f;
            Object[] objArr = this.f27657g;
            int length = kArr.length;
            while (true) {
                i2 = length - 1;
                if (length <= 0) {
                    break;
                }
                K k = kArr[i2];
                if (k == null) {
                    length = i2;
                } else {
                    if (k == this) {
                        k = "(this)";
                    }
                    sb.append(k);
                    sb.append(com.alipay.sdk.encrypt.a.f29503h);
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
                K k2 = kArr[i3];
                if (k2 != null) {
                    sb.append(str);
                    if (k2 == this) {
                        k2 = "(this)";
                    }
                    sb.append(k2);
                    sb.append(com.alipay.sdk.encrypt.a.f29503h);
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
            if (!eVar.f27667i) {
                eVar.c();
                e<V> eVar2 = this.n;
                eVar2.f27667i = true;
                this.o.f27667i = false;
                return eVar2;
            }
            this.o.c();
            e<V> eVar3 = this.o;
            eVar3.f27667i = true;
            this.n.f27667i = false;
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
            this.f27658h = f2;
            int h2 = x.h(i2, f2);
            this.f27659i = (int) (h2 * f2);
            int i5 = h2 - 1;
            this.k = i5;
            this.f27660j = Long.numberOfLeadingZeros(i5);
            this.f27656f = (K[]) new Object[h2];
            this.f27657g = (V[]) new Object[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
