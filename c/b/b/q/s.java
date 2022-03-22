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
/* loaded from: classes3.dex */
public class s<V> implements Iterable<b<V>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f22819b;

    /* renamed from: c  reason: collision with root package name */
    public V[] f22820c;

    /* renamed from: d  reason: collision with root package name */
    public V f22821d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22822e;

    /* renamed from: f  reason: collision with root package name */
    public final float f22823f;

    /* renamed from: g  reason: collision with root package name */
    public int f22824g;

    /* renamed from: h  reason: collision with root package name */
    public int f22825h;
    public int i;
    public transient a j;
    public transient a k;

    /* loaded from: classes3.dex */
    public static class a<V> extends c<V> implements Iterable<b<V>>, Iterator<b<V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final b<V> f22826f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(s sVar) {
            super(sVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((s) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22826f = new b<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: d */
        public b<V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a) {
                    if (this.f22831e) {
                        s<V> sVar = this.f22828b;
                        long[] jArr = sVar.f22819b;
                        int i = this.f22829c;
                        if (i == -1) {
                            b<V> bVar = this.f22826f;
                            bVar.a = 0L;
                            bVar.f22827b = sVar.f22821d;
                        } else {
                            b<V> bVar2 = this.f22826f;
                            bVar2.a = jArr[i];
                            bVar2.f22827b = sVar.f22820c[i];
                        }
                        this.f22830d = this.f22829c;
                        b();
                        return this.f22826f;
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
                if (this.f22831e) {
                    return this.a;
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

    /* loaded from: classes3.dex */
    public static class b<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public V f22827b;

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
                return this.a + "=" + this.f22827b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final s<V> f22828b;

        /* renamed from: c  reason: collision with root package name */
        public int f22829c;

        /* renamed from: d  reason: collision with root package name */
        public int f22830d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22831e;

        public c(s<V> sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22831e = true;
            this.f22828b = sVar;
            c();
        }

        public void b() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long[] jArr = this.f22828b.f22819b;
                int length = jArr.length;
                do {
                    i = this.f22829c + 1;
                    this.f22829c = i;
                    if (i >= length) {
                        this.a = false;
                        return;
                    }
                } while (jArr[i] == 0);
                this.a = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f22830d = -2;
                this.f22829c = -1;
                if (this.f22828b.f22822e) {
                    this.a = true;
                } else {
                    b();
                }
            }
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.f22830d;
                if (i == -1) {
                    s<V> sVar = this.f22828b;
                    if (sVar.f22822e) {
                        sVar.f22822e = false;
                        sVar.f22821d = null;
                        this.f22830d = -2;
                        s<V> sVar2 = this.f22828b;
                        sVar2.a--;
                        return;
                    }
                }
                if (i >= 0) {
                    s<V> sVar3 = this.f22828b;
                    long[] jArr = sVar3.f22819b;
                    V[] vArr = sVar3.f22820c;
                    int i2 = sVar3.i;
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3 & i2;
                        long j = jArr[i4];
                        if (j == 0) {
                            break;
                        }
                        int f2 = this.f22828b.f(j);
                        if (((i4 - f2) & i2) > ((i - f2) & i2)) {
                            jArr[i] = j;
                            vArr[i] = vArr[i4];
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    jArr[i] = 0;
                    vArr[i] = null;
                    if (i != this.f22830d) {
                        this.f22829c--;
                    }
                    this.f22830d = -2;
                    s<V> sVar22 = this.f22828b;
                    sVar22.a--;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (this.j == null) {
                this.j = new a(this);
                this.k = new a(this);
            }
            a aVar = this.j;
            if (!aVar.f22831e) {
                aVar.c();
                a<V> aVar2 = this.j;
                aVar2.f22831e = true;
                this.k.f22831e = false;
                return aVar2;
            }
            this.k.c();
            a<V> aVar3 = this.k;
            aVar3.f22831e = true;
            this.j.f22831e = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public V c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j == 0) {
                if (this.f22822e) {
                    return this.f22821d;
                }
                return null;
            }
            int e2 = e(j);
            if (e2 >= 0) {
                return this.f22820c[e2];
            }
            return null;
        }
        return (V) invokeJ.objValue;
    }

    public V d(long j, V v) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, v)) == null) {
            if (j == 0) {
                return this.f22822e ? this.f22821d : v;
            }
            int e2 = e(j);
            return e2 >= 0 ? this.f22820c[e2] : v;
        }
        return (V) invokeJL.objValue;
    }

    public final int e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048579, this, j)) != null) {
            return invokeJ.intValue;
        }
        long[] jArr = this.f22819b;
        int f2 = f(j);
        while (true) {
            long j2 = jArr[f2];
            if (j2 == 0) {
                return -(f2 + 1);
            }
            if (j2 == j) {
                return f2;
            }
            f2 = (f2 + 1) & this.i;
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
                if (sVar.a != this.a) {
                    return false;
                }
                boolean z = sVar.f22822e;
                boolean z2 = this.f22822e;
                if (z != z2) {
                    return false;
                }
                if (z2) {
                    V v = sVar.f22821d;
                    if (v == null) {
                        if (this.f22821d != null) {
                            return false;
                        }
                    } else if (!v.equals(this.f22821d)) {
                        return false;
                    }
                }
                long[] jArr = this.f22819b;
                V[] vArr = this.f22820c;
                int length = jArr.length;
                for (int i = 0; i < length; i++) {
                    long j = jArr[i];
                    if (j != 0) {
                        V v2 = vArr[i];
                        if (v2 == null) {
                            if (sVar.d(j, w.n) != null) {
                                return false;
                            }
                        } else if (!v2.equals(sVar.c(j))) {
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

    public int f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) ? (int) (((j ^ (j >>> 32)) * (-7046029254386353131L)) >>> this.f22825h) : invokeJ.intValue;
    }

    public V g(long j, V v) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048582, this, j, v)) == null) {
            if (j == 0) {
                V v2 = this.f22821d;
                this.f22821d = v;
                if (!this.f22822e) {
                    this.f22822e = true;
                    this.a++;
                }
                return v2;
            }
            int e2 = e(j);
            if (e2 >= 0) {
                V[] vArr = this.f22820c;
                V v3 = vArr[e2];
                vArr[e2] = v;
                return v3;
            }
            int i = -(e2 + 1);
            long[] jArr = this.f22819b;
            jArr[i] = j;
            this.f22820c[i] = v;
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 >= this.f22824g) {
                i(jArr.length << 1);
                return null;
            }
            return null;
        }
        return (V) invokeJL.objValue;
    }

    public final void h(long j, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048583, this, j, v) == null) {
            long[] jArr = this.f22819b;
            int f2 = f(j);
            while (jArr[f2] != 0) {
                f2 = (f2 + 1) & this.i;
            }
            jArr[f2] = j;
            this.f22820c[f2] = v;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.a;
            if (this.f22822e && (v = this.f22821d) != null) {
                i += v.hashCode();
            }
            long[] jArr = this.f22819b;
            V[] vArr = this.f22820c;
            int length = jArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                long j = jArr[i2];
                if (j != 0) {
                    i = (int) (i + (j * 31));
                    V v2 = vArr[i2];
                    if (v2 != null) {
                        i += v2.hashCode();
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            int length = this.f22819b.length;
            this.f22824g = (int) (i * this.f22823f);
            int i2 = i - 1;
            this.i = i2;
            this.f22825h = Long.numberOfLeadingZeros(i2);
            long[] jArr = this.f22819b;
            V[] vArr = this.f22820c;
            this.f22819b = new long[i];
            this.f22820c = (V[]) new Object[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    long j = jArr[i3];
                    if (j != 0) {
                        h(j, vArr[i3]);
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048587, this)) != null) {
            return (String) invokeV.objValue;
        }
        if (this.a == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        long[] jArr = this.f22819b;
        V[] vArr = this.f22820c;
        int length = jArr.length;
        if (this.f22822e) {
            sb.append("0=");
            sb.append(this.f22821d);
            i = length - 1;
            if (length > 0) {
                long j = jArr[i];
                if (j != 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(j);
                    sb.append('=');
                    sb.append(vArr[i]);
                }
                length = i;
                i = length - 1;
                if (length > 0) {
                    sb.append(']');
                    return sb.toString();
                }
            }
        } else {
            while (true) {
                i = length - 1;
                if (length <= 0) {
                    break;
                }
                long j2 = jArr[i];
                if (j2 != 0) {
                    sb.append(j2);
                    sb.append('=');
                    sb.append(vArr[i]);
                    break;
                }
                length = i;
            }
            length = i;
            i = length - 1;
            if (length > 0) {
            }
        }
    }

    public s(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f22823f = f2;
            int h2 = x.h(i, f2);
            this.f22824g = (int) (h2 * f2);
            int i4 = h2 - 1;
            this.i = i4;
            this.f22825h = Long.numberOfLeadingZeros(i4);
            this.f22819b = new long[h2];
            this.f22820c = (V[]) new Object[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
