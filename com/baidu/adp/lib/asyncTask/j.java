package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j implements Runnable {
    private k<?> hg;

    public j(k<?> kVar) {
        this.hg = null;
        if (kVar == null || kVar.cw() == null) {
            throw new InvalidParameterException("parameter is null");
        }
        this.hg = kVar;
    }

    public void cv() {
        try {
            this.hg.run();
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public void cr() {
        this.hg.cr();
    }

    public boolean isCancelled() {
        return this.hg.isCancelled();
    }

    public BdAsyncTask<?, ?, ?> cw() {
        return this.hg.cw();
    }

    public int getPriority() {
        return this.hg.cw().getPriority();
    }

    public void setTimeout(boolean z) {
        this.hg.cw().setTimeout(z);
    }

    public boolean cx() {
        return this.hg.cw().isTimeout();
    }

    public int getTag() {
        return this.hg.cw().getTag();
    }

    public int cy() {
        if (this.hg.cw().getParallel() != null) {
            return this.hg.cw().getParallel().getTag();
        }
        return 0;
    }

    public String getKey() {
        return this.hg.cw().getKey();
    }

    public BdAsyncTaskParallel.BdAsyncTaskParallelType cz() {
        return this.hg.cw().getParallel() != null ? this.hg.cw().getParallel().cC() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
    }

    public int cA() {
        if (this.hg.cw().getParallel() != null) {
            return this.hg.cw().getParallel().cB();
        }
        return 1;
    }

    public boolean isSelfExecute() {
        return this.hg.cw().isSelfExecute();
    }
}
