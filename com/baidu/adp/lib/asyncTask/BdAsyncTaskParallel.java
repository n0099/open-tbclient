package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId rg;
    private BdAsyncTaskParallelType rh;
    private int ri;

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
        this.rg = null;
        this.rh = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.ri = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.rh = bdAsyncTaskParallelType;
        this.rg = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.rg = null;
        this.rh = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.ri = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.rh = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.ri = i;
        this.rg = bdUniqueId;
    }

    public int dZ() {
        return this.ri;
    }

    public int getTag() {
        if (this.rg == null) {
            return 0;
        }
        return this.rg.getId();
    }

    public BdAsyncTaskParallelType ea() {
        return this.rh;
    }
}
