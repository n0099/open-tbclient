package com.baidu.searchbox.elasticthread.statistic;

import android.os.SystemClock;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.ElasticDataUploader;
import com.baidu.searchbox.elasticthread.executor.BaseDredgeExecutorCell;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.queue.ElasticQueue;
import com.baidu.searchbox.elasticthread.queue.QueueManager;
import com.baidu.searchbox.elasticthread.scheduler.ArteryManager;
import com.baidu.searchbox.elasticthread.scheduler.DredgeManager;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class StatisticRecorder implements Recordable {
    private static final boolean DEBUG = false;
    private static final String TAG = "ElasticRecord";
    public static final long UPLOAD_DATA_TIME_THRESHOLD = 30000;
    private volatile Recordable.RecordStatus mRecordStatus = Recordable.RecordStatus.UNINITIATED;
    private volatile long lastRecordBeginTime = 0;
    private volatile long lastRecordEndTime = 0;

    public long getRecordElapseTime() {
        if (this.mRecordStatus == Recordable.RecordStatus.RECORD_END) {
            return this.lastRecordEndTime - this.lastRecordBeginTime;
        }
        return -1L;
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        this.mRecordStatus = Recordable.RecordStatus.RECORDING;
        this.lastRecordBeginTime = SystemClock.elapsedRealtime();
        this.lastRecordEndTime = 0L;
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        this.mRecordStatus = Recordable.RecordStatus.RECORD_END;
        this.lastRecordEndTime = SystemClock.elapsedRealtime();
    }

    public Recordable.RecordStatus getRecordStatus() {
        return this.mRecordStatus;
    }

    public void uploadData() {
        if (this.mRecordStatus == Recordable.RecordStatus.RECORD_END) {
            try {
                ElasticTaskScheduler elasticTaskScheduler = ElasticTaskScheduler.getInstance();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("record_time", getRecordElapseTime());
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                ArteryManager arteryManager = elasticTaskScheduler.getArteryManager();
                jSONObject3.put(Config.TRACE_VISIT_FIRST, loadArteryExecutorData(arteryManager.getUserRelatedArteryExecutor()));
                jSONObject3.put("second", loadArteryExecutorData(arteryManager.getInTimeArteryExecutor()));
                jSONObject3.put("third", loadArteryExecutorData(arteryManager.getBackgroundArteryExecutor()));
                jSONObject2.put("artery", jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                DredgeManager dredgeManager = elasticTaskScheduler.getDredgeManager();
                jSONObject4.put(Config.TRACE_VISIT_FIRST, loadDredgeExecutorData(dredgeManager.getFirstDredgeExecutor(), ElasticConfig.DREDGE_CONFIG_FIRST_CORE_POOL_SIZE));
                jSONObject4.put("second", loadDredgeExecutorData(dredgeManager.getSecondDredgeExecutor(), ElasticConfig.DREDGE_CONFIG_SECOND_CORE_POOL_SIZE));
                jSONObject4.put("disaster", loadDredgeExecutorData(dredgeManager.getDisasterDredgeExecutor(), ElasticConfig.DREDGE_CONFIG_DISASTER_MAX_POOL_SIZE));
                jSONObject2.put("dredge", jSONObject4);
                jSONObject.put("executor", jSONObject2);
                JSONObject jSONObject5 = new JSONObject();
                QueueManager queueManager = elasticTaskScheduler.getQueueManager();
                jSONObject5.put("immediate", loadSingleQueueData(queueManager.getQueue(0)));
                jSONObject5.put(Config.TRACE_VISIT_FIRST, loadSingleQueueData(queueManager.getQueue(1)));
                jSONObject5.put("second", loadSingleQueueData(queueManager.getQueue(2)));
                jSONObject5.put("third", loadSingleQueueData(queueManager.getQueue(3)));
                jSONObject.put("queue", jSONObject5);
                ElasticDataUploader.getInstance().uploadStatisticData(jSONObject);
            } catch (Exception e) {
            }
        }
    }

    private JSONObject loadArteryExecutorData(BaseExecutorCell baseExecutorCell) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (baseExecutorCell != null) {
            jSONObject.put("maxThreadNum", baseExecutorCell.getMaxThreadNum());
            jSONObject.put("workTime", baseExecutorCell.getWorkTimeInRecordLifeCycle());
            jSONObject.put("completedTaskCount", baseExecutorCell.getCompletedTaskCountInRecordLifeCycle());
        }
        return jSONObject;
    }

    private JSONObject loadDredgeExecutorData(BaseDredgeExecutorCell baseDredgeExecutorCell, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (baseDredgeExecutorCell != null) {
            jSONObject.put("maxThreadNum", baseDredgeExecutorCell.getMaxThreadNum());
            jSONObject.put("workTime", baseDredgeExecutorCell.getWorkTimeInRecordLifeCycle());
            jSONObject.put("completedTaskCount", baseDredgeExecutorCell.getCompletedTaskCountInRecordLifeCycle());
            jSONObject.put("openTime", baseDredgeExecutorCell.getOpenTimeInRecordLifeCycle());
            jSONObject.put("openCount", baseDredgeExecutorCell.getOpenCountInRecordLifeCycle());
        }
        return jSONObject;
    }

    private JSONObject loadSingleQueueData(ElasticQueue elasticQueue) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("waitingTime", elasticQueue.getWaitingTimeInRecordLifeCycle());
        jSONObject.put("outputTaskCount", elasticQueue.getOutputTaskNumInRecordLifeCycle());
        return jSONObject;
    }
}
