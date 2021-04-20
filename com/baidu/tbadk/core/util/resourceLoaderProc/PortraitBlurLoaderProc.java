package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.b.c.j.d.a;
/* loaded from: classes3.dex */
public class PortraitBlurLoaderProc extends PortraitLoaderProc {
    public PortraitBlurLoaderProc(boolean z, boolean z2, int i) {
        super(z, z2, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public a decodeToResource(byte[] bArr, Object... objArr) {
        Bitmap p = super.m16decodeToResource(bArr, objArr).p();
        if (p == null) {
            return null;
        }
        Bitmap fastblur = BitmapHelper.fastblur(p, 10, 0.25f);
        if (fastblur != p) {
            p.recycle();
        }
        return new a(fastblur);
    }
}
