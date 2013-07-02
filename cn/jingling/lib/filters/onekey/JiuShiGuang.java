package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.Curve;
import cn.jingling.lib.filters.ImageProcessUtils;
import cn.jingling.lib.filters.Layer;
import cn.jingling.lib.filters.OneKeyFilter;
/* loaded from: classes.dex */
public class JiuShiGuang extends OneKeyFilter {
    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context context, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        Curve curve = new Curve(context, "curves/fleeting16.dat");
        CMTProcessor.curveEffect(iArr, curve.getCurveRed(), curve.getCurveGreen(), curve.getCurveBlue(), width, height);
        CMTProcessor.linearBurn(iArr, Layer.getLayerPixels(context, "layers/fleeting16", width, height, Layer.Type.ROTATABLE), width, height, 100);
        bitmap.setPixels(ImageProcessUtils.saturationPs(iArr, width, height, -35), 0, width, 0, 0, width, height);
        return bitmap;
    }
}
