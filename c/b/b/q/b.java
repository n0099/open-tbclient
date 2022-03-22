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
/* loaded from: classes3.dex */
public class b<K, V> implements Iterable<w.b<K, V>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public K[] a;

    /* renamed from: b  reason: collision with root package name */
    public V[] f22726b;

    /* renamed from: c  reason: collision with root package name */
    public int f22727c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22728d;

    /* renamed from: e  reason: collision with root package name */
    public transient a f22729e;

    /* renamed from: f  reason: collision with root package name */
    public transient a f22730f;

    /* loaded from: classes3.dex */
    public static class a<K, V> implements Iterable<w.b<K, V>>, Iterator<w.b<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b<K, V> a;

        /* renamed from: b  reason: collision with root package name */
        public w.b<K, V> f22731b;

        /* renamed from: c  reason: collision with root package name */
        public int f22732c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f22733d;

        public a(b<K, V> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22731b = new w.b<>();
            this.f22733d = true;
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: b */
        public w.b<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = this.f22732c;
                b<K, V> bVar = this.a;
                if (i < bVar.f22727c) {
                    if (this.f22733d) {
                        w.b<K, V> bVar2 = this.f22731b;
                        bVar2.a = bVar.a[i];
                        V[] vArr = bVar.f22726b;
                        this.f22732c = i + 1;
                        bVar2.f22866b = vArr[i];
                        return bVar2;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.f22732c));
            }
            return (w.b) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f22733d) {
                    return this.f22732c < this.a.f22727c;
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
                int i = this.f22732c - 1;
                this.f22732c = i;
                this.a.g(i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (this.f22729e == null) {
                this.f22729e = new a(this);
                this.f22730f = new a(this);
            }
            a<K, V> aVar = this.f22729e;
            if (!aVar.f22733d) {
                aVar.f22732c = 0;
                aVar.f22733d = true;
                this.f22730f.f22733d = false;
                return aVar;
            }
            a<K, V> aVar2 = this.f22730f;
            aVar2.f22732c = 0;
            aVar2.f22733d = true;
            aVar.f22733d = false;
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
            Arrays.fill(this.a, 0, this.f22727c, (Object) null);
            Arrays.fill(this.f22726b, 0, this.f22727c, (Object) null);
            this.f22727c = 0;
        }
    }

    public V d(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, k, v)) == null) {
            K[] kArr = this.a;
            int i = this.f22727c - 1;
            if (k == null) {
                while (i >= 0) {
                    if (kArr[i] == k) {
                        return this.f22726b[i];
                    }
                    i--;
                }
            } else {
                while (i >= 0) {
                    if (k.equals(kArr[i])) {
                        return this.f22726b[i];
                    }
                    i--;
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
            K[] kArr = this.a;
            int i = 0;
            if (k == null) {
                int i2 = this.f22727c;
                while (i < i2) {
                    if (kArr[i] == k) {
                        return i;
                    }
                    i++;
                }
                return -1;
            }
            int i3 = this.f22727c;
            while (i < i3) {
                if (k.equals(kArr[i])) {
                    return i;
                }
                i++;
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
                int i = bVar.f22727c;
                int i2 = this.f22727c;
                if (i != i2) {
                    return false;
                }
                K[] kArr = this.a;
                V[] vArr = this.f22726b;
                for (int i3 = 0; i3 < i2; i3++) {
                    K k = kArr[i3];
                    V v = vArr[i3];
                    if (v == null) {
                        if (bVar.d(k, w.n) != null) {
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
                int i = this.f22727c;
                if (i == this.a.length) {
                    h(Math.max(8, (int) (i * 1.75f)));
                }
                e2 = this.f22727c;
                this.f22727c = e2 + 1;
            }
            this.a[e2] = k;
            this.f22726b[e2] = v;
            return e2;
        }
        return invokeLL.intValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            int i2 = this.f22727c;
            if (i < i2) {
                K[] kArr = this.a;
                int i3 = i2 - 1;
                this.f22727c = i3;
                if (this.f22728d) {
                    int i4 = i + 1;
                    System.arraycopy(kArr, i4, kArr, i, i3 - i);
                    V[] vArr = this.f22726b;
                    System.arraycopy(vArr, i4, vArr, i, this.f22727c - i);
                } else {
                    kArr[i] = kArr[i3];
                    V[] vArr2 = this.f22726b;
                    vArr2[i] = vArr2[i3];
                }
                int i5 = this.f22727c;
                kArr[i5] = null;
                this.f22726b[i5] = null;
                return;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            K[] kArr = (K[]) ((Object[]) c.b.b.q.p0.a.a(this.a.getClass().getComponentType(), i));
            System.arraycopy(this.a, 0, kArr, 0, Math.min(this.f22727c, kArr.length));
            this.a = kArr;
            V[] vArr = (V[]) ((Object[]) c.b.b.q.p0.a.a(this.f22726b.getClass().getComponentType(), i));
            System.arraycopy(this.f22726b, 0, vArr, 0, Math.min(this.f22727c, vArr.length));
            this.f22726b = vArr;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            K[] kArr = this.a;
            V[] vArr = this.f22726b;
            int i = this.f22727c;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                K k = kArr[i3];
                V v = vArr[i3];
                if (k != null) {
                    i2 += k.hashCode() * 31;
                }
                if (v != null) {
                    i2 += v.hashCode();
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void insert(int i, K k, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048586, this, i, k, v) == null) {
            int i2 = this.f22727c;
            if (i <= i2) {
                if (i2 == this.a.length) {
                    h(Math.max(8, (int) (i2 * 1.75f)));
                }
                if (this.f22728d) {
                    K[] kArr = this.a;
                    int i3 = i + 1;
                    System.arraycopy(kArr, i, kArr, i3, this.f22727c - i);
                    V[] vArr = this.f22726b;
                    System.arraycopy(vArr, i, vArr, i3, this.f22727c - i);
                } else {
                    K[] kArr2 = this.a;
                    int i4 = this.f22727c;
                    kArr2[i4] = kArr2[i];
                    V[] vArr2 = this.f22726b;
                    vArr2[i4] = vArr2[i];
                }
                this.f22727c++;
                this.a[i] = k;
                this.f22726b[i] = v;
                return;
            }
            throw new IndexOutOfBoundsException(String.valueOf(i));
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
            if (this.f22727c == 0) {
                return StringUtil.EMPTY_ARRAY;
            }
            K[] kArr = this.a;
            V[] vArr = this.f22726b;
            j0 j0Var = new j0(32);
            j0Var.a('{');
            j0Var.m(kArr[0]);
            j0Var.a('=');
            j0Var.m(vArr[0]);
            for (int i = 1; i < this.f22727c; i++) {
                j0Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                j0Var.m(kArr[i]);
                j0Var.a('=');
                j0Var.m(vArr[i]);
            }
            j0Var.a('}');
            return j0Var.toString();
        }
        return (String) invokeV.objValue;
    }

    public b(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f22728d = z;
        this.a = (K[]) new Object[i];
        this.f22726b = (V[]) new Object[i];
    }

    public b(boolean z, int i, Class cls, Class cls2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), cls, cls2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f22728d = z;
        this.a = (K[]) ((Object[]) c.b.b.q.p0.a.a(cls, i));
        this.f22726b = (V[]) ((Object[]) c.b.b.q.p0.a.a(cls2, i));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (Class) objArr2[2], (Class) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
