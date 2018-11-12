package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId Ar;
    private BdAsyncTaskParallelType As;
    private int At;

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
        this.Ar = null;
        this.As = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.At = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.As = bdAsyncTaskParallelType;
        this.Ar = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.Ar = null;
        this.As = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.At = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.As = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.At = i;
        this.Ar = bdUniqueId;
    }

    public int ij() {
        return this.At;
    }

    public int getTag() {
        if (this.Ar == null) {
            return 0;
        }
        return this.Ar.getId();
    }

    public BdAsyncTaskParallelType ik() {
        return this.As;
    }
}
