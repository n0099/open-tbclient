package com.baidu.searchbox.task.sync.appcreate;

import androidx.lifecycle.ProcessLifecycleOwner;
import c.a.q0.c1.k0;
import c.a.q0.c1.n0;
import c.a.q0.r.k;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.growthFunnel.GrowthAppLifecycleObserver;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.InputMethodManagerLeaksFixer;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.ForeBackLifecycleMonitorUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class InitLaunchSyncTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InitLaunchSyncTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void cleanDirectoryNewStatIfNeed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && TbadkCoreApplication.getInst().isMainProcess(true) && TbadkCoreApplication.getInst().getIsFirstUse()) {
            n0.b(new k0<Object>(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitLaunchSyncTask.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitLaunchSyncTask this$0;

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

                @Override // c.a.q0.c1.k0
                public Object doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        if ("12.1.0.1".equals(FileHelper.DataDir.getLatestVersion())) {
                            FileHelper.DataDir.cleanDirectory("/newStat");
                            return null;
                        }
                        return null;
                    }
                    return invokeV.objValue;
                }
            }, null);
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                ProcessLifecycleOwner.get().getLifecycle().addObserver(new GrowthAppLifecycleObserver());
                ProcessLifecycleOwner.get().getLifecycle().addObserver(new ForeBackLifecycleMonitorUtil());
                if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                    SwitchManager.getInstance().clear();
                    if (!TbadkCoreApplication.getInst().getCapabilityOfWebp()) {
                        TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "LocalWebpUnSupport", "");
                    }
                }
            } else {
                TbadkCoreApplication.getInst().mRemoteActivity = new ArrayList<>();
            }
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                TbadkCoreApplication.getInst().sendMessageForEnterBackground();
            }
            NetMessage.setGlobalSwitchToHttpStrategy(new NetMessage.a(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitLaunchSyncTask.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitLaunchSyncTask this$0;

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

                @Override // com.baidu.adp.framework.message.NetMessage.a
                public boolean checkToSwitchHttp(SocketResponsedMessage socketResponsedMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, socketResponsedMessage)) == null) {
                        if (socketResponsedMessage != null) {
                            return socketResponsedMessage.getError() == 110004 || socketResponsedMessage.getError() == 110005;
                        }
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
            k kVar = new k();
            TbadkCoreApplication.getInst().setCoreActivityLifecycleCallbacks(kVar);
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(kVar);
            InputMethodManagerLeaksFixer.fixFocusedViewLeak(TbadkCoreApplication.getInst());
            cleanDirectoryNewStatIfNeed();
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "AppCreate_InitLaunchSync" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }
}
