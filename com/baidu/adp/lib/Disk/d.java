package com.baidu.adp.lib.Disk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class d {
    private static BdUniqueId rs = BdUniqueId.gen();
    private static BdUniqueId rt = BdUniqueId.gen();
    private static d rw = null;
    private b rq;
    private final int ru = 10;
    private final int rv = 5;
    private BdAsyncTaskParallel rx;
    private BdAsyncTaskParallel ry;

    public static d dH() {
        if (rw == null) {
            synchronized (d.class) {
                if (rw == null) {
                    rw = new d();
                }
            }
        }
        return rw;
    }

    private d() {
        this.rq = null;
        this.rx = null;
        this.ry = null;
        this.rx = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.ry = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.rq = new b();
    }

    public void B(String str) {
        this.rq.A(str);
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean dI = new e(this.rq, diskFileOperate).dI();
        diskFileOperate.p(dI);
        return dI;
    }

    public boolean c(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.dX()) {
            return a(diskFileOperate, rs, this.rx, 10);
        }
        return a(diskFileOperate, rt, this.ry, 5);
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
            BdAsyncTask.removeAllTask(rs, e);
            BdAsyncTask.removeAllTask(rt, e);
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
        c cVar = new c(this.rq, diskFileOperate);
        cVar.setTag(bdUniqueId);
        cVar.setParallel(bdAsyncTaskParallel);
        cVar.setPriority(4);
        cVar.setKey(e(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
