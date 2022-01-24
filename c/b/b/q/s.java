package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes9.dex */
public class s<V> implements Iterable<b<V>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f27506e;

    /* renamed from: f  reason: collision with root package name */
    public long[] f27507f;

    /* renamed from: g  reason: collision with root package name */
    public V[] f27508g;

    /* renamed from: h  reason: collision with root package name */
    public V f27509h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27510i;

    /* renamed from: j  reason: collision with root package name */
    public final float f27511j;
    public int k;
    public int l;
    public int m;
    public transient a n;
    public transient a o;

    /* loaded from: classes9.dex */
    public static class a<V> extends c<V> implements Iterable<b<V>>, Iterator<b<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final b<V> f27512j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s sVar) {
            super(sVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((s) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27512j = new b<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: d */
        public b<V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f27514e) {
                    if (this.f27518i) {
                        s<V> sVar = this.f27515f;
                        long[] jArr = sVar.f27507f;
                        int i2 = this.f27516g;
                        if (i2 == -1) {
                            b<V> bVar = this.f27512j;
                            bVar.a = 0L;
                            bVar.f27513b = sVar.f27509h;
                        } else {
                            b<V> bVar2 = this.f27512j;
                            bVar2.a = jArr[i2];
                            bVar2.f27513b = sVar.f27508g[i2];
                        }
                        this.f27517h = this.f27516g;
                        b();
                        return this.f27512j;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f27518i) {
                    return this.f27514e;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public Iterator<b<V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public V f27513b;

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
                return this.a + "=" + this.f27513b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27514e;

        /* renamed from: f  reason: collision with root package name */
        public final s<V> f27515f;

        /* renamed from: g  reason: collision with root package name */
        public int f27516g;

        /* renamed from: h  reason: collision with root package name */
        public int f27517h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f27518i;

        public c(s<V> sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27518i = true;
            this.f27515f = sVar;
            c();
        }

        public void b() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long[] jArr = this.f27515f.f27507f;
                int length = jArr.length;
                do {
                    i2 = this.f27516g + 1;
                    this.f27516g = i2;
                    if (i2 >= length) {
                        this.f27514e = false;
                        return;
                    }
                } while (jArr[i2] == 0);
                this.f27514e = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f27517h = -2;
                this.f27516g = -1;
                if (this.f27515f.f27510i) {
                    this.f27514e = true;
                } else {
                    b();
                }
            }
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = this.f27517h;
                if (i2 == -1) {
                    s<V> sVar = this.f27515f;
                    if (sVar.f27510i) {
                        sVar.f27510i = false;
                        sVar.f27509h = null;
                        this.f27517h = -2;
                        s<V> sVar2 = this.f27515f;
                        sVar2.f27506e--;
                        return;
                    }
                }
                if (i2 >= 0) {
                    s<V> sVar3 = this.f27515f;
                    long[] jArr = sVar3.f27507f;
                    V[] vArr = sVar3.f27508g;
                    int i3 = sVar3.m;
                    int i4 = i2 + 1;
                    while (true) {
                        int i5 = i4 & i3;
                        long j2 = jArr[i5];
                        if (j2 == 0) {
                            break;
                        }
                        int f2 = this.f27515f.f(j2);
                        if (((i5 - f2) & i3) > ((i2 - f2) & i3)) {
                            jArr[i2] = j2;
                            vArr[i2] = vArr[i5];
                            i2 = i5;
                        }
                        i4 = i5 + 1;
                    }
                    jArr[i2] = 0;
                    vArr[i2] = null;
                    if (i2 != this.f27517h) {
                        this.f27516g--;
                    }
                    this.f27517h = -2;
                    s<V> sVar22 = this.f27515f;
                    sVar22.f27506e--;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s() {
        this(51, 0.8f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public a<V> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f.a) {
                return new a<>(this);
            }
            if (this.n == null) {
                this.n = new a(this);
                this.o = new a(this);
            }
            a aVar = this.n;
            if (!aVar.f27518i) {
                aVar.c();
                a<V> aVar2 = this.n;
                aVar2.f27518i = true;
                this.o.f27518i = false;
                return aVar2;
            }
            this.o.c();
            a<V> aVar3 = this.o;
            aVar3.f27518i = true;
            this.n.f27518i = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public V c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (j2 == 0) {
                if (this.f27510i) {
                    return this.f27509h;
                }
                return null;
            }
            int e2 = e(j2);
            if (e2 >= 0) {
                return this.f27508g[e2];
            }
            return null;
        }
        return (V) invokeJ.objValue;
    }

    public V d(long j2, V v) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, v)) == null) {
            if (j2 == 0) {
                return this.f27510i ? this.f27509h : v;
            }
            int e2 = e(j2);
            return e2 >= 0 ? this.f27508g[e2] : v;
        }
        return (V) invokeJL.objValue;
    }

    public final int e(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048579, this, j2)) != null) {
            return invokeJ.intValue;
        }
        long[] jArr = this.f27507f;
        int f2 = f(j2);
        while (true) {
            long j3 = jArr[f2];
            if (j3 == 0) {
                return -(f2 + 1);
            }
            if (j3 == j2) {
                return f2;
            }
            f2 = (f2 + 1) & this.m;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v1, resolved type: c.b.b.q.s */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof s) {
                s sVar = (s) obj;
                if (sVar.f27506e != this.f27506e) {
                    return false;
                }
                boolean z = sVar.f27510i;
                boolean z2 = this.f27510i;
                if (z != z2) {
                    return false;
                }
                if (z2) {
                    V v = sVar.f27509h;
                    if (v == null) {
                        if (this.f27509h != null) {
                            return false;
                        }
                    } else if (!v.equals(this.f27509h)) {
                        return false;
                    }
                }
                long[] jArr = this.f27507f;
                V[] vArr = this.f27508g;
                int length = jArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    long j2 = jArr[i2];
                    if (j2 != 0) {
                        V v2 = vArr[i2];
                        if (v2 == null) {
                            if (sVar.d(j2, w.r) != null) {
                                return false;
                            }
                        } else if (!v2.equals(sVar.c(j2))) {
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

    public int f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) ? (int) (((j2 ^ (j2 >>> 32)) * (-7046029254386353131L)) >>> this.l) : invokeJ.intValue;
    }

    public V g(long j2, V v) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048582, this, j2, v)) == null) {
            if (j2 == 0) {
                V v2 = this.f27509h;
                this.f27509h = v;
                if (!this.f27510i) {
                    this.f27510i = true;
                    this.f27506e++;
                }
                return v2;
            }
            int e2 = e(j2);
            if (e2 >= 0) {
                V[] vArr = this.f27508g;
                V v3 = vArr[e2];
                vArr[e2] = v;
                return v3;
            }
            int i2 = -(e2 + 1);
            long[] jArr = this.f27507f;
            jArr[i2] = j2;
            this.f27508g[i2] = v;
            int i3 = this.f27506e + 1;
            this.f27506e = i3;
            if (i3 >= this.k) {
                i(jArr.length << 1);
                return null;
            }
            return null;
        }
        return (V) invokeJL.objValue;
    }

    public final void h(long j2, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048583, this, j2, v) == null) {
            long[] jArr = this.f27507f;
            int f2 = f(j2);
            while (jArr[f2] != 0) {
                f2 = (f2 + 1) & this.m;
            }
            jArr[f2] = j2;
            this.f27508g[f2] = v;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.f27506e;
            if (this.f27510i && (v = this.f27509h) != null) {
                i2 += v.hashCode();
            }
            long[] jArr = this.f27507f;
            V[] vArr = this.f27508g;
            int length = jArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                long j2 = jArr[i3];
                if (j2 != 0) {
                    i2 = (int) (i2 + (j2 * 31));
                    V v2 = vArr[i3];
                    if (v2 != null) {
                        i2 += v2.hashCode();
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            int length = this.f27507f.length;
            this.k = (int) (i2 * this.f27511j);
            int i3 = i2 - 1;
            this.m = i3;
            this.l = Long.numberOfLeadingZeros(i3);
            long[] jArr = this.f27507f;
            V[] vArr = this.f27508g;
            this.f27507f = new long[i2];
            this.f27508g = (V[]) new Object[i2];
            if (this.f27506e > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    long j2 = jArr[i4];
                    if (j2 != 0) {
                        h(j2, vArr[i4]);
                    }
                }
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<b<V>> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? b() : (Iterator) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0046 -> B:18:0x0047). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048587, this)) != null) {
            return (String) invokeV.objValue;
        }
        if (this.f27506e == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        long[] jArr = this.f27507f;
        V[] vArr = this.f27508g;
        int length = jArr.length;
        if (this.f27510i) {
            sb.append("0=");
            sb.append(this.f27509h);
            i2 = length - 1;
            if (length > 0) {
                long j2 = jArr[i2];
                if (j2 != 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(j2);
                    sb.append(com.alipay.sdk.encrypt.a.f30893h);
                    sb.append(vArr[i2]);
                }
                length = i2;
                i2 = length - 1;
                if (length > 0) {
                    sb.append(']');
                    return sb.toString();
                }
            }
        } else {
            while (true) {
                i2 = length - 1;
                if (length <= 0) {
                    break;
                }
                long j3 = jArr[i2];
                if (j3 != 0) {
                    sb.append(j3);
                    sb.append(com.alipay.sdk.encrypt.a.f30893h);
                    sb.append(vArr[i2]);
                    break;
                }
                length = i2;
            }
            length = i2;
            i2 = length - 1;
            if (length > 0) {
            }
        }
    }

    public s(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f27511j = f2;
            int h2 = x.h(i2, f2);
            this.k = (int) (h2 * f2);
            int i5 = h2 - 1;
            this.m = i5;
            this.l = Long.numberOfLeadingZeros(i5);
            this.f27507f = new long[h2];
            this.f27508g = (V[]) new Object[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
