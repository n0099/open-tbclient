package com.baidu.minivideo.plugin.capture.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BitmapUtils {
    public static /* synthetic */ Interceptable $ic;
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

    public static Bitmap cropBitmapLeft(Bitmap bitmap, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bitmap, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, i, bitmap.getHeight());
            if (z && bitmap != null && !bitmap.equals(createBitmap) && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap scaleCover(Bitmap bitmap, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (i > 0) {
                if ((i2 > 0 || bitmap != null) && !bitmap.isRecycled()) {
                    if ((bitmap.getWidth() > bitmap.getHeight()) != (i > i2)) {
                        i2 = i;
                        i = i2;
                    }
                    return (i == bitmap.getWidth() && i2 == bitmap.getHeight()) ? bitmap : scaleImage(bitmap, i, i2, z);
                }
                return bitmap;
            }
            return bitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap scaleImage(Bitmap bitmap, int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(i / width, i2 / height);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            if (z && bitmap != null && !bitmap.equals(createBitmap)) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap cropBitmapLeft(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i, i2, i3, i4);
            if (z && bitmap != null && !bitmap.equals(createBitmap) && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }
}
