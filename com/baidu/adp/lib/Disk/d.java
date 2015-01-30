package com.baidu.adp.lib.Disk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class d {
    public static BdUniqueId cX = BdUniqueId.gen();
    private static d fL = null;
    private b fI;
    private final int fK = 10;
    private BdAsyncTaskParallel fp;

    public static d bM() {
        if (fL == null) {
            synchronized (d.class) {
                if (fL == null) {
                    fL = new d();
                }
            }
        }
        return fL;
    }

    private d() {
        this.fI = null;
        this.fp = null;
        this.fp = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.fI = new b();
    }

    public void F(String str) {
        this.fI.E(str);
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean bO = new e(this.fI, diskFileOperate).bO();
        diskFileOperate.l(bO);
        return bO;
    }

    public boolean c(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.ca() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(cX) < diskFileOperate.cf() + 10) {
            f(diskFileOperate);
            return true;
        }
        return false;
    }

    public void d(DiskFileOperate diskFileOperate) {
        String e = e(diskFileOperate);
        if (e != null) {
            BdAsyncTask.removeAllTask(cX, e);
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
        c cVar = new c(this.fI, diskFileOperate);
        cVar.setTag(cX);
        cVar.setParallel(this.fp);
        cVar.setPriority(4);
        cVar.setKey(e(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
