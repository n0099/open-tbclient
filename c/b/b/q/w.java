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
/* loaded from: classes3.dex */
public class w<K, V> implements Iterable<b<K, V>> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object n;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public K[] f22858b;

    /* renamed from: c  reason: collision with root package name */
    public V[] f22859c;

    /* renamed from: d  reason: collision with root package name */
    public float f22860d;

    /* renamed from: e  reason: collision with root package name */
    public int f22861e;

    /* renamed from: f  reason: collision with root package name */
    public int f22862f;

    /* renamed from: g  reason: collision with root package name */
    public int f22863g;

    /* renamed from: h  reason: collision with root package name */
    public transient a f22864h;
    public transient a i;
    public transient e j;
    public transient e k;
    public transient c l;
    public transient c m;

    /* loaded from: classes3.dex */
    public static class a<K, V> extends d<K, V, b<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public b<K, V> f22865f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w<K, V> wVar) {
            super(wVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((w) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22865f = new b<>();
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
                if (this.a) {
                    if (this.f22870e) {
                        w<K, V> wVar = this.f22867b;
                        K[] kArr = wVar.f22858b;
                        b<K, V> bVar = this.f22865f;
                        int i = this.f22868c;
                        bVar.a = kArr[i];
                        bVar.f22866b = wVar.f22859c[i];
                        this.f22869d = i;
                        b();
                        return this.f22865f;
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
                if (this.f22870e) {
                    return this.a;
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
        public V f22866b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a + "=" + this.f22866b;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f(new c.b.b.q.a<>(true, this.f22867b.a)) : (c.b.b.q.a) invokeV.objValue;
        }

        public c.b.b.q.a<K> f(c.b.b.q.a<K> aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                while (this.a) {
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
                if (this.f22870e) {
                    return this.a;
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
                if (this.a) {
                    if (this.f22870e) {
                        K[] kArr = this.f22867b.f22858b;
                        int i = this.f22868c;
                        K k = kArr[i];
                        this.f22869d = i;
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
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final w<K, V> f22867b;

        /* renamed from: c  reason: collision with root package name */
        public int f22868c;

        /* renamed from: d  reason: collision with root package name */
        public int f22869d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22870e;

        public d(w<K, V> wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22870e = true;
            this.f22867b = wVar;
            c();
        }

        public void b() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                K[] kArr = this.f22867b.f22858b;
                int length = kArr.length;
                do {
                    i = this.f22868c + 1;
                    this.f22868c = i;
                    if (i >= length) {
                        this.a = false;
                        return;
                    }
                } while (kArr[i] == null);
                this.a = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f22869d = -1;
                this.f22868c = -1;
                b();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.f22869d;
                if (i >= 0) {
                    w<K, V> wVar = this.f22867b;
                    K[] kArr = wVar.f22858b;
                    V[] vArr = wVar.f22859c;
                    int i2 = wVar.f22863g;
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3 & i2;
                        K k = kArr[i4];
                        if (k == null) {
                            break;
                        }
                        int h2 = this.f22867b.h(k);
                        if (((i4 - h2) & i2) > ((i - h2) & i2)) {
                            kArr[i] = k;
                            vArr[i] = vArr[i4];
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    kArr[i] = null;
                    vArr[i] = null;
                    w<K, V> wVar2 = this.f22867b;
                    wVar2.a--;
                    if (i != this.f22869d) {
                        this.f22868c--;
                    }
                    this.f22869d = -1;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (this.f22870e) {
                    return this.a;
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
                if (this.a) {
                    if (this.f22870e) {
                        V[] vArr = this.f22867b.f22859c;
                        int i = this.f22868c;
                        V v = vArr[i];
                        this.f22869d = i;
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
        n = new Object();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w() {
        this(51, 0.8f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (this.f22864h == null) {
                this.f22864h = new a(this);
                this.i = new a(this);
            }
            a aVar = this.f22864h;
            if (!aVar.f22870e) {
                aVar.c();
                a<K, V> aVar2 = this.f22864h;
                aVar2.f22870e = true;
                this.i.f22870e = false;
                return aVar2;
            }
            this.i.c();
            a<K, V> aVar3 = this.i;
            aVar3.f22870e = true;
            this.f22864h.f22870e = false;
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
            return this.f22859c[g2];
        }
        return (V) invokeL.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a == 0) {
            return;
        }
        this.a = 0;
        Arrays.fill(this.f22858b, (Object) null);
        Arrays.fill(this.f22859c, (Object) null);
    }

    public V d(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k, v)) == null) {
            int g2 = g(k);
            return g2 < 0 ? v : this.f22859c[g2];
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
                if (wVar.a != this.a) {
                    return false;
                }
                K[] kArr = this.f22858b;
                V[] vArr = this.f22859c;
                int length = kArr.length;
                for (int i = 0; i < length; i++) {
                    K k = kArr[i];
                    if (k != null) {
                        V v = vArr[i];
                        if (v == null) {
                            if (wVar.d(k, n) != null) {
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
            if (this.l == null) {
                this.l = new c(this);
                this.m = new c(this);
            }
            c cVar = this.l;
            if (!cVar.f22870e) {
                cVar.c();
                c<K> cVar2 = this.l;
                cVar2.f22870e = true;
                this.m.f22870e = false;
                return cVar2;
            }
            this.m.c();
            c<K> cVar3 = this.m;
            cVar3.f22870e = true;
            this.l.f22870e = false;
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
            K[] kArr = this.f22858b;
            int h2 = h(k);
            while (true) {
                K k2 = kArr[h2];
                if (k2 == null) {
                    return -(h2 + 1);
                }
                if (k2.equals(k)) {
                    return h2;
                }
                h2 = (h2 + 1) & this.f22863g;
            }
        } else {
            throw new IllegalArgumentException("key cannot be null.");
        }
    }

    public int h(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k)) == null) ? (int) ((k.hashCode() * (-7046029254386353131L)) >>> this.f22862f) : invokeL.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.a;
            K[] kArr = this.f22858b;
            V[] vArr = this.f22859c;
            int length = kArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                K k = kArr[i2];
                if (k != null) {
                    i += k.hashCode();
                    V v = vArr[i2];
                    if (v != null) {
                        i += v.hashCode();
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public V i(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, k, v)) == null) {
            int g2 = g(k);
            if (g2 >= 0) {
                V[] vArr = this.f22859c;
                V v2 = vArr[g2];
                vArr[g2] = v;
                return v2;
            }
            int i = -(g2 + 1);
            K[] kArr = this.f22858b;
            kArr[i] = k;
            this.f22859c[i] = v;
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 >= this.f22861e) {
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
            K[] kArr = this.f22858b;
            int h2 = h(k);
            while (kArr[h2] != null) {
                h2 = (h2 + 1) & this.f22863g;
            }
            kArr[h2] = k;
            this.f22859c[h2] = v;
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
        K[] kArr = this.f22858b;
        V[] vArr = this.f22859c;
        V v = vArr[g2];
        int i = this.f22863g;
        int i2 = g2 + 1;
        while (true) {
            int i3 = i2 & i;
            K k2 = kArr[i3];
            if (k2 != null) {
                int h2 = h(k2);
                if (((i3 - h2) & i) > ((g2 - h2) & i)) {
                    kArr[g2] = k2;
                    vArr[g2] = vArr[i3];
                    g2 = i3;
                }
                i2 = i3 + 1;
            } else {
                kArr[g2] = null;
                vArr[g2] = null;
                this.a--;
                return v;
            }
        }
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            int length = this.f22858b.length;
            this.f22861e = (int) (i * this.f22860d);
            int i2 = i - 1;
            this.f22863g = i2;
            this.f22862f = Long.numberOfLeadingZeros(i2);
            K[] kArr = this.f22858b;
            V[] vArr = this.f22859c;
            this.f22858b = (K[]) new Object[i];
            this.f22859c = (V[]) new Object[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    K k = kArr[i3];
                    if (k != null) {
                        j(k, vArr[i3]);
                    }
                }
            }
        }
    }

    public String m(String str, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, str, z)) == null) {
            if (this.a == 0) {
                return z ? StringUtil.EMPTY_ARRAY : "";
            }
            StringBuilder sb = new StringBuilder(32);
            if (z) {
                sb.append('{');
            }
            K[] kArr = this.f22858b;
            Object[] objArr = this.f22859c;
            int length = kArr.length;
            while (true) {
                i = length - 1;
                if (length <= 0) {
                    break;
                }
                K k = kArr[i];
                if (k == null) {
                    length = i;
                } else {
                    if (k == this) {
                        k = "(this)";
                    }
                    sb.append(k);
                    sb.append('=');
                    Object obj = objArr[i];
                    if (obj == this) {
                        obj = "(this)";
                    }
                    sb.append(obj);
                }
            }
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                K k2 = kArr[i2];
                if (k2 != null) {
                    sb.append(str);
                    if (k2 == this) {
                        k2 = "(this)";
                    }
                    sb.append(k2);
                    sb.append('=');
                    Object obj2 = objArr[i2];
                    if (obj2 == this) {
                        obj2 = "(this)";
                    }
                    sb.append(obj2);
                }
                i = i2;
            }
            if (z) {
                sb.append('}');
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
            if (this.j == null) {
                this.j = new e(this);
                this.k = new e(this);
            }
            e eVar = this.j;
            if (!eVar.f22870e) {
                eVar.c();
                e<V> eVar2 = this.j;
                eVar2.f22870e = true;
                this.k.f22870e = false;
                return eVar2;
            }
            this.k.c();
            e<V> eVar3 = this.k;
            eVar3.f22870e = true;
            this.j.f22870e = false;
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
    public w(int i) {
        this(i, 0.8f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public w(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Float.valueOf(f2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f22860d = f2;
            int h2 = x.h(i, f2);
            this.f22861e = (int) (h2 * f2);
            int i4 = h2 - 1;
            this.f22863g = i4;
            this.f22862f = Long.numberOfLeadingZeros(i4);
            this.f22858b = (K[]) new Object[h2];
            this.f22859c = (V[]) new Object[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
