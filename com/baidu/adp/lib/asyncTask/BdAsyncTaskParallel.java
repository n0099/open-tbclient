package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId sL;
    private BdAsyncTaskParallelType sM;
    private int sN;

    /* loaded from: classes.dex */
    public enum BdAsyncTaskParallelType {
        SERIAL,
        TWO_PARALLEL,
        THREE_PARALLEL,
        FOUR_PARALLEL,
        CUSTOM_PARALLEL,
        MAX_PARALLEL;

        /* JADX DEBUG: Replace access to removed values field (sO) with 'values()' method */
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
        this.sL = null;
        this.sM = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sN = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sM = bdAsyncTaskParallelType;
        this.sL = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.sL = null;
        this.sM = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sN = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sM = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.sN = i;
        this.sL = bdUniqueId;
    }

    public int fV() {
        return this.sN;
    }

    public int getTag() {
        return this.sL.getId();
    }

    public BdAsyncTaskParallelType fW() {
        return this.sM;
    }
}
