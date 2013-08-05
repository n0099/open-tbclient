package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.Curve;
import cn.jingling.lib.filters.ImageProcessUtils;
import cn.jingling.lib.filters.Layer;
import cn.jingling.lib.filters.OneKeyFilter;
import com.tencent.mm.sdk.contact.RContact;
/* loaded from: classes.dex */
public class Nashiv extends OneKeyFilter {
    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context context, Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] saturationPs = ImageProcessUtils.saturationPs(iArr, width, height, -15);
        Curve curve = new Curve(context, "curves/nashiv.dat");
        CMTProcessor.curveEffect(saturationPs, curve.getCurveRed(), curve.getCurveGreen(), curve.getCurveBlue(), width, height);
        CMTProcessor.multiplyEffect(saturationPs, Layer.getLayerPixels(context, "layers/nashiv", width, height, Layer.Type.ROTATABLE, RContact.MM_CONTACTIMGFLAG_LOCAL_EXIST), width, height);
        bitmap.setPixels(saturationPs, 0, width, 0, 0, width, height);
        return bitmap;
    }
}
