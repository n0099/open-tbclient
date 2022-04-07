package com.baidu.searchbox.elasticthread.queue;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEnabledQueues = new ElasticQueue[4];
        if (ElasticConfig.ELASTIC_QUEUE_INDEX_PRIORITY_TABLE.length != 4 || ElasticConfig.ELASTIC_QUEUE_BLOCK_WEIGHT.length != 4) {
            Log.e(TAG, "Elastic Queue size incompatible!");
        }
        for (int i3 = 0; i3 < 4; i3++) {
            this.mEnabledQueues[i3] = new ElasticQueue();
        }
    }

    public double getBlockWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (getQueue(0).isEmpty()) {
                double d = 0.0d;
                for (int i = 0; i < 4; i++) {
                    d += this.mEnabledQueues[i].getCurrentWaitingTime() * ElasticConfig.ELASTIC_QUEUE_BLOCK_WEIGHT[i];
                }
                return d / 1000.0d;
            }
            return 9999999.0d;
        }
        return invokeV.doubleValue;
    }

    public ElasticTask getNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i = 0; i < 4; i++) {
                if (!this.mEnabledQueues[i].isEmpty()) {
                    return this.mEnabledQueues[i].getNext();
                }
            }
            return null;
        }
        return (ElasticTask) invokeV.objValue;
    }

    public ElasticQueue getQueue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) != null) {
            return (ElasticQueue) invokeI.objValue;
        }
        int i2 = 0;
        while (true) {
            int[] iArr = ElasticConfig.ELASTIC_QUEUE_INDEX_PRIORITY_TABLE;
            if (i2 < iArr.length) {
                if (iArr[i2] == i) {
                    return this.mEnabledQueues[i2];
                }
                i2++;
            } else {
                ElasticQueue[] elasticQueueArr = this.mEnabledQueues;
                return elasticQueueArr[elasticQueueArr.length - 1];
            }
        }
    }

    public void insertTask(Runnable runnable, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, runnable, str, i) == null) {
            getQueue(i).insertTask(runnable, str, i);
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (int i = 0; i < 4; i++) {
                this.mEnabledQueues[i].onRecordBegin();
            }
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (int i = 0; i < 4; i++) {
                this.mEnabledQueues[i].onRecordEnd();
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
