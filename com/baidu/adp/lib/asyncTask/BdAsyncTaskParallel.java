package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId xt;
    private BdAsyncTaskParallelType xu;
    private int xv;

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
        this.xt = null;
        this.xu = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.xv = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.xu = bdAsyncTaskParallelType;
        this.xt = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.xt = null;
        this.xu = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.xv = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.xu = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.xv = i;
        this.xt = bdUniqueId;
    }

    public int gQ() {
        return this.xv;
    }

    public int getTag() {
        if (this.xt == null) {
            return 0;
        }
        return this.xt.getId();
    }

    public BdAsyncTaskParallelType gR() {
        return this.xu;
    }
}
