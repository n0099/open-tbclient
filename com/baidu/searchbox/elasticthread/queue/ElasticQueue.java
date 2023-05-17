package com.baidu.searchbox.elasticthread.queue;

import android.text.TextUtils;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import com.baidu.searchbox.elasticthread.task.ElasticTaskBuilder;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ElasticQueue implements Recordable {
    public static final boolean DEBUG = false;
    public static final String TAG = "ElasticQueue";
    public List<ElasticTask> mElasticTasks = new LinkedList();
    public long waitingTimeInRecordLifeCycle = 0;
    public long outputTaskNumInRecordLifeCycle = 0;
    public Recordable.RecordStatus mRecordStatus = Recordable.RecordStatus.UNINITIATED;

    public long getCurrentWaitingTime() {
        long j = 0;
        for (ElasticTask elasticTask : this.mElasticTasks) {
            j += elasticTask.getWaitingTime();
        }
        return j;
    }

    public ElasticTask getNext() {
        if (this.mElasticTasks.isEmpty()) {
            return null;
        }
        return this.mElasticTasks.get(0);
    }

    public long getOutputTaskNumInRecordLifeCycle() {
        return this.outputTaskNumInRecordLifeCycle;
    }

    public int getTaskNum() {
        return this.mElasticTasks.size();
    }

    public long getWaitingTimeInRecordLifeCycle() {
        return this.waitingTimeInRecordLifeCycle;
    }

    public boolean isEmpty() {
        return this.mElasticTasks.isEmpty();
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        this.waitingTimeInRecordLifeCycle = 0L;
        this.outputTaskNumInRecordLifeCycle = 0L;
        this.mRecordStatus = Recordable.RecordStatus.RECORDING;
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        this.mRecordStatus = Recordable.RecordStatus.RECORD_END;
    }

    public void insertTask(Runnable runnable, String str, int i) {
        if (runnable != null && !TextUtils.isEmpty(str)) {
            ElasticTask build = ElasticTaskBuilder.getInstance().build(runnable, str, i);
            this.mElasticTasks.add(build);
            build.recordEnqueueTime();
            return;
        }
        throw new IllegalArgumentException("illegal params");
    }

    public void remove(ElasticTask elasticTask) {
        this.mElasticTasks.remove(elasticTask);
        if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
            this.waitingTimeInRecordLifeCycle += elasticTask.getWaitingTime();
            this.outputTaskNumInRecordLifeCycle++;
        }
    }
}
