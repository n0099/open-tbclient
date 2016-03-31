package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class c {
    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null && aVar.ia() != 0) {
            d dVar = new d(com.baidu.adp.lib.stats.a.hz().hD(), aVar.ih(), DiskFileOperate.Action.APPEND, aVar, z);
            dVar.p(aVar.it());
            dVar.setContent(aVar.ir().toString());
            aVar.il();
            if (!aVar.iu()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.T(3);
            }
            com.baidu.adp.lib.Disk.d.fs().c(dVar);
        }
    }

    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z, boolean z2, boolean z3) {
        if (aVar != null) {
            e eVar = new e(com.baidu.adp.lib.stats.a.hz().hD(), aVar.ih(), com.baidu.adp.lib.stats.a.hz().hD(), aVar.ii(), DiskFileOperate.Action.RENAME, aVar, z, z2, z3);
            eVar.p(aVar.it());
            eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fs().c(eVar);
        }
    }

    public static long a(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.ij() <= 0) {
            f fVar = new f(com.baidu.adp.lib.stats.a.hz().hD(), aVar.ih(), DiskFileOperate.Action.INFO, aVar);
            fVar.p(aVar.it());
            fVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.fs().c(fVar)) {
                return aVar.ij();
            }
        }
        return aVar.ij();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.p(aVar.it());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.fs().c(diskFileOperate);
    }
}
