package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class p extends q {
    public p(boolean z, boolean z2, int i) {
        super(z, z2, i);
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public com.baidu.adp.widget.ImageView.a a(byte[] bArr, Object... objArr) {
        Bitmap rawBitmap = super.a(bArr, objArr).getRawBitmap();
        if (rawBitmap == null) {
            return null;
        }
        Bitmap fastblur = BitmapHelper.fastblur(rawBitmap, 10, 0.25f);
        if (fastblur != rawBitmap) {
            rawBitmap.recycle();
        }
        return new com.baidu.adp.widget.ImageView.a(fastblur);
    }
}
