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
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public class v<K> implements Iterable<b<K>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f28366e;

    /* renamed from: f  reason: collision with root package name */
    public K[] f28367f;

    /* renamed from: g  reason: collision with root package name */
    public int[] f28368g;

    /* renamed from: h  reason: collision with root package name */
    public float f28369h;

    /* renamed from: i  reason: collision with root package name */
    public int f28370i;

    /* renamed from: j  reason: collision with root package name */
    public int f28371j;

    /* renamed from: k  reason: collision with root package name */
    public int f28372k;
    public transient a l;
    public transient a m;

    /* loaded from: classes9.dex */
    public static class a<K> extends c<K> implements Iterable<b<K>>, Iterator<b<K>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public b<K> f28373j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v<K> vVar) {
            super(vVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((v) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28373j = new b<>();
        }

        public a<K> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (a) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: e */
        public b<K> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f28375e) {
                    if (this.f28379i) {
                        v<K> vVar = this.f28376f;
                        K[] kArr = vVar.f28367f;
                        b<K> bVar = this.f28373j;
                        int i2 = this.f28377g;
                        bVar.a = kArr[i2];
                        bVar.f28374b = vVar.f28368g[i2];
                        this.f28378h = i2;
                        b();
                        return this.f28373j;
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
                if (this.f28379i) {
                    return this.f28375e;
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

    /* loaded from: classes9.dex */
    public static class b<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public K a;

        /* renamed from: b  reason: collision with root package name */
        public int f28374b;

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
                return this.a + "=" + this.f28374b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f28375e;

        /* renamed from: f  reason: collision with root package name */
        public final v<K> f28376f;

        /* renamed from: g  reason: collision with root package name */
        public int f28377g;

        /* renamed from: h  reason: collision with root package name */
        public int f28378h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f28379i;

        public c(v<K> vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28379i = true;
            this.f28376f = vVar;
            c();
        }

        public void b() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                K[] kArr = this.f28376f.f28367f;
                int length = kArr.length;
                do {
                    i2 = this.f28377g + 1;
                    this.f28377g = i2;
                    if (i2 >= length) {
                        this.f28375e = false;
                        return;
                    }
                } while (kArr[i2] == null);
                this.f28375e = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f28378h = -1;
                this.f28377g = -1;
                b();
            }
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = this.f28378h;
                if (i2 >= 0) {
                    v<K> vVar = this.f28376f;
                    K[] kArr = vVar.f28367f;
                    int[] iArr = vVar.f28368g;
                    int i3 = vVar.f28372k;
                    int i4 = i2 + 1;
                    while (true) {
                        int i5 = i4 & i3;
                        K k2 = kArr[i5];
                        if (k2 == null) {
                            break;
                        }
                        int g2 = this.f28376f.g(k2);
                        if (((i5 - g2) & i3) > ((i2 - g2) & i3)) {
                            kArr[i2] = k2;
                            iArr[i2] = iArr[i5];
                            i2 = i5;
                        }
                        i4 = i5 + 1;
                    }
                    kArr[i2] = null;
                    v<K> vVar2 = this.f28376f;
                    vVar2.f28366e--;
                    if (i2 != this.f28378h) {
                        this.f28377g--;
                    }
                    this.f28378h = -1;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v() {
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

    public boolean a(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k2)) == null) ? f(k2) >= 0 : invokeL.booleanValue;
    }

    public a<K> b() {
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
            if (!aVar.f28379i) {
                aVar.c();
                a<K> aVar2 = this.l;
                aVar2.f28379i = true;
                this.m.f28379i = false;
                return aVar2;
            }
            this.m.c();
            a<K> aVar3 = this.m;
            aVar3.f28379i = true;
            this.l.f28379i = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public int c(K k2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, k2, i2)) == null) {
            int f2 = f(k2);
            return f2 < 0 ? i2 : this.f28368g[f2];
        }
        return invokeLI.intValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f28366e == 0) {
            return;
        }
        this.f28366e = 0;
        Arrays.fill(this.f28367f, (Object) null);
    }

    public int d(K k2, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, k2, i2, i3)) == null) {
            int f2 = f(k2);
            if (f2 >= 0) {
                int[] iArr = this.f28368g;
                int i4 = iArr[f2];
                iArr[f2] = iArr[f2] + i3;
                return i4;
            }
            int i5 = -(f2 + 1);
            K[] kArr = this.f28367f;
            kArr[i5] = k2;
            this.f28368g[i5] = i3 + i2;
            int i6 = this.f28366e + 1;
            this.f28366e = i6;
            if (i6 >= this.f28370i) {
                j(kArr.length << 1);
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: e */
    public a<K> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? b() : (a) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof v) {
                v vVar = (v) obj;
                if (vVar.f28366e != this.f28366e) {
                    return false;
                }
                K[] kArr = this.f28367f;
                int[] iArr = this.f28368g;
                int length = kArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    K k2 = kArr[i2];
                    if (k2 != null && (((c2 = vVar.c(k2, 0)) == 0 && !vVar.a(k2)) || c2 != iArr[i2])) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int f(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, k2)) != null) {
            return invokeL.intValue;
        }
        if (k2 != null) {
            K[] kArr = this.f28367f;
            int g2 = g(k2);
            while (true) {
                K k3 = kArr[g2];
                if (k3 == null) {
                    return -(g2 + 1);
                }
                if (k3.equals(k2)) {
                    return g2;
                }
                g2 = (g2 + 1) & this.f28372k;
            }
        } else {
            throw new IllegalArgumentException("key cannot be null.");
        }
    }

    public int g(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k2)) == null) ? (int) ((k2.hashCode() * (-7046029254386353131L)) >>> this.f28371j) : invokeL.intValue;
    }

    public void h(K k2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, k2, i2) == null) {
            int f2 = f(k2);
            if (f2 >= 0) {
                this.f28368g[f2] = i2;
                return;
            }
            int i3 = -(f2 + 1);
            K[] kArr = this.f28367f;
            kArr[i3] = k2;
            this.f28368g[i3] = i2;
            int i4 = this.f28366e + 1;
            this.f28366e = i4;
            if (i4 >= this.f28370i) {
                j(kArr.length << 1);
            }
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.f28366e;
            K[] kArr = this.f28367f;
            int[] iArr = this.f28368g;
            int length = kArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                K k2 = kArr[i3];
                if (k2 != null) {
                    i2 += k2.hashCode() + iArr[i3];
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final void i(K k2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, k2, i2) == null) {
            K[] kArr = this.f28367f;
            int g2 = g(k2);
            while (kArr[g2] != null) {
                g2 = (g2 + 1) & this.f28372k;
            }
            kArr[g2] = k2;
            this.f28368g[g2] = i2;
        }
    }

    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            int length = this.f28367f.length;
            this.f28370i = (int) (i2 * this.f28369h);
            int i3 = i2 - 1;
            this.f28372k = i3;
            this.f28371j = Long.numberOfLeadingZeros(i3);
            K[] kArr = this.f28367f;
            int[] iArr = this.f28368g;
            this.f28367f = (K[]) new Object[i2];
            this.f28368g = new int[i2];
            if (this.f28366e > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    K k2 = kArr[i4];
                    if (k2 != null) {
                        i(k2, iArr[i4]);
                    }
                }
            }
        }
    }

    public final String k(String str, boolean z) {
        InterceptResult invokeLZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, str, z)) == null) {
            if (this.f28366e == 0) {
                return z ? StringUtil.EMPTY_ARRAY : "";
            }
            StringBuilder sb = new StringBuilder(32);
            if (z) {
                sb.append(ExtendedMessageFormat.START_FE);
            }
            K[] kArr = this.f28367f;
            int[] iArr = this.f28368g;
            int length = kArr.length;
            while (true) {
                i2 = length - 1;
                if (length > 0) {
                    K k2 = kArr[i2];
                    if (k2 != null) {
                        sb.append(k2);
                        sb.append(com.alipay.sdk.encrypt.a.f31864h);
                        sb.append(iArr[i2]);
                        break;
                    }
                    length = i2;
                } else {
                    break;
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
                    sb.append(k3);
                    sb.append(com.alipay.sdk.encrypt.a.f31864h);
                    sb.append(iArr[i3]);
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? k(StringUtil.ARRAY_ELEMENT_SEPARATOR, true) : (String) invokeV.objValue;
    }

    public v(int i2, float f2) {
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
            this.f28369h = f2;
            int h2 = x.h(i2, f2);
            this.f28370i = (int) (h2 * f2);
            int i5 = h2 - 1;
            this.f28372k = i5;
            this.f28371j = Long.numberOfLeadingZeros(i5);
            this.f28367f = (K[]) new Object[h2];
            this.f28368g = new int[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
