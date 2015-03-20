package com.baidu.adp.lib.Disk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class d {
    public static BdUniqueId oi = BdUniqueId.gen();
    private static d re = null;
    private BdAsyncTaskParallel qH;
    private b rb;
    private final int rd = 10;

    public static d fk() {
        if (re == null) {
            synchronized (d.class) {
                if (re == null) {
                    re = new d();
                }
            }
        }
        return re;
    }

    private d() {
        this.rb = null;
        this.qH = null;
        this.qH = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.rb = new b();
    }

    public void N(String str) {
        this.rb.M(str);
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean fm = new e(this.rb, diskFileOperate).fm();
        diskFileOperate.l(fm);
        return fm;
    }

    public boolean c(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.fy() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(oi) < diskFileOperate.fD() + 10) {
            f(diskFileOperate);
            return true;
        }
        return false;
    }

    public void d(DiskFileOperate diskFileOperate) {
        String e = e(diskFileOperate);
        if (e != null) {
            BdAsyncTask.removeAllTask(oi, e);
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
        c cVar = new c(this.rb, diskFileOperate);
        cVar.setTag(oi);
        cVar.setParallel(this.qH);
        cVar.setPriority(4);
        cVar.setKey(e(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
