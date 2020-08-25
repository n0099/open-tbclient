package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes2.dex */
public class x extends a {
    private boolean ajr;
    private int procType;

    public x(boolean z, int i) {
        this.ajr = true;
        this.procType = 0;
        this.ajr = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bjK() {
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
        return this.ajr;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bjI() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bjJ() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a mN = com.baidu.tbadk.core.util.u.mN();
        mN.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c Aq = Aq(av.getNameMd5FromUrl(str2));
        if (Aq == null) {
            return null;
        }
        Aq.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        Aq.setSubFolder(true);
        Aq.setIsFormatData(false);
        Aq.setLock(bArr);
        Aq.setSdCard(false);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(Aq);
            aVar.Mn = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.lG().c(Aq)) {
            com.baidu.tbadk.core.util.u.a(mN, str2, false, mN.getTimeCost(), isWifiNet);
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
        if (!Aq.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(Aq, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.u.a(mN, str2, true, mN.getTimeCost(), isWifiNet);
            return aVar2;
        }
        com.baidu.tbadk.core.util.u.a(mN, str2, false, mN.getTimeCost(), isWifiNet);
        return aVar2;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect, boolean z2) {
        if (v(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            aVar2.setNeedCache(z2);
            if (z2) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, av.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setGif(z);
                cVar.setSdCard(false);
                com.baidu.adp.lib.Disk.d.lG().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.Mn = eVar;
                }
            }
        }
        return aVar2;
    }
}
