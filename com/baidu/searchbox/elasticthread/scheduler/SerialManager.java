package com.baidu.searchbox.elasticthread.scheduler;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.executor.SerialExecutorCell;
import com.baidu.searchbox.elasticthread.queue.ElasticQueue;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SerialManager implements Recordable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseExecutorCell mCurrentWorkingExecutor;
    public ElasticQueue mElasticQueue;

    public SerialManager() {
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
        this.mElasticQueue = new ElasticQueue();
        this.mCurrentWorkingExecutor = BaseExecutorCell.build(1, BaseExecutorCell.ExecutorType.SERIAL);
    }

    public boolean checkBlockAndDredge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((SerialExecutorCell) this.mCurrentWorkingExecutor).checkBlockAndDredge() : invokeV.booleanValue;
    }

    public void insertTask(Runnable runnable, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, str, i2) == null) {
            this.mElasticQueue.insertTask(runnable, str, i2);
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mCurrentWorkingExecutor.onRecordBegin();
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mCurrentWorkingExecutor.onRecordEnd();
        }
    }

    public boolean scheduleNextTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ElasticTask next = this.mElasticQueue.getNext();
            if (next != null && this.mCurrentWorkingExecutor.execute(next)) {
                this.mElasticQueue.remove(next);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
