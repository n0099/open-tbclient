package com.baidu.searchbox.elasticthread.executor;

import android.util.Log;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.ElasticDataUploader;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SerialExecutorCell extends BaseExecutorCell {
    private static final int SERIAL_MAX_THREAD_NUM = 1;
    private int dredgeCountInRecordLifeCycle;

    /* JADX INFO: Access modifiers changed from: protected */
    public SerialExecutorCell(int i) {
        super(i);
        this.dredgeCountInRecordLifeCycle = 0;
        if (i != 1) {
            Log.w(getTag(), "You are creating a SerialExecutorCell with maxThreadNum " + i + ". For SerialExecutorCell, maxThreadNum must be 1. So it will be forced to set to 1.");
            this.maxThreadNum = 1;
        }
        this.mExecutor = new ThreadPoolExecutor(1, 1, ElasticConfig.EXECUTOR_CONFIG_KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    protected boolean available() {
        return getWorkingThreadNum() < 1;
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    protected String getTag() {
        return "SerialElasticExecutorCell";
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    protected synchronized void onTaskEnd(ElasticTask elasticTask) {
        super.onTaskEnd(elasticTask);
        ElasticTaskScheduler.getInstance().postSerialSchedule();
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    protected synchronized void onTaskBegin(ElasticTask elasticTask) {
        super.onTaskBegin(elasticTask);
        if (ElasticConfig.ENABLE_SERIAL_DREDGE) {
            ElasticTaskScheduler.getInstance().postSerialDredgeDelay(ElasticConfig.SERIAL_BLOCK_TIME_THRESHOLD + 10);
        }
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell, com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        super.onRecordBegin();
        this.dredgeCountInRecordLifeCycle = 0;
    }

    public synchronized boolean checkBlockAndDredge() {
        ElasticTask currentWorkingTask;
        boolean z = false;
        synchronized (this) {
            if (ElasticConfig.ENABLE_SERIAL_DREDGE && (currentWorkingTask = getCurrentWorkingTask()) != null && currentWorkingTask.getRawWorkTime() >= ElasticConfig.SERIAL_BLOCK_TIME_THRESHOLD) {
                applyDredge(currentWorkingTask);
                z = true;
            }
        }
        return z;
    }

    private synchronized ElasticTask getCurrentWorkingTask() {
        return this.mWorkingTasks.isEmpty() ? null : this.mWorkingTasks.get(0);
    }

    private void applyDredge(ElasticTask elasticTask) {
        if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
            this.workTimeInRecordLifeCycle += elasticTask.getWorkTimeInRecordLifeCycle(this.recordBeginTime, this.recordEndTime);
            this.completedTaskCountInRecordLifeCycle++;
            this.dredgeCountInRecordLifeCycle++;
        }
        ElasticDataUploader.getInstance().uploadWarningData(getBlockWarningMsg(elasticTask));
        elasticTask.setElasticTaskCallback(null);
        this.mExecutor.shutdown();
        this.mWorkingTasks.clear();
        this.mExecutor = new ThreadPoolExecutor(1, 1, ElasticConfig.EXECUTOR_CONFIG_KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        ElasticTaskScheduler.getInstance().postSerialSchedule();
    }

    private JSONObject getBlockWarningMsg(ElasticTask elasticTask) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("warning_type", "serial_block");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("block_task", elasticTask.getName());
            jSONObject.put("warning_data", jSONObject2);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
