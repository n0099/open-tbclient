package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId td;
    private BdAsyncTaskParallelType te;
    private int tf;

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
        this.td = null;
        this.te = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.tf = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.te = bdAsyncTaskParallelType;
        this.td = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.td = null;
        this.te = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.tf = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.te = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.tf = i;
        this.td = bdUniqueId;
    }

    public int er() {
        return this.tf;
    }

    public int getTag() {
        if (this.td == null) {
            return 0;
        }
        return this.td.getId();
    }

    public BdAsyncTaskParallelType es() {
        return this.te;
    }
}
