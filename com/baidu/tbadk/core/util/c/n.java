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
    private boolean ajJ;
    private int procType;

    public n(boolean z, int i) {
        this.ajJ = true;
        this.procType = 0;
        this.ajJ = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int ww() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.ajJ;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wu() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wv() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a fV = r.fV();
        fV.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c ep = ep(an.eb(str2));
        if (ep == null) {
            return null;
        }
        ep.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        ep.s(true);
        ep.t(false);
        ep.k(bArr);
        ep.u(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(ep);
            aVar.xJ = dVar;
        }
        boolean hs = com.baidu.adp.lib.util.i.hs();
        if (!com.baidu.adp.lib.Disk.d.dS().c(ep)) {
            r.a(fV, str2, false, fV.gf(), hs);
            return null;
        }
        int i = 2000;
        if (hs) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = ep.isSuccess() ? a(ep, str2) : null;
        if (a != null) {
            r.a(fV, str2, true, fV.gf(), hs);
            return a;
        }
        r.a(fV, str2, false, fV.gf(), hs);
        return a;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (h(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, an.eb(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.s(true);
            cVar.setData(bArr);
            cVar.v(z);
            cVar.u(false);
            com.baidu.adp.lib.Disk.d.dS().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.xJ = dVar;
            }
        }
        return aVar2;
    }
}
