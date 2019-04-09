package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class v extends a {
    private boolean ZR;
    private int procType;

    public v(boolean z, int i) {
        this.ZR = true;
        this.procType = 0;
        this.ZR = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int adR() {
        return this.procType;
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
        return this.ZR;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adP() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean adQ() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a jC = com.baidu.tbadk.core.util.s.jC();
        jC.jL();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c nb = nb(as.mL(str2));
        if (nb == null) {
            return null;
        }
        nb.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        nb.R(true);
        nb.S(false);
        nb.q((Object) bArr);
        nb.T(false);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(nb);
            aVar.Dv = eVar;
        }
        boolean kZ = com.baidu.adp.lib.util.j.kZ();
        if (!com.baidu.adp.lib.Disk.d.hz().c(nb)) {
            com.baidu.tbadk.core.util.s.a(jC, str2, false, jC.jM(), kZ);
            return null;
        }
        int i3 = 2000;
        if (kZ) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!nb.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(nb, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(jC, str2, true, jC.jM(), kZ);
            return aVar2;
        }
        com.baidu.tbadk.core.util.s.a(jC, str2, false, jC.jM(), kZ);
        return aVar2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (m(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.mL(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.R(true);
            cVar.setData(bArr);
            cVar.W(z);
            cVar.T(false);
            com.baidu.adp.lib.Disk.d.hz().c(cVar);
            if (aVar != null) {
                e eVar = new e();
                eVar.f(cVar);
                aVar.Dv = eVar;
            }
        }
        return aVar2;
    }
}
