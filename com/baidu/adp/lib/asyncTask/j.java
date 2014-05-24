package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j implements Runnable {
    private k<?> a;

    public j(k<?> kVar) {
        this.a = null;
        if (kVar == null || kVar.b() == null) {
            throw new InvalidParameterException("parameter is null");
        }
        this.a = kVar;
    }

    public void a() {
        try {
            this.a.run();
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
            System.gc();
        }
    }

    public void b() {
        this.a.a();
    }

    public boolean c() {
        return this.a.isCancelled();
    }

    public BdAsyncTask<?, ?, ?> d() {
        return this.a.b();
    }

    public int e() {
        return this.a.b().getPriority();
    }

    public void a(boolean z) {
        this.a.b().setTimeout(z);
    }

    public boolean f() {
        return this.a.b().isTimeout();
    }

    public int g() {
        return this.a.b().getTag();
    }

    public int h() {
        if (this.a.b().getParallel() != null) {
            return this.a.b().getParallel().a();
        }
        return 0;
    }

    public String i() {
        return this.a.b().getKey();
    }

    public BdAsyncTaskParallel.BdAsyncTaskParallelType j() {
        return this.a.b().getParallel() != null ? this.a.b().getParallel().b() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
    }

    public boolean k() {
        return this.a.b().isSelfExecute();
    }
}
