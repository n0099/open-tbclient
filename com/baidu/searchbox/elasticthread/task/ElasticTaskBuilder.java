package com.baidu.searchbox.elasticthread.task;

import android.text.TextUtils;
import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public class ElasticTaskBuilder {
    public static volatile ElasticTaskBuilder sInstance;
    public long currentTaskId = 0;

    public static ElasticTaskBuilder getInstance() {
        if (sInstance == null) {
            synchronized (ElasticTaskBuilder.class) {
                if (sInstance == null) {
                    sInstance = new ElasticTaskBuilder();
                }
            }
        }
        return sInstance;
    }

    public ElasticTask build(@NonNull Runnable runnable, @NonNull String str, int i2) {
        ElasticTask elasticTask;
        if (runnable != null && !TextUtils.isEmpty(str)) {
            synchronized (this) {
                long j = this.currentTaskId + 1;
                this.currentTaskId = j;
                elasticTask = new ElasticTask(runnable, str, j, i2);
            }
            return elasticTask;
        }
        throw new IllegalArgumentException("illegal params");
    }
}
