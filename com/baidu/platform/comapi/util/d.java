package com.baidu.platform.comapi.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(Drawable drawable) {
        InterceptResult invokeL;
        int intrinsicWidth;
        int intrinsicHeight;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, drawable)) == null) {
            if (drawable == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT <= 26 && (drawable instanceof BitmapDrawable)) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            try {
                if (!drawable.getBounds().isEmpty()) {
                    intrinsicWidth = drawable.getBounds().width();
                } else {
                    intrinsicWidth = drawable.getIntrinsicWidth();
                }
                if (!drawable.getBounds().isEmpty()) {
                    intrinsicHeight = drawable.getBounds().height();
                } else {
                    intrinsicHeight = drawable.getIntrinsicHeight();
                }
                if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                    if (intrinsicWidth <= bitmap.getWidth()) {
                        intrinsicWidth = bitmap.getWidth();
                    }
                    if (intrinsicHeight <= bitmap.getHeight()) {
                        intrinsicHeight = bitmap.getHeight();
                    }
                }
                if (intrinsicWidth <= 0) {
                    intrinsicWidth = 1;
                }
                if (intrinsicHeight <= 0) {
                    intrinsicHeight = 1;
                }
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }
}
