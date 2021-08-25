package com.baidu.searchbox.taskmanager;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.a.b;
import c.a.e.c.f.k;
import c.a.p0.h0.h;
import c.a.p0.s.l.a;
import c.a.p0.w.d;
import c.a.r.f.a.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.StartupCountStatsController;
import com.baidu.searchbox.aop.annotation.TimeSpendTrace;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.stats.AppCreateSpeedStats;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.performance.speed.task.LaunchTaskSchedule;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.speed.box.speedtask.LaunchTaskExecutor;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.RegisterIntentConfigHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
/* loaded from: classes5.dex */
public class AsyncLaunchTaskManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final long DIVIDER = 1048576;
    public static final String KEY_MEMO_TIME = "memory_save_time";
    public static final String TAG = "AsyncLaunchTaskManager";
    public static boolean isColdStart;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-410287647, "Lcom/baidu/searchbox/taskmanager/AsyncLaunchTaskManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-410287647, "Lcom/baidu/searchbox/taskmanager/AsyncLaunchTaskManager;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        isColdStart = true;
    }

    public AsyncLaunchTaskManager() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkInterrupt(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j2)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 5, 7, 19, 20, 0);
            long timeInMillis = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 5, 7, 21, 0, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 5, 15, 20, 10, 0);
            long timeInMillis3 = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 5, 15, 21, 50, 0);
            long timeInMillis4 = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 4, 27, 20, 0, 0);
            long timeInMillis5 = calendar.getTimeInMillis();
            calendar.set(SpeedStatsStampTable.INIT_GO_ACTION_STAMP_KEY, 4, 27, 20, 30, 0);
            return (timeInMillis <= j2 && j2 <= timeInMillis2) || (timeInMillis3 <= j2 && j2 <= timeInMillis4) || (timeInMillis5 <= j2 && j2 <= calendar.getTimeInMillis());
        }
        return invokeJ.booleanValue;
    }

    public static void initAR(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            b.t(BdUploadHandler.MEDIA_SOURCE_KEY);
            b.k(context);
            b.r(true);
            b.w(false);
            d.a();
        }
    }

    private void initAccount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            LaunchTaskExecutor.execute(new Runnable(this) { // from class: com.baidu.searchbox.taskmanager.AsyncLaunchTaskManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AsyncLaunchTaskManager this$0;

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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c.a.p0.s.l.b.s().A();
                        a.c();
                        c.a.p0.s.l.b.s().z();
                    }
                }
            }, AppCreateSpeedStats.INIT_ACCOUNT);
        }
    }

    private void initDimen(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context) == null) {
            TbDimenManager.getInstance().init((Application) context.getApplicationContext());
        }
    }

    private void initInterruptRule() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            MessageManager.getInstance().addMessageRule(new c.a.e.c.f.d(this, 0) { // from class: com.baidu.searchbox.taskmanager.AsyncLaunchTaskManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AsyncLaunchTaskManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // c.a.e.c.f.f
                public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, httpMessage, httpMessageTask)) == null) {
                        if (this.this$0.checkInterrupt(System.currentTimeMillis()) && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(httpMessage.getCmd()))) {
                            return null;
                        }
                        return httpMessage;
                    }
                    return (HttpMessage) invokeLL.objValue;
                }
            });
            MessageManager.getInstance().addMessageRule(new k(this, 0) { // from class: com.baidu.searchbox.taskmanager.AsyncLaunchTaskManager.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AsyncLaunchTaskManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // c.a.e.c.f.f
                public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketMessage, socketMessageTask)) == null) {
                        if (this.this$0.checkInterrupt(System.currentTimeMillis()) && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(socketMessage.getCmd()))) {
                            return null;
                        }
                        return socketMessage;
                    }
                    return (SocketMessage) invokeLL.objValue;
                }
            });
        }
    }

    private void initMutiProcessManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, context) == null) {
            LaunchTaskExecutor.execute(new Runnable(this, context) { // from class: com.baidu.searchbox.taskmanager.AsyncLaunchTaskManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AsyncLaunchTaskManager this$0;
                public final /* synthetic */ Context val$appContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
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
                    this.val$appContext = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        h.f().g((Application) this.val$appContext);
                    }
                }
            }, "initMutiProcessManager");
        }
    }

    private void registerGoActionTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            LaunchTaskExecutor.execute(new Runnable(this) { // from class: com.baidu.searchbox.taskmanager.AsyncLaunchTaskManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AsyncLaunchTaskManager this$0;

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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        CustomMessageTask customMessageTask = new CustomMessageTask(2002001, new CustomMessageTask.CustomRunnable<IntentConfig>(this) { // from class: com.baidu.searchbox.taskmanager.AsyncLaunchTaskManager.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass4 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                            public CustomResponsedMessage<IntentConfig> run(CustomMessage<IntentConfig> customMessage) {
                                InterceptResult invokeL;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || (invokeL = interceptable3.invokeL(1048576, this, customMessage)) == null) {
                                    if (customMessage == null || customMessage.getData() == null) {
                                        return null;
                                    }
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921565, Boolean.TRUE));
                                    IntentConfig data = customMessage.getData();
                                    if (data.asynStart()) {
                                        return new CustomResponsedMessage<>(customMessage.getCmd(), data);
                                    }
                                    Class<?> intentClass = this.this$1.this$0.getIntentClass(data.getClass());
                                    if (this.this$1.this$0.getIntentClass(AlbumActivityConfig.class) == null) {
                                        TiebaStatic.log(new StatisticItem("inter_config_disappear").param("obj_param1", RegisterIntentConfigHelper.getInst().getConfigSize()));
                                    } else if ((data instanceof LoginActivityConfig) && !LoginActivityConfig.canStartActivity()) {
                                        return null;
                                    }
                                    if (intentClass != null) {
                                        data.setComponentClass(intentClass);
                                        data.run();
                                    }
                                    return new CustomResponsedMessage<>(customMessage.getCmd(), data);
                                }
                                return (CustomResponsedMessage) invokeL.objValue;
                            }
                        });
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                        MessageManager.getInstance().registerTask(customMessageTask);
                    }
                }
            }, "registerGoActionTask");
        }
    }

    private void setWebViewDataDirectorySuffix() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("setDataDirectorySuffix", String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, ProcessUtils.getCurProcessName());
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public void InitVersion(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            ApplicationInfo applicationInfo = null;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                TbConfig.setVersionType(c.a.e.e.m.b.d(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
            } catch (Exception e2) {
                TbConfig.setVersionType(3);
                BdLog.e(e2.getMessage());
            }
            try {
                if (TbConfig.getVersionType() == 2) {
                    TbConfig.setVersion(String.valueOf(applicationInfo.metaData.get("grayVersion")));
                    return;
                }
                TbConfig.setVersion(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
                if (TbConfig.getVersionType() == 1) {
                    TbConfig.setSubVersion(String.valueOf(applicationInfo.metaData.get("subVersion")));
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
        }
    }

    public Class<?> getIntentClass(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? RegisterIntentConfigHelper.getInst().getIntentClass(cls) : (Class) invokeL.objValue;
    }

    public void initAxeSdk(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) && PermissionUtil.isAgreePrivacyPolicy()) {
            b.C1377b.c(context.getApplicationContext()).b().t();
        }
    }

    @TimeSpendTrace
    public void scheduleDelayTask(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            System.currentTimeMillis();
            Context applicationContext = context.getApplicationContext();
            LaunchTaskExecutor.appReady(false);
            LaunchTaskSchedule.getInstance().start(3);
            initAccount();
            initMutiProcessManager(applicationContext);
            initDimen(context);
            context.getSharedPreferences("adp_feature_switch", 0);
            setWebViewDataDirectorySuffix();
            InitVersion(context);
            TbFaceManager.e().i(TbadkCoreApplication.getInst(), new c.a.p0.x.p.b());
            registerGoActionTask();
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                MessageManager.getInstance().runTask(2921328, null, context);
            }
            initInterruptRule();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921512));
            StartupCountStatsController.init();
            initAxeSdk(context);
            initAR(context);
            UiThreadUtil.runOnUiThread(new Runnable(this) { // from class: com.baidu.searchbox.taskmanager.AsyncLaunchTaskManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AsyncLaunchTaskManager this$0;

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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LaunchTaskExecutor.appReady(true);
                    }
                }
            }, 3000L);
        }
    }
}
