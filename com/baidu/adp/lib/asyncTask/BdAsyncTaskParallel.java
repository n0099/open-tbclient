package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId xZ;
    private BdAsyncTaskParallelType ya;
    private int yb;

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
        this.xZ = null;
        this.ya = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.yb = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.ya = bdAsyncTaskParallelType;
        this.xZ = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.xZ = null;
        this.ya = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.yb = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.ya = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.yb = i;
        this.xZ = bdUniqueId;
    }

    public int hc() {
        return this.yb;
    }

    public int getTag() {
        if (this.xZ == null) {
            return 0;
        }
        return this.xZ.getId();
    }

    public BdAsyncTaskParallelType hd() {
        return this.ya;
    }
}
