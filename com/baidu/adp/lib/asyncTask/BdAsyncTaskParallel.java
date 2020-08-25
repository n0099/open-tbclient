package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId Kd;
    private BdAsyncTaskParallelType Ke;
    private int mExecuteNum;

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
        this.Kd = null;
        this.Ke = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.mExecuteNum = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.Ke = bdAsyncTaskParallelType;
        this.Kd = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.Kd = null;
        this.Ke = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.mExecuteNum = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.Ke = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.mExecuteNum = i;
        this.Kd = bdUniqueId;
    }

    public int getExecuteNum() {
        return this.mExecuteNum;
    }

    public int getTag() {
        if (this.Kd == null) {
            return 0;
        }
        return this.Kd.getId();
    }

    public BdAsyncTaskParallelType lP() {
        return this.Ke;
    }
}
