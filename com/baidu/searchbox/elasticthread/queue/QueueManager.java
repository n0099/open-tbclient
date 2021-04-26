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
        for (int i2 = 0; i2 < 4; i2++) {
            this.mEnabledQueues[i2] = new ElasticQueue();
        }
    }

    public double getBlockWeight() {
        if (getQueue(0).isEmpty()) {
            double d2 = 0.0d;
            for (int i2 = 0; i2 < 4; i2++) {
                d2 += this.mEnabledQueues[i2].getCurrentWaitingTime() * ElasticConfig.ELASTIC_QUEUE_BLOCK_WEIGHT[i2];
            }
            return d2 / 1000.0d;
        }
        return 9999999.0d;
    }

    public ElasticTask getNext() {
        for (int i2 = 0; i2 < 4; i2++) {
            if (!this.mEnabledQueues[i2].isEmpty()) {
                return this.mEnabledQueues[i2].getNext();
            }
        }
        return null;
    }

    public ElasticQueue getQueue(int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = ElasticConfig.ELASTIC_QUEUE_INDEX_PRIORITY_TABLE;
            if (i3 < iArr.length) {
                if (iArr[i3] == i2) {
                    return this.mEnabledQueues[i3];
                }
                i3++;
            } else {
                ElasticQueue[] elasticQueueArr = this.mEnabledQueues;
                return elasticQueueArr[elasticQueueArr.length - 1];
            }
        }
    }

    public void insertTask(Runnable runnable, String str, int i2) {
        getQueue(i2).insertTask(runnable, str, i2);
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.mEnabledQueues[i2].onRecordBegin();
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.mEnabledQueues[i2].onRecordEnd();
        }
    }

    public void removeTask(ElasticTask elasticTask) {
        getQueue(elasticTask.getPriority()).remove(elasticTask);
    }
}
