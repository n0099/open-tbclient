package c.a.w0.t;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (w.a(str)) {
                return null;
            }
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        }
        return (Bitmap) invokeL.objValue;
    }

    public static int b(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, options, i2, i3)) == null) {
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            int i6 = 1;
            if (i4 > i3 || i5 > i2) {
                int i7 = i4 / 2;
                int i8 = i5 / 2;
                while (i7 / i6 > i3 && i8 / i6 > i2) {
                    i6 *= 2;
                }
            }
            return i6;
        }
        return invokeLII.intValue;
    }

    public static Bitmap c(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, bitmap, compressFormat, i2)) == null) {
            if (bitmap == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(compressFormat, i2, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
        return (Bitmap) invokeLLI.objValue;
    }

    public static Bitmap d(Bitmap bitmap, int i2, int i3, int i4, int i5, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bitmap, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)})) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i2, i3, i4, i5);
            if (z && bitmap != null && !bitmap.equals(createBitmap) && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap e(String str, int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) {
            if (FileUtils.isExists(str)) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inSampleSize = b(options, i2, i3);
                options.inJustDecodeBounds = false;
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                if (f2 % 360.0f == 0.0f) {
                    return decodeFile;
                }
                if (decodeFile == null) {
                    return null;
                }
                Matrix matrix = new Matrix();
                matrix.postRotate(f2);
                Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                decodeFile.recycle();
                return createBitmap;
            }
            return null;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap f(String str) {
        FileInputStream fileInputStream;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                fileInputStream = null;
            }
            return BitmapFactory.decodeStream(fileInputStream);
        }
        return (Bitmap) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap g(Bitmap bitmap, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{bitmap, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width == 0 || height == 0 || i2 == 0 || i3 == 0) {
                return bitmap;
            }
            float f2 = width;
            float f3 = height;
            float f4 = (f2 * 1.0f) / f3;
            float f5 = i2 * 1.0f;
            float f6 = i3;
            float f7 = f5 / f6;
            if (Math.abs(f4 - f7) < 0.01d) {
                i5 = width;
            } else if (f4 > f7) {
                i5 = (i2 * height) / i3;
            } else {
                i4 = (i3 * width) / i2;
                i5 = width;
                int i6 = width <= i5 ? (width - i5) / 2 : 0;
                int i7 = height <= i4 ? (height - i4) / 2 : 0;
                Matrix matrix = new Matrix();
                matrix.postScale(f5 / f2, (f6 * 1.0f) / f3);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, i6, i7, i5, i4, matrix, true);
                if (z && bitmap != null && !bitmap.equals(createBitmap)) {
                    bitmap.recycle();
                }
                return createBitmap;
            }
            i4 = height;
            if (width <= i5) {
            }
            if (height <= i4) {
            }
            Matrix matrix2 = new Matrix();
            matrix2.postScale(f5 / f2, (f6 * 1.0f) / f3);
            Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, i6, i7, i5, i4, matrix2, true);
            if (z) {
                bitmap.recycle();
            }
            return createBitmap2;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap h(Bitmap bitmap, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{bitmap, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (i2 <= 0 || i3 <= 0 || bitmap == null || bitmap.isRecycled()) {
                return bitmap;
            }
            if ((bitmap.getWidth() > bitmap.getHeight()) != (i2 > i3)) {
                i3 = i2;
                i2 = i3;
            }
            return (i2 == bitmap.getWidth() && i3 == bitmap.getHeight()) ? bitmap : i(bitmap, i2, i3, z);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap i(Bitmap bitmap, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{bitmap, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(i2 / width, i3 / height);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            if (z && bitmap != null && !bitmap.equals(createBitmap)) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }
}
