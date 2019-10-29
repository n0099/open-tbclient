package com.baidu.tbadk.core.util.e;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class x extends a {
    private boolean HY;
    private boolean clX;
    private int procType;

    public x(boolean z, int i) {
        this(z, i, true);
    }

    public x(boolean z, int i, boolean z2) {
        this.HY = true;
        this.procType = 0;
        this.clX = true;
        this.HY = z;
        this.procType = i;
        this.clX = z2;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return this.HY;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean ani() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean anj() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int ank() {
        return this.procType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.util.e.a
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (o(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.clm) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(z);
                cVar.y(this.clX);
                com.baidu.adp.lib.Disk.d.eP().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.pM = eVar;
                }
            }
        }
        return aVar2;
    }
}
