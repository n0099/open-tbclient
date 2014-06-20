package com.baidu.adp.lib.Disk;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.asyncTask.l;
import com.baidu.tbadk.core.util.TbErrInfo;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class d {
    private static d c = null;
    private final int a = 1;
    private final int b = 6;
    private b d;
    private Handler e;
    private AtomicInteger f;
    private BdAsyncTaskParallel g;

    public static d a() {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d();
                }
            }
        }
        return c;
    }

    private d() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.g = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, l.a());
        this.f = new AtomicInteger(0);
        this.d = new b();
        this.e = new e(this);
    }

    public void a(String str) {
        this.d.a(str);
    }

    public boolean a(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        boolean b = new f(this.d, diskFileOperate).b();
        diskFileOperate.c(b);
        return b;
    }

    public boolean b(DiskFileOperate diskFileOperate) {
        if (diskFileOperate == null) {
            return false;
        }
        if (diskFileOperate.j() != DiskFileOperate.OperateType.TRY_SUCCESS || BdAsyncTask.getTaskNum(TbErrInfo.ERR_IMG_GET_REMOTE) + this.f.get() < diskFileOperate.q() + 6) {
            if (Looper.myLooper() != null && Looper.getMainLooper() == Looper.myLooper()) {
                e(diskFileOperate);
            } else {
                this.f.incrementAndGet();
                this.e.sendMessage(this.e.obtainMessage(1, diskFileOperate));
            }
            return true;
        }
        return false;
    }

    public void c(DiskFileOperate diskFileOperate) {
        String d = d(diskFileOperate);
        if (d != null) {
            BdAsyncTask.removeAllTask(TbErrInfo.ERR_IMG_GET_REMOTE, d);
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
        c cVar = new c(this.d, diskFileOperate);
        cVar.setTag(TbErrInfo.ERR_IMG_GET_REMOTE);
        cVar.setParallel(this.g);
        cVar.setPriority(4);
        cVar.setKey(d(diskFileOperate));
        cVar.execute(new DiskFileOperate[0]);
        return true;
    }
}
