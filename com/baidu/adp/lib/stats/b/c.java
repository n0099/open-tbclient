package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class c {
    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null && aVar.hJ() != 0) {
            d dVar = new d(com.baidu.adp.lib.stats.a.hi().hm(), aVar.hO(), DiskFileOperate.Action.APPEND, aVar, z);
            dVar.q(aVar.hZ());
            dVar.setContent(aVar.hX().toString());
            aVar.hS();
            if (!aVar.ia()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.I(3);
            }
            com.baidu.adp.lib.Disk.d.fj().c(dVar);
        }
    }

    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar != null) {
            e eVar = new e(com.baidu.adp.lib.stats.a.hi().hm(), aVar.hO(), com.baidu.adp.lib.stats.a.hi().hm(), aVar.hP(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
            eVar.q(aVar.hZ());
            eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fj().c(eVar);
        }
    }

    public static long a(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.hQ() <= 0) {
            f fVar = new f(com.baidu.adp.lib.stats.a.hi().hm(), aVar.hO(), DiskFileOperate.Action.INFO, aVar);
            fVar.q(aVar.hZ());
            fVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.fj().c(fVar)) {
                return aVar.hQ();
            }
        }
        return aVar.hQ();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.q(aVar.hZ());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.fj().c(diskFileOperate);
    }
}
