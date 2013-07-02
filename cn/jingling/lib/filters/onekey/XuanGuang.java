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
    public Bitmap apply(Context context, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        Curve curve = new Curve(context, "curves/xuanguang.dat");
        CMTProcessor.curveEffect(iArr, curve.getCurveRed(), curve.getCurveGreen(), curve.getCurveBlue(), width, height);
        CMTProcessor.screenEffect(iArr, Layer.getLayerPixels(context, "layers/xuanguanglayer", width, height, Layer.Type.ROTATABLE), width, height);
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap;
    }
}
