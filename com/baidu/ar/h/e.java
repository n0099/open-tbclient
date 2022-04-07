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

    public static Bitmap a(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, bitmap, i)) == null) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
            matrix.postScale(-1.0f, 1.0f);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap b(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bitmap, i)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, height / 4, width, height / 2, (Matrix) null, false);
            Matrix matrix = new Matrix();
            matrix.postRotate(i, createBitmap.getWidth() / 2.0f, createBitmap.getHeight() / 2.0f);
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
            } catch (IOException e) {
                e.printStackTrace();
                return bitmap;
            }
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bitmap, i)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            float f2 = width / 2.0f;
            float f3 = height / 2.0f;
            matrix.setRotate(i, f2, f3);
            float f4 = 0.0f;
            if (i != 90 && i != 270) {
                f = 0.0f;
            } else if (width > height) {
                float f5 = f3 - f2;
                f = 0.0f - f5;
                f4 = f5;
            } else {
                f = f2 - f3;
                f4 = 0.0f - f;
            }
            matrix.postTranslate(f4, f);
            Bitmap bitmap2 = null;
            try {
                bitmap2 = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.ARGB_8888);
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Canvas(bitmap2).drawBitmap(bitmap, matrix, new Paint());
            return bitmap2;
        }
        return (Bitmap) invokeLI.objValue;
    }
}
