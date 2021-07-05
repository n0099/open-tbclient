package com.baidu.ar.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, bitmap, i2)) == null) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i2, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
            matrix.postScale(-1.0f, 1.0f);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap b(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bitmap, i2)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, height / 4, width, height / 2, (Matrix) null, false);
            Matrix matrix = new Matrix();
            matrix.postRotate(i2, createBitmap.getWidth() / 2.0f, createBitmap.getHeight() / 2.0f);
            return Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, false);
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            Bitmap bitmap = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                InputStream open = context.getAssets().open(str);
                bitmap = BitmapFactory.decodeStream(open);
                open.close();
                return bitmap;
            } catch (IOException e2) {
                e2.printStackTrace();
                return bitmap;
            }
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bitmap, i2)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            float f3 = width / 2.0f;
            float f4 = height / 2.0f;
            matrix.setRotate(i2, f3, f4);
            float f5 = 0.0f;
            if (i2 != 90 && i2 != 270) {
                f2 = 0.0f;
            } else if (width > height) {
                float f6 = f4 - f3;
                f2 = 0.0f - f6;
                f5 = f6;
            } else {
                f2 = f3 - f4;
                f5 = 0.0f - f2;
            }
            matrix.postTranslate(f5, f2);
            Bitmap bitmap2 = null;
            try {
                bitmap2 = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.ARGB_8888);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            new Canvas(bitmap2).drawBitmap(bitmap, matrix, new Paint());
            return bitmap2;
        }
        return (Bitmap) invokeLI.objValue;
    }
}
