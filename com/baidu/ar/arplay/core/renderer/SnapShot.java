package com.baidu.ar.arplay.core.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SnapShot {
    public static /* synthetic */ Interceptable $ic;
    public static Bitmap mCaptureScreenBmp;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(492241921, "Lcom/baidu/ar/arplay/core/renderer/SnapShot;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(492241921, "Lcom/baidu/ar/arplay/core/renderer/SnapShot;");
        }
    }

    public SnapShot() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void destroyCache() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (bitmap = mCaptureScreenBmp) == null) {
            return;
        }
        bitmap.recycle();
        mCaptureScreenBmp = null;
    }

    public static Bitmap getCacheBitmap(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            Bitmap bitmap = mCaptureScreenBmp;
            if (bitmap != null && (i2 != bitmap.getWidth() || i3 != mCaptureScreenBmp.getHeight())) {
                mCaptureScreenBmp.recycle();
                mCaptureScreenBmp = null;
            }
            if (mCaptureScreenBmp == null) {
                mCaptureScreenBmp = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            }
            return mCaptureScreenBmp;
        }
        return (Bitmap) invokeII.objValue;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bitmap, i2)) == null) {
            Matrix matrix = new Matrix();
            matrix.postScale(1.0f, -1.0f, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
            matrix.postRotate(i2, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return (Bitmap) invokeLI.objValue;
    }
}
