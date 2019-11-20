package com.baidu.tbadk.core.util.e;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class w extends a {
    private boolean Hx;
    private int procType;

    public w(boolean z, int i) {
        this.Hx = true;
        this.procType = 0;
        this.Hx = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int ani() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean isFromCDN() {
        return this.Hx;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean ang() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public boolean anh() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.e.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a fU = com.baidu.tbadk.core.util.s.fU();
        fU.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c oi = oi(as.getNameMd5FromUrl(str2));
        if (oi == null) {
            return null;
        }
        oi.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        oi.setSubFolder(true);
        oi.setIsFormatData(false);
        oi.setLock(bArr);
        oi.setSdCard(false);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(oi);
            aVar.pi = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.eP().c(oi)) {
            com.baidu.tbadk.core.util.s.a(fU, str2, false, fU.getTimeCost(), isWifiNet);
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
        if (!oi.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(oi, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(fU, str2, true, fU.getTimeCost(), isWifiNet);
            return aVar2;
        }
        com.baidu.tbadk.core.util.s.a(fU, str2, false, fU.getTimeCost(), isWifiNet);
        return aVar2;
    }

    @Override // com.baidu.tbadk.core.util.e.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (o(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setData(bArr);
            cVar.setGif(z);
            cVar.setSdCard(false);
            com.baidu.adp.lib.Disk.d.eP().c(cVar);
            if (aVar != null) {
                e eVar = new e();
                eVar.f(cVar);
                aVar.pi = eVar;
            }
        }
        return aVar2;
    }
}
