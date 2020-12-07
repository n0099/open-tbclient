package com.baidu.adp.lib.stats.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class d {
    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z) {
        if (aVar != null && aVar.np() != 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.nw(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.c.d.1
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z2) {
                    super.callback(z2);
                    if (z2) {
                        aVar.I(getFileInfo().length());
                        if (z || aVar.ny() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                            d.c(aVar, false, false, false);
                        }
                    }
                }
            };
            dVar.setSdCard(aVar.nM());
            dVar.setContent(aVar.nJ().toString());
            aVar.nB();
            if (!aVar.nO()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            if (!com.baidu.adp.lib.Disk.d.lL().c(dVar)) {
            }
        }
    }

    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2, final boolean z3) {
        if (aVar != null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), aVar.nw(), BdStatisticsManager.getInstance().getWriteDir(), aVar.nx(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.c.d.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z4) {
                    super.callback(z4);
                    if (z4) {
                        aVar.I(0L);
                        com.baidu.adp.lib.stats.upload.b.nW().a(aVar, z, z2, z3);
                    } else if (aVar.ny() >= BdStatsConstant.MAX_WRITTING_FILE_SIZE_AFTER_RENAME_FAILED && aVar.nE() != "stat") {
                        d.a(BdStatisticsManager.getInstance().getWriteDir(), aVar.nx(), aVar);
                    }
                }
            };
            diskFileOperate.setSdCard(aVar.nM());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.lL().c(diskFileOperate);
        }
    }

    public static long f(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.ny() <= 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.nw(), DiskFileOperate.Action.INFO) { // from class: com.baidu.adp.lib.stats.c.d.3
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z) {
                    super.callback(z);
                    if (z) {
                        aVar.I(getFileInfo().length());
                    }
                }
            };
            dVar.setSdCard(aVar.nM());
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.lL().c(dVar)) {
                return aVar.ny();
            }
        }
        return aVar.ny();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.setSdCard(aVar.nM());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.lL().c(diskFileOperate);
    }
}
