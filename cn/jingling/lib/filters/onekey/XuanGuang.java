package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.Curve;
import cn.jingling.lib.filters.Layer;
import cn.jingling.lib.filters.OneKeyFilter;
/* loaded from: classes.dex */
public class XuanGuang extends OneKeyFilter {
    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context cx, Bitmap bm) {
        int w = bm.getWidth();
        int h = bm.getHeight();
        int[] pixels = new int[w * h];
        bm.getPixels(pixels, 0, w, 0, 0, w, h);
        Curve c = new Curve(cx, "curves/xuanguang.dat");
        CMTProcessor.curveEffect(pixels, c.getCurveRed(), c.getCurveGreen(), c.getCurveBlue(), w, h);
        CMTProcessor.screenEffect(pixels, Layer.getLayerPixels(cx, "layers/xuanguanglayer", w, h, Layer.Type.ROTATABLE), w, h);
        bm.setPixels(pixels, 0, w, 0, 0, w, h);
        return bm;
    }
}
