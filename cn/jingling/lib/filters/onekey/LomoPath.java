package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.MotionEventCompat;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.Curve;
import cn.jingling.lib.filters.Layer;
import cn.jingling.lib.filters.OneKeyFilter;
/* loaded from: classes.dex */
public class LomoPath extends OneKeyFilter {
    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context cx, Bitmap bm) {
        int w = bm.getWidth();
        int h = bm.getHeight();
        int[] pixels = new int[w * h];
        bm.getPixels(pixels, 0, w, 0, 0, w, h);
        Curve c = new Curve(cx, "curves/lomo_path.dat");
        CMTProcessor.curveEffect(pixels, c.getCurveRed(), c.getCurveGreen(), c.getCurveBlue(), w, h);
        CMTProcessor.multiplyEffect(pixels, Layer.getLayerPixels(cx, "layers/lomo_path", w, h, Layer.Type.ROTATABLE, MotionEventCompat.ACTION_MASK), w, h);
        bm.setPixels(pixels, 0, w, 0, 0, w, h);
        return bm;
    }
}
