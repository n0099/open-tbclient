package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z) {
        if (aVar != null && aVar.iB() != 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.iG(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.d.1
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void t(boolean z2) {
                    super.t(z2);
                    if (z2) {
                        aVar.l(gt().length());
                        if (z || aVar.iI() > 102400) {
                            d.c(aVar, false, false, false);
                        }
                    }
                }
            };
            dVar.y(aVar.iR());
            dVar.setContent(aVar.iP().toString());
            aVar.iK();
            if (!aVar.iS()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.Q(3);
            }
            if (!com.baidu.adp.lib.Disk.d.gf().c(dVar)) {
            }
        }
    }

    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2, final boolean z3) {
        if (aVar != null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), aVar.iG(), BdStatisticsManager.getInstance().getWriteDir(), aVar.iH(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.d.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void t(boolean z4) {
                    super.t(z4);
                    if (z4) {
                        aVar.l(0L);
                        com.baidu.adp.lib.stats.upload.b.jb().a(aVar, z, z2, z3);
                    } else if (aVar.iI() >= 307200 && aVar.iM() != "stat") {
                        d.a(BdStatisticsManager.getInstance().getWriteDir(), aVar.iH(), aVar);
                    }
                }
            };
            diskFileOperate.y(aVar.iR());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.gf().c(diskFileOperate);
        }
    }

    public static long a(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.iI() <= 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.iG(), DiskFileOperate.Action.INFO) { // from class: com.baidu.adp.lib.stats.b.d.3
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void t(boolean z) {
                    super.t(z);
                    if (z) {
                        aVar.l(gt().length());
                    }
                }
            };
            dVar.y(aVar.iR());
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.gf().c(dVar)) {
                return aVar.iI();
            }
        }
        return aVar.iI();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.y(aVar.iR());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.gf().c(diskFileOperate);
    }
}
