package com.baidu.adp.lib.Disk;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class d {
    public static BdUniqueId a = BdUniqueId.gen();
    private static d d = null;
    private final int b = 1;
    private final int c = 6;
    private b e;
    private Handler f;
    private AtomicInteger g;
    private BdAsyncTaskParallel h;

    public static d a() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    private d() {
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.h = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        this.g = new AtomicInteger(0);
        this.e = new b();
        this.f = new e(this);
    }

    public void a(String str) {
        this.e.a(str);
    }

    public boolean a(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean c = new f(this.e, diskFileOperate).c();
        diskFileOperate.c(c);
        return c;
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.j() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(a) + this.g.get() < diskFileOperate.r() + 6) {
            if (Looper.myLooper() != null && Looper.getMainLooper() == Looper.myLooper()) {
                e(diskFileOperate);
            } else {
                this.g.incrementAndGet();
                this.f.sendMessage(this.f.obtainMessage(1, diskFileOperate));
            }
            return true;
        }
        return false;
    }

    public void c(DiskFileOperate diskFileOperate) {
        String d2 = d(diskFileOperate);
        if (d2 != null) {
            BdAsyncTask.removeAllTask(a, d2);
        }
    }

    private String d(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return null;
        }
        if (diskFileOperate.d() == null) {
            return String.valueOf(diskFileOperate.c()) + "|" + diskFileOperate.hashCode();
        }
        return String.valueOf(diskFileOperate.d()) + "/" + diskFileOperate.c() + "|" + diskFileOperate.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(DiskFileOperate diskFileOperate) {
        c cVar = new c(this.e, diskFileOperate);
        cVar.setTag(a);
        cVar.setParallel(this.h);
        cVar.setPriority(4);
        cVar.setKey(d(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
