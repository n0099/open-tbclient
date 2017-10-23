package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private int sA;
    private BdUniqueId sy;
    private BdAsyncTaskParallelType sz;

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
        this.sy = null;
        this.sz = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sA = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sz = bdAsyncTaskParallelType;
        this.sy = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.sy = null;
        this.sz = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sA = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sz = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.sA = i;
        this.sy = bdUniqueId;
    }

    public int eq() {
        return this.sA;
    }

    public int getTag() {
        if (this.sy == null) {
            return 0;
        }
        return this.sy.getId();
    }

    public BdAsyncTaskParallelType er() {
        return this.sz;
    }
}
