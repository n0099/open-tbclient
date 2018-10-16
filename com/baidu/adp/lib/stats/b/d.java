package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z) {
        if (aVar != null && aVar.jW() != 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.kb(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.d.1
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void A(boolean z2) {
                    super.A(z2);
                    if (z2) {
                        aVar.o(hP().length());
                        if (z || aVar.kd() > 102400) {
                            d.c(aVar, false, false, false);
                        }
                    }
                }
            };
            dVar.F(aVar.km());
            dVar.setContent(aVar.kk().toString());
            aVar.kf();
            if (!aVar.kn()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.Y(3);
            }
            if (!com.baidu.adp.lib.Disk.d.hC().c(dVar)) {
            }
        }
    }

    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2, final boolean z3) {
        if (aVar != null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), aVar.kb(), BdStatisticsManager.getInstance().getWriteDir(), aVar.kc(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.d.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void A(boolean z4) {
                    super.A(z4);
                    if (z4) {
                        aVar.o(0L);
                        com.baidu.adp.lib.stats.upload.b.kw().a(aVar, z, z2, z3);
                    } else if (aVar.kd() >= 307200 && aVar.kh() != "stat") {
                        d.a(BdStatisticsManager.getInstance().getWriteDir(), aVar.kc(), aVar);
                    }
                }
            };
            diskFileOperate.F(aVar.km());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.hC().c(diskFileOperate);
        }
    }

    public static long a(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.kd() <= 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.kb(), DiskFileOperate.Action.INFO) { // from class: com.baidu.adp.lib.stats.b.d.3
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void A(boolean z) {
                    super.A(z);
                    if (z) {
                        aVar.o(hP().length());
                    }
                }
            };
            dVar.F(aVar.km());
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.hC().c(dVar)) {
                return aVar.kd();
            }
        }
        return aVar.kd();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.F(aVar.km());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.hC().c(diskFileOperate);
    }
}
