package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.TypedValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#ffffff"));
            paint.setTextSize(TypedValue.applyDimension(1, 14.0f, context.getResources().getDisplayMetrics()));
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setDither(true);
            float measureText = paint.measureText("您还没有获得功能授权", 0, 10);
            float measureText2 = paint.measureText("请联系百度：ar_business@baidu.com", 0, 27);
            float f2 = Float.compare(measureText, measureText2) == 1 ? measureText : measureText2;
            float f3 = paint.getFontMetrics().top;
            float f4 = paint.getFontMetrics().bottom - f3;
            int i2 = (int) (f2 + 40.0f);
            int i3 = (int) ((f4 * 2.0f) + 40.0f);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, i2, i3), new float[]{8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f}, Path.Direction.CW);
            canvas.clipPath(path);
            canvas.drawColor(Color.parseColor("#88333333"));
            float f5 = (-f3) + 20.0f;
            canvas.drawText("您还没有获得功能授权", ((f2 - measureText) / 2.0f) + 20.0f, f5, paint);
            canvas.drawText("请联系百度：ar_business@baidu.com", ((f2 - measureText2) / 2.0f) + 20.0f, f5 + f4, paint);
            com.baidu.ar.h.b.c("createBitmap", "w: " + createBitmap.getWidth() + " h: " + createBitmap.getHeight() + " bc: " + createBitmap.getByteCount());
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }
}
