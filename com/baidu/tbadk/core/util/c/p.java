package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes.dex */
public class p extends a {
    private boolean aiR;
    private int procType;

    public p(boolean z, int i) {
        this.aiR = true;
        this.procType = 0;
        this.aiR = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vZ() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.ae(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aiR;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vX() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vY() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a fK = s.fK();
        fK.fT();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c ei = ei(ao.dV(str2));
        if (ei == null) {
            return null;
        }
        ei.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        ei.t(true);
        ei.u(false);
        ei.j(bArr);
        ei.v(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(ei);
            aVar.vF = dVar;
        }
        boolean hi = com.baidu.adp.lib.util.j.hi();
        if (!com.baidu.adp.lib.Disk.d.dH().c(ei)) {
            s.a(fK, str2, false, fK.fU(), hi);
            return null;
        }
        int i = 2000;
        if (hi) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = ei.isSuccess() ? a(ei, str2) : null;
        if (a != null) {
            s.a(fK, str2, true, fK.fU(), hi);
            return a;
        }
        s.a(fK, str2, false, fK.fU(), hi);
        return a;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (d(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ao.dV(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.t(true);
            cVar.setData(bArr);
            cVar.w(z);
            cVar.v(false);
            com.baidu.adp.lib.Disk.d.dH().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.vF = dVar;
            }
        }
        return aVar2;
    }
}
