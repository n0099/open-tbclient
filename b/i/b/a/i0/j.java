package b.i.b.a.i0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes6.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f32615a;

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f32616b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f32617c;

    /* renamed from: d  reason: collision with root package name */
    public static int[] f32618d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f32619a;

        /* renamed from: b  reason: collision with root package name */
        public final int f32620b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f32621c;

        public a(int i2, int i3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32619a = i2;
            this.f32620b = i3;
            this.f32621c = z;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f32622a;

        /* renamed from: b  reason: collision with root package name */
        public final int f32623b;

        /* renamed from: c  reason: collision with root package name */
        public final int f32624c;

        /* renamed from: d  reason: collision with root package name */
        public final float f32625d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f32626e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f32627f;

        /* renamed from: g  reason: collision with root package name */
        public final int f32628g;

        /* renamed from: h  reason: collision with root package name */
        public final int f32629h;

        /* renamed from: i  reason: collision with root package name */
        public final int f32630i;
        public final boolean j;

        public b(int i2, int i3, int i4, float f2, boolean z, boolean z2, int i5, int i6, int i7, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i8 = newInitContext.flag;
                if ((i8 & 1) != 0) {
                    int i9 = i8 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32622a = i2;
            this.f32623b = i3;
            this.f32624c = i4;
            this.f32625d = f2;
            this.f32626e = z;
            this.f32627f = z2;
            this.f32628g = i5;
            this.f32629h = i6;
            this.f32630i = i7;
            this.j = z3;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-423693761, "Lb/i/b/a/i0/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-423693761, "Lb/i/b/a/i0/j;");
                return;
            }
        }
        f32615a = new byte[]{0, 0, 0, 1};
        f32616b = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
        f32617c = new Object();
        f32618d = new int[10];
    }

    public static void a(boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, zArr) == null) {
            zArr[0] = false;
            zArr[1] = false;
            zArr[2] = false;
        }
    }

    public static void b(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65538, null, byteBuffer) != null) {
            return;
        }
        int position = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 < position) {
                int i5 = byteBuffer.get(i2) & 255;
                if (i3 == 3) {
                    if (i5 == 1 && (byteBuffer.get(i4) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i2 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (i5 == 0) {
                    i3++;
                }
                if (i5 != 0) {
                    i3 = 0;
                }
                i2 = i4;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x009b, code lost:
        r8 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(byte[] bArr, int i2, int i3, boolean[] zArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), zArr})) == null) {
            int i4 = i3 - i2;
            b.i.b.a.i0.a.f(i4 >= 0);
            if (i4 == 0) {
                return i3;
            }
            if (zArr != null) {
                if (zArr[0]) {
                    a(zArr);
                    return i2 - 3;
                } else if (i4 > 1 && zArr[1] && bArr[i2] == 1) {
                    a(zArr);
                    return i2 - 2;
                } else if (i4 > 2 && zArr[2] && bArr[i2] == 0 && bArr[i2 + 1] == 1) {
                    a(zArr);
                    return i2 - 1;
                }
            }
            int i5 = i3 - 1;
            int i6 = i2 + 2;
            while (i6 < i5) {
                if ((bArr[i6] & 254) == 0) {
                    int i7 = i6 - 2;
                    if (bArr[i7] == 0 && bArr[i6 - 1] == 0 && bArr[i6] == 1) {
                        if (zArr != null) {
                            a(zArr);
                        }
                        return i7;
                    }
                    i6 -= 2;
                }
                i6 += 3;
            }
            if (zArr != null) {
                boolean z = i4 > 2 ? false : false;
                zArr[0] = z;
                zArr[1] = i4 <= 1 ? zArr[2] && bArr[i5] == 0 : bArr[i3 + (-2)] == 0 && bArr[i5] == 0;
                zArr[2] = bArr[i5] == 0;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static int d(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3)) == null) {
            while (i2 < i3 - 2) {
                if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 3) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeLII.intValue;
    }

    public static int e(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, bArr, i2)) == null) ? (bArr[i2 + 3] & 126) >> 1 : invokeLI.intValue;
    }

    public static int f(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, bArr, i2)) == null) ? bArr[i2 + 3] & 31 : invokeLI.intValue;
    }

    public static boolean g(String str, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, Byte.valueOf(b2)})) == null) {
            if ("video/avc".equals(str) && (b2 & 31) == 6) {
                return true;
            }
            return "video/hevc".equals(str) && ((b2 & 126) >> 1) == 39;
        }
        return invokeCommon.booleanValue;
    }

    public static a h(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, bArr, i2, i3)) == null) {
            m mVar = new m(bArr, i2, i3);
            mVar.l(8);
            int h2 = mVar.h();
            int h3 = mVar.h();
            mVar.k();
            return new a(h2, h3, mVar.d());
        }
        return (a) invokeLII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b i(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        int h2;
        boolean z;
        int i4;
        int i5;
        boolean z2;
        boolean d2;
        float f2;
        int e2;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, bArr, i2, i3)) == null) {
            m mVar = new m(bArr, i2, i3);
            mVar.l(8);
            int e3 = mVar.e(8);
            mVar.l(16);
            int h3 = mVar.h();
            if (e3 == 100 || e3 == 110 || e3 == 122 || e3 == 244 || e3 == 44 || e3 == 83 || e3 == 86 || e3 == 118 || e3 == 128 || e3 == 138) {
                h2 = mVar.h();
                boolean d3 = h2 == 3 ? mVar.d() : false;
                mVar.h();
                mVar.h();
                mVar.k();
                if (mVar.d()) {
                    int i7 = h2 != 3 ? 8 : 12;
                    int i8 = 0;
                    while (i8 < i7) {
                        if (mVar.d()) {
                            j(mVar, i8 < 6 ? 16 : 64);
                        }
                        i8++;
                    }
                }
                z = d3;
            } else {
                h2 = 1;
                z = false;
            }
            int h4 = mVar.h() + 4;
            int h5 = mVar.h();
            if (h5 == 0) {
                i4 = h3;
                i5 = mVar.h() + 4;
            } else if (h5 == 1) {
                boolean d4 = mVar.d();
                mVar.g();
                mVar.g();
                long h6 = mVar.h();
                i4 = h3;
                for (int i9 = 0; i9 < h6; i9++) {
                    mVar.h();
                }
                z2 = d4;
                i5 = 0;
                mVar.h();
                mVar.k();
                int h7 = mVar.h() + 1;
                d2 = mVar.d();
                int h8 = (2 - (d2 ? 1 : 0)) * (mVar.h() + 1);
                if (!d2) {
                    mVar.k();
                }
                mVar.k();
                int i10 = h7 * 16;
                int i11 = h8 * 16;
                if (mVar.d()) {
                    int h9 = mVar.h();
                    int h10 = mVar.h();
                    int h11 = mVar.h();
                    int h12 = mVar.h();
                    if (h2 == 0) {
                        i6 = 2 - (d2 ? 1 : 0);
                    } else {
                        int i12 = h2 == 3 ? 1 : 2;
                        i6 = (2 - (d2 ? 1 : 0)) * (h2 == 1 ? 2 : 1);
                        r7 = i12;
                    }
                    i10 -= (h9 + h10) * r7;
                    i11 -= (h11 + h12) * i6;
                }
                int i13 = i11;
                int i14 = i10;
                float f3 = 1.0f;
                if (mVar.d() && mVar.d()) {
                    e2 = mVar.e(8);
                    if (e2 != 255) {
                        int e4 = mVar.e(16);
                        int e5 = mVar.e(16);
                        if (e4 != 0 && e5 != 0) {
                            f3 = e4 / e5;
                        }
                        f2 = f3;
                    } else {
                        float[] fArr = f32616b;
                        if (e2 < fArr.length) {
                            f2 = fArr[e2];
                        } else {
                            String str = "Unexpected aspect_ratio_idc value: " + e2;
                        }
                    }
                    return new b(i4, i14, i13, f2, z, d2, h4, h5, i5, z2);
                }
                f2 = 1.0f;
                return new b(i4, i14, i13, f2, z, d2, h4, h5, i5, z2);
            } else {
                i4 = h3;
                i5 = 0;
            }
            z2 = false;
            mVar.h();
            mVar.k();
            int h72 = mVar.h() + 1;
            d2 = mVar.d();
            int h82 = (2 - (d2 ? 1 : 0)) * (mVar.h() + 1);
            if (!d2) {
            }
            mVar.k();
            int i102 = h72 * 16;
            int i112 = h82 * 16;
            if (mVar.d()) {
            }
            int i132 = i112;
            int i142 = i102;
            float f32 = 1.0f;
            if (mVar.d()) {
                e2 = mVar.e(8);
                if (e2 != 255) {
                }
                return new b(i4, i142, i132, f2, z, d2, h4, h5, i5, z2);
            }
            f2 = 1.0f;
            return new b(i4, i142, i132, f2, z, d2, h4, h5, i5, z2);
        }
        return (b) invokeLII.objValue;
    }

    public static void j(m mVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, mVar, i2) == null) {
            int i3 = 8;
            int i4 = 8;
            for (int i5 = 0; i5 < i2; i5++) {
                if (i3 != 0) {
                    i3 = ((mVar.g() + i4) + 256) % 256;
                }
                if (i3 != 0) {
                    i4 = i3;
                }
            }
        }
    }

    public static int k(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, bArr, i2)) == null) {
            synchronized (f32617c) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < i2) {
                    try {
                        i4 = d(bArr, i4, i2);
                        if (i4 < i2) {
                            if (f32618d.length <= i5) {
                                f32618d = Arrays.copyOf(f32618d, f32618d.length * 2);
                            }
                            f32618d[i5] = i4;
                            i4 += 3;
                            i5++;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                i3 = i2 - i5;
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < i5; i8++) {
                    int i9 = f32618d[i8] - i7;
                    System.arraycopy(bArr, i7, bArr, i6, i9);
                    int i10 = i6 + i9;
                    int i11 = i10 + 1;
                    bArr[i10] = 0;
                    i6 = i11 + 1;
                    bArr[i11] = 0;
                    i7 += i9 + 3;
                }
                System.arraycopy(bArr, i7, bArr, i6, i3 - i6);
            }
            return i3;
        }
        return invokeLI.intValue;
    }
}
