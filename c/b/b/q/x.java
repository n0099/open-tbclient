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
    public int f27764e;

    /* renamed from: f  reason: collision with root package name */
    public T[] f27765f;

    /* renamed from: g  reason: collision with root package name */
    public float f27766g;

    /* renamed from: h  reason: collision with root package name */
    public int f27767h;

    /* renamed from: i  reason: collision with root package name */
    public int f27768i;

    /* renamed from: j  reason: collision with root package name */
    public int f27769j;
    public transient a k;
    public transient a l;

    /* loaded from: classes9.dex */
    public static class a<K> implements Iterable<K>, Iterator<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f27770e;

        /* renamed from: f  reason: collision with root package name */
        public final x<K> f27771f;

        /* renamed from: g  reason: collision with root package name */
        public int f27772g;

        /* renamed from: h  reason: collision with root package name */
        public int f27773h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f27774i;

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
            this.f27774i = true;
            this.f27771f = xVar;
            d();
        }

        public final void b() {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                K[] kArr = this.f27771f.f27765f;
                int length = kArr.length;
                do {
                    i2 = this.f27772g + 1;
                    this.f27772g = i2;
                    if (i2 >= length) {
                        this.f27770e = false;
                        return;
                    }
                } while (kArr[i2] == null);
                this.f27770e = true;
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
                this.f27773h = -1;
                this.f27772g = -1;
                b();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f27774i) {
                    return this.f27770e;
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
                if (this.f27770e) {
                    if (this.f27774i) {
                        K[] kArr = this.f27771f.f27765f;
                        int i2 = this.f27772g;
                        K k = kArr[i2];
                        this.f27773h = i2;
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
                int i2 = this.f27773h;
                if (i2 >= 0) {
                    x<K> xVar = this.f27771f;
                    K[] kArr = xVar.f27765f;
                    int i3 = xVar.f27769j;
                    int i4 = i2 + 1;
                    while (true) {
                        int i5 = i4 & i3;
                        K k = kArr[i5];
                        if (k == null) {
                            break;
                        }
                        int f2 = this.f27771f.f(k);
                        if (((i5 - f2) & i3) > ((i2 - f2) & i3)) {
                            kArr[i2] = k;
                            i2 = i5;
                        }
                        i4 = i5 + 1;
                    }
                    kArr[i2] = null;
                    x<K> xVar2 = this.f27771f;
                    xVar2.f27764e--;
                    if (i2 != this.f27773h) {
                        this.f27772g--;
                    }
                    this.f27773h = -1;
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
            T[] tArr = this.f27765f;
            int f2 = f(t);
            while (tArr[f2] != null) {
                f2 = (f2 + 1) & this.f27769j;
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
            T[] tArr = this.f27765f;
            tArr[-(e2 + 1)] = t;
            int i2 = this.f27764e + 1;
            this.f27764e = i2;
            if (i2 >= this.f27767h) {
                g(tArr.length << 1);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            int h2 = h(i2, this.f27766g);
            if (this.f27765f.length <= h2) {
                clear();
                return;
            }
            this.f27764e = 0;
            g(h2);
        }
    }

    public void c(int i2) {
        int h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f27765f.length >= (h2 = h(this.f27764e + i2, this.f27766g))) {
            return;
        }
        g(h2);
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f27764e == 0) {
            return;
        }
        this.f27764e = 0;
        Arrays.fill(this.f27765f, (Object) null);
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
            if (this.k == null) {
                this.k = new a(this);
                this.l = new a(this);
            }
            a aVar = this.k;
            if (!aVar.f27774i) {
                aVar.d();
                a<T> aVar2 = this.k;
                aVar2.f27774i = true;
                this.l.f27774i = false;
                return aVar2;
            }
            this.l.d();
            a<T> aVar3 = this.l;
            aVar3.f27774i = true;
            this.k.f27774i = false;
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
            T[] tArr = this.f27765f;
            int f2 = f(t);
            while (true) {
                T t2 = tArr[f2];
                if (t2 == null) {
                    return -(f2 + 1);
                }
                if (t2.equals(t)) {
                    return f2;
                }
                f2 = (f2 + 1) & this.f27769j;
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
                if (xVar.f27764e != this.f27764e) {
                    return false;
                }
                T[] tArr = this.f27765f;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, t)) == null) ? (int) ((t.hashCode() * (-7046029254386353131L)) >>> this.f27768i) : invokeL.intValue;
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            int length = this.f27765f.length;
            this.f27767h = (int) (i2 * this.f27766g);
            int i3 = i2 - 1;
            this.f27769j = i3;
            this.f27768i = Long.numberOfLeadingZeros(i3);
            T[] tArr = this.f27765f;
            this.f27765f = (T[]) new Object[i2];
            if (this.f27764e > 0) {
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
            int i2 = this.f27764e;
            for (T t : this.f27765f) {
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
        if (this.f27764e == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(32);
        T[] tArr = this.f27765f;
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
        T[] tArr = this.f27765f;
        int i2 = this.f27769j;
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
                this.f27764e--;
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
            this.f27766g = f2;
            int h2 = h(i2, f2);
            this.f27767h = (int) (h2 * f2);
            int i5 = h2 - 1;
            this.f27769j = i5;
            this.f27768i = Long.numberOfLeadingZeros(i5);
            this.f27765f = (T[]) new Object[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
