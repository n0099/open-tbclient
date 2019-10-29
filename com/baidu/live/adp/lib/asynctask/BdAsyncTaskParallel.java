package com.baidu.live.adp.lib.asynctask;

import com.baidu.live.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes6.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId mBdAsyncTaskParallelTag;
    private BdAsyncTaskParallelType mBdAsyncTaskParallelType;
    private int mExecuteNum;

    /* loaded from: classes6.dex */
    public enum BdAsyncTaskParallelType {
        SERIAL,
        TWO_PARALLEL,
        THREE_PARALLEL,
        FOUR_PARALLEL,
        CUSTOM_PARALLEL,
        MAX_PARALLEL
    }

    public BdAsyncTaskParallel(BdAsyncTaskParallelType bdAsyncTaskParallelType, BdUniqueId bdUniqueId) {
        this.mBdAsyncTaskParallelTag = null;
        this.mBdAsyncTaskParallelType = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.mExecuteNum = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.mBdAsyncTaskParallelType = bdAsyncTaskParallelType;
        this.mBdAsyncTaskParallelTag = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.mBdAsyncTaskParallelTag = null;
        this.mBdAsyncTaskParallelType = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.mExecuteNum = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.mBdAsyncTaskParallelType = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.mExecuteNum = i;
        this.mBdAsyncTaskParallelTag = bdUniqueId;
    }

    public int getExecuteNum() {
        return this.mExecuteNum;
    }

    public int getTag() {
        if (this.mBdAsyncTaskParallelTag == null) {
            return 0;
        }
        return this.mBdAsyncTaskParallelTag.getId();
    }

    public BdAsyncTaskParallelType getType() {
        return this.mBdAsyncTaskParallelType;
    }

    /* loaded from: classes6.dex */
    public static final class BdAsyncTaskParallelTag {
        private static final int MAX_BASE_TAG = 1000;
        private static int mBaseTag = 1000;
        private int mTag = 0;

        public static synchronized BdAsyncTaskParallelTag gen() {
            BdAsyncTaskParallelTag bdAsyncTaskParallelTag;
            synchronized (BdAsyncTaskParallelTag.class) {
                bdAsyncTaskParallelTag = new BdAsyncTaskParallelTag();
                bdAsyncTaskParallelTag.mTag = mBaseTag;
                mBaseTag++;
            }
            return bdAsyncTaskParallelTag;
        }

        private BdAsyncTaskParallelTag() {
        }

        public int getTag() {
            return this.mTag;
        }
    }
}
