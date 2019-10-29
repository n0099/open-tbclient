package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private int mExecuteNum;
    private BdUniqueId nL;
    private BdAsyncTaskParallelType nM;

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
        this.nL = null;
        this.nM = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.mExecuteNum = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.nM = bdAsyncTaskParallelType;
        this.nL = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.nL = null;
        this.nM = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.mExecuteNum = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.nM = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.mExecuteNum = i;
        this.nL = bdUniqueId;
    }

    public int getExecuteNum() {
        return this.mExecuteNum;
    }

    public int getTag() {
        if (this.nL == null) {
            return 0;
        }
        return this.nL.getId();
    }

    public BdAsyncTaskParallelType eZ() {
        return this.nM;
    }
}
