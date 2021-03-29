package com.baidu.searchbox.elasticthread;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public class ExecutorUtilsExt {
    public static final boolean DEBUG = false;
    public static final String ELASTIC_TASK_NAME_PREFIX = "elastic_";
    public static final String SERIAL_TASK_NAME_PREFIX = "serial_";
    public static final String TAG = "ExecutorUtilsExt";
    public static final int TASK_PRIORITY_BACKGROUND = 3;
    public static final int TASK_PRIORITY_IMMEDIATE = 0;
    public static final int TASK_PRIORITY_INTIME = 2;
    public static final int TASK_PRIORITY_SERIAL = 4;
    public static final int TASK_PRIORITY_USER_RELATED = 1;

    public static void delayPostOnElastic(@NonNull Runnable runnable, @NonNull String str, int i, long j) {
        int i2;
        if (runnable == null) {
            Log.w(TAG, "received a null task ");
            return;
        }
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            i2 = i;
        } else {
            Log.w(TAG, "illegal priority " + i);
            i2 = 3;
        }
        ElasticConfig.updateConfig();
        if (ElasticConfig.elasticExecutorDisabled()) {
            BackupExecutors.getInstance().postThreadPoolTask(runnable, j);
        } else {
            ElasticTaskScheduler.getInstance().postConcurrentTaskDelay(runnable, getStandardTaskName(str, ELASTIC_TASK_NAME_PREFIX), i2, j);
        }
    }

    public static void delayPostOnSerial(@NonNull Runnable runnable, @NonNull String str, long j) {
        if (runnable == null) {
            Log.w(TAG, "received a null task ");
            return;
        }
        ElasticConfig.updateConfig();
        if (ElasticConfig.elasticExecutorDisabled()) {
            BackupExecutors.getInstance().postSerialTask(runnable, j);
        } else {
            ElasticTaskScheduler.getInstance().postSerialTaskDelay(runnable, getStandardTaskName(str, SERIAL_TASK_NAME_PREFIX), 4, j);
        }
    }

    @Deprecated
    public static Executor getElasticExecutor(String str, int i) {
        if (ElasticConfig.elasticExecutorDisabled()) {
            return BackupExecutors.getInstance().getThreadPoolExecutor();
        }
        return new ElasticExecutor(str, i);
    }

    @Deprecated
    public static Executor getImmediateExecutor(@NonNull String str) {
        if (ElasticConfig.elasticExecutorDisabled()) {
            return BackupExecutors.getInstance().getThreadPoolExecutor();
        }
        return getElasticExecutor(str, 0);
    }

    @Deprecated
    public static Executor getSerialExecutor(@NonNull String str) {
        if (ElasticConfig.elasticExecutorDisabled()) {
            return BackupExecutors.getInstance().getSerialExecutor();
        }
        return new SerialExecutor(str);
    }

    public static String getStandardTaskName(@NonNull String str, @NonNull String str2) {
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "received an empty task name ");
            str = "default";
        }
        String str3 = str2 + str;
        return str3.length() > 256 ? str3.substring(0, 255) : str3;
    }

    public static void postOnElastic(@NonNull Runnable runnable, @NonNull String str, int i) {
        delayPostOnElastic(runnable, str, i, 0L);
    }

    @Deprecated
    public static void postOnImmediate(@NonNull Runnable runnable, @NonNull String str) {
        postOnElastic(runnable, str, 0);
    }

    public static void postOnSerial(@NonNull Runnable runnable, @NonNull String str) {
        delayPostOnSerial(runnable, str, 0L);
    }
}
