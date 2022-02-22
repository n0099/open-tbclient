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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public class u<K> implements Iterable<b<K>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f27725e;

    /* renamed from: f  reason: collision with root package name */
    public K[] f27726f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f27727g;

    /* renamed from: h  reason: collision with root package name */
    public float f27728h;

    /* renamed from: i  reason: collision with root package name */
    public int f27729i;

    /* renamed from: j  reason: collision with root package name */
    public int f27730j;
    public int k;
    public transient a l;
    public transient a m;

    /* loaded from: classes9.dex */
    public static class a<K> extends c<K> implements Iterable<b<K>>, Iterator<b<K>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: j  reason: collision with root package name */
        public b<K> f27731j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u<K> uVar) {
            super(uVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((u) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27731j = new b<>();
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
                if (this.f27733e) {
                    if (this.f27737i) {
                        u<K> uVar = this.f27734f;
                        K[] kArr = uVar.f27726f;
                        b<K> bVar = this.f27731j;
                        int i2 = this.f27735g;
                        bVar.a = kArr[i2];
                        bVar.f27732b = uVar.f27727g[i2];
                        this.f27736h = i2;
                        b();
                        return this.f27731j;
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
                if (this.f27737i) {
                    return this.f27733e;
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
        public float f27732b;

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
                return this.a + "=" + this.f27732b;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27733e;

        /* renamed from: f  reason: collision with root package name */
        public final u<K> f27734f;

        /* renamed from: g  reason: collision with root package name */
        public int f27735g;

        /* renamed from: h  reason: collision with root package name */
        public int f27736h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f27737i;

        public c(u<K> uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27737i = true;
            this.f27734f = uVar;
            c();
        }

        public void b() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                K[] kArr = this.f27734f.f27726f;
                int length = kArr.length;
                do {
                    i2 = this.f27735g + 1;
                    this.f27735g = i2;
                    if (i2 >= length) {
                        this.f27733e = false;
                        return;
                    }
                } while (kArr[i2] == null);
                this.f27733e = true;
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f27736h = -1;
                this.f27735g = -1;
                b();
            }
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i2 = this.f27736h;
                if (i2 >= 0) {
                    u<K> uVar = this.f27734f;
                    K[] kArr = uVar.f27726f;
                    float[] fArr = uVar.f27727g;
                    int i3 = uVar.k;
                    int i4 = i2 + 1;
                    while (true) {
                        int i5 = i4 & i3;
                        K k = kArr[i5];
                        if (k == null) {
                            break;
                        }
                        int f2 = this.f27734f.f(k);
                        if (((i5 - f2) & i3) > ((i2 - f2) & i3)) {
                            kArr[i2] = k;
                            fArr[i2] = fArr[i5];
                            i2 = i5;
                        }
                        i4 = i5 + 1;
                    }
                    kArr[i2] = null;
                    u<K> uVar2 = this.f27734f;
                    uVar2.f27725e--;
                    if (i2 != this.f27736h) {
                        this.f27735g--;
                    }
                    this.f27736h = -1;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u() {
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

    public boolean a(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) ? e(k) >= 0 : invokeL.booleanValue;
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
            if (!aVar.f27737i) {
                aVar.c();
                a<K> aVar2 = this.l;
                aVar2.f27737i = true;
                this.m.f27737i = false;
                return aVar2;
            }
            this.m.c();
            a<K> aVar3 = this.m;
            aVar3.f27737i = true;
            this.l.f27737i = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public float c(K k, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, k, f2)) == null) {
            int e2 = e(k);
            return e2 < 0 ? f2 : this.f27727g[e2];
        }
        return invokeLF.floatValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: d */
    public a<K> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b() : (a) invokeV.objValue;
    }

    public int e(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, k)) != null) {
            return invokeL.intValue;
        }
        if (k != null) {
            K[] kArr = this.f27726f;
            int f2 = f(k);
            while (true) {
                K k2 = kArr[f2];
                if (k2 == null) {
                    return -(f2 + 1);
                }
                if (k2.equals(k)) {
                    return f2;
                }
                f2 = (f2 + 1) & this.k;
            }
        } else {
            throw new IllegalArgumentException("key cannot be null.");
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof u) {
                u uVar = (u) obj;
                if (uVar.f27725e != this.f27725e) {
                    return false;
                }
                K[] kArr = this.f27726f;
                float[] fArr = this.f27727g;
                int length = kArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    K k = kArr[i2];
                    if (k != null) {
                        float c2 = uVar.c(k, 0.0f);
                        if ((c2 == 0.0f && !uVar.a(k)) || c2 != fArr[i2]) {
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

    public int f(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) ? (int) ((k.hashCode() * (-7046029254386353131L)) >>> this.f27730j) : invokeL.intValue;
    }

    public void g(K k, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048583, this, k, f2) == null) {
            int e2 = e(k);
            if (e2 >= 0) {
                this.f27727g[e2] = f2;
                return;
            }
            int i2 = -(e2 + 1);
            K[] kArr = this.f27726f;
            kArr[i2] = k;
            this.f27727g[i2] = f2;
            int i3 = this.f27725e + 1;
            this.f27725e = i3;
            if (i3 >= this.f27729i) {
                i(kArr.length << 1);
            }
        }
    }

    public final void h(K k, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, k, f2) == null) {
            K[] kArr = this.f27726f;
            int f3 = f(k);
            while (kArr[f3] != null) {
                f3 = (f3 + 1) & this.k;
            }
            kArr[f3] = k;
            this.f27727g[f3] = f2;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f27725e;
            K[] kArr = this.f27726f;
            float[] fArr = this.f27727g;
            int length = kArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                K k = kArr[i3];
                if (k != null) {
                    i2 += k.hashCode() + t.b(fArr[i3]);
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            int length = this.f27726f.length;
            this.f27729i = (int) (i2 * this.f27728h);
            int i3 = i2 - 1;
            this.k = i3;
            this.f27730j = Long.numberOfLeadingZeros(i3);
            K[] kArr = this.f27726f;
            float[] fArr = this.f27727g;
            this.f27726f = (K[]) new Object[i2];
            this.f27727g = new float[i2];
            if (this.f27725e > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    K k = kArr[i4];
                    if (k != null) {
                        h(k, fArr[i4]);
                    }
                }
            }
        }
    }

    public final String j(String str, boolean z) {
        InterceptResult invokeLZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) {
            if (this.f27725e == 0) {
                return z ? StringUtil.EMPTY_ARRAY : "";
            }
            StringBuilder sb = new StringBuilder(32);
            if (z) {
                sb.append(ExtendedMessageFormat.START_FE);
            }
            K[] kArr = this.f27726f;
            float[] fArr = this.f27727g;
            int length = kArr.length;
            while (true) {
                i2 = length - 1;
                if (length > 0) {
                    K k = kArr[i2];
                    if (k != null) {
                        sb.append(k);
                        sb.append(com.alipay.sdk.encrypt.a.f31099h);
                        sb.append(fArr[i2]);
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
                K k2 = kArr[i3];
                if (k2 != null) {
                    sb.append(str);
                    sb.append(k2);
                    sb.append(com.alipay.sdk.encrypt.a.f31099h);
                    sb.append(fArr[i3]);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? j(StringUtil.ARRAY_ELEMENT_SEPARATOR, true) : (String) invokeV.objValue;
    }

    public u(int i2, float f2) {
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
            this.f27728h = f2;
            int h2 = x.h(i2, f2);
            this.f27729i = (int) (h2 * f2);
            int i5 = h2 - 1;
            this.k = i5;
            this.f27730j = Long.numberOfLeadingZeros(i5);
            this.f27726f = (K[]) new Object[h2];
            this.f27727g = new float[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
