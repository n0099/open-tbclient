package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class g extends a {
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int d() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int e() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean f() {
        return true;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean g() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean h() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.lib.Disk.ops.c a(String str) {
        return new com.baidu.adp.lib.Disk.ops.b(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null || !(cVar instanceof com.baidu.adp.lib.Disk.ops.b)) {
            return null;
        }
        com.baidu.adp.lib.Disk.ops.b bVar = (com.baidu.adp.lib.Disk.ops.b) cVar;
        cVar.b(cVar.b());
        Bitmap w = cVar.w();
        if (w != null) {
            return new com.baidu.adp.widget.a.a(w, false, str, bVar.u());
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return com.baidu.tbadk.core.util.h.a(bArr, rect, sb);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected boolean a(Bitmap bitmap) {
        return bitmap.getNinePatchChunk() != null && NinePatch.isNinePatchChunk(bitmap.getNinePatchChunk());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        return bitmap;
    }
}
