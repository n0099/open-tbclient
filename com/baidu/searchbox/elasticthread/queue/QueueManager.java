package com.baidu.searchbox.elasticthread.queue;

import android.util.Log;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
/* loaded from: classes3.dex */
public class QueueManager implements Recordable {
    private static final double BLOCK_WEIGHT_IMMEDIATE = 9999999.0d;
    private static final boolean DEBUG = false;
    private static final String TAG = "QueueManager";
    private final ElasticQueue[] mEnabledQueues = new ElasticQueue[4];

    public QueueManager() {
        if (ElasticConfig.ELASTIC_QUEUE_INDEX_PRIORITY_TABLE.length != 4 || ElasticConfig.ELASTIC_QUEUE_BLOCK_WEIGHT.length != 4) {
            Log.e(TAG, "Elastic Queue size incompatible!");
        }
        for (int i = 0; i < 4; i++) {
            this.mEnabledQueues[i] = new ElasticQueue();
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        for (int i = 0; i < 4; i++) {
            this.mEnabledQueues[i].onRecordBegin();
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        for (int i = 0; i < 4; i++) {
            this.mEnabledQueues[i].onRecordEnd();
        }
    }

    public double getBlockWeight() {
        if (!getQueue(0).isEmpty()) {
            return BLOCK_WEIGHT_IMMEDIATE;
        }
        double d = 0.0d;
        for (int i = 0; i < 4; i++) {
            d += this.mEnabledQueues[i].getCurrentWaitingTime() * ElasticConfig.ELASTIC_QUEUE_BLOCK_WEIGHT[i];
        }
        return d / 1000.0d;
    }

    public ElasticQueue getQueue(int i) {
        for (int i2 = 0; i2 < ElasticConfig.ELASTIC_QUEUE_INDEX_PRIORITY_TABLE.length; i2++) {
            if (ElasticConfig.ELASTIC_QUEUE_INDEX_PRIORITY_TABLE[i2] == i) {
                return this.mEnabledQueues[i2];
            }
        }
        return this.mEnabledQueues[this.mEnabledQueues.length - 1];
    }

    public void insertTask(Runnable runnable, String str, int i) {
        getQueue(i).insertTask(runnable, str, i);
    }

    public ElasticTask getNext() {
        for (int i = 0; i < 4; i++) {
            if (!this.mEnabledQueues[i].isEmpty()) {
                return this.mEnabledQueues[i].getNext();
            }
        }
        return null;
    }

    public void removeTask(ElasticTask elasticTask) {
        getQueue(elasticTask.getPriority()).remove(elasticTask);
    }
}
