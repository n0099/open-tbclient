package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class n extends a {
    private int abD;
    private boolean adU;

    public n(boolean z, int i) {
        this.adU = true;
        this.abD = 0;
        this.adU = z;
        this.abD = i;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int wg() {
        return this.abD;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.adU;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean we() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean wf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d eB = u.eB();
        eB.eY();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dU = dU(az.dH(str2));
        if (dU == null) {
            return null;
        }
        dU.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dU.r(true);
        dU.s(false);
        dU.k((Object) bArr);
        dU.t(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dU);
            aVar.oV = dVar;
        }
        boolean gn = com.baidu.adp.lib.util.i.gn();
        if (!com.baidu.adp.lib.Disk.d.cB().c(dU)) {
            u.a(eB, str2, false, eB.eZ(), gn);
            return null;
        }
        int i = 2000;
        if (gn) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dU.isSuccess() ? a(dU, str2) : null;
        if (a != null) {
            u.a(eB, str2, true, eB.eZ(), gn);
        } else {
            u.a(eB, str2, false, eB.eZ(), gn);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (h(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, az.dH(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.r(true);
            cVar.setData(bArr);
            cVar.u(z);
            cVar.t(false);
            com.baidu.adp.lib.Disk.d.cB().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.oV = dVar;
            }
        }
        return aVar2;
    }
}
