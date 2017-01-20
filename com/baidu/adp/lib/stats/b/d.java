package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class d {
    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null && aVar.fh() != 0) {
            e eVar = new e(com.baidu.adp.lib.stats.a.eG().eK(), aVar.fm(), DiskFileOperate.Action.APPEND, aVar, z);
            eVar.t(aVar.fx());
            eVar.setContent(aVar.fv().toString());
            aVar.fq();
            if (!aVar.fy()) {
                eVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                eVar.Y(3);
            }
            com.baidu.adp.lib.Disk.d.cz().c(eVar);
        }
    }

    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar != null) {
            f fVar = new f(com.baidu.adp.lib.stats.a.eG().eK(), aVar.fm(), com.baidu.adp.lib.stats.a.eG().eK(), aVar.fn(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
            fVar.t(aVar.fx());
            fVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.cz().c(fVar);
        }
    }

    public static long a(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.fo() <= 0) {
            g gVar = new g(com.baidu.adp.lib.stats.a.eG().eK(), aVar.fm(), DiskFileOperate.Action.INFO, aVar);
            gVar.t(aVar.fx());
            gVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.cz().c(gVar)) {
                return aVar.fo();
            }
        }
        return aVar.fo();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.t(aVar.fx());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.cz().c(diskFileOperate);
    }
}
