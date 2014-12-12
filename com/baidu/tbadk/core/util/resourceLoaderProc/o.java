package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class o extends a {
    private boolean KM;

    public o(boolean z) {
        this.KM = true;
        this.KM = z;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.M(TbadkCoreApplication.m255getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.N(TbadkCoreApplication.m255getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.KM;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qg() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.q ef = w.ef();
        ef.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cR = cR(bc.cI(str2));
        if (cR == null) {
            return null;
        }
        cR.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cR.o(true);
        cR.p(false);
        cR.g(bArr);
        cR.q(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(cR);
            aVar.lc = dVar;
        }
        boolean fh = com.baidu.adp.lib.util.i.fh();
        if (!com.baidu.adp.lib.Disk.d.bO().c(cR)) {
            w.a(ef, str2, false, ef.eM(), fh);
            return null;
        }
        int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        if (fh) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = cR.isSuccess() ? a(cR, str2) : null;
        if (a != null) {
            w.a(ef, str2, true, ef.eM(), fh);
        } else {
            w.a(ef, str2, false, ef.eM(), fh);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.httpNet.i iVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bc.cI(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.o(true);
            cVar.setData(bArr);
            cVar.r(z);
            cVar.q(false);
            com.baidu.adp.lib.Disk.d.bO().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.g(cVar);
                aVar.lc = dVar;
            }
        }
        return aVar2;
    }
}
