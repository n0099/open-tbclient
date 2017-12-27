package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId agQ;
    private BdAsyncTaskParallelType agR;
    private int agS;

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
        this.agQ = null;
        this.agR = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.agS = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.agR = bdAsyncTaskParallelType;
        this.agQ = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.agQ = null;
        this.agR = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.agS = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.agR = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.agS = i;
        this.agQ = bdUniqueId;
    }

    public int lU() {
        return this.agS;
    }

    public int getTag() {
        if (this.agQ == null) {
            return 0;
        }
        return this.agQ.getId();
    }

    public BdAsyncTaskParallelType lV() {
        return this.agR;
    }
}
