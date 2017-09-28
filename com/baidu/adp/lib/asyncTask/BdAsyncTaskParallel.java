package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId sx;
    private BdAsyncTaskParallelType sy;
    private int sz;

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
        this.sx = null;
        this.sy = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sz = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sy = bdAsyncTaskParallelType;
        this.sx = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.sx = null;
        this.sy = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sz = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sy = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.sz = i;
        this.sx = bdUniqueId;
    }

    public int eq() {
        return this.sz;
    }

    public int getTag() {
        if (this.sx == null) {
            return 0;
        }
        return this.sx.getId();
    }

    public BdAsyncTaskParallelType er() {
        return this.sy;
    }
}
