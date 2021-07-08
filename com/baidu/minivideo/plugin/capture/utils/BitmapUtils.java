package com.baidu.minivideo.plugin.capture.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BitmapUtils {
    public static /* synthetic */ Interceptable $ic;
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

    public static Bitmap cropBitmapLeft(Bitmap bitmap, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bitmap, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, i2, bitmap.getHeight());
            if (z && bitmap != null && !bitmap.equals(createBitmap) && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap scaleCover(Bitmap bitmap, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{bitmap, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (i2 > 0) {
                if ((i3 > 0 || bitmap != null) && !bitmap.isRecycled()) {
                    if ((bitmap.getWidth() > bitmap.getHeight()) != (i2 > i3)) {
                        i3 = i2;
                        i2 = i3;
                    }
                    return (i2 == bitmap.getWidth() && i3 == bitmap.getHeight()) ? bitmap : scaleImage(bitmap, i2, i3, z);
                }
                return bitmap;
            }
            return bitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static Bitmap scaleImage(Bitmap bitmap, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bitmap, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
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

    public static Bitmap cropBitmapLeft(Bitmap bitmap, int i2, int i3, int i4, int i5, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bitmap, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)})) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i2, i3, i4, i5);
            if (z && bitmap != null && !bitmap.equals(createBitmap) && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            return createBitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }
}
