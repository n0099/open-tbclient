package com.baidu.searchbox.taskmanager;

import android.content.Context;
import b.a.e.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.IdleLaunchTask;
import com.baidu.searchbox.launch.SmartLaunchScheduler;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.task.item.InitMainTabTask;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class IdleLaunchTaskManager implements a.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "IdleLaunchTaskManager";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1776558363, "Lcom/baidu/searchbox/taskmanager/IdleLaunchTaskManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1776558363, "Lcom/baidu/searchbox/taskmanager/IdleLaunchTaskManager;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public IdleLaunchTaskManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void addSmartLaunchStatsTask() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || SpeedStats.getInstance().isHotLaunch()) {
            return;
        }
        registerIdleTask(new IdleLaunchTask(this, "smartLaunchStats") { // from class: com.baidu.searchbox.taskmanager.IdleLaunchTaskManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ IdleLaunchTaskManager this$0;

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
                        super((String) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.searchbox.launch.SmartLaunchTask
            public void execute() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    TiebaStatic.log(new StatisticItem("app_idle").param("obj_type", System.currentTimeMillis() - SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp()));
                    new SmartLaunchStats().stats();
                    new TTIStats().stats();
                    new InitMainTabTask().execute();
                }
            }
        });
    }

    public static void registerIdleTask(IdleLaunchTask idleLaunchTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, idleLaunchTask) == null) {
            SmartLaunchScheduler.getInstance().register(idleLaunchTask);
        }
    }

    public void addIdleLaunchTask(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            addSmartLaunchStatsTask();
        }
    }

    @Override // b.a.e.e.a.b
    public void scheduleIdleTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SmartLaunchScheduler.getInstance().scheduleIdleTask();
        }
    }

    @Override // b.a.e.e.a.b
    public void registerIdleTask(String str, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, runnable) == null) {
            registerIdleTask(new IdleLaunchTask(this, str, runnable) { // from class: com.baidu.searchbox.taskmanager.IdleLaunchTaskManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ IdleLaunchTaskManager this$0;
                public final /* synthetic */ Runnable val$task;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(str);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, runnable};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$task = runnable;
                }

                @Override // com.baidu.searchbox.launch.SmartLaunchTask
                public void execute() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$task.run();
                    }
                }
            });
        }
    }
}
