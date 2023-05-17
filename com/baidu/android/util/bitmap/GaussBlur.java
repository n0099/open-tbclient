package com.baidu.android.util.bitmap;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
/* loaded from: classes.dex */
public final class GaussBlur {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public GaussBlur() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Bitmap fastBlur(Bitmap bitmap, boolean z, float f, int i) {
        InterceptResult invokeCommon;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bitmap, Boolean.valueOf(z), Float.valueOf(f), Integer.valueOf(i)})) == null) {
            Bitmap bitmap2 = bitmap;
            int i2 = i;
            int round = Math.round(bitmap.getWidth() * f);
            int round2 = Math.round(bitmap.getHeight() * f);
            if (z) {
                if (f != 1.0f) {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap2, round, round2, false);
                }
            } else {
                bitmap2 = Bitmap.createScaledBitmap(bitmap2, round, round2, false);
            }
            int width = bitmap2.getWidth();
            int height = bitmap2.getHeight();
            int i3 = width * height;
            int[] iArr2 = new int[i3];
            bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
            int i4 = width - 1;
            int i5 = height - 1;
            int i6 = i2 + i2 + 1;
            int[] iArr3 = new int[i3];
            int[] iArr4 = new int[i3];
            int[] iArr5 = new int[i3];
            int[] iArr6 = new int[Math.max(width, height)];
            int i7 = (i6 + 1) >> 1;
            int i8 = i7 * i7;
            int i9 = i8 * 256;
            int[] iArr7 = new int[i9];
            for (int i10 = 0; i10 < i9; i10++) {
                iArr7[i10] = i10 / i8;
            }
            int[][] iArr8 = (int[][]) Array.newInstance(int.class, i6, 3);
            int i11 = i2 + 1;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i12 < height) {
                Bitmap bitmap3 = bitmap2;
                int i15 = -i2;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                int i22 = 0;
                int i23 = 0;
                int i24 = 0;
                while (i15 <= i2) {
                    int i25 = height;
                    int i26 = i5;
                    int i27 = iArr2[i13 + Math.min(i4, Math.max(i15, 0))];
                    int[] iArr9 = iArr8[i15 + i2];
                    iArr9[0] = (i27 & 16711680) >> 16;
                    iArr9[1] = (i27 & 65280) >> 8;
                    iArr9[2] = i27 & 255;
                    int abs = i11 - Math.abs(i15);
                    i16 += iArr9[0] * abs;
                    i17 += iArr9[1] * abs;
                    i18 += iArr9[2] * abs;
                    if (i15 > 0) {
                        i22 += iArr9[0];
                        i23 += iArr9[1];
                        i24 += iArr9[2];
                    } else {
                        i19 += iArr9[0];
                        i20 += iArr9[1];
                        i21 += iArr9[2];
                    }
                    i15++;
                    height = i25;
                    i5 = i26;
                }
                int i28 = height;
                int i29 = i5;
                int i30 = i2;
                int i31 = 0;
                while (i31 < width) {
                    iArr3[i13] = iArr7[i16];
                    iArr4[i13] = iArr7[i17];
                    iArr5[i13] = iArr7[i18];
                    int i32 = i16 - i19;
                    int i33 = i17 - i20;
                    int i34 = i18 - i21;
                    int[] iArr10 = iArr8[((i30 - i2) + i6) % i6];
                    int i35 = i19 - iArr10[0];
                    int i36 = i20 - iArr10[1];
                    int i37 = i21 - iArr10[2];
                    if (i12 == 0) {
                        iArr = iArr7;
                        iArr6[i31] = Math.min(i31 + i2 + 1, i4);
                    } else {
                        iArr = iArr7;
                    }
                    int i38 = iArr2[i14 + iArr6[i31]];
                    iArr10[0] = (i38 & 16711680) >> 16;
                    iArr10[1] = (i38 & 65280) >> 8;
                    iArr10[2] = i38 & 255;
                    int i39 = i22 + iArr10[0];
                    int i40 = i23 + iArr10[1];
                    int i41 = i24 + iArr10[2];
                    i16 = i32 + i39;
                    i17 = i33 + i40;
                    i18 = i34 + i41;
                    i30 = (i30 + 1) % i6;
                    int[] iArr11 = iArr8[i30 % i6];
                    i19 = i35 + iArr11[0];
                    i20 = i36 + iArr11[1];
                    i21 = i37 + iArr11[2];
                    i22 = i39 - iArr11[0];
                    i23 = i40 - iArr11[1];
                    i24 = i41 - iArr11[2];
                    i13++;
                    i31++;
                    iArr7 = iArr;
                }
                i14 += width;
                i12++;
                bitmap2 = bitmap3;
                height = i28;
                i5 = i29;
            }
            Bitmap bitmap4 = bitmap2;
            int i42 = height;
            int[] iArr12 = iArr7;
            int i43 = i5;
            int i44 = 0;
            while (i44 < width) {
                int i45 = -i2;
                int i46 = i45 * width;
                int i47 = 0;
                int i48 = 0;
                int i49 = 0;
                int i50 = 0;
                int i51 = 0;
                int i52 = 0;
                int i53 = 0;
                int i54 = 0;
                int i55 = 0;
                while (i45 <= i2) {
                    int[] iArr13 = iArr6;
                    int max = Math.max(0, i46) + i44;
                    int[] iArr14 = iArr8[i45 + i2];
                    iArr14[0] = iArr3[max];
                    iArr14[1] = iArr4[max];
                    iArr14[2] = iArr5[max];
                    int abs2 = i11 - Math.abs(i45);
                    i47 += iArr3[max] * abs2;
                    i48 += iArr4[max] * abs2;
                    i49 += iArr5[max] * abs2;
                    if (i45 > 0) {
                        i53 += iArr14[0];
                        i54 += iArr14[1];
                        i55 += iArr14[2];
                    } else {
                        i50 += iArr14[0];
                        i51 += iArr14[1];
                        i52 += iArr14[2];
                    }
                    int i56 = i43;
                    if (i45 < i56) {
                        i46 += width;
                    }
                    i45++;
                    i43 = i56;
                    iArr6 = iArr13;
                }
                int[] iArr15 = iArr6;
                int i57 = i43;
                int i58 = i44;
                int i59 = i2;
                int i60 = i42;
                int i61 = 0;
                while (i61 < i60) {
                    iArr2[i58] = (iArr2[i58] & (-16777216)) | (iArr12[i47] << 16) | (iArr12[i48] << 8) | iArr12[i49];
                    int i62 = i47 - i50;
                    int i63 = i48 - i51;
                    int i64 = i49 - i52;
                    int[] iArr16 = iArr8[((i59 - i2) + i6) % i6];
                    int i65 = i50 - iArr16[0];
                    int i66 = i51 - iArr16[1];
                    int i67 = i52 - iArr16[2];
                    if (i44 == 0) {
                        iArr15[i61] = Math.min(i61 + i11, i57) * width;
                    }
                    int i68 = iArr15[i61] + i44;
                    iArr16[0] = iArr3[i68];
                    iArr16[1] = iArr4[i68];
                    iArr16[2] = iArr5[i68];
                    int i69 = i53 + iArr16[0];
                    int i70 = i54 + iArr16[1];
                    int i71 = i55 + iArr16[2];
                    i47 = i62 + i69;
                    i48 = i63 + i70;
                    i49 = i64 + i71;
                    i59 = (i59 + 1) % i6;
                    int[] iArr17 = iArr8[i59];
                    i50 = i65 + iArr17[0];
                    i51 = i66 + iArr17[1];
                    i52 = i67 + iArr17[2];
                    i53 = i69 - iArr17[0];
                    i54 = i70 - iArr17[1];
                    i55 = i71 - iArr17[2];
                    i58 += width;
                    i61++;
                    i2 = i;
                }
                i44++;
                i2 = i;
                i42 = i60;
                i43 = i57;
                iArr6 = iArr15;
            }
            bitmap4.setPixels(iArr2, 0, width, 0, 0, width, i42);
            return bitmap4;
        }
        return (Bitmap) invokeCommon.objValue;
    }
}
