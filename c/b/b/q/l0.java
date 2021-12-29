package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes9.dex */
public class l0<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T[] a;

    /* renamed from: b  reason: collision with root package name */
    public Comparator<? super T> f28285b;

    /* renamed from: c  reason: collision with root package name */
    public int f28286c;

    /* renamed from: d  reason: collision with root package name */
    public T[] f28287d;

    /* renamed from: e  reason: collision with root package name */
    public int f28288e;

    /* renamed from: f  reason: collision with root package name */
    public int f28289f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f28290g;

    /* renamed from: h  reason: collision with root package name */
    public final int[] f28291h;

    public l0() {
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
        this.f28286c = 7;
        this.f28289f = 0;
        this.f28287d = (T[]) new Object[256];
        this.f28290g = new int[40];
        this.f28291h = new int[40];
    }

    /* JADX DEBUG: Duplicate block to fix multi-entry loop: BACK_EDGE: B:21:0x003d -> B:5:0x0006 */
    public static <T> void a(T[] tArr, int i2, int i3, int i4, Comparator<? super T> comparator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{tArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), comparator}) == null) {
            if (i4 == i2) {
                i4++;
            }
            while (i4 < i3) {
                T t = tArr[i4];
                int i5 = i2;
                int i6 = i4;
                while (i5 < i6) {
                    int i7 = (i5 + i6) >>> 1;
                    if (comparator.compare(t, tArr[i7]) < 0) {
                        i6 = i7;
                    } else {
                        i5 = i7 + 1;
                    }
                }
                int i8 = i4 - i5;
                if (i8 != 1) {
                    if (i8 != 2) {
                        System.arraycopy(tArr, i5, tArr, i5 + 1, i8);
                        tArr[i5] = t;
                        i4++;
                    } else {
                        tArr[i5 + 2] = tArr[i5 + 1];
                    }
                }
                tArr[i5 + 1] = tArr[i5];
                tArr[i5] = t;
                i4++;
            }
        }
    }

    public static <T> int b(T[] tArr, int i2, int i3, Comparator<? super T> comparator) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{tArr, Integer.valueOf(i2), Integer.valueOf(i3), comparator})) == null) {
            int i4 = i2 + 1;
            if (i4 == i3) {
                return 1;
            }
            int i5 = i4 + 1;
            if (comparator.compare(tArr[i4], tArr[i2]) < 0) {
                while (i5 < i3 && comparator.compare(tArr[i5], tArr[i5 - 1]) < 0) {
                    i5++;
                }
                o(tArr, i2, i5);
            } else {
                while (i5 < i3 && comparator.compare(tArr[i5], tArr[i5 - 1]) >= 0) {
                    i5++;
                }
            }
            return i5 - i2;
        }
        return invokeCommon.intValue;
    }

    public static <T> int e(T t, T[] tArr, int i2, int i3, int i4, Comparator<? super T> comparator) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{t, tArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), comparator})) == null) {
            int i7 = i2 + i4;
            if (comparator.compare(t, tArr[i7]) > 0) {
                int i8 = i3 - i4;
                int i9 = 0;
                int i10 = 1;
                while (i10 < i8 && comparator.compare(t, tArr[i7 + i10]) > 0) {
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
                while (i15 < i13 && comparator.compare(t, tArr[i7 - i15]) <= 0) {
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
                if (comparator.compare(t, tArr[i2 + i21]) > 0) {
                    i20 = i21 + 1;
                } else {
                    i6 = i21;
                }
            }
            return i6;
        }
        return invokeCommon.intValue;
    }

    public static <T> int f(T t, T[] tArr, int i2, int i3, int i4, Comparator<? super T> comparator) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{t, tArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), comparator})) == null) {
            int i7 = i2 + i4;
            if (comparator.compare(t, tArr[i7]) < 0) {
                int i8 = i4 + 1;
                int i9 = 0;
                int i10 = 1;
                while (i10 < i8 && comparator.compare(t, tArr[i7 - i10]) < 0) {
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
                while (i15 < i13 && comparator.compare(t, tArr[i7 + i15]) >= 0) {
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
                if (comparator.compare(t, tArr[i2 + i20]) < 0) {
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

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Comparator<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void c(T[] tArr, Comparator<T> comparator, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048576, this, tArr, comparator, i2, i3) == null) {
            this.f28289f = 0;
            n(tArr.length, i2, i3);
            int i4 = i3 - i2;
            if (i4 < 2) {
                return;
            }
            if (i4 < 32) {
                a(tArr, i2, i3, b(tArr, i2, i3, comparator) + i2, comparator);
                return;
            }
            this.a = tArr;
            this.f28285b = comparator;
            this.f28288e = 0;
            int l = l(i4);
            do {
                int b2 = b(tArr, i2, i3, comparator);
                if (b2 < l) {
                    int i5 = i4 <= l ? i4 : l;
                    a(tArr, i2, i2 + i5, b2 + i2, comparator);
                    b2 = i5;
                }
                m(i2, b2);
                h();
                i2 += b2;
                i4 -= b2;
            } while (i4 != 0);
            i();
            this.a = null;
            this.f28285b = null;
            T[] tArr2 = this.f28287d;
            int i6 = this.f28288e;
            for (int i7 = 0; i7 < i6; i7++) {
                tArr2[i7] = null;
            }
        }
    }

    public final T[] d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.f28288e = Math.max(this.f28288e, i2);
            if (this.f28287d.length < i2) {
                int i3 = (i2 >> 1) | i2;
                int i4 = i3 | (i3 >> 2);
                int i5 = i4 | (i4 >> 4);
                int i6 = i5 | (i5 >> 8);
                int i7 = (i6 | (i6 >> 16)) + 1;
                if (i7 >= 0) {
                    i2 = Math.min(i7, this.a.length >>> 1);
                }
                this.f28287d = (T[]) new Object[i2];
            }
            return this.f28287d;
        }
        return (T[]) ((Object[]) invokeI.objValue);
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            int[] iArr = this.f28290g;
            int i3 = iArr[i2];
            int[] iArr2 = this.f28291h;
            int i4 = iArr2[i2];
            int i5 = i2 + 1;
            int i6 = iArr[i5];
            int i7 = iArr2[i5];
            iArr2[i2] = i4 + i7;
            if (i2 == this.f28289f - 3) {
                int i8 = i2 + 2;
                iArr[i5] = iArr[i8];
                iArr2[i5] = iArr2[i8];
            }
            this.f28289f--;
            T[] tArr = this.a;
            int f2 = f(tArr[i6], tArr, i3, i4, 0, this.f28285b);
            int i9 = i3 + f2;
            int i10 = i4 - f2;
            if (i10 == 0) {
                return;
            }
            T[] tArr2 = this.a;
            int e2 = e(tArr2[(i9 + i10) - 1], tArr2, i6, i7, i7 - 1, this.f28285b);
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r1[r0 - 2] <= (r1[r0] + r1[r0 - 1])) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
        r1 = r5.f28291h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r1[r0 - 1] >= r1[r0 + 1]) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r1[r0 - 1] > (r1[r0] + r1[r0 + 1])) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
            return;
        }
        while (true) {
            int i2 = this.f28289f;
            if (i2 <= 1) {
                return;
            }
            int i3 = i2 - 2;
            if (i3 >= 1) {
                int[] iArr = this.f28291h;
            }
            if (i3 >= 2) {
                int[] iArr2 = this.f28291h;
            }
            int[] iArr3 = this.f28291h;
            if (iArr3[i3] > iArr3[i3 + 1]) {
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
            int i2 = this.f28289f;
            if (i2 <= 1) {
                return;
            }
            int i3 = i2 - 2;
            if (i3 > 0) {
                int[] iArr = this.f28291h;
                if (iArr[i3 - 1] < iArr[i3 + 1]) {
                    i3--;
                }
            }
            g(i3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
        r12 = r1;
        r13 = r2;
        r14 = r3;
        r15 = r4;
        r16 = r5;
        r17 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
        r6 = r12 - f(r8[r15], r7, r21, r12, r12 - 1, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008f, code lost:
        if (r6 == 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0091, code lost:
        r1 = r16 - r6;
        r2 = r17 - r6;
        r3 = r12 - r6;
        java.lang.System.arraycopy(r7, r2 + 1, r7, r1 + 1, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
        if (r3 != 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a0, code lost:
        r12 = r1;
        r6 = r2;
        r1 = r3;
        r2 = r13;
        r3 = r14;
        r4 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
        r16 = r1;
        r17 = r2;
        r12 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
        r18 = r16 - 1;
        r19 = r15 - 1;
        r7[r16] = r8[r15];
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b7, code lost:
        if (r13 != 1) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
        r1 = r12;
        r2 = r13;
        r3 = r14;
        r6 = r17;
        r12 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c3, code lost:
        r1 = r13 - e(r7[r17], r8, 0, r13, r13 - 1, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d2, code lost:
        if (r1 == 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d4, code lost:
        r2 = r18 - r1;
        r4 = r19 - r1;
        r3 = r13 - r1;
        java.lang.System.arraycopy(r8, r4 + 1, r7, r2 + 1, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e1, code lost:
        if (r3 > 1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e3, code lost:
        r1 = r12;
        r6 = r17;
        r12 = r2;
        r2 = r3;
        r3 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ea, code lost:
        r18 = r2;
        r13 = r3;
        r19 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ef, code lost:
        r16 = r18 - 1;
        r2 = r17 - 1;
        r7[r18] = r7[r17];
        r12 = r12 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f9, code lost:
        if (r12 != 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fb, code lost:
        r6 = r2;
        r1 = r12;
        r2 = r13;
        r3 = r14;
        r12 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0127, code lost:
        r14 = r14 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012a, code lost:
        if (r6 < 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x012c, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x012e, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x012f, code lost:
        if (r1 < 7) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0131, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0133, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0135, code lost:
        if ((r1 | r4) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0137, code lost:
        if (r14 >= 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0139, code lost:
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0145, code lost:
        r17 = r2;
        r15 = r19;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0078 A[EDGE_INSN: B:79:0x0078->B:25:0x0078 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            int i13 = i5;
            T[] tArr = this.a;
            T[] d2 = d(i13);
            System.arraycopy(tArr, i4, d2, 0, i13);
            int i14 = (i2 + i3) - 1;
            int i15 = i13 - 1;
            int i16 = (i4 + i13) - 1;
            int i17 = i16 - 1;
            int i18 = i14 - 1;
            tArr[i16] = tArr[i14];
            int i19 = i3 - 1;
            if (i19 == 0) {
                System.arraycopy(d2, 0, tArr, i17 - i15, i13);
            } else if (i13 == 1) {
                int i20 = i17 - i19;
                System.arraycopy(tArr, (i18 - i19) + 1, tArr, i20 + 1, i19);
                tArr[i20] = d2[i15];
            } else {
                Comparator<? super T> comparator = this.f28285b;
                int i21 = this.f28286c;
                loop0: while (true) {
                    int i22 = 0;
                    int i23 = 0;
                    while (true) {
                        if (comparator.compare(d2[i15], tArr[i18]) < 0) {
                            i6 = i17 - 1;
                            int i24 = i18 - 1;
                            tArr[i17] = tArr[i18];
                            i23++;
                            i19--;
                            if (i19 != 0) {
                                i17 = i6;
                                i18 = i24;
                                i22 = 0;
                                if ((i23 | i22) >= i21) {
                                    break;
                                }
                            } else {
                                i18 = i24;
                                break loop0;
                            }
                        } else {
                            int i25 = i17 - 1;
                            int i26 = i15 - 1;
                            tArr[i17] = d2[i15];
                            i22++;
                            i13--;
                            if (i13 == 1) {
                                i6 = i25;
                                i15 = i26;
                                break loop0;
                            }
                            i17 = i25;
                            i15 = i26;
                            i23 = 0;
                            if ((i23 | i22) >= i21) {
                            }
                        }
                    }
                    i21 = i9 + 2;
                    i18 = i12;
                    i19 = i7;
                    i13 = i8;
                    i17 = i10;
                    i15 = i11;
                }
                i15 = i11;
                if (i21 < 1) {
                    i21 = 1;
                }
                this.f28286c = i21;
                if (i13 == 1) {
                    int i27 = i6 - i19;
                    System.arraycopy(tArr, (i18 - i19) + 1, tArr, i27 + 1, i19);
                    tArr[i27] = d2[i15];
                } else if (i13 != 0) {
                    System.arraycopy(d2, 0, tArr, i6 - (i13 - 1), i13);
                } else {
                    throw new IllegalArgumentException("Comparison method violates its general contract!");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
        r12 = r1;
        r13 = r2;
        r14 = r3;
        r15 = r4;
        r16 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
        r9 = r6;
        r6 = f(r7[r15], r8, r6, r13, 0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
        if (r6 == 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0081, code lost:
        java.lang.System.arraycopy(r8, r9, r7, r14, r6);
        r1 = r14 + r6;
        r2 = r9 + r6;
        r3 = r13 - r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
        if (r3 > r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
        r6 = r2;
        r2 = r3;
        r4 = r15;
        r5 = r16;
        r9 = 1;
        r17 = r12;
        r12 = r1;
        r1 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
        r14 = r1;
        r9 = r2;
        r13 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
        r5 = r14 + 1;
        r4 = r15 + 1;
        r7[r14] = r7[r15];
        r12 = r12 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a6, code lost:
        if (r12 != 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a8, code lost:
        r6 = r9;
        r1 = r12;
        r2 = r13;
        r9 = 1;
        r12 = r5;
        r5 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b0, code lost:
        r15 = r4;
        r1 = e(r8[r9], r7, r4, r12, 0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bf, code lost:
        if (r1 == 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c1, code lost:
        java.lang.System.arraycopy(r7, r15, r7, r5, r1);
        r2 = r5 + r1;
        r4 = r15 + r1;
        r3 = r12 - r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ca, code lost:
        if (r3 != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cc, code lost:
        r12 = r2;
        r1 = r3;
        r6 = r9;
        r2 = r13;
        r5 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d3, code lost:
        r5 = r2;
        r12 = r3;
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d7, code lost:
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d8, code lost:
        r2 = r5 + 1;
        r6 = r9 + 1;
        r7[r5] = r8[r9];
        r13 = r13 - 1;
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
        if (r13 != 1) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e5, code lost:
        r1 = r12;
        r4 = r15;
        r5 = r16;
        r12 = r2;
        r2 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0109, code lost:
        r16 = r16 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x010c, code lost:
        if (r6 < 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010e, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0110, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0111, code lost:
        if (r1 < 7) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0113, code lost:
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0115, code lost:
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0117, code lost:
        if ((r1 | r4) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0119, code lost:
        if (r16 >= 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011b, code lost:
        r16 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0127, code lost:
        r14 = r2;
        r10 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012c A[LOOP:1: B:14:0x0037->B:70:0x012c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x006d A[EDGE_INSN: B:82:0x006d->B:27:0x006d ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            int i13 = i3;
            T[] tArr = this.a;
            T[] d2 = d(i13);
            System.arraycopy(tArr, i2, d2, 0, i13);
            int i14 = i2 + 1;
            int i15 = i4 + 1;
            tArr[i2] = tArr[i4];
            int i16 = i5 - 1;
            if (i16 == 0) {
                System.arraycopy(d2, 0, tArr, i14, i13);
                return;
            }
            int i17 = 1;
            if (i13 == 1) {
                System.arraycopy(tArr, i15, tArr, i14, i16);
                tArr[i14 + i16] = d2[0];
                return;
            }
            Comparator<? super T> comparator = this.f28285b;
            int i18 = this.f28286c;
            int i19 = 0;
            loop0: while (true) {
                int i20 = 0;
                int i21 = 0;
                while (true) {
                    if (comparator.compare(tArr[i15], d2[i19]) < 0) {
                        i6 = i14 + 1;
                        int i22 = i15 + 1;
                        tArr[i14] = tArr[i15];
                        i21 += i17;
                        i16--;
                        if (i16 == 0) {
                            i15 = i22;
                            break loop0;
                        }
                        i14 = i6;
                        i15 = i22;
                        i20 = 0;
                        if ((i20 | i21) < i18) {
                            break;
                        }
                    } else {
                        int i23 = i14 + 1;
                        int i24 = i19 + 1;
                        tArr[i14] = d2[i19];
                        i20 += i17;
                        i13--;
                        if (i13 == i17) {
                            i6 = i23;
                            i19 = i24;
                            break loop0;
                        }
                        i14 = i23;
                        i19 = i24;
                        i21 = 0;
                        if ((i20 | i21) < i18) {
                        }
                    }
                }
                i18 = i11 + 2;
                i14 = i12;
                i16 = i8;
                i13 = i9;
                i15 = i10;
                i17 = 1;
            }
            if (i18 < i7) {
                i18 = 1;
            }
            this.f28286c = i18;
            if (i13 == i7) {
                System.arraycopy(tArr, i15, tArr, i6, i16);
                tArr[i6 + i16] = d2[i19];
            } else if (i13 != 0) {
                System.arraycopy(d2, i19, tArr, i6, i13);
            } else {
                throw new IllegalArgumentException("Comparison method violates its general contract!");
            }
        }
    }

    public final void m(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            int[] iArr = this.f28290g;
            int i4 = this.f28289f;
            iArr[i4] = i2;
            this.f28291h[i4] = i3;
            this.f28289f = i4 + 1;
        }
    }
}
