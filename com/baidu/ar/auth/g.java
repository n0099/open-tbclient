package com.baidu.ar.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.TypedValue;
/* loaded from: classes6.dex */
class g {
    public static Bitmap o(Context context) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#ffffff"));
        paint.setTextSize(TypedValue.applyDimension(1, 14.0f, context.getResources().getDisplayMetrics()));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setDither(true);
        float measureText = paint.measureText("您还没有获得功能授权", 0, "您还没有获得功能授权".length());
        float measureText2 = paint.measureText("请联系百度：ar_business@baidu.com", 0, "请联系百度：ar_business@baidu.com".length());
        float f = Float.compare(measureText, measureText2) == 1 ? measureText : measureText2;
        float f2 = paint.getFontMetrics().top;
        float f3 = paint.getFontMetrics().bottom - f2;
        int i = (int) ((2.0f * 20.0f) + f);
        int i2 = (int) ((2.0f * f3) + (2.0f * 20.0f));
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, i, i2), new float[]{8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f}, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.drawColor(Color.parseColor("#88333333"));
        canvas.drawText("您还没有获得功能授权", ((f - measureText) / 2.0f) + 20.0f, (-f2) + 20.0f, paint);
        canvas.drawText("请联系百度：ar_business@baidu.com", ((f - measureText2) / 2.0f) + 20.0f, (-f2) + 20.0f + f3, paint);
        com.baidu.ar.h.b.c("createBitmap", "w: " + createBitmap.getWidth() + " h: " + createBitmap.getHeight() + " bc: " + createBitmap.getByteCount());
        return createBitmap;
    }
}
