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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class y<K, V> extends w<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.b.b.q.a<K> s;

    /* loaded from: classes3.dex */
    public static class a<K, V> extends w.a<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.b.b.q.a<K> k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y<K, V> yVar) {
            super(yVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
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
            this.k = yVar.s;
        }

        @Override // c.b.b.q.w.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27666h = -1;
                this.f27665g = 0;
                this.f27663e = this.f27664f.f27655e > 0;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.b.q.w.a, java.util.Iterator
        /* renamed from: e */
        public w.b next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f27663e) {
                    if (this.f27667i) {
                        int i2 = this.f27665g;
                        this.f27666h = i2;
                        this.f27661j.a = this.k.get(i2);
                        w.b<K, V> bVar = this.f27661j;
                        bVar.f27662b = this.f27664f.c(bVar.a);
                        int i3 = this.f27665g + 1;
                        this.f27665g = i3;
                        this.f27663e = i3 < this.f27664f.f27655e;
                        return this.f27661j;
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
                if (this.f27666h >= 0) {
                    this.f27664f.k(this.f27661j.a);
                    this.f27665g--;
                    this.f27666h = -1;
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

        /* renamed from: j  reason: collision with root package name */
        public c.b.b.q.a<K> f27679j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(y<K, ?> yVar) {
            super(yVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
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
            this.f27679j = yVar.s;
        }

        @Override // c.b.b.q.w.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27666h = -1;
                this.f27665g = 0;
                this.f27663e = this.f27664f.f27655e > 0;
            }
        }

        @Override // c.b.b.q.w.c
        public c.b.b.q.a<K> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c.b.b.q.a<K> aVar = new c.b.b.q.a<>(true, this.f27679j.f27499f - this.f27665g);
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
                c.b.b.q.a<K> aVar2 = this.f27679j;
                int i2 = this.f27665g;
                aVar.c(aVar2, i2, aVar2.f27499f - i2);
                this.f27665g = this.f27679j.f27499f;
                this.f27663e = false;
                return aVar;
            }
            return (c.b.b.q.a) invokeL.objValue;
        }

        @Override // c.b.b.q.w.c, java.util.Iterator
        public K next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f27663e) {
                    if (this.f27667i) {
                        K k = this.f27679j.get(this.f27665g);
                        int i2 = this.f27665g;
                        this.f27666h = i2;
                        int i3 = i2 + 1;
                        this.f27665g = i3;
                        this.f27663e = i3 < this.f27664f.f27655e;
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
                int i2 = this.f27666h;
                if (i2 >= 0) {
                    ((y) this.f27664f).o(i2);
                    this.f27665g = this.f27666h;
                    this.f27666h = -1;
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

        /* renamed from: j  reason: collision with root package name */
        public c.b.b.q.a f27680j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(y<?, V> yVar) {
            super(yVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
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
            this.f27680j = yVar.s;
        }

        @Override // c.b.b.q.w.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27666h = -1;
                this.f27665g = 0;
                this.f27663e = this.f27664f.f27655e > 0;
            }
        }

        @Override // c.b.b.q.w.e, java.util.Iterator
        public V next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f27663e) {
                    if (this.f27667i) {
                        V c2 = this.f27664f.c(this.f27680j.get(this.f27665g));
                        int i2 = this.f27665g;
                        this.f27666h = i2;
                        int i3 = i2 + 1;
                        this.f27665g = i3;
                        this.f27663e = i3 < this.f27664f.f27655e;
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
                int i2 = this.f27666h;
                if (i2 >= 0) {
                    ((y) this.f27664f).o(i2);
                    this.f27665g = this.f27666h;
                    this.f27666h = -1;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = new c.b.b.q.a<>();
    }

    @Override // c.b.b.q.w
    public w.a<K, V> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f.a) {
                return new a(this);
            }
            if (this.l == null) {
                this.l = new a(this);
                this.m = new a(this);
            }
            w.a aVar = this.l;
            if (!aVar.f27667i) {
                aVar.c();
                w.a<K, V> aVar2 = this.l;
                aVar2.f27667i = true;
                this.m.f27667i = false;
                return aVar2;
            }
            this.m.c();
            w.a<K, V> aVar3 = this.m;
            aVar3.f27667i = true;
            this.l.f27667i = false;
            return aVar3;
        }
        return (w.a) invokeV.objValue;
    }

    @Override // c.b.b.q.w
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.s.clear();
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
            if (this.p == null) {
                this.p = new b(this);
                this.q = new b(this);
            }
            w.c cVar = this.p;
            if (!cVar.f27667i) {
                cVar.c();
                w.c<K> cVar2 = this.p;
                cVar2.f27667i = true;
                this.q.f27667i = false;
                return cVar2;
            }
            this.q.c();
            w.c<K> cVar3 = this.q;
            cVar3.f27667i = true;
            this.p.f27667i = false;
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
                V[] vArr = this.f27657g;
                V v2 = vArr[g2];
                vArr[g2] = v;
                return v2;
            }
            int i2 = -(g2 + 1);
            this.f27656f[i2] = k;
            this.f27657g[i2] = v;
            this.s.a(k);
            int i3 = this.f27655e + 1;
            this.f27655e = i3;
            if (i3 >= this.f27659i) {
                l(this.f27656f.length << 1);
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
            this.s.i(k, false);
            return (V) super.k(k);
        }
        return (V) invokeL.objValue;
    }

    @Override // c.b.b.q.w
    public String m(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) {
            if (this.f27655e == 0) {
                return z ? StringUtil.EMPTY_ARRAY : "";
            }
            StringBuilder sb = new StringBuilder(32);
            if (z) {
                sb.append(ExtendedMessageFormat.START_FE);
            }
            c.b.b.q.a<K> aVar = this.s;
            int i2 = aVar.f27499f;
            for (int i3 = 0; i3 < i2; i3++) {
                K k = aVar.get(i3);
                if (i3 > 0) {
                    sb.append(str);
                }
                Object obj = "(this)";
                sb.append(k == this ? "(this)" : k);
                sb.append(com.alipay.sdk.encrypt.a.f29503h);
                V c2 = c(k);
                if (c2 != this) {
                    obj = c2;
                }
                sb.append(obj);
            }
            if (z) {
                sb.append(ExtendedMessageFormat.END_FE);
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
            if (this.n == null) {
                this.n = new c(this);
                this.o = new c(this);
            }
            w.e eVar = this.n;
            if (!eVar.f27667i) {
                eVar.c();
                w.e<V> eVar2 = this.n;
                eVar2.f27667i = true;
                this.o.f27667i = false;
                return eVar2;
            }
            this.o.c();
            w.e<V> eVar3 = this.o;
            eVar3.f27667i = true;
            this.n.f27667i = false;
            return eVar3;
        }
        return (w.e) invokeV.objValue;
    }

    public V o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? (V) super.k(this.s.h(i2)) : (V) invokeI.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.s = new c.b.b.q.a<>(i2);
    }
}
