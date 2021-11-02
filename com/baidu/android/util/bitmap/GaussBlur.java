package com.baidu.android.util.bitmap;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
/* loaded from: classes6.dex */
public final class GaussBlur {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public GaussBlur() {
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

    public static Bitmap fastBlur(Bitmap bitmap, boolean z, float f2, int i2) {
        InterceptResult invokeCommon;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bitmap, Boolean.valueOf(z), Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            Bitmap bitmap2 = bitmap;
            int i3 = i2;
            int round = Math.round(bitmap.getWidth() * f2);
            int round2 = Math.round(bitmap.getHeight() * f2);
            if (!z) {
                bitmap2 = Bitmap.createScaledBitmap(bitmap2, round, round2, false);
            } else if (f2 != 1.0f) {
                bitmap2 = Bitmap.createScaledBitmap(bitmap2, round, round2, false);
            }
            int width = bitmap2.getWidth();
            int height = bitmap2.getHeight();
            int i4 = width * height;
            int[] iArr2 = new int[i4];
            bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
            int i5 = width - 1;
            int i6 = height - 1;
            int i7 = i3 + i3 + 1;
            int[] iArr3 = new int[i4];
            int[] iArr4 = new int[i4];
            int[] iArr5 = new int[i4];
            int[] iArr6 = new int[Math.max(width, height)];
            int i8 = (i7 + 1) >> 1;
            int i9 = i8 * i8;
            int i10 = i9 * 256;
            int[] iArr7 = new int[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                iArr7[i11] = i11 / i9;
            }
            int[][] iArr8 = (int[][]) Array.newInstance(int.class, i7, 3);
            int i12 = i3 + 1;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i13 < height) {
                Bitmap bitmap3 = bitmap2;
                int i16 = -i3;
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                int i22 = 0;
                int i23 = 0;
                int i24 = 0;
                int i25 = 0;
                while (i16 <= i3) {
                    int i26 = height;
                    int i27 = i6;
                    int i28 = iArr2[i14 + Math.min(i5, Math.max(i16, 0))];
                    int[] iArr9 = iArr8[i16 + i3];
                    iArr9[0] = (i28 & 16711680) >> 16;
                    iArr9[1] = (i28 & 65280) >> 8;
                    iArr9[2] = i28 & 255;
                    int abs = i12 - Math.abs(i16);
                    i17 += iArr9[0] * abs;
                    i18 += iArr9[1] * abs;
                    i19 += iArr9[2] * abs;
                    if (i16 > 0) {
                        i23 += iArr9[0];
                        i24 += iArr9[1];
                        i25 += iArr9[2];
                    } else {
                        i20 += iArr9[0];
                        i21 += iArr9[1];
                        i22 += iArr9[2];
                    }
                    i16++;
                    height = i26;
                    i6 = i27;
                }
                int i29 = height;
                int i30 = i6;
                int i31 = i3;
                int i32 = 0;
                while (i32 < width) {
                    iArr3[i14] = iArr7[i17];
                    iArr4[i14] = iArr7[i18];
                    iArr5[i14] = iArr7[i19];
                    int i33 = i17 - i20;
                    int i34 = i18 - i21;
                    int i35 = i19 - i22;
                    int[] iArr10 = iArr8[((i31 - i3) + i7) % i7];
                    int i36 = i20 - iArr10[0];
                    int i37 = i21 - iArr10[1];
                    int i38 = i22 - iArr10[2];
                    if (i13 == 0) {
                        iArr = iArr7;
                        iArr6[i32] = Math.min(i32 + i3 + 1, i5);
                    } else {
                        iArr = iArr7;
                    }
                    int i39 = iArr2[i15 + iArr6[i32]];
                    iArr10[0] = (i39 & 16711680) >> 16;
                    iArr10[1] = (i39 & 65280) >> 8;
                    iArr10[2] = i39 & 255;
                    int i40 = i23 + iArr10[0];
                    int i41 = i24 + iArr10[1];
                    int i42 = i25 + iArr10[2];
                    i17 = i33 + i40;
                    i18 = i34 + i41;
                    i19 = i35 + i42;
                    i31 = (i31 + 1) % i7;
                    int[] iArr11 = iArr8[i31 % i7];
                    i20 = i36 + iArr11[0];
                    i21 = i37 + iArr11[1];
                    i22 = i38 + iArr11[2];
                    i23 = i40 - iArr11[0];
                    i24 = i41 - iArr11[1];
                    i25 = i42 - iArr11[2];
                    i14++;
                    i32++;
                    iArr7 = iArr;
                }
                i15 += width;
                i13++;
                bitmap2 = bitmap3;
                height = i29;
                i6 = i30;
            }
            Bitmap bitmap4 = bitmap2;
            int i43 = height;
            int[] iArr12 = iArr7;
            int i44 = i6;
            int i45 = 0;
            while (i45 < width) {
                int i46 = -i3;
                int i47 = i46 * width;
                int i48 = 0;
                int i49 = 0;
                int i50 = 0;
                int i51 = 0;
                int i52 = 0;
                int i53 = 0;
                int i54 = 0;
                int i55 = 0;
                int i56 = 0;
                while (i46 <= i3) {
                    int[] iArr13 = iArr6;
                    int max = Math.max(0, i47) + i45;
                    int[] iArr14 = iArr8[i46 + i3];
                    iArr14[0] = iArr3[max];
                    iArr14[1] = iArr4[max];
                    iArr14[2] = iArr5[max];
                    int abs2 = i12 - Math.abs(i46);
                    i48 += iArr3[max] * abs2;
                    i49 += iArr4[max] * abs2;
                    i50 += iArr5[max] * abs2;
                    if (i46 > 0) {
                        i54 += iArr14[0];
                        i55 += iArr14[1];
                        i56 += iArr14[2];
                    } else {
                        i51 += iArr14[0];
                        i52 += iArr14[1];
                        i53 += iArr14[2];
                    }
                    int i57 = i44;
                    if (i46 < i57) {
                        i47 += width;
                    }
                    i46++;
                    i44 = i57;
                    iArr6 = iArr13;
                }
                int[] iArr15 = iArr6;
                int i58 = i44;
                int i59 = i45;
                int i60 = i3;
                int i61 = i43;
                int i62 = 0;
                while (i62 < i61) {
                    iArr2[i59] = (iArr2[i59] & (-16777216)) | (iArr12[i48] << 16) | (iArr12[i49] << 8) | iArr12[i50];
                    int i63 = i48 - i51;
                    int i64 = i49 - i52;
                    int i65 = i50 - i53;
                    int[] iArr16 = iArr8[((i60 - i3) + i7) % i7];
                    int i66 = i51 - iArr16[0];
                    int i67 = i52 - iArr16[1];
                    int i68 = i53 - iArr16[2];
                    if (i45 == 0) {
                        iArr15[i62] = Math.min(i62 + i12, i58) * width;
                    }
                    int i69 = iArr15[i62] + i45;
                    iArr16[0] = iArr3[i69];
                    iArr16[1] = iArr4[i69];
                    iArr16[2] = iArr5[i69];
                    int i70 = i54 + iArr16[0];
                    int i71 = i55 + iArr16[1];
                    int i72 = i56 + iArr16[2];
                    i48 = i63 + i70;
                    i49 = i64 + i71;
                    i50 = i65 + i72;
                    i60 = (i60 + 1) % i7;
                    int[] iArr17 = iArr8[i60];
                    i51 = i66 + iArr17[0];
                    i52 = i67 + iArr17[1];
                    i53 = i68 + iArr17[2];
                    i54 = i70 - iArr17[0];
                    i55 = i71 - iArr17[1];
                    i56 = i72 - iArr17[2];
                    i59 += width;
                    i62++;
                    i3 = i2;
                }
                i45++;
                i3 = i2;
                i43 = i61;
                i44 = i58;
                iArr6 = iArr15;
            }
            bitmap4.setPixels(iArr2, 0, width, 0, 0, width, i43);
            return bitmap4;
        }
        return (Bitmap) invokeCommon.objValue;
    }
}
