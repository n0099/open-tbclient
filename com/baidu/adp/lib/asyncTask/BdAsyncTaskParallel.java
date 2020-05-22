package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId Ja;
    private BdAsyncTaskParallelType Jb;
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
        this.Ja = null;
        this.Jb = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.mExecuteNum = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.Jb = bdAsyncTaskParallelType;
        this.Ja = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.Ja = null;
        this.Jb = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.mExecuteNum = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.Jb = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.mExecuteNum = i;
        this.Ja = bdUniqueId;
    }

    public int getExecuteNum() {
        return this.mExecuteNum;
    }

    public int getTag() {
        if (this.Ja == null) {
            return 0;
        }
        return this.Ja.getId();
    }

    public BdAsyncTaskParallelType ka() {
        return this.Jb;
    }
}
