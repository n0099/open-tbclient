package com.baidu.adp.lib.Disk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class d {
    private static BdUniqueId rd = BdUniqueId.gen();
    private static BdUniqueId re = BdUniqueId.gen();
    private static d rh = null;
    private b rb;
    private final int rf = 10;
    private final int rg = 5;
    private BdAsyncTaskParallel ri;
    private BdAsyncTaskParallel rj;

    public static d fj() {
        if (rh == null) {
            synchronized (d.class) {
                if (rh == null) {
                    rh = new d();
                }
            }
        }
        return rh;
    }

    private d() {
        this.rb = null;
        this.ri = null;
        this.rj = null;
        this.ri = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.rj = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.rb = new b();
    }

    public void M(String str) {
        this.rb.L(str);
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean fk = new e(this.rb, diskFileOperate).fk();
        diskFileOperate.l(fk);
        return fk;
    }

    public boolean c(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.fz()) {
            return a(diskFileOperate, rd, this.ri, 10);
        }
        return a(diskFileOperate, re, this.rj, 5);
    }

    private boolean a(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel, int i) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.fw() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(bdUniqueId) < diskFileOperate.fA() + i) {
            return a(diskFileOperate, bdUniqueId, bdAsyncTaskParallel);
        }
        return false;
    }

    public void d(DiskFileOperate diskFileOperate) {
        String e = e(diskFileOperate);
        if (e != null) {
            BdAsyncTask.removeAllTask(rd, e);
            BdAsyncTask.removeAllTask(re, e);
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
        c cVar = new c(this.rb, diskFileOperate);
        cVar.setTag(bdUniqueId);
        cVar.setParallel(bdAsyncTaskParallel);
        cVar.setPriority(4);
        cVar.setKey(e(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
