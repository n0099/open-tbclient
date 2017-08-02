package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class n extends a {
    private boolean aiq;
    private int procType;

    public n(boolean z, int i) {
        this.aiq = true;
        this.procType = 0;
        this.aiq = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wm() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aiq;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wl() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a fK = r.fK();
        fK.fT();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c ej = ej(an.dV(str2));
        if (ej == null) {
            return null;
        }
        ej.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        ej.s(true);
        ej.t(false);
        ej.k((Object) bArr);
        ej.u(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(ej);
            aVar.wh = dVar;
        }
        boolean hi = com.baidu.adp.lib.util.i.hi();
        if (!com.baidu.adp.lib.Disk.d.dH().c(ej)) {
            r.a(fK, str2, false, fK.fU(), hi);
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
        com.baidu.adp.widget.a.a a = ej.isSuccess() ? a(ej, str2) : null;
        if (a != null) {
            r.a(fK, str2, true, fK.fU(), hi);
            return a;
        }
        r.a(fK, str2, false, fK.fU(), hi);
        return a;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, an.dV(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.s(true);
            cVar.setData(bArr);
            cVar.v(z);
            cVar.u(false);
            com.baidu.adp.lib.Disk.d.dH().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.wh = dVar;
            }
        }
        return aVar2;
    }
}
