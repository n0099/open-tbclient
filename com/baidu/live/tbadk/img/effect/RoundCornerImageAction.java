package com.baidu.live.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.imagemanager.TbImageMemoryCache;
/* loaded from: classes10.dex */
public class RoundCornerImageAction extends ImageAction {
    private static final String ACTION_NAME = "round_corner";
    private float roundPx;

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public String getActionName() {
        return ACTION_NAME;
    }

    public static ImageOperation newOperation(float f) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = ACTION_NAME;
        imageOperation.actionParam = String.valueOf(f);
        return imageOperation;
    }

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public void setParams(String str) {
        if (str != null) {
            this.roundPx = JavaTypesHelper.toFloat(str, 0.0f);
        }
    }

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public Bitmap processImage(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        if (this.roundPx > 0.0f) {
            TbImageMemoryCache.getInstance().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.getRoundedCornerBitmap(bitmap, this.roundPx, z);
        }
        return bitmap;
    }
}
