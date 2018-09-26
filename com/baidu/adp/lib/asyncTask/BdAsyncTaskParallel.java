package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId zE;
    private BdAsyncTaskParallelType zF;
    private int zG;

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
        this.zE = null;
        this.zF = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.zG = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.zF = bdAsyncTaskParallelType;
        this.zE = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.zE = null;
        this.zF = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.zG = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.zF = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.zG = i;
        this.zE = bdUniqueId;
    }

    public int hV() {
        return this.zG;
    }

    public int getTag() {
        if (this.zE == null) {
            return 0;
        }
        return this.zE.getId();
    }

    public BdAsyncTaskParallelType hW() {
        return this.zF;
    }
}
