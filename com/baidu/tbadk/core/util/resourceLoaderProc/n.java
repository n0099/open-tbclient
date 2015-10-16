package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class n extends a {
    private boolean acB;

    public n(boolean z) {
        this.acB = true;
        this.acB = z;
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
        return this.acB;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vl() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vm() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d hb = r.hb();
        hb.hy();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dx = dx(au.dn(str2));
        if (dx == null) {
            return null;
        }
        dx.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dx.o(true);
        dx.p(false);
        dx.h(bArr);
        dx.q(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dx);
            aVar.vs = dVar;
        }
        boolean iN = com.baidu.adp.lib.util.i.iN();
        if (!com.baidu.adp.lib.Disk.d.fj().c(dx)) {
            r.a(hb, str2, false, hb.hz(), iN);
            return null;
        }
        int i = 2000;
        if (iN) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dx.isSuccess() ? a(dx, str2) : null;
        if (a != null) {
            r.a(hb, str2, true, hb.hz(), iN);
        } else {
            r.a(hb, str2, false, hb.hz(), iN);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.j jVar, byte[] bArr, Rect rect) {
        if (i(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, au.dn(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.o(true);
            cVar.setData(bArr);
            cVar.r(z);
            cVar.q(false);
            com.baidu.adp.lib.Disk.d.fj().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.vs = dVar;
            }
        }
        return aVar2;
    }
}
