package com.baidu.live.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
/* loaded from: classes10.dex */
public class n {
    public static Bitmap c(Bitmap bitmap, int i, int i2) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, width, height), i, i, paint);
            int i3 = i2 ^ 15;
            if ((i3 & 1) != 0) {
                a(canvas, paint, i, width, height);
            }
            if ((i3 & 2) != 0) {
                b(canvas, paint, i, width, height);
            }
            if ((i3 & 4) != 0) {
                c(canvas, paint, i, width, height);
            }
            if ((i3 & 8) != 0) {
                d(canvas, paint, i, width, height);
            }
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            Rect rect = new Rect(0, 0, width, height);
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return createBitmap;
        } catch (Exception e) {
            return bitmap;
        }
    }

    private static void a(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(0, 0, i, i), paint);
    }

    private static void b(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(i2 - i, 0, i2, i), paint);
    }

    private static void c(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(0, i3 - i, i, i3), paint);
    }

    private static void d(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(i2 - i, i3 - i, i2, i3), paint);
    }
}
