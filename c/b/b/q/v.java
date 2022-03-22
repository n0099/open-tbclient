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
/* loaded from: classes3.dex */
public class v<K> implements Iterable<b<K>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public K[] f22845b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f22846c;

    /* renamed from: d  reason: collision with root package name */
    public float f22847d;

    /* renamed from: e  reason: collision with root package name */
    public int f22848e;

    /* renamed from: f  reason: collision with root package name */
    public int f22849f;

    /* renamed from: g  reason: collision with root package name */
    public int f22850g;

    /* renamed from: h  reason: collision with root package name */
    public transient a f22851h;
    public transient a i;

    /* loaded from: classes3.dex */
    public static class a<K> extends c<K> implements Iterable<b<K>>, Iterator<b<K>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public b<K> f22852f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v<K> vVar) {
            super(vVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((v) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22852f = new b<>();
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
                if (this.a) {
                    if (this.f22857e) {
                        v<K> vVar = this.f22854b;
                        K[] kArr = vVar.f22845b;
                        b<K> bVar = this.f22852f;
                        int i = this.f22855c;
                        bVar.a = kArr[i];
                        bVar.f22853b = vVar.f22846c[i];
                        this.f22856d = i;
                        b();
                        return this.f22852f;
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
                if (this.f22857e) {
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
    public static class b<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public K a;

        /* renamed from: b  reason: collision with root package name */
        public int f22853b;

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
                return this.a + "=" + this.f22853b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final v<K> f22854b;

        /* renamed from: c  reason: collision with root package name */
        public int f22855c;

        /* renamed from: d  reason: collision with root package name */
        public int f22856d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22857e;

        public c(v<K> vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22857e = true;
            this.f22854b = vVar;
            c();
        }

        public void b() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                K[] kArr = this.f22854b.f22845b;
                int length = kArr.length;
                do {
                    i = this.f22855c + 1;
                    this.f22855c = i;
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
                this.f22856d = -1;
                this.f22855c = -1;
                b();
            }
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.f22856d;
                if (i >= 0) {
                    v<K> vVar = this.f22854b;
                    K[] kArr = vVar.f22845b;
                    int[] iArr = vVar.f22846c;
                    int i2 = vVar.f22850g;
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3 & i2;
                        K k = kArr[i4];
                        if (k == null) {
                            break;
                        }
                        int g2 = this.f22854b.g(k);
                        if (((i4 - g2) & i2) > ((i - g2) & i2)) {
                            kArr[i] = k;
                            iArr[i] = iArr[i4];
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    kArr[i] = null;
                    v<K> vVar2 = this.f22854b;
                    vVar2.a--;
                    if (i != this.f22856d) {
                        this.f22855c--;
                    }
                    this.f22856d = -1;
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

    public boolean a(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) ? f(k) >= 0 : invokeL.booleanValue;
    }

    public a<K> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (f.a) {
                return new a<>(this);
            }
            if (this.f22851h == null) {
                this.f22851h = new a(this);
                this.i = new a(this);
            }
            a aVar = this.f22851h;
            if (!aVar.f22857e) {
                aVar.c();
                a<K> aVar2 = this.f22851h;
                aVar2.f22857e = true;
                this.i.f22857e = false;
                return aVar2;
            }
            this.i.c();
            a<K> aVar3 = this.i;
            aVar3.f22857e = true;
            this.f22851h.f22857e = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public int c(K k, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, k, i)) == null) {
            int f2 = f(k);
            return f2 < 0 ? i : this.f22846c[f2];
        }
        return invokeLI.intValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a == 0) {
            return;
        }
        this.a = 0;
        Arrays.fill(this.f22845b, (Object) null);
    }

    public int d(K k, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, k, i, i2)) == null) {
            int f2 = f(k);
            if (f2 >= 0) {
                int[] iArr = this.f22846c;
                int i3 = iArr[f2];
                iArr[f2] = iArr[f2] + i2;
                return i3;
            }
            int i4 = -(f2 + 1);
            K[] kArr = this.f22845b;
            kArr[i4] = k;
            this.f22846c[i4] = i2 + i;
            int i5 = this.a + 1;
            this.a = i5;
            if (i5 >= this.f22848e) {
                j(kArr.length << 1);
            }
            return i;
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
                if (vVar.a != this.a) {
                    return false;
                }
                K[] kArr = this.f22845b;
                int[] iArr = this.f22846c;
                int length = kArr.length;
                for (int i = 0; i < length; i++) {
                    K k = kArr[i];
                    if (k != null && (((c2 = vVar.c(k, 0)) == 0 && !vVar.a(k)) || c2 != iArr[i])) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int f(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, k)) != null) {
            return invokeL.intValue;
        }
        if (k != null) {
            K[] kArr = this.f22845b;
            int g2 = g(k);
            while (true) {
                K k2 = kArr[g2];
                if (k2 == null) {
                    return -(g2 + 1);
                }
                if (k2.equals(k)) {
                    return g2;
                }
                g2 = (g2 + 1) & this.f22850g;
            }
        } else {
            throw new IllegalArgumentException("key cannot be null.");
        }
    }

    public int g(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k)) == null) ? (int) ((k.hashCode() * (-7046029254386353131L)) >>> this.f22849f) : invokeL.intValue;
    }

    public void h(K k, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, k, i) == null) {
            int f2 = f(k);
            if (f2 >= 0) {
                this.f22846c[f2] = i;
                return;
            }
            int i2 = -(f2 + 1);
            K[] kArr = this.f22845b;
            kArr[i2] = k;
            this.f22846c[i2] = i;
            int i3 = this.a + 1;
            this.a = i3;
            if (i3 >= this.f22848e) {
                j(kArr.length << 1);
            }
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.a;
            K[] kArr = this.f22845b;
            int[] iArr = this.f22846c;
            int length = kArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                K k = kArr[i2];
                if (k != null) {
                    i += k.hashCode() + iArr[i2];
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void i(K k, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, k, i) == null) {
            K[] kArr = this.f22845b;
            int g2 = g(k);
            while (kArr[g2] != null) {
                g2 = (g2 + 1) & this.f22850g;
            }
            kArr[g2] = k;
            this.f22846c[g2] = i;
        }
    }

    public final void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            int length = this.f22845b.length;
            this.f22848e = (int) (i * this.f22847d);
            int i2 = i - 1;
            this.f22850g = i2;
            this.f22849f = Long.numberOfLeadingZeros(i2);
            K[] kArr = this.f22845b;
            int[] iArr = this.f22846c;
            this.f22845b = (K[]) new Object[i];
            this.f22846c = new int[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    K k = kArr[i3];
                    if (k != null) {
                        i(k, iArr[i3]);
                    }
                }
            }
        }
    }

    public final String k(String str, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, str, z)) == null) {
            if (this.a == 0) {
                return z ? StringUtil.EMPTY_ARRAY : "";
            }
            StringBuilder sb = new StringBuilder(32);
            if (z) {
                sb.append('{');
            }
            K[] kArr = this.f22845b;
            int[] iArr = this.f22846c;
            int length = kArr.length;
            while (true) {
                i = length - 1;
                if (length > 0) {
                    K k = kArr[i];
                    if (k != null) {
                        sb.append(k);
                        sb.append('=');
                        sb.append(iArr[i]);
                        break;
                    }
                    length = i;
                } else {
                    break;
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
                    sb.append(k2);
                    sb.append('=');
                    sb.append(iArr[i2]);
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? k(StringUtil.ARRAY_ELEMENT_SEPARATOR, true) : (String) invokeV.objValue;
    }

    public v(int i, float f2) {
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
            this.f22847d = f2;
            int h2 = x.h(i, f2);
            this.f22848e = (int) (h2 * f2);
            int i4 = h2 - 1;
            this.f22850g = i4;
            this.f22849f = Long.numberOfLeadingZeros(i4);
            this.f22845b = (K[]) new Object[h2];
            this.f22846c = new int[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
