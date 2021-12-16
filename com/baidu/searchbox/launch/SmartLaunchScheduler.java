package com.baidu.searchbox.launch;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class SmartLaunchScheduler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ADJUST_SCHEDULE_TAG = "adjustSchedule";
    public static final boolean DEBUG;
    public static final int DEFAULT_RECOVERY_SCHEDULE_DELAY_TIME = 30000;
    public static String TAG = "SmartLaunchManager";
    public static SmartLaunchScheduler instance;
    public static String mInterruptedAndAdjustedStrategyBusiness;
    public static String mInterruptingBusiness;
    public static boolean mIsScheduleEnd;
    public static boolean mIsScheduleInterrupted;
    public static boolean sIsAllowSchedule;
    public static boolean sIsIdleScheduling;
    public static ScheduleStrategy strategy;
    public transient /* synthetic */ FieldHolder $fh;
    public int idleDelayTaskCount;
    public int idleTaskCount;
    public LinkedList<SmartLaunchTask> mIdleQueue;
    public Handler mMainHandler;
    public List<SmartLaunchTask> mRegisterTaskList;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1399526746, "Lcom/baidu/searchbox/launch/SmartLaunchScheduler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1399526746, "Lcom/baidu/searchbox/launch/SmartLaunchScheduler;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        strategy = null;
        mIsScheduleInterrupted = false;
        mInterruptingBusiness = null;
        mInterruptedAndAdjustedStrategyBusiness = null;
        mIsScheduleEnd = false;
        sIsIdleScheduling = false;
        sIsAllowSchedule = false;
    }

    public SmartLaunchScheduler() {
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
        this.mIdleQueue = new LinkedList<>();
        this.mRegisterTaskList = new ArrayList();
        this.mMainHandler = null;
        this.idleTaskCount = 0;
        this.idleDelayTaskCount = 0;
        init();
    }

    public static SmartLaunchScheduler getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (instance == null) {
                instance = new SmartLaunchScheduler();
                strategy = new ScheduleStrategy();
            }
            return instance;
        }
        return (SmartLaunchScheduler) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getMainHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            Handler handler = this.mMainHandler;
            if (handler != null) {
                return handler;
            }
            Handler handler2 = new Handler(Looper.getMainLooper());
            this.mMainHandler = handler2;
            return handler2;
        }
        return (Handler) invokeV.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            BdEventBus.Companion.getDefault().unregister(ADJUST_SCHEDULE_TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedule(SmartLaunchTask smartLaunchTask, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65554, this, smartLaunchTask, i2) == null) || smartLaunchTask == null || smartLaunchTask.isExecuted()) {
            return;
        }
        if (i2 == 1) {
            this.mIdleQueue.add(0, smartLaunchTask);
        }
        List<SmartLaunchTask> dependency = smartLaunchTask.getDependency();
        if (dependency != null && dependency.size() > 0) {
            for (int i3 = 0; i3 < dependency.size(); i3++) {
                SmartLaunchTask smartLaunchTask2 = dependency.get(i3);
                smartLaunchTask2.setScore(smartLaunchTask.getScore());
                schedule(smartLaunchTask2, i2);
            }
        }
        if (i2 == 0) {
            if (!smartLaunchTask.isExecuted()) {
                smartLaunchTask.run();
            }
            if (DEBUG) {
                String str = "task execute : " + smartLaunchTask.getId();
            }
        } else if (i2 == 1) {
            smartLaunchTask.removeAllDependency();
        }
        if (this.mRegisterTaskList.contains(smartLaunchTask)) {
            return;
        }
        this.mRegisterTaskList.add(smartLaunchTask);
    }

    public List<SmartLaunchTask> getRegisteredPersonalLaunchTasks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRegisterTaskList : (List) invokeV.objValue;
    }

    public boolean isScheduleEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? mIsScheduleEnd : invokeV.booleanValue;
    }

    public boolean isScheduleInterrupted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? mIsScheduleInterrupted : invokeV.booleanValue;
    }

    public void register(SmartLaunchTask smartLaunchTask) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, smartLaunchTask) == null) || smartLaunchTask == null) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            getMainHandler().post(new Runnable(this, smartLaunchTask) { // from class: com.baidu.searchbox.launch.SmartLaunchScheduler.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SmartLaunchScheduler this$0;
                public final /* synthetic */ SmartLaunchTask val$task;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, smartLaunchTask};
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
                    this.val$task = smartLaunchTask;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.register(this.val$task);
                    }
                }
            });
        } else if (smartLaunchTask.isMainThreadIdleTask()) {
            if (DEBUG) {
                String str = "add " + smartLaunchTask.getId() + " task to idle task queue";
            }
            this.mIdleQueue.add(smartLaunchTask);
            this.idleTaskCount++;
            if (sIsIdleScheduling || !sIsAllowSchedule) {
                return;
            }
            scheduleIdleTask();
        } else {
            int scheduleStrategy = strategy.getScheduleStrategy(smartLaunchTask);
            if (scheduleStrategy == 0) {
                if (DEBUG) {
                    String str2 = "add " + smartLaunchTask.getId() + " task to fast task queue";
                }
                schedule(smartLaunchTask, 0);
            } else if (scheduleStrategy == 1) {
                if (DEBUG) {
                    String str3 = "add " + smartLaunchTask.getId() + " task to idle task queue";
                }
                this.mIdleQueue.add(smartLaunchTask);
                this.idleTaskCount++;
                if (!sIsIdleScheduling && sIsAllowSchedule) {
                    scheduleIdleTask();
                }
            } else if (DEBUG) {
                String str4 = "do not support strategy: " + scheduleStrategy;
                return;
            } else {
                return;
            }
            if (this.mRegisterTaskList.contains(smartLaunchTask)) {
                return;
            }
            this.mRegisterTaskList.add(smartLaunchTask);
        }
    }

    public void scheduleIdleTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && Looper.getMainLooper() == Looper.myLooper()) {
            sIsAllowSchedule = true;
            if (this.mIdleQueue.size() > 0) {
                Collections.sort(this.mIdleQueue);
                boolean z = DEBUG;
                sIsIdleScheduling = true;
                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler(this) { // from class: com.baidu.searchbox.launch.SmartLaunchScheduler.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SmartLaunchScheduler this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            if (SmartLaunchScheduler.DEBUG) {
                                String unused = SmartLaunchScheduler.TAG;
                            }
                            SmartLaunchTask smartLaunchTask = (SmartLaunchTask) this.this$0.mIdleQueue.poll();
                            if (SmartLaunchStats.getIdleTaskStartTime() == -1) {
                                SmartLaunchStats.setIdleTaskStartTime(System.currentTimeMillis());
                            }
                            if (smartLaunchTask != null) {
                                if (!smartLaunchTask.isExecuted()) {
                                    Handler mainHandler = this.this$0.getMainHandler();
                                    if (mainHandler != null) {
                                        mainHandler.removeCallbacks(smartLaunchTask);
                                        if (smartLaunchTask.getDependency() != null && smartLaunchTask.getDependency().size() > 0) {
                                            this.this$0.schedule(smartLaunchTask, 1);
                                            mainHandler.post((Runnable) this.this$0.mIdleQueue.poll());
                                        } else {
                                            mainHandler.post(smartLaunchTask);
                                        }
                                        return !SmartLaunchScheduler.mIsScheduleInterrupted;
                                    }
                                } else {
                                    this.this$0.idleDelayTaskCount++;
                                    return !SmartLaunchScheduler.mIsScheduleInterrupted;
                                }
                            }
                            SmartLaunchStats.setIdleTaskEndTime(System.currentTimeMillis());
                            boolean unused2 = SmartLaunchScheduler.mIsScheduleEnd = true;
                            boolean unused3 = SmartLaunchScheduler.sIsIdleScheduling = false;
                            this.this$0.mRegisterTaskList.clear();
                            if (SmartLaunchScheduler.DEBUG) {
                                String unused4 = SmartLaunchScheduler.TAG;
                            }
                            this.this$0.release();
                            return false;
                        }
                        return invokeV.booleanValue;
                    }
                });
                return;
            }
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler(this) { // from class: com.baidu.searchbox.launch.SmartLaunchScheduler.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SmartLaunchScheduler this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        if (SmartLaunchStats.getIdleTaskStartTime() == -1) {
                            SmartLaunchStats.setIdleTaskStartTime(System.currentTimeMillis());
                        }
                        SmartLaunchStats.setIdleTaskEndTime(System.currentTimeMillis());
                        return false;
                    }
                    return invokeV.booleanValue;
                }
            });
        }
    }
}
