package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
/* loaded from: classes.dex */
public class n extends a {
    private boolean aid;
    private int procType;

    public n(boolean z, int i) {
        this.aid = true;
        this.procType = 0;
        this.aid = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wE() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aid;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wC() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wD() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.c fN = u.fN();
        fN.fW();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dQ = dQ(aw.dD(str2));
        if (dQ == null) {
            return null;
        }
        dQ.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dQ.s(true);
        dQ.t(false);
        dQ.k((Object) bArr);
        dQ.u(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dQ);
            aVar.wg = dVar;
        }
        boolean hl = com.baidu.adp.lib.util.i.hl();
        if (!com.baidu.adp.lib.Disk.d.dI().c(dQ)) {
            u.a(fN, str2, false, fN.fX(), hl);
            return null;
        }
        int i = 2000;
        if (hl) {
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
            u.a(fN, str2, true, fN.fX(), hl);
        } else {
            u.a(fN, str2, false, fN.fX(), hl);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.dD(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.s(true);
            cVar.setData(bArr);
            cVar.v(z);
            cVar.u(false);
            com.baidu.adp.lib.Disk.d.dI().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.wg = dVar;
            }
        }
        return aVar2;
    }
}
