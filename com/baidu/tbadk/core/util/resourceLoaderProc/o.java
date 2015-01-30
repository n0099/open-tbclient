package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class o extends a {
    private boolean Lg;

    public o(boolean z) {
        this.Lg = true;
        this.Lg = z;
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
        return this.Lg;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qq() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qr() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.q ed = w.ed();
        ed.eK();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cQ = cQ(bh.cH(str2));
        if (cQ == null) {
            return null;
        }
        cQ.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cQ.o(true);
        cQ.p(false);
        cQ.g(bArr);
        cQ.q(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(cQ);
            aVar.lf = dVar;
        }
        boolean fg = com.baidu.adp.lib.util.i.fg();
        if (!com.baidu.adp.lib.Disk.d.bM().c(cQ)) {
            w.a(ed, str2, false, ed.eL(), fg);
            return null;
        }
        int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        if (fg) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = cQ.isSuccess() ? a(cQ, str2) : null;
        if (a != null) {
            w.a(ed, str2, true, ed.eL(), fg);
        } else {
            w.a(ed, str2, false, ed.eL(), fg);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.httpNet.i iVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bh.cH(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.o(true);
            cVar.setData(bArr);
            cVar.r(z);
            cVar.q(false);
            com.baidu.adp.lib.Disk.d.bM().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.g(cVar);
                aVar.lf = dVar;
            }
        }
        return aVar2;
    }
}
