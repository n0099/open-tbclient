package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class u extends a {
    private boolean akC;
    private int procType;

    public u(boolean z, int i) {
        this.akC = true;
        this.procType = 0;
        this.akC = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int wx() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.akC;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean wv() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean ww() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a fq = com.baidu.tbadk.core.util.s.fq();
        fq.fA();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c eC = eC(aq.em(str2));
        if (eC == null) {
            return null;
        }
        eC.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        eC.u(true);
        eC.v(false);
        eC.j((Object) bArr);
        eC.w(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(eC);
            aVar.uq = dVar;
        }
        boolean gQ = com.baidu.adp.lib.util.j.gQ();
        if (!com.baidu.adp.lib.Disk.d.dp().c(eC)) {
            com.baidu.tbadk.core.util.s.a(fq, str2, false, fq.fB(), gQ);
            return null;
        }
        int i = 2000;
        if (gQ) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.ImageView.a a = eC.isSuccess() ? a(eC, str2) : null;
        if (a != null) {
            com.baidu.tbadk.core.util.s.a(fq, str2, true, fq.fB(), gQ);
            return a;
        }
        com.baidu.tbadk.core.util.s.a(fq, str2, false, fq.fB(), gQ);
        return a;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (f(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aq.em(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.u(true);
            cVar.setData(bArr);
            cVar.y(z);
            cVar.w(false);
            com.baidu.adp.lib.Disk.d.dp().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.uq = dVar;
            }
        }
        return aVar2;
    }
}
