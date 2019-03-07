package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId Aq;
    private BdAsyncTaskParallelType Ar;
    private int As;

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
        this.Aq = null;
        this.Ar = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.As = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.Ar = bdAsyncTaskParallelType;
        this.Aq = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.Aq = null;
        this.Ar = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.As = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.Ar = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.As = i;
        this.Aq = bdUniqueId;
    }

    public int ij() {
        return this.As;
    }

    public int getTag() {
        if (this.Aq == null) {
            return 0;
        }
        return this.Aq.getId();
    }

    public BdAsyncTaskParallelType ik() {
        return this.Ar;
    }
}
