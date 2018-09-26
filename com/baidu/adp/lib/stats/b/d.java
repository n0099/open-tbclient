package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z) {
        if (aVar != null && aVar.jI() != 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.jN(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.d.1
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void A(boolean z2) {
                    super.A(z2);
                    if (z2) {
                        aVar.o(hz().length());
                        if (z || aVar.jP() > 102400) {
                            d.c(aVar, false, false, false);
                        }
                    }
                }
            };
            dVar.F(aVar.jY());
            dVar.setContent(aVar.jW().toString());
            aVar.jR();
            if (!aVar.jZ()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.Y(3);
            }
            if (!com.baidu.adp.lib.Disk.d.hl().c(dVar)) {
            }
        }
    }

    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2, final boolean z3) {
        if (aVar != null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), aVar.jN(), BdStatisticsManager.getInstance().getWriteDir(), aVar.jO(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.d.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void A(boolean z4) {
                    super.A(z4);
                    if (z4) {
                        aVar.o(0L);
                        com.baidu.adp.lib.stats.upload.b.ki().a(aVar, z, z2, z3);
                    } else if (aVar.jP() >= 307200 && aVar.jT() != "stat") {
                        d.a(BdStatisticsManager.getInstance().getWriteDir(), aVar.jO(), aVar);
                    }
                }
            };
            diskFileOperate.F(aVar.jY());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.hl().c(diskFileOperate);
        }
    }

    public static long a(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.jP() <= 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.jN(), DiskFileOperate.Action.INFO) { // from class: com.baidu.adp.lib.stats.b.d.3
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void A(boolean z) {
                    super.A(z);
                    if (z) {
                        aVar.o(hz().length());
                    }
                }
            };
            dVar.F(aVar.jY());
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.hl().c(dVar)) {
                return aVar.jP();
            }
        }
        return aVar.jP();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.F(aVar.jY());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.hl().c(diskFileOperate);
    }
}
