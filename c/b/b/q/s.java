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
    public int f28338e;

    /* renamed from: f  reason: collision with root package name */
    public long[] f28339f;

    /* renamed from: g  reason: collision with root package name */
    public V[] f28340g;

    /* renamed from: h  reason: collision with root package name */
    public V f28341h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28342i;

    /* renamed from: j  reason: collision with root package name */
    public final float f28343j;

    /* renamed from: k  reason: collision with root package name */
    public int f28344k;
    public int l;
    public int m;
    public transient a n;
    public transient a o;

    /* loaded from: classes9.dex */
    public static class a<V> extends c<V> implements Iterable<b<V>>, Iterator<b<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public final b<V> f28345j;

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
            this.f28345j = new b<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: d */
        public b<V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f28347e) {
                    if (this.f28351i) {
                        s<V> sVar = this.f28348f;
                        long[] jArr = sVar.f28339f;
                        int i2 = this.f28349g;
                        if (i2 == -1) {
                            b<V> bVar = this.f28345j;
                            bVar.a = 0L;
                            bVar.f28346b = sVar.f28341h;
                        } else {
                            b<V> bVar2 = this.f28345j;
                            bVar2.a = jArr[i2];
                            bVar2.f28346b = sVar.f28340g[i2];
                        }
                        this.f28350h = this.f28349g;
                        b();
                        return this.f28345j;
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
                if (this.f28351i) {
                    return this.f28347e;
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
        public V f28346b;

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
                return this.a + "=" + this.f28346b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f28347e;

        /* renamed from: f  reason: collision with root package name */
        public final s<V> f28348f;

        /* renamed from: g  reason: collision with root package name */
        public int f28349g;

        /* renamed from: h  reason: collision with root package name */
        public int f28350h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f28351i;

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
            this.f28351i = true;
            this.f28348f = sVar;
            c();
        }

        public void b() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long[] jArr = this.f28348f.f28339f;
                int length = jArr.length;
                do {
                    i2 = this.f28349g + 1;
                    this.f28349g = i2;
                    if (i2 >= length) {
                        this.f28347e = false;
                        return;
                    }
                } while (jArr[i2] == 0);
                this.f28347e = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f28350h = -2;
                this.f28349g = -1;
                if (this.f28348f.f28342i) {
                    this.f28347e = true;
                } else {
                    b();
                }
            }
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = this.f28350h;
                if (i2 == -1) {
                    s<V> sVar = this.f28348f;
                    if (sVar.f28342i) {
                        sVar.f28342i = false;
                        sVar.f28341h = null;
                        this.f28350h = -2;
                        s<V> sVar2 = this.f28348f;
                        sVar2.f28338e--;
                        return;
                    }
                }
                if (i2 >= 0) {
                    s<V> sVar3 = this.f28348f;
                    long[] jArr = sVar3.f28339f;
                    V[] vArr = sVar3.f28340g;
                    int i3 = sVar3.m;
                    int i4 = i2 + 1;
                    while (true) {
                        int i5 = i4 & i3;
                        long j2 = jArr[i5];
                        if (j2 == 0) {
                            break;
                        }
                        int f2 = this.f28348f.f(j2);
                        if (((i5 - f2) & i3) > ((i2 - f2) & i3)) {
                            jArr[i2] = j2;
                            vArr[i2] = vArr[i5];
                            i2 = i5;
                        }
                        i4 = i5 + 1;
                    }
                    jArr[i2] = 0;
                    vArr[i2] = null;
                    if (i2 != this.f28350h) {
                        this.f28349g--;
                    }
                    this.f28350h = -2;
                    s<V> sVar22 = this.f28348f;
                    sVar22.f28338e--;
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
            if (!aVar.f28351i) {
                aVar.c();
                a<V> aVar2 = this.n;
                aVar2.f28351i = true;
                this.o.f28351i = false;
                return aVar2;
            }
            this.o.c();
            a<V> aVar3 = this.o;
            aVar3.f28351i = true;
            this.n.f28351i = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public V c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (j2 == 0) {
                if (this.f28342i) {
                    return this.f28341h;
                }
                return null;
            }
            int e2 = e(j2);
            if (e2 >= 0) {
                return this.f28340g[e2];
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
                return this.f28342i ? this.f28341h : v;
            }
            int e2 = e(j2);
            return e2 >= 0 ? this.f28340g[e2] : v;
        }
        return (V) invokeJL.objValue;
    }

    public final int e(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048579, this, j2)) != null) {
            return invokeJ.intValue;
        }
        long[] jArr = this.f28339f;
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
                if (sVar.f28338e != this.f28338e) {
                    return false;
                }
                boolean z = sVar.f28342i;
                boolean z2 = this.f28342i;
                if (z != z2) {
                    return false;
                }
                if (z2) {
                    V v = sVar.f28341h;
                    if (v == null) {
                        if (this.f28341h != null) {
                            return false;
                        }
                    } else if (!v.equals(this.f28341h)) {
                        return false;
                    }
                }
                long[] jArr = this.f28339f;
                V[] vArr = this.f28340g;
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
                V v2 = this.f28341h;
                this.f28341h = v;
                if (!this.f28342i) {
                    this.f28342i = true;
                    this.f28338e++;
                }
                return v2;
            }
            int e2 = e(j2);
            if (e2 >= 0) {
                V[] vArr = this.f28340g;
                V v3 = vArr[e2];
                vArr[e2] = v;
                return v3;
            }
            int i2 = -(e2 + 1);
            long[] jArr = this.f28339f;
            jArr[i2] = j2;
            this.f28340g[i2] = v;
            int i3 = this.f28338e + 1;
            this.f28338e = i3;
            if (i3 >= this.f28344k) {
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
            long[] jArr = this.f28339f;
            int f2 = f(j2);
            while (jArr[f2] != 0) {
                f2 = (f2 + 1) & this.m;
            }
            jArr[f2] = j2;
            this.f28340g[f2] = v;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.f28338e;
            if (this.f28342i && (v = this.f28341h) != null) {
                i2 += v.hashCode();
            }
            long[] jArr = this.f28339f;
            V[] vArr = this.f28340g;
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
            int length = this.f28339f.length;
            this.f28344k = (int) (i2 * this.f28343j);
            int i3 = i2 - 1;
            this.m = i3;
            this.l = Long.numberOfLeadingZeros(i3);
            long[] jArr = this.f28339f;
            V[] vArr = this.f28340g;
            this.f28339f = new long[i2];
            this.f28340g = (V[]) new Object[i2];
            if (this.f28338e > 0) {
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
        if (this.f28338e == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        long[] jArr = this.f28339f;
        V[] vArr = this.f28340g;
        int length = jArr.length;
        if (this.f28342i) {
            sb.append("0=");
            sb.append(this.f28341h);
            i2 = length - 1;
            if (length > 0) {
                long j2 = jArr[i2];
                if (j2 != 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(j2);
                    sb.append(com.alipay.sdk.encrypt.a.f31864h);
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
                    sb.append(com.alipay.sdk.encrypt.a.f31864h);
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
            this.f28343j = f2;
            int h2 = x.h(i2, f2);
            this.f28344k = (int) (h2 * f2);
            int i5 = h2 - 1;
            this.m = i5;
            this.l = Long.numberOfLeadingZeros(i5);
            this.f28339f = new long[h2];
            this.f28340g = (V[]) new Object[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
