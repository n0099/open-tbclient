package com.baidu.android.util.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.PathUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public final class BitmapUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int QUALITY = 100;
    public static final String TAG = "ImageUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public BitmapUtils() {
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

    public static int calculateInSampleSize(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65537, null, i, i2, i3, i4)) == null) {
            int i5 = 1;
            if (i2 > i4 || i > i3) {
                int i6 = i2 / 2;
                int i7 = i / 2;
                while (i6 / i5 > i4 && i7 / i5 > i3) {
                    i5 *= 2;
                }
            }
            return i5;
        }
        return invokeIIII.intValue;
    }

    public static boolean save(Bitmap bitmap, String str, int i, Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65551, null, bitmap, str, i, compressFormat)) == null) {
            if (bitmap != null && !TextUtils.isEmpty(str)) {
                return save(bitmap, new File(str), i, compressFormat);
            }
            return false;
        }
        return invokeLLIL.booleanValue;
    }

    public static Bitmap captureViewSnapshot(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            if (view2 != null && view2.getWidth() > 0 && view2.getHeight() > 0) {
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    int save = canvas.save();
                    view2.draw(canvas);
                    canvas.restoreToCount(save);
                    return createBitmap;
                } catch (Exception | OutOfMemoryError unused) {
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap duplicate(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bitmap)) == null) {
            if (bitmap == null) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width == 0 || height == 0) {
                return null;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                if (createBitmap != null) {
                    Canvas canvas = new Canvas(createBitmap);
                    Rect rect = new Rect(0, 0, width, height);
                    canvas.drawBitmap(bitmap, rect, rect, (Paint) null);
                }
                return createBitmap;
            } catch (Exception | OutOfMemoryError e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap clipCenterCrop(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bitmap, i, i2)) == null) {
            if (bitmap == null) {
                return null;
            }
            int max = Math.max((bitmap.getWidth() - i) / 2, 0);
            int max2 = Math.max((bitmap.getHeight() - i2) / 2, 0);
            if (max == 0) {
                i = bitmap.getWidth();
            }
            int i3 = i;
            if (max2 == 0) {
                i2 = bitmap.getHeight();
            }
            return Bitmap.createBitmap(bitmap, max, max2, i3, i2, new Matrix(), true);
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static boolean createAbsoluteDir(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            if (!file.getParentFile().exists()) {
                return file.getParentFile().mkdirs();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Bitmap fromBase64(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return fromBase64(str, null);
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap fromDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, drawable)) == null) {
            if (drawable == null) {
                return null;
            }
            return fromDrawable(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap loadFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, file)) == null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, new BitmapFactory.Options());
                Closeables.closeSafely(fileInputStream);
                return decodeStream;
            } catch (IOException | OutOfMemoryError e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static String toBase64(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, bitmap)) == null) {
            return toBase64(bitmap, 100);
        }
        return (String) invokeL.objValue;
    }

    public static byte[] toBytes(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bitmap)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } finally {
                Closeables.closeSafely(byteArrayOutputStream);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static Bitmap createTextInCenter(int i, int i2, int i3, int i4, String str, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(i5)})) == null) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.translate(0.0f, 0.0f);
                Paint paint = new Paint();
                paint.setColor(i4);
                Paint paint2 = new Paint(32);
                paint2.setTextSize(i5);
                paint2.setColor(AppRuntime.getAppContext().getResources().getColor(i3));
                Rect rect = new Rect(0, 0, i, i2);
                canvas.drawRect(rect, paint);
                drawText(canvas, paint2, rect, str);
                return createBitmap;
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static void drawText(Canvas canvas, Paint paint, Rect rect, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65542, null, canvas, paint, rect, str) == null) && !TextUtils.isEmpty(str) && rect != null && !rect.isEmpty()) {
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            int height = rect.height();
            float f = fontMetrics.bottom;
            int i = rect.top + ((int) (((height + ((int) (f - fontMetrics.top))) / 2) - f));
            int width = rect.left + ((int) ((rect.width() - paint.measureText(str)) / 2.0f));
            int save = canvas.save();
            canvas.clipRect(rect);
            canvas.drawText(str, 0, str.length(), width, i, paint);
            canvas.restoreToCount(save);
        }
    }

    public static boolean save(Bitmap bitmap, File file, int i, Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65550, null, bitmap, file, i, compressFormat)) == null) {
            boolean z = false;
            if (bitmap != null && file != null && !file.isDirectory()) {
                if (compressFormat == null) {
                    compressFormat = Bitmap.CompressFormat.JPEG;
                }
                if (PathUtils.isExternalStorageWritable()) {
                    FileOutputStream fileOutputStream = null;
                    try {
                        if (!createAbsoluteDir(file)) {
                            Closeables.closeSafely((Closeable) null);
                            return false;
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            z = bitmap.compress(compressFormat, i, fileOutputStream2);
                            Closeables.closeSafely(fileOutputStream2);
                        } catch (FileNotFoundException unused) {
                            fileOutputStream = fileOutputStream2;
                            Closeables.closeSafely(fileOutputStream);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            Closeables.closeSafely(fileOutputStream);
                            throw th;
                        }
                    } catch (FileNotFoundException unused2) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            return z;
        }
        return invokeLLIL.booleanValue;
    }

    public static Bitmap fromBase64(String str, BitmapFactory.Options options) {
        InterceptResult invokeLL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, options)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                bArr = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                bArr = null;
            }
            if (bArr != null) {
                try {
                    return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static Bitmap fromDrawable(Drawable drawable, int i, int i2) {
        InterceptResult invokeLII;
        Bitmap.Config config;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65547, null, drawable, i, i2)) == null) {
            Bitmap bitmap = null;
            if (drawable != null && i > 0 && i2 > 0) {
                if (drawable.getOpacity() != -1) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                try {
                    bitmap = Bitmap.createBitmap(i, i2, config);
                    if (bitmap != null) {
                        Canvas canvas = new Canvas(bitmap);
                        drawable.setBounds(0, 0, i, i2);
                        drawable.draw(canvas);
                    }
                } catch (Exception | OutOfMemoryError e) {
                    e.printStackTrace();
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static Bitmap loadFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return loadFile(new File(str));
        }
        return (Bitmap) invokeL.objValue;
    }

    public static boolean saveJPEG(Bitmap bitmap, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, bitmap, file)) == null) {
            return save(bitmap, file, 100, Bitmap.CompressFormat.JPEG);
        }
        return invokeLL.booleanValue;
    }

    public static boolean saveJPEG(Bitmap bitmap, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, bitmap, str)) == null) {
            if (bitmap != null && !TextUtils.isEmpty(str)) {
                return save(bitmap, new File(str), 100, Bitmap.CompressFormat.JPEG);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Bitmap scale(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65554, null, bitmap, i, i2)) == null) {
            if (bitmap != null && i > 0 && i2 > 0) {
                try {
                    return Bitmap.createScaledBitmap(bitmap, i, i2, true);
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static Bitmap scale(Bitmap bitmap, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (bitmap != null && i > 0 && i2 > 0) {
                try {
                    float width = bitmap.getWidth();
                    float height = bitmap.getHeight();
                    float f = i;
                    float f2 = i2;
                    float min = Math.min(f / width, f2 / height);
                    if (z) {
                        f = min * width;
                    }
                    if (z) {
                        f2 = min * height;
                    }
                    return Bitmap.createScaledBitmap(bitmap, (int) f, (int) f2, true);
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace();
                }
            }
            return bitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static String toBase64(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, bitmap, i)) == null) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            if (bitmap == null) {
                return null;
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                    try {
                        byteArrayOutputStream.flush();
                        Closeables.closeSafely(byteArrayOutputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return encodeToString;
                } catch (Exception unused) {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.flush();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    }
                    Closeables.closeSafely(byteArrayOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.flush();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            throw th;
                        }
                    }
                    Closeables.closeSafely(byteArrayOutputStream2);
                    throw th;
                }
            } catch (Exception unused2) {
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (String) invokeLI.objValue;
        }
    }
}
