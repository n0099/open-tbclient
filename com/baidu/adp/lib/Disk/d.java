package com.baidu.adp.lib.Disk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class d {
    private static BdUniqueId qU = BdUniqueId.gen();
    private static BdUniqueId qV = BdUniqueId.gen();
    private static d qY = null;
    private b qS;
    private final int qW = 10;
    private final int qX = 5;
    private BdAsyncTaskParallel qZ;
    private BdAsyncTaskParallel ra;

    public static d dH() {
        if (qY == null) {
            synchronized (d.class) {
                if (qY == null) {
                    qY = new d();
                }
            }
        }
        return qY;
    }

    private d() {
        this.qS = null;
        this.qZ = null;
        this.ra = null;
        this.qZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.ra = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.qS = new b();
    }

    public void I(String str) {
        this.qS.H(str);
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean dI = new e(this.qS, diskFileOperate).dI();
        diskFileOperate.p(dI);
        return dI;
    }

    public boolean c(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.dW()) {
            return a(diskFileOperate, qU, this.qZ, 10);
        }
        return a(diskFileOperate, qV, this.ra, 5);
    }

    private boolean a(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel, int i) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.dT() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(bdUniqueId) < diskFileOperate.dX() + i) {
            return a(diskFileOperate, bdUniqueId, bdAsyncTaskParallel);
        }
        return false;
    }

    public void d(DiskFileOperate diskFileOperate) {
        String e = e(diskFileOperate);
        if (e != null) {
            BdAsyncTask.removeAllTask(qU, e);
            BdAsyncTask.removeAllTask(qV, e);
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
        c cVar = new c(this.qS, diskFileOperate);
        cVar.setTag(bdUniqueId);
        cVar.setParallel(bdAsyncTaskParallel);
        cVar.setPriority(4);
        cVar.setKey(e(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
