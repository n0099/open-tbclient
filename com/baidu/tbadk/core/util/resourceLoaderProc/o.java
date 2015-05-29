package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.t;
/* loaded from: classes.dex */
public class o extends a {
    private boolean Xs;

    public o(boolean z) {
        this.Xs = true;
        this.Xs = z;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.Xs;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean ue() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.q hm = t.hm();
        hm.hU();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dk = dk(bd.db(str2));
        if (dk == null) {
            return null;
        }
        dk.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dk.o(true);
        dk.p(false);
        dk.g(bArr);
        dk.q(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dk);
            aVar.vx = dVar;
        }
        boolean iY = com.baidu.adp.lib.util.k.iY();
        if (!com.baidu.adp.lib.Disk.d.fp().c(dk)) {
            t.a(hm, str2, false, hm.hV(), iY);
            return null;
        }
        int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        if (iY) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dk.isSuccess() ? a(dk, str2) : null;
        if (a != null) {
            t.a(hm, str2, true, hm.hV(), iY);
        } else {
            t.a(hm, str2, false, hm.hV(), iY);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.httpNet.h hVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bd.db(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.o(true);
            cVar.setData(bArr);
            cVar.r(z);
            cVar.q(false);
            com.baidu.adp.lib.Disk.d.fp().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.vx = dVar;
            }
        }
        return aVar2;
    }
}
