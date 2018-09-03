package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId xm;
    private BdAsyncTaskParallelType xn;
    private int xo;

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
        this.xm = null;
        this.xn = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.xo = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.xn = bdAsyncTaskParallelType;
        this.xm = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.xm = null;
        this.xn = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.xo = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.xn = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.xo = i;
        this.xm = bdUniqueId;
    }

    public int gP() {
        return this.xo;
    }

    public int getTag() {
        if (this.xm == null) {
            return 0;
        }
        return this.xm.getId();
    }

    public BdAsyncTaskParallelType gQ() {
        return this.xn;
    }
}
