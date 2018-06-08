package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class u extends a {
    private boolean asK;
    private int procType;

    public u(boolean z, int i) {
        this.asK = true;
        this.procType = 0;
        this.asK = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int zX() {
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
        return this.asK;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zV() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zW() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a ih = com.baidu.tbadk.core.util.t.ih();
        ih.iq();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c fb = fb(ar.eL(str2));
        if (fb == null) {
            return null;
        }
        fb.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        fb.w(true);
        fb.x(false);
        fb.m(bArr);
        fb.y(false);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(fb);
            aVar.As = dVar;
        }
        boolean jE = com.baidu.adp.lib.util.j.jE();
        if (!com.baidu.adp.lib.Disk.d.gf().c(fb)) {
            com.baidu.tbadk.core.util.t.a(ih, str2, false, ih.ir(), jE);
            return null;
        }
        int i = 2000;
        if (jE) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.ImageView.a a = fb.isSuccess() ? a(fb, str2) : null;
        if (a != null) {
            com.baidu.tbadk.core.util.t.a(ih, str2, true, ih.ir(), jE);
            return a;
        }
        com.baidu.tbadk.core.util.t.a(ih, str2, false, ih.ir(), jE);
        return a;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (e(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ar.eL(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.w(true);
            cVar.setData(bArr);
            cVar.A(z);
            cVar.y(false);
            com.baidu.adp.lib.Disk.d.gf().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.As = dVar;
            }
        }
        return aVar2;
    }
}
