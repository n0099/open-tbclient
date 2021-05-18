package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.a.c.e.a.f.b;
import d.a.c.e.a.f.c;
import d.a.c.j.d.a;
/* loaded from: classes3.dex */
public class NinePatchLoaderProc extends AbstractImageLoaderProc {
    public int procType;

    public NinePatchLoaderProc(int i2) {
        this.procType = 0;
        this.procType = i2;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public Bitmap checkBitmapSize(Bitmap bitmap, int i2, int i3) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean checkBitmapValid(Bitmap bitmap) {
        return bitmap.getNinePatchChunk() != null && NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public c createDiskPicOperate(String str) {
        return new b("images", str, DiskFileOperate.Action.READ);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public a createImageFromDiskPicOperate(c cVar, String str, int i2, int i3) {
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            cVar.formatData(cVar.getData());
            Bitmap bitmap = cVar.getBitmap();
            if (bitmap != null) {
                return new a(bitmap, false, str, bVar.g());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getProcType() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public Bitmap resizeBitmapSize(Bitmap bitmap, int i2, int i3) {
        return bitmap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public a decodeToResource(byte[] bArr, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap Bytes2NineBitmap = BitmapHelper.Bytes2NineBitmap(bArr, (Rect) objArr[0]);
        d.a.c.e.l.a.c(Bytes2NineBitmap != null, System.currentTimeMillis() - currentTimeMillis);
        return new a(Bytes2NineBitmap);
    }
}
