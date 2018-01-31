package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId agT;
    private BdAsyncTaskParallelType agU;
    private int agV;

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
        this.agT = null;
        this.agU = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.agV = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.agU = bdAsyncTaskParallelType;
        this.agT = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.agT = null;
        this.agU = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.agV = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.agU = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.agV = i;
        this.agT = bdUniqueId;
    }

    public int lV() {
        return this.agV;
    }

    public int getTag() {
        if (this.agT == null) {
            return 0;
        }
        return this.agT.getId();
    }

    public BdAsyncTaskParallelType lW() {
        return this.agU;
    }
}
