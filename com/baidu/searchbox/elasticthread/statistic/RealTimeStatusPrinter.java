package com.baidu.searchbox.elasticthread.statistic;

import com.baidu.searchbox.elasticthread.executor.BaseDredgeExecutorCell;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.queue.ElasticQueue;
import com.baidu.searchbox.elasticthread.queue.QueueManager;
import com.baidu.searchbox.elasticthread.scheduler.ArteryManager;
import com.baidu.searchbox.elasticthread.scheduler.DredgeManager;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class RealTimeStatusPrinter {
    private static final boolean DEBUG = false;
    private static final String TAG = "ElasticRealTimeStatus";
    private static volatile RealTimeStatusPrinter sInstance = null;

    public static RealTimeStatusPrinter getInstance() {
        if (sInstance == null) {
            synchronized (RealTimeStatusPrinter.class) {
                if (sInstance == null) {
                    sInstance = new RealTimeStatusPrinter();
                }
            }
        }
        return sInstance;
    }

    public void printRealTimeData() {
        try {
            ElasticTaskScheduler elasticTaskScheduler = ElasticTaskScheduler.getInstance();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            ArteryManager arteryManager = elasticTaskScheduler.getArteryManager();
            jSONObject3.put("First", loadArteryExecutorData(arteryManager.getUserRelatedArteryExecutor()));
            jSONObject3.put("Second", loadArteryExecutorData(arteryManager.getInTimeArteryExecutor()));
            jSONObject3.put("Third", loadArteryExecutorData(arteryManager.getBackgroundArteryExecutor()));
            jSONObject2.put("Artery", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            DredgeManager dredgeManager = elasticTaskScheduler.getDredgeManager();
            jSONObject4.put("First", loadDredgeExecutorData(dredgeManager.getFirstDredgeExecutor()));
            jSONObject4.put("Second", loadDredgeExecutorData(dredgeManager.getSecondDredgeExecutor()));
            jSONObject4.put("Disaster", loadDredgeExecutorData(dredgeManager.getDisasterDredgeExecutor()));
            jSONObject2.put("Dredge", jSONObject4);
            jSONObject.put("Executor", jSONObject2);
            JSONObject jSONObject5 = new JSONObject();
            QueueManager queueManager = elasticTaskScheduler.getQueueManager();
            jSONObject5.put("Immediate", loadSingleQueueData(queueManager.getQueue(0)));
            jSONObject5.put("First", loadSingleQueueData(queueManager.getQueue(1)));
            jSONObject5.put("Second", loadSingleQueueData(queueManager.getQueue(2)));
            jSONObject5.put("Third", loadSingleQueueData(queueManager.getQueue(3)));
            jSONObject.put("Queue", jSONObject5);
            new JSONObject().put("ElasticRealTimeData", jSONObject);
        } catch (Exception e) {
        }
    }

    private JSONObject loadArteryExecutorData(BaseExecutorCell baseExecutorCell) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (baseExecutorCell != null) {
            jSONObject.put("Status", "working");
            jSONObject.put("WorkingThreadNum", baseExecutorCell.getWorkingThreadNum());
            jSONObject.put("MaxThreadNum", baseExecutorCell.getMaxThreadNum());
        }
        return jSONObject;
    }

    private JSONObject loadDredgeExecutorData(BaseDredgeExecutorCell baseDredgeExecutorCell) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (baseDredgeExecutorCell != null) {
            String str = "shutdown";
            if (baseDredgeExecutorCell.isOpen()) {
                str = "working";
            }
            jSONObject.put("Status", str);
            jSONObject.put("WorkingThreadNum", baseDredgeExecutorCell.getWorkingThreadNum());
            jSONObject.put("MaxThreadNum", baseDredgeExecutorCell.getMaxThreadNum());
        }
        return jSONObject;
    }

    private JSONObject loadSingleQueueData(ElasticQueue elasticQueue) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("TaskNum", elasticQueue.getTaskNum());
        jSONObject.put("WaitingTime", elasticQueue.getCurrentWaitingTime());
        return jSONObject;
    }
}
