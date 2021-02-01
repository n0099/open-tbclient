package com.baidu.searchbox.elasticthread.executor;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public abstract class BaseDredgeExecutorCell extends BaseExecutorCell {
    protected static final long KEEP_ALIVE_TIME_OPEN = 5000;
    protected static final long KEEP_ALIVE_TIME_SHUTDOWN = 100;
    protected boolean isOpen;
    private long lastOpenTime;
    private long lastShutdownTime;
    private int openCountInRecordLifeCycle;
    private long openTimeInRecordLifeCycle;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseDredgeExecutorCell(int i) {
        super(i);
        this.lastOpenTime = 0L;
        this.lastShutdownTime = 0L;
        this.isOpen = false;
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    protected boolean available() {
        return this.isOpen && getWorkingThreadNum() < this.maxThreadNum;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void open() {
        if (this.isOpen) {
            Log.w(getTag(), "This executor cell is already opened.");
            return;
        }
        this.isOpen = true;
        this.lastOpenTime = SystemClock.elapsedRealtime();
        if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
            this.openCountInRecordLifeCycle++;
        }
        this.mExecutor.setKeepAliveTime(5000L, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
        if (!this.isOpen) {
            Log.w(getTag(), "This executor cell is already shutdown.");
            return;
        }
        this.isOpen = false;
        this.lastShutdownTime = SystemClock.elapsedRealtime();
        if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
            this.openTimeInRecordLifeCycle += this.lastShutdownTime - Math.max(this.recordBeginTime, this.lastOpenTime);
        }
        this.mExecutor.setKeepAliveTime(KEEP_ALIVE_TIME_SHUTDOWN, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public void onTaskEnd(ElasticTask elasticTask) {
        super.onTaskEnd(elasticTask);
        if (this.isOpen) {
            ElasticTaskScheduler.getInstance().postConcurrentSchedule();
        }
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell, com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        super.onRecordBegin();
        this.openCountInRecordLifeCycle = 0;
        this.openTimeInRecordLifeCycle = 0L;
        if (this.isOpen) {
            this.openTimeInRecordLifeCycle++;
        }
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell, com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        super.onRecordEnd();
        if (this.isOpen) {
            this.openTimeInRecordLifeCycle += SystemClock.elapsedRealtime() - Math.max(this.recordBeginTime, this.lastOpenTime);
        }
    }

    public int getOpenCountInRecordLifeCycle() {
        return this.openCountInRecordLifeCycle;
    }

    public long getOpenTimeInRecordLifeCycle() {
        return this.openTimeInRecordLifeCycle;
    }
}
