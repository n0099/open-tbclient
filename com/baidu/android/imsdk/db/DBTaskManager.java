package com.baidu.android.imsdk.db;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes2.dex */
public class DBTaskManager {
    public static DBTaskManager mInstance;
    public ExecutorService writeService = Executors.newSingleThreadExecutor();

    public DBTaskManager(Context context) {
    }

    public static synchronized DBTaskManager getInstance(Context context) {
        synchronized (DBTaskManager.class) {
            if (context == null) {
                return null;
            }
            if (mInstance == null) {
                mInstance = new DBTaskManager(context);
            }
            return mInstance;
        }
    }

    public <T> Future<T> submitForInsertOperation(Runnable runnable, T t) {
        return this.writeService.submit(runnable, t);
    }
}
