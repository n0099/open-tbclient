package com.baidu.searchbox.elasticthread.executor;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public abstract class BaseDredgeExecutorCell extends BaseExecutorCell {
    public static final long KEEP_ALIVE_TIME_OPEN = 5000;
    public static final long KEEP_ALIVE_TIME_SHUTDOWN = 100;
    public boolean isOpen;
    public long lastOpenTime;
    public long lastShutdownTime;
    public int openCountInRecordLifeCycle;
    public long openTimeInRecordLifeCycle;

    public BaseDredgeExecutorCell(int i) {
        super(i);
        this.lastOpenTime = 0L;
        this.lastShutdownTime = 0L;
        this.isOpen = false;
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public void onTaskEnd(ElasticTask elasticTask) {
        super.onTaskEnd(elasticTask);
        if (this.isOpen) {
            ElasticTaskScheduler.getInstance().postConcurrentSchedule();
        }
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public boolean available() {
        if (!this.isOpen || getWorkingThreadNum() >= this.maxThreadNum) {
            return false;
        }
        return true;
    }

    public int getOpenCountInRecordLifeCycle() {
        return this.openCountInRecordLifeCycle;
    }

    public long getOpenTimeInRecordLifeCycle() {
        return this.openTimeInRecordLifeCycle;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell, com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        super.onRecordBegin();
        this.openCountInRecordLifeCycle = 0;
        this.openTimeInRecordLifeCycle = 0L;
        if (this.isOpen) {
            this.openTimeInRecordLifeCycle = 0 + 1;
        }
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell, com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        super.onRecordEnd();
        if (this.isOpen) {
            this.openTimeInRecordLifeCycle += SystemClock.elapsedRealtime() - Math.max(this.recordBeginTime, this.lastOpenTime);
        }
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
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.lastShutdownTime = elapsedRealtime;
        if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
            this.openTimeInRecordLifeCycle += elapsedRealtime - Math.max(this.recordBeginTime, this.lastOpenTime);
        }
        this.mExecutor.setKeepAliveTime(100L, TimeUnit.MILLISECONDS);
    }
}
