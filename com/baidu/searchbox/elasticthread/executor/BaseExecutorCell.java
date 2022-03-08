package com.baidu.searchbox.elasticthread.executor;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes4.dex */
public abstract class BaseExecutorCell implements Recordable {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public transient /* synthetic */ FieldHolder $fh;
    public int completedTaskCountInRecordLifeCycle;
    public ThreadPoolExecutor mExecutor;
    public Recordable.RecordStatus mRecordStatus;
    public List<ElasticTask> mWorkingTasks;
    public int maxThreadNum;
    public long recordBeginTime;
    public long recordEndTime;
    public long workTimeInRecordLifeCycle;

    /* renamed from: com.baidu.searchbox.elasticthread.executor.BaseExecutorCell$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$elasticthread$executor$BaseExecutorCell$ExecutorType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1470800757, "Lcom/baidu/searchbox/elasticthread/executor/BaseExecutorCell$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1470800757, "Lcom/baidu/searchbox/elasticthread/executor/BaseExecutorCell$2;");
                    return;
                }
            }
            int[] iArr = new int[ExecutorType.values().length];
            $SwitchMap$com$baidu$searchbox$elasticthread$executor$BaseExecutorCell$ExecutorType = iArr;
            try {
                iArr[ExecutorType.ARTERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$elasticthread$executor$BaseExecutorCell$ExecutorType[ExecutorType.DREDGE_NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$elasticthread$executor$BaseExecutorCell$ExecutorType[ExecutorType.DREDGE_DISASTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$elasticthread$executor$BaseExecutorCell$ExecutorType[ExecutorType.SERIAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class ExecutorType {
        public static final /* synthetic */ ExecutorType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ExecutorType ARTERY;
        public static final ExecutorType DREDGE_DISASTER;
        public static final ExecutorType DREDGE_NORMAL;
        public static final ExecutorType SERIAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(113564258, "Lcom/baidu/searchbox/elasticthread/executor/BaseExecutorCell$ExecutorType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(113564258, "Lcom/baidu/searchbox/elasticthread/executor/BaseExecutorCell$ExecutorType;");
                    return;
                }
            }
            ARTERY = new ExecutorType("ARTERY", 0);
            DREDGE_NORMAL = new ExecutorType("DREDGE_NORMAL", 1);
            DREDGE_DISASTER = new ExecutorType("DREDGE_DISASTER", 2);
            ExecutorType executorType = new ExecutorType("SERIAL", 3);
            SERIAL = executorType;
            $VALUES = new ExecutorType[]{ARTERY, DREDGE_NORMAL, DREDGE_DISASTER, executorType};
        }

        public ExecutorType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ExecutorType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ExecutorType) Enum.valueOf(ExecutorType.class, str) : (ExecutorType) invokeL.objValue;
        }

        public static ExecutorType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ExecutorType[]) $VALUES.clone() : (ExecutorType[]) invokeV.objValue;
        }
    }

    public BaseExecutorCell(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWorkingTasks = new LinkedList();
        this.recordBeginTime = 0L;
        this.recordEndTime = Long.MAX_VALUE;
        this.mRecordStatus = Recordable.RecordStatus.UNINITIATED;
        this.maxThreadNum = i2;
    }

    public static BaseExecutorCell build(int i2, ExecutorType executorType) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, executorType)) == null) {
            int i3 = AnonymousClass2.$SwitchMap$com$baidu$searchbox$elasticthread$executor$BaseExecutorCell$ExecutorType[executorType.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return null;
                        }
                        return new SerialExecutorCell(i2);
                    }
                    return new DredgeDisasterExecutorCell(i2);
                }
                return new DredgeNormalExecutorCell(i2);
            }
            return new ArteryExecutorCell(i2);
        }
        return (BaseExecutorCell) invokeIL.objValue;
    }

    private void setTreadPriorityAndName(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, elasticTask) == null) {
            int priority = elasticTask.getPriority();
            Thread currentThread = Thread.currentThread();
            if (priority == 0) {
                currentThread.setPriority(ElasticConfig.EXECUTOR_CONFIG_THREAD_PRIORITY_IMMEDIATE);
            } else if (priority == 1) {
                currentThread.setPriority(ElasticConfig.EXECUTOR_CONFIG_THREAD_PRIORITY_USER_RELATED);
            } else if (priority == 2) {
                currentThread.setPriority(ElasticConfig.EXECUTOR_CONFIG_THREAD_PRIORITY_INTIME);
            } else if (priority == 3) {
                currentThread.setPriority(ElasticConfig.EXECUTOR_CONFIG_THREAD_PRIORITY_BACKGROUND);
            } else if (priority == 4) {
                currentThread.setPriority(ElasticConfig.EXECUTOR_CONFIG_THREAD_PRIORITY_SERIAL);
            }
            currentThread.setName(elasticTask.getName());
        }
    }

    public abstract boolean available();

    public synchronized boolean execute(ElasticTask elasticTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, elasticTask)) == null) {
            synchronized (this) {
                if (available()) {
                    elasticTask.setElasticTaskCallback(new ElasticTask.ElasticTaskCallback(this, elasticTask) { // from class: com.baidu.searchbox.elasticthread.executor.BaseExecutorCell.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaseExecutorCell this$0;
                        public final /* synthetic */ ElasticTask val$elasticTask;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, elasticTask};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$elasticTask = elasticTask;
                        }

                        @Override // com.baidu.searchbox.elasticthread.task.ElasticTask.ElasticTaskCallback
                        public void afterExecuteTask() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.onTaskEnd(this.val$elasticTask);
                            }
                        }

                        @Override // com.baidu.searchbox.elasticthread.task.ElasticTask.ElasticTaskCallback
                        public void beforeExecuteTask() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                this.this$0.onTaskBegin(this.val$elasticTask);
                            }
                        }
                    });
                    this.mWorkingTasks.add(elasticTask);
                    this.mExecutor.execute(elasticTask);
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized int getCompletedTaskCountInRecordLifeCycle() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                i2 = this.completedTaskCountInRecordLifeCycle;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int getMaxThreadNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.maxThreadNum : invokeV.intValue;
    }

    public abstract String getTag();

    public synchronized long getWorkTimeInRecordLifeCycle() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                j2 = this.workTimeInRecordLifeCycle;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public synchronized int getWorkingThreadNum() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                size = this.mWorkingTasks.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public synchronized void onRecordBegin() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                this.recordBeginTime = SystemClock.elapsedRealtime();
                this.recordEndTime = Long.MAX_VALUE;
                this.workTimeInRecordLifeCycle = 0L;
                this.completedTaskCountInRecordLifeCycle = 0;
                this.mRecordStatus = Recordable.RecordStatus.RECORDING;
            }
        }
    }

    @Override // com.baidu.searchbox.elasticthread.statistic.Recordable
    public synchronized void onRecordEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                this.recordEndTime = SystemClock.elapsedRealtime();
                for (ElasticTask elasticTask : this.mWorkingTasks) {
                    this.workTimeInRecordLifeCycle += elasticTask.getWorkTimeInRecordLifeCycle(this.recordBeginTime, this.recordEndTime);
                }
                this.mRecordStatus = Recordable.RecordStatus.RECORD_END;
            }
        }
    }

    public synchronized void onTaskBegin(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, elasticTask) == null) {
            synchronized (this) {
                elasticTask.recordExecuteTime();
                setTreadPriorityAndName(elasticTask);
            }
        }
    }

    public synchronized void onTaskEnd(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, elasticTask) == null) {
            synchronized (this) {
                elasticTask.recordCompleteTime();
                this.mWorkingTasks.remove(elasticTask);
                if (this.mRecordStatus == Recordable.RecordStatus.RECORDING) {
                    this.workTimeInRecordLifeCycle += elasticTask.getWorkTimeInRecordLifeCycle(this.recordBeginTime, this.recordEndTime);
                    this.completedTaskCountInRecordLifeCycle++;
                }
            }
        }
    }
}
