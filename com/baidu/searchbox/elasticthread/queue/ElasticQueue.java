package com.baidu.searchbox.elasticthread.queue;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import com.baidu.searchbox.elasticthread.task.ElasticTaskBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class ElasticQueue implements Recordable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ElasticQueue";
    public transient /* synthetic */ FieldHolder $fh;
    public List mElasticTasks;
    public Recordable.RecordStatus mRecordStatus;
    public long outputTaskNumInRecordLifeCycle;
    public long waitingTimeInRecordLifeCycle;

    public ElasticQueue() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mElasticTasks = new LinkedList();
        this.waitingTimeInRecordLifeCycle = 0L;
        this.outputTaskNumInRecordLifeCycle = 0L;
        this.mRecordStatus = Recordable.RecordStatus.UNINITIATED;
    }

    public long getCurrentWaitingTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j = 0;
            for (ElasticTask elasticTask : this.mElasticTasks) {
                j += elasticTask.getWaitingTime();
            }
            return j;
        }
        return invokeV.longValue;
    }

    public ElasticTask getNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mElasticTasks.isEmpty()) {
                return null;
            }
            return (ElasticTask) this.mElasticTasks.get(0);
        }
        return (ElasticTask) invokeV.objValue;
    }

    public long getOutputTaskNumInRecordLifeCycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.outputTaskNumInRecordLifeCycle;
        }
        return invokeV.longValue;
    }

    public int getTaskNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mElasticTasks.size();
        }
        return invokeV.intValue;
    }

    public long getWaitingTimeInRecordLifeCycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.waitingTimeInRecordLifeCycle;
        }
        return invokeV.longValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mElasticTasks.isEmpty();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.waitingTimeInRecordLifeCycle = 0L;
            this.outputTaskNumInRecordLifeCycle = 0L;
            this.mRecordStatus = Recordable.RecordStatus.RECORDING;
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mRecordStatus = Recordable.RecordStatus.RECORD_END;
        }
    }

    public void insertTask(Runnable runnable, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, runnable, str, i) == null) {
            if (runnable != null && !TextUtils.isEmpty(str)) {
                ElasticTask build = ElasticTaskBuilder.getInstance().build(runnable, str, i);
                this.mElasticTasks.add(build);
                build.recordEnqueueTime();
                return;
            }
            throw new IllegalArgumentException("illegal params");
        }
    }

    public void remove(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, elasticTask) == null) {
            this.mElasticTasks.remove(elasticTask);
            if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
                this.waitingTimeInRecordLifeCycle += elasticTask.getWaitingTime();
                this.outputTaskNumInRecordLifeCycle++;
            }
        }
    }
}
