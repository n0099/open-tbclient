package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z) {
        if (aVar != null && aVar.fL() != 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.fQ(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.d.1
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void q(boolean z2) {
                    super.q(z2);
                    if (z2) {
                        aVar.j(dD().length());
                        if (z || aVar.fS() > 102400) {
                            d.c(aVar, false, false, false);
                        }
                    }
                }
            };
            dVar.w(aVar.gb());
            dVar.setContent(aVar.fZ().toString());
            aVar.fU();
            if (!aVar.gd()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.P(3);
            }
            if (!com.baidu.adp.lib.Disk.d.dp().c(dVar)) {
            }
        }
    }

    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z, final boolean z2, final boolean z3) {
        if (aVar != null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getWriteDir(), aVar.fQ(), BdStatisticsManager.getInstance().getWriteDir(), aVar.fR(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.d.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void q(boolean z4) {
                    super.q(z4);
                    if (z4) {
                        aVar.j(0L);
                        com.baidu.adp.lib.stats.upload.b.gm().a(aVar, z, z2, z3);
                    } else if (aVar.fS() >= 307200 && aVar.fW() != "stat") {
                        d.a(BdStatisticsManager.getInstance().getWriteDir(), aVar.fR(), aVar);
                    }
                }
            };
            diskFileOperate.w(aVar.gb());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.dp().c(diskFileOperate);
        }
    }

    public static long a(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.fS() <= 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getWriteDir(), aVar.fQ(), DiskFileOperate.Action.INFO) { // from class: com.baidu.adp.lib.stats.b.d.3
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void q(boolean z) {
                    super.q(z);
                    if (z) {
                        aVar.j(dD().length());
                    }
                }
            };
            dVar.w(aVar.gb());
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.dp().c(dVar)) {
                return aVar.fS();
            }
        }
        return aVar.fS();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.w(aVar.gb());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.dp().c(diskFileOperate);
    }
}
