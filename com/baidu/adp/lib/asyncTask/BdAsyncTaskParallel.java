package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId Ap;
    private BdAsyncTaskParallelType Aq;
    private int Ar;

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
        this.Ap = null;
        this.Aq = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.Ar = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.Aq = bdAsyncTaskParallelType;
        this.Ap = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.Ap = null;
        this.Aq = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.Ar = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.Aq = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.Ar = i;
        this.Ap = bdUniqueId;
    }

    public int ij() {
        return this.Ar;
    }

    public int getTag() {
        if (this.Ap == null) {
            return 0;
        }
        return this.Ap.getId();
    }

    public BdAsyncTaskParallelType ik() {
        return this.Aq;
    }
}
