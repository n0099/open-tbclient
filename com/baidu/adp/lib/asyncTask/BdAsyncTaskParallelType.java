package com.baidu.adp.lib.asyncTask;
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
