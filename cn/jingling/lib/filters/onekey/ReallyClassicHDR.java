package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.Curve;
import cn.jingling.lib.filters.OneKeyFilter;
/* loaded from: classes.dex */
public class ReallyClassicHDR extends OneKeyFilter {
    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context context, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        int[] iArr2 = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        System.arraycopy(iArr, 0, iArr2, 0, width * height);
        CMTProcessor.unsharpEffect(iArr, iArr2, width, height, 1, 0, 1.5f);
        Curve curve = new Curve(context, "curves/mofangjingdianHDR.dat");
        CMTProcessor.curveEffect(iArr, curve.getCurveRed(), curve.getCurveGreen(), curve.getCurveBlue(), width, height);
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap;
    }
}
