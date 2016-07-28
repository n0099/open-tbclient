package com.baidu.adp.lib.g;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public interface e<T> {
    T a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, a aVar, Object... objArr);

    T a(String str, String str2, a aVar, Object... objArr);

    void a(String str, Object obj, Object... objArr);

    T b(String str, String str2, Object... objArr);

    boolean dI();

    BdAsyncTaskParallel dJ();

    int dK();
}
