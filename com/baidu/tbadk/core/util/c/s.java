package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class s extends a {
    private boolean aXt;
    private int procType;

    public s(boolean z, int i) {
        this.aXt = true;
        this.procType = 0;
        this.aXt = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int Dy() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aXt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dw() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Dx() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a nm = com.baidu.tbadk.core.util.s.nm();
        nm.nv();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c er = er(ao.ee(str2));
        if (er == null) {
            return null;
        }
        er.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        er.Z(true);
        er.aa(false);
        er.ao(bArr);
        er.ab(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(er);
            aVar.ajQ = dVar;
        }
        boolean oJ = com.baidu.adp.lib.util.j.oJ();
        if (!com.baidu.adp.lib.Disk.d.ll().c(er)) {
            com.baidu.tbadk.core.util.s.a(nm, str2, false, nm.nw(), oJ);
            return null;
        }
        int i = 2000;
        if (oJ) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = er.isSuccess() ? a(er, str2) : null;
        if (a != null) {
            com.baidu.tbadk.core.util.s.a(nm, str2, true, nm.nw(), oJ);
            return a;
        }
        com.baidu.tbadk.core.util.s.a(nm, str2, false, nm.nw(), oJ);
        return a;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ao.ee(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.Z(true);
            cVar.setData(bArr);
            cVar.ac(z);
            cVar.ab(false);
            com.baidu.adp.lib.Disk.d.ll().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.ajQ = dVar;
            }
        }
        return aVar2;
    }
}
