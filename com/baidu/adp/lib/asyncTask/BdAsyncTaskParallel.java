package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId xl;
    private BdAsyncTaskParallelType xm;
    private int xn;

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
        this.xl = null;
        this.xm = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.xn = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.xm = bdAsyncTaskParallelType;
        this.xl = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.xl = null;
        this.xm = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.xn = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.xm = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.xn = i;
        this.xl = bdUniqueId;
    }

    public int gP() {
        return this.xn;
    }

    public int getTag() {
        if (this.xl == null) {
            return 0;
        }
        return this.xl.getId();
    }

    public BdAsyncTaskParallelType gQ() {
        return this.xm;
    }
}
