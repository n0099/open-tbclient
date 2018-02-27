package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class s extends a {
    private boolean aYX;
    private int procType;

    public s(boolean z, int i) {
        this.aYX = true;
        this.procType = 0;
        this.aYX = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int DK() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.aYX;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean DJ() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a nn = com.baidu.tbadk.core.util.s.nn();
        nn.nw();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c eK = eK(ap.eu(str2));
        if (eK == null) {
            return null;
        }
        eK.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        eK.ab(true);
        eK.ac(false);
        eK.ao(bArr);
        eK.ad(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(eK);
            aVar.ajM = dVar;
        }
        boolean oK = com.baidu.adp.lib.util.j.oK();
        if (!com.baidu.adp.lib.Disk.d.ll().c(eK)) {
            com.baidu.tbadk.core.util.s.a(nn, str2, false, nn.nx(), oK);
            return null;
        }
        int i = 2000;
        if (oK) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = eK.isSuccess() ? a(eK, str2) : null;
        if (a != null) {
            com.baidu.tbadk.core.util.s.a(nn, str2, true, nn.nx(), oK);
            return a;
        }
        com.baidu.tbadk.core.util.s.a(nn, str2, false, nn.nx(), oK);
        return a;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (i(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ap.eu(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.ab(true);
            cVar.setData(bArr);
            cVar.af(z);
            cVar.ad(false);
            com.baidu.adp.lib.Disk.d.ll().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.ajM = dVar;
            }
        }
        return aVar2;
    }
}
