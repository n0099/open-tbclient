package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z) {
        if (aVar != null && aVar.jU() != 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.jZ(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.d.1
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void O(boolean z2) {
                    super.O(z2);
                    if (z2) {
                        aVar.q(hO().length());
                        if (z || aVar.kb() > 102400) {
                            d.c(aVar, false, false, false);
                        }
                    }
                }
            };
            dVar.T(aVar.kk());
            dVar.setContent(aVar.ki().toString());
            aVar.kd();
            if (!aVar.kl()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.ap(3);
            }
            if (!com.baidu.adp.lib.Disk.d.hB().c(dVar)) {
            }
        }
    }

    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2, final boolean z3) {
        if (aVar != null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), aVar.jZ(), BdStatisticsManager.getInstance().getWriteDir(), aVar.ka(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.d.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void O(boolean z4) {
                    super.O(z4);
                    if (z4) {
                        aVar.q(0L);
                        com.baidu.adp.lib.stats.upload.b.ku().a(aVar, z, z2, z3);
                    } else if (aVar.kb() >= 307200 && aVar.kf() != "stat") {
                        d.a(BdStatisticsManager.getInstance().getWriteDir(), aVar.ka(), aVar);
                    }
                }
            };
            diskFileOperate.T(aVar.kk());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.hB().c(diskFileOperate);
        }
    }

    public static long a(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.kb() <= 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.jZ(), DiskFileOperate.Action.INFO) { // from class: com.baidu.adp.lib.stats.b.d.3
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void O(boolean z) {
                    super.O(z);
                    if (z) {
                        aVar.q(hO().length());
                    }
                }
            };
            dVar.T(aVar.kk());
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.hB().c(dVar)) {
                return aVar.kb();
            }
        }
        return aVar.kb();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.T(aVar.kk());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.hB().c(diskFileOperate);
    }
}
