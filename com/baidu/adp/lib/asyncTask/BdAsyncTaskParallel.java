package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId lM;
    private BdAsyncTaskParallelType lN;
    private int lO;

    /* loaded from: classes.dex */
    public enum BdAsyncTaskParallelType {
        SERIAL,
        TWO_PARALLEL,
        THREE_PARALLEL,
        FOUR_PARALLEL,
        CUSTOM_PARALLEL,
        MAX_PARALLEL;

        /* JADX DEBUG: Replace access to removed values field (lP) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static BdAsyncTaskParallelType[] valuesCustom() {
            BdAsyncTaskParallelType[] valuesCustom = values();
            int length = valuesCustom.length;
            BdAsyncTaskParallelType[] bdAsyncTaskParallelTypeArr = new BdAsyncTaskParallelType[length];
            System.arraycopy(valuesCustom, 0, bdAsyncTaskParallelTypeArr, 0, length);
            return bdAsyncTaskParallelTypeArr;
        }
    }

    public BdAsyncTaskParallel(BdAsyncTaskParallelType bdAsyncTaskParallelType, BdUniqueId bdUniqueId) {
        this.lM = null;
        this.lN = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.lO = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.lN = bdAsyncTaskParallelType;
        this.lM = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.lM = null;
        this.lN = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.lO = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.lN = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.lO = i;
        this.lM = bdUniqueId;
    }

    public int dn() {
        return this.lO;
    }

    public int getTag() {
        if (this.lM == null) {
            return 0;
        }
        return this.lM.getId();
    }

    /* renamed from: do  reason: not valid java name */
    public BdAsyncTaskParallelType m4do() {
        return this.lN;
    }
}
