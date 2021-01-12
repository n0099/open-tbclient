package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId KT;
    private BdAsyncTaskParallelType KU;
    private int mExecuteNum;

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
        this.KT = null;
        this.KU = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.mExecuteNum = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.KU = bdAsyncTaskParallelType;
        this.KT = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.KT = null;
        this.KU = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.mExecuteNum = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.KU = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.mExecuteNum = i;
        this.KT = bdUniqueId;
    }

    public int getExecuteNum() {
        return this.mExecuteNum;
    }

    public int getTag() {
        if (this.KT == null) {
            return 0;
        }
        return this.KT.getId();
    }

    public BdAsyncTaskParallelType ls() {
        return this.KU;
    }
}
