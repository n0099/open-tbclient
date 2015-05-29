package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j implements Runnable {
    private k<?> sM;

    public j(k<?> kVar) {
        this.sM = null;
        if (kVar == null || kVar.fY() == null) {
            throw new InvalidParameterException("parameter is null");
        }
        this.sM = kVar;
    }

    public void fX() {
        try {
            this.sM.run();
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public void fU() {
        this.sM.fU();
    }

    public boolean isCancelled() {
        return this.sM.isCancelled();
    }

    public BdAsyncTask<?, ?, ?> fY() {
        return this.sM.fY();
    }

    public int getPriority() {
        return this.sM.fY().getPriority();
    }

    public void setTimeout(boolean z) {
        this.sM.fY().setTimeout(z);
    }

    public boolean fZ() {
        return this.sM.fY().isTimeout();
    }

    public int getTag() {
        return this.sM.fY().getTag();
    }

    public int ga() {
        if (this.sM.fY().getParallel() != null) {
            return this.sM.fY().getParallel().getTag();
        }
        return 0;
    }

    public String getKey() {
        return this.sM.fY().getKey();
    }

    public BdAsyncTaskParallel.BdAsyncTaskParallelType gb() {
        return this.sM.fY().getParallel() != null ? this.sM.fY().getParallel().gf() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
    }

    public int gd() {
        if (this.sM.fY().getParallel() != null) {
            return this.sM.fY().getParallel().ge();
        }
        return 1;
    }

    public boolean isSelfExecute() {
        return this.sM.fY().isSelfExecute();
    }
}
