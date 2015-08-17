package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class n extends a {
    private boolean acq;

    public n(boolean z) {
        this.acq = true;
        this.acq = z;
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
        return this.acq;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vi() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vj() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d hd = r.hd();
        hd.hA();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dl = dl(as.dc(str2));
        if (dl == null) {
            return null;
        }
        dl.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dl.o(true);
        dl.p(false);
        dl.h(bArr);
        dl.q(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dl);
            aVar.vt = dVar;
        }
        boolean iP = com.baidu.adp.lib.util.i.iP();
        if (!com.baidu.adp.lib.Disk.d.fm().c(dl)) {
            r.a(hd, str2, false, hd.hB(), iP);
            return null;
        }
        int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        if (iP) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dl.isSuccess() ? a(dl, str2) : null;
        if (a != null) {
            r.a(hd, str2, true, hd.hB(), iP);
        } else {
            r.a(hd, str2, false, hd.hB(), iP);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.httpNet.i iVar, byte[] bArr, Rect rect) {
        if (i(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.dc(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.o(true);
            cVar.setData(bArr);
            cVar.r(z);
            cVar.q(false);
            com.baidu.adp.lib.Disk.d.fm().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.vt = dVar;
            }
        }
        return aVar2;
    }
}
