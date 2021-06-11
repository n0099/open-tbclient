package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdAsyncTaskParallel {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f2165a;

    /* renamed from: b  reason: collision with root package name */
    public BdAsyncTaskParallelType f2166b;

    /* renamed from: c  reason: collision with root package name */
    public int f2167c;

    /* loaded from: classes.dex */
    public enum BdAsyncTaskParallelType {
        SERIAL,
        TWO_PARALLEL,
        THREE_PARALLEL,
        FOUR_PARALLEL,
        CUSTOM_PARALLEL,
        MAX_PARALLEL
    }

    public BdAsyncTaskParallel(BdAsyncTaskParallelType bdAsyncTaskParallelType, BdUniqueId bdUniqueId) {
        this.f2165a = null;
        this.f2166b = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.f2167c = 1;
        if (bdAsyncTaskParallelType != null && bdUniqueId != null) {
            this.f2166b = bdAsyncTaskParallelType;
            this.f2165a = bdUniqueId;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }

    public int a() {
        return this.f2167c;
    }

    public int b() {
        BdUniqueId bdUniqueId = this.f2165a;
        if (bdUniqueId == null) {
            return 0;
        }
        return bdUniqueId.getId();
    }

    public BdAsyncTaskParallelType c() {
        return this.f2166b;
    }

    public BdAsyncTaskParallel(BdUniqueId bdUniqueId, int i2) {
        this.f2165a = null;
        this.f2166b = BdAsyncTaskParallelType.MAX_PARALLEL;
        this.f2167c = 1;
        if (bdUniqueId != null) {
            this.f2166b = BdAsyncTaskParallelType.CUSTOM_PARALLEL;
            this.f2167c = i2;
            this.f2165a = bdUniqueId;
            return;
        }
        throw new InvalidParameterException("BdAsyncTaskParallel parameter null");
    }
}
