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
    private int Xu;
    private boolean ZM;

    public n(boolean z, int i) {
        this.ZM = true;
        this.Xu = 0;
        this.ZM = z;
        this.Xu = i;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int uJ() {
        return this.Xu;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m9getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.ZM;
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
        com.baidu.adp.lib.stats.d dH = v.dH();
        dH.ee();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dO = dO(bc.dB(str2));
        if (dO == null) {
            return null;
        }
        dO.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dO.n(true);
        dO.o(false);
        dO.h((Object) bArr);
        dO.p(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dO);
            aVar.lU = dVar;
        }
        boolean fs = com.baidu.adp.lib.util.i.fs();
        if (!com.baidu.adp.lib.Disk.d.bH().c(dO)) {
            v.a(dH, str2, false, dH.ef(), fs);
            return null;
        }
        int i = 2000;
        if (fs) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dO.isSuccess() ? a(dO, str2) : null;
        if (a != null) {
            v.a(dH, str2, true, dH.ef(), fs);
        } else {
            v.a(dH, str2, false, dH.ef(), fs);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (d(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bc.dB(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.n(true);
            cVar.setData(bArr);
            cVar.q(z);
            cVar.p(false);
            com.baidu.adp.lib.Disk.d.bH().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.lU = dVar;
            }
        }
        return aVar2;
    }
}
