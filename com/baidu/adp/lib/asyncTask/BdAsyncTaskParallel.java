package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId lL;
    private BdAsyncTaskParallelType lM;
    private int lN;

    /* loaded from: classes.dex */
    public enum BdAsyncTaskParallelType {
        SERIAL,
        TWO_PARALLEL,
        THREE_PARALLEL,
        FOUR_PARALLEL,
        CUSTOM_PARALLEL,
        MAX_PARALLEL;

        /* JADX DEBUG: Replace access to removed values field (lO) with 'values()' method */
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
        this.lL = null;
        this.lM = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.lN = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.lM = bdAsyncTaskParallelType;
        this.lL = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.lL = null;
        this.lM = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.lN = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.lM = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.lN = i;
        this.lL = bdUniqueId;
    }

    public int dn() {
        return this.lN;
    }

    public int getTag() {
        if (this.lL == null) {
            return 0;
        }
        return this.lL.getId();
    }

    /* renamed from: do  reason: not valid java name */
    public BdAsyncTaskParallelType m4do() {
        return this.lM;
    }
}
