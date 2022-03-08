package c.a.q.f.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f11613b;

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
    }

    /* renamed from: c.a.q.f.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0798b extends a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final int[] f11614f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public int f11615c;

        /* renamed from: d  reason: collision with root package name */
        public int f11616d;

        /* renamed from: e  reason: collision with root package name */
        public final int[] f11617e;

        static {
            InterceptResult invokeClinit;
            int i2;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-401800911, "Lc/a/q/f/f/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-401800911, "Lc/a/q/f/f/b$b;");
                    return;
                }
            }
            f11614f = new int[256];
            int i3 = 0;
            while (true) {
                if (i3 >= 64) {
                    break;
                }
                f11614f[i3] = i3;
                i3++;
            }
            for (i2 = 64; i2 < 256; i2++) {
                f11614f[i2] = -1;
            }
        }

        public C0798b(int i2, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = bArr;
            this.f11617e = f11614f;
            this.f11615c = 0;
            this.f11616d = 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:67:0x00ff, code lost:
            if (r5 != 4) goto L29;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                int i4 = this.f11615c;
                if (i4 == 6) {
                    return false;
                }
                int i5 = i3 + i2;
                int i6 = this.f11616d;
                byte[] bArr2 = this.a;
                int[] iArr = this.f11617e;
                int i7 = i6;
                int i8 = 0;
                int i9 = i4;
                int i10 = i2;
                while (i10 < i5) {
                    if (i9 == 0) {
                        while (true) {
                            int i11 = i10 + 4;
                            if (i11 > i5 || (i7 = (iArr[bArr[i10] & 255] << 18) | (iArr[bArr[i10 + 1] & 255] << 12) | (iArr[bArr[i10 + 2] & 255] << 6) | iArr[bArr[i10 + 3] & 255]) < 0) {
                                break;
                            }
                            bArr2[i8 + 2] = (byte) i7;
                            bArr2[i8 + 1] = (byte) (i7 >> 8);
                            bArr2[i8] = (byte) (i7 >> 16);
                            i8 += 3;
                            i10 = i11;
                        }
                        if (i10 >= i5) {
                            break;
                        }
                    }
                    int i12 = i10 + 1;
                    int i13 = iArr[bArr[i10] & 255];
                    if (i9 != 0) {
                        if (i9 == 1) {
                            if (i13 < 0) {
                                if (i13 != -1) {
                                    this.f11615c = 6;
                                    return false;
                                }
                            }
                            i13 |= i7 << 6;
                        } else if (i9 == 2) {
                            if (i13 < 0) {
                                if (i13 == -2) {
                                    bArr2[i8] = (byte) (i7 >> 4);
                                    i8++;
                                    i9 = 4;
                                } else if (i13 != -1) {
                                    break;
                                }
                            }
                            i13 |= i7 << 6;
                        } else if (i9 != 3) {
                            if (i9 != 4) {
                                if (i9 == 5 && i13 != -1) {
                                    this.f11615c = 6;
                                    return false;
                                }
                            } else if (i13 == -2) {
                                i9++;
                            } else if (i13 != -1) {
                                this.f11615c = 6;
                                return false;
                            }
                        } else if (i13 >= 0) {
                            int i14 = i13 | (i7 << 6);
                            bArr2[i8 + 2] = (byte) i14;
                            bArr2[i8 + 1] = (byte) (i14 >> 8);
                            bArr2[i8] = (byte) (i14 >> 16);
                            i8 += 3;
                            i7 = i14;
                            i9 = 0;
                        } else if (i13 == -2) {
                            bArr2[i8 + 1] = (byte) (i7 >> 2);
                            bArr2[i8] = (byte) (i7 >> 10);
                            i8 += 2;
                            i9 = 5;
                        } else if (i13 != -1) {
                            break;
                        }
                        i9++;
                        i7 = i13;
                    } else {
                        if (i13 < 0) {
                            if (i13 != -1) {
                                this.f11615c = 6;
                                return false;
                            }
                        }
                        i9++;
                        i7 = i13;
                    }
                    i10 = i12;
                }
                if (z) {
                    if (i9 != 1) {
                        if (i9 == 2) {
                            bArr2[i8] = (byte) (i7 >> 4);
                            i8++;
                        } else if (i9 == 3) {
                            int i15 = i8 + 1;
                            bArr2[i8] = (byte) (i7 >> 10);
                            i8 = i15 + 1;
                            bArr2[i15] = (byte) (i7 >> 2);
                        }
                        this.f11615c = i9;
                    }
                    this.f11615c = 6;
                    return false;
                }
                this.f11615c = i9;
                this.f11616d = i7;
                this.f11613b = i8;
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: j  reason: collision with root package name */
        public static final byte[] f11618j;
        public static final /* synthetic */ boolean k;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f11619c;

        /* renamed from: d  reason: collision with root package name */
        public int f11620d;

        /* renamed from: e  reason: collision with root package name */
        public int f11621e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f11622f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f11623g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f11624h;

        /* renamed from: i  reason: collision with root package name */
        public final byte[] f11625i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-401800880, "Lc/a/q/f/f/b$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-401800880, "Lc/a/q/f/f/b$c;");
                    return;
                }
            }
            k = !b.class.desiredAssertionStatus();
            f11618j = new byte[64];
            for (int i2 = 0; i2 < 64; i2++) {
                f11618j[i2] = (byte) i2;
            }
        }

        public c(int i2, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = bArr;
            this.f11622f = (i2 & 1) == 0;
            this.f11623g = (i2 & 2) == 0;
            this.f11624h = (i2 & 4) != 0;
            this.f11625i = f11618j;
            this.f11619c = new byte[2];
            this.f11620d = 0;
            this.f11621e = this.f11623g ? 19 : -1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00da, code lost:
            if (r17.f11624h == false) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00dc, code lost:
            r2[r6] = 13;
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00e1, code lost:
            r2[r6] = 10;
            r6 = r6 + 1;
            r11 = r10;
         */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01c2  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x01d1 A[ADDED_TO_REGION] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00e1 -> B:24:0x008e). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] bArr, int i2, int i3, boolean z) {
            InterceptResult invokeCommon;
            int i4;
            int i5;
            int i6;
            int i7;
            byte b2;
            int i8;
            byte b3;
            byte b4;
            int i9;
            int i10;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) != null) {
                return invokeCommon.booleanValue;
            }
            byte[] bArr2 = this.f11625i;
            byte[] bArr3 = this.a;
            int i11 = this.f11621e;
            int i12 = i3 + i2;
            int i13 = this.f11620d;
            int i14 = 0;
            if (i13 != 1) {
                if (i13 == 2 && (i10 = i2 + 1) <= i12) {
                    byte[] bArr4 = this.f11619c;
                    i5 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i2] & 255);
                    this.f11620d = 0;
                    i4 = i10;
                }
                i4 = i2;
                i5 = -1;
            } else {
                if (i2 + 2 <= i12) {
                    int i15 = i2 + 1;
                    i4 = i15 + 1;
                    i5 = (bArr[i15] & 255) | ((this.f11619c[0] & 255) << 16) | ((bArr[i2] & 255) << 8);
                    this.f11620d = 0;
                }
                i4 = i2;
                i5 = -1;
            }
            if (i5 != -1) {
                bArr3[0] = bArr2[(i5 >> 18) & 63];
                bArr3[1] = bArr2[(i5 >> 12) & 63];
                bArr3[2] = bArr2[(i5 >> 6) & 63];
                bArr3[3] = bArr2[i5 & 63];
                i11--;
                if (i11 == 0) {
                    if (this.f11624h) {
                        i9 = 5;
                        bArr3[4] = 13;
                    } else {
                        i9 = 4;
                    }
                    i6 = i9 + 1;
                    bArr3[i9] = 10;
                    i11 = 19;
                } else {
                    i6 = 4;
                }
            } else {
                i6 = 0;
            }
            while (true) {
                int i16 = i4 + 3;
                if (i16 > i12) {
                    if (z) {
                        int i17 = this.f11620d;
                        int i18 = i4 - i17;
                        if (i18 == i12 - 1) {
                            if (i17 > 0) {
                                b4 = this.f11619c[0];
                                i14 = 1;
                            } else {
                                byte b5 = bArr[i4];
                                i4++;
                                b4 = b5;
                            }
                            int i19 = (b4 & 255) << 4;
                            this.f11620d -= i14;
                            int i20 = i6 + 1;
                            bArr3[i6] = bArr2[(i19 >> 6) & 63];
                            i6 = i20 + 1;
                            bArr3[i20] = bArr2[i19 & 63];
                            if (this.f11622f) {
                                int i21 = i6 + 1;
                                bArr3[i6] = 61;
                                i6 = i21 + 1;
                                bArr3[i21] = 61;
                            }
                            if (this.f11623g) {
                                if (this.f11624h) {
                                    bArr3[i6] = 13;
                                    i6++;
                                }
                                i7 = i6 + 1;
                                bArr3[i6] = 10;
                                i6 = i7;
                            }
                            if (k && this.f11620d != 0) {
                                throw new AssertionError();
                            }
                            if (!k && i4 != i12) {
                                throw new AssertionError();
                            }
                        } else if (i18 == i12 - 2) {
                            if (i17 > 1) {
                                b2 = this.f11619c[0];
                                i14 = 1;
                            } else {
                                byte b6 = bArr[i4];
                                i4++;
                                b2 = b6;
                            }
                            int i22 = (b2 & 255) << 10;
                            if (this.f11620d > 0) {
                                i8 = i14 + 1;
                                b3 = this.f11619c[i14];
                            } else {
                                i8 = i14;
                                b3 = bArr[i4];
                                i4++;
                            }
                            int i23 = i22 | ((b3 & 255) << 2);
                            this.f11620d -= i8;
                            int i24 = i6 + 1;
                            bArr3[i6] = bArr2[(i23 >> 12) & 63];
                            int i25 = i24 + 1;
                            bArr3[i24] = bArr2[(i23 >> 6) & 63];
                            int i26 = i25 + 1;
                            bArr3[i25] = bArr2[i23 & 63];
                            if (this.f11622f) {
                                bArr3[i26] = 61;
                                i26++;
                            }
                            if (this.f11623g) {
                                if (this.f11624h) {
                                    bArr3[i26] = 13;
                                    i26++;
                                }
                                i7 = i26 + 1;
                                bArr3[i26] = 10;
                                i6 = i7;
                                if (k) {
                                }
                                if (!k) {
                                    throw new AssertionError();
                                }
                            } else {
                                i6 = i26;
                                if (k) {
                                }
                                if (!k) {
                                }
                            }
                        } else {
                            if (this.f11623g && i6 > 0 && i11 != 19) {
                                if (this.f11624h) {
                                    bArr3[i6] = 13;
                                    i6++;
                                }
                                i7 = i6 + 1;
                                bArr3[i6] = 10;
                                i6 = i7;
                            }
                            if (k) {
                            }
                            if (!k) {
                            }
                        }
                    } else if (i4 == i12 - 1) {
                        byte[] bArr5 = this.f11619c;
                        int i27 = this.f11620d;
                        this.f11620d = i27 + 1;
                        bArr5[i27] = bArr[i4];
                    } else if (i4 == i12 - 2) {
                        byte[] bArr6 = this.f11619c;
                        int i28 = this.f11620d;
                        int i29 = i28 + 1;
                        this.f11620d = i29;
                        bArr6[i28] = bArr[i4];
                        this.f11620d = i29 + 1;
                        bArr6[i29] = bArr[i4 + 1];
                    }
                    this.f11613b = i6;
                    this.f11621e = i11;
                    return true;
                }
                int i30 = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16) | (bArr[i4 + 2] & 255);
                bArr3[i6] = bArr2[(i30 >> 18) & 63];
                bArr3[i6 + 1] = bArr2[(i30 >> 12) & 63];
                bArr3[i6 + 2] = bArr2[(i30 >> 6) & 63];
                bArr3[i6 + 3] = bArr2[i30 & 63];
                i6 += 4;
                i11--;
                if (i11 == 0) {
                    break;
                }
                i4 = i16;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(678910767, "Lc/a/q/f/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(678910767, "Lc/a/q/f/f/b;");
                return;
            }
        }
        a = !b.class.desiredAssertionStatus();
    }

    public b() {
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

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            c cVar = new c(19, null);
            int i3 = (i2 / 3) * 4;
            if (!cVar.f11622f) {
                int i4 = i2 % 3;
                if (i4 == 1) {
                    i3 += 2;
                } else if (i4 == 2) {
                    i3 += 3;
                }
            } else if (i2 % 3 > 0) {
                i3 += 4;
            }
            if (!cVar.f11623g || i2 <= 0) {
                return i3;
            }
            return i3 + ((((i2 - 1) / 57) + 1) * (cVar.f11624h ? 2 : 1));
        }
        return invokeI.intValue;
    }

    public static byte[] b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) ? c(bArr, 0, bArr.length) : (byte[]) invokeL.objValue;
    }

    public static byte[] c(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3)) == null) {
            C0798b c0798b = new C0798b(19, new byte[(i3 * 3) / 4]);
            if (c0798b.a(bArr, i2, i3, true)) {
                int i4 = c0798b.f11613b;
                byte[] bArr2 = c0798b.a;
                if (i4 == bArr2.length) {
                    return bArr2;
                }
                byte[] bArr3 = new byte[i4];
                System.arraycopy(bArr2, 0, bArr3, 0, i4);
                return bArr3;
            }
            throw new IllegalArgumentException("bad base-64");
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) ? e(bArr, 0, bArr.length) : (byte[]) invokeL.objValue;
    }

    public static byte[] e(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, bArr, i2, i3)) == null) {
            c cVar = new c(19, null);
            int i4 = (i3 / 3) * 4;
            if (!cVar.f11622f) {
                int i5 = i3 % 3;
                if (i5 == 1) {
                    i4 += 2;
                } else if (i5 == 2) {
                    i4 += 3;
                }
            } else if (i3 % 3 > 0) {
                i4 += 4;
            }
            if (cVar.f11623g && i3 > 0) {
                i4 += (((i3 - 1) / 57) + 1) * (cVar.f11624h ? 2 : 1);
            }
            cVar.a = new byte[i4];
            cVar.a(bArr, i2, i3, true);
            if (a || cVar.f11613b == i4) {
                return cVar.a;
            }
            throw new AssertionError();
        }
        return (byte[]) invokeLII.objValue;
    }
}
