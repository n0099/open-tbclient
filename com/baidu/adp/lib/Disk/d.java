package com.baidu.adp.lib.Disk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class d {
    public static BdUniqueId aQ = BdUniqueId.gen();
    private static d dE = null;
    private b dB;
    private final int dD = 10;
    private BdAsyncTaskParallel dh;

    public static d bn() {
        if (dE == null) {
            synchronized (d.class) {
                if (dE == null) {
                    dE = new d();
                }
            }
        }
        return dE;
    }

    private d() {
        this.dB = null;
        this.dh = null;
        this.dh = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.dB = new b();
    }

    public void q(String str) {
        this.dB.p(str);
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean bp = new e(this.dB, diskFileOperate).bp();
        diskFileOperate.h(bp);
        return bp;
    }

    public boolean c(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.bB() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(aQ) < diskFileOperate.bG() + 10) {
            f(diskFileOperate);
            return true;
        }
        return false;
    }

    public void d(DiskFileOperate diskFileOperate) {
        String e = e(diskFileOperate);
        if (e != null) {
            BdAsyncTask.removeAllTask(aQ, e);
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

    private boolean f(DiskFileOperate diskFileOperate) {
        c cVar = new c(this.dB, diskFileOperate);
        cVar.setTag(aQ);
        cVar.setParallel(this.dh);
        cVar.setPriority(4);
        cVar.setKey(e(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
