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
public class x<T> implements Iterable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f28394e;

    /* renamed from: f  reason: collision with root package name */
    public T[] f28395f;

    /* renamed from: g  reason: collision with root package name */
    public float f28396g;

    /* renamed from: h  reason: collision with root package name */
    public int f28397h;

    /* renamed from: i  reason: collision with root package name */
    public int f28398i;

    /* renamed from: j  reason: collision with root package name */
    public int f28399j;

    /* renamed from: k  reason: collision with root package name */
    public transient a f28400k;
    public transient a l;

    /* loaded from: classes9.dex */
    public static class a<K> implements Iterable<K>, Iterator<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f28401e;

        /* renamed from: f  reason: collision with root package name */
        public final x<K> f28402f;

        /* renamed from: g  reason: collision with root package name */
        public int f28403g;

        /* renamed from: h  reason: collision with root package name */
        public int f28404h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f28405i;

        public a(x<K> xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28405i = true;
            this.f28402f = xVar;
            d();
        }

        public final void b() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                K[] kArr = this.f28402f.f28395f;
                int length = kArr.length;
                do {
                    i2 = this.f28403g + 1;
                    this.f28403g = i2;
                    if (i2 >= length) {
                        this.f28401e = false;
                        return;
                    }
                } while (kArr[i2] == null);
                this.f28401e = true;
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
                this.f28404h = -1;
                this.f28403g = -1;
                b();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f28405i) {
                    return this.f28401e;
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
                if (this.f28401e) {
                    if (this.f28405i) {
                        K[] kArr = this.f28402f.f28395f;
                        int i2 = this.f28403g;
                        K k2 = kArr[i2];
                        this.f28404h = i2;
                        b();
                        return k2;
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
                int i2 = this.f28404h;
                if (i2 >= 0) {
                    x<K> xVar = this.f28402f;
                    K[] kArr = xVar.f28395f;
                    int i3 = xVar.f28399j;
                    int i4 = i2 + 1;
                    while (true) {
                        int i5 = i4 & i3;
                        K k2 = kArr[i5];
                        if (k2 == null) {
                            break;
                        }
                        int f2 = this.f28402f.f(k2);
                        if (((i5 - f2) & i3) > ((i2 - f2) & i3)) {
                            kArr[i2] = k2;
                            i2 = i5;
                        }
                        i4 = i5 + 1;
                    }
                    kArr[i2] = null;
                    x<K> xVar2 = this.f28402f;
                    xVar2.f28394e--;
                    if (i2 != this.f28404h) {
                        this.f28403g--;
                    }
                    this.f28404h = -1;
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

    public static int h(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            if (i2 >= 0) {
                int j2 = com.badlogic.gdx.math.d.j(Math.max(2, (int) Math.ceil(i2 / f2)));
                if (j2 <= 1073741824) {
                    return j2;
                }
                throw new IllegalArgumentException("The required capacity is too large: " + i2);
            }
            throw new IllegalArgumentException("capacity must be >= 0: " + i2);
        }
        return invokeCommon.intValue;
    }

    public final void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            T[] tArr = this.f28395f;
            int f2 = f(t);
            while (tArr[f2] != null) {
                f2 = (f2 + 1) & this.f28399j;
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
            T[] tArr = this.f28395f;
            tArr[-(e2 + 1)] = t;
            int i2 = this.f28394e + 1;
            this.f28394e = i2;
            if (i2 >= this.f28397h) {
                g(tArr.length << 1);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            int h2 = h(i2, this.f28396g);
            if (this.f28395f.length <= h2) {
                clear();
                return;
            }
            this.f28394e = 0;
            g(h2);
        }
    }

    public void c(int i2) {
        int h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f28395f.length >= (h2 = h(this.f28394e + i2, this.f28396g))) {
            return;
        }
        g(h2);
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f28394e == 0) {
            return;
        }
        this.f28394e = 0;
        Arrays.fill(this.f28395f, (Object) null);
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
            if (this.f28400k == null) {
                this.f28400k = new a(this);
                this.l = new a(this);
            }
            a aVar = this.f28400k;
            if (!aVar.f28405i) {
                aVar.d();
                a<T> aVar2 = this.f28400k;
                aVar2.f28405i = true;
                this.l.f28405i = false;
                return aVar2;
            }
            this.l.d();
            a<T> aVar3 = this.l;
            aVar3.f28405i = true;
            this.f28400k.f28405i = false;
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
            T[] tArr = this.f28395f;
            int f2 = f(t);
            while (true) {
                T t2 = tArr[f2];
                if (t2 == null) {
                    return -(f2 + 1);
                }
                if (t2.equals(t)) {
                    return f2;
                }
                f2 = (f2 + 1) & this.f28399j;
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
                if (xVar.f28394e != this.f28394e) {
                    return false;
                }
                T[] tArr = this.f28395f;
                int length = tArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (tArr[i2] != null && !xVar.contains(tArr[i2])) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, t)) == null) ? (int) ((t.hashCode() * (-7046029254386353131L)) >>> this.f28398i) : invokeL.intValue;
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            int length = this.f28395f.length;
            this.f28397h = (int) (i2 * this.f28396g);
            int i3 = i2 - 1;
            this.f28399j = i3;
            this.f28398i = Long.numberOfLeadingZeros(i3);
            T[] tArr = this.f28395f;
            this.f28395f = (T[]) new Object[i2];
            if (this.f28394e > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    T t = tArr[i4];
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
            int i2 = this.f28394e;
            for (T t : this.f28395f) {
                if (t != null) {
                    i2 += t.hashCode();
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public String i(String str) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048588, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        if (this.f28394e == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(32);
        T[] tArr = this.f28395f;
        int length = tArr.length;
        while (true) {
            i2 = length - 1;
            if (length <= 0) {
                break;
            }
            T t = tArr[i2];
            if (t == null) {
                length = i2;
            } else {
                if (t == this) {
                    t = "(this)";
                }
                sb.append(t);
            }
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                T t2 = tArr[i3];
                if (t2 != null) {
                    sb.append(str);
                    if (t2 == this) {
                        t2 = "(this)";
                    }
                    sb.append(t2);
                }
                i2 = i3;
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
        T[] tArr = this.f28395f;
        int i2 = this.f28399j;
        int i3 = e2 + 1;
        while (true) {
            int i4 = i3 & i2;
            T t2 = tArr[i4];
            if (t2 != null) {
                int f2 = f(t2);
                if (((i4 - f2) & i2) > ((e2 - f2) & i2)) {
                    tArr[e2] = t2;
                    e2 = i4;
                }
                i3 = i4 + 1;
            } else {
                tArr[e2] = null;
                this.f28394e--;
                return true;
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return ExtendedMessageFormat.START_FE + i(StringUtil.ARRAY_ELEMENT_SEPARATOR) + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x(int i2) {
        this(i2, 0.8f);
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
                this(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public x(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f28396g = f2;
            int h2 = h(i2, f2);
            this.f28397h = (int) (h2 * f2);
            int i5 = h2 - 1;
            this.f28399j = i5;
            this.f28398i = Long.numberOfLeadingZeros(i5);
            this.f28395f = (T[]) new Object[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
