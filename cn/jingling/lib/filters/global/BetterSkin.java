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
    public Bitmap apply(Context context, int i) {
        return ImageProcessUtils.mergeBitmap(this.mPerformedBitmap, this.mOriginalBitmap, i / 100.0d);
    }

    @Override // cn.jingling.lib.filters.GlobalFilter
    public void release() {
        super.release();
        if (this.mPerformedBitmap != null) {
            this.mPerformedBitmap.recycle();
            this.mPerformedBitmap = null;
        }
    }

    @Override // cn.jingling.lib.filters.GlobalFilter
    public void setup(Context context, Bitmap bitmap) {
        super.setup(context, bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        CMTProcessor.brightEffect(iArr, width, height, WHITE_DEGREE);
        CMTProcessor.fastAverageBlurWithThreshold(iArr, width, height, 5, 10);
        this.mPerformedBitmap = Bitmap.createBitmap(iArr, width, height, bitmap.getConfig());
    }
}
