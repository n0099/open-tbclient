package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class d {
    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null && aVar.ep() != 0) {
            e eVar = new e(com.baidu.adp.lib.stats.a.dO().dS(), aVar.eu(), DiskFileOperate.Action.APPEND, aVar, z);
            eVar.p(aVar.eF());
            eVar.setContent(aVar.eD().toString());
            aVar.ey();
            if (!aVar.eG()) {
                eVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                eVar.H(3);
            }
            com.baidu.adp.lib.Disk.d.bH().c(eVar);
        }
    }

    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar != null) {
            f fVar = new f(com.baidu.adp.lib.stats.a.dO().dS(), aVar.eu(), com.baidu.adp.lib.stats.a.dO().dS(), aVar.ev(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
            fVar.p(aVar.eF());
            fVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.bH().c(fVar);
        }
    }

    public static long a(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.ew() <= 0) {
            g gVar = new g(com.baidu.adp.lib.stats.a.dO().dS(), aVar.eu(), DiskFileOperate.Action.INFO, aVar);
            gVar.p(aVar.eF());
            gVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.bH().c(gVar)) {
                return aVar.ew();
            }
        }
        return aVar.ew();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.p(aVar.eF());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.bH().c(diskFileOperate);
    }
}
