package b.i.b.a.a0.q;

import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import b.i.b.a.a0.l;
import b.i.b.a.a0.m;
import b.i.b.a.a0.q.a;
import b.i.b.a.i0.s;
import b.i.b.a.i0.v;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.CencSampleEncryptionInformationGroupEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;
/* loaded from: classes6.dex */
public final class e implements b.i.b.a.a0.e {
    public static /* synthetic */ Interceptable $ic;
    public static final int G;
    public static final byte[] H;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public b.i.b.a.a0.g C;
    public b.i.b.a.a0.m D;
    public b.i.b.a.a0.m[] E;
    public boolean F;

    /* renamed from: a  reason: collision with root package name */
    public final int f31502a;

    /* renamed from: b  reason: collision with root package name */
    public final j f31503b;

    /* renamed from: c  reason: collision with root package name */
    public final DrmInitData f31504c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<b> f31505d;

    /* renamed from: e  reason: collision with root package name */
    public final b.i.b.a.i0.l f31506e;

    /* renamed from: f  reason: collision with root package name */
    public final b.i.b.a.i0.l f31507f;

    /* renamed from: g  reason: collision with root package name */
    public final b.i.b.a.i0.l f31508g;

    /* renamed from: h  reason: collision with root package name */
    public final b.i.b.a.i0.l f31509h;

    /* renamed from: i  reason: collision with root package name */
    public final b.i.b.a.i0.l f31510i;
    public final s j;
    public final b.i.b.a.i0.l k;
    public final byte[] l;
    public final Stack<a.C1474a> m;
    public final LinkedList<a> n;
    public int o;
    public int p;
    public long q;
    public int r;
    public b.i.b.a.i0.l s;
    public long t;
    public int u;
    public long v;
    public long w;
    public b x;
    public int y;
    public int z;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f31511a;

        /* renamed from: b  reason: collision with root package name */
        public final int f31512b;

        public a(long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31511a = j;
            this.f31512b = i2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final l f31513a;

        /* renamed from: b  reason: collision with root package name */
        public final b.i.b.a.a0.m f31514b;

        /* renamed from: c  reason: collision with root package name */
        public j f31515c;

        /* renamed from: d  reason: collision with root package name */
        public c f31516d;

        /* renamed from: e  reason: collision with root package name */
        public int f31517e;

        /* renamed from: f  reason: collision with root package name */
        public int f31518f;

        /* renamed from: g  reason: collision with root package name */
        public int f31519g;

        public b(b.i.b.a.a0.m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31513a = new l();
            this.f31514b = mVar;
        }

        public void a(j jVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, jVar, cVar) == null) {
                b.i.b.a.i0.a.e(jVar);
                this.f31515c = jVar;
                b.i.b.a.i0.a.e(cVar);
                this.f31516d = cVar;
                this.f31514b.b(jVar.f31549f);
                b();
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f31513a.f();
                this.f31517e = 0;
                this.f31519g = 0;
                this.f31518f = 0;
            }
        }

        public void c(DrmInitData drmInitData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drmInitData) == null) {
                k a2 = this.f31515c.a(this.f31513a.f31557a.f31493a);
                this.f31514b.b(this.f31515c.f31549f.copyWithDrmInitData(drmInitData.copyWithSchemeType(a2 != null ? a2.f31553a : null)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1952673158, "Lb/i/b/a/a0/q/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1952673158, "Lb/i/b/a/a0/q/e;");
                return;
            }
        }
        G = v.q(CencSampleEncryptionInformationGroupEntry.TYPE);
        H = new byte[]{-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(int i2) {
        this(i2, null);
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
                this(((Integer) objArr2[0]).intValue(), (s) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int A(b bVar, int i2, long j, int i3, b.i.b.a.i0.l lVar, int i4) {
        InterceptResult invokeCommon;
        boolean z;
        int i5;
        boolean z2;
        int i6;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bVar, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), lVar, Integer.valueOf(i4)})) == null) {
            lVar.J(8);
            int b2 = b.i.b.a.a0.q.a.b(lVar.i());
            j jVar = bVar.f31515c;
            l lVar2 = bVar.f31513a;
            c cVar = lVar2.f31557a;
            lVar2.f31564h[i2] = lVar.B();
            long[] jArr = lVar2.f31563g;
            jArr[i2] = lVar2.f31559c;
            if ((b2 & 1) != 0) {
                jArr[i2] = jArr[i2] + lVar.i();
            }
            boolean z6 = (b2 & 4) != 0;
            int i7 = cVar.f31496d;
            if (z6) {
                i7 = lVar.B();
            }
            boolean z7 = (b2 & 256) != 0;
            boolean z8 = (b2 & 512) != 0;
            boolean z9 = (b2 & 1024) != 0;
            boolean z10 = (b2 & 2048) != 0;
            long[] jArr2 = jVar.f31551h;
            long j2 = 0;
            if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
                j2 = v.F(jVar.f31552i[0], 1000L, jVar.f31546c);
            }
            int[] iArr = lVar2.f31565i;
            int[] iArr2 = lVar2.j;
            long[] jArr3 = lVar2.k;
            boolean[] zArr = lVar2.l;
            int i8 = i7;
            boolean z11 = jVar.f31545b == 2 && (i3 & 1) != 0;
            int i9 = i4 + lVar2.f31564h[i2];
            long j3 = jVar.f31546c;
            long j4 = j2;
            long j5 = i2 > 0 ? lVar2.s : j;
            int i10 = i4;
            while (i10 < i9) {
                int B = z7 ? lVar.B() : cVar.f31494b;
                if (z8) {
                    z = z7;
                    i5 = lVar.B();
                } else {
                    z = z7;
                    i5 = cVar.f31495c;
                }
                if (i10 == 0 && z6) {
                    z2 = z6;
                    i6 = i8;
                } else if (z9) {
                    z2 = z6;
                    i6 = lVar.i();
                } else {
                    z2 = z6;
                    i6 = cVar.f31496d;
                }
                if (z10) {
                    z3 = z10;
                    z4 = z8;
                    z5 = z9;
                    iArr2[i10] = (int) ((lVar.i() * 1000) / j3);
                } else {
                    z3 = z10;
                    z4 = z8;
                    z5 = z9;
                    iArr2[i10] = 0;
                }
                jArr3[i10] = v.F(j5, 1000L, j3) - j4;
                iArr[i10] = i5;
                zArr[i10] = ((i6 >> 16) & 1) == 0 && (!z11 || i10 == 0);
                i10++;
                j5 += B;
                j3 = j3;
                z7 = z;
                z6 = z2;
                z10 = z3;
                z8 = z4;
                z9 = z5;
            }
            lVar2.s = j5;
            return i9;
        }
        return invokeCommon.intValue;
    }

    public static void B(a.C1474a c1474a, b bVar, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{c1474a, bVar, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            List<a.b> list = c1474a.Q0;
            int size = list.size();
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                a.b bVar2 = list.get(i5);
                if (bVar2.f31461a == b.i.b.a.a0.q.a.A) {
                    b.i.b.a.i0.l lVar = bVar2.P0;
                    lVar.J(12);
                    int B = lVar.B();
                    if (B > 0) {
                        i4 += B;
                        i3++;
                    }
                }
            }
            bVar.f31519g = 0;
            bVar.f31518f = 0;
            bVar.f31517e = 0;
            bVar.f31513a.e(i3, i4);
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < size; i8++) {
                a.b bVar3 = list.get(i8);
                if (bVar3.f31461a == b.i.b.a.a0.q.a.A) {
                    i7 = A(bVar, i6, j, i2, bVar3.P0, i7);
                    i6++;
                }
            }
        }
    }

    public static void C(b.i.b.a.i0.l lVar, l lVar2, byte[] bArr) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, lVar, lVar2, bArr) == null) {
            lVar.J(8);
            lVar.g(bArr, 0, 16);
            if (Arrays.equals(bArr, H)) {
                s(lVar, 16, lVar2);
            }
        }
    }

    public static boolean I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? i2 == b.i.b.a.a0.q.a.C || i2 == b.i.b.a.a0.q.a.E || i2 == b.i.b.a.a0.q.a.F || i2 == b.i.b.a.a0.q.a.G || i2 == b.i.b.a.a0.q.a.H || i2 == b.i.b.a.a0.q.a.L || i2 == b.i.b.a.a0.q.a.M || i2 == b.i.b.a.a0.q.a.N || i2 == b.i.b.a.a0.q.a.Q : invokeI.booleanValue;
    }

    public static boolean J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? i2 == b.i.b.a.a0.q.a.T || i2 == b.i.b.a.a0.q.a.S || i2 == b.i.b.a.a0.q.a.D || i2 == b.i.b.a.a0.q.a.B || i2 == b.i.b.a.a0.q.a.U || i2 == b.i.b.a.a0.q.a.x || i2 == b.i.b.a.a0.q.a.y || i2 == b.i.b.a.a0.q.a.P || i2 == b.i.b.a.a0.q.a.z || i2 == b.i.b.a.a0.q.a.A || i2 == b.i.b.a.a0.q.a.V || i2 == b.i.b.a.a0.q.a.d0 || i2 == b.i.b.a.a0.q.a.e0 || i2 == b.i.b.a.a0.q.a.i0 || i2 == b.i.b.a.a0.q.a.h0 || i2 == b.i.b.a.a0.q.a.f0 || i2 == b.i.b.a.a0.q.a.g0 || i2 == b.i.b.a.a0.q.a.R || i2 == b.i.b.a.a0.q.a.O || i2 == b.i.b.a.a0.q.a.G0 : invokeI.booleanValue;
    }

    public static DrmInitData g(List<a.b> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, list)) == null) {
            int size = list.size();
            ArrayList arrayList = null;
            for (int i2 = 0; i2 < size; i2++) {
                a.b bVar = list.get(i2);
                if (bVar.f31461a == b.i.b.a.a0.q.a.V) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    byte[] bArr = bVar.P0.f32635a;
                    UUID d2 = h.d(bArr);
                    if (d2 != null) {
                        arrayList.add(new DrmInitData.SchemeData(d2, "video/mp4", bArr));
                    }
                }
            }
            if (arrayList == null) {
                return null;
            }
            return new DrmInitData(arrayList);
        }
        return (DrmInitData) invokeL.objValue;
    }

    public static b h(SparseArray<b> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, sparseArray)) == null) {
            int size = sparseArray.size();
            b bVar = null;
            long j = Long.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                b valueAt = sparseArray.valueAt(i2);
                int i3 = valueAt.f31519g;
                l lVar = valueAt.f31513a;
                if (i3 != lVar.f31561e) {
                    long j2 = lVar.f31563g[i3];
                    if (j2 < j) {
                        bVar = valueAt;
                        j = j2;
                    }
                }
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static long o(b.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, lVar)) == null) {
            lVar.J(8);
            return b.i.b.a.a0.q.a.c(lVar.i()) == 0 ? lVar.z() : lVar.C();
        }
        return invokeL.longValue;
    }

    public static void p(a.C1474a c1474a, SparseArray<b> sparseArray, int i2, byte[] bArr) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65548, null, c1474a, sparseArray, i2, bArr) == null) {
            int size = c1474a.R0.size();
            for (int i3 = 0; i3 < size; i3++) {
                a.C1474a c1474a2 = c1474a.R0.get(i3);
                if (c1474a2.f31461a == b.i.b.a.a0.q.a.M) {
                    y(c1474a2, sparseArray, i2, bArr);
                }
            }
        }
    }

    public static void q(b.i.b.a.i0.l lVar, l lVar2) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, lVar, lVar2) == null) {
            lVar.J(8);
            int i2 = lVar.i();
            if ((b.i.b.a.a0.q.a.b(i2) & 1) == 1) {
                lVar.K(8);
            }
            int B = lVar.B();
            if (B == 1) {
                lVar2.f31560d += b.i.b.a.a0.q.a.c(i2) == 0 ? lVar.z() : lVar.C();
                return;
            }
            throw new ParserException("Unexpected saio entry count: " + B);
        }
    }

    public static void r(k kVar, b.i.b.a.i0.l lVar, l lVar2) throws ParserException {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, kVar, lVar, lVar2) == null) {
            int i3 = kVar.f31555c;
            lVar.J(8);
            if ((b.i.b.a.a0.q.a.b(lVar.i()) & 1) == 1) {
                lVar.K(8);
            }
            int x = lVar.x();
            int B = lVar.B();
            if (B == lVar2.f31562f) {
                if (x == 0) {
                    boolean[] zArr = lVar2.n;
                    i2 = 0;
                    for (int i4 = 0; i4 < B; i4++) {
                        int x2 = lVar.x();
                        i2 += x2;
                        zArr[i4] = x2 > i3;
                    }
                } else {
                    i2 = (x * B) + 0;
                    Arrays.fill(lVar2.n, 0, B, x > i3);
                }
                lVar2.d(i2);
                return;
            }
            throw new ParserException("Length mismatch: " + B + StringUtil.ARRAY_ELEMENT_SEPARATOR + lVar2.f31562f);
        }
    }

    public static void s(b.i.b.a.i0.l lVar, int i2, l lVar2) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65551, null, lVar, i2, lVar2) == null) {
            lVar.J(i2 + 8);
            int b2 = b.i.b.a.a0.q.a.b(lVar.i());
            if ((b2 & 1) == 0) {
                boolean z = (b2 & 2) != 0;
                int B = lVar.B();
                if (B == lVar2.f31562f) {
                    Arrays.fill(lVar2.n, 0, B, z);
                    lVar2.d(lVar.a());
                    lVar2.b(lVar);
                    return;
                }
                throw new ParserException("Length mismatch: " + B + StringUtil.ARRAY_ELEMENT_SEPARATOR + lVar2.f31562f);
            }
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
    }

    public static void t(b.i.b.a.i0.l lVar, l lVar2) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, lVar, lVar2) == null) {
            s(lVar, 0, lVar2);
        }
    }

    public static void u(b.i.b.a.i0.l lVar, b.i.b.a.i0.l lVar2, String str, l lVar3) throws ParserException {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65553, null, lVar, lVar2, str, lVar3) == null) {
            lVar.J(8);
            int i2 = lVar.i();
            if (lVar.i() != G) {
                return;
            }
            if (b.i.b.a.a0.q.a.c(i2) == 1) {
                lVar.K(4);
            }
            if (lVar.i() == 1) {
                lVar2.J(8);
                int i3 = lVar2.i();
                if (lVar2.i() != G) {
                    return;
                }
                int c2 = b.i.b.a.a0.q.a.c(i3);
                if (c2 == 1) {
                    if (lVar2.z() == 0) {
                        throw new ParserException("Variable length description in sgpd found (unsupported)");
                    }
                } else if (c2 >= 2) {
                    lVar2.K(4);
                }
                if (lVar2.z() == 1) {
                    lVar2.K(1);
                    int x = lVar2.x();
                    int i4 = (x & 240) >> 4;
                    int i5 = x & 15;
                    boolean z = lVar2.x() == 1;
                    if (z) {
                        int x2 = lVar2.x();
                        byte[] bArr2 = new byte[16];
                        lVar2.g(bArr2, 0, 16);
                        if (z && x2 == 0) {
                            int x3 = lVar2.x();
                            byte[] bArr3 = new byte[x3];
                            lVar2.g(bArr3, 0, x3);
                            bArr = bArr3;
                        } else {
                            bArr = null;
                        }
                        lVar3.m = true;
                        lVar3.o = new k(z, str, x2, bArr2, i4, i5, bArr);
                        return;
                    }
                    return;
                }
                throw new ParserException("Entry count in sgpd != 1 (unsupported).");
            }
            throw new ParserException("Entry count in sbgp != 1 (unsupported).");
        }
    }

    public static Pair<Long, b.i.b.a.a0.a> v(b.i.b.a.i0.l lVar, long j) throws ParserException {
        InterceptResult invokeLJ;
        long C;
        long C2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65554, null, lVar, j)) == null) {
            lVar.J(8);
            int c2 = b.i.b.a.a0.q.a.c(lVar.i());
            lVar.K(4);
            long z = lVar.z();
            if (c2 == 0) {
                C = lVar.z();
                C2 = lVar.z();
            } else {
                C = lVar.C();
                C2 = lVar.C();
            }
            long j2 = C;
            long j3 = j + C2;
            long F = v.F(j2, 1000000L, z);
            lVar.K(2);
            int D = lVar.D();
            int[] iArr = new int[D];
            long[] jArr = new long[D];
            long[] jArr2 = new long[D];
            long[] jArr3 = new long[D];
            long j4 = j2;
            long j5 = F;
            int i2 = 0;
            while (i2 < D) {
                int i3 = lVar.i();
                if ((i3 & Integer.MIN_VALUE) == 0) {
                    long z2 = lVar.z();
                    iArr[i2] = i3 & Integer.MAX_VALUE;
                    jArr[i2] = j3;
                    jArr3[i2] = j5;
                    long j6 = j4 + z2;
                    long[] jArr4 = jArr2;
                    long[] jArr5 = jArr3;
                    int i4 = D;
                    int[] iArr2 = iArr;
                    long F2 = v.F(j6, 1000000L, z);
                    jArr4[i2] = F2 - jArr5[i2];
                    lVar.K(4);
                    j3 += iArr2[i2];
                    i2++;
                    iArr = iArr2;
                    jArr3 = jArr5;
                    jArr2 = jArr4;
                    jArr = jArr;
                    D = i4;
                    j4 = j6;
                    j5 = F2;
                } else {
                    throw new ParserException("Unhandled indirect reference");
                }
            }
            return Pair.create(Long.valueOf(F), new b.i.b.a.a0.a(iArr, jArr, jArr2, jArr3));
        }
        return (Pair) invokeLJ.objValue;
    }

    public static long w(b.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, lVar)) == null) {
            lVar.J(8);
            return b.i.b.a.a0.q.a.c(lVar.i()) == 1 ? lVar.C() : lVar.z();
        }
        return invokeL.longValue;
    }

    public static b x(b.i.b.a.i0.l lVar, SparseArray<b> sparseArray, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65556, null, lVar, sparseArray, i2)) == null) {
            lVar.J(8);
            int b2 = b.i.b.a.a0.q.a.b(lVar.i());
            int i3 = lVar.i();
            if ((i2 & 16) != 0) {
                i3 = 0;
            }
            b bVar = sparseArray.get(i3);
            if (bVar == null) {
                return null;
            }
            if ((b2 & 1) != 0) {
                long C = lVar.C();
                l lVar2 = bVar.f31513a;
                lVar2.f31559c = C;
                lVar2.f31560d = C;
            }
            c cVar = bVar.f31516d;
            bVar.f31513a.f31557a = new c((b2 & 2) != 0 ? lVar.B() - 1 : cVar.f31493a, (b2 & 8) != 0 ? lVar.B() : cVar.f31494b, (b2 & 16) != 0 ? lVar.B() : cVar.f31495c, (b2 & 32) != 0 ? lVar.B() : cVar.f31496d);
            return bVar;
        }
        return (b) invokeLLI.objValue;
    }

    public static void y(a.C1474a c1474a, SparseArray<b> sparseArray, int i2, byte[] bArr) throws ParserException {
        b x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(65557, null, c1474a, sparseArray, i2, bArr) == null) || (x = x(c1474a.g(b.i.b.a.a0.q.a.y).P0, sparseArray, i2)) == null) {
            return;
        }
        l lVar = x.f31513a;
        long j = lVar.s;
        x.b();
        if (c1474a.g(b.i.b.a.a0.q.a.x) != null && (i2 & 2) == 0) {
            j = w(c1474a.g(b.i.b.a.a0.q.a.x).P0);
        }
        B(c1474a, x, j, i2);
        k a2 = x.f31515c.a(lVar.f31557a.f31493a);
        a.b g2 = c1474a.g(b.i.b.a.a0.q.a.d0);
        if (g2 != null) {
            r(a2, g2.P0, lVar);
        }
        a.b g3 = c1474a.g(b.i.b.a.a0.q.a.e0);
        if (g3 != null) {
            q(g3.P0, lVar);
        }
        a.b g4 = c1474a.g(b.i.b.a.a0.q.a.i0);
        if (g4 != null) {
            t(g4.P0, lVar);
        }
        a.b g5 = c1474a.g(b.i.b.a.a0.q.a.f0);
        a.b g6 = c1474a.g(b.i.b.a.a0.q.a.g0);
        if (g5 != null && g6 != null) {
            u(g5.P0, g6.P0, a2 != null ? a2.f31553a : null, lVar);
        }
        int size = c1474a.Q0.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = c1474a.Q0.get(i3);
            if (bVar.f31461a == b.i.b.a.a0.q.a.h0) {
                C(bVar.P0, lVar, bArr);
            }
        }
    }

    public static Pair<Integer, c> z(b.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, lVar)) == null) {
            lVar.J(12);
            return Pair.create(Integer.valueOf(lVar.i()), new c(lVar.B() - 1, lVar.B(), lVar.B(), lVar.i()));
        }
        return (Pair) invokeL.objValue;
    }

    public final void D(long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            while (!this.m.isEmpty() && this.m.peek().P0 == j) {
                j(this.m.pop());
            }
            c();
        }
    }

    public final boolean E(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) == null) {
            if (this.r == 0) {
                if (!fVar.a(this.k.f32635a, 0, 8, true)) {
                    return false;
                }
                this.r = 8;
                this.k.J(0);
                this.q = this.k.z();
                this.p = this.k.i();
            }
            long j = this.q;
            if (j == 1) {
                fVar.readFully(this.k.f32635a, 8, 8);
                this.r += 8;
                this.q = this.k.C();
            } else if (j == 0) {
                long length = fVar.getLength();
                if (length == -1 && !this.m.isEmpty()) {
                    length = this.m.peek().P0;
                }
                if (length != -1) {
                    this.q = (length - fVar.getPosition()) + this.r;
                }
            }
            if (this.q >= this.r) {
                long position = fVar.getPosition() - this.r;
                if (this.p == b.i.b.a.a0.q.a.L) {
                    int size = this.f31505d.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        l lVar = this.f31505d.valueAt(i2).f31513a;
                        lVar.f31558b = position;
                        lVar.f31560d = position;
                        lVar.f31559c = position;
                    }
                }
                int i3 = this.p;
                if (i3 == b.i.b.a.a0.q.a.f31460i) {
                    this.x = null;
                    this.t = position + this.q;
                    if (!this.F) {
                        this.C.p(new l.a(this.v));
                        this.F = true;
                    }
                    this.o = 2;
                    return true;
                }
                if (I(i3)) {
                    long position2 = (fVar.getPosition() + this.q) - 8;
                    this.m.add(new a.C1474a(this.p, position2));
                    if (this.q == this.r) {
                        D(position2);
                    } else {
                        c();
                    }
                } else if (J(this.p)) {
                    if (this.r == 8) {
                        long j2 = this.q;
                        if (j2 <= 2147483647L) {
                            b.i.b.a.i0.l lVar2 = new b.i.b.a.i0.l((int) j2);
                            this.s = lVar2;
                            System.arraycopy(this.k.f32635a, 0, lVar2.f32635a, 0, 8);
                            this.o = 1;
                        } else {
                            throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
                        }
                    } else {
                        throw new ParserException("Leaf atom defines extended atom size (unsupported).");
                    }
                } else if (this.q <= 2147483647L) {
                    this.s = null;
                    this.o = 1;
                } else {
                    throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
                }
                return true;
            }
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        return invokeL.booleanValue;
    }

    public final void F(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            int i2 = ((int) this.q) - this.r;
            b.i.b.a.i0.l lVar = this.s;
            if (lVar != null) {
                fVar.readFully(lVar.f32635a, 8, i2);
                l(new a.b(this.p, this.s), fVar.getPosition());
            } else {
                fVar.h(i2);
            }
            D(fVar.getPosition());
        }
    }

    public final void G(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            int size = this.f31505d.size();
            b bVar = null;
            long j = Long.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                l lVar = this.f31505d.valueAt(i2).f31513a;
                if (lVar.r) {
                    long j2 = lVar.f31560d;
                    if (j2 < j) {
                        bVar = this.f31505d.valueAt(i2);
                        j = j2;
                    }
                }
            }
            if (bVar == null) {
                this.o = 3;
                return;
            }
            int position = (int) (j - fVar.getPosition());
            if (position >= 0) {
                fVar.h(position);
                bVar.f31513a.a(fVar);
                return;
            }
            throw new ParserException("Offset to encryption data was negative.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r9v0, types: [b.i.b.a.a0.m] */
    public final boolean H(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        ?? r12;
        m.a aVar;
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fVar)) == null) {
            int i2 = 4;
            int i3 = 1;
            int i4 = 0;
            if (this.o == 3) {
                if (this.x == null) {
                    b h2 = h(this.f31505d);
                    if (h2 == null) {
                        int position = (int) (this.t - fVar.getPosition());
                        if (position >= 0) {
                            fVar.h(position);
                            c();
                            return false;
                        }
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    int position2 = (int) (h2.f31513a.f31563g[h2.f31519g] - fVar.getPosition());
                    if (position2 < 0) {
                        position2 = 0;
                    }
                    fVar.h(position2);
                    this.x = h2;
                }
                b bVar = this.x;
                l lVar = bVar.f31513a;
                this.y = lVar.f31565i[bVar.f31517e];
                if (lVar.m) {
                    int b2 = b(bVar);
                    this.z = b2;
                    this.y += b2;
                } else {
                    this.z = 0;
                }
                if (this.x.f31515c.f31550g == 1) {
                    this.y -= 8;
                    fVar.h(8);
                }
                this.o = 4;
                this.A = 0;
            }
            b bVar2 = this.x;
            l lVar2 = bVar2.f31513a;
            j jVar = bVar2.f31515c;
            ?? r9 = bVar2.f31514b;
            int i5 = bVar2.f31517e;
            int i6 = jVar.j;
            if (i6 == 0) {
                while (true) {
                    int i7 = this.z;
                    int i8 = this.y;
                    if (i7 >= i8) {
                        break;
                    }
                    this.z += r9.d(fVar, i8 - i7, false);
                }
            } else {
                byte[] bArr = this.f31507f.f32635a;
                bArr[0] = 0;
                bArr[1] = 0;
                bArr[2] = 0;
                int i9 = i6 + 1;
                int i10 = 4 - i6;
                while (this.z < this.y) {
                    int i11 = this.A;
                    if (i11 == 0) {
                        fVar.readFully(bArr, i10, i9);
                        this.f31507f.J(i4);
                        this.A = this.f31507f.B() - i3;
                        this.f31506e.J(i4);
                        r9.a(this.f31506e, i2);
                        r9.a(this.f31507f, i3);
                        this.B = this.E != null && b.i.b.a.i0.j.g(jVar.f31549f.sampleMimeType, bArr[i2]);
                        this.z += 5;
                        this.y += i10;
                    } else {
                        if (this.B) {
                            this.f31508g.G(i11);
                            fVar.readFully(this.f31508g.f32635a, i4, this.A);
                            r9.a(this.f31508g, this.A);
                            d2 = this.A;
                            b.i.b.a.i0.l lVar3 = this.f31508g;
                            int k = b.i.b.a.i0.j.k(lVar3.f32635a, lVar3.d());
                            this.f31508g.J("video/hevc".equals(jVar.f31549f.sampleMimeType) ? 1 : 0);
                            this.f31508g.I(k);
                            b.i.b.a.e0.l.g.a(lVar2.c(i5) * 1000, this.f31508g, this.E);
                        } else {
                            d2 = r9.d(fVar, i11, false);
                        }
                        this.z += d2;
                        this.A -= d2;
                        i2 = 4;
                        i3 = 1;
                        i4 = 0;
                    }
                }
            }
            long c2 = lVar2.c(i5) * 1000;
            s sVar = this.j;
            if (sVar != null) {
                c2 = sVar.a(c2);
            }
            boolean z = lVar2.l[i5];
            if (lVar2.m) {
                boolean z2 = z | true;
                k kVar = lVar2.o;
                if (kVar == null) {
                    kVar = jVar.a(lVar2.f31557a.f31493a);
                }
                r12 = z2;
                aVar = kVar.f31554b;
            } else {
                r12 = z;
                aVar = null;
            }
            r9.c(c2, r12, this.y, 0, aVar);
            while (!this.n.isEmpty()) {
                a removeFirst = this.n.removeFirst();
                int i12 = this.u;
                int i13 = removeFirst.f31512b;
                int i14 = i12 - i13;
                this.u = i14;
                this.D.c(c2 + removeFirst.f31511a, 1, i13, i14, null);
            }
            b bVar3 = this.x;
            bVar3.f31517e++;
            int i15 = bVar3.f31518f + 1;
            bVar3.f31518f = i15;
            int[] iArr = lVar2.f31564h;
            int i16 = bVar3.f31519g;
            if (i15 == iArr[i16]) {
                bVar3.f31519g = i16 + 1;
                bVar3.f31518f = 0;
                this.x = null;
            }
            this.o = 3;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // b.i.b.a.a0.e
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            int size = this.f31505d.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f31505d.valueAt(i2).b();
            }
            this.n.clear();
            this.u = 0;
            this.m.clear();
            c();
        }
    }

    public final int b(b bVar) {
        InterceptResult invokeL;
        b.i.b.a.i0.l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
            l lVar2 = bVar.f31513a;
            int i2 = lVar2.f31557a.f31493a;
            k kVar = lVar2.o;
            if (kVar == null) {
                kVar = bVar.f31515c.a(i2);
            }
            int i3 = kVar.f31555c;
            if (i3 != 0) {
                lVar = lVar2.q;
            } else {
                byte[] bArr = kVar.f31556d;
                this.f31510i.H(bArr, bArr.length);
                lVar = this.f31510i;
                i3 = bArr.length;
            }
            boolean z = lVar2.n[bVar.f31517e];
            this.f31509h.f32635a[0] = (byte) ((z ? 128 : 0) | i3);
            this.f31509h.J(0);
            b.i.b.a.a0.m mVar = bVar.f31514b;
            mVar.a(this.f31509h, 1);
            mVar.a(lVar, i3);
            if (z) {
                b.i.b.a.i0.l lVar3 = lVar2.q;
                int D = lVar3.D();
                lVar3.K(-2);
                int i4 = (D * 6) + 2;
                mVar.a(lVar3, i4);
                return i3 + 1 + i4;
            }
            return i3 + 1;
        }
        return invokeL.intValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.o = 0;
            this.r = 0;
        }
    }

    @Override // b.i.b.a.a0.e
    public boolean d(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar)) == null) ? i.b(fVar) : invokeL.booleanValue;
    }

    @Override // b.i.b.a.a0.e
    public int e(b.i.b.a.a0.f fVar, b.i.b.a.a0.k kVar) throws IOException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048585, this, fVar, kVar)) != null) {
            return invokeLL.intValue;
        }
        while (true) {
            int i2 = this.o;
            if (i2 != 0) {
                if (i2 == 1) {
                    F(fVar);
                } else if (i2 != 2) {
                    if (H(fVar)) {
                        return 0;
                    }
                } else {
                    G(fVar);
                }
            } else if (!E(fVar)) {
                return -1;
            }
        }
    }

    @Override // b.i.b.a.a0.e
    public void f(b.i.b.a.a0.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.C = gVar;
            j jVar = this.f31503b;
            if (jVar != null) {
                b bVar = new b(gVar.a(0, jVar.f31545b));
                bVar.a(this.f31503b, new c(0, 0, 0, 0));
                this.f31505d.put(0, bVar);
                i();
                this.C.j();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if ((this.f31502a & 4) != 0 && this.D == null) {
                b.i.b.a.a0.m a2 = this.C.a(this.f31505d.size(), 4);
                this.D = a2;
                a2.b(Format.createSampleFormat(null, "application/x-emsg", Long.MAX_VALUE));
            }
            if ((this.f31502a & 8) == 0 || this.E != null) {
                return;
            }
            b.i.b.a.a0.m a3 = this.C.a(this.f31505d.size() + 1, 3);
            a3.b(Format.createTextSampleFormat(null, "application/cea-608", 0, null));
            this.E = new b.i.b.a.a0.m[]{a3};
        }
    }

    public final void j(a.C1474a c1474a) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, c1474a) == null) {
            int i2 = c1474a.f31461a;
            if (i2 == b.i.b.a.a0.q.a.C) {
                n(c1474a);
            } else if (i2 == b.i.b.a.a0.q.a.L) {
                m(c1474a);
            } else if (this.m.isEmpty()) {
            } else {
                this.m.peek().d(c1474a);
            }
        }
    }

    public final void k(b.i.b.a.i0.l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, lVar) == null) || this.D == null) {
            return;
        }
        lVar.J(12);
        lVar.r();
        lVar.r();
        long F = v.F(lVar.z(), 1000000L, lVar.z());
        lVar.J(12);
        int a2 = lVar.a();
        this.D.a(lVar, a2);
        long j = this.w;
        if (j != -9223372036854775807L) {
            this.D.c(j + F, 1, a2, 0, null);
            return;
        }
        this.n.addLast(new a(F, a2));
        this.u += a2;
    }

    public final void l(a.b bVar, long j) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, bVar, j) == null) {
            if (!this.m.isEmpty()) {
                this.m.peek().e(bVar);
                return;
            }
            int i2 = bVar.f31461a;
            if (i2 == b.i.b.a.a0.q.a.B) {
                Pair<Long, b.i.b.a.a0.a> v = v(bVar.P0, j);
                this.w = ((Long) v.first).longValue();
                this.C.p((b.i.b.a.a0.l) v.second);
                this.F = true;
            } else if (i2 == b.i.b.a.a0.q.a.G0) {
                k(bVar.P0);
            }
        }
    }

    public final void m(a.C1474a c1474a) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, c1474a) == null) {
            p(c1474a, this.f31505d, this.f31502a, this.l);
            DrmInitData g2 = this.f31504c != null ? null : g(c1474a.Q0);
            if (g2 != null) {
                int size = this.f31505d.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f31505d.valueAt(i2).c(g2);
                }
            }
        }
    }

    public final void n(a.C1474a c1474a) throws ParserException {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, c1474a) == null) {
            int i4 = 0;
            b.i.b.a.i0.a.g(this.f31503b == null, "Unexpected moov box.");
            DrmInitData drmInitData = this.f31504c;
            if (drmInitData == null) {
                drmInitData = g(c1474a.Q0);
            }
            a.C1474a f2 = c1474a.f(b.i.b.a.a0.q.a.N);
            SparseArray sparseArray = new SparseArray();
            int size = f2.Q0.size();
            long j = -9223372036854775807L;
            for (int i5 = 0; i5 < size; i5++) {
                a.b bVar = f2.Q0.get(i5);
                int i6 = bVar.f31461a;
                if (i6 == b.i.b.a.a0.q.a.z) {
                    Pair<Integer, c> z = z(bVar.P0);
                    sparseArray.put(((Integer) z.first).intValue(), z.second);
                } else if (i6 == b.i.b.a.a0.q.a.O) {
                    j = o(bVar.P0);
                }
            }
            SparseArray sparseArray2 = new SparseArray();
            int size2 = c1474a.R0.size();
            int i7 = 0;
            while (i7 < size2) {
                a.C1474a c1474a2 = c1474a.R0.get(i7);
                if (c1474a2.f31461a == b.i.b.a.a0.q.a.E) {
                    i2 = i7;
                    i3 = size2;
                    j t = b.i.b.a.a0.q.b.t(c1474a2, c1474a.g(b.i.b.a.a0.q.a.D), j, drmInitData, (this.f31502a & 32) != 0, false);
                    if (t != null) {
                        sparseArray2.put(t.f31544a, t);
                    }
                } else {
                    i2 = i7;
                    i3 = size2;
                }
                i7 = i2 + 1;
                size2 = i3;
            }
            int size3 = sparseArray2.size();
            if (this.f31505d.size() == 0) {
                while (i4 < size3) {
                    j jVar = (j) sparseArray2.valueAt(i4);
                    b bVar2 = new b(this.C.a(i4, jVar.f31545b));
                    bVar2.a(jVar, (c) sparseArray.get(jVar.f31544a));
                    this.f31505d.put(jVar.f31544a, bVar2);
                    this.v = Math.max(this.v, jVar.f31548e);
                    i4++;
                }
                i();
                this.C.j();
                return;
            }
            b.i.b.a.i0.a.f(this.f31505d.size() == size3);
            while (i4 < size3) {
                j jVar2 = (j) sparseArray2.valueAt(i4);
                this.f31505d.get(jVar2.f31544a).a(jVar2, (c) sparseArray.get(jVar2.f31544a));
                i4++;
            }
        }
    }

    @Override // b.i.b.a.a0.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(int i2, s sVar) {
        this(i2, sVar, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), sVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (s) objArr2[1], (j) objArr2[2], (DrmInitData) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public e(int i2, s sVar, j jVar, DrmInitData drmInitData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), sVar, jVar, drmInitData};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f31502a = i2 | (jVar != null ? 16 : 0);
        this.j = sVar;
        this.f31503b = jVar;
        this.f31504c = drmInitData;
        this.k = new b.i.b.a.i0.l(16);
        this.f31506e = new b.i.b.a.i0.l(b.i.b.a.i0.j.f32615a);
        this.f31507f = new b.i.b.a.i0.l(5);
        this.f31508g = new b.i.b.a.i0.l();
        this.f31509h = new b.i.b.a.i0.l(1);
        this.f31510i = new b.i.b.a.i0.l();
        this.l = new byte[16];
        this.m = new Stack<>();
        this.n = new LinkedList<>();
        this.f31505d = new SparseArray<>();
        this.v = -9223372036854775807L;
        this.w = -9223372036854775807L;
        c();
    }
}
