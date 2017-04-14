package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId sW;
    private BdAsyncTaskParallelType sX;
    private int sY;

    /* loaded from: classes.dex */
    public enum BdAsyncTaskParallelType {
        SERIAL,
        TWO_PARALLEL,
        THREE_PARALLEL,
        FOUR_PARALLEL,
        CUSTOM_PARALLEL,
        MAX_PARALLEL;

        /* JADX DEBUG: Replace access to removed values field (sZ) with 'values()' method */
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
        this.sW = null;
        this.sX = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sY = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sX = bdAsyncTaskParallelType;
        this.sW = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.sW = null;
        this.sX = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.sY = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.sX = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.sY = i;
        this.sW = bdUniqueId;
    }

    public int et() {
        return this.sY;
    }

    public int getTag() {
        if (this.sW == null) {
            return 0;
        }
        return this.sW.getId();
    }

    public BdAsyncTaskParallelType eu() {
        return this.sX;
    }
}
