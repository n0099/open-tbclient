package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object[] a;

    /* renamed from: b  reason: collision with root package name */
    public int f28262b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f28263c;

    /* renamed from: d  reason: collision with root package name */
    public int f28264d;

    /* renamed from: e  reason: collision with root package name */
    public int f28265e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f28266f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f28267g;

    public g() {
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
        this.f28262b = 7;
        this.f28265e = 0;
        this.f28263c = new Object[256];
        this.f28266f = new int[40];
        this.f28267g = new int[40];
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:21:0x003f -> B:5:0x0006 */
    public static void a(Object[] objArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65537, null, objArr, i2, i3, i4) == null) {
            if (i4 == i2) {
                i4++;
            }
            while (i4 < i3) {
                Comparable comparable = (Comparable) objArr[i4];
                int i5 = i2;
                int i6 = i4;
                while (i5 < i6) {
                    int i7 = (i5 + i6) >>> 1;
                    if (comparable.compareTo(objArr[i7]) < 0) {
                        i6 = i7;
                    } else {
                        i5 = i7 + 1;
                    }
                }
                int i8 = i4 - i5;
                if (i8 != 1) {
                    if (i8 != 2) {
                        System.arraycopy(objArr, i5, objArr, i5 + 1, i8);
                        objArr[i5] = comparable;
                        i4++;
                    } else {
                        objArr[i5 + 2] = objArr[i5 + 1];
                    }
                }
                objArr[i5 + 1] = objArr[i5];
                objArr[i5] = comparable;
                i4++;
            }
        }
    }

    public static int b(Object[] objArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, objArr, i2, i3)) == null) {
            int i4 = i2 + 1;
            if (i4 == i3) {
                return 1;
            }
            int i5 = i4 + 1;
            if (((Comparable) objArr[i4]).compareTo(objArr[i2]) < 0) {
                while (i5 < i3 && ((Comparable) objArr[i5]).compareTo(objArr[i5 - 1]) < 0) {
                    i5++;
                }
                o(objArr, i2, i5);
            } else {
                while (i5 < i3 && ((Comparable) objArr[i5]).compareTo(objArr[i5 - 1]) >= 0) {
                    i5++;
                }
            }
            return i5 - i2;
        }
        return invokeLII.intValue;
    }

    public static int e(Comparable<Object> comparable, Object[] objArr, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{comparable, objArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int i7 = i2 + i4;
            if (comparable.compareTo(objArr[i7]) > 0) {
                int i8 = i3 - i4;
                int i9 = 0;
                int i10 = 1;
                while (i10 < i8 && comparable.compareTo(objArr[i7 + i10]) > 0) {
                    int i11 = (i10 << 1) + 1;
                    if (i11 <= 0) {
                        i9 = i10;
                        i10 = i8;
                    } else {
                        int i12 = i10;
                        i10 = i11;
                        i9 = i12;
                    }
                }
                if (i10 <= i8) {
                    i8 = i10;
                }
                i5 = i9 + i4;
                i6 = i8 + i4;
            } else {
                int i13 = i4 + 1;
                int i14 = 0;
                int i15 = 1;
                while (i15 < i13 && comparable.compareTo(objArr[i7 - i15]) <= 0) {
                    int i16 = (i15 << 1) + 1;
                    if (i16 <= 0) {
                        i14 = i15;
                        i15 = i13;
                    } else {
                        int i17 = i15;
                        i15 = i16;
                        i14 = i17;
                    }
                }
                if (i15 <= i13) {
                    i13 = i15;
                }
                int i18 = i4 - i13;
                int i19 = i4 - i14;
                i5 = i18;
                i6 = i19;
            }
            int i20 = i5 + 1;
            while (i20 < i6) {
                int i21 = ((i6 - i20) >>> 1) + i20;
                if (comparable.compareTo(objArr[i2 + i21]) > 0) {
                    i20 = i21 + 1;
                } else {
                    i6 = i21;
                }
            }
            return i6;
        }
        return invokeCommon.intValue;
    }

    public static int f(Comparable<Object> comparable, Object[] objArr, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{comparable, objArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int i7 = i2 + i4;
            if (comparable.compareTo(objArr[i7]) < 0) {
                int i8 = i4 + 1;
                int i9 = 0;
                int i10 = 1;
                while (i10 < i8 && comparable.compareTo(objArr[i7 - i10]) < 0) {
                    int i11 = (i10 << 1) + 1;
                    if (i11 <= 0) {
                        i9 = i10;
                        i10 = i8;
                    } else {
                        int i12 = i10;
                        i10 = i11;
                        i9 = i12;
                    }
                }
                if (i10 <= i8) {
                    i8 = i10;
                }
                i6 = i4 - i8;
                i5 = i4 - i9;
            } else {
                int i13 = i3 - i4;
                int i14 = 0;
                int i15 = 1;
                while (i15 < i13 && comparable.compareTo(objArr[i7 + i15]) >= 0) {
                    int i16 = (i15 << 1) + 1;
                    if (i16 <= 0) {
                        i14 = i15;
                        i15 = i13;
                    } else {
                        int i17 = i15;
                        i15 = i16;
                        i14 = i17;
                    }
                }
                if (i15 <= i13) {
                    i13 = i15;
                }
                int i18 = i14 + i4;
                i5 = i4 + i13;
                i6 = i18;
            }
            int i19 = i6 + 1;
            while (i19 < i5) {
                int i20 = ((i5 - i19) >>> 1) + i19;
                if (comparable.compareTo(objArr[i2 + i20]) < 0) {
                    i5 = i20;
                } else {
                    i19 = i20 + 1;
                }
            }
            return i5;
        }
        return invokeCommon.intValue;
    }

    public static int l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) {
            int i3 = 0;
            while (i2 >= 32) {
                i3 |= i2 & 1;
                i2 >>= 1;
            }
            return i2 + i3;
        }
        return invokeI.intValue;
    }

    public static void n(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65542, null, i2, i3, i4) == null) {
            if (i3 <= i4) {
                if (i3 < 0) {
                    throw new ArrayIndexOutOfBoundsException(i3);
                }
                if (i4 > i2) {
                    throw new ArrayIndexOutOfBoundsException(i4);
                }
                return;
            }
            throw new IllegalArgumentException("fromIndex(" + i3 + ") > toIndex(" + i4 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public static void o(Object[] objArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65543, null, objArr, i2, i3) == null) {
            int i4 = i3 - 1;
            while (i2 < i4) {
                Object obj = objArr[i2];
                objArr[i2] = objArr[i4];
                objArr[i4] = obj;
                i4--;
                i2++;
            }
        }
    }

    public void c(Object[] objArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, objArr, i2, i3) == null) {
            this.f28265e = 0;
            n(objArr.length, i2, i3);
            int i4 = i3 - i2;
            if (i4 < 2) {
                return;
            }
            if (i4 < 32) {
                a(objArr, i2, i3, b(objArr, i2, i3) + i2);
                return;
            }
            this.a = objArr;
            this.f28264d = 0;
            int l = l(i4);
            do {
                int b2 = b(objArr, i2, i3);
                if (b2 < l) {
                    int i5 = i4 <= l ? i4 : l;
                    a(objArr, i2, i2 + i5, b2 + i2);
                    b2 = i5;
                }
                m(i2, b2);
                h();
                i2 += b2;
                i4 -= b2;
            } while (i4 != 0);
            i();
            this.a = null;
            Object[] objArr2 = this.f28263c;
            int i6 = this.f28264d;
            for (int i7 = 0; i7 < i6; i7++) {
                objArr2[i7] = null;
            }
        }
    }

    public final Object[] d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.f28264d = Math.max(this.f28264d, i2);
            if (this.f28263c.length < i2) {
                int i3 = (i2 >> 1) | i2;
                int i4 = i3 | (i3 >> 2);
                int i5 = i4 | (i4 >> 4);
                int i6 = i5 | (i5 >> 8);
                int i7 = (i6 | (i6 >> 16)) + 1;
                if (i7 >= 0) {
                    i2 = Math.min(i7, this.a.length >>> 1);
                }
                this.f28263c = new Object[i2];
            }
            return this.f28263c;
        }
        return (Object[]) invokeI.objValue;
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            int[] iArr = this.f28266f;
            int i3 = iArr[i2];
            int[] iArr2 = this.f28267g;
            int i4 = iArr2[i2];
            int i5 = i2 + 1;
            int i6 = iArr[i5];
            int i7 = iArr2[i5];
            iArr2[i2] = i4 + i7;
            if (i2 == this.f28265e - 3) {
                int i8 = i2 + 2;
                iArr[i5] = iArr[i8];
                iArr2[i5] = iArr2[i8];
            }
            this.f28265e--;
            Object[] objArr = this.a;
            int f2 = f((Comparable) objArr[i6], objArr, i3, i4, 0);
            int i9 = i3 + f2;
            int i10 = i4 - f2;
            if (i10 == 0) {
                return;
            }
            Object[] objArr2 = this.a;
            int e2 = e((Comparable) objArr2[(i9 + i10) - 1], objArr2, i6, i7, i7 - 1);
            if (e2 == 0) {
                return;
            }
            if (i10 <= e2) {
                k(i9, i10, i6, e2);
            } else {
                j(i9, i10, i6, e2);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
            return;
        }
        while (true) {
            int i2 = this.f28265e;
            if (i2 <= 1) {
                return;
            }
            int i3 = i2 - 2;
            if (i3 > 0) {
                int[] iArr = this.f28267g;
                int i4 = i3 - 1;
                int i5 = i3 + 1;
                if (iArr[i4] <= iArr[i3] + iArr[i5]) {
                    if (iArr[i4] < iArr[i5]) {
                        i3--;
                    }
                    g(i3);
                }
            }
            int[] iArr2 = this.f28267g;
            if (iArr2[i3] > iArr2[i3 + 1]) {
                return;
            }
            g(i3);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048580, this) != null) {
            return;
        }
        while (true) {
            int i2 = this.f28265e;
            if (i2 <= 1) {
                return;
            }
            int i3 = i2 - 2;
            if (i3 > 0) {
                int[] iArr = this.f28267g;
                if (iArr[i3 - 1] < iArr[i3 + 1]) {
                    i3--;
                }
            }
            g(i3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
        r3 = r8;
        r5 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
        r3 = r13 - f((java.lang.Comparable) r1[r5], r0, r12, r13, r13 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
        if (r3 == 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0080, code lost:
        r6 = r6 - r3;
        r7 = r7 - r3;
        r13 = r13 - r3;
        java.lang.System.arraycopy(r0, r7 + 1, r0, r6 + 1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008a, code lost:
        if (r13 != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008c, code lost:
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
        r8 = r6 - 1;
        r9 = r5 - 1;
        r0[r6] = r1[r5];
        r15 = r15 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0098, code lost:
        if (r15 != 1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009b, code lost:
        r5 = r15 - e((java.lang.Comparable) r0[r7], r1, 0, r15, r15 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a7, code lost:
        if (r5 == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a9, code lost:
        r6 = r8 - r5;
        r8 = r9 - r5;
        r15 = r15 - r5;
        java.lang.System.arraycopy(r1, r8 + 1, r0, r6 + 1, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b5, code lost:
        if (r15 > 1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b7, code lost:
        r3 = r6;
        r5 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ba, code lost:
        r6 = r8;
        r8 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bc, code lost:
        r9 = r6 - 1;
        r10 = r7 - 1;
        r0[r6] = r0[r7];
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c6, code lost:
        if (r13 != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c8, code lost:
        r5 = r8;
        r3 = r9;
        r7 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f0, code lost:
        r14 = r14 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f3, code lost:
        if (r3 < 7) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f5, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f7, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f8, code lost:
        if (r5 < 7) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fa, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00fc, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fe, code lost:
        if ((r3 | r5) != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0100, code lost:
        if (r14 >= 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0102, code lost:
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x010a, code lost:
        r5 = r8;
        r6 = r9;
        r7 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            Object[] objArr = this.a;
            Object[] d2 = d(i5);
            System.arraycopy(objArr, i4, d2, 0, i5);
            int i10 = (i2 + i3) - 1;
            int i11 = i5 - 1;
            int i12 = (i4 + i5) - 1;
            int i13 = i12 - 1;
            int i14 = i10 - 1;
            objArr[i12] = objArr[i10];
            int i15 = i3 - 1;
            if (i15 == 0) {
                System.arraycopy(d2, 0, objArr, i13 - i11, i5);
            } else if (i5 == 1) {
                int i16 = i13 - i15;
                System.arraycopy(objArr, (i14 - i15) + 1, objArr, i16 + 1, i15);
                objArr[i16] = d2[i11];
            } else {
                int i17 = this.f28262b;
                loop0: while (true) {
                    int i18 = 0;
                    int i19 = 0;
                    while (true) {
                        if (((Comparable) d2[i11]).compareTo(objArr[i14]) < 0) {
                            i6 = i13 - 1;
                            int i20 = i14 - 1;
                            objArr[i13] = objArr[i14];
                            i19++;
                            i15--;
                            if (i15 == 0) {
                                i14 = i20;
                                break loop0;
                            }
                            i13 = i6;
                            i14 = i20;
                            i18 = 0;
                        } else {
                            int i21 = i13 - 1;
                            int i22 = i11 - 1;
                            objArr[i13] = d2[i11];
                            i18++;
                            i5--;
                            if (i5 == 1) {
                                break loop0;
                            }
                            i13 = i21;
                            i11 = i22;
                            i19 = 0;
                        }
                        if ((i19 | i18) >= i17) {
                            break;
                        }
                    }
                    i17 += 2;
                    i11 = i7;
                    i13 = i8;
                    i14 = i9;
                }
                if (i17 < 1) {
                    i17 = 1;
                }
                this.f28262b = i17;
                if (i5 == 1) {
                    int i23 = i6 - i15;
                    System.arraycopy(objArr, (i14 - i15) + 1, objArr, i23 + 1, i15);
                    objArr[i23] = d2[i11];
                } else if (i5 != 0) {
                    System.arraycopy(d2, 0, objArr, i6 - (i5 - 1), i5);
                } else {
                    throw new IllegalArgumentException("Comparison method violates its general contract!");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        r6 = f((java.lang.Comparable) r0[r4], r1, r5, r13, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
        if (r6 == 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
        java.lang.System.arraycopy(r1, r5, r0, r3, r6);
        r3 = r3 + r6;
        r5 = r5 + r6;
        r13 = r13 - r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
        if (r13 > 1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
        r7 = r3 + 1;
        r8 = r4 + 1;
        r0[r3] = r0[r4];
        r15 = r15 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
        if (r15 != 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
        r3 = e((java.lang.Comparable) r1[r5], r0, r8, r15, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
        if (r3 == 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0092, code lost:
        java.lang.System.arraycopy(r0, r8, r0, r7, r3);
        r4 = r7 + r3;
        r7 = r8 + r3;
        r15 = r15 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009a, code lost:
        if (r15 != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009c, code lost:
        r6 = r4;
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009f, code lost:
        r7 = r4;
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a3, code lost:
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
        r8 = r7 + 1;
        r9 = r5 + 1;
        r0[r7] = r1[r5];
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ae, code lost:
        if (r13 != 1) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b0, code lost:
        r6 = r8;
        r5 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d0, code lost:
        r14 = r14 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d3, code lost:
        if (r6 < 7) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d5, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d7, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d8, code lost:
        if (r3 < 7) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00da, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00dc, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00de, code lost:
        if ((r3 | r6) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e0, code lost:
        if (r14 >= 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e2, code lost:
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e9, code lost:
        r3 = r8;
        r5 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            Object[] objArr = this.a;
            Object[] d2 = d(i3);
            System.arraycopy(objArr, i2, d2, 0, i3);
            int i9 = i2 + 1;
            int i10 = i4 + 1;
            objArr[i2] = objArr[i4];
            int i11 = i5 - 1;
            if (i11 == 0) {
                System.arraycopy(d2, 0, objArr, i9, i3);
            } else if (i3 == 1) {
                System.arraycopy(objArr, i10, objArr, i9, i11);
                objArr[i9 + i11] = d2[0];
            } else {
                int i12 = this.f28262b;
                int i13 = 0;
                loop0: while (true) {
                    int i14 = 0;
                    int i15 = 0;
                    while (true) {
                        if (((Comparable) objArr[i10]).compareTo(d2[i13]) < 0) {
                            i6 = i9 + 1;
                            int i16 = i10 + 1;
                            objArr[i9] = objArr[i10];
                            i15++;
                            i11--;
                            if (i11 == 0) {
                                break loop0;
                            }
                            i9 = i6;
                            i10 = i16;
                            i14 = 0;
                        } else {
                            int i17 = i9 + 1;
                            int i18 = i13 + 1;
                            objArr[i9] = d2[i13];
                            i14++;
                            i3--;
                            if (i3 == 1) {
                                i6 = i17;
                                i13 = i18;
                                break loop0;
                            }
                            i9 = i17;
                            i13 = i18;
                            i15 = 0;
                        }
                        if ((i14 | i15) >= i12) {
                            break;
                        }
                    }
                    i12 += 2;
                    i9 = i7;
                    i13 = i8;
                }
                if (i12 < 1) {
                    i12 = 1;
                }
                this.f28262b = i12;
                if (i3 == 1) {
                    System.arraycopy(objArr, i10, objArr, i6, i11);
                    objArr[i6 + i11] = d2[i13];
                } else if (i3 != 0) {
                    System.arraycopy(d2, i13, objArr, i6, i3);
                } else {
                    throw new IllegalArgumentException("Comparison method violates its general contract!");
                }
            }
        }
    }

    public final void m(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            int[] iArr = this.f28266f;
            int i4 = this.f28265e;
            iArr[i4] = i2;
            this.f28267g[i4] = i3;
            this.f28265e = i4 + 1;
        }
    }
}
