package com.baidu.adp.lib.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public interface e<T> {
    T a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, a aVar, Object... objArr);

    T a(String str, String str2, int i, int i2, a aVar, Object... objArr);

    T a(String str, String str2, int i, int i2, Object... objArr);

    void a(String str, Object obj, int i, int i2, Object... objArr);

    boolean mV();

    BdAsyncTaskParallel mW();

    int mX();
}
