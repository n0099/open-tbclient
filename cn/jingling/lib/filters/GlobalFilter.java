package cn.jingling.lib.filters;

import android.content.Context;
import android.graphics.Bitmap;
/* loaded from: classes.dex */
public abstract class GlobalFilter extends Filter {
    protected Bitmap mOriginalBitmap;

    public abstract Bitmap apply(Context context, int i);

    public void setup(Context cx, Bitmap bm) {
        this.mOriginalBitmap = bm.copy(bm.getConfig(), true);
    }

    public void release() {
        this.mOriginalBitmap.recycle();
        this.mOriginalBitmap = null;
    }
}
