package c.i.b.a;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class w {
    public static /* synthetic */ Interceptable $ic;
    public static final w a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a extends w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // c.i.b.a.w
        public int b(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return -1;
            }
            return invokeL.intValue;
        }

        @Override // c.i.b.a.w
        public b g(int i2, b bVar, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), bVar, Boolean.valueOf(z)})) == null) {
                throw new IndexOutOfBoundsException();
            }
            return (b) invokeCommon.objValue;
        }

        @Override // c.i.b.a.w
        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.i.b.a.w
        public c n(int i2, c cVar, boolean z, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), cVar, Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
                throw new IndexOutOfBoundsException();
            }
            return (c) invokeCommon.objValue;
        }

        @Override // c.i.b.a.w
        public int o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;

        /* renamed from: b  reason: collision with root package name */
        public Object f29841b;

        /* renamed from: c  reason: collision with root package name */
        public int f29842c;

        /* renamed from: d  reason: collision with root package name */
        public long f29843d;

        /* renamed from: e  reason: collision with root package name */
        public long f29844e;

        /* renamed from: f  reason: collision with root package name */
        public long[] f29845f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f29846g;

        /* renamed from: h  reason: collision with root package name */
        public int[] f29847h;

        /* renamed from: i  reason: collision with root package name */
        public int[] f29848i;

        /* renamed from: j  reason: collision with root package name */
        public long[][] f29849j;
        public long k;

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

        public int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f29846g[i2] : invokeI.intValue;
        }

        public long b(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) {
                long[][] jArr = this.f29849j;
                if (i3 >= jArr[i2].length) {
                    return -9223372036854775807L;
                }
                return jArr[i2][i3];
            }
            return invokeII.longValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                long[] jArr = this.f29845f;
                if (jArr == null) {
                    return 0;
                }
                return jArr.length;
            }
            return invokeV.intValue;
        }

        public int d(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                if (this.f29845f == null) {
                    return -1;
                }
                int i2 = 0;
                while (true) {
                    long[] jArr = this.f29845f;
                    if (i2 >= jArr.length || jArr[i2] == Long.MIN_VALUE || (j2 < jArr[i2] && !l(i2))) {
                        break;
                    }
                    i2++;
                }
                if (i2 < this.f29845f.length) {
                    return i2;
                }
                return -1;
            }
            return invokeJ.intValue;
        }

        public int e(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
                long[] jArr = this.f29845f;
                if (jArr == null) {
                    return -1;
                }
                int length = jArr.length - 1;
                while (length >= 0) {
                    long[] jArr2 = this.f29845f;
                    if (jArr2[length] != Long.MIN_VALUE && jArr2[length] <= j2) {
                        break;
                    }
                    length--;
                }
                if (length < 0 || l(length)) {
                    return -1;
                }
                return length;
            }
            return invokeJ.intValue;
        }

        public long f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.f29845f[i2] : invokeI.longValue;
        }

        public long g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : invokeV.longValue;
        }

        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f29843d : invokeV.longValue;
        }

        public int i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? this.f29848i[i2] : invokeI.intValue;
        }

        public long j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? c.i.b.a.b.b(this.f29844e) : invokeV.longValue;
        }

        public long k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f29844e : invokeV.longValue;
        }

        public boolean l(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
                int[] iArr = this.f29846g;
                return iArr[i2] != -1 && this.f29848i[i2] == iArr[i2];
            }
            return invokeI.booleanValue;
        }

        public boolean m(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i2, i3)) == null) ? i3 < this.f29847h[i2] : invokeII.booleanValue;
        }

        public b n(Object obj, Object obj2, int i2, long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{obj, obj2, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
                o(obj, obj2, i2, j2, j3, null, null, null, null, null, -9223372036854775807L);
                return this;
            }
            return (b) invokeCommon.objValue;
        }

        public b o(Object obj, Object obj2, int i2, long j2, long j3, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{obj, obj2, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), jArr, iArr, iArr2, iArr3, jArr2, Long.valueOf(j4)})) == null) {
                this.a = obj;
                this.f29841b = obj2;
                this.f29842c = i2;
                this.f29843d = j2;
                this.f29844e = j3;
                this.f29845f = jArr;
                this.f29846g = iArr;
                this.f29847h = iArr2;
                this.f29848i = iArr3;
                this.f29849j = jArr2;
                this.k = j4;
                return this;
            }
            return (b) invokeCommon.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;

        /* renamed from: b  reason: collision with root package name */
        public long f29850b;

        /* renamed from: c  reason: collision with root package name */
        public long f29851c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f29852d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f29853e;

        /* renamed from: f  reason: collision with root package name */
        public int f29854f;

        /* renamed from: g  reason: collision with root package name */
        public int f29855g;

        /* renamed from: h  reason: collision with root package name */
        public long f29856h;

        /* renamed from: i  reason: collision with root package name */
        public long f29857i;

        /* renamed from: j  reason: collision with root package name */
        public long f29858j;

        public c() {
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

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29856h : invokeV.longValue;
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? c.i.b.a.b.b(this.f29857i) : invokeV.longValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29858j : invokeV.longValue;
        }

        public c d(Object obj, long j2, long j3, boolean z, boolean z2, long j4, long j5, int i2, int i3, long j6) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{obj, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j6)})) == null) {
                this.a = obj;
                this.f29850b = j2;
                this.f29851c = j3;
                this.f29852d = z;
                this.f29853e = z2;
                this.f29856h = j4;
                this.f29857i = j5;
                this.f29854f = i2;
                this.f29855g = i3;
                this.f29858j = j6;
                return this;
            }
            return (c) invokeCommon.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-528839043, "Lc/i/b/a/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-528839043, "Lc/i/b/a/w;");
                return;
            }
        }
        a = new a();
    }

    public w() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? p() ? -1 : 0 : invokeZ.intValue;
    }

    public abstract int b(Object obj);

    public int c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            if (p()) {
                return -1;
            }
            return o() - 1;
        }
        return invokeZ.intValue;
    }

    public final int d(int i2, b bVar, c cVar, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), bVar, cVar, Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            int i4 = f(i2, bVar).f29842c;
            if (l(i4, cVar).f29855g == i2) {
                int e2 = e(i4, i3, z);
                if (e2 == -1) {
                    return -1;
                }
                return l(e2, cVar).f29854f;
            }
            return i2 + 1;
        }
        return invokeCommon.intValue;
    }

    public int e(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (i3 == 0) {
                if (i2 == c(z)) {
                    return -1;
                }
                return i2 + 1;
            } else if (i3 != 1) {
                if (i3 == 2) {
                    return i2 == c(z) ? a(z) : i2 + 1;
                }
                throw new IllegalStateException();
            } else {
                return i2;
            }
        }
        return invokeCommon.intValue;
    }

    public final b f(int i2, b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, bVar)) == null) ? g(i2, bVar, false) : (b) invokeIL.objValue;
    }

    public abstract b g(int i2, b bVar, boolean z);

    public abstract int h();

    public final Pair<Integer, Long> i(c cVar, b bVar, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{cVar, bVar, Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? j(cVar, bVar, i2, j2, 0L) : (Pair) invokeCommon.objValue;
    }

    public final Pair<Integer, Long> j(c cVar, b bVar, int i2, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{cVar, bVar, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            c.i.b.a.i0.a.c(i2, 0, o());
            n(i2, cVar, false, j3);
            if (j2 == -9223372036854775807L) {
                j2 = cVar.a();
                if (j2 == -9223372036854775807L) {
                    return null;
                }
            }
            int i3 = cVar.f29854f;
            long c2 = cVar.c() + j2;
            long h2 = f(i3, bVar).h();
            while (h2 != -9223372036854775807L && c2 >= h2 && i3 < cVar.f29855g) {
                c2 -= h2;
                i3++;
                h2 = f(i3, bVar).h();
            }
            return Pair.create(Integer.valueOf(i3), Long.valueOf(c2));
        }
        return (Pair) invokeCommon.objValue;
    }

    public int k(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (i3 == 0) {
                if (i2 == a(z)) {
                    return -1;
                }
                return i2 - 1;
            } else if (i3 != 1) {
                if (i3 == 2) {
                    return i2 == a(z) ? c(z) : i2 - 1;
                }
                throw new IllegalStateException();
            } else {
                return i2;
            }
        }
        return invokeCommon.intValue;
    }

    public final c l(int i2, c cVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, cVar)) == null) ? m(i2, cVar, false) : (c) invokeIL.objValue;
    }

    public final c m(int i2, c cVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), cVar, Boolean.valueOf(z)})) == null) ? n(i2, cVar, z, 0L) : (c) invokeCommon.objValue;
    }

    public abstract c n(int i2, c cVar, boolean z, long j2);

    public abstract int o();

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? o() == 0 : invokeV.booleanValue;
    }

    public final boolean q(int i2, b bVar, c cVar, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), bVar, cVar, Integer.valueOf(i3), Boolean.valueOf(z)})) == null) ? d(i2, bVar, cVar, i3, z) == -1 : invokeCommon.booleanValue;
    }
}
