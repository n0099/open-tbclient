package c.i.d.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public final class l1<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final Comparator<? super T> f31020b;

    /* renamed from: c  reason: collision with root package name */
    public final T[] f31021c;

    /* renamed from: d  reason: collision with root package name */
    public int f31022d;

    /* renamed from: e  reason: collision with root package name */
    public T f31023e;

    public l1(Comparator<? super T> comparator, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {comparator, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.i.d.a.n.q(comparator, "comparator");
        this.f31020b = comparator;
        this.a = i2;
        c.i.d.a.n.f(i2 >= 0, "k must be nonnegative, was %s", i2);
        this.f31021c = (T[]) new Object[i2 * 2];
        this.f31022d = 0;
        this.f31023e = null;
    }

    public static <T> l1<T> a(int i2, Comparator<? super T> comparator) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, comparator)) == null) ? new l1<>(comparator, i2) : (l1) invokeIL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: T, ? super T */
    public void b(T t) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, t) == null) || (i2 = this.a) == 0) {
            return;
        }
        int i3 = this.f31022d;
        if (i3 == 0) {
            this.f31021c[0] = t;
            this.f31023e = t;
            this.f31022d = 1;
        } else if (i3 < i2) {
            T[] tArr = this.f31021c;
            this.f31022d = i3 + 1;
            tArr[i3] = t;
            if (this.f31020b.compare(t, (T) this.f31023e) > 0) {
                this.f31023e = t;
            }
        } else if (this.f31020b.compare(t, (T) this.f31023e) < 0) {
            T[] tArr2 = this.f31021c;
            int i4 = this.f31022d;
            int i5 = i4 + 1;
            this.f31022d = i5;
            tArr2[i4] = t;
            if (i5 == this.a * 2) {
                g();
            }
        }
    }

    public void c(Iterator<? extends T> it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
            while (it.hasNext()) {
                b(it.next());
            }
        }
    }

    public final int d(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4)) == null) {
            T[] tArr = this.f31021c;
            T t = tArr[i4];
            tArr[i4] = tArr[i3];
            int i5 = i2;
            while (i2 < i3) {
                if (this.f31020b.compare((Object) this.f31021c[i2], t) < 0) {
                    e(i5, i2);
                    i5++;
                }
                i2++;
            }
            T[] tArr2 = this.f31021c;
            tArr2[i3] = tArr2[i5];
            tArr2[i5] = t;
            return i5;
        }
        return invokeIII.intValue;
    }

    public final void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            T[] tArr = this.f31021c;
            T t = tArr[i2];
            tArr[i2] = tArr[i3];
            tArr[i3] = t;
        }
    }

    public List<T> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Arrays.sort(this.f31021c, 0, this.f31022d, this.f31020b);
            int i2 = this.f31022d;
            int i3 = this.a;
            if (i2 > i3) {
                T[] tArr = this.f31021c;
                Arrays.fill(tArr, i3, tArr.length, (Object) null);
                int i4 = this.a;
                this.f31022d = i4;
                this.f31023e = this.f31021c[i4 - 1];
            }
            return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.f31021c, this.f31022d)));
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r2v3. Raw type applied. Possible types: T, ? super T */
    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048581, this) != null) {
            return;
        }
        int i2 = (this.a * 2) - 1;
        int d2 = c.i.d.f.c.d(i2 + 0, RoundingMode.CEILING) * 3;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 < i2) {
                int d3 = d(i3, i2, ((i3 + i2) + 1) >>> 1);
                int i6 = this.a;
                if (d3 <= i6) {
                    if (d3 >= i6) {
                        break;
                    }
                    i3 = Math.max(d3, i3 + 1);
                    i5 = d3;
                } else {
                    i2 = d3 - 1;
                }
                i4++;
                if (i4 >= d2) {
                    Arrays.sort(this.f31021c, i3, i2, this.f31020b);
                    break;
                }
            } else {
                break;
            }
        }
        this.f31022d = this.a;
        this.f31023e = this.f31021c[i5];
        while (true) {
            i5++;
            if (i5 >= this.a) {
                return;
            }
            if (this.f31020b.compare((Object) this.f31021c[i5], (T) this.f31023e) > 0) {
                this.f31023e = this.f31021c[i5];
            }
        }
    }
}
