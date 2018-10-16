package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId Ao;
    private BdAsyncTaskParallelType Ap;
    private int Aq;

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
        this.Ao = null;
        this.Ap = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.Aq = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.Ap = bdAsyncTaskParallelType;
        this.Ao = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.Ao = null;
        this.Ap = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.Aq = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.Ap = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.Aq = i;
        this.Ao = bdUniqueId;
    }

    public int ik() {
        return this.Aq;
    }

    public int getTag() {
        if (this.Ao == null) {
            return 0;
        }
        return this.Ao.getId();
    }

    public BdAsyncTaskParallelType il() {
        return this.Ap;
    }
}
