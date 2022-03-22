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
public class u<K> implements Iterable<b<K>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public K[] f22832b;

    /* renamed from: c  reason: collision with root package name */
    public float[] f22833c;

    /* renamed from: d  reason: collision with root package name */
    public float f22834d;

    /* renamed from: e  reason: collision with root package name */
    public int f22835e;

    /* renamed from: f  reason: collision with root package name */
    public int f22836f;

    /* renamed from: g  reason: collision with root package name */
    public int f22837g;

    /* renamed from: h  reason: collision with root package name */
    public transient a f22838h;
    public transient a i;

    /* loaded from: classes3.dex */
    public static class a<K> extends c<K> implements Iterable<b<K>>, Iterator<b<K>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public b<K> f22839f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u<K> uVar) {
            super(uVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((u) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22839f = new b<>();
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
                    if (this.f22844e) {
                        u<K> uVar = this.f22841b;
                        K[] kArr = uVar.f22832b;
                        b<K> bVar = this.f22839f;
                        int i = this.f22842c;
                        bVar.a = kArr[i];
                        bVar.f22840b = uVar.f22833c[i];
                        this.f22843d = i;
                        b();
                        return this.f22839f;
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
                if (this.f22844e) {
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
        public float f22840b;

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
                return this.a + "=" + this.f22840b;
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
        public final u<K> f22841b;

        /* renamed from: c  reason: collision with root package name */
        public int f22842c;

        /* renamed from: d  reason: collision with root package name */
        public int f22843d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22844e;

        public c(u<K> uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22844e = true;
            this.f22841b = uVar;
            c();
        }

        public void b() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                K[] kArr = this.f22841b.f22832b;
                int length = kArr.length;
                do {
                    i = this.f22842c + 1;
                    this.f22842c = i;
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
                this.f22843d = -1;
                this.f22842c = -1;
                b();
            }
        }

        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                int i = this.f22843d;
                if (i >= 0) {
                    u<K> uVar = this.f22841b;
                    K[] kArr = uVar.f22832b;
                    float[] fArr = uVar.f22833c;
                    int i2 = uVar.f22837g;
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3 & i2;
                        K k = kArr[i4];
                        if (k == null) {
                            break;
                        }
                        int f2 = this.f22841b.f(k);
                        if (((i4 - f2) & i2) > ((i - f2) & i2)) {
                            kArr[i] = k;
                            fArr[i] = fArr[i4];
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    kArr[i] = null;
                    u<K> uVar2 = this.f22841b;
                    uVar2.a--;
                    if (i != this.f22843d) {
                        this.f22842c--;
                    }
                    this.f22843d = -1;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) ? e(k) >= 0 : invokeL.booleanValue;
    }

    public a<K> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (f.a) {
                return new a<>(this);
            }
            if (this.f22838h == null) {
                this.f22838h = new a(this);
                this.i = new a(this);
            }
            a aVar = this.f22838h;
            if (!aVar.f22844e) {
                aVar.c();
                a<K> aVar2 = this.f22838h;
                aVar2.f22844e = true;
                this.i.f22844e = false;
                return aVar2;
            }
            this.i.c();
            a<K> aVar3 = this.i;
            aVar3.f22844e = true;
            this.f22838h.f22844e = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public float c(K k, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, k, f2)) == null) {
            int e2 = e(k);
            return e2 < 0 ? f2 : this.f22833c[e2];
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
            K[] kArr = this.f22832b;
            int f2 = f(k);
            while (true) {
                K k2 = kArr[f2];
                if (k2 == null) {
                    return -(f2 + 1);
                }
                if (k2.equals(k)) {
                    return f2;
                }
                f2 = (f2 + 1) & this.f22837g;
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
                if (uVar.a != this.a) {
                    return false;
                }
                K[] kArr = this.f22832b;
                float[] fArr = this.f22833c;
                int length = kArr.length;
                for (int i = 0; i < length; i++) {
                    K k = kArr[i];
                    if (k != null) {
                        float c2 = uVar.c(k, 0.0f);
                        if ((c2 == 0.0f && !uVar.a(k)) || c2 != fArr[i]) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k)) == null) ? (int) ((k.hashCode() * (-7046029254386353131L)) >>> this.f22836f) : invokeL.intValue;
    }

    public void g(K k, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048583, this, k, f2) == null) {
            int e2 = e(k);
            if (e2 >= 0) {
                this.f22833c[e2] = f2;
                return;
            }
            int i = -(e2 + 1);
            K[] kArr = this.f22832b;
            kArr[i] = k;
            this.f22833c[i] = f2;
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 >= this.f22835e) {
                i(kArr.length << 1);
            }
        }
    }

    public final void h(K k, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, k, f2) == null) {
            K[] kArr = this.f22832b;
            int f3 = f(k);
            while (kArr[f3] != null) {
                f3 = (f3 + 1) & this.f22837g;
            }
            kArr[f3] = k;
            this.f22833c[f3] = f2;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.a;
            K[] kArr = this.f22832b;
            float[] fArr = this.f22833c;
            int length = kArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                K k = kArr[i2];
                if (k != null) {
                    i += k.hashCode() + t.b(fArr[i2]);
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            int length = this.f22832b.length;
            this.f22835e = (int) (i * this.f22834d);
            int i2 = i - 1;
            this.f22837g = i2;
            this.f22836f = Long.numberOfLeadingZeros(i2);
            K[] kArr = this.f22832b;
            float[] fArr = this.f22833c;
            this.f22832b = (K[]) new Object[i];
            this.f22833c = new float[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    K k = kArr[i3];
                    if (k != null) {
                        h(k, fArr[i3]);
                    }
                }
            }
        }
    }

    public final String j(String str, boolean z) {
        InterceptResult invokeLZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) {
            if (this.a == 0) {
                return z ? StringUtil.EMPTY_ARRAY : "";
            }
            StringBuilder sb = new StringBuilder(32);
            if (z) {
                sb.append('{');
            }
            K[] kArr = this.f22832b;
            float[] fArr = this.f22833c;
            int length = kArr.length;
            while (true) {
                i = length - 1;
                if (length > 0) {
                    K k = kArr[i];
                    if (k != null) {
                        sb.append(k);
                        sb.append('=');
                        sb.append(fArr[i]);
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
                    sb.append(fArr[i2]);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? j(StringUtil.ARRAY_ELEMENT_SEPARATOR, true) : (String) invokeV.objValue;
    }

    public u(int i, float f2) {
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
            this.f22834d = f2;
            int h2 = x.h(i, f2);
            this.f22835e = (int) (h2 * f2);
            int i4 = h2 - 1;
            this.f22837g = i4;
            this.f22836f = Long.numberOfLeadingZeros(i4);
            this.f22832b = (K[]) new Object[h2];
            this.f22833c = new float[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
