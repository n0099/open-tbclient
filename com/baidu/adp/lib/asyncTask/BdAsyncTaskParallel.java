package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId rf;
    private BdAsyncTaskParallelType rg;
    private int rh;

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
        this.rf = null;
        this.rg = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.rh = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.rg = bdAsyncTaskParallelType;
        this.rf = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.rf = null;
        this.rg = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.rh = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.rg = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.rh = i;
        this.rf = bdUniqueId;
    }

    public int dZ() {
        return this.rh;
    }

    public int getTag() {
        if (this.rf == null) {
            return 0;
        }
        return this.rf.getId();
    }

    public BdAsyncTaskParallelType ea() {
        return this.rg;
    }
}
