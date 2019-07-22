package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId yf;
    private BdAsyncTaskParallelType yg;
    private int yh;

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
        this.yf = null;
        this.yg = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.yh = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.yg = bdAsyncTaskParallelType;
        this.yf = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.yf = null;
        this.yg = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.yh = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.yg = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.yh = i;
        this.yf = bdUniqueId;
    }

    public int hl() {
        return this.yh;
    }

    public int getTag() {
        if (this.yf == null) {
            return 0;
        }
        return this.yf.getId();
    }

    public BdAsyncTaskParallelType hm() {
        return this.yg;
    }
}
