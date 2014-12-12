package com.baidu.adp.lib.Disk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class d {
    public static BdUniqueId cW = BdUniqueId.gen();
    private static d fJ = null;
    private b fG;
    private final int fI = 10;
    private BdAsyncTaskParallel fn;

    public static d bO() {
        if (fJ == null) {
            synchronized (d.class) {
                if (fJ == null) {
                    fJ = new d();
                }
            }
        }
        return fJ;
    }

    private d() {
        this.fG = null;
        this.fn = null;
        this.fn = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.fG = new b();
    }

    public void F(String str) {
        this.fG.E(str);
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean bQ = new e(this.fG, diskFileOperate).bQ();
        diskFileOperate.l(bQ);
        return bQ;
    }

    public boolean c(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.cc() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(cW) < diskFileOperate.ch() + 10) {
            f(diskFileOperate);
            return true;
        }
        return false;
    }

    public void d(DiskFileOperate diskFileOperate) {
        String e = e(diskFileOperate);
        if (e != null) {
            BdAsyncTask.removeAllTask(cW, e);
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
        c cVar = new c(this.fG, diskFileOperate);
        cVar.setTag(cW);
        cVar.setParallel(this.fn);
        cVar.setPriority(4);
        cVar.setKey(e(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
