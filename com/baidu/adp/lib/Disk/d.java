package com.baidu.adp.lib.Disk;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class d {
    private static BdUniqueId hk = BdUniqueId.gen();
    private static BdUniqueId hl = BdUniqueId.gen();
    private static d ho = null;
    private b hi;
    private final int hm = 10;
    private final int hn = 5;
    private BdAsyncTaskParallel hp;
    private BdAsyncTaskParallel hq;

    public static d bG() {
        if (ho == null) {
            synchronized (d.class) {
                if (ho == null) {
                    ho = new d();
                }
            }
        }
        return ho;
    }

    private d() {
        this.hi = null;
        this.hp = null;
        this.hq = null;
        this.hp = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.hq = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.hi = new b();
    }

    public void C(String str) {
        this.hi.B(str);
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean bH = new e(this.hi, diskFileOperate).bH();
        diskFileOperate.k(bH);
        return bH;
    }

    public boolean c(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.bW()) {
            return a(diskFileOperate, hk, this.hp, 10);
        }
        return a(diskFileOperate, hl, this.hq, 5);
    }

    private boolean a(DiskFileOperate diskFileOperate, BdUniqueId bdUniqueId, BdAsyncTaskParallel bdAsyncTaskParallel, int i) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.bT() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(bdUniqueId) < diskFileOperate.bX() + i) {
            return a(diskFileOperate, bdUniqueId, bdAsyncTaskParallel);
        }
        return false;
    }

    public void d(DiskFileOperate diskFileOperate) {
        String e = e(diskFileOperate);
        if (e != null) {
            BdAsyncTask.removeAllTask(hk, e);
            BdAsyncTask.removeAllTask(hl, e);
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
        c cVar = new c(this.hi, diskFileOperate);
        cVar.setTag(bdUniqueId);
        cVar.setParallel(bdAsyncTaskParallel);
        cVar.setPriority(4);
        cVar.setKey(e(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
