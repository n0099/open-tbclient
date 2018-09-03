package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class v extends a {
    private boolean asS;
    private int procType;

    public v(boolean z, int i) {
        this.asS = true;
        this.procType = 0;
        this.asS = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Aa() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.asS;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zY() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zZ() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a ii = com.baidu.tbadk.core.util.t.ii();
        ii.ir();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c fc = fc(as.eM(str2));
        if (fc == null) {
            return null;
        }
        fc.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        fc.u(true);
        fc.v(false);
        fc.m(bArr);
        fc.w(false);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(fc);
            aVar.Ao = eVar;
        }
        boolean jF = com.baidu.adp.lib.util.j.jF();
        if (!com.baidu.adp.lib.Disk.d.ge().c(fc)) {
            com.baidu.tbadk.core.util.t.a(ii, str2, false, ii.is(), jF);
            return null;
        }
        int i = 2000;
        if (jF) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.ImageView.a a = fc.isSuccess() ? a(fc, str2) : null;
        if (a != null) {
            com.baidu.tbadk.core.util.t.a(ii, str2, true, ii.is(), jF);
            return a;
        }
        com.baidu.tbadk.core.util.t.a(ii, str2, false, ii.is(), jF);
        return a;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (e(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.eM(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.u(true);
            cVar.setData(bArr);
            cVar.y(z);
            cVar.w(false);
            com.baidu.adp.lib.Disk.d.ge().c(cVar);
            if (aVar != null) {
                e eVar = new e();
                eVar.f(cVar);
                aVar.Ao = eVar;
            }
        }
        return aVar2;
    }
}
