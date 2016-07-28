package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class d {
    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null && aVar.eo() != 0) {
            e eVar = new e(com.baidu.adp.lib.stats.a.dN().dR(), aVar.et(), DiskFileOperate.Action.APPEND, aVar, z);
            eVar.r(aVar.eE());
            eVar.setContent(aVar.eC().toString());
            aVar.ex();
            if (!aVar.eF()) {
                eVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                eVar.K(3);
            }
            com.baidu.adp.lib.Disk.d.bG().c(eVar);
        }
    }

    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar != null) {
            f fVar = new f(com.baidu.adp.lib.stats.a.dN().dR(), aVar.et(), com.baidu.adp.lib.stats.a.dN().dR(), aVar.eu(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
            fVar.r(aVar.eE());
            fVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.bG().c(fVar);
        }
    }

    public static long a(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.ev() <= 0) {
            g gVar = new g(com.baidu.adp.lib.stats.a.dN().dR(), aVar.et(), DiskFileOperate.Action.INFO, aVar);
            gVar.r(aVar.eE());
            gVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.bG().c(gVar)) {
                return aVar.ev();
            }
        }
        return aVar.ev();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.r(aVar.eE());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.bG().c(diskFileOperate);
    }
}
