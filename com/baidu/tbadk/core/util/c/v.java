package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class v extends x {
    public v(boolean z, int i) {
        super(z, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.c.a
    public Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        Bitmap a = super.a(bArr, rect, sb);
        if (a != null) {
            Bitmap fastblur = BitmapHelper.fastblur(a, 10, 0.25f);
            if (fastblur != a) {
                a.recycle();
            }
            return fastblur;
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.c.x, com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect, boolean z2) {
        byte[] bArr2;
        if (bitmap == null || (bArr2 = BitmapHelper.Bitmap2Bytes(bitmap, 100)) == null) {
            bArr2 = bArr;
        }
        return super.a(str, str2, aVar, aVar2, bitmap, z, iVar, bArr2, rect, z2);
    }
}
