package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z) {
        if (aVar != null && aVar.gf() != 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.gk(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.d.1
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void p(boolean z2) {
                    super.p(z2);
                    if (z2) {
                        aVar.i(dV().length());
                        if (z || aVar.gm() > 102400) {
                            d.c(aVar, false, false, false);
                        }
                    }
                }
            };
            dVar.v(aVar.gv());
            dVar.setContent(aVar.gt().toString());
            aVar.go();
            if (!aVar.gw()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.W(3);
            }
            if (!com.baidu.adp.lib.Disk.d.dH().c(dVar)) {
            }
        }
    }

    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2, final boolean z3) {
        if (aVar != null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), aVar.gk(), BdStatisticsManager.getInstance().getWriteDir(), aVar.gl(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.d.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void p(boolean z4) {
                    super.p(z4);
                    if (z4) {
                        aVar.i(0L);
                        com.baidu.adp.lib.stats.upload.b.gF().a(aVar, z, z2, z3);
                    } else if (aVar.gm() >= 307200 && aVar.gq() != "stat") {
                        d.a(BdStatisticsManager.getInstance().getWriteDir(), aVar.gl(), aVar);
                    }
                }
            };
            diskFileOperate.v(aVar.gv());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.dH().c(diskFileOperate);
        }
    }

    public static long a(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.gm() <= 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.gk(), DiskFileOperate.Action.INFO) { // from class: com.baidu.adp.lib.stats.b.d.3
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void p(boolean z) {
                    super.p(z);
                    if (z) {
                        aVar.i(dV().length());
                    }
                }
            };
            dVar.v(aVar.gv());
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.dH().c(dVar)) {
                return aVar.gm();
            }
        }
        return aVar.gm();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.v(aVar.gv());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.dH().c(diskFileOperate);
    }
}
