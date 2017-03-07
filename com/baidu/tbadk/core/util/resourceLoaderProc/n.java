package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class n extends a {
    private boolean ahO;
    private int procType;

    public n(boolean z, int i) {
        this.ahO = true;
        this.procType = 0;
        this.ahO = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wh() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.ahO;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wg() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.c fH = u.fH();
        fH.fQ();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dK = dK(aw.dx(str2));
        if (dK == null) {
            return null;
        }
        dK.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dK.s(true);
        dK.t(false);
        dK.k((Object) bArr);
        dK.u(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dK);
            aVar.wz = dVar;
        }
        boolean hf = com.baidu.adp.lib.util.i.hf();
        if (!com.baidu.adp.lib.Disk.d.dI().c(dK)) {
            u.a(fH, str2, false, fH.fR(), hf);
            return null;
        }
        int i = 2000;
        if (hf) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dK.isSuccess() ? a(dK, str2) : null;
        if (a != null) {
            u.a(fH, str2, true, fH.fR(), hf);
        } else {
            u.a(fH, str2, false, fH.fR(), hf);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (h(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.dx(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.s(true);
            cVar.setData(bArr);
            cVar.v(z);
            cVar.u(false);
            com.baidu.adp.lib.Disk.d.dI().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.wz = dVar;
            }
        }
        return aVar2;
    }
}
