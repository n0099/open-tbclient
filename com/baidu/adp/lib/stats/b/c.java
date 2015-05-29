package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
/* loaded from: classes.dex */
public class c {
    public static void c(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null && aVar.ib() != 0) {
            d dVar = new d(com.baidu.adp.lib.h.a.iB().iC(), aVar.id(), DiskFileOperate.Action.APPEND, aVar, z);
            dVar.q(aVar.ij());
            dVar.setContent(aVar.ii().toString());
            aVar.clearMemData();
            if (!aVar.ik()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.G(3);
            }
            com.baidu.adp.lib.Disk.d.fp().c(dVar);
        }
    }

    public static void d(com.baidu.adp.lib.stats.base.a aVar, boolean z) {
        if (aVar != null) {
            e eVar = new e(com.baidu.adp.lib.h.a.iB().iC(), aVar.id(), com.baidu.adp.lib.h.a.iB().iC(), aVar.getUploadingLogFile(), DiskFileOperate.Action.RENAME, aVar, z);
            eVar.q(aVar.ij());
            eVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.fp().c(eVar);
        }
    }

    public static long c(com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.ie() <= 0) {
            f fVar = new f(com.baidu.adp.lib.h.a.iB().iC(), aVar.id(), DiskFileOperate.Action.INFO, aVar);
            fVar.q(aVar.ij());
            fVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.fp().c(fVar)) {
                return aVar.ie();
            }
        }
        return aVar.ie();
    }

    public static void a(String str, String str2, com.baidu.adp.lib.stats.base.a aVar) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(str, str2, DiskFileOperate.Action.DELETE);
        diskFileOperate.q(aVar.ij());
        diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        com.baidu.adp.lib.Disk.d.fp().c(diskFileOperate);
    }
}
