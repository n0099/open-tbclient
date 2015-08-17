package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class c {
    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null && aVar.hL() != 0) {
            d dVar = new d(com.baidu.adp.lib.stats.a.hk().ho(), aVar.hQ(), DiskFileOperate.Action.APPEND, aVar, z);
            dVar.q(aVar.ib());
            dVar.setContent(aVar.hZ().toString());
            aVar.hU();
            if (!aVar.ic()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.I(3);
            }
            com.baidu.adp.lib.Disk.d.fm().c(dVar);
        }
    }

    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar != null) {
            e eVar = new e(com.baidu.adp.lib.stats.a.hk().ho(), aVar.hQ(), com.baidu.adp.lib.stats.a.hk().ho(), aVar.hR(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
            eVar.q(aVar.ib());
            eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fm().c(eVar);
        }
    }

    public static long a(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.hS() <= 0) {
            f fVar = new f(com.baidu.adp.lib.stats.a.hk().ho(), aVar.hQ(), DiskFileOperate.Action.INFO, aVar);
            fVar.q(aVar.ib());
            fVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.fm().c(fVar)) {
                return aVar.hS();
            }
        }
        return aVar.hS();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.q(aVar.ib());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.fm().c(diskFileOperate);
    }
}
