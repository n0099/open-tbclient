package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j implements Runnable {
    private k<?> hd;

    public j(k<?> kVar) {
        this.hd = null;
        if (kVar == null || kVar.cy() == null) {
            throw new InvalidParameterException("parameter is null");
        }
        this.hd = kVar;
    }

    public void cx() {
        try {
            this.hd.run();
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public void ct() {
        this.hd.ct();
    }

    public boolean isCancelled() {
        return this.hd.isCancelled();
    }

    public BdAsyncTask<?, ?, ?> cy() {
        return this.hd.cy();
    }

    public int getPriority() {
        return this.hd.cy().getPriority();
    }

    public void setTimeout(boolean z) {
        this.hd.cy().setTimeout(z);
    }

    public boolean cz() {
        return this.hd.cy().isTimeout();
    }

    public int getTag() {
        return this.hd.cy().getTag();
    }

    public int cA() {
        if (this.hd.cy().getParallel() != null) {
            return this.hd.cy().getParallel().getTag();
        }
        return 0;
    }

    public String getKey() {
        return this.hd.cy().getKey();
    }

    public BdAsyncTaskParallel.BdAsyncTaskParallelType cB() {
        return this.hd.cy().getParallel() != null ? this.hd.cy().getParallel().cE() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
    }

    public int cC() {
        if (this.hd.cy().getParallel() != null) {
            return this.hd.cy().getParallel().cD();
        }
        return 1;
    }

    public boolean isSelfExecute() {
        return this.hd.cy().isSelfExecute();
    }
}
