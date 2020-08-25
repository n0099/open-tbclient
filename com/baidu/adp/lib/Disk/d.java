package com.baidu.adp.lib.Disk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class d {
    private static BdUniqueId Jm = BdUniqueId.gen();
    private static BdUniqueId Jn = BdUniqueId.gen();
    private static d Jo = null;
    private b Jk;
    private BdAsyncTaskParallel Jp;
    private BdAsyncTaskParallel Jq;
    private final int DISK_TASK_MAX_NUM_SDCARD = 10;
    private final int DISK_TASK_MAX_NUM_ROM = 5;

    public static d lG() {
        if (Jo == null) {
            synchronized (d.class) {
                if (Jo == null) {
                    Jo = new d();
                }
            }
        }
        return Jo;
    }

    private d() {
        this.Jk = null;
        this.Jp = null;
        this.Jq = null;
        this.Jp = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.Jq = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.Jk = new b();
    }

    public void initial(String str) {
        this.Jk.setApplicationPath(str);
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean call = new e(this.Jk, diskFileOperate).call();
        diskFileOperate.callback(call);
        return call;
    }

    public boolean c(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.isSdCard()) {
            return a(diskFileOperate, Jm, this.Jp, 10);
        }
        return a(diskFileOperate, Jn, this.Jq, 5);
    }

    private boolean a(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel, int i) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.lI() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(bdUniqueId) < diskFileOperate.getTrySuccessWeight() + i) {
            return a(diskFileOperate, bdUniqueId, bdAsyncTaskParallel);
        }
        return false;
    }

    public void d(DiskFileOperate diskFileOperate) {
        String e = e(diskFileOperate);
        if (e != null) {
            BdAsyncTask.removeAllTask(Jm, e);
            BdAsyncTask.removeAllTask(Jn, e);
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
        c cVar = new c(this.Jk, diskFileOperate);
        cVar.setTag(bdUniqueId);
        cVar.setParallel(bdAsyncTaskParallel);
        cVar.setPriority(4);
        cVar.setKey(e(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
