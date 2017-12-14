package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId sv;
    private BdAsyncTaskParallelType sw;
    private int sx;

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
        this.sv = null;
        this.sw = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sx = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sw = bdAsyncTaskParallelType;
        this.sv = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.sv = null;
        this.sw = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sx = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sw = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.sx = i;
        this.sv = bdUniqueId;
    }

    public int eq() {
        return this.sx;
    }

    public int getTag() {
        if (this.sv == null) {
            return 0;
        }
        return this.sv.getId();
    }

    public BdAsyncTaskParallelType er() {
        return this.sw;
    }
}
