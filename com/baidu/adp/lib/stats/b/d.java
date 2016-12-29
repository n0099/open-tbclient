package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class d {
    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null && aVar.fj() != 0) {
            e eVar = new e(com.baidu.adp.lib.stats.a.eI().eM(), aVar.fo(), DiskFileOperate.Action.APPEND, aVar, z);
            eVar.t(aVar.fz());
            eVar.setContent(aVar.fx().toString());
            aVar.fs();
            if (!aVar.fA()) {
                eVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                eVar.Y(3);
            }
            com.baidu.adp.lib.Disk.d.cB().c(eVar);
        }
    }

    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar != null) {
            f fVar = new f(com.baidu.adp.lib.stats.a.eI().eM(), aVar.fo(), com.baidu.adp.lib.stats.a.eI().eM(), aVar.fp(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
            fVar.t(aVar.fz());
            fVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.cB().c(fVar);
        }
    }

    public static long a(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.fq() <= 0) {
            g gVar = new g(com.baidu.adp.lib.stats.a.eI().eM(), aVar.fo(), DiskFileOperate.Action.INFO, aVar);
            gVar.t(aVar.fz());
            gVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.cB().c(gVar)) {
                return aVar.fq();
            }
        }
        return aVar.fq();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.t(aVar.fz());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.cB().c(diskFileOperate);
    }
}
