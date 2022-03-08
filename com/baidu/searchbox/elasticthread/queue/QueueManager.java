package com.baidu.searchbox.elasticthread.queue;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class QueueManager implements Recordable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final double BLOCK_WEIGHT_IMMEDIATE = 9999999.0d;
    public static final boolean DEBUG = false;
    public static final String TAG = "QueueManager";
    public transient /* synthetic */ FieldHolder $fh;
    public final ElasticQueue[] mEnabledQueues;

    public QueueManager() {
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
        this.mEnabledQueues = new ElasticQueue[4];
        if (ElasticConfig.ELASTIC_QUEUE_INDEX_PRIORITY_TABLE.length == 4) {
            int length = ElasticConfig.ELASTIC_QUEUE_BLOCK_WEIGHT.length;
        }
        for (int i4 = 0; i4 < 4; i4++) {
            this.mEnabledQueues[i4] = new ElasticQueue();
        }
    }

    public double getBlockWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getQueue(0).isEmpty()) {
                double d2 = 0.0d;
                for (int i2 = 0; i2 < 4; i2++) {
                    d2 += this.mEnabledQueues[i2].getCurrentWaitingTime() * ElasticConfig.ELASTIC_QUEUE_BLOCK_WEIGHT[i2];
                }
                return d2 / 1000.0d;
            }
            return 9999999.0d;
        }
        return invokeV.doubleValue;
    }

    public ElasticTask getNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i2 = 0; i2 < 4; i2++) {
                if (!this.mEnabledQueues[i2].isEmpty()) {
                    return this.mEnabledQueues[i2].getNext();
                }
            }
            return null;
        }
        return (ElasticTask) invokeV.objValue;
    }

    public ElasticQueue getQueue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) != null) {
            return (ElasticQueue) invokeI.objValue;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = ElasticConfig.ELASTIC_QUEUE_INDEX_PRIORITY_TABLE;
            if (i3 < iArr.length) {
                if (iArr[i3] == i2) {
                    return this.mEnabledQueues[i3];
                }
                i3++;
            } else {
                ElasticQueue[] elasticQueueArr = this.mEnabledQueues;
                return elasticQueueArr[elasticQueueArr.length - 1];
            }
        }
    }

    public void insertTask(Runnable runnable, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, runnable, str, i2) == null) {
            getQueue(i2).insertTask(runnable, str, i2);
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (int i2 = 0; i2 < 4; i2++) {
                this.mEnabledQueues[i2].onRecordBegin();
            }
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (int i2 = 0; i2 < 4; i2++) {
                this.mEnabledQueues[i2].onRecordEnd();
            }
        }
    }

    public void removeTask(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, elasticTask) == null) {
            getQueue(elasticTask.getPriority()).remove(elasticTask);
        }
    }
}
