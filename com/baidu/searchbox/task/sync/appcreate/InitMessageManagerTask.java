package com.baidu.searchbox.task.sync.appcreate;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.base.BdActivityStack;
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
import com.baidu.tieba.au5;
import com.baidu.tieba.c35;
import com.baidu.tieba.cb;
import com.baidu.tieba.dw4;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.tieba.kqa;
import com.baidu.tieba.mx5;
import com.baidu.tieba.nia;
import com.baidu.tieba.pt5;
import com.baidu.tieba.qt5;
import com.baidu.tieba.rt5;
import com.baidu.tieba.st5;
import com.baidu.tieba.tt5;
import com.baidu.tieba.ut5;
import com.baidu.tieba.wa;
import com.baidu.tieba.yz7;
import com.baidu.tieba.zz7;
/* loaded from: classes4.dex */
public class InitMessageManagerTask extends LaunchTask {
    public CustomMessageListener mDescriptionTableFixListener = new CustomMessageListener(2921510) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof nia)) {
                nia niaVar = (nia) customResponsedMessage.getData();
                DescriptionTableInfo.setModuleSet(niaVar.a);
                DescriptionTableInfo.setDescriptionTable(niaVar.b);
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
        MessageManager.getInstance().addMessageRule(new wa(0) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.controller.MessageRule
            public HttpMessage process(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
                if (TbadkCoreApplication.getInst().checkInterrupt() && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(httpMessage.getCmd()))) {
                    return null;
                }
                return httpMessage;
            }
        });
        MessageManager.getInstance().addMessageRule(new cb(0) { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.controller.MessageRule
            public SocketMessage process(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
                if (TbadkCoreApplication.getInst().checkInterrupt() && TbConfig.DownFlowCmd.sInterruptCMDs.contains(Integer.valueOf(socketMessage.getCmd()))) {
                    return null;
                }
                return socketMessage;
            }
        });
    }

    private void registeDealIntentTask() {
        au5 au5Var = new au5(2012000, new CustomMessageTask.CustomRunnable<Intent>() { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Intent> customMessage) {
                Context currentActivity;
                if (BdActivityStack.getInst().currentActivity() == null) {
                    currentActivity = TbadkCoreApplication.getInst().getApp();
                } else {
                    currentActivity = BdActivityStack.getInst().currentActivity();
                }
                UtilHelper.commenDealIntent(currentActivity, customMessage.getData());
                return null;
            }
        });
        au5Var.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(au5Var);
    }

    private void registeYYNotificationTask() {
        au5 au5Var = new au5(2012100, new CustomMessageTask.CustomRunnable<c35>() { // from class: com.baidu.searchbox.task.sync.appcreate.InitMessageManagerTask.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<c35> customMessage) {
                UtilHelper.showYYNotification(AppRuntime.getAppContext(), customMessage.getData(), 13);
                return null;
            }
        });
        au5Var.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(au5Var);
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
                if (data.getActivityClass() != null) {
                    intentClass = data.getActivityClass();
                }
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
        messageManager.addMessageRule(new ut5(0));
        messageManager.addMessageRule(new rt5(0));
        messageManager.addResponsedMessageRule(new tt5(0));
        messageManager.addRemovedMessageRule(new st5(0));
        messageManager.addResponsedMessageRule(new zz7());
        messageManager.addResponsedMessageRule(new yz7());
        messageManager.addResponsedMessageRule(new pt5());
        messageManager.addResponsedMessageRule(new qt5());
        messageManager.addResponsedMessageRule(new kqa());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.mDescriptionTableFixListener);
        try {
            mx5.b().e();
            if (TbadkCoreApplication.getInst().isMainProcess(false, AppRuntime.getAppContext())) {
                dw4.d().f();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        MessageManager.getInstance().registerListener(this.mMemListener);
    }
}
