package com.baidu.live.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.imagemanager.TbImageMemoryCache;
/* loaded from: classes6.dex */
public class StickerAction extends ImageAction {
    public static final String ACTION_NAME = "sticker";
    public String mStickerPath = "";

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public String getActionName() {
        return ACTION_NAME;
    }

    public static ImageOperation newOperation() {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = ACTION_NAME;
        return imageOperation;
    }

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public void setParams(String str) {
    }

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public Bitmap processImage(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        TbImageMemoryCache.getInstance().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
        return BitmapHelper.loadResizedBitmap(this.mStickerPath, BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()), BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
    }

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public Bitmap processImage(String str) throws Exception {
        return processImage(BitmapHelper.loadResizedBitmap(str, BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()), BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst())), true);
    }

    public void setPath(String str) {
        this.mStickerPath = str;
    }
}
