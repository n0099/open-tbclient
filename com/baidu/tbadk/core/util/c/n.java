package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes.dex */
public class n extends a {
    private boolean aje;
    private int procType;

    public n(boolean z, int i) {
        this.aje = true;
        this.procType = 0;
        this.aje = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wu() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aje;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean ws() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wt() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a fL = s.fL();
        fL.fU();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c el = el(ao.dX(str2));
        if (el == null) {
            return null;
        }
        el.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        el.t(true);
        el.u(false);
        el.j(bArr);
        el.v(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(el);
            aVar.vC = dVar;
        }
        boolean hj = com.baidu.adp.lib.util.i.hj();
        if (!com.baidu.adp.lib.Disk.d.dI().c(el)) {
            s.a(fL, str2, false, fL.fV(), hj);
            return null;
        }
        int i = 2000;
        if (hj) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = el.isSuccess() ? a(el, str2) : null;
        if (a != null) {
            s.a(fL, str2, true, fL.fV(), hj);
            return a;
        }
        s.a(fL, str2, false, fL.fV(), hj);
        return a;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (d(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ao.dX(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.t(true);
            cVar.setData(bArr);
            cVar.w(z);
            cVar.v(false);
            com.baidu.adp.lib.Disk.d.dI().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.vC = dVar;
            }
        }
        return aVar2;
    }
}
