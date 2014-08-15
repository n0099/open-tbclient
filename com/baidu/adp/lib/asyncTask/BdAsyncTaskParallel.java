package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {
    private BdUniqueId a;
    private BdAsyncTaskParallelType b;
    private int c;

    /* loaded from: classes.dex */
    public enum BdAsyncTaskParallelType {
        SERIAL,
        TWO_PARALLEL,
        THREE_PARALLEL,
        FOUR_PARALLEL,
        CUSTOM_PARALLEL,
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

    public BdAsyncTaskParallel(BdAsyncTaskParallelType bdAsyncTaskParallelType, BdUniqueId bdUniqueId) {
        this.a = null;
        this.b = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.c = 1;
        if (bdAsyncTaskParallelType == null || bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.b = bdAsyncTaskParallelType;
        this.a = bdUniqueId;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i) {
        this.a = null;
        this.b = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.c = 1;
        if (bdUniqueId == null) {
            throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
        }
        this.b = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
        this.c = i;
        this.a = bdUniqueId;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.a.getId();
    }

    public BdAsyncTaskParallelType c() {
        return this.b;
    }
}
