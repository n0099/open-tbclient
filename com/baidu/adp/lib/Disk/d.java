package com.baidu.adp.lib.Disk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class d {
    private static BdUniqueId Kc = BdUniqueId.gen();
    private static BdUniqueId Kd = BdUniqueId.gen();
    private static d Ke = null;
    private b Ka;
    private BdAsyncTaskParallel Kf;
    private BdAsyncTaskParallel Kg;
    private final int DISK_TASK_MAX_NUM_SDCARD = 10;
    private final int DISK_TASK_MAX_NUM_ROM = 5;

    public static d lh() {
        if (Ke == null) {
            synchronized (d.class) {
                if (Ke == null) {
                    Ke = new d();
                }
            }
        }
        return Ke;
    }

    private d() {
        this.Ka = null;
        this.Kf = null;
        this.Kg = null;
        this.Kf = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.Kg = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.Ka = new b();
    }

    public void initial(String str) {
        this.Ka.setApplicationPath(str);
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean call = new e(this.Ka, diskFileOperate).call();
        diskFileOperate.callback(call);
        return call;
    }

    public boolean c(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.isSdCard()) {
            return a(diskFileOperate, Kc, this.Kf, 10);
        }
        return a(diskFileOperate, Kd, this.Kg, 5);
    }

    private boolean a(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel, int i) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.lj() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(bdUniqueId) < diskFileOperate.getTrySuccessWeight() + i) {
            return a(diskFileOperate, bdUniqueId, bdAsyncTaskParallel);
        }
        return false;
    }

    public void d(DiskFileOperate diskFileOperate) {
        String e = e(diskFileOperate);
        if (e != null) {
            BdAsyncTask.removeAllTask(Kc, e);
            BdAsyncTask.removeAllTask(Kd, e);
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
        c cVar = new c(this.Ka, diskFileOperate);
        cVar.setTag(bdUniqueId);
        cVar.setParallel(bdAsyncTaskParallel);
        cVar.setPriority(4);
        cVar.setKey(e(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
