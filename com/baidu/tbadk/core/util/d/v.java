package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class v extends a {
    private boolean aAQ;
    private int procType;

    public v(boolean z, int i) {
        this.aAQ = true;
        this.procType = 0;
        this.aAQ = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dt() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a jB = com.baidu.tbadk.core.util.s.jB();
        jB.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c fI = fI(ar.fs(str2));
        if (fI == null) {
            return null;
        }
        fI.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        fI.R(true);
        fI.S(false);
        fI.q(bArr);
        fI.T(false);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(fI);
            aVar.Dw = eVar;
        }
        boolean kW = com.baidu.adp.lib.util.j.kW();
        if (!com.baidu.adp.lib.Disk.d.hB().c(fI)) {
            com.baidu.tbadk.core.util.s.a(jB, str2, false, jB.jK(), kW);
            return null;
        }
        int i3 = 2000;
        if (kW) {
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
            com.baidu.tbadk.core.util.s.a(jB, str2, true, jB.jK(), kW);
            return aVar2;
        }
        com.baidu.tbadk.core.util.s.a(jB, str2, false, jB.jK(), kW);
        return aVar2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (f(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ar.fs(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.R(true);
            cVar.setData(bArr);
            cVar.W(z);
            cVar.T(false);
            com.baidu.adp.lib.Disk.d.hB().c(cVar);
            if (aVar != null) {
                e eVar = new e();
                eVar.f(cVar);
                aVar.Dw = eVar;
            }
        }
        return aVar2;
    }
}
