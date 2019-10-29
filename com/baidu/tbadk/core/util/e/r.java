package com.baidu.tbadk.core.util.e;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class r extends a {
    private int procType;

    public r(int i) {
        this.procType = 0;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean ani() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean anj() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.e.a
    public com.baidu.adp.lib.Disk.ops.c oi(String str) {
        return new com.baidu.adp.lib.Disk.ops.b(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a pY = com.baidu.tbadk.imageManager.c.avu().pY(str);
        if (pY != null) {
            pY.xD.resourceFromType = "memory";
            pY.xD.costTime = 0L;
            pY.xD.isScuess = true;
        }
        return pY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.e.a
    public com.baidu.adp.widget.ImageView.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str, int i, int i2) {
        if (cVar == null || !(cVar instanceof com.baidu.adp.lib.Disk.ops.b)) {
            return null;
        }
        com.baidu.adp.lib.Disk.ops.b bVar = (com.baidu.adp.lib.Disk.ops.b) cVar;
        cVar.formatData(cVar.getData());
        Bitmap bitmap = cVar.getBitmap();
        if (bitmap != null) {
            return new com.baidu.adp.widget.ImageView.a(bitmap, false, str, bVar.getRect());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.e.a
    public Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.Bytes2NineBitmap(bArr, rect, sb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.e.a
    public boolean o(Bitmap bitmap) {
        return bitmap.getNinePatchChunk() != null && NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk());
    }

    @Override // com.baidu.tbadk.core.util.e.a
    protected Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    protected Bitmap e(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int ank() {
        return this.procType;
    }
}
