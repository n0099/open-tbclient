package com.baidu.searchbox.elasticthread.statistic;

import android.os.SystemClock;
import com.alipay.sdk.app.statistic.b;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.bind.TypeAdapters;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class StatisticRecorder implements Recordable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ElasticRecord";
    public static final long UPLOAD_DATA_TIME_THRESHOLD = 30000;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile long lastRecordBeginTime;
    public volatile long lastRecordEndTime;
    public volatile Recordable.RecordStatus mRecordStatus;

    public StatisticRecorder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRecordStatus = Recordable.RecordStatus.UNINITIATED;
        this.lastRecordBeginTime = 0L;
        this.lastRecordEndTime = 0L;
    }

    private JSONObject loadArteryExecutorData(BaseExecutorCell baseExecutorCell) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, baseExecutorCell)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (baseExecutorCell != null) {
                jSONObject.put("maxThreadNum", baseExecutorCell.getMaxThreadNum());
                jSONObject.put("workTime", baseExecutorCell.getWorkTimeInRecordLifeCycle());
                jSONObject.put("completedTaskCount", baseExecutorCell.getCompletedTaskCountInRecordLifeCycle());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    private JSONObject loadDredgeExecutorData(BaseDredgeExecutorCell baseDredgeExecutorCell, int i2) throws JSONException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, baseDredgeExecutorCell, i2)) == null) {
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
        return (JSONObject) invokeLI.objValue;
    }

    private JSONObject loadSingleQueueData(ElasticQueue elasticQueue) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, elasticQueue)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("waitingTime", elasticQueue.getWaitingTimeInRecordLifeCycle());
            jSONObject.put("outputTaskCount", elasticQueue.getOutputTaskNumInRecordLifeCycle());
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public long getRecordElapseTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mRecordStatus == Recordable.RecordStatus.RECORD_END) {
                return this.lastRecordEndTime - this.lastRecordBeginTime;
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public Recordable.RecordStatus getRecordStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRecordStatus : (Recordable.RecordStatus) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mRecordStatus = Recordable.RecordStatus.RECORDING;
            this.lastRecordBeginTime = SystemClock.elapsedRealtime();
            this.lastRecordEndTime = 0L;
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mRecordStatus = Recordable.RecordStatus.RECORD_END;
            this.lastRecordEndTime = SystemClock.elapsedRealtime();
        }
    }

    public void uploadData() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.mRecordStatus == Recordable.RecordStatus.RECORD_END) {
            try {
                ElasticTaskScheduler elasticTaskScheduler = ElasticTaskScheduler.getInstance();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("record_time", getRecordElapseTime());
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                ArteryManager arteryManager = elasticTaskScheduler.getArteryManager();
                jSONObject3.put("first", loadArteryExecutorData(arteryManager.getUserRelatedArteryExecutor()));
                jSONObject3.put(TypeAdapters.AnonymousClass27.SECOND, loadArteryExecutorData(arteryManager.getInTimeArteryExecutor()));
                jSONObject3.put(b.f35808e, loadArteryExecutorData(arteryManager.getBackgroundArteryExecutor()));
                jSONObject2.put("artery", jSONObject3);
                JSONObject jSONObject4 = new JSONObject();
                DredgeManager dredgeManager = elasticTaskScheduler.getDredgeManager();
                jSONObject4.put("first", loadDredgeExecutorData(dredgeManager.getFirstDredgeExecutor(), ElasticConfig.DREDGE_CONFIG_FIRST_CORE_POOL_SIZE));
                jSONObject4.put(TypeAdapters.AnonymousClass27.SECOND, loadDredgeExecutorData(dredgeManager.getSecondDredgeExecutor(), ElasticConfig.DREDGE_CONFIG_SECOND_CORE_POOL_SIZE));
                jSONObject4.put("disaster", loadDredgeExecutorData(dredgeManager.getDisasterDredgeExecutor(), ElasticConfig.DREDGE_CONFIG_DISASTER_MAX_POOL_SIZE));
                jSONObject2.put("dredge", jSONObject4);
                jSONObject.put("executor", jSONObject2);
                JSONObject jSONObject5 = new JSONObject();
                QueueManager queueManager = elasticTaskScheduler.getQueueManager();
                jSONObject5.put("immediate", loadSingleQueueData(queueManager.getQueue(0)));
                jSONObject5.put("first", loadSingleQueueData(queueManager.getQueue(1)));
                jSONObject5.put(TypeAdapters.AnonymousClass27.SECOND, loadSingleQueueData(queueManager.getQueue(2)));
                jSONObject5.put(b.f35808e, loadSingleQueueData(queueManager.getQueue(3)));
                jSONObject.put("queue", jSONObject5);
                ElasticDataUploader.getInstance().uploadStatisticData(jSONObject);
            } catch (Exception unused) {
            }
        }
    }
}
