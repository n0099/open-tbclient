package com.baidu.searchbox.elasticthread.queue;

import android.text.TextUtils;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import com.baidu.searchbox.elasticthread.task.ElasticTaskBuilder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class ElasticQueue implements Recordable {
    private static final boolean DEBUG = false;
    private static final String TAG = "ElasticQueue";
    private List<ElasticTask> mElasticTasks = new LinkedList();
    private long waitingTimeInRecordLifeCycle = 0;
    private long outputTaskNumInRecordLifeCycle = 0;
    protected Recordable.RecordStatus mRecordStatus = Recordable.RecordStatus.UNINITIATED;

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

    public long getOutputTaskNumInRecordLifeCycle() {
        return this.outputTaskNumInRecordLifeCycle;
    }

    public long getWaitingTimeInRecordLifeCycle() {
        return this.waitingTimeInRecordLifeCycle;
    }

    public void insertTask(Runnable runnable, String str, int i) {
        if (runnable == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("illegal params");
        }
        ElasticTask build = ElasticTaskBuilder.getInstance().build(runnable, str, i);
        this.mElasticTasks.add(build);
        build.recordEnqueueTime();
    }

    public ElasticTask getNext() {
        if (this.mElasticTasks.isEmpty()) {
            return null;
        }
        return this.mElasticTasks.get(0);
    }

    public void remove(ElasticTask elasticTask) {
        this.mElasticTasks.remove(elasticTask);
        if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
            this.waitingTimeInRecordLifeCycle += elasticTask.getWaitingTime();
            this.outputTaskNumInRecordLifeCycle++;
        }
    }

    public long getCurrentWaitingTime() {
        long j = 0;
        Iterator<ElasticTask> it = this.mElasticTasks.iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                j = it.next().getWaitingTime() + j2;
            } else {
                return j2;
            }
        }
    }

    public int getTaskNum() {
        return this.mElasticTasks.size();
    }

    public boolean isEmpty() {
        return this.mElasticTasks.isEmpty();
    }
}
