package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class d {
    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z) {
        if (aVar != null && aVar.lL() != 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.lS(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.d.1
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z2) {
                    super.callback(z2);
                    if (z2) {
                        aVar.K(getFileInfo().length());
                        if (z || aVar.lU() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT) {
                            d.c(aVar, false, false, false);
                        }
                    }
                }
            };
            dVar.setSdCard(aVar.mi());
            dVar.setContent(aVar.mf().toString());
            aVar.lX();
            if (!aVar.mk()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            if (!com.baidu.adp.lib.Disk.d.kh().c(dVar)) {
            }
        }
    }

    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2, final boolean z3) {
        if (aVar != null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), aVar.lS(), BdStatisticsManager.getInstance().getWriteDir(), aVar.lT(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.d.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z4) {
                    super.callback(z4);
                    if (z4) {
                        aVar.K(0L);
                        com.baidu.adp.lib.stats.upload.b.ms().a(aVar, z, z2, z3);
                    } else if (aVar.lU() >= BdStatsConstant.MAX_WRITTING_FILE_SIZE_AFTER_RENAME_FAILED && aVar.ma() != "stat") {
                        d.a(BdStatisticsManager.getInstance().getWriteDir(), aVar.lT(), aVar);
                    }
                }
            };
            diskFileOperate.setSdCard(aVar.mi());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.kh().c(diskFileOperate);
        }
    }

    public static long f(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.lU() <= 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.lS(), DiskFileOperate.Action.INFO) { // from class: com.baidu.adp.lib.stats.b.d.3
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z) {
                    super.callback(z);
                    if (z) {
                        aVar.K(getFileInfo().length());
                    }
                }
            };
            dVar.setSdCard(aVar.mi());
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.kh().c(dVar)) {
                return aVar.lU();
            }
        }
        return aVar.lU();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.setSdCard(aVar.mi());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.kh().c(diskFileOperate);
    }
}
