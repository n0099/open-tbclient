package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class n extends a {
    private boolean ahU;
    private int procType;

    public n(boolean z, int i) {
        this.ahU = true;
        this.procType = 0;
        this.ahU = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wg() {
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
        return this.ahU;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean we() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.c fM = w.fM();
        fM.fV();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c eg = eg(ay.dS(str2));
        if (eg == null) {
            return null;
        }
        eg.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        eg.s(true);
        eg.t(false);
        eg.k((Object) bArr);
        eg.u(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(eg);
            aVar.wg = dVar;
        }
        boolean hk = com.baidu.adp.lib.util.i.hk();
        if (!com.baidu.adp.lib.Disk.d.dI().c(eg)) {
            w.a(fM, str2, false, fM.fW(), hk);
            return null;
        }
        int i = 2000;
        if (hk) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = eg.isSuccess() ? a(eg, str2) : null;
        if (a != null) {
            w.a(fM, str2, true, fM.fW(), hk);
        } else {
            w.a(fM, str2, false, fM.fW(), hk);
        }
        return a;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ay.dS(str2), DiskFileOperate.Action.WRITE);
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
