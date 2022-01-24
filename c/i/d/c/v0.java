package c.i.d.c;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Multisets;
import java.util.Arrays;
/* loaded from: classes9.dex */
public class v0<K> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Object[] a;

    /* renamed from: b  reason: collision with root package name */
    public transient int[] f30118b;

    /* renamed from: c  reason: collision with root package name */
    public transient int f30119c;

    /* renamed from: d  reason: collision with root package name */
    public transient int f30120d;

    /* renamed from: e  reason: collision with root package name */
    public transient int[] f30121e;

    /* renamed from: f  reason: collision with root package name */
    public transient long[] f30122f;

    /* renamed from: g  reason: collision with root package name */
    public transient float f30123g;

    /* renamed from: h  reason: collision with root package name */
    public transient int f30124h;

    /* loaded from: classes9.dex */
    public class a extends Multisets.b<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final K f30125e;

        /* renamed from: f  reason: collision with root package name */
        public int f30126f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ v0 f30127g;

        public a(v0 v0Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30127g = v0Var;
            this.f30125e = (K) v0Var.a[i2];
            this.f30126f = i2;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f30126f;
                if (i2 == -1 || i2 >= this.f30127g.C() || !c.i.d.a.k.a(this.f30125e, this.f30127g.a[this.f30126f])) {
                    this.f30126f = this.f30127g.m(this.f30125e);
                }
            }
        }

        @Override // c.i.d.c.s0.a
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                a();
                int i2 = this.f30126f;
                if (i2 == -1) {
                    return 0;
                }
                return this.f30127g.f30118b[i2];
            }
            return invokeV.intValue;
        }

        @Override // c.i.d.c.s0.a
        public K getElement() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30125e : (K) invokeV.objValue;
        }
    }

    public v0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n(3, 1.0f);
    }

    public static long D(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) ? (j2 & (-4294967296L)) | (i2 & 4294967295L) : invokeCommon.longValue;
    }

    public static <K> v0<K> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new v0<>() : (v0) invokeV.objValue;
    }

    public static <K> v0<K> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) ? new v0<>(i2) : (v0) invokeI.objValue;
    }

    public static int h(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j2)) == null) ? (int) (j2 >>> 32) : invokeJ.intValue;
    }

    public static int j(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65544, null, j2)) == null) ? (int) j2 : invokeJ.intValue;
    }

    public static long[] q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            long[] jArr = new long[i2];
            Arrays.fill(jArr, -1L);
            return jArr;
        }
        return (long[]) invokeI.objValue;
    }

    public static int[] r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            int[] iArr = new int[i2];
            Arrays.fill(iArr, -1);
            return iArr;
        }
        return (int[]) invokeI.objValue;
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (this.f30121e.length >= 1073741824) {
                this.f30124h = Integer.MAX_VALUE;
                return;
            }
            int i3 = ((int) (i2 * this.f30123g)) + 1;
            int[] r = r(i2);
            long[] jArr = this.f30122f;
            int length = r.length - 1;
            for (int i4 = 0; i4 < this.f30119c; i4++) {
                int h2 = h(jArr[i4]);
                int i5 = h2 & length;
                int i6 = r[i5];
                r[i5] = i4;
                jArr[i4] = (h2 << 32) | (i6 & 4294967295L);
            }
            this.f30124h = i3;
            this.f30121e = r;
        }
    }

    public void B(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            c.i.d.a.n.n(i2, this.f30119c);
            this.f30118b[i2] = i3;
        }
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30119c : invokeV.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f30120d++;
            Arrays.fill(this.a, 0, this.f30119c, (Object) null);
            Arrays.fill(this.f30118b, 0, this.f30119c, 0);
            Arrays.fill(this.f30121e, -1);
            Arrays.fill(this.f30122f, -1L);
            this.f30119c = 0;
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 > this.f30122f.length) {
                y(i2);
            }
            if (i2 >= this.f30124h) {
                A(Math.max(2, Integer.highestOneBit(i2 - 1) << 1));
            }
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30119c == 0 ? -1 : 0 : invokeV.intValue;
    }

    public int f(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            int m = m(obj);
            if (m == -1) {
                return 0;
            }
            return this.f30118b[m];
        }
        return invokeL.intValue;
    }

    public s0.a<K> g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            c.i.d.a.n.n(i2, this.f30119c);
            return new a(this, i2);
        }
        return (s0.a) invokeI.objValue;
    }

    public K i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            c.i.d.a.n.n(i2, this.f30119c);
            return (K) this.a[i2];
        }
        return (K) invokeI.objValue;
    }

    public int k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            c.i.d.a.n.n(i2, this.f30119c);
            return this.f30118b[i2];
        }
        return invokeI.intValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f30121e.length - 1 : invokeV.intValue;
    }

    public int m(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            int d2 = n0.d(obj);
            int i2 = this.f30121e[l() & d2];
            while (i2 != -1) {
                long j2 = this.f30122f[i2];
                if (h(j2) == d2 && c.i.d.a.k.a(obj, this.a[i2])) {
                    return i2;
                }
                i2 = j(j2);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void n(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            c.i.d.a.n.e(i2 >= 0, "Initial capacity must be non-negative");
            c.i.d.a.n.e(f2 > 0.0f, "Illegal load factor");
            int a2 = n0.a(i2, f2);
            this.f30121e = r(a2);
            this.f30123g = f2;
            this.a = new Object[i2];
            this.f30118b = new int[i2];
            this.f30122f = q(i2);
            this.f30124h = Math.max(1, (int) (a2 * f2));
        }
    }

    public void o(int i2, K k, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), k, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.f30122f[i2] = (i4 << 32) | 4294967295L;
            this.a[i2] = k;
            this.f30118b[i2] = i3;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048590, this, i2) != null) {
            return;
        }
        int C = C() - 1;
        if (i2 < C) {
            Object[] objArr = this.a;
            objArr[i2] = objArr[C];
            int[] iArr = this.f30118b;
            iArr[i2] = iArr[C];
            objArr[C] = null;
            iArr[C] = 0;
            long[] jArr = this.f30122f;
            long j2 = jArr[C];
            jArr[i2] = j2;
            jArr[C] = -1;
            int h2 = h(j2) & l();
            int[] iArr2 = this.f30121e;
            int i3 = iArr2[h2];
            if (i3 == C) {
                iArr2[h2] = i2;
                return;
            }
            while (true) {
                long j3 = this.f30122f[i3];
                int j4 = j(j3);
                if (j4 == C) {
                    this.f30122f[i3] = D(j3, i2);
                    return;
                }
                i3 = j4;
            }
        } else {
            this.a[i2] = null;
            this.f30118b[i2] = 0;
            this.f30122f[i2] = -1;
        }
    }

    public int s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            int i3 = i2 + 1;
            if (i3 < this.f30119c) {
                return i3;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public int t(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048592, this, i2, i3)) == null) ? i2 - 1 : invokeII.intValue;
    }

    public int u(K k, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, k, i2)) == null) {
            m.d(i2, "count");
            long[] jArr = this.f30122f;
            Object[] objArr = this.a;
            int[] iArr = this.f30118b;
            int d2 = n0.d(k);
            int l = l() & d2;
            int i3 = this.f30119c;
            int[] iArr2 = this.f30121e;
            int i4 = iArr2[l];
            if (i4 == -1) {
                iArr2[l] = i3;
            } else {
                while (true) {
                    long j2 = jArr[i4];
                    if (h(j2) == d2 && c.i.d.a.k.a(k, objArr[i4])) {
                        int i5 = iArr[i4];
                        iArr[i4] = i2;
                        return i5;
                    }
                    int j3 = j(j2);
                    if (j3 == -1) {
                        jArr[i4] = D(j2, i3);
                        break;
                    }
                    i4 = j3;
                }
            }
            if (i3 != Integer.MAX_VALUE) {
                int i6 = i3 + 1;
                z(i6);
                o(i3, k, i2, d2);
                this.f30119c = i6;
                if (i3 >= this.f30124h) {
                    A(this.f30121e.length * 2);
                }
                this.f30120d++;
                return 0;
            }
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        return invokeLI.intValue;
    }

    public int v(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) ? w(obj, n0.d(obj)) : invokeL.intValue;
    }

    public final int w(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(1048595, this, obj, i2)) != null) {
            return invokeLI.intValue;
        }
        int l = l() & i2;
        int i3 = this.f30121e[l];
        if (i3 == -1) {
            return 0;
        }
        int i4 = -1;
        while (true) {
            if (h(this.f30122f[i3]) == i2 && c.i.d.a.k.a(obj, this.a[i3])) {
                int i5 = this.f30118b[i3];
                if (i4 == -1) {
                    this.f30121e[l] = j(this.f30122f[i3]);
                } else {
                    long[] jArr = this.f30122f;
                    jArr[i4] = D(jArr[i4], j(jArr[i3]));
                }
                p(i3);
                this.f30119c--;
                this.f30120d++;
                return i5;
            }
            int j2 = j(this.f30122f[i3]);
            if (j2 == -1) {
                return 0;
            }
            i4 = i3;
            i3 = j2;
        }
    }

    public int x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) ? w(this.a[i2], h(this.f30122f[i2])) : invokeI.intValue;
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.a = Arrays.copyOf(this.a, i2);
            this.f30118b = Arrays.copyOf(this.f30118b, i2);
            long[] jArr = this.f30122f;
            int length = jArr.length;
            long[] copyOf = Arrays.copyOf(jArr, i2);
            if (i2 > length) {
                Arrays.fill(copyOf, length, i2, -1L);
            }
            this.f30122f = copyOf;
        }
    }

    public final void z(int i2) {
        int length;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || i2 <= (length = this.f30122f.length)) {
            return;
        }
        int max = Math.max(1, length >>> 1) + length;
        if (max < 0) {
            max = Integer.MAX_VALUE;
        }
        if (max != length) {
            y(max);
        }
    }

    public v0(v0<? extends K> v0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v0Var};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        n(v0Var.C(), 1.0f);
        int e2 = v0Var.e();
        while (e2 != -1) {
            u(v0Var.i(e2), v0Var.k(e2));
            e2 = v0Var.s(e2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v0(int i2) {
        this(i2, 1.0f);
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

    public v0(int i2, float f2) {
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
        n(i2, f2);
    }
}
