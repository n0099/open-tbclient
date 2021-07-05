package com.baidu.tbadk.core.util;

import android.graphics.BitmapFactory;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ImageUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CameraExif";
    public transient /* synthetic */ FieldHolder $fh;

    public ImageUtil() {
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

    public static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, options, i2, i3)) == null) {
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            int i6 = 1;
            if (i4 > i3 || i5 > i2) {
                int i7 = i4 / 2;
                int i8 = i5 / 2;
                while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                    i6 *= 2;
                }
            }
            return i6;
        }
        return invokeLII.intValue;
    }

    public static int exifToDegrees(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 == 6) {
                return 90;
            }
            if (i2 == 3) {
                return 180;
            }
            return i2 == 8 ? 270 : 0;
        }
        return invokeI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x006a, code lost:
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006b, code lost:
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006c, code lost:
        if (r3 <= 8) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006e, code lost:
        r2 = pack(r11, r1, 4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0075, code lost:
        if (r2 == 1229531648) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007a, code lost:
        if (r2 == 1296891946) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x007c, code lost:
        android.util.Log.e("CameraExif", "Invalid byte order");
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0081, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0082, code lost:
        if (r2 != 1229531648) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0086, code lost:
        r2 = pack(r11, r1 + 4, 4, r6) + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008f, code lost:
        if (r2 < 10) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0091, code lost:
        if (r2 <= r3) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0094, code lost:
        r1 = r1 + r2;
        r3 = r3 - r2;
        r2 = pack(r11, r1 - 2, 2, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009c, code lost:
        r4 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009e, code lost:
        if (r2 <= 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a2, code lost:
        if (r3 < 12) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00aa, code lost:
        if (pack(r11, r1, 2, r6) != 274) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ac, code lost:
        r11 = pack(r11, r1 + 8, 2, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b2, code lost:
        if (r11 == 3) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b5, code lost:
        if (r11 == 6) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b7, code lost:
        if (r11 == 8) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b9, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ba, code lost:
        return 270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00bd, code lost:
        return 90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c0, code lost:
        return 180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c3, code lost:
        r1 = r1 + 12;
        r3 = r3 - 12;
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c9, code lost:
        android.util.Log.e("CameraExif", "Invalid offset");
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00ce, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cf, code lost:
        android.util.Log.i("CameraExif", "Orientation not found");
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00d4, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getOrientation(byte[] bArr) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr == null) {
                return 0;
            }
            int i3 = 0;
            while (true) {
                boolean z = true;
                if (i3 + 3 >= bArr.length) {
                    break;
                }
                int i4 = i3 + 1;
                if ((bArr[i3] & 255) != 255) {
                    break;
                }
                int i5 = bArr[i4] & 255;
                if (i5 != 255) {
                    i4++;
                    if (i5 != 216 && i5 != 1) {
                        if (i5 != 217 && i5 != 218) {
                            int pack = pack(bArr, i4, 2, false);
                            if (pack >= 2 && (i2 = i4 + pack) <= bArr.length) {
                                if (i5 == 225 && pack >= 8 && pack(bArr, i4 + 2, 4, false) == 1165519206 && pack(bArr, i4 + 6, 2, false) == 0) {
                                    i3 = i4 + 8;
                                    int i6 = pack - 8;
                                    break;
                                }
                                i3 = i2;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                i3 = i4;
            }
            Log.e("CameraExif", "Invalid length");
            return 0;
        }
        return invokeL.intValue;
    }

    public static int pack(byte[] bArr, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) != null) {
            return invokeCommon.intValue;
        }
        if (z) {
            i2 += i3 - 1;
            i4 = -1;
        } else {
            i4 = 1;
        }
        int i5 = 0;
        while (true) {
            int i6 = i3 - 1;
            if (i3 <= 0) {
                return i5;
            }
            i5 = (bArr[i2] & 255) | (i5 << 8);
            i2 += i4;
            i3 = i6;
        }
    }
}
