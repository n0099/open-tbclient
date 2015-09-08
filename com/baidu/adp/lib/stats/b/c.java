package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class c {
    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null && aVar.hI() != 0) {
            d dVar = new d(com.baidu.adp.lib.stats.a.hh().hl(), aVar.hN(), DiskFileOperate.Action.APPEND, aVar, z);
            dVar.q(aVar.hY());
            dVar.setContent(aVar.hW().toString());
            aVar.hR();
            if (!aVar.hZ()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.I(3);
            }
            com.baidu.adp.lib.Disk.d.fj().c(dVar);
        }
    }

    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar != null) {
            e eVar = new e(com.baidu.adp.lib.stats.a.hh().hl(), aVar.hN(), com.baidu.adp.lib.stats.a.hh().hl(), aVar.hO(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
            eVar.q(aVar.hY());
            eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fj().c(eVar);
        }
    }

    public static long a(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.hP() <= 0) {
            f fVar = new f(com.baidu.adp.lib.stats.a.hh().hl(), aVar.hN(), DiskFileOperate.Action.INFO, aVar);
            fVar.q(aVar.hY());
            fVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.fj().c(fVar)) {
                return aVar.hP();
            }
        }
        return aVar.hP();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.q(aVar.hY());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.fj().c(diskFileOperate);
    }
}
