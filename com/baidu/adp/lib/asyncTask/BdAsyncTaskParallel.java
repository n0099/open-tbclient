package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId uL;
    private BdAsyncTaskParallelType uM;
    private int uN;

    /* loaded from: classes.dex */
    public enum BdAsyncTaskParallelType {
        SERIAL,
        TWO_PARALLEL,
        THREE_PARALLEL,
        FOUR_PARALLEL,
        CUSTOM_PARALLEL,
        MAX_PARALLEL
    }

    public BdAsyncTaskParallel(BdAsyncTaskParallelType bdAsyncTaskParallelType, BdUniqueId bdUniqueId) {
        this.uL = null;
        this.uM = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.uN = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.uM = bdAsyncTaskParallelType;
        this.uL = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.uL = null;
        this.uM = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.uN = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.uM = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.uN = i;
        this.uL = bdUniqueId;
    }

    public int eC() {
        return this.uN;
    }

    public int getTag() {
        if (this.uL == null) {
            return 0;
        }
        return this.uL.getId();
    }

    public BdAsyncTaskParallelType eD() {
        return this.uM;
    }
}
