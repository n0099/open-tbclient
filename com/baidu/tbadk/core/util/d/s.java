package com.baidu.tbadk.core.util.d;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class s extends a {
    private boolean alQ;
    private int procType;

    public s(boolean z, int i) {
        this.alQ = true;
        this.procType = 0;
        this.alQ = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bwM() {
        return com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bwN() {
        return com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bwO() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return this.alQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.adp.widget.ImageView.a aVar = null;
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c Cl = Cl(av.getNameMd5FromUrl(str2));
        if (Cl == null) {
            return null;
        }
        Cl.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        Cl.setSubFolder(true);
        Cl.setIsFormatData(false);
        Cl.setLock(bArr);
        Cl.setSdCard(false);
        if (bVar != null) {
            d dVar = new d();
            dVar.f(Cl);
            bVar.Np = dVar;
        }
        if (!com.baidu.adp.lib.Disk.d.lh().c(Cl)) {
            com.baidu.adp.lib.e.a.c(false, 0L);
            return null;
        }
        int i3 = 2000;
        if (com.baidu.adp.lib.util.j.isWifiNet()) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (Cl.isSuccess()) {
            aVar = a(Cl, str2, i, i2);
        }
        com.baidu.adp.lib.e.a.c(aVar != null, System.currentTimeMillis() - currentTimeMillis);
        return aVar;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public void a(String str, byte[] bArr, Object... objArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && ((Boolean) objArr[0]).booleanValue()) {
            boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, av.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setData(bArr);
            cVar.setSdCard(false);
            cVar.setGif(booleanValue);
            com.baidu.adp.lib.Disk.d.lh().c(cVar);
            com.baidu.adp.lib.e.b bVar = (com.baidu.adp.lib.e.b) objArr[3];
            if (bVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                bVar.Np = dVar;
            }
        }
    }
}
