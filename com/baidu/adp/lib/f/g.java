package com.baidu.adp.lib.f;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public interface g<T> {
    T a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, a aVar, Object... objArr);

    T a(String str, String str2, a aVar, Object... objArr);

    void a(String str, Object obj, Object... objArr);

    T c(String str, String str2, Object... objArr);

    boolean eh();

    BdAsyncTaskParallel ei();

    int ej();
}
