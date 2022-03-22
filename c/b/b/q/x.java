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
public class x<T> implements Iterable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public T[] f22871b;

    /* renamed from: c  reason: collision with root package name */
    public float f22872c;

    /* renamed from: d  reason: collision with root package name */
    public int f22873d;

    /* renamed from: e  reason: collision with root package name */
    public int f22874e;

    /* renamed from: f  reason: collision with root package name */
    public int f22875f;

    /* renamed from: g  reason: collision with root package name */
    public transient a f22876g;

    /* renamed from: h  reason: collision with root package name */
    public transient a f22877h;

    /* loaded from: classes3.dex */
    public static class a<K> implements Iterable<K>, Iterator<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final x<K> f22878b;

        /* renamed from: c  reason: collision with root package name */
        public int f22879c;

        /* renamed from: d  reason: collision with root package name */
        public int f22880d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f22881e;

        public a(x<K> xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22881e = true;
            this.f22878b = xVar;
            d();
        }

        public final void b() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                K[] kArr = this.f22878b.f22871b;
                int length = kArr.length;
                do {
                    i = this.f22879c + 1;
                    this.f22879c = i;
                    if (i >= length) {
                        this.a = false;
                        return;
                    }
                } while (kArr[i] == null);
                this.a = true;
            }
        }

        public a<K> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (a) invokeV.objValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f22880d = -1;
                this.f22879c = -1;
                b();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f22881e) {
                    return this.a;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            c();
            return this;
        }

        @Override // java.util.Iterator
        public K next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.a) {
                    if (this.f22881e) {
                        K[] kArr = this.f22878b.f22871b;
                        int i = this.f22879c;
                        K k = kArr[i];
                        this.f22880d = i;
                        b();
                        return k;
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException();
            }
            return (K) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                int i = this.f22880d;
                if (i >= 0) {
                    x<K> xVar = this.f22878b;
                    K[] kArr = xVar.f22871b;
                    int i2 = xVar.f22875f;
                    int i3 = i + 1;
                    while (true) {
                        int i4 = i3 & i2;
                        K k = kArr[i4];
                        if (k == null) {
                            break;
                        }
                        int f2 = this.f22878b.f(k);
                        if (((i4 - f2) & i2) > ((i - f2) & i2)) {
                            kArr[i] = k;
                            i = i4;
                        }
                        i3 = i4 + 1;
                    }
                    kArr[i] = null;
                    x<K> xVar2 = this.f22878b;
                    xVar2.a--;
                    if (i != this.f22880d) {
                        this.f22879c--;
                    }
                    this.f22880d = -1;
                    return;
                }
                throw new IllegalStateException("next must be called before remove.");
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x() {
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

    public static int h(int i, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Float.valueOf(f2)})) == null) {
            if (i >= 0) {
                int j = com.badlogic.gdx.math.d.j(Math.max(2, (int) Math.ceil(i / f2)));
                if (j <= 1073741824) {
                    return j;
                }
                throw new IllegalArgumentException("The required capacity is too large: " + i);
            }
            throw new IllegalArgumentException("capacity must be >= 0: " + i);
        }
        return invokeCommon.intValue;
    }

    public final void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            T[] tArr = this.f22871b;
            int f2 = f(t);
            while (tArr[f2] != null) {
                f2 = (f2 + 1) & this.f22875f;
            }
            tArr[f2] = t;
        }
    }

    public boolean add(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
            int e2 = e(t);
            if (e2 >= 0) {
                return false;
            }
            T[] tArr = this.f22871b;
            tArr[-(e2 + 1)] = t;
            int i = this.a + 1;
            this.a = i;
            if (i >= this.f22873d) {
                g(tArr.length << 1);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            int h2 = h(i, this.f22872c);
            if (this.f22871b.length <= h2) {
                clear();
                return;
            }
            this.a = 0;
            g(h2);
        }
    }

    public void c(int i) {
        int h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.f22871b.length >= (h2 = h(this.a + i, this.f22872c))) {
            return;
        }
        g(h2);
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == 0) {
            return;
        }
        this.a = 0;
        Arrays.fill(this.f22871b, (Object) null);
    }

    public boolean contains(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t)) == null) ? e(t) >= 0 : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: d */
    public a<T> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (f.a) {
                return new a<>(this);
            }
            if (this.f22876g == null) {
                this.f22876g = new a(this);
                this.f22877h = new a(this);
            }
            a aVar = this.f22876g;
            if (!aVar.f22881e) {
                aVar.d();
                a<T> aVar2 = this.f22876g;
                aVar2.f22881e = true;
                this.f22877h.f22881e = false;
                return aVar2;
            }
            this.f22877h.d();
            a<T> aVar3 = this.f22877h;
            aVar3.f22881e = true;
            this.f22876g.f22881e = false;
            return aVar3;
        }
        return (a) invokeV.objValue;
    }

    public int e(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, t)) != null) {
            return invokeL.intValue;
        }
        if (t != null) {
            T[] tArr = this.f22871b;
            int f2 = f(t);
            while (true) {
                T t2 = tArr[f2];
                if (t2 == null) {
                    return -(f2 + 1);
                }
                if (t2.equals(t)) {
                    return f2;
                }
                f2 = (f2 + 1) & this.f22875f;
            }
        } else {
            throw new IllegalArgumentException("key cannot be null.");
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj instanceof x) {
                x xVar = (x) obj;
                if (xVar.a != this.a) {
                    return false;
                }
                T[] tArr = this.f22871b;
                int length = tArr.length;
                for (int i = 0; i < length; i++) {
                    if (tArr[i] != null && !xVar.contains(tArr[i])) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int f(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, t)) == null) ? (int) ((t.hashCode() * (-7046029254386353131L)) >>> this.f22874e) : invokeL.intValue;
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            int length = this.f22871b.length;
            this.f22873d = (int) (i * this.f22872c);
            int i2 = i - 1;
            this.f22875f = i2;
            this.f22874e = Long.numberOfLeadingZeros(i2);
            T[] tArr = this.f22871b;
            this.f22871b = (T[]) new Object[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    T t = tArr[i3];
                    if (t != null) {
                        a(t);
                    }
                }
            }
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        T[] tArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i = this.a;
            for (T t : this.f22871b) {
                if (t != null) {
                    i += t.hashCode();
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public String i(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048588, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        if (this.a == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(32);
        T[] tArr = this.f22871b;
        int length = tArr.length;
        while (true) {
            i = length - 1;
            if (length <= 0) {
                break;
            }
            T t = tArr[i];
            if (t == null) {
                length = i;
            } else {
                if (t == this) {
                    t = "(this)";
                }
                sb.append(t);
            }
        }
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                T t2 = tArr[i2];
                if (t2 != null) {
                    sb.append(str);
                    if (t2 == this) {
                        t2 = "(this)";
                    }
                    sb.append(t2);
                }
                i = i2;
            } else {
                return sb.toString();
            }
        }
    }

    public boolean remove(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048590, this, t)) != null) {
            return invokeL.booleanValue;
        }
        int e2 = e(t);
        if (e2 < 0) {
            return false;
        }
        T[] tArr = this.f22871b;
        int i = this.f22875f;
        int i2 = e2 + 1;
        while (true) {
            int i3 = i2 & i;
            T t2 = tArr[i3];
            if (t2 != null) {
                int f2 = f(t2);
                if (((i3 - f2) & i) > ((e2 - f2) & i)) {
                    tArr[e2] = t2;
                    e2 = i3;
                }
                i2 = i3 + 1;
            } else {
                tArr[e2] = null;
                this.a--;
                return true;
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return '{' + i(StringUtil.ARRAY_ELEMENT_SEPARATOR) + '}';
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x(int i) {
        this(i, 0.8f);
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
                this(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public x(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Float.valueOf(f2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f22872c = f2;
            int h2 = h(i, f2);
            this.f22873d = (int) (h2 * f2);
            int i4 = h2 - 1;
            this.f22875f = i4;
            this.f22874e = Long.numberOfLeadingZeros(i4);
            this.f22871b = (T[]) new Object[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
