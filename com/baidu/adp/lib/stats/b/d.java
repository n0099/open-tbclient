package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z) {
        if (aVar != null && aVar.nH() != 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.nM(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.d.1
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void Y(boolean z2) {
                    super.Y(z2);
                    if (z2) {
                        aVar.r(lz().length());
                        if (z || aVar.nO() > 102400) {
                            d.c(aVar, false, false, false);
                        }
                    }
                }
            };
            dVar.ad(aVar.nX());
            dVar.setContent(aVar.nV().toString());
            aVar.nQ();
            if (!aVar.nY()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.cP(3);
            }
            if (!com.baidu.adp.lib.Disk.d.ll().c(dVar)) {
            }
        }
    }

    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2, final boolean z3) {
        if (aVar != null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), aVar.nM(), BdStatisticsManager.getInstance().getWriteDir(), aVar.nN(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.d.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void Y(boolean z4) {
                    super.Y(z4);
                    if (z4) {
                        aVar.r(0L);
                        com.baidu.adp.lib.stats.upload.b.oh().a(aVar, z, z2, z3);
                    } else if (aVar.nO() >= 307200 && aVar.nS() != "stat") {
                        d.a(BdStatisticsManager.getInstance().getWriteDir(), aVar.nN(), aVar);
                    }
                }
            };
            diskFileOperate.ad(aVar.nX());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.ll().c(diskFileOperate);
        }
    }

    public static long a(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.nO() <= 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.nM(), DiskFileOperate.Action.INFO) { // from class: com.baidu.adp.lib.stats.b.d.3
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void Y(boolean z) {
                    super.Y(z);
                    if (z) {
                        aVar.r(lz().length());
                    }
                }
            };
            dVar.ad(aVar.nX());
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.ll().c(dVar)) {
                return aVar.nO();
            }
        }
        return aVar.nO();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.ad(aVar.nX());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.ll().c(diskFileOperate);
    }
}
