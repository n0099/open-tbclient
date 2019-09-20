package com.baidu.tbadk.core.util.e;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class w extends a {
    private boolean Yd;
    private boolean bWT;
    private int procType;

    public w(boolean z, int i) {
        this(z, i, true);
    }

    public w(boolean z, int i, boolean z2) {
        this.Yd = true;
        this.procType = 0;
        this.bWT = true;
        this.Yd = z;
        this.procType = i;
        this.bWT = z2;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return this.Yd;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean akg() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean akh() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int aki() {
        return this.procType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.e.a
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (m(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.bWg) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.ol(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.J(true);
                cVar.setData(bArr);
                cVar.L(false);
                cVar.M(true);
                cVar.O(z);
                cVar.N(this.bWT);
                com.baidu.adp.lib.Disk.d.gC().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.Bk = eVar;
                }
            }
        }
        return aVar2;
    }
}
