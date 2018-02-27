package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId agL;
    private BdAsyncTaskParallelType agM;
    private int agN;

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
        this.agL = null;
        this.agM = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.agN = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.agM = bdAsyncTaskParallelType;
        this.agL = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.agL = null;
        this.agM = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.agN = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.agM = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.agN = i;
        this.agL = bdUniqueId;
    }

    public int lV() {
        return this.agN;
    }

    public int getTag() {
        if (this.agL == null) {
            return 0;
        }
        return this.agL.getId();
    }

    public BdAsyncTaskParallelType lW() {
        return this.agM;
    }
}
