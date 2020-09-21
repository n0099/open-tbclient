package com.baidu.searchbox.elasticthread;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public abstract class ExecutorProxy implements Executor {
    protected int mDefaultPriority;
    protected String mDefaultTaskName;

    @Override // java.util.concurrent.Executor
    public abstract void execute(@NonNull Runnable runnable);

    public abstract void execute(@NonNull Runnable runnable, @NonNull String str);

    public abstract void execute(@NonNull Runnable runnable, @NonNull String str, int i);

    public ExecutorProxy(String str, int i) {
        this.mDefaultPriority = i;
        this.mDefaultTaskName = str;
    }

    public void setDefaultTaskName(String str) {
        this.mDefaultTaskName = str;
    }

    public void setDefaultPriority(int i) {
        this.mDefaultPriority = i;
    }
}
