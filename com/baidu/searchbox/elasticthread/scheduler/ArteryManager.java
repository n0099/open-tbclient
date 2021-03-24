package com.baidu.searchbox.elasticthread.scheduler;

import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
/* loaded from: classes2.dex */
public class ArteryManager implements Recordable {
    public BaseExecutorCell mUserRelatedArteryExecutor = BaseExecutorCell.build(ElasticConfig.ARTERY_CONFIG_UI_CORE_POOL_SIZE, BaseExecutorCell.ExecutorType.ARTERY);
    public BaseExecutorCell mInTimeArteryExecutor = BaseExecutorCell.build(ElasticConfig.ARTERY_CONFIG_INTIME_CORE_POOL_SIZE, BaseExecutorCell.ExecutorType.ARTERY);
    public BaseExecutorCell mBackgroundArteryExecutor = BaseExecutorCell.build(ElasticConfig.ARTERY_CONFIG_BACKGROUND_CORE_POOL_SIZE, BaseExecutorCell.ExecutorType.ARTERY);

    public boolean execute(ElasticTask elasticTask) {
        int priority = elasticTask.getPriority();
        return (priority == 0 || priority == 1) ? this.mUserRelatedArteryExecutor.execute(elasticTask) || this.mInTimeArteryExecutor.execute(elasticTask) || this.mBackgroundArteryExecutor.execute(elasticTask) : priority == 2 ? this.mInTimeArteryExecutor.execute(elasticTask) || this.mBackgroundArteryExecutor.execute(elasticTask) : priority == 3 && this.mBackgroundArteryExecutor.execute(elasticTask);
    }

    public BaseExecutorCell getBackgroundArteryExecutor() {
        return this.mBackgroundArteryExecutor;
    }

    public BaseExecutorCell getInTimeArteryExecutor() {
        return this.mInTimeArteryExecutor;
    }

    public BaseExecutorCell getUserRelatedArteryExecutor() {
        return this.mUserRelatedArteryExecutor;
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        this.mUserRelatedArteryExecutor.onRecordBegin();
        this.mInTimeArteryExecutor.onRecordBegin();
        this.mBackgroundArteryExecutor.onRecordBegin();
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        this.mUserRelatedArteryExecutor.onRecordEnd();
        this.mInTimeArteryExecutor.onRecordEnd();
        this.mBackgroundArteryExecutor.onRecordEnd();
    }
}
