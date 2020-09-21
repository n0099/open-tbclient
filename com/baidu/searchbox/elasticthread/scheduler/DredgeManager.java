package com.baidu.searchbox.elasticthread.scheduler;

import android.os.SystemClock;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.executor.BaseDredgeExecutorCell;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
/* loaded from: classes10.dex */
public class DredgeManager implements Recordable {
    private static final boolean DEBUG = false;
    private static final int DREDGE_STRATEGY_DISASTER = 3;
    private static final int DREDGE_STRATEGY_FIRST = 1;
    private static final int DREDGE_STRATEGY_SECOND = 2;
    private static final int DREDGE_STRATEGY_SHUTDOWN = 0;
    private static final String TAG = "ElasticDredgeManager";
    private int currentDredgeStrategy = 0;
    private long lastAdjustTime = 0;
    private volatile BaseDredgeExecutorCell mDisasterDredgeExecutor;
    private volatile BaseDredgeExecutorCell mFirstDredgeExecutor;
    private volatile BaseDredgeExecutorCell mSecondDredgeExecutor;

    public BaseDredgeExecutorCell getFirstDredgeExecutor() {
        if (this.mFirstDredgeExecutor == null) {
            synchronized (this) {
                if (this.mFirstDredgeExecutor == null) {
                    this.mFirstDredgeExecutor = (BaseDredgeExecutorCell) BaseExecutorCell.build(ElasticConfig.DREDGE_CONFIG_FIRST_CORE_POOL_SIZE, BaseExecutorCell.ExecutorType.DREDGE_NORMAL);
                }
            }
        }
        return this.mFirstDredgeExecutor;
    }

    public BaseDredgeExecutorCell getSecondDredgeExecutor() {
        if (this.mSecondDredgeExecutor == null) {
            synchronized (this) {
                if (this.mSecondDredgeExecutor == null) {
                    this.mSecondDredgeExecutor = (BaseDredgeExecutorCell) BaseExecutorCell.build(ElasticConfig.DREDGE_CONFIG_SECOND_CORE_POOL_SIZE, BaseExecutorCell.ExecutorType.DREDGE_NORMAL);
                }
            }
        }
        return this.mSecondDredgeExecutor;
    }

    public BaseDredgeExecutorCell getDisasterDredgeExecutor() {
        if (this.mDisasterDredgeExecutor == null) {
            synchronized (this) {
                if (this.mDisasterDredgeExecutor == null) {
                    this.mDisasterDredgeExecutor = (BaseDredgeExecutorCell) BaseExecutorCell.build(ElasticConfig.DREDGE_CONFIG_DISASTER_MAX_POOL_SIZE, BaseExecutorCell.ExecutorType.DREDGE_DISASTER);
                }
            }
        }
        return this.mDisasterDredgeExecutor;
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        getFirstDredgeExecutor().onRecordBegin();
        getSecondDredgeExecutor().onRecordBegin();
        getDisasterDredgeExecutor().onRecordBegin();
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        getFirstDredgeExecutor().onRecordEnd();
        getSecondDredgeExecutor().onRecordEnd();
        getDisasterDredgeExecutor().onRecordEnd();
    }

    public int adjustDredgeStrategy() {
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

    private void upgradeStrategy() {
        if (this.currentDredgeStrategy == 0) {
            getFirstDredgeExecutor().open();
            this.currentDredgeStrategy = 1;
        } else if (1 == this.currentDredgeStrategy) {
            getSecondDredgeExecutor().open();
            this.currentDredgeStrategy = 2;
        } else if (2 == this.currentDredgeStrategy) {
            getDisasterDredgeExecutor().open();
            this.currentDredgeStrategy = 3;
        }
    }

    private void downgradeStrategy() {
        if (1 == this.currentDredgeStrategy) {
            getFirstDredgeExecutor().shutdown();
            this.currentDredgeStrategy = 0;
        } else if (2 == this.currentDredgeStrategy) {
            getSecondDredgeExecutor().shutdown();
            this.currentDredgeStrategy = 1;
        } else if (3 == this.currentDredgeStrategy) {
            getDisasterDredgeExecutor().shutdown();
            this.currentDredgeStrategy = 2;
        }
    }

    public boolean execute(ElasticTask elasticTask) {
        if (this.currentDredgeStrategy == 0) {
            return false;
        }
        if (this.currentDredgeStrategy == 1) {
            return getFirstDredgeExecutor().execute(elasticTask);
        } else if (this.currentDredgeStrategy == 2) {
            return getFirstDredgeExecutor().execute(elasticTask) || getSecondDredgeExecutor().execute(elasticTask);
        } else if (this.currentDredgeStrategy == 3) {
            return getFirstDredgeExecutor().execute(elasticTask) || getSecondDredgeExecutor().execute(elasticTask) || getDisasterDredgeExecutor().execute(elasticTask);
        } else {
            return false;
        }
    }
}
