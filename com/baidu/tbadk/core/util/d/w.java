package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class w extends a {
    private boolean Nj;
    private int procType;

    public w(boolean z, int i) {
        this.Nj = true;
        this.procType = 0;
        this.Nj = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aEG() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.Nj;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEE() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aEF() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a gs = com.baidu.tbadk.core.util.s.gs();
        gs.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c tq = tq(as.getNameMd5FromUrl(str2));
        if (tq == null) {
            return null;
        }
        tq.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        tq.setSubFolder(true);
        tq.setIsFormatData(false);
        tq.setLock(bArr);
        tq.setSdCard(false);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(tq);
            aVar.rS = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.fj().c(tq)) {
            com.baidu.tbadk.core.util.s.a(gs, str2, false, gs.getTimeCost(), isWifiNet);
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
        if (!tq.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(tq, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(gs, str2, true, gs.getTimeCost(), isWifiNet);
            return aVar2;
        }
        com.baidu.tbadk.core.util.s.a(gs, str2, false, gs.getTimeCost(), isWifiNet);
        return aVar2;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (o(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setData(bArr);
            cVar.setGif(z);
            cVar.setSdCard(false);
            com.baidu.adp.lib.Disk.d.fj().c(cVar);
            if (aVar != null) {
                e eVar = new e();
                eVar.f(cVar);
                aVar.rS = eVar;
            }
        }
        return aVar2;
    }
}
