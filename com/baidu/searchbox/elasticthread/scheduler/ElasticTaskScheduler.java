package com.baidu.searchbox.elasticthread.scheduler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ElasticConfig;
import com.baidu.searchbox.elasticthread.queue.QueueManager;
import com.baidu.searchbox.elasticthread.statistic.RealTimeStatusPrinter;
import com.baidu.searchbox.elasticthread.statistic.Recordable;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.searchbox.elasticthread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ElasticTaskScheduler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int MSG_DREDGE_CONCURRENT = 3;
    public static final int MSG_INSERT_CONCURRENT_TASK = 1;
    public static final int MSG_INSERT_SERIAL_TASK = 4;
    public static final int MSG_REAL_TIME_STATUS_PRINT = 9;
    public static final int MSG_RECORD_DATA_BEGIN = 7;
    public static final int MSG_RECORD_DATA_END = 8;
    public static final int MSG_SCHEDULE_CONCURRENT = 2;
    public static final int MSG_SCHEDULE_SERIAL = 5;
    public static final int MSG_SERIAL_DREDGE = 6;
    public static final String TAG = "ElasticTaskScheduler";
    public static volatile ElasticTaskScheduler sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public ArteryManager mArteryManager;
    public DredgeManager mDredgeManager;
    public QueueManager mQueueManager;
    public Handler mSchedulerHandler;
    public HandlerThread mSchedulerThread;
    public SerialManager mSerialManager;
    public StatisticRecorder mStatisticRecorder;

    /* loaded from: classes10.dex */
    public static class TaskMsgInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int priority;
        public Runnable runnable;
        public String taskName;

        public TaskMsgInfo(Runnable runnable, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.runnable = runnable;
            this.taskName = str;
            this.priority = i2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-136498084, "Lcom/baidu/searchbox/elasticthread/scheduler/ElasticTaskScheduler;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-136498084, "Lcom/baidu/searchbox/elasticthread/scheduler/ElasticTaskScheduler;");
        }
    }

    public ElasticTaskScheduler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        synchronized (ElasticConfig.getElasticConfigMutex()) {
            initElasticThread();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginRecord() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || ElasticConfig.elasticExecutorDisabled()) {
            return;
        }
        this.mStatisticRecorder.getRecordStatus();
        Recordable.RecordStatus recordStatus = Recordable.RecordStatus.RECORDING;
        this.mStatisticRecorder.onRecordBegin();
        this.mArteryManager.onRecordBegin();
        this.mDredgeManager.onRecordBegin();
        this.mQueueManager.onRecordBegin();
        this.mSerialManager.onRecordBegin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endRecord() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && !ElasticConfig.elasticExecutorDisabled() && this.mStatisticRecorder.getRecordStatus() == Recordable.RecordStatus.RECORDING) {
            this.mStatisticRecorder.onRecordEnd();
            this.mArteryManager.onRecordEnd();
            this.mDredgeManager.onRecordEnd();
            this.mQueueManager.onRecordEnd();
            this.mSerialManager.onRecordEnd();
            if (this.mStatisticRecorder.getRecordElapseTime() > 30000) {
                this.mStatisticRecorder.uploadData();
            }
        }
    }

    public static ElasticTaskScheduler getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (sInstance == null) {
                synchronized (ElasticTaskScheduler.class) {
                    if (sInstance == null) {
                        sInstance = new ElasticTaskScheduler();
                    }
                }
            }
            return sInstance;
        }
        return (ElasticTaskScheduler) invokeV.objValue;
    }

    private void initElasticThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            ElasticConfig.updateConfig();
            ElasticConfig.setElasticThreadInitiated(true);
            this.mArteryManager = new ArteryManager();
            this.mDredgeManager = new DredgeManager();
            this.mQueueManager = new QueueManager();
            this.mSerialManager = new SerialManager();
            this.mStatisticRecorder = new StatisticRecorder();
            HandlerThread handlerThread = new HandlerThread("ElasticSchedulerThread");
            this.mSchedulerThread = handlerThread;
            handlerThread.start();
            this.mSchedulerHandler = new Handler(this, this.mSchedulerThread.getLooper()) { // from class: com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ElasticTaskScheduler this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        super.handleMessage(message);
                        switch (message.what) {
                            case 1:
                                Object obj = message.obj;
                                if (obj instanceof TaskMsgInfo) {
                                    TaskMsgInfo taskMsgInfo = (TaskMsgInfo) obj;
                                    this.this$0.mQueueManager.insertTask(taskMsgInfo.runnable, taskMsgInfo.taskName, taskMsgInfo.priority);
                                }
                                this.this$0.scheduleConcurrentTasks();
                                return;
                            case 2:
                                this.this$0.scheduleConcurrentTasks();
                                return;
                            case 3:
                                if (this.this$0.mDredgeManager.adjustDredgeStrategy() > 0) {
                                    this.this$0.scheduleConcurrentTasks();
                                    return;
                                }
                                return;
                            case 4:
                                Object obj2 = message.obj;
                                if (obj2 instanceof TaskMsgInfo) {
                                    TaskMsgInfo taskMsgInfo2 = (TaskMsgInfo) obj2;
                                    this.this$0.mSerialManager.insertTask(taskMsgInfo2.runnable, taskMsgInfo2.taskName, taskMsgInfo2.priority);
                                    this.this$0.scheduleNextSerialTask();
                                    return;
                                }
                                return;
                            case 5:
                                this.this$0.scheduleNextSerialTask();
                                return;
                            case 6:
                                this.this$0.mSerialManager.checkBlockAndDredge();
                                return;
                            case 7:
                                this.this$0.beginRecord();
                                return;
                            case 8:
                                this.this$0.endRecord();
                                return;
                            case 9:
                                RealTimeStatusPrinter.getInstance().printRealTimeData();
                                this.this$0.postPrintRealTimeData(ElasticConfig.REAL_TIME_PRINTER_INTERVAL);
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
            postPrintRealTimeData(ElasticConfig.REAL_TIME_PRINTER_INTERVAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postPrintRealTimeData(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65550, this, j2) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int scheduleConcurrentTasks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            int i2 = 0;
            while (scheduleNextConcurrentTask()) {
                i2++;
            }
            postConcurrentDredge();
            return i2;
        }
        return invokeV.intValue;
    }

    private boolean scheduleNextConcurrentTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            ElasticTask next = this.mQueueManager.getNext();
            if (next == null) {
                return false;
            }
            if (this.mArteryManager.execute(next)) {
                this.mQueueManager.removeTask(next);
                return true;
            } else if (this.mDredgeManager.execute(next)) {
                this.mQueueManager.removeTask(next);
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean scheduleNextSerialTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) ? this.mSerialManager.scheduleNextTask() : invokeV.booleanValue;
    }

    public ArteryManager getArteryManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mArteryManager : (ArteryManager) invokeV.objValue;
    }

    public DredgeManager getDredgeManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDredgeManager : (DredgeManager) invokeV.objValue;
    }

    public QueueManager getQueueManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mQueueManager : (QueueManager) invokeV.objValue;
    }

    public SerialManager getSerialManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mSerialManager : (SerialManager) invokeV.objValue;
    }

    public void postBeginRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Message obtain = Message.obtain();
            obtain.what = 7;
            this.mSchedulerHandler.sendMessage(obtain);
        }
    }

    public void postConcurrentDredge() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            postConcurrentDredgeDelay(0L);
        }
    }

    public void postConcurrentDredgeDelay(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            this.mSchedulerHandler.sendMessageDelayed(obtain, j2);
        }
    }

    public void postConcurrentSchedule() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            postConcurrentScheduleDelay(0L);
        }
    }

    public void postConcurrentScheduleDelay(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            this.mSchedulerHandler.sendMessageDelayed(obtain, j2);
        }
    }

    public void postConcurrentTask(Runnable runnable, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048585, this, runnable, str, i2) == null) {
            postConcurrentTaskDelay(runnable, str, i2, 0L);
        }
    }

    public void postConcurrentTaskDelay(Runnable runnable, String str, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{runnable, str, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = new TaskMsgInfo(runnable, str, i2);
            this.mSchedulerHandler.sendMessageDelayed(obtain, j2);
        }
    }

    public void postEndRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Message obtain = Message.obtain();
            obtain.what = 8;
            this.mSchedulerHandler.sendMessage(obtain);
        }
    }

    public void postSerialDredge() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            postSerialDredgeDelay(0L);
        }
    }

    public void postSerialDredgeDelay(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            Message obtain = Message.obtain();
            obtain.what = 6;
            this.mSchedulerHandler.sendMessageDelayed(obtain, j2);
        }
    }

    public void postSerialSchedule() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            postSerialScheduleDelay(0L);
        }
    }

    public void postSerialScheduleDelay(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            this.mSchedulerHandler.sendMessageDelayed(obtain, j2);
        }
    }

    public void postSerialTask(Runnable runnable, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048592, this, runnable, str, i2) == null) {
            postSerialTaskDelay(runnable, str, i2, 0L);
        }
    }

    public void postSerialTaskDelay(Runnable runnable, String str, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{runnable, str, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = new TaskMsgInfo(runnable, str, i2);
            this.mSchedulerHandler.sendMessageDelayed(obtain, j2);
        }
    }
}
