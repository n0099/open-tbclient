package com.baidu.searchbox.elasticthread.statistic;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.elasticthread.executor.BaseDredgeExecutorCell;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.queue.ElasticQueue;
import com.baidu.searchbox.elasticthread.queue.QueueManager;
import com.baidu.searchbox.elasticthread.scheduler.ArteryManager;
import com.baidu.searchbox.elasticthread.scheduler.DredgeManager;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RealTimeStatusPrinter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ElasticRealTimeStatus";
    public static volatile RealTimeStatusPrinter sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-857350137, "Lcom/baidu/searchbox/elasticthread/statistic/RealTimeStatusPrinter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-857350137, "Lcom/baidu/searchbox/elasticthread/statistic/RealTimeStatusPrinter;");
        }
    }

    public RealTimeStatusPrinter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static RealTimeStatusPrinter getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                synchronized (RealTimeStatusPrinter.class) {
                    if (sInstance == null) {
                        sInstance = new RealTimeStatusPrinter();
                    }
                }
            }
            return sInstance;
        }
        return (RealTimeStatusPrinter) invokeV.objValue;
    }

    private JSONObject loadArteryExecutorData(BaseExecutorCell baseExecutorCell) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, baseExecutorCell)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (baseExecutorCell != null) {
                jSONObject.put("Status", "working");
                jSONObject.put("WorkingThreadNum", baseExecutorCell.getWorkingThreadNum());
                jSONObject.put("MaxThreadNum", baseExecutorCell.getMaxThreadNum());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    private JSONObject loadDredgeExecutorData(BaseDredgeExecutorCell baseDredgeExecutorCell) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, baseDredgeExecutorCell)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (baseDredgeExecutorCell != null) {
                jSONObject.put("Status", baseDredgeExecutorCell.isOpen() ? "working" : "shutdown");
                jSONObject.put("WorkingThreadNum", baseDredgeExecutorCell.getWorkingThreadNum());
                jSONObject.put("MaxThreadNum", baseDredgeExecutorCell.getMaxThreadNum());
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    private JSONObject loadSingleQueueData(ElasticQueue elasticQueue) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, elasticQueue)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("TaskNum", elasticQueue.getTaskNum());
            jSONObject.put("WaitingTime", elasticQueue.getCurrentWaitingTime());
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void printRealTimeData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
            } catch (Exception unused) {
            }
        }
    }
}
