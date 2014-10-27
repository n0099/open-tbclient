package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class j implements Runnable {
    private k<?> fc;

    public j(k<?> kVar) {
        this.fc = null;
        if (kVar == null || kVar.bX() == null) {
            throw new InvalidParameterException("parameter is null");
        }
        this.fc = kVar;
    }

    public void bW() {
        try {
            this.fc.run();
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public void bT() {
        this.fc.bT();
    }

    public boolean isCancelled() {
        return this.fc.isCancelled();
    }

    public BdAsyncTask<?, ?, ?> bX() {
        return this.fc.bX();
    }

    public int getPriority() {
        return this.fc.bX().getPriority();
    }

    public void setTimeout(boolean z) {
        this.fc.bX().setTimeout(z);
    }

    public boolean bY() {
        return this.fc.bX().isTimeout();
    }

    public int getTag() {
        return this.fc.bX().getTag();
    }

    public int bZ() {
        if (this.fc.bX().getParallel() != null) {
            return this.fc.bX().getParallel().getTag();
        }
        return 0;
    }

    public String getKey() {
        return this.fc.bX().getKey();
    }

    public BdAsyncTaskParallel.BdAsyncTaskParallelType ca() {
        return this.fc.bX().getParallel() != null ? this.fc.bX().getParallel().cd() : BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
    }

    public int cb() {
        if (this.fc.bX().getParallel() != null) {
            return this.fc.bX().getParallel().cc();
        }
        return 1;
    }

    public boolean isSelfExecute() {
        return this.fc.bX().isSelfExecute();
    }
}
