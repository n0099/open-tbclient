package com.baidu.adp.lib.stats.b;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class h {
    public static void c(final com.baidu.adp.lib.stats.base.a aVar, final boolean z) {
        if (aVar != null && aVar.lv() != 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.lA(), DiskFileOperate.Action.APPEND) { // from class: com.baidu.adp.lib.stats.b.h.1
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z2) {
                    super.callback(z2);
                    if (z2) {
                        aVar.M(getFileInfo().length());
                        if (z || aVar.lv() > 20480) {
                            h.p(aVar);
                        }
                    }
                }
            };
            dVar.setSdCard(aVar.lR());
            dVar.setContent(aVar.lP().toString());
            aVar.lH();
            if (!aVar.lS()) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.setTrySuccessWeight(3);
            }
            if (!com.baidu.adp.lib.Disk.d.jP().c(dVar)) {
                BdLog.e("Track Log write to disk fail!");
            }
        }
    }

    public static void p(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar != null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.lA(), BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.lB(), DiskFileOperate.Action.RENAME) { // from class: com.baidu.adp.lib.stats.b.h.2
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z) {
                    super.callback(z);
                    if (z) {
                        aVar.M(0L);
                        com.baidu.adp.lib.stats.upload.b.ma().b(aVar);
                        return;
                    }
                    BdLog.e("Track Log rename fail!");
                }
            };
            diskFileOperate.setSdCard(aVar.lR());
            diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            com.baidu.adp.lib.Disk.d.jP().c(diskFileOperate);
        }
    }

    public static long f(final com.baidu.adp.lib.stats.base.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        if (aVar.lE() <= 0) {
            com.baidu.adp.lib.Disk.ops.d dVar = new com.baidu.adp.lib.Disk.ops.d(BdStatisticsManager.getInstance().getTrackLogWriteDir(), aVar.lA(), DiskFileOperate.Action.INFO) { // from class: com.baidu.adp.lib.stats.b.h.3
                @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
                public void callback(boolean z) {
                    super.callback(z);
                    if (z) {
                        aVar.M(getFileInfo().length());
                    }
                }
            };
            dVar.setSdCard(aVar.lR());
            dVar.a(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (com.baidu.adp.lib.Disk.d.jP().c(dVar)) {
                return aVar.lE();
            }
        }
        return aVar.lE();
    }
}
