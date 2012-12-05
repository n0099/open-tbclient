package cn.jingling.lib.filters.global;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.GlobalFilter;
import cn.jingling.lib.filters.ImageProcessUtils;
/* loaded from: classes.dex */
public class BetterSkin extends GlobalFilter {
    private static final int WHITE_DEGREE = 70;
    private Bitmap mPerformedBitmap;

    @Override // cn.jingling.lib.filters.GlobalFilter
    public void setup(Context cx, Bitmap bm) {
        super.setup(cx, bm);
        int w = bm.getWidth();
        int h = bm.getHeight();
        int[] pixels = new int[w * h];
        bm.getPixels(pixels, 0, w, 0, 0, w, h);
        CMTProcessor.brightEffect(pixels, w, h, WHITE_DEGREE);
        CMTProcessor.fastAverageBlurWithThreshold(pixels, w, h, 5, 10);
        this.mPerformedBitmap = Bitmap.createBitmap(pixels, w, h, bm.getConfig());
    }

    @Override // cn.jingling.lib.filters.GlobalFilter
    public Bitmap apply(Context cx, int degree) {
        Bitmap bm = ImageProcessUtils.mergeBitmap(this.mPerformedBitmap, this.mOriginalBitmap, degree / 100.0d);
        return bm;
    }

    @Override // cn.jingling.lib.filters.GlobalFilter
    public void release() {
        super.release();
        if (this.mPerformedBitmap != null) {
            this.mPerformedBitmap.recycle();
            this.mPerformedBitmap = null;
        }
    }
}
