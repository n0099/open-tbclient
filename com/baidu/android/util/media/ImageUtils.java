package com.baidu.android.util.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.util.bitmap.BitmapUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;
@Deprecated
/* loaded from: classes6.dex */
public final class ImageUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final long DEFAULT_MAX_PIXELS = 131072;
    public static final int QUALITY = 100;
    public static final int ROTATE_0 = 0;
    public static final int ROTATE_180 = 180;
    public static final int ROTATE_270 = 270;
    public static final int ROTATE_90 = 90;
    public static final String TAG = "ImageUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public ImageUtils() {
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

    @Deprecated
    public static Bitmap base64ToImg(String str, BitmapFactory.Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, options)) == null) ? BitmapUtils.fromBase64(str, options) : (Bitmap) invokeLL.objValue;
    }

    @Deprecated
    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bitmap)) == null) ? BitmapUtils.toBytes(bitmap) : (byte[]) invokeL.objValue;
    }

    @Deprecated
    public static int calculateInSampleSize(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(65539, null, i2, i3, i4, i5)) == null) ? BitmapUtils.calculateInSampleSize(i2, i3, i4, i5) : invokeIIII.intValue;
    }

    @Deprecated
    public static Bitmap captureViewSnapshot(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view)) == null) ? BitmapUtils.captureViewSnapshot(view) : (Bitmap) invokeL.objValue;
    }

    @Deprecated
    public static int computeInitialSampleSize(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.AD_TEXT_ID, null, options, i2, i3)) == null) {
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

    @Deprecated
    public static int computeSampleSize(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, options, i2, i3)) == null) {
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

    @Deprecated
    public static boolean createAbsoluteDir(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) {
            if (file.getParentFile().exists()) {
                return true;
            }
            return file.getParentFile().mkdirs();
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static Bitmap createBitmap(int i2, int i3, int i4, int i5, String str, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Integer.valueOf(i6)})) == null) ? BitmapUtils.createTextInCenter(i2, i3, i4, i5, str, i6) : (Bitmap) invokeCommon.objValue;
    }

    @Deprecated
    public static Bitmap createBitmapInNotify(int i2, int i3, int i4, int i5, String str, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str, Integer.valueOf(i6)})) == null) ? createBitmap(i2, i3, i4, i5, str, i6) : (Bitmap) invokeCommon.objValue;
    }

    @Deprecated
    public static Bitmap decodeBitmapFromString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? BitmapUtils.fromBase64(str) : (Bitmap) invokeL.objValue;
    }

    @Deprecated
    public static int decodeImageDegree(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (str == null) {
                return 0;
            }
            try {
                int attributeInt = new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
                if (attributeInt != 3) {
                    if (attributeInt != 6) {
                        return attributeInt != 8 ? 0 : 270;
                    }
                    return 90;
                }
                return 180;
            } catch (IOException e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static Bitmap drawableToBitmap(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, drawable)) == null) ? BitmapUtils.fromDrawable(drawable) : (Bitmap) invokeL.objValue;
    }

    @Deprecated
    public static Bitmap duplicateBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, bitmap)) == null) ? BitmapUtils.duplicate(bitmap) : (Bitmap) invokeL.objValue;
    }

    public static String encodeBitmapAsString(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, bitmap)) == null) {
            if (bitmap == null) {
                return "";
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static int getAppropriateSampleSize(InputStream inputStream, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65552, null, inputStream, i2, i3)) == null) {
            if (inputStream == null) {
                return 1;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream, null, options);
                if (options.outHeight <= 0 || options.outWidth <= 0) {
                    return 1;
                }
                return computeSampleSize(options, i2, i3);
            } catch (Exception | OutOfMemoryError e2) {
                e2.printStackTrace();
                return 1;
            }
        }
        return invokeLII.intValue;
    }

    @Deprecated
    public static String getBase64ImageFromBitmap(Bitmap bitmap, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65554, null, bitmap, j)) == null) {
            if (bitmap == null) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width <= 0 || height <= 0) {
                return null;
            }
            while (width * height > j) {
                width = (int) (width / 1.2d);
                height = (int) (height / 1.2d);
            }
            return getBase64ImageFromBitmap(Bitmap.createScaledBitmap(bitmap, width, height, true));
        }
        return (String) invokeLJ.objValue;
    }

    @Deprecated
    public static Bitmap getBitmapFromNet(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        InputStream byteStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65555, null, context, i2, str)) == null) {
            Bitmap bitmap = null;
            try {
                Response executeSync = HttpManager.getDefault(context).getRequest().url(str).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null && (byteStream = executeSync.body().byteStream()) != null) {
                    try {
                        System.currentTimeMillis();
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = i2;
                        bitmap = BitmapFactory.decodeStream(byteStream, null, options);
                        System.currentTimeMillis();
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                    Closeables.closeSafely(byteStream);
                }
            } catch (IOException | IllegalStateException | Exception unused) {
            }
            return bitmap;
        }
        return (Bitmap) invokeLIL.objValue;
    }

    @Deprecated
    public static Bitmap getCenterCropBitmap(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65556, null, bitmap, i2, i3)) == null) ? BitmapUtils.clipCenterCrop(bitmap, i2, i3) : (Bitmap) invokeLII.objValue;
    }

    @Deprecated
    public static Bitmap getSizedBitmap(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65557, null, bitmap, i2, i3)) == null) ? BitmapUtils.scale(bitmap, i2, i3) : (Bitmap) invokeLII.objValue;
    }

    @Deprecated
    public static String imgToBase64(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, bitmap)) == null) ? imgToBase64(bitmap, 100) : (String) invokeL.objValue;
    }

    @Deprecated
    public static Bitmap loadBitmapFromSDCard(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) ? BitmapUtils.loadFile(str) : (Bitmap) invokeL.objValue;
    }

    @Deprecated
    public static Bitmap reduceBitmap(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65563, null, bitmap, i2, i3)) == null) ? BitmapUtils.scale(bitmap, i2, i3, true) : (Bitmap) invokeLII.objValue;
    }

    @Deprecated
    public static boolean saveBitmap(Bitmap bitmap, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, bitmap, str)) == null) ? saveBitmap(bitmap, str, 100) : invokeLL.booleanValue;
    }

    @Deprecated
    public static void saveBitmapToFile(Bitmap bitmap, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, bitmap, file) == null) {
            BitmapUtils.saveJPEG(bitmap, file);
        }
    }

    @Deprecated
    public static Bitmap drawableToBitmap(Drawable drawable, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65549, null, drawable, i2, i3)) == null) ? BitmapUtils.fromDrawable(drawable, i2, i3) : (Bitmap) invokeLII.objValue;
    }

    @Deprecated
    public static Bitmap getSizedBitmap(Bitmap bitmap, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{bitmap, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) ? BitmapUtils.scale(bitmap, i2, i3, z) : (Bitmap) invokeCommon.objValue;
    }

    @Deprecated
    public static String imgToBase64(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65560, null, bitmap, i2)) == null) ? BitmapUtils.toBase64(bitmap, i2) : (String) invokeLI.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0080: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:38:0x0080 */
    @Deprecated
    public static Bitmap loadBitmapFromSDCard(String str, int i2, int i3) {
        InterceptResult invokeLII;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLII = interceptable.invokeLII(65562, null, str, i2, i3)) != null) {
            return (Bitmap) invokeLII.objValue;
        }
        File file = new File(str);
        FileInputStream fileInputStream3 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = getAppropriateSampleSize(fileInputStream, i2, i3);
                    Closeables.closeSafely(fileInputStream);
                    FileInputStream fileInputStream4 = new FileInputStream(file);
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream4, null, options);
                        int decodeImageDegree = decodeImageDegree(str);
                        if (decodeStream == null || !(decodeImageDegree == 90 || decodeImageDegree == 270)) {
                            Closeables.closeSafely(fileInputStream4);
                            return decodeStream;
                        }
                        Matrix matrix = new Matrix();
                        matrix.setRotate(decodeImageDegree, decodeStream.getWidth() / 2.0f, decodeStream.getHeight() / 2.0f);
                        Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
                        decodeStream.recycle();
                        Closeables.closeSafely(fileInputStream4);
                        return createBitmap;
                    } catch (IOException e2) {
                        e = e2;
                        fileInputStream = fileInputStream4;
                        e.printStackTrace();
                        Closeables.closeSafely(fileInputStream);
                        return null;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        fileInputStream = fileInputStream4;
                        e.printStackTrace();
                        Closeables.closeSafely(fileInputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream3 = fileInputStream4;
                        Closeables.closeSafely(fileInputStream3);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                } catch (OutOfMemoryError e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream3 = fileInputStream2;
            }
        } catch (IOException e6) {
            e = e6;
            fileInputStream = null;
            e.printStackTrace();
            Closeables.closeSafely(fileInputStream);
            return null;
        } catch (OutOfMemoryError e7) {
            e = e7;
            fileInputStream = null;
            e.printStackTrace();
            Closeables.closeSafely(fileInputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Deprecated
    public static boolean saveBitmap(Bitmap bitmap, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65565, null, bitmap, str, i2)) == null) ? saveBitmap(bitmap, str, i2, Bitmap.CompressFormat.JPEG) : invokeLLI.booleanValue;
    }

    @Deprecated
    public static boolean saveBitmap(Bitmap bitmap, String str, int i2, Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65566, null, bitmap, str, i2, compressFormat)) == null) ? BitmapUtils.save(bitmap, str, i2, compressFormat) : invokeLLIL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
        if (r1 == null) goto L5;
     */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getBase64ImageFromBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, bitmap)) == null) {
            String str = null;
            str = null;
            str = null;
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            if (bitmap != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                    } catch (OutOfMemoryError unused) {
                    } catch (Throwable th) {
                        th = th;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (OutOfMemoryError unused3) {
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
