package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class c {
    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null && aVar.hM() != 0) {
            d dVar = new d(com.baidu.adp.lib.stats.a.hl().hp(), aVar.hR(), DiskFileOperate.Action.APPEND, aVar, z);
            dVar.q(aVar.ic());
            dVar.setContent(aVar.ia().toString());
            aVar.hV();
            if (!aVar.id()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.J(3);
            }
            com.baidu.adp.lib.Disk.d.fj().c(dVar);
        }
    }

    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar != null) {
            e eVar = new e(com.baidu.adp.lib.stats.a.hl().hp(), aVar.hR(), com.baidu.adp.lib.stats.a.hl().hp(), aVar.hS(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
            eVar.q(aVar.ic());
            eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fj().c(eVar);
        }
    }

    public static long a(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.hT() <= 0) {
            f fVar = new f(com.baidu.adp.lib.stats.a.hl().hp(), aVar.hR(), DiskFileOperate.Action.INFO, aVar);
            fVar.q(aVar.ic());
            fVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.fj().c(fVar)) {
                return aVar.hT();
            }
        }
        return aVar.hT();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.q(aVar.ic());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.fj().c(diskFileOperate);
    }
}
