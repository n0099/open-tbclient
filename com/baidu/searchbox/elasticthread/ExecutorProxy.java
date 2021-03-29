package com.baidu.searchbox.elasticthread;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public abstract class ExecutorProxy implements Executor {
    public int mDefaultPriority;
    public String mDefaultTaskName;

    public ExecutorProxy(String str, int i) {
        this.mDefaultPriority = i;
        this.mDefaultTaskName = str;
    }

    @Override // java.util.concurrent.Executor
    public abstract void execute(@NonNull Runnable runnable);

    public abstract void execute(@NonNull Runnable runnable, @NonNull String str);

    public abstract void execute(@NonNull Runnable runnable, @NonNull String str, int i);

    public void setDefaultPriority(int i) {
        this.mDefaultPriority = i;
    }

    public void setDefaultTaskName(String str) {
        this.mDefaultTaskName = str;
    }
}
