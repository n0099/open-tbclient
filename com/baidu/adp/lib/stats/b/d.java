package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z) {
        if (aVar != null && aVar.nG() != 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.nL(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.d.1
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void W(boolean z2) {
                    super.W(z2);
                    if (z2) {
                        aVar.r(lz().length());
                        if (z || aVar.nN() > 102400) {
                            d.c(aVar, false, false, false);
                        }
                    }
                }
            };
            dVar.ab(aVar.nW());
            dVar.setContent(aVar.nU().toString());
            aVar.nP();
            if (!aVar.nX()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.cP(3);
            }
            if (!com.baidu.adp.lib.Disk.d.ll().c(dVar)) {
            }
        }
    }

    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2, final boolean z3) {
        if (aVar != null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), aVar.nL(), BdStatisticsManager.getInstance().getWriteDir(), aVar.nM(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.d.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void W(boolean z4) {
                    super.W(z4);
                    if (z4) {
                        aVar.r(0L);
                        com.baidu.adp.lib.stats.upload.b.og().a(aVar, z, z2, z3);
                    } else if (aVar.nN() >= 307200 && aVar.nR() != "stat") {
                        d.a(BdStatisticsManager.getInstance().getWriteDir(), aVar.nM(), aVar);
                    }
                }
            };
            diskFileOperate.ab(aVar.nW());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.ll().c(diskFileOperate);
        }
    }

    public static long a(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.nN() <= 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.nL(), DiskFileOperate.Action.INFO) { // from class: com.baidu.adp.lib.stats.b.d.3
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void W(boolean z) {
                    super.W(z);
                    if (z) {
                        aVar.r(lz().length());
                    }
                }
            };
            dVar.ab(aVar.nW());
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.ll().c(dVar)) {
                return aVar.nN();
            }
        }
        return aVar.nN();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.ab(aVar.nW());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.ll().c(diskFileOperate);
    }
}
