package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId sN;
    private BdAsyncTaskParallelType sO;
    private int sP;

    /* loaded from: classes.dex */
    public enum BdAsyncTaskParallelType {
        SERIAL,
        TWO_PARALLEL,
        THREE_PARALLEL,
        FOUR_PARALLEL,
        CUSTOM_PARALLEL,
        MAX_PARALLEL;

        /* JADX DEBUG: Replace access to removed values field (sQ) with 'values()' method */
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
        this.sN = null;
        this.sO = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sP = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sO = bdAsyncTaskParallelType;
        this.sN = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.sN = null;
        this.sO = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sP = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sO = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.sP = i;
        this.sN = bdUniqueId;
    }

    public int ge() {
        return this.sP;
    }

    public int getTag() {
        return this.sN.getId();
    }

    public BdAsyncTaskParallelType gf() {
        return this.sO;
    }
}
