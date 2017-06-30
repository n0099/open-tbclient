package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class d {
    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null && aVar.gh() != 0) {
            e eVar = new e(BdStatisticsManager.getInstance().getWriteDir(), aVar.gm(), DiskFileOperate.Action.APPEND, aVar, z);
            eVar.u(aVar.gx());
            eVar.setContent(aVar.gv().toString());
            aVar.gq();
            if (!aVar.gy()) {
                eVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                eVar.W(3);
            }
            com.baidu.adp.lib.Disk.d.dI().c(eVar);
        }
    }

    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar != null) {
            f fVar = new f(BdStatisticsManager.getInstance().getWriteDir(), aVar.gm(), BdStatisticsManager.getInstance().getWriteDir(), aVar.gn(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
            fVar.u(aVar.gx());
            fVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.dI().c(fVar);
        }
    }

    public static long a(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.go() <= 0) {
            g gVar = new g(BdStatisticsManager.getInstance().getWriteDir(), aVar.gm(), DiskFileOperate.Action.INFO, aVar);
            gVar.u(aVar.gx());
            gVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.dI().c(gVar)) {
                return aVar.go();
            }
        }
        return aVar.go();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.u(aVar.gx());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.dI().c(diskFileOperate);
    }
}
