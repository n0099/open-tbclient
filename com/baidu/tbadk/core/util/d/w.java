package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class w extends a {
    private boolean aAQ;
    private boolean aBi;
    private int procType;

    public w(boolean z, int i) {
        this(z, i, true);
    }

    public w(boolean z, int i, boolean z2) {
        this.aAQ = true;
        this.procType = 0;
        this.aBi = true;
        this.aAQ = z;
        this.procType = i;
        this.aBi = z2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.aAQ;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dr() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ds() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dt() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (f(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.aAG) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ar.fs(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.R(true);
                cVar.setData(bArr);
                cVar.T(false);
                cVar.U(true);
                cVar.W(z);
                cVar.V(this.aBi);
                com.baidu.adp.lib.Disk.d.hB().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.Dw = eVar;
                }
            }
        }
        return aVar2;
    }
}
