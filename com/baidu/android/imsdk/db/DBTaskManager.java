package com.baidu.android.imsdk.db;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes3.dex */
public class DBTaskManager {
    private static DBTaskManager mInstance;
    private ExecutorService writeService = Executors.newSingleThreadExecutor();

    private DBTaskManager(Context context) {
    }

    public static synchronized DBTaskManager getInstance(Context context) {
        DBTaskManager dBTaskManager;
        synchronized (DBTaskManager.class) {
            if (context == null) {
                dBTaskManager = null;
            } else {
                if (mInstance == null) {
                    mInstance = new DBTaskManager(context);
                }
                dBTaskManager = mInstance;
            }
        }
        return dBTaskManager;
    }

    public <T> Future<T> submitForInsertOperation(Runnable runnable, T t) {
        return this.writeService.submit(runnable, t);
    }
}
