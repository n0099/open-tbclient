package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class n extends a {
    private int abD;
    private boolean adX;

    public n(boolean z, int i) {
        this.adX = true;
        this.abD = 0;
        this.adX = z;
        this.abD = i;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int xd() {
        return this.abD;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m411getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return this.adX;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean xb() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean xc() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d hs = v.hs();
        hs.hP();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dO = dO(ba.dB(str2));
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
            aVar.wb = dVar;
        }
        boolean jg = com.baidu.adp.lib.util.i.jg();
        if (!com.baidu.adp.lib.Disk.d.fs().c(dO)) {
            v.a(hs, str2, false, hs.hQ(), jg);
            return null;
        }
        int i = 2000;
        if (jg) {
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
            v.a(hs, str2, true, hs.hQ(), jg);
        } else {
            v.a(hs, str2, false, hs.hQ(), jg);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (e(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ba.dB(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.n(true);
            cVar.setData(bArr);
            cVar.q(z);
            cVar.p(false);
            com.baidu.adp.lib.Disk.d.fs().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.wb = dVar;
            }
        }
        return aVar2;
    }
}
