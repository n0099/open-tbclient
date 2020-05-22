package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class w extends a {
    private boolean aha;
    private int procType;

    public w(boolean z, int i) {
        this.aha = true;
        this.procType = 0;
        this.aha = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int aVp() {
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
        return this.aha;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aVn() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean aVo() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a kY = com.baidu.tbadk.core.util.s.kY();
        kY.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c wD = wD(as.getNameMd5FromUrl(str2));
        if (wD == null) {
            return null;
        }
        wD.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        wD.setSubFolder(true);
        wD.setIsFormatData(false);
        wD.setLock(bArr);
        wD.setSdCard(false);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(wD);
            aVar.Lg = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.jR().c(wD)) {
            com.baidu.tbadk.core.util.s.a(kY, str2, false, kY.getTimeCost(), isWifiNet);
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
        if (!wD.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(wD, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(kY, str2, true, kY.getTimeCost(), isWifiNet);
            return aVar2;
        }
        com.baidu.tbadk.core.util.s.a(kY, str2, false, kY.getTimeCost(), isWifiNet);
        return aVar2;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect, boolean z2) {
        if (r(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            aVar2.setNeedCache(z2);
            if (z2) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setGif(z);
                cVar.setSdCard(false);
                com.baidu.adp.lib.Disk.d.jR().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.Lg = eVar;
                }
            }
        }
        return aVar2;
    }
}
