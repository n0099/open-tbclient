package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class u extends w {
    public u(boolean z, int i) {
        super(z, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.d.a
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
