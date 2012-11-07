package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.OneKeyFilter;
/* loaded from: classes.dex */
public abstract class SingleColor extends OneKeyFilter {
    public abstract void singleColorEffect(int[] iArr, int i, int i2, float[] fArr);

    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context cx, Bitmap bm) {
        float[] matrix = {0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        int w = bm.getWidth();
        int h = bm.getHeight();
        int[] pixels = new int[w * h];
        bm.getPixels(pixels, 0, w, 0, 0, w, h);
        singleColorEffect(pixels, w, h, matrix);
        bm.setPixels(pixels, 0, w, 0, 0, w, h);
        return bm;
    }
}
