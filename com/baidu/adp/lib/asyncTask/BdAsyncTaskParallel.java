package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId sw;
    private BdAsyncTaskParallelType sx;
    private int sy;

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
        this.sw = null;
        this.sx = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sy = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sx = bdAsyncTaskParallelType;
        this.sw = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.sw = null;
        this.sx = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sy = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sx = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.sy = i;
        this.sw = bdUniqueId;
    }

    public int eq() {
        return this.sy;
    }

    public int getTag() {
        if (this.sw == null) {
            return 0;
        }
        return this.sw.getId();
    }

    public BdAsyncTaskParallelType er() {
        return this.sx;
    }
}
