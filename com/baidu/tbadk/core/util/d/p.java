package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class p extends a {
    private int procType;

    public p(int i) {
        this.procType = 0;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zV() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zW() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.d.a
    public com.baidu.adp.lib.Disk.ops.c fb(String str) {
        return new com.baidu.adp.lib.Disk.ops.b(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.d.a
    public com.baidu.adp.widget.ImageView.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null || !(cVar instanceof com.baidu.adp.lib.Disk.ops.b)) {
            return null;
        }
        com.baidu.adp.lib.Disk.ops.b bVar = (com.baidu.adp.lib.Disk.ops.b) cVar;
        cVar.j(cVar.getData());
        Bitmap bitmap = cVar.getBitmap();
        if (bitmap != null) {
            return new com.baidu.adp.widget.ImageView.a(bitmap, false, str, bVar.getRect());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.d.a
    public Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.Bytes2NineBitmap(bArr, rect, sb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.d.a
    public boolean e(Bitmap bitmap) {
        return bitmap.getNinePatchChunk() != null && NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int zX() {
        return this.procType;
    }
}
