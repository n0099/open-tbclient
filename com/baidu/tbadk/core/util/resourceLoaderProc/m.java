package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class m extends a {
    private boolean ady;

    public m(boolean z) {
        this.ady = true;
        this.ady = z;
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
        return this.ady;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vS() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vT() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d he = v.he();
        he.hB();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dH = dH(az.dy(str2));
        if (dH == null) {
            return null;
        }
        dH.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dH.o(true);
        dH.p(false);
        dH.h(bArr);
        dH.q(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dH);
            aVar.vy = dVar;
        }
        boolean iQ = com.baidu.adp.lib.util.i.iQ();
        if (!com.baidu.adp.lib.Disk.d.fj().c(dH)) {
            v.a(he, str2, false, he.hC(), iQ);
            return null;
        }
        int i = 2000;
        if (iQ) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dH.isSuccess() ? a(dH, str2) : null;
        if (a != null) {
            v.a(he, str2, true, he.hC(), iQ);
        } else {
            v.a(he, str2, false, he.hC(), iQ);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.j jVar, byte[] bArr, Rect rect) {
        if (i(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, az.dy(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.o(true);
            cVar.setData(bArr);
            cVar.r(z);
            cVar.q(false);
            com.baidu.adp.lib.Disk.d.fj().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.vy = dVar;
            }
        }
        return aVar2;
    }
}
