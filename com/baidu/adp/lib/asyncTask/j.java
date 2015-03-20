package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j implements Runnable {
    private k<?> sB;

    public j(k<?> kVar) {
        this.sB = null;
        if (kVar == null || kVar.fU() == null) {
            throw new InvalidParameterException("parameter is null");
        }
        this.sB = kVar;
    }

    public void fT() {
        try {
            this.sB.run();
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public void fP() {
        this.sB.fP();
    }

    public boolean isCancelled() {
        return this.sB.isCancelled();
    }

    public BdAsyncTask<?, ?, ?> fU() {
        return this.sB.fU();
    }

    public int getPriority() {
        return this.sB.fU().getPriority();
    }

    public void setTimeout(boolean z) {
        this.sB.fU().setTimeout(z);
    }

    public boolean fV() {
        return this.sB.fU().isTimeout();
    }

    public int getTag() {
        return this.sB.fU().getTag();
    }

    public int fW() {
        if (this.sB.fU().getParallel() != null) {
            return this.sB.fU().getParallel().getTag();
        }
        return 0;
    }

    public String getKey() {
        return this.sB.fU().getKey();
    }

    public BdAsyncTaskParallel.BdAsyncTaskParallelType fX() {
        return this.sB.fU().getParallel() != null ? this.sB.fU().getParallel().ga() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
    }

    public int fY() {
        if (this.sB.fU().getParallel() != null) {
            return this.sB.fU().getParallel().fZ();
        }
        return 1;
    }

    public boolean isSelfExecute() {
        return this.sB.fU().isSelfExecute();
    }
}
