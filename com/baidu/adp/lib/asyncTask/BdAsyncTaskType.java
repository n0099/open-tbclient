package com.baidu.adp.lib.asyncTask;
/* loaded from: classes.dex */
public enum BdAsyncTaskType {
    SERIAL,
    TWO_PARALLEL,
    THREE_PARALLEL,
    FOUR_PARALLEL,
    MAX_PARALLEL;

    /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
    /* renamed from: values  reason: to resolve conflict with enum method */
    public static BdAsyncTaskType[] valuesCustom() {
        BdAsyncTaskType[] valuesCustom = values();
        int length = valuesCustom.length;
        BdAsyncTaskType[] bdAsyncTaskTypeArr = new BdAsyncTaskType[length];
        System.arraycopy(valuesCustom, 0, bdAsyncTaskTypeArr, 0, length);
        return bdAsyncTaskTypeArr;
    }
}
