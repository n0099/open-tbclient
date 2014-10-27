package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class n extends a {
    private boolean GC;

    public n(boolean z) {
        this.GC = true;
        this.GC = z;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.m.n(TbadkApplication.m251getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return com.baidu.adp.lib.util.m.o(TbadkApplication.m251getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.GC;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nl() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        q logItem = v.getLogItem();
        logItem.eL();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c bZ = bZ(ba.bQ(str2));
        if (bZ == null) {
            return null;
        }
        bZ.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        bZ.k(true);
        bZ.l(false);
        bZ.b(bArr);
        bZ.m(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(bZ);
            aVar.lb = dVar;
        }
        boolean fi = com.baidu.adp.lib.util.j.fi();
        if (!com.baidu.adp.lib.Disk.d.bn().c(bZ)) {
            v.a(logItem, str2, false, logItem.eM(), fi);
            return null;
        }
        int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        if (fi) {
            i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = bZ.isSuccess() ? a(bZ, str2) : null;
        if (a != null) {
            v.a(logItem, str2, true, logItem.eM(), fi);
        } else {
            v.a(logItem, str2, false, logItem.eM(), fi);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.httpNet.k kVar, byte[] bArr, Rect rect) {
        if (d(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ba.bQ(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.k(true);
            cVar.setData(bArr);
            cVar.n(z);
            cVar.m(false);
            com.baidu.adp.lib.Disk.d.bn().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.g(cVar);
                aVar.lb = dVar;
            }
        }
        return aVar2;
    }
}
