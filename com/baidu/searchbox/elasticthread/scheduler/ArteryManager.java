package com.baidu.searchbox.elasticthread.scheduler;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.executor.BaseExecutorCell;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ArteryManager implements Recordable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseExecutorCell mBackgroundArteryExecutor;
    public BaseExecutorCell mInTimeArteryExecutor;
    public BaseExecutorCell mUserRelatedArteryExecutor;

    public ArteryManager() {
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
        this.mUserRelatedArteryExecutor = BaseExecutorCell.build(ElasticConfig.ARTERY_CONFIG_UI_CORE_POOL_SIZE, BaseExecutorCell.ExecutorType.ARTERY);
        this.mInTimeArteryExecutor = BaseExecutorCell.build(ElasticConfig.ARTERY_CONFIG_INTIME_CORE_POOL_SIZE, BaseExecutorCell.ExecutorType.ARTERY);
        this.mBackgroundArteryExecutor = BaseExecutorCell.build(ElasticConfig.ARTERY_CONFIG_BACKGROUND_CORE_POOL_SIZE, BaseExecutorCell.ExecutorType.ARTERY);
    }

    public boolean execute(ElasticTask elasticTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, elasticTask)) == null) {
            int priority = elasticTask.getPriority();
            return (priority == 0 || priority == 1) ? this.mUserRelatedArteryExecutor.execute(elasticTask) || this.mInTimeArteryExecutor.execute(elasticTask) || this.mBackgroundArteryExecutor.execute(elasticTask) : priority == 2 ? this.mInTimeArteryExecutor.execute(elasticTask) || this.mBackgroundArteryExecutor.execute(elasticTask) : priority == 3 && this.mBackgroundArteryExecutor.execute(elasticTask);
        }
        return invokeL.booleanValue;
    }

    public BaseExecutorCell getBackgroundArteryExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBackgroundArteryExecutor : (BaseExecutorCell) invokeV.objValue;
    }

    public BaseExecutorCell getInTimeArteryExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mInTimeArteryExecutor : (BaseExecutorCell) invokeV.objValue;
    }

    public BaseExecutorCell getUserRelatedArteryExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mUserRelatedArteryExecutor : (BaseExecutorCell) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mUserRelatedArteryExecutor.onRecordBegin();
            this.mInTimeArteryExecutor.onRecordBegin();
            this.mBackgroundArteryExecutor.onRecordBegin();
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mUserRelatedArteryExecutor.onRecordEnd();
            this.mInTimeArteryExecutor.onRecordEnd();
            this.mBackgroundArteryExecutor.onRecordEnd();
        }
    }
}
