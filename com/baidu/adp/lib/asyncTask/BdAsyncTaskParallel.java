package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId iU;
    private BdAsyncTaskParallelType iV;
    private int iW;

    /* loaded from: classes.dex */
    public enum BdAsyncTaskParallelType {
        SERIAL,
        TWO_PARALLEL,
        THREE_PARALLEL,
        FOUR_PARALLEL,
        CUSTOM_PARALLEL,
        MAX_PARALLEL;

        /* JADX DEBUG: Replace access to removed values field (iX) with 'values()' method */
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
        this.iU = null;
        this.iV = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.iW = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.iV = bdAsyncTaskParallelType;
        this.iU = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.iU = null;
        this.iV = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.iW = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.iV = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.iW = i;
        this.iU = bdUniqueId;
    }

    public int cs() {
        return this.iW;
    }

    public int getTag() {
        if (this.iU == null) {
            return 0;
        }
        return this.iU.getId();
    }

    public BdAsyncTaskParallelType ct() {
        return this.iV;
    }
}
