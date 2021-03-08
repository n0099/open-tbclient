package com.baidu.live.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.live.tbadk.core.util.BitmapHelper;
/* loaded from: classes10.dex */
public abstract class ImageAction {
    public abstract String getActionName();

    public abstract Bitmap processImage(Bitmap bitmap, boolean z) throws Exception;

    public abstract void setParams(String str);

    public Bitmap processImage(String str) throws Exception {
        return processImage(BitmapHelper.loadBitmap(str), true);
    }
}
