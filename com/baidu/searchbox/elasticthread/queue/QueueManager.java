package com.baidu.searchbox.elasticthread.queue;

import android.util.Log;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
/* loaded from: classes2.dex */
public class QueueManager implements Recordable {
    public static final double BLOCK_WEIGHT_IMMEDIATE = 9999999.0d;
    public static final boolean DEBUG = false;
    public static final String TAG = "QueueManager";
    public final ElasticQueue[] mEnabledQueues = new ElasticQueue[4];

    public QueueManager() {
        if (ElasticConfig.ELASTIC_QUEUE_INDEX_PRIORITY_TABLE.length != 4 || ElasticConfig.ELASTIC_QUEUE_BLOCK_WEIGHT.length != 4) {
            Log.e(TAG, "Elastic Queue size incompatible!");
        }
        for (int i = 0; i < 4; i++) {
            this.mEnabledQueues[i] = new ElasticQueue();
        }
    }

    public double getBlockWeight() {
        if (getQueue(0).isEmpty()) {
            double d2 = 0.0d;
            for (int i = 0; i < 4; i++) {
                double currentWaitingTime = this.mEnabledQueues[i].getCurrentWaitingTime();
                double d3 = ElasticConfig.ELASTIC_QUEUE_BLOCK_WEIGHT[i];
                Double.isNaN(currentWaitingTime);
                d2 += currentWaitingTime * d3;
            }
            return d2 / 1000.0d;
        }
        return 9999999.0d;
    }

    public ElasticTask getNext() {
        for (int i = 0; i < 4; i++) {
            if (!this.mEnabledQueues[i].isEmpty()) {
                return this.mEnabledQueues[i].getNext();
            }
        }
        return null;
    }

    public ElasticQueue getQueue(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = ElasticConfig.ELASTIC_QUEUE_INDEX_PRIORITY_TABLE;
            if (i2 < iArr.length) {
                if (iArr[i2] == i) {
                    return this.mEnabledQueues[i2];
                }
                i2++;
            } else {
                ElasticQueue[] elasticQueueArr = this.mEnabledQueues;
                return elasticQueueArr[elasticQueueArr.length - 1];
            }
        }
    }

    public void insertTask(Runnable runnable, String str, int i) {
        getQueue(i).insertTask(runnable, str, i);
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

    public void removeTask(ElasticTask elasticTask) {
        getQueue(elasticTask.getPriority()).remove(elasticTask);
    }
}
