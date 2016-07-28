package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class n extends a {
    private int Yd;
    private boolean aav;

    public n(boolean z, int i) {
        this.aav = true;
        this.Yd = 0;
        this.aav = z;
        this.Yd = i;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int uJ() {
        return this.Yd;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m10getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.aav;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uH() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d dG = v.dG();
        dG.ed();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dN = dN(bc.dA(str2));
        if (dN == null) {
            return null;
        }
        dN.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dN.p(true);
        dN.q(false);
        dN.k((Object) bArr);
        dN.r(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dN);
            aVar.mz = dVar;
        }
        boolean fr = com.baidu.adp.lib.util.i.fr();
        if (!com.baidu.adp.lib.Disk.d.bG().c(dN)) {
            v.a(dG, str2, false, dG.ee(), fr);
            return null;
        }
        int i = 2000;
        if (fr) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dN.isSuccess() ? a(dN, str2) : null;
        if (a != null) {
            v.a(dG, str2, true, dG.ee(), fr);
        } else {
            v.a(dG, str2, false, dG.ee(), fr);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bc.dA(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.p(true);
            cVar.setData(bArr);
            cVar.s(z);
            cVar.r(false);
            com.baidu.adp.lib.Disk.d.bG().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.mz = dVar;
            }
        }
        return aVar2;
    }
}
