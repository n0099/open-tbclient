package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.Curve;
import cn.jingling.lib.filters.Layer;
import cn.jingling.lib.filters.OneKeyFilter;
/* loaded from: classes.dex */
public class Sunny extends OneKeyFilter {
    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context context, Bitmap bitmap) {
        Bitmap layerImage;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] iArr2 = new int[width * height];
        if (width < 200) {
            layerImage = Layer.getLayerImage(context, "layers/sunnysmall", width, height, Layer.Type.ROTATABLE);
        } else {
            layerImage = Layer.getLayerImage(context, "layers/sunny", width, height, Layer.Type.ROTATABLE);
        }
        layerImage.getPixels(iArr2, 0, width, 0, 0, width, height);
        CMTProcessor.screenEffect(iArr, iArr2, width, height);
        Curve curve = new Curve(context, "curves/sunny.dat");
        CMTProcessor.curveEffect(iArr, curve.getCurveRed(), curve.getCurveGreen(), curve.getCurveBlue(), width, height);
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap;
    }
}
