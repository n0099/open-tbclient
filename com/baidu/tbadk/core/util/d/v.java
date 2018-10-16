package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class v extends a {
    private boolean aAb;
    private int procType;

    public v(boolean z, int i) {
        this.aAb = true;
        this.procType = 0;
        this.aAb = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dm() {
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
        return this.aAb;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Dl() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a jD = com.baidu.tbadk.core.util.s.jD();
        jD.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c fI = fI(ar.fs(str2));
        if (fI == null) {
            return null;
        }
        fI.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        fI.D(true);
        fI.E(false);
        fI.q((Object) bArr);
        fI.F(false);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(fI);
            aVar.Ds = eVar;
        }
        boolean kY = com.baidu.adp.lib.util.j.kY();
        if (!com.baidu.adp.lib.Disk.d.hC().c(fI)) {
            com.baidu.tbadk.core.util.s.a(jD, str2, false, jD.jM(), kY);
            return null;
        }
        int i3 = 2000;
        if (kY) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!fI.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(fI, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(jD, str2, true, jD.jM(), kY);
            return aVar2;
        }
        com.baidu.tbadk.core.util.s.a(jD, str2, false, jD.jM(), kY);
        return aVar2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (f(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ar.fs(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.D(true);
            cVar.setData(bArr);
            cVar.I(z);
            cVar.F(false);
            com.baidu.adp.lib.Disk.d.hC().c(cVar);
            if (aVar != null) {
                e eVar = new e();
                eVar.f(cVar);
                aVar.Ds = eVar;
            }
        }
        return aVar2;
    }
}
