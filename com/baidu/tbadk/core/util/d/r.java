package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class r extends t {
    public r(boolean z, int i) {
        super(z, true, false, i);
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

    @Override // com.baidu.tbadk.core.util.d.t, com.baidu.tbadk.core.util.d.a
    public void a(String str, byte[] bArr, Object... objArr) {
        byte[] Bitmap2Bytes;
        Bitmap bitmap = (Bitmap) objArr[4];
        if (bitmap != null && (Bitmap2Bytes = BitmapHelper.Bitmap2Bytes(bitmap, 100)) != null) {
            bArr = Bitmap2Bytes;
        }
        super.a(str, bArr, objArr);
    }
}
