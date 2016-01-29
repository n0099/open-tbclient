package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class c {
    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null && aVar.hU() != 0) {
            d dVar = new d(com.baidu.adp.lib.stats.a.ht().hx(), aVar.hZ(), DiskFileOperate.Action.APPEND, aVar, z);
            dVar.q(aVar.in());
            dVar.setContent(aVar.ik().toString());
            aVar.ie();
            if (!aVar.io()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.U(3);
            }
            com.baidu.adp.lib.Disk.d.fr().c(dVar);
        }
    }

    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar != null) {
            e eVar = new e(com.baidu.adp.lib.stats.a.ht().hx(), aVar.hZ(), com.baidu.adp.lib.stats.a.ht().hx(), aVar.ia(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
            eVar.q(aVar.in());
            eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fr().c(eVar);
        }
    }

    public static long a(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.ib() <= 0) {
            f fVar = new f(com.baidu.adp.lib.stats.a.ht().hx(), aVar.hZ(), DiskFileOperate.Action.INFO, aVar);
            fVar.q(aVar.in());
            fVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.fr().c(fVar)) {
                return aVar.ib();
            }
        }
        return aVar.ib();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.q(aVar.in());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.fr().c(diskFileOperate);
    }
}
