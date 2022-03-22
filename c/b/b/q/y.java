package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.w;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.NoSuchElementException;
/* loaded from: classes3.dex */
public class y<K, V> extends w<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.b.b.q.a<K> o;

    /* loaded from: classes3.dex */
    public static class a<K, V> extends w.a<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public c.b.b.q.a<K> f22882g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y<K, V> yVar) {
            super(yVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
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
            this.f22882g = yVar.o;
        }

        @Override // c.b.b.q.w.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22869d = -1;
                this.f22868c = 0;
                this.a = this.f22867b.a > 0;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.b.q.w.a, java.util.Iterator
        /* renamed from: e */
        public w.b next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a) {
                    if (this.f22870e) {
                        int i = this.f22868c;
                        this.f22869d = i;
                        this.f22865f.a = this.f22882g.get(i);
                        w.b<K, V> bVar = this.f22865f;
                        bVar.f22866b = this.f22867b.c(bVar.a);
                        int i2 = this.f22868c + 1;
                        this.f22868c = i2;
                        this.a = i2 < this.f22867b.a;
                        return this.f22865f;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (w.b) invokeV.objValue;
        }

        @Override // c.b.b.q.w.d, java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.f22869d >= 0) {
                    this.f22867b.k(this.f22865f.a);
                    this.f22868c--;
                    this.f22869d = -1;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b<K> extends w.c<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public c.b.b.q.a<K> f22883f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(y<K, ?> yVar) {
            super(yVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
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
            this.f22883f = yVar.o;
        }

        @Override // c.b.b.q.w.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22869d = -1;
                this.f22868c = 0;
                this.a = this.f22867b.a > 0;
            }
        }

        @Override // c.b.b.q.w.c
        public c.b.b.q.a<K> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c.b.b.q.a<K> aVar = new c.b.b.q.a<>(true, this.f22883f.f22717b - this.f22868c);
                f(aVar);
                return aVar;
            }
            return (c.b.b.q.a) invokeV.objValue;
        }

        @Override // c.b.b.q.w.c
        public c.b.b.q.a<K> f(c.b.b.q.a<K> aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
                c.b.b.q.a<K> aVar2 = this.f22883f;
                int i = this.f22868c;
                aVar.c(aVar2, i, aVar2.f22717b - i);
                this.f22868c = this.f22883f.f22717b;
                this.a = false;
                return aVar;
            }
            return (c.b.b.q.a) invokeL.objValue;
        }

        @Override // c.b.b.q.w.c, java.util.Iterator
        public K next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.a) {
                    if (this.f22870e) {
                        K k = this.f22883f.get(this.f22868c);
                        int i = this.f22868c;
                        this.f22869d = i;
                        int i2 = i + 1;
                        this.f22868c = i2;
                        this.a = i2 < this.f22867b.a;
                        return k;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (K) invokeV.objValue;
        }

        @Override // c.b.b.q.w.d, java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i = this.f22869d;
                if (i >= 0) {
                    ((y) this.f22867b).o(i);
                    this.f22868c = this.f22869d;
                    this.f22869d = -1;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c<V> extends w.e<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public c.b.b.q.a f22884f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(y<?, V> yVar) {
            super(yVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
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
            this.f22884f = yVar.o;
        }

        @Override // c.b.b.q.w.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22869d = -1;
                this.f22868c = 0;
                this.a = this.f22867b.a > 0;
            }
        }

        @Override // c.b.b.q.w.e, java.util.Iterator
        public V next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a) {
                    if (this.f22870e) {
                        V c2 = this.f22867b.c(this.f22884f.get(this.f22868c));
                        int i = this.f22868c;
                        this.f22869d = i;
                        int i2 = i + 1;
                        this.f22868c = i2;
                        this.a = i2 < this.f22867b.a;
                        return c2;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (V) invokeV.objValue;
        }

        @Override // c.b.b.q.w.d, java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.f22869d;
                if (i >= 0) {
                    ((y) this.f22867b).o(i);
                    this.f22868c = this.f22869d;
                    this.f22869d = -1;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    public y() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new c.b.b.q.a<>();
    }

    @Override // c.b.b.q.w
    public w.a<K, V> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f.a) {
                return new a(this);
            }
            if (this.f22864h == null) {
                this.f22864h = new a(this);
                this.i = new a(this);
            }
            w.a aVar = this.f22864h;
            if (!aVar.f22870e) {
                aVar.c();
                w.a<K, V> aVar2 = this.f22864h;
                aVar2.f22870e = true;
                this.i.f22870e = false;
                return aVar2;
            }
            this.i.c();
            w.a<K, V> aVar3 = this.i;
            aVar3.f22870e = true;
            this.f22864h.f22870e = false;
            return aVar3;
        }
        return (w.a) invokeV.objValue;
    }

    @Override // c.b.b.q.w
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.o.clear();
            super.clear();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.b.b.q.w, java.lang.Iterable
    /* renamed from: e */
    public w.a<K, V> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b() : (w.a) invokeV.objValue;
    }

    @Override // c.b.b.q.w
    public w.c<K> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f.a) {
                return new b(this);
            }
            if (this.l == null) {
                this.l = new b(this);
                this.m = new b(this);
            }
            w.c cVar = this.l;
            if (!cVar.f22870e) {
                cVar.c();
                w.c<K> cVar2 = this.l;
                cVar2.f22870e = true;
                this.m.f22870e = false;
                return cVar2;
            }
            this.m.c();
            w.c<K> cVar3 = this.m;
            cVar3.f22870e = true;
            this.l.f22870e = false;
            return cVar3;
        }
        return (w.c) invokeV.objValue;
    }

    @Override // c.b.b.q.w
    public V i(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, k, v)) == null) {
            int g2 = g(k);
            if (g2 >= 0) {
                V[] vArr = this.f22859c;
                V v2 = vArr[g2];
                vArr[g2] = v;
                return v2;
            }
            int i = -(g2 + 1);
            this.f22858b[i] = k;
            this.f22859c[i] = v;
            this.o.a(k);
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 >= this.f22861e) {
                l(this.f22858b.length << 1);
                return null;
            }
            return null;
        }
        return (V) invokeLL.objValue;
    }

    @Override // c.b.b.q.w
    public V k(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) {
            this.o.j(k, false);
            return (V) super.k(k);
        }
        return (V) invokeL.objValue;
    }

    @Override // c.b.b.q.w
    public String m(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) {
            if (this.a == 0) {
                return z ? StringUtil.EMPTY_ARRAY : "";
            }
            StringBuilder sb = new StringBuilder(32);
            if (z) {
                sb.append('{');
            }
            c.b.b.q.a<K> aVar = this.o;
            int i = aVar.f22717b;
            for (int i2 = 0; i2 < i; i2++) {
                K k = aVar.get(i2);
                if (i2 > 0) {
                    sb.append(str);
                }
                Object obj = "(this)";
                sb.append(k == this ? "(this)" : k);
                sb.append('=');
                V c2 = c(k);
                if (c2 != this) {
                    obj = c2;
                }
                sb.append(obj);
            }
            if (z) {
                sb.append('}');
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }

    @Override // c.b.b.q.w
    public w.e<V> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (f.a) {
                return new c(this);
            }
            if (this.j == null) {
                this.j = new c(this);
                this.k = new c(this);
            }
            w.e eVar = this.j;
            if (!eVar.f22870e) {
                eVar.c();
                w.e<V> eVar2 = this.j;
                eVar2.f22870e = true;
                this.k.f22870e = false;
                return eVar2;
            }
            this.k.c();
            w.e<V> eVar3 = this.k;
            eVar3.f22870e = true;
            this.j.f22870e = false;
            return eVar3;
        }
        return (w.e) invokeV.objValue;
    }

    public V o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? (V) super.k(this.o.i(i)) : (V) invokeI.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = new c.b.b.q.a<>(i);
    }
}
