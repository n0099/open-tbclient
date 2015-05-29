package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class l extends a {
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean ue() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uf() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.lib.Disk.ops.c dk(String str) {
        return new com.baidu.adp.lib.Disk.ops.b(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null || !(cVar instanceof com.baidu.adp.lib.Disk.ops.b)) {
            return null;
        }
        com.baidu.adp.lib.Disk.ops.b bVar = (com.baidu.adp.lib.Disk.ops.b) cVar;
        cVar.k(cVar.getData());
        Bitmap bitmap = cVar.getBitmap();
        if (bitmap != null) {
            return new com.baidu.adp.widget.a.a(bitmap, false, str, bVar.getRect());
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected Bitmap b(byte[] bArr, Rect rect, StringBuilder sb) {
        return com.baidu.tbadk.core.util.c.a(bArr, rect, sb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean g(Bitmap bitmap) {
        return bitmap.getNinePatchChunk() != null && NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected Bitmap b(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }
}
