package com.baidu.searchbox.elasticthread.task;

import android.text.TextUtils;
/* loaded from: classes16.dex */
public class ElasticTaskBuilder {
    private static volatile ElasticTaskBuilder sInstance = null;
    private long currentTaskId = 0;

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

    private ElasticTaskBuilder() {
    }

    public ElasticTask build(Runnable runnable, String str, int i) {
        ElasticTask elasticTask;
        if (runnable == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("illegal params");
        }
        synchronized (this) {
            this.currentTaskId++;
            elasticTask = new ElasticTask(runnable, str, this.currentTaskId, i);
        }
        return elasticTask;
    }
}
