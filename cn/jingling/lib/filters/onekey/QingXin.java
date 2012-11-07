package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.Curve;
import cn.jingling.lib.filters.ImageProcessUtils;
import cn.jingling.lib.filters.OneKeyFilter;
/* loaded from: classes.dex */
public class QingXin extends OneKeyFilter {
    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context cx, Bitmap bm) {
        int w = bm.getWidth();
        int h = bm.getHeight();
        int[] pixels = new int[w * h];
        bm.getPixels(pixels, 0, w, 0, 0, w, h);
        int[] pixels2 = ImageProcessUtils.saturationPs(pixels, w, h, -30);
        Curve c = new Curve(cx, "curves/qingxin.dat");
        CMTProcessor.curveEffect(pixels2, c.getCurveRed(), c.getCurveGreen(), c.getCurveBlue(), w, h);
        bm.setPixels(pixels2, 0, w, 0, 0, w, h);
        return bm;
    }
}
