package c.i.b.a.a0.r;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import java.util.Arrays;
/* loaded from: classes9.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(int i2, int i3, long[] jArr, int i4, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), jArr, Integer.valueOf(i4), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(String str, String[] strArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, strArr, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        public c(boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }
    }

    /* loaded from: classes9.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final long f28817b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28818c;

        /* renamed from: d  reason: collision with root package name */
        public final int f28819d;

        /* renamed from: e  reason: collision with root package name */
        public final int f28820e;

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f28821f;

        public d(long j2, int i2, long j3, int i3, int i4, int i5, int i6, int i7, boolean z, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i8 = newInitContext.flag;
                if ((i8 & 1) != 0) {
                    int i9 = i8 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f28817b = j3;
            this.f28818c = i4;
            this.f28819d = i6;
            this.f28820e = i7;
            this.f28821f = bArr;
        }
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            int i3 = 0;
            while (i2 > 0) {
                i3++;
                i2 >>>= 1;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public static long b(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? (long) Math.floor(Math.pow(j2, 1.0d / j3)) : invokeCommon.longValue;
    }

    public static a c(i iVar) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iVar)) == null) {
            if (iVar.d(24) == 5653314) {
                int d2 = iVar.d(16);
                int d3 = iVar.d(24);
                long[] jArr = new long[d3];
                boolean c2 = iVar.c();
                long j2 = 0;
                if (!c2) {
                    boolean c3 = iVar.c();
                    for (int i2 = 0; i2 < d3; i2++) {
                        if (c3) {
                            if (iVar.c()) {
                                jArr[i2] = iVar.d(5) + 1;
                            } else {
                                jArr[i2] = 0;
                            }
                        } else {
                            jArr[i2] = iVar.d(5) + 1;
                        }
                    }
                } else {
                    int d4 = iVar.d(5) + 1;
                    int i3 = 0;
                    while (i3 < d3) {
                        int d5 = iVar.d(a(d3 - i3));
                        for (int i4 = 0; i4 < d5 && i3 < d3; i4++) {
                            jArr[i3] = d4;
                            i3++;
                        }
                        d4++;
                    }
                }
                int d6 = iVar.d(4);
                if (d6 <= 2) {
                    if (d6 == 1 || d6 == 2) {
                        iVar.e(32);
                        iVar.e(32);
                        int d7 = iVar.d(4) + 1;
                        iVar.e(1);
                        if (d6 != 1) {
                            j2 = d3 * d2;
                        } else if (d2 != 0) {
                            j2 = b(d3, d2);
                        }
                        iVar.e((int) (j2 * d7));
                    }
                    return new a(d2, d3, jArr, d6, c2);
                }
                throw new ParserException("lookup type greater than 2 not decodable: " + d6);
            }
            throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + iVar.b());
        }
        return (a) invokeL.objValue;
    }

    public static void d(i iVar) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, iVar) == null) {
            int d2 = iVar.d(6) + 1;
            for (int i2 = 0; i2 < d2; i2++) {
                int d3 = iVar.d(16);
                if (d3 == 0) {
                    iVar.e(8);
                    iVar.e(16);
                    iVar.e(16);
                    iVar.e(6);
                    iVar.e(8);
                    int d4 = iVar.d(4) + 1;
                    for (int i3 = 0; i3 < d4; i3++) {
                        iVar.e(8);
                    }
                } else if (d3 == 1) {
                    int d5 = iVar.d(5);
                    int i4 = -1;
                    int[] iArr = new int[d5];
                    for (int i5 = 0; i5 < d5; i5++) {
                        iArr[i5] = iVar.d(4);
                        if (iArr[i5] > i4) {
                            i4 = iArr[i5];
                        }
                    }
                    int i6 = i4 + 1;
                    int[] iArr2 = new int[i6];
                    for (int i7 = 0; i7 < i6; i7++) {
                        iArr2[i7] = iVar.d(3) + 1;
                        int d6 = iVar.d(2);
                        if (d6 > 0) {
                            iVar.e(8);
                        }
                        for (int i8 = 0; i8 < (1 << d6); i8++) {
                            iVar.e(8);
                        }
                    }
                    iVar.e(2);
                    int d7 = iVar.d(4);
                    int i9 = 0;
                    int i10 = 0;
                    for (int i11 = 0; i11 < d5; i11++) {
                        i9 += iArr2[iArr[i11]];
                        while (i10 < i9) {
                            iVar.e(d7);
                            i10++;
                        }
                    }
                } else {
                    throw new ParserException("floor type greater than 1 not decodable: " + d3);
                }
            }
        }
    }

    public static void e(int i2, i iVar) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, iVar) == null) {
            int d2 = iVar.d(6) + 1;
            for (int i3 = 0; i3 < d2; i3++) {
                int d3 = iVar.d(16);
                if (d3 != 0) {
                    String str = "mapping type other than 0 not supported: " + d3;
                } else {
                    int d4 = iVar.c() ? iVar.d(4) + 1 : 1;
                    if (iVar.c()) {
                        int d5 = iVar.d(8) + 1;
                        for (int i4 = 0; i4 < d5; i4++) {
                            int i5 = i2 - 1;
                            iVar.e(a(i5));
                            iVar.e(a(i5));
                        }
                    }
                    if (iVar.d(2) != 0) {
                        throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                    }
                    if (d4 > 1) {
                        for (int i6 = 0; i6 < i2; i6++) {
                            iVar.e(4);
                        }
                    }
                    for (int i7 = 0; i7 < d4; i7++) {
                        iVar.e(8);
                        iVar.e(8);
                        iVar.e(8);
                    }
                }
            }
        }
    }

    public static c[] f(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, iVar)) == null) {
            int d2 = iVar.d(6) + 1;
            c[] cVarArr = new c[d2];
            for (int i2 = 0; i2 < d2; i2++) {
                cVarArr[i2] = new c(iVar.c(), iVar.d(16), iVar.d(16), iVar.d(8));
            }
            return cVarArr;
        }
        return (c[]) invokeL.objValue;
    }

    public static void g(i iVar) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, iVar) == null) {
            int d2 = iVar.d(6) + 1;
            for (int i2 = 0; i2 < d2; i2++) {
                if (iVar.d(16) <= 2) {
                    iVar.e(24);
                    iVar.e(24);
                    iVar.e(24);
                    int d3 = iVar.d(6) + 1;
                    iVar.e(8);
                    int[] iArr = new int[d3];
                    for (int i3 = 0; i3 < d3; i3++) {
                        iArr[i3] = ((iVar.c() ? iVar.d(5) : 0) * 8) + iVar.d(3);
                    }
                    for (int i4 = 0; i4 < d3; i4++) {
                        for (int i5 = 0; i5 < 8; i5++) {
                            if ((iArr[i4] & (1 << i5)) != 0) {
                                iVar.e(8);
                            }
                        }
                    }
                } else {
                    throw new ParserException("residueType greater than 2 is not decodable");
                }
            }
        }
    }

    public static b h(l lVar) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, lVar)) == null) {
            k(3, lVar, false);
            String u = lVar.u((int) lVar.n());
            int length = 11 + u.length();
            long n = lVar.n();
            String[] strArr = new String[(int) n];
            int i2 = length + 4;
            for (int i3 = 0; i3 < n; i3++) {
                strArr[i3] = lVar.u((int) lVar.n());
                i2 = i2 + 4 + strArr[i3].length();
            }
            if ((lVar.x() & 1) != 0) {
                return new b(u, strArr, i2 + 1);
            }
            throw new ParserException("framing bit expected to be set");
        }
        return (b) invokeL.objValue;
    }

    public static d i(l lVar) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, lVar)) == null) {
            k(1, lVar, false);
            long n = lVar.n();
            int x = lVar.x();
            long n2 = lVar.n();
            int l = lVar.l();
            int l2 = lVar.l();
            int l3 = lVar.l();
            int x2 = lVar.x();
            return new d(n, x, n2, l, l2, l3, (int) Math.pow(2.0d, x2 & 15), (int) Math.pow(2.0d, (x2 & 240) >> 4), (lVar.x() & 1) > 0, Arrays.copyOf(lVar.a, lVar.d()));
        }
        return (d) invokeL.objValue;
    }

    public static c[] j(l lVar, int i2) throws ParserException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, lVar, i2)) == null) {
            k(5, lVar, false);
            int x = lVar.x() + 1;
            i iVar = new i(lVar.a);
            iVar.e(lVar.c() * 8);
            for (int i3 = 0; i3 < x; i3++) {
                c(iVar);
            }
            int d2 = iVar.d(6) + 1;
            for (int i4 = 0; i4 < d2; i4++) {
                if (iVar.d(16) != 0) {
                    throw new ParserException("placeholder of time domain transforms not zeroed out");
                }
            }
            d(iVar);
            g(iVar);
            e(i2, iVar);
            c[] f2 = f(iVar);
            if (iVar.c()) {
                return f2;
            }
            throw new ParserException("framing bit after modes not set as expected");
        }
        return (c[]) invokeLI.objValue;
    }

    public static boolean k(int i2, l lVar, boolean z) throws ParserException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Integer.valueOf(i2), lVar, Boolean.valueOf(z)})) == null) {
            if (lVar.a() < 7) {
                if (z) {
                    return false;
                }
                throw new ParserException("too short header: " + lVar.a());
            } else if (lVar.x() != i2) {
                if (z) {
                    return false;
                }
                throw new ParserException("expected header type " + Integer.toHexString(i2));
            } else if (lVar.x() == 118 && lVar.x() == 111 && lVar.x() == 114 && lVar.x() == 98 && lVar.x() == 105 && lVar.x() == 115) {
                return true;
            } else {
                if (z) {
                    return false;
                }
                throw new ParserException("expected characters 'vorbis'");
            }
        }
        return invokeCommon.booleanValue;
    }
}
