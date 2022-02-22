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
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public class b<K, V> implements Iterable<w.b<K, V>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public K[] f27606e;

    /* renamed from: f  reason: collision with root package name */
    public V[] f27607f;

    /* renamed from: g  reason: collision with root package name */
    public int f27608g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27609h;

    /* renamed from: i  reason: collision with root package name */
    public transient a f27610i;

    /* renamed from: j  reason: collision with root package name */
    public transient a f27611j;

    /* loaded from: classes9.dex */
    public static class a<K, V> implements Iterable<w.b<K, V>>, Iterator<w.b<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final b<K, V> f27612e;

        /* renamed from: f  reason: collision with root package name */
        public w.b<K, V> f27613f;

        /* renamed from: g  reason: collision with root package name */
        public int f27614g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f27615h;

        public a(b<K, V> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27613f = new w.b<>();
            this.f27615h = true;
            this.f27612e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: b */
        public w.b<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f27614g;
                b<K, V> bVar = this.f27612e;
                if (i2 < bVar.f27608g) {
                    if (this.f27615h) {
                        w.b<K, V> bVar2 = this.f27613f;
                        bVar2.a = bVar.f27606e[i2];
                        V[] vArr = bVar.f27607f;
                        this.f27614g = i2 + 1;
                        bVar2.f27758b = vArr[i2];
                        return bVar2;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.f27614g));
            }
            return (w.b) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f27615h) {
                    return this.f27614g < this.f27612e.f27608g;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public Iterator<w.b<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (Iterator) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i2 = this.f27614g - 1;
                this.f27614g = i2;
                this.f27612e.g(i2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b() {
        this(true, 16);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Boolean) objArr[0]).booleanValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public a<K, V> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (f.a) {
                return new a<>(this);
            }
            if (this.f27610i == null) {
                this.f27610i = new a(this);
                this.f27611j = new a(this);
            }
            a<K, V> aVar = this.f27610i;
            if (!aVar.f27615h) {
                aVar.f27614g = 0;
                aVar.f27615h = true;
                this.f27611j.f27615h = false;
                return aVar;
            }
            a<K, V> aVar2 = this.f27611j;
            aVar2.f27614g = 0;
            aVar2.f27615h = true;
            aVar.f27615h = false;
            return aVar2;
        }
        return (a) invokeV.objValue;
    }

    public V c(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) ? d(k, null) : (V) invokeL.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Arrays.fill(this.f27606e, 0, this.f27608g, (Object) null);
            Arrays.fill(this.f27607f, 0, this.f27608g, (Object) null);
            this.f27608g = 0;
        }
    }

    public V d(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, k, v)) == null) {
            K[] kArr = this.f27606e;
            int i2 = this.f27608g - 1;
            if (k == null) {
                while (i2 >= 0) {
                    if (kArr[i2] == k) {
                        return this.f27607f[i2];
                    }
                    i2--;
                }
            } else {
                while (i2 >= 0) {
                    if (k.equals(kArr[i2])) {
                        return this.f27607f[i2];
                    }
                    i2--;
                }
            }
            return v;
        }
        return (V) invokeLL.objValue;
    }

    public int e(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k)) == null) {
            K[] kArr = this.f27606e;
            int i2 = 0;
            if (k == null) {
                int i3 = this.f27608g;
                while (i2 < i3) {
                    if (kArr[i2] == k) {
                        return i2;
                    }
                    i2++;
                }
                return -1;
            }
            int i4 = this.f27608g;
            while (i2 < i4) {
                if (k.equals(kArr[i2])) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v1, resolved type: c.b.b.q.b */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                int i2 = bVar.f27608g;
                int i3 = this.f27608g;
                if (i2 != i3) {
                    return false;
                }
                K[] kArr = this.f27606e;
                V[] vArr = this.f27607f;
                for (int i4 = 0; i4 < i3; i4++) {
                    K k = kArr[i4];
                    V v = vArr[i4];
                    if (v == null) {
                        if (bVar.d(k, w.r) != null) {
                            return false;
                        }
                    } else if (!v.equals(bVar.c(k))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int f(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, k, v)) == null) {
            int e2 = e(k);
            if (e2 == -1) {
                int i2 = this.f27608g;
                if (i2 == this.f27606e.length) {
                    h(Math.max(8, (int) (i2 * 1.75f)));
                }
                e2 = this.f27608g;
                this.f27608g = e2 + 1;
            }
            this.f27606e[e2] = k;
            this.f27607f[e2] = v;
            return e2;
        }
        return invokeLL.intValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            int i3 = this.f27608g;
            if (i2 < i3) {
                K[] kArr = this.f27606e;
                int i4 = i3 - 1;
                this.f27608g = i4;
                if (this.f27609h) {
                    int i5 = i2 + 1;
                    System.arraycopy(kArr, i5, kArr, i2, i4 - i2);
                    V[] vArr = this.f27607f;
                    System.arraycopy(vArr, i5, vArr, i2, this.f27608g - i2);
                } else {
                    kArr[i2] = kArr[i4];
                    V[] vArr2 = this.f27607f;
                    vArr2[i2] = vArr2[i4];
                }
                int i6 = this.f27608g;
                kArr[i6] = null;
                this.f27607f[i6] = null;
                return;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i2));
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            K[] kArr = (K[]) ((Object[]) c.b.b.q.p0.a.a(this.f27606e.getClass().getComponentType(), i2));
            System.arraycopy(this.f27606e, 0, kArr, 0, Math.min(this.f27608g, kArr.length));
            this.f27606e = kArr;
            V[] vArr = (V[]) ((Object[]) c.b.b.q.p0.a.a(this.f27607f.getClass().getComponentType(), i2));
            System.arraycopy(this.f27607f, 0, vArr, 0, Math.min(this.f27608g, vArr.length));
            this.f27607f = vArr;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            K[] kArr = this.f27606e;
            V[] vArr = this.f27607f;
            int i2 = this.f27608g;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                K k = kArr[i4];
                V v = vArr[i4];
                if (k != null) {
                    i3 += k.hashCode() * 31;
                }
                if (v != null) {
                    i3 += v.hashCode();
                }
            }
            return i3;
        }
        return invokeV.intValue;
    }

    public void insert(int i2, K k, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048586, this, i2, k, v) == null) {
            int i3 = this.f27608g;
            if (i2 <= i3) {
                if (i3 == this.f27606e.length) {
                    h(Math.max(8, (int) (i3 * 1.75f)));
                }
                if (this.f27609h) {
                    K[] kArr = this.f27606e;
                    int i4 = i2 + 1;
                    System.arraycopy(kArr, i2, kArr, i4, this.f27608g - i2);
                    V[] vArr = this.f27607f;
                    System.arraycopy(vArr, i2, vArr, i4, this.f27608g - i2);
                } else {
                    K[] kArr2 = this.f27606e;
                    int i5 = this.f27608g;
                    kArr2[i5] = kArr2[i2];
                    V[] vArr2 = this.f27607f;
                    vArr2[i5] = vArr2[i2];
                }
                this.f27608g++;
                this.f27606e[i2] = k;
                this.f27607f[i2] = v;
                return;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i2));
        }
    }

    @Override // java.lang.Iterable
    public Iterator<w.b<K, V>> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? b() : (Iterator) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f27608g == 0) {
                return StringUtil.EMPTY_ARRAY;
            }
            K[] kArr = this.f27606e;
            V[] vArr = this.f27607f;
            j0 j0Var = new j0(32);
            j0Var.a(ExtendedMessageFormat.START_FE);
            j0Var.m(kArr[0]);
            j0Var.a(com.alipay.sdk.encrypt.a.f31099h);
            j0Var.m(vArr[0]);
            for (int i2 = 1; i2 < this.f27608g; i2++) {
                j0Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                j0Var.m(kArr[i2]);
                j0Var.a(com.alipay.sdk.encrypt.a.f31099h);
                j0Var.m(vArr[i2]);
            }
            j0Var.a(ExtendedMessageFormat.END_FE);
            return j0Var.toString();
        }
        return (String) invokeV.objValue;
    }

    public b(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f27609h = z;
        this.f27606e = (K[]) new Object[i2];
        this.f27607f = (V[]) new Object[i2];
    }

    public b(boolean z, int i2, Class cls, Class cls2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), cls, cls2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f27609h = z;
        this.f27606e = (K[]) ((Object[]) c.b.b.q.p0.a.a(cls, i2));
        this.f27607f = (V[]) ((Object[]) c.b.b.q.p0.a.a(cls2, i2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Class cls, Class cls2) {
        this(false, 16, cls, cls2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, cls2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (Class) objArr2[2], (Class) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
