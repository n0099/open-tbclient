package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class v extends a {
    private boolean XI;
    private int procType;

    public v(boolean z, int i) {
        this.XI = true;
        this.procType = 0;
        this.XI = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aiQ() {
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
        return this.XI;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aiO() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aiP() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a iw = com.baidu.tbadk.core.util.s.iw();
        iw.iF();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c oj = oj(as.nS(str2));
        if (oj == null) {
            return null;
        }
        oj.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        oj.J(true);
        oj.K(false);
        oj.q(bArr);
        oj.L(false);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(oj);
            aVar.Be = eVar;
        }
        boolean jT = com.baidu.adp.lib.util.j.jT();
        if (!com.baidu.adp.lib.Disk.d.gt().c(oj)) {
            com.baidu.tbadk.core.util.s.a(iw, str2, false, iw.iG(), jT);
            return null;
        }
        int i3 = 2000;
        if (jT) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!oj.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(oj, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(iw, str2, true, iw.iG(), jT);
            return aVar2;
        }
        com.baidu.tbadk.core.util.s.a(iw, str2, false, iw.iG(), jT);
        return aVar2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (m(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.nS(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.J(true);
            cVar.setData(bArr);
            cVar.O(z);
            cVar.L(false);
            com.baidu.adp.lib.Disk.d.gt().c(cVar);
            if (aVar != null) {
                e eVar = new e();
                eVar.f(cVar);
                aVar.Be = eVar;
            }
        }
        return aVar2;
    }
}
