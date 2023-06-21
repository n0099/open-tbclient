package com.baidu.searchbox.task.sync.appcreate;

import android.content.Context;
import android.content.Intent;
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
import com.baidu.tieba.ax4;
import com.baidu.tieba.bb;
import com.baidu.tieba.cx5;
import com.baidu.tieba.ft5;
import com.baidu.tieba.g9;
import com.baidu.tieba.gt5;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.tieba.ht5;
import com.baidu.tieba.ib;
import com.baidu.tieba.it5;
import com.baidu.tieba.j35;
import com.baidu.tieba.jt5;
import com.baidu.tieba.kt5;
import com.baidu.tieba.pu7;
import com.baidu.tieba.qt5;
import com.baidu.tieba.qu7;
import com.baidu.tieba.u0a;
import com.baidu.tieba.u7a;
/* loaded from: classes4.dex */
public class InitMessageManagerTask extends LaunchTask {
    public CustomMessageListener mDescriptionTableFixListener = new CustomMessageListener(2921510) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u0a)) {
                u0a u0aVar = (u0a) customResponsedMessage.getData();
                DescriptionTableInfo.setModuleSet(u0aVar.a);
                DescriptionTableInfo.setDescriptionTable(u0aVar.b);
            }
        }
    };
    public CustomMessageListener mMemListener = new CustomMessageListener(2001194) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage == null || (num = (Integer) customResponsedMessage.getData()) == null) {
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

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "Ignore_InitMessageManager";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return -1;
    }

    private void initInterruptRule() {
        MessageManager.getInstance().addMessageRule(new bb(0) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.db
            public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
                if (TbadkCoreApplication.getInst().checkInterrupt() && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(httpMessage.getCmd()))) {
                    return null;
                }
                return httpMessage;
            }
        });
        MessageManager.getInstance().addMessageRule(new ib(0) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.db
            public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
                if (TbadkCoreApplication.getInst().checkInterrupt() && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(socketMessage.getCmd()))) {
                    return null;
                }
                return socketMessage;
            }
        });
    }

    private void registeDealIntentTask() {
        qt5 qt5Var = new qt5(2012000, new CustomMessageTask.CustomRunnable<Intent>() { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Intent> customMessage) {
                Context b;
                if (g9.f().b() == null) {
                    b = TbadkCoreApplication.getInst().getApp();
                } else {
                    b = g9.f().b();
                }
                UtilHelper.commenDealIntent(b, customMessage.getData());
                return null;
            }
        });
        qt5Var.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(qt5Var);
    }

    private void registeYYNotificationTask() {
        qt5 qt5Var = new qt5(2012100, new CustomMessageTask.CustomRunnable<j35>() { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<j35> customMessage) {
                UtilHelper.showYYNotification(AppRuntime.getAppContext(), customMessage.getData(), 13);
                return null;
            }
        });
        qt5Var.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(qt5Var);
    }

    private void registerGoActionTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002001, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<IntentConfig> run(CustomMessage<IntentConfig> customMessage) {
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
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        initInterruptRule();
        FullBrowseHelper.registerBrowseModeRule();
        addLoginRules();
        registerGoActionTask();
        registeYYNotificationTask();
        UpgradePopWindowHelper.registerTask();
        registeDealIntentTask();
        registerListener();
    }

    private void addLoginRules() {
        ReloginManager.g().k();
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.addMessageRule(new kt5(0));
        messageManager.addMessageRule(new ht5(0));
        messageManager.addResponsedMessageRule(new jt5(0));
        messageManager.addRemovedMessageRule(new it5(0));
        messageManager.addResponsedMessageRule(new qu7());
        messageManager.addResponsedMessageRule(new pu7());
        messageManager.addResponsedMessageRule(new ft5());
        messageManager.addResponsedMessageRule(new gt5());
        messageManager.addResponsedMessageRule(new u7a());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.mDescriptionTableFixListener);
        try {
            cx5.b().e();
            if (TbadkCoreApplication.getInst().isMainProcess(false, AppRuntime.getAppContext())) {
                ax4.d().f();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        MessageManager.getInstance().registerListener(this.mMemListener);
    }
}
