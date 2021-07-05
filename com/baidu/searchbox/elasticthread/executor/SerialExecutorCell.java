package com.baidu.searchbox.elasticthread.executor;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.ElasticDataUploader;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SerialExecutorCell extends BaseExecutorCell {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SERIAL_MAX_THREAD_NUM = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int dredgeCountInRecordLifeCycle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SerialExecutorCell(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dredgeCountInRecordLifeCycle = 0;
        if (i2 != 1) {
            String tag = getTag();
            Log.w(tag, "You are creating a SerialExecutorCell with maxThreadNum " + i2 + ". For SerialExecutorCell, maxThreadNum must be 1. So it will be forced to set to 1.");
            this.maxThreadNum = 1;
        }
        this.mExecutor = new ThreadPoolExecutor(1, 1, ElasticConfig.EXECUTOR_CONFIG_KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    private void applyDredge(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, elasticTask) == null) {
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
    }

    private JSONObject getBlockWarningMsg(ElasticTask elasticTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, elasticTask)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("warning_type", "serial_block");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("block_task", elasticTask.getName());
                jSONObject.put("warning_data", jSONObject2);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    private synchronized ElasticTask getCurrentWorkingTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            synchronized (this) {
                if (this.mWorkingTasks.isEmpty()) {
                    return null;
                }
                return this.mWorkingTasks.get(0);
            }
        }
        return (ElasticTask) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public boolean available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getWorkingThreadNum() < 1 : invokeV.booleanValue;
    }

    public synchronized boolean checkBlockAndDredge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (ElasticConfig.ENABLE_SERIAL_DREDGE) {
                    ElasticTask currentWorkingTask = getCurrentWorkingTask();
                    if (currentWorkingTask == null) {
                        return false;
                    }
                    if (currentWorkingTask.getRawWorkTime() >= ElasticConfig.SERIAL_BLOCK_TIME_THRESHOLD) {
                        applyDredge(currentWorkingTask);
                        return true;
                    }
                    return false;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SerialElasticExecutorCell" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell, com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onRecordBegin();
            this.dredgeCountInRecordLifeCycle = 0;
        }
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public synchronized void onTaskBegin(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, elasticTask) == null) {
            synchronized (this) {
                super.onTaskBegin(elasticTask);
                if (ElasticConfig.ENABLE_SERIAL_DREDGE) {
                    ElasticTaskScheduler.getInstance().postSerialDredgeDelay(ElasticConfig.SERIAL_BLOCK_TIME_THRESHOLD + 10);
                }
            }
        }
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public synchronized void onTaskEnd(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, elasticTask) == null) {
            synchronized (this) {
                super.onTaskEnd(elasticTask);
                ElasticTaskScheduler.getInstance().postSerialSchedule();
            }
        }
    }
}
