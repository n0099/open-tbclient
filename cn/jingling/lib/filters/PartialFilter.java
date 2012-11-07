package cn.jingling.lib.filters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes.dex */
public abstract class PartialFilter extends Filter {
    protected Bitmap mOriginalBitmap;

    public abstract Bitmap apply(Bitmap bitmap, View view, MotionEvent motionEvent);

    public void setup(Context cx, Bitmap bm, View v, View v1) {
        this.mOriginalBitmap = bm.copy(bm.getConfig(), true);
    }

    protected final int getBitmapX(View v, int x) {
        int bw = this.mOriginalBitmap.getWidth();
        int vw = v.getWidth();
        return (x * bw) / vw;
    }

    protected final int getBitmapY(View v, int y) {
        int bh = this.mOriginalBitmap.getHeight();
        int vh = v.getHeight();
        return (y * bh) / vh;
    }

    public void release() {
        this.mOriginalBitmap.recycle();
        this.mOriginalBitmap = null;
    }
}
