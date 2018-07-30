package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z) {
        if (aVar != null && aVar.iC() != 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.iH(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.d.1
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void q(boolean z2) {
                    super.q(z2);
                    if (z2) {
                        aVar.l(gs().length());
                        if (z || aVar.iJ() > 102400) {
                            d.c(aVar, false, false, false);
                        }
                    }
                }
            };
            dVar.w(aVar.iS());
            dVar.setContent(aVar.iQ().toString());
            aVar.iL();
            if (!aVar.iT()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.Q(3);
            }
            if (!com.baidu.adp.lib.Disk.d.ge().c(dVar)) {
            }
        }
    }

    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2, final boolean z3) {
        if (aVar != null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), aVar.iH(), BdStatisticsManager.getInstance().getWriteDir(), aVar.iI(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.d.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void q(boolean z4) {
                    super.q(z4);
                    if (z4) {
                        aVar.l(0L);
                        com.baidu.adp.lib.stats.upload.b.jc().a(aVar, z, z2, z3);
                    } else if (aVar.iJ() >= 307200 && aVar.iN() != "stat") {
                        d.a(BdStatisticsManager.getInstance().getWriteDir(), aVar.iI(), aVar);
                    }
                }
            };
            diskFileOperate.w(aVar.iS());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.ge().c(diskFileOperate);
        }
    }

    public static long a(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.iJ() <= 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.iH(), DiskFileOperate.Action.INFO) { // from class: com.baidu.adp.lib.stats.b.d.3
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void q(boolean z) {
                    super.q(z);
                    if (z) {
                        aVar.l(gs().length());
                    }
                }
            };
            dVar.w(aVar.iS());
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.ge().c(dVar)) {
                return aVar.iJ();
            }
        }
        return aVar.iJ();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.w(aVar.iS());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.ge().c(diskFileOperate);
    }
}
