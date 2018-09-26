package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class v extends a {
    private boolean avq;
    private int procType;

    public v(boolean z, int i) {
        this.avq = true;
        this.procType = 0;
        this.avq = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Bf() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.avq;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Bd() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Be() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a jo = com.baidu.tbadk.core.util.s.jo();
        jo.jx();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c fu = fu(ar.fe(str2));
        if (fu == null) {
            return null;
        }
        fu.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        fu.D(true);
        fu.E(false);
        fu.n(bArr);
        fu.F(false);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(fu);
            aVar.CI = eVar;
        }
        boolean kL = com.baidu.adp.lib.util.j.kL();
        if (!com.baidu.adp.lib.Disk.d.hl().c(fu)) {
            com.baidu.tbadk.core.util.s.a(jo, str2, false, jo.jy(), kL);
            return null;
        }
        int i3 = 2000;
        if (kL) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!fu.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(fu, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(jo, str2, true, jo.jy(), kL);
            return aVar2;
        }
        com.baidu.tbadk.core.util.s.a(jo, str2, false, jo.jy(), kL);
        return aVar2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (f(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ar.fe(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.D(true);
            cVar.setData(bArr);
            cVar.I(z);
            cVar.F(false);
            com.baidu.adp.lib.Disk.d.hl().c(cVar);
            if (aVar != null) {
                e eVar = new e();
                eVar.f(cVar);
                aVar.CI = eVar;
            }
        }
        return aVar2;
    }
}
