package com.baidu.live.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.imagemanager.TbImageMemoryCache;
/* loaded from: classes4.dex */
public class ResizeImageAction extends ImageAction {
    public static final String ACTION_NAME = "resize";
    private int maxHeight;
    private int maxWidth;

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public String getActionName() {
        return ACTION_NAME;
    }

    public static ImageOperation newOperation(int i, int i2) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = ACTION_NAME;
        imageOperation.actionParam = i + "," + i2;
        return imageOperation;
    }

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public void setParams(String str) {
        if (str != null) {
            String[] split = str.split(",");
            if (split.length == 2) {
                this.maxWidth = JavaTypesHelper.toInt(split[0], 0);
                this.maxHeight = JavaTypesHelper.toInt(split[1], 0);
            }
        }
    }

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public Bitmap processImage(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        TbImageMemoryCache.getInstance().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
        return BitmapHelper.resizeBitmap(bitmap, this.maxWidth, this.maxHeight, z);
    }

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public Bitmap processImage(String str) throws Exception {
        return processImage(BitmapHelper.loadResizedBitmap(str, this.maxWidth, this.maxHeight), true);
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }
}
