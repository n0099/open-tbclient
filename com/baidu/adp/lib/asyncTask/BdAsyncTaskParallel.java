package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId uJ;
    private BdAsyncTaskParallelType uK;
    private int uL;

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
        this.uJ = null;
        this.uK = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.uL = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.uK = bdAsyncTaskParallelType;
        this.uJ = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.uJ = null;
        this.uK = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.uL = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.uK = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.uL = i;
        this.uJ = bdUniqueId;
    }

    public int eC() {
        return this.uL;
    }

    public int getTag() {
        if (this.uJ == null) {
            return 0;
        }
        return this.uJ.getId();
    }

    public BdAsyncTaskParallelType eD() {
        return this.uK;
    }
}
