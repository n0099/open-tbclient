package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.fj;
import com.baidu.tieba.on;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
/* loaded from: classes3.dex */
public class BitmapHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILE_2_BITMAP_MUL = 10;
    public static final int ROTATE_LEFT = 0;
    public static final int ROTATE_LEFT_RIGHT = 2;
    public static final int ROTATE_RIGHT = 1;
    public static final int ROTATE_UP_DOWN = 3;
    public static final Object lockForSyncImageDecoder;
    public static volatile SparseArray<SoftReference<Bitmap>> mBitmapDarkHash;
    public static volatile SparseArray<SoftReference<Bitmap>> mBitmapHash;
    public static volatile SparseArray<SoftReference<Bitmap>> mBitmapNightHash;
    public static volatile SparseArray<SoftReference<Bitmap>> mBitmapThemeHash;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-934706370, "Lcom/baidu/tbadk/core/util/BitmapHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-934706370, "Lcom/baidu/tbadk/core/util/BitmapHelper;");
                return;
            }
        }
        lockForSyncImageDecoder = new Object();
        mBitmapHash = new SparseArray<>();
        mBitmapNightHash = new SparseArray<>();
        mBitmapDarkHash = new SparseArray<>();
        mBitmapThemeHash = new SparseArray<>();
    }

    public BitmapHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static byte[] Bitmap2Bytes(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        byte[] byteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bitmap, i)) == null) {
            synchronized (lockForSyncImageDecoder) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, i, byteArrayOutputStream);
                byteArray = byteArrayOutputStream.toByteArray();
            }
            return byteArray;
        }
        return (byte[]) invokeLI.objValue;
    }

    public static Bitmap Bytes2Bitmap(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            Bitmap bitmap = null;
            if (bArr != null && bArr.length != 0) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                try {
                    synchronized (lockForSyncImageDecoder) {
                        bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    }
                } catch (OutOfMemoryError unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                } catch (Error e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap Bytes2NineBitmap(byte[] bArr, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, rect)) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = false;
            int i = TbadkCoreApplication.getInst().getResources().getDisplayMetrics().densityDpi;
            options.inScreenDensity = i;
            options.inTargetDensity = i;
            options.inDensity = i;
            Bitmap bitmap = null;
            try {
                try {
                    try {
                        try {
                            synchronized (lockForSyncImageDecoder) {
                                bitmap = BitmapFactory.decodeStream(byteArrayInputStream, rect, options);
                            }
                            byteArrayInputStream.close();
                        } catch (OutOfMemoryError e) {
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            e.printStackTrace();
                            byteArrayInputStream.close();
                        }
                    } catch (Error e2) {
                        e2.printStackTrace();
                        byteArrayInputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        byteArrayInputStream.close();
                    }
                } catch (IOException e4) {
                    BdLog.d(e4.getMessage());
                }
                return bitmap;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e5) {
                    BdLog.d(e5.getMessage());
                }
                throw th;
            }
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static int calcNearestSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            int i2 = 1;
            for (int i3 = 1; i3 <= i; i3 *= 2) {
                int i4 = i - i3;
                if (i4 == 0) {
                    return i;
                }
                if (i4 > 0) {
                    i2 = i3;
                }
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public static Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, bitmap, i, i2)) == null) ? bitmap : (Bitmap) invokeLII.objValue;
    }

    public static on checkIsValidPhotoMemoryCache(String str, on onVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(65543, null, str, onVar, i, i2)) == null) ? onVar : (on) invokeLLII.objValue;
    }

    public static on checkIsValidPicMemoryCache(String str, on onVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(65544, null, str, onVar, i, i2)) == null) ? onVar : (on) invokeLLII.objValue;
    }

    public static void clearCashBitmap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            mBitmapHash.clear();
            mBitmapNightHash.clear();
            mBitmapThemeHash.clear();
        }
    }

    public static void clearThemeCashBitmap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            mBitmapThemeHash.clear();
        }
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65547, null, bArr, i, i2)) == null) {
            if (bArr != null) {
                try {
                    if (bArr.length != 0 && i > 0 && i2 > 0) {
                        synchronized (lockForSyncImageDecoder) {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inPreferredConfig = TbConfig.BitmapConfig;
                            options.inJustDecodeBounds = true;
                            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                            if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                                options.inSampleSize = ImageUtil.calculateInSampleSize(options, i, i2);
                                options.inJustDecodeBounds = false;
                                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                            }
                            return null;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static Bitmap fastblur(Bitmap bitmap, int i, float f) {
        InterceptResult invokeCommon;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{bitmap, Integer.valueOf(i), Float.valueOf(f)})) == null) {
            int i2 = i;
            if (i2 < 1 || bitmap == null || f <= 0.0f) {
                return null;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f), Math.round(bitmap.getHeight() * f), false);
            Bitmap copy = createScaledBitmap.copy(createScaledBitmap.getConfig(), true);
            int width = copy.getWidth();
            int height = copy.getHeight();
            int i3 = width * height;
            int[] iArr2 = new int[i3];
            copy.getPixels(iArr2, 0, width, 0, 0, width, height);
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
                Bitmap bitmap2 = copy;
                int i15 = height;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                int i22 = 0;
                int i23 = 0;
                int i24 = -i2;
                int i25 = 0;
                while (i24 <= i2) {
                    int i26 = i5;
                    int[] iArr9 = iArr6;
                    int i27 = iArr2[i13 + Math.min(i4, Math.max(i24, 0))];
                    int[] iArr10 = iArr8[i24 + i2];
                    iArr10[0] = (i27 & 16711680) >> 16;
                    iArr10[1] = (i27 & 65280) >> 8;
                    iArr10[2] = i27 & 255;
                    int abs = i11 - Math.abs(i24);
                    i25 += iArr10[0] * abs;
                    i16 += iArr10[1] * abs;
                    i17 += iArr10[2] * abs;
                    if (i24 > 0) {
                        i21 += iArr10[0];
                        i22 += iArr10[1];
                        i23 += iArr10[2];
                    } else {
                        i18 += iArr10[0];
                        i19 += iArr10[1];
                        i20 += iArr10[2];
                    }
                    i24++;
                    i5 = i26;
                    iArr6 = iArr9;
                }
                int i28 = i5;
                int[] iArr11 = iArr6;
                int i29 = i25;
                int i30 = i2;
                int i31 = 0;
                while (i31 < width) {
                    iArr3[i13] = iArr7[i29];
                    iArr4[i13] = iArr7[i16];
                    iArr5[i13] = iArr7[i17];
                    int i32 = i29 - i18;
                    int i33 = i16 - i19;
                    int i34 = i17 - i20;
                    int[] iArr12 = iArr8[((i30 - i2) + i6) % i6];
                    int i35 = i18 - iArr12[0];
                    int i36 = i19 - iArr12[1];
                    int i37 = i20 - iArr12[2];
                    if (i12 == 0) {
                        iArr = iArr7;
                        iArr11[i31] = Math.min(i31 + i2 + 1, i4);
                    } else {
                        iArr = iArr7;
                    }
                    int i38 = iArr2[i14 + iArr11[i31]];
                    iArr12[0] = (i38 & 16711680) >> 16;
                    iArr12[1] = (i38 & 65280) >> 8;
                    iArr12[2] = i38 & 255;
                    int i39 = i21 + iArr12[0];
                    int i40 = i22 + iArr12[1];
                    int i41 = i23 + iArr12[2];
                    i29 = i32 + i39;
                    i16 = i33 + i40;
                    i17 = i34 + i41;
                    i30 = (i30 + 1) % i6;
                    int[] iArr13 = iArr8[i30 % i6];
                    i18 = i35 + iArr13[0];
                    i19 = i36 + iArr13[1];
                    i20 = i37 + iArr13[2];
                    i21 = i39 - iArr13[0];
                    i22 = i40 - iArr13[1];
                    i23 = i41 - iArr13[2];
                    i13++;
                    i31++;
                    iArr7 = iArr;
                }
                i14 += width;
                i12++;
                copy = bitmap2;
                height = i15;
                i5 = i28;
                iArr6 = iArr11;
            }
            Bitmap bitmap3 = copy;
            int i42 = height;
            int[] iArr14 = iArr7;
            int i43 = i5;
            int[] iArr15 = iArr6;
            int i44 = 0;
            while (i44 < width) {
                int i45 = -i2;
                int i46 = i6;
                int[] iArr16 = iArr2;
                int i47 = 0;
                int i48 = 0;
                int i49 = 0;
                int i50 = 0;
                int i51 = 0;
                int i52 = 0;
                int i53 = 0;
                int i54 = i45;
                int i55 = i45 * width;
                int i56 = 0;
                int i57 = 0;
                while (i54 <= i2) {
                    int i58 = width;
                    int max = Math.max(0, i55) + i44;
                    int[] iArr17 = iArr8[i54 + i2];
                    iArr17[0] = iArr3[max];
                    iArr17[1] = iArr4[max];
                    iArr17[2] = iArr5[max];
                    int abs2 = i11 - Math.abs(i54);
                    i56 += iArr3[max] * abs2;
                    i57 += iArr4[max] * abs2;
                    i47 += iArr5[max] * abs2;
                    if (i54 > 0) {
                        i51 += iArr17[0];
                        i52 += iArr17[1];
                        i53 += iArr17[2];
                    } else {
                        i48 += iArr17[0];
                        i49 += iArr17[1];
                        i50 += iArr17[2];
                    }
                    int i59 = i43;
                    if (i54 < i59) {
                        i55 += i58;
                    }
                    i54++;
                    i43 = i59;
                    width = i58;
                }
                int i60 = width;
                int i61 = i43;
                int i62 = i44;
                int i63 = i2;
                int i64 = i48;
                int i65 = i42;
                int i66 = i47;
                int i67 = i57;
                int i68 = i56;
                int i69 = 0;
                while (i69 < i65) {
                    iArr16[i62] = (iArr16[i62] & (-16777216)) | (iArr14[i68] << 16) | (iArr14[i67] << 8) | iArr14[i66];
                    int i70 = i68 - i64;
                    int i71 = i67 - i49;
                    int i72 = i66 - i50;
                    int[] iArr18 = iArr8[((i63 - i2) + i46) % i46];
                    int i73 = i64 - iArr18[0];
                    int i74 = i49 - iArr18[1];
                    int i75 = i50 - iArr18[2];
                    if (i44 == 0) {
                        iArr15[i69] = Math.min(i69 + i11, i61) * i60;
                    }
                    int i76 = iArr15[i69] + i44;
                    iArr18[0] = iArr3[i76];
                    iArr18[1] = iArr4[i76];
                    iArr18[2] = iArr5[i76];
                    int i77 = i51 + iArr18[0];
                    int i78 = i52 + iArr18[1];
                    int i79 = i53 + iArr18[2];
                    i68 = i70 + i77;
                    i67 = i71 + i78;
                    i66 = i72 + i79;
                    i63 = (i63 + 1) % i46;
                    int[] iArr19 = iArr8[i63];
                    i64 = i73 + iArr19[0];
                    i49 = i74 + iArr19[1];
                    i50 = i75 + iArr19[2];
                    i51 = i77 - iArr19[0];
                    i52 = i78 - iArr19[1];
                    i53 = i79 - iArr19[2];
                    i62 += i60;
                    i69++;
                    i2 = i;
                }
                i44++;
                i2 = i;
                i43 = i61;
                i42 = i65;
                i6 = i46;
                iArr2 = iArr16;
                width = i60;
            }
            int i80 = width;
            bitmap3.setPixels(iArr2, 0, i80, 0, 0, i80, i42);
            return bitmap3;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static int getBitmapSize(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bitmap)) == null) {
            if (bitmap == null) {
                return 0;
            }
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
        return invokeL.intValue;
    }

    public static Bitmap getCashBitmap(int i, BitmapFactory.Options options) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i, options)) == null) {
            SoftReference<Bitmap> softReference = mBitmapHash.get(i);
            Bitmap bitmap = softReference != null ? softReference.get() : null;
            if (bitmap != null) {
                return bitmap;
            }
            Bitmap resBitmap = getResBitmap(TbadkCoreApplication.getInst().getApp(), i, options);
            if (resBitmap != null) {
                mBitmapHash.put(i, new SoftReference<>(resBitmap));
            }
            return resBitmap;
        }
        return (Bitmap) invokeIL.objValue;
    }

    public static Bitmap getDarkCashBitmap(Resources resources, int i, int i2, BitmapFactory.Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{resources, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            SoftReference<Bitmap> softReference = mBitmapDarkHash.get(i2);
            Bitmap bitmap = softReference != null ? softReference.get() : null;
            if (bitmap != null) {
                return bitmap;
            }
            try {
                bitmap = BitmapFactory.decodeResource(resources, i, options);
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
            }
            if (bitmap != null) {
                mBitmapDarkHash.put(i2, new SoftReference<>(bitmap));
            }
            return bitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static int getGradeResourceIdInEnterForum(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i)) == null) {
            switch (i) {
                case 1:
                    return R.drawable.icon_level_01;
                case 2:
                    return R.drawable.icon_level_02;
                case 3:
                    return R.drawable.icon_level_03;
                case 4:
                    return R.drawable.icon_level_04;
                case 5:
                    return R.drawable.icon_level_05;
                case 6:
                    return R.drawable.icon_level_06;
                case 7:
                    return R.drawable.icon_level_07;
                case 8:
                    return R.drawable.icon_level_08;
                case 9:
                    return R.drawable.icon_level_09;
                case 10:
                    return R.drawable.icon_level_10;
                case 11:
                    return R.drawable.icon_level_11;
                case 12:
                    return R.drawable.icon_level_12;
                case 13:
                    return R.drawable.icon_level_13;
                case 14:
                    return R.drawable.icon_level_14;
                case 15:
                    return R.drawable.icon_level_15;
                case 16:
                    return R.drawable.icon_level_16;
                case 17:
                    return R.drawable.icon_level_17;
                case 18:
                    return R.drawable.icon_level_18;
                default:
                    return 0;
            }
        }
        return invokeI.intValue;
    }

    public static int getGradeResourceIdNew(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i)) == null) ? getGradeResourceIdInEnterForum(i) : invokeI.intValue;
    }

    public static Bitmap getLogoBitmap(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65555, null, context, i)) == null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                return BitmapFactory.decodeResource(context.getResources(), i, options);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap getNightCashBitmap(Resources resources, int i, int i2, BitmapFactory.Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{resources, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            SoftReference<Bitmap> softReference = mBitmapNightHash.get(i2);
            Bitmap bitmap = softReference != null ? softReference.get() : null;
            if (bitmap != null) {
                return bitmap;
            }
            try {
                bitmap = BitmapFactory.decodeResource(resources, i, options);
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
            }
            if (bitmap != null) {
                mBitmapNightHash.put(i2, new SoftReference<>(bitmap));
            }
            return bitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap getResBitmap(Context context, int i, BitmapFactory.Options options) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65559, null, context, i, options)) == null) {
            try {
                return BitmapFactory.decodeResource(context.getResources(), i, options);
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                return null;
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                return null;
            }
        }
        return (Bitmap) invokeLIL.objValue;
    }

    public static Bitmap getResBitmapPowerOf2Size(Context context, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65560, null, context, i)) == null) {
            Bitmap resBitmap = getResBitmap(context, i);
            int i3 = 0;
            if (resBitmap != null) {
                i3 = calcNearestSize(resBitmap.getWidth());
                i2 = calcNearestSize(resBitmap.getHeight());
            } else {
                i2 = 0;
            }
            return getResizedBitmap(resBitmap, i3, i2);
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Bitmap bitmap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65562, null, bitmap, i, i2)) == null) {
            Bitmap bitmap3 = null;
            if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
                int width = bitmap.getWidth();
                float f = i2;
                float height = bitmap.getHeight();
                float f2 = f / height;
                float f3 = i;
                float f4 = width;
                float f5 = f3 / f4;
                if (f2 < f5) {
                    f2 = f5;
                }
                synchronized (lockForSyncImageDecoder) {
                    Matrix matrix = new Matrix();
                    matrix.postScale(f2, f2);
                    matrix.postTranslate((f3 - (f4 * f2)) / 2.0f, (f - (height * f2)) / 2.0f);
                    try {
                        bitmap2 = Bitmap.createBitmap(i, i2, bitmap.getConfig());
                        try {
                            new Canvas(bitmap2).drawBitmap(bitmap, matrix, null);
                        } catch (NullPointerException unused) {
                            bitmap3 = bitmap2;
                            bitmap2 = bitmap3;
                            return bitmap2;
                        } catch (OutOfMemoryError unused2) {
                            bitmap3 = bitmap2;
                            TbadkCoreApplication.getInst().onAppMemoryLow();
                            bitmap2 = bitmap3;
                            return bitmap2;
                        }
                    } catch (NullPointerException unused3) {
                    } catch (OutOfMemoryError unused4) {
                    }
                }
                return bitmap2;
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static Bitmap getResizedBitmapFillCenter(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Bitmap createBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65564, null, bitmap, i, i2)) == null) {
            if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float f = i2 / height;
                float f2 = i / width;
                if (f > f2) {
                    f = f2;
                }
                synchronized (lockForSyncImageDecoder) {
                    Matrix matrix = new Matrix();
                    matrix.postScale(f, f);
                    createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                }
                return createBitmap;
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float f, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{bitmap, Float.valueOf(f), Boolean.valueOf(z)})) == null) {
            Bitmap bitmap2 = null;
            try {
                synchronized (lockForSyncImageDecoder) {
                    bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
                    Canvas canvas = new Canvas(bitmap2);
                    Paint paint = new Paint();
                    Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    RectF rectF = new RectF(rect);
                    paint.setAntiAlias(true);
                    canvas.drawARGB(0, 0, 0, 0);
                    paint.setColor(-12434878);
                    canvas.drawRoundRect(rectF, f, f, paint);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                    canvas.drawBitmap(bitmap, rect, rect, paint);
                }
                if (bitmap2 != bitmap && z) {
                    bitmap.recycle();
                }
            } catch (Throwable unused) {
            }
            return bitmap2;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static int getSmallGradeResourceIdNew(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65566, null, i)) == null) ? getGradeResourceIdInEnterForum(i) : invokeI.intValue;
    }

    public static Bitmap getSquareBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Bitmap createBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, bitmap)) == null) {
            if (bitmap == null) {
                return null;
            }
            synchronized (lockForSyncImageDecoder) {
                if (bitmap.getHeight() < bitmap.getWidth()) {
                    createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - bitmap.getHeight()) >> 1, 0, bitmap.getHeight(), bitmap.getHeight());
                } else {
                    createBitmap = bitmap.getHeight() > bitmap.getWidth() ? Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - bitmap.getWidth()) >> 1, bitmap.getWidth(), bitmap.getWidth()) : bitmap;
                }
                if (bitmap != createBitmap) {
                    bitmap.recycle();
                }
            }
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap getThemeCashBitmap(Resources resources, int i, int i2, BitmapFactory.Options options) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65569, null, new Object[]{resources, Integer.valueOf(i), Integer.valueOf(i2), options})) == null) {
            SoftReference<Bitmap> softReference = mBitmapThemeHash.get(i2);
            Bitmap bitmap = softReference != null ? softReference.get() : null;
            if (bitmap != null) {
                return bitmap;
            }
            try {
                bitmap = BitmapFactory.decodeResource(resources, i, options);
            } catch (OutOfMemoryError unused) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
            }
            if (bitmap != null) {
                mBitmapThemeHash.put(i2, new SoftReference<>(bitmap));
            }
            return bitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap loadBitmap(String str) {
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            inputStream = null;
            InterceptResult invokeL = interceptable.invokeL(65570, null, str);
            if (invokeL != null) {
                return (Bitmap) invokeL.objValue;
            }
        }
        if (str != null && str.length() > 0) {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            try {
                try {
                    synchronized (lockForSyncImageDecoder) {
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inPreferredConfig = TbConfig.BitmapConfig;
                            options.inJustDecodeBounds = false;
                            FileInputStream fileInputStream = new FileInputStream(file);
                            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
                            fj.e(fileInputStream);
                            return decodeStream;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = null;
                            try {
                                throw th;
                            } catch (Throwable unused) {
                                fj.e(inputStream);
                                return null;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable unused2) {
                inputStream = null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x006a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x006d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public static Bitmap loadResizedBitmap(String str, int i, int i2) {
        Interceptable interceptable;
        InterceptResult invokeLII;
        Interceptable interceptable2 = $ic;
        if (interceptable2 != null && (invokeLII = (interceptable = interceptable2).invokeLII(65572, null, str, i, i2)) != null) {
            return (Bitmap) invokeLII.objValue;
        }
        try {
            synchronized (lockForSyncImageDecoder) {
                try {
                    if (str != null) {
                        try {
                            if (str.length() > 0 && i > 0 && i2 > 0) {
                                File file = new File(str);
                                if (!file.exists()) {
                                    fj.e(null);
                                    return null;
                                }
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                int i3 = 1;
                                options.inJustDecodeBounds = true;
                                FileInputStream fileInputStream = new FileInputStream(file);
                                BitmapFactory.decodeStream(fileInputStream, null, options);
                                options.inPreferredConfig = TbConfig.BitmapConfig;
                                fj.e(fileInputStream);
                                while (true) {
                                    int i4 = i3 * 2;
                                    if (options.outWidth / i4 <= i && options.outHeight / i4 <= i2) {
                                        options.inJustDecodeBounds = false;
                                        options.inSampleSize = i3;
                                        FileInputStream fileInputStream2 = new FileInputStream(file);
                                        try {
                                            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options);
                                            fj.e(fileInputStream2);
                                            return decodeStream;
                                        } catch (Throwable th) {
                                            th = th;
                                            interceptable = fileInputStream2;
                                            try {
                                                throw th;
                                            } catch (Throwable unused) {
                                                fj.e(interceptable);
                                                return null;
                                            }
                                        }
                                    }
                                    i3 = i4;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            interceptable = 0;
                        }
                    }
                    fj.e(null);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable unused2) {
            interceptable = 0;
        }
    }

    public static int readPictureDegree(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, str)) == null) {
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
                if (attributeInt != 3) {
                    if (attributeInt != 6) {
                        return attributeInt != 8 ? 0 : 270;
                    }
                    return 90;
                }
                return 180;
            } catch (IOException unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static void removeCashBitmap(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65574, null, i) == null) {
            mBitmapHash.remove(i);
            mBitmapNightHash.remove(i);
            mBitmapThemeHash.remove(i);
        }
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Bitmap createBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65577, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            if ((bitmap.getWidth() > i || bitmap.getHeight() > i2) && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float f = i2 / height;
                float f2 = i / width;
                if (f > f2) {
                    f = f2;
                }
                synchronized (lockForSyncImageDecoder) {
                    Matrix matrix = new Matrix();
                    matrix.postScale(f, f);
                    createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                    if (createBitmap != bitmap && z) {
                        bitmap.recycle();
                    }
                }
                return createBitmap;
            }
            return bitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap resizeBitmapAbsolute(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65579, null, str, i)) == null) ? resizeBitmap(subSampleBitmapAbsolute(str, i), i) : (Bitmap) invokeLI.objValue;
    }

    public static Bitmap resizeBitmapAtLeast(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Bitmap createBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65580, null, bitmap, i, i2)) == null) {
            if (i < 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            if (i == 0 || i2 == 0 || ((i >= bitmap.getWidth() && i2 >= bitmap.getHeight()) || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0)) {
                return bitmap;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f = i / width;
            float f2 = i2 / height;
            if (f <= f2) {
                f = f2;
            }
            if (f >= 1.0f) {
                return bitmap;
            }
            synchronized (lockForSyncImageDecoder) {
                Matrix matrix = new Matrix();
                matrix.postScale(f, f);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                if (createBitmap != bitmap) {
                    bitmap.recycle();
                }
            }
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static Bitmap reversalBitmap(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Bitmap createBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65581, null, bitmap, i)) == null) {
            Matrix matrix = new Matrix();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i == 2) {
                matrix.setScale(1.0f, -1.0f);
            } else if (i == 3) {
                matrix.setScale(-1.0f, 1.0f);
            }
            synchronized (lockForSyncImageDecoder) {
                Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                matrix.setRotate(180.0f);
                createBitmap = Bitmap.createBitmap(createBitmap2, 0, 0, createBitmap2.getWidth(), createBitmap2.getHeight(), matrix, true);
                if (createBitmap2 != createBitmap) {
                    createBitmap2.recycle();
                }
                if (bitmap != createBitmap) {
                    bitmap.recycle();
                }
            }
            return createBitmap;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Bitmap bitmap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65582, null, bitmap, i)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            synchronized (lockForSyncImageDecoder) {
                Matrix matrix = new Matrix();
                if (i == 0) {
                    matrix.postRotate(-90.0f);
                } else if (i == 1) {
                    matrix.postRotate(90.0f);
                }
                try {
                    bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                } catch (OutOfMemoryError unused) {
                    bitmap2 = null;
                }
                if (bitmap2 == null) {
                    bitmap2 = bitmap;
                }
                if (bitmap != bitmap2) {
                    bitmap.recycle();
                }
            }
            return bitmap2;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap rotateBitmapBydegree(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Bitmap bitmap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65583, null, bitmap, i)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            synchronized (lockForSyncImageDecoder) {
                Matrix matrix = new Matrix();
                matrix.postRotate(i);
                try {
                    bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                } catch (Throwable unused) {
                    bitmap2 = null;
                }
                if (bitmap2 == null) {
                    bitmap2 = bitmap;
                }
                if (bitmap != bitmap2) {
                    bitmap.recycle();
                }
            }
            return bitmap2;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap subSampleBitmap(String str, int i) {
        InterceptResult invokeLI;
        Bitmap decodeStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65585, null, str, i)) == null) {
            if (str != null && str.length() > 0 && i > 0) {
                try {
                    synchronized (lockForSyncImageDecoder) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        int i2 = 1;
                        options.inJustDecodeBounds = true;
                        InputStream GetStreamFromFile = FileHelper.GetStreamFromFile(str);
                        BitmapFactory.decodeStream(GetStreamFromFile, null, options);
                        options.inPreferredConfig = TbConfig.BitmapConfig;
                        fj.e(GetStreamFromFile);
                        while (true) {
                            int i3 = i2 * 2;
                            if (options.outWidth / i3 <= i && options.outHeight / i3 <= i) {
                                options.inJustDecodeBounds = false;
                                options.inSampleSize = i2;
                                InputStream GetStreamFromFile2 = FileHelper.GetStreamFromFile(str);
                                decodeStream = BitmapFactory.decodeStream(GetStreamFromFile2, null, options);
                                fj.e(GetStreamFromFile2);
                            }
                            i2 = i3;
                        }
                    }
                    return decodeStream;
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap subSampleBitmapAbsolute(String str, int i) {
        InterceptResult invokeLI;
        Bitmap decodeStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65586, null, str, i)) == null) {
            if (str != null && str.length() > 0 && i > 0) {
                try {
                    synchronized (lockForSyncImageDecoder) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        int i2 = 1;
                        options.inJustDecodeBounds = true;
                        InputStream GetStreamFromFile = FileHelper.GetStreamFromFile(new File(str));
                        BitmapFactory.decodeStream(GetStreamFromFile, null, options);
                        options.inPreferredConfig = TbConfig.BitmapConfig;
                        fj.e(GetStreamFromFile);
                        while (true) {
                            int i3 = i2 * 2;
                            if (options.outWidth / i3 <= i && options.outHeight / i3 <= i) {
                                options.inJustDecodeBounds = false;
                                options.inSampleSize = i2;
                                InputStream GetStreamFromFile2 = FileHelper.GetStreamFromFile(new File(str));
                                decodeStream = BitmapFactory.decodeStream(GetStreamFromFile2, null, options);
                                fj.e(GetStreamFromFile2);
                            }
                            i2 = i3;
                        }
                    }
                    return decodeStream;
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap getResBitmap(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65558, null, context, i)) == null) ? getResBitmap(context, i, new BitmapFactory.Options()) : (Bitmap) invokeLI.objValue;
    }

    public static Bitmap getCashBitmap(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i)) == null) ? getCashBitmap(i, new BitmapFactory.Options()) : (Bitmap) invokeI.objValue;
    }

    public static Bitmap getNightCashBitmap(Resources resources, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65556, null, resources, i, i2)) == null) ? getNightCashBitmap(resources, i, i2, new BitmapFactory.Options()) : (Bitmap) invokeLII.objValue;
    }

    public static Bitmap getThemeCashBitmap(Resources resources, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65568, null, resources, i, i2)) == null) ? getThemeCashBitmap(resources, i, i2, new BitmapFactory.Options()) : (Bitmap) invokeLII.objValue;
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65576, null, bitmap, i)) == null) ? resizeBitmap(bitmap, i, i, true) : (Bitmap) invokeLI.objValue;
    }

    public static Bitmap loadBitmap(String str, BitmapFactory.Options options) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65571, null, str, options)) != null) {
            return (Bitmap) invokeLL.objValue;
        }
        try {
            synchronized (lockForSyncImageDecoder) {
                if (str != null) {
                    try {
                        if (str.length() > 0) {
                            File file = new File(str);
                            if (file.exists() && file.isFile()) {
                                if (options == null) {
                                    options = new BitmapFactory.Options();
                                }
                                options.inPreferredConfig = TbConfig.BitmapConfig;
                                options.inJustDecodeBounds = false;
                                FileInputStream fileInputStream2 = new FileInputStream(file);
                                try {
                                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options);
                                    fj.e(fileInputStream2);
                                    return decodeStream;
                                } catch (Throwable th) {
                                    fileInputStream = fileInputStream2;
                                    th = th;
                                    while (true) {
                                        try {
                                            try {
                                                break;
                                            } catch (Throwable unused) {
                                                fj.e(fileInputStream);
                                                return null;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    }
                                    throw th;
                                }
                            }
                            fj.e(null);
                            return null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                    }
                }
                fj.e(null);
                return null;
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
    }

    public static Bitmap resizeBitmap(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65578, null, str, i)) == null) ? resizeBitmap(subSampleBitmap(str, i), i) : (Bitmap) invokeLI.objValue;
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Bitmap createBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i <= 0 || i2 < 0 || bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            if (z) {
                if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
                    return bitmap;
                }
            } else if (bitmap.getWidth() <= i && bitmap.getHeight() <= i2) {
                return bitmap;
            }
            int width = bitmap.getWidth();
            float f = i2;
            float height = bitmap.getHeight();
            float f2 = f / height;
            float f3 = i;
            float f4 = width;
            float f5 = f3 / f4;
            if (f2 < f5) {
                f2 = f5;
            }
            synchronized (lockForSyncImageDecoder) {
                Matrix matrix = new Matrix();
                matrix.postScale(f2, f2);
                matrix.postTranslate((f3 - (f4 * f2)) / 2.0f, (f - (height * f2)) / 2.0f);
                createBitmap = Bitmap.createBitmap(i, i2, bitmap.getConfig());
                new Canvas(createBitmap).drawBitmap(bitmap, matrix, null);
            }
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap resizeBitmap(Context context, Uri uri, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65575, null, context, uri, i)) == null) ? resizeBitmap(subSampleBitmap(context, uri, i), i) : (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap subSampleBitmap(Context context, Uri uri, int i) {
        InterceptResult invokeLLI;
        ParcelFileDescriptor parcelFileDescriptor;
        Bitmap decodeFileDescriptor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65584, null, context, uri, i)) == null) {
            try {
                parcelFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            } catch (Throwable unused) {
                parcelFileDescriptor = null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inDither = false;
                int i2 = 1;
                options.inJustDecodeBounds = true;
                synchronized (lockForSyncImageDecoder) {
                    BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                    while (true) {
                        int i3 = i2 + 1;
                        if (options.outWidth / i3 <= i && options.outHeight / i3 <= i) {
                            options.inJustDecodeBounds = false;
                            options.inSampleSize = i2;
                            decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor(), null, options);
                        }
                        i2 = i3;
                    }
                }
                return decodeFileDescriptor;
            } catch (Throwable unused2) {
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            }
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65561, null, bitmap, i)) == null) ? getResizedBitmap(bitmap, i, i) : (Bitmap) invokeLI.objValue;
    }
}
