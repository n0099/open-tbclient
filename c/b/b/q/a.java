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
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes3.dex */
public class a<T> implements Iterable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f22717b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22718c;

    /* renamed from: d  reason: collision with root package name */
    public C1651a f22719d;

    /* renamed from: c.b.b.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1651a<T> implements Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final a<T> a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f22720b;

        /* renamed from: c  reason: collision with root package name */
        public b f22721c;

        /* renamed from: d  reason: collision with root package name */
        public b f22722d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C1651a(a<T> aVar) {
            this(aVar, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((a) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Iterable
        /* renamed from: b */
        public b<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (f.a) {
                    return new b<>(this.a, this.f22720b);
                }
                if (this.f22721c == null) {
                    this.f22721c = new b(this.a, this.f22720b);
                    this.f22722d = new b(this.a, this.f22720b);
                }
                b<T> bVar = this.f22721c;
                if (!bVar.f22725d) {
                    bVar.f22724c = 0;
                    bVar.f22725d = true;
                    this.f22722d.f22725d = false;
                    return bVar;
                }
                b<T> bVar2 = this.f22722d;
                bVar2.f22724c = 0;
                bVar2.f22725d = true;
                bVar.f22725d = false;
                return bVar2;
            }
            return (b) invokeV.objValue;
        }

        public C1651a(a<T> aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f22720b = z;
        }
    }

    /* loaded from: classes3.dex */
    public static class b<T> implements Iterator<T>, Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final a<T> a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f22723b;

        /* renamed from: c  reason: collision with root package name */
        public int f22724c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f22725d;

        public b(a<T> aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22725d = true;
            this.a = aVar;
            this.f22723b = z;
        }

        public b<T> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (b) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f22725d) {
                    return this.f22724c < this.a.f22717b;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            b();
            return this;
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i = this.f22724c;
                a<T> aVar = this.a;
                if (i < aVar.f22717b) {
                    if (this.f22725d) {
                        T[] tArr = aVar.a;
                        this.f22724c = i + 1;
                        return tArr[i];
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.f22724c));
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.f22723b) {
                    int i = this.f22724c - 1;
                    this.f22724c = i;
                    this.a.i(i);
                    return;
                }
                throw new GdxRuntimeException("Remove not allowed.");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
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

    public static <T> a<T> o(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tArr)) == null) ? new a<>(tArr) : (a) invokeL.objValue;
    }

    public void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            T[] tArr = this.a;
            int i = this.f22717b;
            if (i == tArr.length) {
                tArr = k(Math.max(8, (int) (i * 1.75f)));
            }
            int i2 = this.f22717b;
            this.f22717b = i2 + 1;
            tArr[i2] = t;
        }
    }

    public void b(a<? extends T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            d(aVar.a, 0, aVar.f22717b);
        }
    }

    public void c(a<? extends T> aVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, aVar, i, i2) == null) {
            if (i + i2 <= aVar.f22717b) {
                d(aVar.a, i, i2);
                return;
            }
            throw new IllegalArgumentException("start + count must be <= size: " + i + " + " + i2 + " <= " + aVar.f22717b);
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Arrays.fill(this.a, 0, this.f22717b, (Object) null);
            this.f22717b = 0;
        }
    }

    public void d(T[] tArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, tArr, i, i2) == null) {
            T[] tArr2 = this.a;
            int i3 = this.f22717b + i2;
            if (i3 > tArr2.length) {
                tArr2 = k(Math.max(Math.max(8, i3), (int) (this.f22717b * 1.75f)));
            }
            System.arraycopy(tArr, i, tArr2, this.f22717b, i2);
            this.f22717b = i3;
        }
    }

    public T[] e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i >= 0) {
                int i2 = this.f22717b + i;
                if (i2 > this.a.length) {
                    k(Math.max(Math.max(8, i2), (int) (this.f22717b * 1.75f)));
                }
                return this.a;
            }
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i);
        }
        return (T[]) ((Object[]) invokeI.objValue);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (this.f22718c && (obj instanceof a)) {
                a aVar = (a) obj;
                if (aVar.f22718c && (i = this.f22717b) == aVar.f22717b) {
                    T[] tArr = this.a;
                    T[] tArr2 = aVar.a;
                    for (int i2 = 0; i2 < i; i2++) {
                        T t = tArr[i2];
                        T t2 = tArr2[i2];
                        if (t == null) {
                            if (t2 != null) {
                                return false;
                            }
                        } else if (!t.equals(t2)) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public T f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f22717b != 0) {
                return this.a[0];
            }
            throw new IllegalStateException("Array is empty.");
        }
        return (T) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: g */
    public b<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (f.a) {
                return new b<>(this, true);
            }
            if (this.f22719d == null) {
                this.f22719d = new C1651a(this);
            }
            return this.f22719d.iterator();
        }
        return (b) invokeV.objValue;
    }

    public T get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (i < this.f22717b) {
                return this.a[i];
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f22717b);
        }
        return (T) invokeI.objValue;
    }

    public T h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.f22717b;
            if (i == 0) {
                return null;
            }
            return this.a[com.badlogic.gdx.math.d.n(0, i - 1)];
        }
        return (T) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f22718c) {
                T[] tArr = this.a;
                int i = this.f22717b;
                int i2 = 1;
                for (int i3 = 0; i3 < i; i3++) {
                    i2 *= 31;
                    T t = tArr[i3];
                    if (t != null) {
                        i2 += t.hashCode();
                    }
                }
                return i2;
            }
            return super.hashCode();
        }
        return invokeV.intValue;
    }

    public T i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            int i2 = this.f22717b;
            if (i < i2) {
                T[] tArr = this.a;
                T t = tArr[i];
                int i3 = i2 - 1;
                this.f22717b = i3;
                if (this.f22718c) {
                    System.arraycopy(tArr, i + 1, tArr, i, i3 - i);
                } else {
                    tArr[i] = tArr[i3];
                }
                tArr[this.f22717b] = null;
                return t;
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f22717b);
        }
        return (T) invokeI.objValue;
    }

    public void insert(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, t) == null) {
            int i2 = this.f22717b;
            if (i <= i2) {
                T[] tArr = this.a;
                if (i2 == tArr.length) {
                    tArr = k(Math.max(8, (int) (i2 * 1.75f)));
                }
                if (this.f22718c) {
                    System.arraycopy(tArr, i, tArr, i + 1, this.f22717b - i);
                } else {
                    tArr[this.f22717b] = tArr[i];
                }
                this.f22717b++;
                tArr[i] = t;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.f22717b);
        }
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f22717b == 0 : invokeV.booleanValue;
    }

    public boolean j(T t, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, t, z)) == null) {
            T[] tArr = this.a;
            if (!z && t != null) {
                int i = this.f22717b;
                for (int i2 = 0; i2 < i; i2++) {
                    if (t.equals(tArr[i2])) {
                        i(i2);
                        return true;
                    }
                }
            } else {
                int i3 = this.f22717b;
                for (int i4 = 0; i4 < i3; i4++) {
                    if (tArr[i4] == t) {
                        i(i4);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public T[] k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            T[] tArr = this.a;
            T[] tArr2 = (T[]) ((Object[]) c.b.b.q.p0.a.a(tArr.getClass().getComponentType(), i));
            System.arraycopy(tArr, 0, tArr2, 0, Math.min(this.f22717b, tArr2.length));
            this.a = tArr2;
            return tArr2;
        }
        return (T[]) ((Object[]) invokeI.objValue);
    }

    public void l(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, t) == null) {
            if (i < this.f22717b) {
                this.a[i] = t;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.f22717b);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            h0.a().b(this.a, 0, this.f22717b);
        }
    }

    public <V> V[] n(Class<V> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, cls)) == null) {
            V[] vArr = (V[]) ((Object[]) c.b.b.q.p0.a.a(cls, this.f22717b));
            System.arraycopy(this.a, 0, vArr, 0, this.f22717b);
            return vArr;
        }
        return (V[]) ((Object[]) invokeL.objValue);
    }

    public T peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int i = this.f22717b;
            if (i != 0) {
                return this.a[i - 1];
            }
            throw new IllegalStateException("Array is empty.");
        }
        return (T) invokeV.objValue;
    }

    public T pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int i = this.f22717b;
            if (i != 0) {
                int i2 = i - 1;
                this.f22717b = i2;
                T[] tArr = this.a;
                T t = tArr[i2];
                tArr[i2] = null;
                return t;
            }
            throw new IllegalStateException("Array is empty.");
        }
        return (T) invokeV.objValue;
    }

    public void sort(Comparator<? super T> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, comparator) == null) {
            h0.a().c(this.a, comparator, 0, this.f22717b);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.f22717b == 0) {
                return "[]";
            }
            T[] tArr = this.a;
            j0 j0Var = new j0(32);
            j0Var.a('[');
            j0Var.m(tArr[0]);
            for (int i = 1; i < this.f22717b; i++) {
                j0Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                j0Var.m(tArr[i]);
            }
            j0Var.a(']');
            return j0Var.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i) {
        this(true, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public a(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f22718c = z;
        this.a = (T[]) new Object[i];
    }

    public a(boolean z, int i, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), cls};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.f22718c = z;
        this.a = (T[]) ((Object[]) c.b.b.q.p0.a.a(cls, i));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Class cls) {
        this(true, 16, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(a<? extends T> aVar) {
        this(aVar.f22718c, aVar.f22717b, aVar.a.getClass().getComponentType());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        int i3 = aVar.f22717b;
        this.f22717b = i3;
        System.arraycopy(aVar.a, 0, this.a, 0, i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(T[] tArr) {
        this(true, tArr, 0, tArr.length);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tArr};
            interceptable.invokeUnInit(65543, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (Object[]) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(boolean z, T[] tArr, int i, int i2) {
        this(z, i2, tArr.getClass().getComponentType());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), tArr, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        this.f22717b = i2;
        System.arraycopy(tArr, i, this.a, 0, i2);
    }
}
