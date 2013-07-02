package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.OneKeyFilter;
/* loaded from: classes.dex */
public abstract class SingleColor extends OneKeyFilter {
    public abstract void singleColorEffect(int[] iArr, int i, int i2, float[] fArr);

    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context context, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        singleColorEffect(iArr, width, height, new float[]{0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.3f, 0.59f, 0.11f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap;
    }
}
