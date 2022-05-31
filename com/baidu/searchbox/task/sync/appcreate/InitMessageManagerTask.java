package com.baidu.searchbox.task.sync.appcreate;

import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.RegisterIntentConfigHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UpgradePopWindowHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bo8;
import com.repackage.ec5;
import com.repackage.gk4;
import com.repackage.k85;
import com.repackage.l85;
import com.repackage.m85;
import com.repackage.n85;
import com.repackage.no4;
import com.repackage.o85;
import com.repackage.oa;
import com.repackage.oq6;
import com.repackage.p85;
import com.repackage.pq6;
import com.repackage.uh8;
import com.repackage.v85;
import com.repackage.va;
import com.repackage.x8;
/* loaded from: classes2.dex */
public class InitMessageManagerTask extends LaunchTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener mDescriptionTableFixListener;
    public CustomMessageListener mMemListener;

    public InitMessageManagerTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDescriptionTableFixListener = new CustomMessageListener(this, 2921510) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ InitMessageManagerTask this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof uh8)) {
                    uh8 uh8Var = (uh8) customResponsedMessage.getData();
                    DescriptionTableInfo.setModuleSet(uh8Var.a);
                    DescriptionTableInfo.setDescriptionTable(uh8Var.b);
                }
            }
        };
        this.mMemListener = new CustomMessageListener(this, 2001194) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ InitMessageManagerTask this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Integer num;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null) {
                    return;
                }
                TbadkCoreApplication.setCurrentMemberType(num.intValue());
                if (num.intValue() != 0) {
                    TbadkSettings inst = TbadkSettings.getInst();
                    inst.saveBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), true);
                    return;
                }
                TbadkSettings inst2 = TbadkSettings.getInst();
                inst2.saveBoolean(TbadkCoreApplication.isMem + TbadkCoreApplication.getCurrentAccount(), false);
            }
        };
    }

    private void addLoginRules() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            ReloginManager.g().k();
            MessageManager messageManager = MessageManager.getInstance();
            messageManager.addMessageRule(new p85(0));
            messageManager.addMessageRule(new m85(0));
            messageManager.addResponsedMessageRule(new o85(0));
            messageManager.addRemovedMessageRule(new n85(0));
            messageManager.addResponsedMessageRule(new pq6());
            messageManager.addResponsedMessageRule(new oq6());
            messageManager.addResponsedMessageRule(new k85());
            messageManager.addResponsedMessageRule(new l85());
            messageManager.addResponsedMessageRule(new bo8());
        }
    }

    private void initInterruptRule() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            MessageManager.getInstance().addMessageRule(new oa(this, 0) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitMessageManagerTask this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.repackage.qa
                public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, httpMessage, httpMessageTask)) == null) {
                        if (TbadkCoreApplication.getInst().checkInterrupt() && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(httpMessage.getCmd()))) {
                            return null;
                        }
                        return httpMessage;
                    }
                    return (HttpMessage) invokeLL.objValue;
                }
            });
            MessageManager.getInstance().addMessageRule(new va(this, 0) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitMessageManagerTask this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.repackage.qa
                public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketMessage, socketMessageTask)) == null) {
                        if (TbadkCoreApplication.getInst().checkInterrupt() && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(socketMessage.getCmd()))) {
                            return null;
                        }
                        return socketMessage;
                    }
                    return (SocketMessage) invokeLL.objValue;
                }
            });
        }
    }

    private void registeDealIntentTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            v85 v85Var = new v85(2012000, new CustomMessageTask.CustomRunnable<Intent>(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitMessageManagerTask this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<Intent> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        UtilHelper.commenDealIntent(x8.g().b() == null ? TbadkCoreApplication.getInst().getApp() : x8.g().b(), customMessage.getData());
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            v85Var.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(v85Var);
        }
    }

    private void registeYYNotificationTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            v85 v85Var = new v85(2012100, new CustomMessageTask.CustomRunnable<no4>(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitMessageManagerTask this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<no4> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        UtilHelper.showYYNotification(AppRuntime.getAppContext(), customMessage.getData(), 13);
                        return null;
                    }
                    return (CustomResponsedMessage) invokeL.objValue;
                }
            });
            v85Var.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(v85Var);
        }
    }

    private void registerGoActionTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2002001, new CustomMessageTask.CustomRunnable<IntentConfig>(this) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InitMessageManagerTask this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<IntentConfig> run(CustomMessage<IntentConfig> customMessage) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, customMessage)) == null) {
                        if (customMessage == null || customMessage.getData() == null) {
                            return null;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921565, Boolean.TRUE));
                        IntentConfig data = customMessage.getData();
                        if (data.asynStart()) {
                            return new CustomResponsedMessage<>(customMessage.getCmd(), data);
                        }
                        Class<?> intentClass = TbadkCoreApplication.getInst().getIntentClass(data.getClass());
                        if (TbadkCoreApplication.getInst().getIntentClass(AlbumActivityConfig.class) == null) {
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

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            MessageManager.getInstance().registerListener(this.mDescriptionTableFixListener);
            try {
                ec5.b().e();
                if (TbadkCoreApplication.getInst().isMainProcess(false, AppRuntime.getAppContext())) {
                    gk4.d().f();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
            MessageManager.getInstance().registerListener(this.mMemListener);
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            initInterruptRule();
            FullBrowseHelper.registerBrowseModeRule();
            addLoginRules();
            registerGoActionTask();
            registeYYNotificationTask();
            UpgradePopWindowHelper.registerTask();
            registeDealIntentTask();
            registerListener();
        }
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "AppCreate_InitMessageManager" : (String) invokeV.objValue;
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
