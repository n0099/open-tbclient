package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes2.dex */
public class u extends v {
    public u(boolean z, boolean z2, int i) {
        super(z, z2, i);
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
}
