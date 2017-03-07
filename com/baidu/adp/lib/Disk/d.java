package com.baidu.adp.lib.Disk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class d {
    private static BdUniqueId rT = BdUniqueId.gen();
    private static BdUniqueId rU = BdUniqueId.gen();
    private static d rX = null;
    private b rR;
    private final int rV = 10;
    private final int rW = 5;
    private BdAsyncTaskParallel rY;
    private BdAsyncTaskParallel rZ;

    public static d dI() {
        if (rX == null) {
            synchronized (d.class) {
                if (rX == null) {
                    rX = new d();
                }
            }
        }
        return rX;
    }

    private d() {
        this.rR = null;
        this.rY = null;
        this.rZ = null;
        this.rY = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.rZ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.rR = new b();
    }

    public void E(String str) {
        this.rR.D(str);
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean dJ = new e(this.rR, diskFileOperate).dJ();
        diskFileOperate.p(dJ);
        return dJ;
    }

    public boolean c(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.dY()) {
            return a(diskFileOperate, rT, this.rY, 10);
        }
        return a(diskFileOperate, rU, this.rZ, 5);
    }

    private boolean a(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel, int i) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.dV() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(bdUniqueId) < diskFileOperate.dZ() + i) {
            return a(diskFileOperate, bdUniqueId, bdAsyncTaskParallel);
        }
        return false;
    }

    public void d(DiskFileOperate diskFileOperate) {
        String e = e(diskFileOperate);
        if (e != null) {
            BdAsyncTask.removeAllTask(rT, e);
            BdAsyncTask.removeAllTask(rU, e);
        }
    }

    private String e(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return null;
        }
        if (diskFileOperate.getPath() == null) {
            return String.valueOf(diskFileOperate.getName()) + "|" + diskFileOperate.hashCode();
        }
        return String.valueOf(diskFileOperate.getPath()) + "/" + diskFileOperate.getName() + "|" + diskFileOperate.hashCode();
    }

    private boolean a(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel) {
        c cVar = new c(this.rR, diskFileOperate);
        cVar.setTag(bdUniqueId);
        cVar.setParallel(bdAsyncTaskParallel);
        cVar.setPriority(4);
        cVar.setKey(e(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
