package com.baidu.searchbox.elasticthread.scheduler;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.executor.BaseDredgeExecutorCell;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class DredgeManager implements Recordable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int DREDGE_STRATEGY_DISASTER = 3;
    public static final int DREDGE_STRATEGY_FIRST = 1;
    public static final int DREDGE_STRATEGY_SECOND = 2;
    public static final int DREDGE_STRATEGY_SHUTDOWN = 0;
    public static final String TAG = "ElasticDredgeManager";
    public transient /* synthetic */ FieldHolder $fh;
    public int currentDredgeStrategy;
    public long lastAdjustTime;
    public volatile BaseDredgeExecutorCell mDisasterDredgeExecutor;
    public volatile BaseDredgeExecutorCell mFirstDredgeExecutor;
    public volatile BaseDredgeExecutorCell mSecondDredgeExecutor;

    public DredgeManager() {
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
        this.currentDredgeStrategy = 0;
        this.lastAdjustTime = 0L;
    }

    private void downgradeStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            int i2 = this.currentDredgeStrategy;
            if (1 == i2) {
                getFirstDredgeExecutor().shutdown();
                this.currentDredgeStrategy = 0;
            } else if (2 == i2) {
                getSecondDredgeExecutor().shutdown();
                this.currentDredgeStrategy = 1;
            } else if (3 == i2) {
                getDisasterDredgeExecutor().shutdown();
                this.currentDredgeStrategy = 2;
            }
        }
    }

    private void upgradeStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            int i2 = this.currentDredgeStrategy;
            if (i2 == 0) {
                getFirstDredgeExecutor().open();
                this.currentDredgeStrategy = 1;
            } else if (1 == i2) {
                getSecondDredgeExecutor().open();
                this.currentDredgeStrategy = 2;
            } else if (2 == i2) {
                getDisasterDredgeExecutor().open();
                this.currentDredgeStrategy = 3;
            }
        }
    }

    public int adjustDredgeStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            double blockWeight = ElasticTaskScheduler.getInstance().getQueueManager().getBlockWeight();
            if (blockWeight >= ElasticConfig.DREDGE_CONFIG_UPGRADE_THRESHOLD && 3 != this.currentDredgeStrategy) {
                if ((blockWeight >= ElasticConfig.DREDGE_CONFIG_UPGRADE_RIGHT_AWAY_THRESHOLD) || SystemClock.elapsedRealtime() - this.lastAdjustTime > ElasticConfig.DREDGE_CONFIG_UPGRADE_STRATEGY_PROTECTION_TIME) {
                    upgradeStrategy();
                    this.lastAdjustTime = SystemClock.elapsedRealtime();
                    ElasticTaskScheduler.getInstance().postConcurrentDredgeDelay(ElasticConfig.DREDGE_CONFIG_UPGRADE_STRATEGY_PROTECTION_TIME + 10);
                    return 1;
                }
            }
            if (this.currentDredgeStrategy == 0 || blockWeight >= ElasticConfig.DREDGE_CONFIG_DOWNGRADE_THRESHOLD || SystemClock.elapsedRealtime() - this.lastAdjustTime <= ElasticConfig.DREDGE_CONFIG_DOWNGRADE_STRATEGY_PROTECTION_TIME) {
                return 0;
            }
            downgradeStrategy();
            this.lastAdjustTime = SystemClock.elapsedRealtime();
            ElasticTaskScheduler.getInstance().postConcurrentDredgeDelay(ElasticConfig.DREDGE_CONFIG_DOWNGRADE_STRATEGY_PROTECTION_TIME + 10);
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean execute(ElasticTask elasticTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, elasticTask)) == null) {
            int i2 = this.currentDredgeStrategy;
            if (i2 == 0) {
                return false;
            }
            return i2 == 1 ? getFirstDredgeExecutor().execute(elasticTask) : i2 == 2 ? getFirstDredgeExecutor().execute(elasticTask) || getSecondDredgeExecutor().execute(elasticTask) : i2 == 3 && (getFirstDredgeExecutor().execute(elasticTask) || getSecondDredgeExecutor().execute(elasticTask) || getDisasterDredgeExecutor().execute(elasticTask));
        }
        return invokeL.booleanValue;
    }

    public BaseDredgeExecutorCell getDisasterDredgeExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mDisasterDredgeExecutor == null) {
                synchronized (this) {
                    if (this.mDisasterDredgeExecutor == null) {
                        this.mDisasterDredgeExecutor = (BaseDredgeExecutorCell) BaseExecutorCell.build(ElasticConfig.DREDGE_CONFIG_DISASTER_MAX_POOL_SIZE, BaseExecutorCell.ExecutorType.DREDGE_DISASTER);
                    }
                }
            }
            return this.mDisasterDredgeExecutor;
        }
        return (BaseDredgeExecutorCell) invokeV.objValue;
    }

    public BaseDredgeExecutorCell getFirstDredgeExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mFirstDredgeExecutor == null) {
                synchronized (this) {
                    if (this.mFirstDredgeExecutor == null) {
                        this.mFirstDredgeExecutor = (BaseDredgeExecutorCell) BaseExecutorCell.build(ElasticConfig.DREDGE_CONFIG_FIRST_CORE_POOL_SIZE, BaseExecutorCell.ExecutorType.DREDGE_NORMAL);
                    }
                }
            }
            return this.mFirstDredgeExecutor;
        }
        return (BaseDredgeExecutorCell) invokeV.objValue;
    }

    public BaseDredgeExecutorCell getSecondDredgeExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mSecondDredgeExecutor == null) {
                synchronized (this) {
                    if (this.mSecondDredgeExecutor == null) {
                        this.mSecondDredgeExecutor = (BaseDredgeExecutorCell) BaseExecutorCell.build(ElasticConfig.DREDGE_CONFIG_SECOND_CORE_POOL_SIZE, BaseExecutorCell.ExecutorType.DREDGE_NORMAL);
                    }
                }
            }
            return this.mSecondDredgeExecutor;
        }
        return (BaseDredgeExecutorCell) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            getFirstDredgeExecutor().onRecordBegin();
            getSecondDredgeExecutor().onRecordBegin();
            getDisasterDredgeExecutor().onRecordBegin();
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            getFirstDredgeExecutor().onRecordEnd();
            getSecondDredgeExecutor().onRecordEnd();
            getDisasterDredgeExecutor().onRecordEnd();
        }
    }
}
