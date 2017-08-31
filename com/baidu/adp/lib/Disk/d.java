package com.baidu.adp.lib.Disk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class d {
    private static BdUniqueId qS = BdUniqueId.gen();
    private static BdUniqueId qT = BdUniqueId.gen();
    private static d qW = null;
    private b qQ;
    private final int qU = 10;
    private final int qV = 5;
    private BdAsyncTaskParallel qX;
    private BdAsyncTaskParallel qY;

    public static d dI() {
        if (qW == null) {
            synchronized (d.class) {
                if (qW == null) {
                    qW = new d();
                }
            }
        }
        return qW;
    }

    private d() {
        this.qQ = null;
        this.qX = null;
        this.qY = null;
        this.qX = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.qY = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.qQ = new b();
    }

    public void I(String str) {
        this.qQ.H(str);
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean dJ = new e(this.qQ, diskFileOperate).dJ();
        diskFileOperate.p(dJ);
        return dJ;
    }

    public boolean c(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.dX()) {
            return a(diskFileOperate, qS, this.qX, 10);
        }
        return a(diskFileOperate, qT, this.qY, 5);
    }

    private boolean a(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel, int i) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.dU() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(bdUniqueId) < diskFileOperate.dY() + i) {
            return a(diskFileOperate, bdUniqueId, bdAsyncTaskParallel);
        }
        return false;
    }

    public void d(DiskFileOperate diskFileOperate) {
        String e = e(diskFileOperate);
        if (e != null) {
            BdAsyncTask.removeAllTask(qS, e);
            BdAsyncTask.removeAllTask(qT, e);
        }
    }

    private String e(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return null;
        }
        if (diskFileOperate.getPath() == null) {
            return diskFileOperate.getName() + "|" + diskFileOperate.hashCode();
        }
        return diskFileOperate.getPath() + "/" + diskFileOperate.getName() + "|" + diskFileOperate.hashCode();
    }

    private boolean a(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel) {
        c cVar = new c(this.qQ, diskFileOperate);
        cVar.setTag(bdUniqueId);
        cVar.setParallel(bdAsyncTaskParallel);
        cVar.setPriority(4);
        cVar.setKey(e(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
