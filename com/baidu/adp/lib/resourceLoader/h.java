package com.baidu.adp.lib.resourceLoader;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public interface h<T> {
    T a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, a aVar, Object... objArr);

    T a(String str, String str2, a aVar, Object... objArr);

    T a(String str, String str2, Object... objArr);

    void a(String str, Object obj, Object... objArr);

    boolean a();

    BdAsyncTaskParallel b();

    int c();
}
