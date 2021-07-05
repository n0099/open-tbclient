package com.baidu.searchbox.elasticthread.executor;

import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public abstract class BaseDredgeExecutorCell extends BaseExecutorCell {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long KEEP_ALIVE_TIME_OPEN = 5000;
    public static final long KEEP_ALIVE_TIME_SHUTDOWN = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isOpen;
    public long lastOpenTime;
    public long lastShutdownTime;
    public int openCountInRecordLifeCycle;
    public long openTimeInRecordLifeCycle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDredgeExecutorCell(int i2) {
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
        this.lastOpenTime = 0L;
        this.lastShutdownTime = 0L;
        this.isOpen = false;
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public boolean available() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isOpen && getWorkingThreadNum() < this.maxThreadNum : invokeV.booleanValue;
    }

    public int getOpenCountInRecordLifeCycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.openCountInRecordLifeCycle : invokeV.intValue;
    }

    public long getOpenTimeInRecordLifeCycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.openTimeInRecordLifeCycle : invokeV.longValue;
    }

    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isOpen : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell, com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordBegin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onRecordBegin();
            this.openCountInRecordLifeCycle = 0;
            this.openTimeInRecordLifeCycle = 0L;
            if (this.isOpen) {
                this.openTimeInRecordLifeCycle = 0 + 1;
            }
        }
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell, com.baidu.searchbox.elasticthread.statistic.Recordable
    public void onRecordEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onRecordEnd();
            if (this.isOpen) {
                this.openTimeInRecordLifeCycle += SystemClock.elapsedRealtime() - Math.max(this.recordBeginTime, this.lastOpenTime);
            }
        }
    }

    @Override // com.baidu.searchbox.elasticthread.executor.BaseExecutorCell
    public void onTaskEnd(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, elasticTask) == null) {
            super.onTaskEnd(elasticTask);
            if (this.isOpen) {
                ElasticTaskScheduler.getInstance().postConcurrentSchedule();
            }
        }
    }

    public void open() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.isOpen) {
                Log.w(getTag(), "This executor cell is already opened.");
                return;
            }
            this.isOpen = true;
            this.lastOpenTime = SystemClock.elapsedRealtime();
            if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
                this.openCountInRecordLifeCycle++;
            }
            this.mExecutor.setKeepAliveTime(5000L, TimeUnit.MILLISECONDS);
        }
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!this.isOpen) {
                Log.w(getTag(), "This executor cell is already shutdown.");
                return;
            }
            this.isOpen = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.lastShutdownTime = elapsedRealtime;
            if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
                this.openTimeInRecordLifeCycle += elapsedRealtime - Math.max(this.recordBeginTime, this.lastOpenTime);
            }
            this.mExecutor.setKeepAliveTime(100L, TimeUnit.MILLISECONDS);
        }
    }
}
