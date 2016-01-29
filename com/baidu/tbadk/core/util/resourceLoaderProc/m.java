package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class m extends a {
    private int acq;
    private boolean aeC;

    public m(boolean z, int i) {
        this.aeC = true;
        this.acq = 0;
        this.aeC = z;
        this.acq = i;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wK() {
        return this.acq;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.aeC;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wJ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d hm = u.hm();
        hm.hJ();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dJ = dJ(ay.dy(str2));
        if (dJ == null) {
            return null;
        }
        dJ.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dJ.o(true);
        dJ.p(false);
        dJ.h(bArr);
        dJ.q(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dJ);
            aVar.vK = dVar;
        }
        boolean ja = com.baidu.adp.lib.util.i.ja();
        if (!com.baidu.adp.lib.Disk.d.fr().c(dJ)) {
            u.a(hm, str2, false, hm.hK(), ja);
            return null;
        }
        int i = 2000;
        if (ja) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dJ.isSuccess() ? a(dJ, str2) : null;
        if (a != null) {
            u.a(hm, str2, true, hm.hK(), ja);
        } else {
            u.a(hm, str2, false, hm.hK(), ja);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ay.dy(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.o(true);
            cVar.setData(bArr);
            cVar.r(z);
            cVar.q(false);
            com.baidu.adp.lib.Disk.d.fr().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.vK = dVar;
            }
        }
        return aVar2;
    }
}
