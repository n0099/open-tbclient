package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class v extends a {
    private boolean atn;
    private int procType;

    public v(boolean z, int i) {
        this.atn = true;
        this.procType = 0;
        this.atn = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Am() {
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
        return this.atn;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ak() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Al() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a ih = com.baidu.tbadk.core.util.t.ih();
        ih.iq();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c fe = fe(as.eO(str2));
        if (fe == null) {
            return null;
        }
        fe.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        fe.w(true);
        fe.x(false);
        fe.m(bArr);
        fe.y(false);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(fe);
            aVar.As = eVar;
        }
        boolean jE = com.baidu.adp.lib.util.j.jE();
        if (!com.baidu.adp.lib.Disk.d.gf().c(fe)) {
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
        com.baidu.adp.widget.ImageView.a a = fe.isSuccess() ? a(fe, str2) : null;
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
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.eO(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.w(true);
            cVar.setData(bArr);
            cVar.A(z);
            cVar.y(false);
            com.baidu.adp.lib.Disk.d.gf().c(cVar);
            if (aVar != null) {
                e eVar = new e();
                eVar.f(cVar);
                aVar.As = eVar;
            }
        }
        return aVar2;
    }
}
