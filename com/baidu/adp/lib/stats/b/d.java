package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z) {
        if (aVar != null && aVar.iQ() != 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.iV(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.d.1
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void G(boolean z2) {
                    super.G(z2);
                    if (z2) {
                        aVar.l(gH().length());
                        if (z || aVar.iX() > 102400) {
                            d.c(aVar, false, false, false);
                        }
                    }
                }
            };
            dVar.L(aVar.jg());
            dVar.setContent(aVar.je().toString());
            aVar.iZ();
            if (!aVar.jh()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.Q(3);
            }
            if (!com.baidu.adp.lib.Disk.d.gt().c(dVar)) {
            }
        }
    }

    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2, final boolean z3) {
        if (aVar != null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), aVar.iV(), BdStatisticsManager.getInstance().getWriteDir(), aVar.iW(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.d.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void G(boolean z4) {
                    super.G(z4);
                    if (z4) {
                        aVar.l(0L);
                        com.baidu.adp.lib.stats.upload.b.jq().a(aVar, z, z2, z3);
                    } else if (aVar.iX() >= 307200 && aVar.jb() != "stat") {
                        d.a(BdStatisticsManager.getInstance().getWriteDir(), aVar.iW(), aVar);
                    }
                }
            };
            diskFileOperate.L(aVar.jg());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.gt().c(diskFileOperate);
        }
    }

    public static long a(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.iX() <= 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.iV(), DiskFileOperate.Action.INFO) { // from class: com.baidu.adp.lib.stats.b.d.3
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void G(boolean z) {
                    super.G(z);
                    if (z) {
                        aVar.l(gH().length());
                    }
                }
            };
            dVar.L(aVar.jg());
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.gt().c(dVar)) {
                return aVar.iX();
            }
        }
        return aVar.iX();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.L(aVar.jg());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.gt().c(diskFileOperate);
    }
}
