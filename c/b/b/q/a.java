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
/* loaded from: classes9.dex */
public class a<T> implements Iterable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public T[] f27360e;

    /* renamed from: f  reason: collision with root package name */
    public int f27361f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27362g;

    /* renamed from: h  reason: collision with root package name */
    public C1619a f27363h;

    /* renamed from: c.b.b.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1619a<T> implements Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final a<T> f27364e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f27365f;

        /* renamed from: g  reason: collision with root package name */
        public b f27366g;

        /* renamed from: h  reason: collision with root package name */
        public b f27367h;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C1619a(a<T> aVar) {
            this(aVar, true);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    return new b<>(this.f27364e, this.f27365f);
                }
                if (this.f27366g == null) {
                    this.f27366g = new b(this.f27364e, this.f27365f);
                    this.f27367h = new b(this.f27364e, this.f27365f);
                }
                b<T> bVar = this.f27366g;
                if (!bVar.f27371h) {
                    bVar.f27370g = 0;
                    bVar.f27371h = true;
                    this.f27367h.f27371h = false;
                    return bVar;
                }
                b<T> bVar2 = this.f27367h;
                bVar2.f27370g = 0;
                bVar2.f27371h = true;
                bVar.f27371h = false;
                return bVar2;
            }
            return (b) invokeV.objValue;
        }

        public C1619a(a<T> aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f27364e = aVar;
            this.f27365f = z;
        }
    }

    /* loaded from: classes9.dex */
    public static class b<T> implements Iterator<T>, Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final a<T> f27368e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f27369f;

        /* renamed from: g  reason: collision with root package name */
        public int f27370g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f27371h;

        public b(a<T> aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27371h = true;
            this.f27368e = aVar;
            this.f27369f = z;
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
                if (this.f27371h) {
                    return this.f27370g < this.f27368e.f27361f;
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
                int i2 = this.f27370g;
                a<T> aVar = this.f27368e;
                if (i2 < aVar.f27361f) {
                    if (this.f27371h) {
                        T[] tArr = aVar.f27360e;
                        this.f27370g = i2 + 1;
                        return tArr[i2];
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.f27370g));
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.f27369f) {
                    int i2 = this.f27370g - 1;
                    this.f27370g = i2;
                    this.f27368e.h(i2);
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

    public static <T> a<T> n(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tArr)) == null) ? new a<>(tArr) : (a) invokeL.objValue;
    }

    public void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            T[] tArr = this.f27360e;
            int i2 = this.f27361f;
            if (i2 == tArr.length) {
                tArr = j(Math.max(8, (int) (i2 * 1.75f)));
            }
            int i3 = this.f27361f;
            this.f27361f = i3 + 1;
            tArr[i3] = t;
        }
    }

    public void b(a<? extends T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            d(aVar.f27360e, 0, aVar.f27361f);
        }
    }

    public void c(a<? extends T> aVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, aVar, i2, i3) == null) {
            if (i2 + i3 <= aVar.f27361f) {
                d(aVar.f27360e, i2, i3);
                return;
            }
            throw new IllegalArgumentException("start + count must be <= size: " + i2 + " + " + i3 + " <= " + aVar.f27361f);
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Arrays.fill(this.f27360e, 0, this.f27361f, (Object) null);
            this.f27361f = 0;
        }
    }

    public void d(T[] tArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, tArr, i2, i3) == null) {
            T[] tArr2 = this.f27360e;
            int i4 = this.f27361f + i3;
            if (i4 > tArr2.length) {
                tArr2 = j(Math.max(Math.max(8, i4), (int) (this.f27361f * 1.75f)));
            }
            System.arraycopy(tArr, i2, tArr2, this.f27361f, i3);
            this.f27361f = i4;
        }
    }

    public T[] e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 >= 0) {
                int i3 = this.f27361f + i2;
                if (i3 > this.f27360e.length) {
                    j(Math.max(Math.max(8, i3), (int) (this.f27361f * 1.75f)));
                }
                return this.f27360e;
            }
            throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i2);
        }
        return (T[]) ((Object[]) invokeI.objValue);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (this.f27362g && (obj instanceof a)) {
                a aVar = (a) obj;
                if (aVar.f27362g && (i2 = this.f27361f) == aVar.f27361f) {
                    T[] tArr = this.f27360e;
                    T[] tArr2 = aVar.f27360e;
                    for (int i3 = 0; i3 < i2; i3++) {
                        T t = tArr[i3];
                        T t2 = tArr2[i3];
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: f */
    public b<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (f.a) {
                return new b<>(this, true);
            }
            if (this.f27363h == null) {
                this.f27363h = new C1619a(this);
            }
            return this.f27363h.iterator();
        }
        return (b) invokeV.objValue;
    }

    public T first() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f27361f != 0) {
                return this.f27360e[0];
            }
            throw new IllegalStateException("Array is empty.");
        }
        return (T) invokeV.objValue;
    }

    public T g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f27361f;
            if (i2 == 0) {
                return null;
            }
            return this.f27360e[com.badlogic.gdx.math.d.n(0, i2 - 1)];
        }
        return (T) invokeV.objValue;
    }

    public T get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (i2 < this.f27361f) {
                return this.f27360e[i2];
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i2 + " >= " + this.f27361f);
        }
        return (T) invokeI.objValue;
    }

    public T h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            int i3 = this.f27361f;
            if (i2 < i3) {
                T[] tArr = this.f27360e;
                T t = tArr[i2];
                int i4 = i3 - 1;
                this.f27361f = i4;
                if (this.f27362g) {
                    System.arraycopy(tArr, i2 + 1, tArr, i2, i4 - i2);
                } else {
                    tArr[i2] = tArr[i4];
                }
                tArr[this.f27361f] = null;
                return t;
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i2 + " >= " + this.f27361f);
        }
        return (T) invokeI.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f27362g) {
                T[] tArr = this.f27360e;
                int i2 = this.f27361f;
                int i3 = 1;
                for (int i4 = 0; i4 < i2; i4++) {
                    i3 *= 31;
                    T t = tArr[i4];
                    if (t != null) {
                        i3 += t.hashCode();
                    }
                }
                return i3;
            }
            return super.hashCode();
        }
        return invokeV.intValue;
    }

    public boolean i(T t, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, t, z)) == null) {
            T[] tArr = this.f27360e;
            if (!z && t != null) {
                int i2 = this.f27361f;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (t.equals(tArr[i3])) {
                        h(i3);
                        return true;
                    }
                }
            } else {
                int i4 = this.f27361f;
                for (int i5 = 0; i5 < i4; i5++) {
                    if (tArr[i5] == t) {
                        h(i5);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void insert(int i2, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, t) == null) {
            int i3 = this.f27361f;
            if (i2 <= i3) {
                T[] tArr = this.f27360e;
                if (i3 == tArr.length) {
                    tArr = j(Math.max(8, (int) (i3 * 1.75f)));
                }
                if (this.f27362g) {
                    System.arraycopy(tArr, i2, tArr, i2 + 1, this.f27361f - i2);
                } else {
                    tArr[this.f27361f] = tArr[i2];
                }
                this.f27361f++;
                tArr[i2] = t;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be > size: " + i2 + " > " + this.f27361f);
        }
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f27361f == 0 : invokeV.booleanValue;
    }

    public T[] j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            T[] tArr = this.f27360e;
            T[] tArr2 = (T[]) ((Object[]) c.b.b.q.p0.a.a(tArr.getClass().getComponentType(), i2));
            System.arraycopy(tArr, 0, tArr2, 0, Math.min(this.f27361f, tArr2.length));
            this.f27360e = tArr2;
            return tArr2;
        }
        return (T[]) ((Object[]) invokeI.objValue);
    }

    public void k(int i2, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, t) == null) {
            if (i2 < this.f27361f) {
                this.f27360e[i2] = t;
                return;
            }
            throw new IndexOutOfBoundsException("index can't be >= size: " + i2 + " >= " + this.f27361f);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            h0.a().b(this.f27360e, 0, this.f27361f);
        }
    }

    public <V> V[] m(Class<V> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, cls)) == null) {
            V[] vArr = (V[]) ((Object[]) c.b.b.q.p0.a.a(cls, this.f27361f));
            System.arraycopy(this.f27360e, 0, vArr, 0, this.f27361f);
            return vArr;
        }
        return (V[]) ((Object[]) invokeL.objValue);
    }

    public T peek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int i2 = this.f27361f;
            if (i2 != 0) {
                return this.f27360e[i2 - 1];
            }
            throw new IllegalStateException("Array is empty.");
        }
        return (T) invokeV.objValue;
    }

    public T pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int i2 = this.f27361f;
            if (i2 != 0) {
                int i3 = i2 - 1;
                this.f27361f = i3;
                T[] tArr = this.f27360e;
                T t = tArr[i3];
                tArr[i3] = null;
                return t;
            }
            throw new IllegalStateException("Array is empty.");
        }
        return (T) invokeV.objValue;
    }

    public void sort(Comparator<? super T> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, comparator) == null) {
            h0.a().c(this.f27360e, comparator, 0, this.f27361f);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.f27361f == 0) {
                return "[]";
            }
            T[] tArr = this.f27360e;
            j0 j0Var = new j0(32);
            j0Var.a('[');
            j0Var.m(tArr[0]);
            for (int i2 = 1; i2 < this.f27361f; i2++) {
                j0Var.n(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                j0Var.m(tArr[i2]);
            }
            j0Var.a(']');
            return j0Var.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i2) {
        this(true, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public a(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f27362g = z;
        this.f27360e = (T[]) new Object[i2];
    }

    public a(boolean z, int i2, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), cls};
            interceptable.invokeUnInit(65541, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.f27362g = z;
        this.f27360e = (T[]) ((Object[]) c.b.b.q.p0.a.a(cls, i2));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this(aVar.f27362g, aVar.f27361f, aVar.f27360e.getClass().getComponentType());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        int i4 = aVar.f27361f;
        this.f27361f = i4;
        System.arraycopy(aVar.f27360e, 0, this.f27360e, 0, i4);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (Object[]) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65543, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(boolean z, T[] tArr, int i2, int i3) {
        this(z, i3, tArr.getClass().getComponentType());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), tArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        this.f27361f = i3;
        System.arraycopy(tArr, i2, this.f27360e, 0, i3);
    }
}
