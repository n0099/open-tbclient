package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId agR;
    private BdAsyncTaskParallelType agS;
    private int agT;

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
        this.agR = null;
        this.agS = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.agT = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.agS = bdAsyncTaskParallelType;
        this.agR = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.agR = null;
        this.agS = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.agT = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.agS = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.agT = i;
        this.agR = bdUniqueId;
    }

    public int lV() {
        return this.agT;
    }

    public int getTag() {
        if (this.agR == null) {
            return 0;
        }
        return this.agR.getId();
    }

    public BdAsyncTaskParallelType lW() {
        return this.agS;
    }
}
