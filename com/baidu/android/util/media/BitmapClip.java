package com.baidu.android.util.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
/* loaded from: classes5.dex */
public class BitmapClip {

    /* loaded from: classes5.dex */
    public enum ClipType {
        ALL,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        LEFT_DIAGONAL,
        RIGHT_DIAGONAL
    }

    public static Bitmap clip(ClipType clipType, Bitmap bitmap, int i) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            switch (clipType) {
                case ALL:
                    clipAll(canvas, paint, i, width, height);
                    break;
                case LEFT:
                    clipLeft(canvas, paint, i, width, height);
                    break;
                case TOP:
                    clipTop(canvas, paint, i, width, height);
                    break;
                case RIGHT:
                    clipRight(canvas, paint, i, width, height);
                    break;
                case BOTTOM:
                    clipBottom(canvas, paint, i, width, height);
                    break;
                case LEFT_DIAGONAL:
                    clipLeftDiagonal(canvas, paint, i, width, height);
                    break;
                case RIGHT_DIAGONAL:
                    clipRightDiagonal(canvas, paint, i, width, height);
                    break;
                default:
                    clipAll(canvas, paint, i, width, height);
                    break;
            }
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            Rect rect = new Rect(0, 0, width, height);
            canvas.drawBitmap(bitmap, rect, rect, paint);
            bitmap = createBitmap;
            return bitmap;
        } catch (Exception e) {
            return bitmap;
        }
    }

    private static void clipLeft(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(i, 0, i2, i3), paint);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, i * 2, i3), i, i, paint);
    }

    private static void clipRight(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(0, 0, i2 - i, i3), paint);
        canvas.drawRoundRect(new RectF(i2 - (i * 2), 0.0f, i2, i3), i, i, paint);
    }

    private static void clipTop(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(0, i, i2, i3), paint);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, i2, i * 2), i, i, paint);
    }

    private static void clipBottom(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(0, 0, i2, i3 - i), paint);
        canvas.drawRoundRect(new RectF(0.0f, i3 - (i * 2), i2, i3), i, i, paint);
    }

    private static void clipAll(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, i2, i3), i, i, paint);
    }

    private static void clipLeftDiagonal(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(i, 0, i2, i3 - i), paint);
        canvas.drawRect(new Rect(0, i, i2 - i, i3), paint);
        canvas.drawCircle(i, i, i, paint);
        canvas.drawCircle(i2 - i, i3 - i, i, paint);
    }

    private static void clipRightDiagonal(Canvas canvas, Paint paint, int i, int i2, int i3) {
        canvas.drawRect(new Rect(0, 0, i2 - i, i3 - i), paint);
        canvas.drawRect(new Rect(i, i, i2, i3), paint);
        canvas.drawCircle(i2 - i, i, i, paint);
        canvas.drawCircle(i, i3 - i, i, paint);
    }
}
