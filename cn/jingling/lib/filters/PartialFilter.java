package cn.jingling.lib.filters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public abstract class PartialFilter extends Filter {
    protected Bitmap mOriginalBitmap;

    public abstract Bitmap apply(Bitmap bitmap, View view, MotionEvent motionEvent);

    public void setup(Context context, Bitmap bitmap, View view, View view2) {
        this.mOriginalBitmap = bitmap.copy(bitmap.getConfig(), true);
    }

    protected final int getBitmapX(View view, int i) {
        return (this.mOriginalBitmap.getWidth() * i) / view.getWidth();
    }

    protected final int getBitmapY(View view, int i) {
        return (this.mOriginalBitmap.getHeight() * i) / view.getHeight();
    }

    public void release() {
        this.mOriginalBitmap.recycle();
        this.mOriginalBitmap = null;
    }
}
