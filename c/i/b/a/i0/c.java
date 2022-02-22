package c.i.b.a.i0;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.rtc.record.MediaEncodeParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.ParserException;
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f29926b;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f29927c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-717096985, "Lc/i/b/a/i0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-717096985, "Lc/i/b/a/i0/c;");
                return;
            }
        }
        a = new byte[]{0, 0, 0, 1};
        f29926b = new int[]{96000, 88200, 64000, MediaEncodeParams.AUDIO_SAMPLE_RATE, 44100, 32000, 24000, 22050, 16000, w0.X3, 11025, 8000, 7350};
        f29927c = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    }

    public static byte[] a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65537, null, i2, i3, i4)) == null) ? new byte[]{(byte) (((i2 << 3) & 248) | ((i3 >> 1) & 7)), (byte) (((i3 << 7) & 128) | ((i4 << 3) & 120))} : (byte[]) invokeIII.objValue;
    }

    public static byte[] b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
            int i4 = 0;
            int i5 = 0;
            int i6 = -1;
            while (true) {
                int[] iArr = f29926b;
                if (i5 >= iArr.length) {
                    break;
                }
                if (i2 == iArr[i5]) {
                    i6 = i5;
                }
                i5++;
            }
            int i7 = -1;
            while (true) {
                int[] iArr2 = f29927c;
                if (i4 >= iArr2.length) {
                    break;
                }
                if (i3 == iArr2[i4]) {
                    i7 = i4;
                }
                i4++;
            }
            if (i2 != -1 && i7 != -1) {
                return a(2, i6, i7);
            }
            throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3);
        }
        return (byte[]) invokeII.objValue;
    }

    public static byte[] c(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i2, i3)) == null) {
            byte[] bArr2 = a;
            byte[] bArr3 = new byte[bArr2.length + i3];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, i2, bArr3, a.length, i3);
            return bArr3;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static int d(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2)) == null) {
            int length = bArr.length - a.length;
            while (i2 <= length) {
                if (g(bArr, i2)) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public static int e(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, kVar)) == null) {
            int g2 = kVar.g(5);
            return g2 == 31 ? kVar.g(6) + 32 : g2;
        }
        return invokeL.intValue;
    }

    public static int f(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, kVar)) == null) {
            int g2 = kVar.g(4);
            if (g2 == 15) {
                return kVar.g(24);
            }
            a.a(g2 < 13);
            return f29926b[g2];
        }
        return invokeL.intValue;
    }

    public static boolean g(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65543, null, bArr, i2)) != null) {
            return invokeLI.booleanValue;
        }
        if (bArr.length - i2 <= a.length) {
            return false;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = a;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr[i2 + i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    public static Pair<Integer, Integer> h(k kVar, boolean z) throws ParserException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65544, null, kVar, z)) == null) {
            int e2 = e(kVar);
            int f2 = f(kVar);
            int g2 = kVar.g(4);
            if (e2 == 5 || e2 == 29) {
                f2 = f(kVar);
                e2 = e(kVar);
                if (e2 == 22) {
                    g2 = kVar.g(4);
                }
            }
            if (z) {
                if (e2 != 1 && e2 != 2 && e2 != 3 && e2 != 4 && e2 != 6 && e2 != 7 && e2 != 17) {
                    switch (e2) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            break;
                        default:
                            throw new ParserException("Unsupported audio object type: " + e2);
                    }
                }
                j(kVar, e2, g2);
                switch (e2) {
                    case 17:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        int g3 = kVar.g(2);
                        if (g3 == 2 || g3 == 3) {
                            throw new ParserException("Unsupported epConfig: " + g3);
                        }
                }
            }
            int i2 = f29927c[g2];
            a.a(i2 != -1);
            return Pair.create(Integer.valueOf(f2), Integer.valueOf(i2));
        }
        return (Pair) invokeLZ.objValue;
    }

    public static Pair<Integer, Integer> i(byte[] bArr) throws ParserException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bArr)) == null) ? h(new k(bArr), false) : (Pair) invokeL.objValue;
    }

    public static void j(k kVar, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65546, null, kVar, i2, i3) == null) {
            kVar.n(1);
            if (kVar.f()) {
                kVar.n(14);
            }
            boolean f2 = kVar.f();
            if (i3 == 0) {
                throw new UnsupportedOperationException();
            }
            if (i2 == 6 || i2 == 20) {
                kVar.n(3);
            }
            if (f2) {
                if (i2 == 22) {
                    kVar.n(16);
                }
                if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                    kVar.n(3);
                }
                kVar.n(1);
            }
        }
    }

    public static byte[][] k(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bArr)) == null) {
            if (g(bArr, 0)) {
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                do {
                    arrayList.add(Integer.valueOf(i2));
                    i2 = d(bArr, i2 + a.length);
                } while (i2 != -1);
                byte[][] bArr2 = new byte[arrayList.size()];
                int i3 = 0;
                while (i3 < arrayList.size()) {
                    int intValue = ((Integer) arrayList.get(i3)).intValue();
                    int intValue2 = (i3 < arrayList.size() + (-1) ? ((Integer) arrayList.get(i3 + 1)).intValue() : bArr.length) - intValue;
                    byte[] bArr3 = new byte[intValue2];
                    System.arraycopy(bArr, intValue, bArr3, 0, intValue2);
                    bArr2[i3] = bArr3;
                    i3++;
                }
                return bArr2;
            }
            return null;
        }
        return (byte[][]) invokeL.objValue;
    }
}
