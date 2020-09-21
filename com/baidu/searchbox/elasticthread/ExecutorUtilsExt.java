package com.baidu.searchbox.elasticthread;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public class ExecutorUtilsExt {
    private static final boolean DEBUG = false;
    private static final String ELASTIC_TASK_NAME_PREFIX = "elastic_";
    private static final String SERIAL_TASK_NAME_PREFIX = "serial_";
    private static final String TAG = "ExecutorUtilsExt";
    public static final int TASK_PRIORITY_BACKGROUND = 3;
    public static final int TASK_PRIORITY_IMMEDIATE = 0;
    public static final int TASK_PRIORITY_INTIME = 2;
    public static final int TASK_PRIORITY_SERIAL = 4;
    public static final int TASK_PRIORITY_USER_RELATED = 1;

    public static Executor getSerialExecutor(@NonNull String str) {
        return ElasticConfig.elasticExecutorDisabled() ? BackupExecutors.getInstance().getSerialExecutor() : new SerialExecutor(str);
    }

    @Deprecated
    public static Executor getImmediateExecutor(@NonNull String str) {
        return ElasticConfig.elasticExecutorDisabled() ? BackupExecutors.getInstance().getThreadPoolExecutor() : getElasticExecutor(str, 0);
    }

    public static Executor getElasticExecutor(String str, int i) {
        return ElasticConfig.elasticExecutorDisabled() ? BackupExecutors.getInstance().getThreadPoolExecutor() : new ElasticExecutor(str, i);
    }

    public static void postOnSerial(@NonNull Runnable runnable, @NonNull String str) {
        delayPostOnSerial(runnable, str, 0L);
    }

    public static void delayPostOnSerial(@NonNull Runnable runnable, @NonNull String str, long j) {
        if (runnable == null) {
            Log.w(TAG, "received a null task ");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "default";
            Log.w(TAG, "received an empty task name ");
        }
        ElasticConfig.updateConfig();
        if (ElasticConfig.elasticExecutorDisabled()) {
            BackupExecutors.getInstance().postSerialTask(runnable, j);
        } else {
            ElasticTaskScheduler.getInstance().postSerialTaskDelay(runnable, getStandardTaskName(str, SERIAL_TASK_NAME_PREFIX), 4, j);
        }
    }

    @Deprecated
    public static void postOnImmediate(@NonNull Runnable runnable, @NonNull String str) {
        postOnElastic(runnable, str, 0);
    }

    public static void postOnElastic(@NonNull Runnable runnable, @NonNull String str, int i) {
        delayPostOnElastic(runnable, str, i, 0L);
    }

    public static void delayPostOnElastic(@NonNull Runnable runnable, @NonNull String str, int i, long j) {
        int i2 = 3;
        if (runnable == null) {
            Log.w(TAG, "received a null task ");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "received an empty task name ");
        }
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            i2 = i;
        } else {
            Log.w(TAG, "illegal priority " + i);
        }
        ElasticConfig.updateConfig();
        if (ElasticConfig.elasticExecutorDisabled()) {
            BackupExecutors.getInstance().postThreadPoolTask(runnable, j);
        } else {
            ElasticTaskScheduler.getInstance().postConcurrentTaskDelay(runnable, getStandardTaskName(str, ELASTIC_TASK_NAME_PREFIX), i2, j);
        }
    }

    private static String getStandardTaskName(@NonNull String str, @NonNull String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "default";
        }
        String str3 = str2 + str;
        if (str3.length() > 256) {
            return str3.substring(0, 255);
        }
        return str3;
    }
}
