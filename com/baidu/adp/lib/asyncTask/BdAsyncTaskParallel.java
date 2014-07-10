package com.baidu.adp.lib.asyncTask;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private l a;
    private BdAsyncTaskParallelType b;

    /* loaded from: classes.dex */
    public enum BdAsyncTaskParallelType {
        SERIAL,
        TWO_PARALLEL,
        THREE_PARALLEL,
        FOUR_PARALLEL,
        MAX_PARALLEL;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static BdAsyncTaskParallelType[] valuesCustom() {
            BdAsyncTaskParallelType[] valuesCustom = values();
            int length = valuesCustom.length;
            BdAsyncTaskParallelType[] bdAsyncTaskParallelTypeArr = new BdAsyncTaskParallelType[length];
            System.arraycopy(valuesCustom, 0, bdAsyncTaskParallelTypeArr, 0, length);
            return bdAsyncTaskParallelTypeArr;
        }
    }

    public BdAsyncTaskParallel(BdAsyncTaskParallelType bdAsyncTaskParallelType, l lVar) {
        this.a = null;
        this.b = BdAsyncTaskParallelType.MAX_PARALLEL;
        if (bdAsyncTaskParallelType == null || lVar == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.b = bdAsyncTaskParallelType;
        this.a = lVar;
    }

    public int a() {
        int i;
        i = this.a.b;
        return i;
    }

    public BdAsyncTaskParallelType b() {
        return this.b;
    }
}
