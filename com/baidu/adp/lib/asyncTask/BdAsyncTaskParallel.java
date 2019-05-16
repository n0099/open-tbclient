package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId ya;
    private BdAsyncTaskParallelType yb;
    private int yc;

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
        this.ya = null;
        this.yb = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.yc = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.yb = bdAsyncTaskParallelType;
        this.ya = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.ya = null;
        this.yb = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.yc = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.yb = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.yc = i;
        this.ya = bdUniqueId;
    }

    public int hc() {
        return this.yc;
    }

    public int getTag() {
        if (this.ya == null) {
            return 0;
        }
        return this.ya.getId();
    }

    public BdAsyncTaskParallelType hd() {
        return this.yb;
    }
}
