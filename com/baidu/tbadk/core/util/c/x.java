package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class x extends a {
    private boolean aib;
    private int procType;

    public x(boolean z, int i) {
        this.aib = true;
        this.procType = 0;
        this.aib = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bbl() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return this.aib;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bbj() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bbk() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a lo = com.baidu.tbadk.core.util.u.lo();
        lo.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c yc = yc(au.getNameMd5FromUrl(str2));
        if (yc == null) {
            return null;
        }
        yc.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        yc.setSubFolder(true);
        yc.setIsFormatData(false);
        yc.setLock(bArr);
        yc.setSdCard(false);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(yc);
            aVar.LH = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.kh().c(yc)) {
            com.baidu.tbadk.core.util.u.a(lo, str2, false, lo.getTimeCost(), isWifiNet);
            return null;
        }
        int i3 = 2000;
        if (isWifiNet) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!yc.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(yc, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.u.a(lo, str2, true, lo.getTimeCost(), isWifiNet);
            return aVar2;
        }
        com.baidu.tbadk.core.util.u.a(lo, str2, false, lo.getTimeCost(), isWifiNet);
        return aVar2;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect, boolean z2) {
        if (v(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            aVar2.setNeedCache(z2);
            if (z2) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, au.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setGif(z);
                cVar.setSdCard(false);
                com.baidu.adp.lib.Disk.d.kh().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.LH = eVar;
                }
            }
        }
        return aVar2;
    }
}
