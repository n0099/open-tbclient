package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.OneKeyFilter;
/* loaded from: classes.dex */
public class Dreamy extends OneKeyFilter {
    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context context, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        CMTProcessor.dreamy(iArr, width, height, 2);
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap;
    }
}
