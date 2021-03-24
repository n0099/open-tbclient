package com.baidu.searchbox.elasticthread.scheduler;

import android.os.SystemClock;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.executor.BaseDredgeExecutorCell;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
/* loaded from: classes2.dex */
public class DredgeManager implements Recordable {
    public static final boolean DEBUG = false;
    public static final int DREDGE_STRATEGY_DISASTER = 3;
    public static final int DREDGE_STRATEGY_FIRST = 1;
    public static final int DREDGE_STRATEGY_SECOND = 2;
    public static final int DREDGE_STRATEGY_SHUTDOWN = 0;
    public static final String TAG = "ElasticDredgeManager";
    public int currentDredgeStrategy = 0;
    public long lastAdjustTime = 0;
    public volatile BaseDredgeExecutorCell mDisasterDredgeExecutor;
    public volatile BaseDredgeExecutorCell mFirstDredgeExecutor;
    public volatile BaseDredgeExecutorCell mSecondDredgeExecutor;

    private void downgradeStrategy() {
        int i = this.currentDredgeStrategy;
        if (1 == i) {
            getFirstDredgeExecutor().shutdown();
            this.currentDredgeStrategy = 0;
        } else if (2 == i) {
            getSecondDredgeExecutor().shutdown();
            this.currentDredgeStrategy = 1;
        } else if (3 == i) {
            getDisasterDredgeExecutor().shutdown();
            this.currentDredgeStrategy = 2;
        }
    }

    private void upgradeStrategy() {
        int i = this.currentDredgeStrategy;
        if (i == 0) {
            getFirstDredgeExecutor().open();
            this.currentDredgeStrategy = 1;
        } else if (1 == i) {
            getSecondDredgeExecutor().open();
            this.currentDredgeStrategy = 2;
        } else if (2 == i) {
            getDisasterDredgeExecutor().open();
            this.currentDredgeStrategy = 3;
        }
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

    public boolean execute(ElasticTask elasticTask) {
        int i = this.currentDredgeStrategy;
        if (i == 0) {
            return false;
        }
        return i == 1 ? getFirstDredgeExecutor().execute(elasticTask) : i == 2 ? getFirstDredgeExecutor().execute(elasticTask) || getSecondDredgeExecutor().execute(elasticTask) : i == 3 && (getFirstDredgeExecutor().execute(elasticTask) || getSecondDredgeExecutor().execute(elasticTask) || getDisasterDredgeExecutor().execute(elasticTask));
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
}
