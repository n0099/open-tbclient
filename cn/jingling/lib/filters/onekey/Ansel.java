package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.Curve;
import cn.jingling.lib.filters.ImageProcessUtils;
import cn.jingling.lib.filters.Layer;
import cn.jingling.lib.filters.OneKeyFilter;
/* loaded from: classes.dex */
public class Ansel extends OneKeyFilter {
    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context context, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] saturationPs = ImageProcessUtils.saturationPs(iArr, width, height, -100);
        Curve curve = new Curve(context, "curves/ansel.dat");
        CMTProcessor.curveEffect(saturationPs, curve.getCurveRed(), curve.getCurveGreen(), curve.getCurveBlue(), width, height);
        CMTProcessor.multiplyEffect(saturationPs, Layer.getLayerPixels(context, "layers/ansel", width, height, Layer.Type.ROTATABLE, 178), width, height);
        bitmap.setPixels(saturationPs, 0, width, 0, 0, width, height);
        return bitmap;
    }
}
