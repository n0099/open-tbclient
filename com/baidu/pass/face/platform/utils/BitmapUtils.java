package com.baidu.pass.face.platform.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.model.BDFaceImageInstance;
import com.baidu.pass.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class BitmapUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IMAGEBOUND = 128;
    public static final int MAXLENTH = 1024;
    public static final int PIC_COMPRESS_SIZE = 4;
    public static final int QUALITY = 100;
    public static final int ROTATE0 = 0;
    public static final int ROTATE180 = 180;
    public static final int ROTATE270 = 270;
    public static final int ROTATE360 = 360;
    public static final int ROTATE90 = 90;
    public static final String TAG = "ImageUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public BitmapUtils() {
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

    public static Bitmap BGR2Bitmap(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, bArr, i2, i3)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            int i4 = i2 * i3;
            byte[] bArr2 = new byte[i4 * 4];
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 * 3;
                byte b2 = bArr[i6 + 0];
                byte b3 = bArr[i6 + 1];
                int i7 = i5 * 4;
                bArr2[i7 + 0] = bArr[i6 + 2];
                bArr2[i7 + 1] = b3;
                bArr2[i7 + 2] = b2;
                bArr2[i7 + 3] = -1;
            }
            createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr2));
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static Bitmap Depth2Bitmap(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, bArr, i2, i3)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            int i4 = i2 * i3;
            int[] iArr = new int[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i5 * 2;
                int i7 = i6 + 1;
                iArr[i5] = ((((bArr[i6] + (bArr[i7] * 256)) / 10) & 255) << 16) | (((bArr[i6] + (bArr[i7] * 256)) / 10) & 255) | ((((bArr[i6] + (bArr[i7] * 256)) / 10) & 255) << 8) | (-16777216);
            }
            createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static byte[] bitmapCompress(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65539, null, bitmap, i2)) != null) {
            return (byte[]) invokeLI.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return byteArray;
            } catch (Exception unused) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String bitmapToJpegBase64(Bitmap bitmap, int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bitmap, Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            try {
                float max = f2 / Math.max(bitmap.getWidth(), bitmap.getHeight());
                if (max < 1.0f) {
                    bitmap = scale(bitmap, max);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return Base64Utils.encodeToString(byteArray, 2);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static Bitmap calculateInSampleSize(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.AD_TEXT_ID, null, bitmap, i2, i3)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (height > i3 || width > i2) {
                float f2 = i3 / height;
                float f3 = i2 / width;
                if (f2 >= f3) {
                    f2 = f3;
                }
                return scale(bitmap, f2);
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static int computeInitialSampleSize(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, options, i2, i3)) == null) {
            double d2 = options.outWidth;
            double d3 = options.outHeight;
            int ceil = i3 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d2 * d3) / i3));
            if (i2 == -1) {
                min = 128;
            } else {
                double d4 = i2;
                min = (int) Math.min(Math.floor(d2 / d4), Math.floor(d3 / d4));
            }
            if (min < ceil) {
                return ceil;
            }
            if (i3 == -1 && i2 == -1) {
                return 1;
            }
            return i2 == -1 ? ceil : min;
        }
        return invokeLII.intValue;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, options, i2, i3)) == null) {
            int computeInitialSampleSize = computeInitialSampleSize(options, i2, i3);
            if (computeInitialSampleSize <= 8) {
                int i4 = 1;
                while (i4 < computeInitialSampleSize) {
                    i4 <<= 1;
                }
                return i4;
            }
            return ((computeInitialSampleSize + 7) / 8) * 8;
        }
        return invokeLII.intValue;
    }

    public static Bitmap createBitmap(Context context, byte[] bArr, float f2) {
        InterceptResult invokeCommon;
        Bitmap rotateBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, bArr, Float.valueOf(f2)})) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            Bitmap bitmap = null;
            try {
                int min = Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                options.inSampleSize = computeSampleSize(options, min, 1048576);
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                rotateBitmap = rotateBitmap(f2, bitmap);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                rotateBitmap = rotateBitmap(f2, bitmap);
            }
            if (rotateBitmap != bitmap && bitmap != null) {
                bitmap.recycle();
            }
            return rotateBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static int decodeImageDegree(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
                if (attributeInt != 3) {
                    if (attributeInt != 6) {
                        return attributeInt != 8 ? 0 : 270;
                    }
                    return 90;
                }
                return 180;
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static Bitmap getInstaceBmp(BDFaceImageInstance bDFaceImageInstance) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bDFaceImageInstance)) == null) {
            BDFaceSDKCommon.BDFaceImageType bDFaceImageType = bDFaceImageInstance.imageType;
            if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_RGBA) {
                Bitmap createBitmap = Bitmap.createBitmap(bDFaceImageInstance.width, bDFaceImageInstance.height, Bitmap.Config.ARGB_8888);
                createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bDFaceImageInstance.data));
                return createBitmap;
            } else if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_BGR) {
                return BGR2Bitmap(bDFaceImageInstance.data, bDFaceImageInstance.width, bDFaceImageInstance.height);
            } else {
                if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21) {
                    return yuv2Bitmap(bDFaceImageInstance.data, bDFaceImageInstance.width, bDFaceImageInstance.height);
                }
                if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_GRAY) {
                    return Depth2Bitmap(bDFaceImageInstance.data, bDFaceImageInstance.width, bDFaceImageInstance.height);
                }
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap rotateBitmap(float f2, Bitmap bitmap) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Float.valueOf(f2), bitmap})) == null) {
            Matrix matrix = new Matrix();
            if (f2 == 0.0f) {
                return bitmap;
            }
            matrix.setRotate(f2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static boolean saveBitmap(File file, Bitmap bitmap) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, file, bitmap)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e2) {
                e = e2;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                try {
                    fileOutputStream.close();
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return true;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                        return false;
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        return false;
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public static Bitmap scale(Bitmap bitmap, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65552, null, bitmap, f2)) == null) {
            Matrix matrix = new Matrix();
            matrix.postScale(f2, f2);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap != null) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return (Bitmap) invokeLF.objValue;
    }

    public static Bitmap yuv2Bitmap(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65554, null, bArr, i2, i3)) == null) {
            int i4 = i2 * i3;
            int[] iArr = new int[i4];
            for (int i5 = 0; i5 < i3; i5++) {
                for (int i6 = 0; i6 < i2; i6++) {
                    int i7 = (i5 * i2) + i6;
                    int i8 = 255;
                    int i9 = bArr[i7] & 255;
                    int i10 = ((i5 >> 1) * i2) + i4 + (i6 & (-2));
                    int i11 = bArr[i10 + 0] & 255;
                    int i12 = bArr[i10 + 1] & 255;
                    if (i9 < 16) {
                        i9 = 16;
                    }
                    float f2 = (i9 - 16) * 1.164f;
                    float f3 = i12 + a.f36021g;
                    int round = Math.round((1.596f * f3) + f2);
                    float f4 = i11 + a.f36021g;
                    int round2 = Math.round((f2 - (f3 * 0.813f)) - (0.391f * f4));
                    int round3 = Math.round(f2 + (f4 * 2.018f));
                    if (round < 0) {
                        round = 0;
                    } else if (round > 255) {
                        round = 255;
                    }
                    if (round2 < 0) {
                        round2 = 0;
                    } else if (round2 > 255) {
                        round2 = 255;
                    }
                    if (round3 < 0) {
                        i8 = 0;
                    } else if (round3 <= 255) {
                        i8 = round3;
                    }
                    iArr[i7] = ((i8 << 16) - 16777216) + (round2 << 8) + round;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
            return createBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static Bitmap scale(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65553, null, bitmap, i2, i3)) == null) {
            if (bitmap == null) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(i2 / width, i3 / height);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static Bitmap createBitmap(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Bitmap rotateBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, context, str, i2)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            Bitmap bitmap = null;
            try {
                int min = Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inSampleSize = computeSampleSize(options, min, 1048576);
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeFile(str, options);
                rotateBitmap = rotateBitmap(i2, bitmap);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                if (bitmap != null) {
                    bitmap.recycle();
                }
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeFile(str, options);
                rotateBitmap = rotateBitmap(i2, bitmap);
            }
            if (rotateBitmap != bitmap && bitmap != null) {
                bitmap.recycle();
            }
            return rotateBitmap;
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap createBitmap(Context context, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Bitmap rotateBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65547, null, context, bArr, i2)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            Bitmap bitmap = null;
            try {
                Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                rotateBitmap = rotateBitmap(i2, bitmap);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                if (bitmap != null) {
                    bitmap.recycle();
                }
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                rotateBitmap = rotateBitmap(i2, bitmap);
            }
            if (rotateBitmap != bitmap && bitmap != null) {
                bitmap.recycle();
            }
            return rotateBitmap;
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap createBitmap(Context context, int i2, int i3, int[] iArr) {
        InterceptResult invokeCommon;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), iArr})) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            try {
                Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
                options.inJustDecodeBounds = false;
                bitmap = Bitmap.createBitmap(iArr, i2, i3, Bitmap.Config.RGB_565);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                bitmap = null;
            }
            if (bitmap != null && bitmap != null) {
                bitmap.recycle();
            }
            return null;
        }
        return (Bitmap) invokeCommon.objValue;
    }
}
