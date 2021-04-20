package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.b.c.j.d.a;
/* loaded from: classes3.dex */
public class SimpleBlurLoaderProc extends SimpleLoaderProc {
    public SimpleBlurLoaderProc(boolean z, int i) {
        super(z, true, false, i);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.SimpleLoaderProc, com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        byte[] Bitmap2Bytes;
        Bitmap bitmap = (Bitmap) objArr[4];
        if (bitmap != null && (Bitmap2Bytes = BitmapHelper.Bitmap2Bytes(bitmap, 100)) != null) {
            bArr = Bitmap2Bytes;
        }
        super.storeLocal(str, bArr, objArr);
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
