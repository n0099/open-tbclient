package cn.jingling.lib.filters.onekey;

import android.content.Context;
import android.graphics.Bitmap;
import cn.jingling.lib.filters.CMTProcessor;
import cn.jingling.lib.filters.Curve;
import cn.jingling.lib.filters.OneKeyFilter;
/* loaded from: classes.dex */
public class CurveFilter extends OneKeyFilter {
    protected int mHeight;
    protected String mPath = null;
    protected int[] mPixels;
    protected int mWidth;

    protected void initial(Bitmap bitmap) {
        this.mWidth = bitmap.getWidth();
        this.mHeight = bitmap.getHeight();
        this.mPixels = new int[this.mWidth * this.mHeight];
        bitmap.getPixels(this.mPixels, 0, this.mWidth, 0, 0, this.mWidth, this.mHeight);
    }

    protected void curvePixels(Context context) {
        Curve curve = new Curve(context, this.mPath);
        CMTProcessor.curveEffect(this.mPixels, curve.getCurveRed(), curve.getCurveGreen(), curve.getCurveBlue(), this.mWidth, this.mHeight);
    }

    protected void setPicxels(Bitmap bitmap) {
        bitmap.setPixels(this.mPixels, 0, this.mWidth, 0, 0, this.mWidth, this.mHeight);
        this.mPixels = null;
    }

    @Override // cn.jingling.lib.filters.OneKeyFilter
    public Bitmap apply(Context context, Bitmap bitmap) {
        initial(bitmap);
        curvePixels(context);
        setPicxels(bitmap);
        return bitmap;
    }
}
