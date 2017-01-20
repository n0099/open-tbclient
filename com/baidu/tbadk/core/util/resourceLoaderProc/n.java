package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.t;
/* loaded from: classes.dex */
public class n extends a {
    private boolean acy;
    private int procType;

    public n(boolean z, int i) {
        this.acy = true;
        this.procType = 0;
        this.acy = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int vK() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.acy;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean vJ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d ez = t.ez();
        ez.eW();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dQ = dQ(av.dD(str2));
        if (dQ == null) {
            return null;
        }
        dQ.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dQ.r(true);
        dQ.s(false);
        dQ.k((Object) bArr);
        dQ.t(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dQ);
            aVar.oO = dVar;
        }
        boolean gl = com.baidu.adp.lib.util.i.gl();
        if (!com.baidu.adp.lib.Disk.d.cz().c(dQ)) {
            t.a(ez, str2, false, ez.eX(), gl);
            return null;
        }
        int i = 2000;
        if (gl) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dQ.isSuccess() ? a(dQ, str2) : null;
        if (a != null) {
            t.a(ez, str2, true, ez.eX(), gl);
        } else {
            t.a(ez, str2, false, ez.eX(), gl);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (h(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, av.dD(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.r(true);
            cVar.setData(bArr);
            cVar.u(z);
            cVar.t(false);
            com.baidu.adp.lib.Disk.d.cz().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.oO = dVar;
            }
        }
        return aVar2;
    }
}
