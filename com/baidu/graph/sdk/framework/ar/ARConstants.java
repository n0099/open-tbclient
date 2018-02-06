package com.baidu.graph.sdk.framework.ar;

import android.graphics.Bitmap;
/* loaded from: classes3.dex */
public class ARConstants {
    public static final String buttonClose = "close";
    public static final String buttonSysBack = "sysBack";
    public static Bitmap mPreviewBitmap = null;

    /* loaded from: classes3.dex */
    public enum ARFinishMode {
        BackMode,
        RescanMode,
        JumpToBrowserMode,
        JumpToBarcode
    }

    public static void setPreviewBitmap(Bitmap bitmap) {
        if (mPreviewBitmap != null) {
            mPreviewBitmap.recycle();
            mPreviewBitmap = null;
        }
        mPreviewBitmap = bitmap;
    }

    public static Bitmap getPreviewBitmap() {
        Bitmap bitmap = mPreviewBitmap;
        mPreviewBitmap = null;
        return bitmap;
    }
}
