package com.baidu.live.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.imagemanager.TbImageMemoryCache;
/* loaded from: classes11.dex */
public class RotateImageAction extends ImageAction {
    public static final String ACTION_NAME = "rotate";
    private int rotateType = 0;

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public String getActionName() {
        return ACTION_NAME;
    }

    public static ImageOperation newOperation(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = ACTION_NAME;
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public void setParams(String str) {
        if (str != null) {
            this.rotateType = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public Bitmap processImage(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        TbImageMemoryCache.getInstance().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
        if (this.rotateType == 0 || this.rotateType == 1) {
            return BitmapHelper.rotateBitmap(bitmap, this.rotateType);
        }
        if (this.rotateType == 2 || this.rotateType == 3) {
            return BitmapHelper.reversalBitmap(bitmap, this.rotateType);
        }
        return bitmap;
    }

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public Bitmap processImage(String str) throws Exception {
        int max = Math.max(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp()), BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp()));
        return processImage(BitmapHelper.loadResizedBitmap(str, max, max), true);
    }
}
