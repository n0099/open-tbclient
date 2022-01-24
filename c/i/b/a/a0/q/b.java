package c.i.b.a.a0.q;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.a0.q.a;
import c.i.b.a.a0.q.d;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
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
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f28679b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f28680c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f28681d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f28682e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f28683f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f28684g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public int f28685b;

        /* renamed from: c  reason: collision with root package name */
        public int f28686c;

        /* renamed from: d  reason: collision with root package name */
        public long f28687d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f28688e;

        /* renamed from: f  reason: collision with root package name */
        public final c.i.b.a.i0.l f28689f;

        /* renamed from: g  reason: collision with root package name */
        public final c.i.b.a.i0.l f28690g;

        /* renamed from: h  reason: collision with root package name */
        public int f28691h;

        /* renamed from: i  reason: collision with root package name */
        public int f28692i;

        public a(c.i.b.a.i0.l lVar, c.i.b.a.i0.l lVar2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, lVar2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28690g = lVar;
            this.f28689f = lVar2;
            this.f28688e = z;
            lVar2.J(12);
            this.a = lVar2.B();
            lVar.J(12);
            this.f28692i = lVar.B();
            c.i.b.a.i0.a.g(lVar.i() == 1, "first_chunk must be 1");
            this.f28685b = -1;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f28685b + 1;
                this.f28685b = i2;
                if (i2 == this.a) {
                    return false;
                }
                this.f28687d = this.f28688e ? this.f28689f.C() : this.f28689f.z();
                if (this.f28685b == this.f28691h) {
                    this.f28686c = this.f28690g.B();
                    this.f28690g.K(4);
                    int i3 = this.f28692i - 1;
                    this.f28692i = i3;
                    this.f28691h = i3 > 0 ? this.f28690g.B() - 1 : -1;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: c.i.b.a.a0.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1653b {
        int a();

        int b();

        boolean c();
    }

    /* loaded from: classes9.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final k[] a;

        /* renamed from: b  reason: collision with root package name */
        public Format f28693b;

        /* renamed from: c  reason: collision with root package name */
        public int f28694c;

        /* renamed from: d  reason: collision with root package name */
        public int f28695d;

        public c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new k[i2];
            this.f28695d = 0;
        }
    }

    /* loaded from: classes9.dex */
    public static final class d implements InterfaceC1653b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28696b;

        /* renamed from: c  reason: collision with root package name */
        public final c.i.b.a.i0.l f28697c;

        public d(a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            c.i.b.a.i0.l lVar = bVar.P0;
            this.f28697c = lVar;
            lVar.J(12);
            this.a = this.f28697c.B();
            this.f28696b = this.f28697c.B();
        }

        @Override // c.i.b.a.a0.q.b.InterfaceC1653b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.a;
                return i2 == 0 ? this.f28697c.B() : i2;
            }
            return invokeV.intValue;
        }

        @Override // c.i.b.a.a0.q.b.InterfaceC1653b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28696b : invokeV.intValue;
        }

        @Override // c.i.b.a.a0.q.b.InterfaceC1653b
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a != 0 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class e implements InterfaceC1653b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.i.b.a.i0.l a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28698b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28699c;

        /* renamed from: d  reason: collision with root package name */
        public int f28700d;

        /* renamed from: e  reason: collision with root package name */
        public int f28701e;

        public e(a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            c.i.b.a.i0.l lVar = bVar.P0;
            this.a = lVar;
            lVar.J(12);
            this.f28699c = this.a.B() & 255;
            this.f28698b = this.a.B();
        }

        @Override // c.i.b.a.a0.q.b.InterfaceC1653b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f28699c;
                if (i2 == 8) {
                    return this.a.x();
                }
                if (i2 == 16) {
                    return this.a.D();
                }
                int i3 = this.f28700d;
                this.f28700d = i3 + 1;
                if (i3 % 2 == 0) {
                    int x = this.a.x();
                    this.f28701e = x;
                    return (x & 240) >> 4;
                }
                return this.f28701e & 15;
            }
            return invokeV.intValue;
        }

        @Override // c.i.b.a.a0.q.b.InterfaceC1653b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28698b : invokeV.intValue;
        }

        @Override // c.i.b.a.a0.q.b.InterfaceC1653b
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final long f28702b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28703c;

        public f(int i2, long j2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f28702b = j2;
            this.f28703c = i3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445121442, "Lc/i/b/a/a0/q/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445121442, "Lc/i/b/a/a0/q/b;");
                return;
            }
        }
        a = v.q("vide");
        f28679b = v.q("soun");
        f28680c = v.q("text");
        f28681d = v.q("sbtl");
        f28682e = v.q("subt");
        f28683f = v.q("clcp");
        v.q("cenc");
        f28684g = v.q("meta");
    }

    public static int a(c.i.b.a.i0.l lVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, lVar, i2, i3)) == null) {
            int c2 = lVar.c();
            while (c2 - i2 < i3) {
                lVar.J(c2);
                int i4 = lVar.i();
                c.i.b.a.i0.a.b(i4 > 0, "childAtomSize should be positive");
                if (lVar.i() == c.i.b.a.a0.q.a.K) {
                    return c2;
                }
                c2 += i4;
            }
            return -1;
        }
        return invokeLII.intValue;
    }

    public static void b(c.i.b.a.i0.l lVar, int i2, int i3, int i4, int i5, String str, boolean z, DrmInitData drmInitData, c cVar, int i6) throws ParserException {
        int i7;
        int i8;
        int i9;
        String str2;
        int i10;
        int i11;
        String str3;
        String str4;
        DrmInitData drmInitData2;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{lVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Boolean.valueOf(z), drmInitData, cVar, Integer.valueOf(i6)}) == null) {
            int i13 = i3;
            DrmInitData drmInitData3 = drmInitData;
            lVar.J(i13 + 8 + 8);
            if (z) {
                i7 = lVar.D();
                lVar.K(6);
            } else {
                lVar.K(8);
                i7 = 0;
            }
            if (i7 == 0 || i7 == 1) {
                int D = lVar.D();
                lVar.K(6);
                int y = lVar.y();
                if (i7 == 1) {
                    lVar.K(16);
                }
                i8 = y;
                i9 = D;
            } else if (i7 != 2) {
                return;
            } else {
                lVar.K(16);
                i8 = (int) Math.round(lVar.h());
                i9 = lVar.B();
                lVar.K(20);
            }
            int c2 = lVar.c();
            int i14 = i2;
            if (i14 == c.i.b.a.a0.q.a.b0) {
                Pair<Integer, k> n = n(lVar, i13, i4);
                if (n != null) {
                    i14 = ((Integer) n.first).intValue();
                    drmInitData3 = drmInitData3 == null ? null : drmInitData3.copyWithSchemeType(((k) n.second).a);
                    cVar.a[i6] = (k) n.second;
                }
                lVar.J(c2);
            }
            DrmInitData drmInitData4 = drmInitData3;
            String str5 = "audio/raw";
            if (i14 == c.i.b.a.a0.q.a.o) {
                str2 = "audio/ac3";
            } else if (i14 == c.i.b.a.a0.q.a.q) {
                str2 = "audio/eac3";
            } else if (i14 == c.i.b.a.a0.q.a.s) {
                str2 = "audio/vnd.dts";
            } else if (i14 == c.i.b.a.a0.q.a.t || i14 == c.i.b.a.a0.q.a.u) {
                str2 = "audio/vnd.dts.hd";
            } else if (i14 == c.i.b.a.a0.q.a.v) {
                str2 = "audio/vnd.dts.hd;profile=lbr";
            } else if (i14 == c.i.b.a.a0.q.a.y0) {
                str2 = "audio/3gpp";
            } else if (i14 == c.i.b.a.a0.q.a.z0) {
                str2 = "audio/amr-wb";
            } else if (i14 == c.i.b.a.a0.q.a.m || i14 == c.i.b.a.a0.q.a.n) {
                str2 = "audio/raw";
            } else if (i14 == c.i.b.a.a0.q.a.k) {
                str2 = "audio/mpeg";
            } else {
                str2 = i14 == c.i.b.a.a0.q.a.O0 ? "audio/alac" : null;
            }
            String str6 = str2;
            int i15 = i9;
            int i16 = i8;
            int i17 = c2;
            byte[] bArr = null;
            while (i17 - i13 < i4) {
                lVar.J(i17);
                int i18 = lVar.i();
                c.i.b.a.i0.a.b(i18 > 0, "childAtomSize should be positive");
                int i19 = lVar.i();
                if (i19 != c.i.b.a.a0.q.a.K && (!z || i19 != c.i.b.a.a0.q.a.l)) {
                    if (i19 == c.i.b.a.a0.q.a.p) {
                        lVar.J(i17 + 8);
                        cVar.f28693b = c.i.b.a.x.a.c(lVar, Integer.toString(i5), str, drmInitData4);
                    } else if (i19 == c.i.b.a.a0.q.a.r) {
                        lVar.J(i17 + 8);
                        cVar.f28693b = c.i.b.a.x.a.f(lVar, Integer.toString(i5), str, drmInitData4);
                    } else {
                        if (i19 == c.i.b.a.a0.q.a.w) {
                            i12 = i17;
                            str3 = str6;
                            str4 = str5;
                            drmInitData2 = drmInitData4;
                            cVar.f28693b = Format.createAudioSampleFormat(Integer.toString(i5), str6, null, -1, -1, i15, i16, null, drmInitData2, 0, str);
                            i10 = i18;
                        } else {
                            i12 = i17;
                            str3 = str6;
                            str4 = str5;
                            drmInitData2 = drmInitData4;
                            i10 = i18;
                            if (i19 == c.i.b.a.a0.q.a.O0) {
                                byte[] bArr2 = new byte[i10];
                                i11 = i12;
                                lVar.J(i11);
                                lVar.g(bArr2, 0, i10);
                                bArr = bArr2;
                            }
                        }
                        i11 = i12;
                    }
                    i10 = i18;
                    i11 = i17;
                    str3 = str6;
                    str4 = str5;
                    drmInitData2 = drmInitData4;
                } else {
                    i10 = i18;
                    i11 = i17;
                    str3 = str6;
                    str4 = str5;
                    drmInitData2 = drmInitData4;
                    int a2 = i19 == c.i.b.a.a0.q.a.K ? i11 : a(lVar, i11, i10);
                    if (a2 != -1) {
                        Pair<String, byte[]> e2 = e(lVar, a2);
                        str6 = (String) e2.first;
                        bArr = (byte[]) e2.second;
                        if ("audio/mp4a-latm".equals(str6)) {
                            Pair<Integer, Integer> i20 = c.i.b.a.i0.c.i(bArr);
                            i16 = ((Integer) i20.first).intValue();
                            i15 = ((Integer) i20.second).intValue();
                        }
                        i17 = i11 + i10;
                        i13 = i3;
                        drmInitData4 = drmInitData2;
                        str5 = str4;
                    }
                }
                str6 = str3;
                i17 = i11 + i10;
                i13 = i3;
                drmInitData4 = drmInitData2;
                str5 = str4;
            }
            String str7 = str6;
            String str8 = str5;
            DrmInitData drmInitData5 = drmInitData4;
            if (cVar.f28693b != null || str7 == null) {
                return;
            }
            cVar.f28693b = Format.createAudioSampleFormat(Integer.toString(i5), str7, null, -1, -1, i15, i16, str8.equals(str7) ? 2 : -1, bArr != null ? Collections.singletonList(bArr) : null, drmInitData5, 0, str);
        }
    }

    public static Pair<Integer, k> c(c.i.b.a.i0.l lVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, lVar, i2, i3)) == null) {
            int i4 = i2 + 8;
            String str = null;
            Integer num = null;
            int i5 = -1;
            int i6 = 0;
            while (i4 - i2 < i3) {
                lVar.J(i4);
                int i7 = lVar.i();
                int i8 = lVar.i();
                if (i8 == c.i.b.a.a0.q.a.c0) {
                    num = Integer.valueOf(lVar.i());
                } else if (i8 == c.i.b.a.a0.q.a.X) {
                    lVar.K(4);
                    str = lVar.u(4);
                } else if (i8 == c.i.b.a.a0.q.a.Y) {
                    i5 = i4;
                    i6 = i7;
                }
                i4 += i7;
            }
            if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                c.i.b.a.i0.a.b(num != null, "frma atom is mandatory");
                c.i.b.a.i0.a.b(i5 != -1, "schi atom is mandatory");
                k o = o(lVar, i5, i6, str);
                c.i.b.a.i0.a.b(o != null, "tenc atom is mandatory");
                return Pair.create(num, o);
            }
            return null;
        }
        return (Pair) invokeLII.objValue;
    }

    public static Pair<long[], long[]> d(a.C1652a c1652a) {
        InterceptResult invokeL;
        a.b g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c1652a)) == null) {
            if (c1652a != null && (g2 = c1652a.g(c.i.b.a.a0.q.a.R)) != null) {
                c.i.b.a.i0.l lVar = g2.P0;
                lVar.J(8);
                int c2 = c.i.b.a.a0.q.a.c(lVar.i());
                int B = lVar.B();
                long[] jArr = new long[B];
                long[] jArr2 = new long[B];
                for (int i2 = 0; i2 < B; i2++) {
                    jArr[i2] = c2 == 1 ? lVar.C() : lVar.z();
                    jArr2[i2] = c2 == 1 ? lVar.q() : lVar.i();
                    if (lVar.t() == 1) {
                        lVar.K(2);
                    } else {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                }
                return Pair.create(jArr, jArr2);
            }
            return Pair.create(null, null);
        }
        return (Pair) invokeL.objValue;
    }

    public static Pair<String, byte[]> e(c.i.b.a.i0.l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, lVar, i2)) == null) {
            lVar.J(i2 + 8 + 4);
            lVar.K(1);
            f(lVar);
            lVar.K(2);
            int x = lVar.x();
            if ((x & 128) != 0) {
                lVar.K(2);
            }
            if ((x & 64) != 0) {
                lVar.K(lVar.D());
            }
            if ((x & 32) != 0) {
                lVar.K(2);
            }
            lVar.K(1);
            f(lVar);
            int x2 = lVar.x();
            String str = null;
            if (x2 == 32) {
                str = "video/mp4v-es";
            } else if (x2 == 33) {
                str = "video/avc";
            } else if (x2 != 35) {
                if (x2 != 64) {
                    if (x2 == 107) {
                        return Pair.create("audio/mpeg", null);
                    }
                    if (x2 == 96 || x2 == 97) {
                        str = "video/mpeg2";
                    } else if (x2 == 165) {
                        str = "audio/ac3";
                    } else if (x2 != 166) {
                        switch (x2) {
                            case 102:
                            case 103:
                            case 104:
                                break;
                            default:
                                switch (x2) {
                                    case 169:
                                    case 172:
                                        return Pair.create("audio/vnd.dts", null);
                                    case Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID /* 170 */:
                                    case Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID /* 171 */:
                                        return Pair.create("audio/vnd.dts.hd", null);
                                }
                        }
                    } else {
                        str = "audio/eac3";
                    }
                }
                str = "audio/mp4a-latm";
            } else {
                str = "video/hevc";
            }
            lVar.K(12);
            lVar.K(1);
            int f2 = f(lVar);
            byte[] bArr = new byte[f2];
            lVar.g(bArr, 0, f2);
            return Pair.create(str, bArr);
        }
        return (Pair) invokeLI.objValue;
    }

    public static int f(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, lVar)) == null) {
            int x = lVar.x();
            int i2 = x & 127;
            while ((x & 128) == 128) {
                x = lVar.x();
                i2 = (i2 << 7) | (x & 127);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public static int g(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, lVar)) == null) {
            lVar.J(16);
            int i2 = lVar.i();
            if (i2 == f28679b) {
                return 1;
            }
            if (i2 == a) {
                return 2;
            }
            if (i2 == f28680c || i2 == f28681d || i2 == f28682e || i2 == f28683f) {
                return 3;
            }
            return i2 == f28684g ? 4 : -1;
        }
        return invokeL.intValue;
    }

    public static Metadata h(c.i.b.a.i0.l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, lVar, i2)) == null) {
            lVar.K(8);
            ArrayList arrayList = new ArrayList();
            while (lVar.c() < i2) {
                Metadata.Entry c2 = c.i.b.a.a0.q.f.c(lVar);
                if (c2 != null) {
                    arrayList.add(c2);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new Metadata(arrayList);
        }
        return (Metadata) invokeLI.objValue;
    }

    public static Pair<Long, String> i(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, lVar)) == null) {
            lVar.J(8);
            int c2 = c.i.b.a.a0.q.a.c(lVar.i());
            lVar.K(c2 == 0 ? 8 : 16);
            long z = lVar.z();
            lVar.K(c2 == 0 ? 4 : 8);
            int D = lVar.D();
            return Pair.create(Long.valueOf(z), "" + ((char) (((D >> 10) & 31) + 96)) + ((char) (((D >> 5) & 31) + 96)) + ((char) ((D & 31) + 96)));
        }
        return (Pair) invokeL.objValue;
    }

    public static Metadata j(c.i.b.a.i0.l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, lVar, i2)) == null) {
            lVar.K(12);
            while (lVar.c() < i2) {
                int c2 = lVar.c();
                int i3 = lVar.i();
                if (lVar.i() == c.i.b.a.a0.q.a.C0) {
                    lVar.J(c2);
                    return h(lVar, c2 + i3);
                }
                lVar.K(i3 - 8);
            }
            return null;
        }
        return (Metadata) invokeLI.objValue;
    }

    public static long k(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, lVar)) == null) {
            lVar.J(8);
            lVar.K(c.i.b.a.a0.q.a.c(lVar.i()) != 0 ? 16 : 8);
            return lVar.z();
        }
        return invokeL.longValue;
    }

    public static float l(c.i.b.a.i0.l lVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, lVar, i2)) == null) {
            lVar.J(i2 + 8);
            return lVar.B() / lVar.B();
        }
        return invokeLI.floatValue;
    }

    public static byte[] m(c.i.b.a.i0.l lVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65549, null, lVar, i2, i3)) == null) {
            int i4 = i2 + 8;
            while (i4 - i2 < i3) {
                lVar.J(i4);
                int i5 = lVar.i();
                if (lVar.i() == c.i.b.a.a0.q.a.J0) {
                    return Arrays.copyOfRange(lVar.a, i4, i5 + i4);
                }
                i4 += i5;
            }
            return null;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static Pair<Integer, k> n(c.i.b.a.i0.l lVar, int i2, int i3) {
        InterceptResult invokeLII;
        Pair<Integer, k> c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65550, null, lVar, i2, i3)) == null) {
            int c3 = lVar.c();
            while (c3 - i2 < i3) {
                lVar.J(c3);
                int i4 = lVar.i();
                c.i.b.a.i0.a.b(i4 > 0, "childAtomSize should be positive");
                if (lVar.i() == c.i.b.a.a0.q.a.W && (c2 = c(lVar, c3, i4)) != null) {
                    return c2;
                }
                c3 += i4;
            }
            return null;
        }
        return (Pair) invokeLII.objValue;
    }

    public static k o(c.i.b.a.i0.l lVar, int i2, int i3, String str) {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{lVar, Integer.valueOf(i2), Integer.valueOf(i3), str})) != null) {
            return (k) invokeCommon.objValue;
        }
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            lVar.J(i6);
            int i7 = lVar.i();
            if (lVar.i() == c.i.b.a.a0.q.a.Z) {
                int c2 = c.i.b.a.a0.q.a.c(lVar.i());
                lVar.K(1);
                if (c2 == 0) {
                    lVar.K(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int x = lVar.x();
                    i4 = x & 15;
                    i5 = (x & 240) >> 4;
                }
                boolean z = lVar.x() == 1;
                int x2 = lVar.x();
                byte[] bArr2 = new byte[16];
                lVar.g(bArr2, 0, 16);
                if (z && x2 == 0) {
                    int x3 = lVar.x();
                    bArr = new byte[x3];
                    lVar.g(bArr, 0, x3);
                }
                return new k(z, str, x2, bArr2, i5, i4, bArr);
            }
            i6 += i7;
        }
    }

    public static m p(j jVar, a.C1652a c1652a, c.i.b.a.a0.i iVar) throws ParserException {
        InterceptResult invokeLLL;
        InterfaceC1653b eVar;
        boolean z;
        int i2;
        int i3;
        j jVar2;
        int i4;
        long[] jArr;
        int[] iArr;
        int i5;
        long[] jArr2;
        int[] iArr2;
        long j2;
        long j3;
        boolean z2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        long[] jArr3;
        int i6;
        int[] iArr6;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, jVar, c1652a, iVar)) == null) {
            a.b g2 = c1652a.g(c.i.b.a.a0.q.a.q0);
            if (g2 != null) {
                eVar = new d(g2);
            } else {
                a.b g3 = c1652a.g(c.i.b.a.a0.q.a.r0);
                if (g3 != null) {
                    eVar = new e(g3);
                } else {
                    throw new ParserException("Track has no sample table size information");
                }
            }
            int b2 = eVar.b();
            if (b2 == 0) {
                return new m(new long[0], new int[0], 0, new long[0], new int[0]);
            }
            a.b g4 = c1652a.g(c.i.b.a.a0.q.a.s0);
            if (g4 == null) {
                g4 = c1652a.g(c.i.b.a.a0.q.a.t0);
                z = true;
            } else {
                z = false;
            }
            c.i.b.a.i0.l lVar = g4.P0;
            c.i.b.a.i0.l lVar2 = c1652a.g(c.i.b.a.a0.q.a.p0).P0;
            c.i.b.a.i0.l lVar3 = c1652a.g(c.i.b.a.a0.q.a.m0).P0;
            a.b g5 = c1652a.g(c.i.b.a.a0.q.a.n0);
            c.i.b.a.i0.l lVar4 = null;
            c.i.b.a.i0.l lVar5 = g5 != null ? g5.P0 : null;
            a.b g6 = c1652a.g(c.i.b.a.a0.q.a.o0);
            c.i.b.a.i0.l lVar6 = g6 != null ? g6.P0 : null;
            a aVar = new a(lVar2, lVar, z);
            lVar3.J(12);
            int B = lVar3.B() - 1;
            int B2 = lVar3.B();
            int B3 = lVar3.B();
            if (lVar6 != null) {
                lVar6.J(12);
                i2 = lVar6.B();
            } else {
                i2 = 0;
            }
            int i10 = -1;
            if (lVar5 != null) {
                lVar5.J(12);
                i3 = lVar5.B();
                if (i3 > 0) {
                    i10 = lVar5.B() - 1;
                    lVar4 = lVar5;
                }
            } else {
                lVar4 = lVar5;
                i3 = 0;
            }
            long j4 = 0;
            if (!(eVar.c() && "audio/raw".equals(jVar.f28752f.sampleMimeType) && B == 0 && i2 == 0 && i3 == 0)) {
                long[] jArr4 = new long[b2];
                iArr = new int[b2];
                jArr2 = new long[b2];
                int i11 = i3;
                iArr2 = new int[b2];
                int i12 = i10;
                long j5 = 0;
                j2 = 0;
                int i13 = 0;
                i5 = 0;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                int i17 = i2;
                int i18 = B3;
                int i19 = B2;
                int i20 = B;
                int i21 = i11;
                while (i13 < b2) {
                    while (i15 == 0) {
                        c.i.b.a.i0.a.f(aVar.a());
                        j5 = aVar.f28687d;
                        i15 = aVar.f28686c;
                        i18 = i18;
                        i19 = i19;
                    }
                    int i22 = i19;
                    int i23 = i18;
                    if (lVar6 != null) {
                        while (i14 == 0 && i17 > 0) {
                            i14 = lVar6.B();
                            i16 = lVar6.i();
                            i17--;
                        }
                        i14--;
                    }
                    int i24 = i16;
                    jArr4[i13] = j5;
                    iArr[i13] = eVar.a();
                    if (iArr[i13] > i5) {
                        i5 = iArr[i13];
                    }
                    int i25 = b2;
                    InterfaceC1653b interfaceC1653b = eVar;
                    jArr2[i13] = j2 + i24;
                    iArr2[i13] = lVar4 == null ? 1 : 0;
                    if (i13 == i12) {
                        iArr2[i13] = 1;
                        i21--;
                        if (i21 > 0) {
                            i12 = lVar4.B() - 1;
                        }
                    }
                    long[] jArr5 = jArr4;
                    j2 += i23;
                    int i26 = i22 - 1;
                    if (i26 != 0 || i20 <= 0) {
                        i8 = i23;
                        i9 = i26;
                    } else {
                        i9 = lVar3.B();
                        i8 = lVar3.i();
                        i20--;
                    }
                    int i27 = i9;
                    j5 += iArr[i13];
                    i15--;
                    i13++;
                    b2 = i25;
                    jArr4 = jArr5;
                    i12 = i12;
                    i16 = i24;
                    i19 = i27;
                    i18 = i8;
                    eVar = interfaceC1653b;
                }
                i4 = b2;
                long[] jArr6 = jArr4;
                int i28 = i19;
                c.i.b.a.i0.a.a(i14 == 0);
                while (i17 > 0) {
                    c.i.b.a.i0.a.a(lVar6.B() == 0);
                    lVar6.i();
                    i17--;
                }
                if (i21 == 0 && i28 == 0) {
                    i7 = i15;
                    if (i7 == 0 && i20 == 0) {
                        jVar2 = jVar;
                        jArr = jArr6;
                    }
                } else {
                    i7 = i15;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Inconsistent stbl box for track ");
                jVar2 = jVar;
                sb.append(jVar2.a);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i21);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i28);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i7);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i20);
                sb.toString();
                jArr = jArr6;
            } else {
                jVar2 = jVar;
                i4 = b2;
                InterfaceC1653b interfaceC1653b2 = eVar;
                int i29 = aVar.a;
                long[] jArr7 = new long[i29];
                int[] iArr7 = new int[i29];
                while (aVar.a()) {
                    int i30 = aVar.f28685b;
                    jArr7[i30] = aVar.f28687d;
                    iArr7[i30] = aVar.f28686c;
                }
                d.b a2 = c.i.b.a.a0.q.d.a(interfaceC1653b2.a(), jArr7, iArr7, B3);
                jArr = a2.a;
                iArr = a2.f28707b;
                i5 = a2.f28708c;
                jArr2 = a2.f28709d;
                iArr2 = a2.f28710e;
                j2 = 0;
            }
            if (jVar2.f28754h != null && !iVar.a()) {
                long[] jArr8 = jVar2.f28754h;
                if (jArr8.length == 1 && jVar2.f28748b == 1 && jArr2.length >= 2) {
                    long j6 = jVar2.f28755i[0];
                    long F = v.F(jArr8[0], jVar2.f28749c, jVar2.f28750d) + j6;
                    if (jArr2[0] <= j6 && j6 < jArr2[1] && jArr2[jArr2.length - 1] < F && F <= j2) {
                        long j7 = j2 - F;
                        long F2 = v.F(j6 - jArr2[0], jVar2.f28752f.sampleRate, jVar2.f28749c);
                        long F3 = v.F(j7, jVar2.f28752f.sampleRate, jVar2.f28749c);
                        if ((F2 != 0 || F3 != 0) && F2 <= 2147483647L && F3 <= 2147483647L) {
                            iVar.a = (int) F2;
                            iVar.f28591b = (int) F3;
                            v.H(jArr2, 1000000L, jVar2.f28749c);
                            return new m(jArr, iArr, i5, jArr2, iArr2);
                        }
                    }
                }
                long[] jArr9 = jVar2.f28754h;
                if (jArr9.length == 1) {
                    char c2 = 0;
                    if (jArr9[0] == 0) {
                        int i31 = 0;
                        while (i31 < jArr2.length) {
                            jArr2[i31] = v.F(jArr2[i31] - jVar2.f28755i[c2], 1000000L, jVar2.f28749c);
                            i31++;
                            c2 = 0;
                        }
                        return new m(jArr, iArr, i5, jArr2, iArr2);
                    }
                }
                boolean z3 = jVar2.f28748b == 1;
                boolean z4 = false;
                int i32 = 0;
                int i33 = 0;
                int i34 = 0;
                while (true) {
                    long[] jArr10 = jVar2.f28754h;
                    j3 = -1;
                    if (i32 >= jArr10.length) {
                        break;
                    }
                    long j8 = jVar2.f28755i[i32];
                    if (j8 != -1) {
                        i6 = i5;
                        iArr6 = iArr;
                        long F4 = v.F(jArr10[i32], jVar2.f28749c, jVar2.f28750d);
                        int b3 = v.b(jArr2, j8, true, true);
                        int b4 = v.b(jArr2, j8 + F4, z3, false);
                        i33 += b4 - b3;
                        z4 |= i34 != b3;
                        i34 = b4;
                    } else {
                        i6 = i5;
                        iArr6 = iArr;
                    }
                    i32++;
                    iArr = iArr6;
                    i5 = i6;
                }
                int i35 = i5;
                int[] iArr8 = iArr;
                boolean z5 = z4 | (i33 != i4);
                long[] jArr11 = z5 ? new long[i33] : jArr;
                int[] iArr9 = z5 ? new int[i33] : iArr8;
                int i36 = z5 ? 0 : i35;
                int[] iArr10 = z5 ? new int[i33] : iArr2;
                long[] jArr12 = new long[i33];
                int i37 = i36;
                int i38 = 0;
                int i39 = 0;
                while (true) {
                    long[] jArr13 = jVar2.f28754h;
                    if (i38 >= jArr13.length) {
                        break;
                    }
                    long[] jArr14 = jArr12;
                    int[] iArr11 = iArr10;
                    long j9 = jVar2.f28755i[i38];
                    long j10 = jArr13[i38];
                    if (j9 != j3) {
                        int b5 = v.b(jArr2, j9, true, true);
                        int b6 = v.b(jArr2, v.F(j10, jVar2.f28749c, jVar2.f28750d) + j9, z3, false);
                        if (z5) {
                            int i40 = b6 - b5;
                            System.arraycopy(jArr, b5, jArr11, i39, i40);
                            iArr5 = iArr8;
                            System.arraycopy(iArr5, b5, iArr9, i39, i40);
                            z2 = z3;
                            iArr4 = iArr11;
                            System.arraycopy(iArr2, b5, iArr4, i39, i40);
                        } else {
                            iArr5 = iArr8;
                            z2 = z3;
                            iArr4 = iArr11;
                        }
                        int i41 = i37;
                        while (b5 < b6) {
                            long[] jArr15 = jArr;
                            int[] iArr12 = iArr2;
                            long j11 = j9;
                            jArr14[i39] = v.F(j4, 1000000L, jVar2.f28750d) + v.F(jArr2[b5] - j9, 1000000L, jVar2.f28749c);
                            if (z5 && iArr9[i39] > i41) {
                                i41 = iArr5[b5];
                            }
                            i39++;
                            b5++;
                            jArr = jArr15;
                            j9 = j11;
                            iArr2 = iArr12;
                        }
                        jArr3 = jArr;
                        iArr3 = iArr2;
                        i37 = i41;
                    } else {
                        z2 = z3;
                        iArr3 = iArr2;
                        iArr4 = iArr11;
                        iArr5 = iArr8;
                        jArr3 = jArr;
                    }
                    j4 += j10;
                    i38++;
                    jArr = jArr3;
                    iArr10 = iArr4;
                    iArr8 = iArr5;
                    z3 = z2;
                    jArr12 = jArr14;
                    iArr2 = iArr3;
                    j3 = -1;
                }
                int[] iArr13 = iArr8;
                long[] jArr16 = jArr;
                int[] iArr14 = iArr2;
                long[] jArr17 = jArr12;
                int[] iArr15 = iArr10;
                boolean z6 = false;
                for (int i42 = 0; i42 < iArr15.length && !z6; i42++) {
                    z6 |= (iArr15[i42] & 1) != 0;
                }
                if (!z6) {
                    v.H(jArr2, 1000000L, jVar2.f28749c);
                    return new m(jArr16, iArr13, i35, jArr2, iArr14);
                }
                return new m(jArr11, iArr9, i37, jArr17, iArr15);
            }
            int i43 = i5;
            int[] iArr16 = iArr;
            v.H(jArr2, 1000000L, jVar2.f28749c);
            return new m(jArr, iArr16, i43, jArr2, iArr2);
        }
        return (m) invokeLLL.objValue;
    }

    public static c q(c.i.b.a.i0.l lVar, int i2, int i3, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{lVar, Integer.valueOf(i2), Integer.valueOf(i3), str, drmInitData, Boolean.valueOf(z)})) == null) {
            lVar.J(12);
            int i4 = lVar.i();
            c cVar = new c(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                int c2 = lVar.c();
                int i6 = lVar.i();
                c.i.b.a.i0.a.b(i6 > 0, "childAtomSize should be positive");
                int i7 = lVar.i();
                if (i7 != c.i.b.a.a0.q.a.f28671c && i7 != c.i.b.a.a0.q.a.f28672d && i7 != c.i.b.a.a0.q.a.a0 && i7 != c.i.b.a.a0.q.a.l0 && i7 != c.i.b.a.a0.q.a.f28673e && i7 != c.i.b.a.a0.q.a.f28674f && i7 != c.i.b.a.a0.q.a.f28675g && i7 != c.i.b.a.a0.q.a.K0 && i7 != c.i.b.a.a0.q.a.L0) {
                    if (i7 != c.i.b.a.a0.q.a.f28678j && i7 != c.i.b.a.a0.q.a.b0 && i7 != c.i.b.a.a0.q.a.o && i7 != c.i.b.a.a0.q.a.q && i7 != c.i.b.a.a0.q.a.s && i7 != c.i.b.a.a0.q.a.v && i7 != c.i.b.a.a0.q.a.t && i7 != c.i.b.a.a0.q.a.u && i7 != c.i.b.a.a0.q.a.y0 && i7 != c.i.b.a.a0.q.a.z0 && i7 != c.i.b.a.a0.q.a.m && i7 != c.i.b.a.a0.q.a.n && i7 != c.i.b.a.a0.q.a.k && i7 != c.i.b.a.a0.q.a.O0) {
                        if (i7 != c.i.b.a.a0.q.a.k0 && i7 != c.i.b.a.a0.q.a.u0 && i7 != c.i.b.a.a0.q.a.v0 && i7 != c.i.b.a.a0.q.a.w0 && i7 != c.i.b.a.a0.q.a.x0) {
                            if (i7 == c.i.b.a.a0.q.a.N0) {
                                cVar.f28693b = Format.createSampleFormat(Integer.toString(i2), "application/x-camera-motion", null, -1, null);
                            }
                        } else {
                            r(lVar, i7, c2, i6, i2, str, cVar);
                        }
                    } else {
                        b(lVar, i7, c2, i6, i2, str, z, drmInitData, cVar, i5);
                    }
                } else {
                    v(lVar, i7, c2, i6, i2, i3, drmInitData, cVar, i5);
                }
                lVar.J(c2 + i6);
            }
            return cVar;
        }
        return (c) invokeCommon.objValue;
    }

    public static void r(c.i.b.a.i0.l lVar, int i2, int i3, int i4, int i5, String str, c cVar) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, null, new Object[]{lVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, cVar}) == null) {
            lVar.J(i3 + 8 + 8);
            String str2 = "application/ttml+xml";
            List list = null;
            long j2 = Long.MAX_VALUE;
            if (i2 != c.i.b.a.a0.q.a.k0) {
                if (i2 == c.i.b.a.a0.q.a.u0) {
                    int i6 = (i4 - 8) - 8;
                    byte[] bArr = new byte[i6];
                    lVar.g(bArr, 0, i6);
                    list = Collections.singletonList(bArr);
                    str2 = "application/x-quicktime-tx3g";
                } else if (i2 == c.i.b.a.a0.q.a.v0) {
                    str2 = "application/x-mp4-vtt";
                } else if (i2 == c.i.b.a.a0.q.a.w0) {
                    j2 = 0;
                } else if (i2 == c.i.b.a.a0.q.a.x0) {
                    cVar.f28695d = 1;
                    str2 = "application/x-mp4-cea-608";
                } else {
                    throw new IllegalStateException();
                }
            }
            cVar.f28693b = Format.createTextSampleFormat(Integer.toString(i5), str2, null, -1, 0, str, -1, null, j2, list);
        }
    }

    public static f s(c.i.b.a.i0.l lVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, lVar)) == null) {
            lVar.J(8);
            int c2 = c.i.b.a.a0.q.a.c(lVar.i());
            lVar.K(c2 == 0 ? 8 : 16);
            int i2 = lVar.i();
            lVar.K(4);
            int c3 = lVar.c();
            int i3 = c2 == 0 ? 4 : 8;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i5 >= i3) {
                    z = true;
                    break;
                } else if (lVar.a[c3 + i5] != -1) {
                    z = false;
                    break;
                } else {
                    i5++;
                }
            }
            long j2 = -9223372036854775807L;
            if (z) {
                lVar.K(i3);
            } else {
                long z2 = c2 == 0 ? lVar.z() : lVar.C();
                if (z2 != 0) {
                    j2 = z2;
                }
            }
            lVar.K(16);
            int i6 = lVar.i();
            int i7 = lVar.i();
            lVar.K(4);
            int i8 = lVar.i();
            int i9 = lVar.i();
            if (i6 == 0 && i7 == 65536 && i8 == -65536 && i9 == 0) {
                i4 = 90;
            } else if (i6 == 0 && i7 == -65536 && i8 == 65536 && i9 == 0) {
                i4 = 270;
            } else if (i6 == -65536 && i7 == 0 && i8 == 0 && i9 == -65536) {
                i4 = 180;
            }
            return new f(i2, j2, i4);
        }
        return (f) invokeL.objValue;
    }

    public static j t(a.C1652a c1652a, a.b bVar, long j2, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        InterceptResult invokeCommon;
        a.b bVar2;
        long j3;
        long[] jArr;
        long[] jArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, null, new Object[]{c1652a, bVar, Long.valueOf(j2), drmInitData, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            a.C1652a f2 = c1652a.f(c.i.b.a.a0.q.a.F);
            int g2 = g(f2.g(c.i.b.a.a0.q.a.T).P0);
            if (g2 == -1) {
                return null;
            }
            f s = s(c1652a.g(c.i.b.a.a0.q.a.P).P0);
            if (j2 == -9223372036854775807L) {
                bVar2 = bVar;
                j3 = s.f28702b;
            } else {
                bVar2 = bVar;
                j3 = j2;
            }
            long k = k(bVar2.P0);
            long F = j3 != -9223372036854775807L ? v.F(j3, 1000000L, k) : -9223372036854775807L;
            a.C1652a f3 = f2.f(c.i.b.a.a0.q.a.G).f(c.i.b.a.a0.q.a.H);
            Pair<Long, String> i2 = i(f2.g(c.i.b.a.a0.q.a.S).P0);
            c q = q(f3.g(c.i.b.a.a0.q.a.U).P0, s.a, s.f28703c, (String) i2.second, drmInitData, z2);
            if (z) {
                jArr = null;
                jArr2 = null;
            } else {
                Pair<long[], long[]> d2 = d(c1652a.f(c.i.b.a.a0.q.a.Q));
                jArr2 = (long[]) d2.second;
                jArr = (long[]) d2.first;
            }
            if (q.f28693b == null) {
                return null;
            }
            return new j(s.a, g2, ((Long) i2.first).longValue(), k, F, q.f28693b, q.f28695d, q.a, q.f28694c, jArr, jArr2);
        }
        return (j) invokeCommon.objValue;
    }

    public static Metadata u(a.b bVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65557, null, bVar, z)) == null) {
            if (z) {
                return null;
            }
            c.i.b.a.i0.l lVar = bVar.P0;
            lVar.J(8);
            while (lVar.a() >= 8) {
                int c2 = lVar.c();
                int i2 = lVar.i();
                if (lVar.i() == c.i.b.a.a0.q.a.B0) {
                    lVar.J(c2);
                    return j(lVar, c2 + i2);
                }
                lVar.K(i2 - 8);
            }
            return null;
        }
        return (Metadata) invokeLZ.objValue;
    }

    public static void v(c.i.b.a.i0.l lVar, int i2, int i3, int i4, int i5, int i6, DrmInitData drmInitData, c cVar, int i7) throws ParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{lVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), drmInitData, cVar, Integer.valueOf(i7)}) == null) {
            DrmInitData drmInitData2 = drmInitData;
            lVar.J(i3 + 8 + 8);
            lVar.K(16);
            int D = lVar.D();
            int D2 = lVar.D();
            lVar.K(50);
            int c2 = lVar.c();
            String str = null;
            int i8 = i2;
            if (i8 == c.i.b.a.a0.q.a.a0) {
                Pair<Integer, k> n = n(lVar, i3, i4);
                if (n != null) {
                    i8 = ((Integer) n.first).intValue();
                    drmInitData2 = drmInitData2 == null ? null : drmInitData2.copyWithSchemeType(((k) n.second).a);
                    cVar.a[i7] = (k) n.second;
                }
                lVar.J(c2);
            }
            DrmInitData drmInitData3 = drmInitData2;
            List<byte[]> list = null;
            byte[] bArr = null;
            boolean z = false;
            float f2 = 1.0f;
            int i9 = -1;
            while (c2 - i3 < i4) {
                lVar.J(c2);
                int c3 = lVar.c();
                int i10 = lVar.i();
                if (i10 == 0 && lVar.c() - i3 == i4) {
                    break;
                }
                c.i.b.a.i0.a.b(i10 > 0, "childAtomSize should be positive");
                int i11 = lVar.i();
                if (i11 == c.i.b.a.a0.q.a.I) {
                    c.i.b.a.i0.a.f(str == null);
                    lVar.J(c3 + 8);
                    c.i.b.a.j0.a b2 = c.i.b.a.j0.a.b(lVar);
                    list = b2.a;
                    cVar.f28694c = b2.f29794b;
                    if (!z) {
                        f2 = b2.f29797e;
                    }
                    str = "video/avc";
                } else if (i11 == c.i.b.a.a0.q.a.J) {
                    c.i.b.a.i0.a.f(str == null);
                    lVar.J(c3 + 8);
                    c.i.b.a.j0.b a2 = c.i.b.a.j0.b.a(lVar);
                    list = a2.a;
                    cVar.f28694c = a2.f29798b;
                    str = "video/hevc";
                } else if (i11 == c.i.b.a.a0.q.a.M0) {
                    c.i.b.a.i0.a.f(str == null);
                    str = i8 == c.i.b.a.a0.q.a.K0 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                } else if (i11 == c.i.b.a.a0.q.a.f28676h) {
                    c.i.b.a.i0.a.f(str == null);
                    str = "video/3gpp";
                } else if (i11 == c.i.b.a.a0.q.a.K) {
                    c.i.b.a.i0.a.f(str == null);
                    Pair<String, byte[]> e2 = e(lVar, c3);
                    str = (String) e2.first;
                    list = Collections.singletonList(e2.second);
                } else if (i11 == c.i.b.a.a0.q.a.j0) {
                    f2 = l(lVar, c3);
                    z = true;
                } else if (i11 == c.i.b.a.a0.q.a.I0) {
                    bArr = m(lVar, c3, i10);
                } else if (i11 == c.i.b.a.a0.q.a.H0) {
                    int x = lVar.x();
                    lVar.K(3);
                    if (x == 0) {
                        int x2 = lVar.x();
                        if (x2 == 0) {
                            i9 = 0;
                        } else if (x2 == 1) {
                            i9 = 1;
                        } else if (x2 == 2) {
                            i9 = 2;
                        } else if (x2 == 3) {
                            i9 = 3;
                        }
                    }
                }
                c2 += i10;
            }
            if (str == null) {
                return;
            }
            cVar.f28693b = Format.createVideoSampleFormat(Integer.toString(i5), str, null, -1, -1, D, D2, -1.0f, list, i6, f2, bArr, i9, null, drmInitData3);
        }
    }
}
