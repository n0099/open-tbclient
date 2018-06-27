package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId xr;
    private BdAsyncTaskParallelType xs;
    private int xt;

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
        this.xr = null;
        this.xs = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.xt = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.xs = bdAsyncTaskParallelType;
        this.xr = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.xr = null;
        this.xs = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.xt = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.xs = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.xt = i;
        this.xr = bdUniqueId;
    }

    public int gQ() {
        return this.xt;
    }

    public int getTag() {
        if (this.xr == null) {
            return 0;
        }
        return this.xr.getId();
    }

    public BdAsyncTaskParallelType gR() {
        return this.xs;
    }
}
