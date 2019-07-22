package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class v extends a {
    private boolean Yd;
    private int procType;

    public v(boolean z, int i) {
        this.Yd = true;
        this.procType = 0;
        this.Yd = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int ajU() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.Yd;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean ajS() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean ajT() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a iF = com.baidu.tbadk.core.util.s.iF();
        iF.iO();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c oB = oB(at.oj(str2));
        if (oB == null) {
            return null;
        }
        oB.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        oB.J(true);
        oB.K(false);
        oB.q(bArr);
        oB.L(false);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(oB);
            aVar.Bk = eVar;
        }
        boolean kd = com.baidu.adp.lib.util.j.kd();
        if (!com.baidu.adp.lib.Disk.d.gC().c(oB)) {
            com.baidu.tbadk.core.util.s.a(iF, str2, false, iF.iP(), kd);
            return null;
        }
        int i3 = 2000;
        if (kd) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!oB.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(oB, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(iF, str2, true, iF.iP(), kd);
            return aVar2;
        }
        com.baidu.tbadk.core.util.s.a(iF, str2, false, iF.iP(), kd);
        return aVar2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (m(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, at.oj(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.J(true);
            cVar.setData(bArr);
            cVar.O(z);
            cVar.L(false);
            com.baidu.adp.lib.Disk.d.gC().c(cVar);
            if (aVar != null) {
                e eVar = new e();
                eVar.f(cVar);
                aVar.Bk = eVar;
            }
        }
        return aVar2;
    }
}
