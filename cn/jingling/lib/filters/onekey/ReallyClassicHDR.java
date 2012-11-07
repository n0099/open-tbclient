package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.Curve;
import cn.jingling.lib.filters.OneKeyFilter;
/* loaded from: classes.dex */
public class ReallyClassicHDR extends OneKeyFilter {
    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context cx, Bitmap bm) {
        int w = bm.getWidth();
        int h = bm.getHeight();
        int[] pixels = new int[w * h];
        int[] blurPixels = new int[w * h];
        bm.getPixels(pixels, 0, w, 0, 0, w, h);
        System.arraycopy(pixels, 0, blurPixels, 0, w * h);
        CMTProcessor.unsharpEffect(pixels, blurPixels, w, h, 1, 0, 1.5f);
        Curve c = new Curve(cx, "curves/mofangjingdianHDR.dat");
        CMTProcessor.curveEffect(pixels, c.getCurveRed(), c.getCurveGreen(), c.getCurveBlue(), w, h);
        bm.setPixels(pixels, 0, w, 0, 0, w, h);
        return bm;
    }
}
